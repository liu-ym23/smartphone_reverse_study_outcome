package mf5;

import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SharePermissionViewModel f513631a;

    public d(SharePermissionViewModel r100) {
        this.f513631a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        tt5.a.e(this.f513631a.f232154d, "fetchUserPermission: ", r101, false);
    }
}
