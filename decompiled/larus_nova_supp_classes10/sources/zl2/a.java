package zl2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.log.f;
import com.bytedance.android.livesdk.log.alog.TTLiveALogTag;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static volatile a a;
    public static final b0 b = null;

    public a() {
    }

    public static a b() {
        if (a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    static {
        b = b0.o();
    }

    public static JSONObject c(Map r3) {
        JSONObject r0 = new JSONObject();
        Iterator r4 = ((HashMap) r3).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r4.next();
        r0.put((String) r1.getKey(), r1.getValue());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r0;
    }

    public static String a(int r6, ViewGroup r7) {
        StringBuffer r0 = new StringBuffer();
        if (r7 == null) goto L5;
        int r1 = 0;
    L8:
        if (r1 >= r7.getChildCount()) goto L35;
        View r2 = r7.getChildAt(r1);
        r0.append("|index:");
        r0.append(r6);
        r0.append(r1);
        String r4 = "";
        if ((r2 instanceof TextView) == false) goto L12;
        String r3 = ((TextView) r2).getText().toString();
    L14:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        r0.append("|text:");
        r0.append(r3);
    L16:
        if (r2 == null) goto L18;
        Object r5 = r2.getTag();
    L19:
        if (r5 != null) goto L21;
        String r8 = "";
    L23:
        if (TextUtils.isEmpty(r8) == true) goto L25;
        r0.append("|tag:");
        r0.append(r3);
    L25:
        if (r2 == null) goto L28;
        r4 = (String) r2.getContentDescription();
    L28:
        if (TextUtils.isEmpty(r4) == true) goto L31;
        r0.append("|description:");
        r0.append(r4);
    L31:
        if ((r2 instanceof ViewGroup) == false) goto L33;
        r0.append(a(r1, (ViewGroup) r2));
    L33:
        r1 = r1 + 1;
        goto L8
    L21:
        r8 = String.valueOf(r5);
        goto L23
    L18:
        r5 = "";
        goto L19
    L12:
        r3 = "";
        goto L14
    L35:
        return r0.toString();
    L5:
        return r0.toString();
    }

    public static void e(LiveVerticalViewPager r12, int r13) {
        if (r12 != null) goto L5;
        return;
    L5:
        if (r13 == (-1)) goto L100;
        HashMap r4 = new HashMap();
        r4.put(LocationMonitorConst.TYPE, "action");     // Catch: Throwable -> L82
        r4.put("action", "ViewPage#onPageSelected()");     // Catch: Throwable -> L82
        r4.put("class_name", r12.toString());     // Catch: Throwable -> L82
        StringBuffer r2 = new StringBuffer();     // Catch: Throwable -> L82
        String r5 = (String) r12.getTag(-16777215);     // Catch: Throwable -> L82
        if (r5 == null) goto L12;
        r2.append("page_name:");     // Catch: Throwable -> L82
        r2.append(r5);     // Catch: Throwable -> L82
    L12:
        ViewParent r7 = r12.getParent();     // Catch: Throwable -> L82
    L14:
        if (r7.getParent() == null) goto L23;
        if ((r7 instanceof View) == false) goto L23;
        if (TextUtils.isEmpty(r5) == false) goto L23;
        View r8 = (View) r7;     // Catch: Throwable -> L82
        if (r8.getTag(-16777215) != null) goto L21;
        r7 = r7.getParent();     // Catch: Throwable -> L82
        goto L14
    L21:
        String r3 = (String) r8.getTag(-16777215);     // Catch: Throwable -> L82
        r2.append("page_name:");     // Catch: Throwable -> L82
        r2.append(r3);     // Catch: Throwable -> L82
    L23:
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L82
        String r9 = "";
        if (r12.getId() > 0) goto L27;
    L31:
        String r10 = "";
    L33:
        if (TextUtils.isEmpty(r10) == true) goto L35;
        r4.put("id", r10);     // Catch: Throwable -> L82
        r2.append("|id:");     // Catch: Throwable -> L82
        r2.append(r10);     // Catch: Throwable -> L82
        boolean r11 = false;
    L38:
        if (r12.getParent() == null) goto L51;
        if ((r12.getParent() instanceof RecyclerView) == false) goto L46;
        int r14 = r12.getParent().indexOfChild(r12);     // Catch: Throwable -> L82
        r2.append("|RecyclerView");     // Catch: Throwable -> L82
        r2.append("|position:");     // Catch: Throwable -> L82
        r2.append(r14);     // Catch: Throwable -> L82
        r6.put("position", r14);     // Catch: Exception -> L79 Throwable -> L82
    L44:
        f(r6, "children_info", a(0, r12));     // Catch: Throwable -> L82
        goto L51
    L46:
        if ((r12.getParent() instanceof ListView) == false) goto L51;
        int r15 = ((ListView) r12.getParent()).indexOfChild(r12);     // Catch: Throwable -> L82
        r2.append("|ListView");     // Catch: Throwable -> L82
        r2.append("|position:");     // Catch: Throwable -> L82
        r2.append(r15);     // Catch: Throwable -> L82
        r6.put("position", r15);     // Catch: Exception -> L80 Throwable -> L82
    L49:
        f(r6, "children_info", a(0, r12));     // Catch: Throwable -> L82
    L51:
        if ((r12 instanceof TextView) == false) goto L53;
        String r16 = ((TextView) r12).getText().toString();     // Catch: Throwable -> L82
    L55:
        if (TextUtils.isEmpty(r16) == true) goto L57;
        f(r6, "text", r16);     // Catch: Throwable -> L82
        r2.append("|text:");     // Catch: Throwable -> L82
        r2.append(r16);     // Catch: Throwable -> L82
        r11 = false;
    L57:
        Object r17 = r12.getTag();     // Catch: Throwable -> L82
        if (r17 == null) goto L62;
        r9 = String.valueOf(r17);     // Catch: Throwable -> L82
    L62:
        if (TextUtils.isEmpty(r9) == true) goto L64;
        f(r6, LocationMonitorConst.TAG, r9);     // Catch: Throwable -> L82
        r2.append("|tag:");     // Catch: Throwable -> L82
        r2.append(r9);     // Catch: Throwable -> L82
        r11 = false;
    L64:
        String r18 = (String) r12.getContentDescription();     // Catch: Throwable -> L82
        if (TextUtils.isEmpty(r18) == true) goto L68;
        f(r6, "description", r18);     // Catch: Throwable -> L82
        r2.append("|description:");     // Catch: Throwable -> L82
        r2.append(r18);     // Catch: Throwable -> L82
        r11 = false;
    L68:
        if (r6.length() <= 0) goto L70;
        r11 = false;
    L70:
        if (r11 == false) goto L72;
        f(r6, "children_info", a(0, r12));     // Catch: Throwable -> L82
    L72:
        r4.put("params", r6.toString());     // Catch: Throwable -> L82
        r4.put("path", r2.toString());     // Catch: Throwable -> L82
        goto L73
    L53:
        r16 = "";
        goto L55
    L35:
        r11 = true;
        goto L38
    L27:
        if (r12.getContext() == null) goto L31;
        r10 = "R.id." + r12.getContext().getResources().getResourceEntryName(r12.getId());     // Catch: Exception -> L81 Throwable -> L82
    L73:
        JSONObject r19 = c(r4);
        r19.put("position", r13);     // Catch: Exception -> L83
    L75:
        f(r19, "description", "room scroll change");
        b0 r110 = b;
        String r0 = TTLiveALogTag.Page.info;
        r110.getClass();
        if (TextUtils.isEmpty(r0) == true) goto L99;
        ALogger.d(r0, new f(r110, r0, r19));
        return;
    L99:
        return;
    }

    public static void f(JSONObject r0, String r1, String r2) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.put(r1, r2);     // Catch: Exception -> L6
        return;
    }

    public static void d(String r1, String r2, int r3, JSONObject r4) {
        if (r4 != null) goto L17;
        return;
    L17:
        JSONObject r0 = new JSONObject(r4.toString());     // Catch: Exception -> L7
    L8:
        if (r0 != null) goto L10;
        return;
    L10:
        f(r0, "service", r2);
        r0.put("status_code", r3);     // Catch: Exception -> L16
    L12:
        b0 r5 = b;
        r5.getClass();
        if (TextUtils.isEmpty(r1) == true) goto L21;
        ALogger.d(r1, new f(r5, r1, r0));
        return;
    L21:
        return;
    L7:
        r0 = null;
        goto L8
    }
}
