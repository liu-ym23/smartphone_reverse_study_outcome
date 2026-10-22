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
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFetcher;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.insets.WindowInsetsUtils;
import io.reactivex.disposables.CompositeDisposable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u001dH\u0016J\b\u0010*\u001a\u00020\u001dH\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\b\u0010.\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u000202H\u0002J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u000209H\u0002J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u000205H\u0002J\b\u0010@\u001a\u00020\u001dH\u0002J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!H\u0002J\u0012\u0010B\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010D\u001a\u00020\u001d2\b\u0010E\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010F\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010G\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010H\u001a\u00020\u001dH\u0002J\b\u0010I\u001a\u00020\u001dH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/OfficeBitableApplyPermissionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "<init>", "()V", "params", "Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "fetcher", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProFetcher;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "descView", "Landroid/widget/TextView;", "inputContainer", "Landroid/widget/FrameLayout;", "inputView", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "inputError", "submitView", "helpView", "customBackDrawable", "Landroid/graphics/drawable/Drawable;", "customBackListener", "Landroid/view/View$OnClickListener;", "visibleListener", "Lcom/bytedance/ee/permission/view/IViewVisibleListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "onDestroyView", "onDestroy", "bindViews", "bindContent", "queryApplyPermissionCode", "submitApplyRequest", "updateApplyLayoutVisibility", "canApply", "", "updateInputError", "length", "", "setLoading", "loading", "buildOwnerDescription", "", "resId", "ownerKey", "", "buildHelpDescription", "showToast", "errorCode", "hideKeyboard", "bindVisibleListener", "setBackIcon", "drawable", "setBackListener", "listener", "getTitleBar", "setViewVisibleListener", "saveSoftInputMode", "revertSoftInputMode", "Companion", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBitableApplyPermissionFragment extends BaseFragment implements au5.a {
    public static final /* synthetic */ int r = 0;
    public NoPermission e;
    public BitableApplyProFetcher f;
    public final CompositeDisposable g;
    public BaseTitleBar h;
    public TextView i;
    public FrameLayout j;
    public SpaceEditText k;
    public TextView l;
    public TextView m;
    public TextView n;
    public Drawable o;
    public View.OnClickListener p;
    public au5.b q;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ OfficeBitableApplyPermissionFragment a;

        public b(OfficeBitableApplyPermissionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            NoPermission r5 = this.a.e;
            NoPermission r1 = null;
            if (r5 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("params");
            r5 = null;
        L6:
            if (r5.getOwnerId().length() <= 0) goto L8;
            boolean r6 = true;
        L9:
            if (r6 == false) goto L16;
            com.bytedance.ee.bear.docshost.k r7 = (com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6);
            NoPermission r2 = this.a.e;
            if (r2 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("params");
        L14:
            r7.e(r1.getOwnerId(), "");
            int r8 = com.bytedance.ee.bear.bitable.pro.d.a;
            JSONObject r9 = new JSONObject();
            r9.put("click", "owner_name");
            r9.put("target", "none");
            com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_application_click", r9);
            return;
        L13:
            r1 = r2;
            goto L14
        L16:
            return;
        L8:
            r6 = false;
            goto L9
        }
    }

    static {
    }

    public final /* synthetic */ View NW() {
        return null;
    }

    public OfficeBitableApplyPermissionFragment() {
        this.g = new CompositeDisposable();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.g.dispose();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
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

    public final View getTitleBar() {
        return this.h;
    }

    public final void mY(au5.b r1) {
        this.q = r1;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Serializable r4 = requireArguments().getSerializable("params");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.apply.NoPermission");
        this.e = (NoPermission) r4;
        NoPermission r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r1 = null;
    L5:
        this.f = new BitableApplyProFetcher(r1.getToken());
    }

    public final void setBackIcon(Drawable r2) {
        this.o = r2;
        if (r2 == null) goto L10;
        BaseTitleBar r0 = this.h;
        if (r0 == null) goto L11;
        ImageView r1 = r0.getLeftImage();
        if (r1 == null) goto L12;
        r1.setImageDrawable(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setBackListener(View.OnClickListener r2) {
        this.p = r2;
        BaseTitleBar r0 = this.h;
        if (r0 == null) goto L6;
        r0.setLeftClickListener(r2);
        return;
    }

    public final void setLoading(boolean r3) {
        TextView r0 = this.m;
        if (r0 == null) goto L14;
        r0.setEnabled(!r3);
        if (r3 == false) goto L7;
        int r1 = 2131889694;
    L8:
        r0.setText(r1);
        if (r3 == false) goto L11;
        int r4 = 2131244709;
    L12:
        r0.setBackgroundResource(r4);
        return;
    L11:
        r4 = 2131244707;
        goto L12
    L7:
        r1 = 2131886174;
        goto L8
    }

    public static final void U90(OfficeBitableApplyPermissionFragment r1, int r2) {
        r1.getClass();
        if (r2 != 0) goto L5;
        int r0 = 2131886173;
    L12:
        Context r3 = r1.requireContext();
        if (r2 != 0) goto L15;
        int r4 = 2131256306;
    L16:
        UDToast.show(r3, r0, r4);
        return;
    L15:
        r4 = 2131255144;
        goto L16
    L5:
        if (r2 != 800004006) goto L7;
        r0 = 2131886171;
        goto L12
    L7:
        if (r2 == 800004106) goto L9;
        r0 = 2131886172;
        goto L12
    L9:
        r0 = 2131886170;
        goto L12
    }

    public static final void V90(OfficeBitableApplyPermissionFragment r4, boolean r5) {
        FrameLayout r0 = r4.j;
        int r1 = 0;
        if (r0 == null) goto L8;
        if (r5 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        goto L8
    L6:
        r3 = 8;
    L8:
        TextView r2 = r4.l;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        TextView r6 = r4.m;
        if (r6 == null) goto L17;
        if (r5 == true) goto L16;
        r1 = 8;
    L16:
        r6.setVisibility(r1);
    L17:
        TextView r7 = r4.i;
        if (r7 == null) goto L24;
        if (r5 == false) goto L21;
        CharSequence r8 = r4.W90(2131886175, "userName");
    L22:
        r7.setText(r8);
        return;
    L21:
        r8 = r4.W90(2131886242, "name");
        goto L22
    }

    public final CharSequence W90(int r11, String r12) {
        Context r0 = getContext();
        NoPermission r1 = this.e;
        NoPermission r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r1 = null;
    L5:
        String r13 = xo5.a.c(r0, r11, r12, r1.getOwnerName());
        NoPermission r14 = this.e;
        if (r14 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r14 = null;
    L9:
        if (r14.getOwnerName().length() != 0) goto L11;
        boolean r15 = true;
    L12:
        if (r15 == false) goto L15;
        Intrinsics.checkNotNull(r13);
        return r13;
    L15:
        Intrinsics.checkNotNull(r13);
        NoPermission r16 = this.e;
        if (r16 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r16 = null;
    L18:
        int r17 = StringsKt.indexOf$default(r13, r16.getOwnerName(), 0, false, 6, null);
        NoPermission r3 = this.e;
        if (r3 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("params");
    L22:
        int r4 = r2.getOwnerName().length() + r17;
        if (r17 >= 0) goto L25;
    L29:
        return r13;
    L25:
        if (r4 > r13.length()) goto L29;
        SpannableStringBuilder r5 = new SpannableStringBuilder(r13);
        r5.setSpan(new UDEmptyState.b(new b(this)), r17, r4, 34);
        return r5;
    L21:
        r2 = r3;
        goto L22
    L11:
        r15 = false;
        goto L12
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        WindowInsetsUtils.b(this).c(true);
        WindowInsetsUtils.b(this).o(true);
        this.h = (BaseTitleBar) r9.findViewById(2131382173);
        this.i = (TextView) r9.findViewById(2131381367);
        this.j = (FrameLayout) r9.findViewById(2131371424);
        this.k = (SpaceEditText) r9.findViewById(2131371423);
        this.l = (TextView) r9.findViewById(2131381370);
        this.m = (TextView) r9.findViewById(2131385928);
        this.n = (TextView) r9.findViewById(2131381368);
        ((LinearLayout) r9.findViewById(2131382178)).setVisibility(8);
        ((TextView) r9.findViewById(2131381371)).setText(2131886176);
        BaseTitleBar r11 = this.h;
        BitableApplyProFetcher r12 = null;
        if (r11 == null) goto L21;
        r11.setDividerVisible(false);
        NoPermission r2 = this.e;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r2 = null;
    L7:
        r11.setLeftIconVisibility(r2.getBackVisible());
        Drawable r3 = this.o;
        if (r3 == null) goto L12;
        ImageView r4 = r11.getLeftImage();
        if (r4 == null) goto L12;
        r4.setImageDrawable(r3);
    L12:
        View.OnClickListener r5 = this.p;
        if (r5 != null) goto L15;
        r5 = new q0(this);
    L15:
        r11.setLeftClickListener(r5);
        if (r11.isAttachedToWindow() == false) goto L20;
        au5.b r6 = this.q;
        if (r6 == null) goto L20;
        r6.a(true);
    L20:
        r11.addOnAttachStateChangeListener(new v0(this, r11));
    L21:
        TextView r13 = this.i;
        if (r13 == null) goto L24;
        r13.setText(W90(2131886175, "userName"));
        r13.setMovementMethod(LinkMovementMethod.getInstance());
        r13.setHighlightColor(0);
    L24:
        UDEditText r14 = this.k;
        if (r14 == null) goto L27;
        r14.setHint(2131886169);
        r14.setOnFocusChangeListener(r0.a);
        r14.addTextChangedListener(new u0(this));
    L27:
        TextView r15 = this.m;
        if (r15 == null) goto L30;
        r15.setText(2131886174);
        r15.setOnClickListener(new s0(this));
    L30:
        int r16 = com.bytedance.ee.bear.bitable.pro.e.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("base.advanced_permission.role_inheritance") == false) goto L41;
        TextView r17 = this.n;
        if (r17 == null) goto L41;
        r17.setVisibility(0);
        String r0 = getString(2131886218);
        String r7 = xo5.a.c(getContext(), 2131886219, "docName", r0);
        Intrinsics.checkNotNull(r7);
        int r1 = StringsKt.indexOf$default(r7, r0, 0, false, 6, null);
        int r8 = r0.length() + r1;
        CharSequence r18 = r7;
        if (r1 < 0) goto L40;
        int r19 = r7.length();
        r18 = r7;
        if (r8 > r19) goto L40;
        SpannableStringBuilder r20 = new SpannableStringBuilder(r7);
        r20.setSpan(new UDEmptyState.b(w0.a), r1, r8, 34);
        r18 = r20;
    L40:
        r17.setText(r18);
        r17.setMovementMethod(LinkMovementMethod.getInstance());
    L41:
        View r21 = getView();
        if (r21 == null) goto L44;
        r21.setOnClickListener(new t0(this));
    L44:
        CompositeDisposable r22 = this.g;
        BitableApplyProFetcher r23 = this.f;
        if (r23 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("fetcher");
    L48:
        r22.add(r12.b().subscribe(new x0(this), new y0(this)));
        int r24 = com.bytedance.ee.bear.bitable.pro.d.a;
        com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_application_view", new JSONObject());
        return;
    L47:
        r12 = r23;
        goto L48
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564063, r3, false);
    }
}
