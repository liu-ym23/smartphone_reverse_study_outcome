package com.ss.android.lark.flow.feed.long_click;

import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.shared.page.utils.CanvasUtil;
import com.ss.android.lark.flow.feed.component.title.FlowTitleView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowFeedDialogBuilder extends UDBaseDialogBuilder<FlowFeedDialogBuilder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f423381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f423382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f423383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f423384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f423385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f423386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f423387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f423388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f423389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f423390j;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowFeedDialogBuilder f423391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UDDialog f423392b;

        public b(FlowFeedDialogBuilder r100, UDDialog r101) {
            this.f423391a = r100;
            this.f423392b = r101;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r100) {
            FlowFeedDialogBuilder r101 = this.f423391a;
            UDDialog r102 = this.f423392b;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "dialog");
            Window r103 = r102.getWindow();
            if (r103 == null) goto L9;
            View r104 = FlowFeedDialogBuilder.a(r103);
            if (r104 == null) goto L10;
            com.ss.android.lark.flow.feed.long_click.b r105 = new com.ss.android.lark.flow.feed.long_click.b(r102);
            r101.f423381a.addOnLayoutChangeListener(r105);
            r104.addOnAttachStateChangeListener(new com.ss.android.lark.flow.feed.long_click.a(r101, r105));
            return;
        L10:
            return;
        }
    }

    static {
    }

    public final UDDialog c() {
        final UDDialog r100 = super.build();
        this.f423386f = new FlowFeedDialogBuilder$buildDialog$1(r100);
        Ref.BooleanRef r101 = new Ref.BooleanRef();
        Window r102 = r100.getWindow();
        if (r102 == null) goto L8;
        View r103 = a(r102);
        if (r103 == null) goto L8;
        r103.setOnTouchListener(new c(r101, this, r100));
    L8:
        if (((Boolean) this.f423390j.getValue()).booleanValue() == true) goto L10;
        r100.setOnShowListener(new b(this, r100));
    L10:
        return r100;
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static FlowTitleView d(View r100) {
        if ((r100 instanceof FlowTitleView) == false) goto L7;
        return (FlowTitleView) r100;
    L7:
        if ((r100 instanceof ViewGroup) == true) goto L9;
        return null;
    L9:
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L15;
        FlowTitleView r104 = d(r101.getChildAt(r103));
        if (r104 != null) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        return r104;
    L15:
        return null;
    }

    public static void e(View r100, Canvas r101) {
        if (com.ss.android.lark.feed.shared.fg.c.f421187a.isEnable("lark.feed.dialog_redraw_avatar_view_opt") == false) goto L19;
        View r102 = r100.findViewById(R.id.open_feed_avatar);
        if (r102 != null) goto L7;
        return;
    L7:
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L10;
        ViewGroup r104 = (ViewGroup) r103;
    L11:
        if (r104 != null) goto L13;
        return;
    L13:
        int r105 = CanvasUtil.f421456a;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r104, "avatarContainer");
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r104, "targetView");
        int[] r106 = new int[2];
        r100.getLocationOnScreen(r106);
        int[] r107 = new int[2];
        r104.getLocationOnScreen(r107);
        float r108 = r107[0] - r106[0];
        float r109 = r107[1] - r106[1];
        RectF r110 = new RectF(r108, r109, r104.getWidth() + r108, r104.getHeight() + r109);
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r110, SVGRenderEngine.RECT);
        Paint r111 = new Paint(1);
        r111.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        r101.drawRect(r110, r111);
        float r112 = r110.left;
        float r113 = r110.top;
        int r114 = r101.save();
        r101.translate(r112, r113);
        CanvasUtil.a(r101, r104);     // Catch: Throwable -> L16
        r101.restoreToCount(r114);
        return;
    L16:
        th = move-exception;
        r101.restoreToCount(r114);
        throw th;
    L10:
        r104 = null;
        goto L11
    L19:
        CanvasUtil.e(r101, r100);
    }

    public static final boolean b(FlowFeedDialogBuilder r100, float r101, float r102) {
        int[] r103 = new int[2];
        ((View) r100.f423389i.getValue()).getLocationOnScreen(r103);
        int r104 = r103[0];
        int r105 = r103[1];
        int r106 = ((View) r100.f423389i.getValue()).getWidth() + r104;
        int r107 = ((View) r100.f423389i.getValue()).getHeight() + r105;
        float r108 = r104;
        if (r101 <= r106) goto L5;
    L7:
        boolean r109 = false;
    L8:
        if (r109 == false) goto L16;
        float r110 = r105;
        if (r102 <= r107) goto L12;
    L14:
        boolean r111 = false;
    L15:
        if (r111 == false) goto L16;
        return false;
    L12:
        if (r110 > r102) goto L14;
        r111 = true;
    L16:
        return true;
    L5:
        if (r108 > r101) goto L7;
        r109 = true;
        goto L8
    }

    public FlowFeedDialogBuilder(View r110, final UIFeedCard r111, final ueb.a r112, final LinkedHashMap<FeedActionType, aeb.c> r113, final aeb.a r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r112, "itemContainer");
        Intrinsics.checkNotNullParameter(r113, "feedActionMap");
        Intrinsics.checkNotNullParameter(r114, "actionStatusListener");
        super(r110.getContext());
        this.f423381a = r110;
        this.f423382b = r115;
        this.f423383c = UIHelper.dp2px(30.0f);
        this.f423384d = UIHelper.dp2px(7.0f);
        Rect r100 = new Rect();
        this.f423385e = r100;
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        Lazy r116 = LazyKt.lazy(r101, new FlowFeedDialogBuilder$menuListHeight$2(this, r113));
        this.f423387g = r116;
        Lazy r117 = LazyKt.lazy(r101, new FlowFeedDialogBuilder$isMenuOnBottom$2(this));
        this.f423388h = r117;
        Lazy r102 = LazyKt.lazy(r101, new FlowFeedDialogBuilder$contentView$2(this, r111, r112, r113, r114));
        this.f423389i = r102;
        this.f423390j = LazyKt.lazy(r101, FlowFeedDialogBuilder$disableDialogNoDismiss$2.INSTANCE);
        r110.getGlobalVisibleRect(r100);
        float r103 = r110.getMeasuredWidth() + r100.left;
        gravity(51);
        contentLayout((View) r102.getValue());
        View r104 = new View(getContext());
        r104.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        footerLayout(r104);
        int r105 = UIHelper.px2dp(UIUtils.calcViewScreenLocation(r110).top);
        Rect r106 = new Rect();
        r110.getWindowVisibleDisplayFrame(r106);
        int r107 = UIHelper.px2dp(r106.top);
        if (((Boolean) r117.getValue()).booleanValue() == true) goto L6;
        r105 = (r105 - 4) - UIHelper.px2dp(((Number) r116.getValue()).intValue());
    L6:
        translationOnY(r105 - r107);
        width(UIHelper.px2dp(r103));
        backgroundColor(R.color.transparent);
        if (Build.VERSION.SDK_INT >= 31) goto L9;
        float r108 = 0.3f;
    L10:
        maskAlpha(r108);
        return;
    L9:
        r108 = 0.0f;
        goto L10
    }
}
