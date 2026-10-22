package com.bytedance.android.shopping.prepurchase.business.pdp.util;

import android.net.Uri;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.data.k;
import com.bytedance.android.shopping.service.c;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DelayKt;
import vg3.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BottomNavigationToaster {
    public final f0 a;

    public BottomNavigationToaster(f0 r1) {
        this.a = r1;
    }

    public final void a(String r4) {
        Uri.Builder r5 = UriProtector.parse(r4).buildUpon();
        k r0 = AnchorV4DataManager.a;
        r5.appendQueryParameter("identifier", AnchorV4DataManager.d);
        f0 r1 = this.a;
        if (r1 == null) goto L5;
        r1.openSchema(r5.build().toString());
    L5:
        q.a.e("detail_last_show_add_cart_popup", System.currentTimeMillis());
    }

    public final Object b(boolean r9, String r10, long r11, Continuation<? super Unit> r13) {
        if ((r13 instanceof BottomNavigationToaster$showCartEntranceVideo$1) == false) goto L7;
        BottomNavigationToaster$showCartEntranceVideo$1 r0 = (BottomNavigationToaster$showCartEntranceVideo$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = r0.Z$0;
        r10 = (String) r0.L$1;
        BottomNavigationToaster r12 = (BottomNavigationToaster) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L44:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L40
        if (r9 == false) goto L36;
        r12.a(r10);     // Catch: Throwable -> L40
    L38:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L43:
        return Unit.INSTANCE;
    L36:
        if (c.b.a == false) goto L38;
        r12.a(r10);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (r10 == null) goto L17;
        Ref.LongRef r17 = new Ref.LongRef();
        r17.element = 0;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L21
        r17.element = q.a.getLong("detail_last_show_add_cart_popup", 0);     // Catch: Throwable -> L21
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L24:
        if ((System.currentTimeMillis() - r17.element) <= 86400000) goto L26;
        boolean r18 = true;
    L27:
        if (r18 == false) goto L43;
        r0.L$0 = this;
        r0.L$1 = r10;
        r0.Z$0 = r9;
        r0.label = 1;
        if (DelayKt.delay(r11, r0) != r2) goto L31;
        return r2;
    L31:
        r12 = this;
        goto L44
    L26:
        r18 = false;
    L21:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L17:
        return Unit.INSTANCE;
    L7:
        r0 = new BottomNavigationToaster$showCartEntranceVideo$1(this, r13);
        goto L8
    }
}
