package com.bytedance.ee.bear.document.customheader;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005*\u0001&\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u00132\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00102\u001a\u00020)H\u0016J\b\u00103\u001a\u00020\"H\u0016J\u0012\u00104\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0018\u00107\u001a\u00020)2\u0006\u00101\u001a\u00020\u00132\u0006\u00108\u001a\u00020\"H\u0002J*\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\"2\b\u0010;\u001a\u0004\u0018\u00010\u00112\u0006\u0010<\u001a\u00020\u001d2\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020AH\u0002J \u0010B\u001a\u00020\u00162\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH\u0002J \u0010E\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u001a\u0010F\u001a\u00020)2\b\b\u0001\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\"H\u0002J%\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010NH\u0002¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u00020)H\u0002J\u000e\u0010!\u001a\u00020)2\u0006\u0010Q\u001a\u00020\"R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\"\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006S"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/OfficeCustomHeaderFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "officeCustomHeaderViewModel", "Lcom/bytedance/ee/bear/document/customheader/OfficeCustomHeaderViewModel;", "statusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "titleContainer", "Landroid/widget/LinearLayout;", "titleBarWrapper", "Landroid/view/View;", "btnTitleBg", "titleView", "Landroid/widget/TextView;", "titleColor", "", "leftMenuContainer", "Landroid/view/ViewGroup;", "rightMenuContainer", "syncIcon", "Landroid/widget/ImageView;", "viewIcon", "arrowIcon", "syncAnimator", "Landroid/animation/ObjectAnimator;", "divider", "menuSize", "", "leftMenuMargin", "rightMenuMargin", "businessExtraId", "disableTitleCenter", "", "statusBarColorStore", "Lkotlin/Pair;", "statusBarInterceptor", "com/bytedance/ee/bear/document/customheader/OfficeCustomHeaderFragment$statusBarInterceptor$1", "Lcom/bytedance/ee/bear/document/customheader/OfficeCustomHeaderFragment$statusBarInterceptor$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "onDestroyView", "onBackPressed", "updateView", "data", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig;", "setViewAndChildrenEnabled", "enabled", "decorateTitle", "decorate", "name", "iconResource", "clickListener", "Landroid/view/View$OnClickListener;", "handleBusinessLogic", "menu", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$Menu;", "createMenuIconView", "menuMarginLeft", "menuMarginRight", "createMenuTextView", "setStatusBarColor", "statusBarColor", "lightStatusBar", "getColors", "", "context", "Landroid/content/Context;", "customColor", "", "(Landroid/content/Context;[Ljava/lang/String;)[I", "makeTitleCenter", SimpleItemModel.ITEM_STYLE_DISABLE, "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCustomHeaderFragment extends BaseFragment implements l {
    public static final /* synthetic */ int y = 0;
    public OfficeCustomHeaderViewModel e;
    public xu5.b.a f;
    public LinearLayout g;
    public View h;
    public LinearLayout i;
    public TextView j;
    public String k;
    public ViewGroup l;
    public ViewGroup m;
    public ImageView n;
    public ImageView o;
    public ImageView p;
    public ObjectAnimator q;
    public View r;
    public int s;
    public int t;
    public int u;
    public String v;
    public Pair<Integer, Boolean> w;
    public final f x;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ OfficeCustomHeaderFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CustomHeaderConfig.Menu c;

        public b(OfficeCustomHeaderFragment r1, String r2, CustomHeaderConfig.Menu r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            OfficeCustomHeaderViewModel r4 = this.a.e;
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
            r4 = null;
        L5:
            OfficeCustomHeaderViewModel.a r5 = r4.getDelegate();
            if (r5 == null) goto L9;
            r5.a(this.b, this.c.getExtraId());
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CustomHeaderConfig.Menu a;
        public final /* synthetic */ OfficeCustomHeaderFragment b;

        public c(CustomHeaderConfig.Menu r1, OfficeCustomHeaderFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            String r4 = this.a.getId();
            if (r4 == null) goto L11;
            OfficeCustomHeaderFragment r0 = this.b;
            CustomHeaderConfig.Menu r1 = this.a;
            OfficeCustomHeaderViewModel r2 = r0.e;
            if (r2 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
            r2 = null;
        L7:
            OfficeCustomHeaderViewModel.a r5 = r2.getDelegate();
            if (r5 == null) goto L12;
            r5.a(r4, r1.getExtraId());
            return;
        L12:
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ OfficeCustomHeaderFragment a;

        public d(OfficeCustomHeaderFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeCustomHeaderFragment r0 = this.a;     // Catch: Throwable -> L4
            int r1 = OfficeCustomHeaderFragment.y;     // Catch: Throwable -> L4
            r0.X90();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ OfficeCustomHeaderFragment a;

        public e(OfficeCustomHeaderFragment r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onChanged(Object r18) {
            CustomHeaderConfig r0 = (CustomHeaderConfig) r18;
            OfficeCustomHeaderFragment r2 = this.a;
            int r3 = OfficeCustomHeaderFragment.y;
            r2.getClass();
            boolean r5 = true;
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ui_state_fix_enable") == false) goto L32;
            tt5.a.h("CustomHeaderFragment", "ui state fix enable is on");
            OfficeCustomHeaderViewModel r4 = r2.e;
            if (r4 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
            r4 = null;
        L7:
            Integer r6 = r4.getHeaderHeight();
            if (r6 != null) goto L10;
        L18:
            int r7 = r2.getResources().getDimensionPixelSize(2131165837);
        L19:
            View r9 = r2.h;
            if (r9 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("titleBarWrapper");
            r9 = null;
        L23:
            if (r9.getLayoutParams().height == r7) goto L31;
            View r10 = r2.h;
            if (r10 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("titleBarWrapper");
            r10 = null;
        L27:
            r10.getLayoutParams().height = r7;
            View r8 = r2.h;
            if (r8 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("titleBarWrapper");
            r8 = null;
        L30:
            r8.requestLayout();
        L31:
            Unit r11 = Unit.INSTANCE;
        L52:
            if (r0 == null) goto L282;
            String r12 = r0.getThemeColor();
            if (r12 == null) goto L65;
            int r13 = ColorUtils.h(r12);
            boolean r14 = ColorUtils.f(r13);
            View r16 = r2.getView();
            if (r16 == null) goto L58;
            r16.setBackgroundColor(r13);
            Unit r17 = Unit.INSTANCE;
        L58:
            if (r14 == false) goto L60;
            String r19 = CustomHeaderConfig.COLOR_LIGHT;
        L61:
            r2.k = r19;
            boolean r20 = !r14;
            bp5.c.c(r2.getActivity(), r2.x);
            xu5.b.a r21 = r2.f;
            if (r21 == null) goto L64;
            r21.b(r13, r20);
        L64:
            bp5.c.b(r2.getActivity(), r2.x);
            Unit r22 = Unit.INSTANCE;
            goto L65
        L60:
            r19 = CustomHeaderConfig.COLOR_DARK;
        L65:
            ViewGroup r23 = r2.l;
            if (r23 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
            r23 = null;
        L68:
            r23.removeAllViews();
            ViewGroup r24 = r2.m;
            if (r24 != null) goto L71;
            Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
            r24 = null;
        L71:
            r24.removeAllViews();
            CustomHeaderConfig.MenuItems r26 = r0.getItems();
            if (r26 == null) goto L113;
            CustomHeaderConfig.Menu[] r110 = r26.getLeft();
            if (r110 == null) goto L93;
            int r111 = r110.length;
            int r112 = 0;
        L76:
            if (r112 >= r111) goto L92;
            CustomHeaderConfig.Menu r113 = r110[r112];
            if (r113.getId() == null) goto L91;
            if (Intrinsics.areEqual(r113.getStyle(), "text") == false) goto L83;
            int r114 = r2.t;
            View r115 = r2.V90(r113, r114, r114);
        L84:
            int r116 = com.bytedance.ee.bear.document.customheader.b.a;
            if (Intrinsics.areEqual("docx_embedded_history_exit", r113.getExtraId()) == false) goto L87;
            r2.v = r113.getExtraId();
        L87:
            ViewGroup r27 = r2.l;
            if (r27 != null) goto L90;
            Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
            r27 = null;
        L90:
            r27.addView(r115);
            goto L91
        L83:
            int r117 = r2.t;
            r115 = r2.U90(r113, r117, r117);
        L91:
            r112 = r112 + 1;
            goto L76
        L92:
            Unit r28 = Unit.INSTANCE;
        L93:
            CustomHeaderConfig.Menu[] r29 = r26.getRight();
            if (r29 == null) goto L113;
            int r30 = r29.length;
            int r31 = 0;
            boolean r32 = true;
        L96:
            if (r31 >= r30) goto L112;
            CustomHeaderConfig.Menu r118 = r29[r31];
            if (r118.getId() == null) goto L111;
            if (r32 == false) goto L102;
            int r33 = r2.u;
            boolean r119 = false;
        L104:
            if (Intrinsics.areEqual(r118.getStyle(), "text") == false) goto L106;
            View r34 = r2.V90(r118, r33, r2.u);
        L107:
            ViewGroup r120 = r2.m;
            if (r120 != null) goto L110;
            Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
            r120 = null;
        L110:
            r120.addView(r34);
            r32 = r119;
            goto L111
        L106:
            r34 = r2.U90(r118, r33, r2.u);
            goto L107
        L102:
            r119 = r32;
            r33 = 0;
        L111:
            r31 = r31 + 1;
            goto L96
        L112:
            Unit r36 = Unit.INSTANCE;
        L113:
            CustomHeaderConfig.TitleConfig r37 = r0.getTitleConfig();
            if (r37 != null) goto L116;
        L118:
            boolean r38 = false;
        L120:
            if (r38 == false) goto L129;
            LinearLayout r39 = r2.i;
            if (r39 != null) goto L124;
            Intrinsics.throwUninitializedPropertyAccessException("btnTitleBg");
            r39 = null;
        L124:
            Context r40 = r2.getContext();
            if (r40 == null) goto L127;
            Drawable r41 = AppCompatResources.getDrawable(r40, 2131232424);
        L128:
            r39.setBackground(r41);
        L133:
            Context r42 = r2.getContext();
            if (r42 == null) goto L148;
            TextView r43 = r2.j;
            if (r43 != null) goto L138;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r43 = null;
        L138:
            CustomHeaderConfig.TitleConfig r44 = r0.getTitleConfig();
            if (r44 != null) goto L141;
        L143:
            boolean r46 = false;
        L144:
            if (r46 == false) goto L146;
            Typeface r47 = h18.e.b(r42, 1);
        L147:
            r43.setTypeface(r47);
            Unit r48 = Unit.INSTANCE;
            goto L148
        L146:
            r47 = h18.e.b(r42, 0);
            goto L147
        L141:
            if (r44.isBold() != true) goto L143;
            r46 = true;
        L148:
            TextView r49 = r2.j;
            if (r49 != null) goto L151;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r49 = null;
        L151:
            CustomHeaderConfig.TitleConfig r50 = r0.getTitleConfig();
            if (r50 == null) goto L156;
            String r51 = r50.getTitle();
            if (r51 == null) goto L156;
        L157:
            r49.setText(r51);
            CustomHeaderConfig.TitleConfig r52 = r0.getTitleConfig();
            if (r52 == null) goto L160;
            boolean r53 = Intrinsics.areEqual(r52.isLoading(), Boolean.TRUE);
        L162:
            if (r53 == false) goto L182;
            TextView r54 = r2.j;
            if (r54 != null) goto L166;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r54 = null;
        L166:
            r54.setTextColor(r2.getResources().getColor(2131103404));
            ImageView r56 = r2.n;
            if (r56 != null) goto L169;
            Intrinsics.throwUninitializedPropertyAccessException("syncIcon");
            r56 = null;
        L169:
            r56.setVisibility(0);
            ObjectAnimator r57 = r2.q;
            if (r57 != null) goto L173;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r57 = null;
        L173:
            if (r57.isStarted() == false) goto L178;
            ObjectAnimator r58 = r2.q;
            if (r58 != null) goto L177;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r58 = null;
        L177:
            r58.resume();
        L195:
            CustomHeaderConfig.TitleConfig r59 = r0.getTitleConfig();
            if (r59 == null) goto L203;
            String r60 = r59.getPosition();
            if (r60 == null) goto L203;
            if (Intrinsics.areEqual(r60, CustomHeaderConfig.TitleConfig.Position.CENTER) == false) goto L202;
            r2.X90();
        L202:
            Unit r61 = Unit.INSTANCE;
        L203:
            View r62 = r2.r;
            if (r62 != null) goto L207;
            Intrinsics.throwUninitializedPropertyAccessException("divider");
            r62 = null;
        L207:
            if (Intrinsics.areEqual(r0.getShouldShowDivider(), Boolean.TRUE) == false) goto L209;
            int r63 = 0;
        L210:
            r62.setVisibility(r63);
            CustomHeaderConfig.TitleConfig r64 = r0.getTitleConfig();
            if (r64 == null) goto L267;
            ImageView r121 = r2.o;
            if (r121 != null) goto L215;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r121 = null;
        L215:
            Integer r122 = r0.getTitleIcon(r64.getTitleIcon(), r121.getContext());
            if (r122 == null) goto L218;
            int r123 = 0;
            r121.setVisibility(0);
            r121.setImageResource(kac.a.b(r122.intValue()));
        L222:
            Unit r124 = Unit.INSTANCE;
            ImageView r125 = r2.p;
            if (r125 != null) goto L226;
            Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
            r125 = null;
        L226:
            if (r64.getShowFoldBtn() == false) goto L228;
            int r126 = 0;
        L229:
            r125.setVisibility(r126);
            String r127 = r64.getOnboardingKey();
            if (r127 != null) goto L232;
        L235:
            if (r5 == true) goto L241;
            LinearLayout r66 = r2.g;
            if (r66 != null) goto L239;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r66 = null;
        L239:
            r66.setTag(r64.getOnboardingKey());
        L241:
            if (r64.getId() == null) goto L262;
            String r67 = r64.getId();
            if (r67 == null) goto L267;
            LinearLayout r128 = r2.g;
            if (r128 != null) goto L247;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r128 = null;
        L247:
            r128.setOnClickListener(new com.bytedance.ee.bear.document.customheader.c(r2, r67));
            LinearLayout r68 = r2.g;
            if (r68 != null) goto L250;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r68 = null;
        L250:
            boolean r69 = r64.getEnable();
            r68.setEnabled(r69);
            if (r69 == false) goto L253;
            float r129 = 1.0f;
        L254:
            r68.setAlpha(r129);
            int r130 = r68.getChildCount();
        L255:
            if (r123 >= r130) goto L261;
            View r131 = r68.getChildAt(r123);
            r131.setEnabled(r69);
            if (r69 == false) goto L259;
            float r132 = 1.0f;
        L260:
            r131.setAlpha(r132);
            r123 = r123 + 1;
            goto L255
        L259:
            r132 = 0.5f;
            goto L260
        L261:
            Unit r70 = Unit.INSTANCE;
            goto L267
        L253:
            r129 = 0.5f;
            goto L254
        L262:
            LinearLayout r71 = r2.g;
            if (r71 != null) goto L265;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r71 = null;
        L265:
            r71.setOnClickListener(null);
            goto L267
        L232:
            if (r127.length() == 0) goto L235;
            r5 = false;
            goto L235
        L228:
            r126 = 8;
            goto L229
        L218:
            r123 = 0;
            ImageView r133 = r2.o;
            if (r133 != null) goto L221;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r133 = null;
        L221:
            r133.setVisibility(8);
        L267:
            if (r0.getTitleConfig() != null) goto L280;
            ImageView r1 = r2.o;
            if (r1 != null) goto L271;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r1 = null;
        L271:
            r1.setVisibility(8);
            ImageView r72 = r2.p;
            if (r72 != null) goto L274;
            Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
            ImageView r73 = null;
        L275:
            r73.setVisibility(8);
            LinearLayout r74 = r2.g;
            if (r74 != null) goto L278;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            View.OnClickListener r76 = null;
            r74 = null;
        L279:
            r74.setOnClickListener(r76);
        L281:
            Unit r77 = Unit.INSTANCE;
        L283:
            OfficeCustomHeaderViewModel r78 = r2.e;
            if (r78 != null) goto L286;
            Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
            OfficeCustomHeaderViewModel r79 = r76;
        L287:
            r79.getStatusBarDiffHeight().observe(r2, new p05.e(r2));
            View r80 = r2.getView();
            if (r80 == null) goto L300;
            r80.addOnLayoutChangeListener(new p05.f(r2));
            Unit r81 = Unit.INSTANCE;
            return;
        L300:
            return;
        L286:
            r79 = r78;
            goto L287
        L278:
            r76 = null;
            goto L279
        L274:
            r73 = r72;
            goto L275
        L280:
            r76 = null;
            goto L281
        L209:
            r63 = 8;
            goto L210
        L178:
            ObjectAnimator r82 = r2.q;
            if (r82 != null) goto L181;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r82 = null;
        L181:
            r82.start();
            goto L195
        L182:
            TextView r83 = r2.j;
            if (r83 != null) goto L185;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r83 = null;
        L185:
            String r84 = r2.k;
            if (r84 != null) goto L188;
            Intrinsics.throwUninitializedPropertyAccessException("titleColor");
            r84 = null;
        L188:
            r83.setTextColor(ColorUtils.h(r84));
            ImageView r86 = r2.n;
            if (r86 != null) goto L191;
            Intrinsics.throwUninitializedPropertyAccessException("syncIcon");
            r86 = null;
        L191:
            r86.setVisibility(8);
            ObjectAnimator r87 = r2.q;
            if (r87 != null) goto L194;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r87 = null;
        L194:
            r87.cancel();
            goto L195
        L160:
            r53 = false;
        L156:
            r51 = "";
            goto L157
        L127:
            r41 = null;
            goto L128
        L129:
            LinearLayout r88 = r2.i;
            if (r88 != null) goto L132;
            Intrinsics.throwUninitializedPropertyAccessException("btnTitleBg");
            r88 = null;
        L132:
            r88.setBackground(null);
            goto L133
        L116:
            if (r37.getHasBorder() != true) goto L118;
            r38 = true;
            goto L120
        L282:
            r76 = null;
            goto L283
        L10:
            if (r6.intValue() <= 0) goto L12;
            boolean r89 = true;
        L13:
            if (r89 == true) goto L16;
            r6 = null;
        L16:
            if (r6 == null) goto L18;
            r7 = r6.intValue();
            goto L19
        L12:
            r89 = false;
            goto L13
        L32:
            OfficeCustomHeaderViewModel r90 = r2.e;
            if (r90 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
            r90 = null;
        L35:
            Integer r91 = r90.getHeaderHeight();
            if (r91 == null) goto L52;
            if (r91.intValue() <= 0) goto L40;
            boolean r92 = true;
        L41:
            if (r92 == true) goto L44;
            r91 = null;
        L44:
            if (r91 == null) goto L52;
            int r93 = r91.intValue();
            View r94 = r2.h;
            if (r94 != null) goto L48;
            Intrinsics.throwUninitializedPropertyAccessException("titleBarWrapper");
            r94 = null;
        L48:
            r94.getLayoutParams().height = r93;
            View r96 = r2.h;
            if (r96 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("titleBarWrapper");
            r96 = null;
        L51:
            r96.requestLayout();
            Unit r97 = Unit.INSTANCE;
            goto L52
        L40:
            r92 = false;
            goto L41
        }
    }

    public static final class f implements bp5.c.a {
        public final /* synthetic */ OfficeCustomHeaderFragment a;

        public final boolean interceptSetSystemUiVisibility(Activity r1, int r2) {
            return true;
        }

        public f(OfficeCustomHeaderFragment r1) {
            this.a = r1;
        }

        public final boolean interceptSetStatusBarColor(Activity r2, int r3, boolean r4) {
            OfficeCustomHeaderFragment r5 = this.a;
            r5.w = new Pair(Integer.valueOf(r3), Boolean.valueOf(r4));
            return false;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        OfficeCustomHeaderViewModel r0 = this.e;
        OfficeCustomHeaderViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
        r0 = null;
    L5:
        CustomHeaderConfig r2 = (CustomHeaderConfig) r0.getHeaderData().getValue();
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L13;
        return false;
    L13:
        OfficeCustomHeaderViewModel r4 = this.e;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
    L17:
        OfficeCustomHeaderViewModel.a r5 = r1.getDelegate();
        if (r5 == null) goto L20;
        r5.a(CustomHeaderConfig.EXIT_MENU_ID, this.v);
    L20:
        return true;
    L16:
        r1 = r4;
        goto L17
    L8:
        if (r2.getShouldHandleBackPress() == true) goto L10;
        r3 = true;
        goto L11
    }

    public OfficeCustomHeaderFragment() {
        this.x = new f(this);
    }

    public final void X90() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        View r0 = getView();
        if (r0 == null) goto L8;
        int r1 = r0.getWidth();
    L9:
        if (r1 != 0) goto L14;
        tt5.a.h("CustomHeaderFragment", "fragmentWidth is 0, post runnable");
        View r2 = getView();
        if (r2 == null) goto L46;
        r2.post(new d(this));
        return;
    L46:
        return;
    L14:
        TextView r3 = this.j;
        LinearLayout r4 = null;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r3 = null;
    L17:
        r3.setGravity(17);
        getContext();
        if (getContext() == null) goto L47;
        int r5 = View.MeasureSpec.makeMeasureSpec(1073741823, 0);
        ViewGroup r6 = this.l;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
        r6 = null;
    L22:
        r6.measure(r5, r5);
        ViewGroup r7 = this.m;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
        r7 = null;
    L25:
        r7.measure(r5, r5);
        ViewGroup r8 = this.l;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
        r8 = null;
    L28:
        int r9 = r8.getMeasuredWidth();
        ViewGroup r10 = this.m;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
        r10 = null;
    L31:
        int r11 = Math.max(r9, r10.getMeasuredWidth());
        LinearLayout r12 = this.g;
        if (r12 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r12 = null;
    L34:
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if ((r13 instanceof RelativeLayout.LayoutParams) == false) goto L37;
        RelativeLayout.LayoutParams r14 = (RelativeLayout.LayoutParams) r13;
    L38:
        if (r14 == null) goto L40;
        r14.removeRule(17);
        r14.removeRule(16);
        r14.addRule(13, -1);
        r14.width = ((r1 / 2) - r11) * 2;
    L40:
        LinearLayout r16 = this.g;
        if (r16 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    L44:
        r4.setGravity(1);
        return;
    L43:
        r4 = r16;
        goto L44
    L37:
        r14 = null;
        goto L38
    L47:
        return;
    L8:
        r1 = 0;
        goto L9
    }

    public final void onDestroyView() {
        super.onDestroyView();
        Pair<Integer, Boolean> r0 = this.w;
        ObjectAnimator r1 = null;
        if (r0 == null) goto L14;
        Integer r2 = (Integer) r0.getFirst();
        Pair<Integer, Boolean> r3 = this.w;
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.getSecond();
    L8:
        if (r2 == null) goto L17;
        if (r4 == null) goto L17;
        int r5 = r2.intValue();
        boolean r6 = r4.booleanValue();
        bp5.c.c(getActivity(), this.x);
        xu5.b.a r7 = this.f;
        if (r7 == null) goto L13;
        r7.b(r5, r6);
    L13:
        bp5.c.b(getActivity(), this.x);
    L17:
        bp5.c.c(getActivity(), this.x);
        ObjectAnimator r8 = this.q;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
    L21:
        r1.cancel();
        return;
    L20:
        r1 = r8;
        goto L21
    L7:
        r4 = null;
        goto L8
    L14:
        xu5.b.a r9 = this.f;
        if (r9 == null) goto L17;
        r9.resetState();
        goto L17
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        FragmentActivity r5 = getActivity();
        OfficeCustomHeaderViewModel r0 = null;
        if (r5 == null) goto L5;
        xu5.b.a r6 = xu5.b.b(r5, null);
    L6:
        this.f = r6;
        if (r6 == null) goto L9;
        r6.saveState();
    L9:
        OfficeCustomHeaderViewModel r7 = (OfficeCustomHeaderViewModel) q.a(this, OfficeCustomHeaderViewModel.class);
        this.e = r7;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
        r7 = null;
    L12:
        r7.getHeaderData().observe(this, new e(this));
        OfficeCustomHeaderViewModel r8 = this.e;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
    L16:
        r0.isCustomHeaderVisible().observe(this, new AnonymousClass3(this));
        return;
    L15:
        r0 = r8;
        goto L16
    L5:
        r6 = null;
        goto L6
    }

    public final int[] W90(Context r5, String[] r6) {
        int[] r1 = new int[4];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= 4) goto L5;
        r1[r3] = 0;
        r3 = r3 + 1;
        goto L3
    L5:
        if (r6 == null) goto L8;
    L6:
        if (r2 >= 4) goto L9;
        r1[r2] = ColorUtils.h(r6[r2]);
        r2 = r2 + 1;
    L9:
        return r1;
    L8:
        r1[0] = ContextCompat.getColor(r5, 2131105550);
        r1[1] = ContextCompat.getColor(r5, 2131105548);
        r1[2] = ContextCompat.getColor(r5, 2131106610);
        r1[3] = ContextCompat.getColor(r5, 2131105548);
        goto L9
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        this.g = (LinearLayout) r5.findViewById(2131388843);
        this.h = r5.findViewById(2131388831);
        this.i = (LinearLayout) r5.findViewById(2131364861);
        this.j = (TextView) r5.findViewById(2131388772);
        this.k = CustomHeaderConfig.COLOR_DARK;
        this.l = (ViewGroup) r5.findViewById(2131377797);
        this.m = (ViewGroup) r5.findViewById(2131384608);
        ImageView r7 = (ImageView) r5.findViewById(2131387960);
        this.n = r7;
        ObjectAnimator r0 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("syncIcon");
        r7 = null;
    L5:
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r7, "rotation", new float[]{0.0f, 359.0f});
        this.q = r8;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
        r8 = null;
    L8:
        r8.setDuration(2000);
        ObjectAnimator r9 = this.q;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
        r9 = null;
    L11:
        r9.setInterpolator(new LinearInterpolator());
        ObjectAnimator r10 = this.q;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
    L15:
        r0.setRepeatCount(-1);
        this.o = (ImageView) r5.findViewById(2131392520);
        this.p = (ImageView) r5.findViewById(2131363236);
        this.s = getResources().getDimensionPixelSize(2131169533);
        this.t = getResources().getDimensionPixelSize(2131165755);
        this.u = getResources().getDimensionPixelSize(2131165756);
        this.r = r5.findViewById(2131369197);
        return;
    L14:
        r0 = r10;
        goto L15
    }

    public final ImageView U90(CustomHeaderConfig.Menu r11, int r12, int r13) {
        ImageView r1 = new ImageView(getContext());
        String r2 = r11.getId();
        if (r2 == null) goto L43;
        Boolean r3 = r11.getEnable();
        if (r3 == null) goto L7;
        boolean r4 = r3.booleanValue();
    L8:
        r1.setEnabled(r4);
        String r5 = r11.getOnboardingKey();
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L17;
        r1.setTag(r11.getOnboardingKey());
    L17:
        String r7 = r11.getIconKey();
        if (r7 != null) goto L20;
    L23:
        boolean r8 = true;
    L25:
        if (r8 == false) goto L46;
    L33:
        boolean r0 = false;
    L34:
        if (r0 == false) goto L44;
    L39:
        int r9 = this.s;
        ViewGroup.MarginLayoutParams r10 = new ViewGroup.MarginLayoutParams(r9, r9);
        r10.leftMargin = r12;
        r10.rightMargin = r13;
        r1.setLayoutParams(r10);
        int[][] r14 = {new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[0]};
        String[] r16 = r11.getCustomColor();
        if (r16 == null) goto L42;
        r1.setImageTintList(new ColorStateList(r14, W90(r1.getContext(), r16)));
    L42:
        r1.setOnClickListener(new b(this, r2, r11));
        goto L43
    L44:
        MenuEnum r17 = MenuEnum.valueOf(r2);     // Catch: Exception -> L37
        r1.setImageDrawable(com.bytedance.ee.util.ui.l.a(r1.getContext(), kac.a.b(r17.getImageResId()), r17.getImageResTint()));     // Catch: Exception -> L37
    L37:
        e = move-exception;
        tt5.a.e("CustomHeaderFragment", "createMenuIconView fallback icon fail, iconKey=" + r7 + ", id=" + r2, e, false);
        goto L39
    L46:
        int r18 = n.o(r1.getContext(), r7);     // Catch: Exception -> L31
        if (r18 == 0) goto L29;
        r1.setImageDrawable(com.bytedance.ee.util.ui.l.a(r1.getContext(), kac.a.b(r18), 2131101926));     // Catch: Exception -> L31
        r0 = true;
        goto L34
    L29:
        tt5.a.k("CustomHeaderFragment", "iconKey resource not found, fallback to menu id icon, iconKey=" + r7 + ", id=" + r2);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        tt5.a.e("CustomHeaderFragment", "get icon fail, iconKey=" + r7 + ", id=" + r2, e, false);
        goto L33
    L20:
        if (r7.length() == 0) goto L23;
        r8 = false;
        goto L25
    L11:
        if (r5.length() == 0) goto L14;
        r6 = false;
        goto L15
    L7:
        r4 = true;
    L43:
        return r1;
    }

    public final TextView V90(CustomHeaderConfig.Menu r6, int r7, int r8) {
        TextView r0 = new TextView(getContext());
        Boolean r1 = r6.getEnable();
        if (r1 == null) goto L5;
        boolean r2 = r1.booleanValue();
    L6:
        r0.setEnabled(r2);
        r0.setText(r6.getText());
        String r3 = r6.getOnboardingKey();
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L15;
        r0.setTag(r6.getOnboardingKey());
    L15:
        r0.setAllCaps(false);
        ViewGroup.MarginLayoutParams r5 = new ViewGroup.MarginLayoutParams(-2, -2);
        r5.leftMargin = r7;
        r5.rightMargin = r8;
        r0.setLayoutParams(r5);
        r0.setTextSize(16.0f);
        r0.setBackground(r0.getResources().getDrawable(2131103546));
        r0.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[0]}, W90(r0.getContext(), r6.getCustomColor())));
        r0.setOnClickListener(new c(r6, this));
        return r0;
    L9:
        if (r3.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r2 = true;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559986, r3, false);
    }
}
