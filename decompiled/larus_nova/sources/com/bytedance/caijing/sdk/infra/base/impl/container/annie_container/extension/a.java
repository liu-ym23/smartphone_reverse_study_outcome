package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension;

import android.app.Activity;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.PlugInContainerService;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y36.p;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends k16.a {

    /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension.a$a, reason: collision with other inner class name */
    public static final class C2923a {
    }

    public static final class b implements m16.c<gd4.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension.b f202405a;

        @Override // com.bytedance.ies.bullet.service.base.i0
        public final void release() {
            this.f202405a.getClass();
        }

        public b() {
            this.f202405a = new com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension.b();
        }

        @Override // m16.c
        public final gd4.b provideInstance() {
            return this.f202405a;
        }
    }

    public static final class c implements ee4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m16.b f202406a;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee4.a
        public final void onEvent() {
            h16.e r100 = (h16.e) this.f202406a.c(h16.e.class);
            String r101 = null;
            if (r100 == null) goto L7;
            h16.d r102 = r100.getActivityWrapper();
            if (r102 == null) goto L7;
            Activity r103 = r102.getActivity();
        L8:
            if (r103 != null) goto L10;
            return;
        L10:
            BulletContext r104 = (BulletContext) this.f202406a.c(BulletContext.class);
            if (r104 == null) goto L16;
            t36.d r105 = r104.f246437e;
            if (r105 == null) goto L16;
            r101 = (String) new p(r105, "is_cj_web_scan", null).f565862b;
        L16:
            if (Intrinsics.areEqual(r101, "1") == false) goto L19;
            return;
        L19:
            if (r103.isFinishing() == true) goto L22;
            r103.finish();
            r103.overridePendingTransition(0, 0);
            return;
        L22:
            return;
        L7:
            r103 = null;
            goto L8
        }

        public c(m16.b r100) {
            this.f202406a = r100;
        }
    }

    static {
    }

    public a() {
    }

    @Override // k16.a
    public final List<IDLXBridgeMethod> H0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        r100.f(gd4.b.class, new b());
        ve4.a.f554342a.getClass();
        PlugInContainerService r101 = (PlugInContainerService) ve4.a.a(PlugInContainerService.class);
        if (r101 == null) goto L6;
        r101.registerCJPayFinishAllH5Event(new c(r100));
    L6:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k16.a, k16.b
    public final List<MethodFinder> L(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        BulletContext r101 = (BulletContext) r100.c(BulletContext.class);
        Boolean r102 = null;
        if (r101 == null) goto L8;
        t36.d r103 = r101.f246437e;
        if (r103 == null) goto L8;
        r102 = (Boolean) new y36.a(r103, "cj_use_default_bridge", null).f565862b;
    L8:
        if (r102 == null) goto L10;
        boolean r104 = r102.booleanValue();
    L11:
        if (r104 == false) goto L15;
        return CollectionsKt.mutableListOf(new MethodFinder[]{new com.bytedance.ies.bullet.base.bridge.p(r100), new com.bytedance.ies.bullet.base.bridge.c(r100), new com.bytedance.ies.bullet.base.bridge.l(r100)});
    L15:
        return CollectionsKt.listOf(new af4.a(0));
    L10:
        r104 = false;
        goto L11
    }
}
