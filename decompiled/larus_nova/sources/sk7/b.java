package sk7;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.ug.sdk.luckydog.api.log.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import org.json.JSONObject;
import uk7.n;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f542424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC7625a f542425b;

    public b(JSONObject r100, c r101) {
        this.f542424a = r100;
        this.f542425b = r101;
    }

    public final void a() {
        String r100 = (String) n.c("https://praisewindow.ugsdk.cn/zebra/praise/url/", this.f542424a).body();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r100) == false) goto L7;
        this.f542425b.onFail("请求小米市场schema接口不成功, res is empty");     // Catch: Throwable -> L17
        return;
    L7:
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L17
        int r102 = JSONObjectProtectorUtils.getInt(r101, "code");     // Catch: Throwable -> L17
        if (r102 == 0) goto L11;
        this.f542425b.onFail("请求小米市场schema接口不成功, code = " + r102);     // Catch: Throwable -> L17
        return;
    L11:
        String r103 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r101, "data"), ComplianceResult.JsonKey.MARKET_DEEP_LINK);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r103) == false) goto L15;
        this.f542425b.onFail("请求小米市场schema接口不成功, schema 为空");     // Catch: Throwable -> L17
        return;
    L15:
        this.f542425b.onSuccess(r103);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        boolean r104 = a.f542422a;
        d.c("LuckyMarketUtils", "error catch: " + th.getLocalizedMessage(), th);
        a.InterfaceC7625a r105 = this.f542425b;
        String r106 = th.getLocalizedMessage();
        if (r106 != null) goto L22;
        r106 = "";
    L22:
        r105.onFail(r106);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
