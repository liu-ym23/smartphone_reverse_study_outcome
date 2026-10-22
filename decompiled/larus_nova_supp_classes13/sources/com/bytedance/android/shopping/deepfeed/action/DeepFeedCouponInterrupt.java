package com.bytedance.android.shopping.deepfeed.action;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedCouponResult;
import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedProductCouponApi;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.larus.apm.impl.protector.RunnableProtector;
import he3.d1;
import he3.e1;
import he3.h2;
import he3.l;
import he3.m2;
import he3.n0;
import he3.p0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedCouponInterrupt {
    public final Handler a;
    public final String b;
    public final List<c> c;
    public final MutableLiveData<m2> d;

    public static final class a implements Runnable {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ Function1 b;

        public a(Ref.BooleanRef r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ref.BooleanRef r0 = this.a;     // Catch: Throwable -> L6
            if (r0.element == true) goto L9;
            r0.element = true;     // Catch: Throwable -> L6
            this.b.invoke(null);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public DeepFeedCouponInterrupt(MutableLiveData<m2> r2) {
        Intrinsics.checkNotNullParameter(r2, "showToast");
        this.d = r2;
        this.a = new Handler(Looper.getMainLooper());
        this.b = "领券未成功，稍后再试试哦";
        this.c = new ArrayList();
    }

    public final void a(InFeedProductV2 r2, final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "continueAction");
        b(r2, new DeepFeedCouponInterrupt$onInterrupt$1(r3));
    }

    public final void b(final InFeedProductV2 r14, final Function1<? super l, Unit> r15) {
        Intrinsics.checkNotNullParameter(r15, "continueAction");
        if (r14 == null) goto L11;
        InFeedProductPackData r1 = r14.getPackData();
        if (r1 == null) goto L11;
        InFeedProductPackDataElements r2 = r1.getElements();
        if (r2 == null) goto L11;
        List<p0> r3 = r2.getProducts();
        if (r3 == null) goto L11;
        p0 r4 = (p0) CollectionsKt.firstOrNull(r3);
    L12:
        if (r4 != null) goto L23;
        if (r14 == null) goto L19;
        InFeedProductPackData r5 = r14.getPackData();
        if (r5 == null) goto L19;
        InFeedProductPackDataElements r6 = r5.getElements();
        if (r6 == null) goto L19;
        n0 r7 = r6.getSliceCard();
    L20:
        if (r7 != null) goto L23;
        r15.invoke(null);
        return;
    L19:
        r7 = null;
    L23:
        l r8 = r14.getDynamicData().d;
        if (r8 == null) goto L26;
        Long r9 = r8.a();
    L27:
        DeepFeedProductCouponApi r10 = com.bytedance.android.shopping.deepfeed.utlis.e.a;
        if (r9 != null) goto L31;
    L32:
        l r11 = r14.getDynamicData().d;
        if (r11 == null) goto L35;
        Long r12 = r11.a();
    L36:
        if (r12 != null) goto L39;
    L40:
        l r13 = r14.getDynamicData().d;
        if (r13 == null) goto L43;
        Long r16 = r13.a();
    L44:
        if (r16 != null) goto L47;
    L49:
        final h2 r17 = com.bytedance.android.shopping.deepfeed.utlis.a.j(r14);
        if (r17 != null) goto L53;
        r15.invoke(null);
        return;
    L53:
        List<d1> r18 = r17.a();
        if (r18 != null) goto L56;
    L59:
        boolean r19 = true;
    L60:
        if (r19 == false) goto L63;
        r15.invoke(null);
        return;
    L63:
        d1 r20 = (d1) CollectionsKt.firstOrNull(r17.a());
        if (r20 != null) goto L66;
    L69:
        final Ref.BooleanRef r21 = new Ref.BooleanRef();
        r21.element = false;
        this.a.postDelayed(new a(r21, r15), 500);
        Function2<l, String, Unit> r22 = new DeepFeedCouponInterrupt$onInterruptWithData$$inlined$let$lambda$2(r17, r21, this, r15, r14, r17);
        h2 r110 = com.bytedance.android.shopping.deepfeed.utlis.a.j(r14);
        if (r110 == null) goto L77;
        e1 r111 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r14);
        if (r111 == null) goto L75;
        String r112 = r111.a();
        if (r112 == null) goto L75;
    L76:
        com.bytedance.android.shopping.deepfeed.utlis.e.b(r110, r112, com.bytedance.android.shopping.deepfeed.utlis.h.c(r110), r22);
        return;
    L75:
        r112 = "";
        goto L76
    L77:
        r22.invoke(null, DeepFeedCouponResult.UN_REQUEST);
        return;
    L66:
        if (com.bytedance.android.shopping.deepfeed.utlis.e.a(r20) == false) goto L69;
        r15.invoke(null);
        return;
    L56:
        if (r18.isEmpty() == true) goto L59;
        r19 = false;
        goto L60
    L47:
        if (r16.longValue() != 10) goto L49;
    L79:
        r15.invoke(null);
        return;
    L43:
        r16 = null;
        goto L44
    L39:
        if (r12.longValue() == 3) goto L79;
    L35:
        r12 = null;
        goto L36
    L31:
        if (r9.longValue() == 2) goto L79;
    L26:
        r9 = null;
    L11:
        r4 = null;
        goto L12
    }
}
