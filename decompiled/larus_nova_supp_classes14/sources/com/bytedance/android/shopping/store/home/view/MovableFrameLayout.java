package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.shopping.store.keva.ECStoreDefaultKevaRepo;
import com.bytedance.keva.Keva;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002+,B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010#\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001a¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/MovableFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/store/home/view/MovableFrameLayout$b;", "moveListener", "", "setMoveListener", "", "translationX", "setTranslationX", "translationY", "setTranslationY", "", "minTranslationX", "setMinTranslationX", "maxTranslationX", "setMaxTranslationX", "minTranslationY", "setMinTranslationY", "maxTranslationY", "setMaxTranslationY", "", "g", "Z", "getQuitMove", "()Z", "setQuitMove", "(Z)V", "quitMove", "h", "getRecordPosition", "setRecordPosition", "recordPosition", "i", "getNeedAdsorptionEdge", "setNeedAdsorptionEdge", "needAdsorptionEdge", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MovableFrameLayout extends FrameLayout {
    public static final int k = 0;
    public int a;
    public int b;
    public int c;
    public int d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    public static final class a {
    }

    public interface b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MovableFrameLayout a;
        public final /* synthetic */ float b;

        public c(MovableFrameLayout r1, float r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setX(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MovableFrameLayout a;
        public final /* synthetic */ float b;

        public d(MovableFrameLayout r1, float r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setY(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ MovableFrameLayout a;

        public e(MovableFrameLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MovableFrameLayout.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public MovableFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MovableFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setMoveListener(b r1) {
    }

    static {
        k = ExtensionsKt.a(3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new w(this));
    }

    public final boolean getNeedAdsorptionEdge() {
        return this.i;
    }

    public final boolean getQuitMove() {
        return this.g;
    }

    public final boolean getRecordPosition() {
        return this.h;
    }

    public static final void a(MovableFrameLayout r4) {
        int r0 = r4.getLeft();
        int r1 = r4.getTop();
        r4.setMinTranslationX(-r0);
        r4.setMinTranslationY(-r1);
        ViewParent r2 = r4.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L5;
        ViewGroup r3 = (ViewGroup) r2;
        r4.setMaxTranslationX((r3.getMeasuredWidth() - r0) - r4.getMeasuredWidth());
        r4.setMaxTranslationY((r3.getMeasuredHeight() - r1) - r4.getMeasuredHeight());
    L5:
        r4.d(0.0f, 0.0f);
    }

    private final void setMaxTranslationX(int r1) {
        this.b = r1;
    }

    private final void setMaxTranslationY(int r1) {
        this.d = r1;
    }

    private final void setMinTranslationX(int r1) {
        this.a = r1;
    }

    private final void setMinTranslationY(int r1) {
        this.c = r1;
    }

    public final void b(boolean r6) {
        Resources r0 = getContext().getResources();
        int r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).widthPixels;
        if ((getX() + (getWidth() / 2)) > (r1 / 2)) goto L5;
        int r2 = 0;
    L6:
        float r3 = r2;
        if (r6 == false) goto L9;
        animate().x(r3).setDuration(300).withEndAction(new c(this, r3)).start();
    L10:
        float r4 = eh.b.b(getContext());
        if (getY() >= r4) goto L16;
        if (r6 == false) goto L14;
        animate().y(r4).setDuration(300).withEndAction(new d(this, r4)).start();
        return;
    L14:
        setY(r4);
        return;
    L16:
        return;
    L9:
        setX(r3);
        goto L10
    L5:
        r2 = r1 - getWidth();
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.g == true) goto L5;
        float r0 = r5.getRawX();
        float r1 = r5.getRawY();
        int r2 = r5.getAction();
        if (r2 != 0) goto L10;
        this.e = r0;
        this.f = r1;
    L18:
        return super.onInterceptTouchEvent(r5);
    L10:
        if (r2 != 2) goto L18;
        if (this.j == false) goto L14;
        return true;
    L14:
        if (c(this.e, this.f, r0, r1) == false) goto L18;
        return true;
    L5:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (this.g == true) goto L5;
        float r0 = r6.getRawX();
        float r1 = r6.getRawY();
        int r2 = r6.getAction();
        if (r2 == 0) goto L29;
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L21;
    L28:
        return super.onTouchEvent(r6);
    L15:
        if (this.j == false) goto L17;
    L18:
        d(r0 - this.e, r1 - this.f);
        this.e = r0;
        this.f = r1;
        this.j = true;
        return true;
    L17:
        if (c(this.e, this.f, r0, r1) == false) goto L28;
    L21:
        if (this.j == false) goto L28;
        if (this.i == false) goto L25;
        b(true);
    L25:
        this.j = false;
        return true;
    L29:
        return true;
    L5:
        return super.onTouchEvent(r6);
    }

    public final void setNeedAdsorptionEdge(boolean r1) {
        this.i = r1;
    }

    public final void setQuitMove(boolean r1) {
        this.g = r1;
    }

    public final void setRecordPosition(boolean r1) {
        this.h = r1;
    }

    @Override // android.view.View
    public void setTranslationX(float r3) {
        super.setTranslationX(r3);
        Lazy r0 = ECStoreDefaultKevaRepo.a;
        Intrinsics.checkNotNullParameter("live_icon_translation_x", "key");
        ((Keva) ECStoreDefaultKevaRepo.a.getValue()).storeFloat("live_icon_translation_x", r3);
    }

    @Override // android.view.View
    public void setTranslationY(float r3) {
        super.setTranslationY(r3);
        Lazy r0 = ECStoreDefaultKevaRepo.a;
        Intrinsics.checkNotNullParameter("live_icon_translation_y", "key");
        ((Keva) ECStoreDefaultKevaRepo.a.getValue()).storeFloat("live_icon_translation_y", r3);
    }

    public final void d(float r9, float r10) {
        float r0 = getTranslationX();
        float r1 = getTranslationY();
        float r11 = (float) Math.max(this.a, Math.min(r0 + r9, this.b));
        float r12 = (float) Math.max(this.c, Math.min(r1 + r10, this.d));
        setTranslationX(r11);
        setTranslationY(r12);
    }

    public MovableFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.h = true;
        this.i = true;
    }

    public /* synthetic */ MovableFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final boolean c(float r7, float r8, float r9, float r10) {
        float r0 = (float) Math.abs(r7 - r9);
        float r1 = (float) Math.abs(r8 - r10);
        if (Math.abs((float) Math.sqrt((r0 * r0) + (r1 * r1))) < k) goto L24;
        float r11 = getTranslationX() + (r9 - r7);
        if (r11 >= this.a) goto L7;
    L9:
        boolean r12 = false;
    L10:
        if (r12 == true) goto L20;
        float r13 = getTranslationY() + (r10 - r8);
        if (r13 >= this.c) goto L14;
    L16:
        boolean r14 = false;
    L17:
        if (r14 == true) goto L20;
        boolean r15 = false;
    L21:
        if (r15 == false) goto L25;
        return true;
    L25:
        return false;
    L14:
        if (r13 > this.d) goto L16;
        r14 = true;
    L20:
        r15 = true;
        goto L21
    L7:
        if (r11 > this.b) goto L9;
        r12 = true;
        goto L10
    L24:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        post(new e(this));
    }
}
