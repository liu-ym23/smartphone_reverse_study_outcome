package com.bytedance.android.shopping.mall.feed.opt;

import android.content.Context;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallRequestEndManager implements com.bytedance.android.shopping.mall.feed.opt.a {
    public static final Lazy b = null;
    public static final Lazy c = null;
    public final List<com.bytedance.android.shopping.mall.feed.opt.a> a;

    public static final class a {
    }

    static {
        b = LazyKt.lazy(MallRequestEndManager$Companion$liveOptPage$2.INSTANCE);
        c = LazyKt.lazy(MallRequestEndManager$Companion$imageOptPage$2.INSTANCE);
    }

    public MallRequestEndManager(String r3) {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        if (((ArrayList) b.getValue()).contains(r3) == false) goto L6;
        r0.add(new MallLiveCardOpt());
    L6:
        if (((ArrayList) c.getValue()).contains(r3) == false) goto L9;
        r0.add(new c());
        return;
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void a(Context r3, HomePageDTO r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.mall.feed.opt.a) r0.next()).a(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void b(Context r3, HomePageDTO r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.mall.feed.opt.a) r0.next()).b(r3, r4);
        goto L4
    }
}
