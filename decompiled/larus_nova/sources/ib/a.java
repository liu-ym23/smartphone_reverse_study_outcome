package ib;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w26.g;
import y36.p;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends com.bytedance.ies.bullet.service.sdk.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f488980a;

    @Override // t36.e
    public final String getName() {
        return "AnnieXLiteForestInterceptor";
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        this.f488980a = r100;
    }

    @Override // t36.e
    public final boolean b(com.bytedance.ies.bullet.service.sdk.d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        r100.a("delay_preload", new y36.d(0), true);
        Map<String, Map<Class<?>, Object>> r101 = x26.a.f562251a;
        g r102 = (g) x26.a.a(g.class);
        if (r102 == null) goto L9;
        w26.e r103 = (w26.e) r102.n0(w26.e.class);
        if (r103 == null) goto L9;
        Boolean r104 = r103.m1();
        if (r104 == null) goto L9;
        boolean r105 = r104.booleanValue();
    L10:
        if (r105 == true) goto L12;
    L14:
        return true;
    L12:
        if (Intrinsics.areEqual(this.f488980a, "webcast") == false) goto L14;
        r100.a("enable_preload", new p(PullConfiguration.PROCESS_NAME_MAIN), true);
    L9:
        r105 = true;
        goto L10
    }
}
