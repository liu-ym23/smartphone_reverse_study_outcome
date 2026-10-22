package com.bytedance.ee.bear.document.customheader;

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
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005*\u0001&\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u00132\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00102\u001a\u00020)H\u0016J\b\u00103\u001a\u00020\"H\u0016J\u0012\u00104\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0018\u00107\u001a\u00020)2\u0006\u00101\u001a\u00020\u00132\u0006\u00108\u001a\u00020\"H\u0002J*\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\"2\b\u0010;\u001a\u0004\u0018\u00010\u00112\u0006\u0010<\u001a\u00020\u001d2\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020AH\u0002J \u0010B\u001a\u00020\u00162\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH\u0002J \u0010E\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u001a\u0010F\u001a\u00020)2\b\b\u0001\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\"H\u0002J%\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010NH\u0002¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u00020)H\u0002J\u000e\u0010!\u001a\u00020)2\u0006\u0010Q\u001a\u00020\"R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\"\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006S"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/OfficeCustomHeaderFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "officeCustomHeaderViewModel", "Lcom/bytedance/ee/bear/document/customheader/OfficeCustomHeaderViewModel;", "statusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "titleContainer", "Landroid/widget/LinearLayout;", "titleBarWrapper", "Landroid/view/View;", "btnTitleBg", "titleView", "Landroid/widget/TextView;", "titleColor", "", "leftMenuContainer", "Landroid/view/ViewGroup;", "rightMenuContainer", "syncIcon", "Landroid/widget/ImageView;", "viewIcon", "arrowIcon", "syncAnimator", "Landroid/animation/ObjectAnimator;", ItemStyle.ITEM_STYLE_DIVIDER, "menuSize", "", "leftMenuMargin", "rightMenuMargin", "businessExtraId", "disableTitleCenter", "", "statusBarColorStore", "Lkotlin/Pair;", "statusBarInterceptor", "com/bytedance/ee/bear/document/customheader/OfficeCustomHeaderFragment$statusBarInterceptor$1", "Lcom/bytedance/ee/bear/document/customheader/OfficeCustomHeaderFragment$statusBarInterceptor$1;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "onViewCreated", "view", "onDestroyView", "onBackPressed", "updateView", "data", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig;", "setViewAndChildrenEnabled", "enabled", "decorateTitle", "decorate", "name", "iconResource", "clickListener", "Landroid/view/View$OnClickListener;", "handleBusinessLogic", TplType.MENU, "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$Menu;", "createMenuIconView", "menuMarginLeft", "menuMarginRight", "createMenuTextView", "setStatusBarColor", "statusBarColor", "lightStatusBar", "getColors", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "customColor", "", "(Landroid/content/Context;[Ljava/lang/String;)[I", "makeTitleCenter", "disable", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCustomHeaderFragment extends BaseFragment implements l {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f219447y = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OfficeCustomHeaderViewModel f219448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public xu5.b.a f219449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f219450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f219451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f219452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f219453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f219454k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f219455l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f219456m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f219457n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f219458o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f219459p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ObjectAnimator f219460q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f219461r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f219462s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f219463t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f219464u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f219465v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Pair<Integer, Boolean> f219466w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f f219467x;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeCustomHeaderFragment f219468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f219469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CustomHeaderConfig.Menu f219470c;

        public b(OfficeCustomHeaderFragment r100, String r101, CustomHeaderConfig.Menu r102) {
            this.f219468a = r100;
            this.f219469b = r101;
            this.f219470c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OfficeCustomHeaderViewModel r101 = this.f219468a.f219448e;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
            r101 = null;
        L5:
            OfficeCustomHeaderViewModel.a r102 = r101.getDelegate();
            if (r102 == null) goto L9;
            r102.a(this.f219469b, this.f219470c.getExtraId());
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomHeaderConfig.Menu f219471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficeCustomHeaderFragment f219472b;

        public c(CustomHeaderConfig.Menu r100, OfficeCustomHeaderFragment r101) {
            this.f219471a = r100;
            this.f219472b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = this.f219471a.getId();
            if (r101 == null) goto L11;
            OfficeCustomHeaderFragment r102 = this.f219472b;
            CustomHeaderConfig.Menu r103 = this.f219471a;
            OfficeCustomHeaderViewModel r104 = r102.f219448e;
            if (r104 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
            r104 = null;
        L7:
            OfficeCustomHeaderViewModel.a r105 = r104.getDelegate();
            if (r105 == null) goto L12;
            r105.a(r101, r103.getExtraId());
            return;
        L12:
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeCustomHeaderFragment f219473a;

        public d(OfficeCustomHeaderFragment r100) {
            this.f219473a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeCustomHeaderFragment r100 = this.f219473a;     // Catch: Throwable -> L4
            int r101 = OfficeCustomHeaderFragment.f219447y;     // Catch: Throwable -> L4
            r100.X90();     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeCustomHeaderFragment f219474a;

        public e(OfficeCustomHeaderFragment r100) {
            this.f219474a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            CustomHeaderConfig r100 = (CustomHeaderConfig) r110;
            OfficeCustomHeaderFragment r101 = this.f219474a;
            int r102 = OfficeCustomHeaderFragment.f219447y;
            r101.getClass();
            boolean r103 = true;
            if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.ui_state_fix_enable") == false) goto L32;
            tt5.a.h("CustomHeaderFragment", "ui state fix enable is on");
            OfficeCustomHeaderViewModel r104 = r101.f219448e;
            if (r104 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
            r104 = null;
        L7:
            Integer r105 = r104.getHeaderHeight();
            if (r105 != null) goto L10;
        L18:
            int r106 = r101.getResources().getDimensionPixelSize(R.dimen.doc_titlebar_height);
        L19:
            View r107 = r101.f219451h;
            if (r107 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("titleBarWrapper");
            r107 = null;
        L23:
            if (r107.getLayoutParams().height == r106) goto L31;
            View r108 = r101.f219451h;
            if (r108 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("titleBarWrapper");
            r108 = null;
        L27:
            r108.getLayoutParams().height = r106;
            View r109 = r101.f219451h;
            if (r109 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("titleBarWrapper");
            r109 = null;
        L30:
            r109.requestLayout();
        L31:
            Unit r111 = Unit.INSTANCE;
        L52:
            if (r100 == null) goto L282;
            String r112 = r100.getThemeColor();
            if (r112 == null) goto L65;
            int r113 = ColorUtils.h(r112);
            boolean r114 = ColorUtils.f(r113);
            View r115 = r101.getView();
            if (r115 == null) goto L58;
            r115.setBackgroundColor(r113);
            Unit r116 = Unit.INSTANCE;
        L58:
            if (r114 == false) goto L60;
            String r117 = CustomHeaderConfig.COLOR_LIGHT;
        L61:
            r101.f219454k = r117;
            boolean r118 = !r114;
            bp5.c.c(r101.getActivity(), r101.f219467x);
            xu5.b.a r119 = r101.f219449f;
            if (r119 == null) goto L64;
            r119.b(r113, r118);
        L64:
            bp5.c.b(r101.getActivity(), r101.f219467x);
            Unit r120 = Unit.INSTANCE;
            goto L65
        L60:
            r117 = CustomHeaderConfig.COLOR_DARK;
        L65:
            ViewGroup r121 = r101.f219455l;
            if (r121 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
            r121 = null;
        L68:
            r121.removeAllViews();
            ViewGroup r122 = r101.f219456m;
            if (r122 != null) goto L71;
            Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
            r122 = null;
        L71:
            r122.removeAllViews();
            CustomHeaderConfig.MenuItems r123 = r100.getItems();
            if (r123 == null) goto L113;
            CustomHeaderConfig.Menu[] r124 = r123.getLeft();
            if (r124 == null) goto L93;
            int r125 = r124.length;
            int r126 = 0;
        L76:
            if (r126 >= r125) goto L92;
            CustomHeaderConfig.Menu r127 = r124[r126];
            if (r127.getId() == null) goto L91;
            if (Intrinsics.areEqual(r127.getStyle(), "text") == false) goto L83;
            int r128 = r101.f219463t;
            View r129 = r101.V90(r127, r128, r128);
        L84:
            int r130 = com.bytedance.ee.bear.document.customheader.b.f219484a;
            if (Intrinsics.areEqual("docx_embedded_history_exit", r127.getExtraId()) == false) goto L87;
            r101.f219465v = r127.getExtraId();
        L87:
            ViewGroup r131 = r101.f219455l;
            if (r131 != null) goto L90;
            Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
            r131 = null;
        L90:
            r131.addView(r129);
            goto L91
        L83:
            int r132 = r101.f219463t;
            r129 = r101.U90(r127, r132, r132);
        L91:
            r126 = r126 + 1;
            goto L76
        L92:
            Unit r133 = Unit.INSTANCE;
        L93:
            CustomHeaderConfig.Menu[] r134 = r123.getRight();
            if (r134 == null) goto L113;
            int r135 = r134.length;
            int r136 = 0;
            boolean r137 = true;
        L96:
            if (r136 >= r135) goto L112;
            CustomHeaderConfig.Menu r138 = r134[r136];
            if (r138.getId() == null) goto L111;
            if (r137 == false) goto L102;
            int r139 = r101.f219464u;
            boolean r140 = false;
        L104:
            if (Intrinsics.areEqual(r138.getStyle(), "text") == false) goto L106;
            View r141 = r101.V90(r138, r139, r101.f219464u);
        L107:
            ViewGroup r142 = r101.f219456m;
            if (r142 != null) goto L110;
            Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
            r142 = null;
        L110:
            r142.addView(r141);
            r137 = r140;
            goto L111
        L106:
            r141 = r101.U90(r138, r139, r101.f219464u);
            goto L107
        L102:
            r140 = r137;
            r139 = 0;
        L111:
            r136 = r136 + 1;
            goto L96
        L112:
            Unit r143 = Unit.INSTANCE;
        L113:
            CustomHeaderConfig.TitleConfig r144 = r100.getTitleConfig();
            if (r144 != null) goto L116;
        L118:
            boolean r145 = false;
        L120:
            if (r145 == false) goto L129;
            LinearLayout r146 = r101.f219452i;
            if (r146 != null) goto L124;
            Intrinsics.throwUninitializedPropertyAccessException("btnTitleBg");
            r146 = null;
        L124:
            Context r147 = r101.getContext();
            if (r147 == null) goto L127;
            Drawable r148 = AppCompatResources.getDrawable(r147, R.drawable.btn_white_corner_border_bg);
        L128:
            r146.setBackground(r148);
        L133:
            Context r149 = r101.getContext();
            if (r149 == null) goto L148;
            TextView r150 = r101.f219453j;
            if (r150 != null) goto L138;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r150 = null;
        L138:
            CustomHeaderConfig.TitleConfig r151 = r100.getTitleConfig();
            if (r151 != null) goto L141;
        L143:
            boolean r152 = false;
        L144:
            if (r152 == false) goto L146;
            Typeface r153 = h18.e.b(r149, 1);
        L147:
            r150.setTypeface(r153);
            Unit r154 = Unit.INSTANCE;
            goto L148
        L146:
            r153 = h18.e.b(r149, 0);
            goto L147
        L141:
            if (r151.isBold() != true) goto L143;
            r152 = true;
        L148:
            TextView r155 = r101.f219453j;
            if (r155 != null) goto L151;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r155 = null;
        L151:
            CustomHeaderConfig.TitleConfig r156 = r100.getTitleConfig();
            if (r156 == null) goto L156;
            String r157 = r156.getTitle();
            if (r157 == null) goto L156;
        L157:
            r155.setText(r157);
            CustomHeaderConfig.TitleConfig r158 = r100.getTitleConfig();
            if (r158 == null) goto L160;
            boolean r159 = Intrinsics.areEqual(r158.isLoading(), Boolean.TRUE);
        L162:
            if (r159 == false) goto L182;
            TextView r160 = r101.f219453j;
            if (r160 != null) goto L166;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r160 = null;
        L166:
            r160.setTextColor(r101.getResources().getColor(R.color.lkui_B500));
            ImageView r161 = r101.f219457n;
            if (r161 != null) goto L169;
            Intrinsics.throwUninitializedPropertyAccessException("syncIcon");
            r161 = null;
        L169:
            r161.setVisibility(0);
            ObjectAnimator r162 = r101.f219460q;
            if (r162 != null) goto L173;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r162 = null;
        L173:
            if (r162.isStarted() == false) goto L178;
            ObjectAnimator r163 = r101.f219460q;
            if (r163 != null) goto L177;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r163 = null;
        L177:
            r163.resume();
        L195:
            CustomHeaderConfig.TitleConfig r164 = r100.getTitleConfig();
            if (r164 == null) goto L203;
            String r165 = r164.getPosition();
            if (r165 == null) goto L203;
            if (Intrinsics.areEqual(r165, "center") == false) goto L202;
            r101.X90();
        L202:
            Unit r166 = Unit.INSTANCE;
        L203:
            View r167 = r101.f219461r;
            if (r167 != null) goto L207;
            Intrinsics.throwUninitializedPropertyAccessException(ItemStyle.ITEM_STYLE_DIVIDER);
            r167 = null;
        L207:
            if (Intrinsics.areEqual(r100.getShouldShowDivider(), Boolean.TRUE) == false) goto L209;
            int r168 = 0;
        L210:
            r167.setVisibility(r168);
            CustomHeaderConfig.TitleConfig r169 = r100.getTitleConfig();
            if (r169 == null) goto L267;
            ImageView r170 = r101.f219458o;
            if (r170 != null) goto L215;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r170 = null;
        L215:
            Integer r171 = r100.getTitleIcon(r169.getTitleIcon(), r170.getContext());
            if (r171 == null) goto L218;
            int r172 = 0;
            r170.setVisibility(0);
            r170.setImageResource(kac.a.b(r171.intValue()));
        L222:
            Unit r173 = Unit.INSTANCE;
            ImageView r174 = r101.f219459p;
            if (r174 != null) goto L226;
            Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
            r174 = null;
        L226:
            if (r169.getShowFoldBtn() == false) goto L228;
            int r175 = 0;
        L229:
            r174.setVisibility(r175);
            String r176 = r169.getOnboardingKey();
            if (r176 != null) goto L232;
        L235:
            if (r103 == true) goto L241;
            LinearLayout r177 = r101.f219450g;
            if (r177 != null) goto L239;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r177 = null;
        L239:
            r177.setTag(r169.getOnboardingKey());
        L241:
            if (r169.getId() == null) goto L262;
            String r178 = r169.getId();
            if (r178 == null) goto L267;
            LinearLayout r179 = r101.f219450g;
            if (r179 != null) goto L247;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r179 = null;
        L247:
            r179.setOnClickListener(new com.bytedance.ee.bear.document.customheader.c(r101, r178));
            LinearLayout r180 = r101.f219450g;
            if (r180 != null) goto L250;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r180 = null;
        L250:
            boolean r181 = r169.getEnable();
            r180.setEnabled(r181);
            if (r181 == false) goto L253;
            float r182 = 1.0f;
        L254:
            r180.setAlpha(r182);
            int r183 = r180.getChildCount();
        L255:
            if (r172 >= r183) goto L261;
            View r184 = r180.getChildAt(r172);
            r184.setEnabled(r181);
            if (r181 == false) goto L259;
            float r185 = 1.0f;
        L260:
            r184.setAlpha(r185);
            r172 = r172 + 1;
            goto L255
        L259:
            r185 = 0.5f;
            goto L260
        L261:
            Unit r186 = Unit.INSTANCE;
            goto L267
        L253:
            r182 = 0.5f;
            goto L254
        L262:
            LinearLayout r187 = r101.f219450g;
            if (r187 != null) goto L265;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r187 = null;
        L265:
            r187.setOnClickListener(null);
            goto L267
        L232:
            if (r176.length() == 0) goto L235;
            r103 = false;
            goto L235
        L228:
            r175 = 8;
            goto L229
        L218:
            r172 = 0;
            ImageView r188 = r101.f219458o;
            if (r188 != null) goto L221;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r188 = null;
        L221:
            r188.setVisibility(8);
        L267:
            if (r100.getTitleConfig() != null) goto L280;
            ImageView r189 = r101.f219458o;
            if (r189 != null) goto L271;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r189 = null;
        L271:
            r189.setVisibility(8);
            ImageView r190 = r101.f219459p;
            if (r190 != null) goto L274;
            Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
            ImageView r191 = null;
        L275:
            r191.setVisibility(8);
            LinearLayout r192 = r101.f219450g;
            if (r192 != null) goto L278;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            View.OnClickListener r193 = null;
            r192 = null;
        L279:
            r192.setOnClickListener(r193);
        L281:
            Unit r194 = Unit.INSTANCE;
        L283:
            OfficeCustomHeaderViewModel r195 = r101.f219448e;
            if (r195 != null) goto L286;
            Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
            OfficeCustomHeaderViewModel r196 = r193;
        L287:
            r196.getStatusBarDiffHeight().observe(r101, new p05.e(r101));
            View r197 = r101.getView();
            if (r197 == null) goto L300;
            r197.addOnLayoutChangeListener(new p05.f(r101));
            Unit r198 = Unit.INSTANCE;
            return;
        L300:
            return;
        L286:
            r196 = r195;
            goto L287
        L278:
            r193 = null;
            goto L279
        L274:
            r191 = r190;
            goto L275
        L280:
            r193 = null;
            goto L281
        L209:
            r168 = 8;
            goto L210
        L178:
            ObjectAnimator r199 = r101.f219460q;
            if (r199 != null) goto L181;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r199 = null;
        L181:
            r199.start();
            goto L195
        L182:
            TextView r200 = r101.f219453j;
            if (r200 != null) goto L185;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r200 = null;
        L185:
            String r201 = r101.f219454k;
            if (r201 != null) goto L188;
            Intrinsics.throwUninitializedPropertyAccessException("titleColor");
            r201 = null;
        L188:
            r200.setTextColor(ColorUtils.h(r201));
            ImageView r202 = r101.f219457n;
            if (r202 != null) goto L191;
            Intrinsics.throwUninitializedPropertyAccessException("syncIcon");
            r202 = null;
        L191:
            r202.setVisibility(8);
            ObjectAnimator r203 = r101.f219460q;
            if (r203 != null) goto L194;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r203 = null;
        L194:
            r203.cancel();
            goto L195
        L160:
            r159 = false;
        L156:
            r157 = "";
            goto L157
        L127:
            r148 = null;
            goto L128
        L129:
            LinearLayout r204 = r101.f219452i;
            if (r204 != null) goto L132;
            Intrinsics.throwUninitializedPropertyAccessException("btnTitleBg");
            r204 = null;
        L132:
            r204.setBackground(null);
            goto L133
        L116:
            if (r144.getHasBorder() != true) goto L118;
            r145 = true;
            goto L120
        L282:
            r193 = null;
            goto L283
        L10:
            if (r105.intValue() <= 0) goto L12;
            boolean r205 = true;
        L13:
            if (r205 == true) goto L16;
            r105 = null;
        L16:
            if (r105 == null) goto L18;
            r106 = r105.intValue();
            goto L19
        L12:
            r205 = false;
            goto L13
        L32:
            OfficeCustomHeaderViewModel r206 = r101.f219448e;
            if (r206 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
            r206 = null;
        L35:
            Integer r207 = r206.getHeaderHeight();
            if (r207 == null) goto L52;
            if (r207.intValue() <= 0) goto L40;
            boolean r208 = true;
        L41:
            if (r208 == true) goto L44;
            r207 = null;
        L44:
            if (r207 == null) goto L52;
            int r209 = r207.intValue();
            View r210 = r101.f219451h;
            if (r210 != null) goto L48;
            Intrinsics.throwUninitializedPropertyAccessException("titleBarWrapper");
            r210 = null;
        L48:
            r210.getLayoutParams().height = r209;
            View r211 = r101.f219451h;
            if (r211 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("titleBarWrapper");
            r211 = null;
        L51:
            r211.requestLayout();
            Unit r212 = Unit.INSTANCE;
            goto L52
        L40:
            r208 = false;
            goto L41
        }
    }

    public static final class f implements bp5.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeCustomHeaderFragment f219475a;

        @Override // bp5.c.a
        public final boolean interceptSetSystemUiVisibility(Activity r100, int r101) {
            return true;
        }

        public f(OfficeCustomHeaderFragment r100) {
            this.f219475a = r100;
        }

        @Override // bp5.c.a
        public final boolean interceptSetStatusBarColor(Activity r100, int r101, boolean r102) {
            OfficeCustomHeaderFragment r103 = this.f219475a;
            r103.f219466w = new Pair(Integer.valueOf(r101), Boolean.valueOf(r102));
            return false;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        OfficeCustomHeaderViewModel r100 = this.f219448e;
        OfficeCustomHeaderViewModel r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
        r100 = null;
    L5:
        CustomHeaderConfig r102 = r100.getHeaderData().getValue();
        if (r102 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L13;
        return false;
    L13:
        OfficeCustomHeaderViewModel r104 = this.f219448e;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
    L17:
        OfficeCustomHeaderViewModel.a r105 = r101.getDelegate();
        if (r105 == null) goto L20;
        r105.a("exit", this.f219465v);
    L20:
        return true;
    L16:
        r101 = r104;
        goto L17
    L8:
        if (r102.getShouldHandleBackPress() == true) goto L10;
        r103 = true;
        goto L11
    }

    public OfficeCustomHeaderFragment() {
        this.f219467x = new f(this);
    }

    public final void X90() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        View r100 = getView();
        if (r100 == null) goto L8;
        int r101 = r100.getWidth();
    L9:
        if (r101 != 0) goto L14;
        tt5.a.h("CustomHeaderFragment", "fragmentWidth is 0, post runnable");
        View r102 = getView();
        if (r102 == null) goto L46;
        r102.post(new d(this));
        return;
    L46:
        return;
    L14:
        TextView r103 = this.f219453j;
        LinearLayout r104 = null;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r103 = null;
    L17:
        r103.setGravity(17);
        getContext();
        if (getContext() == null) goto L47;
        int r105 = View.MeasureSpec.makeMeasureSpec(1073741823, 0);
        ViewGroup r106 = this.f219455l;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
        r106 = null;
    L22:
        r106.measure(r105, r105);
        ViewGroup r107 = this.f219456m;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
        r107 = null;
    L25:
        r107.measure(r105, r105);
        ViewGroup r108 = this.f219455l;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
        r108 = null;
    L28:
        int r109 = r108.getMeasuredWidth();
        ViewGroup r110 = this.f219456m;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
        r110 = null;
    L31:
        int r111 = Math.max(r109, r110.getMeasuredWidth());
        LinearLayout r112 = this.f219450g;
        if (r112 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r112 = null;
    L34:
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if ((r113 instanceof RelativeLayout.LayoutParams) == false) goto L37;
        RelativeLayout.LayoutParams r114 = (RelativeLayout.LayoutParams) r113;
    L38:
        if (r114 == null) goto L40;
        r114.removeRule(17);
        r114.removeRule(16);
        r114.addRule(13, -1);
        r114.width = ((r101 / 2) - r111) * 2;
    L40:
        LinearLayout r115 = this.f219450g;
        if (r115 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    L44:
        r104.setGravity(1);
        return;
    L43:
        r104 = r115;
        goto L44
    L37:
        r114 = null;
        goto L38
    L47:
        return;
    L8:
        r101 = 0;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Pair<Integer, Boolean> r100 = this.f219466w;
        ObjectAnimator r101 = null;
        if (r100 == null) goto L14;
        Integer r102 = r100.getFirst();
        Pair<Integer, Boolean> r103 = this.f219466w;
        if (r103 == null) goto L7;
        Boolean r104 = r103.getSecond();
    L8:
        if (r102 == null) goto L17;
        if (r104 == null) goto L17;
        int r105 = r102.intValue();
        boolean r106 = r104.booleanValue();
        bp5.c.c(getActivity(), this.f219467x);
        xu5.b.a r107 = this.f219449f;
        if (r107 == null) goto L13;
        r107.b(r105, r106);
    L13:
        bp5.c.b(getActivity(), this.f219467x);
    L17:
        bp5.c.c(getActivity(), this.f219467x);
        ObjectAnimator r108 = this.f219460q;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
    L21:
        r101.cancel();
        return;
    L20:
        r101 = r108;
        goto L21
    L7:
        r104 = null;
        goto L8
    L14:
        xu5.b.a r109 = this.f219449f;
        if (r109 == null) goto L17;
        r109.resetState();
        goto L17
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FragmentActivity r101 = getActivity();
        OfficeCustomHeaderViewModel r102 = null;
        if (r101 == null) goto L5;
        xu5.b.a r103 = xu5.b.b(r101, null);
    L6:
        this.f219449f = r103;
        if (r103 == null) goto L9;
        r103.saveState();
    L9:
        OfficeCustomHeaderViewModel r104 = (OfficeCustomHeaderViewModel) q.a(this, OfficeCustomHeaderViewModel.class);
        this.f219448e = r104;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
        r104 = null;
    L12:
        r104.getHeaderData().observe(this, new e(this));
        OfficeCustomHeaderViewModel r105 = this.f219448e;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
    L16:
        r102.isCustomHeaderVisible().observe(this, new AnonymousClass3(this));
        return;
    L15:
        r102 = r105;
        goto L16
    L5:
        r103 = null;
        goto L6
    }

    public final int[] W90(Context r100, String[] r101) {
        int[] r102 = new int[4];
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= 4) goto L5;
        r102[r104] = 0;
        r104 = r104 + 1;
        goto L3
    L5:
        if (r101 == null) goto L8;
    L6:
        if (r103 >= 4) goto L9;
        r102[r103] = ColorUtils.h(r101[r103]);
        r103 = r103 + 1;
    L9:
        return r102;
    L8:
        r102[0] = ContextCompat.getColor(r100, R.color.primary_fill_loading);
        r102[1] = ContextCompat.getColor(r100, R.color.primary_fill_default);
        r102[2] = ContextCompat.getColor(r100, R.color.text_disable);
        r102[3] = ContextCompat.getColor(r100, R.color.primary_fill_default);
        goto L9
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f219450g = (LinearLayout) r100.findViewById(R.id.title_container);
        this.f219451h = r100.findViewById(R.id.title_bar_wrapper);
        this.f219452i = (LinearLayout) r100.findViewById(R.id.btn_title_bg);
        this.f219453j = (TextView) r100.findViewById(R.id.title);
        this.f219454k = CustomHeaderConfig.COLOR_DARK;
        this.f219455l = (ViewGroup) r100.findViewById(R.id.left_menu_container);
        this.f219456m = (ViewGroup) r100.findViewById(R.id.right_menu_container);
        ImageView r102 = (ImageView) r100.findViewById(R.id.sync_icon);
        this.f219457n = r102;
        ObjectAnimator r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("syncIcon");
        r102 = null;
    L5:
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r102, "rotation", new float[]{0.0f, 359.0f});
        this.f219460q = r104;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
        r104 = null;
    L8:
        r104.setDuration(2000);
        ObjectAnimator r105 = this.f219460q;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
        r105 = null;
    L11:
        r105.setInterpolator(new LinearInterpolator());
        ObjectAnimator r106 = this.f219460q;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
    L15:
        r103.setRepeatCount(-1);
        this.f219458o = (ImageView) r100.findViewById(R.id.view_icon);
        this.f219459p = (ImageView) r100.findViewById(R.id.arrow);
        this.f219462s = getResources().getDimensionPixelSize(R.dimen.widget_menu_img_size);
        this.f219463t = getResources().getDimensionPixelSize(R.dimen.custom_header_left_menu_half_margin);
        this.f219464u = getResources().getDimensionPixelSize(R.dimen.custom_header_right_menu_half_margin);
        this.f219461r = r100.findViewById(R.id.divider);
        return;
    L14:
        r103 = r106;
        goto L15
    }

    public final ImageView U90(CustomHeaderConfig.Menu r110, int r111, int r112) {
        ImageView r100 = new ImageView(getContext());
        String r101 = r110.getId();
        if (r101 == null) goto L43;
        Boolean r102 = r110.getEnable();
        if (r102 == null) goto L7;
        boolean r103 = r102.booleanValue();
    L8:
        r100.setEnabled(r103);
        String r104 = r110.getOnboardingKey();
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L17;
        r100.setTag(r110.getOnboardingKey());
    L17:
        String r106 = r110.getIconKey();
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L25:
        if (r107 == false) goto L46;
    L33:
        boolean r108 = false;
    L34:
        if (r108 == false) goto L44;
    L39:
        int r109 = this.f219462s;
        ViewGroup.MarginLayoutParams r113 = new ViewGroup.MarginLayoutParams(r109, r109);
        r113.leftMargin = r111;
        r113.rightMargin = r112;
        r100.setLayoutParams(r113);
        int[][] r114 = {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_selected}, new int[]{-16842910}, new int[0]};
        String[] r115 = r110.getCustomColor();
        if (r115 == null) goto L42;
        r100.setImageTintList(new ColorStateList(r114, W90(r100.getContext(), r115)));
    L42:
        r100.setOnClickListener(new b(this, r101, r110));
        goto L43
    L44:
        MenuEnum r116 = MenuEnum.valueOf(r101);     // Catch: Exception -> L37
        r100.setImageDrawable(com.bytedance.ee.util.ui.l.a(r100.getContext(), kac.a.b(r116.getImageResId()), r116.getImageResTint()));     // Catch: Exception -> L37
    L37:
        e = move-exception;
        tt5.a.e("CustomHeaderFragment", "createMenuIconView fallback icon fail, iconKey=" + r106 + ", id=" + r101, e, false);
        goto L39
    L46:
        int r117 = n.o(r100.getContext(), r106);     // Catch: Exception -> L31
        if (r117 == 0) goto L29;
        r100.setImageDrawable(com.bytedance.ee.util.ui.l.a(r100.getContext(), kac.a.b(r117), R.color.facade_selector_icon_n1));     // Catch: Exception -> L31
        r108 = true;
        goto L34
    L29:
        tt5.a.k("CustomHeaderFragment", "iconKey resource not found, fallback to menu id icon, iconKey=" + r106 + ", id=" + r101);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        tt5.a.e("CustomHeaderFragment", "get icon fail, iconKey=" + r106 + ", id=" + r101, e, false);
        goto L33
    L20:
        if (r106.length() == 0) goto L23;
        r107 = false;
        goto L25
    L11:
        if (r104.length() == 0) goto L14;
        r105 = false;
        goto L15
    L7:
        r103 = true;
    L43:
        return r100;
    }

    public final TextView V90(CustomHeaderConfig.Menu r100, int r101, int r102) {
        TextView r103 = new TextView(getContext());
        Boolean r104 = r100.getEnable();
        if (r104 == null) goto L5;
        boolean r105 = r104.booleanValue();
    L6:
        r103.setEnabled(r105);
        r103.setText(r100.getText());
        String r106 = r100.getOnboardingKey();
        if (r106 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == true) goto L15;
        r103.setTag(r100.getOnboardingKey());
    L15:
        r103.setAllCaps(false);
        ViewGroup.MarginLayoutParams r108 = new ViewGroup.MarginLayoutParams(-2, -2);
        r108.leftMargin = r101;
        r108.rightMargin = r102;
        r103.setLayoutParams(r108);
        r103.setTextSize(16.0f);
        r103.setBackground(r103.getResources().getDrawable(R.color.lkui_transparent));
        r103.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_selected}, new int[]{-16842910}, new int[0]}, W90(r103.getContext(), r100.getCustomColor())));
        r103.setOnClickListener(new c(r100, this));
        return r103;
    L9:
        if (r106.length() == 0) goto L12;
        r107 = false;
        goto L13
    L5:
        r105 = true;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.dc_custom_header_layout, r101, false);
    }
}
