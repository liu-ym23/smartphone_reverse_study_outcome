package com.bytedance.ee.bear.list.homepage.banner;

import android.content.Context;
import com.bytedance.ee.bear.contract.e0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.f;
import com.bytedance.ee.bear.list.homepage.banner.g;
import com.bytedance.ee.bear.list.homepage.banner.g.a;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.route.h;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import dd5.q1;
import dd5.s1;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a<M extends f, V extends g<VD>, VD extends g.a> extends BasePresenter<M, V, VD> implements q1 {
    public final LifeCycleFragment a;
    public final Context b;
    public M c;
    public V d;
    public final ce5.a e;
    public final CompositeDisposable f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.homepage.banner.a$a, reason: collision with other inner class name */
    public static final class C0016a {
    }

    public final class b implements g.a {
        public final /* synthetic */ a<M, V, VD> a;

        @Override // com.bytedance.ee.bear.list.homepage.banner.g.a
        public final void t6() {
            this.a.I8();
            lc5.f.a r0 = lc5.f.a;
            com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            String r2 = this.a.J8();
            Intrinsics.checkNotNullParameter(r1, "analyticService");
            Intrinsics.checkNotNullParameter(r2, "module");
            HashMap r3 = new HashMap();
            r3.put("module", r2);
            if (qc5.a.h() == false) goto L5;
            String r4 = "new_format";
        L6:
            r3.put("space_version", r4);
            lc5.f.a.D(r1, "click_folder_all", r3);
            return;
        L5:
            r4 = "original";
            goto L6
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.homepage.banner.g.a
        public final void y1(Document r2, int r3) {
            this.a.N8(r2, r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a<M, V, VD> a;

        public c(a<M, V, VD> r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            ((g) this.a.getView()).l0(new ArrayList());
            ((f) this.a.getModel()).X().removeObservers(this.a.a);
            ((f) this.a.getModel()).d7();
            a.H8(this.a);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a<M, V, VD> a;

        public d(a<M, V, VD> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r0 = this.a.L8();
            tt5.a.f(r0, (Throwable) r3, false);
        }
    }

    static {
    }

    public abstract void I8();

    public abstract String J8();

    public String K8() {
        return "none";
    }

    public String L8() {
        return "BaseBannerPresenter";
    }

    public abstract String M8();

    public final IView.IViewDelegate createViewDelegate() {
        return new b(this);
    }

    public void create() {
        super.create();
        s1.a.a.a(this);
        ((f) getModel()).X().observe(this.a, new com.bytedance.ee.bear.list.homepage.banner.b(this));
    }

    public void destroy() {
        super.destroy();
        this.f.clear();
        s1.a.a.h(this);
    }

    @Override // dd5.q1
    public final void r() {
        tt5.a.h(L8(), "onTenantChanged()...");
        this.f.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new c(this), new d(this)));
    }

    public final Context getContext() {
        return this.b;
    }

    public static final void H8(a r3) {
        ((f) r3.getModel()).X().observe(r3.a, new com.bytedance.ee.bear.list.homepage.banner.b(r3));
    }

    public void O8(ArrayList<Document> r6) {
        String r0 = L8();
        StringBuilder r1 = new StringBuilder("onListChange list = ");
        Integer r2 = null;
        if (r6 == null) goto L5;
        Integer r3 = Integer.valueOf(r6.size());
    L6:
        r1.append(r3);
        tt5.a.h(r0, r1.toString());
        ((f) getModel()).C4(r6);
        ArrayList<Document> r7 = ((f) getModel()).getList();
        ArrayList<Document> r4 = dd5.a.a(r7, this.e.d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible"));
        if (r7 == null) goto L9;
        Integer r5 = Integer.valueOf(r7.size());
    L10:
        if (r4 == null) goto L13;
        r2 = Integer.valueOf(r4.size());
    L13:
        if (Intrinsics.areEqual(r5, r2) == true) goto L24;
        String r8 = L8();
        StringBuilder r9 = new StringBuilder("ai_artifact_folder_display_filter, rawSize=");
        if (r7 == null) goto L17;
        int r10 = r7.size();
    L18:
        r9.append(r10);
        r9.append(", visibleSize=");
        if (r4 == null) goto L21;
        int r11 = r4.size();
    L22:
        r9.append(r11);
        tt5.a.h(r8, r9.toString());
        goto L24
    L21:
        r11 = 0;
        goto L22
    L17:
        r10 = 0;
    L24:
        if (r4 != null) goto L26;
    L29:
        boolean r12 = true;
    L30:
        if (r12 == false) goto L33;
        ((g) getView()).l0(new ArrayList());
        ((g) getView()).l6(false);
        return;
    L33:
        ((g) getView()).l6(true);
        ((g) getView()).j4(((f) getModel()).hasMore());
        ((g) getView()).l0(r4);
        return;
    L26:
        if (r4.isEmpty() == true) goto L29;
        r12 = false;
        goto L30
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public void N8(Document r20, int r21) {
        if (r20 == null) goto L35;
        String r1 = r20.p;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        return;
    L14:
        if (j.a.a.getNetworkState().a() == false) goto L16;
    L19:
        h r12 = (h) org.koin.java.a.c(h.class, null, null, 6);
        String r13 = r20.p + M8();
        Context r3 = this.b;
        String r15 = J8();
        ArrayList r16 = new ArrayList();
        String r17 = K8();
        Context r4 = new e0(r3, r20, r15, r16, r17, "home").getContext();
        if (r20.getType() != sbb.e.f.b) goto L23;
        sd5.e r5 = new sd5.c(r4, r15, 1, "");
    L29:
        r12.m9(r13, r5.a(r20));
        lc5.f.a r6 = lc5.f.a;
        com.bytedance.ee.bear.contract.d r7 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        String r8 = J8();
        Intrinsics.checkNotNullParameter(r7, "analyticService");
        Intrinsics.checkNotNullParameter(r8, "module");
        HashMap r9 = new HashMap();
        String r10 = du5.b.g(r20.d);
        r9.put("module", r8);
        Intrinsics.checkNotNull(r20);
        r9.put("file_type", sbb.e.c(r20.getType()));
        r9.put("file_id", r10);
        r9.put("location", String.valueOf(r21 + 1));
        r9.put("folder_level", "0");
        r9.put("sequence_num", String.valueOf(r21));
        if (qc5.a.h() == false) goto L32;
        String r11 = "new_format";
    L33:
        r9.put("space_version", r11);
        r7.v("click_list_item", r9);
        return;
    L32:
        r11 = "original";
        goto L33
    L23:
        if (r20.getType() != sbb.e.l.b) goto L26;
        r5 = new sd5.b(new e0(r4, r20, r15, r16, r17, "home"), "");
        goto L29
    L26:
        if (r20.getType() != sbb.e.n.b) goto L28;
        r5 = new sd5.g();
        goto L29
    L28:
        r5 = new sd5.a(r4);
        goto L29
    L16:
        if (t0.c(r20) == true) goto L19;
        tt5.a.h(L8(), "onItemClick()...can not open offline");
        Context r14 = this.b;
        Toast.showText(r14, r14.getString(2131887939), 0);
        return;
    L7:
        if (StringsKt.isBlank(r1) == true) goto L10;
        r2 = false;
        goto L11
    }

    public a(LifeCycleFragment r2, Context r3, BaseBannerModel r4, com.bytedance.ee.bear.list.homepage.banner.c r5, ce5.a r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "model");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "userComponentAbility");
        super(r4, r5);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = new CompositeDisposable();
    }
}
