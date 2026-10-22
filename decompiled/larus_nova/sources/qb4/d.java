package qb4;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdturing.EventReport;
import com.bytedance.ee.space.sync.PushAction$ESubType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f532330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ jc4.m f532331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f532332c;

    public class a implements a0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f532333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f532334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f532335c;

        public final void a(int r100, String r101) {
            this.f532335c.f532330a.onFail(1002, this.f532334b);
            EventReport.T(r100, r101, this.f532335c.f532331b);
        }

        public a(d r100, int r101, JSONObject r102) {
            this.f532335c = r100;
            this.f532333a = r101;
            this.f532334b = r102;
        }
    }

    @Override // qb4.f
    public final void onFail(int r100, JSONObject r101) {
        this.f532330a.onFail(r100, r101);
        EventReport.U(r100, r101, this.f532331b);
    }

    @Override // qb4.f
    public final void onSuccess(int r100, JSONObject r101) {
        EventReport.U(r100, r101, this.f532331b);
        if (r101 == null) goto L5;
        JSONObject r102 = r101.optJSONObject("notify_data");
    L6:
        if (r102 != null) goto L8;
    L35:
        this.f532330a.onSuccess(r100, r101);
        return;
    L8:
        if (TextUtils.isEmpty(r102.optString(PushAction$ESubType.KEY_NAME)) == true) goto L35;
        if (a0.f532294c == null) goto L13;
    L22:
        a0 r103 = a0.f532294c;
        JSONObject r104 = this.f532332c;
        a r105 = new a(this, r100, r101);
        r103.getClass();
        com.bytedance.bdturing.setting.e r106 = com.bytedance.bdturing.setting.e.f202077a;
        String r107 = com.bytedance.bdturing.setting.e.d("verify");
        StringBuilder r108 = new StringBuilder();
        if (TextUtils.isEmpty(r107) == false) goto L25;
    L30:
        String r109 = r108.toString();
        if (TextUtils.isEmpty(r109) == false) goto L33;
        r105.a(3, "");
        return;
    L33:
        r103.f532295a = 0;
        r103.b(r109 + "combined_verify/notify", hc4.d.a(r104), hc4.d.a(r102), r105);
        return;
    L25:
        if (r107.startsWith("https://") == true) goto L27;
        r108.append("https://");
    L27:
        r108.append(r107);
        if (r107.endsWith(HTTP.URL_DEFAULT) == true) goto L30;
        r108.append(HTTP.URL_DEFAULT);
        goto L30
    L13:
        monitor-enter(a0.class);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (a0.f532294c != null) goto L17;
        a0.f532294c = new a0();     // Catch: Throwable -> L19
    L17:
        monitor-exit(a0.class);     // Catch: Throwable -> L19
        goto L22
    L5:
        r102 = null;
        goto L6
    }

    public d(f r100, jc4.m r101, JSONObject r102) {
        this.f532330a = r100;
        this.f532331b = r101;
        this.f532332c = r102;
    }
}
