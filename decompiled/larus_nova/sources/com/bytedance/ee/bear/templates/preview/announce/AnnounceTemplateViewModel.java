package com.bytedance.ee.bear.templates.preview.announce;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSON;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.templates.BaseAnnounceTemplateViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import s45.p;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 j2\u00020\u0001:\u0003jklB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020B07J\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020BH\u0002J\u000e\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080KJ\n\u0010L\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080KH\u0016J\u0015\u0010M\u001a\u00020H2\b\u0010N\u001a\u0004\u0018\u000108¢\u0006\u0002\u0010OJ\u0006\u0010P\u001a\u00020HJ\u0006\u0010Q\u001a\u00020HJ\u0010\u0010R\u001a\u00020H2\u0006\u0010S\u001a\u00020TH\u0002J\u0006\u0010U\u001a\u00020HJ\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020X0WH\u0002J\n\u0010Y\u001a\u0004\u0018\u00010;H\u0002J\u0006\u0010Z\u001a\u00020HJ(\u0010[\u001a\u00020H2\u0006\u0010\\\u001a\u00020\u00102\u0006\u0010]\u001a\u00020B2\u0006\u0010^\u001a\u00020B2\u0006\u0010S\u001a\u00020TH\u0007J\u001e\u0010_\u001a\b\u0012\u0004\u0012\u00020`0W2\u0006\u0010a\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u0010H\u0002J\u0016\u0010b\u001a\u00020H2\u0006\u0010I\u001a\u00020B2\u0006\u0010c\u001a\u000208R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0082\u000e¢\u0006\u0002\n\u0000R4\u00109\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020;\u0018\u00010:j\n\u0012\u0004\u0012\u00020;\u0018\u0001`<07X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020B07X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010C\u001a\b\u0012\u0004\u0012\u00020807X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010>\"\u0004\bE\u0010@R\u001c\u0010d\u001a\u0004\u0018\u00010eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010i¨\u0006m"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel;", "Lcom/bytedance/ee/bear/templates/BaseAnnounceTemplateViewModel;", "<init>", "()V", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "netService$delegate", "Lkotlin/Lazy;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "announceToken", "", "getAnnounceToken", "()Ljava/lang/String;", "setAnnounceToken", "(Ljava/lang/String;)V", "announceUrl", "getAnnounceUrl", "setAnnounceUrl", "panelDelegate", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$PanelDelegate;", "getPanelDelegate", "()Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$PanelDelegate;", "setPanelDelegate", "(Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$PanelDelegate;)V", "templateData", "Lcom/bytedance/ee/bear/templates/preview/announce/TemplateData;", "getTemplateData", "()Lcom/bytedance/ee/bear/templates/preview/announce/TemplateData;", "setTemplateData", "(Lcom/bytedance/ee/bear/templates/preview/announce/TemplateData;)V", "titleBarHeight", "", "getTitleBarHeight", "()F", "setTitleBarHeight", "(F)V", "panelLocOnScreen", "", "getPanelLocOnScreen", "()[I", "setPanelLocOnScreen", "([I)V", "previewTemplateView", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnouncePreviewTemplateView;", "getPreviewTemplateView", "()Lcom/bytedance/ee/bear/templates/preview/announce/AnnouncePreviewTemplateView;", "setPreviewTemplateView", "(Lcom/bytedance/ee/bear/templates/preview/announce/AnnouncePreviewTemplateView;)V", "previewActive", "Landroidx/lifecycle/MutableLiveData;", "", "templates", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplate;", "Lkotlin/collections/ArrayList;", "getTemplates", "()Landroidx/lifecycle/MutableLiveData;", "setTemplates", "(Landroidx/lifecycle/MutableLiveData;)V", "currTemplatePos", "", "panelActive", "getPanelActive", "setPanelActive", "getCurrTemplatePos", "setCurrTemplatePos", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "getPreviewActive", "Landroidx/lifecycle/LiveData;", "getPanelLocOnScreenS", "setPreviewActive", "data", "(Ljava/lang/Boolean;)V", "onClickHidePanel", "onRefreshUI", "notifyFailed", LynxError.LYNX_THROWABLE, "", "loadCardData", "loadAnnounceTemplates", "Lio/reactivex/Flowable;", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateResults;", "getCurrTemplate", "loadTemplateDataFromNet", "handleDlpToast", "templateToken", "type", "code", "loadUseTemplateDataFromNet", "Lcom/bytedance/ee/bear/templates/preview/announce/UsedTemplateResult;", "docToken", "loadAnnounceUrl", "addToTask", "viewDelegate", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$ViewDelegate;)V", "Companion", "PanelDelegate", "ViewDelegate", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnounceTemplateViewModel extends BaseAnnounceTemplateViewModel {
    private static final String ANNOUNCE_RECOMMEND_TEMPLATE_API_PATH = "/space/api/platform/template/recommend_bottom/";
    private static final String BACK_STACK_MARK = "addToBackStack";
    public static final a Companion = null;
    private static final String SELECTED_USED_TEMPLATE_API_PATH = "/space/api/obj_template/template_insert/";
    public static final String TAG = "AnnounceTemplateViewModel";
    private String announceToken;
    private String announceUrl;
    private final Lazy compositeDisposable$delegate;
    private MutableLiveData<Integer> currTemplatePos;
    private final Lazy netService$delegate;
    private MutableLiveData<Boolean> panelActive;
    private b panelDelegate;
    private int[] panelLocOnScreen;
    private MutableLiveData<Boolean> previewActive;
    private com.bytedance.ee.bear.templates.preview.announce.d previewTemplateView;
    private TemplateData templateData;
    private MutableLiveData<ArrayList<AnnounceTemplate>> templates;
    private float titleBarHeight;
    private c viewDelegate;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    public interface c {
        void a();
    }

    public static final class d<T extends Result> implements NetService.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f239140a = null;

        static {
            f239140a = new d();
        }

        public d() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) {
            AnnounceTemplateResults.Companion.getClass();
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == true) goto L24;
            boolean r102 = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
            JSONObject r103 = new JSONObject(r100).optJSONObject("data");     // Catch: Throwable -> L18
            if (r103 == null) goto L15;
            JSONArray r104 = r103.optJSONArray("templates");     // Catch: Throwable -> L18
        L16:
            AnnounceTemplateResults r105 = new AnnounceTemplateResults(AnnounceTemplateResults.a.a(r104, r102), null);     // Catch: Throwable -> L18
        L21:
            return r105;
        L15:
            r104 = null;
        L18:
            th = move-exception;
            tt5.a.d("AnnounceTemplates", "parse()...error:" + th);
            r105 = new AnnounceTemplateResults(new ArrayList(), th);
            goto L21
        L24:
            return new AnnounceTemplateResults(new ArrayList(), new Throwable("json is null"));
        L5:
            if (StringsKt.isBlank(r100) == true) goto L8;
            r101 = false;
            goto L9
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T, R> f239141a = null;

        static {
            f239141a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return new AnnounceTemplateResults(new ArrayList(), r101);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnounceTemplateViewModel f239142a;

        public f(AnnounceTemplateViewModel r100) {
            this.f239142a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AnnounceTemplateResults r101 = (AnnounceTemplateResults) r100;
            if (r101.getErr() == null) goto L5;
            AnnounceTemplateViewModel.access$notifyFailed(this.f239142a, r101.getErr());
            return;
        L5:
            this.f239142a.getTemplates().setValue(r101.getTemplates());
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnounceTemplateViewModel f239143a;

        public g(AnnounceTemplateViewModel r100) {
            this.f239143a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "t");
            AnnounceTemplateViewModel.access$notifyFailed(this.f239143a, r101);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnounceTemplateViewModel f239144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f239145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f239146c;

        public h(AnnounceTemplateViewModel r100, String r101, Integer r102) {
            this.f239144a = r100;
            this.f239145b = r101;
            this.f239146c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            UsedTemplateResult r101 = (UsedTemplateResult) r100;
            if (r101.code == 0) goto L5;
            AnnounceTemplateViewModel.access$notifyFailed(this.f239144a, new Throwable("result  data error! code = " + r101.code + " message = " + r101.msg));
            this.f239144a.handleDlpToast(this.f239145b, this.f239146c.intValue(), r101.code, new NetService.ServerErrorException(r101.code, "", "", ""));
            return;
        L5:
            this.f239144a.setPreviewActive(Boolean.FALSE);
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnounceTemplateViewModel f239147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f239148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f239149c;

        public i(AnnounceTemplateViewModel r100, String r101, Integer r102) {
            this.f239147a = r100;
            this.f239148b = r101;
            this.f239149c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "t");
            AnnounceTemplateViewModel r102 = this.f239147a;
            r102.handleDlpToast(this.f239148b, this.f239149c.intValue(), k0.a(r101), r101);
            AnnounceTemplateViewModel.access$notifyFailed(r102, r101);
        }
    }

    public static final class j<T extends Result> implements NetService.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j<T> f239150a = null;

        static {
            f239150a = new j();
        }

        public j() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) {
            if (r100 != null) goto L4;
        L7:
            boolean r101 = true;
        L8:
            if (r101 == false) goto L10;
            tt5.a.d(AnnounceTemplateViewModel.TAG, "loadUseTemplateDataFromNet: result data null!");
            return new UsedTemplateResult(null, -1);
        L10:
            JSONObject r102 = new JSONObject(r100);
            return new UsedTemplateResult(r102.optString("ObjToken"), r102.optInt("NewRev"));
        L4:
            if (StringsKt.isBlank(r100) == true) goto L7;
            r101 = false;
            goto L8
        }
    }

    public static final class k<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k<T, R> f239151a = null;

        static {
            f239151a = new k();
        }

        public k() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            tt5.a.e(AnnounceTemplateViewModel.TAG, "loadUseTemplateDataFromNet: ", r101, false);
            return new UsedTemplateResult(null, -1);
        }
    }

    static {
        Companion = new a();
    }

    private final CompositeDisposable getCompositeDisposable() {
        return (CompositeDisposable) this.compositeDisposable$delegate.getValue();
    }

    private final AnnounceTemplate getCurrTemplate() {
        ArrayList<AnnounceTemplate> r100 = this.templates.getValue();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.size();
    L7:
        if (r102 <= 0) goto L15;
        ArrayList<AnnounceTemplate> r103 = this.templates.getValue();
        if (r103 == null) goto L16;
        Integer r104 = this.currTemplatePos.getValue();
        if (r104 == null) goto L14;
        r101 = r104.intValue();
    L14:
        return (AnnounceTemplate) ListProtector.get(r103, r101);
    L16:
        return null;
    L15:
        return null;
    L5:
        r102 = 0;
        goto L7
    }

    private final NetService getNetService() {
        return (NetService) this.netService$delegate.getValue();
    }

    private final Flowable<AnnounceTemplateResults> loadAnnounceTemplates() {
        NetService.f r100 = new NetService.f(ANNOUNCE_RECOMMEND_TEMPLATE_API_PATH);
        r100.b("platform", "group_announcement");
        r100.b("obj_type", String.valueOf(sbb.e.f541296g.f541317b));
        r100.b("obj_token", this.announceToken);
        r100.b("version", "4");
        r100.b("scene", "");
        r100.b("num", "0");
        r100.f216906c = 2;
        return getNetService().Vc(d.f239140a).a(r100).onErrorReturn(e.f239141a).observeOn(fo5.d.d());
    }

    public final void onClickHidePanel() {
        b r100 = this.panelDelegate;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public final void onRefreshUI() {
        b r100 = this.panelDelegate;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public AnnounceTemplateViewModel() {
        this.netService$delegate = LazyKt.lazy(AnnounceTemplateViewModel$netService$2.INSTANCE);
        this.compositeDisposable$delegate = LazyKt.lazy(AnnounceTemplateViewModel$compositeDisposable$2.INSTANCE);
        this.previewActive = new MutableLiveData();
        this.templates = new MutableLiveData();
        this.currTemplatePos = new MutableLiveData(-1);
        this.panelActive = new MutableLiveData();
    }

    public final void loadCardData() {
        Disposable r100 = loadAnnounceTemplates().subscribe(new f(this), new g(this));
        getCompositeDisposable().add(r100);
    }

    public final void loadTemplateDataFromNet() {
        AnnounceTemplate r100 = getCurrTemplate();
        if (r100 == null) goto L5;
        String r101 = r100.getObjToken();
    L6:
        if (r100 == null) goto L8;
        Integer r102 = Integer.valueOf(r100.getObjType());
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(this.announceToken) == true) goto L29;
        if (r102 == null) goto L30;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L20;
        PermissionResponse r103 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity(r101, sbb.e.d(r102.intValue()), BizDomain.FileBizDomainCCM, ""), "CREATE_COPY"), null);
        r103.getCallback().a(eu5.b.f474075a, r103);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r103) == false) goto L26;
        return;
    L26:
        String r104 = this.announceToken;
        Intrinsics.checkNotNull(r104);
        Intrinsics.checkNotNull(r101);
        getCompositeDisposable().add(loadUseTemplateDataFromNet(r104, r101).subscribe(new h(this, r101, r102), new i(this, r101, r102)));
        return;
    L20:
        gj5.b r105 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r106 = FileBizDomain.FileBizDomainCCM;
        gj5.c r107 = r105.g("CCM_CREATE_COPY", r106, r102.intValue(), r101);
        if (r107.f481503a == true) goto L26;
        if (r107.f481504b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L26;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CREATE_COPY", r106, r102.intValue(), r101);
        return;
    L30:
        return;
    L29:
        return;
    L8:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final String getAnnounceToken() {
        return this.announceToken;
    }

    public final String getAnnounceUrl() {
        return this.announceUrl;
    }

    public final MutableLiveData<Integer> getCurrTemplatePos() {
        return this.currTemplatePos;
    }

    @Override // com.bytedance.ee.bear.templates.BaseAnnounceTemplateViewModel
    public LiveData<Boolean> getPanelActive() {
        return this.panelActive;
    }

    public final b getPanelDelegate() {
        return this.panelDelegate;
    }

    public final int[] getPanelLocOnScreen() {
        return this.panelLocOnScreen;
    }

    @Override // com.bytedance.ee.bear.templates.BaseAnnounceTemplateViewModel
    public int[] getPanelLocOnScreenS() {
        return this.panelLocOnScreen;
    }

    public final LiveData<Boolean> getPreviewActive() {
        return this.previewActive;
    }

    public final com.bytedance.ee.bear.templates.preview.announce.d getPreviewTemplateView() {
        return this.previewTemplateView;
    }

    public final TemplateData getTemplateData() {
        return this.templateData;
    }

    public final MutableLiveData<ArrayList<AnnounceTemplate>> getTemplates() {
        return this.templates;
    }

    public final float getTitleBarHeight() {
        return this.titleBarHeight;
    }

    public final c getViewDelegate() {
        return this.viewDelegate;
    }

    @Override // com.bytedance.ee.bear.templates.BaseAnnounceTemplateViewModel
    public final MutableLiveData<Boolean> getPanelActive() {
        return this.panelActive;
    }

    private final void notifyFailed(Throwable r100) {
        this.templates.setValue(null);
    }

    private final void setCurrTemplatePos(int r100) {
        getCurrTemplatePos().setValue(Integer.valueOf(r100));
    }

    public final void setAnnounceToken(String r100) {
        this.announceToken = r100;
    }

    public final void setAnnounceUrl(String r100) {
        this.announceUrl = r100;
    }

    public final void setPanelActive(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.panelActive = r100;
    }

    public final void setPanelDelegate(b r100) {
        this.panelDelegate = r100;
    }

    public final void setPanelLocOnScreen(int[] r100) {
        this.panelLocOnScreen = r100;
    }

    public final void setPreviewActive(Boolean r100) {
        this.previewActive.setValue(r100);
    }

    public final void setPreviewTemplateView(com.bytedance.ee.bear.templates.preview.announce.d r100) {
        this.previewTemplateView = r100;
    }

    public final void setTemplateData(TemplateData r100) {
        this.templateData = r100;
    }

    public final void setTemplates(MutableLiveData<ArrayList<AnnounceTemplate>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templates = r100;
    }

    public final void setTitleBarHeight(float r100) {
        this.titleBarHeight = r100;
    }

    public final void setViewDelegate(c r100) {
        this.viewDelegate = r100;
    }

    public static final /* synthetic */ void access$notifyFailed(AnnounceTemplateViewModel r100, Throwable r101) {
        r100.notifyFailed(r101);
    }

    private final Flowable<UsedTemplateResult> loadUseTemplateDataFromNet(String r100, String r101) {
        NetService.f r102 = new NetService.f(SELECTED_USED_TEMPLATE_API_PATH);
        HashMap r103 = new HashMap();
        r103.put("obj_token", r100);
        r103.put("obj_type", String.valueOf(sbb.e.f541296g.f541317b));
        r103.put("template_obj_token", r101);
        r103.put("base_rev", "0");
        com.alibaba.fastjson.JSONObject r104 = new com.alibaba.fastjson.JSONObject();
        Integer r105 = 0;
        Integer r106 = 0;
        TemplateData r107 = this.templateData;
        if (r107 == null) goto L11;
        r106 = null;
        if (r107 == null) goto L7;
        r105 = Integer.valueOf(r107.getPosition());
    L8:
        TemplateData r108 = this.templateData;
        if (r108 == null) goto L11;
        r106 = Integer.valueOf(r108.getBaseRev());
        goto L11
    L7:
        r105 = null;
    L11:
        r104.put("position", r105);
        r104.put("bese_rev", r106);
        r103.put("extra", JSON.toJSONString(r104));
        r102.d(r103);
        r102.f216906c = 1;
        return getNetService().Vc(j.f239150a).a(r102).onErrorReturn(k.f239151a);
    }

    public final void loadAnnounceUrl(int r100, boolean r101) {
        if (this.templates.getValue() == null) goto L25;
        if (r100 < 0) goto L26;
        ArrayList<AnnounceTemplate> r102 = this.templates.getValue();
        Intrinsics.checkNotNull(r102);
        if (r100 >= r102.size()) goto L27;
        setCurrTemplatePos(r100);
        ArrayList<AnnounceTemplate> r103 = this.templates.getValue();
        if (r103 == null) goto L11;
        AnnounceTemplate r104 = (AnnounceTemplate) ListProtector.get(r103, r100);
    L12:
        if (r104 != null) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == false) goto L19;
        return;
    L19:
        Bundle r106 = new Bundle();
        r106.putBoolean(BACK_STACK_MARK, r101);
        RouteBean r107 = new RouteBean();
        r107.f236649n = r106;
        t45.c r108 = p.a();
        String r109 = sbb.e.f541296g.getType();
        if (r104 == null) goto L22;
        String r110 = r104.getObjToken();
    L23:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r108.ua(r109, r110, "template_preview") + "&template_preview_source=announce", r107);
        return;
    L22:
        r110 = null;
        goto L23
    L14:
        if (r104.getEnable() == true) goto L16;
        r105 = true;
        goto L17
    L11:
        r104 = null;
        goto L12
    L27:
        return;
    L26:
        return;
    }

    public final void handleDlpToast(String r100, int r101, int r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, "templateToken");
        Intrinsics.checkNotNullParameter(r103, LynxError.LYNX_THROWABLE);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L8;
        ErrorResponse r104 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).e(r100, Integer.valueOf(r101), "CREATE_COPY", r103);
        if (r104.getHasHandledUiAction() == false) goto L12;
        r104.getCallback().a(eu5.b.f474075a, r104);
        return;
    L12:
        return;
    L8:
        String r105 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).f(r100, "CCM_CREATE_COPY", r102);
        if (TextUtils.isEmpty(r105) == true) goto L13;
        Toast.showFailureText(eu5.b.f474075a, r105);
        return;
    }
}
