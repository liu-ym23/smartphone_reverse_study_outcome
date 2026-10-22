package com.bytedance.ee.bear.basesdk.config.directionprovider;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.basesdk.services.route.config.ForsetiNavigationConfig;
import com.bytedance.ee.bear.route.RouteBean;
import java.util.ArrayList;
import kotlin.Lazy;
import onc.f0;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final /* synthetic */ boolean c() {
        return true;
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final com.suite.lark.component.navroute.api.c<Bundle> a(RouteBean r100) {
        return new f0(new Bundle());
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final boolean b(RouteBean r100) {
        StringBuilder r101 = new StringBuilder("canRouterForsetiByActivity: scene:");
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.f236645j;
    L6:
        r101.append(r103);
        tt5.a.h("WikiTreeDirectionProvider", r101.toString());
        if (r100 == null) goto L9;
        String r104 = r100.f236645j;
    L11:
        if (TextUtils.isEmpty(r104) == true) goto L22;
        Lazy<ForsetiNavigationConfig> r105 = DocDirectionProvider.f206597a;
        if (DocDirectionProvider.a.a() == null) goto L22;
        if (DocDirectionProvider.a.a().enableSceneList == null) goto L22;
        ArrayList<String> r106 = DocDirectionProvider.a.a().enableSceneList;
        if (r100 == null) goto L20;
        r102 = r100.f236645j;
    L20:
        if (r106.contains(r102) == false) goto L22;
        return true;
    L22:
        return false;
    L9:
        r104 = null;
        goto L11
    L5:
        r103 = null;
        goto L6
    }
}
