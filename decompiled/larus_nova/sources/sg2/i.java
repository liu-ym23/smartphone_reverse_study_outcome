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
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.Module;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Module
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f541805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f541806b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f541807c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f541808d = null;

    public static final class a implements el2.g {
        public a() {
        }

        @Override // el2.g
        public final <T> T getLiveSettingValue(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNull(r101);
            return (T) EComABUtils.getLiveSettingValue(r100, r101);
        }
    }

    public static final class b implements el2.i {
        public b() {
        }

        @Override // el2.i
        public final com.bytedance.android.livesdk.livecommerce.event.k a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            return new com.bytedance.android.livesdk.livecommerce.event.k(r100);
        }
    }

    public static final class c implements el2.k {
        public c() {
        }

        @Override // el2.k
        public final void a(com.bytedance.android.livesdk.livecommerce.saascoupon.e r100) {
            Intrinsics.checkNotNullParameter(r100, "cardControllerProvider");
            int r101 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.f151643o;
            com.bytedance.android.livesdk.livecommerce.room.controller.business.n r102 = ControllerCenter.c(null, null).f151426q;
            Objects.toString(r102);
            cf.d r103 = r102.f151649h;
            if (r103 == null) goto L6;
            r103.a(r100);
            return;
        }

        @Override // el2.k
        public final Long b(String r100) {
            int r101 = RoomContextController.f151593h;
            ECContext r102 = RoomContextController.a.b(r100, null).r();
            if (r102 == null) goto L12;
            com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r103 = r102.getEcLivePerformanceMonitor();
            if (r103 == null) goto L13;
            ECLivePerformanceMonitor r104 = r103.getValue();
            if (r104 == null) goto L14;
            Long r105 = r104.f149749c;
            if (r105 == null) goto L15;
            long r106 = r105.longValue();
            long r107 = SystemClock.elapsedRealtime() - r106;
            return Long.valueOf(System.currentTimeMillis() - r107);
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
        public final void c(Context r110, zk.b r111, PromotionListController.c r112) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            PromotionListController.T.getClass();
            PromotionListController r100 = PromotionListController.a.a();
            Intrinsics.checkNotNull(r111);
            PromotionListController.N(r100, r110, "other", r111, r112, false, null, null, null, 192);
        }
    }

    public static final class d implements el2.l {
        public d() {
        }

        @Override // el2.l
        public final <T extends com.bytedance.android.ec.model.g> Observable<T> a(String r100, FilterNullArrayList<si2.k> r101, Class<T> r102, el2.m r103) {
            Intrinsics.checkNotNullParameter(r100, "path");
            Intrinsics.checkNotNullParameter(r101, "paramList");
            Intrinsics.checkNotNullParameter(r102, "clazz");
            return vi2.h.e(null, null, r100, new vi2.c(r101, r100, r103, r102));
        }

        @Override // el2.l
        public final <T extends com.bytedance.android.ec.model.g> Observable<T> b(final String r100, final FilterNullArrayList<si2.k> r101, final Class<T> r102, final el2.m r103) {
            Intrinsics.checkNotNullParameter(r100, "path");
            Intrinsics.checkNotNullParameter(r101, "paramList");
            Intrinsics.checkNotNullParameter(r102, "clazz");
            return vi2.h.e(null, null, r100, new vi2.d(r101, r100, r103, r102));
        }
    }

    public static final class e {
    }

    public i() {
    }

    static {
        f541805a = new d();
        f541806b = new a();
        f541807c = new b();
        f541808d = new c();
    }
}
