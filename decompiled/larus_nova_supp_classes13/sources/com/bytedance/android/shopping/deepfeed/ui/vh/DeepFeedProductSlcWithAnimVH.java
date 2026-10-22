package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.animation.ValueAnimator;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.larus.apm.impl.protector.RunnableProtector;
import he3.n0;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductSlcWithAnimVH;", "Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductSlcVH;", "", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductSlcWithAnimVH extends DeepFeedProductSlcVH {
    public static final /* synthetic */ int H0 = 0;
    public ValueAnimator p0;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DeepFeedProductSlcWithAnimVH a;
        public final /* synthetic */ int b;

        public b(DeepFeedProductSlcWithAnimVH r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            DeepFeedProductSlcWithAnimVH r0 = this.a;
            int r1 = DeepFeedProductSlcWithAnimVH.H0;
            r0.getClass();
            throw null;
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

    public static final class c implements Runnable {
        public final /* synthetic */ DeepFeedProductSlcWithAnimVH a;
        public final /* synthetic */ int b;

        public c(DeepFeedProductSlcWithAnimVH r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            DeepFeedProductSlcWithAnimVH r0 = this.a;
            int r1 = DeepFeedProductSlcWithAnimVH.H0;
            if (r0.getAdapterPosition() <= r0.i4().curNoFullScreenCount()) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L8;
            return;
        L8:
            r0.getClass();
            throw null;
        L5:
            r2 = false;
            goto L6
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

    static {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH, com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void q4() {
        ValueAnimator r0 = this.p0;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.p0 = null;
        super.q4();
    }

    public final int J4() {
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH
    public final void E4(InFeedProductV2 r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        int r0 = r4.getDynamicData().h;
        super.E4(r4);
        if (r0 != 2) goto L5;
        J4();
        throw null;
    L5:
        if (r0 != 3) goto L7;
        int r5 = J4();
        if (getAdapterPosition() <= i4().curNoFullScreenCount()) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == false) goto L20;
        new c(this, r5);
        throw null;
    L20:
        throw null;
    L17:
        r1 = false;
        goto L18
    L7:
        if (r0 == 6) goto L13;
        if (r0 == 4) goto L25;
        r4.getDynamicData().h = 1;
        return;
    L25:
        return;
    L13:
        throw null;
    }

    public final void K4(float r3) {
        InFeedProductV2 r0 = this.m;
        if (r0 == null) goto L10;
        n0 r1 = r0.slcCard();
        if (r1 == null) goto L11;
        com.bytedance.android.shopping.deepfeed.slice.c r2 = r1.d;
        if (r2 == null) goto L12;
        r2.a(MapsKt.mapOf(TuplesKt.to("bottom_panel_translate_y", Float.valueOf(r3))));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH
    public final /* bridge */ /* synthetic */ void a4(Object r1) {
        E4((InFeedProductV2) r1);
    }
}
