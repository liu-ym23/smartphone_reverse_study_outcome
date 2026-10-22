package gu2;

import com.bytedance.android.live.core.verify.api.VerifyResponBean;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f482753a = 0;

    public f() {
    }

    static {
    }

    public static final HashMap a(boolean r100, String r101, JSONObject r102, int r103, VerifyResponBean r104) {
        HashMap r105 = new HashMap();
        r105.put("isThrowable", Boolean.valueOf(r100));
        r105.put("msg", r101);
        if (r102 == null) goto L5;
        r105.put("data", r102);
    L5:
        r105.put("live_response", r104);
        r105.put("errCode", Integer.valueOf(r103));
        return r105;
    }
}
