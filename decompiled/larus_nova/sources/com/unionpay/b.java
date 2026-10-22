package com.unionpay;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.unionpay.utils.UPUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements Handler.Callback {
    public b() {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r110) {
        String r100 = "0";
        switch(r110.what) {
            case 1001: goto L53;
            case 1002: goto L58;
            case 1003: goto L6;
            case 1004: goto L5;
            default: goto L55;
        };
    L5:
        a.f462142q = true;
    L16:
        a.h(r100);
        goto L55
    L6:
        a.f462144s.removeMessages(1004);
        Object r111 = r110.obj;     // Catch: Exception -> L13
        if ((r111 instanceof Integer) == false) goto L15;
        if (((Integer) r111).intValue() != 1) goto L15;
        r100 = "1";
    L15:
        if (a.f462142q == true) goto L55;
    L53:
        a.f462141p = true;
    L54:
        a.f(a.k(), a.f462148w, a.f462140o);
    L55:
        return true;
    L58:
    L48:
        e = move-exception;
        e.printStackTrace();
    L51:
        if (a.f462141p == true) goto L55;
    L18:
        if (r110.obj == null) goto L51;
        JSONObject r101 = new JSONObject((String) r110.obj);     // Catch: Exception -> L48
        String r102 = com.unionpay.utils.g.b(r101, "sign");     // Catch: Exception -> L48
        int r103 = CastIntegerProtector.parseInt(a.f462139n);     // Catch: Exception -> L22
    L23:
        String r104 = new String(Base64.decode(JSONObjectProtectorUtils.getString(r101, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY), 2));     // Catch: Exception -> L48
        String r105 = "";
        if (r101.has("sePayConf") == false) goto L27;
        String r106 = new String(Base64.decode(JSONObjectProtectorUtils.getString(r101, "sePayConf"), 2));     // Catch: Exception -> L48
    L29:
        if (TextUtils.isEmpty(r106) == true) goto L32;
        r105 = r106;
    L32:
        String r107 = com.unionpay.utils.b.d(UPUtils.b(r104 + r105 + a.f462136k));     // Catch: Exception -> L48
        String r108 = UPUtils.c(UPUtils.forConfig(r103, r102));     // Catch: Throwable -> L35
    L38:
        if (TextUtils.isEmpty(r108) == true) goto L51;
        if (r108.equals(r107) == false) goto L51;
        UPUtils.d(a.k(), (String) r110.obj, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY + a.f462132g);     // Catch: Exception -> L48
        UPUtils.d(a.k(), a.f462139n, "mode" + a.f462132g);     // Catch: Exception -> L48
        UPUtils.d(a.k(), a.f462136k, SRStrategy.KEY_ORIGIN_RESOLUTION + a.f462132g);     // Catch: Exception -> L48
        if (TextUtils.isEmpty(a.f462130e) == true) goto L45;
        UPUtils.d(a.k(), r105, "se_configs" + a.f462130e);     // Catch: Exception -> L48
    L45:
        if (a.f462141p == true) goto L51;
        a.f462148w = a.e(new JSONArray(r104));     // Catch: Exception -> L48
        a.i(r105);     // Catch: Exception -> L48
    L35:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L48
        r108 = null;
        goto L38
    L27:
        r106 = "";
    L22:
        r103 = 0;
        goto L23
    }
}
