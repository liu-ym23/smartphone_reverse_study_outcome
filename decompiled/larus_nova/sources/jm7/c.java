package jm7;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import ok7.i;
import org.json.JSONException;
import org.json.JSONObject;
import wm7.g;
import ym7.l;
import ym7.n;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckydogTimerPendantOperation")
public final class c extends ok7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f499671a;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f499671a = "luckydogTimerPendantOperation";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f499671a;
    }

    public static void f(String r100, JSONObject r101) {
        if (r101 == null) goto L6;
        n r102 = new n(null, r101, 4);
        l r103 = (l) g.a(l.class);
        if (r103 == null) goto L10;
        r103.d(r100, r102);
        return;
    L10:
        return;
    L6:
        l r104 = (l) g.a(l.class);
        if (r104 == null) goto L12;
        r104.enterScene(r100);
        return;
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("luckydogTimerPendantOperation", "LuckyDogTimerPendantOperation on call");
        JSONObject r102 = new JSONObject();
        String r103 = s.f(r100, ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE, "");
        boolean r104 = false;
        if (r103.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L9;
        g(r102, r101, "operation_type is empty");
        return;
    L9:
        String r106 = s.f(r100, "scene", "");
        if (r106.length() != 0) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L17;
        g(r102, r101, "scene is empty");
        return;
    L17:
        switch(r103.hashCode()) {
            case -2121757281: goto L41;
            case -1573145462: goto L36;
            case 759013466: goto L25;
            case 1630123242: goto L20;
            default: goto L47;
        };
    L47:
        g(r102, r101, "operation_type is invalid");
        return;
    L20:
        if (r103.equals(ILoadStallMonitor.STOP_TIME) == false) goto L47;
        zm7.d r108 = (zm7.d) g.a(zm7.d.class);
        if (r108 == null) goto L45;
        r108.c(r106);
    L45:
        r102.put("error_code", 1);
        r102.put("error_msg", "success");
        r101.a(1, r102, "success");
        return;
    L25:
        if (r103.equals("show_pendant") == false) goto L47;
        String r109 = s.f(r100, "extra", "");
        if (r109.length() != 0) goto L29;
        r104 = true;
    L29:
        if (r104 == false) goto L49;
        f(r106, null);
        goto L45
    L49:
        f(r106, new JSONObject(r109));     // Catch: JSONException -> L33
    L33:
        g(r102, r101, "extra = " + r109 + ", is invalid");
        return;
    L36:
        if (r103.equals(ILoadStallMonitor.START_TIME) == false) goto L47;
        zm7.d r110 = (zm7.d) g.a(zm7.d.class);
        if (r110 == null) goto L45;
        r110.a(r106);
        goto L45
    L41:
        if (r103.equals("hide_pendant") == false) goto L47;
        l r111 = (l) g.a(l.class);
        if (r111 == null) goto L45;
        r111.b(r106);
        goto L45
    L12:
        r107 = false;
        goto L13
    L5:
        r105 = false;
        goto L6
    }

    public static void g(JSONObject r100, i r101, String r102) {
        r100.put("error_code", -1);
        r100.put("error_msg", r102);
        r101.a(0, r100, "failed");
    }
}
