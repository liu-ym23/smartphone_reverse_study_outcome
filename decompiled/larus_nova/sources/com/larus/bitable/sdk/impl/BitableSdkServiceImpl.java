package com.larus.bitable.sdk.impl;

import android.net.Uri;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.document.SubStrategyType;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.document.w4;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bitable.sdk.api.IBitableSdkService;
import com.larus.office.IOfficeSdkService;
import com.larus.office.OfficeBitableScene;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.h;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ew4.a0;
import ew4.c0;
import ew4.x;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import pa8.g;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 42\u00020\u0001:\u000545678B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J<\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\bH\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020$H\u0016J\u000e\u0010)\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010*J\f\u0010-\u001a\u00020\f*\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u00103\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/bitable/sdk/impl/BitableSdkServiceImpl;", "Lcom/larus/bitable/sdk/api/IBitableSdkService;", "<init>", "()V", "docSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "bitableStrategiesRegisteredSdk", "lifecycleOrder", "", "lifecycleCategory", "", "preInitDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "destroyDocSdk", "createBaseMainAIChatVisibilityAbilities", "", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "hostAbilityProvider", "Lcom/larus/office/OfficeHostAbilityProvider;", "openAndGetBitableFragment", "Landroidx/fragment/app/Fragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "inputParam", "Lcom/larus/office/OfficeInputParam;", "listener", "Lcom/larus/office/permission/IOfficePermissionListener;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "(Landroid/content/Context;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/larus/office/OfficeHostAbilityProvider;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadDocumentData", "tryPrefetchData", "", "notifyBottomPanelHeightChanged", "height", "notifyAIChatListFoldStatusChanged", "isFold", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectUserHostAbility", "ensureDocsSdk", "registerBitableOpenStrategiesIfNeeded", "createBitableOfficePlugins", "Lcom/bytedance/ee/bear/browser/plugin/PluginList;", "scene", "Lcom/larus/office/OfficeBitableScene;", "buildTargetUrl", "buildFallbackTargetUrl", "Companion", "BaseAddOpenStrategy", "BaseRecordOpenStrategy", "BaseAppOpenStrategy", "BaseMainOpenStrategy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSdkServiceImpl implements IBitableSdkService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f294868c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ik5.a f294869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ik5.a f294870b;

    public final class a extends kk5.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableSdkServiceImpl f294871c;

        @Override // com.bytedance.ee.bear.document.v4
        public final n getBizPluginList(ChameleonPluginHost r100) {
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            return n.c(this.f503795a.getBizPluginList(r100), BitableSdkServiceImpl.V(this.f294871c, OfficeBitableScene.BASE_ADD));
        }

        public a(BitableSdkServiceImpl r100, ik5.a r101) {
            Intrinsics.checkNotNullParameter(r101, "docSdk");
            this.f294871c = r100;
            super(r101);
        }
    }

    public final class b extends kk5.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableSdkServiceImpl f294872c;

        @Override // com.bytedance.ee.bear.document.v4
        public final n getBizPluginList(ChameleonPluginHost r100) {
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            return n.c(this.f503797a.getBizPluginList(r100), BitableSdkServiceImpl.V(this.f294872c, OfficeBitableScene.BASE_APP));
        }

        public b(BitableSdkServiceImpl r100, ik5.a r101) {
            Intrinsics.checkNotNullParameter(r101, "docSdk");
            this.f294872c = r100;
            super(r101);
        }
    }

    public final class c extends kk5.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableSdkServiceImpl f294873c;

        @Override // com.bytedance.ee.bear.document.v4
        public final n getBizPluginList(ChameleonPluginHost r100) {
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            return n.c(this.f503799a.getBizPluginList(r100), BitableSdkServiceImpl.V(this.f294873c, OfficeBitableScene.BASE_MAIN));
        }

        public c(BitableSdkServiceImpl r100, ik5.a r101) {
            Intrinsics.checkNotNullParameter(r101, "docSdk");
            this.f294873c = r100;
            super(r101);
        }
    }

    public final class d extends kk5.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableSdkServiceImpl f294874c;

        @Override // com.bytedance.ee.bear.document.v4
        public final n getBizPluginList(ChameleonPluginHost r100) {
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            return n.c(this.f503801a.getBizPluginList(r100), BitableSdkServiceImpl.V(this.f294874c, OfficeBitableScene.BASE_RECORD));
        }

        public d(BitableSdkServiceImpl r100, ik5.a r101) {
            Intrinsics.checkNotNullParameter(r101, "docSdk");
            this.f294874c = r100;
            super(r101);
        }
    }

    public static final class e {
    }

    public static final class f implements x {
        public f() {
        }

        @Override // ew4.x
        public final int s() {
            int r100 = qa8.a.f532277a;
            return qa8.a.f532277a;
        }

        @Override // ew4.x
        public final void g1(ew4.a r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            int r101 = qa8.a.f532277a;
            Intrinsics.checkNotNullParameter(r100, "listener");
            qa8.a.f532279c.remove(r100);
        }

        @Override // ew4.x
        public final void j(ew4.a r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            int r101 = qa8.a.f532277a;
            Intrinsics.checkNotNullParameter(r100, "listener");
            qa8.a.f532279c.addIfAbsent(r100);
            r100.a(qa8.a.f532277a);
            r100.b(qa8.a.f532278b);
        }
    }

    static {
    }

    public BitableSdkServiceImpl() {
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final String lifecycleCategory() {
        return DocumentType.BITABLE_NAME;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final int lifecycleOrder() {
        return 2;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void destroyDocSdk() {
        FLogger.f375446a.i("BitableSdkServiceImpl", "destroyDocSdk");
        this.f294869a = null;
        this.f294870b = null;
        int r100 = qa8.a.f532277a;
        qa8.a.f532277a = 0;
        qa8.a.f532278b = true;
        qa8.a.f532279c.clear();
    }

    public static String W(OfficeInputParam r100) {
        String r101 = r100.getSourceUrlForParams();
        boolean r102 = true;
        if (r101 != null) goto L5;
    L20:
        String r103 = r100.getSlidesToken();
        if (StringsKt.isBlank(r103) == false) goto L23;
        r103 = r100.getResourceId();
    L23:
        Uri.Builder r104 = UriProtector.parse("https://feishu.doubao.com").buildUpon().appendPath("base").appendPath(r103);
        if ((!StringsKt.isBlank(r100.getEnterMethod())) == false) goto L27;
        r104.appendQueryParameter("from", r100.getEnterMethod());
    L30:
        return r104.build().toString();
    L27:
        if ((true ^ StringsKt.isBlank(r100.getEnterFrom())) == false) goto L30;
        r104.appendQueryParameter("from", r100.getEnterFrom());
        goto L30
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L20;
        Lazy r105 = com.larus.office.base.utils.n.f361174a;
        Intrinsics.checkNotNullParameter(r101, "sourceUrl");
        Intrinsics.checkNotNullParameter("feishu.doubao.com", "targetHost");
        Uri r106 = UriProtector.parse(r101);
        com.larus.office.base.utils.n.a r107 = com.larus.office.base.utils.n.m(r106.getPathSegments());
        Uri.Builder r108 = r106.buildUpon().authority("feishu.doubao.com");
        if (r107 != null) goto L13;
    L15:
        r102 = false;
    L16:
        if (r102 == false) goto L19;
        r108.path("/share/base/" + r107.f361175a + '/' + r107.f361176b);
    L19:
        return r108.build().toString();
    L13:
        if (r107.f361177c != true) goto L15;
        goto L15
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final List<i> D(h r100) {
        Intrinsics.checkNotNullParameter(r100, "hostAbilityProvider");
        return CollectionsKt.listOf(new oa8.a(r100));
    }

    public final Object X(Continuation<? super ik5.a> r100) {
        if ((r100 instanceof BitableSdkServiceImpl$ensureDocsSdk$1) == false) goto L7;
        BitableSdkServiceImpl$ensureDocsSdk$1 r101 = (BitableSdkServiceImpl$ensureDocsSdk$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L27
    L23:
        ik5.a r106 = (ik5.a) r103;     // Catch: Throwable -> L27
    L25:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L27
    L29:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L33;
        FLogger.f375446a.e("BitableSdkServiceImpl", "ensureDocsSdk failed", r108);
    L33:
        if (Result.m9455isFailureimpl(r107) == false) goto L35;
        r107 = null;
    L35:
        ik5.a r109 = (ik5.a) r107;
        if (r109 == null) goto L41;
        this.f294869a = r109;
        Y(r109);
        return r109;
    L41:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        ik5.a r110 = this.f294869a;
        if (r110 == null) goto L18;
        return r110;
    L18:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L27
        IOfficeSdkServiceV2 r112 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Throwable -> L27
        if (r112 == null) goto L24;
        IOfficeSdkServiceV2.a.b(r112, true, DocumentType.BITABLE_NAME, 4);     // Catch: Throwable -> L27
        r101.label = 1;     // Catch: Throwable -> L27
        r103 = r112.o0(15000, r101);     // Catch: Throwable -> L27
        if (r103 != r104) goto L23;
        return r104;
    L24:
        r106 = null;
    L27:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new BitableSdkServiceImpl$ensureDocsSdk$1(this, r100);
        goto L8
    }

    public final void Y(ik5.a r100) {
        if (this.f294870b != r100) goto L6;
        FLogger.f375446a.i("BitableSdkServiceImpl", "registerBitableOpenStrategies skipped, already registered");
        return;
    L6:
        v4 r101 = r100.a5(sbb.e.f541298i);
        if ((r101 instanceof w4) == false) goto L9;
        w4 r102 = (w4) r101;
    L10:
        if (r102 != null) goto L13;
        FLogger.f375446a.e("BitableSdkServiceImpl", "registerBitableOpenStrategies failed, BITABLE strategy is not router strategy");
        return;
    L13:
        r102.b(SubStrategyType.BaseAdd, new a(this, r100));
        r102.b(SubStrategyType.BaseRecord, new d(this, r100));
        r102.b(SubStrategyType.BaseApp, new b(this, r100));
        r102.b(SubStrategyType.BaseMain, new c(this, r100));
        r100.Ka(sbb.e.f541299j, new a(this, r100));
        this.f294870b = r100;
        FLogger.f375446a.i("BitableSdkServiceImpl", "registerBitableOpenStrategies success");
        return;
    L9:
        r102 = null;
        goto L10
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final Object a(Continuation<? super Unit> r100) {
        Object r101 = X(r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final boolean c(OfficeInputParam r100) {
        Intrinsics.checkNotNullParameter(r100, "inputParam");
        ik5.a r101 = this.f294869a;
        if (r101 != null) goto L11;
        IOfficeSdkServiceV2 r102 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r102 == null) goto L9;
        r101 = r102.c0();
        if (r101 == null) goto L9;
        this.f294869a = r101;
        Y(r101);
    L9:
        r101 = null;
    L11:
        if (r101 != null) goto L14;
        FLogger.f375446a.i("BitableSdkServiceImpl", "tryPrefetchData skipped, docSdk not ready, token=" + r100.getSlidesToken());
        return false;
    L14:
        String r103 = W(r100);
        FLogger.f375446a.i("BitableSdkServiceImpl", "tryPrefetchData, token=" + r100.getSlidesToken());
        r101.r2(r103, "doubao");
        return true;
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final void d(boolean r100) {
        int r101 = qa8.a.f532277a;
        if (qa8.a.f532278b == r100) goto L9;
        qa8.a.f532278b = r100;
        Iterator<ew4.a> r102 = qa8.a.f532279c.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        r102.next().b(r100);
        goto L7
    L11:
        return;
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final void i(int r100) {
        int r101 = qa8.a.f532277a;
        int r102 = RangesKt.coerceAtLeast(r100, 0);
        if (qa8.a.f532277a == r102) goto L9;
        qa8.a.f532277a = r102;
        Iterator<ew4.a> r103 = qa8.a.f532279c.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        r103.next().a(r102);
        goto L7
    L11:
        return;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void initDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 == null) goto L5;
        ik5.a r102 = r101.c0();
    L6:
        this.f294869a = r102;
        FLogger.f375446a.i("BitableSdkServiceImpl", "initDocSdk: docSdk=" + this.f294869a);
        ik5.a r103 = this.f294869a;
        if (r103 == null) goto L10;
        Y(r103);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void postInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        FLogger.f375446a.i("BitableSdkServiceImpl", "postInitDocSdk");
        r100.setHostService(x.class, new f());
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void preInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        FLogger.f375446a.i("BitableSdkServiceImpl", "preInitDocSdk");
        r100.setHostService(c0.class, new pa8.n());
        r100.setHostService(a0.class, new g());
    }

    public static final n V(BitableSdkServiceImpl r100, OfficeBitableScene r101) {
        r100.getClass();
        IOfficeSdkService r102 = (IOfficeSdkService) ServiceManager.get().getService(IOfficeSdkService.class);
        if (r102 == null) goto L7;
        n r103 = r102.d("base", r101);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return new n(new n.a[0]);
    }

    @Override // com.larus.bitable.sdk.api.IBitableSdkService
    public final Object v(OfficeInputParam r110, fo9.a r111, h r112, com.larus.office.container.impl.applet.i r113, Continuation r210) {
        if ((r210 instanceof BitableSdkServiceImpl$openAndGetBitableFragment$1) == false) goto L7;
        BitableSdkServiceImpl$openAndGetBitableFragment$1 r100 = (BitableSdkServiceImpl$openAndGetBitableFragment$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        com.bytedance.ee.bear.container.f r105 = (com.bytedance.ee.bear.container.f) r100.L$3;
        h r106 = (h) r100.L$2;
        fo9.b r107 = (fo9.b) r100.L$1;
        OfficeInputParam r108 = (OfficeInputParam) r100.L$0;
        ResultKt.throwOnFailure(r102);
        com.bytedance.ee.bear.container.f r114 = r105;
        h r109 = r106;
        fo9.b r115 = r107;
        Object r116 = r102;
        OfficeInputParam r117 = r108;
    L18:
        ik5.a r118 = (ik5.a) r116;
        if (r118 == null) goto L26;
        com.larus.bitable.sdk.impl.a r119 = new com.larus.bitable.sdk.impl.a(r115, r109, r117, this);
        String r120 = W(r117);
        if (r117.getDocPreloaded() == false) goto L23;
        FLogger.f375446a.i("BitableSdkServiceImpl", "skip preload in openAndGetBitableFragment, already preloaded upstream");
    L25:
        return r118.C6(r120, Boxing.boxLong(r117.getClickTimestamp()), null, r119, r114);
    L23:
        r118.Qd(r120);
        goto L25
    L26:
        FLogger.f375446a.e("BitableSdkServiceImpl", "openAndGetBitableFragment failed, docSdk is null");
        throw new IllegalStateException("Bitable docSdk is null");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("BitableSdkServiceImpl", "openAndGetBitableFragment, token=" + r110.getSlidesToken() + ", docSdk=" + this.f294869a);
        r117 = r110;
        r100.L$0 = r117;
        r115 = r111;
        r100.L$1 = r115;
        r109 = r112;
        r100.L$2 = r109;
        r100.L$3 = r113;
        r100.label = 1;
        r116 = X(r100);
        if (r116 != r103) goto L17;
        return r103;
    L17:
        r114 = r113;
    L7:
        r100 = new BitableSdkServiceImpl$openAndGetBitableFragment$1(this, r210);
        goto L8
    }
}
