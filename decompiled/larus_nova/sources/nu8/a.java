package nu8;

import android.text.TextUtils;
import android.util.Log;
import com.larus.bootprotector.IBootProtectorLauncher;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxError;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb2.c;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f520610a = null;

    static {
        IBootProtectorLauncher.f317602a.getClass();
        IBootProtectorLauncher.a.b().isDebug();
        f520610a = System.getProperty("line.separator");
    }

    @JvmStatic
    public static final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        FLogger r101 = FLogger.f375446a;
        if (r101.a() == false) goto L6;
        r101.i("bootprotector", r100);
        return;
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "text");
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        String r103 = String.format("%s %s", Arrays.copyOf(new Object[]{r100, r101}, 2));
        FLogger r104 = FLogger.f375446a;
        if (r104.a() == false) goto L6;
        r104.d("bootprotector", r103);
        return;
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "text");
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        String r103 = String.format("%s %s", Arrays.copyOf(new Object[]{r100, r101}, 2));
        FLogger r104 = FLogger.f375446a;
        if (r104.a() == false) goto L6;
        r104.e("bootprotector", r103);
        return;
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "text");
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        String r103 = String.format("%s %s", Arrays.copyOf(new Object[]{r100, r101}, 2));
        FLogger r104 = FLogger.f375446a;
        if (r104.a() == false) goto L6;
        r104.i("bootprotector", r103);
        return;
    }

    public static void g(String r100, String r110) {
        Intrinsics.checkNotNullParameter("BootProtectorLandingAct", "tag");
        int r101 = 0;
        if (r100 != null) goto L20;
    L11:
        r100 = "";
    L12:
        h("BootProtectorLandingAct", "╔═══════════════════════════════════════════════════════════════════════════════════════");
        StringBuilder r102 = new StringBuilder();
        r102.append(r110);
        String r111 = f520610a;
        r102.append(r111);
        r102.append(r100);
        String r103 = r102.toString();
        if (TextUtils.isEmpty(r111) == true) goto L17;
        String[] r104 = (String[]) StringsKt.split$default(r103, new String[]{r111}, false, 0, 6, null).toArray(new String[0]);
        int r112 = r104.length;
    L15:
        if (r101 >= r112) goto L17;
        h("BootProtectorLandingAct", "║ " + r104[r101]);
        r101 = r101 + 1;
    L17:
        h("BootProtectorLandingAct", "╚═══════════════════════════════════════════════════════════════════════════════════════");
        return;
    L20:
        if (StringsKt.startsWith$default(r100, "{", false, 2, null) == false) goto L8;
        r100 = new JSONObject(r100).toString(4);     // Catch: JSONException -> L19
    L10:
        if (r100 != null) goto L12;
    L8:
        if (StringsKt.startsWith$default(r100, "[", false, 2, null) == false) goto L10;
        r100 = new JSONArray(r100).toString(4);     // Catch: JSONException -> L19
        goto L10
    }

    @JvmStatic
    public static final void h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "text");
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        String r103 = String.format("%s %s", Arrays.copyOf(new Object[]{r100, r101}, 2));
        FLogger r104 = FLogger.f375446a;
        if (r104.a() == false) goto L6;
        r104.w("bootprotector", r103);
        return;
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        String r104 = String.format("%s %s", Arrays.copyOf(new Object[]{r100, r101}, 2));
        FLogger r105 = FLogger.f375446a;
        if (r105.a() == false) goto L6;
        r105.e("bootprotector", r104, r102);
        return;
    }

    @JvmStatic
    public static final void f(String r100, Throwable r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "tr");
        b(r100, r102 + c.DEFAULT_TEXT + Log.getStackTraceString(r101));
    }
}
