package com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.r;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EntranceType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import fc3.c;
import ic3.e;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.ecom.arch.slice.render.b {
    public final /* synthetic */ BaseSliceViewHolder a;

    public a(BaseSliceViewHolder r1) {
        this.a = r1;
    }

    public final void a(r r10) {
        Intrinsics.checkNotNullParameter(r10, "actionInfo");
        IAction r0 = r10.a;
        View r11 = r10.d;
        dm.a.a("bjt_test").i("action: " + k.d(r0));
        int r1 = e.a;
        com.bytedance.android.shopping.commentv3.data.b r2 = this.a.c;
        if (r2 == null) goto L5;
        fc3.a r3 = r2.b;
    L6:
        e.a.a(r3, EventName.STATE.getEvent(), EntranceType.SLICE_ACTION_HANDLE.getType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class: " + this.a.h + ", method: handleAction, sliceId: " + this.a.V3() + ", action: " + k.d(r0))}), null, null, 240);
        c r4 = new c(r0, r11, this.a.U3(r0), this.a.d);
        com.bytedance.android.shopping.commentv3.base.c r12 = this.a.i;
        if (r12 == null) goto L12;
        fc3.a r13 = r12.d;
        if (r13 == null) goto L13;
        r13.a(r4);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
