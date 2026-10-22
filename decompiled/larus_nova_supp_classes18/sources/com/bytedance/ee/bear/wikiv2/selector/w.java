package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import iq5.d0;
import iq5.e0;
import iq5.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w extends com.larksuite.framework.mvp.a<n.a> implements n {
    public final View b;
    public final SelectorConfig c;
    public final ce5.a d;
    public n.a e;
    public RootSelectAdapter f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ w a;

        public b(w r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            n.a r2 = this.a.e;
            if (r2 == null) goto L6;
            r2.onCancelClick();
            return;
        }
    }

    public static final class c extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ w c;

        public c(w r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            tt5.a.h("RootSelectView", "on search click.");
            n.a r3 = this.c.e;
            if (r3 == null) goto L6;
            r3.p();
            return;
        }
    }

    public static final class d implements iq5.r {
        public final /* synthetic */ w a;

        @Override // iq5.r
        public final void a() {
            n.a r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.r3();
            return;
        }

        public d(w r1) {
            this.a = r1;
        }

        @Override // iq5.r
        public final void b(int r3) {
            tt5.a.h("RootSelectView", "onClickWiki()...position = " + r3);
            n.a r4 = this.a.e;
            if (r4 == null) goto L6;
            r4.M5();
            return;
        }

        @Override // iq5.r
        public final void c(int r3) {
            tt5.a.h("RootSelectView", "onClickMyFolder()...position = " + r3);
            n.a r4 = this.a.e;
            if (r4 == null) goto L6;
            r4.k6();
            return;
        }

        @Override // iq5.r
        public final void d(int r3) {
            tt5.a.h("RootSelectView", "onClickMyShareFolder()...position = " + r3);
            n.a r4 = this.a.e;
            if (r4 == null) goto L6;
            r4.h2();
            return;
        }
    }

    static {
    }

    public final void destroy() {
        ((com.larksuite.framework.mvp.a) this).a = null;
        tt5.a.h("RootSelectView", "destroy()...");
        this.e = null;
    }

    public final void create() {
        tt5.a.h("RootSelectView", "create()...");
        BaseTitleBar r0 = (BaseTitleBar) this.b.findViewById(2131393246);
        boolean r1 = false;
        r0.setLeftIconVisibility(false);
        r0.setLeftText(this.b.getContext().getString(2131887716));
        r0.setLeftTextColor(this.b.getContext().getResources().getColorStateList(2131101926));
        r0.setTitle(this.c.b);
        r0.setLeftClickListener(new b(this));
        LinearLayout r2 = (LinearLayout) this.b.findViewById(2131393245);
        Set<SelectorType> r3 = x.a;
        boolean r4 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        SelectorType r5 = this.c.a;
        Intrinsics.checkNotNullParameter(r5, "selectorType");
        Intrinsics.checkNotNullParameter(r5, "selectorType");
        if (r4 == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L10;
        r2.setVisibility(8);
    L11:
        RecyclerView r7 = this.b.findViewById(2131393244);
        r7.setLayoutManager(new LinearLayoutManager(this.b.getContext()));
        RootSelectAdapter r8 = new RootSelectAdapter(this.b.getContext(), new ArrayList());
        this.f = r8;
        r8.b = new d(this);
        r7.setAdapter(r8);
        k();
        RootSelectAdapter r9 = this.f;
        RootSelectAdapter r10 = null;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r9 = null;
    L14:
        Iterator r11 = r9.getData().iterator();
    L16:
        if (r11.hasNext() == false) goto L20;
        Object r12 = r11.next();
        if ((((iq5.p) r12) instanceof o) == false) goto L16;
    L22:
        if (((iq5.p) r12) != null) goto L43;
        int r13 = o.b;
        if (o.a.b(this.c.f) == true) goto L26;
    L41:
        Unit r14 = Unit.INSTANCE;
        goto L43
    L26:
        if (o.a.a() == false) goto L41;
        Set<SelectorType> r15 = x.a;
        boolean r16 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        SelectorType r17 = this.c.a;
        Intrinsics.checkNotNullParameter(r17, "selectorType");
        if (r16 == true) goto L30;
    L32:
        boolean r18 = false;
    L33:
        if (r18 == true) goto L41;
        String r19 = dq5.j.a(this.d);
        if (r19 != null) goto L37;
    L38:
        r1 = true;
    L39:
        if (r1 == false) goto L41;
        int r20 = dq5.j.a;
        up5.g.a(dq5.j.b(this.d).subscribe(new iq5.v(this), iq5.w.a), new CompositeDisposable());
        goto L41
    L37:
        if (r19.length() != 0) goto L39;
    L30:
        if (x.a.contains(r17) == false) goto L32;
        r18 = true;
    L43:
        if (this.c.c == false) goto L53;
        com.bytedance.ee.bear.wikiv2.a r21 = new com.bytedance.ee.bear.wikiv2.a(this.b.getContext());
        r21.setViewDelegate(this.e);
        RootSelectAdapter r22 = this.f;
        if (r22 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L48:
        r10.addHeaderView(r21);
        return;
    L47:
        r10 = r22;
        goto L48
    L53:
        return;
    L20:
        r12 = null;
        goto L22
    L10:
        r2.setOnClickListener(new c(this));
        goto L11
    L5:
        if (x.a.contains(r5) == false) goto L7;
        r6 = true;
        goto L8
    }

    public final void k() {
        ArrayList r0 = new ArrayList();
        SelectorScope r1 = this.c.f;
        CollectionsKt.listOf(new SelectorType[]{SelectorType.WIKI_MOVE_TO, SelectorType.WIKI_SHORTCUT_TO, SelectorType.WIKI_MAKE_COPY_TO, SelectorType.WIKI_CREATE_TO}).contains(this.c.a);
        if (qc5.a.h() == true) goto L5;
        h(r0, new iq5.p[]{new o(r1), new iq5.q(r1), new d0(r1), new e0(r1)});
    L6:
        RootSelectAdapter r2 = this.f;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r2 = null;
    L9:
        r2.setNewData(r0);
        return;
    L5:
        h(r0, new iq5.p[]{new o(r1), new e0(r1), new iq5.a(new iq5.q(r1), new d0(r1)), new iq5.q(r1), new d0(r1)});
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n
    public final void I(List<? extends Document> r3) {
        if (hu5.a.f(r3) == false) goto L12;
        p r0 = new p(this.b.getContext());
        r0.setViewDelegate(this.e);
        FolderSelectAdapter r1 = r0.a;
        if (r3 != null) goto L7;
        r1.getClass();
        r3 = new ArrayList();
    L7:
        r1.c = r3;
        r0.a.notifyDataSetChanged();
        RootSelectAdapter r4 = this.f;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r4 = null;
    L10:
        r4.addFooterView(r0);
        return;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.e = (n.a) r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.n
    public final void u1(List<? extends RecentOperationResult.a> r3) {
        if (hu5.a.f(r3) == false) goto L9;
        q r0 = new q(this.b.getContext());
        r0.setViewDelegate(this.e);
        RecentOperationAdapter r1 = r0.a;
        r1.b = r3;
        r1.notifyDataSetChanged();
        r0.setUserComponentAbility(this.d);
        RootSelectAdapter r4 = this.f;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r4 = null;
    L7:
        r4.addFooterView(r0);
        return;
    }

    public final void h(List<iq5.p> r8, iq5.p... r9) {
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L25;
        iq5.p r3 = r9[r2];
        if (r3.a(this.d) == false) goto L24;
        Set<SelectorType> r4 = x.a;
        boolean r5 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        SelectorType r6 = this.c.a;
        Intrinsics.checkNotNullParameter(r6, "selectorType");
        boolean r7 = true;
        if (r5 == true) goto L9;
    L11:
        boolean r10 = false;
    L12:
        if (r10 == true) goto L15;
    L21:
        r7 = false;
    L22:
        if (r7 == true) goto L24;
        ((ArrayList) r8).add(r3);
        goto L24
    L15:
        if ((r3 instanceof o) == true) goto L22;
        if ((r3 instanceof e0) == true) goto L22;
        if ((r3 instanceof d0) == false) goto L21;
    L9:
        if (x.a.contains(r6) == false) goto L11;
        r10 = true;
    L24:
        r2 = r2 + 1;
        goto L3
    }

    public w(View r2, SelectorConfig r3, ce5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "selectorConfig");
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
