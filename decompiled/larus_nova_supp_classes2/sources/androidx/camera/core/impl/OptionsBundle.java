package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class OptionsBundle implements Config {
    private static final OptionsBundle EMPTY_BUNDLE = null;
    protected static final Comparator<Config.Option<?>> ID_COMPARE = null;
    protected final TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> mOptions;

    public static /* synthetic */ int a(Config.Option r0, Config.Option r1) {
        return lambda$static$0(r0, r1);
    }

    static {
        Comparator<Config.Option<?>> r0 = new t();
        ID_COMPARE = r0;
        EMPTY_BUNDLE = new OptionsBundle(new TreeMap(r0));
    }

    @Override // androidx.camera.core.impl.Config
    public Set<Config.Option<?>> listOptions() {
        return Collections.unmodifiableSet(this.mOptions.keySet());
    }

    public static OptionsBundle emptyBundle() {
        return EMPTY_BUNDLE;
    }

    public OptionsBundle(TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> r1) {
        this.mOptions = r1;
    }

    public static OptionsBundle from(Config r7) {
        if (OptionsBundle.class.equals(r7.getClass()) == true) goto L5;
        TreeMap r0 = new TreeMap(ID_COMPARE);
        Iterator<Config.Option<?>> r1 = r7.listOptions().iterator();
    L8:
        if (r1.hasNext() == false) goto L15;
        Config.Option<?> r2 = r1.next();
        Set<Config.OptionPriority> r3 = r7.getPriorities(r2);
        ArrayMap r4 = new ArrayMap();
        Iterator<Config.OptionPriority> r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        Config.OptionPriority r6 = r5.next();
        r4.put(r6, r7.retrieveOptionWithPriority(r2, r6));
        goto L11
    L13:
        r0.put(r2, r4);
        goto L8
    L15:
        return new OptionsBundle(r0);
    L5:
        return (OptionsBundle) r7;
    }

    @Override // androidx.camera.core.impl.Config
    public boolean containsOption(Config.Option<?> r2) {
        return this.mOptions.containsKey(r2);
    }

    @Override // androidx.camera.core.impl.Config
    public Config.OptionPriority getOptionPriority(Config.Option<?> r4) {
        Map<Config.OptionPriority, Object> r0 = this.mOptions.get(r4);
        if (r0 == null) goto L7;
        return (Config.OptionPriority) Collections.min(r0.keySet());
    L7:
        throw new IllegalArgumentException("Option does not exist: " + r4);
    }

    @Override // androidx.camera.core.impl.Config
    public Set<Config.OptionPriority> getPriorities(Config.Option<?> r2) {
        Map<Config.OptionPriority, Object> r3 = this.mOptions.get(r2);
        if (r3 != null) goto L7;
        return Collections.emptySet();
    L7:
        return Collections.unmodifiableSet(r3.keySet());
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT retrieveOption(Config.Option<ValueT> r4) {
        Map<Config.OptionPriority, Object> r0 = this.mOptions.get(r4);
        if (r0 == null) goto L7;
        return (ValueT) r0.get((Config.OptionPriority) Collections.min(r0.keySet()));
    L7:
        throw new IllegalArgumentException("Option does not exist: " + r4);
    }

    private static /* synthetic */ int lambda$static$0(Config.Option r0, Config.Option r1) {
        return r0.getId().compareTo(r1.getId());
    }

    @Override // androidx.camera.core.impl.Config
    public void findOptions(String r4, Config.OptionMatcher r5) {
        Config.Option<?> r0 = Config.Option.create(r4, Void.class);
        Iterator<Map.Entry<Config.Option<?>, Map<Config.OptionPriority, Object>>> r1 = this.mOptions.tailMap(r0).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<Config.Option<?>, Map<Config.OptionPriority, Object>> r2 = r1.next();
        if (r2.getKey().getId().startsWith(r4) == false) goto L15;
        if (r5.onOptionMatched(r2.getKey()) == true) goto L4;
        return;
    L15:
        return;
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT retrieveOption(Config.Option<ValueT> r1, ValueT r2) {
        return (ValueT) retrieveOption(r1);
    L4:
        return r2;
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT retrieveOptionWithPriority(Config.Option<ValueT> r4, Config.OptionPriority r5) {
        Map<Config.OptionPriority, Object> r0 = this.mOptions.get(r4);
        if (r0 == null) goto L11;
        if (r0.containsKey(r5) == false) goto L9;
        return (ValueT) r0.get(r5);
    L9:
        throw new IllegalArgumentException("Option does not exist: " + r4 + " with priority=" + r5);
    L11:
        throw new IllegalArgumentException("Option does not exist: " + r4);
    }
}
