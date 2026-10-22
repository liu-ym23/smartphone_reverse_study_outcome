package i39;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.larus.utils.k0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements q97.a {
    public c() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        int r101 = k0.f375428a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L9:
        return Intrinsics.areEqual("//flow/new_doc", k0.a(r103));
    L7:
        r103 = null;
        goto L9
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        Fragment r102 = com.larus.doc.impl.chat.a.a();
        if (r102 == null) goto L11;
        t1a.b r103 = s1a.a.g(r102);
        if (r103 == null) goto L12;
        g39.c r104 = (g39.c) r103.getAbility(g39.c.class);
        if (r104 == null) goto L13;
        r104.HA();
        return true;
    L13:
        return true;
    L12:
        return true;
    L11:
        return true;
    }
}
