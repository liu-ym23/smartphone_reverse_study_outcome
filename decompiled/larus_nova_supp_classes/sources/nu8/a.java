package nu8;

import android.text.TextUtils;
import android.util.Log;
import com.larus.bootprotector.IBootProtectorLauncher;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final String a = null;

    static {
        IBootProtectorLauncher.a.getClass();
        IBootProtectorLauncher.a.b().isDebug();
        a = System.getProperty("line.separator");
    }

    @JvmStatic
    public static final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        FLogger r0 = FLogger.a;
        if (r0.a() == false) goto L6;
        r0.i("bootprotector", r2);
        return;
    }

    @JvmStatic
    public static final void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "text");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r5 = String.format("%s %s", Arrays.copyOf(new Object[]{r3, r4}, 2));
        FLogger r6 = FLogger.a;
        if (r6.a() == false) goto L6;
        r6.d("bootprotector", r5);
        return;
    }

    @JvmStatic
    public static final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "text");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r5 = String.format("%s %s", Arrays.copyOf(new Object[]{r3, r4}, 2));
        FLogger r6 = FLogger.a;
        if (r6.a() == false) goto L6;
        r6.e("bootprotector", r5);
        return;
    }

    @JvmStatic
    public static final void e(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "text");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r5 = String.format("%s %s", Arrays.copyOf(new Object[]{r3, r4}, 2));
        FLogger r6 = FLogger.a;
        if (r6.a() == false) goto L6;
        r6.i("bootprotector", r5);
        return;
    }

    public static void g(String r9, String r10) {
        Intrinsics.checkNotNullParameter("BootProtectorLandingAct", "tag");
        int r0 = 0;
        if (r9 != null) goto L20;
    L11:
        r9 = XmlPullParser.NO_NAMESPACE;
    L12:
        h("BootProtectorLandingAct", "╔═══════════════════════════════════════════════════════════════════════════════════════");
        StringBuilder r2 = new StringBuilder();
        r2.append(r10);
        String r11 = a;
        r2.append(r11);
        r2.append(r9);
        String r3 = r2.toString();
        if (TextUtils.isEmpty(r11) == true) goto L17;
        String[] r12 = (String[]) StringsKt.split$default(r3, new String[]{r11}, false, 0, 6, null).toArray(new String[0]);
        int r13 = r12.length;
    L15:
        if (r0 >= r13) goto L17;
        h("BootProtectorLandingAct", "║ " + r12[r0]);
        r0 = r0 + 1;
    L17:
        h("BootProtectorLandingAct", "╚═══════════════════════════════════════════════════════════════════════════════════════");
        return;
    L20:
        if (StringsKt.startsWith$default(r9, "{", false, 2, null) == false) goto L8;
        r9 = new JSONObject(r9).toString(4);     // Catch: JSONException -> L19
    L10:
        if (r9 != null) goto L12;
    L8:
        if (StringsKt.startsWith$default(r9, "[", false, 2, null) == false) goto L10;
        r9 = new JSONArray(r9).toString(4);     // Catch: JSONException -> L19
        goto L10
    }

    @JvmStatic
    public static final void h(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "text");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r5 = String.format("%s %s", Arrays.copyOf(new Object[]{r3, r4}, 2));
        FLogger r6 = FLogger.a;
        if (r6.a() == false) goto L6;
        r6.w("bootprotector", r5);
        return;
    }

    @JvmStatic
    public static final void c(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "msg");
        Intrinsics.checkNotNullParameter(r5, "throwable");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r6 = String.format("%s %s", Arrays.copyOf(new Object[]{r3, r4}, 2));
        FLogger r7 = FLogger.a;
        if (r7.a() == false) goto L6;
        r7.e("bootprotector", r6, r5);
        return;
    }

    @JvmStatic
    public static final void f(String r1, Throwable r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "tr");
        b(r1, r3 + "  " + Log.getStackTraceString(r2));
    }
}
