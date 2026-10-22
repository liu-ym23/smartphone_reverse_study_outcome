package com.bytedance.ee.bear.bitable.baseadd.pluginhost;

import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bitable.noweb.pluginhost.NoWebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/pluginhost/BaseAddPluginHost;", "Lcom/bytedance/ee/bear/bitable/noweb/pluginhost/NoWebPluginHost;", "<init>", "()V", "docViewModel", "Lcom/bytedance/ee/bear/document/DocViewModel;", "editPanelsManager", "Lcom/bytedance/ee/bear/document/toolbar/editpanels/EditPanelsManager;", "onPrepareCreate", "", "activity", "Landroidx/fragment/app/FragmentActivity;", WidgetCostModule.TYPE_ON_CREATE, "delegate", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost$Delegate;", "setDocViewModel", "getDocViewModel", "getEditPanelsManager", "getDocumentMetadata", "Lcom/bytedance/ee/bear/document/DocumentMetadata;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseAddPluginHost extends NoWebPluginHost {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DocViewModel f207000b;

    public BaseAddPluginHost() {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final void onCreate(PluginHost.a r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        EditPanelsManager r101 = (EditPanelsManager) ViewModelProviders.of(r100.getActivity()).get(EditPanelsManager.class);
        super.onCreate(r100);
    }
}
