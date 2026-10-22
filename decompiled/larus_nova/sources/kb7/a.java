package kb7;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.account.bus.util.Version;
import com.bytedance.sdk.account.impl.b0;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.account.f;
import com.ss.android.account.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements jb7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f502221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f502222b;

    /* JADX INFO: renamed from: kb7.a$a, reason: collision with other inner class name */
    public static final class C6532a {
    }

    public a() {
    }

    @Override // jb7.a
    public final String getName() {
        return "captcha";
    }

    static {
        f502222b = true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.bdturing.reflect.VersionUtils");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.bdturing.reflect.VersionUtils");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.bdturing.reflect.VersionUtils");
    }

    @Override // jb7.a
    public final boolean b(int r100, Map r101, ua7.b r102, b0 r103) {
        if (r102.f549259m != null) goto L6;
        return false;
    L6:
        if (f502221a == false) goto L42;
    L24:
        String r104 = r102.f549259m.optString("verify_center_decision_conf");
        if (TextUtils.isEmpty(r104) == false) goto L30;
        JSONObject r105 = r102.f549259m.optJSONObject("data");
        if (r105 == null) goto L29;
        r104 = r105.optString("verify_center_decision_conf");
        goto L30
    L29:
        r104 = null;
    L30:
        xqa.b r106 = f.a().f406248a.a();
        if (f502222b == true) goto L33;
    L41:
        return false;
    L33:
        if (r100 != 1104) goto L35;
    L38:
        if (r106 == null) goto L41;
        r106.c();
        r106.a(r104, new b(r103));
        return true;
    L35:
        if (r100 == 1105) goto L38;
        if (TextUtils.isEmpty(r104) == true) goto L41;
    L42:
        Class r107 = c();     // Catch: Throwable -> L9
        String r108 = r107.getMethod("getVersionName", new Class[0]).invoke(r107.newInstance(), new Object[0]).toString();     // Catch: Throwable -> L9
    L12:
        if (TextUtils.isEmpty(r108) == true) goto L17;
        int r109 = com.bytedance.sdk.account.bus.util.a.f268879a;
        if (new Version("3.1.0").a(new Version(r108)) > 0) goto L17;
        boolean r110 = false;
    L18:
        f502222b = r110;
        if (r110 == true) goto L21;
    L23:
        f502221a = true;
        goto L24
    L21:
        if (f.a().f406248a.a() == null) goto L23;
        f.a().f406248a.a().b();
        k.d().isLocalTest();
        tb7.a.b("CaptchaErrorHandler", "未接入验证码SDK或版本过低，请升级验证码SDK到3.1.0版本以上！");
    L17:
        r110 = true;
    L9:
        th = move-exception;
        th.printStackTrace();
        r108 = "";
        goto L12
    }
}
