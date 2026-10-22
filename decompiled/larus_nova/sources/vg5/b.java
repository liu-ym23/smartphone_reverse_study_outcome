package vg5;

import com.bytedance.ee.bear.middleground.permission.escape.request.CreateInstanceResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ax4.e<CreateInstanceResult> f554700a;

    public b(d r100) {
        this.f554700a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("DocInviteMemberManagerModel", "inviteUsersByEscape()...succeed");
        ax4.e<CreateInstanceResult> r101 = this.f554700a;
        r101.onSuccess((CreateInstanceResult) r100);
    }
}
