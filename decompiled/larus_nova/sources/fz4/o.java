package fz4;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class o implements Action {
    public /* synthetic */ o() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Toast.cancelLoading();
    }
}
