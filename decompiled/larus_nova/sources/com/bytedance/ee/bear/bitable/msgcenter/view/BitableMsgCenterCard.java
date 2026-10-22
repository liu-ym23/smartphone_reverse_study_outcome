package com.bytedance.ee.bear.bitable.msgcenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.bitable.common.widgets.SwipeMenuLayout;
import com.bytedance.ee.bear.bitable.databinding.BitableMsgCenterCardBinding;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/msgcenter/view/BitableMsgCenterCard;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableMsgCenterCardBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableMsgCenterCardBinding;", "setBinding", "(Lcom/bytedance/ee/bear/bitable/databinding/BitableMsgCenterCardBinding;)V", "mOnSingleTap", "Lkotlin/Function0;", "", "gestureDetector", "Landroid/view/GestureDetector;", "menuActionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/WrapperActonHandler;", "getMenuActionHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/WrapperActonHandler;", "setMenuActionHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/WrapperActonHandler;)V", "setData", "data", "Lcom/bytedance/ee/bear/bitable/msgcenter/view/BitableMsgCardModel;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableMsgCenterCard extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BitableMsgCenterCardBinding f214693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f214694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GestureDetector f214695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gv4.f f214696d;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMsgCenterCard f214697a;

        public a(BitableMsgCenterCard r100) {
            this.f214697a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            Function0<Unit> r101 = this.f214697a.f214694b;
            if (r101 == null) goto L7;
            r101.invoke();
            return false;
        L7:
            return false;
        }
    }

    public static final class b extends gv4.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableMsgCenterCard f214698b;

        public b(BitableMsgCenterCard r100) {
            this.f214698b = r100;
        }

        @Override // gv4.a
        public final void a(Action r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f214698b.getBinding().f210938a.b();
            gv4.a r101 = this.f482821a;
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }
    }

    public BitableMsgCenterCard(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableMsgCenterCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final BitableMsgCenterCardBinding getBinding() {
        return this.f214693a;
    }

    public final gv4.f getMenuActionHandler() {
        return this.f214696d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f214693a.f210945h.f226698k == true) goto L6;
        this.f214695c.onTouchEvent(r100);
    L6:
        return super.dispatchTouchEvent(r100);
    }

    public final void setBinding(BitableMsgCenterCardBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214693a = r100;
    }

    public final void setMenuActionHandler(gv4.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214696d = r100;
    }

    public BitableMsgCenterCard(Context r210, AttributeSet r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        this.f214695c = new GestureDetector(r210, new a(this));
        View r100 = LayoutInflater.from(r210).inflate(R.layout.bitable_msg_center_card, this, false);
        addView(r100);
        int r101 = R.id.avatar;
        LKUIRoundedImageView2 r102 = (LKUIRoundedImageView2) ViewBindings.findChildViewById(r100, R.id.avatar);
        if (r102 == null) goto L31;
        r101 = R.id.card;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.card);
        if (r103 == null) goto L31;
        r101 = R.id.card_content;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.card_content);
        if (r104 == null) goto L31;
        r101 = R.id.card_loading;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.card_loading);
        if (r105 == null) goto L31;
        r101 = R.id.card_menu;
        LinearLayout r110 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.card_menu);
        if (r110 == null) goto L31;
        r101 = R.id.card_wrapper;
        FrameLayout r111 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.card_wrapper);
        if (r111 == null) goto L31;
        SwipeMenuLayout r112 = (SwipeMenuLayout) r100;
        r101 = R.id.delete_bt;
        LinearLayout r113 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.delete_bt);
        if (r113 == null) goto L31;
        r101 = R.id.mark_bt;
        LinearLayout r114 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.mark_bt);
        if (r114 == null) goto L31;
        r101 = R.id.mark_icon;
        AppCompatImageView r115 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.mark_icon);
        if (r115 == null) goto L31;
        r101 = R.id.mark_text;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r100, R.id.mark_text);
        if (r116 == null) goto L31;
        r101 = R.id.time;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r100, R.id.time);
        if (r117 == null) goto L31;
        r101 = R.id.title;
        TextView r118 = (TextView) ViewBindings.findChildViewById(r100, R.id.title);
        if (r118 == null) goto L31;
        r101 = R.id.unread_icon;
        LKUIRoundedImageView2 r119 = (LKUIRoundedImageView2) ViewBindings.findChildViewById(r100, R.id.unread_icon);
        if (r119 == null) goto L31;
        this.f214693a = new BitableMsgCenterCardBinding(r112, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
        this.f214696d = new b(this);
        return;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public /* synthetic */ BitableMsgCenterCard(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
