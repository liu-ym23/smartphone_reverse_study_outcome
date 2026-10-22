package oxa;

import com.ss.android.lark.biz.im.api.extension.chat_window.e;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a<T extends e> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<T> f527095a;

    public a() {
        this.f527095a = new ArrayList();
    }

    @Override // oxa.c
    public final void m(T r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.f527095a.contains(r100) == false) goto L5;
        return;
    L5:
        this.f527095a.add(r100);
    }
}
