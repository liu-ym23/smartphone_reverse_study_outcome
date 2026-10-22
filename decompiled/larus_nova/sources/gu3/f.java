package gu3;

import androidx.camera.video.AudioStats;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements fu3.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fu3.f f482771a;

    public class a implements hu3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f482772a;

        public a(f r100) {
            this.f482772a = r100;
        }

        @Override // hu3.b
        public final void a(JSONObject r210) {
            f r100 = this.f482772a;
            r100.getClass();
            if (r210 != null) goto L87;
            return;
        L87:
            JSONObject r101 = r210.optJSONObject("performance_modules").optJSONObject("frequency");     // Catch: Throwable -> L8
        L9:
            if (r101 != null) goto L12;
            return;
        L12:
            if (r101.optInt("enable_frequency_monitor", 0) != 1) goto L14;
            boolean r102 = true;
        L16:
            if (r101.optInt("enable_exception_monitor", 0) != 1) goto L18;
            boolean r103 = true;
        L19:
            int r104 = r101.optInt("front_exception_check_interval", 0);
            int r105 = r101.optInt("background_exception_check_interval", 0);
            JSONObject r106 = r101.optJSONObject("front_exception_threshold_per_min");
            if (r106 == null) goto L25;
            HashMap r110 = new HashMap();
            Iterator<String> r111 = r106.keys();
        L23:
            if (r111.hasNext() == false) goto L26;
            String r112 = r111.next();
            r110.put(r112, Float.valueOf((float) r106.optDouble(r112, AudioStats.AUDIO_AMPLITUDE_NONE)));
        L26:
            JSONObject r107 = r101.optJSONObject("background_exception_threshold_per_min");
            if (r107 == null) goto L32;
            HashMap r108 = new HashMap();
            Iterator<String> r109 = r107.keys();
        L30:
            if (r109.hasNext() == false) goto L33;
            String r113 = r109.next();
            r108.put(r113, Float.valueOf((float) r107.optDouble(r113, AudioStats.AUDIO_AMPLITUDE_NONE)));
        L33:
            int r114 = r101.optInt("exception_report_top_count", 0);
            int r115 = r101.optInt("report_interval", 0);
            int r116 = r101.optInt("event_sampling_rate", 10000);
            JSONObject r117 = r101.optJSONObject("front_report_threshold_per_min");
            if (r117 == null) goto L40;
            HashMap r118 = new HashMap();
            Iterator<String> r119 = r117.keys();
        L37:
            if (r119.hasNext() == false) goto L39;
            String r120 = r119.next();
            boolean r121 = r102;
            r118.put(r120, Float.valueOf((float) r117.optDouble(r120, AudioStats.AUDIO_AMPLITUDE_NONE)));
            r102 = r121;
            r103 = r103;
            goto L37
        L39:
            boolean r122 = r102;
            boolean r123 = r103;
        L41:
            JSONObject r124 = r101.optJSONObject("background_report_threshold_per_min");
            if (r124 == null) goto L48;
            HashMap r125 = new HashMap();
            Iterator<String> r126 = r124.keys();
        L45:
            if (r126.hasNext() == false) goto L47;
            String r127 = r126.next();
            HashMap r128 = r118;
            r125.put(r127, Float.valueOf((float) r124.optDouble(r127, AudioStats.AUDIO_AMPLITUDE_NONE)));
            r118 = r128;
            goto L45
        L47:
            HashMap r129 = r118;
            HashMap r130 = r125;
        L49:
            HashMap r131 = new HashMap();
            HashMap r132 = new HashMap();
            HashMap r133 = new HashMap();
            HashMap r134 = new HashMap();
            if (r104 <= 0) goto L52;
            int r135 = r104;
        L54:
            if (r105 <= 0) goto L56;
            int r136 = r105;
        L57:
            if (r110 != null) goto L60;
            r110 = r131;
        L60:
            if (r108 == null) goto L62;
            r132 = r108;
        L62:
            if (r114 <= 0) goto L64;
            int r137 = r114;
        L65:
            if (r115 <= 0) goto L67;
            int r138 = r115;
        L68:
            if (r116 > 0) goto L70;
        L72:
            int r139 = 1000;
        L73:
            if (r129 != null) goto L76;
            r129 = r133;
        L76:
            if (r130 == null) goto L78;
            HashMap r140 = r130;
        L79:
            r100.f482771a = new fu3.f(r122, r123, r135, r136, r110, r132, r137, r138, r139, r129, r140);
            fu3.b r141 = fu3.b.g();
            fu3.f r142 = r100.f482771a;
            if (r142 != null) goto L82;
            r141.getClass();
            return;
        L82:
            if (r141.f478873n == r142) goto L96;
            r141.j();
            r141.i(r142);
            return;
        L96:
            return;
        L78:
            r140 = r134;
            goto L79
        L70:
            if (r116 > 10000) goto L72;
            r139 = r116;
            goto L73
        L67:
            r138 = 600;
            goto L68
        L64:
            r137 = 5;
            goto L65
        L56:
            r136 = 600;
            goto L57
        L52:
            r135 = 120;
            goto L54
        L48:
            r129 = r118;
            r130 = null;
            goto L49
        L40:
            r122 = r102;
            r123 = r103;
            r118 = null;
            goto L41
        L32:
            r108 = null;
            goto L33
        L25:
            r110 = null;
            goto L26
        L18:
            r103 = false;
            goto L19
        L14:
            r102 = false;
        L8:
            r101 = null;
            goto L9
        }
    }

    public f() {
        hu3.a.a().b();
        hu3.a.a().c(new a(this));
    }
}
