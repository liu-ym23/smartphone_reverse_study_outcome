package ox0;

import com.bytedance.android.live.utils.c;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import kotlin.jvm.internal.Intrinsics;
import y11.g;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x11.a f527064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f527065b;

    public final int a() {
        int r100 = this.f527065b.getMultiInteractMode();
        x11.a r101 = this.f527064a;
        if (r101 == null) goto L7;
        g r102 = r101.Dn();
        if (r102 == null) goto L7;
        int r103 = r102.a();
    L8:
        int r104 = c.f102546a;
        return r100 | r103;
    L7:
        r103 = 0;
        goto L8
    }

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "revInternalService");
        this.f527065b = r100;
    }
}
