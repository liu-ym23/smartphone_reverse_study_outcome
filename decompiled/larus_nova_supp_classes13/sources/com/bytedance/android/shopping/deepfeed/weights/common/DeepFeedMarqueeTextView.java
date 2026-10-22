package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002Y\u0003B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010V\u001a\u00020\u0012¢\u0006\u0004\bW\u0010XR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010%\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010)\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\"\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\"\u00101\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\"\u00105\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b2\u0010\f\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\"\u00109\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0014\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018R\"\u0010=\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0014\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\"\u0010A\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b>\u0010\f\u001a\u0004\b?\u0010\u000e\"\u0004\b@\u0010\u0010R\"\u0010C\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010\f\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010\u0010R*\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0019\u0010S\u001a\u0004\u0018\u00010N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R¨\u0006Z"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/DeepFeedMarqueeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/widget/Scroller;", "b", "Landroid/widget/Scroller;", "getMScroller", "()Landroid/widget/Scroller;", "setMScroller", "(Landroid/widget/Scroller;)V", "mScroller", "", "c", "Z", "getCanScrollable", "()Z", "setCanScrollable", "(Z)V", "canScrollable", "", "d", "I", "getMScrollVelocity", "()I", "setMScrollVelocity", "(I)V", "mScrollVelocity", "e", "getMaxLoopCount", "setMaxLoopCount", "maxLoopCount", "f", "getScrollStartDelay", "setScrollStartDelay", "scrollStartDelay", "g", "getScrollFirstDelay", "setScrollFirstDelay", "scrollFirstDelay", "h", "getScrollTimeInterval", "setScrollTimeInterval", "scrollTimeInterval", "i", "getNeedAdaptWidth", "setNeedAdaptWidth", "needAdaptWidth", "j", "getMFirst", "setMFirst", "mFirst", "k", "getScrollOnVisible", "setScrollOnVisible", "scrollOnVisible", "l", "getScrollMode", "setScrollMode", "scrollMode", "m", "getCurrentLoop", "setCurrentLoop", "currentLoop", "n", "getHasAdjusted", "setHasAdjusted", "hasAdjusted", "o", "isScrollEnd", "setScrollEnd", "Lkotlin/Function0;", "", "p", "Lkotlin/jvm/functions/Function0;", "getOnScrollEndAction", "()Lkotlin/jvm/functions/Function0;", "setOnScrollEndAction", "(Lkotlin/jvm/functions/Function0;)V", "onScrollEndAction", "Landroid/util/AttributeSet;", "s", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", "context", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DeepFeedMarqueeTextView extends AppCompatTextView {
    public static final /* synthetic */ int t = 0;
    public int a;
    public Scroller b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public Function0<Unit> p;
    public Boolean q;
    public final List<b> r;
    public final AttributeSet s;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    public static final class c implements Runnable {
        public final /* synthetic */ DeepFeedMarqueeTextView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public c(DeepFeedMarqueeTextView r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Scroller r1 = this.a.getMScroller();     // Catch: Throwable -> L7
            if (r1 == null) goto L5;
            r1.startScroll(0, 0, this.b, 0, this.c);     // Catch: Throwable -> L7
        L5:
            this.a.invalidate();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ DeepFeedMarqueeTextView a;
        public final /* synthetic */ Integer b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public d(DeepFeedMarqueeTextView r1, Integer r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Scroller r1 = this.a.getMScroller();     // Catch: Throwable -> L14
            if (r1 == null) goto L12;
            int r2 = this.b.intValue();     // Catch: Throwable -> L14
            Integer r0 = this.b;     // Catch: Throwable -> L14
            if (r0 != null) goto L8;
        L10:
            int r3 = -this.c;
        L11:
            r1.startScroll(r2, 0, r3, 0, this.d);     // Catch: Throwable -> L14
            goto L12
        L8:
            if (r0.intValue() != 0) goto L10;
            r3 = this.c;     // Catch: Throwable -> L14
        L12:
            this.a.invalidate();     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L18;
            return;
        L18:
            throw th;
        }
    }

    static {
    }

    public DeepFeedMarqueeTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedMarqueeTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        if (this.m < this.e) goto L8;
        this.o = true;
        Function0<Unit> r0 = this.p;
        if (r0 == null) goto L34;
        Unit r1 = (Unit) r0.invoke();
        return;
    L34:
        return;
    L8:
        setHorizontallyScrolling(true);
        Scroller r2 = this.b;
        if (r2 == null) goto L11;
        setScroller(r2);
    L11:
        int r3 = x() - getMeasuredWidth();
        if (r3 > 0) goto L17;
        this.o = true;
        Function0<Unit> r4 = this.p;
        if (r4 == null) goto L35;
        Unit r5 = (Unit) r4.invoke();
        return;
    L35:
        return;
    L17:
        this.o = false;
        int r6 = (r3 * 100) / this.d;
        if (this.j == false) goto L20;
        new Handler(Looper.getMainLooper()).postDelayed(new c(this, r3, r6), this.f);
        return;
    L20:
        Scroller r7 = this.b;
        if (r7 == null) goto L23;
        Integer r8 = Integer.valueOf(r7.getCurrX());
    L24:
        if (r8 == null) goto L37;
        r8.intValue();
        if (r8.intValue() != r3) goto L29;
        this.m++;
    L29:
        if (r8.intValue() != 0) goto L31;
        int r9 = this.h;
    L32:
        postDelayed(new d(this, r8, r3, r6), r9);
        return;
    L31:
        r9 = this.g;
        goto L32
    L37:
        return;
    L23:
        r8 = null;
        goto L24
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void computeScroll() {
        super/*android.widget.TextView*/.computeScroll();
        if (this.o == false) goto L5;
        return;
    L5:
        Scroller r0 = this.b;
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.c == true) goto L11;
        return;
    L11:
        int r1 = r0.getCurrX();
        if (r1 == this.a) goto L25;
        Iterator r2 = ((ArrayList) this.r).iterator();
    L15:
        if (r2.hasNext() == false) goto L25;
        b r4 = (b) r2.next();
        r4.b();
        Float r5 = Float.valueOf(x() - getMeasuredWidth());
        if (r5.floatValue() <= 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L23;
        r5 = null;
    L23:
        if (r5 == null) goto L15;
        r5.floatValue();
        r4.a();
        goto L15
    L19:
        r6 = false;
    L25:
        this.a = r1;
        Scroller r3 = this.b;
        if (r3 != null) goto L28;
    L44:
        this.q = Boolean.FALSE;
        return;
    L28:
        if (r3.isFinished() != true) goto L44;
        if (this.l != 101) goto L40;
        Scroller r7 = this.b;
        if (r7 == null) goto L40;
        if (r7.getCurrX() != 0) goto L40;
        Scroller r8 = this.b;
        if (r8 == null) goto L51;
        r8.startScroll(0, 0, 0, 0, 0);
        return;
    L51:
        return;
    L40:
        Boolean r9 = this.q;
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r9, r10) == false) goto L43;
        return;
    L43:
        this.j = false;
        y();
        this.q = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int x() {
        TextPaint r0 = getPaint();
        Rect r1 = new Rect();
        String r2 = getText().toString();
        r0.getTextBounds(r2, 0, r2.length(), r1);
        r0.measureText(r2);
        return (int) r0.measureText(r2);
    }

    public final AttributeSet getAttrs() {
        return this.s;
    }

    public final boolean getCanScrollable() {
        return this.c;
    }

    public final int getCurrentLoop() {
        return this.m;
    }

    public final boolean getHasAdjusted() {
        return this.n;
    }

    public final boolean getMFirst() {
        return this.j;
    }

    public final int getMScrollVelocity() {
        return this.d;
    }

    public final Scroller getMScroller() {
        return this.b;
    }

    public final int getMaxLoopCount() {
        return this.e;
    }

    public final boolean getNeedAdaptWidth() {
        return this.i;
    }

    public final Function0<Unit> getOnScrollEndAction() {
        return this.p;
    }

    public final int getScrollFirstDelay() {
        return this.g;
    }

    public final int getScrollMode() {
        return this.l;
    }

    public final boolean getScrollOnVisible() {
        return this.k;
    }

    public final int getScrollStartDelay() {
        return this.f;
    }

    public final int getScrollTimeInterval() {
        return this.h;
    }

    public final void setCanScrollable(boolean r1) {
        this.c = r1;
    }

    public final void setCurrentLoop(int r1) {
        this.m = r1;
    }

    public final void setHasAdjusted(boolean r1) {
        this.n = r1;
    }

    public final void setMFirst(boolean r1) {
        this.j = r1;
    }

    public final void setMScrollVelocity(int r1) {
        this.d = r1;
    }

    public final void setMScroller(Scroller r1) {
        this.b = r1;
    }

    public final void setMaxLoopCount(int r1) {
        this.e = r1;
    }

    public final void setNeedAdaptWidth(boolean r1) {
        this.i = r1;
    }

    public final void setOnScrollEndAction(Function0<Unit> r1) {
        this.p = r1;
    }

    public final void setScrollEnd(boolean r1) {
        this.o = r1;
    }

    public final void setScrollFirstDelay(int r1) {
        this.g = r1;
    }

    public final void setScrollMode(int r1) {
        this.l = r1;
    }

    public final void setScrollOnVisible(boolean r1) {
        this.k = r1;
    }

    public final void setScrollStartDelay(int r1) {
        this.f = r1;
    }

    public final void setScrollTimeInterval(int r1) {
        this.h = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super/*android.widget.TextView*/.onVisibilityChanged(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedMarqueeTextView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.s = r5;
        boolean r7 = true;
        this.c = true;
        this.e = Integer.MAX_VALUE;
        this.j = true;
        this.k = true;
        this.r = new ArrayList();
        this.b = new Scroller(r4, new LinearInterpolator());
        TypedArray r8 = r4.obtainStyledAttributes(r5, new int[]{2130969923, 2130969924, 2130969925, 2130969926, 2130969927, 2130969928, 2130969929, 2130969930});
        this.d = r8.getInt(7, 7);
        this.l = r8.getInt(4, 100);
        this.f = r8.getInt(5, 2000);
        this.g = r8.getInt(2, 1000);
        this.h = r8.getInt(6, 1000);
        if (r8.getInt(0, 0) != 1) goto L5;
        boolean r1 = true;
    L6:
        this.i = r1;
        if (r8.getInt(1, 102) == 102) goto L10;
        r7 = false;
    L10:
        this.c = r7;
        this.e = r8.getInt(3, Integer.MAX_VALUE);
        r8.recycle();
        setSingleLine();
        setEllipsize(null);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public /* synthetic */ DeepFeedMarqueeTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
