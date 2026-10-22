package gj0;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f481490a = null;

    static {
        f481490a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        String r102 = r101.getMessage();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        f2.c(r101.getMessage(), 0);
        return;
    L12:
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
