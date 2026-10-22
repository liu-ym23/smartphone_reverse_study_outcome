package sm5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements Action {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void run() {
        Toast.cancelLoading();
    }
}
