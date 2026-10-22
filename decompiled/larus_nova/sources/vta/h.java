package vta;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f557273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f557274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f557275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f557276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f557277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f557278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f557279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f557280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f557281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f557282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f557283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f557284l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f557285m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f557286n;

    public static final class a {
        public static h a(JSONObject r110) {
            if (r110 != null) goto L33;
            return null;
        L33:
            boolean r100 = Intrinsics.areEqual(r110.optString("ues_explicit_intent"), "1");     // Catch: JSONException -> L29
            boolean r111 = Intrinsics.areEqual(r110.optString("disable_back_pressed"), "1");     // Catch: JSONException -> L29
            if (r110.has("enable_opt_call") == false) goto L7;
            String r101 = r110.optString("enable_opt_call");     // Catch: JSONException -> L29
        L8:
            boolean r112 = true;
            if (r110.has("try_continue_pay") == false) goto L11;
            boolean r102 = Intrinsics.areEqual(r110.optString("try_continue_pay"), "1");     // Catch: JSONException -> L29
        L13:
            if (r110.has("start_activity_continue_pay") == false) goto L15;
            boolean r103 = Intrinsics.areEqual(r110.optString("start_activity_continue_pay"), "1");     // Catch: JSONException -> L29
        L17:
            if (r110.has("enable_no_result_retry") == false) goto L19;
            boolean r104 = Intrinsics.areEqual(r110.optString("enable_no_result_retry"), "1");     // Catch: JSONException -> L29
        L20:
            boolean r113 = Intrinsics.areEqual(r110.optString("enable_fail_check"), "1");     // Catch: JSONException -> L29
            boolean r114 = Intrinsics.areEqual(r110.optString("enable_activity_monitor"), "1");     // Catch: JSONException -> L29
            String r115 = r110.optString("heart_beat_interval");     // Catch: JSONException -> L29
            String r116 = r110.optString("heart_beat_duration");     // Catch: JSONException -> L29
            if (r110.has("use_version_control") == false) goto L23;
            r112 = Intrinsics.areEqual(r110.optString("use_version_control"), "1");     // Catch: JSONException -> L29
        L23:
            boolean r105 = Intrinsics.areEqual(r110.optString("applog_real_time_report"), "1");     // Catch: JSONException -> L29
            r110.optString("opt_call_type");     // Catch: JSONException -> L29
            String r106 = r110.optString("invoke_order");     // Catch: JSONException -> L29
            if (r110.has("enable_installing_check") == false) goto L26;
            boolean r107 = Intrinsics.areEqual(r110.optString("enable_installing_check"), "1");     // Catch: JSONException -> L29
        L27:
            h r108 = new h();     // Catch: JSONException -> L29
            r108.f557273a = r100;     // Catch: JSONException -> L29
            r108.f557274b = r111;     // Catch: JSONException -> L29
            r108.f557275c = r101;     // Catch: JSONException -> L29
            r108.f557280h = r113;     // Catch: JSONException -> L29
            r108.f557276d = r102;     // Catch: JSONException -> L29
            r108.f557277e = r103;     // Catch: JSONException -> L29
            r108.f557278f = r104;     // Catch: JSONException -> L29
            r108.f557279g = r114;     // Catch: JSONException -> L29
            r108.f557281i = r115;     // Catch: JSONException -> L29
            r108.f557282j = r116;     // Catch: JSONException -> L29
            r108.f557283k = r112;     // Catch: JSONException -> L29
            r108.f557284l = r105;     // Catch: JSONException -> L29
            r108.f557285m = r106;     // Catch: JSONException -> L29
            r108.f557286n = r107;     // Catch: JSONException -> L29
            return r108;
        L26:
            r107 = false;
            goto L27
        L19:
            r104 = true;
            goto L20
        L15:
            r103 = true;
            goto L17
        L11:
            r102 = true;
            goto L13
        L7:
            r101 = "1";
        L29:
            return null;
        }
    }

    public h() {
        this.f557275c = "1";
        this.f557276d = true;
        this.f557277e = true;
        this.f557278f = true;
        this.f557281i = "";
        this.f557282j = "";
        this.f557283k = true;
        this.f557285m = "";
    }
}
