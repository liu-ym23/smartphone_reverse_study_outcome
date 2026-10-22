package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class PdpRecyclerViewPoolTrimManager$trimTo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $cacheSize;

    public PdpRecyclerViewPoolTrimManager$trimTo$1(int r1) {
        this.$cacheSize = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2604invoke() {
        List<WeakReference<RecyclerView>> r0 = p.a;
        p.b = Integer.valueOf(this.$cacheSize);
        List<WeakReference<RecyclerView>> r1 = p.a;
        CollectionsKt.removeAll(r1, AnonymousClass1.INSTANCE);
        Iterator r2 = ((ArrayList) r1).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        RecyclerView r3 = (RecyclerView) ((WeakReference) r2.next()).get();
        if (r3 == null) goto L4;
        List<WeakReference<RecyclerView>> r4 = p.a;
        p.a(r3, this.$cacheSize);
        goto L4
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2604invoke();
        return Unit.INSTANCE;
    }
}
