package s0b;

import com.ss.android.lark.officesdk.utils.di.j;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes35.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T> f540066a = null;

    static {
        f540066a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        j.c("CML_TAG_GeckoResManager", "executeCheckUpdate failed", (Throwable) r100);
    }
}
