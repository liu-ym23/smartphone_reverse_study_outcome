package sm5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Action {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void run() {
        Toast.cancelLoading();
    }
}
