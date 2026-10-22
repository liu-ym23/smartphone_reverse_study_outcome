package com.bytedance.salamander.anniex;

/* JADX INFO: loaded from: classes20.dex */
public final class p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f268295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f268296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f268297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f268298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f268299e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f268300a = null;

        static {
            int[] r100 = new int[SLContainerTiming.values().length];
            r100[SLContainerTiming.OpenTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[SLContainerTiming.ContainerInitStart.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[SLContainerTiming.ContainerInitEnd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[SLContainerTiming.PrepareTemplateStart.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[SLContainerTiming.PrepareTemplateEnd.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f268300a = r100;
        }
    }

    public p7() {
    }
}
