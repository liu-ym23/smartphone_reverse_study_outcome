package j70;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.larus.dora.api.model.FlowDoraWifiScene;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f497562a = null;

    public static String a(double r100) {
        if (r100 >= 1.0d) goto L8;
        if (r100 < 0) goto L8;
        return DiagnoseResult.DIAGNOSE_LEVEL_P0;
    L8:
        if (r100 >= 2.0d) goto L11;
        return DiagnoseResult.DIAGNOSE_LEVEL_P1;
    L11:
        if (r100 >= 3.0d) goto L13;
        return DiagnoseResult.DIAGNOSE_LEVEL_P2;
    L13:
        return FlowDoraWifiScene.OTHER;
    }

    static {
        f497562a = new HashMap();
    }
}
