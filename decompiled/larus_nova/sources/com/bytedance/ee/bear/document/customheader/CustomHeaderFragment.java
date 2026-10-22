package com.bytedance.ee.bear.document.customheader;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.comment.CommentPanelViewModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005*\u0001&\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010\u001b2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u00122\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00102\u001a\u00020)H\u0016J\b\u00103\u001a\u00020\"H\u0016J\u0012\u00104\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0018\u00107\u001a\u00020)2\u0006\u00101\u001a\u00020\u00122\u0006\u00108\u001a\u00020\"H\u0002J*\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\"2\b\u0010;\u001a\u0004\u0018\u00010\u00102\u0006\u0010<\u001a\u00020\u001d2\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020AH\u0002J \u0010B\u001a\u00020\u00152\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH\u0002J \u0010E\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u001a\u0010F\u001a\u00020)2\b\b\u0001\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\"H\u0002J%\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010NH\u0002¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u00020)H\u0002J\u000e\u0010!\u001a\u00020)2\u0006\u0010Q\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\"\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006S"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/CustomHeaderFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "customHeaderViewModel", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderViewModel;", "commentPanelViewModel", "Lcom/bytedance/ee/bear/document/comment/CommentPanelViewModel;", "statusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "titleContainer", "Landroid/widget/LinearLayout;", "btnTitleBg", "titleView", "Landroid/widget/TextView;", "titleColor", "", "leftMenuContainer", "Landroid/view/ViewGroup;", "rightMenuContainer", "syncIcon", "Landroid/widget/ImageView;", "viewIcon", "arrowIcon", "syncAnimator", "Landroid/animation/ObjectAnimator;", ItemStyle.ITEM_STYLE_DIVIDER, "Landroid/view/View;", "menuSize", "", "leftMenuMargin", "rightMenuMargin", "businessExtraId", "disableTitleCenter", "", "statusBarColorStore", "Lkotlin/Pair;", "statusBarInterceptor", "com/bytedance/ee/bear/document/customheader/CustomHeaderFragment$statusBarInterceptor$1", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderFragment$statusBarInterceptor$1;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "onViewCreated", "view", "onDestroyView", "onBackPressed", "updateView", "data", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig;", "setViewAndChildrenEnabled", "enabled", "decorateTitle", "decorate", "name", "iconResource", "clickListener", "Landroid/view/View$OnClickListener;", "handleBusinessLogic", TplType.MENU, "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$Menu;", "createMenuIconView", "menuMarginLeft", "menuMarginRight", "createMenuTextView", "setStatusBarColor", "statusBarColor", "lightStatusBar", "getColors", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "customColor", "", "(Landroid/content/Context;[Ljava/lang/String;)[I", "makeTitleCenter", "disable", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomHeaderFragment extends BaseFragment {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f219406z = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CustomHeaderViewModel f219407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommentPanelViewModel f219408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public xu5.b.a f219409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f219410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f219411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f219412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f219413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f219414l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f219415m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f219416n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f219417o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f219418p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ObjectAnimator f219419q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f219420r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f219421s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f219422t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f219423u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f219424v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f219425w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Pair<Integer, Boolean> f219426x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final g f219427y;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomHeaderFragment f219428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f219429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CustomHeaderConfig.Menu f219430c;

        public b(CustomHeaderFragment r100, String r101, CustomHeaderConfig.Menu r102) {
            this.f219428a = r100;
            this.f219429b = r101;
            this.f219430c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CustomHeaderViewModel r101 = this.f219428a.f219407e;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
            r101 = null;
        L5:
            CustomHeaderViewModel.a r102 = r101.getDelegate();
            if (r102 == null) goto L9;
            r102.a(this.f219429b, this.f219430c.getExtraId());
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomHeaderConfig.Menu f219431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CustomHeaderFragment f219432b;

        public c(CustomHeaderConfig.Menu r100, CustomHeaderFragment r101) {
            this.f219431a = r100;
            this.f219432b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = this.f219431a.getId();
            if (r101 == null) goto L11;
            CustomHeaderFragment r102 = this.f219432b;
            CustomHeaderConfig.Menu r103 = this.f219431a;
            CustomHeaderViewModel r104 = r102.f219407e;
            if (r104 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
            r104 = null;
        L7:
            CustomHeaderViewModel.a r105 = r104.getDelegate();
            if (r105 == null) goto L12;
            r105.a(r101, r103.getExtraId());
            return;
        L12:
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomHeaderFragment f219433a;

        public d(CustomHeaderFragment r100) {
            this.f219433a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CustomHeaderFragment r100 = this.f219433a;     // Catch: Throwable -> L4
            int r101 = CustomHeaderFragment.f219406z;     // Catch: Throwable -> L4
            r100.Y90();     // Catch: Throwable -> L4
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
        public final /* synthetic */ CustomHeaderFragment f219434a;

        public e(CustomHeaderFragment r100) {
            this.f219434a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            CustomHeaderConfig r100 = (CustomHeaderConfig) r110;
            CustomHeaderFragment r101 = this.f219434a;
            CustomHeaderViewModel r102 = null;
            if (r100 == null) goto L225;
            int r103 = CustomHeaderFragment.f219406z;
            r101.getClass();
            String r104 = r100.getThemeColor();
            if (r104 == null) goto L16;
            int r105 = ColorUtils.h(r104);
            boolean r106 = ColorUtils.f(r105);
            View r107 = r101.getView();
            if (r107 == null) goto L9;
            r107.setBackgroundColor(r105);
        L9:
            if (r106 == false) goto L11;
            String r108 = CustomHeaderConfig.COLOR_LIGHT;
        L12:
            r101.f219413k = r108;
            r101.Z90(r105, !r106);
            CommentPanelViewModel r109 = r101.f219408f;
            if (r109 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("commentPanelViewModel");
            r109 = null;
        L15:
            r109.isShowingComment().observe(r101, new p05.a(r101, r105, r106));
            goto L16
        L11:
            r108 = CustomHeaderConfig.COLOR_DARK;
        L16:
            ViewGroup r111 = r101.f219414l;
            if (r111 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
            r111 = null;
        L19:
            r111.removeAllViews();
            ViewGroup r112 = r101.f219415m;
            if (r112 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
            r112 = null;
        L22:
            r112.removeAllViews();
            CustomHeaderConfig.MenuItems r113 = r100.getItems();
            boolean r114 = true;
            if (r113 == null) goto L62;
            CustomHeaderConfig.Menu[] r115 = r113.getLeft();
            if (r115 == null) goto L43;
            int r116 = r115.length;
            int r117 = 0;
        L27:
            if (r117 >= r116) goto L43;
            CustomHeaderConfig.Menu r118 = r115[r117];
            if (r118.getId() == null) goto L42;
            if (Intrinsics.areEqual(r118.getStyle(), "text") == false) goto L34;
            int r119 = r101.f219422t;
            View r120 = r101.V90(r118, r119, r119);
        L35:
            int r121 = com.bytedance.ee.bear.document.customheader.b.f219484a;
            if (Intrinsics.areEqual("docx_embedded_history_exit", r118.getExtraId()) == false) goto L38;
            r101.f219424v = r118.getExtraId();
        L38:
            ViewGroup r122 = r101.f219414l;
            if (r122 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
            r122 = null;
        L41:
            r122.addView(r120);
            goto L42
        L34:
            int r123 = r101.f219422t;
            r120 = r101.U90(r118, r123, r123);
        L42:
            r117 = r117 + 1;
        L43:
            CustomHeaderConfig.Menu[] r124 = r113.getRight();
            if (r124 == null) goto L62;
            int r125 = r124.length;
            int r126 = 0;
            boolean r127 = true;
        L46:
            if (r126 >= r125) goto L62;
            CustomHeaderConfig.Menu r128 = r124[r126];
            if (r128.getId() == null) goto L61;
            if (r127 == false) goto L52;
            int r129 = r101.f219423u;
            boolean r130 = false;
        L54:
            if (Intrinsics.areEqual(r128.getStyle(), "text") == false) goto L56;
            View r131 = r101.V90(r128, r129, r101.f219423u);
        L57:
            ViewGroup r132 = r101.f219415m;
            if (r132 != null) goto L60;
            Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
            r132 = null;
        L60:
            r132.addView(r131);
            r127 = r130;
            goto L61
        L56:
            r131 = r101.U90(r128, r129, r101.f219423u);
            goto L57
        L52:
            r130 = r127;
            r129 = 0;
        L61:
            r126 = r126 + 1;
        L62:
            CustomHeaderConfig.TitleConfig r133 = r100.getTitleConfig();
            if (r133 != null) goto L65;
        L67:
            boolean r134 = false;
        L69:
            if (r134 == false) goto L78;
            LinearLayout r135 = r101.f219411i;
            if (r135 != null) goto L73;
            Intrinsics.throwUninitializedPropertyAccessException("btnTitleBg");
            r135 = null;
        L73:
            Context r136 = r101.getContext();
            if (r136 == null) goto L76;
            Drawable r137 = AppCompatResources.getDrawable(r136, R.drawable.btn_white_corner_border_bg);
        L77:
            r135.setBackground(r137);
        L82:
            Context r138 = r101.getContext();
            if (r138 == null) goto L97;
            TextView r139 = r101.f219412j;
            if (r139 != null) goto L87;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r139 = null;
        L87:
            CustomHeaderConfig.TitleConfig r140 = r100.getTitleConfig();
            if (r140 != null) goto L90;
        L92:
            boolean r141 = false;
        L93:
            if (r141 == false) goto L95;
            Typeface r142 = h18.e.b(r138, 1);
        L96:
            r139.setTypeface(r142);
            goto L97
        L95:
            r142 = h18.e.b(r138, 0);
            goto L96
        L90:
            if (r140.isBold() != true) goto L92;
            r141 = true;
        L97:
            TextView r143 = r101.f219412j;
            if (r143 != null) goto L100;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r143 = null;
        L100:
            CustomHeaderConfig.TitleConfig r144 = r100.getTitleConfig();
            if (r144 == null) goto L105;
            String r145 = r144.getTitle();
            if (r145 == null) goto L105;
        L106:
            r143.setText(r145);
            CustomHeaderConfig.TitleConfig r146 = r100.getTitleConfig();
            if (r146 == null) goto L109;
            boolean r147 = Intrinsics.areEqual(r146.isLoading(), Boolean.TRUE);
        L111:
            if (r147 == false) goto L131;
            TextView r148 = r101.f219412j;
            if (r148 != null) goto L115;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r148 = null;
        L115:
            r148.setTextColor(r101.getResources().getColor(R.color.lkui_B500));
            ImageView r149 = r101.f219416n;
            if (r149 != null) goto L118;
            Intrinsics.throwUninitializedPropertyAccessException("syncIcon");
            r149 = null;
        L118:
            r149.setVisibility(0);
            ObjectAnimator r150 = r101.f219419q;
            if (r150 != null) goto L122;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r150 = null;
        L122:
            if (r150.isStarted() == false) goto L127;
            ObjectAnimator r151 = r101.f219419q;
            if (r151 != null) goto L126;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r151 = null;
        L126:
            r151.resume();
        L144:
            CustomHeaderConfig.TitleConfig r152 = r100.getTitleConfig();
            if (r152 == null) goto L151;
            String r153 = r152.getPosition();
            if (r153 == null) goto L151;
            if (Intrinsics.areEqual(r153, "center") == false) goto L151;
            r101.Y90();
        L151:
            View r154 = r101.f219420r;
            if (r154 != null) goto L155;
            Intrinsics.throwUninitializedPropertyAccessException(ItemStyle.ITEM_STYLE_DIVIDER);
            r154 = null;
        L155:
            if (Intrinsics.areEqual(r100.getShouldShowDivider(), Boolean.TRUE) == false) goto L157;
            int r155 = 0;
        L158:
            r154.setVisibility(r155);
            CustomHeaderConfig.TitleConfig r156 = r100.getTitleConfig();
            if (r156 == null) goto L214;
            ImageView r157 = r101.f219417o;
            if (r157 != null) goto L163;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r157 = null;
        L163:
            Integer r158 = r100.getTitleIcon(r156.getTitleIcon(), r157.getContext());
            if (r158 == null) goto L166;
            int r159 = 0;
            r157.setVisibility(0);
            r157.setImageResource(r158.intValue());
        L170:
            ImageView r160 = r101.f219418p;
            if (r160 != null) goto L174;
            Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
            r160 = null;
        L174:
            if (r156.getShowFoldBtn() == false) goto L176;
            int r161 = 0;
        L177:
            r160.setVisibility(r161);
            String r162 = r156.getOnboardingKey();
            if (r162 != null) goto L180;
        L183:
            if (r114 == true) goto L189;
            LinearLayout r163 = r101.f219410h;
            if (r163 != null) goto L187;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r163 = null;
        L187:
            r163.setTag(r156.getOnboardingKey());
        L189:
            if (r156.getId() == null) goto L209;
            String r164 = r156.getId();
            if (r164 == null) goto L214;
            LinearLayout r165 = r101.f219410h;
            if (r165 != null) goto L195;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r165 = null;
        L195:
            r165.setOnClickListener(new com.bytedance.ee.bear.document.customheader.a(r101, r164));
            LinearLayout r166 = r101.f219410h;
            if (r166 != null) goto L198;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r166 = null;
        L198:
            boolean r167 = r156.getEnable();
            r166.setEnabled(r167);
            if (r167 == false) goto L201;
            float r168 = 1.0f;
        L202:
            r166.setAlpha(r168);
            int r169 = r166.getChildCount();
        L203:
            if (r159 >= r169) goto L214;
            View r170 = r166.getChildAt(r159);
            r170.setEnabled(r167);
            if (r167 == false) goto L207;
            float r171 = 1.0f;
        L208:
            r170.setAlpha(r171);
            r159 = r159 + 1;
            goto L203
        L207:
            r171 = 0.5f;
            goto L208
        L201:
            r168 = 0.5f;
            goto L202
        L209:
            LinearLayout r172 = r101.f219410h;
            if (r172 != null) goto L212;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r172 = null;
        L212:
            r172.setOnClickListener(null);
            goto L214
        L180:
            if (r162.length() == 0) goto L183;
            r114 = false;
            goto L183
        L176:
            r161 = 8;
            goto L177
        L166:
            r159 = 0;
            ImageView r173 = r101.f219417o;
            if (r173 != null) goto L169;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r173 = null;
        L169:
            r173.setVisibility(8);
        L214:
            if (r100.getTitleConfig() != null) goto L225;
            ImageView r174 = r101.f219417o;
            if (r174 != null) goto L218;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r174 = null;
        L218:
            r174.setVisibility(8);
            ImageView r175 = r101.f219418p;
            if (r175 != null) goto L221;
            Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
            r175 = null;
        L221:
            r175.setVisibility(8);
            LinearLayout r176 = r101.f219410h;
            if (r176 != null) goto L224;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r176 = null;
        L224:
            r176.setOnClickListener(null);
            goto L225
        L157:
            r155 = 8;
            goto L158
        L127:
            ObjectAnimator r177 = r101.f219419q;
            if (r177 != null) goto L130;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r177 = null;
        L130:
            r177.start();
            goto L144
        L131:
            TextView r178 = r101.f219412j;
            if (r178 != null) goto L134;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r178 = null;
        L134:
            String r179 = r101.f219413k;
            if (r179 != null) goto L137;
            Intrinsics.throwUninitializedPropertyAccessException("titleColor");
            r179 = null;
        L137:
            r178.setTextColor(ColorUtils.h(r179));
            ImageView r180 = r101.f219416n;
            if (r180 != null) goto L140;
            Intrinsics.throwUninitializedPropertyAccessException("syncIcon");
            r180 = null;
        L140:
            r180.setVisibility(8);
            ObjectAnimator r181 = r101.f219419q;
            if (r181 != null) goto L143;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r181 = null;
        L143:
            r181.cancel();
            goto L144
        L109:
            r147 = false;
        L105:
            r145 = "";
            goto L106
        L76:
            r137 = null;
            goto L77
        L78:
            LinearLayout r182 = r101.f219411i;
            if (r182 != null) goto L81;
            Intrinsics.throwUninitializedPropertyAccessException("btnTitleBg");
            r182 = null;
        L81:
            r182.setBackground(null);
            goto L82
        L65:
            if (r133.getHasBorder() != true) goto L67;
            r134 = true;
        L225:
            CustomHeaderViewModel r183 = r101.f219407e;
            if (r183 != null) goto L228;
            Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
        L229:
            r102.getStatusBarDiffHeight().observe(r101, new p05.b(r101));
            View r184 = r101.getView();
            if (r184 == null) goto L242;
            r184.addOnLayoutChangeListener(new p05.c(r101));
            return;
        L242:
            return;
        L228:
            r102 = r183;
            goto L229
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomHeaderFragment f219435a;

        public f(CustomHeaderFragment r100) {
            this.f219435a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            View r102 = this.f219435a.getView();
            if (r102 == null) goto L5;
            ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        L6:
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L9;
            int r105 = k.e(this.f219435a.getContext());
        L10:
            r104.topMargin = r105;
            return;
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class g implements bp5.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomHeaderFragment f219436a;

        @Override // bp5.c.a
        public final boolean interceptSetSystemUiVisibility(Activity r100, int r101) {
            return true;
        }

        public g(CustomHeaderFragment r100) {
            this.f219436a = r100;
        }

        @Override // bp5.c.a
        public final boolean interceptSetStatusBarColor(Activity r100, int r101, boolean r102) {
            CustomHeaderFragment r103 = this.f219436a;
            r103.f219426x = new Pair(Integer.valueOf(r101), Boolean.valueOf(r102));
            return false;
        }
    }

    static {
    }

    public final void Y90() {
        if (this.f219425w == false) goto L6;
        return;
    L6:
        if (isAdded() == true) goto L8;
        return;
    L8:
        View r100 = getView();
        if (r100 == null) goto L11;
        int r101 = r100.getWidth();
    L13:
        if (ForsetiHelper.s(this) == false) goto L17;
        if (r101 != 0) goto L17;
        hac.b.f484427a.b("CustomHeaderFragment", "fragmentWidth is 0, post runnable");
        j.c(new d(this));
        return;
    L17:
        TextView r102 = this.f219412j;
        LinearLayout r103 = null;
        if (r102 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r102 = null;
    L20:
        r102.setGravity(17);
        Context r104 = getContext();
        Context r105 = getContext();
        if (r105 != null) goto L23;
        return;
    L23:
        if (ForsetiHelper.s(this) == false) goto L26;
    L39:
        int r106 = View.MeasureSpec.makeMeasureSpec(1073741823, 0);
        ViewGroup r107 = this.f219414l;
        if (r107 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
        r107 = null;
    L42:
        r107.measure(r106, r106);
        ViewGroup r108 = this.f219415m;
        if (r108 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
        r108 = null;
    L45:
        r108.measure(r106, r106);
        ViewGroup r109 = this.f219414l;
        if (r109 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
        r109 = null;
    L48:
        int r110 = r109.getMeasuredWidth();
        ViewGroup r111 = this.f219415m;
        if (r111 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
        r111 = null;
    L51:
        int r112 = Math.max(r110, r111.getMeasuredWidth());
        LinearLayout r113 = this.f219410h;
        if (r113 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r113 = null;
    L54:
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if ((r114 instanceof RelativeLayout.LayoutParams) == false) goto L57;
        RelativeLayout.LayoutParams r115 = (RelativeLayout.LayoutParams) r114;
    L58:
        if (r115 == null) goto L60;
        r115.removeRule(17);
        r115.removeRule(16);
        r115.addRule(13, -1);
        r115.width = ((r101 / 2) - r112) * 2;
    L60:
        LinearLayout r116 = this.f219410h;
        if (r116 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    L64:
        r103.setGravity(1);
        return;
    L63:
        r103 = r116;
        goto L64
    L57:
        r115 = null;
        goto L58
    L26:
        if (com.bytedance.ee.util.ui.b.b(r104) == false) goto L36;
        if ((r104 instanceof Activity) == false) goto L36;
        View r117 = ((Activity) r104).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L34;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r118 = ThreadMethodProxy.currentThread();
        if (r118 == com.larus.home.impl.utils.c.f346341a) goto L34;
        com.larus.home.impl.utils.c.a(r118, "getDecorView");
    L34:
        r101 = r117.getWidth();
    L36:
        if (cu5.c.f465432a > 0) goto L38;
        WindowManager r119 = (WindowManager) r105.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r120 = new DisplayMetrics();
        r119.getDefaultDisplay().getMetrics(r120);
        cu5.c.f465432a = r120.widthPixels;
    L38:
        r101 = cu5.c.f465432a;
        goto L39
    L11:
        r101 = 0;
        goto L13
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        CustomHeaderViewModel r100 = this.f219407e;
        CustomHeaderViewModel r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
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
        CustomHeaderViewModel r104 = this.f219407e;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
    L17:
        CustomHeaderViewModel.a r105 = r101.getDelegate();
        if (r105 == null) goto L20;
        r105.a("exit", this.f219424v);
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

    public CustomHeaderFragment() {
        this.f219427y = new g(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Pair<Integer, Boolean> r100 = this.f219426x;
        ObjectAnimator r101 = null;
        if (r100 == null) goto L11;
        Integer r102 = r100.getFirst();
        Pair<Integer, Boolean> r103 = this.f219426x;
        if (r103 == null) goto L7;
        Boolean r104 = r103.getSecond();
    L8:
        if (r102 == null) goto L14;
        if (r104 == null) goto L14;
        Z90(r102.intValue(), r104.booleanValue());
    L14:
        bp5.c.c(getActivity(), this.f219427y);
        ObjectAnimator r105 = this.f219419q;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
    L18:
        r101.cancel();
        return;
    L17:
        r101 = r105;
        goto L18
    L7:
        r104 = null;
        goto L8
    L11:
        xu5.b.a r106 = this.f219409g;
        if (r106 == null) goto L14;
        r106.resetState();
        goto L14
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FragmentActivity r101 = getActivity();
        CustomHeaderViewModel r102 = null;
        if (r101 == null) goto L5;
        xu5.b.a r103 = xu5.b.b(r101, null);
    L6:
        this.f219409g = r103;
        if (r103 == null) goto L9;
        r103.saveState();
    L9:
        CustomHeaderViewModel r104 = (CustomHeaderViewModel) q.a(this, CustomHeaderViewModel.class);
        this.f219407e = r104;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
        r104 = null;
    L12:
        r104.getHeaderData().observe(this, new e(this));
        CustomHeaderViewModel r105 = this.f219407e;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
        r105 = null;
    L15:
        r105.isStatusBarImmersive().observe(this, new f(this));
        CustomHeaderViewModel r106 = this.f219407e;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
    L19:
        r102.isCustomHeaderVisible().observe(this, new AnonymousClass4(this));
        this.f219408f = (CommentPanelViewModel) q.a(this, CommentPanelViewModel.class);
        return;
    L18:
        r102 = r106;
        goto L19
    L5:
        r103 = null;
        goto L6
    }

    public final int[] X90(Context r100, String[] r101) {
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

    public final void Z90(int r100, boolean r101) {
        bp5.c.c(getActivity(), this.f219427y);
        xu5.b.a r102 = this.f219409g;
        if (r102 == null) goto L5;
        r102.b(r100, r101);
    L5:
        bp5.c.b(getActivity(), this.f219427y);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f219410h = (LinearLayout) r100.findViewById(R.id.title_container);
        this.f219411i = (LinearLayout) r100.findViewById(R.id.btn_title_bg);
        this.f219412j = (TextView) r100.findViewById(R.id.title);
        this.f219413k = CustomHeaderConfig.COLOR_DARK;
        this.f219414l = (ViewGroup) r100.findViewById(R.id.left_menu_container);
        this.f219415m = (ViewGroup) r100.findViewById(R.id.right_menu_container);
        ImageView r102 = (ImageView) r100.findViewById(R.id.sync_icon);
        this.f219416n = r102;
        ObjectAnimator r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("syncIcon");
        r102 = null;
    L5:
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r102, "rotation", new float[]{0.0f, 359.0f});
        this.f219419q = r104;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
        r104 = null;
    L8:
        r104.setDuration(2000);
        ObjectAnimator r105 = this.f219419q;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
        r105 = null;
    L11:
        r105.setInterpolator(new LinearInterpolator());
        ObjectAnimator r106 = this.f219419q;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
    L15:
        r103.setRepeatCount(-1);
        this.f219417o = (ImageView) r100.findViewById(R.id.view_icon);
        this.f219418p = (ImageView) r100.findViewById(R.id.arrow);
        this.f219421s = getResources().getDimensionPixelSize(R.dimen.widget_menu_img_size);
        this.f219422t = getResources().getDimensionPixelSize(R.dimen.custom_header_left_menu_half_margin);
        this.f219423u = getResources().getDimensionPixelSize(R.dimen.custom_header_right_menu_half_margin);
        this.f219420r = r100.findViewById(R.id.divider);
        return;
    L14:
        r103 = r106;
        goto L15
    }

    public final ImageView U90(CustomHeaderConfig.Menu r100, int r110, int r111) {
        ImageView r101 = new ImageView(getContext());
        String r102 = r100.getId();
        if (r102 == null) goto L30;
        Boolean r103 = r100.getEnable();
        if (r103 == null) goto L7;
        boolean r104 = r103.booleanValue();
    L8:
        r101.setEnabled(r104);
        String r105 = r100.getOnboardingKey();
        if (r105 != null) goto L11;
    L14:
        boolean r106 = true;
    L15:
        if (r106 == true) goto L17;
        r101.setTag(r100.getOnboardingKey());
    L17:
        String r107 = r100.getIconKey();
        if (r107 == null) goto L31;
        int r108 = n.n(r101.getContext(), r107);
        if (r108 == 0) goto L26;
        r101.setImageDrawable(l.a(r101.getContext(), r108, R.color.facade_selector_icon_n1));
    L26:
        int r109 = this.f219421s;
        ViewGroup.MarginLayoutParams r112 = new ViewGroup.MarginLayoutParams(r109, r109);
        r112.leftMargin = r110;
        r112.rightMargin = r111;
        r101.setLayoutParams(r112);
        int[][] r113 = {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_selected}, new int[]{-16842910}, new int[0]};
        String[] r114 = r100.getCustomColor();
        if (r114 == null) goto L29;
        r101.setImageTintList(new ColorStateList(r113, X90(r101.getContext(), r114)));
    L29:
        r101.setOnClickListener(new b(this, r102, r100));
        goto L30
    L31:
        MenuEnum r115 = MenuEnum.valueOf(r102);     // Catch: Exception -> L24
        r101.setImageDrawable(l.a(r101.getContext(), r115.getImageResId(), r115.getImageResTint()));     // Catch: Exception -> L24
    L24:
        e = move-exception;
        hac.b.f484427a.b("CustomHeaderFragment", "createMenuIconView: " + r102 + " ,not find iconResId:" + e);
        goto L26
    L11:
        if (r105.length() == 0) goto L14;
        r106 = false;
        goto L15
    L7:
        r104 = true;
    L30:
        return r101;
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
        r103.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_selected}, new int[]{-16842910}, new int[0]}, X90(r103.getContext(), r100.getCustomColor())));
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
        return r100.inflate(R.layout.custom_header_layout, r101, false);
    }

    public final void W90(boolean r100, String r101, int r102, View.OnClickListener r103) {
        LinearLayout r104 = null;
        if (r100 == false) goto L18;
        ImageView r105 = this.f219417o;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
        r105 = null;
    L7:
        r105.setVisibility(0);
        r105.setImageResource(r102);
        ImageView r106 = this.f219418p;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
        r106 = null;
    L10:
        r106.setVisibility(0);
        TextView r107 = this.f219412j;
        if (r107 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r107 = null;
    L13:
        r107.setText(r101);
        LinearLayout r108 = this.f219410h;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    L17:
        r104.setOnClickListener(r103);
        return;
    L16:
        r104 = r108;
        goto L17
    L18:
        ImageView r109 = this.f219417o;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
        r109 = null;
    L21:
        r109.setVisibility(8);
        ImageView r110 = this.f219418p;
        if (r110 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
        r110 = null;
    L24:
        r110.setVisibility(8);
        LinearLayout r111 = this.f219410h;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r111 = null;
    L27:
        r111.setOnClickListener(null);
    }
}
