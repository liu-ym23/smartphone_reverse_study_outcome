package com.obric.framework.inputmethod.api;

import android.app.ITopActivityAssistDataReceiver;
import android.app.assist.AssistStructure;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"com/obric/framework/inputmethod/api/ObricInjectTextResponseCallback$stub$2$1", "Landroid/app/ITopActivityAssistDataReceiver$Stub;", "onResultData", "", "requestId", "", OnekeyLoginConstants.CU_KEY_RESULT_DATA, "Landroid/os/Bundle;", "onScreenshotData", "screenshotData", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInjectTextResponseCallback$stub$2$1 extends ITopActivityAssistDataReceiver.Stub {
    final /* synthetic */ b this$0;

    @Override // android.app.ITopActivityAssistDataReceiver
    public void onScreenshotData(int r100, Bundle r101) {
    }

    public ObricInjectTextResponseCallback$stub$2$1(b r100) {
    }

    @Override // android.app.ITopActivityAssistDataReceiver
    public void onResultData(int r100, Bundle r101) {
        c.f396886a.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        Object r103 = r101.get("obric.inject_text.type");     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r104) == false) goto L15;
        r104 = null;
    L15:
        if ((r104 instanceof Integer) == false) goto L17;
        Integer r105 = (Integer) r104;
    L18:
        boolean r106 = true;
        if (r105 == null) goto L29;
        int r107 = r105.intValue();
        if (r107 == 0) goto L28;
        if (r107 != 1) goto L24;
        ObricInjectTextResponseType r108 = ObricInjectTextResponseType.ABNORMAL;
    L30:
        c.f396886a.getClass();
        Intrinsics.checkNotNullParameter(r108, "type");
        if (r108 == ObricInjectTextResponseType.NORMAL) goto L35;
        if (r108 == ObricInjectTextResponseType.ABNORMAL) goto L35;
        throw null;
    L35:
        if (r101 != null) goto L37;
    L39:
        r106 = false;
    L40:
        if (r106 == false) goto L62;
    L50:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Object r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L53:
        if (Result.m9455isFailureimpl(r110) == false) goto L55;
        r110 = null;
    L55:
        AssistStructure r111 = (AssistStructure) r110;
        throw null;
    L42:
        if (Build.VERSION.SDK_INT < 33) goto L44;
        AssistStructure r112 = (AssistStructure) r101.getParcelable("obric.inject_text.view_tree", AssistStructure.class);     // Catch: Throwable -> L50
    L48:
        r110 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L50
        goto L53
    L44:
        Parcelable r113 = r101.getParcelable("obric.inject_text.view_tree");     // Catch: Throwable -> L50
        if ((r113 instanceof AssistStructure) == false) goto L47;
        r112 = (AssistStructure) r113;     // Catch: Throwable -> L50
        goto L48
    L47:
        r112 = null;
        goto L48
    L62:
        throw null;
    L37:
        if (r101.containsKey("obric.inject_text.view_tree") != true) goto L39;
    L24:
        if (r107 == 2) goto L26;
        r108 = ObricInjectTextResponseType.UNKNOWN;
        goto L30
    L26:
        r108 = ObricInjectTextResponseType.SECURE;
        goto L30
    L28:
        r108 = ObricInjectTextResponseType.NORMAL;
        goto L30
    L29:
        r108 = ObricInjectTextResponseType.UNKNOWN;
        goto L30
    L17:
        r105 = null;
        goto L18
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
