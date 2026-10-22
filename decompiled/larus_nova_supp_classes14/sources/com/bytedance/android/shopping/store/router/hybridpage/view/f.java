package com.bytedance.android.shopping.store.router.hybridpage.view;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.shopping.store.router.hybridpage.event.PageCardEventManager;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements com.bytedance.android.ec.hybrid.list.ability.c {
    public final /* synthetic */ b a;
    public final /* synthetic */ LifecycleOwner b;

    public final void release() {
    }

    public f(b r1, LifecycleOwner r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void aW(ECHybridListItemVO r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "itemDataVO");
        ReentrantReadWriteLock r0 = PageCardEventManager.a;
        b r1 = this.a;
        String r2 = r1.Q3;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r6 = r1.d0();
        if (r6 != null) goto L8;
        r6 = "hybrid_list";
    L8:
        PageCardEventManager.e(r2, r6, r5, r4, r3);
    }

    public final void gZ(ECHybridListItemVO r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        ReentrantReadWriteLock r0 = PageCardEventManager.a;
        b r1 = this.a;
        String r2 = r1.Q3;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r6 = r1.d0();
        if (r6 != null) goto L8;
        r6 = "hybrid_list";
    L8:
        PageCardEventManager.d(r2, r6, r5, r4, r3);
    }

    public final void vA(ECHybridListItemVO r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "itemData");
        ReentrantReadWriteLock r0 = PageCardEventManager.a;
        b r1 = this.a;
        String r2 = r1.Q3;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r3 = r2;
        String r4 = r1.d0();
        if (r4 != null) goto L8;
        r4 = "hybrid_list";
    L8:
        PageCardEventManager.c(r3, r4, r11, r10, r9, r9.K);
    }
}
