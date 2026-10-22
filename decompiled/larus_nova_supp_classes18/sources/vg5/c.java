package vg5;

import com.bytedance.ee.bear.middleground.permission.escape.request.CreateInstanceResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ ax4.e<CreateInstanceResult> a;

    public c(d r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        tt5.a.h("DocInviteMemberManagerModel", "inviteUsersByEscape()...error = " + r4.getMessage());
        this.a.onFailed(r4);
    }
}
