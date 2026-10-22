package com.larus.dora.impl.device.manage.holder;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.impl.device.manage.LifecycleUIComponent;
import com.larus.dora.impl.device.manage.p0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/MediaAlbumUIComponent;", "Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "<init>", "()V", "helper", "Lcom/larus/avlink/api/IMediaAlbumViewHelper;", "onCreateAndSetupView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", WidgetCostModule.TYPE_ON_START, "", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "onBind", "data", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaAlbumUIComponent extends LifecycleUIComponent {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w88.u f333800d;

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void b(p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onDestroy() {
        super.onDestroy();
        w88.u r100 = this.f333800d;
        if (r100 == null) goto L5;
        r100.onDestroy();
    L5:
        this.f333800d = null;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onStart() {
        super.onStart();
        w88.u r100 = this.f333800d;
        if (r100 == null) goto L6;
        r100.onStart();
        return;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onStop() {
        super.onStop();
        w88.u r100 = this.f333800d;
        if (r100 == null) goto L6;
        r100.onStop();
        return;
    }

    public MediaAlbumUIComponent() {
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final View c(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        IDoraAVLinkService r102 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r102 == null) goto L5;
        w88.u r103 = r102.l1(r101.getContext(), this);
    L6:
        this.f333800d = r103;
        if (r103 == null) goto L10;
        View r104 = r103.getView();
        if (r104 == null) goto L10;
    L11:
        Resources r105 = r101.getContext().getResources();
        float r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density;
        int r107 = (int) (16 * r106);
        ViewGroup.MarginLayoutParams r108 = new ViewGroup.MarginLayoutParams(-1, -2);
        r108.setMargins(r107, (int) (12 * r106), r107, 0);
        r104.setLayoutParams(r108);
        return r104;
    L10:
        r104 = new View(r101.getContext());
        goto L11
    L5:
        r103 = null;
        goto L6
    }
}
