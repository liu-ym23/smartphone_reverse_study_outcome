package jx3;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends a {
    public String A;
    public int B;
    public String C;
    public String D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f500810y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f500811z;

    @Override // jx3.a
    public final String h() {
        return "";
    }

    @Override // jx3.a
    public final String j() {
        return "page";
    }

    @Override // jx3.a
    public final String g() {
        return this.A + ", " + this.f500810y;
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
        r100.put("event", "bav2b_page");
        r100.put("is_bav", 1);
        JSONObject r101 = new JSONObject();
        r101.put(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, this.A);
        r101.put("refer_page_key", this.f500811z);
        r101.put("is_back", this.B);
        r101.put("duration", this.f500810y);
        r100.put("params", r101);
        r100.put(SheetInputData.InputData.DateType.DATETIME, this.f500770n);
        long r102 = this.f500773q;
        if (r102 <= 0) goto L8;
        r100.put("event_id", r102);
    L8:
        return r100;
    }

    @Override // jx3.a
    public final List<String> e() {
        List<String> r100 = super.e();
        ArrayList r101 = new ArrayList(r100.size());
        r101.addAll(r100);
        r101.addAll(Arrays.asList(new String[]{DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer", "last_session", "varchar", "flat_params", "varchar"}));
        return r101;
    }

    public j() {
    }

    @Override // jx3.a
    public final void k(Cursor r100) {
        super.k(r100);
        this.A = r100.getString(18);
        this.f500811z = r100.getString(19);
        this.f500810y = r100.getLong(20);
        this.B = r100.getInt(21);
        this.C = r100.getString(22);
        this.D = r100.getString(23);
    }

    @Override // jx3.a
    public final a l(JSONObject r100) {
        super.l(r100);
        this.A = r100.optString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, null);
        this.f500811z = r100.optString("refer_page_key", null);
        this.f500810y = r100.optLong("duration", 0);
        this.B = r100.optInt("is_back", 0);
        return this;
    }

    @Override // jx3.a
    public final void p(ContentValues r100) {
        super.p(r100);
        r100.put(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, this.A);
        r100.put("refer_page_key", this.f500811z);
        r100.put("duration", Long.valueOf(this.f500810y));
        r100.put("is_back", Integer.valueOf(this.B));
        r100.put("last_session", this.C);
        r100.put("flat_params", this.D);
    }

    @Override // jx3.a
    public final void q(JSONObject r100) throws JSONException {
        super.q(r100);
        r100.put(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, this.A);
        r100.put("refer_page_key", this.f500811z);
        r100.put("duration", this.f500810y);
        r100.put("is_back", this.B);
    }
}
