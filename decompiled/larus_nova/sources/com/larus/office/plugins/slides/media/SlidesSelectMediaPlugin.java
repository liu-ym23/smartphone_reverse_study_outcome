package com.larus.office.plugins.slides.media;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.home.impl.sdk.x1;
import com.larus.office.util.ChameleonImageUtils;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g3;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.c0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0002/0B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J \u0010\u001e\u001a\u00020\u00192\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"0 H\u0016J\u0012\u0010#\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010!H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\n\u0010*\u001a\u0004\u0018\u00010!H\u0002J\b\u0010+\u001a\u00020\u0019H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020.H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0016¨\u00061"}, d2 = {"Lcom/larus/office/plugins/slides/media/SlidesSelectMediaPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/office/plugins/slides/media/SlidesPhotoInsertFragment$SelectMediaListener;", "<init>", "()V", "editPanelManager", "Lcom/bytedance/ee/bear/document/toolbar/editpanels/IEditPanelsManager;", "editPanel", "Lcom/larus/office/plugins/slides/media/SlidesSelectMediaDelegate;", "getEditPanel", "()Lcom/larus/office/plugins/slides/media/SlidesSelectMediaDelegate;", "editPanel$delegate", "Lkotlin/Lazy;", "pluginHost", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "curSelectLocalImage", "Lcom/larus/office/plugins/slides/media/SelectLocalImage;", "photoInsertFragment", "Lcom/larus/office/plugins/slides/media/SlidesPhotoInsertFragment;", "repo", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "getRepo", "()Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "repo$delegate", "onAttachToUIContainer", "", "host", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "setupSelectLocalImageCallback", "selectLocalImage", "onSelectLocalImage", "thumbType", "Lcom/larus/office/plugins/slides/media/ThumbType;", "clickFrom", "onHideBottomPage", "getImageCacheRootDir", "showPhotoPickerFragment", "addPhotoInsertFragment", "hidePhotoPickerFragment", "", "Companion", "SelectMediaHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesSelectMediaPlugin extends OfficeDocumentPlugin implements SlidesPhotoInsertFragment.b {
    private static final String BIZ_SLIDES_SELECT_MEDIA = "biz.util.slidesSelectMedia";
    public static final a Companion = null;
    private static final long MAX_FILE_SIZE_BYTES = 20971520;
    private static final String PHOTO_INSERT_TAG = "slides_photo_insert_fragment";
    private static final String TAG = "SlidesSelectMediaPlugin";
    private com.larus.office.plugins.slides.media.a curSelectLocalImage;
    private final Lazy editPanel$delegate;
    private g45.d editPanelManager;
    private SlidesPhotoInsertFragment photoInsertFragment;
    private ChameleonPluginHost pluginHost;
    private final Lazy repo$delegate;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<SelectedImageModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlidesSelectMediaPlugin f363266a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SlidesSelectMediaPlugin r100) {
            this.f363266a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            final SelectedImageModel r102 = (SelectedImageModel) r100;
            FLogger.f375446a.i(SlidesSelectMediaPlugin.TAG, "call select media:" + GsonProtectorUtils.toJson(new Gson(), r102));
            final ChameleonPluginHost r103 = SlidesSelectMediaPlugin.access$getPluginHost$p(this.f363266a);
            SlidesSelectMediaPlugin.access$getEditPanel(this.f363266a).f363413a.setValue(Boolean.TRUE);
            g45.d r104 = SlidesSelectMediaPlugin.access$getEditPanelManager$p(this.f363266a);
            if (r104 == null) goto L5;
            r104.requestUpdateWebContentHeight();
        L5:
            if (r103 == null) goto L12;
            com.bytedance.ee.bear.browser.plugin.t r105 = r103.getUIContainer();
            if (r105 == null) goto L13;
            View r106 = r105.getContentView();
            if (r106 == null) goto L14;
            final SlidesSelectMediaPlugin r107 = this.f363266a;
            r106.postDelayed(new v(r107, r102, r103), 250);
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.office.plugins.slides.media.SlidesSelectMediaPlugin$onSelectLocalImage$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.office.plugins.slides.media.SlidesSelectMediaPlugin$onSelectLocalImage$5", f = "SlidesSelectMediaPlugin.kt", i = {}, l = {168, 185}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $clickFrom;
        final /* synthetic */ ThumbType $thumbType;
        int label;
        final /* synthetic */ SlidesSelectMediaPlugin this$0;

        /* JADX INFO: renamed from: com.larus.office.plugins.slides.media.SlidesSelectMediaPlugin$onSelectLocalImage$5$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.office.plugins.slides.media.SlidesSelectMediaPlugin$onSelectLocalImage$5$3", f = "SlidesSelectMediaPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SlidesSelectMediaPlugin this$0;

            public AnonymousClass3(SlidesSelectMediaPlugin r100, Continuation<? super AnonymousClass3> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass3(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r100);
                SlidesSelectMediaPlugin.access$hidePhotoPickerFragment(this.this$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass5(ThumbType r100, SlidesSelectMediaPlugin r101, String r102, Continuation<? super AnonymousClass5> r103) {
            this.$thumbType = r100;
            this.this$0 = r101;
            this.$clickFrom = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass5(this.$thumbType, this.this$0, this.$clickFrom, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass5) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r110);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r110);
        L13:
            MainCoroutineDispatcher r111 = Dispatchers.getMain();
            AnonymousClass3 r102 = new AnonymousClass3(this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r111, r102, this) != r100) goto L17;
            return r100;
        L10:
            ResultKt.throwOnFailure(r110);
            ChameleonImageUtils r112 = ChameleonImageUtils.f363623a;
            ThumbType r103 = this.$thumbType;
            Long r104 = Boxing.boxLong(SlidesSelectMediaPlugin.MAX_FILE_SIZE_BYTES);
            final SlidesSelectMediaPlugin r105 = this.this$0;
            Function0 r106 = new y(r105);
            final String r107 = this.$clickFrom;
            Function1 r108 = new z(r105, r107);
            this.label = 1;
            r112.getClass();
            if (ChameleonImageUtils.b(r103, r104, r106, r108, this) != r100) goto L13;
            return r100;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit a(SlidesSelectMediaPlugin r100, boolean r101) {
        return showPhotoPickerFragment$lambda$6(r100, r101);
    }

    public static /* synthetic */ r c() {
        return editPanel_delegate$lambda$0();
    }

    public static /* synthetic */ ISettingRepoService d() {
        return repo_delegate$lambda$1();
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private static final r editPanel_delegate$lambda$0() {
        return new r();
    }

    private final r getEditPanel() {
        return (r) this.editPanel$delegate.getValue();
    }

    private final String getImageCacheRootDir() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L5;
        r100.D();
        return x1.f346268a.e();
    L5:
        return null;
    }

    private final ISettingRepoService getRepo() {
        return (ISettingRepoService) this.repo$delegate.getValue();
    }

    private static final ISettingRepoService repo_delegate$lambda$1() {
        return RepoDispatcherDelegate.f307737b.c();
    }

    public SlidesSelectMediaPlugin() {
        this.editPanel$delegate = LazyKt.lazy(new s());
        this.repo$delegate = LazyKt.lazy(new t());
    }

    private final void addPhotoInsertFragment() {
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L5;
        return;
    L5:
        Fragment r101 = r100.getSupportFragmentManager().findFragmentByTag(PHOTO_INSERT_TAG);
        if (r101 != null) goto L8;
    L9:
        SlidesPhotoInsertFragment.b r102 = SlidesPhotoInsertFragment.f363258j;
        Bundle r103 = r100.getIntent().getExtras();
        SlidesPhotoInsertFragment.f363258j = this;
        SlidesPhotoInsertFragment r104 = new SlidesPhotoInsertFragment();
        r104.setArguments(r103);
        this.photoInsertFragment = r104;
        com.larus.office.h r105 = (com.larus.office.h) getHost().getHostAbility(com.larus.office.h.class);
        if (r105 == null) goto L16;
        int r106 = r105.Ve();
        SlidesPhotoInsertFragment r107 = this.photoInsertFragment;
        if (r107 == null) goto L17;
        INVOKEVIRTUAL_com_larus_office_plugins_slides_media_SlidesSelectMediaPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r100.getSupportFragmentManager().beginTransaction(), r106, r107, PHOTO_INSERT_TAG).commitAllowingStateLoss();
        return;
    L17:
        return;
    L16:
        return;
    L8:
        if (r101.isAdded() == false) goto L9;
    }

    private final boolean hidePhotoPickerFragment() {
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isFinishing() == false) goto L8;
    L34:
        this.photoInsertFragment = null;
        return false;
    L8:
        if (r100.isDestroyed() == true) goto L34;
        FragmentManager r101 = r100.getSupportFragmentManager();
        SlidesPhotoInsertFragment r102 = this.photoInsertFragment;
        if (r102 != null) goto L16;
        Fragment r103 = r101.findFragmentByTag(PHOTO_INSERT_TAG);
        if ((r103 instanceof SlidesPhotoInsertFragment) == false) goto L15;
        r102 = (SlidesPhotoInsertFragment) r103;
        goto L16
    L15:
        r102 = null;
    L16:
        if (r102 != null) goto L18;
    L33:
        return false;
    L18:
        if (r102.isAdded() == false) goto L33;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L21
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(r101.beginTransaction().remove(r102).commitAllowingStateLoss()));     // Catch: Throwable -> L21
    L23:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L26;
        FLogger.f375446a.e(TAG, "hidePhotoPickerFragment remove fail", r106);
    L26:
        this.photoInsertFragment = null;
        com.larus.office.plugins.slides.media.a r107 = this.curSelectLocalImage;
        if (r107 == null) goto L38;
        Function0<Unit> r108 = r107.f363271d;
        if (r108 == null) goto L39;
        r108.invoke();
        return true;
    L39:
        return true;
    L38:
        return true;
    L21:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    private final void showPhotoPickerFragment() {
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L6;
        return;
    L6:
        if (getRepo().k0() == true) goto L8;
        getRepo().F();
        k2 r101 = k2.f365755a;
        g3.a.a(null, r100, false, null, false, new u(this), 29);
        return;
    L8:
        addPhotoInsertFragment();
    }

    @Override // com.larus.office.plugins.slides.media.SlidesPhotoInsertFragment.b
    public void onHideBottomPage() {
        hidePhotoPickerFragment();
    }

    public static final /* synthetic */ com.larus.office.plugins.slides.media.a access$getCurSelectLocalImage$p(SlidesSelectMediaPlugin r100) {
        return r100.curSelectLocalImage;
    }

    public static final /* synthetic */ r access$getEditPanel(SlidesSelectMediaPlugin r100) {
        return r100.getEditPanel();
    }

    public static final /* synthetic */ g45.d access$getEditPanelManager$p(SlidesSelectMediaPlugin r100) {
        return r100.editPanelManager;
    }

    public static final /* synthetic */ String access$getImageCacheRootDir(SlidesSelectMediaPlugin r100) {
        return r100.getImageCacheRootDir();
    }

    public static final /* synthetic */ ChameleonPluginHost access$getPluginHost$p(SlidesSelectMediaPlugin r100) {
        return r100.pluginHost;
    }

    public static final /* synthetic */ boolean access$hidePhotoPickerFragment(SlidesSelectMediaPlugin r100) {
        return r100.hidePhotoPickerFragment();
    }

    private final void setupSelectLocalImageCallback(com.larus.office.plugins.slides.media.a r310) {
        this.curSelectLocalImage = r310;
        showPhotoPickerFragment();
        FragmentActivity r100 = getActivity();     // Catch: Exception -> L42
        Integer r101 = null;
        if (r100 == null) goto L7;
        Intent r102 = r100.getIntent();     // Catch: Exception -> L42
    L9:
        if (r102 == null) goto L14;
        String r103 = r102.getStringExtra("presentation_id");     // Catch: Exception -> L42
        if (r103 == null) goto L14;
        String r110 = r103;
    L15:
        if (r102 == null) goto L20;
        String r104 = r102.getStringExtra("resource_id");     // Catch: Exception -> L42
        if (r104 == null) goto L20;
        String r210 = r104;
    L22:
        if (r102 == null) goto L24;
        Integer r211 = Integer.valueOf(r102.getIntExtra("resource_type", -1));     // Catch: Exception -> L42
    L25:
        if (r102 == null) goto L30;
        String r105 = r102.getStringExtra("artifact_meta_id");     // Catch: Exception -> L42
        if (r105 == null) goto L30;
        String r212 = r105;
    L31:
        if (r102 == null) goto L33;
        r101 = Integer.valueOf(r102.getIntExtra("artifact_type", -1));     // Catch: Exception -> L42
    L33:
        Integer r213 = r101;
        if (r102 == null) goto L39;
        String r106 = r102.getStringExtra("aippt_task_id");     // Catch: Exception -> L42
        if (r106 == null) goto L39;
        String r214 = r106;
    L40:
        c0.H(null, "aippt_tool_bar", null, null, null, "aippt_new_detail", null, null, null, null, null, null, null, 0, r110, r210, r211, r212, r213, r214, "aippt_new", null, null, 31473629);     // Catch: Exception -> L42
        return;
    L39:
        r214 = "";
    L30:
        r212 = "";
        goto L31
    L24:
        r211 = null;
    L20:
        r210 = "";
    L14:
        r110 = "";
        goto L15
    L7:
        r102 = null;
    L42:
        e = move-exception;
        FLogger.f375446a.e(TAG, "call mobClickUploadEntrance error", e);
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put(BIZ_SLIDES_SELECT_MEDIA, new b(this));
    }

    public static final /* synthetic */ void access$setupSelectLocalImageCallback(SlidesSelectMediaPlugin r100, com.larus.office.plugins.slides.media.a r101) {
        r100.setupSelectLocalImageCallback(r101);
    }

    private static final Unit onSelectLocalImage$lambda$3(ThumbType r100, SlidesSelectMediaPlugin r101) {
        com.larus.office.plugins.slides.media.a r102 = r101.curSelectLocalImage;
        if (r102 == null) goto L9;
        SelectedImageModel r103 = r102.f363268a;
        if (r103 == null) goto L9;
        Float r104 = r103.getWidth();
        if (r104 == null) goto L9;
        int r105 = (int) r104.floatValue();
    L10:
        r100.setWidth(Integer.valueOf(r105));
        return Unit.INSTANCE;
    L9:
        r105 = 0;
        goto L10
    }

    private static final Unit onSelectLocalImage$lambda$5(ThumbType r100, SlidesSelectMediaPlugin r101) {
        com.larus.office.plugins.slides.media.a r102 = r101.curSelectLocalImage;
        if (r102 == null) goto L9;
        SelectedImageModel r103 = r102.f363268a;
        if (r103 == null) goto L9;
        Float r104 = r103.getHeight();
        if (r104 == null) goto L9;
        int r105 = (int) r104.floatValue();
    L10:
        r100.setHeight(Integer.valueOf(r105));
        return Unit.INSTANCE;
    L9:
        r105 = 0;
        goto L10
    }

    private static final Unit showPhotoPickerFragment$lambda$6(SlidesSelectMediaPlugin r100, boolean r101) {
        if (r101 == false) goto L5;
        r100.addPhotoInsertFragment();
    L5:
        return Unit.INSTANCE;
    }

    public void onAttachToUIContainer(ChameleonPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onAttachToUIContainer(r100, r101);
        this.pluginHost = r100;
        if (r100 == null) goto L5;
        g45.d r102 = (g45.d) r100.getHostAbility(g45.d.class);
    L6:
        this.editPanelManager = r102;
        if (r102 == null) goto L10;
        r102.registerEditPanel(getLifecycleOwner(), getEditPanel());
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onDetachFromUIContainer(r100, r101);
        this.editPanelManager = null;
        this.pluginHost = null;
        hidePhotoPickerFragment();
    }

    @Override // com.larus.office.plugins.slides.media.SlidesPhotoInsertFragment.b
    public void onSelectLocalImage(ThumbType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "thumbType");
        Integer r102 = r100.getWidth();
        int r103 = 0;
        if (r102 != null) goto L5;
    L16:
        Integer r104 = r100.getHeight();
        if (r104 != null) goto L19;
    L29:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass5(r100, this, r101, null), 3, null);
        return;
    L19:
        if (r104.intValue() > 0) goto L28;
        com.larus.office.plugins.slides.media.a r105 = this.curSelectLocalImage;
        if (r105 == null) goto L27;
        SelectedImageModel r106 = r105.f363268a;
        if (r106 == null) goto L27;
        Float r107 = r106.getHeight();
        if (r107 == null) goto L27;
        r103 = Integer.valueOf((int) r107.floatValue());
    L27:
        r100.setHeight(r103);
    L28:
        r104.intValue();
        goto L29
    L5:
        if (r102.intValue() > 0) goto L15;
        com.larus.office.plugins.slides.media.a r108 = this.curSelectLocalImage;
        if (r108 == null) goto L13;
        SelectedImageModel r109 = r108.f363268a;
        if (r109 == null) goto L13;
        Float r110 = r109.getWidth();
        if (r110 == null) goto L13;
        Integer r111 = Integer.valueOf((int) r110.floatValue());
    L14:
        r100.setWidth(r111);
    L13:
        r111 = 0;
    L15:
        r102.intValue();
        goto L16
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onDetachFromUIContainer((ChameleonPluginHost) r100, r101);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_office_plugins_slides_media_SlidesSelectMediaPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, int r101, Fragment r102, String r103) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r103, r101) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102, r103);
    }
}
