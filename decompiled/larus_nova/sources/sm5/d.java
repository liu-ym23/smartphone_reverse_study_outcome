package sm5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f542577a = null;

    static {
        f542577a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Toast.cancelLoading();
    }
}
