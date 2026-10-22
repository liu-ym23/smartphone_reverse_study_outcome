package jx3;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class e extends a {
    public boolean A;
    public String B;
    public String C;
    public final boolean D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f500799y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public JSONObject f500800z;

    @Override // jx3.a
    public String j() {
        return "eventv3";
    }

    @Override // jx3.a
    public final JSONObject r() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("local_time_ms", this.f500758b);
        r100.put("tea_event_index", this.f500759c);
        r100.put("session_id", this.f500760d);
        c(r100);
        if (TextUtils.isEmpty(this.f500763g) == true) goto L5;
        r100.put(DyPayConstant.KEY_USER_UNIQUE_ID, this.f500763g);
    L5:
        r100.put("event", this.B);
        if (this.A == false) goto L9;
        r100.put("is_bav", 1);
    L9:
        if (TextUtils.isEmpty(this.f500799y) == true) goto L11;
        r100.put("params", fx3.b.b(this, new JSONObject(this.f500799y)));
    L15:
        if (this.f500765i == NetworkUtils.NetworkType.UNKNOWN.getValue()) goto L17;
        r100.put("nt", this.f500765i);
    L17:
        r100.put(SheetInputData.InputData.DateType.DATETIME, this.f500770n);
        if (TextUtils.isEmpty(this.f500764h) == true) goto L21;
        r100.put("ab_sdk_version", this.f500764h);
    L21:
        if (TextUtils.isEmpty(this.C) == true) goto L23;
        r100.put("disable_personalization", CastIntegerProtector.valueOf(this.C));
    L23:
        long r101 = this.f500773q;
        if (r101 <= 0) goto L26;
        r100.put("event_id", r101);
    L26:
        long r102 = this.f500774r;
        if (r102 <= 0) goto L29;
        r100.put("monitor_id", String.valueOf(r102));
    L29:
        int r103 = this.f500775s;
        if (r103 <= 0) goto L32;
        r100.put("event_stained", r103);
    L32:
        ow3.d.a r104 = this.f500777u;
        if (r104 == null) goto L35;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        r100.putOpt("__pid", r104.f527054a);
        r100.putOpt("__pname", r104.f527055b);
        r100.putOpt("__sdk_pid", r104.f527056c);
    L35:
        return r100;
    L11:
        JSONObject r105 = this.f500800z;
        if (r105 == null) goto L15;
        r100.put("params", fx3.b.b(this, r105));
        goto L15
    }

    public final void s() {
        JSONObject r100 = this.f500800z;
        if (r100 == null) goto L6;
        t(r100.toString());
        return;
    }

    @Override // jx3.a
    public final a a() {
        e r100 = (e) super.a();
        r100.s();
        return r100;
    }

    @Override // jx3.a
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    @Override // jx3.a
    public final List<String> e() {
        List<String> r100 = super.e();
        ArrayList r101 = new ArrayList(r100.size());
        r101.addAll(r100);
        r101.addAll(Arrays.asList(new String[]{"event", "varchar", "params", "varchar", "is_bav", "integer", "disable_personalization", "varchar", "page_info", "varchar"}));
        return r101;
    }

    @Override // jx3.a
    public final long n() {
        return super.n();
    }

    @Override // jx3.a
    public final String f() {
        return this.f500799y;
    }

    @Override // jx3.a
    public final String g() {
        return this.B;
    }

    @Override // jx3.a
    public final String h() {
        return this.B;
    }

    @Override // jx3.a
    public final void k(Cursor r100) {
        super.k(r100);
        this.B = r100.getString(18);
        t(r100.getString(19));
        boolean r101 = true;
        if (r100.getInt(20) == 1) goto L6;
        r101 = false;
    L6:
        this.A = r101;
        this.C = r100.getString(21);
        String r102 = r100.getString(22);
        if (TextUtils.isEmpty(r102) == true) goto L24;
        int r103 = ow3.d.a.f527053d;
        Intrinsics.checkNotNullParameter(r102, "json");
        JSONObject r104 = new JSONObject(r102);     // Catch: Throwable -> L22
        String r105 = r104.optString("pid");     // Catch: Throwable -> L19
        String r106 = r104.optString("pName");     // Catch: Throwable -> L19
        String r107 = r104.optString("sdkPageId");     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r105) == true) goto L14;
    L17:
        ow3.d.a r108 = new ow3.d.a(r105, r106, r107);     // Catch: Throwable -> L19
    L25:
        this.f500777u = r108;
        return;
    L14:
        if (TextUtils.isEmpty(r106) == false) goto L17;
        if (TextUtils.isEmpty(r107) == true) goto L24;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();
    L24:
        r108 = null;
        goto L25
    }

    @Override // jx3.a
    public final a l(JSONObject r100) {
        super.l(r100);
        this.B = r100.optString("event", null);
        t(r100.optString("params", null));
        this.A = r100.optBoolean("is_bav", false);
        this.C = r100.optString("disable_personalization", null);
        return this;
    }

    @Override // jx3.a
    public final void p(ContentValues r100) {
        super.p(r100);
        r100.put("event", this.B);
        if (mw3.d.f515934a == false) goto L5;
        String r101 = this.f500769m;
        StageEventType r102 = StageEventType.V3_EVENT;
        String r103 = mw3.c.c(r101, this.f500799y);
    L6:
        String r104 = null;
        if (r103 == null) goto L19;
        com.bytedance.applog.b r105 = com.bytedance.applog.a.a(this.f500769m);
        if (r105 == null) goto L11;
        fx3.e r106 = r105.f192444y0;
    L12:
        if (r106 == null) goto L32;
        Iterator r107 = ((CopyOnWriteArrayList) r106.f479109a).iterator();
    L15:
        if (r107.hasNext() == false) goto L32;
        fx3.d r108 = (fx3.d) r107.next();
        if ((r108 instanceof fx3.c) == false) goto L15;
        r103 = ((fx3.c) r108).b(this, r103);
    L32:
        r100.put("params", r103);
        r100.put("is_bav", Integer.valueOf(this.A ? 1 : 0));
        r100.put("disable_personalization", this.C);
        ow3.d.a r109 = this.f500777u;
        if (r109 == null) goto L35;
        JSONObject r110 = new JSONObject();
        r110.put("pid", r109.f527054a);
        r110.put("pName", r109.f527055b);
        r110.put("sdkPageId", r109.f527056c);
        r104 = r110.toString();
    L35:
        r100.put("page_info", r104);
        return;
    L11:
        r106 = null;
        goto L12
    L19:
        JSONObject r111 = this.f500800z;
        com.bytedance.applog.b r112 = com.bytedance.applog.a.a(this.f500769m);
        if (r112 == null) goto L22;
        fx3.e r113 = r112.f192444y0;
    L23:
        if (r113 == null) goto L30;
        Iterator r114 = ((CopyOnWriteArrayList) r113.f479109a).iterator();
    L26:
        if (r114.hasNext() == false) goto L30;
        fx3.d r115 = (fx3.d) r114.next();
        if ((r115 instanceof fx3.c) == false) goto L26;
        r111 = ((fx3.c) r115).c(this, r111);
    L30:
        if (r111 == null) goto L32;
        r103 = r111.toString();
        goto L32
    L22:
        r113 = null;
        goto L23
    L5:
        r103 = this.f500799y;
        goto L6
    }

    @Override // jx3.a
    public final void q(JSONObject r100) throws JSONException {
        super.q(r100);
        r100.put("event", this.B);
        s();
        r100.put("params", this.f500799y);
        r100.put("is_bav", this.A);
        r100.put("disable_personalization", this.C);
    }

    public final void t(String r100) {
        this.f500799y = r100;
        this.f500800z = null;
    }

    public void u(com.bytedance.applog.priority.a r110) {
        if (r110 == null) goto L153;
        String r100 = this.B;
        s();
        String r101 = this.f500799y;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        boolean r102 = false;
    L12:
        int r103 = -1;
        if (r102 == false) goto L104;
        Map<String, Integer> r104 = r110.f192589f;
        if (r104 == null) goto L23;
        if (((HashMap) r104).containsKey(r100) == false) goto L23;
        Integer r111 = (Integer) ((HashMap) r110.f192589f).get(r100);
        if (r111 == null) goto L104;
        r103 = r111.intValue();
    L23:
        if (TextUtils.isEmpty(r101) == true) goto L104;
        Map<Integer, com.bytedance.applog.priority.b> r105 = r110.f192587d;
        if (r105 == null) goto L104;
        if (r105.isEmpty() == true) goto L104;
        JSONObject r106 = new JSONObject(r101);     // Catch: JSONException -> L102
        Iterator<Map.Entry<Integer, com.bytedance.applog.priority.b>> r112 = r110.f192587d.entrySet().iterator();
    L32:
        if (r112.hasNext() == false) goto L104;
        Map.Entry<Integer, com.bytedance.applog.priority.b> r107 = r112.next();
        int r108 = r107.getKey().intValue();
        if ((-1) == r108) goto L32;
        com.bytedance.applog.priority.b r109 = r107.getValue();
        if (r109 == null) goto L32;
        Map<String, List<Set<String>>> r113 = r109.f192596e;
        if (r113 != null) goto L42;
    L65:
        Map<String, List<Map<String, Object>>> r114 = r109.f192597f;
        if (r114 == null) goto L32;
        if (((HashMap) r114).isEmpty() == true) goto L32;
        if (((HashMap) r109.f192597f).containsKey(r100) == false) goto L32;
        List r115 = (List) ((HashMap) r109.f192597f).get(r100);
        if (r115 == null) goto L32;
        if (r115.isEmpty() == true) goto L32;
        Iterator r116 = r115.iterator();
    L77:
        if (r116.hasNext() == false) goto L32;
        Map r117 = (Map) r116.next();
        if (r117 == null) goto L77;
        if (r117.isEmpty() == true) goto L77;
        Iterator r118 = r117.keySet().iterator();
    L84:
        if (r118.hasNext() == false) goto L88;
        if (r106.has((String) r118.next()) == true) goto L84;
        boolean r119 = false;
    L89:
        if (r119 == false) goto L77;
        Iterator r120 = r117.entrySet().iterator();
    L92:
        if (r120.hasNext() == false) goto L99;
        Map.Entry r121 = (Map.Entry) r120.next();
        String r122 = (String) r121.getKey();
        Object r123 = r121.getValue();
        if (TextUtils.isEmpty(r122) == true) goto L98;
        if (r123 == null) goto L98;
        if (r123.equals(r106.opt(r122)) == true) goto L92;
    L98:
        boolean r124 = false;
    L100:
        if (r124 == false) goto L77;
    L101:
        r103 = r108;
        goto L104
    L99:
        r124 = true;
        goto L100
    L88:
        r119 = true;
        goto L89
    L42:
        if (((HashMap) r113).isEmpty() == true) goto L65;
        if (((HashMap) r109.f192596e).containsKey(r100) == false) goto L65;
        List r125 = (List) ((HashMap) r109.f192596e).get(r100);
        if (r125 == null) goto L65;
        if (r125.isEmpty() == true) goto L65;
        Iterator r126 = r125.iterator();
    L51:
        if (r126.hasNext() == false) goto L65;
        Set r127 = (Set) r126.next();
        if (r127 == null) goto L51;
        if (r127.isEmpty() == true) goto L51;
        Iterator r128 = r127.iterator();
    L58:
        if (r128.hasNext() == false) goto L62;
        if (r106.has((String) r128.next()) == true) goto L58;
        boolean r129 = false;
    L63:
        if (r129 == false) goto L51;
    L62:
        r129 = true;
    L102:
        e = move-exception;
        n.w().q("Cannot parse event params", e, new Object[0]);
    L104:
        this.f500771o = r103;
        return;
    L6:
        Map<String, Integer> r130 = r110.f192589f;
        if (r130 != null) goto L9;
    L11:
        r102 = ((HashSet) r110.f192588e).contains(r100);
        goto L12
    L9:
        if (((HashMap) r130).containsKey(r100) == false) goto L11;
        r102 = true;
        goto L12
    }

    public e(String r100, String r101) {
        this.f500769m = r100;
        this.B = r101;
        this.D = false;
    }

    public e(String r100, String r101, String r102, int r103) {
        this.f500769m = r100;
        this.B = r101;
        this.A = false;
        this.f500799y = r102;
        this.f500800z = null;
        com.bytedance.applog.b r104 = com.bytedance.applog.a.a(r100);
        if (r104 != null) goto L5;
    L7:
        this.D = false;
        return;
    L5:
        if (r104.Y == null) goto L7;
        this.C = String.valueOf(r104.Y);
        goto L7
    }
}
