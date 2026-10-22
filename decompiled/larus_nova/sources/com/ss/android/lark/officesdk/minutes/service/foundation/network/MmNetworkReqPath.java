package com.ss.android.lark.officesdk.minutes.service.foundation.network;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes37.dex */
public final class MmNetworkReqPath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f433890a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f433891a = null;

        static {
            int[] r100 = new int[MmRecordingSource.values().length];
            r100[MmRecordingSource.DOUBAO_PERSONAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r100[MmRecordingSource.DOUBAO_ENTERPRISE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r100[MmRecordingSource.DOUBAO_EARBUDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[MmRecordingSource.DOUBAO_GLASSES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r100[MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r100[MmRecordingSource.FEISHU_DOUBAO.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r100[MmRecordingSource.OBRIC_RECORDER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[MmRecordingSource.FEISHU.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[MmRecordingSource.FEISHU_HARDWARE_RECORDER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[MmRecordingSource.FEISHU_HARDWARE_D1204.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r100[MmRecordingSource.FEISHU_HARDWARE_D1204_CASE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[MmRecordingSource.FEISHU_STANDALONE_AI_INTERPRETATION.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            f433891a = r100;
        }
    }

    static {
        f433890a = LazyKt.lazy(MmNetworkReqPath$legacyBaseApi$2.INSTANCE);
    }

    public static String a(MmRecordingSource r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L5:
        switch(r101) {
            case -1: goto L11;
            case 0: goto L7;
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        return "/minutes/api/";
    L9:
        return "/minutes/doubao/api/";
    L7:
        throw new NoWhenBranchMatchedException();
    L11:
        return (String) f433890a.getValue();
    L4:
        r101 = a.f433891a[r100.ordinal()];
        goto L5
    }

    public static String b(MmRecordingSource r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L6:
        if (r101 != 1) goto L8;
    L21:
        return "/memory/api/doubao/recording/";
    L8:
        if (r101 == 2) goto L21;
        if (r101 != 5) goto L12;
        return "/memory/api/doubao/simultaneous/";
    L12:
        if (r101 == 6) goto L21;
        if (r101 != 8) goto L16;
        return "/memory/api/recording/";
    L16:
        if (r101 != 12) goto L23;
        return "/memory/api/simultaneous/";
    L23:
        return a(r100);
    L4:
        r101 = a.f433891a[r100.ordinal()];
        goto L6
    }

    public static String c(MmRecordingSource r100, boolean r101) {
        if (r101 == false) goto L5;
        return b(r100) + "status";
    L5:
        return a(r100) + "audio/status";
    }
}
