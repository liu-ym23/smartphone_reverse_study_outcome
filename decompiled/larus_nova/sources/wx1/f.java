package wx1;

import com.bytedance.android.gamecp.host_api.model.user.IUser;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements SingleObserver<IUser> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.a f561760a;

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    public f(g.a r100) {
        this.f561760a = r100;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(IUser r100) {
        IUser r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "iUser");
        this.f561760a.f561768a.f(r101);
    }
}
