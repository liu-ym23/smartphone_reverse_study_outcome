package com.bytedance.ee.bear.document.loading;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.o;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z05.i;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 82\u00020\u0001:\u000389:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0014J\b\u0010-\u001a\u00020\u001fH\u0014J\b\u0010.\u001a\u00020\u001fH\u0014J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001bH\u0014J\u0010\u00101\u001a\u00020\u001f2\b\u00102\u001a\u0004\u0018\u00010\rJ\u000e\u00103\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u000fJ\u0010\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u0016H\u0014J\b\u00106\u001a\u00020\u0013H\u0014J\b\u00107\u001a\u00020\u001fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001c\u0010\u0018R\u0014\u0010*\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006;"}, d2 = {"Lcom/bytedance/ee/bear/document/loading/DocLoadingPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "mDocReport", "Lcom/bytedance/ee/bear/document/DocReport;", "getMDocReport", "()Lcom/bytedance/ee/bear/document/DocReport;", "mDocReport$delegate", "Lkotlin/Lazy;", "mLoadingWrapper", "Lcom/bytedance/ee/bear/document/loading/ILoadingWrapper;", "mOnRetryListener", "Lcom/bytedance/ee/bear/document/loading/LoadingLayout$OnRetryListener;", "mOnBackSourceDocListener", "Lcom/bytedance/ee/bear/document/loading/LoadingLayout$OnBackSourceDocListener;", "mEditionManager", "Lcom/bytedance/ee/bear/document/editionmanager/EditionManager;", "isEditionTokenInPath", "", "unSupportEvent", "Landroidx/lifecycle/MutableLiveData;", "", "getUnSupportEvent", "()Landroidx/lifecycle/MutableLiveData;", "unSupportEvent$delegate", "loadingState", "Lcom/bytedance/ee/bear/document/loading/DocLoadingPlugin$DocumentLoadState;", "getLoadingState", "loadingState$delegate", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "initLoadingView", "createLoadingWrapper", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "documentType", "getDocumentType", "()Ljava/lang/String;", "showLoadingView", "hideLoadingView", "loadFail", "failState", "setOnRetryListener", "listener", "setOnBackSourceDocListener", "onUnSupportEvent", "event", "isForbidLoadingOnLoadStart", "hideLoading", "Companion", "InnerLoadingHandler", "DocumentLoadState", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DocLoadingPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final int EDITION_DOC_REAL_SUB_TYPE = 4;
    private static final String TAG = "LoaddingPlugin";
    private boolean isEditionTokenInPath;
    private final Lazy loadingState$delegate;
    private final Lazy mDocReport$delegate;
    private z05.d mEditionManager;
    private com.bytedance.ee.bear.document.loading.d mLoadingWrapper;
    private LoadingLayout.b mOnBackSourceDocListener;
    private LoadingLayout.c mOnRetryListener;
    private final Lazy unSupportEvent$delegate;

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f220179c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f220180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f220181b;

        public static final class a {
        }

        static {
        }

        public b(int r100, Throwable r101) {
            this.f220180a = r100;
            this.f220181b = r101;
        }
    }

    public final class c implements x2.b, x2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocLoadingPlugin f220182a;

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onLoadCancel() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onSSRLoadSuccess() {
        }

        public final void b() {
            this.f220182a.getLoadingState().setValue(new b(-58, new Throwable("not found edition doc!")));
            TitleBar r100 = DocLoadingPlugin.access$getTitleBar(this.f220182a);
            if (r100 == null) goto L6;
            r100.getTitleBarLayout().getRightLayout().setVisibility(8);
            return;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
            tt5.a.h(DocLoadingPlugin.TAG, "startLoading " + DocLoadingPlugin.access$getDocumentType(this.f220182a));
            if (this.f220182a.isForbidLoadingOnLoadStart() == true) goto L6;
            MutableLiveData<b> r100 = this.f220182a.getLoadingState();
            int r101 = b.f220179c;
            r100.setValue(new b(-800001, null));
        L6:
            if ((this.f220182a.getHost() instanceof DocumentPluginHost) == true) goto L9;
            return;
        L9:
            if (this.f220182a.getDocumentMetadata().isSyncBlock() == true) goto L17;
            DocLoadingPlugin.access$setEditionTokenInPath$p(this.f220182a, false);
            if (this.f220182a.getDocumentMetadata().isEditionDoc() == true) goto L15;
            iu5.f.a(new com.bytedance.ee.bear.document.loading.a(this.f220182a, sbb.e.e(this.f220182a.getDocumentMetadata().getBearUrl().f222560a).f541317b, this));
            return;
        L15:
            return;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            tt5.a.h(DocLoadingPlugin.TAG, "loadSuccess " + DocLoadingPlugin.access$getDocumentType(this.f220182a));
            DocViewModel r100 = DocLoadingPlugin.access$getDocViewModel(this.f220182a);
            if (r100 == null) goto L8;
            WikiInfo r101 = r100.getWikiInfo();
            if (r101 == null) goto L7;
            int r102 = r101.getObjType();
        L10:
            if (i.b(r102) == true) goto L12;
        L14:
            this.f220182a.getLoadingState().setValue(new b(-800002, null));
            return;
        L12:
            if (DocLoadingPlugin.access$isEditionTokenInPath$p(this.f220182a) == false) goto L14;
            b();
            return;
        L7:
            r102 = r100.getDocumentTypeValue();
            goto L10
        L8:
            r102 = -1;
            goto L10
        }

        public c(DocLoadingPlugin r100) {
            this.f220182a = r100;
        }

        @Override // com.bytedance.ee.bear.document.x2.a
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            DocLoadingPlugin.access$getUnSupportEvent(this.f220182a).setValue(r100);
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r100, Throwable r101) {
            StringBuilder r102 = new StringBuilder("loadFail{code:");
            r102.append(r100);
            r102.append(", ");
            if (r101 == null) goto L5;
            StackTraceElement[] r103 = r101.getStackTrace();
        L6:
            r102.append(r103);
            r102.append('}');
            tt5.a.h(DocLoadingPlugin.TAG, r102.toString());
            MutableLiveData<b> r104 = this.f220182a.getLoadingState();
            int r105 = b.f220179c;
            r104.setValue(new b(r100, r101));
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocLoadingPlugin f220183a;

        public d(DocLoadingPlugin r100) {
            this.f220183a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            b r101 = (b) r100;
            switch(r101.f220180a) {
                case -800002: goto L6;
                case -800001: goto L5;
                default: goto L4;
            };
        L4:
            DocLoadingPlugin r102 = this.f220183a;
            Intrinsics.checkNotNull(r101);
            r102.loadFail(r101);
            return;
        L5:
            this.f220183a.showLoadingView();
            return;
        L6:
            this.f220183a.hideLoadingView();
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocLoadingPlugin f220184a;

        public e(DocLoadingPlugin r100) {
            this.f220184a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            DocLoadingPlugin r102 = this.f220184a;
            Intrinsics.checkNotNull(r101);
            r102.onUnSupportEvent(r101);
        }
    }

    static {
        Companion = new a();
    }

    public boolean isForbidLoadingOnLoadStart() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public void onUnSupportEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    private final s1 getMDocReport() {
        return (s1) this.mDocReport$delegate.getValue();
    }

    private final MutableLiveData<String> getUnSupportEvent() {
        return (MutableLiveData) this.unSupportEvent$delegate.getValue();
    }

    public final MutableLiveData<b> getLoadingState() {
        return (MutableLiveData) this.loadingState$delegate.getValue();
    }

    public void hideLoadingView() {
        com.bytedance.ee.bear.document.loading.d r100 = this.mLoadingWrapper;
        if (r100 == null) goto L6;
        r100.hide();
        return;
    }

    public void showLoadingView() {
        com.bytedance.ee.bear.document.loading.d r100 = this.mLoadingWrapper;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public DocLoadingPlugin() {
        this.mDocReport$delegate = LazyKt.lazy(DocLoadingPlugin$mDocReport$2.INSTANCE);
        this.unSupportEvent$delegate = LazyKt.lazy(DocLoadingPlugin$unSupportEvent$2.INSTANCE);
        this.loadingState$delegate = LazyKt.lazy(DocLoadingPlugin$loadingState$2.INSTANCE);
    }

    private final String getDocumentType() {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("ccm.bitable.docx_base.optimized.enable") == true) goto L5;
        return "";
    L5:
        PluginHost r100 = getHost();
        if (r100 != null) goto L8;
        return "";
    L8:
        if ((r100 instanceof DocumentPluginHost) == false) goto L17;
        DocViewModel r101 = ((DocumentPluginHost) r100).a();
        if (r101 == null) goto L18;
        String r102 = r101.getDocumentType();
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L18:
        return "";
    L17:
        return "";
    }

    public void hideLoading() {
        getLoadingState().setValue(new b(-800002, null));
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(DocLoadingPlugin r100) {
        return r100.getDocViewModel();
    }

    public static final /* synthetic */ String access$getDocumentType(DocLoadingPlugin r100) {
        return r100.getDocumentType();
    }

    public static final /* synthetic */ z05.d access$getMEditionManager$p(DocLoadingPlugin r100) {
        return r100.mEditionManager;
    }

    public static final /* synthetic */ TitleBar access$getTitleBar(DocLoadingPlugin r100) {
        return r100.getTitleBar();
    }

    public static final /* synthetic */ MutableLiveData access$getUnSupportEvent(DocLoadingPlugin r100) {
        return r100.getUnSupportEvent();
    }

    public static final /* synthetic */ boolean access$isEditionTokenInPath$p(DocLoadingPlugin r100) {
        return r100.isEditionTokenInPath;
    }

    private final void initLoadingView(t r100) {
        com.bytedance.ee.bear.document.loading.d r101 = createLoadingWrapper(r100, getEditorAbility().getDocumentMetadata().getBearUrl());
        this.mLoadingWrapper = r101;
        if (r101 == null) goto L5;
        r101.setOnRetryListener(this.mOnRetryListener);
    L5:
        com.bytedance.ee.bear.document.loading.d r102 = this.mLoadingWrapper;
        if (r102 == null) goto L8;
        r102.setOnBackSourceDocListener(this.mOnBackSourceDocListener);
    L8:
        getLoadingState().observe(getHost().getLifecycleOwner(), new d(this));
        getUnSupportEvent().observe(getHost().getLifecycleOwner(), new e(this));
    }

    public void loadFail(b r100) {
        Intrinsics.checkNotNullParameter(r100, "failState");
        if (r100.f220180a != 5) goto L6;
        getMDocReport().i(r100.f220180a);
        o.a();
    L6:
        if (this.mLoadingWrapper != null) goto L8;
        tt5.a.d(TAG, "load fail while loading view null !");
        return;
    L8:
        Throwable r101 = r100.f220181b;
        if ((r101 instanceof DocException) == false) goto L11;
        String r102 = ((DocException) r101).getMessage();
    L12:
        com.bytedance.ee.bear.document.loading.d r103 = this.mLoadingWrapper;
        if (r103 == null) goto L15;
        r103.a(r100.f220180a, r102);
    L15:
        com.bytedance.ee.bear.document.loading.d r104 = this.mLoadingWrapper;
        if (r104 == null) goto L20;
        r104.show();
        return;
    L20:
        return;
    L11:
        r102 = "";
        goto L12
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        getEditorAbility().getDocumentLoader().S3(new c(this));
        this.mEditionManager = new z05.d();
    }

    public final void setOnBackSourceDocListener(LoadingLayout.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.mOnBackSourceDocListener = r100;
        com.bytedance.ee.bear.document.loading.d r101 = this.mLoadingWrapper;
        if (r101 == null) goto L6;
        r101.setOnBackSourceDocListener(r100);
        return;
    }

    public final void setOnRetryListener(LoadingLayout.c r100) {
        this.mOnRetryListener = r100;
        com.bytedance.ee.bear.document.loading.d r101 = this.mLoadingWrapper;
        if (r101 == null) goto L6;
        r101.setOnRetryListener(r100);
        return;
    }

    public static final /* synthetic */ void access$setEditionTokenInPath$p(DocLoadingPlugin r100, boolean r101) {
        r100.isEditionTokenInPath = r101;
    }

    public com.bytedance.ee.bear.document.loading.d createLoadingWrapper(t r100, BearUrl r101) {
        Intrinsics.checkNotNullParameter(r100, "uiContainer");
        Intrinsics.checkNotNullParameter(r101, "bearUrl");
        View r102 = r100.getContentView();
        Map<String, Set<String>> r103 = d25.d.f466514a;
        if (r101 != null) goto L5;
    L15:
        boolean r104 = false;
    L17:
        return new LazyLoadingWrapper(r102, r104, r101.f222560a);
    L5:
        if (TextUtils.equals(r101.f222560a, sbb.e.f541296g.getType()) == true) goto L9;
        if (TextUtils.equals(r101.f222560a, sbb.e.f541304o.getType()) == false) goto L15;
    L9:
        if (TextUtils.equals("tab_create", r101.f222567h) == false) goto L11;
    L14:
        r104 = true;
        goto L17
    L11:
        if (TextUtils.equals("lark_create", r101.f222567h) == true) goto L14;
        if (TextUtils.equals("web_create", r101.f222567h) == false) goto L15;
        goto L14
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "uiContainer");
        initLoadingView(r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "uiContainer");
        super.onDetachFromUIContainer(r100, r101);
        this.mOnRetryListener = null;
        this.mOnBackSourceDocListener = null;
        com.bytedance.ee.bear.document.loading.d r102 = this.mLoadingWrapper;
        if (r102 == null) goto L6;
        r102.reset();
        return;
    }
}
