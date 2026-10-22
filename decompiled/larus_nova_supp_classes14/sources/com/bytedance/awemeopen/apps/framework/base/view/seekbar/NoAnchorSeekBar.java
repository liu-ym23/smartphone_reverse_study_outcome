package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001;B\u0013\b\u0016\u0012\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105B\u001d\b\u0016\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b4\u00108B%\b\u0016\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u00109\u001a\u00020\u000b¢\u0006\u0004\b4\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R6\u0010,\u001a\u0016\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00101\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u00100¨\u0006<"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/NoAnchorSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "", "getScale", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/NoAnchorSeekBar$a;", "l", "", "setOnSeekBarChangeListener", "Landroid/graphics/drawable/Drawable;", "thumb", "setThumb", "", "d", "I", "getScaledTouchSlop", "()I", "setScaledTouchSlop", "(I)V", "scaledTouchSlop", "e", "getTriggerCancellationMinHeight", "setTriggerCancellationMinHeight", "triggerCancellationMinHeight", "", "f", "Z", "getEndOutOfArea", "()Z", "endOutOfArea", "Ljava/util/TreeSet;", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/a;", "g", "Ljava/util/TreeSet;", "getDrawers", "()Ljava/util/TreeSet;", "drawers", "Lkotlin/Function2;", "Landroid/view/MotionEvent;", "h", "Lkotlin/jvm/functions/Function2;", "getMapper", "()Lkotlin/jvm/functions/Function2;", "setMapper", "(Lkotlin/jvm/functions/Function2;)V", "mapper", "i", "getAnchor", "setAnchor", "(Z)V", "anchor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class NoAnchorSeekBar extends AppCompatSeekBar {
    public static final /* synthetic */ int l = 0;
    public a a;
    public float b;
    public float c;
    public int d;
    public int e;
    public boolean f;
    public final TreeSet<com.bytedance.awemeopen.apps.framework.base.view.seekbar.a> g;
    public Function2<? super MotionEvent, ? super Float, Integer> h;
    public boolean i;
    public boolean j;
    public float k;

    public static abstract class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        public abstract void a(SeekBar r1, boolean r2);

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r2) {
            a(r2, false);
        }
    }

    private final boolean getEndOutOfArea() {
        boolean r0 = this.f;
        this.f = false;
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final float getScale() {
        int r0 = getMax();
        if (r0 > 0) goto L7;
        return 0.0f;
    L7:
        return getProgress() / r0;
    }

    public final boolean getAnchor() {
        return this.i;
    }

    public final TreeSet<com.bytedance.awemeopen.apps.framework.base.view.seekbar.a> getDrawers() {
        return this.g;
    }

    public final Function2<MotionEvent, Float, Integer> getMapper() {
        return this.h;
    }

    public final int getScaledTouchSlop() {
        return this.d;
    }

    public final int getTriggerCancellationMinHeight() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NoAnchorSeekBar(Context r3) {
        new LinkedHashMap();
        Intrinsics.checkNotNull(r3);
        super(r3);
        this.e = -1;
        final NoAnchorSeekBar$drawers$1 r0 = NoAnchorSeekBar$drawers$1.INSTANCE;
        this.g = new TreeSet(new e(r0));
        this.d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (Float.isNaN(r5.getX()) == false) goto L5;
        return;
    L5:
        if (Float.isNaN(r5.getY()) == true) goto L25;
        float r1 = MathKt.roundToInt(r5.getX());
        float r2 = MathKt.roundToInt(r5.getY());
        Drawable r3 = getBackground();
        if (r3 == null) goto L10;
        r3.setHotspot(r1, r2);
    L10:
        Intrinsics.checkNotNullParameter(r5, "event");
        Function2<? super MotionEvent, ? super Float, Integer> r0 = this.h;
        if (r0 == null) goto L21;
        Integer r6 = Integer.valueOf(((Number) r0.invoke(r5, Float.valueOf(this.c))).intValue());
        if (r6.intValue() < 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L19;
        r6 = null;
    L19:
        if (r6 == null) goto L21;
        int r7 = r6.intValue();
    L22:
        setProgress(r7);
        return;
    L15:
        r4 = false;
    L21:
        r7 = MathKt.roundToInt(((this.c / ((getWidth() - getPaddingLeft()) - getPaddingRight())) * getMax()) + getProgress());
        goto L22
    }

    public final void onDraw(Canvas r4) {
        super.onDraw(r4);
        if (r4 != null) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.g.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        com.bytedance.awemeopen.apps.framework.base.view.seekbar.a r1 = (com.bytedance.awemeopen.apps.framework.base.view.seekbar.a) r0.next();
        if (r1.a() == false) goto L7;
        r4.save();
        r1.b(r4);
        r4.restore();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r7) {
        if (this.e <= 0) goto L22;
        if (r7 != null) goto L6;
    L8:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L16;
        if (r7 != null) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L22;
    L12:
        if (r7.getActionMasked() != 3) goto L14;
        r1 = true;
    L16:
        int[] r2 = new int[2];
        getLocationOnScreen(r2);
        if (this.j == false) goto L22;
        if ((r2[1] - r7.getRawY()) <= this.e) goto L22;
        this.f = true;
        goto L22
    L6:
        if (r7.getActionMasked() != 1) goto L8;
        r0 = true;
    L22:
        if (this.i == false) goto L26;
        return super/*android.widget.SeekBar*/.onTouchEvent(r7);
    L26:
        if (isEnabled() == false) goto L66;
        if (r7 == null) goto L66;
        this.c = r7.getX() - this.b;
        int r3 = r7.getAction();
        if (r3 == 0) goto L63;
        if (r3 == 1) goto L57;
        if (r3 == 2) goto L43;
        if (r3 == 3) goto L36;
    L64:
        this.b = r7.getX();
        return true;
    L36:
        if (this.j == false) goto L41;
        this.j = false;
        a r4 = this.a;
        if (r4 == null) goto L40;
        r4.a(this, getEndOutOfArea());
    L40:
        setPressed(false);
    L41:
        invalidate();
        goto L64
    L43:
        if (this.j == false) goto L46;
        a(r7);
        goto L64
    L46:
        if (Math.abs(r7.getX() - this.k) <= this.d) goto L64;
        setPressed(true);
        if (getThumb() == null) goto L50;
        invalidate(getThumb().getBounds());
    L50:
        this.j = true;
        a r5 = this.a;
        if (r5 == null) goto L53;
        r5.onStartTrackingTouch(this);
    L53:
        a(r7);
        if (getParent() == null) goto L64;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L64
    L57:
        if (this.j == false) goto L62;
        a(r7);
        this.j = false;
        a r6 = this.a;
        if (r6 == null) goto L61;
        r6.a(this, getEndOutOfArea());
    L61:
        setPressed(false);
    L62:
        invalidate();
        goto L64
    L63:
        this.k = r7.getX();
    L66:
        return false;
    }

    public final void setAnchor(boolean r1) {
        this.i = r1;
    }

    public final void setMapper(Function2<? super MotionEvent, ? super Float, Integer> r1) {
        this.h = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setOnSeekBarChangeListener(a r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        super/*android.widget.SeekBar*/.setOnSeekBarChangeListener(r2);
        this.a = r2;
    }

    public final void setScaledTouchSlop(int r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setThumb(Drawable r2) {
        super/*android.widget.SeekBar*/.setThumb(r2);
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        b(getWidth(), getHeight());
        return;
    }

    public final void setTriggerCancellationMinHeight(int r1) {
        this.e = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NoAnchorSeekBar(Context r2, AttributeSet r3) {
        new LinkedHashMap();
        Intrinsics.checkNotNull(r2);
        super(r2, r3);
        this.e = -1;
        final NoAnchorSeekBar$drawers$1 r4 = NoAnchorSeekBar$drawers$1.INSTANCE;
        this.g = new TreeSet(new e(r4));
        this.d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(int r8, int r9) {
        int r10 = (r9 - getPaddingTop()) - getPaddingBottom();
        Drawable r0 = getProgressDrawable();
        Drawable r1 = getThumb();
        if (r1 == null) goto L5;
        int r3 = r1.getIntrinsicHeight();
    L6:
        if (r3 <= r10) goto L8;
        int r4 = (r10 - r3) / 2;
        int r5 = ((r3 - r10) / 2) + r4;
    L9:
        if (r0 == null) goto L11;
        r0.setBounds(0, r5, (r8 - getPaddingRight()) - getPaddingLeft(), r10 + r5);
    L11:
        if (r1 == null) goto L18;
        getScale();
        int r11 = r1.getIntrinsicHeight();
        if (r4 != Integer.MIN_VALUE) goto L15;
        Rect r12 = r1.getBounds();
        r4 = r12.top;
        int r13 = r12.bottom;
    L16:
        r1.setBounds(r1.getBounds().left, r4, r1.getBounds().right, r13);
        return;
    L15:
        r13 = r11 + r4;
        goto L16
    L18:
        return;
    L8:
        int r6 = (r10 - r10) / 2;
        r4 = ((r10 - r3) / 2) + r6;
        r5 = r6;
        goto L9
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performAccessibilityAction(int r3, Bundle r4) {
        if (r3 == 8192) goto L9;
        if (r3 == 4096) goto L9;
        return super/*android.widget.SeekBar*/.performAccessibilityAction(r3, r4);
    L9:
        if (isEnabled() == true) goto L12;
        return false;
    L12:
        int r5 = Math.max(1, MathKt.roundToInt(getMax() / 20.0f));
        if (r3 != 8192) goto L16;
        r5 = -r5;
    L16:
        if (this.a == null) goto L18;
        setProgress(getProgress() + r5);
    L18:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NoAnchorSeekBar(Context r2, AttributeSet r3, int r4) {
        new LinkedHashMap();
        Intrinsics.checkNotNull(r2);
        super(r2, r3, r4);
        this.e = -1;
        final NoAnchorSeekBar$drawers$1 r5 = NoAnchorSeekBar$drawers$1.INSTANCE;
        this.g = new TreeSet(new e(r5));
        this.d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.SeekBar*/.onSizeChanged(r1, r2, r3, r4);
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        b(r1, r2);
        return;
    }
}
