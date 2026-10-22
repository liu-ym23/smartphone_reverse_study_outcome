package io7;

import android.text.TextUtils;
import com.bytedance.ug.sdk.share.impl.network.model.GetSignInfoResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import oo7.k;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GetSignInfoResponse f495224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f495225b;

    public final void a() {
        if (this.f495225b.f495229d == null) goto L19;
        boolean r100 = true;
        if (this.f495224a.getStatus() != 0) goto L12;
        if (this.f495224a.getSignInfo() == null) goto L12;
        if (TextUtils.isEmpty(this.f495224a.getSignInfo().getSignature()) == true) goto L12;
        ((un7.c) this.f495225b.f495229d).a(true, this.f495224a.getSignInfo().getSignature());
        return;
    L12:
        if (this.f495224a.getSignInfo() != null) goto L14;
    L17:
        k.e("GetSignInfoThread", "sign failed, continueShare = " + r100);
        ((un7.c) this.f495225b.f495229d).a(r100, "");
        return;
    L14:
        if (this.f495224a.getSignInfo().continueShare() == true) goto L17;
        r100 = false;
        goto L17
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c r100, GetSignInfoResponse r101) {
        this.f495225b = r100;
        this.f495224a = r101;
    }
}
