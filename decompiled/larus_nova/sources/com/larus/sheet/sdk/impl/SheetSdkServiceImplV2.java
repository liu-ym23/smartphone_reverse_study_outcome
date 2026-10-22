package com.larus.sheet.sdk.impl;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.office.IOfficeSdkService;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.plugins.attachment.OpenImagePluginV2;
import com.larus.office.base.plugins.authorization.LarkAuthorizationPluginV2;
import com.larus.office.base.plugins.editpanel.HostEditPanelPlugin;
import com.larus.office.base.plugins.media.SheetSelectMediaPluginV2;
import com.larus.office.base.plugins.permission.PermissionChangeHandlePluginV2;
import com.larus.office.base.plugins.share.OfficeSharePermissionPlugin;
import com.larus.office.base.plugins.statistics.ReportEventPluginV2;
import com.larus.office.base.plugins.titlebar.FlowDocTitleMenuPluginV2;
import com.larus.office.base.plugins.toast.ToastPluginV2;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.base.service.m;
import com.larus.platform.service.z2;
import com.larus.sheet.sdk.api.ISheetSdkServiceV2;
import com.larus.sheet.sdk.impl.plugins.chat_input.SheetChatInputVisibilityPlugin;
import com.larus.sheet.sdk.impl.plugins.event.GetTrackInfoPluginV2;
import com.larus.sheet.sdk.impl.plugins.event.SheetLoadEventPluginV2;
import com.larus.sheet.sdk.impl.plugins.orientation.OrientationInfoPlugin;
import com.larus.sheet.sdk.impl.plugins.orientation.ToggleTitleBarPluginV2;
import com.larus.sheet.sdk.impl.plugins.selection.SheetSelectionChangePluginV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ew4.b0;
import ew4.e0;
import ew4.f0;
import ew4.g0;
import ew4.w;
import ew4.z;
import java.util.Locale;
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

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J<\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096@¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010(\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0010H\u0016Jr\u0010.\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u00010\u00102\b\u00102\u001a\u0004\u0018\u00010\u00102\b\u00103\u001a\u0004\u0018\u00010\u001022\u00104\u001a.\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u000106\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u001205H\u0016J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u00100\u001a\u00020\u0010H\u0002J\u0014\u0010:\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100;H\u0002J\b\u0010<\u001a\u00020\u0012H\u0002J\u0010\u0010=\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J0\u0010>\u001a\u00020\u00122\b\u0010?\u001a\u0004\u0018\u00010\u00102\b\u0010@\u001a\u0004\u0018\u00010\u00102\b\u0010A\u001a\u0004\u0018\u00010\u00102\b\u0010B\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006E"}, d2 = {"Lcom/larus/sheet/sdk/impl/SheetSdkServiceImplV2;", "Lcom/larus/sheet/sdk/api/ISheetSdkServiceV2;", "<init>", "()V", "docSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "lifecycleOrder", "", "lifecycleCategory", "", "preInitDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "destroyDocSdk", "openAndGetSheetFragment", "Landroidx/fragment/app/Fragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "inputParam", "Lcom/larus/office/OfficeInputParam;", "listener", "Lcom/larus/office/permission/IOfficePermissionListener;", "hostAbilityProvider", "Lcom/larus/office/OfficeHostAbilityProvider;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "(Landroid/content/Context;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/larus/office/OfficeHostAbilityProvider;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadDocumentData", "tryPrefetchData", "", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildTargetUrl", "host", "onContextMenuShow", "key", "startDocExport", "fileName", "fileType", "type", "token", "eventSource", "callback", "Lkotlin/Function5;", "Landroid/net/Uri;", "", "fileTypeToExportFormat", "Lcom/bytedance/ee/bear/contract/export/ExportFormatEnum;", "getHost", "Lkotlin/Pair;", "initOfficeSdkIfNeeded", "injectUserHostAbility", "updateTrackParams", "artifactMetaId", "conversationId", "messageId", "botId", "Companion", "SheetOpenStrategy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetSdkServiceImplV2 implements ISheetSdkServiceV2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f369141c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ik5.a f369142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f369143b;

    public static final class a {
    }

    public static final class b extends kk5.g {
        public b(ik5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "docSdk");
            super(r100);
        }

        @Override // com.bytedance.ee.bear.document.v4
        public final n getBizPluginList(ChameleonPluginHost r110) {
            Intrinsics.checkNotNullParameter(r110, "pluginHost");
            IOfficeSdkService r100 = (IOfficeSdkService) ServiceManager.get().getService(IOfficeSdkService.class);
            if (r100 == null) goto L5;
            n r101 = r100.g(DocumentType.SHEET_NAME);
        L6:
            SheetSelectMediaPluginV2 r102 = new SheetSelectMediaPluginV2(new com.larus.office.base.plugins.media.a());
            PluginMountStrategy r103 = PluginMountStrategy.LoadFinish;
            OfficeSharePermissionPlugin r104 = new OfficeSharePermissionPlugin();
            z2 r105 = z2.f365865a;
            boolean r106 = r105.f4();
            PluginMountStrategy r111 = PluginMountStrategy.Immediate;
            n r107 = new n(new n.a[]{n.i(r102, true, r103), n.i(r104, r106, r111)});
            if (r105.f4() == false) goto L14;
            Intrinsics.checkNotNullParameter(r110, "pluginHost");
            n r112 = this.f503808a.getBizPluginList(r110);
            if (r101 == null) goto L13;
            r107 = n.c(r101, r107);
        L13:
            return n.c(r112, r107);
        L14:
            Intrinsics.checkNotNullParameter(r110, "pluginHost");
            return n.c(this.f503808a.getBizPluginList(r110), n.c(r107, new n(new n.a[]{n.i(new SheetLoadEventPluginV2(), true, r111), n.i(new LarkAuthorizationPluginV2(), true, r111), n.i(new ReportEventPluginV2(), true, r111), n.i(new ReportEventPluginV2(), true, r111), n.i(new FlowDocTitleMenuPluginV2(false), true, r111), n.i(new ToastPluginV2(), true, PluginMountStrategy.FirstJSCall), n.i(new SheetSelectionChangePluginV2(), true, r103), n.i(new OpenImagePluginV2(), true, r103), n.i(new ToggleTitleBarPluginV2(), true, r111), n.i(new HostEditPanelPlugin(new com.larus.sheet.sdk.impl.b()), true, r111), n.i(new OrientationInfoPlugin(), true, r111), n.i(new SheetChatInputVisibilityPlugin(), true, r103), n.i(new GetTrackInfoPluginV2(), true, r111), n.i(new GetTrackInfoPluginV2(), true, r111), n.i(new PermissionChangeHandlePluginV2(), true, r111)})));
        L5:
            r101 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void destroyDocSdk() {
        this.f369142a = null;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final String lifecycleCategory() {
        return DocumentType.SHEET_NAME;
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
        String r102 = ((Keva) this.f369143b.getValue()).getString("doc_host", "");
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
        FLogger.f375446a.i("SheetSdkServiceImplV2", "Init Office sdk if needed");
        IOfficeSdkServiceV2 r100 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r100 == null) goto L6;
        IOfficeSdkServiceV2.a.b(r100, false, null, 7);
        return;
    }

    public SheetSdkServiceImplV2() {
        this.f369143b = LazyKt.lazy(new com.larus.sheet.sdk.impl.a());
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final void G() {
        Lazy r100 = m.f361113a;
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final Object a(Continuation<? super Unit> r100) {
        if ((r100 instanceof SheetSdkServiceImplV2$initSdkIfNeeded$1) == false) goto L7;
        SheetSdkServiceImplV2$initSdkIfNeeded$1 r101 = (SheetSdkServiceImplV2$initSdkIfNeeded$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        SheetSdkServiceImplV2 r106 = (SheetSdkServiceImplV2) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L30
    L24:
        ik5.a r107 = (ik5.a) r103;     // Catch: Exception -> L30
    L26:
        r106.f369142a = r107;     // Catch: Exception -> L30
        ik5.a r108 = this.f369142a;     // Catch: Exception -> L30
        if (r108 == null) goto L33;
        r108.Ka(sbb.e.f541297h, new b(r108));     // Catch: Exception -> L30
    L33:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        if (this.f369142a != null) goto L33;
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
        FLogger.f375446a.e("SheetSdkServiceImplV2", "Load docSdk failed: " + e.getMessage());
    L7:
        r101 = new SheetSdkServiceImplV2$initSdkIfNeeded$1(this, r100);
        goto L8
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final boolean c(OfficeInputParam r100) {
        Intrinsics.checkNotNullParameter(r100, "inputParam");
        ik5.a r101 = this.f369142a;
        if (r101 != null) goto L11;
        IOfficeSdkServiceV2 r102 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r102 == null) goto L9;
        r101 = r102.c0();
        if (r101 == null) goto L9;
        this.f369142a = r101;
    L9:
        r101 = null;
    L11:
        if (r101 != null) goto L14;
        FLogger.f375446a.i("SheetSdkServiceImplV2", "tryPrefetchData skipped, docSdk not ready, token=" + r100.getSlidesToken());
        return false;
    L14:
        String r103 = V(W().getSecond(), r100);
        FLogger.f375446a.i("SheetSdkServiceImplV2", "tryPrefetchData, token=" + r100.getSlidesToken());
        r101.r2(r103, "doubao");
        return true;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void initDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 == null) goto L5;
        ik5.a r102 = r101.c0();
    L6:
        this.f369142a = r102;
        FLogger.f375446a.i("SheetSdkServiceImplV2", "initDocSdk: docSdk:" + this.f369142a);
        ik5.a r103 = this.f369142a;
        if (r103 == null) goto L10;
        r103.Ka(sbb.e.f541297h, new b(r103));
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final void j(OfficeInputParam r100) {
        Intrinsics.checkNotNullParameter(r100, "inputParam");
        ik5.a r101 = this.f369142a;
        if (r101 != null) goto L6;
        FLogger.f375446a.i("SheetSdkServiceImplV2", "preloadDocumentData skipped, docSdk not ready, token=" + r100.getSlidesToken());
        return;
    L6:
        String r102 = V(W().getSecond(), r100);
        FLogger.f375446a.i("SheetSdkServiceImplV2", "preloadDocumentData, token=" + r100.getSlidesToken());
        r101.Qd(r102);
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void postInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        FLogger.f375446a.i("SheetSdkServiceImplV2", "postInitDocSdk: docSdk:" + this.f369142a);
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void preInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        FLogger.f375446a.i("SheetSdkServiceImplV2", "preInitDocSdk: docSdk:" + this.f369142a);
        r100.setHostService(z.class, new c());
        r100.setHostService(f0.class, new d());
        r100.setHostService(g0.class, new e());
        r100.setHostService(gm5.a.class, new g(this));
        r100.setHostService(e0.class, new h());
        r100.setHostService(b0.class, new i());
        r100.setHostService(w.class, new j());
    }

    public final String V(String r100, OfficeInputParam r101) {
        int r102 = r101.getResourceVersion();
        String r103 = r101.getSlidesToken();
        String r104 = r101.getEnterFrom();
        String r105 = r101.getSheet();
        Uri.Builder r106 = UriProtector.parse(r100).buildUpon().appendPath("sheets").appendPath(r103);
        if (r102 < 0) goto L6;
        r106.appendQueryParameter("version", String.valueOf(r102));
    L6:
        if ((!StringsKt.isBlank(r104)) == false) goto L9;
        r106.appendQueryParameter("from", r104);
    L9:
        if ((!StringsKt.isBlank(r105)) == false) goto L11;
        r106.appendQueryParameter(DocumentType.SHEET_NAME, r105);
    L11:
        com.larus.office.base.preview.c r107 = com.larus.office.base.preview.c.f361026a;
        String r108 = r106.build().toString();
        String r109 = r101.getSourceUrlForParams();
        r107.getClass();
        return com.larus.office.base.preview.c.j(r108, r109);
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final Object T(OfficeInputParam r110, fo9.b r111, com.larus.office.h r112, com.bytedance.ee.bear.container.f r113, Continuation r114) {
        if ((r114 instanceof SheetSdkServiceImplV2$openAndGetSheetFragment$1) == false) goto L7;
        SheetSdkServiceImplV2$openAndGetSheetFragment$1 r100 = (SheetSdkServiceImplV2$openAndGetSheetFragment$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        SheetSdkServiceImplV2 r105 = (SheetSdkServiceImplV2) r100.L$4;
        com.bytedance.ee.bear.container.f r106 = (com.bytedance.ee.bear.container.f) r100.L$3;
        com.larus.office.h r107 = (com.larus.office.h) r100.L$2;
        fo9.b r108 = (fo9.b) r100.L$1;
        OfficeInputParam r109 = (OfficeInputParam) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
    L33:
        ik5.a r115 = (ik5.a) r102;     // Catch: Exception -> L14
    L43:
        r105.f369142a = r115;     // Catch: Exception -> L14
    L49:
        com.bytedance.ee.bear.container.f r116 = r106;
    L51:
        sw9.g.f543735f = r109;
        k r117 = new k(new an9.a(r108), r107, r109);
        String r118 = V(W().getSecond(), r109);
        if (r109.getDocPreloaded() == false) goto L54;
        FLogger.f375446a.i("SheetSdkServiceImplV2", "skip preload in openAndGetSheetFragment, already preloaded upstream, token=" + r109.getSlidesToken());
    L57:
        ik5.a r119 = this.f369142a;
        if (r119 == null) goto L62;
        Fragment r120 = r119.C6(r118, Boxing.boxLong(r109.getClickTimestamp()), null, r117, r116);
        if (r120 == null) goto L62;
        return r120;
    L62:
        return new Fragment();
    L54:
        FLogger.f375446a.i("SheetSdkServiceImplV2", "preload in openAndGetSheetFragment, token=" + r109.getSlidesToken());
        ik5.a r121 = this.f369142a;
        if (r121 == null) goto L57;
        r121.Qd(r118);
    L14:
        e = e;
    L48:
        FLogger.f375446a.e("SheetSdkServiceImplV2", "Load docSdk failed: " + e.getMessage());
        goto L49
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("SheetSdkServiceImplV2", "Get slides fragment, docSdk:" + this.f369142a);
        ((Keva) this.f369143b.getValue()).storeBoolean("has_opened_fusion_doc", true);
        if (this.f369142a == null) goto L69;
        r108 = r111;
        r109 = r110;
        r107 = r112;
        r116 = r113;
        goto L51
    L69:
        X();     // Catch: Exception -> L45
        IOfficeSdkServiceV2 r122 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L45
        OfficeInputParam r123 = r110;
        if (r122 != null) goto L71;
        r108 = r111;
        r115 = null;
        r105 = this;
        r109 = r123;
        r107 = r112;
        r106 = r113;
        goto L43
    L71:
        r100.L$0 = r123;     // Catch: Exception -> L40
        r108 = r111;
        r100.L$1 = r108;     // Catch: Exception -> L38
        com.larus.office.h r124 = r112;
        r100.L$2 = r124;     // Catch: Exception -> L36
        com.bytedance.ee.bear.container.f r125 = r113;
        r100.L$3 = r125;     // Catch: Exception -> L34
        r100.L$4 = this;     // Catch: Exception -> L34
        r100.label = 1;     // Catch: Exception -> L34
        r102 = r122.o0(15000, r100);     // Catch: Exception -> L34
        if (r102 != r103) goto L32;
        return r103;
    L32:
        r105 = this;
        r109 = r123;
        r107 = r124;
        r106 = r125;
    L34:
        e = e;
    L47:
        r109 = r123;
        r107 = r124;
        r106 = r125;
    L36:
        e = e;
    L37:
        r125 = r113;
    L38:
        e = e;
    L39:
        r124 = r112;
    L40:
        e = e;
    L41:
        r108 = r111;
    L45:
        e = e;
        r123 = r110;
    L7:
        r100 = new SheetSdkServiceImplV2$openAndGetSheetFragment$1(this, r114);
        goto L8
    }

    @Override // com.larus.sheet.sdk.api.ISheetSdkServiceV2
    public final void n(Context r110, String r111, String r112, String r113, String r114, com.larus.sheet.operation.download.b r115) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "fileName");
        Intrinsics.checkNotNullParameter(r112, "fileType");
        Intrinsics.checkNotNullParameter(r115, "callback");
        ik5.a r100 = this.f369142a;
        if (r100 == null) goto L5;
        j15.a r101 = r100.R4(r110, r111);
    L6:
        if (r101 != null) goto L9;
        r115.invoke(Boolean.FALSE, null, null, null, "export executor is null");
        return;
    L9:
        String r116 = r112.toLowerCase(Locale.ROOT);
        switch(r116.hashCode()) {
            case 110834: goto L29;
            case 115312: goto L25;
            case 3088960: goto L21;
            case 3447940: goto L17;
            case 96948919: goto L13;
            default: goto L33;
        };
    L33:
        rw4.n r102 = null;
    L34:
        if (r102 != null) goto L37;
        r115.invoke(Boolean.FALSE, null, null, null, "unsupported fileType: ".concat(r112));
        return;
    L37:
        if (r114 != null) goto L39;
    L41:
        String r103 = null;
    L42:
        if (r103 != null) goto L45;
        r115.invoke(Boolean.FALSE, null, null, null, "token is empty");
        return;
    L45:
        r101.a(r102, r113, r103, "41", null, new l(r115));
        return;
    L39:
        if ((!StringsKt.isBlank(r114)) == false) goto L41;
        r103 = r114;
        goto L42
    L13:
        if (r116.equals("excel") == false) goto L47;
        rw4.n r117 = rw4.n.f539705g;
    L32:
        r102 = r117;
        goto L34
    L47:
        r102 = null;
        goto L34
    L17:
        if (r116.equals(ExportFileExtension.PPTX) == false) goto L48;
        r117 = rw4.n.f539706h;
        goto L32
    L48:
        r102 = null;
        goto L34
    L21:
        if (r116.equals(DocumentType.DOCX_NAME) == false) goto L49;
        r117 = rw4.n.f539701c;
        goto L32
    L49:
        r102 = null;
        goto L34
    L25:
        if (r116.equals("txt") == false) goto L50;
        r117 = rw4.n.f539707i;
        goto L32
    L50:
        r102 = null;
        goto L34
    L29:
        if (r116.equals(ExportFileExtension.PDF) == false) goto L51;
        r117 = rw4.n.f539702d;
        goto L32
    L51:
        r102 = null;
        goto L34
    L5:
        r101 = null;
        goto L6
    }
}
