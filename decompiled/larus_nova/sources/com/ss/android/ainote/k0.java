package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteWriteError;

/* JADX INFO: loaded from: classes34.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f406835a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406836a = null;

        static {
            int[] r100 = new int[AINoteWriteError.values().length];
            r100[AINoteWriteError.DELETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[AINoteWriteError.HAS_USE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[AINoteWriteError.VERSION_LOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[AINoteWriteError.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f406836a = r100;
        }
    }

    static {
    }
}
