package com.larus.bmhome.interactionpanel;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tp8.a f312360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f312361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f312362c;

    public static final class a {
    }

    static {
    }

    public k(tp8.a r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Intrinsics.checkNotNullParameter(r101, "manager");
        this.f312360a = r100;
        this.f312361b = r101;
        this.f312362c = new AtomicInteger();
    }

    public static List a(t r100, m r101) {
        if ((r100 instanceof t.b) == false) goto L6;
        List<Block> r102 = ((t.b) r100).f312423b;
    L8:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((Block) r105).getBlockId(), r101.f312374a.f312391c) == false) goto L10;
        r103.add(r105);
        goto L10
    L15:
        if (r103.isEmpty() == true) goto L19;
        r102 = r103;
    L19:
        return r102;
    L6:
        if ((r100 instanceof t.a) == false) goto L21;
        r102 = ((t.a) r100).f312419c;
        goto L8
    L21:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.bmhome.interactionpanel.j] */
    public final boolean b(final m r110, final String r210, Message r211, List<Block> r212, int r213) {
        if (r213 == this.f312362c.get()) goto L7;
        FLogger.f375446a.i("InputAreaBlockPanelAdapter", "skip stale show, key=" + r110.f312374a);
        return false;
    L7:
        if (r212.isEmpty() == false) goto L10;
        FLogger.f375446a.w("InputAreaBlockPanelAdapter", "skip show, blocks empty, key=" + r110.f312374a);
        return false;
    L10:
        Map<Class<?>, ? extends jc8.l> r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(tp8.h.class, new tp8.h(new j(this, r110, r210)))});
        w r101 = r110.f312384k;
        if (r101 == null) goto L13;
        r100.put(w.class, r101);
    L13:
        tp8.a r102 = this.f312360a;
        List<Block> r103 = r212;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L15:
        if (r105.hasNext() == false) goto L17;
        r104.add(Block.copy$default((Block) r105.next(), 0, null, null, null, false, null, null, null, 251, null));
        goto L15
    L17:
        r102.hN(r211, r104, r100);
        return true;
    }
}
