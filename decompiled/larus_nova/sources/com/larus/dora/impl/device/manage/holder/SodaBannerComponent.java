package com.larus.dora.impl.device.manage.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementSodaBannerBinding;
import com.larus.dora.impl.device.manage.LifecycleUIComponent;
import com.larus.dora.impl.device.manage.b1;
import com.larus.dora.impl.device.manage.p0;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\rH\u0016J\u0006\u0010!\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020\rJ\b\u0010#\u001a\u00020\rH\u0002J\b\u0010$\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/SodaBannerComponent;", "Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementSodaBannerBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementSodaBannerBinding;", "currentBannerType", "", "onBannerClosed", "Lkotlin/Function1;", "", "getOnBannerClosed", "()Lkotlin/jvm/functions/Function1;", "setOnBannerClosed", "(Lkotlin/jvm/functions/Function1;)V", "onCreateAndSetupView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onBind", "data", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "requestUpdateTopMarginByPreviousItem", "updateTopMarginByPreviousItem", "updateTopMargin", "useCompactTopMargin", "", WidgetCostModule.TYPE_ON_START, "showBanner", "hideBanner", "closeBanner", "openSodaVipApplet", LiveCommonConstants.REASON_ON_DEDTROY, "onStop", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SodaBannerComponent extends LifecycleUIComponent {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f333824g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusItemDoraGDeviceManagementSodaBannerBinding f333825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f333826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Integer, Unit> f333827f;

    public static final class a {
    }

    static {
    }

    public final LarusItemDoraGDeviceManagementSodaBannerBinding h() {
        LarusItemDoraGDeviceManagementSodaBannerBinding r100 = this.f333825d;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public SodaBannerComponent() {
        this.f333826e = 1;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onDestroy() {
        super.onDestroy();
        g49.d.d("SodaBannerComponent", LiveCommonConstants.REASON_ON_DEDTROY);
        this.f333825d = null;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onStart() {
        super.onStart();
        LarusItemDoraGDeviceManagementSodaBannerBinding r100 = this.f333825d;
        if (r100 == null) goto L8;
        ItemGroup r101 = r100.f333405a;
        if (r101 == null) goto L9;
        r101.post(new m0(this));
        return;
    L9:
        return;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onStop() {
        super.onStop();
        g49.d.d("SodaBannerComponent", "onStop");
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void b(p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if ((r100 instanceof b1) == false) goto L5;
        b1 r101 = (b1) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        g49.d.d("SodaBannerComponent", "onBind: item=" + r101);
        if (r101.f333703e == false) goto L15;
        e1.x(h().f333405a);
        LarusItemDoraGDeviceManagementSodaBannerBinding r102 = this.f333825d;
        if (r102 == null) goto L17;
        ItemGroup r103 = r102.f333405a;
        if (r103 == null) goto L18;
        r103.post(new m0(this));
        return;
    L18:
        return;
    L17:
        return;
    L15:
        e1.o(h().f333405a);
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final View c(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        g49.d.d("SodaBannerComponent", "onCreateAndSetupView");
        View r102 = r100.inflate(R.layout.larus_item_dora_g_device_management_soda_banner, r101, false);
        int r103 = R.id.soda_banner_content;
        LinearLayoutCompat r104 = (LinearLayoutCompat) ViewBindings.findChildViewById(r102, R.id.soda_banner_content);
        if (r104 == null) goto L19;
        ItemGroup r105 = (ItemGroup) r102;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r102, R.id.soda_vip_close);
        if (r106 != null) goto L7;
        r103 = R.id.soda_vip_close;
        goto L19
    L7:
        if (((ImageView) ViewBindings.findChildViewById(r102, R.id.soda_vip_icon)) != null) goto L9;
        r103 = R.id.soda_vip_icon;
        goto L19
    L9:
        if (((AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.soda_vip_subtitle)) != null) goto L11;
        r103 = R.id.soda_vip_subtitle;
        goto L19
    L11:
        if (((DoraTextView) ViewBindings.findChildViewById(r102, R.id.soda_vip_title)) == null) goto L14;
        this.f333825d = new LarusItemDoraGDeviceManagementSodaBannerBinding(r105, r104, r106);
        e1.d(h().f333406b, new k0(this));
        h().f333407c.setOnClickListener(new l0(this));
        return h().f333405a;
    L14:
        r103 = R.id.soda_vip_title;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
