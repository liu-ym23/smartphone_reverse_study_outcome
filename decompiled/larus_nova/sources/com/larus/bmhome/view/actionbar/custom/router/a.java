package com.larus.bmhome.view.actionbar.custom.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUrl");
        return true;
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean a(BaseContentWidget r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r101, "schemaUrl");
        Intrinsics.checkNotNullParameter(r102, "commonArgs");
        Uri r103 = UriProtector.parse(r101);
        if (r100 == null) goto L6;
        Context r104 = r100.getContext();
        if (r104 == null) goto L6;
    L7:
        Uri.Builder r105 = r103.buildUpon();
        String r106 = UriProtector.getQueryParameter(r103, "enter_method");
        if (r106 != null) goto L10;
    L13:
        boolean r107 = true;
    L14:
        if (r107 == false) goto L16;
        r105.appendQueryParameter("enter_method", "chat_action_bar");
    L16:
        i r108 = SmartRouter.buildRoute(r104, r105.appendQueryParameter("android_no_clear_top", "1").build().toString());
        r108.f267554c.putExtras(r102);
        if (StringsKt.contains$default(r101, "//flow/create_digital_avatar", false, 2, null) == false) goto L19;
        r108.f267554c.putExtra("click_create_replica_current_page", "create_feed");
        r108.f267555d = R.anim.larus_router_no_anim;
        r108.f267556e = R.anim.larus_router_no_anim;
    L19:
        r108.d();
        return true;
    L10:
        if (r106.length() == 0) goto L13;
        r107 = false;
    L6:
        r104 = AppHost.f326268a.a().getCurrentActivity();
        goto L7
    }
}
