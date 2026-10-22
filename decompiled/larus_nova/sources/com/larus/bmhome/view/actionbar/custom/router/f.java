package com.larus.bmhome.view.actionbar.custom.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.common.apphost.AppHost;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class f implements b {
    public f() {
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUrl");
        return StringsKt.contains$default(r100, "//flow/zproject/main", false, 2, null);
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
        i r105 = SmartRouter.buildRoute(r104, r103.buildUpon().build().toString());
        r105.f267554c.putExtras(r102);
        r105.d();
        return true;
    L6:
        r104 = AppHost.f326268a.a().getCurrentActivity();
        goto L7
    }
}
