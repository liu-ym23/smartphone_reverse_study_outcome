package li5;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ ax4.e<ShareUserInfoResult> a;

    public f(ax4.e<ShareUserInfoResult> r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.h("DocPermissionManager", "getUserInfo succeed");
        ax4.e<ShareUserInfoResult> r0 = this.a;
        r0.onSuccess((ShareUserInfoResult) r3);
    }
}
