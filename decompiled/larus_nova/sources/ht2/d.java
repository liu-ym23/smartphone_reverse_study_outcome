package ht2;

import com.bytedance.android.logsdk.format.Spm;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f487108a = null;

    static {
        f487108a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.b7000").result(101).addArg("error_msg", ((Throwable) r100).getMessage()), "crash");
    }
}
