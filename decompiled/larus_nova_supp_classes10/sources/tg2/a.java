package tg2;

import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import dm.c;
import dm.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements b {
    public final boolean a;
    public final String b;

    public a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "innerTag");
        int r0 = ECSdk.a;
        IECHostService r1 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r1 == null) goto L5;
        vi.a r2 = r1.getIECHostAppInfo();
    L6:
        boolean r3 = true;
        if (r2 != null) goto L9;
    L10:
        if (r2 != null) goto L12;
    L14:
        r3 = false;
    L15:
        this.a = r3;
        this.b = "Atomic_".concat(r4);
        return;
    L12:
        if (r2.isLocalTest() != true) goto L14;
    L9:
        if (r2.isDebug() == true) goto L15;
    L5:
        r2 = null;
        goto L6
    }

    public final void a(String r9) {
        if (this.a == false) goto L12;
        dm.a.b r0 = dm.a.a;
        d r1 = dm.a.a(this.b).a;     // Catch: Exception -> L7
        r1.g(2, r1.d(), r1.e(), r1.c(), r9, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        c.b(e);
        return;
    }

    @Override // tg2.b
    public final void logE(String r3) {
        dm.a.b r0 = dm.a.a;
        dm.a.a(this.b).b(r3, null);
    }
}
