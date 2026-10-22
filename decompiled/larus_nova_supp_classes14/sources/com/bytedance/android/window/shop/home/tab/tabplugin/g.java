package com.bytedance.android.window.shop.home.tab.tabplugin;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements e {
    public static final fo.a<Set<String>> e = null;
    public static final fo.a<String> f = null;
    public final ECWindowTabScrollEventReportPlugin$scrollReportEventListener$1 a;
    public final RecyclerView b;
    public final String c;
    public final BaseWindowTabViewModel d;

    public static final class a {
    }

    static {
        e = new fo.a("shopwindow_tab_request_id_saver", new Set[0]);
        f = new fo.a("window_tab_newest_request_id", new String[0]);
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void a() {
        this.b.addOnScrollListener(this.a);
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void b() {
        this.b.removeOnScrollListener(this.a);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowTabScrollEventReportPlugin$scrollReportEventListener$1] */
    public g(ECHybridRecyclerView r2, String r3, WindowHybridTabViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "secAuthorId");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new ECWindowTabScrollEventReportPlugin$scrollReportEventListener$1(this);
    }
}
