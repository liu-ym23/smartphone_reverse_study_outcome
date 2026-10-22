package com.larus.dora.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&JT\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u000f2$\u0010\u0010\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0007H&J4\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u000fH&J4\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H&¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/api/IDoraGuideService;", "", "init", "", "isDoraGuideDegrade", "", "launchGuideSession", "", "page", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "guideFilterList", "", "lifeCycleScope", "Lkotlinx/coroutines/CoroutineScope;", "guideListener", "Lkotlin/Function4;", "endGuideSession", "sessionId", "showGuide", "guideId", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "anchorView", "Landroid/view/View;", "dismissGuide", "requestGuide", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraGuideService {
    void a(int r100);

    boolean b();

    void d(int r100, int r101, Fragment r102, View r103, LifecycleCoroutineScope r104);

    int e(String r100, Context r101, List r102, LifecycleCoroutineScope r103, Function4 r104);

    void init();
}
