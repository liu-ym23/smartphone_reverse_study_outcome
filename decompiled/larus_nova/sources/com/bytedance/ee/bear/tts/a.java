package com.bytedance.ee.bear.tts;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    static {
    }

    public static void a(TtsResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        tt5.a.h("TtsErrorHandler", "toast, result: " + r100);
        if (r100.a() == false) goto L5;
        return;
    L5:
        TtsResult.b r101 = r100.f239451a;
        if (Intrinsics.areEqual(r101, TtsResult.f239450e.f239451a) == false) goto L9;
        Toast.showFailureText(LarkContext.getApplication(), R.string.LarkCCM_Docs_ReadAloud_LoadAudioFail_Toast);
        return;
    L9:
        if (r101 != TtsResult.PlayerCode.UNKNOWN) goto L12;
        Toast.showFailureText(LarkContext.getApplication(), R.string.LarkCCM_Docs_ReadAloud_LoadAudioFail_Toast);
        return;
    L12:
        if (r101 != TtsResult.ModelCode.M3U8_LINK_INVALID) goto L15;
        Toast.showFailureText(LarkContext.getApplication(), R.string.LarkCCM_Docs_ReadAloud_LoadAudioFail_Toast);
        return;
    L15:
        if (r101 != TtsResult.ModelCode.M3U8_SERVER_LIMIT) goto L18;
        Toast.showFailureText(LarkContext.getApplication(), R.string.LarkCCM_Docs_ReadAloud_HighTrafficLater_Toast);
        return;
    L18:
        if (r101 != TtsResult.ModelCode.TONE_LIST_INVALID) goto L21;
        Toast.showFailureText(LarkContext.getApplication(), R.string.LarkCCM_Docs_ReadAloud_LoadVoiceFail_Toast);
        return;
    L21:
        if (r101 != TtsResult.AccessCode.NETWORK_ERROR) goto L24;
        Toast.showFailureText(LarkContext.getApplication(), R.string.Doc_Doc_NetException);
        return;
    L24:
        if (r101 != TtsResult.AccessCode.FILE_NOT_EXISTS) goto L27;
        Toast.showFailureText(LarkContext.getApplication(), R.string.LarkCCM_Docs_ReadAloud_FailNoExist_Toast);
        return;
    L27:
        if (r101 != TtsResult.AccessCode.NO_VIEW_PERMISSION) goto L29;
    L36:
        Toast.showFailureText(LarkContext.getApplication(), R.string.LarkCCM_Docs_ReadAloud_NoViewPerm_Toast);
        return;
    L29:
        if (r101 == TtsResult.AccessCode.NO_PREVIEW_PERMISSION) goto L36;
        if (r101 == TtsResult.AccessCode.NO_PERCEIVE_PERMISSION) goto L36;
        if (r101 != TtsResult.AccessCode.NO_PERMISSION_DEFAULT) goto L45;
        Toast.showFailureText(LarkContext.getApplication(), R.string.LarkCCM_Docs_ReadAloud_FailNoAccess_Toast);
        return;
    }
}
