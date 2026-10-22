package lt3;

import android.text.TextUtils;
import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements nu3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f510667b;

    @Override // nu3.c
    public final JSONObject a() {
        JSONObject r100 = this.f510667b;     // Catch: Exception -> L7
        if (r100 != null) goto L5;
        r100 = new JSONObject();     // Catch: Exception -> L7
    L5:
        r100.put(FrescoMonitorConst.LOG_TYPE, this.f510666a);     // Catch: Exception -> L7
        return r100;
    L8:
        if (xu3.a.a() == false) goto L16;
        av3.a r101 = av3.b.f16366a;
        if (r101 == null) goto L17;
        r101.b();
        return null;
    L17:
        return null;
    L16:
        return null;
    }

    @Override // nu3.c
    public final boolean isValid() {
        return !TextUtils.isEmpty(this.f510666a);
    }

    public final String toString() {
        return "CommonLog{logType='" + this.f510666a + "'}";
    }

    @Override // nu3.c
    public final String getLogType() {
        return this.f510666a;
    }

    public b(String r100, JSONObject r101) {
        this.f510666a = r100;
        this.f510667b = r101;
    }
}
