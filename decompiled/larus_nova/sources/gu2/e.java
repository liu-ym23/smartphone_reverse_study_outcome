package gu2;

import com.bytedance.android.live.core.verify.api.VerifyResponBean;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f482750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f482751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.verify.utils.a.g f482752c;

    public e(JSONObject r100, int r101, com.bytedance.android.live.core.verify.utils.a.g r102) {
        this.f482750a = r100;
        this.f482751b = r101;
        this.f482752c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = f.f482753a;
        HashMap r102 = f.a(true, String.valueOf(((Throwable) r100).getMessage()), this.f482750a, this.f482751b, new VerifyResponBean());
        com.bytedance.android.live.core.verify.utils.a.g r103 = this.f482752c;
        if (r103 == null) goto L7;
        r103.onVerify(false, r102);
        return;
    }
}
