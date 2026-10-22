package com.larksuite.framework.utils.file.direct;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f285987a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285988a = null;

        static {
            int[] r100 = new int[DirectFileAccess.PathType.values().length];
            r100[DirectFileAccess.PathType.ROOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[DirectFileAccess.PathType.CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[DirectFileAccess.PathType.CODE_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[DirectFileAccess.PathType.FILES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f285988a = r100;
        }
    }

    static {
    }
}
