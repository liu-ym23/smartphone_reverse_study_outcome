package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.graphics.Bitmap;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r<T> implements ObservableOnSubscribe {
    public final /* synthetic */ String a;

    public static final class a<T> implements com.bytedance.android.ec.core.utils.o {
        public final /* synthetic */ ObservableEmitter a;

        public a(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.onNext(new com.bytedance.android.shopping.anchorv4.voavhs.blur.c((Bitmap) r3));
        }
    }

    public r(String r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<com.bytedance.android.shopping.anchorv4.voavhs.blur.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        ECLiveImageUtils.f(this.a, new a(r3));
    }
}
