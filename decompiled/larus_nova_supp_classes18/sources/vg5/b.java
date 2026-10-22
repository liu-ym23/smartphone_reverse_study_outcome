package vg5;

import com.bytedance.ee.bear.middleground.permission.escape.request.CreateInstanceResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ ax4.e<CreateInstanceResult> a;

    public b(d r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.h("DocInviteMemberManagerModel", "inviteUsersByEscape()...succeed");
        ax4.e<CreateInstanceResult> r0 = this.a;
        r0.onSuccess((CreateInstanceResult) r3);
    }
}
