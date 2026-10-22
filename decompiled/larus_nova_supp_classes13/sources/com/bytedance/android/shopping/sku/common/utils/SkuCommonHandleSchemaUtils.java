package com.bytedance.android.shopping.sku.common.utils;

import android.content.Context;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.l0;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonHandleSchemaUtils {
    public static final /* synthetic */ int a = 0;

    public SkuCommonHandleSchemaUtils() {
    }

    static {
    }

    public static void b(final Context r3, String r4, boolean r5, final Function0 r6, int r7) {
        if ((r7 & 4) == 0) goto L5;
        final boolean r0 = false;
    L7:
        if ((r7 & 8) == 0) goto L10;
        r5 = false;
    L10:
        if ((r7 & 64) == 0) goto L12;
        r6 = null;
    L12:
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "url");
        final Ref.BooleanRef r8 = new Ref.BooleanRef();
        r8.element = false;
        if (r5 == false) goto L21;
        if (l0.b(r3) == null) goto L21;
        nj.d r9 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r9 == null) goto L19;
        r9.i();
    L19:
        r8.element = false;
    L21:
        if (r8.element == true) goto L24;
        b.a(r4, new SkuCommonHandleSchemaUtils$handleSchemaWithLive$2(r8, r3, r0), new SkuCommonHandleSchemaUtils$handleSchemaWithLive$3(r6));
        return;
    L24:
        return;
    L5:
        r0 = true;
        goto L7
    }

    public static String a(final String r4, String r5, Map r6, final mh3.a r7, final String r8, PageFinder r9) {
        Intrinsics.checkNotNullParameter(r4, "schema");
        Intrinsics.checkNotNullParameter(r8, "tag");
        Intrinsics.checkNotNullParameter(r9, "btmPageFinder");
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L21;
        final String r10 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r5, r9, new BcmParams().merge(r6));
        if (r10 != null) goto L14;
    L17:
        if (r0 == true) goto L22;
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = r4;
        b.a(r4, new SkuCommonHandleSchemaUtils$handleSchemaWithBtm$1(r11, r10), new SkuCommonHandleSchemaUtils$handleSchemaWithBtm$2(r7, r8, r4));
        return (String) r11.element;
    L22:
        return r4;
    L14:
        if (r10.length() == 0) goto L17;
        r0 = false;
        goto L17
    L21:
        return r4;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r2 = false;
        goto L9
    }
}
