package w74;

import androidx.collection.SieveCacheKt;
import com.bytedance.bdinstall.c0;
import com.bytedance.bdinstall.p0;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f558499a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f558500b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f558501c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile int f558502d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile long f558503e = -2147483648L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f558504f = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile String f558505g = "";

    public static void a() {
        List<String> r100 = n74.a.f518200b;
        int r101 = n74.a.f518201c;
        if (r100 != null) goto L5;
    L37:
        u74.a r102 = n74.a.f518202d;
        if (r102 != null) goto L40;
        return;
    L40:
        JSONObject r103 = b();
        c0 r104 = ((p0.c) r102).f199764a.E;
        if (r104 == null) goto L43;
        ((nw3.c) r104).a("dtrait_ciphertext", r103);
    L43:
        f558500b = false;
        f558501c = "";
        f558502d = -1;
        f558505g = "";
        f558499a = false;
        f558504f = Integer.MIN_VALUE;
        f558503e = SieveCacheKt.NodeMetaAndPreviousMask;
        return;
    L5:
        if (r100.isEmpty() == true) goto L37;
        Iterator<String> r105 = r100.iterator();
    L8:
        boolean r110 = true;
        if (r105.hasNext() == false) goto L15;
        String r111 = r105.next();
        if (f558501c.contains(r111) == false) goto L8;
        if (y74.a.f566590e.nextInt(100) >= r101) goto L15;
        boolean r106 = true;
    L16:
        Iterator<String> r107 = r100.iterator();
    L18:
        if (r107.hasNext() == false) goto L22;
        String r108 = r107.next();
        if (f558501c.contains(r108) == false) goto L18;
        boolean r109 = true;
    L23:
        if (r106 == true) goto L26;
        if (r109 == true) goto L26;
    L27:
        if (r110 == true) goto L29;
        return;
    L29:
        u74.a r112 = n74.a.f518202d;
        if (r112 != null) goto L32;
        return;
    L32:
        JSONObject r113 = b();
        c0 r114 = ((p0.c) r112).f199764a.E;
        if (r114 == null) goto L35;
        ((nw3.c) r114).a("dtrait_ciphertext", r113);
    L35:
        f558500b = false;
        f558501c = "";
        f558502d = -1;
        f558505g = "";
        f558499a = false;
        f558504f = Integer.MIN_VALUE;
        f558503e = SieveCacheKt.NodeMetaAndPreviousMask;
        return;
    L26:
        r110 = r106;
        goto L27
    L22:
        r109 = false;
    L15:
        r106 = false;
        goto L16
    }

    public static JSONObject b() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("result", Boolean.valueOf(f558500b));     // Catch: Exception -> L5
        r100.putOpt("duration", Long.valueOf(f558503e));     // Catch: Exception -> L5
        r100.putOpt("riskType", Integer.valueOf(f558502d));     // Catch: Exception -> L5
        r100.putOpt("path", f558501c);     // Catch: Exception -> L5
        r100.putOpt("expectedTime", Integer.valueOf(f558504f));     // Catch: Exception -> L5
        r100.putOpt("useCache", Boolean.valueOf(f558499a));     // Catch: Exception -> L5
        r100.putOpt(BytedCertConstant.LivenessInfoConfigKey.DETECT_TYPE, f558505g);     // Catch: Exception -> L5
        r100.putOpt("params_for_special", "uc_login");     // Catch: Exception -> L5
    L4:
        return r100;
    }
}
