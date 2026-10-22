package com.bytedance.android.window.shop.home;

import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.dto.WindowAuthorInfoResponseDTO;
import com.bytedance.android.window.shop.repository.dto.l;
import com.bytedance.android.window.shop.repository.dto.o;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ c a;

    public a(c r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        WindowAuthorInfoResponseDTO r8 = (WindowAuthorInfoResponseDTO) r7;
        if (r8.getStatusCode() == 0) goto L5;
        this.a.g.getLoadStatus().setValue(WindowLoadStatus.InitializeError);
        return;
    L5:
        int r0 = uq3.b.c;
        Intrinsics.checkNotNullParameter(r8, "dto");
        uq3.b r1 = new uq3.b();
        l r2 = r8.getWindowAuthorInfo();
        String r3 = null;
        if (r2 == null) goto L8;
        int r4 = uq3.c.e;
        Intrinsics.checkNotNullParameter(r2, "dto");
        uq3.c r5 = new uq3.c();
        r5.a = r2.a();
        r5.b = r2.b();
        r5.c = r2.d();
        r5.d = r2.c();
    L9:
        r1.a = r5;
        o r9 = r8.getWindowCartEntryInfo();
        if (r9 == null) goto L12;
        int r6 = uq3.f.b;
        Intrinsics.checkNotNullParameter(r9, "dto");
        uq3.f r10 = new uq3.f();
        r10.a = r9.a();
    L13:
        r1.b = r10;
        uq3.c r11 = r1.a;
        if (r11 == null) goto L18;
        Integer r12 = r11.d;
        if (r12 == null) goto L18;
        this.a.g.getShopParam().setFollowStatus(Integer.valueOf(r12.intValue()));
    L18:
        ECWindowViewModel r13 = this.a.g;
        Pair[] r14 = new Pair[1];
        uq3.c r15 = r1.a;
        if (r15 == null) goto L23;
        Integer r16 = r15.d;
        if (r16 == null) goto L23;
        String r17 = String.valueOf(r16.intValue());
    L24:
        r14[0] = TuplesKt.to("follow_status", r17);
        r13.appendEventParams(r14);
        zn.b<WindowCartEntryConfig> r18 = this.a.g.getCartEntryConfig();
        uq3.f r19 = r1.b;
        if (r19 == null) goto L27;
        r3 = r19.a;
    L27:
        r18.setValue(new WindowCartEntryConfig(r3));
        this.a.f.setValue(r1);
        return;
    L23:
        r17 = null;
        goto L24
    L12:
        r10 = null;
        goto L13
    L8:
        r5 = null;
        goto L9
    }
}
