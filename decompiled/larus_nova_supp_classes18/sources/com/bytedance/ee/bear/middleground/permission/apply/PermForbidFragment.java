package com.bytedance.ee.bear.middleground.permission.apply;

import android.R;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannedString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010/\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\u0012H\u0002J\b\u00103\u001a\u00020.H\u0002J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u0002052\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010<\u001a\u00020=H\u0002J\u0012\u0010>\u001a\u00020\u00122\b\u0010?\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010@\u001a\u00020\u00122\b\u0010A\u001a\u0004\u0018\u00010,H\u0016J\n\u0010B\u001a\u0004\u0018\u000105H\u0016J\u0012\u0010C\u001a\u00020\u00122\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\n\u0010F\u001a\u0004\u0018\u000105H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/PermForbidFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "<init>", "()V", "permissionTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getPermissionTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setPermissionTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "noDataEmptyStateFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getNoDataEmptyStateFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setNoDataEmptyStateFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "clearFromXmlViewCache", "", "onDestroyView", "isShowMasterTips", "", "masterTipsId", "", "isShowSlaveTips", "slaveTipsId", "isBackVisible", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "subType", "fromVc", "isWiki", "module", "userPerm", "publicPerm", "forbidden", "isSecretFile", "permCode", "viewPerceive", "fromDocxInBase", "customBackDrawable", "Landroid/graphics/drawable/Drawable;", "customBackListener", "Landroid/view/View$OnClickListener;", "forbidUiConfig", "Lcom/bytedance/ee/bear/middleground/permission/apply/PermissionForbidUiConfig;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseArgs", "resolveForbidUiConfig", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "getOwnerText", "Landroid/text/Spanned;", "setBackIcon", "drawable", "setBackListener", "listener", "getTitleBar", "setViewVisibleListener", "visibleListener", "Lcom/bytedance/ee/permission/view/IViewVisibleListener;", "getTitleTipExtra", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermForbidFragment extends BaseFragment implements au5.a {
    public static final /* synthetic */ int C = 0;
    public j1 A;
    public au5.b B;
    public BaseTitleBar e;
    public SpaceEmptyState f;
    public boolean g;
    public int h;
    public boolean i;
    public int j;
    public boolean k;
    public String l;
    public int m;
    public String n;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public String s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public Drawable y;
    public View.OnClickListener z;

    public static final class a {
        @JvmStatic
        public static PermForbidFragment a(FragmentManager r8, int r9, boolean r10, int r11, boolean r12, int r13, boolean r14, String r15, int r16, String r17, boolean r18, boolean r19, String r20, String r21, String r22, boolean r23, boolean r24, boolean r25, Boolean r26, int r27) {
            Intrinsics.checkNotNullParameter(r8, "fm");
            Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r20, "module");
            Intrinsics.checkNotNullParameter(r21, "userPerm");
            PermForbidFragment r3 = new PermForbidFragment();
            Bundle r5 = new Bundle();
            r5.putBoolean("extra_is_show_master_tips", r10);
            r5.putInt("extra_master_tips", r11);
            r5.putBoolean("extra_is_show_slave_tips", r12);
            r5.putInt("extra_slave_tips", r13);
            r5.putBoolean("extra_is_back_visible", r14);
            r5.putString("extra_token", r15);
            r5.putInt("extra_type", r16);
            String r0 = "";
            if (r17 != null) goto L5;
            String r6 = "";
        L6:
            r5.putString("extra_sub_type", r6);
            r5.putBoolean("extra_from_vc", r18);
            r5.putBoolean("extra_is_wiki", r19);
            r5.putString("extra_module", r20);
            r5.putString("extra_user_perm", r21);
            if (r22 == null) goto L10;
            r0 = r22;
        L10:
            r5.putString("extra_public_perm", r0);
            r5.putInt("extra_perm_code", r27);
            r5.putBoolean("extra_view_perceive", r23);
            r5.putBoolean("extra_view_forbidden", r24);
            r5.putBoolean("extra_view_secret", r25);
            if (r26 == null) goto L13;
            boolean r1 = r26.booleanValue();
        L14:
            r5.putBoolean("extra_from_docxinbase", r1);
            r3.setArguments(r5);
            FragmentTransaction r2 = r8.beginTransaction();
            if (r9 != (-1)) goto L17;
            int r4 = R.id.content;
        L19:
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r4) == true) goto L22;
            r2 = r2.replace(r4, r3);
        L22:
            r2.commitAllowingStateLoss();
            return r3;
        L17:
            r4 = r9;
            goto L19
        L13:
            r1 = false;
            goto L14
        L5:
            r6 = r17;
            goto L6
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PermForbidFragment a;

        public b(PermForbidFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            FragmentActivity r10 = this.a.getActivity();
            if (r10 == null) goto L5;
            r10.onBackPressed();
        L5:
            PermForbidFragment r11 = this.a;
            com.bytedance.ee.bear.middleground.permission.c.D(r11.l, r11.m, r11.n, r11.o, r11.p, r11.q, r11.r, r11.s);
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ PermForbidFragment a;

        public c(PermForbidFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            au5.b r3 = this.a.B;
            if (r3 == null) goto L5;
            r3.a(true);
        L5:
            tt5.a.h("PermForbidFragment", "onViewAttachedToWindow true");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            au5.b r3 = this.a.B;
            if (r3 == null) goto L5;
            r3.a(false);
        L5:
            BaseTitleBar r4 = this.a.V90();
            if (r4 == null) goto L8;
            r4.removeOnAttachStateChangeListener(this);
        L8:
            tt5.a.h("PermForbidFragment", "onViewDetachedFromWindow false");
        }
    }

    static {
    }

    public final SpaceEmptyState U90() {
        UDEmptyState r0 = this.f;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131380922);
    L8:
        this.f = (SpaceEmptyState) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (SpaceEmptyState) r0;
    }

    public final BaseTitleBar V90() {
        View r0 = this.e;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131382173);
    L8:
        this.e = (BaseTitleBar) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (BaseTitleBar) r0;
    }

    public PermForbidFragment() {
        this.g = true;
        this.h = -1;
        this.i = true;
        this.j = -1;
        this.k = true;
        this.l = "";
        this.n = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.v = -1;
        this.A = new j1(0);
    }

    public final View NW() {
        View r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131382174);
    }

    public final View getTitleBar() {
        return V90();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
        this.f = null;
    }

    public final void mY(au5.b r1) {
        this.B = r1;
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        Bundle r0 = getArguments();
        boolean r1 = true;
        if (r0 == null) goto L5;
        boolean r2 = r0.getBoolean("extra_is_show_master_tips", true);
    L6:
        this.g = r2;
        Bundle r3 = getArguments();
        int r4 = -1;
        if (r3 == null) goto L9;
        int r5 = r3.getInt("extra_master_tips", -1);
    L10:
        this.h = r5;
        Bundle r7 = getArguments();
        if (r7 == null) goto L13;
        boolean r8 = r7.getBoolean("extra_is_show_slave_tips", true);
    L14:
        this.i = r8;
        Bundle r9 = getArguments();
        if (r9 == null) goto L17;
        int r10 = r9.getInt("extra_slave_tips", -1);
    L18:
        this.j = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L21;
        r1 = r11.getBoolean("extra_is_back_visible", true);
    L21:
        this.k = r1;
        Bundle r12 = getArguments();
        if (r12 == null) goto L24;
        boolean r13 = r12.getBoolean("extra_view_secret", false);
    L25:
        this.u = r13;
        Bundle r14 = getArguments();
        String r15 = "";
        if (r14 == null) goto L29;
        String r16 = r14.getString("extra_token", "");
        if (r16 == null) goto L29;
    L30:
        this.l = r16;
        Bundle r17 = getArguments();
        if (r17 == null) goto L33;
        int r18 = r17.getInt("extra_type", 0);
    L34:
        this.m = r18;
        Bundle r19 = getArguments();
        if (r19 == null) goto L38;
        String r20 = r19.getString("extra_sub_type", "");
        if (r20 == null) goto L38;
    L39:
        this.n = r20;
        Bundle r21 = getArguments();
        if (r21 == null) goto L42;
        boolean r22 = r21.getBoolean("extra_from_vc", false);
    L43:
        this.o = r22;
        Bundle r23 = getArguments();
        if (r23 == null) goto L46;
        boolean r24 = r23.getBoolean("extra_is_wiki", false);
    L47:
        this.p = r24;
        Bundle r25 = getArguments();
        if (r25 == null) goto L51;
        String r26 = r25.getString("extra_module", "");
        if (r26 == null) goto L51;
    L52:
        this.q = r26;
        Bundle r27 = getArguments();
        if (r27 == null) goto L56;
        String r28 = r27.getString("extra_user_perm");
        if (r28 == null) goto L56;
    L57:
        this.r = r28;
        Bundle r29 = getArguments();
        if (r29 == null) goto L63;
        String r30 = r29.getString("extra_public_perm", "");
        if (r30 == null) goto L63;
        r15 = r30;
    L63:
        this.s = r15;
        Bundle r31 = getArguments();
        if (r31 == null) goto L66;
        boolean r32 = r31.getBoolean("extra_view_perceive", false);
    L67:
        this.w = r32;
        Bundle r33 = getArguments();
        if (r33 == null) goto L70;
        boolean r34 = r33.getBoolean("extra_view_forbidden", false);
    L71:
        this.t = r34;
        Bundle r35 = getArguments();
        if (r35 == null) goto L74;
        boolean r36 = r35.getBoolean("extra_from_docxinbase", false);
    L75:
        this.x = r36;
        Bundle r37 = getArguments();
        if (r37 == null) goto L78;
        r4 = r37.getInt("extra_perm_code", -1);
    L78:
        this.v = r4;
        j1 r38 = ((c0) org.koin.java.a.c(c0.class, null, null, 6)).c();     // Catch: Throwable -> L81
    L83:
        this.A = r38;
        tt5.a.h("PermForbidFragment", "isShowMasterTips: " + this.g + ", isShowSlaveTips: " + this.i + ", isBackVisible: " + this.k + "permCode: " + this.v);
        return;
    L81:
        th = move-exception;
        tt5.a.e("PermForbidFragment", "resolve forbid ui config failed, fallback default", th, false);
        r38 = new j1(0);
        goto L83
    L74:
        r36 = false;
        goto L75
    L70:
        r34 = false;
        goto L71
    L66:
        r32 = false;
    L56:
        r28 = "";
    L51:
        r26 = "";
        goto L52
    L46:
        r24 = false;
        goto L47
    L42:
        r22 = false;
    L38:
        r20 = "";
        goto L39
    L33:
        r18 = 0;
    L29:
        r16 = "";
        goto L30
    L24:
        r13 = false;
        goto L25
    L17:
        r10 = -1;
        goto L18
    L13:
        r8 = true;
        goto L14
    L9:
        r5 = -1;
        goto L10
    L5:
        r2 = true;
        goto L6
    }

    public final void setBackIcon(Drawable r1) {
        this.y = r1;
    }

    public final void setBackListener(View.OnClickListener r1) {
        this.z = r1;
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        V90().setDividerVisible(false);
        V90().setLeftIconVisibility(this.k);
        if (this.v != 2004) goto L5;
        boolean r14 = true;
    L7:
        if (this.w == false) goto L9;
        V90().setVisibility(4);
        U90().setImageRes(Integer.valueOf(this.A.b));
    L20:
        if (this.x == false) goto L22;
        V90().setVisibility(8);
    L22:
        float r1 = (getResources().getDimension(2131169381) * 2) + getResources().getDimension(2131168381);
        ViewGroup.LayoutParams r3 = U90().getLayoutParams();
        r3.width = (int) r1;
        U90().setLayoutParams(r3);
        int r2 = this.h;
        if (r2 != (-1)) goto L26;
        r2 = 2131888048;
    L26:
        U90().setTitle(r12.getContext().getString(r2));
        U90().showTitle(this.g);
        if (this.u == false) goto L30;
        U90().setPadding(y9c.d.a(42), 0, y9c.d.a(42), 0);
    L30:
        if (this.t == false) goto L33;
        if (r14 == true) goto L33;
        U90().setDesc(r12.getContext().getString(2131888713));
        U90().setImageRes(Integer.valueOf(this.A.d));
    L45:
        U90().showDescription(this.i);
        if (this.y == null) goto L51;
        ImageView r15 = V90().getLeftImage();
        if (r15 == null) goto L51;
        r15.setImageDrawable(this.y);
    L51:
        if (this.z == null) goto L53;
        V90().setLeftClickListener(this.z);
    L54:
        com.bytedance.ee.bear.middleground.permission.c.X(this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s);
        if (V90().isAttachedToWindow() == false) goto L59;
        tt5.a.h("PermForbidFragment", "permission_title_bar isAttachedToWindow");
        au5.b r16 = this.B;
        if (r16 == null) goto L59;
        r16.a(true);
    L59:
        V90().addOnAttachStateChangeListener(new c(this));
        return;
    L53:
        V90().setLeftClickListener(new b(this));
    L33:
        SpaceEmptyState r17 = U90();
        if (this.j == (-1)) goto L36;
        CharSequence r18 = r12.getContext().getString(this.j);
    L44:
        r17.setDesc(r18);
        goto L45
    L36:
        com.bytedance.ee.bear.contract.h0 r19 = (com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6);
        String r0 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).a();
        AccountService.Account r110 = r19.G2();
        if (r110 == null) goto L43;
        String r4 = ou5.a.d(r0, r110.displayName, r110.userName, r110.enName);
        if (r110.isConsumer() == false) goto L41;
        String r111 = getString(2131888107);
    L42:
        r18 = Html.fromHtml(xo5.a.c(getContext(), 2131888083, "user", b0.a(r111 + '-' + r4)));
        goto L44
    L41:
        r111 = r110.tenantName;
        goto L42
    L43:
        r18 = new SpannedString("");
        goto L44
    L9:
        if (r14 == false) goto L13;
        V90().setVisibility(0);
        SpaceEmptyState r5 = U90();
        if (r5 == null) goto L20;
        r5.setImageRes(Integer.valueOf(this.A.b));
        goto L20
    L13:
        BaseTitleBar r6 = V90();
        if (r6 == null) goto L16;
        r6.setVisibility(0);
    L16:
        SpaceEmptyState r7 = U90();
        if (r7 == null) goto L20;
        r7.setImageRes(Integer.valueOf(this.A.c));
        goto L20
    L5:
        r14 = false;
        goto L7
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        return r4.inflate(this.A.a, r5, false);
    L5:
        th = move-exception;
        tt5.a.e("PermForbidFragment", "inflate forbid page failed, fallback default layout", th, false);
        return r4.inflate(2131564182, r5, false);
    }
}
