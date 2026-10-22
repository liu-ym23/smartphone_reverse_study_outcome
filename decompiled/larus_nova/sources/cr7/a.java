package cr7;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.webx.seclink.setting.b;
import com.bytedance.webx.seclink.setting.c;
import er7.e;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f465092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static gr7.a f465093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f465094c;

    public static Context getContext() {
        return f465092a;
    }

    public static er7.a a(WebView r100, String r101) {
        c r102 = c.d();
        com.bytedance.webx.seclink.setting.a.c r103 = r102.e(r101);
        if (r103 == null) goto L5;
        boolean r104 = r103.f272624d;
    L11:
        if (r104 == false) goto L14;
        return new e(r100, r101);
    L14:
        return new er7.c(r100, r101);
    L5:
        com.bytedance.webx.seclink.setting.a r105 = r102.c();
        if (r105 == null) goto L10;
        com.bytedance.webx.seclink.setting.a.b r106 = r105.f272607c;
        if (r106 == null) goto L10;
        r104 = r106.f272619c;
    L10:
        r104 = true;
        goto L11
    }

    public static void b(Context r100, gr7.a r101) {
        if (TextUtils.isEmpty(r101.f482366a) == true) goto L62;
        System.currentTimeMillis();
        if (TextUtils.isEmpty(null) == true) goto L7;
        r101.a(null);
    L7:
        int r102 = 0;
        if (f465093b == null) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
        f465092a = r100.getApplicationContext();
        f465093b = r101;
        f465094c = true;
    L52:
        c r104 = c.d();
        if (r104.f272638k == true) goto L59;
        com.bytedance.webx.seclink.setting.e r105 = com.bytedance.webx.seclink.setting.e.a.f272646a;
        b r106 = new b(r104);
        Handler r107 = r105.f272645b;
        if (r107 == null) goto L58;
        r107.post(r106);
    L58:
        r104.f272638k = true;
    L59:
        System.currentTimeMillis();
        return;
    L13:
        if (TextUtils.isEmpty(r101.f482366a) == true) goto L16;
        gr7.a r108 = f465093b;
        r108.f482366a = r101.f482366a;
    L16:
        if (TextUtils.isEmpty(r101.f482367b) == true) goto L19;
        gr7.a r109 = f465093b;
        r109.f482367b = r101.f482367b;
    L19:
        if (TextUtils.isEmpty(r101.f482371f) == true) goto L22;
        f465093b.a(r101.f482371f);
    L22:
        if (TextUtils.isEmpty(r101.f482369d) == true) goto L25;
        gr7.a r110 = f465093b;
        r110.f482369d = r101.f482369d;
    L25:
        if (TextUtils.isEmpty(r101.f482370e) == true) goto L27;
        gr7.a r111 = f465093b;
        r111.f482370e = r101.f482370e;
    L27:
        TextUtils.isEmpty(r101.f482368c);
        if (TextUtils.isEmpty(r101.f482368c) == true) goto L30;
        gr7.a r112 = f465093b;
        TextUtils.isEmpty(r101.f482368c);
        r112.f482368c = r101.f482368c;
    L30:
        long r113 = r101.f482373h;
        if (r113 <= 0) goto L33;
        f465093b.f482373h = r113;
    L33:
        dr7.b r114 = r101.f482374i;
        if (r114 == null) goto L36;
        f465093b.f482374i = r114;
    L36:
        List<String> r115 = r101.f482372g;
        if (r115 == null) goto L52;
        if (r115.size() <= 0) goto L52;
        List<String> r116 = f465093b.f482372g;
        if (r116 != null) goto L43;
    L50:
        f465093b.f482372g = r115;
        goto L52
    L43:
        if (r116.size() <= 0) goto L50;
    L45:
        if (r102 >= r115.size()) goto L52;
        String r117 = (String) ListProtector.get(r115, r102);
        if (r116.contains(r117) == true) goto L49;
        r116.add(r117);
    L49:
        r102 = r102 + 1;
        goto L45
    L10:
        r103 = false;
        goto L11
    L62:
        throw new RuntimeException("app_id can not be empty.");
    }
}
