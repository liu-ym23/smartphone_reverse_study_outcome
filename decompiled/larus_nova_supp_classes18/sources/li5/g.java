package li5;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ ax4.e<ShareUserInfoResult> a;

    public g(ax4.e<ShareUserInfoResult> r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        tt5.a.f("DocPermissionManager", r4, false);
        this.a.onFailed(r4);
    }
}
