package com.bytedance.ee.bear.document.plugin.loading;

import android.app.Application;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.j5;
import com.bytedance.ee.bear.document.o;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.document.y5;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import z05.i;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 E2\u00020\u0001:\u0002EFB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00100\u001a\u00020&H\u0016J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u001c\u00105\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001c\u00108\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u00109\u001a\u0002022\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0010\u0010:\u001a\u0002022\b\u0010;\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010<\u001a\u0002022\u0006\u0010;\u001a\u00020\u001fJ\b\u0010=\u001a\u000202H\u0014J\b\u0010>\u001a\u000202H\u0014J\u0010\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020\fH\u0014J\b\u0010A\u001a\u000202H\u0002J\b\u0010B\u001a\u00020\u0011H\u0014J\u0010\u0010C\u001a\u0002022\u0006\u0010D\u001a\u00020&H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b\"\u0010#R!\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b'\u0010\u000eR\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020&0*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u0006G"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/loading/OfficeLoadingPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "mDocReport", "Lcom/bytedance/ee/bear/document/analytic/DocReport2;", "getMDocReport", "()Lcom/bytedance/ee/bear/document/analytic/DocReport2;", "mDocReport$delegate", "Lkotlin/Lazy;", "loadingState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/document/plugin/loading/OfficeDocumentLoadState;", "getLoadingState", "()Landroidx/lifecycle/MutableLiveData;", "loadingState$delegate", "isEditionTokenInPath", "", "errorLayout", "Lcom/bytedance/ee/bear/dependency/IErrorLayout;", "getErrorLayout", "()Lcom/bytedance/ee/bear/dependency/IErrorLayout;", "errorLayout$delegate", "loadingFrameContainer", "Landroid/widget/FrameLayout;", "getLoadingFrameContainer", "()Landroid/widget/FrameLayout;", "loadingFrameContainer$delegate", "mOnRetryListener", "Lcom/bytedance/ee/bear/document/plugin/loading/OnRetryListener;", "mOnBackSourceDocListener", "Lcom/bytedance/ee/bear/document/plugin/loading/OnBackSourceDocListener;", "editionManager", "Lcom/bytedance/ee/bear/document/editionmanager/EditionManager;", "getEditionManager", "()Lcom/bytedance/ee/bear/document/editionmanager/EditionManager;", "editionManager$delegate", "mutableUnSupportEvent", "", "getMutableUnSupportEvent", "mutableUnSupportEvent$delegate", "unSupportEvent", "Landroidx/lifecycle/LiveData;", "getUnSupportEvent", "()Landroidx/lifecycle/LiveData;", "documentType", "getDocumentType", "()Ljava/lang/String;", "getPluginId", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "initLoadingView", "setOnRetryListener", "listener", "setOnBackSourceDocListener", "showLoadingView", "hideLoadingView", "loadFail", "failState", "showEditionDocNotFound", "isForbidLoadingOnLoadStart", "onUnSupportEvent", "event", "Companion", "LoadingCallback", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OfficeLoadingPlugin extends DocumentPluginV3 {
    public static final a Companion = null;
    private static final int EDITION_DOC_REAL_SUB_TYPE = 4;
    private static final String TAG = "LoaddingPlugin";
    private final Lazy editionManager$delegate;
    private final Lazy errorLayout$delegate;
    private boolean isEditionTokenInPath;
    private final Lazy loadingFrameContainer$delegate;
    private final Lazy loadingState$delegate;
    private final Lazy mDocReport$delegate;
    private f mOnBackSourceDocListener;
    private g mOnRetryListener;
    private final Lazy mutableUnSupportEvent$delegate;

    public static final class a {
        public a() {
        }
    }

    public final class b extends x2.c implements x2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeLoadingPlugin f220840a;

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
            tt5.a.h(OfficeLoadingPlugin.TAG, "startLoading " + OfficeLoadingPlugin.access$getDocumentType(this.f220840a));
            if (this.f220840a.isForbidLoadingOnLoadStart() == true) goto L6;
            this.f220840a.getLoadingState().setValue(new com.bytedance.ee.bear.document.plugin.loading.b(-800001, null));
        L6:
            if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L24;
            y3 r100 = this.f220840a.getDocumentMetadata();
            if (r100 == null) goto L13;
            boolean r101 = true;
            if (r100.isSyncBlock() != true) goto L13;
        L14:
            if (r101 == true) goto L25;
            OfficeLoadingPlugin.access$setEditionTokenInPath$p(this.f220840a, false);
            y3 r102 = this.f220840a.getDocumentMetadata();
            if (r102 != null) goto L20;
            return;
        L20:
            if (r102.isEditionDoc() == true) goto L23;
            int r103 = sbb.e.e(r102.getBearUrl().f222560a).f541317b;
            String r104 = r102.getToken();
            z05.d r105 = OfficeLoadingPlugin.access$getEditionManager(this.f220840a);
            com.bytedance.ee.bear.document.plugin.loading.d r106 = new com.bytedance.ee.bear.document.plugin.loading.d(this, this.f220840a);
            r105.getClass();
            iu5.f.a(new z05.c(r105, r104, r103, r106));
            return;
        L23:
            return;
        L25:
            return;
        L13:
            r101 = false;
            goto L14
        }

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            tt5.a.h(OfficeLoadingPlugin.TAG, "loadSuccess " + OfficeLoadingPlugin.access$getDocumentType(this.f220840a));
            if (i.b(this.f220840a.getDocumentMetadata().getDocumentTypeValue()) == true) goto L5;
        L7:
            MutableLiveData<com.bytedance.ee.bear.document.plugin.loading.b> r100 = this.f220840a.getLoadingState();
            int r101 = com.bytedance.ee.bear.document.plugin.loading.b.f220848c;
            r100.setValue(new com.bytedance.ee.bear.document.plugin.loading.b(-800002, null));
            return;
        L5:
            if (OfficeLoadingPlugin.access$isEditionTokenInPath$p(this.f220840a) == false) goto L7;
            OfficeLoadingPlugin.access$showEditionDocNotFound(this.f220840a);
        }

        public b(OfficeLoadingPlugin r100) {
            this.f220840a = r100;
        }

        @Override // com.bytedance.ee.bear.document.x2.a
        public final void a(String r100) {
            OfficeLoadingPlugin.access$getMutableUnSupportEvent(this.f220840a).setValue(r100);
        }

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r100, Throwable r101) {
            StringBuilder r102 = new StringBuilder("loadFail{code:");
            r102.append(r100);
            r102.append(", ");
            if (r101 == null) goto L5;
            StackTraceElement[] r103 = r101.getStackTrace();
        L6:
            r102.append(r103);
            r102.append('}');
            tt5.a.h(OfficeLoadingPlugin.TAG, r102.toString());
            MutableLiveData<com.bytedance.ee.bear.document.plugin.loading.b> r104 = this.f220840a.getLoadingState();
            int r105 = com.bytedance.ee.bear.document.plugin.loading.b.f220848c;
            r104.setValue(new com.bytedance.ee.bear.document.plugin.loading.b(r100, r101));
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeLoadingPlugin f220841a;

        public c(OfficeLoadingPlugin r100) {
            this.f220841a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.ee.bear.document.plugin.loading.b r101 = (com.bytedance.ee.bear.document.plugin.loading.b) r100;
            switch(r101.f220849a) {
                case -800002: goto L6;
                case -800001: goto L5;
                default: goto L4;
            };
        L4:
            OfficeLoadingPlugin r102 = this.f220841a;
            Intrinsics.checkNotNull(r101);
            r102.loadFail(r101);
            return;
        L5:
            this.f220841a.showLoadingView();
            return;
        L6:
            this.f220841a.hideLoadingView();
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeLoadingPlugin f220842a;

        public d(OfficeLoadingPlugin r100) {
            this.f220842a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            OfficeLoadingPlugin r102 = this.f220842a;
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

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public void onUnSupportEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    private final z05.d getEditionManager() {
        return (z05.d) this.editionManager$delegate.getValue();
    }

    private final yx4.c getErrorLayout() {
        return (yx4.c) this.errorLayout$delegate.getValue();
    }

    private final FrameLayout getLoadingFrameContainer() {
        return (FrameLayout) this.loadingFrameContainer$delegate.getValue();
    }

    private final a05.c getMDocReport() {
        return (a05.c) this.mDocReport$delegate.getValue();
    }

    private final MutableLiveData<String> getMutableUnSupportEvent() {
        return (MutableLiveData) this.mutableUnSupportEvent$delegate.getValue();
    }

    public final MutableLiveData<com.bytedance.ee.bear.document.plugin.loading.b> getLoadingState() {
        return (MutableLiveData) this.loadingState$delegate.getValue();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public String getPluginId() {
        String r100 = y5.f222532a;
        return y5.f222533b;
    }

    public OfficeLoadingPlugin() {
        this.mDocReport$delegate = LazyKt.lazy(OfficeLoadingPlugin$mDocReport$2.INSTANCE);
        this.loadingState$delegate = LazyKt.lazy(OfficeLoadingPlugin$loadingState$2.INSTANCE);
        this.errorLayout$delegate = LazyKt.lazy(OfficeLoadingPlugin$errorLayout$2.INSTANCE);
        this.loadingFrameContainer$delegate = LazyKt.lazy(new OfficeLoadingPlugin$loadingFrameContainer$2(this));
        this.editionManager$delegate = LazyKt.lazy(OfficeLoadingPlugin$editionManager$2.INSTANCE);
        this.mutableUnSupportEvent$delegate = LazyKt.lazy(OfficeLoadingPlugin$mutableUnSupportEvent$2.INSTANCE);
    }

    private final String getDocumentType() {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("ccm.bitable.docx_base.optimized.enable") == true) goto L6;
        return "";
    L6:
        if (getHost() == null) goto L10;
        y3 r100 = getDocumentMetadata();
        if (r100 == null) goto L10;
        r100.getDocumentType();
    L10:
        return "";
    }

    private final void showEditionDocNotFound() {
        getLoadingState().setValue(new com.bytedance.ee.bear.document.plugin.loading.b(-58, new Throwable("not found edition doc!")));
        TitleBar r100 = getTitleBar();
        if (r100 == null) goto L10;
        BaseTitleBar r101 = r100.getTitleBarLayout();
        if (r101 == null) goto L11;
        LinearLayout r102 = r101.getRightLayout();
        if (r102 == null) goto L12;
        r102.setVisibility(8);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final LiveData<String> getUnSupportEvent() {
        return getMutableUnSupportEvent();
    }

    public void hideLoadingView() {
        com.bytedance.ee.bear.document.container.a r100 = (com.bytedance.ee.bear.document.container.a) getHost().getHostAbilityOrNull(com.bytedance.ee.bear.document.container.a.class);
        if (r100 == null) goto L5;
        r100.hideLoading();
    L5:
        FrameLayout r101 = getLoadingFrameContainer();
        if (r101 == null) goto L9;
        r101.setVisibility(8);
        return;
    }

    public void showLoadingView() {
        com.bytedance.ee.bear.document.container.a r100 = (com.bytedance.ee.bear.document.container.a) getHost().getHostAbilityOrNull(com.bytedance.ee.bear.document.container.a.class);
        if (r100 == null) goto L5;
        r100.showLoading();
    L5:
        FrameLayout r101 = getLoadingFrameContainer();
        if (r101 == null) goto L9;
        r101.setVisibility(8);
        return;
    }

    public static final /* synthetic */ String access$getDocumentType(OfficeLoadingPlugin r100) {
        return r100.getDocumentType();
    }

    public static final /* synthetic */ z05.d access$getEditionManager(OfficeLoadingPlugin r100) {
        return r100.getEditionManager();
    }

    public static final /* synthetic */ f access$getMOnBackSourceDocListener$p(OfficeLoadingPlugin r100) {
        return r100.mOnBackSourceDocListener;
    }

    public static final /* synthetic */ g access$getMOnRetryListener$p(OfficeLoadingPlugin r100) {
        return r100.mOnRetryListener;
    }

    public static final /* synthetic */ MutableLiveData access$getMutableUnSupportEvent(OfficeLoadingPlugin r100) {
        return r100.getMutableUnSupportEvent();
    }

    public static final /* synthetic */ boolean access$isEditionTokenInPath$p(OfficeLoadingPlugin r100) {
        return r100.isEditionTokenInPath;
    }

    public static final /* synthetic */ void access$showEditionDocNotFound(OfficeLoadingPlugin r100) {
        r100.showEditionDocNotFound();
    }

    private final void initLoadingView(t r100) {
        getLoadingState().observe(getHost().getLifecycleOwner(), new c(this));
        getMutableUnSupportEvent().observe(getHost().getLifecycleOwner(), new d(this));
    }

    public void loadFail(com.bytedance.ee.bear.document.plugin.loading.b r210) {
        Intrinsics.checkNotNullParameter(r210, "failState");
        if (r210.f220849a != 5) goto L5;
        getMDocReport().a(r210.f220849a);
        o.a();
    L5:
        hideLoadingView();
        FrameLayout r100 = getLoadingFrameContainer();
        if (r100 != null) goto L8;
        tt5.a.d(TAG, "load fail while loading view null !");
        return;
    L8:
        Throwable r101 = r210.f220850b;
        if ((r101 instanceof DocException) == false) goto L13;
        DocException r102 = (DocException) r101;
        if (r102 == null) goto L13;
        r102.getMessage();
    L13:
        ViewGroup r103 = getContainer(ContainerType.Content.getValue());
        if (r100.getParent() != null) goto L16;
        r103.addView(r100, -1, -1);
    L16:
        r100.removeAllViews();
        boolean r104 = false;
        r100.setVisibility(0);
        yx4.c r105 = getErrorLayout();
        if (r105 == null) goto L19;
        r105.a(r100);
    L19:
        int r106 = com.bytedance.ee.bear.document.plugin.loading.a.f220844a;
        int r107 = r210.f220849a;
        Resources r108 = r103.getResources();
        Intrinsics.checkNotNullParameter(r108, "resources");
        final com.bytedance.ee.bear.document.plugin.loading.a.C3148a r109 = new com.bytedance.ee.bear.document.plugin.loading.a.C3148a();
        r109.f220847c = false;
        if (r107 != (-1)) goto L22;
    L25:
        boolean r110 = true;
    L27:
        if (r110 == false) goto L30;
        r109.f220845a = R.drawable.ccm_empty_negative_no_wifi;
        r109.a(r108.getString(R.string.Doc_Facade_NetworkInterrutedRetry));
    L68:
        int r111 = r210.f220849a;
        if (r111 != (-57)) goto L71;
        boolean r112 = true;
    L72:
        if (r112 == false) goto L80;
        ChameleonPluginHost r113 = getHost();
        if (r113 == null) goto L102;
        Fragment r114 = r113.getFragment();
        if (r114 == null) goto L102;
        Resources r115 = r114.getResources();
        if (r115 == null) goto L102;
        String r116 = r115.getString(R.string.LarkCCM_Docx_VersionMgmt_View_Back2Ori_Button);
    L103:
        String r117 = r116;
        yx4.c r118 = getErrorLayout();
        if (r118 == null) goto L124;
        String r119 = r109.f220846b;
        int r120 = r109.f220845a;
        Integer r121 = Integer.valueOf(r210.f220849a);
        int r122 = r210.f220849a;
        if (r122 != (-55)) goto L108;
        boolean r123 = true;
    L109:
        String r124 = "";
        if (r123 == true) goto L120;
        if (r122 != (-56)) goto L113;
        r104 = true;
    L113:
        if (r104 == true) goto L120;
        if (tp5.b.c(r122) == true) goto L120;
        Application r125 = com.larksuite.framework.utils.b.f285948a;
        StringBuilder r126 = new StringBuilder();
        if (com.bytedance.ee.bear.document.plugin.loading.a.a(r122) == false) goto L119;
        r124 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
    L119:
        r126.append(r124);
        r126.append(r122);
        String r127 = xo5.a.c(r125, R.string.LarkCCM_Docs_ErrorCode_Mob, "code", r126.toString());
    L121:
        r118.b(new yx4.f(r119, r120, r121, r117, r127, new AnonymousClass1(r109, this)));
        return;
    L120:
        r127 = "";
        goto L121
    L108:
        r123 = false;
        goto L109
    L124:
        return;
    L102:
        r116 = null;
        goto L103
    L80:
        if (r111 != (-58)) goto L82;
        boolean r128 = true;
    L83:
        if (r128 == true) goto L102;
        if (r111 != (-55)) goto L86;
        boolean r129 = true;
    L87:
        if (r129 == true) goto L102;
        if (r111 != (-56)) goto L90;
        boolean r130 = true;
    L91:
        if (r130 == true) goto L102;
        if (tp5.b.c(r111) == true) goto L102;
        ChameleonPluginHost r131 = getHost();
        if (r131 == null) goto L102;
        Fragment r132 = r131.getFragment();
        if (r132 == null) goto L102;
        Resources r133 = r132.getResources();
        if (r133 == null) goto L102;
        r116 = r133.getString(R.string.LarkCCM_Docs_ErrorRefresh_Button_Mob);
        goto L103
    L90:
        r130 = false;
        goto L91
    L86:
        r129 = false;
        goto L87
    L82:
        r128 = false;
        goto L83
    L71:
        r112 = false;
        goto L72
    L30:
        if (com.bytedance.ee.bear.document.plugin.loading.a.a(r107) == false) goto L36;
        r109.f220845a = R.drawable.ccm_empty_negative_load_failed;
        if (j5.a() == false) goto L34;
        r109.a(r108.getString(R.string.LarkCCM_Docs_Error_LoadOT_Mob));
        goto L68
    L34:
        r109.a(r108.getString(R.string.Doc_Facade_LoadOverTime));
        goto L68
    L36:
        if (r107 != (-100001)) goto L38;
        boolean r134 = true;
    L39:
        if (r134 == false) goto L42;
        r109.f220845a = R.drawable.ccm_ccm_empty_neutral_400_403;
        r109.a(r108.getString(R.string.CreationMobile_ECM_SiteUnavailableDesc));
        goto L68
    L42:
        if (tp5.b.c(r107) == false) goto L44;
        r109.f220845a = R.drawable.ccm_empty_neutral_no_content;
        r109.a(r108.getString(R.string.CreationMobile_Wiki_PageDeleted_Toast));
        goto L68
    L44:
        if (r107 != (-55)) goto L46;
        boolean r135 = true;
    L47:
        if (r135 == false) goto L49;
        r109.f220845a = R.drawable.ccm_vc_empty_neutral_recycle_bin;
        r109.a(r108.getString(R.string.CreationMobile_ECM_DocsDeletedDesc));
        goto L68
    L49:
        if (r107 != (-58)) goto L51;
        boolean r136 = true;
    L52:
        if (r136 == false) goto L54;
        r109.f220845a = R.drawable.ccm_empty_neutral_no_content;
        r109.a(r108.getString(R.string.LarkCCM_Docx_VersionMgmt_DocNonExist_Mob));
        r109.f220847c = true;
        goto L68
    L54:
        if (r107 != (-57)) goto L56;
        boolean r137 = true;
    L57:
        if (r137 == false) goto L59;
        r109.f220845a = R.drawable.ccm_empty_neutral_no_content;
        r109.a(r108.getString(R.string.LarkCCM_Docx_VersionMgmt_Deleted));
        r109.f220847c = true;
        goto L68
    L59:
        if (r107 != (-56)) goto L61;
        boolean r138 = true;
    L62:
        if (r138 == false) goto L64;
        r109.f220845a = R.drawable.ccm_ccm_empty_neutral_document_key_unavailable;
        r109.a(r108.getString(R.string.CreationDoc_Docs_KeyInvalidCanNotRead));
        goto L68
    L64:
        r109.f220845a = R.drawable.ccm_empty_negative_load_failed;
        if (j5.a() == false) goto L67;
        r109.a(r108.getString(R.string.LarkCCM_Docs_LoadError_Mob));
        goto L68
    L67:
        StringCompanionObject r139 = StringCompanionObject.INSTANCE;
        r109.a(String.format("%s(%s)", Arrays.copyOf(new Object[]{r108.getString(R.string.Doc_Facade_LoadFailed), Integer.valueOf(r107)}, 2)));
        goto L68
    L61:
        r138 = false;
        goto L62
    L56:
        r137 = false;
        goto L57
    L51:
        r136 = false;
        goto L52
    L46:
        r135 = false;
        goto L47
    L38:
        r134 = false;
        goto L39
    L22:
        if (fw4.d.b(com.larksuite.framework.utils.b.f285948a) == NetworkType.NETWORK_NO) goto L25;
        r110 = false;
        goto L27
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        x2 r101 = getDocumentLoader();
        if (r101 == null) goto L6;
        r101.S3(new b(this));
        return;
    }

    public final void setOnBackSourceDocListener(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.mOnBackSourceDocListener = r100;
    }

    public final void setOnRetryListener(g r100) {
        this.mOnRetryListener = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    public static final /* synthetic */ void access$setEditionTokenInPath$p(OfficeLoadingPlugin r100, boolean r101) {
        r100.isEditionTokenInPath = r101;
    }

    public void onAttachToUIContainer(ChameleonPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        initLoadingView(r101);
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        this.mOnRetryListener = null;
        this.mOnBackSourceDocListener = null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((ChameleonPluginHost) r100, r101);
    }
}
