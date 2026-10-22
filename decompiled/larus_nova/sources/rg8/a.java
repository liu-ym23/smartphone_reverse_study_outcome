package rg8;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements tg8.b {
    public a() {
    }

    @Override // tg8.b
    public final boolean c(t1a.b r100, Message r101, q0 r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        if (com.larus.bmhome.chat.bean.d.x0(r101) == true) goto L6;
        return false;
    L6:
        return true;
    }
}
