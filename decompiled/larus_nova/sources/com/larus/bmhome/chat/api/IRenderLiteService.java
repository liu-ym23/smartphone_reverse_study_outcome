package com.larus.bmhome.chat.api;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H&J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/api/IRenderLiteService;", "", "createLiteView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "templateUrl", "", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/larus/bmhome/chat/bean/IRenderLiteLifeCycle;", "initData", "updateLiteViewData", "", "liteView", "renderData", "destroyLiteView", SendEventContainerMethodParamModel.EventKinds.openPage, "uri", "Landroid/net/Uri;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IRenderLiteService {
    void a(View r100, String r101);

    void b(Context r100, Uri r101);

    View c(Context r100, String r101, String r102);

    void d(View r100);
}
