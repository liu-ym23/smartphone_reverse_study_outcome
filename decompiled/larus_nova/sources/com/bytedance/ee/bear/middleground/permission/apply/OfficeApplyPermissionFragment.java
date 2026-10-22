package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\u0012\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010,\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/OfficeApplyPermissionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "<init>", "()V", "params", "Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "mode", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageMode;", "controller", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionController;", "pageView", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageView;", "customBackDrawable", "Landroid/graphics/drawable/Drawable;", "customBackListener", "Landroid/view/View$OnClickListener;", "visibleListener", "Lcom/bytedance/ee/permission/view/IViewVisibleListener;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "bindVisibleListener", "bindWindowInsets", "saveSoftInputMode", "revertSoftInputMode", "setBackIcon", "drawable", "setBackListener", "listener", "getTitleBar", "setViewVisibleListener", "Companion", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeApplyPermissionFragment extends BaseFragment implements au5.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f232929l = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NoPermission f232930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ApplyPermissionPageMode f232931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ApplyPermissionController f232932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p0 f232933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f232934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View.OnClickListener f232935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public au5.b f232936k;

    public static final class a {
        @JvmStatic
        public static OfficeApplyPermissionFragment a(NoPermission r100, ApplyPermissionPageMode r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "mode");
            OfficeApplyPermissionFragment r102 = new OfficeApplyPermissionFragment();
            Bundle r103 = new Bundle();
            r103.putSerializable("Params", r100);
            r103.putString("PageMode", r101.name());
            r102.setArguments(r103);
            return r102;
        }
    }

    static {
    }

    @Override // au5.a
    public final /* synthetic */ View NW() {
        return null;
    }

    @Override // au5.a
    public final View getTitleBar() {
        p0 r100 = this.f232933h;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f233058b;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ApplyPermissionController r100 = this.f232932g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("controller");
        r100 = null;
    L5:
        r100.f232876e.dispose();
        r100.f232875d = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ApplyPermissionController r100 = this.f232932g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("controller");
        r100 = null;
    L5:
        r100.f232876e.clear();
        r100.f232875d = null;
        this.f232933h = null;
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

    public OfficeApplyPermissionFragment() {
    }

    @Override // au5.a
    public final void mY(au5.b r100) {
        this.f232936k = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Serializable r101 = requireArguments().getSerializable("Params");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.apply.NoPermission");
        this.f232930e = (NoPermission) r101;
        String r102 = requireArguments().getString("PageMode");
        if (r102 != null) goto L5;
        r102 = EffectConstants.NORMAL;
    L5:
        this.f232931f = ApplyPermissionPageMode.valueOf(r102);
        NoPermission r103 = this.f232930e;
        ApplyPermissionPageMode r104 = null;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r103 = null;
    L8:
        ApplyPermissionPageMode r105 = this.f232931f;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mode");
    L12:
        this.f232932g = new ApplyPermissionController(this, r103, r104);
        return;
    L11:
        r104 = r105;
        goto L12
    }

    @Override // au5.a
    public final void setBackIcon(Drawable r100) {
        this.f232934i = r100;
        if (r100 == null) goto L8;
        p0 r101 = this.f232933h;
        if (r101 == null) goto L9;
        r101.e(r100);
        return;
    L9:
        return;
    }

    @Override // au5.a
    public final void setBackListener(View.OnClickListener r100) {
        this.f232935j = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        WindowInsetsUtils.b(this).c(true);
        WindowInsetsUtils.b(this).o(true);
        final p0 r100 = new p0(r210);
        ApplyPermissionController r101 = this.f232932g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("controller");
        ApplyPermissionController r102 = null;
    L6:
        LifecycleOwner r103 = getViewLifecycleOwner();
        Drawable r104 = this.f232934i;
        View.OnClickListener r105 = this.f232935j;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "pageView");
        Intrinsics.checkNotNullParameter(r103, "lifecycleOwner");
        r102.f232875d = r100;
        Context r106 = r102.f232872a.requireContext();
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        ApplyPermissionPageMode r110 = r102.f232874c;
        int[] r111 = ApplyPermissionController.b.f232879a;
        int r112 = r111[r110.ordinal()];
        String r113 = "";
        if (r112 == 1) goto L12;
        if (r112 != 2) goto L11;
        String r107 = r106.getString(R.string.Doc_Permission_OwnerNotAuthorizeCross);
    L18:
        String r114 = r107;
    L19:
        Context r108 = r102.f232872a.requireContext();
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r109 = r111[r102.f232874c.ordinal()];
        if (r109 == 1) goto L27;
        if (r109 != 2) goto L26;
        if (((com.bytedance.ee.bear.middleground.permission.apply.a) r102.f232878g.getValue()) == null) goto L30;
        Spanned r115 = com.bytedance.ee.bear.middleground.permission.apply.a.a(r108);
    L31:
        if (r115 != null) goto L33;
        r115 = new SpannableString("");
    L33:
        Spanned r116 = r115;
        int r117 = r111[r102.f232874c.ordinal()];
        if (r117 == 1) goto L39;
        if (r117 != 2) goto L38;
    L57:
        ApplyPermissionPageMode r118 = r102.f232874c;
        ApplyPermissionPageMode r119 = ApplyPermissionPageMode.NORMAL;
        if (r118 != r119) goto L60;
        boolean r120 = true;
    L61:
        PermApplyViewModel r121 = r102.c();
        if (r121 == null) goto L69;
        LiveData<PermApplyViewModel.PermType> r122 = r121.getPermType();
        if (r122 == null) goto L69;
        PermApplyViewModel.PermType r123 = r122.getValue();
        if (r123 == null) goto L69;
        String r124 = r123.getText();
        if (r124 == null) goto L69;
    L70:
        r100.d(new o(r114, r116, r113, r120, r124, r102.e(), r102.f232873b.getBackVisible(), r102.f232873b.getFromDocXInBase()));
        if (r104 == null) goto L73;
        r100.e(r104);
    L73:
        r100.f(new g(r105, r100, r102));
        Function1<PermApplyViewModel.PermType, Unit> r125 = new ApplyPermissionController$bind$3(r100);
        Intrinsics.checkNotNullParameter(r103, "owner");
        Intrinsics.checkNotNullParameter(r125, "observer");
        PermApplyViewModel r126 = r102.c();
        if (r126 == null) goto L79;
        LiveData<PermApplyViewModel.PermType> r127 = r126.getPermType();
        if (r127 == null) goto L79;
        r127.observe(r103, new h(r125));
    L79:
        if (r102.f232874c != r119) goto L83;
        com.bytedance.ee.bear.route.h r128 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        String r129 = r102.f232873b.getOriginalBearUrlToken();
        if (r129 == null) goto L83;
        r128.N9(r129, r102.f232872a.requireContext().getResources().getString(R.string.Doc_Permission_NoPermissionAccess));
    L83:
        com.bytedance.ee.bear.middleground.permission.c.z(r102.f232873b.getToken(), sbb.e.g(r102.f232873b.getDocumentType()), r102.f232873b.getSubType(), r102.f232873b.getFromVc(), r102.f232873b.isWiki(), r102.f232873b.getModule(), r102.f232873b.getUserPerm(), r102.f232873b.getPublicPerm(), r102.d());
        BaseTitleBar r130 = r100.f233058b;
        if (r130 != null) goto L87;
    L92:
        this.f232933h = r100;
        return;
    L87:
        if (r130.isAttachedToWindow() == false) goto L91;
        au5.b r131 = this.f232936k;
        if (r131 == null) goto L91;
        r131.a(true);
    L91:
        r130.addOnAttachStateChangeListener(new k0(this, r130));
    L69:
        r124 = r102.f232872a.getString(R.string.Doc_Facade_ReadPermission);
        goto L70
    L60:
        r120 = false;
        goto L61
    L38:
        throw new NoWhenBranchMatchedException();
    L39:
        PermApplyViewModel r132 = r102.c();
        if (r132 != null) goto L43;
        String r133 = r102.f232873b.getOwnerName();
    L56:
        r113 = r133;
        goto L57
    L43:
        if (r132.getOwnerText().length() != 0) goto L45;
        boolean r134 = true;
    L46:
        if (r134 == true) goto L57;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L50
        Object r136 = Result.m9449constructorimpl(r132.getOwnerStr());     // Catch: Throwable -> L50
    L52:
        String r137 = r102.f232873b.getOwnerName();
        if (Result.m9455isFailureimpl(r136) == false) goto L55;
        r136 = r137;
    L55:
        r133 = (String) r136;
    L50:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L52
    L45:
        r134 = false;
    L30:
        r115 = null;
        goto L31
    L26:
        throw new NoWhenBranchMatchedException();
    L27:
        PermApplyViewModel r139 = r102.c();
        if (r139 == null) goto L30;
        r115 = r139.getOwnerText();
        goto L31
    L11:
        throw new NoWhenBranchMatchedException();
    L12:
        PermApplyViewModel r140 = r102.c();
        if (r140 == null) goto L15;
        r107 = r140.getTipsText();
    L16:
        if (r107 != null) goto L18;
        r114 = "";
        goto L19
    L15:
        r107 = null;
        goto L16
    L5:
        r102 = r101;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.office_permission_apply, r101, false);
    }
}
