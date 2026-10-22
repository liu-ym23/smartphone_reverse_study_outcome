package rjb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.guide.ui.common.popup.view.MaskView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rjb.a f538197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f538198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f538199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f538200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f538201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public sjb.a f538202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f538203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Size f538204h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MaskView f538205i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f538206a = null;

        static {
            f538206a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Log.d("GuidePopup", "MaskView click");
        }
    }

    /* JADX INFO: renamed from: rjb.c$c, reason: collision with other inner class name */
    public static final class C7495c implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f538207a;

        public C7495c(c r100) {
            this.f538207a = r100;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            c r100 = this.f538207a;
            MaskView r101 = r100.f538205i;
            if (r101 == null) goto L7;
            ViewParent r102 = r101.getParent();
            if (r102 == null) goto L7;
            AlphaAnimation r103 = new AlphaAnimation(1.0f, 0.0f);
            r103.setDuration(200);
            r103.setInterpolator(new DecelerateInterpolator());
            r103.setAnimationListener(new d(r102, r100));
            r101.startAnimation(r103);
        L7:
            PopupWindow.OnDismissListener r104 = this.f538207a.f538197a.f538196m;
            if (r104 == null) goto L11;
            r104.onDismiss();
            return;
        }
    }

    static {
    }

    @Override // rjb.g
    public void close() {
        sjb.a r100 = this.f538202f;
        if (r100 == null) goto L6;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
        return;
    }

    @Override // rjb.g
    public boolean isShowing() {
        sjb.a r100 = this.f538202f;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isShowing();
    }

    @Override // rjb.g
    public boolean show() {
        View r100 = this.f538197a.f538185b;
        if (r100 != null) goto L7;
        Log.i("GuidePopup", "params.anchorView is null");
        return false;
    L7:
        if (r100.getWindowToken() != null) goto L10;
        Log.i("GuidePopup", "anchorView.windowToken is null, anchorView.isAttachedToWindow=" + r100.isAttachedToWindow());
        return false;
    L10:
        rjb.b r101 = this.f538197a.f538184a;
        if (r101 != null) goto L14;
        Log.i("GuidePopup", "params.component is null");
        return false;
    L14:
        int r102 = h.f538224b;
        Intrinsics.checkNotNullParameter(r101, "component");
        h r103 = new h(r101);
        Context r104 = r100.getContext();
        if ((r104 instanceof Activity) == false) goto L19;
        Activity r105 = (Activity) r104;
    L17:
        Activity r110 = r105;
        Intrinsics.checkNotNull(r104);
        e(r104);
        this.f538203g = d(r104, r103);
        Rect r111 = b(r100);
        LinearLayout r106 = this.f538203g;
        Intrinsics.checkNotNull(r106);
        Point r107 = c(r103.a(r106, this.f538204h, r111), r103);
        int r108 = this.f538204h.getWidth();     // Catch: Exception -> L58
        int r109 = this.f538204h.getHeight();     // Catch: Exception -> L58
        if (r108 <= 0) goto L55;
        if (r109 <= 0) goto L55;
        sjb.a r112 = new sjb.a(this.f538203g, r108, r109);     // Catch: Exception -> L58
        Boolean r113 = this.f538197a.f538195l;     // Catch: Exception -> L58
        if (r113 == null) goto L33;
        boolean r114 = r113.booleanValue();     // Catch: Exception -> L58
    L34:
        r112.setFocusable(r114);     // Catch: Exception -> L58
        Boolean r115 = this.f538197a.f538186c;     // Catch: Exception -> L58
        if (r115 == null) goto L37;
        boolean r116 = r115.booleanValue();     // Catch: Exception -> L58
    L38:
        r112.setOutsideTouchable(r116);     // Catch: Exception -> L58
        this.f538197a.getClass();     // Catch: Exception -> L58
        r112.setBackgroundDrawable(new ColorDrawable(0));     // Catch: Exception -> L58
        r112.setAnimationStyle(R.style.GuideUiTheme_Popup);     // Catch: Exception -> L58
        r112.setOnDismissListener(new C7495c(this));     // Catch: Exception -> L58
        int r117 = r107.x;     // Catch: Exception -> L58
        int r118 = r107.y;     // Catch: Exception -> L58
        if (PopupWindowLancet.hasSubWindowToken(r100) == false) goto L42;
    L48:
        this.f538202f = r112;     // Catch: Exception -> L58
        if (r112.isShowing() != true) goto L51;
        boolean r119 = true;
    L52:
        if (r119 == false) goto L63;
        a(r110, r100, r111);     // Catch: Exception -> L58
        return true;
    L63:
        return false;
    L51:
        r119 = false;
        goto L52
    L42:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r112) == false) goto L44;
        r112.showAtLocation(r100, 8388659, r117, r118);     // Catch: Exception -> L58
        goto L48
    L44:
        OverlaySource r120 = PopupWindowLancet.resolveSource(r100);     // Catch: Exception -> L58
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r112, r100, r120, 8388659, r117, r118) == true) goto L48;
        r112.showAtLocation(r100, 8388659, r117, r118);     // Catch: Exception -> L58
        PopupWindowLancet.trackAfterShow(r112, r120, r100);     // Catch: Exception -> L58
        goto L48
    L37:
        r116 = true;
        goto L38
    L33:
        r114 = true;
    L55:
        Log.w("GuidePopup", "show error, width=" + r108 + ", height=" + r109);     // Catch: Exception -> L58
        return false;
    L58:
        e = move-exception;
        Log.e("GuidePopup", "show error", e);
        return false;
    L19:
        if (this.f538197a.getActivity() == null) goto L21;
        r105 = this.f538197a.getActivity();
        goto L17
    L21:
        r105 = ViewUtils.getActivityByContext(r104);
        if (r105 != null) goto L17;
        Log.i("GuidePopup", "not found activity");
        return false;
    }

    public c(rjb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f538197a = r100;
        this.f538204h = new Size(0, 0);
    }

    public static Rect b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        int r101 = r100.getMeasuredWidth();
        int r102 = r100.getMeasuredHeight();
        int[] r103 = new int[2];
        r100.getLocationInWindow(r103);
        Rect r104 = new Rect();
        int r105 = r103[0];
        r104.left = r105;
        int r106 = r103[1];
        r104.top = r106;
        r104.right = r105 + r101;
        r104.bottom = r106 + r102;
        return r104;
    }

    public final void e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = DeviceUtils.getScreenWidth(r100);
        int r102 = DeviceUtils.getScreenHeight(r100);
        int r103 = UIUtils.dp2px(r100, 12.0f);
        this.f538198b = r103;
        this.f538199c = r101 - r103;
        this.f538200d = StatusBarUtil.getStatusBarHeight(r100) + r103;
        this.f538201e = r102 - r103;
    }

    public final Point c(Point r100, h r110) {
        Intrinsics.checkNotNullParameter(r100, "targetPoint");
        Intrinsics.checkNotNullParameter(r110, "popupCell");
        Rect r101 = r110.d();
        int r102 = 0;
        if (r101.left == 0) goto L5;
    L33:
        Point r103 = new Point();
        r103.x = r100.x;
        r103.y = r100.y;
        int r104 = r110.e();
        if ((r104 & 48) != 48) goto L36;
    L37:
        int r105 = r103.x;
        int r106 = r101.left + r105;
        int r107 = (r105 + this.f538204h.getWidth()) - r101.right;
        int r108 = this.f538198b;
        if (r106 >= r108) goto L40;
        r102 = r106 - r108;
        r103.x = r108 - r101.left;
    L44:
        if ((r104 & 3) != 3) goto L46;
    L47:
        int r109 = r103.y;
        int r111 = r101.top + r109;
        int r112 = (r109 + this.f538204h.getHeight()) - r101.bottom;
        int r113 = this.f538200d;
        if (r111 >= r113) goto L50;
        r102 = r111 - r113;
        r103.y = r113 - r101.top;
    L53:
        LinearLayout r114 = this.f538203g;
        Intrinsics.checkNotNull(r114);
        r110.f(r114, this.f538204h, r102);
        return r103;
    L50:
        int r115 = this.f538201e;
        if (r112 <= r115) goto L53;
        r102 = r112 - r115;
        r103.y = (r115 - this.f538204h.getHeight()) + r101.bottom;
        goto L53
    L46:
        if ((r104 & 5) != 5) goto L53;
    L40:
        int r116 = this.f538199c;
        if (r107 <= r116) goto L44;
        r102 = r107 - r116;
        r103.x = (r116 - this.f538204h.getWidth()) + r101.right;
        goto L44
    L36:
        if ((r104 & 80) != 80) goto L44;
    L5:
        if (r101.top != 0) goto L33;
        if (r101.right != 0) goto L33;
        if (r101.bottom != 0) goto L33;
        Point r117 = new Point();
        r117.x = r100.x;
        r117.y = r100.y;
        int r118 = r110.e();
        if ((r118 & 48) != 48) goto L14;
    L15:
        int r119 = r117.x;
        int r120 = this.f538198b;
        if (r119 >= r120) goto L19;
        r102 = r119 - r120;
        r117.x = r120;
    L22:
        if ((r118 & 3) != 3) goto L24;
    L25:
        int r121 = r117.y;
        int r122 = this.f538200d;
        if (r121 >= r122) goto L29;
        r102 = r121 - r122;
        r117.y = r122;
    L31:
        LinearLayout r123 = this.f538203g;
        Intrinsics.checkNotNull(r123);
        r110.f(r123, this.f538204h, r102);
        return r117;
    L29:
        if ((r121 + this.f538204h.getHeight()) <= this.f538201e) goto L31;
        int r124 = r117.y + this.f538204h.getHeight();
        int r125 = this.f538201e;
        r102 = r124 - r125;
        r117.y = r125 - this.f538204h.getHeight();
        goto L31
    L24:
        if ((r118 & 5) != 5) goto L31;
    L19:
        if ((r119 + this.f538204h.getWidth()) <= this.f538199c) goto L22;
        int r126 = r117.x + this.f538204h.getWidth();
        int r127 = this.f538199c;
        int r128 = r126 - r127;
        r117.x = r127 - this.f538204h.getWidth();
        r102 = r128;
        goto L22
    L14:
        if ((r118 & 80) != 80) goto L22;
        goto L15
    }

    public final LinearLayout d(Context r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "component");
        LinearLayout r102 = new LinearLayout(r100);
        r101.g(r100, r102, this);
        this.f538204h = new Size(UIUtils.getWidth(r102), UIUtils.getHeight(r102));
        r102.setFocusable(true);
        r102.setFocusableInTouchMode(true);
        return r102;
    }

    public final void a(Activity r100, View r101, Rect r102) {
        Boolean r103 = this.f538197a.f538187d;
        Boolean r104 = Boolean.TRUE;
        if (Intrinsics.areEqual(r103, r104) == false) goto L14;
        Integer r105 = this.f538197a.f538189f;
        if (r105 != null) goto L8;
    L9:
        Integer r106 = this.f538197a.f538190g;
        if (r106 == null) goto L14;
        if (r106.intValue() == 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L44;
        this.f538205i = new MaskView(r101.getContext());
        Integer r108 = this.f538197a.f538190g;
        if (r108 == null) goto L19;
        int r109 = r108.intValue();
        MaskView r110 = this.f538205i;
        Intrinsics.checkNotNull(r110);
        r110.setFullingColor(r109);
    L19:
        Integer r111 = this.f538197a.f538189f;
        if (r111 == null) goto L22;
        int r112 = r111.intValue();
        MaskView r113 = this.f538205i;
        Intrinsics.checkNotNull(r113);
        r113.setFullingAlpha(r112);
    L22:
        Boolean r114 = this.f538197a.f538191h;
        if (r114 == null) goto L25;
        boolean r115 = r114.booleanValue();
        MaskView r116 = this.f538205i;
        Intrinsics.checkNotNull(r116);
        r116.setTargetHighlight(r115);
    L25:
        f r117 = this.f538197a.f538194k;
        if (r117 == null) goto L28;
        Rect r118 = r117.a(r102);
        MaskView r119 = this.f538205i;
        Intrinsics.checkNotNull(r119);
        r119.setTargetRect(r118);
    L28:
        Integer r120 = this.f538197a.f538192i;
        if (r120 == null) goto L31;
        int r121 = r120.intValue();
        MaskView r122 = this.f538205i;
        Intrinsics.checkNotNull(r122);
        r122.setHighlightTargetCorner(r121);
    L31:
        Integer r123 = this.f538197a.f538193j;
        if (r123 == null) goto L35;
        int r124 = r123.intValue();
        MaskView r125 = this.f538205i;
        Intrinsics.checkNotNull(r125);
        r125.setHighTargetGraphStyle(r124);
    L35:
        if (Intrinsics.areEqual(this.f538197a.f538186c, r104) == true) goto L37;
        MaskView r126 = this.f538205i;
        Intrinsics.checkNotNull(r126);
        r126.setOnClickListener(b.f538206a);
    L37:
        View r127 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L42;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r128 = ThreadMethodProxy.currentThread();
        if (r128 == com.larus.home.impl.utils.c.f346341a) goto L42;
        com.larus.home.impl.utils.c.a(r128, "getDecorView");
    L42:
        Intrinsics.checkNotNull(r127, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r127).addView(this.f538205i);
        MaskView r129 = this.f538205i;
        Intrinsics.checkNotNull(r129);
        AlphaAnimation r130 = new AlphaAnimation(0.0f, 1.0f);
        r130.setDuration(200);
        r130.setInterpolator(new DecelerateInterpolator());
        r129.startAnimation(r130);
        return;
    L44:
        return;
    L8:
        if (r105.intValue() != 0) goto L9;
    L14:
        r107 = false;
        goto L15
    }
}
