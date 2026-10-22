package com.bytedance.ee.bear.drive.view.preview.wps;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n extends com.bytedance.ee.bear.drive.view.preview.wps.a {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.g
    public final int a() {
        return 2;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.g
    public final String b(WpsAccessTokenPuller.Result r9) {
        Intrinsics.checkNotNullParameter(r9, TipCallBackData.RESULT);
        this.a.getEntity().getClass();
        String r0 = StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null);
        String r1 = e(r9);
        tt5.a.h("WpsCenterVersionController", "getWpsIframeUrl reqId=" + r0 + ", brand=" + r9.brand + ", local=" + r1);
        String r2 = r9.url;
        String r4 = "?";
        boolean r5 = false;
        if (r2 != null) goto L5;
    L7:
        if (r5 == false) goto L9;
        r4 = "&";
    L9:
        String r10 = r9.url + r4 + "_w_third_lang=" + r1 + "&_w_third_req_id=" + r0 + "&_w_third_require_mode=" + this.a.getEntity().b + this.b.g();
        tt5.a.b("WpsCenterVersionController", "getWpsIframeUrl = " + r10);
        return r10;
    L5:
        if (StringsKt.contains$default(r2, "?", false, 2, null) != true) goto L7;
        r5 = true;
        goto L7
    }

    public n(WpsView r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "wpsView");
        super(r2, r3);
    }
}
