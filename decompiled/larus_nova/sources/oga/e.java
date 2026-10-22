package oga;

import android.os.Handler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f523226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f523227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f523228c;

    @Override // oga.a
    public final void onDismissFailed() {
        Handler r100 = this.f523226a;
        if (r100 == null) goto L5;
        final Function0<Unit> r101 = this.f523228c;
        r100.post(new c(r101));
        return;
    L5:
        this.f523228c.invoke();
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        Handler r100 = this.f523226a;
        if (r100 == null) goto L5;
        final Function0<Unit> r101 = this.f523227b;
        r100.post(new d(r101));
        return;
    L5:
        this.f523227b.invoke();
    }

    public e(Handler r100, Function0<Unit> r101, Function0<Unit> r102) {
        this.f523226a = r100;
        this.f523227b = r101;
        this.f523228c = r102;
    }
}
