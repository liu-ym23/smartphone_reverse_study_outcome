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
import com.bytedance.apm.agent.helper.ApmAgentHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f572783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f572784b = null;

    public a() {
    }

    public static a b() {
        if (f572783a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f572783a != null) goto L9;
        f572783a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f572783a;
    }

    static {
        f572784b = b0.o();
    }

    public static JSONObject c(Map r100) {
        JSONObject r101 = new JSONObject();
        Iterator r102 = ((HashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r101;
    }

    public static String a(int r100, ViewGroup r101) {
        StringBuffer r102 = new StringBuffer();
        if (r101 == null) goto L5;
        int r103 = 0;
    L8:
        if (r103 >= r101.getChildCount()) goto L35;
        View r104 = r101.getChildAt(r103);
        r102.append("|index:");
        r102.append(r100);
        r102.append(r103);
        String r105 = "";
        if ((r104 instanceof TextView) == false) goto L12;
        String r106 = ((TextView) r104).getText().toString();
    L14:
        if (TextUtils.isEmpty(r106) == true) goto L16;
        r102.append("|text:");
        r102.append(r106);
    L16:
        if (r104 == null) goto L18;
        Object r107 = r104.getTag();
    L19:
        if (r107 != null) goto L21;
        String r108 = "";
    L23:
        if (TextUtils.isEmpty(r108) == true) goto L25;
        r102.append("|tag:");
        r102.append(r106);
    L25:
        if (r104 == null) goto L28;
        r105 = (String) r104.getContentDescription();
    L28:
        if (TextUtils.isEmpty(r105) == true) goto L31;
        r102.append("|description:");
        r102.append(r105);
    L31:
        if ((r104 instanceof ViewGroup) == false) goto L33;
        r102.append(a(r103, (ViewGroup) r104));
    L33:
        r103 = r103 + 1;
        goto L8
    L21:
        r108 = String.valueOf(r107);
        goto L23
    L18:
        r107 = "";
        goto L19
    L12:
        r106 = "";
        goto L14
    L35:
        return r102.toString();
    L5:
        return r102.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(LiveVerticalViewPager r110, int r111) {
        if (r110 != 0) goto L5;
        return;
    L5:
        if (r111 == (-1)) goto L100;
        HashMap r100 = new HashMap();
        r100.put("type", "action");     // Catch: Throwable -> L82
        r100.put("action", "ViewPage#onPageSelected()");     // Catch: Throwable -> L82
        r100.put("class_name", r110.toString());     // Catch: Throwable -> L82
        StringBuffer r101 = new StringBuffer();     // Catch: Throwable -> L82
        String r102 = (String) r110.getTag(ApmAgentHelper.VIEW_DATA_KEY_1);     // Catch: Throwable -> L82
        if (r102 == null) goto L12;
        r101.append("page_name:");     // Catch: Throwable -> L82
        r101.append(r102);     // Catch: Throwable -> L82
    L12:
        ViewParent r103 = r110.getParent();     // Catch: Throwable -> L82
    L14:
        if (r103.getParent() == null) goto L23;
        if ((r103 instanceof View) == false) goto L23;
        if (TextUtils.isEmpty(r102) == false) goto L23;
        View r104 = (View) r103;     // Catch: Throwable -> L82
        if (r104.getTag(ApmAgentHelper.VIEW_DATA_KEY_1) != null) goto L21;
        r103 = r103.getParent();     // Catch: Throwable -> L82
        goto L14
    L21:
        String r105 = (String) r104.getTag(ApmAgentHelper.VIEW_DATA_KEY_1);     // Catch: Throwable -> L82
        r101.append("page_name:");     // Catch: Throwable -> L82
        r101.append(r105);     // Catch: Throwable -> L82
    L23:
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L82
        String r107 = "";
        if (r110.getId() > 0) goto L27;
    L31:
        String r108 = "";
    L33:
        if (TextUtils.isEmpty(r108) == true) goto L35;
        r100.put("id", r108);     // Catch: Throwable -> L82
        r101.append("|id:");     // Catch: Throwable -> L82
        r101.append(r108);     // Catch: Throwable -> L82
        boolean r109 = false;
    L38:
        if (r110.getParent() == null) goto L51;
        if ((r110.getParent() instanceof RecyclerView) == false) goto L46;
        int r112 = ((RecyclerView) r110.getParent()).indexOfChild(r110);     // Catch: Throwable -> L82
        r101.append("|RecyclerView");     // Catch: Throwable -> L82
        r101.append("|position:");     // Catch: Throwable -> L82
        r101.append(r112);     // Catch: Throwable -> L82
        r106.put("position", r112);     // Catch: Exception -> L79 Throwable -> L82
    L44:
        f(r106, "children_info", a(0, r110));     // Catch: Throwable -> L82
        goto L51
    L46:
        if ((r110.getParent() instanceof ListView) == false) goto L51;
        int r113 = ((ListView) r110.getParent()).indexOfChild(r110);     // Catch: Throwable -> L82
        r101.append("|ListView");     // Catch: Throwable -> L82
        r101.append("|position:");     // Catch: Throwable -> L82
        r101.append(r113);     // Catch: Throwable -> L82
        r106.put("position", r113);     // Catch: Exception -> L80 Throwable -> L82
    L49:
        f(r106, "children_info", a(0, r110));     // Catch: Throwable -> L82
    L51:
        if ((r110 instanceof TextView) == false) goto L53;
        String r114 = ((TextView) r110).getText().toString();     // Catch: Throwable -> L82
    L55:
        if (TextUtils.isEmpty(r114) == true) goto L57;
        f(r106, "text", r114);     // Catch: Throwable -> L82
        r101.append("|text:");     // Catch: Throwable -> L82
        r101.append(r114);     // Catch: Throwable -> L82
        r109 = false;
    L57:
        Object r115 = r110.getTag();     // Catch: Throwable -> L82
        if (r115 == null) goto L62;
        r107 = String.valueOf(r115);     // Catch: Throwable -> L82
    L62:
        if (TextUtils.isEmpty(r107) == true) goto L64;
        f(r106, "tag", r107);     // Catch: Throwable -> L82
        r101.append("|tag:");     // Catch: Throwable -> L82
        r101.append(r107);     // Catch: Throwable -> L82
        r109 = false;
    L64:
        String r116 = (String) r110.getContentDescription();     // Catch: Throwable -> L82
        if (TextUtils.isEmpty(r116) == true) goto L68;
        f(r106, "description", r116);     // Catch: Throwable -> L82
        r101.append("|description:");     // Catch: Throwable -> L82
        r101.append(r116);     // Catch: Throwable -> L82
        r109 = false;
    L68:
        if (r106.length() <= 0) goto L70;
        r109 = false;
    L70:
        if (r109 == false) goto L72;
        f(r106, "children_info", a(0, r110));     // Catch: Throwable -> L82
    L72:
        r100.put("params", r106.toString());     // Catch: Throwable -> L82
        r100.put("path", r101.toString());     // Catch: Throwable -> L82
        goto L73
    L53:
        r114 = "";
        goto L55
    L35:
        r109 = true;
        goto L38
    L27:
        if (r110.getContext() == null) goto L31;
        r108 = "R.id." + r110.getContext().getResources().getResourceEntryName(r110.getId());     // Catch: Exception -> L81 Throwable -> L82
    L73:
        JSONObject r117 = c(r100);
        r117.put("position", r111);     // Catch: Exception -> L83
    L75:
        f(r117, "description", "room scroll change");
        b0 r118 = f572784b;
        String r119 = TTLiveALogTag.Page.info;
        r118.getClass();
        if (TextUtils.isEmpty(r119) == true) goto L99;
        ALogger.d(r119, new f(r118, r119, r117));
        return;
    L99:
        return;
    }

    public static void f(JSONObject r100, String r101, String r102) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.put(r101, r102);     // Catch: Exception -> L6
        return;
    }

    public static void d(String r100, String r101, int r102, JSONObject r103) {
        if (r103 != null) goto L17;
        return;
    L17:
        JSONObject r104 = new JSONObject(r103.toString());     // Catch: Exception -> L7
    L8:
        if (r104 != null) goto L10;
        return;
    L10:
        f(r104, "service", r101);
        r104.put("status_code", r102);     // Catch: Exception -> L16
    L12:
        b0 r105 = f572784b;
        r105.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L21;
        ALogger.d(r100, new f(r105, r100, r104));
        return;
    L21:
        return;
    L7:
        r104 = null;
        goto L8
    }
}
