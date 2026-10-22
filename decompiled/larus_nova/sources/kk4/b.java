package kk4;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.facebook.keyframes.model.KFImage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f503781a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C6566b f503782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f503783b;

        public static JSONObject a(a r100) throws JSONException {
            r100.getClass();
            JSONObject r101 = new JSONObject();
            C6566b r102 = r100.f503782a;
            if (r102 == null) goto L11;
            JSONObject r103 = new JSONObject();
            d r104 = r102.f503784a;
            if (r104 == null) goto L10;
            JSONObject r105 = new JSONObject();
            b.a(r105, "enable", r104.f503786a);
            if (r104.f503787b == null) goto L9;
            r105.put("support_link", new JSONArray(r104.f503787b));
        L9:
            r103.put("rtc", r105);
        L10:
            r101.put("capabilities", r103);
        L11:
            c r106 = r100.f503783b;
            if (r106 == null) goto L17;
            JSONObject r107 = new JSONObject();
            e r108 = r106.f503785a;
            if (r108 == null) goto L16;
            JSONObject r109 = new JSONObject();
            b.a(r109, "enable", r108.f503788a);
            b.a(r109, "show_entrance", r108.f503789b);
            b.a(r109, NotificationCompat.CATEGORY_TRANSPORT, r108.f503790c);
            b.a(r109, "control_mode", r108.f503791d);
            b.a(r109, "active_link", r108.f503792e);
            r107.put("video_streaming", r109);
        L16:
            r101.put(KFImage.FEATURES_JSON_FIELD, r107);
        L17:
            return r101;
        }

        public static a b(JSONObject r110) {
            c r100 = null;
            e r101 = null;
            if (r110 == null) goto L41;
            JSONObject r102 = r110.optJSONObject("capabilities");
            if (r102 != null) goto L8;
            C6566b r103 = null;
        L28:
            JSONObject r111 = r110.optJSONObject(KFImage.FEATURES_JSON_FIELD);
            if (r111 == null) goto L37;
            JSONObject r112 = r111.optJSONObject("video_streaming");
            if (r112 == null) goto L35;
            r101 = new e(b.b(r112, "enable"), b.b(r112, "show_entrance"), b.c(r112, NotificationCompat.CATEGORY_TRANSPORT), b.c(r112, "control_mode"), b.c(r112, "active_link"));
        L35:
            r100 = new c(r101);
        L37:
            return new a(r103, r100);
        L8:
            JSONObject r104 = r102.optJSONObject("rtc");
            if (r104 != null) goto L11;
            d r105 = null;
        L27:
            r103 = new C6566b(r105);
            goto L28
        L11:
            Boolean r106 = b.b(r104, "enable");
            if (b.e(r104, "support_link") == true) goto L14;
            ArrayList r107 = null;
        L26:
            r105 = new d(r106, r107);
            goto L27
        L14:
            JSONArray r108 = r104.optJSONArray("support_link");
            r107 = new ArrayList();
            if (r108 == null) goto L26;
            int r109 = 0;
        L19:
            if (r109 >= r108.length()) goto L26;
            String r113 = r108.optString(r109, null);
            if ("spp".equals(r113) == false) goto L23;
        L24:
            r107.add(r113);
        L25:
            r109 = r109 + 1;
            goto L19
        L23:
            if ("p2p".equals(r113) == false) goto L25;
        L41:
            return null;
        }

        public a(C6566b r100, c r101) {
            c r102 = null;
            if (r100 == null) goto L5;
            C6566b r103 = new C6566b(r100.f503784a);
        L6:
            this.f503782a = r103;
            if (r101 == null) goto L9;
            r102 = new c(r101.f503785a);
        L9:
            this.f503783b = r102;
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: kk4.b$b, reason: collision with other inner class name */
    public static class C6566b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f503784a;

        public C6566b(d r100) {
            if (r100 == null) goto L5;
            d r101 = new d(r100.f503786a, r100.f503787b);
        L6:
            this.f503784a = r101;
            return;
        L5:
            r101 = null;
            goto L6
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f503785a;

        public c(e r100) {
            if (r100 == null) goto L5;
            e r101 = new e(r100.f503788a, r100.f503789b, r100.f503790c, r100.f503791d, r100.f503792e);
        L6:
            this.f503785a = r101;
            return;
        L5:
            r101 = null;
            goto L6
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f503786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f503787b;

        public d(Boolean r100, List<String> r101) {
            this.f503786a = r100;
            if (r101 == null) goto L5;
            ArrayList r102 = new ArrayList(r101);
        L6:
            this.f503787b = r102;
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f503788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f503789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f503790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f503791d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f503792e;

        public e(Boolean r100, Boolean r101, String r102, String r103, String r104) {
            this.f503788a = r100;
            this.f503789b = r101;
            this.f503790c = r102;
            this.f503791d = r103;
            this.f503792e = r104;
        }
    }

    public final boolean d() {
        a r100 = this.f503781a;
        if (r100 == null) goto L45;
        C6566b r101 = r100.f503782a;
        if (r101 == null) goto L19;
        d r102 = r101.f503784a;
        if (r102 != null) goto L9;
    L17:
        boolean r103 = false;
    L18:
        if (r103 == false) goto L19;
    L40:
        boolean r104 = true;
    L42:
        if (r104 == false) goto L46;
        return true;
    L46:
        return false;
    L9:
        if (r102.f503786a == null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L17;
        r103 = true;
        goto L18
    L11:
        if (r102.f503787b != null) goto L14;
        r105 = false;
    L19:
        c r106 = r100.f503783b;
        if (r106 == null) goto L41;
        e r107 = r106.f503785a;
        if (r107 != null) goto L24;
    L38:
        boolean r108 = false;
    L39:
        if (r108 == false) goto L41;
    L24:
        if (r107.f503788a == null) goto L26;
    L35:
        boolean r109 = true;
    L36:
        if (r109 == false) goto L38;
        r108 = true;
        goto L39
    L26:
        if (r107.f503789b != null) goto L35;
        if (r107.f503790c != null) goto L35;
        if (r107.f503791d != null) goto L35;
        if (r107.f503792e != null) goto L35;
        r109 = false;
    L41:
        r104 = false;
        goto L42
    L45:
        return false;
    }

    public b(a r100) {
        if (r100 == null) goto L5;
        a r101 = new a(r100.f503782a, r100.f503783b);
    L6:
        this.f503781a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static Boolean b(JSONObject r100, String r101) {
        if (e(r100, r101) == false) goto L8;
        Object r102 = r100.opt(r101);
        if ((r102 instanceof Boolean) == false) goto L8;
        return (Boolean) r102;
    L8:
        return null;
    }

    public static String c(JSONObject r100, String r101) {
        if (e(r100, r101) == false) goto L10;
        String r102 = r100.optString(r101, null);
        if (TextUtils.isEmpty(r102) == false) goto L9;
        return null;
    L9:
        return r102;
    L10:
        return null;
    }

    public static boolean e(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.isNull(r101) == true) goto L7;
        return true;
    }

    public static void a(JSONObject r100, String r101, Object r102) throws JSONException {
        if (r102 == null) goto L5;
        r100.put(r101, r102);
        return;
    }
}
