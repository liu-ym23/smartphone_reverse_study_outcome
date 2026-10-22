package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface TargetConfig<T> extends ReadableConfig {
    public static final Config.Option<Class<?>> OPTION_TARGET_CLASS = null;
    public static final Config.Option<String> OPTION_TARGET_NAME = null;

    /* JADX INFO: renamed from: androidx.camera.core.internal.TargetConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static Class $default$getTargetClass(TargetConfig r1) {
            return (Class) r1.retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
        }

        public static String $default$getTargetName(TargetConfig r1) {
            return (String) r1.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
        }

        public static Class $default$getTargetClass(TargetConfig r1, Class r2) {
            return (Class) r1.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, r2);
        }

        public static String $default$getTargetName(TargetConfig r1, String r2) {
            return (String) r1.retrieveOption(TargetConfig.OPTION_TARGET_NAME, r2);
        }
    }

    public interface Builder<T, B> {
        B setTargetClass(Class<T> r1);

        B setTargetName(String r1);
    }

    Class<T> getTargetClass();

    Class<T> getTargetClass(Class<T> r1);

    String getTargetName();

    String getTargetName(String r1);

    static {
        OPTION_TARGET_NAME = Config.Option.create("camerax.core.target.name", String.class);
        OPTION_TARGET_CLASS = Config.Option.create("camerax.core.target.class", Class.class);
    }
}
