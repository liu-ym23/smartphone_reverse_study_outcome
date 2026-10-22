package u77;

import com.bytedance.common.push.BaseJson;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class n extends BaseJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f549064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f549065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f549066c;

    public final String toString() {
        return "regText:" + this.f549064a + " blackFiledList:" + this.f549065b;
    }

    public n(JSONObject r100) {
        this.f549064a = r100.optString("reg");     // Catch: Throwable -> L10
        this.f549066c = r100.optBoolean("need_intercept");     // Catch: Throwable -> L10
        JSONArray r101 = r100.optJSONArray("black_field_list");     // Catch: Throwable -> L10
        this.f549065b = new ArrayList();     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        int r102 = 0;
    L7:
        if (r102 >= r101.length()) goto L17;
        this.f549065b.add(JSONArrayProtectorUtils.getString(r101, r102));     // Catch: Throwable -> L10
        r102 = r102 + 1;
        goto L7
    L17:
        return;
    L16:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }
}
