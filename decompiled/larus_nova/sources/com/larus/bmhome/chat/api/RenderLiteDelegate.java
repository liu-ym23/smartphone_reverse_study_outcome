package com.larus.bmhome.chat.api;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/api/RenderLiteDelegate;", "Lcom/larus/bmhome/chat/api/IRenderLiteService;", "<init>", "()V", "impl", "createLiteView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "templateUrl", "", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/larus/bmhome/chat/bean/IRenderLiteLifeCycle;", "initData", "updateLiteViewData", "", "liteView", "renderData", "destroyLiteView", SendEventContainerMethodParamModel.EventKinds.openPage, "uri", "Landroid/net/Uri;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderLiteDelegate implements IRenderLiteService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RenderLiteDelegate f297174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IRenderLiteService f297175b = null;

    private RenderLiteDelegate() {
    }

    static {
        f297174a = new RenderLiteDelegate();
        f297175b = (IRenderLiteService) ServiceManager.get().getService(IRenderLiteService.class);
    }

    @Override // com.larus.bmhome.chat.api.IRenderLiteService
    public final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "liteView");
        IRenderLiteService r101 = f297175b;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IRenderLiteService
    public final void a(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "liteView");
        Intrinsics.checkNotNullParameter(r101, "renderData");
        IRenderLiteService r102 = f297175b;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IRenderLiteService
    public final void b(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        IRenderLiteService r102 = f297175b;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IRenderLiteService
    public final View c(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "templateUrl");
        IRenderLiteService r103 = f297175b;
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.c(r100, r101, r102);
    }
}
