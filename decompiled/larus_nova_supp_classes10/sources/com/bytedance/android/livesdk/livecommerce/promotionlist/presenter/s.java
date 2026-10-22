package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.core.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements com.bytedance.android.livesdk.livecommerce.multitype.e {
    public final b a;
    public final /* synthetic */ LivePromotionListListingPresenter b;

    public static final class a implements Runnable {
        public final /* synthetic */ s a;

        public a(s r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.shopping.ligo.context.b<?> r0 = this.a.b.d0().getLigoContext();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.c("cart_icon_loc", this.a.b.r);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements com.bytedance.android.ec.monitor.duration.h {
        public final /* synthetic */ s a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ca3.b r0 = this.a.a.b.t;     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.triggerPreload();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public b(s r1) {
            this.a = r1;
        }

        public final void a(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "timestampCache");
            com.bytedance.android.ec.monitor.duration.h.a.d(r2);
        }

        public final void c(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r2, "data");
        }

        public final void d(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "timestampCache");
            com.bytedance.android.ec.monitor.duration.h.a.c(r2);
        }

        public final void f(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "timestampCache");
            Lazy r3 = UIUtils.a;
            UIUtils.e(new a(this));
        }

        public final void b(String r2, Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            Intrinsics.checkNotNullParameter(r3, "timestampCache");
            com.bytedance.android.ec.monitor.duration.h.a.b(r2, r3);
        }

        public final void e(Exception r3, Map r4) {
            Intrinsics.checkNotNullParameter("ReportDuration has error", "msg");
            Intrinsics.checkNotNullParameter(r3, "e");
            Intrinsics.checkNotNullParameter(r4, "timestampCache");
            com.bytedance.android.ec.monitor.duration.h.a.a(r3, r4);
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.multitype.e
    public final void a() {
        this.b.d0().reportFirstBindPromotionMonitorIfNeed(this.a);
        LivePromotionListListingPresenter r0 = this.b;
        if (r0.o == false) goto L6;
        r0.o = false;
        com.bytedance.android.ec.core.arch.event.c.d(r0.d0(), com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.r.a);
        LivePromotionListListingPresenter.k0(this.b).post(new a(this));
        return;
    }

    public s(LivePromotionListListingPresenter r1) {
        this.b = r1;
        this.a = new b(this);
    }
}
