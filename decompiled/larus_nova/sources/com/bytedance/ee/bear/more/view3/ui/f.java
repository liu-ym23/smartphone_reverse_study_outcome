package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.view3.MoreAdapter;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ee.bear.more.protocol3.i f235076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f235077f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        if (this.f234904d != ItemUIStyle.DOUBAO) goto L5;
        return R.layout.more_v3_item_vertical_group_doubao;
    L5:
        return R.layout.more_v3_item_vertical_group;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final com.bytedance.ee.bear.more.protocol3.i d() {
        return this.f235076e;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void b(View r110, List<? extends Object> r111) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        TextView r100 = (TextView) r110.findViewById(R.id.title);
        RecyclerView r101 = (RecyclerView) r110.findViewById(R.id.verticalRecycler);
        String r102 = this.f235077f;
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        r100.setText(r102);
        String r103 = this.f235077f;
        boolean r104 = true;
        if (r103 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        int r106 = 8;
    L16:
        r100.setVisibility(r106);
        RecyclerView.Adapter r107 = r101.getAdapter();
        String r108 = null;
        if ((r107 instanceof MoreAdapter) == false) goto L19;
        MoreAdapter r109 = (MoreAdapter) r107;
    L20:
        if (r109 != null) goto L22;
        boolean r112 = true;
    L23:
        StringBuilder r113 = new StringBuilder("UILinearGroupItem.bind. linearAdapter?=");
        if (r109 != null) goto L26;
        boolean r114 = true;
    L27:
        r113.append(r114);
        r113.append(", this=");
        r113.append(hashCode());
        r113.append(", itemView=");
        r113.append(r110.hashCode());
        r113.append(", hostStyle=");
        r113.append(this.f234904d);
        r113.append(", payloads=");
        if (r111 == null) goto L32;
        Object[] r115 = r111.toArray(new Object[0]);
        if (r115 == null) goto L32;
        r108 = Arrays.toString(r115);
    L32:
        r113.append(r108);
        tt5.a.h("UILinearGroupItem", r113.toString());
        if (r109 != null) goto L39;
        r109 = new MoreAdapter(this);
        r101.setAdapter(r109);
        r101.setLayoutManager(new LinearLayoutManagerWrapper(r110.getContext()));
        r101.setNestedScrollingEnabled(false);
        r101.addItemDecoration(new CornerRadiusItemDecoration(this.f234904d));
        int r116 = n.c(0.5f);
        if (this.f234904d != ItemUIStyle.DOUBAO) goto L37;
        int r117 = n.c(53.0f);
    L38:
        r101.addItemDecoration(new DividerItemDecoration(r116, r117, r101.getResources().getColor(R.color.line_divider_default)));
        goto L39
    L37:
        r117 = n.c(16.0f);
    L39:
        if (r112 == true) goto L54;
        List<? extends Object> r118 = r111;
        if (r118 != null) goto L43;
    L46:
        if (r104 == true) goto L54;
        Iterator<T> r119 = r111.iterator();
    L50:
        if (r119.hasNext() == false) goto L61;
        Object r120 = r119.next();
        if ((r120 instanceof k) == false) goto L50;
        r109.z2((k) r120);
        goto L50
    L61:
        return;
    L43:
        if (r118.isEmpty() == true) goto L46;
        r104 = false;
    L54:
        r109.y2(this.f235076e);
        return;
    L26:
        r114 = false;
        goto L27
    L22:
        r112 = false;
        goto L23
    L19:
        r109 = null;
        goto L20
    L15:
        r106 = 0;
        goto L16
    L9:
        if (r103.length() == 0) goto L12;
        r105 = false;
        goto L13
    }

    public f(String r100, com.bytedance.ee.bear.more.protocol3.i r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "items");
        super(r100);
        this.f235076e = r101;
        this.f235077f = r102;
    }
}
