package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001SB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0016J\u0012\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020$H\u0016J\b\u00108\u001a\u00020$H\u0016J\b\u00109\u001a\u00020$H\u0002J&\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010@\u001a\u00020$H\u0016J\u001a\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020;2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010C\u001a\u00020$H\u0016J\u0010\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020$2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010H\u001a\u00020$H\u0002J\b\u0010I\u001a\u00020$H\u0002J\b\u0010J\u001a\u00020$H\u0002J\u0012\u0010K\u001a\u00020$2\b\u0010L\u001a\u0004\u0018\u00010/H\u0016J\u0012\u0010M\u001a\u00020$2\b\u0010N\u001a\u0004\u0018\u000101H\u0016J\n\u0010O\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010P\u001a\u00020$2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010&\u001a\u00020'X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/AuditControlApplyFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "<init>", "()V", "permissionTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getPermissionTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setPermissionTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "editOptionalFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getEditOptionalFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setEditOptionalFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "noDataEmptyStateFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getNoDataEmptyStateFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setNoDataEmptyStateFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "sendRequestFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getSendRequestFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setSendRequestFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "permissionTypeChooseFromXml", "Landroid/widget/LinearLayout;", "getPermissionTypeChooseFromXml", "()Landroid/widget/LinearLayout;", "setPermissionTypeChooseFromXml", "(Landroid/widget/LinearLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "params", "Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "getParams", "()Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "setParams", "(Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "customBackDrawable", "Landroid/graphics/drawable/Drawable;", "customBackListener", "Landroid/view/View$OnClickListener;", "fetcher", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyAuditEscapeFetcher;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "parseArgs", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "bindView", "onViewCreated", "view", LiveCommonConstants.REASON_ON_DEDTROY, "handleLoading", "loading", "", "handleLoadingInner", "bindListener", "saveSoftInputMode", "revertSoftInputMode", "setBackIcon", "drawable", "setBackListener", "listener", "getTitleBar", "setViewVisibleListener", "visibleListener", "Lcom/bytedance/ee/permission/view/IViewVisibleListener;", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AuditControlApplyFragment extends BaseFragment implements au5.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f232894p = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f232895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SpaceEditText f232896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SpaceEmptyState f232897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDButton f232898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f232899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public NoPermission f232900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f232901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f232902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View.OnClickListener f232903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.permission.apply.a f232904n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public au5.b f232905o;

    public static final class a {
    }

    static {
    }

    @Override // au5.a
    public final /* synthetic */ View NW() {
        return null;
    }

    public final SpaceEditText U90() {
        View r100 = this.f232896f;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.edit_optional);
    L8:
        this.f232896f = (SpaceEditText) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SpaceEditText) r100;
    }

    public final SpaceEmptyState V90() {
        View r100 = this.f232897g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.no_data_empty_state);
    L8:
        this.f232897g = (SpaceEmptyState) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SpaceEmptyState) r100;
    }

    public final NoPermission W90() {
        NoPermission r100 = this.f232900j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    }

    public final BaseTitleBar X90() {
        View r100 = this.f232895e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.permission_title_bar);
    L8:
        this.f232895e = (BaseTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (BaseTitleBar) r100;
    }

    public final UDButton Y90() {
        View r100 = this.f232898h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.send_request);
    L8:
        this.f232898h = (UDButton) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (UDButton) r100;
    }

    public AuditControlApplyFragment() {
        this.f232901k = new CompositeDisposable();
        this.f232904n = new com.bytedance.ee.bear.middleground.permission.apply.a();
    }

    @Override // au5.a
    public final View getTitleBar() {
        return X90();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f232901k.dispose();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f232895e = null;
        this.f232896f = null;
        this.f232897g = null;
        this.f232898h = null;
        this.f232899i = null;
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
        this.f232905o = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Serializable r101 = requireArguments().getSerializable("Params");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.apply.NoPermission");
        NoPermission r102 = (NoPermission) r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f232900j = r102;
    }

    @Override // au5.a
    public final void setBackIcon(Drawable r100) {
        this.f232902l = r100;
    }

    @Override // au5.a
    public final void setBackListener(View.OnClickListener r100) {
        this.f232903m = r100;
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
        com.bytedance.ee.bear.middleground.permission.apply.a r112 = this.f232904n;
        Context r100 = requireContext();
        r112.getClass();
        Spanned r113 = com.bytedance.ee.bear.middleground.permission.apply.a.a(r100);
        float r101 = (getResources().getDimension(R.dimen.ud_emptystate_padding_horizontal) * 2) + getResources().getDimension(R.dimen.space_permission_apply_max_width);
        ViewGroup.LayoutParams r102 = U90().getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
        r103.setMargins(r103.leftMargin, y9c.d.a(18) + r103.topMargin, r103.rightMargin, r103.bottomMargin);
        ViewGroup.LayoutParams r104 = V90().getLayoutParams();
        r104.width = (int) r101;
        V90().setLayoutParams(r104);
        UDButton r105 = Y90();
        Context r106 = getContext();
        View r107 = null;
        if (r106 == null) goto L8;
        String r108 = r106.getString(R.string.Doc_Facade_ApplyFor);
    L9:
        r105.setText(r108);
        SpaceEmptyState r109 = V90();
        Context r114 = getContext();
        if (r114 == null) goto L12;
        String r115 = r114.getString(R.string.Doc_Permission_OwnerNotAuthorizeCross);
    L13:
        r109.setTitle(r115);
        V90().setDesc(r113);
        if (this.f232902l == null) goto L18;
        ImageView r116 = X90().getLeftImage();
        if (r116 == null) goto L18;
        r116.setImageDrawable(this.f232902l);
    L18:
        View r117 = this.f232899i;
        if (r117 != null) goto L24;
        View r118 = getView();
        if (r118 == null) goto L23;
        r107 = r118.findViewById(R.id.permission_type_choose);
    L23:
        this.f232899i = (LinearLayout) r107;
        r117 = r107;
    L24:
        ((LinearLayout) r117).setVisibility(8);
        if (X90().isAttachedToWindow() == false) goto L29;
        tt5.a.h("AuditControlApplyFragment", "permission_title_bar isAttachedToWindow");
        au5.b r119 = this.f232905o;
        if (r119 == null) goto L29;
        r119.a(true);
    L29:
        X90().addOnAttachStateChangeListener(new y(this));
        if (this.f232903m == null) goto L32;
        X90().setLeftClickListener(this.f232903m);
    L33:
        Y90().setOnClickListener(new x(this));
        com.bytedance.ee.bear.middleground.permission.c.z(W90().getToken(), sbb.e.g(W90().getDocumentType()), W90().getSubType(), W90().getFromVc(), W90().isWiki(), W90().getModule(), W90().getUserPerm(), W90().getPublicPerm(), "admin_forbidden");
        return;
    L32:
        X90().setLeftClickListener(new w(this));
        goto L33
    L12:
        r115 = null;
        goto L13
    L8:
        r108 = null;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.permission_apply, r101, false);
    }
}
