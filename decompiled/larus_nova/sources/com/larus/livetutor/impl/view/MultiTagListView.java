package com.larus.livetutor.impl.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.livetutor.impl.databinding.LiveTutorMultiTagItemViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001'B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ \u0010\r\u001a\u00020\u00112\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000eJ\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\fJ\u0014\u0010#\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/larus/livetutor/impl/view/MultiTagListView;", "Landroid/widget/HorizontalScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", KtvSubElement.CONTAINER, "Landroid/widget/LinearLayout;", "canScroll", "Lkotlin/Function0;", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function2;", "", "", "", "innerCurrent", "scrollAnimator", "Landroid/animation/ObjectAnimator;", "value", "current", "getCurrent", "()I", "setCurrent", "(I)V", GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, "click", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "select", "index", "scrollable", "bindData", "list", "", "Lcom/larus/livetutor/impl/view/TabData;", "MultiTagItemView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTagListView extends HorizontalScrollView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f356775e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f356776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Integer, ? super String, Unit> f356777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f356778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObjectAnimator f356779d;

    public final class a extends ConstraintLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LiveTutorMultiTagItemViewBinding f356780a;

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, null);
            LayoutInflater.from(r100).inflate(R.layout.live_tutor_multi_tag_item_view, this);
            int r101 = R.id.new_bot_tag_item_container;
            if (((ConstraintLayout) ViewBindings.findChildViewById(this, R.id.new_bot_tag_item_container)) == null) goto L13;
            r101 = R.id.new_bot_tag_item_view_icon;
            if (((SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.new_bot_tag_item_view_icon)) == null) goto L13;
            r101 = R.id.new_bot_tag_item_view_line;
            View r102 = ViewBindings.findChildViewById(this, R.id.new_bot_tag_item_view_line);
            if (r102 == null) goto L13;
            r101 = R.id.new_bot_tag_item_view_text;
            TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.new_bot_tag_item_view_text);
            if (r103 == null) goto L13;
            this.f356780a = new LiveTutorMultiTagItemViewBinding(this, r102, r103);
            return;
        L13:
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r101)));
        }

        @Override // android.view.View
        public final void setSelected(boolean r100) {
            super.setSelected(r100);
            this.f356780a.f355983c.setSelected(r100);
            if (r100 == false) goto L9;
            if (Build.VERSION.SDK_INT < 28) goto L7;
            Typeface r101 = Typeface.create(this.f356780a.f355983c.getTypeface(), 600, this.f356780a.f355983c.getTypeface().isItalic());
            this.f356780a.f355983c.setTypeface(r101);
        L7:
            com.larus.utils.e1.x(this.f356780a.f355982b);
            return;
        L9:
            if (Build.VERSION.SDK_INT < 28) goto L11;
            Typeface r102 = Typeface.create(this.f356780a.f355983c.getTypeface(), 600, this.f356780a.f355983c.getTypeface().isItalic());
            this.f356780a.f355983c.setTypeface(r102);
        L11:
            com.larus.utils.e1.o(this.f356780a.f355982b);
        }
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f356781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MultiTagListView f356782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f356783c;

        public b(View r100, MultiTagListView r101, boolean r102) {
            this.f356781a = r100;
            this.f356782b = r101;
            this.f356783c = r102;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            if (this.f356781a.getWidth() > 0) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(this.f356781a.getParent(), this.f356782b.f356776a) == false) goto L15;
            int r109 = ((this.f356781a.getLeft() + (this.f356781a.getWidth() / 2)) - (this.f356782b.getWidth() / 2)) + i5.g();
            if (this.f356783c == true) goto L9;
            this.f356782b.scrollTo(r109, 0);
            return;
        L9:
            ObjectAnimator r110 = this.f356782b.f356779d;
            if (r110 == null) goto L12;
            r110.cancel();
        L12:
            MultiTagListView r111 = this.f356782b;
            ObjectAnimator r112 = ObjectAnimator.ofInt(r111, "scrollX", new int[]{r111.getScrollX(), r109});
            r112.setDuration(200);
            r112.start();
            r111.f356779d = r112;
            return;
        }
    }

    public final int getCurrent() {
        return this.f356778c;
    }

    public MultiTagListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (super.onTouchEvent(r100) == false) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setCurrent(int r100) {
        if (this.f356778c != r100) goto L5;
        return;
    L5:
        this.f356778c = r100;
        a(r100, true);
    }

    public MultiTagListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LinearLayout r102 = new LinearLayout(r100);
        this.f356776a = r102;
        this.f356778c = -1;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, -2);
        r103.bottomMargin = i5.z();
        r103.topMargin = i5.c();
        r102.setOrientation(0);
        addView(r102, r103);
        setHorizontalScrollBarEnabled(false);
    }

    public final void a(int r100, boolean r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= this.f356776a.getChildCount()) goto L40;
        this.f356778c = r100;
        View r102 = ViewGroupKt.get(this.f356776a, r100);
        LinearLayout r103 = this.f356776a;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L16;
        View r106 = r103.getChildAt(r105);
        r106.setSelected(Intrinsics.areEqual(r106, r102));
        if ((r106 instanceof TextView) == false) goto L11;
        TextView r107 = (TextView) r106;
    L12:
        if (r107 == null) goto L14;
        r107.setTypeface(Typeface.DEFAULT, Intrinsics.areEqual(r106, r102) ? 1 : 0);
    L14:
        r105 = r105 + 1;
        goto L7
    L11:
        r107 = null;
        goto L12
    L16:
        if (isLaidOut() == true) goto L18;
    L30:
        addOnLayoutChangeListener(new b(r102, this, r101));
        return;
    L18:
        if (isLayoutRequested() == true) goto L30;
        if (r102.getWidth() > 0) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual(r102.getParent(), this.f356776a) == false) goto L37;
        int r108 = ((r102.getLeft() + (r102.getWidth() / 2)) - (getWidth() / 2)) + i5.g();
        if (r101 == true) goto L26;
        scrollTo(r108, 0);
        return;
    L26:
        ObjectAnimator r109 = this.f356779d;
        if (r109 == null) goto L29;
        r109.cancel();
    L29:
        ObjectAnimator r110 = ObjectAnimator.ofInt(this, "scrollX", new int[]{getScrollX(), r108});
        r110.setDuration(200);
        r110.start();
        this.f356779d = r110;
        return;
    L37:
        return;
    }
}
