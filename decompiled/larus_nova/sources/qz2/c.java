package qz2;

import com.bytedance.android.monitorV2.util.l;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends fz2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f535296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f535297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f535298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f535299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f535300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f535301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f535302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f535303i;

    public c() {
        super("fetchError");
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        l.q(r100, com.alipay.sdk.m.p.e.f25671s, this.f535296b);
        l.n(r100, "error_no", this.f535302h);
        l.q(r100, "error_msg", this.f535301g);
        l.q(r100, "url", this.f535297c);
        l.n(r100, "status_code", this.f535298d);
        l.n(r100, "request_error_code", this.f535299e);
        l.q(r100, "request_error_msg", this.f535300f);
        l.n(r100, "jsb_ret", 0);
        l.n(r100, "hit_prefetch", 0);
        l.q(r100, "tt_log_id", this.f535303i);
    }
}
