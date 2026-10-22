package e33;

import com.lynx.tasm.LynxError;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {
    public static final void a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        com.bytedance.android.scope.c r101 = com.bytedance.android.scope.n.f163451a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        com.bytedance.android.scope.c.a r102 = new com.bytedance.android.scope.c.a();
        Iterator<T> r103 = r101.f163437b.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        ((com.bytedance.android.scope.b) r103.next()).a(r102, r100);
        goto L4
    L7:
        if (r102.f163438a == false) goto L9;
        return;
    L9:
        throw r100;
    }
}
