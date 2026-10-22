package androidx.camera.core.impl;

import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface ReadableConfig extends Config {

    /* JADX INFO: renamed from: androidx.camera.core.impl.ReadableConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Set $default$listOptions(ReadableConfig r0) {
            return r0.getConfig().listOptions();
        }

        public static boolean $default$containsOption(ReadableConfig r0, Config.Option r1) {
            return r0.getConfig().containsOption(r1);
        }

        public static Config.OptionPriority $default$getOptionPriority(ReadableConfig r0, Config.Option r1) {
            return r0.getConfig().getOptionPriority(r1);
        }

        public static Set $default$getPriorities(ReadableConfig r0, Config.Option r1) {
            return r0.getConfig().getPriorities(r1);
        }

        public static Object $default$retrieveOption(ReadableConfig r0, Config.Option r1) {
            return r0.getConfig().retrieveOption(r1);
        }

        public static void $default$findOptions(ReadableConfig r0, String r1, Config.OptionMatcher r2) {
            r0.getConfig().findOptions(r1, r2);
        }

        public static Object $default$retrieveOption(ReadableConfig r0, Config.Option r1, Object r2) {
            return r0.getConfig().retrieveOption(r1, r2);
        }

        public static Object $default$retrieveOptionWithPriority(ReadableConfig r0, Config.Option r1, Config.OptionPriority r2) {
            return r0.getConfig().retrieveOptionWithPriority(r1, r2);
        }
    }

    @Override // androidx.camera.core.impl.Config
    boolean containsOption(Config.Option<?> r1);

    @Override // androidx.camera.core.impl.Config
    void findOptions(String r1, Config.OptionMatcher r2);

    Config getConfig();

    @Override // androidx.camera.core.impl.Config
    Config.OptionPriority getOptionPriority(Config.Option<?> r1);

    @Override // androidx.camera.core.impl.Config
    Set<Config.OptionPriority> getPriorities(Config.Option<?> r1);

    @Override // androidx.camera.core.impl.Config
    Set<Config.Option<?>> listOptions();

    @Override // androidx.camera.core.impl.Config
    <ValueT> ValueT retrieveOption(Config.Option<ValueT> r1);

    @Override // androidx.camera.core.impl.Config
    <ValueT> ValueT retrieveOption(Config.Option<ValueT> r1, ValueT r2);

    @Override // androidx.camera.core.impl.Config
    <ValueT> ValueT retrieveOptionWithPriority(Config.Option<ValueT> r1, Config.OptionPriority r2);
}
