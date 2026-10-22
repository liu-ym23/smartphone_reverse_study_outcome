package com.larus.home.impl.route;

import android.content.Context;
import android.net.Uri;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class x0 implements q97.a {
    public x0() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        int r101 = u0.f346102a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L9:
        return Intrinsics.areEqual(u0.a(r103), "//flow/share");
    L7:
        r103 = null;
        goto L9
    }

    @Override // q97.a
    public final boolean a(Context r110, com.bytedance.router.c r111) {
        String r100 = null;
        if (r111 == null) goto L7;
        Uri r101 = r111.f267530d;
        if (r101 == null) goto L7;
        String r102 = UriProtector.getQueryParameter(r101, "title");
    L8:
        if (r111 == null) goto L12;
        Uri r103 = r111.f267530d;
        if (r103 == null) goto L12;
        String r104 = UriProtector.getQueryParameter(r103, "share_url");
    L13:
        if (r111 == null) goto L17;
        Uri r105 = r111.f267530d;
        if (r105 == null) goto L17;
        r100 = UriProtector.getQueryParameter(r105, BdpAppEventConstant.PARAMS_SUB_TITLE);
    L17:
        String r106 = r100;
        ShareScene.a r107 = ShareScene.Companion;
        if (r111 == null) goto L23;
        Uri r112 = r111.f267530d;
        if (r112 == null) goto L23;
        String r113 = UriProtector.getQueryParameter(r112, "share_scene");
        if (r113 == null) goto L23;
    L24:
        r107.getClass();
        ShareScene r114 = ShareScene.a.a(r113);
        if (r114 != null) goto L27;
        r114 = ShareScene.UNKNOWN;
    L27:
        IShareService.a.c(ShareServiceDelegate.f313831b, r110, r104, r102, r106, r114, null, null, null, 480);
        return true;
    L23:
        r113 = "";
    L12:
        r104 = null;
    L7:
        r102 = null;
        goto L8
    }
}
