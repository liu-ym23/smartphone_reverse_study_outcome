package gu2;

import com.bytedance.android.live.core.verify.api.VerifyResponBean;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f482744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f482745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.verify.utils.a.g f482746c;

    public c(JSONObject r100, int r101, com.bytedance.android.live.core.verify.utils.a.g r102) {
        this.f482744a = r100;
        this.f482745b = r101;
        this.f482746c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = f.f482753a;
        HashMap r103 = f.a(true, "", this.f482744a, this.f482745b, new VerifyResponBean());
        com.bytedance.android.live.core.verify.utils.a.g r104 = this.f482746c;
        if (r104 == null) goto L7;
        r104.onVerify(false, r103);
        return;
    }
}
