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

/* JADX INFO: loaded from: classes10.dex */
public final class c<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f533486a;

    public static final class a implements v0<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter f533487a;

        public a(SingleEmitter r100) {
            this.f533487a = r100;
        }

        @Override // vi2.v0
        public final void onError(Throwable r100) {
            SingleEmitter r101 = this.f533487a;
            if (r100 != null) goto L5;
            r100 = new Throwable();
        L5:
            r101.tryOnError(r100);
        }

        @Override // vi2.v0
        public final void onSuccess(k r100) {
            k r101 = r100;
            SingleEmitter r102 = this.f533487a;
            if (r101 != null) goto L5;
            r101 = new k();
        L5:
            r102.onSuccess(r101);
        }
    }

    public c(String r100) {
        this.f533486a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        CompositeDisposable r101 = CoreRequests.f151395a;     // Catch: Throwable -> L11
        String r102 = this.f533486a;     // Catch: Throwable -> L11
        a r103 = new a(r100);     // Catch: Throwable -> L11
        PromotionUpdateQueryFromType.Companion.getClass();     // Catch: Throwable -> L11
        PromotionListController.T.getClass();     // Catch: Throwable -> L11
        fh2.a r104 = PromotionListController.a.b(null, null);     // Catch: Throwable -> L11
        if (r104 != null) goto L6;
    L8:
        PromotionUpdateQueryFromType r105 = PromotionUpdateQueryFromType.FROM_CARD_WITH_LIST_CLOSE;     // Catch: Throwable -> L11
    L9:
        CoreRequests.f(r102, r103, r105.getValue());     // Catch: Throwable -> L11
        return;
    L6:
        if (((LivePromotionListFragment) r104).p() != true) goto L8;
        r105 = PromotionUpdateQueryFromType.FROM_CARD_WITH_LIST_OPEN;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r100.tryOnError(th);
    }
}
