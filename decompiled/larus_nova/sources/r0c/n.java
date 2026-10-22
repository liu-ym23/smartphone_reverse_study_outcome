package r0c;

import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: classes37.dex */
public final class n implements RxScheduledExecutor.Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f535544a;

    public n(k r100) {
        this.f535544a = r100;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
    public final void consume(Throwable r100) {
        this.f535544a.c();
        Log.e("SavePhotoUrlAction", "save edited photo failed", r100);
        LKUIToast.show(this.f535544a.f535529a, R.string.Lark_Legacy_SaveFailTip);
        k.b(this.f535544a, false);
    }
}
