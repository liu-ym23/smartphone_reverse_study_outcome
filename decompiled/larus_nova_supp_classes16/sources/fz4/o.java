package fz4;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class o implements Action {
    public /* synthetic */ o() {
    }

    public final void run() {
        Toast.cancelLoading();
    }
}
