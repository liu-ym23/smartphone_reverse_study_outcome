package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.externalshare.ShareScene;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001:B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u001e\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H\u0002J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\b\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020&2\u0006\u0010/\u001a\u000200H\u0002J\b\u00107\u001a\u00020&H\u0002J\b\u00108\u001a\u00020&H\u0016J\b\u00109\u001a\u00020\u001bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/preview/SheetImagePreviewFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "Lcom/bytedance/ee/bear/share/export/ISharePanel;", "<init>", "()V", "panelSession", "", "getPanelSession", "()Ljava/lang/String;", "viewModel", "Lcom/bytedance/ee/bear/sheet/exportimage/preview/ImagePreviewViewModel;", "statusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "externalShareView", "Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "loadingView", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "loadingViewContainer", "Landroid/widget/FrameLayout;", "shareTextContainer", "Landroid/view/View;", "shareTextView", "Landroid/widget/TextView;", "shareItemDisabled", "", "isShareText", "shareText", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initViews", RootDescription.ROOT_ELEMENT, "registerObservers", "showShareTextPanel", "hideShareTextPanel", "updateExternalConfig", "isThirdPartyShareType", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "getShareItems", "", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", "buildShareItemModelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "onShareToExternalApp", "setPageBackgroundBlack", "onDestroyView", "onBackPressed", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetImagePreviewFragment extends BaseFragment implements l, com.bytedance.ee.bear.share.export.i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f237533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImagePreviewViewModel f237534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public xu5.b.a f237535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ExternalShareView f237536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BaseTitleBar f237537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BearLottieView f237538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f237539k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f237540l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f237541m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f237542n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f237543o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f237544p;

    public static final class a {
    }

    static {
    }

    public final km5.a U90() {
        if (this.f237543o == false) goto L5;
        ShareScene r100 = ShareScene.SHARE_TEXT;
    L7:
        return new km5.a(0, 3, null, false, false, null, null, null, false, false, false, false, null, null, false, false, r100, 49152);
    L5:
        r100 = ShareScene.EXPORT_IMAGE;
        goto L7
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        ImagePreviewViewModel r100 = this.f237534f;
        if (r100 == null) goto L7;
        r100.onClose();
        return true;
    L7:
        return true;
    }

    public SheetImagePreviewFragment() {
        this.f237533e = String.valueOf(hashCode());
        this.f237544p = "";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ExternalShareView r100 = this.f237536h;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.NOT_SHOW, U90());
    L10:
        xu5.b.a r102 = this.f237535g;
        if (r102 == null) goto L13;
        r102.resetState();
    L13:
        BearLottieView r103 = this.f237538j;
        if (r103 == null) goto L16;
        r103.cancelAnimation();
    L16:
        ImagePreviewViewModel r104 = this.f237534f;
        if (r104 == null) goto L22;
        MutableLiveData<Boolean> r105 = r104.getCalSharePanelHeight();
        if (r105 == null) goto L23;
        r105.setValue(Boolean.FALSE);
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.share.export.i
    public final String getPanelSession() {
        return this.f237533e;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        BaseTitleBar r102 = (BaseTitleBar) r100.findViewById(R.id.export_image_preview_titleBar);
        this.f237537i = r102;
        if (r102 == null) goto L5;
        r102.setLeftImageResource(R.drawable.ud_icon_close_small_outlined);
    L5:
        BaseTitleBar r103 = this.f237537i;
        if (r103 == null) goto L8;
        r103.setActionIconTint(R.color.icon_n1);
    L8:
        BaseTitleBar r104 = this.f237537i;
        if (r104 == null) goto L11;
        r104.setLeftClickListener(new com.bytedance.ee.bear.sheet.exportimage.preview.a(this));
    L11:
        qm5.b.b("ccm_space_docs_topbar_view", new HashMap());
        this.f237539k = (FrameLayout) r100.findViewById(R.id.export_image_preview_loading_container);
        this.f237538j = (BearLottieView) r100.findViewById(R.id.export_image_preview_loading);
        this.f237536h = (ExternalShareView) r100.findViewById(R.id.export_image_preview_sharePanel);
        this.f237540l = r100.findViewById(R.id.share_text_container);
        this.f237541m = (TextView) r100.findViewById(R.id.share_text);
        ImagePreviewViewModel r105 = this.f237534f;
        if (r105 == null) goto L16;
        MutableLiveData<Boolean> r106 = r105.getShowShare();
        if (r106 == null) goto L16;
        r106.observe(this, new b(this));
    L16:
        ImagePreviewViewModel r107 = this.f237534f;
        if (r107 == null) goto L21;
        MutableLiveData<Boolean> r108 = r107.getShowLoading();
        if (r108 == null) goto L21;
        r108.observe(this, new c(this));
    L21:
        ImagePreviewViewModel r109 = this.f237534f;
        if (r109 == null) goto L26;
        MutableLiveData<PreviewTitleModel> r110 = r109.getTitleData();
        if (r110 == null) goto L26;
        r110.observe(this, new d(this));
    L26:
        ImagePreviewViewModel r111 = this.f237534f;
        if (r111 == null) goto L31;
        MutableLiveData<Boolean> r112 = r111.getDisableShareItem();
        if (r112 == null) goto L31;
        r112.observe(this, new e(this));
    L31:
        ImagePreviewViewModel r113 = this.f237534f;
        if (r113 == null) goto L36;
        MutableLiveData<ShareOperationTypeModel> r114 = r113.getOperationType();
        if (r114 == null) goto L36;
        r114.observe(this, new g(this));
    L36:
        ImagePreviewViewModel r115 = this.f237534f;
        if (r115 == null) goto L42;
        MutableLiveData<Boolean> r116 = r115.getCalSharePanelHeight();
        if (r116 == null) goto L43;
        r116.observe(this, new i(this));
        return;
    L43:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        this.f237534f = (ImagePreviewViewModel) q.a(this, ImagePreviewViewModel.class);
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L8;
        xu5.b.a r104 = xu5.b.b(r103, null);
        this.f237535g = r104;
        r104.saveState();
        xu5.b.a r105 = this.f237535g;
        if (r105 == null) goto L8;
        r105.d(R.color.bg_body, true);
    L8:
        return r100.inflate(R.layout.sheet_export_image_preview_fragment, r101, false);
    }
}
