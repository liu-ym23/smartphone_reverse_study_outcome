package vp0;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f556547a;

    public b(Function0 r100) {
        this.f556547a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        qo0.a.b("AnchorPrivateMsgContextService", "request /webcast/microapp/private_msg_tab/get/ fail", (Throwable) r100);
        Function0 r101 = this.f556547a;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke();
        return;
    }
}
