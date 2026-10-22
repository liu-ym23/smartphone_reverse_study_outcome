package com.larus.audio.asr;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.ss.android.ttvecamera.TECameraSettings;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class k0 {
    public static final hw5.a a(h68.a.C6106a r100, FlowAsrErrorType r101) {
        String r102 = r100.f483924b;
        String r103 = null;
        if (r102 != null) goto L5;
    L9:
        int r104 = r100.f483923a;
        if (r104 == (-1004)) goto L17;
        switch(r104) {
            case -2004: goto L16;
            case -2003: goto L15;
            case -2002: goto L14;
            case -2001: goto L13;
            default: goto L12;
        };
    L12:
        r102 = "ASR audio data source failed, code=" + r100.f483923a;
    L18:
        int r105 = r100.f483923a;
        if (r105 == (-1004)) goto L26;
        switch(r105) {
            case -2004: goto L25;
            case -2003: goto L24;
            case -2002: goto L23;
            case -2001: goto L22;
            default: goto L27;
        };
    L22:
        r101 = FlowAsrErrorType.SOURCE_START_FAILED;
        goto L27
    L23:
        r101 = FlowAsrErrorType.SOURCE_STOP_FAILED;
        goto L27
    L24:
        r101 = FlowAsrErrorType.SOURCE_RELEASE_FAILED;
        goto L27
    L25:
        r101 = FlowAsrErrorType.SOURCE_START_FAILED;
    L27:
        Throwable r106 = r100.f483925c;
        if (r106 == null) goto L36;
        String r107 = r106.toString();
        if (r107 == null) goto L36;
        if ((!StringsKt.isBlank(r107)) == false) goto L34;
        r103 = r107;
    L34:
        if (r103 == null) goto L36;
    L38:
        return new hw5.a(r101, r102, r105, r103);
    L36:
        r103 = TECameraSettings.PictureCallback.ERROR_CODE_SPLIT_REGEX + r100.f483923a + ",errorMessage=" + r102;
        goto L38
    L26:
        r101 = FlowAsrErrorType.CLIENT_ERROR;
        goto L27
    L13:
        r102 = "ASR audio recorder captured only silence";
        goto L18
    L14:
        r102 = "ASR audio recorder stop failed";
        goto L18
    L15:
        r102 = "ASR audio recorder release failed";
        goto L18
    L16:
        r102 = "ASR audio recorder start failed";
        goto L18
    L17:
        r102 = "ASR audio data source read failed";
        goto L18
    L5:
        if ((!StringsKt.isBlank(r102)) == true) goto L8;
        r102 = null;
    L8:
        if (r102 != null) goto L18;
        goto L9
    }
}
