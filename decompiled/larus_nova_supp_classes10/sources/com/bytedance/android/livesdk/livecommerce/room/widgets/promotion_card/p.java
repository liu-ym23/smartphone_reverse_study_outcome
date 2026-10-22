package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$FromSource;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.RelatedInfoManager;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p {
    public Disposable a;
    public volatile boolean b;
    public volatile a c;
    public Function1<? super ECUIPromotion, Unit> d;
    public final RelatedInfoManager e;
    public final Function3<com.bytedance.android.livesdk.livecommerce.room.model.e, String, Boolean, Observable<ECCurrentPromotion>> f;
    public final Function2<com.bytedance.android.livesdk.livecommerce.room.model.e, Boolean, Observable<ECCurrentPromotion>> g;

    public static final class a {
        public final ECUIPromotion a;
        public final ECUIPromotion b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ECUIPromotion r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            ECUIPromotion r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "CombineResponse(explainCardResp=" + this.a + ", relatedCardResp=" + this.b + ")";
        }

        public a(ECUIPromotion r1, ECUIPromotion r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static void a(String r1) {
        dm.a.a("LiveCardLoad").i(r1);
    }

    public final void b(ECUIPromotion r3) {
        String r4 = r3.replaceRelatedInfo;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L15;
        a("replace related_info to ".concat(r4));
        this.e.i(r4, IRelatedInfoManager$FromSource.RELATED_CARD);
        return;
    L15:
        return;
    L7:
        r0 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(RelatedInfoManager r2, Function3<? super com.bytedance.android.livesdk.livecommerce.room.model.e, ? super String, ? super Boolean, ? extends Observable<ECCurrentPromotion>> r3, Function2<? super com.bytedance.android.livesdk.livecommerce.room.model.e, ? super Boolean, ? extends Observable<ECCurrentPromotion>> r4) {
        Intrinsics.checkNotNullParameter(r2, "relatedInfoManager");
        Intrinsics.checkNotNullParameter(r3, "relatedCardDataSource");
        Intrinsics.checkNotNullParameter(r4, "explainCardDataSource");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.b = true;
    }

    public final void c(ECContext r4, com.bytedance.android.livesdk.livecommerce.room.model.g r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "ecContext");
        Intrinsics.checkNotNullParameter(r5, "roomInfo");
        a("instant room, req explain card and related card, disposable = " + this.a);
        if (this.a == null) goto L5;
        return;
    L5:
        this.b = true;
        Function2<com.bytedance.android.livesdk.livecommerce.room.model.e, Boolean, Observable<ECCurrentPromotion>> r0 = this.g;
        Boolean r1 = Boolean.TRUE;
        this.a = bk2.c.a(Observable.combineLatest((Observable) r0.invoke(r5, r1), (Observable) this.f.invoke(r5, r6, r1), q.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this), new s(this)), (bk2.d) r4.getDisposableContext().getValue());
    }
}
