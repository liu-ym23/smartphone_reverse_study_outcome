package j8b;

import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f497741a = null;

    static {
        f497741a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (r101 == null) goto L9;
        FileAuthMonitor.UpdateTrigger[] r102 = FileAuthMonitor.f418450a;
        String r103 = r101.getMessage();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        FileAuthMonitor.i(r103);
        return;
    }
}
