package com.ss.android.ad.applinksdk.core;

import android.content.Context;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements Callback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f406361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f406362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ira.e f406363c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.retrofit2.Callback
    public final void onFailure(Call<String> r100, Throwable r101) {
        int r102 = b.f406354a;
        b.d((String) this.f406361a.element, "网络错误," + r101.getMessage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.String] */
    @Override // com.bytedance.retrofit2.Callback
    public final void onResponse(Call<String> r100, SsResponse<String> r101) {
        if (r101 != null) goto L4;
    L9:
        int r102 = b.f406354a;
        String r103 = (String) this.f406361a.element;
        StringBuilder r104 = new StringBuilder("网络错误，code=");
        if (r101 == null) goto L12;
        String r105 = String.valueOf(r101.code());
    L13:
        r104.append(r105);
        b.d(r103, r104.toString());
        return;
    L12:
        r105 = null;
        goto L13
    L4:
        if (r101.isSuccessful() == false) goto L9;
        JSONObject r106 = new JSONObject(r101.body());     // Catch: Exception -> L7
        this.f406361a.element = r106.optString(ComplianceResult.JsonKey.MARKET_DEEP_LINK);     // Catch: Exception -> L7
        int r107 = g.f406364a;     // Catch: Exception -> L7
        g.b((String) this.f406361a.element, this.f406362b, this.f406363c);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        int r108 = b.f406354a;
        b.d((String) this.f406361a.element, "解析错误," + e.getMessage());
    }

    public f(Ref.ObjectRef r100, Context r101, ira.e r102) {
        this.f406361a = r100;
        this.f406362b = r101;
        this.f406363c = r102;
    }
}
