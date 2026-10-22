package u1b;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonReport;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.di.d;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.q;
import com.ss.android.lark.officesdk.utils.net.NetworkType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;
import ntb.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f548367a = false;

    static {
        int r100 = d.f437220a;
        if ((d.a.a().getApplicationInfo().flags & 2) == 0) goto L7;
        boolean r101 = true;
    L8:
        f548367a = r101;
        return;
    L7:
        r101 = false;
        goto L8
    }

    public static void b(String r100, JSONObject r101) {
        if (f548367a == false) goto L5;
        j.a(ChameleonReport.TAG, "trackEventExt, eventName = " + r100 + " param is " + r101);
    L5:
        if (r101 == null) goto L10;
        int r102 = q.f437232a;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        DependencyContainer r103 = DependencyContainer.f433166a;
        u r104 = (u) DependencyContainer.a(u.class, null);
        if (r104 == null) goto L11;
        r104.sendEvent(r100, r101);
        return;
    L11:
        return;
    }

    public static void a(String r100, String r101, long r102, boolean r103, String r110) {
        JSONObject r104 = new JSONObject();
        int r105 = d.f437220a;
        NetworkType r106 = twb.a.a(d.a.a());
        r104.put("duration_ms", r102);     // Catch: JSONException -> L15
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        r104.put("app_name", r100);     // Catch: JSONException -> L15
        r104.put("is_success", r103);     // Catch: JSONException -> L15
        if (r110 != null) goto L10;
        r110 = "";
    L10:
        r104.put("errorMsg", r110);     // Catch: JSONException -> L15
        if (r101 != null) goto L13;
        r101 = "";
    L13:
        r104.put("channel", r101);     // Catch: JSONException -> L15
        r104.put(DBDefinition.DOWNLOAD_TABLE_NAME, "gecko");     // Catch: JSONException -> L15
        r104.put("network_status", r106);     // Catch: JSONException -> L15
        j.a(ChameleonReport.TAG, "reportChameleonDownload, params = " + r104);     // Catch: JSONException -> L15
    L17:
        b("Chameleon_gecko_download_duration_dev", r104);
        return;
    L15:
        e = move-exception;
        j.c(ChameleonReport.TAG, "reportChameleonDownload failed", e);
        goto L17
    }
}
