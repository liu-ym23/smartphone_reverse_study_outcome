package com.heytap.mcssdk.e;

import android.content.Context;
import android.content.Intent;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.heytap.mcssdk.PushService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements d {
    public c() {
    }

    public static List<BaseMode> a(Context r100, Intent r101) {
        if (r101 != null) goto L18;
        return null;
    L18:
        int r102 = CastIntegerProtector.parseInt(com.heytap.mcssdk.utils.b.d(r101.getStringExtra("type")));     // Catch: Exception -> L7
    L9:
        com.heytap.mcssdk.utils.d.b("MessageParser--getMessageByIntent--type:" + r102);
        ArrayList r103 = new ArrayList();
        Iterator<d> r104 = PushService.getInstance().getParsers().iterator();
    L11:
        if (r104.hasNext() == false) goto L17;
        d r105 = r104.next();
        if (r105 == null) goto L11;
        BaseMode r106 = r105.a(r100, r102, r101);
        if (r106 == null) goto L11;
        r103.add(r106);
        goto L11
    L17:
        return r103;
    L7:
        e = move-exception;
        com.heytap.mcssdk.utils.d.e("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
        r102 = 4096;
        goto L9
    }

    public abstract BaseMode a(Intent r100, int r101);
}
