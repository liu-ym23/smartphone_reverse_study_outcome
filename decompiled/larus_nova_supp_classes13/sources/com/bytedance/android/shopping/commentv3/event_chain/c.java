package com.bytedance.android.shopping.commentv3.event_chain;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements v96.e {
    public final Context a;
    public final Function0<PageFinder> b;

    public final void openSchema(String r3) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        p.a.openSchema(this.a, r3);
    }

    public c(Context r2, Function0<? extends PageFinder> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "btmPageFinderMethod");
        this.a = r2;
        this.b = r3;
    }

    public final void a(String r4, String r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "schema");
        Intrinsics.checkNotNullParameter(r5, "btm");
        Intrinsics.checkNotNullParameter(this.a, "context");
        Intrinsics.checkNotNullParameter(r5, "btm");
        PageFinder r0 = (PageFinder) this.b.invoke();
        if (r0 != null) goto L5;
        String r7 = null;
    L6:
        if (r7 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == false) goto L14;
        Uri r9 = UriProtector.parse(r4);
    L15:
        p.a.openSchema(this.a, r9.toString());
        return;
    L14:
        r9 = UriProtector.parse(r4).buildUpon().appendQueryParameter("source_btm_token", r7).build();
        goto L15
    L8:
        if (r7.length() == 0) goto L11;
        r8 = false;
        goto L12
    L5:
        r7 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r5, r0, new BcmParams().merge(r6));
        goto L6
    }
}
