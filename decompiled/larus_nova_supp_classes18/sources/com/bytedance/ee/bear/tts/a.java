package com.bytedance.ee.bear.tts;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    static {
    }

    public static void a(TtsResult r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        tt5.a.h("TtsErrorHandler", "toast, result: " + r2);
        if (r2.a() == false) goto L5;
        return;
    L5:
        TtsResult.b r3 = r2.a;
        if (Intrinsics.areEqual(r3, TtsResult.e.a) == false) goto L9;
        Toast.showFailureText(LarkContext.getApplication(), 2131889239);
        return;
    L9:
        if (r3 != TtsResult.PlayerCode.UNKNOWN) goto L12;
        Toast.showFailureText(LarkContext.getApplication(), 2131889239);
        return;
    L12:
        if (r3 != TtsResult.ModelCode.M3U8_LINK_INVALID) goto L15;
        Toast.showFailureText(LarkContext.getApplication(), 2131889239);
        return;
    L15:
        if (r3 != TtsResult.ModelCode.M3U8_SERVER_LIMIT) goto L18;
        Toast.showFailureText(LarkContext.getApplication(), 2131889237);
        return;
    L18:
        if (r3 != TtsResult.ModelCode.TONE_LIST_INVALID) goto L21;
        Toast.showFailureText(LarkContext.getApplication(), 2131889240);
        return;
    L21:
        if (r3 != TtsResult.AccessCode.NETWORK_ERROR) goto L24;
        Toast.showFailureText(LarkContext.getApplication(), 2131887674);
        return;
    L24:
        if (r3 != TtsResult.AccessCode.FILE_NOT_EXISTS) goto L27;
        Toast.showFailureText(LarkContext.getApplication(), 2131889234);
        return;
    L27:
        if (r3 != TtsResult.AccessCode.NO_VIEW_PERMISSION) goto L29;
    L36:
        Toast.showFailureText(LarkContext.getApplication(), 2131889242);
        return;
    L29:
        if (r3 == TtsResult.AccessCode.NO_PREVIEW_PERMISSION) goto L36;
        if (r3 == TtsResult.AccessCode.NO_PERCEIVE_PERMISSION) goto L36;
        if (r3 != TtsResult.AccessCode.NO_PERMISSION_DEFAULT) goto L45;
        Toast.showFailureText(LarkContext.getApplication(), 2131889233);
        return;
    }
}
