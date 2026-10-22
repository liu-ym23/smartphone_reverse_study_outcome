package tg2;

import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import dm.c;
import dm.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f545845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f545846b;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "innerTag");
        int r101 = ECSdk.f48106a;
        IECHostService r102 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r102 == null) goto L5;
        vi.a r103 = r102.getIECHostAppInfo();
    L6:
        boolean r104 = true;
        if (r103 != null) goto L9;
    L10:
        if (r103 != null) goto L12;
    L14:
        r104 = false;
    L15:
        this.f545845a = r104;
        this.f545846b = "Atomic_".concat(r100);
        return;
    L12:
        if (r103.isLocalTest() != true) goto L14;
    L9:
        if (r103.isDebug() == true) goto L15;
    L5:
        r103 = null;
        goto L6
    }

    public final void a(String r100) {
        if (this.f545845a == false) goto L12;
        dm.a.b r101 = dm.a.f469202a;
        d r102 = dm.a.a(this.f545846b).f469203a;     // Catch: Exception -> L7
        r102.g(2, r102.d(), r102.e(), r102.c(), r100, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        c.b(e);
        return;
    }

    @Override // tg2.b
    public final void logE(String r100) {
        dm.a.b r101 = dm.a.f469202a;
        dm.a.a(this.f545846b).b(r100, null);
    }
}
