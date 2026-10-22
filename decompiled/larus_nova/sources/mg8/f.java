package mg8;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lg8.h;

/* JADX INFO: loaded from: classes25.dex */
public final class f implements tg8.b {
    public f() {
    }

    @Override // tg8.b
    public final boolean c(t1a.b r100, Message r101, q0 r102) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r101, "data");
        if (com.larus.bmhome.chat.bean.d.I0(r101) == false) goto L5;
    L20:
        boolean r103 = true;
    L22:
        return !r103;
    L5:
        if (r101.getMessageStatusLocal() != 21) goto L20;
        if (com.larus.bmhome.chat.bean.d.Q0(r101) == true) goto L20;
        if (h.b(r102, r101) == false) goto L20;
        Map<String, String> r104 = r101.getExt();
        if (r104 == null) goto L13;
        String r105 = r104.get("need_auth_identity");
    L15:
        if (Intrinsics.areEqual(r105, "1") == false) goto L20;
        if (h.a(r102, r101) == false) goto L20;
        r103 = false;
        goto L22
    L13:
        r105 = null;
        goto L15
    }
}
