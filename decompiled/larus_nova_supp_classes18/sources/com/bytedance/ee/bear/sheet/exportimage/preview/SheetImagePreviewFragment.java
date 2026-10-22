package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.externalshare.ShareScene;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001:B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u001e\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H\u0002J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\b\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020&2\u0006\u0010/\u001a\u000200H\u0002J\b\u00107\u001a\u00020&H\u0002J\b\u00108\u001a\u00020&H\u0016J\b\u00109\u001a\u00020\u001bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/preview/SheetImagePreviewFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "Lcom/bytedance/ee/bear/share/export/ISharePanel;", "<init>", "()V", "panelSession", "", "getPanelSession", "()Ljava/lang/String;", "viewModel", "Lcom/bytedance/ee/bear/sheet/exportimage/preview/ImagePreviewViewModel;", "statusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "externalShareView", "Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "loadingView", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "loadingViewContainer", "Landroid/widget/FrameLayout;", "shareTextContainer", "Landroid/view/View;", "shareTextView", "Landroid/widget/TextView;", "shareItemDisabled", "", "isShareText", "shareText", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initViews", "root", "registerObservers", "showShareTextPanel", "hideShareTextPanel", "updateExternalConfig", "isThirdPartyShareType", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "getShareItems", "", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", "buildShareItemModelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "onShareToExternalApp", "setPageBackgroundBlack", "onDestroyView", "onBackPressed", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetImagePreviewFragment extends BaseFragment implements l, com.bytedance.ee.bear.share.export.i {
    public final String e;
    public ImagePreviewViewModel f;
    public xu5.b.a g;
    public ExternalShareView h;
    public BaseTitleBar i;
    public BearLottieView j;
    public FrameLayout k;
    public View l;
    public TextView m;
    public boolean n;
    public boolean o;
    public String p;

    public static final class a {
    }

    static {
    }

    public final km5.a U90() {
        if (this.o == false) goto L5;
        ShareScene r1 = ShareScene.SHARE_TEXT;
    L7:
        return new km5.a(0, 3, null, false, false, null, null, null, false, false, false, false, null, null, false, false, r1, 49152);
    L5:
        r1 = ShareScene.EXPORT_IMAGE;
        goto L7
    }

    public final boolean onBackPressed() {
        ImagePreviewViewModel r0 = this.f;
        if (r0 == null) goto L7;
        r0.onClose();
        return true;
    L7:
        return true;
    }

    public SheetImagePreviewFragment() {
        this.e = String.valueOf(hashCode());
        this.p = "";
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        ExternalShareView r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.NOT_SHOW, U90());
    L10:
        xu5.b.a r2 = this.g;
        if (r2 == null) goto L13;
        r2.resetState();
    L13:
        BearLottieView r3 = this.j;
        if (r3 == null) goto L16;
        r3.cancelAnimation();
    L16:
        ImagePreviewViewModel r4 = this.f;
        if (r4 == null) goto L22;
        MutableLiveData<Boolean> r5 = r4.getCalSharePanelHeight();
        if (r5 == null) goto L23;
        r5.setValue(Boolean.FALSE);
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.share.export.i
    public final String getPanelSession() {
        return this.e;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        BaseTitleBar r4 = (BaseTitleBar) r2.findViewById(2131371953);
        this.i = r4;
        if (r4 == null) goto L5;
        r4.setLeftImageResource(2131254124);
    L5:
        BaseTitleBar r5 = this.i;
        if (r5 == null) goto L8;
        r5.setActionIconTint(2131102418);
    L8:
        BaseTitleBar r6 = this.i;
        if (r6 == null) goto L11;
        r6.setLeftClickListener(new com.bytedance.ee.bear.sheet.exportimage.preview.a(this));
    L11:
        qm5.b.b("ccm_space_docs_topbar_view", new HashMap());
        this.k = (FrameLayout) r2.findViewById(2131371951);
        this.j = r2.findViewById(2131371950);
        this.h = r2.findViewById(2131371952);
        this.l = r2.findViewById(2131386142);
        this.m = (TextView) r2.findViewById(2131386141);
        ImagePreviewViewModel r7 = this.f;
        if (r7 == null) goto L16;
        MutableLiveData<Boolean> r8 = r7.getShowShare();
        if (r8 == null) goto L16;
        r8.observe(this, new b(this));
    L16:
        ImagePreviewViewModel r9 = this.f;
        if (r9 == null) goto L21;
        MutableLiveData<Boolean> r10 = r9.getShowLoading();
        if (r10 == null) goto L21;
        r10.observe(this, new c(this));
    L21:
        ImagePreviewViewModel r11 = this.f;
        if (r11 == null) goto L26;
        MutableLiveData<PreviewTitleModel> r12 = r11.getTitleData();
        if (r12 == null) goto L26;
        r12.observe(this, new d(this));
    L26:
        ImagePreviewViewModel r13 = this.f;
        if (r13 == null) goto L31;
        MutableLiveData<Boolean> r14 = r13.getDisableShareItem();
        if (r14 == null) goto L31;
        r14.observe(this, new e(this));
    L31:
        ImagePreviewViewModel r15 = this.f;
        if (r15 == null) goto L36;
        MutableLiveData<ShareOperationTypeModel> r16 = r15.getOperationType();
        if (r16 == null) goto L36;
        r16.observe(this, new g(this));
    L36:
        ImagePreviewViewModel r17 = this.f;
        if (r17 == null) goto L42;
        MutableLiveData<Boolean> r18 = r17.getCalSharePanelHeight();
        if (r18 == null) goto L43;
        r18.observe(this, new i(this));
        return;
    L43:
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        this.f = (ImagePreviewViewModel) q.a(this, ImagePreviewViewModel.class);
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L8;
        xu5.b.a r7 = xu5.b.b(r6, null);
        this.g = r7;
        r7.saveState();
        xu5.b.a r8 = this.g;
        if (r8 == null) goto L8;
        r8.d(2131100548, true);
    L8:
        return r3.inflate(2131564547, r4, false);
    }
}
