package w48;

import com.bytedance.bdinstall.n0;
import com.bytedance.bdinstall.t0;
import com.larus.applog.impl.ApplogImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ApplogImpl f558263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v48.b f558264b;

    @Override // com.bytedance.bdinstall.t0
    public final void onTimeout() {
        this.f558263a.getClass();
        ApplogImpl.A(0, "-1001", "timeout");
        v48.b r100 = this.f558264b;
        if (r100 == null) goto L6;
        r100.onTimeout();
        return;
    }

    @Override // com.bytedance.bdinstall.t0
    public final void a(n0 r100) {
        Intrinsics.checkNotNullParameter(r100, "installInfo");
        String r101 = r100.f199720a;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = r100.f199721b;
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        if (r101.length() <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L15;
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L20;
        this.f558263a.getClass();
        ApplogImpl.A(1, null, null);
    L21:
        v48.b r106 = this.f558264b;
        if (r106 == null) goto L25;
        r106.a(r101, r102);
        return;
    L25:
        return;
    L20:
        this.f558263a.getClass();
        ApplogImpl.A(0, "-1002", "invalid_did");
        goto L21
    L15:
        if (Intrinsics.areEqual(r101, "0") == true) goto L17;
        r105 = true;
        goto L18
    L12:
        r104 = false;
        goto L13
    }

    public k(ApplogImpl r100, nba.c.a r101) {
        this.f558263a = r100;
        this.f558264b = r101;
    }
}
