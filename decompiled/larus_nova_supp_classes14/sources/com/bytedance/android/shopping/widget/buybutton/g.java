package com.bytedance.android.shopping.widget.buybutton;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements d, l1.a {
    public e a;
    public b b;
    public l1 c;
    public int d;
    public final c e;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onFinish() {
        l1 r0 = this.c;
        if (r0 == null) goto L5;
        ((ArrayList) r0.j).remove(this);
    L5:
        b r1 = this.b;
        if (r1 == null) goto L9;
        r1.a();
        return;
    }

    public g(c r23) {
        Intrinsics.checkNotNullParameter(r23, "view");
        this.e = r23;
        int r0 = e.u;
        Intrinsics.checkNotNullParameter(this, "presenter");
        this.a = new e(this, null, null, "", "", "", "", "", null, "", null, null, null, null, null, null, null, null, null, CollectionsKt.emptyList());
        this.d = -1;
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.d
    public final void b(boolean r4) {
        if (r4 == false) goto L8;
        ECResultDialogContentVO r5 = ECSettingKeys.b();
        b r0 = this.b;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        if (r5 == null) goto L10;
        this.e.d(r5);
        return;
    L10:
        return;
    L8:
        c.a.a(this.e, null, 2131896092, 1);
    }

    public final void onTick(long r3) {
        this.e.e(this.d, r3);
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.d
    public final void a(boolean r3, String r4) {
        if (r3 == false) goto L6;
        b r5 = this.b;
        if (r5 == null) goto L6;
        r5.a();
    L6:
        c r6 = this.e;
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        c.a.a(r6, r4, null, 2);
    }
}
