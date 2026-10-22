package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;

/* JADX INFO: loaded from: classes5.dex */
public final class e implements com.obric.assistant.provider.hybrid.a {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // com.obric.assistant.provider.hybrid.a
    public Bundle call(String r100, Bundle r101) {
        if (r101 == null) goto L5;
        String r102 = r101.getString("packageName");
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        FLogger.f375446a.w("OpenLoginAbility", "no package name");
        return null;
    L16:
        FLogger.f375446a.i("OpenLoginAbility", r102 + " call login");
        t0.e(new d());
        return null;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }
}
