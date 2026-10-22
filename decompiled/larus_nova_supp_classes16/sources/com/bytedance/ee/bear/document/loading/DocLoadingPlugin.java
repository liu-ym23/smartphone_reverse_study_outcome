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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public static final /* synthetic */ int c = 0;
        public final int a;
        public final Throwable b;

        public static final class a {
        }

        static {
        }

        public b(int r1, Throwable r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final class c implements x2.b, x2.a {
        public final /* synthetic */ DocLoadingPlugin a;

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onLoadCancel() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onSSRLoadSuccess() {
        }

        public final void b() {
            this.a.getLoadingState().setValue(new b(-58, new Throwable("not found edition doc!")));
            TitleBar r0 = DocLoadingPlugin.access$getTitleBar(this.a);
            if (r0 == null) goto L6;
            r0.getTitleBarLayout().getRightLayout().setVisibility(8);
            return;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
            tt5.a.h(DocLoadingPlugin.TAG, "startLoading " + DocLoadingPlugin.access$getDocumentType(this.a));
            if (this.a.isForbidLoadingOnLoadStart() == true) goto L6;
            MutableLiveData<b> r0 = this.a.getLoadingState();
            int r1 = b.c;
            r0.setValue(new b(-800001, null));
        L6:
            if ((this.a.getHost() instanceof DocumentPluginHost) == true) goto L9;
            return;
        L9:
            if (this.a.getDocumentMetadata().isSyncBlock() == true) goto L17;
            DocLoadingPlugin.access$setEditionTokenInPath$p(this.a, false);
            if (this.a.getDocumentMetadata().isEditionDoc() == true) goto L15;
            iu5.f.a(new com.bytedance.ee.bear.document.loading.a(this.a, sbb.e.e(this.a.getDocumentMetadata().getBearUrl().a).b, this));
            return;
        L15:
            return;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            tt5.a.h(DocLoadingPlugin.TAG, "loadSuccess " + DocLoadingPlugin.access$getDocumentType(this.a));
            DocViewModel r0 = DocLoadingPlugin.access$getDocViewModel(this.a);
            if (r0 == null) goto L8;
            WikiInfo r1 = r0.getWikiInfo();
            if (r1 == null) goto L7;
            int r2 = r1.getObjType();
        L10:
            if (i.b(r2) == true) goto L12;
        L14:
            this.a.getLoadingState().setValue(new b(-800002, null));
            return;
        L12:
            if (DocLoadingPlugin.access$isEditionTokenInPath$p(this.a) == false) goto L14;
            b();
            return;
        L7:
            r2 = r0.getDocumentTypeValue();
            goto L10
        L8:
            r2 = -1;
            goto L10
        }

        public c(DocLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.x2.a
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            DocLoadingPlugin.access$getUnSupportEvent(this.a).setValue(r2);
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r3, Throwable r4) {
            StringBuilder r0 = new StringBuilder("loadFail{code:");
            r0.append(r3);
            r0.append(", ");
            if (r4 == null) goto L5;
            StackTraceElement[] r1 = r4.getStackTrace();
        L6:
            r0.append(r1);
            r0.append('}');
            tt5.a.h(DocLoadingPlugin.TAG, r0.toString());
            MutableLiveData<b> r2 = this.a.getLoadingState();
            int r5 = b.c;
            r2.setValue(new b(r3, r4));
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DocLoadingPlugin a;

        public d(DocLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            b r3 = (b) r2;
            switch(r3.a) {
                case -800002: goto L6;
                case -800001: goto L5;
                default: goto L4;
            };
        L4:
            DocLoadingPlugin r0 = this.a;
            Intrinsics.checkNotNull(r3);
            r0.loadFail(r3);
            return;
        L5:
            this.a.showLoadingView();
            return;
        L6:
            this.a.hideLoadingView();
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DocLoadingPlugin a;

        public e(DocLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            String r3 = (String) r2;
            DocLoadingPlugin r0 = this.a;
            Intrinsics.checkNotNull(r3);
            r0.onUnSupportEvent(r3);
        }
    }

    static {
        Companion = new a();
    }

    public boolean isForbidLoadingOnLoadStart() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void onUnSupportEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
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
        com.bytedance.ee.bear.document.loading.d r0 = this.mLoadingWrapper;
        if (r0 == null) goto L6;
        r0.hide();
        return;
    }

    public void showLoadingView() {
        com.bytedance.ee.bear.document.loading.d r0 = this.mLoadingWrapper;
        if (r0 == null) goto L6;
        r0.b();
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
        PluginHost r0 = getHost();
        if (r0 != null) goto L8;
        return "";
    L8:
        if ((r0 instanceof DocumentPluginHost) == false) goto L17;
        DocViewModel r1 = ((DocumentPluginHost) r0).a();
        if (r1 == null) goto L18;
        String r2 = r1.getDocumentType();
        if (r2 != null) goto L15;
        return "";
    L15:
        return r2;
    L18:
        return "";
    L17:
        return "";
    }

    public void hideLoading() {
        getLoadingState().setValue(new b(-800002, null));
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(DocLoadingPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ String access$getDocumentType(DocLoadingPlugin r0) {
        return r0.getDocumentType();
    }

    public static final /* synthetic */ z05.d access$getMEditionManager$p(DocLoadingPlugin r0) {
        return r0.mEditionManager;
    }

    public static final /* synthetic */ TitleBar access$getTitleBar(DocLoadingPlugin r0) {
        return r0.getTitleBar();
    }

    public static final /* synthetic */ MutableLiveData access$getUnSupportEvent(DocLoadingPlugin r0) {
        return r0.getUnSupportEvent();
    }

    public static final /* synthetic */ boolean access$isEditionTokenInPath$p(DocLoadingPlugin r0) {
        return r0.isEditionTokenInPath;
    }

    private final void initLoadingView(t r3) {
        com.bytedance.ee.bear.document.loading.d r4 = createLoadingWrapper(r3, getEditorAbility().getDocumentMetadata().getBearUrl());
        this.mLoadingWrapper = r4;
        if (r4 == null) goto L5;
        r4.setOnRetryListener(this.mOnRetryListener);
    L5:
        com.bytedance.ee.bear.document.loading.d r5 = this.mLoadingWrapper;
        if (r5 == null) goto L8;
        r5.setOnBackSourceDocListener(this.mOnBackSourceDocListener);
    L8:
        getLoadingState().observe(getHost().getLifecycleOwner(), new d(this));
        getUnSupportEvent().observe(getHost().getLifecycleOwner(), new e(this));
    }

    public void loadFail(b r3) {
        Intrinsics.checkNotNullParameter(r3, "failState");
        if (r3.a != 5) goto L6;
        getMDocReport().i(r3.a);
        o.a();
    L6:
        if (this.mLoadingWrapper != null) goto L8;
        tt5.a.d(TAG, "load fail while loading view null !");
        return;
    L8:
        Throwable r0 = r3.b;
        if ((r0 instanceof DocException) == false) goto L11;
        String r1 = ((DocException) r0).getMessage();
    L12:
        com.bytedance.ee.bear.document.loading.d r2 = this.mLoadingWrapper;
        if (r2 == null) goto L15;
        r2.a(r3.a, r1);
    L15:
        com.bytedance.ee.bear.document.loading.d r4 = this.mLoadingWrapper;
        if (r4 == null) goto L20;
        r4.show();
        return;
    L20:
        return;
    L11:
        r1 = "";
        goto L12
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        getEditorAbility().getDocumentLoader().S3(new c(this));
        this.mEditionManager = new z05.d();
    }

    public final void setOnBackSourceDocListener(LoadingLayout.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mOnBackSourceDocListener = r2;
        com.bytedance.ee.bear.document.loading.d r0 = this.mLoadingWrapper;
        if (r0 == null) goto L6;
        r0.setOnBackSourceDocListener(r2);
        return;
    }

    public final void setOnRetryListener(LoadingLayout.c r2) {
        this.mOnRetryListener = r2;
        com.bytedance.ee.bear.document.loading.d r0 = this.mLoadingWrapper;
        if (r0 == null) goto L6;
        r0.setOnRetryListener(r2);
        return;
    }

    public static final /* synthetic */ void access$setEditionTokenInPath$p(DocLoadingPlugin r0, boolean r1) {
        r0.isEditionTokenInPath = r1;
    }

    public com.bytedance.ee.bear.document.loading.d createLoadingWrapper(t r4, BearUrl r5) {
        Intrinsics.checkNotNullParameter(r4, "uiContainer");
        Intrinsics.checkNotNullParameter(r5, "bearUrl");
        View r6 = r4.getContentView();
        Map<String, Set<String>> r1 = d25.d.a;
        if (r5 != null) goto L5;
    L15:
        boolean r2 = false;
    L17:
        return new LazyLoadingWrapper(r6, r2, r5.a);
    L5:
        if (TextUtils.equals(r5.a, sbb.e.g.getType()) == true) goto L9;
        if (TextUtils.equals(r5.a, sbb.e.o.getType()) == false) goto L15;
    L9:
        if (TextUtils.equals("tab_create", r5.h) == false) goto L11;
    L14:
        r2 = true;
        goto L17
    L11:
        if (TextUtils.equals("lark_create", r5.h) == true) goto L14;
        if (TextUtils.equals("web_create", r5.h) == false) goto L15;
        goto L14
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        initLoadingView(r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onDetachFromUIContainer(r2, r3);
        this.mOnRetryListener = null;
        this.mOnBackSourceDocListener = null;
        com.bytedance.ee.bear.document.loading.d r4 = this.mLoadingWrapper;
        if (r4 == null) goto L6;
        r4.reset();
        return;
    }
}
