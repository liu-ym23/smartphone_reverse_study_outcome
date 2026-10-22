package ms;

import android.content.Context;
import com.bytedance.android.gamecp.base.core.service.depend.x;
import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.android.gamecp.business.download.y0;
import com.bytedance.android.gamecp.business.i0;
import com.bytedance.android.gamecp.common.setting.config.s0;
import com.bytedance.android.gamecp.common.utils.NetworkUtils;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ttnetuploader.uploader.task.Task;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import wu.a1;
import wu.b1;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f515456a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f515457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f515458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f515459d;

    static {
        f515456a = TokenCert.Companion.with("bpea-live_game_download_network");
        f515457b = "";
        f515459d = "";
    }

    public static void c(Context r100, p r101) {
        if (r100 == null) goto L40;
        if (r101 == null) goto L40;
        s0 r102 = a1.f561277a.getValue();
        StringBuilder r103 = new StringBuilder("tryShowDownloadPauseDialog() GAMECP_DOWNLOAD_PAUSE_ABTEST.value=");
        wu.f r104 = wu.f.f561305a;
        r103.append(r104.getValue());
        yr.c.b("download_pause_dialog", r103.toString());
        Integer r105 = r104.getValue();
        if (r105 == null) goto L13;
        if (r105.intValue() != 0) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r101.f52845f, "promote_detail") == true) goto L17;
        if (Intrinsics.areEqual(r101.f52845f, "game_ad") == true) goto L17;
    L20:
        yr.c.e("download_pause_dialog", "tryShowDownloadPauseDialog from page=" + r101.f52845f + ",hit =" + r102.b());
        String r106 = r101.f52845f;
        List<String> r107 = b1.f561283a.getValue().b();
        yr.c.b("download_pause_dialog", "isSupportPauseDialog() page=" + r106 + " pageList=" + r107);
        boolean r108 = false;
        if (r106 != null) goto L23;
    L26:
        boolean r109 = true;
    L27:
        if (r109 == true) goto L31;
        if (r107 == null) goto L31;
        r108 = r107.contains(r106);
    L31:
        if (r108 == true) goto L33;
        y0.f52963a.a(r100, r101);
        return;
    L33:
        if (NetworkUtils.d(r100, f515456a) == false) goto L36;
        a(r100, 1, r101);
        return;
    L36:
        if (NetworkUtils.f(r100) == false) goto L50;
        a(r100, 2, r101);
        return;
    L50:
        return;
    L23:
        if (r106.length() == 0) goto L26;
        r109 = false;
    L17:
        if (r102.b() >= 2) goto L20;
        yr.c.b("download_pause_dialog", "tryShowDownloadPauseDialog() downloadInfo.page=" + r101.f52845f + "config.downloadPauseABTest=" + r102.b() + ", return");
        y0.f52963a.a(r100, r101);
        return;
    L40:
        StringBuilder r110 = new StringBuilder("tryShowDownloadPauseDialog from page=");
        Integer r111 = null;
        if (r101 == null) goto L43;
        String r112 = r101.f52845f;
    L44:
        r110.append(r112);
        r110.append(",status=");
        if (r101 == null) goto L47;
        r111 = Integer.valueOf(r101.f52880w0);
    L47:
        r110.append(r111);
        yr.c.b("download_pause_dialog", r110.toString());
        y0.f52963a.a(r100, r101);
        return;
    L43:
        r112 = null;
        goto L44
    }

    public static void a(Context r100, int r101, p r102) {
        String r103 = "gamecp.key.DOWNLOAD_PAUSE_DIALOG_SHOW_" + r102.f52866p0;
        s0 r104 = a1.f561277a.getValue();
        boolean r105 = false;
        if (com.bytedance.android.gamecp.host_api.a.b().getHostContext().isLocalTest() == true) goto L5;
    L7:
        boolean r106 = false;
    L8:
        int r107 = com.bytedance.android.gamecp.common.utils.a1.b().getInt(r103, 0);
        StringBuilder r108 = new StringBuilder("doShowDownloadPauseDialog should show dialog = ");
        if (r107 != 0) goto L11;
        r105 = true;
    L11:
        r108.append(r105);
        r108.append(",type =");
        r108.append(r101);
        yr.c.e("download_pause_dialog", r108.toString());
        if (r107 == 0) goto L16;
        if (r106 == true) goto L16;
        y0.f52963a.a(r100, r102);
        return;
    L16:
        a r109 = new a(r100, r101, r102);
        if (DialogLancet.shouldBlockDialogShow(r109) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(r109);
    L21:
        com.bytedance.android.gamecp.common.utils.a1.a().putInt(r103, 1).apply();
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L20:
        DialogLancet.beforeDialogShow(r109);
        r109.show();
        DialogLancet.afterDialogShow(r109);
        goto L21
    L5:
        if (r104.f() == false) goto L7;
        r106 = true;
        goto L8
    }

    public static String b(Long r110, x r111, boolean r112) {
        if (r111 != null) goto L6;
        yr.c.e("getPauseTextSuffix", "progressData = null");
        return "";
    L6:
        long r100 = r111.f51443g - r111.f51442f;
        if (r100 <= 0) goto L56;
        float r101 = r111.f51444h;
        if (r101 <= 0) goto L56;
        float r102 = (r100 / ((long) 1000)) / r101;
        yr.c.a("getPauseTextSuffix", "downloadTime:" + r110 + ", restBytes: " + r100 + ", restTime: " + r102 + ", lastRealSpeed:" + r111.f51444h);
        if (a1.f561277a.getValue().c() == false) goto L19;
        long r103 = r111.f51443g;
        if (r103 <= 1073741824) goto L17;
        int r104 = 30000;
    L21:
        if (r110 == null) goto L28;
        if (r110.longValue() >= r104) goto L28;
        double r105 = 1024;
        String r106 = com.bytedance.android.gamecp.common.utils.y0.j(R.string.gamecp_download_pause_dialog_rest_size_greater_than_500, new Object[]{Integer.valueOf((int) ((((((double) i0.h(r111)) / 100.0d) * r111.f51443g) / r105) / r105))});
        if (r112 == true) goto L59;
        return r106;
    L59:
        return r106 + com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_wifi_tips_dialog_size_limit);
    L28:
        if (r102 > 20) goto L33;
        String r107 = com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_rest_time_less_than_20);
        if (r112 == true) goto L61;
        return r107;
    L61:
        return r107 + com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_wifi_tips_dialog_time_limit);
    L33:
        if (r102 > 30) goto L38;
        String r108 = com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_rest_time_less_than_30);
        if (r112 == true) goto L63;
        return r108;
    L63:
        return r108 + com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_wifi_tips_dialog_time_limit);
    L38:
        if (r102 > 50) goto L43;
        String r109 = com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_rest_time_less_than_50);
        if (r112 == true) goto L65;
        return r109;
    L65:
        return r109 + com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_wifi_tips_dialog_time_limit);
    L43:
        if (r102 > 80) goto L48;
        String r113 = com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_rest_time_less_than_80);
        if (r112 == true) goto L67;
        return r113;
    L67:
        return r113 + com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_wifi_tips_dialog_time_limit);
    L48:
        if (r100 >= Task.DISK_THRESHOLD_MIN) goto L52;
        double r114 = 1024;
        String r115 = com.bytedance.android.gamecp.common.utils.y0.j(R.string.gamecp_download_pause_dialog_rest_size_less_than_500, new Object[]{Integer.valueOf((int) ((((((double) 1) - (((double) i0.h(r111)) / 100.0d)) * r111.f51443g) / r114) / r114))});
        if (r112 == true) goto L69;
        return r115;
    L69:
        return r115 + com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_wifi_tips_dialog_time_limit);
    L52:
        double r116 = 1024;
        String r117 = com.bytedance.android.gamecp.common.utils.y0.j(R.string.gamecp_download_pause_dialog_rest_size_greater_than_500, new Object[]{Integer.valueOf((int) ((((((double) i0.h(r111)) / 100.0d) * r111.f51443g) / r116) / r116))});
        if (r112 == true) goto L55;
        return r117;
    L55:
        return r117 + com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_download_pause_wifi_tips_dialog_size_limit);
    L17:
        if (r103 <= 629145600) goto L19;
        r104 = 20000;
    L19:
        r104 = 10000;
    L56:
        yr.c.e("getPauseTextSuffix", "restBytes: " + r100 + ", lastRealSpeed:" + r111.f51444h);
        return "";
    }
}
