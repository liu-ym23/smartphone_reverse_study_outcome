package li5;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ ax4.e<ShareUserInfoResult> a;

    public e(com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a.b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        tt5.a.d("DocPermissionManager", "getSyncedBlockUserInfo error" + r4);
        this.a.onFailed(r4);
    }
}
