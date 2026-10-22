package f96;

import com.ss.android.agilelogger.ALog;
import java.util.Map;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f475971a = 0;

    public a() {
    }

    static {
    }

    public static String c(String r100) {
        StringBuilder r101 = new StringBuilder("HybridLogger");
        if (StringsKt.isBlank(r100) == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101.append("_");
        r101.append(r100);
    L9:
        return r101.toString();
    L5:
        r102 = false;
        goto L6
    }

    public static String b(String r100, Map r101) {
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return r100;
    L11:
        StringBuffer r104 = new StringBuffer(r100);
        if (r101 != null) goto L14;
    L17:
        if (r102 == true) goto L20;
        r104.append("|xParam:");
        r104.append(new JSONObject(r101).toString());
    L20:
        return r104.toString();
    L14:
        if (r101.isEmpty() == true) goto L17;
        r102 = false;
        goto L17
    L5:
        if (r101.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public static void e(String r100, Map r101) {
        ALog.w(c("interactive_predefine"), b(r100, r101));
    }

    public static void a(String r100, String r101, Map r102) {
        ALog.e(c(r100), b(r101, r102));
    }

    public static void d(String r100, String r101, Map r102) {
        ALog.i(c(r100), b(r101, r102));
    }
}
