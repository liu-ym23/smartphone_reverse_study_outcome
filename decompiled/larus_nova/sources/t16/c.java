package t16;

import com.ss.android.cert.manager.constants.EventConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544157a;

    public c(JSONObject r100) {
        if (r100 == null) goto L5;
        r100.optString("development");
    L5:
        if (r100 == null) goto L7;
        r100.optString("production");
    L7:
        if (r100 == null) goto L9;
        String r101 = r100.optString(EventConstant.Key.MODULE);
    L10:
        this.f544157a = r101;
        return;
    L9:
        r101 = null;
        goto L10
    }
}
