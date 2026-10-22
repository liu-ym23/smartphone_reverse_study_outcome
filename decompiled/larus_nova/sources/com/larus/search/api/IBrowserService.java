package com.larus.search.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.larus.search.api.event.HybridEventParams;
import com.larus.search.impl.WebFragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\"\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u000bH&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H&J$\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014H&J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\n\u0010 \u001a\u0004\u0018\u00010\u0014H&¨\u0006!"}, d2 = {"Lcom/larus/search/api/IBrowserService;", "", MiPushClient.COMMAND_REGISTER, "", "searchModel", "Lcom/larus/search/api/model/SearchModel;", "getSearchModel", "navigateWeb", "view", "Landroid/view/View;", "args", "Landroid/os/Bundle;", "hybridEventParams", "Lcom/larus/search/api/event/HybridEventParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "navigateHalfWeb", "navigateNineInchWeb", "navigateFeedback", "source", "", "extras", "extra", "queryUrl", "text", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isWebActivity", "", "activity", "Landroid/app/Activity;", "createWebFragment", "Lcom/larus/platform/model/webview/AbsWebFragment;", "webClassName", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBrowserService {

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ void a(IBrowserService r100, View r101, String r102) {
            r100.k(r101, r102, new Bundle());
        }
    }

    void a(AppletAppActivity r100, String r101);

    void b(ts9.a r100);

    WebFragment c();

    void d(View r100, Bundle r101);

    void e(Context r100, Bundle r101, HybridEventParams r102);

    ts9.a f();

    boolean g(Activity r100);

    String h();

    void i(View r100, Bundle r101, HybridEventParams r102);

    void j(Context r100, String r101);

    void k(View r100, String r101, Bundle r102);

    Object o(String r100, Continuation<? super String> r101);
}
