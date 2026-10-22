package qk2;

import com.bytedance.android.ec.model.g;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.s;
import com.bytedance.android.livesdk.livecommerce.event.o;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.model.e;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.live.datacontext.i;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import pk2.f;
import vi2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements pk2.a {

    /* JADX INFO: renamed from: qk2.a$a, reason: collision with other inner class name */
    public static final class C0164a {
    }

    public static final class b<T> implements SingleOnSubscribe {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ e e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ String g;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ Map i;

        /* JADX INFO: renamed from: qk2.a$b$a, reason: collision with other inner class name */
        public static final class C0165a<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public C0165a(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                ECCurrentPromotion r4 = (ECCurrentPromotion) r3;
                if (((g) r4).statusCode == 0) goto L5;
                this.a.onSuccess(new f(null));
                return;
            L5:
                if (r4.a() != null) goto L7;
                return;
            L7:
                if (r4.a().size() <= 0) goto L12;
                this.a.onSuccess(new f(r4));
                return;
            }
        }

        /* JADX INFO: renamed from: qk2.a$b$b, reason: collision with other inner class name */
        public static final class C0166b<T> implements Consumer {
            public final /* synthetic */ b a;
            public final /* synthetic */ SingleEmitter b;

            public C0166b(b r1, SingleEmitter r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r7) {
                SingleEmitter r0 = this.b;
                r0.tryOnError((Throwable) r7);
                int r8 = RoomContextController.h;
                b r9 = this.a;
                ECContext r10 = RoomContextController.a.b(r9.c, r9.d).r();
                if (r10 == null) goto L10;
                i<ECLivePerformanceMonitor> r11 = r10.getEcLivePerformanceMonitor();
                if (r11 == null) goto L11;
                ECLivePerformanceMonitor r1 = (ECLivePerformanceMonitor) r11.getValue();
                if (r1 == null) goto L12;
                r1.i();
                r1.x(false, null, null, null, "101");
                return;
            L12:
                return;
            L11:
                return;
            }
        }

        public b(String r1, String r2, String r3, String r4, com.bytedance.android.livesdk.livecommerce.room.model.g r5, boolean r6, String r7, boolean r8, Map r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }

        public final void subscribe(SingleEmitter<f> r19) {
            Intrinsics.checkNotNullParameter(r19, "emitter");
            h.l(this.a, this.b, this.c, this.d, this.e.e("live_popup_card"), "3", true, true, this.f, false, null, this.g, this.h, this.i, null).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0165a(r19), new C0166b(this, r19));
        }
    }

    static {
    }

    public a() {
    }

    public final Single<f> b(e r13, boolean r14, boolean r15, String r16, Map<String, String> r17) {
        Intrinsics.checkNotNullParameter(r13, "roomInfo");
        com.bytedance.android.livesdk.livecommerce.room.model.g r7 = (com.bytedance.android.livesdk.livecommerce.room.model.g) r13;
        String r5 = r7.roomId();
        String r6 = r7.a();
        String r3 = r7.c();
        String r4 = r7.d();
        o r0 = new o();
        PromotionListController.T.getClass();
        fh2.a r1 = PromotionListController.a.b(r5, r6);
        if (r1 == null) goto L7;
        int r2 = 1;
        if (((LivePromotionListFragment) r1).p() != true) goto L7;
    L8:
        r0.d("list_is_show", r2);
        r0.k();
        return Single.create(new b(r3, r4, r5, r6, r7, r14, r16, r15, r17));
    L7:
        r2 = 0;
        goto L8
    }

    @Override // pk2.a
    public final Observable<ECCurrentPromotion> a(e r20, boolean r21, boolean r22, boolean r23, s r24, Map<String, String> r25, String r26, uj2.c r27) {
        Intrinsics.checkNotNullParameter(r20, "roomInfo");
        o r1 = new o();
        PromotionListController.a r2 = PromotionListController.T;
        String r3 = r20.roomId();
        String r4 = r20.a();
        r2.getClass();
        fh2.a r5 = PromotionListController.a.b(r3, r4);
        if (r5 == null) goto L7;
        int r6 = 1;
        if (((LivePromotionListFragment) r5).p() != true) goto L7;
    L8:
        r1.d("list_is_show", r6);
        r1.k();
        return h.l(r20.c(), r20.d(), r20.roomId(), r20.a(), r20.e("live_popup_card"), "3", true, true, r21, r22, r24, r26, r23, r25, r27);
    L7:
        r6 = 0;
        goto L8
    }
}
