package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l<T> implements ObservableOnSubscribe {
    public final /* synthetic */ k a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ String e;

    public static final class a implements zt0.b {
        public a() {
        }

        public final void a(String r3) {
            ALogger.i("RTChorusRoomDressResource", "onSyncSuccess: " + r3);
        }

        public final void b(String r3, String r4, int r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "version");
            Intrinsics.checkNotNullParameter(r4, "version");
            ALogger.e("RTChorusRoomDressResource", "onSyncFailed: " + r3 + ", " + r4 + ", " + r5 + ", " + r6);
        }
    }

    public l(k r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = 35;
        this.d = r3;
        this.e = "rt_chorus";
    }

    public final void subscribe(ObservableEmitter<com.bytedance.android.live.profit.dress.t> r9) {
        Intrinsics.checkNotNullParameter(r9, "it");
        this.a.getClass();
        com.bytedance.android.live.profit.dress.t r0 = yt0.c.a().getDressData(this.b, this.c, this.d, this.e, new a());
        if (r0 == null) goto L5;
        r9.onNext(r0);
        r9.onComplete();
        return;
    L5:
        r9.onError(new Throwable("dressData is null"));
    }
}
