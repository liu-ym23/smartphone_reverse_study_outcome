package com.larksuite.framework.utils.file.direct;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f285985a = 0;

    /* JADX INFO: renamed from: com.larksuite.framework.utils.file.direct.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C3932a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285986a = null;

        static {
            int[] r100 = new int[DirectFileAccess.PathType.values().length];
            r100[DirectFileAccess.PathType.CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DirectFileAccess.PathType.FILES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DirectFileAccess.PathType.ROOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f285986a = r100;
        }
    }

    static {
    }
}
