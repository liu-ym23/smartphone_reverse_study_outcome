package com.larus.home.impl.main.side_bar.feed.arch;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class CardFeedSlot implements eb9.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<eb9.o<?>, Unit> f344554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends eb9.o<?>> f344555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f344556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f344557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<fb9.a> f344558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final fb9.i f344559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final fb9.f f344560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FlowFeedAdapter f344561i;

    @Override // eb9.s
    public final void release() {
    }

    public final void a() {
        if (this.f344557e == false) goto L5;
    L7:
        this.f344555c = CollectionsKt.emptyList();
        this.f344557e = false;
        this.f344556d++;
        this.f344561i.submitList(null);
        return;
    L5:
        if (this.f344561i.getItemCount() != 0) goto L7;
    }

    @Override // eb9.s
    public final List<fb9.a> getAbilities() {
        return this.f344558f;
    }

    @Override // eb9.s
    public final RecyclerView.Adapter getAdapter() {
        return this.f344561i;
    }

    @Override // eb9.s
    public final String getId() {
        return this.f344553a;
    }

    public final void b(List<? extends eb9.o<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "cards");
        fb9.i r101 = this.f344559g;
        if (r101 == null) goto L8;
        List<eb9.o<?>> r102 = r101.b(r100);
        if (r102 == null) goto L8;
        r100 = r102;
    L8:
        c(r100, "data", false);
    }

    public final void c(final List<? extends eb9.o<?>> r110, String r111, final boolean r112) {
        if (r110.isEmpty() == true) goto L5;
    L10:
        int r100 = this.f344555c.size();
        int r101 = this.f344561i.getItemCount();
        this.f344555c = r110;
        final int r102 = this.f344556d + 1;
        this.f344556d = r102;
        if (this.f344557e == true) goto L13;
    L20:
        boolean r103 = true;
    L21:
        this.f344557e = true;
        if (r103 == false) goto L24;
        int r104 = t.f344637a;
        t.c("cards_submit", "source=" + this.f344553a + " sourceRef=" + t.e(this) + " adapter=" + t.e(this.f344561i) + " gen=" + r102 + " reason=" + r111 + " accepted=" + r100 + "->" + r110.size() + " committed=" + r101);
    L24:
        final boolean r105 = r103;
        this.f344561i.submitList(r110, new a(r105, this, r102, r110, r112));
        return;
    L13:
        if (Intrinsics.areEqual(r111, "data") == false) goto L20;
        if (r100 != r110.size()) goto L20;
        if (r101 != r110.size()) goto L20;
        r103 = false;
        goto L21
    L5:
        if (this.f344557e == true) goto L10;
        if (this.f344561i.getItemCount() != 0) goto L10;
        this.f344555c = r110;
        int r106 = t.f344637a;
        t.c("cards_skip_empty", "source=" + this.f344553a + " adapter=" + t.e(this.f344561i) + " reason=" + r111);
    }

    public /* synthetic */ CardFeedSlot(String r100, w r101, Fragment r110, RecyclerView r111, Function1 r112) {
        this(r100, r101, r110, r111, CollectionsKt.emptyList(), r112);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.home.impl.main.side_bar.feed.arch.b] */
    public CardFeedSlot(String r100, w r101, Fragment r102, RecyclerView r110, List<? extends fb9.a> r111, Function1<? super eb9.o<?>, Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "registry");
        Intrinsics.checkNotNullParameter(r102, "host");
        Intrinsics.checkNotNullParameter(r110, "recyclerView");
        Intrinsics.checkNotNullParameter(r111, "abilities");
        Intrinsics.checkNotNullParameter(r112, "cardSelectionHandler");
        this.f344553a = r100;
        this.f344554b = r112;
        this.f344555c = CollectionsKt.emptyList();
        List r103 = CollectionsKt.createListBuilder();
        r103.addAll(r111);
        List r113 = r103;
        boolean r114 = r113 instanceof Collection;
        boolean r104 = true;
        if (r114 == true) goto L5;
    L7:
        Iterator r105 = r113.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        if ((((fb9.a) r105.next()) instanceof fb9.i) == false) goto L9;
        boolean r106 = false;
    L14:
        if (r106 == false) goto L16;
        r103.add(new rb9.d(this.f344554b, new b(this), new CardFeedSlot$abilities$1$3(this)));
    L16:
        if (r114 == true) goto L18;
    L20:
        Iterator r115 = r113.iterator();
    L22:
        if (r115.hasNext() == false) goto L26;
        if ((((fb9.a) r115.next()) instanceof fb9.f) == false) goto L22;
        r104 = false;
    L26:
        if (r104 == false) goto L28;
        r103.add(rb9.c.f536993a);
    L28:
        List<fb9.a> r107 = CollectionsKt.build(r103);
        this.f344558f = r107;
        ArrayList r116 = new ArrayList();
        Iterator<T> r108 = r107.iterator();
    L30:
        if (r108.hasNext() == false) goto L34;
        Object r117 = r108.next();
        if ((r117 instanceof fb9.i) == false) goto L30;
        r116.add(r117);
        goto L30
    L34:
        this.f344559g = (fb9.i) CollectionsKt.firstOrNull(r116);
        List<fb9.a> r109 = this.f344558f;
        ArrayList r118 = new ArrayList();
        Iterator<T> r119 = r109.iterator();
    L36:
        if (r119.hasNext() == false) goto L40;
        Object r120 = r119.next();
        if ((r120 instanceof fb9.f) == false) goto L36;
        r118.add(r120);
        goto L36
    L40:
        this.f344560h = (fb9.f) CollectionsKt.firstOrNull(r118);
        this.f344561i = new FlowFeedAdapter(r101, new c(r102, r110, this.f344558f));
        return;
    L18:
        if (r113.isEmpty() == false) goto L20;
    L13:
        r106 = true;
        goto L14
    L5:
        if (r113.isEmpty() == false) goto L7;
        goto L7
    }
}
