package us4;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f551505a;

    public n(l r100) {
        this.f551505a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocumentCreateInfo r101 = (DocumentCreateInfo) r100;
        if (TextUtils.isEmpty(r101.f216950d) == true) goto L5;
        this.f551505a.e(r101.f216950d);
        return;
    L5:
        Toast.showFailureText(this.f551505a.getContext(), R.string.Doc_Facade_CreateFailed);
        this.f551505a.d();
    }
}
