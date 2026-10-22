package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class EventDispatcher implements o, p {
    public volatile boolean a;
    public final List<p> b;

    public static final class a implements Runnable {
        public final /* synthetic */ EventDispatcher a;
        public final /* synthetic */ p b;

        @Override // java.lang.Runnable
        public final void run() {
            List<p> r0 = this.a.b;     // Catch: Throwable -> L6
            ArrayList r1 = (ArrayList) r0;     // Catch: Throwable -> L6
            if (r1.contains(this.b) == true) goto L9;
            List<p> r2 = this.a.b;     // Catch: Throwable -> L6
            ArrayList r3 = (ArrayList) r2;     // Catch: Throwable -> L6
            r3.add(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(EventDispatcher r1, p r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ EventDispatcher a;
        public final /* synthetic */ p b;

        public b(EventDispatcher r1, p r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<p> r0 = this.a.b;     // Catch: Throwable -> L4
            ArrayList r1 = (ArrayList) r0;     // Catch: Throwable -> L4
            r1.remove(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void e() {
        b(EventDispatcher$onHiddenCellShow$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void k() {
        b(EventDispatcher$hideWireFrame$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void m() {
        b(EventDispatcher$onHeadInVisible$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onDestroy() {
        b(AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPause() {
        b(C02481.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onResume() {
        b(C02491.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
        b(EventDispatcher$onBeginTransit$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void t() {
        b(EventDispatcher$onHeadVisible$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void u() {
        b(EventDispatcher$onFooterInvoke$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void v() {
        b(EventDispatcher$onStartVideoPlay$1.INSTANCE);
    }

    public EventDispatcher() {
        this.b = new ArrayList();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(final boolean r2) {
        b(new EventDispatcher$onEndTransit$1(r2));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void a(final boolean r2) {
        b(new EventDispatcher$onDragProgressStateChange$1(r2));
    }

    public final void b(Function1<? super p, Unit> r3) {
        this.a = true;
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.invoke(r0.next());
        goto L4
    L6:
        this.a = false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void c(final boolean r2) {
        b(new EventDispatcher$onSmallModeChange$1(r2));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void f(final boolean r2) {
        b(new EventDispatcher$onVideoPlayStateChange$1(r2));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void h(final boolean r2) {
        b(new EventDispatcher$onHeadAICombinationStateChange$1(r2));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(final float r2) {
        b(new EventDispatcher$onTransit$1(r2));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPageSelected(final int r2) {
        b(new C02471(r2));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void p(final String r2) {
        b(new EventDispatcher$onSkuSelected$1(r2));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(final AnchorV4HeadV2VO r2) {
        Intrinsics.checkNotNullParameter(r2, "headVo");
        b(new EventDispatcher$onDataSet$1(r2));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(final int r2) {
        b(new EventDispatcher$onBeforeOpenGallery$1(r2));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.o
    public final void x(p r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        a r0 = new a(this, r2);
        if (this.a == false) goto L5;
        Lazy r3 = UIUtils.a;
        UIUtils.c().post(r0);
        return;
    L5:
        r0.run();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.o
    public final boolean z(p r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (this.a == false) goto L6;
        boolean r0 = ((ArrayList) this.b).contains(r4);
        Lazy r1 = UIUtils.a;
        UIUtils.c().post(new b(this, r4));
        return r0;
    L6:
        return ((ArrayList) this.b).remove(r4);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void d(final boolean r2, final int r3) {
        b(new EventDispatcher$onFoldableTabStatusUpdate$1(r2, r3));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void n(final int r2, final Boolean r3) {
        b(new EventDispatcher$trySelectPage$1(r2, r3));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void j(final int r2, final ImageInfo r3, final boolean r4, final int r5) {
        b(new EventDispatcher$onBitmapLoaded$1(r2, r3, r4, r5));
    }
}
