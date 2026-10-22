package com.ss.android.lark.diskmanage.storage;

import java.lang.reflect.InvocationHandler;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f420485a = 0;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.diskmanage.storage.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4955a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f420486a = null;

            static {
                int[] r100 = new int[Storage.Type.values().length];
                r100[Storage.Type.INNER_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[Storage.Type.CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[Storage.Type.INNER_FILES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[Storage.Type.FILES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[Storage.Type.STORAGE_LARK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f420486a = r100;
            }
        }
    }

    static {
    }
}
