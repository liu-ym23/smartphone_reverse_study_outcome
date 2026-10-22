package qk2;

import com.bytedance.android.livesdk.livecommerce.define.PromotionUpdateQueryFromType;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import vi2.v0;
import xi2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements SingleOnSubscribe {
    public final /* synthetic */ String a;

    public static final class a implements v0<k> {
        public final /* synthetic */ SingleEmitter a;

        public a(SingleEmitter r1) {
            this.a = r1;
        }

        @Override // vi2.v0
        public final void onError(Throwable r2) {
            SingleEmitter r0 = this.a;
            if (r2 != null) goto L5;
            r2 = new Throwable();
        L5:
            r0.tryOnError(r2);
        }

        @Override // vi2.v0
        public final void onSuccess(k r2) {
            k r3 = r2;
            SingleEmitter r0 = this.a;
            if (r3 != null) goto L5;
            r3 = new k();
        L5:
            r0.onSuccess(r3);
        }
    }

    public c(String r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<k> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        CompositeDisposable r0 = CoreRequests.a;     // Catch: Throwable -> L11
        String r1 = this.a;     // Catch: Throwable -> L11
        a r2 = new a(r5);     // Catch: Throwable -> L11
        PromotionUpdateQueryFromType.Companion.getClass();     // Catch: Throwable -> L11
        PromotionListController.T.getClass();     // Catch: Throwable -> L11
        fh2.a r3 = PromotionListController.a.b(null, null);     // Catch: Throwable -> L11
        if (r3 != null) goto L6;
    L8:
        PromotionUpdateQueryFromType r4 = PromotionUpdateQueryFromType.FROM_CARD_WITH_LIST_CLOSE;     // Catch: Throwable -> L11
    L9:
        CoreRequests.f(r1, r2, r4.getValue());     // Catch: Throwable -> L11
        return;
    L6:
        if (((LivePromotionListFragment) r3).p() != true) goto L8;
        r4 = PromotionUpdateQueryFromType.FROM_CARD_WITH_LIST_OPEN;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r5.tryOnError(th);
    }
}
