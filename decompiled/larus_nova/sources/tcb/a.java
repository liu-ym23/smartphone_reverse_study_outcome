package tcb;

import com.ss.android.lark.log.Log;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a<T> implements Callable<T> {
    public abstract T a() throws Exception;

    @Override // java.util.concurrent.Callable
    public final T call() throws Exception {
        return a();
    L4:
        e = move-exception;
        Log.e("ExceptionDetectorCallab", "" + e.getStackTrace(), e, true);
        return null;
    }

    public a() {
    }
}
