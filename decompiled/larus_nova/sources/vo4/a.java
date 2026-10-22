package vo4;

import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;
import tb5.n;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements n {

    /* JADX INFO: renamed from: vo4.a$a, reason: collision with other inner class name */
    public static final class C8027a {
    }

    static {
    }

    public a() {
    }

    @Override // tb5.n
    public final void b() {
        Intrinsics.checkNotNullParameter("biz.util.onKeyboardChanged", "handlerName");
        tt5.a.b("BaseAddBridge", "unbindBridgeHandler handlerName=biz.util.onKeyboardChanged");
    }

    @Override // tb5.n
    public final void c(String r100, i<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        Intrinsics.checkNotNullParameter(r101, "handler");
        tt5.a.b("BaseAddBridge", "bindBridgeHandler handlerName=" + r100);
    }

    @Override // tb5.n
    public final void a(String r100, Object r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        tt5.a.b("BaseAddBridge", "dispatchBridgeMsg handlerName=" + r100 + " data=" + r101);
    }
}
