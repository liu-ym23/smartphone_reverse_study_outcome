package com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Uri b(String r2, Map r3) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r2, "$this$toUri");
        Uri.Builder r4 = UriProtector.parse(r2).buildUpon();
        Iterator r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        Map.Entry r0 = (Map.Entry) r5.next();
        r4.appendQueryParameter((String) r0.getKey(), (String) r0.getValue());
        goto L4
    L7:
        return r4.build();
    }

    public static Uri a(Context r1, String r2, String r3, Map r4, PageFinder r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "btm");
        if (r5 != null) goto L5;
        String r6 = null;
    L6:
        if (r6 != null) goto L8;
    L11:
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        Intrinsics.checkNotNullParameter(r2, "$this$toUri");
        return UriProtector.parse(r2);
    L15:
        Intrinsics.checkNotNullParameter(r2, "$this$toUri");
        return UriProtector.parse(r2).buildUpon().appendQueryParameter("source_btm_token", r6).build();
    L8:
        if (r6.length() == 0) goto L11;
        r7 = false;
        goto L13
    L5:
        r6 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r3, r5, new BcmParams().merge(r4));
        goto L6
    }
}
