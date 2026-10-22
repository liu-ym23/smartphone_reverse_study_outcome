package x74;

import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.p0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.Sword.Sword;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class c {
    public static void a(JSONObject r100, boolean r101) {
        boolean r102 = false;
        byte[] r103 = new byte[0];
        r103 = r100.toString().getBytes("UTF-8");     // Catch: Exception -> L5
    L20:
        String r104 = UriProtector.parse("https://log.snssdk.com/service/2/dtrait/").buildUpon().appendQueryParameter("req_id", y74.c.f566591a.b(new Object[0])).build().toString();     // Catch: Exception -> L15
        u74.a r105 = n74.a.f518202d;     // Catch: Exception -> L15
        if (r105 == null) goto L13;
        o0 r106 = ((p0.c) r105).f199764a;     // Catch: Exception -> L15
        if (r106.f199745r == false) goto L12;
        r102 = r106.A;     // Catch: Exception -> L15
        goto L13
    L12:
        r102 = true;
    L13:
        b.a(r104, new String(r103, "UTF-8"), r102, r101);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        m74.a.b("[dt] DTraitNetworkHelper# bindDTrait network error " + e.getMessage());
        return;
    L5:
        e = move-exception;
        m74.a.b("[dt] DTraitNetworkHelper# sword encrypt error, " + e.getMessage());
        goto L20
    }

    public static JSONObject b(JSONObject r100, boolean r101) {
        boolean r102 = false;
        byte[] r103 = new byte[0];
        r103 = r100.toString().getBytes("UTF-8");     // Catch: Exception -> L5
        byte[] r104 = Sword.clientPackedBase64(r103, r103.length).getBytes("UTF-8");     // Catch: Exception -> L5
    L20:
        String r105 = UriProtector.parse("https://log.snssdk.com/service/3/device_sdk/stats_collect/").buildUpon().appendQueryParameter("req_id", y74.c.f566591a.b(new Object[0])).build().toString();     // Catch: Exception -> L15
        u74.a r106 = n74.a.f518202d;     // Catch: Exception -> L15
        if (r106 == null) goto L13;
        o0 r107 = ((p0.c) r106).f199764a;     // Catch: Exception -> L15
        if (r107.f199745r == false) goto L12;
        r102 = r107.A;     // Catch: Exception -> L15
        goto L13
    L12:
        r102 = true;
    L13:
        JSONObject r108 = b.a(r105, new String(r104, "UTF-8"), r102, r101);     // Catch: Exception -> L15
    L17:
        if (r108 == null) goto L19;
        return r108;
    L19:
        return new JSONObject();
    L15:
        e = move-exception;
        m74.a.b("[dt] DTraitNetworkHelper# statsCollect network error " + e.getMessage());
        r108 = null;
    L5:
        e = move-exception;
        m74.a.b("[dt] DTraitNetworkHelper# sword encrypt error, " + e.getMessage());
        r104 = r103;
        goto L20
    }
}
