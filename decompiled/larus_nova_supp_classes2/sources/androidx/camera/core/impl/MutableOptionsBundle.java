package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class MutableOptionsBundle extends OptionsBundle implements MutableConfig {
    private static final Config.OptionPriority DEFAULT_PRIORITY = null;

    static {
        DEFAULT_PRIORITY = Config.OptionPriority.OPTIONAL;
    }

    public static MutableOptionsBundle create() {
        return new MutableOptionsBundle(new TreeMap(OptionsBundle.ID_COMPARE));
    }

    private MutableOptionsBundle(TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> r1) {
        super(r1);
    }

    public static MutableOptionsBundle from(Config r7) {
        TreeMap r0 = new TreeMap(OptionsBundle.ID_COMPARE);
        Iterator<Config.Option<?>> r1 = r7.listOptions().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Config.Option<?> r2 = r1.next();
        Set<Config.OptionPriority> r3 = r7.getPriorities(r2);
        ArrayMap r4 = new ArrayMap();
        Iterator<Config.OptionPriority> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Config.OptionPriority r6 = r5.next();
        r4.put(r6, r7.retrieveOptionWithPriority(r2, r6));
        goto L7
    L9:
        r0.put(r2, r4);
        goto L4
    L11:
        return new MutableOptionsBundle(r0);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    public <ValueT> ValueT removeOption(Config.Option<ValueT> r2) {
        return (ValueT) this.mOptions.remove(r2);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    public <ValueT> void insertOption(Config.Option<ValueT> r2, ValueT r3) {
        insertOption(r2, DEFAULT_PRIORITY, r3);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    public <ValueT> void insertOption(Config.Option<ValueT> r6, Config.OptionPriority r7, ValueT r8) {
        Map<Config.OptionPriority, Object> r0 = this.mOptions.get(r6);
        if (r0 != null) goto L6;
        ArrayMap r1 = new ArrayMap();
        this.mOptions.put(r6, r1);
        r1.put(r7, r8);
        return;
    L6:
        Config.OptionPriority r2 = (Config.OptionPriority) Collections.min(r0.keySet());
        if (Objects.equals(r0.get(r2), r8) == false) goto L9;
    L13:
        r0.put(r7, r8);
        return;
    L9:
        if (Config.CC.hasConflict(r2, r7) == false) goto L13;
        throw new IllegalArgumentException("Option values conflicts: " + r6.getId() + ", existing value (" + r2 + ")=" + r0.get(r2) + ", conflicting (" + r7 + ")=" + r8);
    }
}
