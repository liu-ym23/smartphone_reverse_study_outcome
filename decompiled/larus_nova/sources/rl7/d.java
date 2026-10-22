package rl7;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import ok7.i;
import org.json.JSONObject;
import rk7.m;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckycatGetEnvInfo", owner = "lichengjian")
public final class d extends ok7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538470a;

    public static final class a {
    }

    static {
    }

    public d() {
        this.f538470a = "luckycatGetEnvInfo";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f538470a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        JSONObject r102 = new JSONObject();
        Application r103 = m.f538347a;
        String r104 = "";
        if (m.f538352f == null) goto L5;
        String r105 = "";
    L6:
        if (r105 != null) goto L9;
        r105 = "unknown";
    L9:
        r102.put("ppe", r105);
        boolean r106 = false;
        if (m.f538352f == null) goto L12;
        Integer r107 = 0;
    L13:
        int r108 = GeckoGlobalConfig.ENVType.BOE.getVal();
        if (r107 != null) goto L17;
    L19:
        int r109 = GeckoGlobalConfig.ENVType.DEV.getVal();
        if (r107 != null) goto L23;
    L25:
        int r110 = GeckoGlobalConfig.ENVType.PROD.getVal();
        if (r107 != null) goto L29;
    L31:
        String r111 = "local_test";
    L32:
        r102.put("geckoChannel", r111);
        tk7.b r112 = m.f538352f;
        if (r112 == null) goto L37;
        tk7.c r113 = r112.f546553a;
        if (r113 == null) goto L37;
    L39:
        if (r113 == null) goto L51;
        String r114 = r113.f546557b;
        if (r114 == null) goto L51;
        if (r114.length() <= 0) goto L45;
        boolean r115 = true;
    L46:
        if (r115 == true) goto L49;
        r114 = null;
    L49:
        if (r114 == null) goto L51;
    L55:
        if (r114 != null) goto L58;
        r114 = "";
    L58:
        r102.put("aid", r114);
        if (r113 == null) goto L70;
        String r116 = r113.f546556a;
        if (r116 == null) goto L70;
        if (r116.length() <= 0) goto L65;
        r106 = true;
    L65:
        if (r106 == true) goto L68;
        r116 = null;
    L68:
        if (r116 == null) goto L70;
    L74:
        if (r116 != null) goto L77;
        r116 = "";
    L77:
        r102.put("channel", r116);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_DID, m.h());
        if (m.f538352f == null) goto L80;
        String r117 = "";
    L82:
        if (TextUtils.isEmpty(r117) == false) goto L84;
        ((dn7.d) sl7.b.a.f542478a.f542477b).getClass();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyDogDebugConfig", "getGeckoPpeEnv luckyCatDebugConfig null luckyDogDebugConfig null");
    L85:
        r102.put("geckoPpe", r104);
        if (m.o() == false) goto L88;
        r102.put("uid", m.j());
    L89:
        r102.put("actToken", qm7.c.a.f533904a.d());
        r102.put("currentTimeValue", hl7.b.b().a());
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckyGetEnvInfoMethod", r102.toString());
        i.b(r101, 1, r102, null, 4);
        return;
    L88:
        r102.put("uid", "un_login");
        goto L89
    L84:
        r104 = r117;
        goto L85
    L80:
        r117 = null;
    L70:
        zl7.d r118 = (zl7.d) hn7.d.b(zl7.d.class);
        if (r118 == null) goto L73;
        r116 = r118.getChannel();
        goto L74
    L73:
        r116 = null;
        goto L74
    L45:
        r115 = false;
    L51:
        zl7.d r119 = (zl7.d) hn7.d.b(zl7.d.class);
        if (r119 == null) goto L54;
        r114 = r119.getAid();
        goto L55
    L54:
        r114 = null;
    L37:
        r113 = null;
        goto L39
    L29:
        if (r107.intValue() != r110) goto L31;
        r111 = "online";
        goto L32
    L23:
        if (r107.intValue() != r109) goto L25;
    L17:
        if (r107.intValue() != r108) goto L19;
    L12:
        r107 = null;
        goto L13
    L5:
        r105 = null;
        goto L6
    }
}
