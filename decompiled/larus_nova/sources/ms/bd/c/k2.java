package ms.bd.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class k2 implements m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f515181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f515182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c2 f515183c;

    @Override // ms.bd.c.m2
    public final String getToken() {
        long r100 = this.f515181a;
        if (r100 != (-1)) goto L5;
        return "";
    L5:
        return (String) p2.a(33554439, 0, r100, null, null);
    }

    public static String a(Map r100) {
        if (r100 != null) goto L4;
    L14:
        return "";
    L4:
        if (r100.isEmpty() == true) goto L14;
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L23;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (TextUtils.isEmpty((CharSequence) r103.getKey()) == true) goto L7;
        if (TextUtils.isEmpty((CharSequence) r103.getValue()) == true) goto L7;
        r101.put(r103.getKey());
        r101.put(r103.getValue());
        goto L7
    L23:
        return r101.toString();
    }

    @Override // ms.bd.c.m2
    public final void postEventMessage(MSManagerUtils.MSBusinessHelper r110) {
        if (this.f515181a == (-1)) goto L6;
        p2.a(33554443, 0, 0, null, r110);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setBDDeviceID(String r100) {
        this.f515183c.mBDDeviceID = r100;
        long r101 = this.f515181a;
        if (r101 == (-1)) goto L6;
        p2.a(33554437, 0, r101, r100, this.f515182b);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setCollectMode(int r100) {
        long r101 = this.f515181a;
        if (r101 == (-1)) goto L6;
        p2.a(33554441, r100, r101, null, null);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setDeviceID(String r100) {
        this.f515183c.mDeviceID = r100;
        long r101 = this.f515181a;
        if (r101 == (-1)) goto L6;
        p2.a(33554434, 0, r101, r100, this.f515182b);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setInstallID(String r100) {
        this.f515183c.mInstallID = r100;
        long r101 = this.f515181a;
        if (r101 == (-1)) goto L6;
        p2.a(33554435, 0, r101, r100, this.f515182b);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setMsSettingConfig(String r100) {
        if (this.f515181a == (-1)) goto L14;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return;
    L7:
        if (r100.contains("content") == false) goto L9;
        r100 = JSONObjectProtectorUtils.getString(new JSONObject(r100), "content");     // Catch: Exception -> L11
    L9:
        long r101 = this.f515181a;     // Catch: Exception -> L11
        p2.a(33554447, 0, r101, r100, this.f515182b);     // Catch: Exception -> L11
        return;
    L16:
        return;
    }

    @Override // ms.bd.c.m2
    public final void setSessionID(String r100) {
        this.f515183c.mSessionID = r100;
        long r101 = this.f515181a;
        if (r101 == (-1)) goto L6;
        p2.a(33554436, 0, r101, r100, this.f515182b);
        return;
    }

    @Override // ms.bd.c.m2
    public final Map frameSign(String r100, int r101) {
        if (this.f515181a == (-1)) goto L22;
        HashMap r102 = new HashMap();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        String[] r103 = (String[]) p2.a(33554442, r101, this.f515181a, r100, null);
        if ((r103 instanceof String[]) == true) goto L11;
    L20:
        return r102;
    L11:
        if ((r103.length % 2) != 0) goto L20;
        int r104 = 0;
    L14:
        if (r104 >= r103.length) goto L20;
        String r105 = r103[r104];
        String r106 = r103[r104 + 1];
        if (r105 == null) goto L19;
        if (r106 == null) goto L19;
        r102.put(r105, r106);
    L19:
        r104 = r104 + 2;
        goto L14
    L7:
        return Collections.emptyMap();
    L22:
        return Collections.emptyMap();
    }

    @Override // ms.bd.c.m2
    public final Map getFeatureHash(String r100, byte[] r110) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
    L19:
        return r101;
    L5:
        if (r100.length() == 0) goto L19;
        String[] r102 = (String[]) p2.a(33554438, 0, this.f515181a, r100, r110);
        if (r102 == null) goto L19;
        if ((r102.length % 2) != 0) goto L19;
        int r111 = 0;
    L13:
        if (r111 >= r102.length) goto L19;
        String r103 = r102[r111];
        String r104 = r102[r111 + 1];
        if (r103 == null) goto L18;
        if (r104 == null) goto L18;
        r101.put(r103, r104);
    L18:
        r111 = r111 + 2;
        goto L13
    }

    @Override // ms.bd.c.m2
    public final void qurryMsRiskInfo(String r100, MSManagerUtils.IMsBundleCallback r110) {
        t2 r101 = t2.f515368b;
        if (r101.f515369a.size() >= 20) goto L6;
        if (r110 == null) goto L6;
        HashMap r102 = new HashMap();
        r102.put(r100, r110);
        r101.f515369a.add(r102);
    L6:
        long r103 = this.f515181a;
        if (r103 == (-1)) goto L10;
        p2.a(33554450, 0, r103, r100, null);
        return;
    }

    @Override // ms.bd.c.m2
    public final void report(String r100, String r101) {
        if (this.f515181a != (-1)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        p2.a(InputDeviceCompat.SOURCE_HDMI, 0, this.f515181a, r100, r101);
        return;
    }

    @Override // ms.bd.c.m2
    public final void setCustomInfo(Map r110, boolean r111) {
        if (this.f515181a == (-1)) goto L6;
        String r100 = a(r110);
        long r101 = this.f515181a;
        p2.a(33554448, r111 ? 1 : 0, r101, r100, null);
        return;
    }

    public k2(c2 r100, Context r101, long r102) {
        if (r101 == null) goto L7;
        this.f515183c = r100;
        this.f515182b = r101.getApplicationContext();
        this.f515181a = r102;
        return;
    L7:
        throw new NullPointerException("context could not be null");
    }

    @Override // ms.bd.c.m2
    public final Map getReportRaw(String r110, int r111, Map r112) {
        if (this.f515181a == (-1)) goto L15;
        String r113 = a(r112);
        Object r114 = p2.a(33554440, r111, this.f515181a, r110, r113);
        if ((r114 instanceof Object[]) == false) goto L15;
        Object[] r115 = (Object[]) r114;
        if (r115.length < 2) goto L15;
        if (r115[0] == null) goto L15;
        if (r115[1] == null) goto L15;
        HashMap r100 = new HashMap();
        r100.put(r115[0].toString(), r115[1].toString());
        return r100;
    L15:
        return Collections.emptyMap();
    }
}
