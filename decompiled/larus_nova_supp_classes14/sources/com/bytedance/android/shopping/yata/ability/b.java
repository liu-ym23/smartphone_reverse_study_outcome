package com.bytedance.android.shopping.yata.ability;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v96.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b implements e {
    public final Context a;
    public final Function0<PageFinder> b;

    public final Context getContext() {
        return this.a;
    }

    public void openSchema(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Context r0 = this.a;
        Uri r6 = UriProtector.parse(r5);
        int r1 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L6;
        IAdapterService.a.a(r2, r0, r6, true, 8);
        return;
    }

    public b(Context r2, Function0<? extends PageFinder> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "btmPageFinderMethod");
        this.a = r2;
        this.b = r3;
    }

    public void a(String r3, String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        Intrinsics.checkNotNullParameter(r4, "btm");
        String r6 = b(this.a, r4, r5);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        if (r6 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        Uri r7 = UriProtector.parse(r3);     // Catch: Throwable -> L15
    L13:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r8) == false) goto L20;
        r8 = null;
    L20:
        Uri r9 = (Uri) r8;
        if (r9 == null) goto L28;
        Context r10 = this.a;
        int r2 = ECSdk.a;
        IAdapterService r11 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r11 == null) goto L29;
        IAdapterService.a.a(r11, r10, r9, true, 8);
        return;
    L29:
        return;
    L28:
        return;
    L12:
        r7 = UriProtector.parse(r3).buildUpon().appendQueryParameter("source_btm_token", r6).build();     // Catch: Throwable -> L15
        goto L13
    L6:
        if (r6.length() == 0) goto L9;
        r1 = false;
    L15:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public String b(Context r3, String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "btm");
        PageFinder r6 = (PageFinder) this.b.invoke();
        if (r6 != null) goto L7;
        return null;
    L7:
        return BtmSDK.INSTANCE.createJumpSourceBtmToken(r4, r6, new BcmParams().merge(r5));
    }
}
