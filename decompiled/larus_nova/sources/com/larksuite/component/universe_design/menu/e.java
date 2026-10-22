package com.larksuite.component.universe_design.menu;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements c.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<g> f285135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.f f285136b;

    @Override // com.larksuite.component.universe_design.menu.c.g
    public final ViewGroup create(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = h.f285139a;
        List<g> r102 = this.f285135a;
        c.f r103 = this.f285136b;
        List<Integer> r104 = r103.f285098h;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "itemList");
        Intrinsics.checkNotNullParameter(r104, "dividerPositions");
        RecyclerView r105 = new RecyclerView(r100);
        r105.setOverScrollMode(2);
        r105.setLayoutManager(new LinearLayoutManager(r100));
        h.b r106 = new h.b(r100);
        Intrinsics.checkNotNullParameter(r102, "dataList");
        r106.f285141b.clear();
        r106.f285141b.addAll(r102);
        r106.notifyDataSetChanged();
        if (r106.f285142c == false) goto L5;
        r106.f285142c = false;
        r106.notifyDataSetChanged();
    L5:
        r105.setAdapter(r106);
        r105.addItemDecoration(new MenuDividerItemDecoration(r100, r104));
        int r107 = (int) new UDDimension.Dp(4.0f).toPixels(r100);
        r105.setPadding(r107, r107, r107, r107);
        r105.setClipToPadding(false);
        FrameLayout r108 = new FrameLayout(r100);
        r108.setBackground(ContextCompat.getDrawable(r100, R.drawable.ud_menu_container_bg));
        r108.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r108.addView(r105);
        return r108;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(List<? extends g> r100, c.f r101) {
        this.f285135a = r100;
        this.f285136b = r101;
    }
}
