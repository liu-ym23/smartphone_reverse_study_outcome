package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.view3.MoreAdapter;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.n;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends k {
    public final com.bytedance.ee.bear.more.protocol3.i e;
    public final String f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        if (this.d != ItemUIStyle.DOUBAO) goto L5;
        return 2131563693;
    L5:
        return 2131563692;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final com.bytedance.ee.bear.more.protocol3.i d() {
        return this.e;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void b(View r10, List<? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "itemView");
        TextView r0 = (TextView) r10.findViewById(2131388772);
        RecyclerView r1 = r10.findViewById(2131392216);
        String r2 = this.f;
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        r0.setText(r2);
        String r3 = this.f;
        boolean r4 = true;
        if (r3 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        int r6 = 8;
    L16:
        r0.setVisibility(r6);
        RecyclerView.Adapter r7 = r1.getAdapter();
        String r8 = null;
        if ((r7 instanceof MoreAdapter) == false) goto L19;
        MoreAdapter r9 = (MoreAdapter) r7;
    L20:
        if (r9 != null) goto L22;
        boolean r12 = true;
    L23:
        StringBuilder r13 = new StringBuilder("UILinearGroupItem.bind. linearAdapter?=");
        if (r9 != null) goto L26;
        boolean r14 = true;
    L27:
        r13.append(r14);
        r13.append(", this=");
        r13.append(hashCode());
        r13.append(", itemView=");
        r13.append(r10.hashCode());
        r13.append(", hostStyle=");
        r13.append(this.d);
        r13.append(", payloads=");
        if (r11 == null) goto L32;
        Object[] r15 = r11.toArray(new Object[0]);
        if (r15 == null) goto L32;
        r8 = Arrays.toString(r15);
    L32:
        r13.append(r8);
        tt5.a.h("UILinearGroupItem", r13.toString());
        if (r9 != null) goto L39;
        r9 = new MoreAdapter(this);
        r1.setAdapter(r9);
        r1.setLayoutManager(new LinearLayoutManagerWrapper(r10.getContext()));
        r1.setNestedScrollingEnabled(false);
        r1.addItemDecoration(new CornerRadiusItemDecoration(this.d));
        int r16 = n.c(0.5f);
        if (this.d != ItemUIStyle.DOUBAO) goto L37;
        int r17 = n.c(53.0f);
    L38:
        r1.addItemDecoration(new DividerItemDecoration(r16, r17, r1.getResources().getColor(2131103353)));
        goto L39
    L37:
        r17 = n.c(16.0f);
    L39:
        if (r12 == true) goto L54;
        List<? extends Object> r18 = r11;
        if (r18 != null) goto L43;
    L46:
        if (r4 == true) goto L54;
        Iterator<T> r19 = r11.iterator();
    L50:
        if (r19.hasNext() == false) goto L61;
        Object r110 = r19.next();
        if ((r110 instanceof k) == false) goto L50;
        r9.z2((k) r110);
        goto L50
    L61:
        return;
    L43:
        if (r18.isEmpty() == true) goto L46;
        r4 = false;
    L54:
        r9.y2(this.e);
        return;
    L26:
        r14 = false;
        goto L27
    L22:
        r12 = false;
        goto L23
    L19:
        r9 = null;
        goto L20
    L15:
        r6 = 0;
        goto L16
    L9:
        if (r3.length() == 0) goto L12;
        r5 = false;
        goto L13
    }

    public f(String r2, com.bytedance.ee.bear.more.protocol3.i r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "items");
        super(r2);
        this.e = r3;
        this.f = r4;
    }
}
