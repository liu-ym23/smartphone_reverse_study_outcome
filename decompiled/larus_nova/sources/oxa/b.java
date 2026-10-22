package oxa;

import com.ss.android.lark.biz.im.api.extension.chat_window.e;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b<T extends e> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<T> f527096a;

    public b() {
        this.f527096a = new CopyOnWriteArrayList();
    }

    @Override // oxa.c
    public final void l(T r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f527096a.remove(r100);
    }

    @Override // oxa.c
    public final void m(T r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f527096a.addIfAbsent(r100);
    }
}
