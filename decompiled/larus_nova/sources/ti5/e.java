package ti5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransferApplyFragment f546120a;

    public e(TransferApplyFragment r100) {
        this.f546120a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        Toast.cancelLoading();
        TransferApplyFragment.aa0(this.f546120a);
    }
}
