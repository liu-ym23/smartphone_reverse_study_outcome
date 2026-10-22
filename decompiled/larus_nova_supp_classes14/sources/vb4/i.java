package vb4;

import com.bytedance.bdturing.EventReport;
import ec4.c;
import org.json.JSONObject;
import xb4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements c {
    public final /* synthetic */ qb4.f a;
    public final /* synthetic */ String b;
    public final /* synthetic */ jc4.m c;
    public final /* synthetic */ int d;
    public final /* synthetic */ JSONObject e;

    @Override // ec4.c
    public final void a(a r5) {
        if (r5.a != 200) goto L8;
        if (this.a == null) goto L14;
        EventReport.t(true, this.b, "", this.c);
        this.a.onSuccess(this.d, this.e);
        return;
    L14:
        return;
    L8:
        if (this.a == null) goto L16;
        JSONObject r6 = this.e;
        if (r6 != null) goto L12;
        r6 = new JSONObject();
    L12:
        hc4.d.b(r6, "errorMessage", "live dispatch verify report result failed");
        EventReport.t(false, this.b, "send_result_fail", this.c);
        this.a.onFail(30007, r6);
        return;
    }

    @Override // ec4.c
    public final void onError(Throwable r5) {
        if (this.a == null) goto L9;
        JSONObject r6 = this.e;
        if (r6 != null) goto L7;
        r6 = new JSONObject();
    L7:
        hc4.d.b(r6, "errorMessage", "live dispatch verify report result failed");
        EventReport.t(false, this.b, "send_result_fail", this.c);
        this.a.onFail(30007, r6);
        return;
    }

    public i(qb4.f r1, String r2, jc4.m r3, int r4, JSONObject r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
