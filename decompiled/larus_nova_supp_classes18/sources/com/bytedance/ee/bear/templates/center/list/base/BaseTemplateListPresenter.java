package com.bytedance.ee.bear.templates.center.list.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.create.q0;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.preview.single.common.CommonPreviewTemplateView;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.bear.workspace.NewBaseEntry;
import com.bytedance.ee.bear.workspace.NewBaseType;
import com.bytedance.ee.bear.workspace.WorkspaceAction;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BaseTemplateListPresenter extends BasePresenter<p, q, q.a> implements q.a {
    public static final /* synthetic */ int k = 0;
    public final Fragment a;
    public final p b;
    public final q c;
    public final String d;
    public final CompositeDisposable e;
    public String f;
    public boolean g;
    public final Lazy h;
    public boolean i;
    public a j;

    public static final class a implements ue5.b {
        public final SoftReference<BaseTemplateListPresenter> a;

        @Override // ue5.b
        public final void a() {
            tt5.a.h("BaseTemplateListPresenter", "ICipherCallback");
            BaseTemplateListPresenter r0 = this.a.get();
            if (r0 == null) goto L9;
            sbb.e r1 = (sbb.e) r0.N8().u7().getValue();
            if (r1 != null) goto L7;
            r1 = sbb.e.e;
        L7:
            Intrinsics.checkNotNull(r1);
            r0.S8(r1);
            return;
        }

        public a(SoftReference<BaseTemplateListPresenter> r2) {
            Intrinsics.checkNotNullParameter(r2, "presenter");
            this.a = r2;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BaseTemplateListPresenter a;
        public final /* synthetic */ int b;

        public c(BaseTemplateListPresenter r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r18) {
            TemplateGroupTab r1 = (TemplateGroupTab) r18;
            BaseTemplateListPresenter r2 = this.a;
            String r3 = r1.getShareIndex();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r2.f = r3;
            if (r1.getSource() != 2) goto L10;
            if (r1.getErr() == null) goto L10;
            BaseTemplateListPresenter r4 = this.a;
            if (r4.g == true) goto L50;
            r4.P8().m(r1.getErr());
            return;
        L50:
            return;
        L10:
            if (this.a.g == false) goto L41;
            if (r1.getOnlyBlankDocument() == false) goto L41;
            return;
        L41:
            boolean r5 = !((ao5.a) ListProtector.get(((CategoryTab) ListProtector.get(r1.getCategoryTabList(), 0)).getCategoryList(), 0)).c.isEmpty();
        L18:
            TemplateReportV2 r6 = TemplateReportV2.a;
            TemplateReportV2.f(sbb.e.d(this.b), r5, null);
            this.a.g = r1.getHasData();
            q r7 = this.a.P8();
            Intrinsics.checkNotNull(r1);
            r7.Y1(r1);
            this.a.P8().Z(r1);
            q r8 = this.a.P8();
            this.a.getClass();
            TemplateCenterViewModel.Companion.getClass();
            if (TemplateCenterViewModel.access$getCATEGORY_ID$cp() != (-1)) goto L21;
        L38:
            int r9 = -1;
        L39:
            r8.H0(r9);
            return;
        L21:
            if (r1.getCategoryTabList().isEmpty() == true) goto L38;
            int r10 = r1.getCategoryTabList().size();
            r9 = 1;
        L24:
            if (r9 >= r10) goto L38;
            Iterator<T> r11 = ((CategoryTab) ListProtector.get(r1.getCategoryTabList(), r9)).getCategoryList().iterator();
        L27:
            if (r11.hasNext() == false) goto L34;
            T r12 = r11.next();
            long r13 = ((ao5.a) r12).d;
            TemplateCenterViewModel.Companion.getClass();
            if (r13 != TemplateCenterViewModel.access$getCATEGORY_ID$cp()) goto L31;
            boolean r14 = true;
        L32:
            if (r14 == false) goto L27;
        L35:
            if (r12 != null) goto L36;
            r9 = r9 + 1;
            goto L24
        L36:
            tt5.a.h("BaseTemplateListPresenter", "findTargetCategoryIndex = " + r9);
            TemplateCenterViewModel.Companion.getClass();
            TemplateCenterViewModel.access$setCATEGORY_ID$cp(-1);
            goto L39
        L31:
            r14 = false;
            goto L32
        L34:
            r12 = (T) null;
        L17:
            r5 = false;
            goto L18
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ BaseTemplateListPresenter a;

        public d(BaseTemplateListPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("BaseTemplateListPresenter", "loadData err:", r5, false);
            q r0 = this.a.P8();
            Intrinsics.checkNotNull(r5);
            r0.m(r5);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ BaseTemplateListPresenter a;

        public e(BaseTemplateListPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            TemplateGroupTab r5 = (TemplateGroupTab) r4;
            this.a.K8(r5.getCategoryTabList(), 0, r5.getSource());
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ BaseTemplateListPresenter a;

        public f(BaseTemplateListPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            TemplateGroupTab r5 = (TemplateGroupTab) r4;
            BaseTemplateListPresenter r0 = this.a;
            String r1 = r5.getShareIndex();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.f = r1;
            this.a.P8().b0();
            q r2 = this.a.P8();
            boolean r3 = r5.getHasMore();
            r5.getSource();
            r2.Q(r3);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ BaseTemplateListPresenter a;

        public g(BaseTemplateListPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e("BaseTemplateListPresenter", "loadMoreError()...", (Throwable) r4, false);
            this.a.P8().Q(true);
        }
    }

    public static final class h implements TemplateUtils.a {
        public final /* synthetic */ BaseTemplateListPresenter a;

        public h(BaseTemplateListPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.templates.TemplateUtils.a
        public final void onResult(String r5) {
            Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_URL);
            if (this.a.M8().isAdded() == false) goto L20;
            FragmentActivity r0 = this.a.M8().getActivity();
            boolean r1 = false;
            if (r0 != null) goto L7;
        L9:
            boolean r2 = false;
        L10:
            if (r2 == true) goto L21;
            FragmentActivity r3 = this.a.M8().getActivity();
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

    public static final class i<T> implements Consumer {
        public final /* synthetic */ BaseTemplateListPresenter a;
        public final /* synthetic */ wn5.a b;
        public final /* synthetic */ Ref.ObjectRef<String> c;
        public final /* synthetic */ TemplateV4 d;

        public i(BaseTemplateListPresenter r1, wn5.a r2, Ref.ObjectRef<String> r3, TemplateV4 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r15) {
            CreateSelectResult r16 = (CreateSelectResult) r15;
            tt5.a.h("BaseTemplateListPresenter", "onTemplateClicked: getCreateLocation createLocationResult：" + r16);
            TemplateCenterViewModel r0 = this.a.O8();
            Intrinsics.checkNotNull(r16);
            r0.setCreateSelectResult(r16);
            this.a.O8().setSpaceId(r16.e);
            this.b.h(this.a.M8().getActivity(), (String) this.c.element, this.d.getObjType(), null, this.d.getId(), this.a.O8().getTemplateSource(), this.a.O8().getCreateSelectResult().c, this.a.O8().getModule(), this.a.O8().getCreateSelectResult().b, this.a.O8().getCreateSelectResult().d, this.a.O8().getSpaceId(), new com.bytedance.ee.bear.templates.center.list.base.j(this.d, this.a));
        }
    }

    public static final class j<T> implements Consumer {
        public static final j<T> a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final void accept(Object r3) {
            tt5.a.d("BaseTemplateListPresenter", "onTemplateClicked error :" + ((Throwable) r3));
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    public final TemplateCenterViewModel O8() {
        return (TemplateCenterViewModel) this.h.getValue();
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q.a
    public void a() {
        tt5.a.h("BaseTemplateListPresenter", "loadMore()...index = " + this.f);
        this.e.add(N8().N7(this.f, L8(), -1, 0).observeOn(fo5.d.e()).doOnNext(new e(this)).observeOn(fo5.d.d()).subscribe(new f(this), new g(this)));
    }

    public final int L8() {
        sbb.e r0 = (sbb.e) N8().u7().getValue();
        if (r0 != null) goto L6;
        r0 = sbb.e.e;
    L6:
        if (N8().L5(r0.b) == false) goto L9;
        r0 = sbb.e.o;
    L9:
        if (Intrinsics.areEqual(r0, sbb.e.e) == false) goto L12;
        return -1;
    L12:
        return r0.b;
    }

    public final void create() {
        super.create();
        N8().u7().observe(M8(), new com.bytedance.ee.bear.templates.center.list.base.h(this));
        com.bytedance.ee.bear.contract.j r0 = com.bytedance.ee.bear.contract.j.a.a;
        this.i = r0.getNetworkState().a();
        r0.a().observe(M8(), new com.bytedance.ee.bear.templates.center.list.base.i(this));
        O8().getDeleteToken().observe(M8(), new com.bytedance.ee.bear.templates.center.list.base.g(this));
        this.j = new a(new SoftReference(this));
        ((ue5.a) org.koin.java.a.c(ue5.a.class, null, null, 6)).b(this.j);
    }

    public final void destroy() {
        super.destroy();
        if (this.e.isDisposed() == true) goto L6;
        this.e.dispose();
    L6:
        if (this.j == null) goto L9;
        ((ue5.a) org.koin.java.a.c(ue5.a.class, null, null, 6)).a(this.j);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q.a
    public final void onLoadFailed() {
        R8(L8());
    }

    public Fragment M8() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q.a
    public final void N3() {
        a();
    }

    public p N8() {
        return this.b;
    }

    public q P8() {
        return this.c;
    }

    public final void R8(int r3) {
        if (this.g == true) goto L5;
        P8().d();
    L5:
        tt5.a.h("BaseTemplateListPresenter", "loadData()... filterType = " + r3);
        this.e.add(N8().t1(r3).subscribe(new c(this, r3), new d(this)));
    }

    public final void S8(sbb.e r2) {
        if (Intrinsics.areEqual(r2, sbb.e.e) == false) goto L5;
        R8(-1);
        return;
    L5:
        int r3 = r2.b;
        if (N8().L5(r3) == false) goto L8;
        r3 = sbb.e.o.b;
    L8:
        R8(r3);
    }

    public final boolean T8(TemplateV4 r5) {
        ConnectionService.NetworkState r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState();
        boolean r1 = !r0.a();
        if (r5.getEnable() == true) goto L7;
        if (r1 == false) goto L7;
        tt5.a.h("BaseTemplateListPresenter", "create template offline, state:" + r0 + ", template enable: " + r5.getEnable());
        Toast.showFailureText(M8().getContext(), 2131887937);
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q.a
    public void V6(CategoryTab r9) {
        Intrinsics.checkNotNullParameter(r9, "categoryTab");
        String r1 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();     // Catch: Throwable -> L5
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L5
        r4.put("primary", this.d);     // Catch: Throwable -> L5
        r4.put(ResourceData.KEY_TYPE, ((ao5.a) ListProtector.get(r9.getCategoryList(), 0)).d);     // Catch: Throwable -> L5
        r4.put("lang", r1);     // Catch: Throwable -> L5
        org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("BaseTemplateListPresenter", "onCategoryClicked()...reportEvent error:", th, false);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q.a
    public final void w(TemplateV4 r2) {
        Intrinsics.checkNotNullParameter(r2, ThumbGlideUrl.SOURCE_TEMPLATE);
        O8().getDeleteToken().setValue(r2.getObjToken());
    }

    public static final String H8(BaseTemplateListPresenter r1, String r2) {
        r1.getClass();
        tt5.a.h("BaseTemplateListPresenter", "module: " + r2 + " --isBlank: true");
        if (Intrinsics.areEqual("space_template", TemplateReportV2.c) == false) goto L6;
        return AnalyticConstant.OpenType.SPACE_TEMPLATE.getType();
    L6:
        if (Intrinsics.areEqual("home", r2) == false) goto L9;
        return AnalyticConstant.OpenType.HOME_CREATE_BLANK.getType();
    L9:
        if (Intrinsics.areEqual(WikiSpaceType.PERSONAL, r2) == true) goto L25;
        if (Intrinsics.areEqual("personal_folder_root", r2) == true) goto L25;
        if (Intrinsics.areEqual("personal_subfolder", r2) == true) goto L25;
        if (Intrinsics.areEqual("shared_subfolder", r2) == true) goto L29;
        if (Intrinsics.areEqual("shared", r2) == true) goto L29;
        if (Intrinsics.areEqual("shared_folder_root", r2) == true) goto L29;
        return "";
    L29:
        return AnalyticConstant.OpenType.SHARED_CREATE_BLANK.getType();
    L25:
        return AnalyticConstant.OpenType.PERSONAL_CREATE_BLANK.getType();
    }

    public static boolean Q8(ao5.a r4, ao5.a r5) {
        Intrinsics.checkNotNullParameter(r4, "a");
        Intrinsics.checkNotNullParameter(r5, "b");
        if (Intrinsics.areEqual(r4.a.toString(), r5.a.toString()) == true) goto L10;
        long r0 = r4.d;
        if (r0 != (-1)) goto L7;
    L9:
        return false;
    L7:
        if (r0 != r5.d) goto L9;
    L10:
        return true;
    }

    public void K8(ArrayList<CategoryTab> r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "categoryTabList");
        CategoryTab r10 = P8().s0();
        if (r10 != null) goto L5;
        return;
    L5:
        List<ao5.a> r11 = r10.getCategoryList();
        if (r11.isEmpty() == false) goto L8;
        return;
    L8:
        Iterator<CategoryTab> r12 = r7.iterator();
    L10:
        if (r12.hasNext() == false) goto L22;
        List<ao5.a> r13 = r12.next().getCategoryList();
        Iterator<ao5.a> r0 = r11.iterator();
    L13:
        if (r0.hasNext() == false) goto L10;
        ao5.a r1 = r0.next();
        Iterator<ao5.a> r2 = r13.iterator();
    L16:
        if (r2.hasNext() == false) goto L13;
        ao5.a r3 = r2.next();
        if (Q8(r1, r3) == false) goto L16;
        if ((!r3.c.isEmpty()) == false) goto L16;
        r1.c.addAll(r3.c);
        r1.b = r3.b;
        goto L16
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q.a
    public final void h(int r14, TemplateV4 r15, String r16) {
        Intrinsics.checkNotNullParameter(r15, ThumbGlideUrl.SOURCE_TEMPLATE);
        tt5.a.b("BaseTemplateListPresenter", "onTemplateSelected()...template = " + r15);
        if (r15.isCipherInvalid() == false) goto L6;
        UDToast.show(M8().requireActivity(), 2131887111);
        return;
    L6:
        List<ao5.a> r3 = null;
        if (r15.isBlankDocumentTemplate() == false) goto L42;
        if (O8().isOnlyNewLarkForm() == false) goto L39;
        wn5.a r1 = (wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6);
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = r15.getObjToken();
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("bitable.new.survey.from.block.disable") == true) goto L13;
        r5.element = com.bytedance.ee.bear.templates.a.b();
    L13:
        er5.b r6 = (er5.b) org.koin.java.a.c(er5.b.class, null, null, 6);
        String r4 = O8().getModule();
        String r7 = O8().getTemplateSource();
        if (Intrinsics.areEqual(r4, "lark_workspace_bitable_landing") == false) goto L16;
    L19:
        boolean r8 = true;
    L21:
        if (r15.getObjType() != 8) goto L37;
        if (r8 == false) goto L37;
        if (r6.j() == false) goto L37;
        FragmentActivity r9 = M8().getActivity();
        if (r9 == null) goto L53;
        WorkspaceAction r10 = WorkspaceAction.NewTo;
        NewBaseEntry r2 = NewBaseEntry.TemplateCenter;
        NewBaseType r11 = NewBaseType.Form;
        if ((28 & 64) == 0) goto L30;
        NewBaseType r12 = null;
    L32:
        if ((28 & 128) == 0) goto L34;
        NewBaseEntry r13 = null;
    L35:
        r6.e(r9, r10, null, null, r12, r13);
        return;
    L34:
        r13 = r2;
        goto L35
    L30:
        r12 = r11;
        goto L32
    L53:
        return;
    L37:
        int r17 = com.bytedance.ee.bear.content.creation.location.a.a;
        this.e.add(com.bytedance.ee.bear.content.creation.location.a.c(O8().getCreateSelectResult()).subscribe(new i(this, r1, r5, r15), j.a));
        return;
    L16:
        if (((List) CommonPreviewTemplateView.i.getValue()).contains(r7) == true) goto L19;
        r8 = false;
        goto L21
    L39:
        CreateSelectResult r18 = O8().getCreateSelectResult();
        int r19 = com.bytedance.ee.bear.content.creation.location.a.a;
        this.e.add(com.bytedance.ee.bear.content.creation.location.a.c(r18).subscribe(new com.bytedance.ee.bear.templates.center.list.base.a(this, r15), com.bytedance.ee.bear.templates.center.list.base.b.a));
        return;
    L42:
        if (T8(r15) == true) goto L44;
        return;
    L44:
        com.bytedance.ee.bear.templates.e r20 = new com.bytedance.ee.bear.templates.e(null, Integer.valueOf(r14), r16, P8().M4(), 2);
        TemplateReportV2 r21 = TemplateReportV2.a;
        TemplateReportV2.k(r15, r20);
        if (r15.isSceneTemplate() == false) goto L48;
        TemplateUtils.f(TemplateUtils.a, r15.getObjType(), r15.getObjToken(), r15.getCollectionId(), null, String.valueOf(r15.getTemplateType()), new h(this), 8);
        return;
    L48:
        TemplateUtils r22 = TemplateUtils.a;
        TemplateCenterViewModel r23 = O8();
        CategoryTab r24 = P8().s0();
        if (r24 == null) goto L51;
        r3 = r24.getCategoryList();
    L51:
        TemplateUtils.i(r22, r15, r23, r3, null, new BaseTemplateListPresenter$onTemplateClicked$3(this), 24);
    }

    public BaseTemplateListPresenter(Fragment r2, p r3, q r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "tabName");
        super(r3, r4);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new CompositeDisposable();
        this.f = "";
        this.h = LazyKt.lazy(new BaseTemplateListPresenter$templateCenterViewModel$2(this));
        this.i = true;
    }

    public static final void J8(BaseTemplateListPresenter r6, TemplateV4 r7, String r8, String r9, DocumentCreateInfo r10) {
        r6.P8().c0();
        r6.O8().setSelectedTemplate(r7);
        q0.e(new com.bytedance.ee.bear.list.create.b(r6.M8().getContext(), "tab_create", r9, r8, r10));
    }

    public static final void I8(BaseTemplateListPresenter r3, TemplateV4 r4, String r5, String r6, Throwable r7, boolean r8) {
        r3.P8().c0();
        com.bytedance.ee.bear.list.create.m r0 = new com.bytedance.ee.bear.list.create.m(r5, r6, "docs_manage", false);
        String r9 = r3.M8().getString(2131887996);
        String r10 = sbb.e.c(r4.getObjType());
        if (r8 == false) goto L5;
        q0.f(r3.M8().getContext(), r7);
    L7:
        if ((r7 instanceof NetService.ServerErrorException) == false) goto L17;
        int r11 = ((NetService.ServerErrorException) r7).getCode();
        if (r11 != 3) goto L11;
    L15:
        tt5.a.h("BaseTemplateListPresenter", "refreshDataIfNeed()...errorCode = " + r11);
        r3.R8(r3.L8());
        Toast.showFailureText(r3.M8().getContext(), 2131887997);
        return;
    L11:
        if (r11 == 10002) goto L15;
        if (r11 == 10007) goto L15;
        return;
    L17:
        return;
    L5:
        q0.d(new com.bytedance.ee.bear.list.create.b(r3.M8().getContext(), r0, r10), r7, r9);
        goto L7
    }
}
