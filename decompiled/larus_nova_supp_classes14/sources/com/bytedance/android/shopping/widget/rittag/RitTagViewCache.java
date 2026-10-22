package com.bytedance.android.shopping.widget.rittag;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.model.response.RitTagUI;
import com.bytedance.android.shopping.widget.rittag.viewimpl.RitTagSplitView;
import com.bytedance.android.shopping.widget.rittag.viewimpl.RitTagTextView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/widget/rittag/RitTagViewCache;", "Landroidx/lifecycle/LifecycleEventObserver;", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RitTagViewCache implements LifecycleEventObserver {
    public static final Map<? extends Class<? extends Object>, RitTagUI.RitTagUIItem.UIItemType> d = null;
    public static final ConcurrentHashMap<LifecycleOwner, RitTagViewCache> e = null;
    public static final a f = null;
    public final ConcurrentHashMap<RitTagUI.RitTagUIItem.UIItemType, LinkedBlockingQueue<b>> a;
    public final LinkedBlockingQueue<com.bytedance.android.shopping.widget.rittag.viewimpl.d> b;
    public final LifecycleOwner c;

    public static final class a {
        public a() {
        }
    }

    static {
        f = new a();
        d = MapsKt.mapOf(new Pair[]{TuplesKt.to(RitTagTextView.class, RitTagUI.RitTagUIItem.UIItemType.TEXT), TuplesKt.to(com.bytedance.android.shopping.widget.rittag.viewimpl.a.class, RitTagUI.RitTagUIItem.UIItemType.IMAGE), TuplesKt.to(RitTagSplitView.class, RitTagUI.RitTagUIItem.UIItemType.SPLIT)});
        e = new ConcurrentHashMap();
    }

    public RitTagViewCache(LifecycleOwner r1) {
        this.c = r1;
        r1.getLifecycle().addObserver(this);
        this.a = new ConcurrentHashMap();
        this.b = new LinkedBlockingQueue();
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r2.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        this.a.clear();
        this.b.clear();
        return;
    }
}
