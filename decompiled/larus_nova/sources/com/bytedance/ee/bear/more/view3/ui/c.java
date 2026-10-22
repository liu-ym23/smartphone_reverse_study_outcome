package com.bytedance.ee.bear.more.view3.ui;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.view3.MoreAdapter;
import com.larus.nova.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ee.bear.more.protocol3.i f235066e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        if (this.f234904d != ItemUIStyle.DOUBAO) goto L5;
        return R.layout.more_v3_item_grid_group_doubao;
    L5:
        return R.layout.more_v3_item_grid_group;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final com.bytedance.ee.bear.more.protocol3.i d() {
        return this.f235066e;
    }

    public c(String r100, com.bytedance.ee.bear.more.protocol3.i r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "items");
        super(r100);
        this.f235066e = r101;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void b(View r110, List<? extends Object> r111) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        RecyclerView r100 = (RecyclerView) r110.findViewById(R.id.gridRecycler);
        RecyclerView.Adapter r101 = r100.getAdapter();
        String r102 = null;
        if ((r101 instanceof MoreAdapter) == false) goto L5;
        MoreAdapter r103 = (MoreAdapter) r101;
    L6:
        boolean r104 = true;
        if (r103 != null) goto L9;
        boolean r105 = true;
    L10:
        StringBuilder r106 = new StringBuilder("UIGridGroupItem.bind. gridAdapter?=");
        if (r103 != null) goto L13;
        boolean r107 = true;
    L14:
        r106.append(r107);
        r106.append(", this=");
        r106.append(hashCode());
        r106.append(", itemView=");
        r106.append(r110.hashCode());
        r106.append(", hostStyle=");
        r106.append(this.f234904d);
        r106.append(", payloads=");
        if (r111 == null) goto L19;
        Object[] r108 = r111.toArray(new Object[0]);
        if (r108 == null) goto L19;
        r102 = Arrays.toString(r108);
    L19:
        r106.append(r102);
        tt5.a.h("UIGridGroupItem", r106.toString());
        if (r103 != null) goto L27;
        r103 = new MoreAdapter(this);
        r100.setAdapter(r103);
        Context r112 = r110.getContext();
        if (this.f234904d != ItemUIStyle.DOUBAO) goto L24;
        boolean r109 = true;
    L25:
        r100.setLayoutManager(new MoreItemLinearLayoutManager(r112, r100, r109));
        r100.addItemDecoration(new MoreItemDecoration(this.f234904d));
        r100.setNestedScrollingEnabled(false);
        goto L27
    L24:
        r109 = false;
    L27:
        if (r103.getItemCount() == this.f235066e.f234895a.size()) goto L34;
        com.bytedance.ee.bear.more.protocol3.i r113 = this.f235066e;
        r103.f235010b = r113;
        k r114 = r103.f235009a;
        Iterator<k> r115 = r113.f234895a.iterator();
    L30:
        if (r115.hasNext() == false) goto L32;
        r115.next().f234902b = r114;
        goto L30
    L32:
        r103.notifyDataSetChanged();
        return;
    L34:
        if (r105 == true) goto L49;
        List<? extends Object> r116 = r111;
        if (r116 != null) goto L38;
    L41:
        if (r104 == true) goto L49;
        Iterator<T> r117 = r111.iterator();
    L45:
        if (r117.hasNext() == false) goto L57;
        Object r118 = r117.next();
        if ((r118 instanceof k) == false) goto L45;
        r103.z2((k) r118);
        goto L45
    L57:
        return;
    L38:
        if (r116.isEmpty() == true) goto L41;
        r104 = false;
    L49:
        r103.y2(this.f235066e);
        return;
    L13:
        r107 = false;
        goto L14
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
