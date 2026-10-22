package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0016J\u0012\u0010>\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020*H\u0016J\b\u0010B\u001a\u00020*H\u0016J\b\u0010C\u001a\u00020*H\u0002J&\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010J\u001a\u00020*H\u0016J\b\u0010K\u001a\u00020*H\u0002J\u001a\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020E2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010N\u001a\u00020*H\u0016J\u0010\u0010O\u001a\u00020*2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020*H\u0002J\b\u0010S\u001a\u00020*H\u0002J\b\u0010T\u001a\u00020*H\u0002J\b\u0010U\u001a\u00020*H\u0002J\u0012\u0010V\u001a\u00020*2\b\u0010W\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010X\u001a\u00020*2\b\u0010Y\u001a\u0004\u0018\u00010=H\u0016J\n\u0010Z\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010[\u001a\u00020*2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010$8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010,\u001a\u00020-X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00102\u001a\u0002038DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b4\u00105R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "<init>", "()V", "permissionTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getPermissionTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setPermissionTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "noDataEmptyStateFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getNoDataEmptyStateFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setNoDataEmptyStateFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "permissionTypeFromXml", "Landroid/widget/TextView;", "getPermissionTypeFromXml", "()Landroid/widget/TextView;", "setPermissionTypeFromXml", "(Landroid/widget/TextView;)V", "sendRequestFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getSendRequestFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setSendRequestFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "permissionTypeChooseFromXml", "Landroid/widget/LinearLayout;", "getPermissionTypeChooseFromXml", "()Landroid/widget/LinearLayout;", "setPermissionTypeChooseFromXml", "(Landroid/widget/LinearLayout;)V", "editOptionalFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getEditOptionalFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setEditOptionalFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "clearFromXmlViewCache", "", "onDestroyView", "params", "Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "getParams", "()Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "setParams", "(Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;)V", "viewModel", "Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "customBackDrawable", "Landroid/graphics/drawable/Drawable;", "customBackListener", "Landroid/view/View$OnClickListener;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "parseArgs", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "bindView", "handleSpanClick", "onViewCreated", "view", LiveCommonConstants.REASON_ON_DEDTROY, "handleLoading", "loading", "", "bindListener", "showActionSheet", "saveSoftInputMode", "revertSoftInputMode", "setBackIcon", "drawable", "setBackListener", "listener", "getTitleBar", "setViewVisibleListener", "visibleListener", "Lcom/bytedance/ee/permission/view/IViewVisibleListener;", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PermApplyFragment extends BaseFragment implements au5.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f232956q = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f232957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SpaceEmptyState f232958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f232959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDButton f232960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f232961i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SpaceEditText f232962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public NoPermission f232963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f232964l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompositeDisposable f232965m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f232966n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnClickListener f232967o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public au5.b f232968p;

    public static final class a {
    }

    public static final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PermApplyFragment f232969a;

        public b(PermApplyFragment r100) {
            this.f232969a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            if (TextUtils.isEmpty(this.f232969a.W90().getOwnerId()) == true) goto L6;
            ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).e(this.f232969a.W90().getOwnerId(), "");
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setUnderlineText(false);
        }
    }

    static {
    }

    @Override // au5.a
    public final /* synthetic */ View NW() {
        return null;
    }

    public final SpaceEmptyState V90() {
        View r100 = this.f232958f;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.no_data_empty_state);
    L8:
        this.f232958f = (SpaceEmptyState) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SpaceEmptyState) r100;
    }

    public final NoPermission W90() {
        NoPermission r100 = this.f232963k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    }

    public final BaseTitleBar X90() {
        View r100 = this.f232957e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.permission_title_bar);
    L8:
        this.f232957e = (BaseTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (BaseTitleBar) r100;
    }

    public final UDButton Y90() {
        View r100 = this.f232960h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.send_request);
    L8:
        this.f232960h = (UDButton) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (UDButton) r100;
    }

    public final PermApplyViewModel Z90() {
        return (PermApplyViewModel) this.f232964l.getValue();
    }

    public PermApplyFragment() {
        this.f232964l = LazyKt.lazy(new PermApplyFragment$viewModel$2(this));
        this.f232965m = new CompositeDisposable();
    }

    public final void aa0() {
        if (Z90().getOwnerText().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L15;
        SpannableString r101 = new SpannableString(Z90().getOwnerText());
        int r102 = StringsKt.indexOf$default(Z90().getOwnerText(), Z90().getOwnerStr(), 0, false, 6, null);
        int r103 = Z90().getOwnerStr().length() + r102;
        if (r102 < r103) goto L10;
        return;
    L10:
        if (r101.length() < r103) goto L17;
        if (r102 < 0) goto L18;
        r101.setSpan(new b(this), r102, r103, 33);
        V90().setDesc(r101);
        return;
    L18:
        return;
    L17:
        return;
    L15:
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // au5.a
    public final View getTitleBar() {
        return X90();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f232965m.dispose();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f232957e = null;
        this.f232958f = null;
        this.f232959g = null;
        this.f232960h = null;
        this.f232961i = null;
        this.f232962j = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L7;
        Intent r101 = r100.getIntent();
        if (r101 == null) goto L7;
        int r102 = r101.getIntExtra("softInputMode", -1);
    L8:
        if (r102 == (-1)) goto L15;
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L16;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L17;
        r104.setSoftInputMode(r102);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r102 = -1;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        FragmentActivity r100 = getActivity();
        int r101 = -1;
        if (r100 == null) goto L7;
        Intent r102 = r100.getIntent();
        if (r102 == null) goto L7;
        int r103 = r102.getIntExtra("softInputMode", -1);
    L8:
        if (r103 != (-1)) goto L21;
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L16;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L16;
        WindowManager.LayoutParams r106 = r105.getAttributes();
        if (r106 == null) goto L16;
        r101 = r106.softInputMode;
    L16:
        FragmentActivity r107 = getActivity();
        if (r107 == null) goto L21;
        Intent r108 = r107.getIntent();
        if (r108 == null) goto L21;
        r108.putExtra("softInputMode", r101);
    L21:
        FragmentActivity r109 = getActivity();
        if (r109 == null) goto L27;
        Window r110 = r109.getWindow();
        if (r110 == null) goto L28;
        r110.setSoftInputMode(16);
        return;
    L28:
        return;
    L27:
        return;
    L7:
        r103 = -1;
        goto L8
    }

    @Override // au5.a
    public final void mY(au5.b r100) {
        this.f232968p = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Serializable r101 = requireArguments().getSerializable("Params");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.apply.NoPermission");
        NoPermission r102 = (NoPermission) r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f232963k = r102;
    }

    @Override // au5.a
    public final void setBackIcon(Drawable r100) {
        this.f232966n = r100;
    }

    @Override // au5.a
    public final void setBackListener(View.OnClickListener r100) {
        this.f232967o = r100;
    }

    public static final void U90(final PermApplyFragment r100, boolean r101) {
        if (r100.Y90() == null) goto L10;
        if (r101 == false) goto L7;
        com.larksuite.component.universe_design.button.e.h(r100.Y90(), new PermApplyFragment$handleLoading$1(r100));
        r100.Y90().setTextColor(UDColorUtils.getColor(r100.requireContext(), R.color.udtoken_btn_pri_text_disabled));
        r100.Y90().setBackgroundColor(UDColorUtils.getColor(r100.requireContext(), R.color.primary_fill_loading));
        return;
    L7:
        com.larksuite.component.universe_design.button.e.c(r100.Y90(), R.string.Doc_Permission_SendRequest);
        r100.Y90().setTextColor(UDColorUtils.getColor(r100.requireContext(), R.color.static_white));
        r100.Y90().setBackgroundColor(UDColorUtils.getColor(r100.requireContext(), R.color.primary_fill_default));
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        X90().setDividerVisible(false);
        X90().setLeftIconVisibility(W90().getBackVisible());
        if (W90().getFromDocXInBase() == false) goto L5;
        X90().setVisibility(8);
    L5:
        float r112 = (getResources().getDimension(R.dimen.ud_emptystate_padding_horizontal) * 2) + getResources().getDimension(R.dimen.space_permission_apply_max_width);
        ViewGroup.LayoutParams r100 = V90().getLayoutParams();
        r100.width = (int) r112;
        V90().setLayoutParams(r100);
        V90().setTitle(Z90().getTipsText());
        V90().setDesc(Z90().getOwnerText());
        aa0();     // Catch: Throwable -> L8
    L11:
        if (this.f232966n == null) goto L15;
        ImageView r113 = X90().getLeftImage();
        if (r113 == null) goto L15;
        r113.setImageDrawable(this.f232966n);
    L15:
        Z90().getPermType().observe(getViewLifecycleOwner(), new e1(this));
        if (X90().isAttachedToWindow() == false) goto L20;
        tt5.a.h("PermApplyFragment", "permission_title_bar isAttachedToWindow");
        au5.b r114 = this.f232968p;
        if (r114 == null) goto L20;
        r114.a(true);
    L20:
        X90().addOnAttachStateChangeListener(new f1(this));
        if (this.f232967o == null) goto L23;
        X90().setLeftClickListener(this.f232967o);
    L24:
        View r115 = this.f232961i;
        if (r115 != null) goto L31;
        View r116 = getView();
        if (r116 == null) goto L29;
        r115 = r116.findViewById(R.id.permission_type_choose);
    L30:
        this.f232961i = (LinearLayout) r115;
        goto L31
    L29:
        r115 = null;
    L31:
        ((LinearLayout) r115).setOnClickListener(new c1(this));
        Y90().setOnClickListener(new d1(this));
        int r101 = sbb.e.g(W90().getDocumentType());
        com.bytedance.ee.bear.route.h r117 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        String r118 = W90().getOriginalBearUrlToken();
        if (r118 == null) goto L34;
        r117.N9(r118, requireContext().getResources().getString(R.string.Doc_Permission_NoPermissionAccess));
    L34:
        com.bytedance.ee.bear.middleground.permission.c.z(W90().getToken(), r101, W90().getSubType(), W90().getFromVc(), W90().isWiki(), W90().getModule(), W90().getUserPerm(), W90().getPublicPerm(), "apply_permission");
        return;
    L23:
        X90().setLeftClickListener(new b1(this));
    L8:
        th = move-exception;
        tt5.a.f("", th, false);
        iu5.d.a("", th);
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.permission_apply, r101, false);
    }
}
