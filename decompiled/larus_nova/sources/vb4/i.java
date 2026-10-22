package vb4;

import com.bytedance.bdturing.EventReport;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class i implements ec4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qb4.f f554030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f554031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ jc4.m f554032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f554033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ JSONObject f554034e;

    @Override // ec4.c
    public final void a(xb4.a r100) {
        if (r100.f563110a != 200) goto L8;
        if (this.f554030a == null) goto L14;
        EventReport.t(true, this.f554031b, "", this.f554032c);
        this.f554030a.onSuccess(this.f554033d, this.f554034e);
        return;
    L14:
        return;
    L8:
        if (this.f554030a == null) goto L16;
        JSONObject r101 = this.f554034e;
        if (r101 != null) goto L12;
        r101 = new JSONObject();
    L12:
        hc4.d.b(r101, "errorMessage", "live dispatch verify report result failed");
        EventReport.t(false, this.f554031b, "send_result_fail", this.f554032c);
        this.f554030a.onFail(30007, r101);
        return;
    }

    @Override // ec4.c
    public final void onError(Throwable r100) {
        if (this.f554030a == null) goto L9;
        JSONObject r101 = this.f554034e;
        if (r101 != null) goto L7;
        r101 = new JSONObject();
    L7:
        hc4.d.b(r101, "errorMessage", "live dispatch verify report result failed");
        EventReport.t(false, this.f554031b, "send_result_fail", this.f554032c);
        this.f554030a.onFail(30007, r101);
        return;
    }

    public i(qb4.f r100, String r101, jc4.m r102, int r103, JSONObject r104) {
        this.f554030a = r100;
        this.f554031b = r101;
        this.f554032c = r102;
        this.f554033d = r103;
        this.f554034e = r104;
    }
}
