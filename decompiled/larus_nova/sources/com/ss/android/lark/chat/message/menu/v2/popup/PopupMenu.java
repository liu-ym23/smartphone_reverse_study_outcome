package com.ss.android.lark.chat.message.menu.v2.popup;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.chat.message.menu.v2.o0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class PopupMenu implements com.ss.android.lark.chat.message.menu.v2.popup.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f415771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Point f415772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f415773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o0 f415774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f415775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f415776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PopupMenuMainContent f415777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PopupMenuSubContent f415778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PopupMenuPartialContent f415779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f415780j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f415781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final yya.a f415782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.ss.android.lark.chat.message.menu.d f415783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public o0 f415784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Point f415785e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f415786f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f415787g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.ss.android.lark.biz.im.api.message.params.m f415788h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f415789i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f415790j;

        public final Activity getActivity() {
            return this.f415781a;
        }

        public a(Activity r100, yya.a r101, com.ss.android.lark.chat.message.menu.d r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "actionContext");
            Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
            this.f415781a = r100;
            this.f415782b = r101;
            this.f415783c = r102;
        }
    }

    public interface b {
        void a(boolean r100, MessageActionType r101, boolean r102);

        void onShow();
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void c(zya.b r100, List<zya.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "parentAction");
        Intrinsics.checkNotNullParameter(r101, "childActions");
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.a
    public final void e() {
        PopupMenuSubContent r100 = this.f415778h;
        if (r100 == null) goto L13;
        PopupMenuRootView r101 = f();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "view");
        int r102 = r101.getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        View r104 = r101.getChildAt(r103);
        if (Intrinsics.areEqual(r104, r100.getParent()) == true) goto L11;
        r103 = r103 + 1;
    L11:
        if (r104 == null) goto L13;
        r104.animate().alpha(0.0f).setDuration(200).withEndAction(new o(r101, r104)).start();
        goto L13
    L10:
        r104 = null;
    L13:
        this.f415778h = null;
        PopupMenuMainContent r105 = this.f415777g;
        if (r105 == null) goto L22;
        ValueAnimator r106 = r105.f415830h;
        if (r106 == null) goto L18;
        r106.cancel();
    L18:
        r105.f415827e = true;
        r105.f415829g = 1.0f;
        r105.invalidate();
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r107.setDuration(150);
        r107.setInterpolator(new DecelerateInterpolator());
        r107.addUpdateListener(new i(r105));
        Intrinsics.checkNotNull(r107);
        r107.addListener(new j(r105));
        r107.start();
        r105.f415830h = r107;
        r105.setOnClickListener(null);
        r105.setClickable(false);
        return;
    }

    public final PopupMenuRootView f() {
        return (PopupMenuRootView) this.f415776f.getValue();
    }

    public final void g() {
        ViewParent r100 = f().getParent();
        AttributeSet r101 = null;
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r100;
    L6:
        if (r102 == null) goto L9;
        r102.removeView(f());
    L9:
        if (this.f415773c.f415887e == false) goto L11;
        f().setBackgroundColorRes(R.color.transparent);
    L11:
        ((ViewGroup) this.f415780j.getValue()).addView(f(), new ViewGroup.LayoutParams(-1, -1));
        int r103 = 6;
        int r104 = 0;
        if (this.f415773c.f415887e == false) goto L14;
        PopupMenuPartialContent r105 = new PopupMenuPartialContent(this.f415771a, r101, r103, r104);
        r105.setMenuContext(this.f415773c);
        this.f415779i = r105;
        PopupMenuRootView.b(f(), r105, this.f415772b, 28);
    L15:
        PopupMenuRootView r106 = f();
        if (r106.isAttachedToWindow() == false) goto L23;
        r106.f415867e.setAlpha(0.0f);
        r106.f415867e.animate().alpha(1.0f).setDuration(200).start();
        int r107 = r106.getChildCount();
    L18:
        if (r104 >= r107) goto L24;
        View r108 = r106.getChildAt(r104);
        if (Intrinsics.areEqual(r108, r106.f415867e) == true) goto L22;
        r108.setAlpha(0.0f);
        r108.setScaleX(0.98f);
        r108.setScaleY(0.98f);
        r108.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
    L22:
        r104 = r104 + 1;
    L24:
        f().post(new c(this));
        return;
    L23:
        r106.addOnAttachStateChangeListener(new p(r106, r106));
        goto L24
    L14:
        PopupMenuMainContent r109 = new PopupMenuMainContent(this.f415771a, null, 6, 0);
        r109.setMenuContext(this.f415773c);
        r109.setOnReactionClickListener(this.f415774d);
        this.f415777g = r109;
        PopupMenuRootView.b(f(), r109, this.f415772b, 28);
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    public PopupMenu(final a r100) {
        this.f415771a = r100.getActivity();
        this.f415772b = r100.f415785e;
        int r101 = d.f415882f;
        Intrinsics.checkNotNullParameter(r100, "builder");
        d r102 = new d(r100.f415782b, r100.f415783c, r100.f415788h);
        r102.f415887e = r100.f415787g;
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r102.f415886d = this;
        this.f415773c = r102;
        this.f415774d = r100.f415784d;
        this.f415775e = r100.f415786f;
        this.f415776f = LazyKt.lazy(new PopupMenu$rootView$2(this, r100));
        this.f415780j = LazyKt.lazy(new PopupMenu$decorView$2(this));
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void a(PanelType r110) {
        Intrinsics.checkNotNullParameter(r110, "toType");
        if (r110 != PanelType.EMOJI) goto L26;
        PopupMenuEmojiPanelContent r100 = new PopupMenuEmojiPanelContent(this.f415771a, null, 6, 0);
        r100.setMenuContext(this.f415773c);
        r100.setOnReactionClickListener(this.f415774d);
        PopupMenuRootView.b(f(), r100, null, 30);
        PopupMenuRootView r101 = f();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r110, "toPanelType");
        int r102 = r101.getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L34;
        View r104 = r101.getChildAt(r103);
        if (Intrinsics.areEqual(r104, r101.f415867e) == true) goto L25;
        if ((r104 instanceof PopupMenuContentContainer) == false) goto L11;
        PopupMenuContentContainer r105 = (PopupMenuContentContainer) r104;
    L12:
        if (r105 == null) goto L25;
        PanelType r106 = r105.getPanelType();
        if (r106 != r110) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L23;
        if (r106 != PanelType.EMOJI) goto L25;
        OneShotPreDrawListener.add(r105, new n(r105, r105));
        goto L25
    L23:
        if (r106 != PanelType.ACTION) goto L25;
        r105.animate().alpha(0.0f).setDuration(200).withEndAction(new m(r101, r105)).start();
        goto L25
    L17:
        r107 = false;
        goto L18
    L11:
        r105 = null;
    L25:
        r103 = r103 + 1;
        goto L5
    L34:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chat.message.menu.v2.popup.a
    public final void b(List r110, PopupMenuItem r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r111, "parentItemView");
        if (this.f415778h == null) goto L5;
        e();
    L5:
        View r100 = null;
        Object[] r101 = 0 == true ? 1 : 0;
        PopupMenuSubContent r102 = new PopupMenuSubContent(this.f415771a, r101, 6, 0);
        r102.setMenuContext(this.f415773c);
        r102.setParentItemWidth(r111.getMeasuredWidth());
        r102.setActions(r110);
        int[] r103 = new int[2];
        r111.getLocationInWindow(r103);
        int r104 = r103[0];
        Rect r105 = new Rect(r104, r103[1], r111.getMeasuredWidth() + r104, r103[1] + r111.getMeasuredHeight());
        f().a(r102, null, r105, PopupMenuContentContainer.AnchorStyle.OVERLAY, r112);
        this.f415778h = r102;
        PopupMenuMainContent r113 = this.f415777g;
        if (r113 == null) goto L11;
        ValueAnimator r106 = r113.f415830h;
        if (r106 == null) goto L10;
        r106.cancel();
    L10:
        r113.f415827e = true;
        r113.f415829g = 0.0f;
        r113.invalidate();
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r114.setDuration(150);
        r114.setInterpolator(new DecelerateInterpolator());
        r114.addUpdateListener(new l(r113));
        r114.start();
        r113.f415830h = r114;
        r113.setOnClickListener(new k(r113));
    L11:
        ViewParent r115 = r102.getParent();
        if ((r115 instanceof View) == false) goto L14;
        r100 = (View) r115;
    L14:
        if (r100 == null) goto L17;
        r100.setAlpha(0.0f);
        r100.animate().alpha(1.0f).setDuration(200).start();
        return;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void d(final boolean r100, final MessageActionType r101, final boolean r102) {
        PopupMenuRootView r103 = f();
        Function0<Unit> r104 = new PopupMenu$dismiss$1(this, r100, r101, r102);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "completion");
        r103.f415867e.animate().alpha(0.0f).setDuration(200).withEndAction(new PopupMenuRootView.a(r104)).start();
        int r105 = r103.getChildCount();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L8;
        View r107 = r103.getChildAt(r106);
        if (Intrinsics.areEqual(r107, r103.f415867e) == true) goto L7;
        r107.animate().alpha(0.0f).setDuration(200).start();
    L7:
        r106 = r106 + 1;
        goto L3
    }
}
