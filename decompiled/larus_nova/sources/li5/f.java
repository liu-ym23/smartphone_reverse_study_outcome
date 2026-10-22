package li5;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ax4.e<ShareUserInfoResult> f509363a;

    public f(ax4.e<ShareUserInfoResult> r100) {
        this.f509363a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("DocPermissionManager", "getUserInfo succeed");
        ax4.e<ShareUserInfoResult> r101 = this.f509363a;
        r101.onSuccess((ShareUserInfoResult) r100);
    }
}
