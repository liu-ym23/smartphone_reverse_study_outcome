package sg8;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements tg8.b {
    public a() {
    }

    @Override // tg8.b
    public final boolean c(t1a.b r100, Message r101, q0 r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        List<Reference> r103 = com.larus.im.bean.message.a.G(r101);
        if (com.larus.bmhome.chat.bean.d.I0(r101) == false) goto L5;
    L9:
        return false;
    L5:
        if ((!r103.isEmpty()) == false) goto L7;
        return true;
    L7:
        if (com.larus.im.bean.message.a.f0(r101) == false) goto L9;
        return true;
    }
}
