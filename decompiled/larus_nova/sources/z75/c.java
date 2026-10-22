package z75;

import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;

/* JADX INFO: loaded from: classes16.dex */
public final class c {
    static {
    }

    public static by4.c a(UserSession r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (((dn4.a) k.b(((v) k.a(LarkContext.getApplication(), v.class)).c(r100), dn4.a.class)).a().isEnable("ccm.drive.mobile.file_ext") == true) goto L6;
        return null;
    L6:
        return (by4.c) k.b(((v) k.a(LarkContext.getApplication(), v.class)).c(r100), by4.c.class);
    }
}
