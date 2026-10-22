package vl2;

import android.text.TextUtils;
import com.bytedance.android.livesdk.utils.q1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements ObservableOnSubscribe<String> {
    public final /* synthetic */ String a;

    public k(String r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<String> r4) throws Exception {
        if (TextUtils.isEmpty(this.a) == true) goto L12;
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.a);
        if (r0.exists() == false) goto L11;
        String r1 = r0.getParent();
        q1.b(r0.getPath(), r1);     // Catch: IOException -> L9
    L10:
        r4.onNext(r1);
        return;
    L9:
        r1 = "IOException";
        goto L10
    L11:
        r4.onNext("");
        return;
    L12:
        r4.onNext("");
    }
}
