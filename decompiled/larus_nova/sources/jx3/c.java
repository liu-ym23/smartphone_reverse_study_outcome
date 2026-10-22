package jx3;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    public String A;
    public String B;
    public long C;
    public long D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f500795y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f500796z;

    @Override // jx3.a
    public final String j() {
        return "event";
    }

    @Override // jx3.a
    public final String g() {
        return "" + this.f500796z + ", " + this.A;
    }

    @Override // jx3.a
    public final JSONObject r() throws JSONException {
        if (TextUtils.isEmpty(this.B) == true) goto L5;
        JSONObject r100 = new JSONObject(this.B);
    L6:
        if (r100 != null) goto L8;
        r100 = new JSONObject();
    L8:
        r100.put("local_time_ms", this.f500758b);
        r100.put("tea_event_index", this.f500759c);
        r100.put("session_id", this.f500760d);
        c(r100);
        if (this.f500765i == NetworkUtils.NetworkType.UNKNOWN.getValue()) goto L12;
        r100.put("nt", this.f500765i);
    L12:
        if (TextUtils.isEmpty(this.f500763g) == true) goto L14;
        r100.put(DyPayConstant.KEY_USER_UNIQUE_ID, this.f500763g);
    L14:
        r100.put("category", this.f500795y);
        r100.put("tag", this.f500796z);
        r100.put("value", this.C);
        r100.put("ext_value", this.D);
        r100.put("label", this.A);
        r100.put(SheetInputData.InputData.DateType.DATETIME, this.f500770n);
        if (TextUtils.isEmpty(this.f500764h) == true) goto L17;
        r100.put("ab_sdk_version", this.f500764h);
    L17:
        long r101 = this.f500773q;
        if (r101 <= 0) goto L20;
        r100.put("event_id", r101);
    L20:
        long r102 = this.f500774r;
        if (r102 <= 0) goto L23;
        r100.put("monitor_id", String.valueOf(r102));
    L23:
        int r103 = this.f500775s;
        if (r103 <= 0) goto L26;
        r100.put("event_stained", r103);
    L26:
        return r100;
    L5:
        r100 = null;
        goto L6
    }

    @Override // jx3.a
    public final List<String> e() {
        List<String> r100 = super.e();
        ArrayList r101 = new ArrayList(r100.size());
        r101.addAll(r100);
        r101.addAll(Arrays.asList(new String[]{"category", "varchar", "tag", "varchar", "value", "integer", "ext_value", "integer", "params", "varchar", "label", "varchar"}));
        return r101;
    }

    public c() {
    }

    @Override // jx3.a
    public final String f() {
        return this.B;
    }

    @Override // jx3.a
    public final String h() {
        return this.f500796z;
    }

    @Override // jx3.a
    public final void k(Cursor r100) {
        super.k(r100);
        this.f500795y = r100.getString(18);
        this.f500796z = r100.getString(19);
        this.C = r100.getLong(20);
        this.D = r100.getLong(21);
        this.B = r100.getString(22);
        this.A = r100.getString(23);
    }

    @Override // jx3.a
    public final a l(JSONObject r100) {
        super.l(r100);
        this.f500759c = r100.optLong("tea_event_index", 0);
        this.f500795y = r100.optString("category", null);
        this.f500796z = r100.optString("tag", null);
        this.C = r100.optLong("value", 0);
        this.D = r100.optLong("ext_value", 0);
        this.B = r100.optString("params", null);
        this.A = r100.optString("label", null);
        return this;
    }

    @Override // jx3.a
    public final void p(ContentValues r100) {
        super.p(r100);
        r100.put("category", this.f500795y);
        r100.put("tag", this.f500796z);
        r100.put("value", Long.valueOf(this.C));
        r100.put("ext_value", Long.valueOf(this.D));
        if (mw3.d.f515934a == false) goto L5;
        String r101 = this.f500769m;
        StageEventType r102 = StageEventType.V3_EVENT;
        r100.put("params", mw3.c.c(r101, this.B));
    L6:
        r100.put("label", this.A);
        return;
    L5:
        r100.put("params", this.B);
        goto L6
    }

    @Override // jx3.a
    public final void q(JSONObject r100) throws JSONException {
        super.q(r100);
        r100.put("tea_event_index", this.f500759c);
        r100.put("category", this.f500795y);
        r100.put("tag", this.f500796z);
        r100.put("value", this.C);
        r100.put("ext_value", this.D);
        r100.put("params", this.B);
        r100.put("label", this.A);
    }

    public c(String r100, String r101, String r102, String r103, long r104, long r105, String r110) {
        m(0);
        this.f500795y = r101;
        this.f500796z = r102;
        this.A = r103;
        this.C = r104;
        this.D = r105;
        this.B = r110;
        this.f500769m = r100;
    }
}
