package com.bytedance.applet.aibridge.luna;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tx9.v1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J.\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¨\u0006\u0019"}, d2 = {"Lcom/bytedance/applet/aibridge/luna/JumpToLunaMethod;", "Lcom/bytedance/applet/aibridge/luna/AbsJumpToLunaMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/luna/AbsJumpToLunaMethodIDL$JumpToLunaMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/luna/AbsJumpToLunaMethodIDL$JumpToLunaMethodResultModel;", "handleVipScene", "jumpLuna", "callbackFailure", "scene", "", "method", "errorMsg", "startActivityByUrl", "", "url", "Landroid/net/Uri;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JumpToLunaMethod extends AbsJumpToLunaMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public JumpToLunaMethod() {
    }

    public static boolean c(Uri r2, h r3, String r4) {
        Intent r0 = new Intent("android.intent.action.VIEW", r2);
        Activity r5 = AppHost.a.a().getCurrentActivity();
        if (r5 != null) goto L6;
        b("member", r4, "current_activity_not_found", r3);
        return false;
    L6:
        r5.startActivity(r0);
        return true;
    }

    public final void handle(d r8, ParamModel r9, h r10) {
        AbsJumpToLunaMethodIDL.a r11 = (AbsJumpToLunaMethodIDL.a) r9;
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (Intrinsics.areEqual(r11.getScene(), "member") == false) goto L18;
        AppHost.Companion r0 = AppHost.a;
        FragmentActivity r3 = r0.a().getCurrentActivity();
        if ((r3 instanceof FragmentActivity) == false) goto L7;
        FragmentActivity r4 = r3;
    L8:
        Resources r1 = r0.getApplication().getResources();
        if (r4 == null) goto L17;
        if (r1 == null) goto L17;
        FragmentManager r2 = r4.getSupportFragmentManager();
        CommonDialog.a r5 = new CommonDialog.a();
        r5.i(r1.getString(2131907975));
        CommonDialog.a.f(r5, new com.bytedance.applet.aibridge.luna.a(this, r8, r11, r10), r1.getString(2131907973), false, 12);
        CommonDialog.a.e(r5, new b(r10), r1.getString(2131907972), 4);
        CommonDialog r12 = r5.d(ContextCompat.getColor(r4, 2131103203));
        LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, null, r13);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r12, r13) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L16:
        r12.show(r2, null);
        return;
    L25:
        return;
    L17:
        b("member", CommentPublishScene.UNKNOWN, "context_error", r10);
        return;
    L7:
        r4 = null;
        goto L8
    L18:
        b(CommentPublishScene.UNKNOWN, CommentPublishScene.UNKNOWN, "wrong_scene:" + r11.getScene(), r10);
    }

    public static void b(String r3, String r4, String r5, h r6) {
        FLogger.a.i("JumpToLunaMethod", r3 + " try " + r4 + " fail, errorMsg: " + r5);
        v1.a(r3, r4, 0, r5, 48);
        h.a.a(r6, r5, null, null, 14);
    }
}
