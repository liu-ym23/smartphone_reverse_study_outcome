package qz1;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleSweepGiftViewHolder;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleSweepGiftViewHolder f535267a;

    public u(SimpleSweepGiftViewHolder r100) {
        this.f535267a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        rz1.b r101 = this.f535267a.V3();
        r101.a((Bitmap) r100);
        this.f535267a.V3().c(null);
    }
}
