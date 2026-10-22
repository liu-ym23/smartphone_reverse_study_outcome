package r74;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import b84.q;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdinstall.c0;
import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.bytedance.bdinstall.f0;
import com.bytedance.bdinstall.p0;
import com.bytedance.bdinstall.t;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends s74.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile w74.b f536441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, JSONObject> f536442g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f536443h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ReentrantLock f536444i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ReentrantLock f536445j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile byte[] f536446k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile byte[] f536447l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, b> f536448m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final v74.d f536449n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CountDownLatch f536450o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f536451p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Handler f536452q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f536453r;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f536454a = null;

        static {
            int[] r100 = new int[DTraitRiskType.values().length];
            f536454a = r100;
            r100[DTraitRiskType.HIGH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f536454a[DTraitRiskType.LOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f536455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f536456b;

        public b(String r100, long r101) {
            this.f536455a = r100;
            this.f536456b = r101;
        }
    }

    @Override // s74.a
    public final String c() {
        return "[factorLoader] ";
    }

    @Override // s74.a
    public final List<String> b() {
        ((ArrayList) this.f536443h).add("d_i0");
        ((ArrayList) this.f536443h).add("d_a0");
        ((ArrayList) this.f536443h).add("d_r0");
        ((ArrayList) this.f536443h).add("d_b0");
        return this.f536443h;
    }

    public final void d() {
        if (((HashMap) this.f540927d.f528024e).isEmpty() == false) goto L11;
        m74.a.a("[dt] [factorLoader] parseCollectorByConfig# config map is empty, again fetch config from cache.");
        String r100 = this.f540926c.a(Constants.Keys.SP_D_DATA);
        if (TextUtils.isEmpty(r100) == true) goto L11;
        JSONObject r101 = new JSONObject();
        r101.putOpt("message", com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);     // Catch: Exception -> L9
        r101.putOpt("data", r100);     // Catch: Exception -> L9
        this.f540927d.c(r101);     // Catch: Exception -> L9
    L11:
        if (((HashMap) this.f540927d.f528024e).isEmpty() == false) goto L14;
        y74.a.c(DTraitLogLevel.ERROR, "[device]", "add_collect ", "again fetch config from cache error, return", null);
        return;
    L14:
        HashMap r102 = (HashMap) this.f540927d.f528024e;
        if (r102.isEmpty() == false) goto L18;
        m74.a.a("[dt] [factorLoader] parseCollectorByConfig# config map is empty");
        return;
    L18:
        a(r102);
    }

    public final void f() {
        y74.a.e("01_collect_dtrait_map ");
        if (((ArrayList) this.f540924a).size() > 0) goto L6;
        m74.a.a("[dt] [factorLoader] doCollect# loaderList is 0, return.");
        return;
    L6:
        m74.a.a("[dt] [factorLoader] doCollect# loaderList size: " + ((ArrayList) this.f540924a).size());
        int r100 = 0;
    L8:
        if (r100 >= ((ArrayList) this.f540924a).size()) goto L18;
        w74.f r101 = ((p74.a) ListProtector.get(this.f540924a, r100)).a();     // Catch: Exception -> L15
        if (r101 == null) goto L17;
        if (TextUtils.isEmpty(r101.f558526a) == true) goto L17;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L15
        r102.putOpt("value", r101.f558528c);     // Catch: Exception -> L15
        r102.putOpt("index", Integer.valueOf(r101.f558531f));     // Catch: Exception -> L15
        ((ConcurrentHashMap) this.f536442g).put(r101.f558526a, r102);     // Catch: Exception -> L15
    L17:
        r100 = r100 + 1;
    L15:
        e = move-exception;
        m74.a.b("[dt] [factorLoader] doCollect# error " + Log.getStackTraceString(e));
        goto L17
    L18:
        y74.a.f("01_collect_dtrait_map ");
        y74.a.c(DTraitLogLevel.DEBUG, "[device]", "01_collect_dtrait_map ", "collect# d map:" + ((ConcurrentHashMap) this.f536442g).keySet(), null);
    }

    public final void g(String r110) {
        this.f536444i.lock();
        y74.a.e("02_generateBasicDTrait ");     // Catch: Throwable -> L29
        w74.d.f558520b = r110;     // Catch: Throwable -> L29
        y74.a.e("02_01_wait_dtrait_version ");     // Catch: Throwable -> L29
        if (this.f536446k != null) goto L6;
    L12:
        String r100 = i(r110, "02_01_wait_dtrait_version ", "dtrait_version");     // Catch: Throwable -> L29
        if (TextUtils.equals(r100, String.valueOf(-1000)) == false) goto L15;
    L49:
        y74.a.c(DTraitLogLevel.ERROR, r110, "02_generateBasicDTrait ", "gbd# device_register response's dtrait_version is empty, default dtrait_version: ".concat(r100), null);     // Catch: Throwable -> L29
        j(false, "dtrait version from server is empty");     // Catch: Throwable -> L29
    L50:
        this.f536444i.unlock();
        return;
    L15:
        if (TextUtils.isEmpty(r100) == true) goto L49;
        if (this.f536446k == null) goto L23;
        if (this.f536446k.length <= 0) goto L23;
        m74.a.a("[dt] gbd# highBasicDTraitValue build fail, return ");     // Catch: Throwable -> L29
    L23:
        if (((ConcurrentHashMap) this.f536442g).isEmpty() == false) goto L36;
        u74.a r101 = n74.a.f518202d;     // Catch: Throwable -> L29
        if (r101 == null) goto L31;
        q r102 = ((p0.c) r101).f199765b.f199759c;     // Catch: Throwable -> L29
        if (r102.f18047k == false) goto L31;
        JSONObject r103 = r102.f18045i;     // Catch: Throwable -> L29
    L32:
        if (r103 != null) goto L34;
        r103 = new JSONObject();     // Catch: Throwable -> L29
    L34:
        k(r103);     // Catch: Throwable -> L29
        y74.a.c(DTraitLogLevel.DEBUG, r110, "02_generateBasicDTrait ", "gbd# basicDTraitMap is empty, again fetch collect().", null);     // Catch: Throwable -> L29
    L31:
        r103 = null;
    L36:
        if (((ConcurrentHashMap) this.f536442g).isEmpty() == false) goto L38;
        y74.a.c(DTraitLogLevel.ERROR, r110, "02_generateBasicDTrait ", "gbd# basicDTraitMap is empty, fetch collect() failure return.", null);     // Catch: Throwable -> L29
        j(false, "basicDTraitMap is empty");     // Catch: Throwable -> L29
        goto L50
    L38:
        this.f536446k = this.f536449n.c(this.f536442g, Integer.parseInt(r100), DTraitRiskType.HIGH.getValue());     // Catch: Throwable -> L29
        this.f536447l = this.f536449n.c(this.f536442g, Integer.parseInt(r100), DTraitRiskType.LOW.getValue());     // Catch: Throwable -> L29
        y74.a.c(DTraitLogLevel.DEBUG, r110, "02_generateBasicDTrait ", "write basic d success high size:" + this.f536446k.length + ", low size:" + this.f536447l.length + ", keyMaps: " + Arrays.toString(((ConcurrentHashMap) this.f536442g).keySet().toArray()), null);     // Catch: Throwable -> L29
        if (this.f536446k != null) goto L41;
    L47:
        boolean r104 = false;
    L48:
        j(r104, "");     // Catch: Throwable -> L29
        goto L50
    L41:
        if (this.f536446k.length <= 0) goto L47;
        if (this.f536447l == null) goto L47;
        if (this.f536447l.length <= 0) goto L47;
        r104 = true;
        goto L48
    L6:
        if (this.f536446k.length <= 0) goto L12;
        if (this.f536447l == null) goto L12;
        if (this.f536447l.length <= 0) goto L12;
    L29:
        th = move-exception;
        y74.a.c(DTraitLogLevel.ERROR, r110, "02_generateBasicDTrait ", "gbd error: " + th.getMessage(), th);     // Catch: Throwable -> L54
        j(false, th.getMessage());     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        this.f536444i.unlock();
        throw th;
    }

    public final void k(JSONObject r100) {
        this.f536445j.lock();
        d();     // Catch: Throwable -> L6
        f();     // Catch: Throwable -> L6
        e(r100, this.f536442g);     // Catch: Throwable -> L6
        this.f536445j.unlock();
        return;
    L6:
        th = move-exception;
        this.f536445j.unlock();
        throw th;
    }

    public static void j(boolean r100, String r101) {
        y74.a.f("02_generateBasicDTrait ");
        w74.d.f558519a = r100;
        w74.d.f558522d = r101;
        w74.d.f558521c = y74.a.b("02_generateBasicDTrait ");
        u74.a r102 = n74.a.f518202d;
        if (r102 == null) goto L15;
        JSONObject r103 = new JSONObject();
        r103.putOpt("result", Boolean.valueOf(w74.d.f558519a));     // Catch: Exception -> L12
        r103.putOpt("duration", Long.valueOf(w74.d.f558521c + y74.a.b("01_collect_dtrait_map ")));     // Catch: Exception -> L12
        r103.putOpt("path", w74.d.f558520b);     // Catch: Exception -> L12
        r103.putOpt("params_for_special", "uc_login");     // Catch: Exception -> L12
        r103.putOpt("error", w74.d.f558522d);     // Catch: Exception -> L12
    L7:
        c0 r104 = ((p0.c) r102).f199764a.E;
        if (r104 == null) goto L10;
        ((nw3.c) r104).a("dtrait_plaintext", r103);
    L10:
        w74.d.f558519a = false;
        w74.d.f558520b = "";
        w74.d.f558521c = SieveCacheKt.NodeMetaAndPreviousMask;
        w74.d.f558522d = "";
        return;
    }

    public final void e(JSONObject r100, Map<String, JSONObject> r101) {
        JSONObject r102 = new JSONObject();
        y74.d.a r103 = y74.d.f566592a;
        if (r100 != null) goto L44;
    L16:
        HashMap r104 = (HashMap) this.f540927d.f528024e;
        if (r104.containsKey("d_i1") == true) goto L19;
        return;
    L19:
        y74.a.e("03_appendCandidateFactorFromHeaders ");
        JSONArray r105 = r102.optJSONArray("ipv6_list");
        if (r105 != null) goto L22;
        return;
    L22:
        if (r105.length() <= 0) goto L52;
        int r106 = 0;
    L25:
        if (r106 >= r105.length()) goto L37;
        JSONObject r107 = JSONArrayProtectorUtils.getJSONObject(r105, r106);     // Catch: Exception -> L34
        if ("client_tun".equals(JSONObjectProtectorUtils.getString(r107, "type")) == false) goto L36;
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L34
        r108.putOpt("value", r107.optString("value"));     // Catch: Exception -> L34
        JSONObject r109 = (JSONObject) r104.get("d_i1");     // Catch: Exception -> L34
        if (r109 == null) goto L31;
        int r110 = JSONObjectProtectorUtils.getInt(r109, "index");     // Catch: Exception -> L34
    L32:
        r108.putOpt("index", Integer.valueOf(r110));     // Catch: Exception -> L34
        r101.put("d_i1", r108);     // Catch: Exception -> L34
        goto L36
    L31:
        r110 = -1;
    L36:
        r106 = r106 + 1;
    L34:
        e = move-exception;
        m74.a.b("[dt] appendCandidateFactorToMap# error: " + e.getMessage());
        goto L36
    L37:
        y74.a.f("03_appendCandidateFactorFromHeaders ");
        y74.a.c(DTraitLogLevel.DEBUG, "[device]", "03_appendCandidateFactorFromHeaders ", "appendCandidateFactorFromHeaders# append ipv6 to basic d map success!", null);
        return;
    L52:
        return;
    L44:
        monitor-enter(y74.d.class);     // Catch: Throwable -> L39
        Iterator<String> r111 = r100.keys();     // Catch: Throwable -> L13
    L9:
        if (r111.hasNext() == false) goto L11;
        String r112 = r111.next();     // Catch: Throwable -> L13
        r102.put(r112, r100.opt(r112));     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(y74.d.class);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
        goto L16
    }

    public final String h(String r210, DTraitRiskType r211, int r212) {
        this.f536444i.lock();
        w74.a.f558501c = r210;     // Catch: Throwable -> L69
        w74.a.f558504f = r212;     // Catch: Throwable -> L69
        y74.a.e("04_generateBase64EncryptBasicDTrait ");     // Catch: Throwable -> L69
        if (r211 != DTraitRiskType.HIGH) goto L6;
        int r100 = 0;
    L7:
        w74.a.f558502d = r100;     // Catch: Throwable -> L69
        if (this.f536441f == null) goto L13;
        String r101 = this.f536441f.f558508c;     // Catch: Throwable -> L69
        if (TextUtils.isEmpty(r101) == true) goto L13;
        w74.a.f558505g = r101.substring(0, (int) (((double) r101.length()) * 0.25d));     // Catch: Throwable -> L69
    L13:
        if (this.f536446k == null) goto L64;
        if (this.f536447l == null) goto L64;
        int r102 = a.f536454a[r211.ordinal()];     // Catch: Throwable -> L69
        if (r102 == 1) goto L22;
        if (r102 == 2) goto L21;
        String r110 = "";
        byte[] r103 = null;
    L23:
        Pair r111 = new Pair(r110, r103);     // Catch: Throwable -> L69
        byte[] r104 = (byte[]) r111.second;     // Catch: Throwable -> L69
        String r112 = (String) r111.first;     // Catch: Throwable -> L69
        b r113 = (b) ((ConcurrentHashMap) this.f536448m).get(r112);     // Catch: Throwable -> L69
        if (r113 != null) goto L26;
    L35:
        String r105 = i(r210, "04_01_wait_public_key ", r112);     // Catch: Throwable -> L69
        if (this.f536441f != null) goto L38;
    L58:
        DTraitLogLevel r106 = DTraitLogLevel.ERROR;     // Catch: Throwable -> L69
        Object[] r107 = new Object[3];     // Catch: Throwable -> L69
        if (this.f536441f != null) goto L61;
        boolean r114 = true;
    L62:
        r107[0] = Boolean.valueOf(r114);     // Catch: Throwable -> L69
        r107[1] = Boolean.valueOf(TextUtils.isEmpty(r105));     // Catch: Throwable -> L69
        r107[2] = r211;     // Catch: Throwable -> L69
        y74.a.c(r106, r210, "04_generateBase64EncryptBasicDTrait ", String.format("ed# dt is null? %s or pk is empty? %s type: %s, return method", r107), null);     // Catch: Throwable -> L69
    L74:
        y74.a.f("04_generateBase64EncryptBasicDTrait ");
        w74.a.f558500b = !((ConcurrentHashMap) this.f536448m).isEmpty();
        w74.a.f558503e = y74.a.b("04_generateBase64EncryptBasicDTrait ");
        w74.a.a();
        y74.a.d(this.f540925b);
        System.currentTimeMillis();
        this.f536444i.unlock();
        return "";
    L61:
        r114 = false;
        goto L62
    L38:
        if (TextUtils.isEmpty(r105) == true) goto L58;
        if (r104 == null) goto L43;
        byte[] r115 = "_".getBytes();     // Catch: Throwable -> L69
        long r116 = (long) (System.currentTimeMillis() * 0.001d);     // Catch: Throwable -> L69
        ByteBuffer r108 = ByteBuffer.wrap(new byte[(r104.length + r115.length) + 8]);     // Catch: Throwable -> L69
        r108.order(ByteOrder.BIG_ENDIAN);     // Catch: Throwable -> L69
        r108.put(r104);     // Catch: Throwable -> L69
        r108.put(r115);     // Catch: Throwable -> L69
        r108.putLong(r116);     // Catch: Throwable -> L69
        byte[] r117 = r108.array();     // Catch: Throwable -> L69
    L45:
        StringBuilder r109 = new StringBuilder();     // Catch: Throwable -> L69
        w74.b r118 = this.f536441f;     // Catch: Throwable -> L69
        r118.getClass();     // Catch: Throwable -> L69
        int r119 = w74.b.a.f558514a[r211.ordinal()];     // Catch: Throwable -> L69
        if (r119 != 1) goto L48;
        String r120 = r118.f558510e;     // Catch: Throwable -> L69
    L52:
        r109.append(r120);     // Catch: Throwable -> L69
        r109.append("_");     // Catch: Throwable -> L69
        r109.append(y74.d.c(r117, r105));     // Catch: Throwable -> L69
        String r121 = r109.toString();     // Catch: Throwable -> L69
        ((ConcurrentHashMap) this.f536448m).put(r112, new b(r121, System.currentTimeMillis() + this.f540927d.f528022c));     // Catch: Throwable -> L69
        if (this.f536451p.get() == true) goto L55;
        this.f536450o.countDown();     // Catch: Throwable -> L69
        this.f536451p.set(true);     // Catch: Throwable -> L69
    L55:
        y74.a.c(DTraitLogLevel.DEBUG, r210, "04_generateBase64EncryptBasicDTrait ", String.format("ed# encrypt key:%s, type: %s, result=%s, pk: %s", new Object[]{r112, r211, r121, r105}), null);     // Catch: Throwable -> L69
        y74.a.f("04_generateBase64EncryptBasicDTrait ");
        w74.a.f558500b = !((ConcurrentHashMap) this.f536448m).isEmpty();
        w74.a.f558503e = y74.a.b("04_generateBase64EncryptBasicDTrait ");
        w74.a.a();
        y74.a.d(this.f540925b);
        System.currentTimeMillis();
        this.f536444i.unlock();
        return r121;
    L48:
        if (r119 == 2) goto L50;
        r120 = "";
        goto L52
    L50:
        r120 = r118.f558511f;     // Catch: Throwable -> L69
        goto L52
    L43:
        r117 = new byte[0];     // Catch: Throwable -> L69
        goto L45
    L26:
        if (TextUtils.isEmpty(r113.f536455a) == true) goto L35;
        if (System.currentTimeMillis() <= r113.f536456b) goto L30;
        boolean r122 = true;
    L31:
        if (r122 == true) goto L35;
        w74.a.f558499a = true;     // Catch: Throwable -> L69
        m74.a.a("[dt] ed# return memory " + r211 + " type cache!");     // Catch: Throwable -> L69
        String r123 = r113.f536455a;     // Catch: Throwable -> L69
        y74.a.f("04_generateBase64EncryptBasicDTrait ");
        w74.a.f558500b = !((ConcurrentHashMap) this.f536448m).isEmpty();
        w74.a.f558503e = y74.a.b("04_generateBase64EncryptBasicDTrait ");
        w74.a.a();
        y74.a.d(this.f540925b);
        System.currentTimeMillis();
        this.f536444i.unlock();
        return r123;
    L30:
        r122 = false;
        goto L31
    L21:
        r103 = this.f536447l;     // Catch: Throwable -> L69
        r110 = "dtrait_pk2";
        goto L23
    L22:
        r103 = this.f536446k;     // Catch: Throwable -> L69
        r110 = "dtrait_pk1";
    L64:
        if (m74.a.f512332a == null) goto L74;
        f0 r124 = t.f199791b;     // Catch: Throwable -> L69
        if (r124 == null) goto L74;
        r124.w("bdinstall# [dt] [dt] ed# highBasicDTraitValue or lowBasicDTraitValue is null", null);     // Catch: Throwable -> L69
        goto L74
    L6:
        r100 = 1;
    L69:
        th = move-exception;
        y74.a.c(DTraitLogLevel.ERROR, r210, "04_generateBase64EncryptBasicDTrait ", "ed# encrypt msg= " + th.getMessage(), null);     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        y74.a.f("04_generateBase64EncryptBasicDTrait ");
        w74.a.f558500b = !((ConcurrentHashMap) this.f536448m).isEmpty();
        w74.a.f558503e = y74.a.b("04_generateBase64EncryptBasicDTrait ");
        w74.a.a();
        y74.a.d(this.f540925b);
        System.currentTimeMillis();
        this.f536444i.unlock();
        throw th;
    }

    public final String i(String r100, String r110, String r111) {
        String r101 = this.f540926c.a(r111);
        if (TextUtils.isEmpty(r101) == false) goto L22;
        y74.a.e(r110);
        v74.a r102 = this.f540926c;
        TimeUnit r103 = TimeUnit.SECONDS;
        r102.f553472b.lock();
    L23:
    L19:
        th = move-exception;
        r102.f553472b.unlock();
        throw th;
    L7:
        if (r102.f553471a == true) goto L14;
        if (r102.f553473c.await(30, r103) == true) goto L23;
    L13:
        r102.f553472b.unlock();
        boolean r104 = false;
    L16:
        if (r104 == false) goto L18;
        r101 = this.f540926c.a(r111);
    L18:
        y74.a.f(r110);
        y74.a.c(DTraitLogLevel.DEBUG, r100, r110, String.format("%s# wait value..., excepted time:%ss", new Object[]{r110, 30}), null);
        goto L22
    L11:
        e = move-exception;
        m74.a.b("[dt] awaitUpdate# await error " + e.getMessage());     // Catch: Throwable -> L19
        goto L13
    L14:
        r102.f553471a = false;     // Catch: Throwable -> L19
        m74.a.a("[dt] awaitUpdate# await done.");     // Catch: Throwable -> L19
        r102.f553472b.unlock();
        r104 = true;
    L22:
        return r101;
    }

    public g(Context r100, p74.b r110, v74.a r111, v74.d r112, boolean r113) {
        super(r100, r110, r111, r113);
        this.f536444i = new ReentrantLock();
        this.f536445j = new ReentrantLock();
        this.f536450o = new CountDownLatch(1);
        this.f536451p = new AtomicBoolean(false);
        this.f536453r = 0;
        String r101 = r111.b("dtrait_pk1");
        if (TextUtils.isEmpty(r101) == true) goto L5;
        this.f536441f = new w74.b(r101, r111.b("dtrait_pk2"), r111.b("dtrait_pk1_version"), r111.b("dtrait_pk2_version"), r111.b("dtrait_token"), r111.b("dtrait_version"), false);
        y74.a.c(DTraitLogLevel.DEBUG, "[device]", "load_dtrait_info", "loadInfo success: " + this.f536441f.toString(), null);
    L5:
        this.f536442g = new ConcurrentHashMap();
        this.f536448m = new ConcurrentHashMap();
        this.f536443h = new ArrayList();
        this.f536452q = o74.a.f522264g.b(new Object[0]);
        this.f536449n = r112;
    }
}
