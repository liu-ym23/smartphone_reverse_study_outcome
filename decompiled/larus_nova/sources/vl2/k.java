package vl2;

import android.text.TextUtils;
import com.bytedance.android.livesdk.utils.q1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public final class k implements ObservableOnSubscribe<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f555665a;

    public k(String r100) {
        this.f555665a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<String> r100) throws Exception {
        if (TextUtils.isEmpty(this.f555665a) == true) goto L12;
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f555665a);
        if (r101.exists() == false) goto L11;
        String r102 = r101.getParent();
        q1.b(r101.getPath(), r102);     // Catch: IOException -> L9
    L10:
        r100.onNext(r102);
        return;
    L9:
        r102 = "IOException";
        goto L10
    L11:
        r100.onNext("");
        return;
    L12:
        r100.onNext("");
    }
}
