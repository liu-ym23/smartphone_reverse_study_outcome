package di2;

import cf.q;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.eventcenter.d;
import com.bytedance.android.livesdk.livecommerce.iron.ui.i;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import lh2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements q {
    public final di2.a a;
    public final i b;
    public final q c;
    public final RoomContextController d;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ ql.a b;
        public final /* synthetic */ String c;

        public a(b r1, ql.a r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r0 = this.a.c;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(this.b, this.c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void a(ql.a r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "promotion");
        Lazy r0 = LiveEventCenter.b;
        d r1 = LiveEventCenter.a.a();
        String r2 = this.a.getRoomId();
        RoomContextController r3 = this.d;
        if (r3 == null) goto L5;
        String r4 = r3.D();
    L6:
        r1.sendEvent("product_show", new c(r2, r4, r6, 1));
        this.b.postRunnable(new a(this, r6, r7));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public b(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.b r2, i r3, RoomContextController r4) {
        Intrinsics.checkNotNullParameter(r2, "paramContext");
        Intrinsics.checkNotNullParameter(r3, "pendingHandler");
        this.a = r2;
        this.b = r3;
        this.c = null;
        this.d = r4;
    }
}
