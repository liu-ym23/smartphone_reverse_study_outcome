package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.content.Context;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.model.api.p;
import com.bytedance.android.live.ktv.common.model.api.v;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.ktvimpl.base.adapter.KtvGroupUserListAdapter;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ KtvGroupListDialogFragment a;
    public final /* synthetic */ long b;

    public d(KtvGroupListDialogFragment r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
        v r0 = (v) ((ExtraResponse) r9).data;
        if (r0 == null) goto L31;
        Map r1 = r0.a();
        if (r1 == null) goto L32;
        p r2 = (p) r1.get(Long.valueOf(this.a.d));
        if (r2 == null) goto L33;
        Context r3 = this.a.getContext();
        if (r3 == null) goto L16;
        String r4 = r3.getString(2131918397, new Object[]{Long.valueOf(r2.a())});
        if (r4 == null) goto L16;
        TextView r5 = this.a.b;
        if (r5 == null) goto L16;
        r5.setText(r4);
    L16:
        List r6 = r2.b();
        if (r6 == null) goto L29;
        RecyclerView r7 = this.a.a;
        RecyclerView.Adapter r10 = null;
        if (r7 == null) goto L21;
        RecyclerView.Adapter r11 = r7.getAdapter();
    L23:
        if ((r11 instanceof KtvGroupUserListAdapter) == false) goto L26;
        r10 = r11;
    L26:
        KtvGroupUserListAdapter r12 = (KtvGroupUserListAdapter) r10;
        if (r12 == null) goto L29;
        Intrinsics.checkNotNullParameter(r6, "list");
        r12.a.clear();
        r12.a.addAll(r6);
        r12.notifyDataSetChanged();
        goto L29
    L21:
        r11 = null;
    L29:
        Long r13 = KtvLoggerHelper.a;
        KtvLoggerHelper.X("livesdk_live_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from_merge", "chat"), TuplesKt.to("enter_method", "ktv_fiend_live_link")}));
        mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiGetLinkmicGroupUser, System.currentTimeMillis() - this.b, ((ExtraResponse) r9).logId);
        return;
    L33:
        return;
    L32:
        return;
    }
}
