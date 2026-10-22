package com.bytedance.ee.bear.drive.view.preview.wps;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t extends com.bytedance.ee.bear.drive.view.preview.wps.a {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.g
    public final int a() {
        return 1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.g
    public final String b(WpsAccessTokenPuller.Result r9) {
        Intrinsics.checkNotNullParameter(r9, TipCallBackData.RESULT);
        String r0 = StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null);
        String r1 = e(r9);
        tt5.a.h("WpsPearlResearchController", "getWpsIframeUrl reqId=" + r0 + ", brand=" + r9.brand + ", local=" + r1);
        String r2 = r9.url;
        String r4 = "?";
        boolean r5 = false;
        if (r2 != null) goto L5;
    L7:
        if (r5 == false) goto L9;
        r4 = "&";
    L9:
        StringBuilder r3 = new StringBuilder();
        r3.append(r9.url);
        r3.append(r4);
        r3.append("_w_tokentype=1&lang=");
        r3.append(r1);
        r3.append("&third_req_id=");
        r3.append(r0);
        r3.append("&require_mode=");
        r3.append(this.a.getEntity().b);
        r3.append(this.b.g());
        r3.append("&gray_strategy=");
        if (TextUtils.isEmpty(this.a.p) == false) goto L12;
        String r10 = "online";
    L13:
        r3.append(r10);
        String r11 = r3.toString();
        tt5.a.b("WpsPearlResearchController", "getWpsIframeUrl = " + r11);
        return r11;
    L12:
        r10 = this.a.p;
        goto L13
    L5:
        if (StringsKt.contains$default(r2, "?", false, 2, null) != true) goto L7;
        r5 = true;
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.a
    public final String e(WpsAccessTokenPuller.Result r4) {
        Intrinsics.checkNotNullParameter(r4, TipCallBackData.RESULT);
        if (((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.k.class, null, null, 6)).isUsPackage() == true) goto L7;
        return super.e(r4);
    L7:
        if (Intrinsics.areEqual("lark", r4.brand) == true) goto L11;
        return super.e(r4);
    L11:
        if (Intrinsics.areEqual(getContext().getResources().getConfiguration().locale.getLanguage(), Locale.CHINESE.getLanguage()) == false) goto L13;
        return "zh-lark";
    L13:
        return "en-lark";
    }

    public t(WpsView r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "wpsView");
        super(r2, r3);
    }
}
