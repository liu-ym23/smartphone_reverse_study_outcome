package qz1;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleSweepGiftViewHolder;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleSweepGiftViewHolder f535268a;

    public v(SimpleSweepGiftViewHolder r100) {
        this.f535268a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        GiftIconMaskView r102 = this.f535268a.W3();
        if (r102 == null) goto L6;
        r102.setVisibility(8);
        return;
    }
}
