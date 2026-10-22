package hr7;

import android.text.TextUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.webx.seclink.util.ReportUtil;
import org.json.JSONException;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements Callback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dr7.b.a f486917a;

    public e(d.RunnableC6187d.a r100) {
        this.f486917a = r100;
    }

    @Override // com.bytedance.retrofit2.Callback
    public final void onFailure(Call<String> r110, Throwable r111) {
        dr7.b.a r112 = this.f486917a;
        if (r112 == null) goto L9;
        if (r111 == null) goto L6;
        String r113 = r111.getMessage();
    L7:
        d.RunnableC6187d.a r114 = (d.RunnableC6187d.a) r112;
        String r100 = r114.f486913a;
        f r101 = r114.f486916d.f486912a;
        ReportUtil.h(r100, false, r101.f486919b, r101.f486920c, r114.f486914b, false, System.currentTimeMillis() - r114.f486915c, 0, r113, 0);
        r114.f486916d.c(r113, 1);
        return;
    L6:
        r113 = "";
        goto L7
    }

    @Override // com.bytedance.retrofit2.Callback
    public final void onResponse(Call<String> r110, SsResponse<String> r210) {
        dr7.b.a r100 = this.f486917a;
        if (r100 == null) goto L28;
        if (r210 == null) goto L6;
        String r101 = r210.body();
    L7:
        d.RunnableC6187d.a r102 = (d.RunnableC6187d.a) r100;
    L24:
        e = move-exception;
        String r103 = r102.f486913a;
        f r104 = r102.f486916d.f486912a;
        ReportUtil.h(r103, false, r104.f486919b, r104.f486920c, r102.f486914b, false, System.currentTimeMillis() - r102.f486915c, 0, "json exception", 0);
        r102.f486916d.c("source:  " + r101 + "  case : " + e.getMessage(), 2);
        return;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        r102.f486916d.c("response body is empty", 1);     // Catch: JSONException -> L24
        String r105 = r102.f486913a;     // Catch: JSONException -> L24
        f r106 = r102.f486916d.f486912a;     // Catch: JSONException -> L24
        ReportUtil.h(r105, false, r106.f486919b, r106.f486920c, r102.f486914b, false, System.currentTimeMillis() - r102.f486915c, 0, "json exception", 0);     // Catch: JSONException -> L24
        return;
    L11:
        String r107 = r102.f486916d.f486912a.f486920c;     // Catch: JSONException -> L24
        c r108 = d.a.d(r101);     // Catch: JSONException -> L24
        if (r108.f486895a == false) goto L22;
        com.bytedance.webx.seclink.setting.a r109 = com.bytedance.webx.seclink.setting.c.d().c();     // Catch: JSONException -> L24
        if (r109 == null) goto L18;
        com.bytedance.webx.seclink.setting.a.C3815a r111 = r109.f272605a;     // Catch: JSONException -> L24
        if (r111 == null) goto L18;
        boolean r112 = r111.f272608a;     // Catch: JSONException -> L24
    L19:
        if (r112 == false) goto L21;
        fr7.a r113 = fr7.a.a();     // Catch: JSONException -> L24
        f r114 = r102.f486916d.f486912a;     // Catch: JSONException -> L24
        r113.d(r114.f486919b, r114.f486920c, r108);     // Catch: JSONException -> L24
    L21:
        String r115 = r102.f486913a;     // Catch: JSONException -> L24
        f r116 = r102.f486916d.f486912a;     // Catch: JSONException -> L24
        ReportUtil.h(r115, true, r116.f486919b, r116.f486920c, r102.f486914b, r108.f486897c, System.currentTimeMillis() - r102.f486915c, 0, "", r108.f486896b);     // Catch: JSONException -> L24
    L18:
        r112 = false;
    L22:
        r102.f486916d.e(r108);     // Catch: JSONException -> L24
        return;
    L6:
        r101 = "";
        goto L7
    }
}
