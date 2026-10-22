package r12;

import com.bytedance.android.livesdk.gift.model.p2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f535614a;

    public c(e r100) {
        this.f535614a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        p2 r101 = (p2) r100;
        this.f535614a.finishWithSuccess();
    }
}
