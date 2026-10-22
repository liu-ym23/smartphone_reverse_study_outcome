package com.ss.android.eventbus.collector;

/* JADX INFO: loaded from: classes34.dex */
public class CollectorProvider {
    private static final ICollector COMPILER_COLLECTOR = null;
    private static final ICollector DEFAULT_COLLECTOR = null;
    private static final ICollector REFLECTION_COLLECTOR = null;

    public CollectorProvider() {
    }

    static {
        REFLECTION_COLLECTOR = new CollectorReflectionImpl();
        CollectorCompileImpl r100 = new CollectorCompileImpl();
        COMPILER_COLLECTOR = r100;
        DEFAULT_COLLECTOR = r100;
    }

    public static ICollector getCompilerCollector() {
        return COMPILER_COLLECTOR;
    }

    public static ICollector getDefaultCollector() {
        return DEFAULT_COLLECTOR;
    }

    public static ICollector getReflectionCollector() {
        return REFLECTION_COLLECTOR;
    }
}
