package li5;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ax4.e<ShareUserInfoResult> f509361a;

    public d(com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a.b r100) {
        this.f509361a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("DocPermissionManager", "getSyncedBlockUserInfo success");
        ax4.e<ShareUserInfoResult> r101 = this.f509361a;
        r101.onSuccess((ShareUserInfoResult) r100);
    }
}
