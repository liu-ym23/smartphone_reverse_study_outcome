package com.larus.bmhome.chat.markdown.code;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/markdown/code/CodeRenderGestureLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onLongPressCallback", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnLongPressCallback", "()Lkotlin/jvm/functions/Function1;", "setOnLongPressCallback", "(Lkotlin/jvm/functions/Function1;)V", "blockParentHorizontalScroll", "getBlockParentHorizontalScroll", "()Z", "setBlockParentHorizontalScroll", "(Z)V", "longPressTriggered", "touchSlop", "initialX", "", "initialY", "scrollDirectionDecided", "gestureDetector", "Landroid/view/GestureDetector;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onTouchEvent", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeRenderGestureLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super View, Boolean> f306958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f306959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f306960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f306961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f306962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f306963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f306964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final GestureDetector f306965h;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CodeRenderGestureLayout f306966a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return true;
        }

        public a(CodeRenderGestureLayout r100) {
            this.f306966a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            CodeRenderGestureLayout r101 = this.f306966a;
            Function1<View, Boolean> r102 = r101.getOnLongPressCallback();
            if (r102 == null) goto L5;
            boolean r103 = r102.invoke(this.f306966a).booleanValue();
        L6:
            r101.f306960c = r103;
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    public CodeRenderGestureLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CodeRenderGestureLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final boolean getBlockParentHorizontalScroll() {
        return this.f306959b;
    }

    public final Function1<View, Boolean> getOnLongPressCallback() {
        return this.f306958a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getActionMasked();
        boolean r102 = true;
        if (r101 != 0) goto L5;
        this.f306960c = false;
        this.f306962e = r100.getX();
        this.f306963f = r100.getY();
        this.f306964g = false;
        if (this.f306959b == false) goto L27;
        ViewParent r103 = getParent();
        if (r103 == null) goto L27;
        r103.requestDisallowInterceptTouchEvent(true);
    L27:
        this.f306965h.onTouchEvent(r100);
        return super.dispatchTouchEvent(r100);
    L5:
        if (r101 != 2) goto L27;
        if (this.f306959b == false) goto L27;
        if (this.f306964g == true) goto L27;
        float r104 = Math.abs(r100.getX() - this.f306962e);
        float r105 = Math.abs(r100.getY() - this.f306963f);
        int r106 = this.f306961d;
        if (r104 <= r106) goto L14;
    L15:
        this.f306964g = true;
        ViewParent r107 = getParent();
        if (r107 == null) goto L27;
        if (r104 >= r105) goto L21;
        r102 = false;
    L21:
        r107.requestDisallowInterceptTouchEvent(r102);
        goto L27
    L14:
        if (r105 <= r106) goto L27;
        goto L15
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return this.f306960c;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f306960c == false) goto L10;
        if (isPressed() == false) goto L11;
        setPressed(false);
        return true;
    L11:
        return true;
    L10:
        return super.onTouchEvent(r100);
    }

    public final void setBlockParentHorizontalScroll(boolean r100) {
        this.f306959b = r100;
    }

    public final void setOnLongPressCallback(Function1<? super View, Boolean> r100) {
        this.f306958a = r100;
    }

    public CodeRenderGestureLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f306961d = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f306965h = new GestureDetector(r100, new a(this));
    }

    public /* synthetic */ CodeRenderGestureLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
