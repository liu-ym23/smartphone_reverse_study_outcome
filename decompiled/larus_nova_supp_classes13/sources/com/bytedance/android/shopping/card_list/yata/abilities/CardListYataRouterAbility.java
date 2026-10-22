package com.bytedance.android.shopping.card_list.yata.abilities;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.yata.ability.b;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nj.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListYataRouterAbility extends b {
    public final Lazy c;
    public final CardListObjectContainer d;

    public final void openSchema(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L27;
        Intrinsics.checkNotNullParameter(r5, "$this$toUri");
        Uri r1 = UriProtector.parse(r5);
        String r2 = UriProtector.getQueryParameter(r1, "url");
        String r3 = UriProtector.getQueryParameter(r1, "height_percent");
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r2, "$this$toUri");
        Uri r0 = UriProtector.parse(r2);
        if (r0 == null) goto L9;
        String r4 = UriProtector.getQueryParameter(r0, "height_percent");
    L10:
        if (r4 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == true) goto L22;
        if (k.c(r3) == true) goto L22;
        int r7 = com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend.a.a;
        r5 = com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend.a.b(r5, MapsKt.mapOf(TuplesKt.to("height_percent", r4))).toString();
    L22:
        if (l0.b(getContext()) == null) goto L29;
        d r8 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r8 == null) goto L26;
        r8.i();
    L26:
        super.openSchema(r5);
        return;
    L29:
        return;
    L12:
        if (r4.length() == 0) goto L15;
        r6 = false;
    L9:
        r4 = null;
        goto L10
    L27:
        super.openSchema(r5);
    }

    public CardListYataRouterAbility(Context r2, CardListObjectContainer r3, Function0<? extends PageFinder> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        Intrinsics.checkNotNullParameter(r4, "btmPageFinderMethod");
        super(r2, r4);
        this.d = r3;
        this.c = LazyKt.lazy(new CardListYataRouterAbility$isInSplit$2(this));
    }

    public final void a(String r9, String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r9, "schema");
        Intrinsics.checkNotNullParameter(r10, "btm");
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L56;
        Intrinsics.checkNotNullParameter(r9, "$this$toUri");
        Uri r1 = UriProtector.parse(r9);
        String r2 = UriProtector.getQueryParameter(r1, "url");
        String r3 = UriProtector.getQueryParameter(r1, "height_percent");
        String r4 = null;
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r2, "$this$toUri");
        Uri r5 = UriProtector.parse(r2);
        if (r5 == null) goto L9;
        String r6 = UriProtector.getQueryParameter(r5, "height_percent");
    L10:
        boolean r7 = false;
        if (r6 != null) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r8 == false) goto L19;
    L22:
        String r12 = b(getContext(), r10, r11);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L35
        if (r12 != null) goto L26;
    L29:
        boolean r14 = true;
    L30:
        if (r14 == false) goto L32;
        Intrinsics.checkNotNullParameter(r9, "$this$toUri");     // Catch: Throwable -> L35
        Uri r0 = UriProtector.parse(r9);     // Catch: Throwable -> L35
    L33:
        Object r15 = Result.constructor-impl(r0);     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r15) == false) goto L40;
        r15 = null;
    L40:
        Uri r16 = (Uri) r15;
        if (r16 == null) goto L43;
        r4 = r16.toString();
    L43:
        if (r4 != null) goto L45;
    L46:
        r7 = true;
    L47:
        if (r7 == false) goto L51;
        super.a(r9, r10, r11);
        return;
    L51:
        if (l0.b(getContext()) == null) goto L60;
        d r17 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r17 == null) goto L55;
        r17.i();
    L55:
        super.a(r4, r10, r11);
        return;
    L60:
        return;
    L45:
        if (r4.length() != 0) goto L47;
    L32:
        Intrinsics.checkNotNullParameter(r9, "$this$toUri");     // Catch: Throwable -> L35
        r0 = UriProtector.parse(r9).buildUpon().appendQueryParameter("source_btm_token", r12).build();     // Catch: Throwable -> L35
        goto L33
    L26:
        if (r12.length() == 0) goto L29;
        r14 = false;
    L35:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L19:
        if (k.c(r3) == true) goto L22;
        int r19 = com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend.a.a;
        r9 = com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend.a.b(r9, MapsKt.mapOf(TuplesKt.to("height_percent", r6))).toString();
        goto L22
    L13:
        if (r6.length() == 0) goto L16;
        r8 = false;
    L9:
        r6 = null;
        goto L10
    L56:
        super.a(r9, r10, r11);
    }
}
