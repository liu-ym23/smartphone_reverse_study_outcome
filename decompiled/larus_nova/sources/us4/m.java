package us4;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f551504a;

    public m(l r100) {
        this.f551504a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f551504a.f551499o = false;
        Toast.cancelLoading();
    }
}
