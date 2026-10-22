package com.bytedance.ee.bear.templates.preview.announce;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSON;
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
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 j2\u00020\u0001:\u0003jklB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020B07J\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020BH\u0002J\u000e\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080KJ\n\u0010L\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080KH\u0016J\u0015\u0010M\u001a\u00020H2\b\u0010N\u001a\u0004\u0018\u000108¢\u0006\u0002\u0010OJ\u0006\u0010P\u001a\u00020HJ\u0006\u0010Q\u001a\u00020HJ\u0010\u0010R\u001a\u00020H2\u0006\u0010S\u001a\u00020TH\u0002J\u0006\u0010U\u001a\u00020HJ\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020X0WH\u0002J\n\u0010Y\u001a\u0004\u0018\u00010;H\u0002J\u0006\u0010Z\u001a\u00020HJ(\u0010[\u001a\u00020H2\u0006\u0010\\\u001a\u00020\u00102\u0006\u0010]\u001a\u00020B2\u0006\u0010^\u001a\u00020B2\u0006\u0010S\u001a\u00020TH\u0007J\u001e\u0010_\u001a\b\u0012\u0004\u0012\u00020`0W2\u0006\u0010a\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u0010H\u0002J\u0016\u0010b\u001a\u00020H2\u0006\u0010I\u001a\u00020B2\u0006\u0010c\u001a\u000208R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0082\u000e¢\u0006\u0002\n\u0000R4\u00109\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020;\u0018\u00010:j\n\u0012\u0004\u0012\u00020;\u0018\u0001`<07X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020B07X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010C\u001a\b\u0012\u0004\u0012\u00020807X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010>\"\u0004\bE\u0010@R\u001c\u0010d\u001a\u0004\u0018\u00010eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010i¨\u0006m"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel;", "Lcom/bytedance/ee/bear/templates/BaseAnnounceTemplateViewModel;", "<init>", "()V", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "netService$delegate", "Lkotlin/Lazy;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "announceToken", "", "getAnnounceToken", "()Ljava/lang/String;", "setAnnounceToken", "(Ljava/lang/String;)V", "announceUrl", "getAnnounceUrl", "setAnnounceUrl", "panelDelegate", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$PanelDelegate;", "getPanelDelegate", "()Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$PanelDelegate;", "setPanelDelegate", "(Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$PanelDelegate;)V", "templateData", "Lcom/bytedance/ee/bear/templates/preview/announce/TemplateData;", "getTemplateData", "()Lcom/bytedance/ee/bear/templates/preview/announce/TemplateData;", "setTemplateData", "(Lcom/bytedance/ee/bear/templates/preview/announce/TemplateData;)V", "titleBarHeight", "", "getTitleBarHeight", "()F", "setTitleBarHeight", "(F)V", "panelLocOnScreen", "", "getPanelLocOnScreen", "()[I", "setPanelLocOnScreen", "([I)V", "previewTemplateView", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnouncePreviewTemplateView;", "getPreviewTemplateView", "()Lcom/bytedance/ee/bear/templates/preview/announce/AnnouncePreviewTemplateView;", "setPreviewTemplateView", "(Lcom/bytedance/ee/bear/templates/preview/announce/AnnouncePreviewTemplateView;)V", "previewActive", "Landroidx/lifecycle/MutableLiveData;", "", "templates", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplate;", "Lkotlin/collections/ArrayList;", "getTemplates", "()Landroidx/lifecycle/MutableLiveData;", "setTemplates", "(Landroidx/lifecycle/MutableLiveData;)V", "currTemplatePos", "", "panelActive", "getPanelActive", "setPanelActive", "getCurrTemplatePos", "setCurrTemplatePos", "", "pos", "getPreviewActive", "Landroidx/lifecycle/LiveData;", "getPanelLocOnScreenS", "setPreviewActive", WikiFolderPushPlugin.DATA, "(Ljava/lang/Boolean;)V", "onClickHidePanel", "onRefreshUI", "notifyFailed", "throwable", "", "loadCardData", "loadAnnounceTemplates", "Lio/reactivex/Flowable;", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateResults;", "getCurrTemplate", "loadTemplateDataFromNet", "handleDlpToast", "templateToken", ResourceData.KEY_TYPE, "code", "loadUseTemplateDataFromNet", "Lcom/bytedance/ee/bear/templates/preview/announce/UsedTemplateResult;", "docToken", "loadAnnounceUrl", "addToTask", "viewDelegate", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel$ViewDelegate;)V", "Companion", "PanelDelegate", "ViewDelegate", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Result parse(String r4) {
            AnnounceTemplateResults.Companion.getClass();
            if (r4 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == true) goto L24;
            boolean r1 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
            JSONObject r5 = new JSONObject(r4).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Throwable -> L18
            if (r5 == null) goto L15;
            JSONArray r6 = r5.optJSONArray("templates");     // Catch: Throwable -> L18
        L16:
            AnnounceTemplateResults r2 = new AnnounceTemplateResults(AnnounceTemplateResults.a.a(r6, r1), null);     // Catch: Throwable -> L18
        L21:
            return r2;
        L15:
            r6 = null;
        L18:
            th = move-exception;
            tt5.a.d("AnnounceTemplates", "parse()...error:" + th);
            r2 = new AnnounceTemplateResults(new ArrayList(), th);
            goto L21
        L24:
            return new AnnounceTemplateResults(new ArrayList(), new Throwable("json is null"));
        L5:
            if (StringsKt.isBlank(r4) == true) goto L8;
            r0 = false;
            goto L9
        }
    }

    public static final class e<T, R> implements Function {
        public static final e<T, R> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            return new AnnounceTemplateResults(new ArrayList(), r4);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ AnnounceTemplateViewModel a;

        public f(AnnounceTemplateViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            AnnounceTemplateResults r3 = (AnnounceTemplateResults) r2;
            if (r3.getErr() == null) goto L5;
            AnnounceTemplateViewModel.access$notifyFailed(this.a, r3.getErr());
            return;
        L5:
            this.a.getTemplates().setValue(r3.getTemplates());
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ AnnounceTemplateViewModel a;

        public g(AnnounceTemplateViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "t");
            AnnounceTemplateViewModel.access$notifyFailed(this.a, r3);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ AnnounceTemplateViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Integer c;

        public h(AnnounceTemplateViewModel r1, String r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            UsedTemplateResult r8 = (UsedTemplateResult) r7;
            if (((Result) r8).code == 0) goto L5;
            AnnounceTemplateViewModel.access$notifyFailed(this.a, new Throwable("result  data error! code = " + ((Result) r8).code + " message = " + ((Result) r8).msg));
            this.a.handleDlpToast(this.b, this.c.intValue(), ((Result) r8).code, new NetService.ServerErrorException(((Result) r8).code, "", "", ""));
            return;
        L5:
            this.a.setPreviewActive(Boolean.FALSE);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ AnnounceTemplateViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Integer c;

        public i(AnnounceTemplateViewModel r1, String r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            Intrinsics.checkNotNullParameter(r6, "t");
            AnnounceTemplateViewModel r0 = this.a;
            r0.handleDlpToast(this.b, this.c.intValue(), k0.a(r6), r6);
            AnnounceTemplateViewModel.access$notifyFailed(r0, r6);
        }
    }

    public static final class j<T extends Result> implements NetService.c {
        public static final j<T> a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final Result parse(String r3) {
            if (r3 != null) goto L4;
        L7:
            boolean r0 = true;
        L8:
            if (r0 == false) goto L10;
            tt5.a.d(AnnounceTemplateViewModel.TAG, "loadUseTemplateDataFromNet: result data null!");
            return new UsedTemplateResult(null, -1);
        L10:
            JSONObject r1 = new JSONObject(r3);
            return new UsedTemplateResult(r1.optString("ObjToken"), r1.optInt("NewRev"));
        L4:
            if (StringsKt.isBlank(r3) == true) goto L7;
            r0 = false;
            goto L8
        }
    }

    public static final class k<T, R> implements Function {
        public static final k<T, R> a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final Object apply(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            tt5.a.e(AnnounceTemplateViewModel.TAG, "loadUseTemplateDataFromNet: ", r5, false);
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
        ArrayList r0 = (ArrayList) this.templates.getValue();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L7:
        if (r2 <= 0) goto L15;
        ArrayList r3 = (ArrayList) this.templates.getValue();
        if (r3 == null) goto L16;
        Integer r4 = (Integer) this.currTemplatePos.getValue();
        if (r4 == null) goto L14;
        r1 = r4.intValue();
    L14:
        return (AnnounceTemplate) ListProtector.get(r3, r1);
    L16:
        return null;
    L15:
        return null;
    L5:
        r2 = 0;
        goto L7
    }

    private final NetService getNetService() {
        return (NetService) this.netService$delegate.getValue();
    }

    private final Flowable<AnnounceTemplateResults> loadAnnounceTemplates() {
        NetService.f r0 = new NetService.f(ANNOUNCE_RECOMMEND_TEMPLATE_API_PATH);
        r0.b("platform", "group_announcement");
        r0.b("obj_type", String.valueOf(sbb.e.g.b));
        r0.b(ResourceData.KEY_OBJ_TOKEN, this.announceToken);
        r0.b("version", "4");
        r0.b("scene", "");
        r0.b("num", "0");
        ((NetService.e) r0).c = 2;
        return getNetService().Vc(d.a).a(r0).onErrorReturn(e.a).observeOn(fo5.d.d());
    }

    public final void onClickHidePanel() {
        b r0 = this.panelDelegate;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void onRefreshUI() {
        b r0 = this.panelDelegate;
        if (r0 == null) goto L6;
        r0.b();
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
        Disposable r0 = loadAnnounceTemplates().subscribe(new f(this), new g(this));
        getCompositeDisposable().add(r0);
    }

    public final void loadTemplateDataFromNet() {
        AnnounceTemplate r0 = getCurrTemplate();
        if (r0 == null) goto L5;
        String r2 = r0.getObjToken();
    L6:
        if (r0 == null) goto L8;
        Integer r1 = Integer.valueOf(r0.getObjType());
    L10:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(this.announceToken) == true) goto L29;
        if (r1 == null) goto L30;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L20;
        PermissionResponse r3 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity(r2, sbb.e.d(r1.intValue()), BizDomain.FileBizDomainCCM, ""), "CREATE_COPY"), null);
        r3.getCallback().a(eu5.b.a, r3);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r3) == false) goto L26;
        return;
    L26:
        String r4 = this.announceToken;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r2);
        getCompositeDisposable().add(loadUseTemplateDataFromNet(r4, r2).subscribe(new h(this, r2, r1), new i(this, r2, r1)));
        return;
    L20:
        gj5.b r5 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r6 = FileBizDomain.FileBizDomainCCM;
        gj5.c r7 = r5.g("CCM_CREATE_COPY", r6, r1.intValue(), r2);
        if (r7.a == true) goto L26;
        if (r7.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L26;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CREATE_COPY", r6, r1.intValue(), r2);
        return;
    L30:
        return;
    L29:
        return;
    L8:
        r1 = null;
        goto L10
    L5:
        r2 = null;
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

    /* JADX INFO: renamed from: getPanelActive, reason: collision with other method in class */
    public final MutableLiveData<Boolean> m569getPanelActive() {
        return this.panelActive;
    }

    private final void notifyFailed(Throwable r2) {
        this.templates.setValue(null);
    }

    private final void setCurrTemplatePos(int r2) {
        getCurrTemplatePos().setValue(Integer.valueOf(r2));
    }

    public final void setAnnounceToken(String r1) {
        this.announceToken = r1;
    }

    public final void setAnnounceUrl(String r1) {
        this.announceUrl = r1;
    }

    public final void setPanelActive(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.panelActive = r2;
    }

    public final void setPanelDelegate(b r1) {
        this.panelDelegate = r1;
    }

    public final void setPanelLocOnScreen(int[] r1) {
        this.panelLocOnScreen = r1;
    }

    public final void setPreviewActive(Boolean r2) {
        this.previewActive.setValue(r2);
    }

    public final void setPreviewTemplateView(com.bytedance.ee.bear.templates.preview.announce.d r1) {
        this.previewTemplateView = r1;
    }

    public final void setTemplateData(TemplateData r1) {
        this.templateData = r1;
    }

    public final void setTemplates(MutableLiveData<ArrayList<AnnounceTemplate>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.templates = r2;
    }

    public final void setTitleBarHeight(float r1) {
        this.titleBarHeight = r1;
    }

    public final void setViewDelegate(c r1) {
        this.viewDelegate = r1;
    }

    public static final /* synthetic */ void access$notifyFailed(AnnounceTemplateViewModel r0, Throwable r1) {
        r0.notifyFailed(r1);
    }

    private final Flowable<UsedTemplateResult> loadUseTemplateDataFromNet(String r5, String r6) {
        NetService.f r0 = new NetService.f(SELECTED_USED_TEMPLATE_API_PATH);
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_OBJ_TOKEN, r5);
        r1.put("obj_type", String.valueOf(sbb.e.g.b));
        r1.put("template_obj_token", r6);
        r1.put("base_rev", "0");
        com.alibaba.fastjson.JSONObject r7 = new com.alibaba.fastjson.JSONObject();
        Integer r2 = 0;
        Integer r8 = 0;
        TemplateData r3 = this.templateData;
        if (r3 == null) goto L11;
        r8 = null;
        if (r3 == null) goto L7;
        r2 = Integer.valueOf(r3.getPosition());
    L8:
        TemplateData r4 = this.templateData;
        if (r4 == null) goto L11;
        r8 = Integer.valueOf(r4.getBaseRev());
        goto L11
    L7:
        r2 = null;
    L11:
        r7.put("position", r2);
        r7.put("bese_rev", r8);
        r1.put("extra", JSON.toJSONString(r7));
        r0.d(r1);
        ((NetService.e) r0).c = 1;
        return getNetService().Vc(j.a).a(r0).onErrorReturn(k.a);
    }

    public final void loadAnnounceUrl(int r5, boolean r6) {
        if (this.templates.getValue() == null) goto L25;
        if (r5 < 0) goto L26;
        Object r0 = this.templates.getValue();
        Intrinsics.checkNotNull(r0);
        if (r5 >= ((ArrayList) r0).size()) goto L27;
        setCurrTemplatePos(r5);
        ArrayList r1 = (ArrayList) this.templates.getValue();
        if (r1 == null) goto L11;
        AnnounceTemplate r7 = (AnnounceTemplate) ListProtector.get(r1, r5);
    L12:
        if (r7 != null) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L19;
        return;
    L19:
        Bundle r3 = new Bundle();
        r3.putBoolean(BACK_STACK_MARK, r6);
        RouteBean r8 = new RouteBean();
        r8.n = r3;
        t45.c r4 = p.a();
        String r9 = sbb.e.g.getType();
        if (r7 == null) goto L22;
        String r10 = r7.getObjToken();
    L23:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r4.ua(r9, r10, "template_preview") + "&template_preview_source=announce", r8);
        return;
    L22:
        r10 = null;
        goto L23
    L14:
        if (r7.getEnable() == true) goto L16;
        r2 = true;
        goto L17
    L11:
        r7 = null;
        goto L12
    L27:
        return;
    L26:
        return;
    }

    public final void handleDlpToast(String r4, int r5, int r6, Throwable r7) {
        Intrinsics.checkNotNullParameter(r4, "templateToken");
        Intrinsics.checkNotNullParameter(r7, "throwable");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L8;
        ErrorResponse r8 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).e(r4, Integer.valueOf(r5), "CREATE_COPY", r7);
        if (r8.getHasHandledUiAction() == false) goto L12;
        r8.getCallback().a(eu5.b.a, r8);
        return;
    L12:
        return;
    L8:
        String r9 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).f(r4, "CCM_CREATE_COPY", r6);
        if (TextUtils.isEmpty(r9) == true) goto L13;
        Toast.showFailureText(eu5.b.a, r9);
        return;
    }
}
