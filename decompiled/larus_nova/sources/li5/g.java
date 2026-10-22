package li5;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ax4.e<ShareUserInfoResult> f509364a;

    public g(ax4.e<ShareUserInfoResult> r100) {
        this.f509364a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.f("DocPermissionManager", r101, false);
        this.f509364a.onFailed(r101);
    }
}
