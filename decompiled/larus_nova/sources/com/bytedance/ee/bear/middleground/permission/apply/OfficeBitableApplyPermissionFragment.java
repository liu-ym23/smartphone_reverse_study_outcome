package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFetcher;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.disposables.CompositeDisposable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u001dH\u0016J\b\u0010*\u001a\u00020\u001dH\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\b\u0010.\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u000202H\u0002J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u000209H\u0002J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u000205H\u0002J\b\u0010@\u001a\u00020\u001dH\u0002J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!H\u0002J\u0012\u0010B\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010D\u001a\u00020\u001d2\b\u0010E\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010F\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010G\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010H\u001a\u00020\u001dH\u0002J\b\u0010I\u001a\u00020\u001dH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/OfficeBitableApplyPermissionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "<init>", "()V", "params", "Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "fetcher", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProFetcher;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "descView", "Landroid/widget/TextView;", "inputContainer", "Landroid/widget/FrameLayout;", "inputView", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "inputError", "submitView", "helpView", "customBackDrawable", "Landroid/graphics/drawable/Drawable;", "customBackListener", "Landroid/view/View$OnClickListener;", "visibleListener", "Lcom/bytedance/ee/permission/view/IViewVisibleListener;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "bindViews", "bindContent", "queryApplyPermissionCode", "submitApplyRequest", "updateApplyLayoutVisibility", "canApply", "", "updateInputError", "length", "", "setLoading", "loading", "buildOwnerDescription", "", "resId", "ownerKey", "", "buildHelpDescription", "showToast", "errorCode", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "bindVisibleListener", "setBackIcon", "drawable", "setBackListener", "listener", "getTitleBar", "setViewVisibleListener", "saveSoftInputMode", "revertSoftInputMode", "Companion", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBitableApplyPermissionFragment extends BaseFragment implements au5.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f232937r = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NoPermission f232938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BitableApplyProFetcher f232939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f232940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BaseTitleBar f232941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f232942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f232943j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SpaceEditText f232944k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f232945l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f232946m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f232947n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f232948o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View.OnClickListener f232949p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public au5.b f232950q;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeBitableApplyPermissionFragment f232951a;

        public b(OfficeBitableApplyPermissionFragment r100) {
            this.f232951a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            NoPermission r101 = this.f232951a.f232938e;
            NoPermission r102 = null;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("params");
            r101 = null;
        L6:
            if (r101.getOwnerId().length() <= 0) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L16;
            com.bytedance.ee.bear.docshost.k r104 = (com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6);
            NoPermission r105 = this.f232951a.f232938e;
            if (r105 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("params");
        L14:
            r104.e(r102.getOwnerId(), "");
            int r106 = com.bytedance.ee.bear.bitable.pro.d.f215166a;
            JSONObject r107 = new JSONObject();
            r107.put("click", "owner_name");
            r107.put(PickerReporterConstants.KEY.TARGET, "none");
            com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_application_click", r107);
            return;
        L13:
            r102 = r105;
            goto L14
        L16:
            return;
        L8:
            r103 = false;
            goto L9
        }
    }

    static {
    }

    @Override // au5.a
    public final /* synthetic */ View NW() {
        return null;
    }

    public OfficeBitableApplyPermissionFragment() {
        this.f232940g = new CompositeDisposable();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f232940g.dispose();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f232941h = null;
        this.f232942i = null;
        this.f232943j = null;
        this.f232944k = null;
        this.f232945l = null;
        this.f232946m = null;
        this.f232947n = null;
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
    public final View getTitleBar() {
        return this.f232941h;
    }

    @Override // au5.a
    public final void mY(au5.b r100) {
        this.f232950q = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Serializable r101 = requireArguments().getSerializable("params");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.apply.NoPermission");
        this.f232938e = (NoPermission) r101;
        NoPermission r102 = this.f232938e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r102 = null;
    L5:
        this.f232939f = new BitableApplyProFetcher(r102.getToken());
    }

    @Override // au5.a
    public final void setBackIcon(Drawable r100) {
        this.f232948o = r100;
        if (r100 == null) goto L10;
        BaseTitleBar r101 = this.f232941h;
        if (r101 == null) goto L11;
        ImageView r102 = r101.getLeftImage();
        if (r102 == null) goto L12;
        r102.setImageDrawable(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // au5.a
    public final void setBackListener(View.OnClickListener r100) {
        this.f232949p = r100;
        BaseTitleBar r101 = this.f232941h;
        if (r101 == null) goto L6;
        r101.setLeftClickListener(r100);
        return;
    }

    public final void setLoading(boolean r100) {
        TextView r101 = this.f232946m;
        if (r101 == null) goto L14;
        r101.setEnabled(!r100);
        if (r100 == false) goto L7;
        int r102 = R.string.LarkCCM_Perm_PermissionRequesting_Mobile;
    L8:
        r101.setText(r102);
        if (r100 == false) goto L11;
        int r103 = R.drawable.office_permission_primary_button_loading;
    L12:
        r101.setBackgroundResource(r103);
        return;
    L11:
        r103 = R.drawable.office_permission_primary_button;
        goto L12
    L7:
        r102 = R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_Apply_Button;
        goto L8
    }

    public static final void U90(OfficeBitableApplyPermissionFragment r100, int r101) {
        r100.getClass();
        if (r101 != 0) goto L5;
        int r102 = R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_ApplySent_Toast;
    L12:
        Context r103 = r100.requireContext();
        if (r101 != 0) goto L15;
        int r104 = R.drawable.ud_icon_yes_outlined;
    L16:
        UDToast.show(r103, r102, r104);
        return;
    L15:
        r104 = R.drawable.ud_icon_more_close_outlined;
        goto L16
    L5:
        if (r101 != 800004006) goto L7;
        r102 = R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_ApplySentFailed_NotesContainSensitiveInfo_Toast;
        goto L12
    L7:
        if (r101 == 800004106) goto L9;
        r102 = R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_ApplySentFailed_Toast;
        goto L12
    L9:
        r102 = R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_ApplySentFailed_AlreadyHavePerm_Toast;
        goto L12
    }

    public static final void V90(OfficeBitableApplyPermissionFragment r100, boolean r101) {
        FrameLayout r102 = r100.f232943j;
        int r103 = 0;
        if (r102 == null) goto L8;
        if (r101 == false) goto L6;
        int r104 = 0;
    L7:
        r102.setVisibility(r104);
        goto L8
    L6:
        r104 = 8;
    L8:
        TextView r105 = r100.f232945l;
        if (r105 == null) goto L11;
        r105.setVisibility(8);
    L11:
        TextView r106 = r100.f232946m;
        if (r106 == null) goto L17;
        if (r101 == true) goto L16;
        r103 = 8;
    L16:
        r106.setVisibility(r103);
    L17:
        TextView r107 = r100.f232942i;
        if (r107 == null) goto L24;
        if (r101 == false) goto L21;
        CharSequence r108 = r100.W90(R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_Description, "userName");
    L22:
        r107.setText(r108);
        return;
    L21:
        r108 = r100.W90(R.string.Bitable_AdvancedPermissions_NoPermissionToAccess_Desc, "name");
        goto L22
    }

    public final CharSequence W90(int r110, String r111) {
        Context r100 = getContext();
        NoPermission r101 = this.f232938e;
        NoPermission r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r101 = null;
    L5:
        String r112 = xo5.a.c(r100, r110, r111, r101.getOwnerName());
        NoPermission r113 = this.f232938e;
        if (r113 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r113 = null;
    L9:
        if (r113.getOwnerName().length() != 0) goto L11;
        boolean r114 = true;
    L12:
        if (r114 == false) goto L15;
        Intrinsics.checkNotNull(r112);
        return r112;
    L15:
        Intrinsics.checkNotNull(r112);
        NoPermission r115 = this.f232938e;
        if (r115 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r115 = null;
    L18:
        int r116 = StringsKt.indexOf$default(r112, r115.getOwnerName(), 0, false, 6, null);
        NoPermission r103 = this.f232938e;
        if (r103 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L22:
        int r104 = r102.getOwnerName().length() + r116;
        if (r116 >= 0) goto L25;
    L29:
        return r112;
    L25:
        if (r104 > r112.length()) goto L29;
        SpannableStringBuilder r105 = new SpannableStringBuilder(r112);
        r105.setSpan(new UDEmptyState.b(new b(this)), r116, r104, 34);
        return r105;
    L21:
        r102 = r103;
        goto L22
    L11:
        r114 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        WindowInsetsUtils.b(this).c(true);
        WindowInsetsUtils.b(this).o(true);
        this.f232941h = (BaseTitleBar) r100.findViewById(R.id.permission_title_bar);
        this.f232942i = (TextView) r100.findViewById(R.id.office_permission_desc);
        this.f232943j = (FrameLayout) r100.findViewById(R.id.edit_optional_container);
        this.f232944k = (SpaceEditText) r100.findViewById(R.id.edit_optional);
        this.f232945l = (TextView) r100.findViewById(R.id.office_permission_input_error);
        this.f232946m = (TextView) r100.findViewById(R.id.send_request);
        this.f232947n = (TextView) r100.findViewById(R.id.office_permission_help);
        ((LinearLayout) r100.findViewById(R.id.permission_type_choose)).setVisibility(8);
        ((TextView) r100.findViewById(R.id.office_permission_title)).setText(R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_Title);
        BaseTitleBar r101 = this.f232941h;
        BitableApplyProFetcher r111 = null;
        if (r101 == null) goto L21;
        r101.setDividerVisible(false);
        NoPermission r102 = this.f232938e;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r102 = null;
    L7:
        r101.setLeftIconVisibility(r102.getBackVisible());
        Drawable r103 = this.f232948o;
        if (r103 == null) goto L12;
        ImageView r104 = r101.getLeftImage();
        if (r104 == null) goto L12;
        r104.setImageDrawable(r103);
    L12:
        View.OnClickListener r105 = this.f232949p;
        if (r105 != null) goto L15;
        r105 = new q0(this);
    L15:
        r101.setLeftClickListener(r105);
        if (r101.isAttachedToWindow() == false) goto L20;
        au5.b r106 = this.f232950q;
        if (r106 == null) goto L20;
        r106.a(true);
    L20:
        r101.addOnAttachStateChangeListener(new v0(this, r101));
    L21:
        TextView r107 = this.f232942i;
        if (r107 == null) goto L24;
        r107.setText(W90(R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_Description, "userName"));
        r107.setMovementMethod(LinkMovementMethod.getInstance());
        r107.setHighlightColor(0);
    L24:
        SpaceEditText r108 = this.f232944k;
        if (r108 == null) goto L27;
        r108.setHint(R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_AddNote_Placeholder);
        r108.setOnFocusChangeListener(r0.f233069a);
        r108.addTextChangedListener(new u0(this));
    L27:
        TextView r109 = this.f232946m;
        if (r109 == null) goto L30;
        r109.setText(R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_Apply_Button);
        r109.setOnClickListener(new s0(this));
    L30:
        int r112 = com.bytedance.ee.bear.bitable.pro.e.f215169a;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.advanced_permission.role_inheritance") == false) goto L41;
        TextView r113 = this.f232947n;
        if (r113 == null) goto L41;
        r113.setVisibility(0);
        String r114 = getString(R.string.Bitable_AdvancedPermissionsInherit_RequestCard_HowToAssign_Link);
        String r115 = xo5.a.c(getContext(), R.string.Bitable_AdvancedPermissionsInherit_RequestCard_ViewDoc_Desc, "docName", r114);
        Intrinsics.checkNotNull(r115);
        int r116 = StringsKt.indexOf$default(r115, r114, 0, false, 6, null);
        int r117 = r114.length() + r116;
        CharSequence r118 = r115;
        if (r116 < 0) goto L40;
        int r119 = r115.length();
        r118 = r115;
        if (r117 > r119) goto L40;
        SpannableStringBuilder r120 = new SpannableStringBuilder(r115);
        r120.setSpan(new UDEmptyState.b(w0.f233085a), r116, r117, 34);
        r118 = r120;
    L40:
        r113.setText(r118);
        r113.setMovementMethod(LinkMovementMethod.getInstance());
    L41:
        View r121 = getView();
        if (r121 == null) goto L44;
        r121.setOnClickListener(new t0(this));
    L44:
        CompositeDisposable r122 = this.f232940g;
        BitableApplyProFetcher r123 = this.f232939f;
        if (r123 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("fetcher");
    L48:
        r122.add(r111.b().subscribe(new x0(this), new y0(this)));
        int r124 = com.bytedance.ee.bear.bitable.pro.d.f215166a;
        com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_application_view", new JSONObject());
        return;
    L47:
        r111 = r123;
        goto L48
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.office_permission_apply, r101, false);
    }
}
