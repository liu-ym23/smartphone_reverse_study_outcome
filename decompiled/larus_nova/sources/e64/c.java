package e64;

import android.content.Context;
import android.os.Handler;
import com.bytedance.tma.base.keva.KevaManager;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f471137d;

    @Override // e64.a
    public final void a() {
        Handler r100 = (Handler) KevaManager.f270924a.getValue();
        b r101 = this.f471137d;
        if (r101 == null) goto L5;
        r100.removeCallbacks(r101);
    L6:
        r100.post(this.f471137d);
        return;
    L5:
        this.f471137d = new b(this);
        goto L6
    }

    public c(Context r100, String r101) {
        super(r101);
    }
}
