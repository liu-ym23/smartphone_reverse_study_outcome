package com.bytedance.ee.bear.more.view3.ui;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.view3.MoreAdapter;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends k {
    public final com.bytedance.ee.bear.more.protocol3.i e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        if (this.d != ItemUIStyle.DOUBAO) goto L5;
        return 2131563680;
    L5:
        return 2131563679;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final com.bytedance.ee.bear.more.protocol3.i d() {
        return this.e;
    }

    public c(String r2, com.bytedance.ee.bear.more.protocol3.i r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "items");
        super(r2);
        this.e = r3;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void b(View r10, List<? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "itemView");
        RecyclerView r0 = r10.findViewById(2131373898);
        RecyclerView.Adapter r1 = r0.getAdapter();
        String r3 = null;
        if ((r1 instanceof MoreAdapter) == false) goto L5;
        MoreAdapter r2 = (MoreAdapter) r1;
    L6:
        boolean r4 = true;
        if (r2 != null) goto L9;
        boolean r5 = true;
    L10:
        StringBuilder r6 = new StringBuilder("UIGridGroupItem.bind. gridAdapter?=");
        if (r2 != null) goto L13;
        boolean r7 = true;
    L14:
        r6.append(r7);
        r6.append(", this=");
        r6.append(hashCode());
        r6.append(", itemView=");
        r6.append(r10.hashCode());
        r6.append(", hostStyle=");
        r6.append(this.d);
        r6.append(", payloads=");
        if (r11 == null) goto L19;
        Object[] r8 = r11.toArray(new Object[0]);
        if (r8 == null) goto L19;
        r3 = Arrays.toString(r8);
    L19:
        r6.append(r3);
        tt5.a.h("UIGridGroupItem", r6.toString());
        if (r2 != null) goto L27;
        r2 = new MoreAdapter(this);
        r0.setAdapter(r2);
        Context r12 = r10.getContext();
        if (this.d != ItemUIStyle.DOUBAO) goto L24;
        boolean r9 = true;
    L25:
        r0.setLayoutManager(new MoreItemLinearLayoutManager(r12, r0, r9));
        r0.addItemDecoration(new MoreItemDecoration(this.d));
        r0.setNestedScrollingEnabled(false);
        goto L27
    L24:
        r9 = false;
    L27:
        if (r2.getItemCount() == this.e.a.size()) goto L34;
        com.bytedance.ee.bear.more.protocol3.i r13 = this.e;
        r2.b = r13;
        k r14 = r2.a;
        Iterator<k> r15 = r13.a.iterator();
    L30:
        if (r15.hasNext() == false) goto L32;
        r15.next().b = r14;
        goto L30
    L32:
        r2.notifyDataSetChanged();
        return;
    L34:
        if (r5 == true) goto L49;
        List<? extends Object> r16 = r11;
        if (r16 != null) goto L38;
    L41:
        if (r4 == true) goto L49;
        Iterator<T> r17 = r11.iterator();
    L45:
        if (r17.hasNext() == false) goto L57;
        Object r18 = r17.next();
        if ((r18 instanceof k) == false) goto L45;
        r2.z2((k) r18);
        goto L45
    L57:
        return;
    L38:
        if (r16.isEmpty() == true) goto L41;
        r4 = false;
    L49:
        r2.y2(this.e);
        return;
    L13:
        r7 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
