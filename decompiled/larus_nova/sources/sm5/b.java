package sm5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f542575a = null;

    static {
        f542575a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Toast.cancelLoading();
    }
}
