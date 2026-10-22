package cy9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f465949a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Bundle f465950b;

    static {
        f465949a = new a();
    }

    public a() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        f465950b = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String b(Bundle r100) {
        if (r100 == null) goto L6;
        String r101 = r100.getString("ai_creation_applet_path");
        if (r101 == null) goto L6;
        return r101;
    L6:
        if (r100 == null) goto L10;
        Bundle r102 = r100.getBundle("__applet_app_ext_bundle__");
        if (r102 == null) goto L10;
        String r103 = r102.getString("url");
    L11:
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        if (r103.length() != 0) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == true) goto L48;
        String r105 = StringsKt.substringBefore$default(r103, "?", null, 2, null);
        if (Intrinsics.areEqual(r105, "index") == true) goto L40;
        if (StringsKt.startsWith$default(r105, HTTP.URL_DEFAULT, false, 2, null) == true) goto L40;
        MatchResult r106 = Regex.find$default(new Regex("(?:^|[?&])path=([^&]+)"), r103, 0, 2, null);
        if (r106 == null) goto L44;
        List<String> r107 = r106.getGroupValues();
        if (r107 == null) goto L45;
        String r108 = (String) CollectionsKt.getOrNull(r107, 1);
        if (r108 == null) goto L46;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L32
        Object r110 = Result.m9449constructorimpl(URLDecoder.decode(r108, "UTF-8"));     // Catch: Throwable -> L32
    L34:
        Object r111 = r108;
        if (Result.m9455isFailureimpl(r110) == true) goto L47;
        r111 = r110;
    L47:
        return (String) r111;
    L32:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L46:
        return null;
    L45:
        return null;
    L44:
        return null;
    L40:
        return r105;
    L48:
        return null;
    L16:
        r104 = false;
    L10:
        r103 = null;
        goto L11
    }

    public static boolean d(Activity r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getClass().getName();
    L7:
        if (Intrinsics.areEqual(r102, "com.bytedance.ai.applet.app.AppletFullScreenActivity") == false) goto L14;
        Intent r103 = r100.getIntent();
        if (r103 == null) goto L12;
        r101 = r103.getDataString();
    L12:
        if (Intrinsics.areEqual(r101, "db_2UHTeIU") == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    public static boolean e(Bundle r100) {
        if (r100 == null) goto L5;
        Object r101 = r100.get("from_ai_creation_applet");
    L7:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L9;
    L22:
        return true;
    L9:
        if (Intrinsics.areEqual(r101, "1") == true) goto L22;
        if (Intrinsics.areEqual(r101, 1) == true) goto L22;
        if (r100 == null) goto L17;
        Bundle r102 = r100.getBundle("__applet_app_ext_bundle__");
        if (r102 == null) goto L17;
        String r103 = r102.getString("url");
    L18:
        if (r103 != null) goto L21;
        r103 = "";
    L21:
        return StringsKt.contains$default(r103, "from_ai_creation_applet=1", false, 2, null);
    L17:
        r103 = null;
        goto L18
    L5:
        r101 = null;
        goto L7
    }

    public static boolean f(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return true;
    L11:
        if (Intrinsics.areEqual(r100, "index") == false) goto L13;
        return true;
    L13:
        if (Intrinsics.areEqual(r100, "/creation/home") == true) goto L19;
        return false;
    L19:
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static boolean g(Bundle r100) {
        if (e(r100) == true) goto L5;
        return false;
    L5:
        if (r100 == null) goto L7;
        Object r101 = r100.get("ai_creation_applet_is_root_page");
    L9:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L11;
    L23:
        return true;
    L11:
        if (Intrinsics.areEqual(r101, "1") == true) goto L23;
        if (Intrinsics.areEqual(r101, 1) == true) goto L23;
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(r101, "0") == false) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(r101, 0) == false) goto L27;
        return false;
    L27:
        return f(b(r100));
    L7:
        r101 = null;
        goto L9
    }

    public static boolean h(Bundle r100) {
        if (e(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (g(r100) == true) goto L7;
        return true;
    }

    public final synchronized Bundle c(Bundle r100) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        Bundle r101 = null;
        if (e(r100) == true) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (g(r100) == true) goto L11;
    L14:
        Bundle r102 = f465950b;     // Catch: Throwable -> L19
        if (r102 == null) goto L17;
        r101 = new Bundle(r102);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return r101;
    L11:
        if (f(b(r100)) == true) goto L14;
        monitor-exit(this);
        return null;
    }

    public static boolean i(Bundle r100, String r101) {
        if (r100 == null) goto L4;
        Object r102 = r100.get(r101);
    L6:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L8;
        return true;
    L8:
        if (Intrinsics.areEqual(r102, "1") == false) goto L10;
        return true;
    L10:
        if (Intrinsics.areEqual(r102, 1) == true) goto L16;
        return false;
    L16:
        return true;
    L4:
        r102 = null;
        goto L6
    }
}
