package lg8;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements tg8.b {
    public g() {
    }

    @Override // tg8.b
    public final boolean c(t1a.b r100, Message r101, q0 r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        boolean r103 = h.b(r102, r101);
        boolean r104 = hc8.c.f484552a.j(r101);
        if (r103 == false) goto L8;
        if (r104 == false) goto L10;
        return true;
    L10:
        return false;
    L8:
        return false;
    }
}
