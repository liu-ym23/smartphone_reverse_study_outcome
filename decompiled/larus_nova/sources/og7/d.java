package og7;

import com.alipay.sdk.m.p.e;
import org.json.JSONException;
import org.json.JSONObject;
import xf7.t;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements yf7.a<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yf7.a<Void> f523206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ag7.b f523207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f523208c;

    public final void c() {
        zf7.b.a(this.f523207b + " " + this.f523208c + " success");
        yf7.a<Void> r100 = this.f523206a;
        if (r100 == null) goto L5;
        ((d) r100).c();
    L5:
        a(true, 0, null);
    }

    public final void b(com.bytedance.sync.exc.a r100) {
        zf7.b.a(this.f523207b + " " + this.f523208c + " failed. reason :code-> " + r100.getErrorCode() + ", msg = " + r100.getErrorMsg());
        yf7.a<Void> r101 = this.f523206a;
        if (r101 == null) goto L5;
        ((d) r101).b(r100);
    L5:
        a(false, r100.getErrorCode(), r100.getErrorMsg());
    }

    public d(ag7.b r100, String r101, yf7.a<Void> r102) {
        this.f523206a = r102;
        this.f523207b = r100;
        this.f523208c = r101;
    }

    public final void a(boolean r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("success", r100);     // Catch: JSONException -> L5
    L7:
        eg7.a.c(r103, e.f25671s, this.f523208c);
        eg7.a.b(r103, "business", this.f523207b.a());
        if (r100 == true) goto L10;
        eg7.a.a(r103, "error_code", r101);
        eg7.a.c(r103, "error_msg", r102);
    L10:
        t.a("sync_sdk_custom_topic", r103, null, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
