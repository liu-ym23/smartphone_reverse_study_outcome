package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a implements r {
    public a() {
    }

    @Override // kotlinx.coroutines.internal.r
    public int b() {
        return 1073741823;
    }

    @Override // kotlinx.coroutines.internal.r
    public String c() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.r
    public MainCoroutineDispatcher a(List<? extends r> r100) {
        Looper r101 = Looper.getMainLooper();
        if (r101 == null) goto L7;
        return new HandlerContext(HandlerDispatcherKt.asHandler(r101, true));
    L7:
        throw new IllegalStateException("The main looper is not available");
    }
}
