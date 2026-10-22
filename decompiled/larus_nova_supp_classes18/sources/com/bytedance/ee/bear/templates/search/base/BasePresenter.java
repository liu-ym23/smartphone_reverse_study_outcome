package com.bytedance.ee.bear.templates.search.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.templates.TemplateReport;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.mvp.IView;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BasePresenter extends com.larksuite.framework.mvp.BasePresenter<com.bytedance.ee.bear.templates.search.base.e, com.bytedance.ee.bear.templates.search.base.f, com.bytedance.ee.bear.templates.search.base.f.a> implements com.bytedance.ee.bear.templates.search.base.f.a {
    public final Fragment a;
    public final com.bytedance.ee.bear.templates.search.base.e b;
    public final com.bytedance.ee.bear.templates.search.base.f c;
    public final CompositeDisposable d;
    public int e;
    public String f;
    public String g;
    public boolean h;
    public final Lazy i;
    public a j;
    public final f k;

    public static final class a implements ue5.b {
        public final SoftReference<com.bytedance.ee.bear.templates.search.base.f.a> a;

        @Override // ue5.b
        public final void a() {
            tt5.a.h("SearchListPresenter", "ICipherCallback");
            com.bytedance.ee.bear.templates.search.base.f.a r0 = this.a.get();
            if (r0 == null) goto L6;
            r0.l4();
            return;
        }

        public a(SoftReference<com.bytedance.ee.bear.templates.search.base.f.a> r2) {
            Intrinsics.checkNotNullParameter(r2, "delegate");
            this.a = r2;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BasePresenter a;

        public c(BasePresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            BasePresenter r0 = this.a;
            ArrayList<CategoryTab> r10 = ((TemplateGroupTab) r9).getCategoryTabList();
            CategoryTab r1 = r0.J8().s0();
            if (r1 == null) goto L22;
            List<ao5.a> r2 = r1.getCategoryList();
            if (r2.isEmpty() == true) goto L32;
            Iterator<CategoryTab> r11 = r10.iterator();
        L10:
            if (r11.hasNext() == false) goto L33;
            List<ao5.a> r3 = r11.next().getCategoryList();
            Iterator<ao5.a> r4 = r2.iterator();
        L13:
            if (r4.hasNext() == false) goto L10;
            ao5.a r5 = r4.next();
            Iterator<ao5.a> r6 = r3.iterator();
        L16:
            if (r6.hasNext() == false) goto L13;
            ao5.a r7 = r6.next();
            if (Intrinsics.areEqual(r5.a.toString(), r7.a.toString()) == false) goto L16;
            if ((!r7.c.isEmpty()) == false) goto L16;
            r5.c.addAll(r7.c);
            r5.b = r7.b;
            goto L16
        L33:
            return;
        L32:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ BasePresenter a;

        public d(BasePresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            TemplateGroupTab r5 = (TemplateGroupTab) r4;
            this.a.e += r5.getSize();
            this.a.f = r5.getBuffer();
            this.a.J8().b0();
            com.bytedance.ee.bear.templates.search.base.f r0 = this.a.J8();
            boolean r1 = r5.getHasMore();
            r5.getSource();
            r0.Q(r1);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ BasePresenter a;

        public e(BasePresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e("SearchListPresenter", "loadMoreError()...", (Throwable) r4, false);
            this.a.J8().Q(true);
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ BasePresenter a;

        public f(BasePresenter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        L24:
            return;
        L3:
            if (this.a.H8().getUserVisibleHint() == true) goto L5;
            return;
        L5:
            if (this.a.H8().isAdded() == false) goto L22;
            FragmentActivity r0 = this.a.H8().getActivity();     // Catch: Throwable -> L15
            if (r0 == null) goto L11;
            boolean r1 = true;
            if (r0.isFinishing() != true) goto L11;
        L12:
            if (r1 == true) goto L23;
            this.a.J8().d();     // Catch: Throwable -> L15
            return;
        L23:
            return;
        L11:
            r1 = false;
            goto L12
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ BasePresenter a;
        public final /* synthetic */ String b;

        public g(BasePresenter r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            TemplateGroupTab r7 = (TemplateGroupTab) r6;
            j.e(this.a.k);
            if (r7.getErr() == null) goto L7;
            BasePresenter r0 = this.a;
            if (r0.h == true) goto L8;
            r0.J8().m(r7.getErr());
        L8:
            boolean r1 = false;
            r1 = !((ao5.a) ListProtector.get(((CategoryTab) ListProtector.get(r7.getCategoryTabList(), 0)).getCategoryList(), 0)).c.isEmpty();
        L12:
            TemplateReportV2 r8 = TemplateReportV2.a;
            String r9 = this.b;
            String r2 = this.a.I8().getTemplateType();
            Intrinsics.checkNotNullParameter(r2, "templateType");
            JSONObject r3 = new JSONObject();
            r3.put("click_type", "search_input_result");
            r3.put("result", String.valueOf(r1));
            if (TemplateReportV2.e == true) goto L16;
            r9 = "input";
        L16:
            r3.put("keywords", r9);
            if (TemplateReportV2.e == false) goto L19;
            String r10 = "recommend";
        L20:
            r3.put("keywords_type", r10);
            r3.put("template_source", TemplateReportV2.c);
            r3.put("template_type", r2);
            TemplateReportV2.a().n("ccm_template_search_result_view", r3);
            return;
        L19:
            r10 = ThumbGlideUrl.SOURCE_SEARCH;
            goto L20
        L7:
            this.a.h = r7.getHasData();
            this.a.f = r7.getBuffer();
            this.a.e = r7.getSize();
            com.bytedance.ee.bear.templates.search.base.f r4 = this.a.J8();
            Intrinsics.checkNotNull(r7);
            r4.Z(r7);
            goto L8
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ BasePresenter a;

        public h(BasePresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("SearchListPresenter", "loadData err:", r5, false);
            j.e(this.a.k);
            com.bytedance.ee.bear.templates.search.base.f r0 = this.a.J8();
            Intrinsics.checkNotNull(r5);
            r0.m(r5);
        }
    }

    public static final class i implements TemplateUtils.a {
        public final /* synthetic */ BasePresenter a;

        public i(BasePresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.templates.TemplateUtils.a
        public final void onResult(String r5) {
            Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_URL);
            if (this.a.H8().isAdded() == false) goto L20;
            FragmentActivity r0 = this.a.H8().getActivity();
            boolean r1 = false;
            if (r0 != null) goto L7;
        L9:
            boolean r2 = false;
        L10:
            if (r2 == true) goto L21;
            FragmentActivity r3 = this.a.H8().getActivity();
            if (r3 != null) goto L14;
        L16:
            if (r1 == true) goto L22;
            RouteBean r4 = new RouteBean();
            r4.c = 1;
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r5, r4);
            return;
        L22:
            return;
        L14:
            if (r3.isDestroyed() != true) goto L16;
            r1 = true;
            goto L16
        L21:
            return;
        L7:
            if (r0.isFinishing() != true) goto L9;
            r2 = true;
            goto L10
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f.a
    public final void onLoadFailed() {
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f.a
    public final void a() {
        tt5.a.h("SearchListPresenter", "loadMore()...offset = " + this.e + " searchKey=" + this.g);
        this.d.add(I8().D7(this.e, this.g, this.f).observeOn(fo5.d.e()).doOnNext(new c(this)).observeOn(fo5.d.d()).subscribe(new d(this), new e(this)));
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f.a
    public final void l4() {
        Z1(this.g);
    }

    public void create() {
        super.create();
        this.j = new a(new SoftReference(this));
        ((ue5.a) org.koin.java.a.c(ue5.a.class, null, null, 6)).b(this.j);
    }

    public final void destroy() {
        super.destroy();
        if (this.d.isDisposed() == true) goto L6;
        this.d.dispose();
    L6:
        if (this.j == null) goto L9;
        ((ue5.a) org.koin.java.a.c(ue5.a.class, null, null, 6)).a(this.j);
        return;
    }

    public Fragment H8() {
        return this.a;
    }

    public com.bytedance.ee.bear.templates.search.base.e I8() {
        return this.b;
    }

    public com.bytedance.ee.bear.templates.search.base.f J8() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f.a
    public final void Z1(String r14) {
        Intrinsics.checkNotNullParameter(r14, "searchKey");
        this.g = r14;
        boolean r0 = false;
        this.e = 0;
        this.f = "";
        j.d(this.k, 300);
        if (r14.length() != 0) goto L5;
        r0 = true;
    L5:
        if (r0 == false) goto L7;
    L19:
        j.e(this.k);
        J8().Z(new TemplateGroupTab(2, null, false, false, null, null, null, 0, false, 510, null));
        return;
    L7:
        if (r14.length() > 1000) goto L19;
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L13;
        j.e(this.k);
        J8().m(new Throwable("net not connected"));
        return;
    L13:
        Disposable r1 = I8().H5(r14).subscribe(new g(this, r14), new h(this));
        this.d.add(r1);
        TemplateReportV2 r2 = TemplateReportV2.a;
        String r3 = I8().getTemplateType();
        Intrinsics.checkNotNullParameter(r3, "templateType");
        JSONObject r4 = new JSONObject();
        r4.put("click_type", "search_input_click");
        r4.put("template_source", TemplateReportV2.c);
        if (TemplateReportV2.e == true) goto L17;
        r14 = "input";
    L17:
        r4.put("keywords", r14);
        r4.put("template_type", r3);
        TemplateReportV2.a().n("ccm_template_search_result_view_click", r4);
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f.a
    public final void w(TemplateV4 r2) {
        Intrinsics.checkNotNullParameter(r2, ThumbGlideUrl.SOURCE_TEMPLATE);
        ((TemplateCenterViewModel) this.i.getValue()).getDeleteToken().setValue(r2.getObjToken());
    }

    public BasePresenter(Fragment r2, com.bytedance.ee.bear.templates.search.base.e r3, com.bytedance.ee.bear.templates.search.base.f r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "view");
        super(r3, r4);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new CompositeDisposable();
        this.f = "";
        this.g = "";
        this.i = LazyKt.lazy(new BasePresenter$templateCenterViewModel$2(this));
        this.k = new f(this);
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f.a
    public final void h(int r8, TemplateV4 r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, ThumbGlideUrl.SOURCE_TEMPLATE);
        tt5.a.b("SearchListPresenter", "onTemplateSelected()...template = " + r9);
        String r0 = TemplateReport.a;
        JSONObject r1 = new JSONObject();
        r1.put("template_searchresult", "yes");
        r1.put("create_from_template", "yes");
        TemplateReport.a().v("template_search", r1);
        ConnectionService.NetworkState r2 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState();
        boolean r3 = !r2.a();
        if (r9.getEnable() == true) goto L7;
        if (r3 == false) goto L7;
        tt5.a.h("SearchListPresenter", "create template offline, state:" + r2 + ", template enable: " + r9.getEnable());
        Toast.showFailureText(H8().getContext(), 2131887937);
        return;
    L7:
        com.bytedance.ee.bear.templates.e r6 = new com.bytedance.ee.bear.templates.e(this.g, Integer.valueOf(r8), r10, null, 16);
        TemplateReportV2 r11 = TemplateReportV2.a;
        TemplateReportV2.k(r9, r6);
        if (r9.isSceneTemplate() == false) goto L11;
        TemplateUtils r12 = TemplateUtils.a;
        int r4 = r9.getObjType();
        String r5 = r9.getObjToken();
        String r7 = r9.getCollectionId();
        String r13 = String.valueOf(r9.getTemplateType());
        i r14 = new i(this);
        r12.getClass();
        TemplateUtils.e(r4, r5, r7, "templatecenter_searchresult", r13, r14);
        return;
    L11:
        TemplateUtils r15 = TemplateUtils.a;
        TemplateCenterViewModel r16 = (TemplateCenterViewModel) this.i.getValue();
        CategoryTab r17 = J8().s0();
        if (r17 == null) goto L14;
        List<ao5.a> r18 = r17.getCategoryList();
    L15:
        List<ao5.a> r19 = r18;
        if (TemplateReportV2.e == false) goto L18;
        String r110 = this.g;
    L19:
        Function0<Boolean> r20 = new BasePresenter$onTemplateClicked$2(this);
        r15.getClass();
        TemplateUtils.h(r9, r16, r19, "templatecenter_searchresult", r110, r20);
        return;
    L18:
        r110 = "input";
        goto L19
    L14:
        r18 = null;
        goto L15
    }
}
