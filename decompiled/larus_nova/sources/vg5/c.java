package vg5;

import com.bytedance.ee.bear.middleground.permission.escape.request.CreateInstanceResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ax4.e<CreateInstanceResult> f554701a;

    public c(d r100) {
        this.f554701a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.h("DocInviteMemberManagerModel", "inviteUsersByEscape()...error = " + r101.getMessage());
        this.f554701a.onFailed(r101);
    }
}
