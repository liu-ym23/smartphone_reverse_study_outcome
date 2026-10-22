package com.bytedance.ee.bear.templates.center.list.system;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter;
import com.bytedance.ee.bear.templates.center.list.base.p;
import com.bytedance.ee.bear.templates.center.list.base.q;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BaseTemplateListPresenter {
    public final Fragment l;
    public final SystemTemplateListModel m;
    public final com.bytedance.ee.bear.templates.center.list.system.b n;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.center.list.system.a$a, reason: collision with other inner class name */
    public static final class C0185a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ CategoryTab a;
        public final /* synthetic */ a b;
        public final /* synthetic */ int c;

        public b(CategoryTab r1, a r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            TemplateGroupTab r5 = (TemplateGroupTab) r4;
            if (Intrinsics.areEqual(this.a, this.b.n.j) == false) goto L6;
            this.b.K8(r5.getCategoryTabList(), this.c, r5.getSource());
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CategoryTab a;
        public final /* synthetic */ a b;
        public final /* synthetic */ Ref.BooleanRef c;
        public final /* synthetic */ int d;

        public c(CategoryTab r1, a r2, Ref.BooleanRef r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r4) {
            TemplateGroupTab r5 = (TemplateGroupTab) r4;
            if (Intrinsics.areEqual(this.a, this.b.n.j) == false) goto L19;
            a r0 = this.b;
            String r1 = r5.getShareIndex();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.f = r1;
            this.b.n.b0();
            com.bytedance.ee.bear.templates.center.list.system.b r2 = this.b.n;
            boolean r3 = r5.getHasMore();
            r5.getSource();
            r2.Q(r3);
            if (r5.getHasData() == true) goto L8;
            return;
        L8:
            if (r5.getHasMore() == true) goto L10;
            return;
        L10:
            if (this.c.element == true) goto L18;
            CategoryTab r6 = this.a;
            if (r6 == null) goto L14;
            r6.setPageNumber(this.d + 1);
        L14:
            this.c.element = true;
            return;
        L18:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e("SystemTemplateListPresenter", "loadMoreError()...", (Throwable) r4, false);
            this.a.n.Q(true);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter, com.bytedance.ee.bear.templates.center.list.base.q.a
    public final void a() {
        CategoryTab r0 = this.n.j;
        if (r0 == null) goto L5;
        long r1 = r0.getCategoryId();
    L6:
        long r6 = r1;
        if (r0 == null) goto L9;
        int r2 = r0.getPageNumber();
    L10:
        tt5.a.h("SystemTemplateListPresenter", "loadMore()...index = " + this.f + " pageNumber=" + r2 + " categoryId=" + r6);
        this.e.add(this.m.N7(this.f, L8(), r6, r2).observeOn(fo5.d.e()).doOnNext(new b(r0, this, r2)).observeOn(fo5.d.d()).subscribe(new c(r0, this, new Ref.BooleanRef(), r2), new d(this)));
        return;
    L9:
        r2 = 1;
        goto L10
    L5:
        r1 = -1;
        goto L6
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter
    public final Fragment M8() {
        return this.l;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter
    public final p N8() {
        return this.m;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter
    public final q P8() {
        return this.n;
    }

    public a(Fragment r2, SystemTemplateListModel r3, com.bytedance.ee.bear.templates.center.list.system.b r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "view");
        super(r2, r3, r4, r2.getString(2131888016));
        this.l = r2;
        this.m = r3;
        this.n = r4;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter
    public final void K8(ArrayList<CategoryTab> r20, int r21, int r22) {
        Intrinsics.checkNotNullParameter(r20, "categoryTabList");
        CategoryTab r2 = this.n.j;
        if (r2 != null) goto L5;
        return;
    L5:
        List<ao5.a> r3 = r2.getCategoryList();
        if (r3.isEmpty() == false) goto L8;
        return;
    L8:
        Iterator<CategoryTab> r1 = r20.iterator();
    L10:
        if (r1.hasNext() == false) goto L52;
        List<ao5.a> r4 = r1.next().getCategoryList();
        Iterator<ao5.a> r5 = r3.iterator();
    L13:
        if (r5.hasNext() == false) goto L10;
        ao5.a r6 = r5.next();
        Iterator<ao5.a> r7 = r4.iterator();
    L16:
        if (r7.hasNext() == false) goto L13;
        ao5.a r8 = r7.next();
        if (BaseTemplateListPresenter.Q8(r6, r8) == false) goto L16;
        if ((!r8.c.isEmpty()) == false) goto L16;
        if (r6.g.get(Integer.valueOf(r21)) != null) goto L25;
        r6.g.put(Integer.valueOf(r21), r8.c);
    L27:
        boolean r9 = true;
    L29:
        if (r9 == false) goto L16;
        List r10 = CollectionsKt.sorted(CollectionsKt.toList(r6.g.keySet()));
        r6.c.clear();
        r6.f.clear();
        Iterator r11 = r10.iterator();
    L32:
        if (r11.hasNext() == false) goto L48;
        List<TemplateV4> r12 = r6.g.get(Integer.valueOf(((Number) r11.next()).intValue()));
        if (r12 == null) goto L32;
        Iterator<T> r13 = r12.iterator();
    L37:
        if (r13.hasNext() == false) goto L32;
        TemplateV4 r14 = (TemplateV4) r13.next();
        if (r6.f.containsKey(r14.getId()) == false) goto L40;
        TemplateV4 r15 = r6.f.get(r14.getId());
        long r16 = r14.getUpdateTime();
        if (r15 == null) goto L44;
        long r17 = r15.getUpdateTime();
    L46:
        if (r16 <= r17) goto L37;
        TypeIntrinsics.asMutableCollection(r6.c).remove(r15);
        r6.c.add(r14);
        r6.f.put(r14.getId(), r14);
        goto L37
    L44:
        r17 = 0;
        goto L46
    L40:
        r6.c.add(r14);
        r6.f.put(r14.getId(), r14);
        goto L37
    L48:
        r6.b = r8.b;
        goto L16
    L25:
        if (r22 != 2) goto L28;
        r6.g.put(Integer.valueOf(r21), r8.c);
        goto L27
    L28:
        r9 = false;
        goto L29
    L52:
        Iterator<ao5.a> r18 = r3.iterator();
    L54:
        if (r18.hasNext() == false) goto L58;
        ao5.a r19 = r18.next();
        if (r19.e == true) goto L54;
        r19.e = true;
        goto L54
    }
}
