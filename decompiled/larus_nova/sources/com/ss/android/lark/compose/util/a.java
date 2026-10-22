package com.ss.android.lark.compose.util;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.rustclient.api.RustClientException;
import com.larus.nova.R;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public static final void a(Context r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        if ((r101 instanceof RustClientException) == false) goto L5;
        RustClientException r102 = (RustClientException) r101;
    L6:
        if (r102 == null) goto L11;
        LarkError r103 = r102.getRustError();
        if (r103 == null) goto L11;
        String r104 = r103.display_message;
        if (r104 == null) goto L11;
    L13:
        if ((!StringsKt.isBlank(r104)) == false) goto L15;
        FlowToast.d(r100, r104);
        return;
    L15:
        FlowToast.c(r100, R.string.Settings_ChangeName_GeneralError);
        return;
    L11:
        r104 = "";
        goto L13
    L5:
        r102 = null;
        goto L6
    }
}
