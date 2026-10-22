package ega;

import com.obric.assistant.multiuser.api.IObricMultiUserService;

/* JADX INFO: loaded from: classes33.dex */
public final class a {
    static {
    }

    public static boolean a() {
        IObricMultiUserService.f390298a.getClass();
        IObricMultiUserService r100 = IObricMultiUserService.a.a();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.a() != true) goto L7;
        return true;
    }
}
