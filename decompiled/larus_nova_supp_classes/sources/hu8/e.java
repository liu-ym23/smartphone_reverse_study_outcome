package hu8;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.bootprotector.entity.LastException;
import com.larus.settings.provider.bootprotector.BootProtectorBizCallbackConfig;
import com.larus.settings.provider.bootprotector.BootProtectorConfig;
import com.larus.settings.provider.bootprotector.BootProtectorSilentCleanConfig;
import com.larus.settings.value.az;
import com.larus.settings.value.e10;
import com.larus.settings.value.iu;
import com.larus.utils.l0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mu8.d;
import nu8.a;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static BootProtectorBizCallbackConfig b() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (BootProtectorBizCallbackConfig) l0.a(new BootProtectorBizCallbackConfig(false, null, 3, null), new az());
    }

    public static BootProtectorSilentCleanConfig c() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return (BootProtectorSilentCleanConfig) l0.a(new BootProtectorSilentCleanConfig(null, null, null, null, 15, null), new iu());
    }

    public static String d() {
        Keva r3 = a.a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter("clear_cache_white_list", "key");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(XmlPullParser.NO_NAMESPACE, "fallback");     // Catch: Throwable -> L8
        String r4 = a.a.getString("clear_cache_white_list", XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L8
        if (r4 != null) goto L6;
        r4 = XmlPullParser.NO_NAMESPACE;
    L6:
        a.e("BootProtectorSettings", "getClearCacheWhiteString is: ".concat(r4));     // Catch: Throwable -> L8
        return r4;
    L8:
        th = move-exception;
        a.f("BootProtectorSettings", th, "getClearCacheWhiteList failed");
        return XmlPullParser.NO_NAMESPACE;
    }

    public static int e() {
        int r0 = a.a("crash_count_threhold", 3);
        a.a("BootProtectorSettings", "getCrashCountThrehold is " + r0);
        return r0;
    }

    public static int f() {
        int r0 = a.a("crash_livingtime_threhold", 10000);
        a.a("BootProtectorSettings", "getCrashLivingTimeThrehold is " + r0);
        return r0;
    }

    public static int g() {
        return a.a("current_crash_count", 0);
    }

    public static LastException h() {
        Keva r0 = a.a;
        Intrinsics.checkNotNullParameter("last_exception_info", "key");
        Intrinsics.checkNotNullParameter(LastException.class, "clazz");
        Object r3 = null;
        Intrinsics.checkNotNullParameter("last_exception_info", "key");     // Catch: Exception -> L5
        String r1 = a.a.getString("last_exception_info", null);     // Catch: Exception -> L5
        r3 = new Gson().fromJson(r1, LastException.class);     // Catch: Exception -> L5
    L11:
        return (LastException) r3;
    L5:
        e = move-exception;
        String r2 = e.getMessage();
        if (r2 != null) goto L9;
        r2 = XmlPullParser.NO_NAMESPACE;
    L9:
        a.e("BootProtectorRepo", r2);
        goto L11
    }

    public static void j(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "baseContext");
        a.e("BootProtectorSettings", "updateBootProtectorSettings start");
        e10 r2 = e10.a;
        BootProtectorConfig r3 = e10.C();
        Boolean r5 = r3.getBootProtectorEnable();
        if (r5 == null) goto L5;
        boolean r6 = r5.booleanValue();
    L6:
        Intrinsics.checkNotNullParameter(r4, "baseContext");
        a(r4, r6, "enable_boot_protector");
        Integer r7 = r3.getCrashCountThrehold();
        if (r7 != null) goto L9;
    L10:
        r7 = 3;
    L11:
        Keva r0 = a.a;
        a.b("crash_count_threhold", r7.intValue());
        Integer r8 = r3.getCrashLivingTimeThrehold();
        if (r8 != null) goto L14;
    L15:
        r8 = 10000;
    L16:
        a.b("crash_livingtime_threhold", r8.intValue());
        Gson r9 = d.a;
        String r10 = d.a(r3.getClearCacheWhiteList());
        if (r10 != null) goto L19;
        r10 = XmlPullParser.NO_NAMESPACE;
    L19:
        Intrinsics.checkNotNullParameter("clear_cache_white_list", "key");
        a.a.storeString("clear_cache_white_list", r10);
        a.e("BootProtectorSettings", "updateBootProtectorSettings end");
        return;
    L14:
        if (r8.intValue() > 0) goto L16;
    L9:
        if (r7.intValue() > 0) goto L11;
    L5:
        r6 = false;
        goto L6
    }

    public static boolean i(Context r3, String r4) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        if (new PolarisFileWrapper(String.valueOf(r3.getFilesDir()), r4).exists() == false) goto L7;
        a.e("BootProtectorSettings", "isFlagFileExists: " + r4 + " enable -> true");     // Catch: Throwable -> L9
        return true;
    L7:
        Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        a.e("BootProtectorSettings", "isFlagFileExists: " + r4 + " enable -> false");
        return false;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static void k(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Keva r6 = a.a;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter("history_crash_stacks", "key");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(XmlPullParser.NO_NAMESPACE, "fallback");     // Catch: Throwable -> L16
        List r7 = (List) new Gson().fromJson(a.a.getString("history_crash_stacks", XmlPullParser.NO_NAMESPACE), new d().getType());     // Catch: Throwable -> L16
        if (r7 != null) goto L7;
        r7 = new ArrayList();     // Catch: Throwable -> L16
    L7:
        if (TextUtils.isEmpty(r5) == false) goto L10;
        return;
    L10:
        if (r7.size() != e()) goto L12;
        ListProtector.remove(r7, r7.size() - 1);     // Catch: Throwable -> L16
    L12:
        if (r5 != null) goto L14;
        r5 = XmlPullParser.NO_NAMESPACE;
    L14:
        ListProtector.add(r7, 0, r5);     // Catch: Throwable -> L16
        a.c("history_crash_stacks", r7);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        a.f("BootProtectorSettings", th, "saveCrashStack failed:");
    }

    public static void a(Context r4, boolean r5, String r6) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        a.e("BootProtectorSettings", "createOrDeleteFlagFileExists: " + r6 + " enable -> " + r5);     // Catch: Throwable -> L15
        PolarisFileWrapper r3 = new PolarisFileWrapper(String.valueOf(r4.getFilesDir()), r6);     // Catch: Throwable -> L15
        if (r5 == true) goto L6;
    L8:
        if (r5 == false) goto L10;
    L12:
        a.e("BootProtectorSettings", "createOrDeleteFlagFileExists: " + r6 + "  do nothing");     // Catch: Throwable -> L15
        Object r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Result.m49constructorimpl(r7);     // Catch: Throwable -> L15
        return;
    L10:
        if (r3.exists() == false) goto L12;
        r7 = Boolean.valueOf(r3.delete());     // Catch: Throwable -> L15
        goto L13
    L6:
        if (r3.exists() == true) goto L8;
        r7 = Boolean.valueOf(r3.createNewFile());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.m49constructorimpl(ResultKt.createFailure(th));
    }
}
