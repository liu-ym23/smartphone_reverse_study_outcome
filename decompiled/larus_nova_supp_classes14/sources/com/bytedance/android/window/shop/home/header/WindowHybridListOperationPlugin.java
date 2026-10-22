package com.bytedance.android.window.shop.home.header;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowHybridListOperationPlugin extends ECWindowJsbPlugin {
    public final LifecycleOwner b;
    public final ECWindowViewModel c;
    public final ECHybridListEngine d;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;

        public static final class a {
        }

        static {
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            Intrinsics.checkNotNullParameter(r3, "secAuthorId");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<com.bytedance.android.window.shop.home.tab.tabplugin.c> c() {
        return CollectionsKt.listOf(new com.bytedance.android.window.shop.home.tab.tabplugin.c[]{new com.bytedance.android.window.shop.home.tab.tabplugin.c("ecom.window.header_state_transform", new WindowHybridListOperationPlugin$createJsbActions$1(this)), new com.bytedance.android.window.shop.home.tab.tabplugin.c("ecom.window.header_hybrid_list_update", new WindowHybridListOperationPlugin$createJsbActions$2(this))});
    }

    public WindowHybridListOperationPlugin(Fragment r3, ECWindowViewModel r4, ECHybridListEngine r5) {
        Intrinsics.checkNotNullParameter(r3, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "hybridEngine");
        this.b = r3;
        this.c = r4;
        this.d = r5;
        RecyclerView.ItemAnimator r6 = r5.b.getItemAnimator();
        if (r6 == null) goto L5;
        r6.setAddDuration(120);
    L5:
        RecyclerView.ItemAnimator r7 = r5.b.getItemAnimator();
        if (r7 == null) goto L9;
        r7.setMoveDuration(120);
        return;
    }
}
