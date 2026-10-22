package com.ss.android.lark.officesdk.integrator.im;

import android.content.Context;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.preview.actions.ActionImpl$onActionTriggered$1;
import com.ss.android.lark.export.entity.preview.Parameters;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f433270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InitChatPreviewTask f433271b;

    public a(Context r100, InitChatPreviewTask r101) {
        this.f433270a = r100;
        this.f433271b = r101;
    }

    public final void a(Context r100, String r101, String r102) {
        if (r100 != null) goto L5;
        r100 = this.f433270a;
    L5:
        if (r100 != null) goto L8;
        Log.e("[URLPreview]InitChatPreviewTask", "context is null, open url failed");
        return;
    L8:
        if (r101 != null) goto L11;
        Log.e("[URLPreview]InitChatPreviewTask", "url is null. previewId: " + r102);
        return;
    L11:
        int r103 = FlowChatModule.f422022d;
        FlowChatModule.a.a().a().getBrowserDependency().openUrl(r100, r101);
    }

    public final void b(Parameters r100, String r101, ActionImpl$onActionTriggered$1 r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        IIMApi r103 = InitChatPreviewTask.j(this.f433271b);
        if (r103 == null) goto L5;
        r103.putReviewAction(r100, r101, r102);
        return;
    L5:
        this.f433271b.getClass();
        CoreThreadPool.getDefault().getUIExecutor().execute(new i(r102));
    }

    public final void c(String r110, String r111, String r112, String r113, String r114, String r115, String r116, Map<String, ? extends Object> r117) {
        Intrinsics.checkNotNullParameter(r112, "clickParam");
        Intrinsics.checkNotNullParameter(r117, "messageParams");
        IIMApi r100 = InitChatPreviewTask.j(this.f433271b);
        if (r100 == null) goto L6;
        r100.sendUrlClick(r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    }
}
