package lm7;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.model.DataUnionStrategy;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import om7.b;
import om7.d;
import om7.f;
import org.json.JSONObject;
import rk7.m;
import rm7.c;
import rm7.i;
import rm7.j;
import um7.e;
import um7.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f509892a;

    public static void b() {
        pm7.a r100 = pm7.a.C7212a.f529851a;
        if (r100.f529849c == true) goto L10;
        e.b("setHasFocus() on call");
        r100.f529849c = true;
        if (r100.f529850d == null) goto L9;
        List<String> r101 = c.a.f538587a.d();
        e.b("setHasFocus(); 获取到剪切板，且callback开始回调；");
        ((b) r100.f529850d).a(r101);
        r100.f529850d = null;
        return;
    L9:
        return;
    }

    public static void d() {
        String r100 = i.b.f538604a.e();
        if (TextUtils.isEmpty(r100) == true) goto L33;
        pm7.b r101 = pm7.b.a.f529854a;
        e.b("setTokenToClipboard() on call; mInit = " + r101.f529853b);
        if (r101.f529853b == false) goto L26;
        Set r102 = pm7.a.C7212a.f529851a.f529848b;
        if (r102 != null) goto L12;
        r102 = new HashSet();
    L12:
        if (r102.contains(DataUnionStrategy.UNION_CLIPBOARD) == false) goto L27;
        d.b.f524309a.getClass();
        e.b("setTokenToClipboard()");
        Context r103 = r101.getContext();
        if (r103 == null) goto L28;
        String r104 = com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.e.a(r103).b(r100);
        if (TextUtils.isEmpty(r104) == false) goto L18;
        e.b("setTokenToClipboard() value = null; return");
        return;
    L18:
        String r105 = r100.toUpperCase();
        String r106 = r105 + new String(f.b(r104)) + r105;
        if (c.a.f538587a.f538576a == null) goto L30;
        Application r107 = m.f538347a;
        m.n();
        ik7.c r108 = m.f538353g;
        if (r108 == null) goto L31;
        bn7.c r109 = ((dn7.c) r108).f469366a;
        if (r109 == null) goto L32;
        r109.d(r106, true);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public static void a(mm7.b r100) {
        j r101 = j.a.f538610a;
        monitor-enter(r101);
        e.b("addTokenInitListener() on call");     // Catch: Throwable -> L18
        if (r101.f538605a == false) goto L8;
        e.b("addTokenInitListener() 回调onTokenSuccess(), listener.name = ".concat(r100.getClass().getName()));     // Catch: Throwable -> L18
        r100.onTokenSuccess(r101.f538606b);     // Catch: Throwable -> L18
    L8:
        if (r101.f538607c == false) goto L11;
        e.b("addTokenInitListener() 回调onCommonPramsFirstSuccess(), listener.name = ".concat(r100.getClass().getName()));     // Catch: Throwable -> L18
        r100.b();     // Catch: Throwable -> L18
    L11:
        if (r101.f538608d == false) goto L13;
        e.b("addTokenInitListener() 回调onUpdateCommonPrams(), listener.name = ".concat(r100.getClass().getName()));     // Catch: Throwable -> L18
        r100.c();     // Catch: Throwable -> L18
    L13:
        e.b("addTokenInitListener() 加入监听列表 listener.name = ".concat(r100.getClass().getName()));     // Catch: Throwable -> L18
        if (r101.f538609e.contains(r100) == true) goto L16;
        r101.f538609e.add(r100);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r101);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static void c(JSONObject r100) {
        i r101 = i.b.f538604a;
        monitor-enter(r101);
        StringBuilder r102 = new StringBuilder("onAppSettingsUpdate is called; mInit = ");     // Catch: Throwable -> L45
        r102.append(r101.f538594a);     // Catch: Throwable -> L45
        r102.append(" appSettings == null ? ");     // Catch: Throwable -> L45
        if (r100 != null) goto L7;
        boolean r103 = true;
    L8:
        r102.append(r103);     // Catch: Throwable -> L45
        e.b(r102.toString());     // Catch: Throwable -> L45
        if (r100 != null) goto L12;
    L15:
        if (r100 != null) goto L17;
    L42:
        e.b("onAppSettingsUpdate() 不包含dog的配置，return");     // Catch: Throwable -> L45
        monitor-exit(r101);
        return;
    L17:
        if (r100.has("sdk_key_LuckyDog") == false) goto L42;
        if (r101.f538594a == true) goto L24;
        r101.f538602i = r100;     // Catch: Throwable -> L45
        e.b("onAppSettingsUpdate() 没有初始化,pending整个appSettings，返回");     // Catch: Throwable -> L45
        monitor-exit(r101);
        return;
    L24:
        c r104 = c.a.f538587a;     // Catch: Throwable -> L45
        if (r104.f538578c == true) goto L27;
        e.b("onAppSettingsUpdate() 没有初始化，return");     // Catch: Throwable -> L45
    L32:
        if (r101.f538595b == true) goto L37;
        r101.f538602i = r100;     // Catch: Throwable -> L45
        e.b("onAppSettingsUpdate() mInitDeviceId 没有初始化，返回");     // Catch: Throwable -> L45
        monitor-exit(r101);
        return;
    L37:
        if (g.a() == false) goto L39;
        r104.b(new rm7.f(r101, r100));     // Catch: Throwable -> L45
    L40:
        monitor-exit(r101);
        return;
    L39:
        r101.b(r100);     // Catch: Throwable -> L45
        goto L40
    L27:
        e.b("onAppSettingsUpdate() on call;");     // Catch: Throwable -> L45
        if (g.a() == false) goto L30;
        r104.b(new rm7.b(r104, r100));     // Catch: Throwable -> L45
        goto L32
    L30:
        r104.k(r100);     // Catch: Throwable -> L45
        goto L32
    L12:
        if (g.a() == false) goto L14;
        c.a.f538587a.b(new um7.a(r100));     // Catch: Throwable -> L45
        goto L15
    L14:
        JSONObject r105 = um7.b.a(r100);     // Catch: Throwable -> L45
        boolean r106 = r105.optBoolean("enable_apply_token", false);     // Catch: Throwable -> L45
        j.a.f538610a.a(r106, r105);     // Catch: Throwable -> L45
        goto L15
    L7:
        r103 = false;
    L45:
        th = move-exception;
        throw th;
    }
}
