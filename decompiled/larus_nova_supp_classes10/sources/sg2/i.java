package sg2;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import dagger.Module;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Module
public final class i {
    public static final d a = null;
    public static final a b = null;
    public static final b c = null;
    public static final c d = null;

    public static final class a implements el2.g {
        public a() {
        }

        @Override // el2.g
        public final <T> T getLiveSettingValue(String r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNull(r3);
            return (T) EComABUtils.getLiveSettingValue(r2, r3);
        }
    }

    public static final class b implements el2.i {
        public b() {
        }

        @Override // el2.i
        public final com.bytedance.android.livesdk.livecommerce.event.k a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            return new com.bytedance.android.livesdk.livecommerce.event.k(r2);
        }
    }

    public static final class c implements el2.k {
        public c() {
        }

        @Override // el2.k
        public final void a(com.bytedance.android.livesdk.livecommerce.saascoupon.e r3) {
            Intrinsics.checkNotNullParameter(r3, "cardControllerProvider");
            int r0 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.o;
            com.bytedance.android.livesdk.livecommerce.room.controller.business.n r1 = ControllerCenter.c(null, null).q;
            Objects.toString(r1);
            cf.d r2 = r1.h;
            if (r2 == null) goto L6;
            r2.a(r3);
            return;
        }

        @Override // el2.k
        public final Long b(String r5) {
            int r0 = RoomContextController.h;
            ECContext r6 = RoomContextController.a.b(r5, null).r();
            if (r6 == null) goto L12;
            com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r7 = r6.getEcLivePerformanceMonitor();
            if (r7 == null) goto L13;
            ECLivePerformanceMonitor r8 = (ECLivePerformanceMonitor) r7.getValue();
            if (r8 == null) goto L14;
            Long r9 = r8.c;
            if (r9 == null) goto L15;
            long r1 = r9.longValue();
            long r2 = SystemClock.elapsedRealtime() - r1;
            return Long.valueOf(System.currentTimeMillis() - r2);
        L15:
            return null;
        L14:
            return null;
        L13:
            return null;
        L12:
            return null;
        }

        @Override // el2.k
        public final void c(Context r12, zk.b r13, PromotionListController.c r14) {
            Intrinsics.checkNotNullParameter(r12, "context");
            PromotionListController.T.getClass();
            PromotionListController r1 = PromotionListController.a.a();
            Intrinsics.checkNotNull(r13);
            PromotionListController.N(r1, r12, "other", r13, r14, false, null, null, null, 192);
        }
    }

    public static final class d implements el2.l {
        public d() {
        }

        @Override // el2.l
        public final <T extends com.bytedance.android.ec.model.g> Observable<T> a(String r2, FilterNullArrayList<si2.k> r3, Class<T> r4, el2.m r5) {
            Intrinsics.checkNotNullParameter(r2, "path");
            Intrinsics.checkNotNullParameter(r3, "paramList");
            Intrinsics.checkNotNullParameter(r4, "clazz");
            return vi2.h.e(null, null, r2, new vi2.c(r3, r2, r5, r4));
        }

        @Override // el2.l
        public final <T extends com.bytedance.android.ec.model.g> Observable<T> b(final String r2, final FilterNullArrayList<si2.k> r3, final Class<T> r4, final el2.m r5) {
            Intrinsics.checkNotNullParameter(r2, "path");
            Intrinsics.checkNotNullParameter(r3, "paramList");
            Intrinsics.checkNotNullParameter(r4, "clazz");
            return vi2.h.e(null, null, r2, new vi2.d(r3, r2, r5, r4));
        }
    }

    public static final class e {
    }

    public i() {
    }

    static {
        a = new d();
        b = new a();
        c = new b();
        d = new c();
    }
}
