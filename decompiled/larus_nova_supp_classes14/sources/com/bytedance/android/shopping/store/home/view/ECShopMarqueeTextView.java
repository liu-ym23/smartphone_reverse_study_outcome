package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002Y\u0003B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010V\u001a\u00020\u0012¢\u0006\u0004\bW\u0010XR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010%\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010)\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\"\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\"\u00101\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\"\u00105\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b2\u0010\f\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\"\u00109\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0014\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018R\"\u0010=\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0014\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\"\u0010A\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b>\u0010\f\u001a\u0004\b?\u0010\u000e\"\u0004\b@\u0010\u0010R\"\u0010C\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010\f\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010\u0010R*\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0019\u0010S\u001a\u0004\u0018\u00010N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R¨\u0006Z"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECShopMarqueeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/widget/Scroller;", "b", "Landroid/widget/Scroller;", "getMScroller", "()Landroid/widget/Scroller;", "setMScroller", "(Landroid/widget/Scroller;)V", "mScroller", "", "c", "Z", "getCanScrollable", "()Z", "setCanScrollable", "(Z)V", "canScrollable", "", "d", "I", "getMScrollVelocity", "()I", "setMScrollVelocity", "(I)V", "mScrollVelocity", "e", "getMaxLoopCount", "setMaxLoopCount", "maxLoopCount", "f", "getScrollStartDelay", "setScrollStartDelay", "scrollStartDelay", "g", "getScrollFirstDelay", "setScrollFirstDelay", "scrollFirstDelay", "h", "getScrollTimeInterval", "setScrollTimeInterval", "scrollTimeInterval", "i", "getNeedAdaptWidth", "setNeedAdaptWidth", "needAdaptWidth", "j", "getMFirst", "setMFirst", "mFirst", "k", "getScrollOnVisible", "setScrollOnVisible", "scrollOnVisible", "l", "getScrollMode", "setScrollMode", "scrollMode", "m", "getCurrentLoop", "setCurrentLoop", "currentLoop", "n", "getHasAdjusted", "setHasAdjusted", "hasAdjusted", "o", "isScrollEnd", "setScrollEnd", "Lkotlin/Function0;", "", "p", "Lkotlin/jvm/functions/Function0;", "getOnScrollEndAction", "()Lkotlin/jvm/functions/Function0;", "setOnScrollEndAction", "(Lkotlin/jvm/functions/Function0;)V", "onScrollEndAction", "Landroid/util/AttributeSet;", "w", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", "context", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECShopMarqueeTextView extends AppCompatTextView {
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
    public boolean q;
    public Boolean r;
    public boolean s;
    public Runnable t;
    public final List<b> u;
    public final c v;
    public final AttributeSet w;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECShopMarqueeTextView a;

        public c(ECShopMarqueeTextView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.TextView, com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView] */
        /* JADX WARN: Type inference failed for: r0v11, types: [android.widget.TextView, com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView] */
        /* JADX WARN: Type inference failed for: r0v20, types: [android.widget.TextView, com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView] */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            ?? r0 = this.a;
            if (r0.s == true) goto L5;
            return;
        L5:
            if (r0.q == false) goto L7;
            return;
        L7:
            if (r0.getVisibility() != 0) goto L87;
            CharSequence r1 = this.a.getText();
            if (r1 != null) goto L12;
        L15:
            boolean r2 = true;
        L16:
            if (r2 == false) goto L18;
        L76:
            this.a.z("checkScroll, wait for valid layout");
            return;
        L18:
            if (this.a.getMeasuredWidth() <= 0) goto L76;
            int r3 = this.a.getMaxWidth();
            ?? r4 = this.a;
            if (r4.n == true) goto L60;
            if (r4.i == false) goto L40;
            CharSequence r5 = r4.getText();
            if (r5 != null) goto L29;
        L32:
            boolean r6 = true;
        L33:
            if (r6 == true) goto L40;
            if (r4.getVisibility() == 8) goto L40;
            if (r4.getMeasuredWidth() <= 0) goto L40;
            boolean r7 = false;
        L42:
            if (r7 == true) goto L60;
            TextPaint r8 = r4.getPaint();
            String r9 = r4.getText().toString();
            int r10 = r9.length();
        L45:
            if (r10 < 1) goto L60;
            int r11 = (int) r8.measureText(r9, 0, r10);
            if (r11 <= 0) goto L58;
            if (r11 > r4.getMeasuredWidth()) goto L58;
            if (r4.getMaxWidth() == r11) goto L60;
            r4.n = true;
            r4.setMaxWidth(r11);     // Catch: Throwable -> L55
            r4.n = false;
        L55:
            th = move-exception;
            r4.n = false;
            throw th;
        L58:
            r10 = r10 - 1;
            goto L45
        L29:
            if (StringsKt.isBlank(r5) == true) goto L32;
            r6 = false;
        L40:
            r7 = true;
        L60:
            if (this.a.getMaxWidth() == r3) goto L63;
            this.a.C();
            return;
        L63:
            ?? r12 = this.a;
            int r13 = r12.x();
            r12.z("should Scroll, measuredWidth: " + r12.getMeasuredWidth() + ", textLength: " + r13);
            if (r12.getMeasuredWidth() > 0) goto L66;
        L68:
            boolean r14 = false;
        L69:
            if (r14 == false) goto L74;
            this.a.z("checkScroll, shouldScroll");
            this.a.setCanScrollable(true);
            ?? r15 = this.a;
            r15.z("startScroll");
            r15.y();
            r15.o = false;
            r15.m = 0;
            r15.r = null;
            r15.a = 0;
            r15.j = true;
            Scroller r16 = r15.b;
            if (r16 == null) goto L73;
            r16.startScroll(0, 0, 0, 0, 0);
        L73:
            r15.scrollTo(0, 0);
            r15.B();
            return;
        L74:
            this.a.z("checkScroll, should not scroll");
            this.a.D();
            this.a.setScrollEnd(false);
            this.a.A();
            return;
        L66:
            if (r12.getMeasuredWidth() >= r13) goto L68;
            r14 = true;
            goto L69
        L12:
            if (StringsKt.isBlank(r1) == true) goto L15;
            r2 = false;
            goto L16
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ ECShopMarqueeTextView a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public d(ECShopMarqueeTextView r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            this.a.D();
            this.a.setCurrentLoop(0);
            if (this.a.getCanScrollable() == false) goto L5;
        L6:
            ECShopMarqueeTextView r3 = this.a;
            r3.s = true;
            r3.C();
            return;
        L5:
            if (this.a.s == true) goto L6;
        }
    }

    static {
    }

    public ECShopMarqueeTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECShopMarqueeTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void A() {
        if (this.o == false) goto L5;
        return;
    L5:
        this.o = true;
        y();
        Function0<Unit> r0 = this.p;
        if (r0 == null) goto L9;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B() {
        z("resumeScroll, currentLoop: " + this.m + ", maxLoopCount: " + this.e);
        if (this.m < this.e) goto L6;
        A();
        return;
    L6:
        setHorizontallyScrolling(true);
        Scroller r1 = this.b;
        if (r1 == null) goto L9;
        setScroller(r1);
    L9:
        final int r2 = x() - getMeasuredWidth();
        z("resumeScroll, scrollingLen: " + r2);
        if (r2 > 0) goto L13;
        A();
        return;
    L13:
        final int r3 = (r2 * 100) / this.d;
        if (this.j == false) goto L16;
        long r4 = this.f;
        Function0<Unit> r0 = new ECShopMarqueeTextView$resumeScroll$1(this, r2, r3);
        y();
        com.bytedance.android.shopping.store.home.view.b r5 = new com.bytedance.android.shopping.store.home.view.b(this, r0);
        this.t = r5;
        postDelayed(r5, r4);
        return;
    L16:
        Scroller r6 = this.b;
        if (r6 == null) goto L19;
        final Integer r7 = Integer.valueOf(r6.getCurrX());
    L20:
        if (r7 == null) goto L31;
        r7.intValue();
        if (r7.intValue() != r2) goto L24;
        this.m++;
    L24:
        z("resumeScroll, currentX: " + r7 + ", currentLoop: " + this.m);
        if (r7.intValue() != 0) goto L27;
        int r8 = this.h;
    L28:
        long r9 = r8;
        Function0<Unit> r10 = new ECShopMarqueeTextView$resumeScroll$2(this, r7, r2, r3);
        y();
        com.bytedance.android.shopping.store.home.view.b r11 = new com.bytedance.android.shopping.store.home.view.b(this, r10);
        this.t = r11;
        postDelayed(r11, r9);
        return;
    L27:
        r8 = this.g;
        goto L28
    L31:
        return;
    L19:
        r7 = null;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C() {
        removeCallbacks(this.v);
        postDelayed(this.v, 32);
    }

    public final void E() {
        z("tryScrollIfNeed");
        this.s = true;
        D();
        C();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        removeCallbacks(this.v);
        D();
        super/*android.widget.TextView*/.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        Runnable r0 = this.t;
        if (r0 == null) goto L5;
        removeCallbacks(r0);
    L5:
        this.t = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D() {
        y();
        this.o = true;
        Scroller r1 = this.b;
        if (r1 == null) goto L5;
        r1.forceFinished(true);
    L5:
        Scroller r2 = this.b;
        if (r2 == null) goto L8;
        r2.startScroll(0, 0, 0, 0, 0);
    L8:
        scrollTo(0, 0);
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
        if (this.c == true) goto L12;
        return;
    L12:
        if (this.q == false) goto L14;
        return;
    L14:
        int r1 = r0.getCurrX();
        if (r1 == this.a) goto L28;
        Iterator r2 = ((ArrayList) this.u).iterator();
    L18:
        if (r2.hasNext() == false) goto L28;
        b r4 = (b) r2.next();
        r4.b();
        Float r5 = Float.valueOf(x() - getMeasuredWidth());
        if (r5.floatValue() <= 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L26;
        r5 = null;
    L26:
        if (r5 == null) goto L18;
        r5.floatValue();
        r4.a();
        goto L18
    L22:
        r6 = false;
    L28:
        this.a = r1;
        Scroller r3 = this.b;
        if (r3 != null) goto L31;
    L44:
        this.r = Boolean.FALSE;
        return;
    L31:
        if (r3.isFinished() != true) goto L44;
        if (this.l != 101) goto L40;
        Scroller r7 = this.b;
        if (r7 == null) goto L40;
        if (r7.getCurrX() != 0) goto L40;
        D();
        return;
    L40:
        Boolean r8 = this.r;
        Boolean r9 = Boolean.TRUE;
        if (Intrinsics.areEqual(r8, r9) == false) goto L43;
        return;
    L43:
        this.j = false;
        z("computeScroll computeScroll mScroller?.isFinished == true");
        B();
        this.r = r9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        if (this.s == true) goto L5;
        return;
    L5:
        if (this.q == false) goto L7;
        return;
    L7:
        if (getVisibility() != 0) goto L12;
        C();
        return;
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
        return this.w;
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

    public final void z(String r4) {
        dm.a.a("ECShopMarqueeTextView").a("text: " + getText() + ", " + r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super/*android.widget.TextView*/.onVisibilityChanged(r2, r3);
        if (r3 == 0) goto L5;
    L13:
        if (r3 == 0) goto L17;
        removeCallbacks(this.v);
        D();
        return;
    L17:
        return;
    L5:
        if (this.k == false) goto L13;
        if (this.c == true) goto L11;
        if (this.s == false) goto L13;
    L11:
        if (this.q == true) goto L13;
        z("onVisibilityChanged tryScrollIfNeed");
        E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECShopMarqueeTextView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.w = r6;
        boolean r8 = true;
        this.c = true;
        this.e = Integer.MAX_VALUE;
        this.j = true;
        this.k = true;
        this.u = new ArrayList();
        this.v = new c(this);
        d r1 = new d(this);
        this.b = new Scroller(r5, new LinearInterpolator());
        TypedArray r9 = r5.obtainStyledAttributes(r6, new int[]{2130969923, 2130969924, 2130969925, 2130969926, 2130969927, 2130969928, 2130969929, 2130969930});
        this.d = r9.getInt(7, 7);
        this.l = r9.getInt(4, 100);
        this.f = r9.getInt(5, ECDraweeView.ROUND);
        this.g = r9.getInt(2, ECDraweeView.SQUARE);
        this.h = r9.getInt(6, ECDraweeView.SQUARE);
        if (r9.getInt(0, 0) != 1) goto L5;
        boolean r2 = true;
    L6:
        this.i = r2;
        if (r9.getInt(1, 102) == 102) goto L10;
        r8 = false;
    L10:
        this.c = r8;
        this.e = r9.getInt(3, Integer.MAX_VALUE);
        r9.recycle();
        setSingleLine();
        setEllipsize(null);
        addTextChangedListener(r1);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public /* synthetic */ ECShopMarqueeTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.onSizeChanged(r1, r2, r3, r4);
        if (r1 != r3) goto L5;
        return;
    L5:
        if (this.s == false) goto L9;
        D();
        C();
        return;
    }
}
