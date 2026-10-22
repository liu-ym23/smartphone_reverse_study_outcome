package lta;

import android.text.TextUtils;
import ita.j;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements h.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f510720a;

    @Override // lta.h.b.a
    public final void onNetworkReady() {
        j.b("Retry update device id", null);
        if (TextUtils.isEmpty(((jta.a) this.f510720a.f510734e).c()) == false) goto L6;
        this.f510720a.f();
        return;
    }

    public g(h r100) {
        this.f510720a = r100;
    }
}
