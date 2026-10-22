package l17;

import com.bytedance.lynx.webview.internal.DownloadEventType;
import com.bytedance.lynx.webview.internal.LibraryLoader;
import com.bytedance.lynx.webview.internal.LoadEventType;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StringBuffer f506991a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f506992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f506993c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadEventType f506994a;

        @Override // java.lang.Runnable
        public final void run() {
            b.f506991a.append(this.f506994a.getStatusCode() + "-");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LoadEventType r100) {
            this.f506994a = r100;
        }
    }

    static {
        f506991a = new StringBuffer();
        f506992b = false;
        f506993c = false;
    }

    public static String c() {
        ArrayList r100 = new ArrayList();
        String[] r101 = "".split("-");     // Catch: Exception -> L21
        int r102 = r101.length;     // Catch: Exception -> L21
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L24;
        String r104 = r101[r103];     // Catch: Exception -> L21
        if (r104 == null) goto L20;
        if (r104.equals("") == true) goto L20;
        int r105 = 0;
    L11:
        if (r105 >= r104.length()) goto L19;
        if (r104.charAt(r105) > '9') goto L18;
        if (r104.charAt(r105) < '0') goto L18;
        r105 = r105 + 1;     // Catch: Exception -> L21
    L18:
        return "Failed";
    L19:
        r100.add(DownloadEventType.getDownloadEventType(CastIntegerProtector.parseInt(r104)));     // Catch: Exception -> L21
    L20:
        r103 = r103 + 1;
    L24:
        if (r100.size() < 2) goto L57;
        DownloadEventType r106 = (DownloadEventType) ListProtector.get(r100, r100.size() - 1);
        DownloadEventType r107 = (DownloadEventType) ListProtector.get(r100, r100.size() - 2);
        if (r106 == null) goto L55;
        if (r107 != null) goto L31;
        return "Failed";
    L31:
        if (DownloadEventType.isSucessStatus(r106.name()) == false) goto L36;
        if (DownloadEventType.isSucessStatus(r107.name()) == false) goto L36;
        return "Success";
    L36:
        if (r106 != DownloadEventType.Prepare_download_end) goto L38;
        int r108 = r107.ordinal();
    L44:
        return "Not reach " + DownloadEventType.getDownloadEventTypeByIndex(r108 + 1).name();
    L41:
        e = move-exception;
        e.toString();
        return null;
    L38:
        r108 = r106.ordinal();
        goto L44
    L55:
        return "Failed";
    L57:
        return "Failed";
    L21:
        e = move-exception;
        e.toString();
        goto L24
    }

    public static String b() {
        int r100 = TTWebContext.h().p().f265273b.getInt("enable_ttwebview_status", -1);
        if (r100 == (-1)) goto L13;
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return "";
    L10:
        if (f506993c == false) goto L12;
        return " and setting-switch is off from PreVersion";
    L12:
        return " and setting-switch is off";
    L13:
        return " and not get setting";
    }

    public static void a(LoadEventType r100) {
        TTWebContext.C(new a(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String d(String r100) {
        ArrayList r101 = new ArrayList();
        char r102 = 0;
        String[] r103 = r100.split("-");     // Catch: Exception -> L21
        int r104 = r103.length;     // Catch: Exception -> L21
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L24;
        String r106 = r103[r105];     // Catch: Exception -> L21
        if (r106 == null) goto L20;
        if (r106.equals("") == true) goto L20;
        int r107 = 0;
    L11:
        if (r107 >= r106.length()) goto L19;
        if (r106.charAt(r107) > '9') goto L18;
        if (r106.charAt(r107) < '0') goto L18;
        r107 = r107 + 1;     // Catch: Exception -> L21
    L18:
        return "Failed";
    L19:
        r101.add(LoadEventType.getLoadEventType(CastIntegerProtector.parseInt(r106)));     // Catch: Exception -> L21
    L20:
        r105 = r105 + 1;
    L24:
        if (r101.size() < 2) goto L84;
        LoadEventType r108 = (LoadEventType) ListProtector.get(r101, r101.size() - 2);
        if (r108 != null) goto L30;
        return "Failed";
    L30:
        if (LoadEventType.isSucessStatus(r108.name()) == false) goto L32;
        return "Success";
    L32:
        int r109 = r108.getStatusCode();
        String r110 = null;
        if (r109 != LoadEventType.LoadPreCheck_first_download.getStatusCode()) goto L35;
    L73:
        return "so not exits and " + LoadEventType.getLoadEventType(r109).name();
    L64:
        e = move-exception;
        e.toString();
        return null;
    L35:
        if (r109 == LoadEventType.LoadPreCheck_not_first_download.getStatusCode()) goto L73;
        String r111 = LoadEventType.getLoadEventTypeByIndex(r108.ordinal() + 1).name();     // Catch: NullPointerException -> L59
    L57:
        e = e;
    L61:
        e.toString();
        return r111;
    L39:
        if (r111.equals(LoadEventType.CheckSwitch_enable_ttwebview.name()) == false) goto L42;
        r111 = r111 + b();     // Catch: NullPointerException -> L57
    L42:
        if (r111.equals(LoadEventType.DoCrossProcessInitialization_load_ttwebview.name()) == false) goto L55;
        StringBuilder r112 = new StringBuilder();     // Catch: NullPointerException -> L57
        r112.append(r111);     // Catch: NullPointerException -> L57
        if (LibraryLoader.f265130q.get().booleanValue() == false) goto L46;
        r102 = 2;
    L46:
        boolean r113 = r102 | (LibraryLoader.f265131r.get().booleanValue() ? 1 : 0);     // Catch: NullPointerException -> L57
        if (r113 == 0) goto L53;
        if (r113 == 1) goto L52;
        if (r113 != 2) goto L54;
        r110 = " and get setting in self-process";
    L54:
        r112.append(r110);     // Catch: NullPointerException -> L57
        r111 = r112.toString();     // Catch: NullPointerException -> L57
        goto L55
    L52:
        r110 = " and get setting cross process";
        goto L54
    L53:
        r110 = " and get contentlock failed";
    L55:
        return "Not Pass " + r111;
    L59:
        e = e;
        r111 = null;
        goto L61
    L84:
        return "Failed";
    L21:
        e = move-exception;
        e.toString();
        goto L24
    }
}
