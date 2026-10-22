package com.bytedance.android.shopping.deepfeed.slice.view.viewpage;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"doStep", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class AutoScrollViewPager2$scrollToNext$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AutoScrollViewPager2$scrollToNext$1 $finishScroll$1;
    final /* synthetic */ long $frameInterval;
    final /* synthetic */ float $pageHeight;
    final /* synthetic */ Ref.LongRef $step;
    final /* synthetic */ long $steps;
    final /* synthetic */ Ref.FloatRef $totalDragged;
    final /* synthetic */ com.bytedance.android.shopping.deepfeed.slice.view.viewpage.a this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.viewpage.AutoScrollViewPager2$scrollToNext$2$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        final /* synthetic */ AutoScrollViewPager2$scrollToNext$2 this$0;

        public AnonymousClass1(AutoScrollViewPager2$scrollToNext$2 r7) {
            this.this$0 = r7;
            super(0, null, "doStep", "invoke()V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m812invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m812invoke() {
            this.this$0.m811invoke();
        }
    }

    public final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AutoScrollViewPager2$scrollToNext$2(com.bytedance.android.shopping.deepfeed.slice.view.viewpage.a r1, Ref.LongRef r2, long r3, AutoScrollViewPager2$scrollToNext$1 r5, float r6, Ref.FloatRef r7, long r8) {
        this.this$0 = r1;
        this.$step = r2;
        this.$steps = r3;
        this.$finishScroll$1 = r5;
        this.$pageHeight = r6;
        this.$totalDragged = r7;
        this.$frameInterval = r8;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m811invoke() {
        com.bytedance.android.shopping.deepfeed.slice.view.viewpage.a r0 = this.this$0;
        boolean r2 = false;
        if (r0.c == false) goto L7;
        r0.b = false;
        return;
    L7:
        if (this.$step.element < this.$steps) goto L24;
        this.$finishScroll$1.m810invoke();
        return;
    L24:
    L20:
        this.$finishScroll$1.m810invoke();
        return;
    L9:
        if (r0.h.isFakeDragging() == true) goto L12;
        this.$finishScroll$1.m810invoke();     // Catch: IllegalStateException -> L20
        return;
    L12:
        long r1 = this.$step.element;     // Catch: IllegalStateException -> L20
        long r3 = this.$steps;     // Catch: IllegalStateException -> L20
        if (r1 != (r3 - 1)) goto L15;
        r2 = true;
    L15:
        if (r2 == false) goto L17;
        float r4 = -(this.$pageHeight + this.$totalDragged.element);
    L18:
        this.this$0.h.fakeDragBy(r4);     // Catch: IllegalStateException -> L20
        this.$totalDragged.element += r4;     // Catch: IllegalStateException -> L20
        this.$step.element++;
        this.this$0.a.postDelayed(new a(new AnonymousClass1(this)), this.$frameInterval);
        return;
    L17:
        r4 = (-this.$pageHeight) / r3;     // Catch: IllegalStateException -> L20
        goto L18
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m811invoke();
        return Unit.INSTANCE;
    }
}
