package com.larus.slides.sdk.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.office.IOfficeSdkService;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.plugins.attachment.OpenImagePluginV2;
import com.larus.office.base.plugins.authorization.LarkAuthorizationPluginV2;
import com.larus.office.base.plugins.dialog.AlertPluginV2;
import com.larus.office.base.plugins.editpanel.HostEditPanelPlugin;
import com.larus.office.base.plugins.permission.PermissionChangeHandlePluginV2;
import com.larus.office.base.plugins.share.OfficeSharePermissionPlugin;
import com.larus.office.base.plugins.statistics.ReportEventPluginV2;
import com.larus.office.base.plugins.titlebar.FlowDocTitleMenuPluginV2;
import com.larus.office.base.plugins.toast.ToastPluginV2;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.base.utils.f;
import com.larus.platform.service.z2;
import com.larus.slides.sdk.api.ISlidesSdkServiceV2;
import com.larus.slides.sdk.impl.plugins.cot.RenderFinishPluginV2;
import com.larus.slides.sdk.impl.plugins.event.GetTrackInfoPluginV2;
import com.larus.slides.sdk.impl.plugins.event.SlidesLoadEventPluginV2;
import com.larus.slides.sdk.impl.plugins.media.AIGenerateImagePluginV2;
import com.larus.slides.sdk.impl.plugins.media.SlidesSelectMediaPluginV2;
import com.larus.slides.sdk.impl.plugins.orientation.GetOrientationPluginV2;
import com.larus.slides.sdk.impl.plugins.orientation.SetFullscreenPluginV2;
import com.larus.slides.sdk.impl.plugins.orientation.SetOrientationPluginV2;
import com.larus.slides.sdk.impl.plugins.orientation.SlidesStateChangedPluginV2;
import com.larus.slides.sdk.impl.plugins.orientation.ToggleTitleBarPluginV2;
import com.larus.slides.sdk.impl.plugins.selection.SlidesSelectionChangePluginV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Locale;
import kk5.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sbb.e;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J<\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002Jj\u0010,\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u00010\u00122\b\u00100\u001a\u0004\u0018\u00010\u00122\b\u00101\u001a\u0004\u0018\u00010\u00122*\u00102\u001a&\u0012\u0004\u0012\u00020)\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u001403H\u0016J\b\u00105\u001a\u00020\u0014H\u0016J\u000e\u00106\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u00107J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010.\u001a\u00020\u0012H\u0002J\u0014\u0010:\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120;H\u0002J\b\u0010<\u001a\u00020\u0014H\u0002J\u0010\u0010=\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006@"}, d2 = {"Lcom/larus/slides/sdk/impl/SlidesSdkServiceImplV2;", "Lcom/larus/slides/sdk/api/ISlidesSdkServiceV2;", "<init>", "()V", "docSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "documentExportExecutor", "Lcom/bytedance/ee/bear/document/export/net/DocumentExportExecutor;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "lifecycleOrder", "", "lifecycleCategory", "", "preInitDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "destroyDocSdk", "openAndGetSlidesFragment", "Landroidx/fragment/app/Fragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "inputParam", "Lcom/larus/office/OfficeInputParam;", "listener", "Lcom/larus/office/permission/IOfficePermissionListener;", "hostAbilityProvider", "Lcom/larus/office/OfficeHostAbilityProvider;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "(Landroid/content/Context;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/larus/office/OfficeHostAbilityProvider;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadDocumentData", "tryPrefetchData", "", "buildTargetUrl", "host", "startDocExport", "fileName", "fileType", "type", "token", "eventSource", "callback", "Lkotlin/Function4;", "Landroid/net/Uri;", "cancelDocExport", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileTypeToExportFormat", "Lcom/bytedance/ee/bear/contract/export/ExportFormatEnum;", "getHost", "Lkotlin/Pair;", "initOfficeSdkIfNeeded", "injectUserHostAbility", "Companion", "SlidesOpenStrategy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesSdkServiceImplV2 implements ISlidesSdkServiceV2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f369761d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ik5.a f369762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j15.a f369763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f369764c;

    public static final class a {
    }

    public static final class b extends h {
        public b(ik5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "docSdk");
            super(r100);
        }

        @Override // com.bytedance.ee.bear.document.v4
        public final n getBizPluginList(ChameleonPluginHost r100) {
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            IOfficeSdkService r101 = (IOfficeSdkService) ServiceManager.get().getService(IOfficeSdkService.class);
            if (r101 == null) goto L5;
            n r102 = r101.g("slides");
        L6:
            OfficeSharePermissionPlugin r103 = new OfficeSharePermissionPlugin();
            z2 r104 = z2.f365865a;
            boolean r105 = r104.f4();
            PluginMountStrategy r106 = PluginMountStrategy.Immediate;
            n r107 = new n(new n.a[]{n.i(r103, r105, r106)});
            if (r104.f4() == false) goto L14;
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            n r108 = this.f503810a.getBizPluginList(r100);
            if (r102 == null) goto L13;
            r107 = n.c(r102, r107);
        L13:
            return n.c(r108, r107);
        L14:
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            n r109 = this.f503810a.getBizPluginList(r100);
            SlidesSelectionChangePluginV2 r110 = new SlidesSelectionChangePluginV2();
            PluginMountStrategy r111 = PluginMountStrategy.LoadFinish;
            ToastPluginV2 r112 = new ToastPluginV2();
            PluginMountStrategy r113 = PluginMountStrategy.FirstJSCall;
            return n.c(r109, n.c(r107, new n(new n.a[]{n.i(new ReportEventPluginV2(), true, r106), n.i(new LarkAuthorizationPluginV2(), true, r106), n.i(new HostEditPanelPlugin(new com.larus.slides.sdk.impl.b()), true, r106), n.i(new SlidesLoadEventPluginV2(), true, r106), n.i(new FlowDocTitleMenuPluginV2(false), true, r106), n.i(r110, true, r111), n.i(r112, true, r113), n.i(new AlertPluginV2(), true, r113), n.i(new OpenImagePluginV2(), true, r111), n.i(new ToggleTitleBarPluginV2(), true, r106), n.i(new GetOrientationPluginV2(), true, r106), n.i(new GetTrackInfoPluginV2(), true, r106), n.i(new PermissionChangeHandlePluginV2(), true, r106), n.i(new AIGenerateImagePluginV2(), true, r111), n.i(new SlidesSelectMediaPluginV2(), true, r111), n.i(new SetOrientationPluginV2(), true, r106), n.i(new SetFullscreenPluginV2(), true, r106), n.i(new SlidesStateChangedPluginV2(), true, r106), n.i(new RenderFinishPluginV2(), true, r113)})));
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void destroyDocSdk() {
        this.f369762a = null;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final String lifecycleCategory() {
        return "slides";
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final int lifecycleOrder() {
        return 2;
    }

    public final Pair<Boolean, String> W() {
        AppHost.Companion r100 = AppHost.f326268a;
        boolean r101 = true;
        if (r100.isDebug() == false) goto L5;
    L6:
        String r102 = ((Keva) this.f369764c.getValue()).getString("doc_host", "");
        Intrinsics.checkNotNull(r102);
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L12;
    L18:
        r102 = "https://www.doubao.com";
    L20:
        return new Pair(Boolean.valueOf(r101), r102);
    L12:
        if (StringsKt.startsWith$default(r102, "http://", false, 2, null) == false) goto L14;
    L17:
        r101 = false;
        goto L20
    L14:
        if (StringsKt.startsWith$default(r102, "https://", false, 2, null) == true) goto L17;
        r102 = "http://".concat(r102);
        goto L17
    L9:
        r103 = false;
        goto L10
    L5:
        if (r100.isTestChannel() == false) goto L18;
        goto L6
    }

    public final void X() {
        FLogger.f375446a.i("SlidesSdkServiceImplV2", "Init Office sdk if needed");
        IOfficeSdkServiceV2 r100 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r100 == null) goto L6;
        IOfficeSdkServiceV2.a.b(r100, true, null, 6);
        return;
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
    public final void cancelDocExport() {
        FLogger.f375446a.i("SlidesSdkServiceImplV2", "cancelDocExport");
        j15.a r100 = this.f369763b;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f369763b = null;
    }

    public SlidesSdkServiceImplV2() {
        this.f369764c = LazyKt.lazy(new com.larus.slides.sdk.impl.a());
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
    public final Object a(Continuation<? super Unit> r100) {
        if ((r100 instanceof SlidesSdkServiceImplV2$initSdkIfNeeded$1) == false) goto L7;
        SlidesSdkServiceImplV2$initSdkIfNeeded$1 r101 = (SlidesSdkServiceImplV2$initSdkIfNeeded$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        SlidesSdkServiceImplV2 r106 = (SlidesSdkServiceImplV2) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L30
    L24:
        ik5.a r107 = (ik5.a) r103;     // Catch: Exception -> L30
    L26:
        r106.f369762a = r107;     // Catch: Exception -> L30
        ik5.a r108 = this.f369762a;     // Catch: Exception -> L30
        if (r108 == null) goto L33;
        r108.Ka(e.f541302m, new b(r108));     // Catch: Exception -> L30
    L33:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        if (this.f369762a != null) goto L33;
        X();     // Catch: Exception -> L30
        IOfficeSdkServiceV2 r109 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L30
        if (r109 == null) goto L25;
        r101.L$0 = this;     // Catch: Exception -> L30
        r101.label = 1;     // Catch: Exception -> L30
        r103 = r109.o0(15000, r101);     // Catch: Exception -> L30
        if (r103 != r104) goto L23;
        return r104;
    L23:
        r106 = this;
        goto L24
    L25:
        r107 = null;
        r106 = this;
    L30:
        e = move-exception;
        FLogger.f375446a.e("SlidesSdkServiceImplV2", "Load docSdk failed: " + e.getMessage());
    L7:
        r101 = new SlidesSdkServiceImplV2$initSdkIfNeeded$1(this, r100);
        goto L8
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
    public final boolean c(OfficeInputParam r100) {
        Intrinsics.checkNotNullParameter(r100, "inputParam");
        ik5.a r101 = this.f369762a;
        if (r101 != null) goto L11;
        IOfficeSdkServiceV2 r102 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r102 == null) goto L9;
        r101 = r102.c0();
        if (r101 == null) goto L9;
        this.f369762a = r101;
    L9:
        r101 = null;
    L11:
        if (r101 != null) goto L14;
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("tryPrefetchData skipped, docSdk not ready, token=");
        int r105 = f.f361173a;
        r104.append(f.b(r100.getSlidesToken()));
        r103.i("SlidesSdkServiceImplV2", r104.toString());
        return false;
    L14:
        String r106 = V(W().getSecond(), r100);
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("tryPrefetchData, token=");
        int r109 = f.f361173a;
        r108.append(f.b(r100.getSlidesToken()));
        r107.i("SlidesSdkServiceImplV2", r108.toString());
        r101.r2(r106, "doubao");
        return true;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void initDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 == null) goto L5;
        ik5.a r102 = r101.c0();
    L6:
        this.f369762a = r102;
        FLogger.f375446a.i("SlidesSdkServiceImplV2", "initDocSdk: docSdk:" + this.f369762a);
        ik5.a r103 = this.f369762a;
        if (r103 == null) goto L10;
        r103.Ka(e.f541302m, new b(r103));
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
    public final void j(OfficeInputParam r100) {
        Intrinsics.checkNotNullParameter(r100, "inputParam");
        ik5.a r101 = this.f369762a;
        if (r101 != null) goto L6;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("preloadDocumentData skipped, docSdk not ready, token=");
        int r104 = f.f361173a;
        r103.append(f.b(r100.getSlidesToken()));
        r102.i("SlidesSdkServiceImplV2", r103.toString());
        return;
    L6:
        String r105 = V(W().getSecond(), r100);
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("preloadDocumentData, token=");
        int r108 = f.f361173a;
        r107.append(f.b(r100.getSlidesToken()));
        r106.i("SlidesSdkServiceImplV2", r107.toString());
        r101.Qd(r105);
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void postInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        FLogger.f375446a.i("SlidesSdkServiceImplV2", "postInitDocSdk: docSdk:" + this.f369762a);
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void preInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        FLogger.f375446a.i("SlidesSdkServiceImplV2", "preInitDocSdk: docSdk:" + this.f369762a);
    }

    public final String V(String r100, OfficeInputParam r101) {
        int r102 = r101.getResourceVersion();
        String r103 = r101.getSlidesToken();
        String r104 = r101.getEnterMethod();
        if (r104.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L9;
        r104 = "unknown";
    L9:
        if (r102 > 0) goto L11;
        String r106 = r100 + "/slides/" + r103 + "?from=" + r104;
    L12:
        com.larus.office.base.preview.c r107 = com.larus.office.base.preview.c.f361026a;
        String r108 = r101.getSourceUrlForParams();
        r107.getClass();
        String r109 = com.larus.office.base.preview.c.j(r106, r108);
        FLogger.f375446a.d("SlidesSdkServiceImplV2", "buildTargetUrl merged, url=" + f.c(r109));
        return r109;
    L11:
        r106 = r100 + "/slides/" + r103 + "?version=" + r102 + "&from=" + r104;
        goto L12
    L5:
        r105 = false;
        goto L6
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
    public final Object s(OfficeInputParam r110, fo9.b r111, com.larus.office.h r112, com.bytedance.ee.bear.container.f r113, Continuation r114) {
        if ((r114 instanceof SlidesSdkServiceImplV2$openAndGetSlidesFragment$1) == false) goto L7;
        SlidesSdkServiceImplV2$openAndGetSlidesFragment$1 r100 = (SlidesSdkServiceImplV2$openAndGetSlidesFragment$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        SlidesSdkServiceImplV2 r105 = (SlidesSdkServiceImplV2) r100.L$4;
        com.bytedance.ee.bear.container.f r106 = (com.bytedance.ee.bear.container.f) r100.L$3;
        com.larus.office.h r107 = (com.larus.office.h) r100.L$2;
        fo9.b r108 = (fo9.b) r100.L$1;
        OfficeInputParam r109 = (OfficeInputParam) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
    L33:
        ik5.a r115 = (ik5.a) r102;     // Catch: Exception -> L14
    L43:
        r105.f369762a = r115;     // Catch: Exception -> L14
    L49:
        com.bytedance.ee.bear.container.f r116 = r106;
    L51:
        ex9.e.f474727b = r109;
        c r117 = new c(new an9.a(r108), r107, r109);
        String r118 = V(W().getSecond(), r109);
        if (r109.getDocPreloaded() == false) goto L54;
        FLogger r119 = FLogger.f375446a;
        StringBuilder r120 = new StringBuilder("skip preload in openAndGetSlidesFragment, already preloaded upstream, token=");
        int r121 = f.f361173a;
        r120.append(f.b(r109.getSlidesToken()));
        r119.i("SlidesSdkServiceImplV2", r120.toString());
    L57:
        ik5.a r122 = this.f369762a;
        if (r122 == null) goto L62;
        Fragment r123 = r122.C6(r118, Boxing.boxLong(r109.getClickTimestamp()), null, r117, r116);
        if (r123 == null) goto L62;
        return r123;
    L62:
        return new Fragment();
    L54:
        FLogger r124 = FLogger.f375446a;
        StringBuilder r125 = new StringBuilder("preload in openAndGetSlidesFragment, token=");
        int r126 = f.f361173a;
        r125.append(f.b(r109.getSlidesToken()));
        r124.i("SlidesSdkServiceImplV2", r125.toString());
        ik5.a r127 = this.f369762a;
        if (r127 == null) goto L57;
        r127.Qd(r118);
    L14:
        e = e;
    L48:
        FLogger.f375446a.e("SlidesSdkServiceImplV2", "Load docSdk failed: " + e.getMessage());
        goto L49
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("SlidesSdkServiceImplV2", "Get slides fragment, docSdk:" + this.f369762a);
        ((Keva) this.f369764c.getValue()).storeBoolean("has_opened_fusion_doc", true);
        if (this.f369762a == null) goto L69;
        r108 = r111;
        r109 = r110;
        r107 = r112;
        r116 = r113;
        goto L51
    L69:
        X();     // Catch: Exception -> L45
        IOfficeSdkServiceV2 r128 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L45
        OfficeInputParam r129 = r110;
        if (r128 != null) goto L71;
        r108 = r111;
        r115 = null;
        r105 = this;
        r109 = r129;
        r107 = r112;
        r106 = r113;
        goto L43
    L71:
        r100.L$0 = r129;     // Catch: Exception -> L40
        r108 = r111;
        r100.L$1 = r108;     // Catch: Exception -> L38
        com.larus.office.h r130 = r112;
        r100.L$2 = r130;     // Catch: Exception -> L36
        com.bytedance.ee.bear.container.f r131 = r113;
        r100.L$3 = r131;     // Catch: Exception -> L34
        r100.L$4 = this;     // Catch: Exception -> L34
        r100.label = 1;     // Catch: Exception -> L34
        r102 = r128.o0(15000, r100);     // Catch: Exception -> L34
        if (r102 != r103) goto L32;
        return r103;
    L32:
        r105 = this;
        r109 = r129;
        r107 = r130;
        r106 = r131;
    L34:
        e = e;
    L47:
        r109 = r129;
        r107 = r130;
        r106 = r131;
    L36:
        e = e;
    L37:
        r131 = r113;
    L38:
        e = e;
    L39:
        r130 = r112;
    L40:
        e = e;
    L41:
        r108 = r111;
    L45:
        e = e;
        r129 = r110;
    L7:
        r100 = new SlidesSdkServiceImplV2$openAndGetSlidesFragment$1(this, r114);
        goto L8
    }

    @Override // com.larus.slides.sdk.api.ISlidesSdkServiceV2
    public final void y(Context r110, String r111, String r112, String r113, String r114, com.larus.slides.operation.download.a r115) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "fileName");
        Intrinsics.checkNotNullParameter(r112, "fileType");
        Intrinsics.checkNotNullParameter(r115, "callback");
        ik5.a r100 = this.f369762a;
        if (r100 == null) goto L5;
        j15.a r101 = r100.R4(r110, r111);
    L6:
        if (r101 != null) goto L9;
        r115.invoke(Boolean.FALSE, null, null, "export executor is null");
        return;
    L9:
        String r116 = r112.toLowerCase(Locale.ROOT);
        switch(r116.hashCode()) {
            case 110834: goto L25;
            case 115312: goto L21;
            case 3088960: goto L17;
            case 3447940: goto L13;
            default: goto L29;
        };
    L29:
        rw4.n r102 = null;
    L30:
        if (r102 != null) goto L33;
        r115.invoke(Boolean.FALSE, null, null, "unsupported fileType: ".concat(r112));
        return;
    L33:
        if (r114 != null) goto L35;
    L37:
        String r103 = null;
    L38:
        if (r103 != null) goto L41;
        r115.invoke(Boolean.FALSE, null, null, "token is empty");
        return;
    L41:
        this.f369763b = r101;
        r101.a(r102, r113, r103, "41", null, new d(r115));
        return;
    L35:
        if ((!StringsKt.isBlank(r114)) == false) goto L37;
        r103 = r114;
        goto L38
    L13:
        if (r116.equals(ExportFileExtension.PPTX) == false) goto L43;
        rw4.n r117 = rw4.n.f539706h;
    L28:
        r102 = r117;
        goto L30
    L43:
        r102 = null;
        goto L30
    L17:
        if (r116.equals(DocumentType.DOCX_NAME) == false) goto L44;
        r117 = rw4.n.f539701c;
        goto L28
    L44:
        r102 = null;
        goto L30
    L21:
        if (r116.equals("txt") == false) goto L45;
        r117 = rw4.n.f539707i;
        goto L28
    L45:
        r102 = null;
        goto L30
    L25:
        if (r116.equals(ExportFileExtension.PDF) == false) goto L46;
        r117 = rw4.n.f539702d;
        goto L28
    L46:
        r102 = null;
        goto L30
    L5:
        r101 = null;
        goto L6
    }
}
