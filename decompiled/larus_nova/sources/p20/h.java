package p20;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f527372a = null;

    static {
        f527372a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getMessage();
    L6:
        ALogger.i("DebugHybridTools_JSB", String.valueOf(r102));
        return;
    L5:
        r102 = null;
        goto L6
    }
}
