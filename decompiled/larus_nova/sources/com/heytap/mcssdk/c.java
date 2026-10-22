package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.mcssdk.utils.d;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class c {
    public c() {
    }

    public static void a(Context r100, Intent r101, IDataMessageCallBackService r102) {
        if (r100 != null) goto L6;
        String r103 = "context is null , please check param of parseIntent()";
    L4:
        d.e(r103);
        return;
    L6:
        if (r101 != null) goto L8;
        r103 = "intent is null , please check param of parseIntent()";
        goto L4
    L8:
        if (r102 != null) goto L11;
        r103 = "callback is null , please check param of parseIntent()";
        goto L4
    L11:
        if (Utils.isSupportPushByClient(r100) == true) goto L13;
        r103 = "push is null ,please check system has push";
        goto L4
    L13:
        List<BaseMode> r104 = com.heytap.mcssdk.e.c.a(r100, r101);
        if (r104 != null) goto L16;
        return;
    L16:
        Iterator<BaseMode> r105 = r104.iterator();
    L18:
        if (r105.hasNext() == false) goto L27;
        BaseMode r106 = r105.next();
        if (r106 == null) goto L18;
        Iterator<com.heytap.mcssdk.f.c> r107 = PushService.getInstance().getProcessors().iterator();
    L23:
        if (r107.hasNext() == false) goto L18;
        com.heytap.mcssdk.f.c r108 = r107.next();
        if (r108 == null) goto L23;
        r108.a(r100, r106, r102);
        goto L23
    }
}
