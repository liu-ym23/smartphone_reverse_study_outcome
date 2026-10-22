package com.facebook.imagepipeline.systrace;

/* JADX INFO: loaded from: classes3.dex */
public class FrescoSystrace {
    public static final ArgsBuilder NO_OP_ARGS_BUILDER = null;
    private static volatile Systrace sInstance;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.systrace.FrescoSystrace$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface ArgsBuilder {
        ArgsBuilder arg(String r100, double r101);

        ArgsBuilder arg(String r100, int r101);

        ArgsBuilder arg(String r100, long r101);

        ArgsBuilder arg(String r100, Object r101);

        void flush();
    }

    public static final class NoOpArgsBuilder implements ArgsBuilder {
        private NoOpArgsBuilder() {
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String r100, double r101) {
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String r100, int r101) {
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String r100, long r101) {
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String r100, Object r101) {
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public void flush() {
        }

        public /* synthetic */ NoOpArgsBuilder(AnonymousClass1 r100) {
            this();
        }
    }

    public interface Systrace {
        void beginSection(String r100);

        ArgsBuilder beginSectionWithArgs(String r100);

        void endSection();

        boolean isTracing();
    }

    private FrescoSystrace() {
    }

    static {
        NO_OP_ARGS_BUILDER = new NoOpArgsBuilder(null);
        sInstance = null;
    }

    private static Systrace getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(FrescoSystrace.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DefaultFrescoSystrace();     // Catch: Throwable -> L11
    L9:
        monitor-exit(FrescoSystrace.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static void endSection() {
        getInstance().endSection();
    }

    public static boolean isTracing() {
        return getInstance().isTracing();
    }

    public static void beginSection(String r100) {
        getInstance().beginSection(r100);
    }

    public static ArgsBuilder beginSectionWithArgs(String r100) {
        return getInstance().beginSectionWithArgs(r100);
    }

    public static void provide(Systrace r100) {
        sInstance = r100;
    }
}
