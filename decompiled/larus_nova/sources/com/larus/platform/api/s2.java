package com.larus.platform.api;

/* JADX INFO: loaded from: classes31.dex */
public final class s2 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f365269a = null;

        static {
            int[] r100 = new int[CachedVideosPreloadFrom.values().length];
            r100[CachedVideosPreloadFrom.OUTER_FALLBACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[CachedVideosPreloadFrom.CMD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[CachedVideosPreloadFrom.BIND_PULL_API.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[CachedVideosPreloadFrom.REFRESH_VIDEO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[CachedVideosPreloadFrom.UN_CONSUMED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[CachedVideosPreloadFrom.UNLIMITED_FLOW.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f365269a = r100;
        }
    }

    public static final PrefetchVideoProcessStage a(CachedVideosPreloadFrom r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L5:
        switch(r101) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        return PrefetchVideoProcessStage.EXCEPTION;
    L15:
        return PrefetchVideoProcessStage.UNLIMITED_FLOW_PROCESS;
    L16:
        return PrefetchVideoProcessStage.UN_CONSUMED_PROCESS;
    L17:
        return PrefetchVideoProcessStage.REFRESH_PROCESS;
    L18:
        return PrefetchVideoProcessStage.BIND_PROCESS;
    L19:
        return PrefetchVideoProcessStage.CMD_PROCESS;
    L13:
        return PrefetchVideoProcessStage.CMD_PROCESS;
    L4:
        r101 = a.f365269a[r100.ordinal()];
        goto L5
    }
}
