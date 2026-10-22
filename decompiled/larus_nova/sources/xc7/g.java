package xc7;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.sdk.bridge.Logger;
import org.json.JSONException;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements Callback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f563226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f563227b;

    public g(h r100, String r101) {
        this.f563227b = r100;
        this.f563226a = r101;
    }

    @Override // com.bytedance.retrofit2.Callback
    public final void onFailure(Call<String> r100, Throwable r101) {
        this.f563227b.f563230b = false;
        Logger r102 = Logger.f269563c;
        int r103 = h.f563228c;
        r101.getMessage();
        r102.getClass();
        Logger.b();
    }

    @Override // com.bytedance.retrofit2.Callback
    public final void onResponse(Call<String> r100, SsResponse<String> r101) {
        Logger r102 = Logger.f269563c;
        int r103 = h.f563228c;
        r102.getClass();
        Logger.b();
        this.f563227b.f563230b = false;
        String r104 = r101.body();
        h.a(this.f563227b, r104, this.f563226a);     // Catch: JSONException -> L5
        this.f563227b.f563229a = true;     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
