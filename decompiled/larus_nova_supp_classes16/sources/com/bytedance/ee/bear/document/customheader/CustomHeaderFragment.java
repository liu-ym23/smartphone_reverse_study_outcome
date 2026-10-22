package com.bytedance.ee.bear.document.customheader;

import android.R;
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
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.comment.CommentPanelViewModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005*\u0001&\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010\u001b2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u00122\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00102\u001a\u00020)H\u0016J\b\u00103\u001a\u00020\"H\u0016J\u0012\u00104\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0018\u00107\u001a\u00020)2\u0006\u00101\u001a\u00020\u00122\u0006\u00108\u001a\u00020\"H\u0002J*\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\"2\b\u0010;\u001a\u0004\u0018\u00010\u00102\u0006\u0010<\u001a\u00020\u001d2\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020AH\u0002J \u0010B\u001a\u00020\u00152\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH\u0002J \u0010E\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u001a\u0010F\u001a\u00020)2\b\b\u0001\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\"H\u0002J%\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010NH\u0002¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u00020)H\u0002J\u000e\u0010!\u001a\u00020)2\u0006\u0010Q\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\"\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006S"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/CustomHeaderFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "customHeaderViewModel", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderViewModel;", "commentPanelViewModel", "Lcom/bytedance/ee/bear/document/comment/CommentPanelViewModel;", "statusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "titleContainer", "Landroid/widget/LinearLayout;", "btnTitleBg", "titleView", "Landroid/widget/TextView;", "titleColor", "", "leftMenuContainer", "Landroid/view/ViewGroup;", "rightMenuContainer", "syncIcon", "Landroid/widget/ImageView;", "viewIcon", "arrowIcon", "syncAnimator", "Landroid/animation/ObjectAnimator;", "divider", "Landroid/view/View;", "menuSize", "", "leftMenuMargin", "rightMenuMargin", "businessExtraId", "disableTitleCenter", "", "statusBarColorStore", "Lkotlin/Pair;", "statusBarInterceptor", "com/bytedance/ee/bear/document/customheader/CustomHeaderFragment$statusBarInterceptor$1", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderFragment$statusBarInterceptor$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "onDestroyView", "onBackPressed", "updateView", "data", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig;", "setViewAndChildrenEnabled", "enabled", "decorateTitle", "decorate", "name", "iconResource", "clickListener", "Landroid/view/View$OnClickListener;", "handleBusinessLogic", "menu", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig$Menu;", "createMenuIconView", "menuMarginLeft", "menuMarginRight", "createMenuTextView", "setStatusBarColor", "statusBarColor", "lightStatusBar", "getColors", "", "context", "Landroid/content/Context;", "customColor", "", "(Landroid/content/Context;[Ljava/lang/String;)[I", "makeTitleCenter", SimpleItemModel.ITEM_STYLE_DISABLE, "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomHeaderFragment extends BaseFragment {
    public static final /* synthetic */ int z = 0;
    public CustomHeaderViewModel e;
    public CommentPanelViewModel f;
    public xu5.b.a g;
    public LinearLayout h;
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
    public boolean w;
    public Pair<Integer, Boolean> x;
    public final g y;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CustomHeaderFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CustomHeaderConfig.Menu c;

        public b(CustomHeaderFragment r1, String r2, CustomHeaderConfig.Menu r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            CustomHeaderViewModel r4 = this.a.e;
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
            r4 = null;
        L5:
            CustomHeaderViewModel.a r5 = r4.getDelegate();
            if (r5 == null) goto L9;
            r5.a(this.b, this.c.getExtraId());
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CustomHeaderConfig.Menu a;
        public final /* synthetic */ CustomHeaderFragment b;

        public c(CustomHeaderConfig.Menu r1, CustomHeaderFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            String r4 = this.a.getId();
            if (r4 == null) goto L11;
            CustomHeaderFragment r0 = this.b;
            CustomHeaderConfig.Menu r1 = this.a;
            CustomHeaderViewModel r2 = r0.e;
            if (r2 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
            r2 = null;
        L7:
            CustomHeaderViewModel.a r5 = r2.getDelegate();
            if (r5 == null) goto L12;
            r5.a(r4, r1.getExtraId());
            return;
        L12:
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ CustomHeaderFragment a;

        public d(CustomHeaderFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CustomHeaderFragment r0 = this.a;     // Catch: Throwable -> L4
            int r1 = CustomHeaderFragment.z;     // Catch: Throwable -> L4
            r0.Y90();     // Catch: Throwable -> L4
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
        public final /* synthetic */ CustomHeaderFragment a;

        public e(CustomHeaderFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r17) {
            CustomHeaderConfig r0 = (CustomHeaderConfig) r17;
            CustomHeaderFragment r2 = this.a;
            CustomHeaderViewModel r3 = null;
            if (r0 == null) goto L225;
            int r4 = CustomHeaderFragment.z;
            r2.getClass();
            String r5 = r0.getThemeColor();
            if (r5 == null) goto L16;
            int r6 = ColorUtils.h(r5);
            boolean r7 = ColorUtils.f(r6);
            View r8 = r2.getView();
            if (r8 == null) goto L9;
            r8.setBackgroundColor(r6);
        L9:
            if (r7 == false) goto L11;
            String r9 = CustomHeaderConfig.COLOR_LIGHT;
        L12:
            r2.k = r9;
            r2.Z90(r6, !r7);
            CommentPanelViewModel r10 = r2.f;
            if (r10 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("commentPanelViewModel");
            r10 = null;
        L15:
            r10.isShowingComment().observe(r2, new p05.a(r2, r6, r7));
            goto L16
        L11:
            r9 = CustomHeaderConfig.COLOR_DARK;
        L16:
            ViewGroup r11 = r2.l;
            if (r11 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
            r11 = null;
        L19:
            r11.removeAllViews();
            ViewGroup r12 = r2.m;
            if (r12 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
            r12 = null;
        L22:
            r12.removeAllViews();
            CustomHeaderConfig.MenuItems r13 = r0.getItems();
            boolean r14 = true;
            if (r13 == null) goto L62;
            CustomHeaderConfig.Menu[] r16 = r13.getLeft();
            if (r16 == null) goto L43;
            int r18 = r16.length;
            int r19 = 0;
        L27:
            if (r19 >= r18) goto L43;
            CustomHeaderConfig.Menu r110 = r16[r19];
            if (r110.getId() == null) goto L42;
            if (Intrinsics.areEqual(r110.getStyle(), "text") == false) goto L34;
            int r111 = r2.t;
            View r112 = r2.V90(r110, r111, r111);
        L35:
            int r113 = com.bytedance.ee.bear.document.customheader.b.a;
            if (Intrinsics.areEqual("docx_embedded_history_exit", r110.getExtraId()) == false) goto L38;
            r2.v = r110.getExtraId();
        L38:
            ViewGroup r20 = r2.l;
            if (r20 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
            r20 = null;
        L41:
            r20.addView(r112);
            goto L42
        L34:
            int r114 = r2.t;
            r112 = r2.U90(r110, r114, r114);
        L42:
            r19 = r19 + 1;
        L43:
            CustomHeaderConfig.Menu[] r21 = r13.getRight();
            if (r21 == null) goto L62;
            int r22 = r21.length;
            int r23 = 0;
            boolean r24 = true;
        L46:
            if (r23 >= r22) goto L62;
            CustomHeaderConfig.Menu r115 = r21[r23];
            if (r115.getId() == null) goto L61;
            if (r24 == false) goto L52;
            int r26 = r2.u;
            boolean r116 = false;
        L54:
            if (Intrinsics.areEqual(r115.getStyle(), "text") == false) goto L56;
            View r27 = r2.V90(r115, r26, r2.u);
        L57:
            ViewGroup r117 = r2.m;
            if (r117 != null) goto L60;
            Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
            r117 = null;
        L60:
            r117.addView(r27);
            r24 = r116;
            goto L61
        L56:
            r27 = r2.U90(r115, r26, r2.u);
            goto L57
        L52:
            r116 = r24;
            r26 = 0;
        L61:
            r23 = r23 + 1;
        L62:
            CustomHeaderConfig.TitleConfig r28 = r0.getTitleConfig();
            if (r28 != null) goto L65;
        L67:
            boolean r29 = false;
        L69:
            if (r29 == false) goto L78;
            LinearLayout r30 = r2.i;
            if (r30 != null) goto L73;
            Intrinsics.throwUninitializedPropertyAccessException("btnTitleBg");
            r30 = null;
        L73:
            Context r31 = r2.getContext();
            if (r31 == null) goto L76;
            Drawable r32 = AppCompatResources.getDrawable(r31, 2131232424);
        L77:
            r30.setBackground(r32);
        L82:
            Context r33 = r2.getContext();
            if (r33 == null) goto L97;
            TextView r34 = r2.j;
            if (r34 != null) goto L87;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r34 = null;
        L87:
            CustomHeaderConfig.TitleConfig r36 = r0.getTitleConfig();
            if (r36 != null) goto L90;
        L92:
            boolean r37 = false;
        L93:
            if (r37 == false) goto L95;
            Typeface r38 = h18.e.b(r33, 1);
        L96:
            r34.setTypeface(r38);
            goto L97
        L95:
            r38 = h18.e.b(r33, 0);
            goto L96
        L90:
            if (r36.isBold() != true) goto L92;
            r37 = true;
        L97:
            TextView r39 = r2.j;
            if (r39 != null) goto L100;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r39 = null;
        L100:
            CustomHeaderConfig.TitleConfig r40 = r0.getTitleConfig();
            if (r40 == null) goto L105;
            String r41 = r40.getTitle();
            if (r41 == null) goto L105;
        L106:
            r39.setText(r41);
            CustomHeaderConfig.TitleConfig r42 = r0.getTitleConfig();
            if (r42 == null) goto L109;
            boolean r43 = Intrinsics.areEqual(r42.isLoading(), Boolean.TRUE);
        L111:
            if (r43 == false) goto L131;
            TextView r44 = r2.j;
            if (r44 != null) goto L115;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r44 = null;
        L115:
            r44.setTextColor(r2.getResources().getColor(2131103404));
            ImageView r46 = r2.n;
            if (r46 != null) goto L118;
            Intrinsics.throwUninitializedPropertyAccessException("syncIcon");
            r46 = null;
        L118:
            r46.setVisibility(0);
            ObjectAnimator r47 = r2.q;
            if (r47 != null) goto L122;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r47 = null;
        L122:
            if (r47.isStarted() == false) goto L127;
            ObjectAnimator r48 = r2.q;
            if (r48 != null) goto L126;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r48 = null;
        L126:
            r48.resume();
        L144:
            CustomHeaderConfig.TitleConfig r49 = r0.getTitleConfig();
            if (r49 == null) goto L151;
            String r50 = r49.getPosition();
            if (r50 == null) goto L151;
            if (Intrinsics.areEqual(r50, CustomHeaderConfig.TitleConfig.Position.CENTER) == false) goto L151;
            r2.Y90();
        L151:
            View r51 = r2.r;
            if (r51 != null) goto L155;
            Intrinsics.throwUninitializedPropertyAccessException("divider");
            r51 = null;
        L155:
            if (Intrinsics.areEqual(r0.getShouldShowDivider(), Boolean.TRUE) == false) goto L157;
            int r52 = 0;
        L158:
            r51.setVisibility(r52);
            CustomHeaderConfig.TitleConfig r53 = r0.getTitleConfig();
            if (r53 == null) goto L214;
            ImageView r118 = r2.o;
            if (r118 != null) goto L163;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r118 = null;
        L163:
            Integer r119 = r0.getTitleIcon(r53.getTitleIcon(), r118.getContext());
            if (r119 == null) goto L166;
            int r120 = 0;
            r118.setVisibility(0);
            r118.setImageResource(r119.intValue());
        L170:
            ImageView r121 = r2.p;
            if (r121 != null) goto L174;
            Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
            r121 = null;
        L174:
            if (r53.getShowFoldBtn() == false) goto L176;
            int r122 = 0;
        L177:
            r121.setVisibility(r122);
            String r123 = r53.getOnboardingKey();
            if (r123 != null) goto L180;
        L183:
            if (r14 == true) goto L189;
            LinearLayout r54 = r2.h;
            if (r54 != null) goto L187;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r54 = null;
        L187:
            r54.setTag(r53.getOnboardingKey());
        L189:
            if (r53.getId() == null) goto L209;
            String r56 = r53.getId();
            if (r56 == null) goto L214;
            LinearLayout r124 = r2.h;
            if (r124 != null) goto L195;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r124 = null;
        L195:
            r124.setOnClickListener(new com.bytedance.ee.bear.document.customheader.a(r2, r56));
            LinearLayout r57 = r2.h;
            if (r57 != null) goto L198;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r57 = null;
        L198:
            boolean r58 = r53.getEnable();
            r57.setEnabled(r58);
            if (r58 == false) goto L201;
            float r125 = 1.0f;
        L202:
            r57.setAlpha(r125);
            int r126 = r57.getChildCount();
        L203:
            if (r120 >= r126) goto L214;
            View r127 = r57.getChildAt(r120);
            r127.setEnabled(r58);
            if (r58 == false) goto L207;
            float r128 = 1.0f;
        L208:
            r127.setAlpha(r128);
            r120 = r120 + 1;
            goto L203
        L207:
            r128 = 0.5f;
            goto L208
        L201:
            r125 = 0.5f;
            goto L202
        L209:
            LinearLayout r59 = r2.h;
            if (r59 != null) goto L212;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r59 = null;
        L212:
            r59.setOnClickListener(null);
            goto L214
        L180:
            if (r123.length() == 0) goto L183;
            r14 = false;
            goto L183
        L176:
            r122 = 8;
            goto L177
        L166:
            r120 = 0;
            ImageView r129 = r2.o;
            if (r129 != null) goto L169;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r129 = null;
        L169:
            r129.setVisibility(8);
        L214:
            if (r0.getTitleConfig() != null) goto L225;
            ImageView r1 = r2.o;
            if (r1 != null) goto L218;
            Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
            r1 = null;
        L218:
            r1.setVisibility(8);
            ImageView r60 = r2.p;
            if (r60 != null) goto L221;
            Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
            r60 = null;
        L221:
            r60.setVisibility(8);
            LinearLayout r61 = r2.h;
            if (r61 != null) goto L224;
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            r61 = null;
        L224:
            r61.setOnClickListener(null);
            goto L225
        L157:
            r52 = 8;
            goto L158
        L127:
            ObjectAnimator r62 = r2.q;
            if (r62 != null) goto L130;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r62 = null;
        L130:
            r62.start();
            goto L144
        L131:
            TextView r63 = r2.j;
            if (r63 != null) goto L134;
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            r63 = null;
        L134:
            String r64 = r2.k;
            if (r64 != null) goto L137;
            Intrinsics.throwUninitializedPropertyAccessException("titleColor");
            r64 = null;
        L137:
            r63.setTextColor(ColorUtils.h(r64));
            ImageView r66 = r2.n;
            if (r66 != null) goto L140;
            Intrinsics.throwUninitializedPropertyAccessException("syncIcon");
            r66 = null;
        L140:
            r66.setVisibility(8);
            ObjectAnimator r67 = r2.q;
            if (r67 != null) goto L143;
            Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
            r67 = null;
        L143:
            r67.cancel();
            goto L144
        L109:
            r43 = false;
        L105:
            r41 = "";
            goto L106
        L76:
            r32 = null;
            goto L77
        L78:
            LinearLayout r68 = r2.i;
            if (r68 != null) goto L81;
            Intrinsics.throwUninitializedPropertyAccessException("btnTitleBg");
            r68 = null;
        L81:
            r68.setBackground(null);
            goto L82
        L65:
            if (r28.getHasBorder() != true) goto L67;
            r29 = true;
        L225:
            CustomHeaderViewModel r69 = r2.e;
            if (r69 != null) goto L228;
            Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
        L229:
            r3.getStatusBarDiffHeight().observe(r2, new p05.b(r2));
            View r70 = r2.getView();
            if (r70 == null) goto L242;
            r70.addOnLayoutChangeListener(new p05.c(r2));
            return;
        L242:
            return;
        L228:
            r3 = r69;
            goto L229
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ CustomHeaderFragment a;

        public f(CustomHeaderFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            View r0 = this.a.getView();
            if (r0 == null) goto L5;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        L6:
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L9;
            int r5 = k.e(this.a.getContext());
        L10:
            r2.topMargin = r5;
            return;
        L9:
            r5 = 0;
            goto L10
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class g implements bp5.c.a {
        public final /* synthetic */ CustomHeaderFragment a;

        public final boolean interceptSetSystemUiVisibility(Activity r1, int r2) {
            return true;
        }

        public g(CustomHeaderFragment r1) {
            this.a = r1;
        }

        public final boolean interceptSetStatusBarColor(Activity r2, int r3, boolean r4) {
            CustomHeaderFragment r5 = this.a;
            r5.x = new Pair(Integer.valueOf(r3), Boolean.valueOf(r4));
            return false;
        }
    }

    static {
    }

    public final void Y90() {
        if (this.w == false) goto L6;
        return;
    L6:
        if (isAdded() == true) goto L8;
        return;
    L8:
        View r0 = getView();
        if (r0 == null) goto L11;
        int r1 = r0.getWidth();
    L13:
        if (ForsetiHelper.s(this) == false) goto L17;
        if (r1 != 0) goto L17;
        hac.b.a.b("CustomHeaderFragment", "fragmentWidth is 0, post runnable");
        j.c(new d(this));
        return;
    L17:
        TextView r2 = this.j;
        LinearLayout r3 = null;
        if (r2 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r2 = null;
    L20:
        r2.setGravity(17);
        Context r4 = getContext();
        Context r5 = getContext();
        if (r5 != null) goto L23;
        return;
    L23:
        if (ForsetiHelper.s(this) == false) goto L26;
    L39:
        int r6 = View.MeasureSpec.makeMeasureSpec(1073741823, 0);
        ViewGroup r7 = this.l;
        if (r7 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
        r7 = null;
    L42:
        r7.measure(r6, r6);
        ViewGroup r8 = this.m;
        if (r8 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
        r8 = null;
    L45:
        r8.measure(r6, r6);
        ViewGroup r9 = this.l;
        if (r9 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("leftMenuContainer");
        r9 = null;
    L48:
        int r10 = r9.getMeasuredWidth();
        ViewGroup r11 = this.m;
        if (r11 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("rightMenuContainer");
        r11 = null;
    L51:
        int r12 = Math.max(r10, r11.getMeasuredWidth());
        LinearLayout r13 = this.h;
        if (r13 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r13 = null;
    L54:
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof RelativeLayout.LayoutParams) == false) goto L57;
        RelativeLayout.LayoutParams r16 = (RelativeLayout.LayoutParams) r14;
    L58:
        if (r16 == null) goto L60;
        r16.removeRule(17);
        r16.removeRule(16);
        r16.addRule(13, -1);
        r16.width = ((r1 / 2) - r12) * 2;
    L60:
        LinearLayout r17 = this.h;
        if (r17 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    L64:
        r3.setGravity(1);
        return;
    L63:
        r3 = r17;
        goto L64
    L57:
        r16 = null;
        goto L58
    L26:
        if (com.bytedance.ee.util.ui.b.b(r4) == false) goto L36;
        if ((r4 instanceof Activity) == false) goto L36;
        View r18 = ((Activity) r4).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L34;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r19 = ThreadMethodProxy.currentThread();
        if (r19 == com.larus.home.impl.utils.c.a) goto L34;
        com.larus.home.impl.utils.c.a(r19, "getDecorView");
    L34:
        r1 = r18.getWidth();
    L36:
        if (cu5.c.a > 0) goto L38;
        WindowManager r20 = (WindowManager) r5.getSystemService("window");
        DisplayMetrics r21 = new DisplayMetrics();
        r20.getDefaultDisplay().getMetrics(r21);
        cu5.c.a = r21.widthPixels;
    L38:
        r1 = cu5.c.a;
        goto L39
    L11:
        r1 = 0;
        goto L13
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        CustomHeaderViewModel r0 = this.e;
        CustomHeaderViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
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
        CustomHeaderViewModel r4 = this.e;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
    L17:
        CustomHeaderViewModel.a r5 = r1.getDelegate();
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

    public CustomHeaderFragment() {
        this.y = new g(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        Pair<Integer, Boolean> r0 = this.x;
        ObjectAnimator r1 = null;
        if (r0 == null) goto L11;
        Integer r2 = (Integer) r0.getFirst();
        Pair<Integer, Boolean> r3 = this.x;
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.getSecond();
    L8:
        if (r2 == null) goto L14;
        if (r4 == null) goto L14;
        Z90(r2.intValue(), r4.booleanValue());
    L14:
        bp5.c.c(getActivity(), this.y);
        ObjectAnimator r5 = this.q;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("syncAnimator");
    L18:
        r1.cancel();
        return;
    L17:
        r1 = r5;
        goto L18
    L7:
        r4 = null;
        goto L8
    L11:
        xu5.b.a r6 = this.g;
        if (r6 == null) goto L14;
        r6.resetState();
        goto L14
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        FragmentActivity r5 = getActivity();
        CustomHeaderViewModel r0 = null;
        if (r5 == null) goto L5;
        xu5.b.a r6 = xu5.b.b(r5, null);
    L6:
        this.g = r6;
        if (r6 == null) goto L9;
        r6.saveState();
    L9:
        CustomHeaderViewModel r7 = (CustomHeaderViewModel) q.a(this, CustomHeaderViewModel.class);
        this.e = r7;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
        r7 = null;
    L12:
        r7.getHeaderData().observe(this, new e(this));
        CustomHeaderViewModel r8 = this.e;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
        r8 = null;
    L15:
        r8.isStatusBarImmersive().observe(this, new f(this));
        CustomHeaderViewModel r9 = this.e;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
    L19:
        r0.isCustomHeaderVisible().observe(this, new AnonymousClass4(this));
        this.f = (CommentPanelViewModel) q.a(this, CommentPanelViewModel.class);
        return;
    L18:
        r0 = r9;
        goto L19
    L5:
        r6 = null;
        goto L6
    }

    public final int[] X90(Context r5, String[] r6) {
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

    public final void Z90(int r3, boolean r4) {
        bp5.c.c(getActivity(), this.y);
        xu5.b.a r0 = this.g;
        if (r0 == null) goto L5;
        r0.b(r3, r4);
    L5:
        bp5.c.b(getActivity(), this.y);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        this.h = (LinearLayout) r5.findViewById(2131388843);
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

    public final ImageView U90(CustomHeaderConfig.Menu r9, int r10, int r11) {
        ImageView r0 = new ImageView(getContext());
        String r1 = r9.getId();
        if (r1 == null) goto L30;
        Boolean r2 = r9.getEnable();
        if (r2 == null) goto L7;
        boolean r3 = r2.booleanValue();
    L8:
        r0.setEnabled(r3);
        String r4 = r9.getOnboardingKey();
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L17;
        r0.setTag(r9.getOnboardingKey());
    L17:
        String r6 = r9.getIconKey();
        if (r6 == null) goto L31;
        int r7 = n.n(r0.getContext(), r6);
        if (r7 == 0) goto L26;
        r0.setImageDrawable(l.a(r0.getContext(), r7, 2131101926));
    L26:
        int r8 = this.s;
        ViewGroup.MarginLayoutParams r12 = new ViewGroup.MarginLayoutParams(r8, r8);
        r12.leftMargin = r10;
        r12.rightMargin = r11;
        r0.setLayoutParams(r12);
        int[][] r13 = {new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[0]};
        String[] r14 = r9.getCustomColor();
        if (r14 == null) goto L29;
        r0.setImageTintList(new ColorStateList(r13, X90(r0.getContext(), r14)));
    L29:
        r0.setOnClickListener(new b(this, r1, r9));
        goto L30
    L31:
        MenuEnum r16 = MenuEnum.valueOf(r1);     // Catch: Exception -> L24
        r0.setImageDrawable(l.a(r0.getContext(), r16.getImageResId(), r16.getImageResTint()));     // Catch: Exception -> L24
    L24:
        e = move-exception;
        hac.b.a.b("CustomHeaderFragment", "createMenuIconView: " + r1 + " ,not find iconResId:" + e);
        goto L26
    L11:
        if (r4.length() == 0) goto L14;
        r5 = false;
        goto L15
    L7:
        r3 = true;
    L30:
        return r0;
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
        r0.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[0]}, X90(r0.getContext(), r6.getCustomColor())));
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
        return r2.inflate(2131559978, r3, false);
    }

    public final void W90(boolean r5, String r6, int r7, View.OnClickListener r8) {
        LinearLayout r3 = null;
        if (r5 == false) goto L18;
        ImageView r9 = this.o;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
        r9 = null;
    L7:
        r9.setVisibility(0);
        r9.setImageResource(r7);
        ImageView r10 = this.p;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
        r10 = null;
    L10:
        r10.setVisibility(0);
        TextView r11 = this.j;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r11 = null;
    L13:
        r11.setText(r6);
        LinearLayout r12 = this.h;
        if (r12 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    L17:
        r3.setOnClickListener(r8);
        return;
    L16:
        r3 = r12;
        goto L17
    L18:
        ImageView r13 = this.o;
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
        r13 = null;
    L21:
        r13.setVisibility(8);
        ImageView r14 = this.p;
        if (r14 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
        r14 = null;
    L24:
        r14.setVisibility(8);
        LinearLayout r16 = this.h;
        if (r16 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r16 = null;
    L27:
        r16.setOnClickListener(null);
    }
}
