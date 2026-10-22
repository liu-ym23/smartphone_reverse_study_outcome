package com.larus.bmhome.view.actionbar.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.view.actionbar.custom.router.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import ss8.e;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H&¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/view/actionbar/api/IActionBarProvider;", "", "provideSegments", "", "Lcom/larus/bmhome/view/actionbar/api/IActionBarSegment;", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "provideSchemaRouterProcessors", "Lcom/larus/bmhome/view/actionbar/custom/router/IOpenBySchemaRouterProcessor;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IActionBarProvider {
    List<b> a();

    List<e> b(t1a.b r100, Context r101, Fragment r102);
}
