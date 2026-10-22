package ve2;

import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f554337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tf0.b f554338b;

    public f(e r100, com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r101) {
        this.f554337a = r100;
        this.f554338b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "multiChorusPrepareApply success");
        hd0.c.f().k(1);
        this.f554338b.b((IApplyResult) vh7.f.c(IApplyResult.class));
        this.f554337a.f554325b = true;
    }
}
