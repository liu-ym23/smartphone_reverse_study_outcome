package com.bytedance.android.livesdk.livecommerce;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/ECommerceSDK;", "", "()V", "init", "", "callBack", "Lkotlin/Function1;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECommerceSDK {
    public static final ECommerceSDK INSTANCE = null;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<Void> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            if (ECLiveABUtils.INSTANCE.getENABLE_CONVERTER_OPT() == false) goto L7;
            int r3 = ECSdk.a;
            IAdapterService r4 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r4 == null) goto L10;
            r4.injectRoomControllerProviderV2(com.bytedance.android.livesdk.livecommerce.room.c.a);
        L10:
            ECLiveCommerce.getCommerceService();
            Function1 r5 = this.a;
            if (r5 == null) goto L14;
            Unit r6 = (Unit) r5.invoke(Boolean.TRUE);
            return;
        L14:
            return;
        L7:
            int r7 = ECSdk.a;
            IAdapterService r8 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r8 == null) goto L10;
            r8.injectRoomControllerProvider(com.bytedance.android.livesdk.livecommerce.room.b.a);
            goto L10
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Void r2 = (Void) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            if (com.bytedance.android.ec.sdk.a.a == true) goto L8;
            r3.getMessage();
            Function1 r4 = this.a;
            if (r4 == null) goto L9;
            Unit r5 = (Unit) r4.invoke(Boolean.FALSE);
            return;
        L9:
            return;
        L8:
            throw r3;
        }
    }

    private ECommerceSDK() {
    }

    static {
        INSTANCE = new ECommerceSDK();
    }

    @JvmStatic
    public static final void init(Function1<? super Boolean, Unit> r3) {
        nl2.b.b(Observable.create(new a(r3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(b.a, new c(r3)));
    }

    public static /* synthetic */ void init$default(Function1 r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L5;
        r0 = null;
    L5:
        init(r0);
    }
}
