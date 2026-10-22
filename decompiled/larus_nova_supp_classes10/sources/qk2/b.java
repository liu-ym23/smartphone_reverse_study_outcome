package qk2;

import com.bytedance.android.ec.model.g;
import com.bytedance.android.ec.model.response.ECPromotionPriceResponse;
import com.bytedance.android.ec.model.response.PromotionPriceInfo;
import com.bytedance.android.livesdk.livecommerce.define.PromotionUpdateQueryFromType;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.model.e;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vi2.h;
import vi2.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements SingleOnSubscribe {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ e d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ SingleEmitter a;

        public a(SingleEmitter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ECPromotionPriceResponse r5 = (ECPromotionPriceResponse) r4;
            PromotionPriceInfo r1 = null;
            if (((g) r5).statusCode != 0) goto L13;
            List r0 = r5.getPriceInfoList();
            if (r0 == null) goto L7;
            int r2 = r0.size();
        L8:
            if (r2 <= 0) goto L13;
            SingleEmitter r3 = this.a;
            List r6 = r5.getPriceInfoList();
            if (r6 == null) goto L12;
            r1 = (PromotionPriceInfo) CollectionsKt.first(r6);
        L12:
            r3.onSuccess(new pk2.e(r1));
            return;
        L7:
            r2 = 0;
        L13:
            this.a.onSuccess(new pk2.e(null));
        }
    }

    /* JADX INFO: renamed from: qk2.b$b, reason: collision with other inner class name */
    public static final class C0167b<T> implements Consumer {
        public final /* synthetic */ SingleEmitter a;

        public C0167b(SingleEmitter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            SingleEmitter r0 = this.a;
            r0.tryOnError((Throwable) r2);
        }
    }

    public b(String r1, String r2, String r3, e r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void subscribe(SingleEmitter<pk2.e> r14) {
        Intrinsics.checkNotNullParameter(r14, "emitter");
        String r2 = this.a;
        String r3 = this.b;
        String r0 = this.c;
        String r10 = this.d.a();
        String r6 = this.d.e("live_popup_card");
        String r7 = this.e;
        String r8 = this.f;
        PromotionUpdateQueryFromType.a r1 = PromotionUpdateQueryFromType.Companion;
        String r4 = this.c;
        String r5 = this.d.a();
        r1.getClass();
        PromotionListController.T.getClass();
        fh2.a r9 = PromotionListController.a.b(r4, r5);
        if (r9 != null) goto L5;
    L7:
        PromotionUpdateQueryFromType r11 = PromotionUpdateQueryFromType.FROM_CARD_WITH_LIST_CLOSE;
    L8:
        int r12 = r11.getValue();
        String r13 = h.a;
        h.e(r0, r10, si2.g.l, new r0(r2, r3, r0, r10, r6, r7, r8, r12)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r14), new C0167b(r14));
        return;
    L5:
        if (((LivePromotionListFragment) r9).p() != true) goto L7;
        r11 = PromotionUpdateQueryFromType.FROM_CARD_WITH_LIST_OPEN;
        goto L8
    }
}
