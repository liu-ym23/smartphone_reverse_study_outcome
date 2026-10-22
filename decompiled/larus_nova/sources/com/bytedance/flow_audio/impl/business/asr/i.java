package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.tts.error.FlowAudioAssistantError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f243985a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f243986b = null;

        static {
            int[] r100 = new int[FlowAsrErrorType.values().length];
            r100[FlowAsrErrorType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L52:
            r100[FlowAsrErrorType.UNSUPPORTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L62:
            r100[FlowAsrErrorType.CLIENT_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L40:
            r100[FlowAsrErrorType.SOURCE_PREPARE_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L42:
            r100[FlowAsrErrorType.SOURCE_START_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            r100[FlowAsrErrorType.SOURCE_STOP_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L58:
            r100[FlowAsrErrorType.SOURCE_RELEASE_FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L44:
            r100[FlowAsrErrorType.NETWORK_ERROR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L54:
            r100[FlowAsrErrorType.SERVER_ERROR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L56:
            r100[FlowAsrErrorType.TIMEOUT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L36:
            r100[FlowAsrErrorType.EMPTY_RESULT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L16:
            f243985a = r100;
            int[] r101 = new int[FlowAudioAssistantError.ErrorType.values().length];
            r101[FlowAudioAssistantError.ErrorType.ConnectFailed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L60:
            r101[FlowAudioAssistantError.ErrorType.TaskFailed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L38:
            r101[FlowAudioAssistantError.ErrorType.SessionFailed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L20:
            f243986b = r101;
        }
    }

    public static final int a(FlowAsrErrorType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(a.f243985a[r100.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            default: goto L5;
        };
    L6:
        return 501;
    L7:
        return 505;
    L8:
        return 503;
    L9:
        return 504;
    L10:
        return -2003;
    L11:
        return -2002;
    L12:
        return -2004;
    L13:
        return 951;
    L14:
        return 500;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static hw5.a b(Throwable r100, FlowAsrErrorType r101, Integer r102, int r103) {
        String r104 = null;
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "code");
        String r105 = r100.toString();
        String r106 = r100.getMessage();
        if (r106 != null) goto L8;
    L11:
        r104 = r101 + " failed: " + r105;
    L12:
        if (r102 == null) goto L14;
        int r107 = r102.intValue();
    L16:
        return new hw5.a(r101, r104, r107, r105);
    L14:
        r107 = a(r101);
        goto L16
    L8:
        if ((!StringsKt.isBlank(r106)) == false) goto L10;
        r104 = r106;
    L10:
        if (r104 != null) goto L12;
        goto L11
    }
}
