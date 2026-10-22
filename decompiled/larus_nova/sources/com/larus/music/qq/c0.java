package com.larus.music.qq;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f359520a = null;

        static {
            int[] r100 = new int[QQMusicBizErrorCode.values().length];
            r100[QQMusicBizErrorCode.RESULT_CODE_OK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[QQMusicBizErrorCode.SYSTEM_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[QQMusicBizErrorCode.AUTH_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[QQMusicBizErrorCode.NOT_LOGIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[QQMusicBizErrorCode.NOT_INSTALLED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[QQMusicBizErrorCode.NOT_CONNECT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f359520a = r100;
        }
    }

    public static final int a(QQMusicBizErrorCode r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(a.f359520a[r100.ordinal()]) {
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L7;
        };
    L5:
        return -5;
    L6:
        return -4;
    L7:
        return -1;
    L8:
        return 0;
    L10:
        return -2;
    }
}
