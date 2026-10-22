package com.bytedance.android.shopping.searchsimilar;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.sdk.helper.p;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ SimilarProductFragment a;

    public d(SimilarProductFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        p r7 = p.a;
        Context r0 = this.a.getContext();
        Lazy r1 = ECSettingKeys.a;
        int r2 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r3 = "sslocal://webcast_lynxview?type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_mall%2Fhomepage%2Ftemplate.js%3Fenter_from%3Dcomment_search%26origin_type%3D9902090000&page=ecom_mall&hide_nav_bar=1&hide_status_bar=0&status_bar_color=black&show_close=0&trans_status_bar=1&hide_loading=1&enable_share=0&show_back=0&web_bg_color=%23ffffffff&load_taro=0&top_level=1";
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r5 = jj4.b.b;     // Catch: Throwable -> L7
        Object r8 = jj4.a.a("ec_commerce_comment_jump_mall_schema", String.class, "sslocal://webcast_lynxview?type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_mall%2Fhomepage%2Ftemplate.js%3Fenter_from%3Dcomment_search%26origin_type%3D9902090000&page=ecom_mall&hide_nav_bar=1&hide_status_bar=0&status_bar_color=black&show_close=0&trans_status_bar=1&hide_loading=1&enable_share=0&show_back=0&web_bg_color=%23ffffffff&load_taro=0&top_level=1", false);     // Catch: Throwable -> L7
        if (r8 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        r7.openSchema(r0, (String) r8);
        return;
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Object r10 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r10) == true) goto L12;
        r3 = r10;
    L12:
        r8 = r3;
        goto L13
    }
}
