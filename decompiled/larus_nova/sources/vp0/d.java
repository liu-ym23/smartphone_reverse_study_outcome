package vp0;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f556551a;

    public d(Function0 r100) {
        this.f556551a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        qo0.a.b("AnchorPrivateMsgContextService", "request /webcast/microapp/private_msg_tab/update/ fail", (Throwable) r100);
        this.f556551a.invoke();
    }
}
