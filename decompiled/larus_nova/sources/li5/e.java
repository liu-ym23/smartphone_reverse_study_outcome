package li5;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ax4.e<ShareUserInfoResult> f509362a;

    public e(com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a.b r100) {
        this.f509362a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.d("DocPermissionManager", "getSyncedBlockUserInfo error" + r101);
        this.f509362a.onFailed(r101);
    }
}
