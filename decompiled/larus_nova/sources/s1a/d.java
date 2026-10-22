package s1a;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.ui.arch.context.internal.VContextStore;
import defpackage.t0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {
    public static final t1a.b a(AttachReceiver r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof EmptyComponent) == false) goto L7;
        return new t0();
    L7:
        if ((r100 instanceof Container) == false) goto L13;
        t1a.b r101 = com.larus.ui.arch.context.internal.a.a(((Container) r100).getParent());
        if (r101 == null) goto L11;
        return r101;
    L11:
        return new t0();
    L13:
        if (x1a.a.f562151b == true) goto L15;
        int r102 = y1a.a.f565679a;
        y1a.a.a("ComponentArch", "find vContext from " + r100.getParent());
    L15:
        t1a.b r103 = com.larus.ui.arch.context.internal.a.a(r100.getParent());
        if (r103 == null) goto L23;
        if ((r103 instanceof t0) == true) goto L25;
        VContextStore.Companion.getClass();
        return VContextStore.a.a(r100).getOrInit(r103);
    L25:
        return r103;
    L23:
        throw new Exception("can't find parent: " + r100.getParent());
    }
}
