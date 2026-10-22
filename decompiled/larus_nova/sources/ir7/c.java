package ir7;

import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import hr7.f;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes22.dex */
public final class c {
    public static String d() {
        return com.bytedance.webx.seclink.setting.c.d().g();
    }

    public static boolean g(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return false;
    L10:
        String r102 = UriProtector.parse(d()).getHost();
        String r103 = UriProtector.parse(r100).getHost();
        if (r103 != null) goto L14;
        return false;
    L14:
        return r103.equalsIgnoreCase(r102);
    L5:
        if (TextUtils.isEmpty("https://") == true) goto L7;
        r101 = r100.toLowerCase().startsWith("https://".toLowerCase());
        goto L8
    }

    public static boolean e(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L13:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        if (r101.equals(r100) == false) goto L11;
        return true;
    L11:
        if (r101.equals(r100 + HTTP.URL_DEFAULT) == false) goto L13;
        return true;
    }

    public static boolean f(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L47:
        return false;
    L5:
        if (com.bytedance.webx.seclink.setting.c.i(r101) == false) goto L47;
        Uri r102 = UriProtector.parse(r100);
        String r103 = r102.getScheme();
        if (TextUtils.isEmpty(r103) == true) goto L49;
        com.bytedance.webx.seclink.setting.c r104 = com.bytedance.webx.seclink.setting.c.d();
        com.bytedance.webx.seclink.setting.a.c r105 = r104.e(r101);
        if (r105 == null) goto L15;
        Set<String> r106 = r105.f272625e;
        if (r106 == null) goto L15;
        if (((HashSet) r106).isEmpty() == true) goto L15;
        Set<String> r107 = r105.f272625e;
    L26:
        if (r107 != null) goto L28;
    L32:
        r107 = r104.f272629b;
    L33:
        if (r107 != null) goto L35;
    L44:
        gr7.a r108 = cr7.a.f465093b;
        if (r108 == null) goto L47;
        r108.getClass();
        goto L47
    L35:
        if (r107.contains("*") == false) goto L41;
        if (TextUtils.isEmpty(r102.getHost()) == true) goto L44;
        return !g(r100);
    L41:
        if (r107.contains(r103.toLowerCase()) == false) goto L44;
        return !g(r100);
    L28:
        if (r107.isEmpty() == true) goto L32;
        if (r107.contains("*") == true) goto L33;
        r107.addAll(r104.f272629b);
    L15:
        com.bytedance.webx.seclink.setting.a r109 = r104.c();
        if (r109 == null) goto L24;
        com.bytedance.webx.seclink.setting.a.b r110 = r109.f272607c;
        if (r110 == null) goto L24;
        Set<String> r111 = r110.f272620d;
        if (r111 == null) goto L24;
        if (((HashSet) r111).isEmpty() == true) goto L24;
        r107 = r109.f272607c.f272620d;
    L24:
        r107 = null;
        goto L26
    L49:
        return true;
    }

    public static String a(String r100, String r110, String r111, int r112, String r113) {
        gr7.a r101 = cr7.a.f465093b;
        if (TextUtils.isEmpty(r110) == false) goto L8;
        if (r101 == null) goto L6;
        r110 = r101.f482366a;
        goto L8
    L6:
        r110 = "";
    L8:
        if (TextUtils.isEmpty(r110) == false) goto L11;
        return r100;
    L11:
        if (TextUtils.isEmpty(r100) == false) goto L14;
        return r100;
    L14:
        if (g(r100) == false) goto L16;
        return r100;
    L16:
        String r102 = d();
        if (f(r100, r111) == false) goto L40;
        StringBuilder r103 = new StringBuilder();
        r103.append(r102);
        if (r112 <= 0) goto L21;
        r103.append("/middle-page");
    L21:
        HashMap r104 = (HashMap) e.a();
        r104.put("aid", r110);
        if (r101 == null) goto L24;
        String r114 = r101.f482367b;
    L25:
        r104.put(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, r114);
        r104.put("scene", r111);
        r104.put("jumper_version", "1");
        r104.put(PickerReporterConstants.KEY.TARGET, URLEncoder.encode(r100));
        if (TextUtils.isEmpty(r113) == true) goto L28;
        String r115 = r113;
    L29:
        r104.put("sec_link_biz_tag", r115);
        if (r112 <= 0) goto L32;
        r104.put("type", r112 + "");
    L32:
        r103.append("?");
        Iterator r116 = r104.keySet().iterator();
    L34:
        if (r116.hasNext() == false) goto L38;
        String r117 = (String) r116.next();
        String r105 = (String) r104.get(r117);
        r103.append(r117);
        r103.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r103.append(r105);
        if (r116.hasNext() == false) goto L34;
        r103.append("&");
        goto L34
    L38:
        String r118 = r103.toString();
        ReportUtil.a(true, r102, r100, r111, r113, r118);
        return r118;
    L28:
        r115 = "unknown";
        goto L29
    L24:
        r114 = "zh";
        goto L25
    L40:
        ReportUtil.a(false, r102, r100, r111, r113, r100);
        return r100;
    }

    public static Future<hr7.c> b(String r100, String r101, String r102, int r103, Map<String, Object> r104, boolean r105, String r106) {
        gr7.a r107 = cr7.a.f465093b;
        if (TextUtils.isEmpty(r101) == false) goto L11;
        r101 = "";
        if (r107 == null) goto L7;
        String r108 = r107.f482366a;
    L9:
        if (TextUtils.isEmpty(r108) == true) goto L11;
        r101 = r108;
        goto L11
    L7:
        r108 = "";
    L11:
        f r109 = new f();
        r109.f486918a = r101;
        r109.f486919b = r102;
        r109.f486920c = r100;
        r109.f486921d = System.currentTimeMillis() / 1000;
        r109.f486925h = null;
        r109.f486924g = r103;
        r109.f486923f = r105;
        r109.f486926i = r104;
        r109.f486927j = r106;
        hr7.d.b().getClass();
        d r110 = d.a();
        hr7.d.b r111 = new hr7.d.b(r109);
        if (r110.f495490a != null) goto L15;
        r110.f495490a = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("SecLinkTaskExecutor"));
    L15:
        return r110.f495490a.submit(r111);
    }

    public static void c(String r100, String r101, String r102, int r103, Map<String, Object> r104, String r105, hr7.b r106, boolean r110) {
        gr7.a r107 = cr7.a.f465093b;
        if (TextUtils.isEmpty(r101) == false) goto L7;
        if (r107 == null) goto L6;
        r101 = r107.f482366a;
        goto L7
    L6:
        r101 = "";
    L7:
        f r108 = new f();
        r108.f486918a = r101;
        r108.f486919b = r102;
        r108.f486920c = r100;
        r108.f486921d = System.currentTimeMillis() / 1000;
        r108.f486925h = r106;
        r108.f486924g = r103;
        r108.f486923f = r110;
        r108.f486926i = r104;
        r108.f486927j = r105;
        hr7.d r109 = hr7.d.b();
        r109.getClass();
        String r111 = r108.f486919b;
        String r112 = r108.f486920c;
        if (com.bytedance.webx.seclink.setting.c.i(r111) == true) goto L13;
        hr7.b r113 = r108.f486925h;
        if (r113 == null) goto L58;
        r113.onFail();
    L58:
        boolean r114 = false;
    L63:
        if (r114 == false) goto L74;
        d r115 = d.a();
        hr7.d.RunnableC6187d r116 = new hr7.d.RunnableC6187d(r108);
        if (r115.f495490a != null) goto L68;
        r115.f495490a = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("SecLinkTaskExecutor"));
    L68:
        r115.f495490a.execute(r116);
        return;
    L74:
        return;
    L13:
        if (TextUtils.isEmpty(r112) == false) goto L18;
        hr7.b r117 = r108.f486925h;
        if (r117 == null) goto L58;
        r117.onFail();
        goto L58
    L18:
        if (g(r112) == false) goto L22;
        hr7.b r118 = r108.f486925h;
        if (r118 == null) goto L58;
        r118.onFail();
        goto L58
    L22:
        hr7.c r119 = fr7.a.a().b(r108.f486919b, r108.f486920c);
        if (r119 == null) goto L27;
        ReportUtil.d(r112, r111, r108.f486927j, r119.f486897c, "task_check");
        hr7.b r120 = r108.f486925h;
        if (r120 == null) goto L58;
        r120.a(r112, r119);
        goto L58
    L27:
        String r121 = hr7.a.a(r108.f486918a, r108.f486919b, r108.f486920c);
        hr7.a r122 = r109.f486910a;
        if (r122 != null) goto L30;
    L62:
        r109.f486910a = new hr7.a(r108.f486918a, r108.f486919b, r108.f486920c);
        r114 = true;
        goto L63
    L30:
        if (hr7.a.a(r122.f486890b, r122.f486891c, r122.f486892d).equals(r121) == false) goto L62;
        long r123 = System.currentTimeMillis();
        hr7.a r124 = r109.f486910a;
        if ((r123 - r124.f486889a) >= 300) goto L62;
        monitor-enter(r124);
        boolean r125 = r124.f486894f;     // Catch: Throwable -> L59
        monitor-exit(r124);
        if (r125 == false) goto L72;
        hr7.c r126 = r109.f486910a.f486893e;
        if (r126 != null) goto L40;
    L44:
        hr7.b r127 = r108.f486925h;
        if (r127 == null) goto L58;
        r127.onFail();
        goto L58
    L40:
        if (r126.f486895a == false) goto L44;
        hr7.b r128 = r108.f486925h;
        if (r128 == null) goto L58;
        r128.a(r112, r126);
        goto L58
    L72:
        List<f> r129 = r109.f486911b.get(r121);     // Catch: Exception -> L54
        if (r129 != null) goto L51;
        r129 = new ArrayList();     // Catch: Exception -> L54
        r109.f486911b.put(r121, r129);     // Catch: Exception -> L54
    L51:
        if (r129.contains(r108) == true) goto L58;
        r129.add(r108);     // Catch: Exception -> L54
    L54:
        e = move-exception;
        e.printStackTrace();
        hr7.b r130 = r108.f486925h;
        if (r130 == null) goto L58;
        r130.onFail();
    L59:
        th = move-exception;
        throw th;
    }
}
