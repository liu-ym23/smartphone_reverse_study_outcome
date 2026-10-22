package a65;

import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements UDToast.b {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.compose.foundation.toast.b r9) {
        Intrinsics.checkNotNullParameter(r9, "toast");
        c r10 = this.a;
        if (r10.c == null) goto L6;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).r3(r10.a, r10.d, e.l.b, r10.c, "", "from_banner");
        return;
    }
}
