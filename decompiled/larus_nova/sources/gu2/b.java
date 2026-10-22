package gu2;

import com.bytedance.android.live.core.verify.api.VerifyResponBean;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f482741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f482742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.verify.utils.a.g f482743c;

    public b(JSONObject r100, int r101, com.bytedance.android.live.core.verify.utils.a.g r102) {
        this.f482741a = r100;
        this.f482742b = r101;
        this.f482743c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        int r102 = f.f482753a;
        VerifyResponBean r103 = (VerifyResponBean) r101.data;
        boolean r104 = r103.isVerified;
        HashMap r105 = f.a(true, "", this.f482741a, this.f482742b, r103);
        com.bytedance.android.live.core.verify.utils.a.g r106 = this.f482743c;
        if (r106 == null) goto L7;
        r106.onVerify(r104, r105);
        return;
    }
}
