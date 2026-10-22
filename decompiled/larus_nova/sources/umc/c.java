package umc;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<HashMap<String, String>> f550750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f550751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f550752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f550753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f550754e;

    public String getSeiReportStr() {
        if (this.f550750a.isEmpty() == false) goto L25;
        return "none";
    L25:
        JSONArray r100 = new JSONArray();     // Catch: Exception -> L19
        int r101 = 0;
    L7:
        if (r101 >= this.f550750a.size()) goto L17;
        HashMap r102 = (HashMap) ListProtector.get(this.f550750a, r101);     // Catch: Exception -> L19
        if (r102.size() <= 0) goto L16;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L19
        Iterator r104 = r102.keySet().iterator();     // Catch: Exception -> L19
    L13:
        if (r104.hasNext() == false) goto L15;
        String r105 = (String) r104.next();     // Catch: Exception -> L19
        r103.put(r105, r102.get(r105));     // Catch: Exception -> L19
        goto L13
    L15:
        r100.put(r103);     // Catch: Exception -> L19
    L16:
        r101 = r101 + 1;     // Catch: Exception -> L19
        goto L7
    L17:
        String r106 = r100.toString();     // Catch: Exception -> L19
    L20:
        this.f550750a.clear();
        if (TextUtils.isEmpty(r106) == false) goto L24;
        return "none";
    L24:
        return r106;
    L19:
        com.ss.videoarch.liveplayer.log.c.e("getSeiReportStr", "parseSEI err");
        r106 = "none";
        goto L20
    }

    public c() {
        this.f550750a = new ArrayList();
    }

    private HashMap<String, String> addClientAlg(HashMap<String, String> r100) {
        if (r100.containsKey(String.valueOf(6)) == true) goto L8;
        if (this.f550753d != 1) goto L8;
        r100.put(String.valueOf(6), "1");
    L8:
        if (r100.containsKey(String.valueOf(5)) == true) goto L13;
        if (this.f550752c != 1) goto L13;
        r100.put(String.valueOf(5), "1");
    L13:
        if (r100.containsKey(String.valueOf(10)) == true) goto L18;
        if (this.f550751b != 1) goto L18;
        r100.put(String.valueOf(10), "1");
    L18:
        if (r100.containsKey(String.valueOf(11)) == false) goto L20;
    L22:
        return r100;
    L20:
        if (this.f550754e != 1) goto L22;
        r100.put(String.valueOf(11), "1");
        goto L22
    }

    private void dealSEI(Object r100) {
    L10:
        com.ss.videoarch.liveplayer.log.c.e("SEIReportMgr", "parseSEI err");
        return;
    L3:
        if (this.f550750a.size() < 10) goto L6;
        return;
    L6:
        if ((r100 instanceof ByteBuffer) == true) goto L8;
        return;
    L8:
        parseSEI((ByteBuffer) r100);     // Catch: Exception -> L10
    }

    private void parseSEI(ByteBuffer r110) {
        int r100 = r110.position();
        int r101 = r110.limit();
        int r102 = r110.remaining();
        byte[] r103 = new byte[r102];
        r110.get(r103);
        r110.position(r100);
        r110.limit(r101);
        byte[] r111 = new byte[r102];
        parseAntiCollisionCode(r103, r111);
        int r104 = 10;
        if (r102 >= 10) goto L6;
        return;
    L6:
        if (getIntFromByte(r111, 9) != 0) goto L12;
        ArrayList<HashMap<String, String>> r105 = this.f550750a;
        if (r105 == null) goto L12;
        if (r105.size() <= 0) goto L12;
        return;
    L12:
        HashMap<String, String> r106 = new HashMap();
        r106.put("timestamp", String.valueOf(System.currentTimeMillis()));
        int r107 = getIntFromByte(r111, 6);
        int r108 = (getIntFromByte(r111, 7) << 8) + r107;
        if (r108 <= 65280) goto L15;
        r108 = 65280;
    L15:
        int r109 = 0;
    L16:
        if (r109 >= r108) goto L24;
        int r112 = r104 + 5;
        if (r112 >= r102) goto L24;
        int r113 = getIntFromByte(r111, r104);
        int r114 = (getIntFromByte(r111, r104 + 1) << 8) + r113;
        if (r114 <= 0) goto L24;
        int r115 = getIntFromByte(r111, r104 + 2);
        int r116 = (getIntFromByte(r111, r104 + 3) << 8) + r115;
        int r117 = getIntFromByte(r111, r104 + 4);
        int r118 = (getIntFromByte(r111, r112) << 8) + r117;
        r106.put(String.valueOf(r116), generateAlgSwitch(r118, r116));
        r104 = (r104 + r114) + 6;
        r109 = r109 + 1;
    L24:
        this.f550750a.add(addClientAlg(r106));
    }

    private String generateAlgSwitch(int r100, int r101) {
        if (r101 != 6) goto L9;
        if (this.f550753d != 1) goto L9;
        return String.valueOf(r100 + 1);
    L9:
        if (r101 != 5) goto L15;
        if (this.f550752c != 1) goto L15;
        return String.valueOf(r100 + 1);
    L15:
        if (r101 != 10) goto L21;
        if (this.f550751b != 1) goto L21;
        return String.valueOf(r100 + 1);
    L21:
        if (r101 != 11) goto L27;
        if (this.f550754e != 1) goto L27;
        return String.valueOf(r100 + 1);
    L27:
        return String.valueOf(r100);
    }

    private int getIntFromByte(byte[] r100, int r101) {
        if (r100.length <= r101) goto L7;
        byte r102 = r100[r101];
        if (r102 < 0) goto L10;
        return r102;
    L10:
        return r102 + 256;
    L7:
        return 0;
    }

    private int parseAntiCollisionCode(byte[] r110, byte[] r111) {
        int r100 = r110.length;
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L21;
        int r103 = r101 + 3;
        if (r103 < r100) goto L7;
    L19:
        r111[r102] = r110[r101];
        r102 = r102 + 1;
    L20:
        r101 = r101 + 1;
        goto L3
    L7:
        if (r110[r101] != 0) goto L19;
        if (r110[r101 + 1] != 0) goto L19;
        if (r110[r101 + 2] != 3) goto L19;
        byte r104 = r110[r103];
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L18;
        if (r104 == 2) goto L18;
        if (r104 != 3) goto L19;
    L18:
        int r105 = r102 + 1;
        r111[r102] = 0;
        int r106 = r105 + 1;
        r111[r105] = 0;
        r111[r106] = r110[r103];
        r102 = r106 + 1;
        r101 = r103;
        goto L20
    L21:
        return r102;
    }

    @Override // umc.b
    public void onEvent(int r100, int r101, String r102, Object r103) {
        if (r100 != 111) goto L7;
        this.f550751b = r101;
        return;
    L7:
        if (r100 != 110) goto L11;
        this.f550754e = r101;
        return;
    L11:
        if (r100 != 108) goto L15;
        this.f550752c = r101;
        return;
    L15:
        if (r100 != 107) goto L19;
        this.f550753d = r101;
        return;
    L19:
        if (r100 != 109) goto L22;
        return;
    L22:
        if (r100 != 105) goto L27;
        if (r103 == null) goto L28;
        dealSEI(r103);
        return;
    L28:
        return;
    }
}
