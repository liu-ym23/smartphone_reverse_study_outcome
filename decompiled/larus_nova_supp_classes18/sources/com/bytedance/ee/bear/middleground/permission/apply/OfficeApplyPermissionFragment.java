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
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.ss.android.lark.insets.WindowInsetsUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\u0012\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010,\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/OfficeApplyPermissionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "<init>", "()V", "params", "Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "mode", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageMode;", "controller", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionController;", "pageView", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageView;", "customBackDrawable", "Landroid/graphics/drawable/Drawable;", "customBackListener", "Landroid/view/View$OnClickListener;", "visibleListener", "Lcom/bytedance/ee/permission/view/IViewVisibleListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "onDestroyView", "onDestroy", "bindVisibleListener", "bindWindowInsets", "saveSoftInputMode", "revertSoftInputMode", "setBackIcon", "drawable", "setBackListener", "listener", "getTitleBar", "setViewVisibleListener", "Companion", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeApplyPermissionFragment extends BaseFragment implements au5.a {
    public static final /* synthetic */ int l = 0;
    public NoPermission e;
    public ApplyPermissionPageMode f;
    public ApplyPermissionController g;
    public p0 h;
    public Drawable i;
    public View.OnClickListener j;
    public au5.b k;

    public static final class a {
        @JvmStatic
        public static OfficeApplyPermissionFragment a(NoPermission r3, ApplyPermissionPageMode r4) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "mode");
            OfficeApplyPermissionFragment r0 = new OfficeApplyPermissionFragment();
            Bundle r1 = new Bundle();
            r1.putSerializable("Params", r3);
            r1.putString("PageMode", r4.name());
            r0.setArguments(r1);
            return r0;
        }
    }

    static {
    }

    public final /* synthetic */ View NW() {
        return null;
    }

    public final View getTitleBar() {
        p0 r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final void onDestroy() {
        super.onDestroy();
        ApplyPermissionController r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("controller");
        r0 = null;
    L5:
        r0.e.dispose();
        r0.d = null;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        ApplyPermissionController r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("controller");
        r0 = null;
    L5:
        r0.e.clear();
        r0.d = null;
        this.h = null;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        Intent r1 = r0.getIntent();
        if (r1 == null) goto L7;
        int r2 = r1.getIntExtra("softInputMode", -1);
    L8:
        if (r2 == (-1)) goto L15;
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L16;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L17;
        r4.setSoftInputMode(r2);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r2 = -1;
        goto L8
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        FragmentActivity r0 = getActivity();
        int r1 = -1;
        if (r0 == null) goto L7;
        Intent r2 = r0.getIntent();
        if (r2 == null) goto L7;
        int r3 = r2.getIntExtra("softInputMode", -1);
    L8:
        if (r3 != (-1)) goto L21;
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L16;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L16;
        WindowManager.LayoutParams r6 = r5.getAttributes();
        if (r6 == null) goto L16;
        r1 = r6.softInputMode;
    L16:
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L21;
        Intent r8 = r7.getIntent();
        if (r8 == null) goto L21;
        r8.putExtra("softInputMode", r1);
    L21:
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L27;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L28;
        r10.setSoftInputMode(16);
        return;
    L28:
        return;
    L27:
        return;
    L7:
        r3 = -1;
        goto L8
    }

    public OfficeApplyPermissionFragment() {
    }

    public final void mY(au5.b r1) {
        this.k = r1;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Serializable r5 = requireArguments().getSerializable("Params");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.apply.NoPermission");
        this.e = (NoPermission) r5;
        String r6 = requireArguments().getString("PageMode");
        if (r6 != null) goto L5;
        r6 = "NORMAL";
    L5:
        this.f = ApplyPermissionPageMode.valueOf(r6);
        NoPermission r0 = this.e;
        ApplyPermissionPageMode r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r0 = null;
    L8:
        ApplyPermissionPageMode r2 = this.f;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mode");
    L12:
        this.g = new ApplyPermissionController(this, r0, r1);
        return;
    L11:
        r1 = r2;
        goto L12
    }

    public final void setBackIcon(Drawable r2) {
        this.i = r2;
        if (r2 == null) goto L8;
        p0 r0 = this.h;
        if (r0 == null) goto L9;
        r0.e(r2);
        return;
    L9:
        return;
    }

    public final void setBackListener(View.OnClickListener r1) {
        this.j = r1;
    }

    public final void onViewCreated(View r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r21, "view");
        super.onViewCreated(r21, r22);
        WindowInsetsUtils.b(this).c(true);
        WindowInsetsUtils.b(this).o(true);
        final p0 r2 = new p0(r21);
        ApplyPermissionController r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("controller");
        ApplyPermissionController r5 = null;
    L6:
        LifecycleOwner r6 = getViewLifecycleOwner();
        Drawable r7 = this.i;
        View.OnClickListener r8 = this.j;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "pageView");
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        r5.d = r2;
        Context r1 = r5.a.requireContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        ApplyPermissionPageMode r10 = r5.c;
        int[] r11 = ApplyPermissionController.b.a;
        int r12 = r11[r10.ordinal()];
        String r13 = "";
        if (r12 == 1) goto L12;
        if (r12 != 2) goto L11;
        String r3 = r1.getString(2131888103);
    L18:
        String r14 = r3;
    L19:
        Context r4 = r5.a.requireContext();
        Intrinsics.checkNotNullParameter(r4, "context");
        int r9 = r11[r5.c.ordinal()];
        if (r9 == 1) goto L27;
        if (r9 != 2) goto L26;
        if (((com.bytedance.ee.bear.middleground.permission.apply.a) r5.g.getValue()) == null) goto L30;
        Spanned r15 = com.bytedance.ee.bear.middleground.permission.apply.a.a(r4);
    L31:
        if (r15 != null) goto L33;
        r15 = new SpannableString("");
    L33:
        Spanned r16 = r15;
        int r17 = r11[r5.c.ordinal()];
        if (r17 == 1) goto L39;
        if (r17 != 2) goto L38;
    L57:
        ApplyPermissionPageMode r18 = r5.c;
        ApplyPermissionPageMode r19 = ApplyPermissionPageMode.NORMAL;
        if (r18 != r19) goto L60;
        boolean r20 = true;
    L61:
        PermApplyViewModel r23 = r5.c();
        if (r23 == null) goto L69;
        LiveData<PermApplyViewModel.PermType> r24 = r23.getPermType();
        if (r24 == null) goto L69;
        PermApplyViewModel.PermType r25 = (PermApplyViewModel.PermType) r24.getValue();
        if (r25 == null) goto L69;
        String r26 = r25.getText();
        if (r26 == null) goto L69;
    L70:
        r2.d(new o(r14, r16, r13, r20, r26, r5.e(), r5.b.getBackVisible(), r5.b.getFromDocXInBase()));
        if (r7 == null) goto L73;
        r2.e(r7);
    L73:
        r2.f(new g(r8, r2, r5));
        Function1<PermApplyViewModel.PermType, Unit> r27 = new ApplyPermissionController$bind$3(r2);
        Intrinsics.checkNotNullParameter(r6, "owner");
        Intrinsics.checkNotNullParameter(r27, "observer");
        PermApplyViewModel r28 = r5.c();
        if (r28 == null) goto L79;
        LiveData<PermApplyViewModel.PermType> r29 = r28.getPermType();
        if (r29 == null) goto L79;
        r29.observe(r6, new h(r27));
    L79:
        if (r5.c != r19) goto L83;
        com.bytedance.ee.bear.route.h r30 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        String r31 = r5.b.getOriginalBearUrlToken();
        if (r31 == null) goto L83;
        r30.N9(r31, r5.a.requireContext().getResources().getString(2131888095));
    L83:
        com.bytedance.ee.bear.middleground.permission.c.z(r5.b.getToken(), sbb.e.g(r5.b.getDocumentType()), r5.b.getSubType(), r5.b.getFromVc(), r5.b.isWiki(), r5.b.getModule(), r5.b.getUserPerm(), r5.b.getPublicPerm(), r5.d());
        BaseTitleBar r32 = r2.b;
        if (r32 != null) goto L87;
    L92:
        this.h = r2;
        return;
    L87:
        if (r32.isAttachedToWindow() == false) goto L91;
        au5.b r33 = this.k;
        if (r33 == null) goto L91;
        r33.a(true);
    L91:
        r32.addOnAttachStateChangeListener(new k0(this, r32));
    L69:
        r26 = r5.a.getString(2131887806);
        goto L70
    L60:
        r20 = false;
        goto L61
    L38:
        throw new NoWhenBranchMatchedException();
    L39:
        PermApplyViewModel r34 = r5.c();
        if (r34 != null) goto L43;
        String r35 = r5.b.getOwnerName();
    L56:
        r13 = r35;
        goto L57
    L43:
        if (r34.getOwnerText().length() != 0) goto L45;
        boolean r110 = true;
    L46:
        if (r110 == true) goto L57;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L50
        Object r36 = Result.constructor-impl(r34.getOwnerStr());     // Catch: Throwable -> L50
    L52:
        String r112 = r5.b.getOwnerName();
        if (Result.isFailure-impl(r36) == false) goto L55;
        r36 = r112;
    L55:
        r35 = (String) r36;
    L50:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L45:
        r110 = false;
    L30:
        r15 = null;
        goto L31
    L26:
        throw new NoWhenBranchMatchedException();
    L27:
        PermApplyViewModel r37 = r5.c();
        if (r37 == null) goto L30;
        r15 = r37.getOwnerText();
        goto L31
    L11:
        throw new NoWhenBranchMatchedException();
    L12:
        PermApplyViewModel r38 = r5.c();
        if (r38 == null) goto L15;
        r3 = r38.getTipsText();
    L16:
        if (r3 != null) goto L18;
        r14 = "";
        goto L19
    L15:
        r3 = null;
        goto L16
    L5:
        r5 = r0;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564063, r3, false);
    }
}
