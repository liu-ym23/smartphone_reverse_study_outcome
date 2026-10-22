package ti5;

import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransferApplyFragment f546122a;

    public g(TransferApplyFragment r100) {
        this.f546122a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        TransferApplyFragment r102 = this.f546122a;
        Intrinsics.checkNotNull(r101);
        r102.f234289k = r101.booleanValue();
    }
}
