package gu2;

import com.bytedance.android.live.core.verify.api.VerifyResponBean;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f482747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f482748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.verify.utils.a.g f482749c;

    public d(JSONObject r100, int r101, com.bytedance.android.live.core.verify.utils.a.g r102) {
        this.f482747a = r100;
        this.f482748b = r101;
        this.f482749c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        int r102 = f.f482753a;
        VerifyResponBean r103 = (VerifyResponBean) r101.data;
        boolean r104 = r103.isVerified;
        HashMap r105 = f.a(false, "", this.f482747a, this.f482748b, r103);
        com.bytedance.android.live.core.verify.utils.a.g r106 = this.f482749c;
        if (r106 == null) goto L7;
        r106.onVerify(r104, r105);
        return;
    }
}
