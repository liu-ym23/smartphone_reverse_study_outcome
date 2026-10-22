package wz2;

import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.webview.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends NativeCommon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f561907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f561908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f561909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f561910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f561911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f561912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f561913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f561914h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f561915i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f561916j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f561917k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f561918l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f561919m;

    public a() {
        this.f561907a = null;
        this.f561908b = null;
        this.f561909c = null;
        this.f561910d = null;
        this.f561911e = null;
        this.f561912f = null;
        this.f561913g = null;
        this.f561914h = null;
        this.f561915i = null;
        this.f561916j = null;
        this.f561917k = null;
        this.f561918l = null;
        this.f561919m = null;
    }

    @Override // com.bytedance.android.monitorV2.entity.NativeCommon, fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        super.fillInJsonObject(r100);
        String r101 = this.f561908b;
        if (r101 == null) goto L5;
        l.q(r100, "engine_type", r101);
    L5:
        String r102 = this.f561907a;
        if (r102 == null) goto L8;
        l.q(r100, "event_type", r102);
    L8:
        String r103 = this.f561909c;
        if (r103 == null) goto L11;
        l.q(r100, "format_url", r103);
    L11:
        String r104 = this.f561910d;
        if (r104 == null) goto L14;
        l.q(r100, "full_url", r104);
    L14:
        String r105 = this.f561912f;
        if (r105 == null) goto L17;
        l.q(r100, "parent_url", r105);
    L17:
        String r106 = this.f561911e;
        if (r106 == null) goto L20;
        l.q(r100, "root_url", r106);
    L20:
        String r107 = this.f561913g;
        if (r107 == null) goto L23;
        l.q(r100, "biz", r107);
    L23:
        String r108 = this.f561914h;
        if (r108 == null) goto L26;
        l.q(r100, "res_format_src", r108);
    L26:
        String r109 = this.f561915i;
        if (r109 == null) goto L29;
        l.q(r100, "res_full_src", r109);
    L29:
        String r110 = this.f561916j;
        if (r110 == null) goto L32;
        l.q(r100, "res_from", r110);
    L32:
        Integer r111 = this.f561917k;
        if (r111 == null) goto L35;
        l.p(r100, "res_size", r111);
    L35:
        String r112 = this.f561918l;
        if (r112 == null) goto L38;
        l.q(r100, "res_type", r112);
    L38:
        String r113 = this.f561919m;
        if (r113 == null) goto L41;
        l.q(r100, "request_method", r113);
    L41:
        JSONObject r114 = r100.optJSONObject("debug_context");
        if (r114 != null) goto L44;
        r114 = new JSONObject();
        l.p(r100, "debug_context", r114);
    L44:
        l.q(r114, "is_ttweb_enable", String.valueOf(m.f163358f.D()));
    }
}
