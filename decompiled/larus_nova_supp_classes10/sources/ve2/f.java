package ve2;

import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ tf0.b b;

    public f(e r1, com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "multiChorusPrepareApply success");
        hd0.c.f().k(1);
        this.b.b(vh7.f.c(IApplyResult.class));
        this.a.b = true;
    }
}
