package ms;

import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f515455a = null;

    static {
        f515455a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.gamecp.business.download.a r101 = (com.bytedance.android.gamecp.business.download.a) r100;
        if (r101.f52447b == false) goto L11;
        TokenCert r102 = i.f515456a;
        i.f515458c = System.currentTimeMillis();
        p r103 = r101.f52446a;
        if (r103 == null) goto L8;
        String r104 = r103.f52845f;
    L9:
        i.f515457b = r104;
        return;
    L8:
        r104 = null;
        goto L9
    }
}
