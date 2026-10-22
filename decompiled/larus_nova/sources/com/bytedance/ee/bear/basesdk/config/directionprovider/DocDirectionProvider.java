package com.bytedance.ee.bear.basesdk.config.directionprovider;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.basesdk.services.route.config.ForsetiNavigationConfig;
import com.bytedance.ee.bear.route.RouteBean;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes15.dex */
public final class DocDirectionProvider implements com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<ForsetiNavigationConfig> f206597a = null;

    public static final class a {
        public static ForsetiNavigationConfig a() {
            return DocDirectionProvider.f206597a.getValue();
        }
    }

    public DocDirectionProvider() {
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final /* synthetic */ boolean c() {
        return true;
    }

    static {
        f206597a = LazyKt.lazy(DocDirectionProvider$Companion$forsetiNavigationConfig$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final com.suite.lark.component.navroute.api.c<Bundle> a(RouteBean r100) {
        return new onc.a(new Bundle());
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final boolean b(RouteBean r100) {
        StringBuilder r101 = new StringBuilder("canRouterForsetiByActivity: scene:");
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.f236645j;
    L6:
        r101.append(r103);
        tt5.a.h("DocDirectionProvider", r101.toString());
        if (r100 == null) goto L9;
        String r104 = r100.f236645j;
    L11:
        if (TextUtils.isEmpty(r104) == false) goto L13;
    L22:
        return false;
    L13:
        if (a.a() == null) goto L22;
        if (a.a().enableSceneList == null) goto L22;
        ArrayList<String> r105 = a.a().enableSceneList;
        if (r100 == null) goto L20;
        r102 = r100.f236645j;
    L20:
        if (r105.contains(r102) == false) goto L22;
        return true;
    L9:
        r104 = null;
        goto L11
    L5:
        r103 = null;
        goto L6
    }
}
