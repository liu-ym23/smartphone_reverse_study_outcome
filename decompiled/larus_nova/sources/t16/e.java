package t16;

import com.ss.android.cert.manager.constants.EventConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f544162b;

    public final String getType() {
        return this.f544161a;
    }

    public e(JSONObject r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.optString("type");
    L6:
        this.f544161a = r102;
        if (r100 == null) goto L9;
        r100.optString("development");
    L9:
        if (r100 == null) goto L11;
        r100.optString("production");
    L11:
        if (r100 == null) goto L13;
        r101 = r100.optString(EventConstant.Key.MODULE);
    L13:
        this.f544162b = r101;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
