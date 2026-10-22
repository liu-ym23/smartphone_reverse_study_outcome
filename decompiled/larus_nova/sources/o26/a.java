package o26;

import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.bullet.service.sdk.d;
import com.bytedance.ies.bullet.service.sdk.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521783a;

    @Override // t36.e
    public final String getName() {
        return this.f521783a;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        this.f521783a = "WebStandardInterceptor";
    }

    @Override // t36.e
    public final boolean b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        if (r100.g() == false) goto L9;
        s26.d r101 = s26.d.f540305c;
        m0 r102 = (m0) s26.d.f540305c.c(m0.class);
        if (r102 == null) goto L10;
        r102.a0();
        return true;
    L10:
        return true;
    L9:
        return true;
    }
}
