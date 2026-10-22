package ej0;

import com.bytedance.android.live.liveinteract.plantform.model.y0;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter.PaidProfileCardControlPresenter;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.interact.i1;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidProfileCardControlPresenter f472835a;

    public a(PaidProfileCardControlPresenter r100) {
        this.f472835a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        e r101 = (e) r100;
        if (r101 == null) goto L13;
        y0 r102 = (y0) r101.data;
        if (r102 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r102.needShow, Boolean.TRUE) == false) goto L14;
        i1 r103 = r102.explainCardInfo;
        if (r103 == null) goto L15;
        PaidProfileCardControlPresenter r104 = this.f472835a;
        int r105 = PaidProfileCardControlPresenter.f78569h;
        r104.i0(r103);
        return;
    L15:
        return;
    L14:
        return;
    }
}
