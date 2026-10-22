package fd1;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.wallet.monitor.WalletMonitorEvent;
import com.bytedance.android.live.wallet.monitor.WalletMonitorService;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f476458a = 0;

    static {
    }

    public static void b(Throwable r100, Map r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ApiServerException) == false) goto L10;
        ApiServerException r102 = (ApiServerException) r100;
        if (TextUtils.isEmpty(r102.getErrorMsg()) == true) goto L10;
        r101.put("error_code", Integer.valueOf(r102.getErrorCode()));
        String r103 = r102.getErrorMsg();
        Intrinsics.checkNotNull(r103);
        r101.put("error_msg", r103);
        return;
    L10:
        if ((r100 instanceof ApiException) == false) goto L15;
        r101.put("error_code", Integer.valueOf(((ApiException) r100).getErrorCode()));
        String r104 = r100.getMessage();
        if (r104 == null) goto L21;
        r101.put("error_msg", r104);
        return;
    L21:
        return;
    L15:
        if ((r100 instanceof Exception) == false) goto L23;
        r101.put("error_code", -1);
        String r105 = r100.getMessage();
        if (r105 == null) goto L24;
        r101.put("error_msg", r105);
        return;
    L24:
        return;
    }

    public static void a(String r100, int r101, Map r102) {
        Intrinsics.checkNotNullParameter(r102, "extra");
        Intrinsics.checkNotNullParameter(r102, "map");
        JSONObject r103 = new JSONObject();
        Iterator r104 = r102.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.put((String) r105.getKey(), r105.getValue());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        Intrinsics.checkNotNullParameter(r103, "jsonExtra");
        LiveSlardarMonitor.monitorStatusRate(r100, r101, r103);
    }

    public static void c(WalletMonitorService r100, Map r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorService");
        Intrinsics.checkNotNullParameter(r101, "extra");
        b(r102, r101);
        a(r100.getServiceName(), 0, r101);
    }

    public static void d(boolean r100, WalletMonitorEvent r101, Map r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r101, "walletMonitorEvent");
        Intrinsics.checkNotNullParameter(r102, "extra");
        b(r103, r102);
        a(r101.getService().getServiceName(), r101.getStatusCode() + (!r100 ? 1 : 0), r102);
    }
}
