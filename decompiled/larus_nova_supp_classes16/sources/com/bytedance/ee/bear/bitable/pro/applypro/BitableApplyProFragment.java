package com.bytedance.ee.bear.bitable.pro.applypro;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.bitable.pro.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.edittext.UDTextInputLayout;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larksuite.component.universe_design.toast.UDToast;
import io.reactivex.disposables.CompositeDisposable;
import ju4.e;
import ju4.f;
import ju4.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import s45.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0011\u0018\u0000 i2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001iB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000201H\u0016J\u0012\u0010C\u001a\u0002012\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010F\u001a\u000201H\u0002J&\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u001a\u0010M\u001a\u0002012\u0006\u0010N\u001a\u00020H2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010O\u001a\u000201H\u0016J\b\u0010P\u001a\u000201H\u0016J\b\u0010Q\u001a\u000201H\u0002J\u0010\u0010R\u001a\u0002012\u0006\u0010S\u001a\u000208H\u0002J\b\u0010T\u001a\u000201H\u0002J\u0010\u0010U\u001a\u0002012\u0006\u0010V\u001a\u00020WH\u0002J\u0018\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020W2\u0006\u0010[\u001a\u000204H\u0002J\u0006\u0010\\\u001a\u00020YJ\b\u0010]\u001a\u000208H\u0016J\u0012\u0010^\u001a\u0002012\b\u0010_\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010`\u001a\u0002012\b\u0010a\u001a\u0004\u0018\u00010@H\u0016J\n\u0010b\u001a\u0004\u0018\u00010HH\u0016J\u0012\u0010c\u001a\u0002012\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010d\u001a\u0002012\u0006\u0010e\u001a\u00020\u0007H\u0002J\b\u0010f\u001a\u000201H\u0016J\b\u0010g\u001a\u000201H\u0002J\b\u0010h\u001a\u000201H\u0002R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00010%8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010+8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "<init>", "()V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "emptyStateFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getEmptyStateFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setEmptyStateFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "applyProFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getApplyProFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setApplyProFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "inputNoteFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getInputNoteFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setInputNoteFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "inputTipsFromXml", "Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;", "getInputTipsFromXml", "()Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;", "setInputTipsFromXml", "(Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;)V", "useProTipsFromXml", "Landroid/widget/TextView;", "getUseProTipsFromXml", "()Landroid/widget/TextView;", "setUseProTipsFromXml", "(Landroid/widget/TextView;)V", "applyPermissionLayoutFromXml", "Landroid/widget/LinearLayout;", "getApplyPermissionLayoutFromXml", "()Landroid/widget/LinearLayout;", "setApplyPermissionLayoutFromXml", "(Landroid/widget/LinearLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "ownerName", "", "ownerId", "token", "skipHostSoftInputModeChange", "", "fetcher", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProFetcher;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "customBackDrawable", "Landroid/graphics/drawable/Drawable;", "customBackListener", "Landroid/view/View$OnClickListener;", "visibleListener", "Lcom/bytedance/ee/permission/view/IViewVisibleListener;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseArguments", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "initView", "updateApplyLayoutVisibility", "visible", "hideKeyboard", "showToast", "errCode", "", "getDesc", "", "resId", "userKey", "getProDesc", "onBackPressed", "setBackIcon", "drawable", "setBackListener", "listener", "getTitleBar", "setViewVisibleListener", "bindVisibleListener", "titleBar", "onDestroy", "saveSoftInputMode", "revertSoftInputMode", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableApplyProFragment extends BaseFragment implements l, au5.a {
    public static final /* synthetic */ int u = 0;
    public BaseTitleBar e;
    public SpaceEmptyState f;
    public UDButton g;
    public SpaceEditText h;
    public UDTextInputLayout i;
    public TextView j;
    public LinearLayout k;
    public String l;
    public String m;
    public String n;
    public boolean o;
    public BitableApplyProFetcher p;
    public final CompositeDisposable q;
    public Drawable r;
    public View.OnClickListener s;
    public au5.b t;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BitableApplyProFragment a;

        public b(BitableApplyProFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (this.a.m.length() <= 0) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == false) goto L9;
            ((k) org.koin.java.a.c(k.class, null, null, 6)).e(this.a.m, "");
            int r5 = d.a;
            JSONObject r6 = new JSONObject();
            r6.put("click", "owner_name");
            r6.put("target", "none");
            d.b("ccm_bitable_premium_permission_application_click", r6);
            return;
        L9:
            return;
        L5:
            r4 = false;
            goto L6
        }
    }

    static {
    }

    public final /* synthetic */ View NW() {
        return null;
    }

    public final SpaceEditText X90() {
        View r0 = this.h;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131375388);
    L8:
        this.h = (SpaceEditText) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (SpaceEditText) r0;
    }

    public final BaseTitleBar Y90() {
        View r0 = this.e;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131388807);
    L8:
        this.e = (BaseTitleBar) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (BaseTitleBar) r0;
    }

    public final TextView Z90() {
        View r0 = this.j;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131391978);
    L8:
        this.j = (TextView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (TextView) r0;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        int r0 = c.a;
        int r1 = n.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.apply_pro_back_press_fix_enable") == false) goto L6;
        return false;
    L6:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L11;
        r2.finish();
        return true;
    L11:
        return true;
    }

    public BitableApplyProFragment() {
        this.l = "";
        this.m = "";
        this.n = "";
        this.q = new CompositeDisposable();
    }

    public final View getTitleBar() {
        return Y90();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        this.q.dispose();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
    }

    public final void onPause() {
        super.onPause();
        if (this.o == false) goto L5;
        this.o = false;
        return;
    L5:
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L10;
        Intent r1 = r0.getIntent();
        if (r1 == null) goto L10;
        int r2 = r1.getIntExtra("softInputMode", -1);
    L11:
        if (r2 == (-1)) goto L19;
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L20;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L21;
        r4.setSoftInputMode(r2);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r2 = -1;
        goto L11
    }

    public final void onResume() {
        super.onResume();
        boolean r0 = ForsetiHelper.x(this);
        this.o = r0;
        if (r0 == true) goto L32;
        FragmentActivity r1 = getActivity();
        int r2 = -1;
        if (r1 == null) goto L10;
        Intent r3 = r1.getIntent();
        if (r3 == null) goto L10;
        int r4 = r3.getIntExtra("softInputMode", -1);
    L11:
        if (r4 != (-1)) goto L24;
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L19;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L19;
        WindowManager.LayoutParams r7 = r6.getAttributes();
        if (r7 == null) goto L19;
        r2 = r7.softInputMode;
    L19:
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L24;
        Intent r9 = r8.getIntent();
        if (r9 == null) goto L24;
        r9.putExtra("softInputMode", r2);
    L24:
        FragmentActivity r10 = getActivity();
        if (r10 == null) goto L30;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L31;
        r11.setSoftInputMode(32);
        return;
    L31:
        return;
    L30:
        return;
    L10:
        r4 = -1;
        goto L11
    }

    public final void mY(au5.b r1) {
        this.t = r1;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        String r0 = "";
        if (r4 == null) goto L6;
        String r5 = r4.getString("owner_name", "");
        if (r5 == null) goto L6;
    L7:
        this.l = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L11;
        String r7 = r6.getString("owner_id", "");
        if (r7 == null) goto L11;
    L12:
        this.m = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L18;
        String r9 = r8.getString("token", "");
        if (r9 == null) goto L18;
        r0 = r9;
    L18:
        this.n = r0;
        this.p = new BitableApplyProFetcher(this.n);
        return;
    L11:
        r7 = "";
    L6:
        r5 = "";
        goto L7
    }

    public final void setBackIcon(Drawable r2) {
        this.r = r2;
        if (r2 == null) goto L10;
        BaseTitleBar r0 = Y90();
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
        this.s = r2;
        BaseTitleBar r0 = Y90();
        if (r0 == null) goto L6;
        r0.setLeftClickListener(r2);
        return;
    }

    public static final void U90(BitableApplyProFragment r1, int r2) {
        Context r3 = r1.getContext();
        if (r3 != null) goto L5;
        tt5.a.d("BitableApplyProFragment", "context is null");
        return;
    L5:
        if (r2 != 0) goto L7;
        int r0 = 2131886173;
    L14:
        if (r2 != 0) goto L16;
        int r4 = 2131256306;
    L17:
        UDToast.show(r3, r0, r4);
        return;
    L16:
        r4 = 2131255144;
        goto L17
    L7:
        if (r2 != 800004006) goto L9;
        r0 = 2131886171;
        goto L14
    L9:
        if (r2 == 800004106) goto L11;
        r0 = 2131886172;
        goto L14
    L11:
        r0 = 2131886170;
        goto L14
    }

    public static final void V90(BitableApplyProFragment r3, boolean r4) {
        View r0 = r3.k;
        View r1 = null;
        if (r0 != null) goto L9;
        View r2 = r3.getView();
        if (r2 == null) goto L7;
        r0 = r2.findViewById(2131363192);
    L8:
        r3.k = (LinearLayout) r0;
        goto L9
    L7:
        r0 = null;
    L9:
        LinearLayout r5 = (LinearLayout) r0;
        if (r4 == false) goto L12;
        int r6 = 0;
    L13:
        r5.setVisibility(r6);
        if (r4 == false) goto L16;
        CharSequence r7 = r3.W90(2131886175, "userName");
    L17:
        View r8 = r3.f;
        if (r8 != null) goto L23;
        View r9 = r3.getView();
        if (r9 == null) goto L22;
        r1 = r9.findViewById(2131371597);
    L22:
        r3.f = (SpaceEmptyState) r1;
        r8 = r1;
    L23:
        ((SpaceEmptyState) r8).setDesc(r7);
        return;
    L16:
        r7 = r3.W90(2131886242, "name");
        goto L17
    L12:
        r6 = 8;
        goto L13
    }

    public final CharSequence W90(int r8, String r9) {
        String r6 = this.l;
        String r10 = xo5.a.c(getContext(), r8, r9, r6);
        if (r6.length() <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L13;
        SpannableStringBuilder r12 = new SpannableStringBuilder();
        r12.append(r10);
        Intrinsics.checkNotNull(r10);
        int r0 = StringsKt.indexOf$default(r10, r6, 0, false, 6, null);
        int r1 = r6.length() + r0;
        if (r0 < 0) goto L13;
        if (r1 > r10.length()) goto L13;
        r12.setSpan(new UDEmptyState.b(new b(this)), r0, r1, 34);
        return r12;
    L13:
        Intrinsics.checkNotNull(r10);
        return r10;
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        BitableApplyProFetcher r13 = this.p;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fetcher");
        r13 = null;
    L5:
        this.q.add(r13.b().subscribe(new com.bytedance.ee.bear.bitable.pro.applypro.a(this), new h(this)));
        boolean r0 = false;
        Y90().setDividerVisible(false);
        BaseTitleBar r14 = Y90();
        Drawable r1 = this.r;
        if (r1 == null) goto L10;
        ImageView r2 = r14.getLeftImage();
        if (r2 == null) goto L10;
        r2.setImageDrawable(r1);
    L10:
        View.OnClickListener r3 = this.s;
        if (r3 != null) goto L13;
        r3 = new ju4.d(this);
    L13:
        r14.setLeftClickListener(r3);
        if (r14.isAttachedToWindow() == false) goto L18;
        au5.b r4 = this.t;
        if (r4 == null) goto L18;
        r4.a(true);
    L18:
        r14.addOnAttachStateChangeListener(new ju4.a(this, r14));
        View r16 = this.f;
        if (r16 != null) goto L25;
        View r17 = getView();
        if (r17 == null) goto L23;
        r16 = r17.findViewById(2131371597);
    L24:
        this.f = (SpaceEmptyState) r16;
        goto L25
    L23:
        r16 = null;
    L25:
        ((SpaceEmptyState) r16).setDesc(W90(2131886175, "userName"));
        View r18 = this.g;
        if (r18 != null) goto L32;
        View r19 = getView();
        if (r19 == null) goto L30;
        r18 = r19.findViewById(2131363193);
    L31:
        this.g = (UDButton) r18;
        goto L32
    L30:
        r18 = null;
    L32:
        ((UDButton) r18).setOnClickListener(new e(this));
        X90().setOnFocusChangeListener(f.a);
        X90().addTextChangedListener(new ju4.c(this));
        int r110 = com.bytedance.ee.bear.bitable.pro.e.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("base.advanced_permission.role_inheritance") == false) goto L50;
        Z90().setVisibility(0);
        TextView r111 = Z90();
        Context r5 = getContext();
        if (r5 == null) goto L38;
        String r6 = r5.getString(2131886218);
        if (r6 == null) goto L38;
    L39:
        String r9 = xo5.a.c(getContext(), 2131886219, "docName", r6);
        s45.h r7 = g.a;
        String r112 = g.a.b("173353144094", "067313445121", null);
        if (r6.length() <= 0) goto L42;
        r0 = true;
    L42:
        if (r0 == false) goto L48;
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        r8.append(r9);
        Intrinsics.checkNotNull(r9);
        int r10 = StringsKt.indexOf$default(r9, r6, 0, false, 6, null);
        int r20 = r6.length() + r10;
        if (r10 < 0) goto L48;
        if (r20 > r9.length()) goto L48;
        r8.setSpan(new UDEmptyState.b(new ju4.b(r112)), r10, r20, 34);
        CharSequence r21 = r8;
    L49:
        r111.setText(r21);
        Z90().setMovementMethod(LinkMovementMethod.getInstance());
    L48:
        Intrinsics.checkNotNull(r9);
        r21 = r9;
    L38:
        r6 = "";
    L50:
        View r113 = getView();
        if (r113 == null) goto L53;
        r113.setOnClickListener(new ju4.g(this));
    L53:
        int r114 = d.a;
        d.b("ccm_bitable_premium_permission_application_view", new JSONObject());
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131558807, r3, false);
    }
}
