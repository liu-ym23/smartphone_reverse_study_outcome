package com.bytedance.ee.bear.templates.center.list.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.AnalyticConstant$OpenType;
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
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
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

/* JADX INFO: loaded from: classes18.dex */
public class BaseTemplateListPresenter extends BasePresenter<p, q, q.a> implements q.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f238954k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f238955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f238956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f238957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f238958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f238959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f238960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f238961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f238962h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f238963i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f238964j;

    public static final class a implements ue5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SoftReference<BaseTemplateListPresenter> f238965a;

        @Override // ue5.b
        public final void a() {
            tt5.a.h("BaseTemplateListPresenter", "ICipherCallback");
            BaseTemplateListPresenter r100 = this.f238965a.get();
            if (r100 == null) goto L9;
            sbb.e r101 = r100.N8().u7().getValue();
            if (r101 != null) goto L7;
            r101 = sbb.e.f541294e;
        L7:
            Intrinsics.checkNotNull(r101);
            r100.S8(r101);
            return;
        }

        public a(SoftReference<BaseTemplateListPresenter> r100) {
            Intrinsics.checkNotNullParameter(r100, "presenter");
            this.f238965a = r100;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseTemplateListPresenter f238966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f238967b;

        public c(BaseTemplateListPresenter r100, int r101) {
            this.f238966a = r100;
            this.f238967b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            TemplateGroupTab r100 = (TemplateGroupTab) r110;
            BaseTemplateListPresenter r101 = this.f238966a;
            String r102 = r100.getShareIndex();
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f238960f = r102;
            if (r100.getSource() != 2) goto L10;
            if (r100.getErr() == null) goto L10;
            BaseTemplateListPresenter r103 = this.f238966a;
            if (r103.f238961g == true) goto L50;
            r103.P8().m(r100.getErr());
            return;
        L50:
            return;
        L10:
            if (this.f238966a.f238961g == false) goto L41;
            if (r100.getOnlyBlankDocument() == false) goto L41;
            return;
        L41:
            boolean r104 = !((ao5.a) ListProtector.get(((CategoryTab) ListProtector.get(r100.getCategoryTabList(), 0)).getCategoryList(), 0)).f15786c.isEmpty();
        L18:
            TemplateReportV2 r105 = TemplateReportV2.f238768a;
            TemplateReportV2.f(sbb.e.d(this.f238967b), r104, null);
            this.f238966a.f238961g = r100.getHasData();
            q r106 = this.f238966a.P8();
            Intrinsics.checkNotNull(r100);
            r106.Y1(r100);
            this.f238966a.P8().Z(r100);
            q r107 = this.f238966a.P8();
            this.f238966a.getClass();
            TemplateCenterViewModel.Companion.getClass();
            if (TemplateCenterViewModel.access$getCATEGORY_ID$cp() != (-1)) goto L21;
        L38:
            int r108 = -1;
        L39:
            r107.H0(r108);
            return;
        L21:
            if (r100.getCategoryTabList().isEmpty() == true) goto L38;
            int r109 = r100.getCategoryTabList().size();
            r108 = 1;
        L24:
            if (r108 >= r109) goto L38;
            Iterator<T> r111 = ((CategoryTab) ListProtector.get(r100.getCategoryTabList(), r108)).getCategoryList().iterator();
        L27:
            if (r111.hasNext() == false) goto L34;
            T r112 = r111.next();
            long r113 = ((ao5.a) r112).f15787d;
            TemplateCenterViewModel.Companion.getClass();
            if (r113 != TemplateCenterViewModel.access$getCATEGORY_ID$cp()) goto L31;
            boolean r114 = true;
        L32:
            if (r114 == false) goto L27;
        L35:
            if (r112 != null) goto L36;
            r108 = r108 + 1;
            goto L24
        L36:
            tt5.a.h("BaseTemplateListPresenter", "findTargetCategoryIndex = " + r108);
            TemplateCenterViewModel.Companion.getClass();
            TemplateCenterViewModel.access$setCATEGORY_ID$cp(-1);
            goto L39
        L31:
            r114 = false;
            goto L32
        L34:
            r112 = (T) null;
        L17:
            r104 = false;
            goto L18
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseTemplateListPresenter f238968a;

        public d(BaseTemplateListPresenter r100) {
            this.f238968a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e("BaseTemplateListPresenter", "loadData err:", r101, false);
            q r102 = this.f238968a.P8();
            Intrinsics.checkNotNull(r101);
            r102.m(r101);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseTemplateListPresenter f238969a;

        public e(BaseTemplateListPresenter r100) {
            this.f238969a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            TemplateGroupTab r101 = (TemplateGroupTab) r100;
            this.f238969a.K8(r101.getCategoryTabList(), 0, r101.getSource());
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseTemplateListPresenter f238970a;

        public f(BaseTemplateListPresenter r100) {
            this.f238970a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            TemplateGroupTab r101 = (TemplateGroupTab) r100;
            BaseTemplateListPresenter r102 = this.f238970a;
            String r103 = r101.getShareIndex();
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r102.f238960f = r103;
            this.f238970a.P8().b0();
            q r104 = this.f238970a.P8();
            boolean r105 = r101.getHasMore();
            r101.getSource();
            r104.Q(r105);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseTemplateListPresenter f238971a;

        public g(BaseTemplateListPresenter r100) {
            this.f238971a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("BaseTemplateListPresenter", "loadMoreError()...", (Throwable) r100, false);
            this.f238971a.P8().Q(true);
        }
    }

    public static final class h implements TemplateUtils.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseTemplateListPresenter f238972a;

        public h(BaseTemplateListPresenter r100) {
            this.f238972a = r100;
        }

        @Override // com.bytedance.ee.bear.templates.TemplateUtils.a
        public final void onResult(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            if (this.f238972a.M8().isAdded() == false) goto L20;
            FragmentActivity r101 = this.f238972a.M8().getActivity();
            boolean r102 = false;
            if (r101 != null) goto L7;
        L9:
            boolean r103 = false;
        L10:
            if (r103 == true) goto L21;
            FragmentActivity r104 = this.f238972a.M8().getActivity();
            if (r104 != null) goto L14;
        L16:
            if (r102 == true) goto L22;
            RouteBean r105 = new RouteBean();
            r105.f236638c = 1;
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r100, r105);
            return;
        L22:
            return;
        L14:
            if (r104.isDestroyed() != true) goto L16;
            r102 = true;
            goto L16
        L21:
            return;
        L7:
            if (r101.isFinishing() != true) goto L9;
            r103 = true;
            goto L10
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseTemplateListPresenter f238973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ wn5.a f238974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f238975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TemplateV4 f238976d;

        public i(BaseTemplateListPresenter r100, wn5.a r101, Ref.ObjectRef<String> r102, TemplateV4 r103) {
            this.f238973a = r100;
            this.f238974b = r101;
            this.f238975c = r102;
            this.f238976d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            CreateSelectResult r111 = (CreateSelectResult) r110;
            tt5.a.h("BaseTemplateListPresenter", "onTemplateClicked: getCreateLocation createLocationResult：" + r111);
            TemplateCenterViewModel r100 = this.f238973a.O8();
            Intrinsics.checkNotNull(r111);
            r100.setCreateSelectResult(r111);
            this.f238973a.O8().setSpaceId(r111.f216828e);
            this.f238974b.h(this.f238973a.M8().getActivity(), this.f238975c.element, this.f238976d.getObjType(), null, this.f238976d.getId(), this.f238973a.O8().getTemplateSource(), this.f238973a.O8().getCreateSelectResult().f216826c, this.f238973a.O8().getModule(), this.f238973a.O8().getCreateSelectResult().f216825b, this.f238973a.O8().getCreateSelectResult().f216827d, this.f238973a.O8().getSpaceId(), new com.bytedance.ee.bear.templates.center.list.base.j(this.f238976d, this.f238973a));
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j<T> f238977a = null;

        static {
            f238977a = new j();
        }

        public j() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d("BaseTemplateListPresenter", "onTemplateClicked error :" + ((Throwable) r100));
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    public final TemplateCenterViewModel O8() {
        return (TemplateCenterViewModel) this.f238962h.getValue();
    }

    public void a() {
        tt5.a.h("BaseTemplateListPresenter", "loadMore()...index = " + this.f238960f);
        this.f238959e.add(N8().N7(this.f238960f, L8(), -1, 0).observeOn(fo5.d.e()).doOnNext(new e(this)).observeOn(fo5.d.d()).subscribe(new f(this), new g(this)));
    }

    public final int L8() {
        sbb.e r100 = N8().u7().getValue();
        if (r100 != null) goto L6;
        r100 = sbb.e.f541294e;
    L6:
        if (N8().L5(r100.f541317b) == false) goto L9;
        r100 = sbb.e.f541304o;
    L9:
        if (Intrinsics.areEqual(r100, sbb.e.f541294e) == false) goto L12;
        return -1;
    L12:
        return r100.f541317b;
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        N8().u7().observe(M8(), new com.bytedance.ee.bear.templates.center.list.base.h(this));
        com.bytedance.ee.bear.contract.j r100 = com.bytedance.ee.bear.contract.j.a.f217090a;
        this.f238963i = r100.getNetworkState().a();
        r100.a().observe(M8(), new com.bytedance.ee.bear.templates.center.list.base.i(this));
        O8().getDeleteToken().observe(M8(), new com.bytedance.ee.bear.templates.center.list.base.g(this));
        this.f238964j = new a(new SoftReference(this));
        ((ue5.a) org.koin.java.a.c(ue5.a.class, null, null, 6)).b(this.f238964j);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        if (this.f238959e.isDisposed() == true) goto L6;
        this.f238959e.dispose();
    L6:
        if (this.f238964j == null) goto L9;
        ((ue5.a) org.koin.java.a.c(ue5.a.class, null, null, 6)).a(this.f238964j);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q.a
    public final void onLoadFailed() {
        R8(L8());
    }

    public Fragment M8() {
        return this.f238955a;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q.a
    public final void N3() {
        a();
    }

    public p N8() {
        return this.f238956b;
    }

    public q P8() {
        return this.f238957c;
    }

    public final void R8(int r100) {
        if (this.f238961g == true) goto L5;
        P8().d();
    L5:
        tt5.a.h("BaseTemplateListPresenter", "loadData()... filterType = " + r100);
        this.f238959e.add(N8().t1(r100).subscribe(new c(this, r100), new d(this)));
    }

    public final void S8(sbb.e r100) {
        if (Intrinsics.areEqual(r100, sbb.e.f541294e) == false) goto L5;
        R8(-1);
        return;
    L5:
        int r101 = r100.f541317b;
        if (N8().L5(r101) == false) goto L8;
        r101 = sbb.e.f541304o.f541317b;
    L8:
        R8(r101);
    }

    public final boolean T8(TemplateV4 r100) {
        ConnectionService.NetworkState r101 = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState();
        boolean r102 = !r101.a();
        if (r100.getEnable() == true) goto L7;
        if (r102 == false) goto L7;
        tt5.a.h("BaseTemplateListPresenter", "create template offline, state:" + r101 + ", template enable: " + r100.getEnable());
        Toast.showFailureText(M8().getContext(), R.string.Doc_List_NoInternetClickMoreToast);
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q.a
    public void V6(CategoryTab r100) {
        Intrinsics.checkNotNullParameter(r100, "categoryTab");
        String r101 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();     // Catch: Throwable -> L5
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L5
        r102.put("primary", this.f238958d);     // Catch: Throwable -> L5
        r102.put("type", ((ao5.a) ListProtector.get(r100.getCategoryList(), 0)).f15787d);     // Catch: Throwable -> L5
        r102.put(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, r101);     // Catch: Throwable -> L5
        org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("BaseTemplateListPresenter", "onCategoryClicked()...reportEvent error:", th, false);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q.a
    public final void w(TemplateV4 r100) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        O8().getDeleteToken().setValue(r100.getObjToken());
    }

    public static final String H8(BaseTemplateListPresenter r100, String r101) {
        r100.getClass();
        tt5.a.h("BaseTemplateListPresenter", "module: " + r101 + " --isBlank: true");
        if (Intrinsics.areEqual("space_template", TemplateReportV2.f238770c) == false) goto L6;
        return AnalyticConstant$OpenType.SPACE_TEMPLATE.getType();
    L6:
        if (Intrinsics.areEqual("home", r101) == false) goto L9;
        return AnalyticConstant$OpenType.HOME_CREATE_BLANK.getType();
    L9:
        if (Intrinsics.areEqual(WikiSpaceType.PERSONAL, r101) == true) goto L25;
        if (Intrinsics.areEqual("personal_folder_root", r101) == true) goto L25;
        if (Intrinsics.areEqual("personal_subfolder", r101) == true) goto L25;
        if (Intrinsics.areEqual("shared_subfolder", r101) == true) goto L29;
        if (Intrinsics.areEqual("shared", r101) == true) goto L29;
        if (Intrinsics.areEqual("shared_folder_root", r101) == true) goto L29;
        return "";
    L29:
        return AnalyticConstant$OpenType.SHARED_CREATE_BLANK.getType();
    L25:
        return AnalyticConstant$OpenType.PERSONAL_CREATE_BLANK.getType();
    }

    public static boolean Q8(ao5.a r100, ao5.a r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        if (Intrinsics.areEqual(r100.f15784a.toString(), r101.f15784a.toString()) == true) goto L10;
        long r102 = r100.f15787d;
        if (r102 != (-1)) goto L7;
    L9:
        return false;
    L7:
        if (r102 != r101.f15787d) goto L9;
    L10:
        return true;
    }

    public void K8(ArrayList<CategoryTab> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "categoryTabList");
        CategoryTab r103 = P8().s0();
        if (r103 != null) goto L5;
        return;
    L5:
        List<ao5.a> r104 = r103.getCategoryList();
        if (r104.isEmpty() == false) goto L8;
        return;
    L8:
        Iterator<CategoryTab> r105 = r100.iterator();
    L10:
        if (r105.hasNext() == false) goto L22;
        List<ao5.a> r106 = r105.next().getCategoryList();
        Iterator<ao5.a> r107 = r104.iterator();
    L13:
        if (r107.hasNext() == false) goto L10;
        ao5.a r108 = r107.next();
        Iterator<ao5.a> r109 = r106.iterator();
    L16:
        if (r109.hasNext() == false) goto L13;
        ao5.a r110 = r109.next();
        if (Q8(r108, r110) == false) goto L16;
        if ((!r110.f15786c.isEmpty()) == false) goto L16;
        r108.f15786c.addAll(r110.f15786c);
        r108.f15785b = r110.f15785b;
        goto L16
    }

    /* JADX WARN: Type inference failed for: r6v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.String] */
    @Override // com.bytedance.ee.bear.templates.center.list.base.q.a
    public final void h(int r110, TemplateV4 r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, ThumbGlideUrl.SOURCE_TEMPLATE);
        tt5.a.b("BaseTemplateListPresenter", "onTemplateSelected()...template = " + r111);
        if (r111.isCipherInvalid() == false) goto L6;
        UDToast.show(M8().requireActivity(), R.string.CreationDoc_Template_KeyInvalidCanNotOperate);
        return;
    L6:
        List<ao5.a> r100 = null;
        if (r111.isBlankDocumentTemplate() == false) goto L42;
        if (O8().isOnlyNewLarkForm() == false) goto L39;
        wn5.a r101 = (wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6);
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = r111.getObjToken();
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("bitable.new.survey.from.block.disable") == true) goto L13;
        r102.element = com.bytedance.ee.bear.templates.a.b();
    L13:
        er5.b r103 = (er5.b) org.koin.java.a.c(er5.b.class, null, null, 6);
        String r104 = O8().getModule();
        String r105 = O8().getTemplateSource();
        if (Intrinsics.areEqual(r104, "lark_workspace_bitable_landing") == false) goto L16;
    L19:
        boolean r106 = true;
    L21:
        if (r111.getObjType() != 8) goto L37;
        if (r106 == false) goto L37;
        if (r103.j() == false) goto L37;
        FragmentActivity r107 = M8().getActivity();
        if (r107 == null) goto L53;
        WorkspaceAction r108 = WorkspaceAction.NewTo;
        NewBaseEntry r109 = NewBaseEntry.TemplateCenter;
        NewBaseType r113 = NewBaseType.Form;
        if ((28 & 64) == 0) goto L30;
        NewBaseType r114 = null;
    L32:
        if ((28 & 128) == 0) goto L34;
        NewBaseEntry r115 = null;
    L35:
        r103.e(r107, r108, null, null, r114, r115);
        return;
    L34:
        r115 = r109;
        goto L35
    L30:
        r114 = r113;
        goto L32
    L53:
        return;
    L37:
        int r116 = com.bytedance.ee.bear.content.creation.location.a.f216830a;
        this.f238959e.add(com.bytedance.ee.bear.content.creation.location.a.c(O8().getCreateSelectResult()).subscribe(new i(this, r101, r102, r111), j.f238977a));
        return;
    L16:
        if (CommonPreviewTemplateView.f239196i.getValue().contains(r105) == true) goto L19;
        r106 = false;
        goto L21
    L39:
        CreateSelectResult r117 = O8().getCreateSelectResult();
        int r118 = com.bytedance.ee.bear.content.creation.location.a.f216830a;
        this.f238959e.add(com.bytedance.ee.bear.content.creation.location.a.c(r117).subscribe(new com.bytedance.ee.bear.templates.center.list.base.a(this, r111), com.bytedance.ee.bear.templates.center.list.base.b.f238994a));
        return;
    L42:
        if (T8(r111) == true) goto L44;
        return;
    L44:
        com.bytedance.ee.bear.templates.e r119 = new com.bytedance.ee.bear.templates.e(null, Integer.valueOf(r110), r112, P8().M4(), 2);
        TemplateReportV2 r120 = TemplateReportV2.f238768a;
        TemplateReportV2.k(r111, r119);
        if (r111.isSceneTemplate() == false) goto L48;
        TemplateUtils.f(TemplateUtils.f238776a, r111.getObjType(), r111.getObjToken(), r111.getCollectionId(), null, String.valueOf(r111.getTemplateType()), new h(this), 8);
        return;
    L48:
        TemplateUtils r121 = TemplateUtils.f238776a;
        TemplateCenterViewModel r122 = O8();
        CategoryTab r123 = P8().s0();
        if (r123 == null) goto L51;
        r100 = r123.getCategoryList();
    L51:
        TemplateUtils.i(r121, r111, r122, r100, null, new BaseTemplateListPresenter$onTemplateClicked$3(this), 24);
    }

    public BaseTemplateListPresenter(Fragment r100, p r101, q r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, "tabName");
        super(r101, r102);
        this.f238955a = r100;
        this.f238956b = r101;
        this.f238957c = r102;
        this.f238958d = r103;
        this.f238959e = new CompositeDisposable();
        this.f238960f = "";
        this.f238962h = LazyKt.lazy(new BaseTemplateListPresenter$templateCenterViewModel$2(this));
        this.f238963i = true;
    }

    public static final void J8(BaseTemplateListPresenter r100, TemplateV4 r101, String r102, String r103, DocumentCreateInfo r110) {
        r100.P8().c0();
        r100.O8().setSelectedTemplate(r101);
        q0.e(new com.bytedance.ee.bear.list.create.b(r100.M8().getContext(), "tab_create", r103, r102, r110));
    }

    public static final void I8(BaseTemplateListPresenter r100, TemplateV4 r101, String r102, String r103, Throwable r104, boolean r105) {
        r100.P8().c0();
        com.bytedance.ee.bear.list.create.m r106 = new com.bytedance.ee.bear.list.create.m(r102, r103, "docs_manage", false);
        String r107 = r100.M8().getString(R.string.Doc_List_TemplateLoadingFailedToast);
        String r108 = sbb.e.c(r101.getObjType());
        if (r105 == false) goto L5;
        q0.f(r100.M8().getContext(), r104);
    L7:
        if ((r104 instanceof NetService.ServerErrorException) == false) goto L17;
        int r109 = ((NetService.ServerErrorException) r104).getCode();
        if (r109 != 3) goto L11;
    L15:
        tt5.a.h("BaseTemplateListPresenter", "refreshDataIfNeed()...errorCode = " + r109);
        r100.R8(r100.L8());
        Toast.showFailureText(r100.M8().getContext(), R.string.Doc_List_TemplateNoPermissionToast);
        return;
    L11:
        if (r109 == 10002) goto L15;
        if (r109 == 10007) goto L15;
        return;
    L17:
        return;
    L5:
        q0.d(new com.bytedance.ee.bear.list.create.b(r100.M8().getContext(), r106, r108), r104, r107);
        goto L7
    }
}
