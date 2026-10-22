package jx3;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class k extends a {
    public String A;
    public Integer B;
    public String C;
    public String D;
    public Integer E;
    public String F;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f500812y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f500813z;

    @Override // jx3.a
    public final List<String> e() {
        return null;
    }

    @Override // jx3.a
    public final String h() {
        return EventVerify.TYPE_TERMINATE;
    }

    @Override // jx3.a
    public final String j() {
        return EventVerify.TYPE_TERMINATE;
    }

    @Override // jx3.a
    public final String g() {
        return String.valueOf(this.f500812y);
    }

    @Override // jx3.a
    public final JSONObject r() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("local_time_ms", this.f500758b);
        r100.put("tea_event_index", this.f500759c);
        r100.put("session_id", this.f500760d);
        r100.put("stop_timestamp", this.f500813z / 1000);
        r100.put("duration", this.f500812y / 1000);
        r100.put(SheetInputData.InputData.DateType.DATETIME, this.f500770n);
        c(r100);
        if (TextUtils.isEmpty(this.f500763g) == true) goto L6;
        r100.put(DyPayConstant.KEY_USER_UNIQUE_ID, this.f500763g);
    L6:
        if (TextUtils.isEmpty(this.f500764h) == true) goto L9;
        r100.put("ab_sdk_version", this.f500764h);
    L9:
        if (TextUtils.isEmpty(this.A) == true) goto L13;
        r100.put("uuid_changed", true);
        if (TextUtils.equals(this.A, this.f500760d) == true) goto L13;
        r100.put("original_session_id", this.A);
    L13:
        Integer r101 = this.B;
        if (r101 == null) goto L17;
        r100.put("session_type", r101);
    L17:
        if (TextUtils.isEmpty(this.D) == true) goto L20;
        r100.put("from_session", this.D);
    L20:
        if (TextUtils.isEmpty(this.C) == true) goto L22;
        r100.put("to_session", this.C);
    L22:
        Integer r102 = this.E;
        if (r102 == null) goto L25;
        r100.put("bg_session", r102);
    L25:
        long r103 = this.f500773q;
        if (r103 <= 0) goto L28;
        r100.put("event_id", r103);
    L28:
        long r104 = this.f500774r;
        if (r104 <= 0) goto L31;
        r100.put("monitor_id", String.valueOf(r104));
    L31:
        int r105 = this.f500775s;
        if (r105 <= 0) goto L35;
        r100.put("event_stained", r105);
    L35:
        if (TextUtils.isEmpty(this.F) == false) goto L48;
    L47:
        return r100;
    L48:
        JSONObject r106 = new JSONObject(this.F);     // Catch: Throwable -> L45
        Iterator<String> r107 = r106.keys();     // Catch: Throwable -> L45
    L38:
        if (r107.hasNext() == false) goto L47;
        String r108 = r107.next();     // Catch: Throwable -> L45
        if (r100.has(r108) == false) goto L42;
        i().f(4, this.f500776t, "Add flat params to terminate conflict: {} - {}", new Object[]{r108, r106.opt(r108)});     // Catch: Throwable -> L45
        goto L38
    L42:
        r100.put(r108, r106.opt(r108));     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        i().r(4, this.f500776t, "Add params to terminate error", th, new Object[0]);
        goto L47
    }

    public k() {
    }

    @Override // jx3.a
    public final void k(Cursor r100) {
        i().p(4, this.f500776t, "read db not implemented", new Object[0]);
    }

    @Override // jx3.a
    public final a l(JSONObject r100) {
        i().p(4, this.f500776t, "read ipc not implemented", new Object[0]);
        return this;
    }

    @Override // jx3.a
    public final void p(ContentValues r100) {
        i().p(4, this.f500776t, "write db not implemented", new Object[0]);
    }

    @Override // jx3.a
    public final void q(JSONObject r100) {
        i().p(4, this.f500776t, "write ipc not implemented", new Object[0]);
    }
}
