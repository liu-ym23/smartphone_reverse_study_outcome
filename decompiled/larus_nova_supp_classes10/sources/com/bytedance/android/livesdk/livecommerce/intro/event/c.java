package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.livesdk.livecommerce.intro.model.resp.t;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.u;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Ref;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Runnable {
    public final /* synthetic */ IntroCardEventCenter a;

    public static final class a implements Runnable {
        public final /* synthetic */ IntroPromotionVO a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g c;
        public final /* synthetic */ c d;

        public a(IntroPromotionVO r1, Ref.ObjectRef r2, com.bytedance.android.ec.common.api.jump.model.g r3, c r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            IntroCardEventCenter r0 = this.d.a;
            v r1 = new v("livesdk_show_have_seen_label", this.c);
            r1.c("product_id", this.a.getProductId());
            r1.c("tag_name", (String) this.b.element);
            r0.d(r1, null);
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

    public c(IntroCardEventCenter r1) {
        this.a = r1;
    }

    public final void a() {
        com.bytedance.android.ec.common.api.jump.model.g r0 = IntroCardEventCenter.c(this.a);
        if (r0 == null) goto L26;
        ql.a r1 = r0.a;
        if ((r1 instanceof IntroPromotionVO) == true) goto L7;
        r1 = null;
    L7:
        IntroPromotionVO r2 = (IntroPromotionVO) r1;
        if (r2 == null) goto L27;
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = null;
        u r4 = r2.getImage();
        if (r4 == null) goto L19;
        List<t> r5 = r4.d();
        if (r5 == null) goto L19;
        Iterator<T> r6 = r5.iterator();
    L15:
        if (r6.hasNext() == false) goto L19;
        String r7 = ((t) r6.next()).e();
        if (r7 == null) goto L15;
        r3.element = r7;
    L19:
        oh.a.c("doShowHaveSeenLabelEvent", new a(r2, r3, r0, this));
        return;
    L27:
        return;
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
