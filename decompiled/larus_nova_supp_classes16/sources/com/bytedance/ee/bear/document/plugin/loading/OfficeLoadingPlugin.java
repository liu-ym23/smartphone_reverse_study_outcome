package com.bytedance.ee.bear.document.plugin.loading;

import android.app.Application;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ OfficeLoadingPlugin a;

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
            tt5.a.h(OfficeLoadingPlugin.TAG, "startLoading " + OfficeLoadingPlugin.access$getDocumentType(this.a));
            if (this.a.isForbidLoadingOnLoadStart() == true) goto L6;
            this.a.getLoadingState().setValue(new com.bytedance.ee.bear.document.plugin.loading.b(-800001, null));
        L6:
            if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L24;
            y3 r0 = this.a.getDocumentMetadata();
            if (r0 == null) goto L13;
            boolean r2 = true;
            if (r0.isSyncBlock() != true) goto L13;
        L14:
            if (r2 == true) goto L25;
            OfficeLoadingPlugin.access$setEditionTokenInPath$p(this.a, false);
            y3 r1 = this.a.getDocumentMetadata();
            if (r1 != null) goto L20;
            return;
        L20:
            if (r1.isEditionDoc() == true) goto L23;
            int r3 = sbb.e.e(r1.getBearUrl().a).b;
            String r4 = r1.getToken();
            z05.d r5 = OfficeLoadingPlugin.access$getEditionManager(this.a);
            com.bytedance.ee.bear.document.plugin.loading.d r6 = new com.bytedance.ee.bear.document.plugin.loading.d(this, this.a);
            r5.getClass();
            iu5.f.a(new z05.c(r5, r4, r3, r6));
            return;
        L23:
            return;
        L25:
            return;
        L13:
            r2 = false;
            goto L14
        }

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            tt5.a.h(OfficeLoadingPlugin.TAG, "loadSuccess " + OfficeLoadingPlugin.access$getDocumentType(this.a));
            if (i.b(this.a.getDocumentMetadata().getDocumentTypeValue()) == true) goto L5;
        L7:
            MutableLiveData<com.bytedance.ee.bear.document.plugin.loading.b> r0 = this.a.getLoadingState();
            int r1 = com.bytedance.ee.bear.document.plugin.loading.b.c;
            r0.setValue(new com.bytedance.ee.bear.document.plugin.loading.b(-800002, null));
            return;
        L5:
            if (OfficeLoadingPlugin.access$isEditionTokenInPath$p(this.a) == false) goto L7;
            OfficeLoadingPlugin.access$showEditionDocNotFound(this.a);
        }

        public b(OfficeLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.x2.a
        public final void a(String r2) {
            OfficeLoadingPlugin.access$getMutableUnSupportEvent(this.a).setValue(r2);
        }

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r3, Throwable r4) {
            StringBuilder r0 = new StringBuilder("loadFail{code:");
            r0.append(r3);
            r0.append(", ");
            if (r4 == null) goto L5;
            StackTraceElement[] r1 = r4.getStackTrace();
        L6:
            r0.append(r1);
            r0.append('}');
            tt5.a.h(OfficeLoadingPlugin.TAG, r0.toString());
            MutableLiveData<com.bytedance.ee.bear.document.plugin.loading.b> r2 = this.a.getLoadingState();
            int r5 = com.bytedance.ee.bear.document.plugin.loading.b.c;
            r2.setValue(new com.bytedance.ee.bear.document.plugin.loading.b(r3, r4));
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ OfficeLoadingPlugin a;

        public c(OfficeLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            com.bytedance.ee.bear.document.plugin.loading.b r3 = (com.bytedance.ee.bear.document.plugin.loading.b) r2;
            switch(r3.a) {
                case -800002: goto L6;
                case -800001: goto L5;
                default: goto L4;
            };
        L4:
            OfficeLoadingPlugin r0 = this.a;
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

    public static final class d<T> implements Observer {
        public final /* synthetic */ OfficeLoadingPlugin a;

        public d(OfficeLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            String r3 = (String) r2;
            OfficeLoadingPlugin r0 = this.a;
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

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void onUnSupportEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
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

    public String getPluginId() {
        String r0 = y5.a;
        return y5.b;
    }

    public OfficeLoadingPlugin() {
        this.mDocReport$delegate = LazyKt.lazy(OfficeLoadingPlugin$mDocReport$2.INSTANCE);
        this.loadingState$delegate = LazyKt.lazy(OfficeLoadingPlugin$loadingState$2.INSTANCE);
        this.errorLayout$delegate = LazyKt.lazy(OfficeLoadingPlugin$errorLayout$2.INSTANCE);
        this.loadingFrameContainer$delegate = LazyKt.lazy(new OfficeLoadingPlugin$loadingFrameContainer$2(this));
        this.editionManager$delegate = LazyKt.lazy(OfficeLoadingPlugin$editionManager$2.INSTANCE);
        this.mutableUnSupportEvent$delegate = LazyKt.lazy(OfficeLoadingPlugin$mutableUnSupportEvent$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getDocumentType() {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("ccm.bitable.docx_base.optimized.enable") == true) goto L6;
        return "";
    L6:
        if (getHost() == null) goto L10;
        y3 r0 = getDocumentMetadata();
        if (r0 == null) goto L10;
        r0.getDocumentType();
    L10:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showEditionDocNotFound() {
        getLoadingState().setValue(new com.bytedance.ee.bear.document.plugin.loading.b(-58, new Throwable("not found edition doc!")));
        TitleBar r0 = getTitleBar();
        if (r0 == null) goto L10;
        BaseTitleBar r1 = r0.getTitleBarLayout();
        if (r1 == null) goto L11;
        LinearLayout r2 = r1.getRightLayout();
        if (r2 == null) goto L12;
        r2.setVisibility(8);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final LiveData<String> getUnSupportEvent() {
        return getMutableUnSupportEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void hideLoadingView() {
        com.bytedance.ee.bear.document.container.a r0 = (com.bytedance.ee.bear.document.container.a) getHost().getHostAbilityOrNull(com.bytedance.ee.bear.document.container.a.class);
        if (r0 == null) goto L5;
        r0.hideLoading();
    L5:
        FrameLayout r1 = getLoadingFrameContainer();
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showLoadingView() {
        com.bytedance.ee.bear.document.container.a r0 = (com.bytedance.ee.bear.document.container.a) getHost().getHostAbilityOrNull(com.bytedance.ee.bear.document.container.a.class);
        if (r0 == null) goto L5;
        r0.showLoading();
    L5:
        FrameLayout r1 = getLoadingFrameContainer();
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    }

    public static final /* synthetic */ String access$getDocumentType(OfficeLoadingPlugin r0) {
        return r0.getDocumentType();
    }

    public static final /* synthetic */ z05.d access$getEditionManager(OfficeLoadingPlugin r0) {
        return r0.getEditionManager();
    }

    public static final /* synthetic */ f access$getMOnBackSourceDocListener$p(OfficeLoadingPlugin r0) {
        return r0.mOnBackSourceDocListener;
    }

    public static final /* synthetic */ g access$getMOnRetryListener$p(OfficeLoadingPlugin r0) {
        return r0.mOnRetryListener;
    }

    public static final /* synthetic */ MutableLiveData access$getMutableUnSupportEvent(OfficeLoadingPlugin r0) {
        return r0.getMutableUnSupportEvent();
    }

    public static final /* synthetic */ boolean access$isEditionTokenInPath$p(OfficeLoadingPlugin r0) {
        return r0.isEditionTokenInPath;
    }

    public static final /* synthetic */ void access$showEditionDocNotFound(OfficeLoadingPlugin r0) {
        r0.showEditionDocNotFound();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initLoadingView(t r3) {
        getLoadingState().observe(getHost().getLifecycleOwner(), new c(this));
        getMutableUnSupportEvent().observe(getHost().getLifecycleOwner(), new d(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadFail(com.bytedance.ee.bear.document.plugin.loading.b r20) {
        Intrinsics.checkNotNullParameter(r20, "failState");
        if (r20.a != 5) goto L5;
        getMDocReport().a(r20.a);
        o.a();
    L5:
        hideLoadingView();
        FrameLayout r2 = getLoadingFrameContainer();
        if (r2 != null) goto L8;
        tt5.a.d(TAG, "load fail while loading view null !");
        return;
    L8:
        Throwable r3 = r20.b;
        if ((r3 instanceof DocException) == false) goto L13;
        DocException r4 = (DocException) r3;
        if (r4 == null) goto L13;
        r4.getMessage();
    L13:
        ViewGroup r5 = getContainer(ContainerType.Content.getValue());
        if (r2.getParent() != null) goto L16;
        r5.addView(r2, -1, -1);
    L16:
        r2.removeAllViews();
        boolean r6 = false;
        r2.setVisibility(0);
        yx4.c r7 = getErrorLayout();
        if (r7 == null) goto L19;
        r7.a(r2);
    L19:
        int r8 = com.bytedance.ee.bear.document.plugin.loading.a.a;
        int r9 = r20.a;
        Resources r10 = r5.getResources();
        Intrinsics.checkNotNullParameter(r10, "resources");
        final com.bytedance.ee.bear.document.plugin.loading.a.C0092a r11 = new com.bytedance.ee.bear.document.plugin.loading.a.C0092a();
        r11.c = false;
        if (r9 != (-1)) goto L22;
    L25:
        boolean r12 = true;
    L27:
        if (r12 == false) goto L30;
        r11.a = 2131232543;
        r11.a(r10.getString(2131887782));
    L68:
        int r13 = r20.a;
        if (r13 != (-57)) goto L71;
        boolean r14 = true;
    L72:
        if (r14 == false) goto L80;
        ChameleonPluginHost r16 = getHost();
        if (r16 == null) goto L102;
        Fragment r17 = r16.getFragment();
        if (r17 == null) goto L102;
        Resources r18 = r17.getResources();
        if (r18 == null) goto L102;
        String r19 = r18.getString(2131889376);
    L103:
        String r110 = r19;
        yx4.c r21 = getErrorLayout();
        if (r21 == null) goto L124;
        String r111 = r11.b;
        int r112 = r11.a;
        Integer r113 = Integer.valueOf(r20.a);
        int r1 = r20.a;
        if (r1 != (-55)) goto L108;
        boolean r22 = true;
    L109:
        String r23 = "";
        if (r22 == true) goto L120;
        if (r1 != (-56)) goto L113;
        r6 = true;
    L113:
        if (r6 == true) goto L120;
        if (tp5.b.c(r1) == true) goto L120;
        Application r24 = com.larksuite.framework.utils.b.a;
        StringBuilder r26 = new StringBuilder();
        if (com.bytedance.ee.bear.document.plugin.loading.a.a(r1) == false) goto L119;
        r23 = "A";
    L119:
        r26.append(r23);
        r26.append(r1);
        String r114 = xo5.a.c(r24, 2131889051, "code", r26.toString());
    L121:
        r21.b(new yx4.f(r111, r112, r113, r110, r114, new AnonymousClass1(r11, this)));
        return;
    L120:
        r114 = "";
        goto L121
    L108:
        r22 = false;
        goto L109
    L124:
        return;
    L102:
        r19 = null;
        goto L103
    L80:
        if (r13 != (-58)) goto L82;
        boolean r27 = true;
    L83:
        if (r27 == true) goto L102;
        if (r13 != (-55)) goto L86;
        boolean r28 = true;
    L87:
        if (r28 == true) goto L102;
        if (r13 != (-56)) goto L90;
        boolean r29 = true;
    L91:
        if (r29 == true) goto L102;
        if (tp5.b.c(r13) == true) goto L102;
        ChameleonPluginHost r30 = getHost();
        if (r30 == null) goto L102;
        Fragment r31 = r30.getFragment();
        if (r31 == null) goto L102;
        Resources r32 = r31.getResources();
        if (r32 == null) goto L102;
        r19 = r32.getString(2131889052);
        goto L103
    L90:
        r29 = false;
        goto L91
    L86:
        r28 = false;
        goto L87
    L82:
        r27 = false;
        goto L83
    L71:
        r14 = false;
        goto L72
    L30:
        if (com.bytedance.ee.bear.document.plugin.loading.a.a(r9) == false) goto L36;
        r11.a = 2131232542;
        if (j5.a() == false) goto L34;
        r11.a(r10.getString(2131889053));
        goto L68
    L34:
        r11.a(r10.getString(2131887768));
        goto L68
    L36:
        if (r9 != (-100001)) goto L38;
        boolean r33 = true;
    L39:
        if (r33 == false) goto L42;
        r11.a = 2131232536;
        r11.a(r10.getString(2131887301));
        goto L68
    L42:
        if (tp5.b.c(r9) == false) goto L44;
        r11.a = 2131232549;
        r11.a(r10.getString(2131887502));
        goto L68
    L44:
        if (r9 != (-55)) goto L46;
        boolean r34 = true;
    L47:
        if (r34 == false) goto L49;
        r11.a = 2131232580;
        r11.a(r10.getString(2131887257));
        goto L68
    L49:
        if (r9 != (-58)) goto L51;
        boolean r36 = true;
    L52:
        if (r36 == false) goto L54;
        r11.a = 2131232549;
        r11.a(r10.getString(2131889365));
        r11.c = true;
        goto L68
    L54:
        if (r9 != (-57)) goto L56;
        boolean r37 = true;
    L57:
        if (r37 == false) goto L59;
        r11.a = 2131232549;
        r11.a(r10.getString(2131889364));
        r11.c = true;
        goto L68
    L59:
        if (r9 != (-56)) goto L61;
        boolean r38 = true;
    L62:
        if (r38 == false) goto L64;
        r11.a = 2131232537;
        r11.a(r10.getString(2131887106));
        goto L68
    L64:
        r11.a = 2131232542;
        if (j5.a() == false) goto L67;
        r11.a(r10.getString(2131889107));
        goto L68
    L67:
        StringCompanionObject r39 = StringCompanionObject.INSTANCE;
        r11.a(String.format("%s(%s)", Arrays.copyOf(new Object[]{r10.getString(2131887767), Integer.valueOf(r9)}, 2)));
        goto L68
    L61:
        r38 = false;
        goto L62
    L56:
        r37 = false;
        goto L57
    L51:
        r36 = false;
        goto L52
    L46:
        r34 = false;
        goto L47
    L38:
        r33 = false;
        goto L39
    L22:
        if (fw4.d.b(com.larksuite.framework.utils.b.a) == NetworkType.NETWORK_NO) goto L25;
        r12 = false;
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        x2 r3 = getDocumentLoader();
        if (r3 == null) goto L6;
        r3.S3(new b(this));
        return;
    }

    public final void setOnBackSourceDocListener(f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mOnBackSourceDocListener = r2;
    }

    public final void setOnRetryListener(g r1) {
        this.mOnRetryListener = r1;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$setEditionTokenInPath$p(OfficeLoadingPlugin r0, boolean r1) {
        r0.isEditionTokenInPath = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        initLoadingView(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        this.mOnRetryListener = null;
        this.mOnBackSourceDocListener = null;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
