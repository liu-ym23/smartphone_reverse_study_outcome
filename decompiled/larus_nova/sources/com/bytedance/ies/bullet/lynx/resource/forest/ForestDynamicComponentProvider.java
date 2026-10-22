package com.bytedance.ies.bullet.lynx.resource.forest;

import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.o;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.f;
import com.bytedance.ies.bullet.forest.g;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v26.l;
import y16.b;
import y16.c;

/* JADX INFO: loaded from: classes19.dex */
public final class ForestDynamicComponentProvider implements k7a.a, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f247411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f247412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f247413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f247414e;

    @Override // com.bytedance.ies.bullet.forest.g
    public final String forestDownloadEngine(BulletContext r100) {
        return g.a.f(r100);
    }

    @Override // com.bytedance.ies.bullet.forest.g
    public final boolean hasGeckoModelInfo(BulletContext r100) {
        return g.a.l(r100);
    }

    @Override // com.bytedance.ies.bullet.forest.g
    public final String sessionID(BulletContext r100) {
        return g.a.r(r100);
    }

    @Override // com.bytedance.ies.bullet.forest.g
    public final boolean useForest(BulletContext r100) {
        return g.a.u(r100);
    }

    @Override // k7a.a
    public final void loadDynamicComponent(String r100, k7a.a.InterfaceC6515a r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L16;
        b r103 = c.f565659a;
        c.d("ForestDynamicComponentProvider start to load ".concat(r100));
        String r104 = UriProtector.getQueryParameter(UriProtector.parse(r100), this.f247413d);
        if (r104 != null) goto L13;
        r104 = "0";
    L13:
        a(r100, r101, r104);
        return;
    L16:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public ForestDynamicComponentProvider(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "downloadEngine");
        Intrinsics.checkNotNullParameter(r102, "bid");
        this.f247410a = r100;
        this.f247411b = r101;
        this.f247412c = r102;
        this.f247413d = "forest_sync_load";
        this.f247414e = "ForestDynamicComponentProvider";
    }

    public final void a(final String r110, final k7a.a.InterfaceC6515a r111, final String r112) {
        f<String, o> r100 = ForestLoader.f246728a;
        String r101 = this.f247410a;
        Scene r102 = Scene.LYNX_COMPONENT;
        String r103 = this.f247411b;
        l r104 = new l();
        r104.b(this.f247412c);
        Unit r105 = Unit.INSTANCE;
        ForestLoader.f(null, r110, r101, r102, r103, r104, false, null, new ForestDynamicComponentProvider$loadResource$2(r112, r111, this, r110), 193);
    }
}
