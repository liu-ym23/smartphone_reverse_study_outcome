package unc;

import android.text.TextUtils;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class e extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xnc.a f550896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, c> f550897d;

    @Override // unc.b
    public final boolean a(snc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        String r101 = r100.f542689d;
        if (TextUtils.isEmpty(r101) == false) goto L6;
        r101 = this.f550895b;
    L6:
        if (this.f550897d.get(r101) == null) goto L8;
        return true;
    L8:
        return false;
    }

    public e(String r100, xnc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultScheme");
        Intrinsics.checkNotNullParameter(r101, "routerMapping");
        this.f550895b = r100;
        this.f550896c = r101;
        this.f550897d = new HashMap();
    }

    @Override // unc.f
    public final void c(snc.b r100, tnc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = r100.f542689d;
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = this.f550895b;
    L5:
        c r103 = this.f550897d.get(r102);
        if (r103 == null) goto L8;
        r103.b(r100, r101);
        return;
    L8:
        r101.onNext();
    }
}
