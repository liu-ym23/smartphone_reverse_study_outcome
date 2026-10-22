package com.larus.office.plugins.slides.media.imggen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.minor.model.MinorConfigItems;
import com.larus.office.plugins.slides.media.SelectedImageModel;
import com.larus.office.plugins.slides.media.ThumbType;
import com.larus.office.util.ChameleonImageUtils;
import com.larus.platform.api.creation.Resource;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0013H\u0016J\u001c\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0002J$\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\"\u0010\"\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J*\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00110+H\u0082@¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\u0014*\u0004\u0018\u00010\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/office/plugins/slides/media/imggen/AIGenerateImagePlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "editPanelManager", "Lcom/bytedance/ee/bear/document/toolbar/editpanels/IEditPanelsManager;", "editPanel", "Lcom/larus/office/plugins/slides/media/imggen/AIGenerateImageDelegate;", "getEditPanel", "()Lcom/larus/office/plugins/slides/media/imggen/AIGenerateImageDelegate;", "editPanel$delegate", "Lkotlin/Lazy;", "curAIGenerateImage", "Lcom/larus/office/plugins/slides/media/imggen/AIGenerateImage;", "pluginHost", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToUIContainer", "host", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "setupAIGenerateImageCallback", "activity", "Landroid/app/Activity;", "aiGenerateImage", "showAIGenerateImagePage", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "handleActivityResult", "resultCode", "", "data", "Landroid/content/Intent;", "copyToChameleonDir", "thumbType", "Lcom/larus/office/plugins/slides/media/ThumbType;", "onFinalImageProcess", "Lkotlin/Function1;", "(Lcom/larus/office/plugins/slides/media/ThumbType;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeLogId", "Companion", "AIGenerateImageHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIGenerateImagePlugin extends OfficeDocumentPlugin {
    private static final int AI_GENERATE_MAX_SELECT_IMAGE_COUNT = 6;
    private static final String BIZ_AI_GENERATE_IMAGE = "biz.util.AIGenerateImage";
    public static final b Companion = null;
    private static final String DEBUG_TAG = "OfficePluginDebug";
    private static final long MAX_FILE_SIZE_BYTES = 20971520;
    private static final String TAG = "AIGenerateImagePluginV2";
    private com.larus.office.plugins.slides.media.imggen.a curAIGenerateImage;
    private final Lazy editPanel$delegate;
    private g45.d editPanelManager;
    private ChameleonPluginHost pluginHost;

    public final class a implements tb5.i<SelectedImageModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AIGenerateImagePlugin f363282a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(AIGenerateImagePlugin r100) {
            this.f363282a = r100;
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.office.plugins.slides.media.imggen.g] */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.office.plugins.slides.media.imggen.h] */
        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            SelectedImageModel r102 = (SelectedImageModel) r100;
            FLogger r103 = FLogger.f375446a;
            r103.d(AIGenerateImagePlugin.TAG, "call ai generate image:" + GsonProtectorUtils.toJson(new Gson(), r102));
            StringBuilder r104 = new StringBuilder("[AIGenerateImagePlugin] handle generateImage data=");
            r104.append(GsonProtectorUtils.toJson(new Gson(), r102));
            r104.append(" hasHost=");
            if (AIGenerateImagePlugin.access$getPluginHost$p(this.f363282a) == null) goto L5;
            boolean r105 = true;
        L6:
            r104.append(r105);
            r104.append(" activity=");
            FragmentActivity r106 = AIGenerateImagePlugin.access$getActivity(this.f363282a);
            if (r106 == null) goto L9;
            String r107 = r106.getClass().getSimpleName();
        L10:
            r104.append(r107);
            r103.i(AIGenerateImagePlugin.DEBUG_TAG, r104.toString());
            FragmentActivity r108 = AIGenerateImagePlugin.access$getActivity(this.f363282a);
            if (r108 == null) goto L24;
            final ChameleonPluginHost r109 = AIGenerateImagePlugin.access$getPluginHost$p(this.f363282a);
            final AIGenerateImagePlugin r110 = this.f363282a;
            AIGenerateImagePlugin.access$setupAIGenerateImageCallback(r110, r108, new com.larus.office.plugins.slides.media.imggen.a(r102, new g(r109), new h(r110), 2));
            if (r109 == null) goto L21;
            com.bytedance.ee.bear.browser.plugin.t r111 = r109.getUIContainer();
            if (r111 == null) goto L22;
            View r112 = r111.getContentView();
            if (r112 == null) goto L23;
            final AIGenerateImagePlugin r113 = this.f363282a;
            r112.postDelayed(new i(r113, r109), 500);
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        L24:
            return;
        L9:
            r107 = null;
            goto L10
        L5:
            r105 = false;
            goto L6
        }
    }

    public static final class b {
        public b() {
        }
    }

    /* JADX INFO: renamed from: com.larus.office.plugins.slides.media.imggen.AIGenerateImagePlugin$handleActivityResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.office.plugins.slides.media.imggen.AIGenerateImagePlugin$handleActivityResult$1", f = "AIGenerateImagePlugin.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $localPath;
        final /* synthetic */ ThumbType $thumbType;
        int label;
        final /* synthetic */ AIGenerateImagePlugin this$0;

        public AnonymousClass1(ThumbType r100, AIGenerateImagePlugin r101, String r102, Continuation<? super AnonymousClass1> r103) {
            this.$thumbType = r100;
            this.this$0 = r101;
            this.$localPath = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$thumbType, this.this$0, this.$localPath, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ChameleonImageUtils r103 = ChameleonImageUtils.f363623a;
            ThumbType r104 = this.$thumbType;
            Long r105 = Boxing.boxLong(AIGenerateImagePlugin.MAX_FILE_SIZE_BYTES);
            Function0 r106 = new j();
            final AIGenerateImagePlugin r107 = this.this$0;
            final String r108 = this.$localPath;
            Function1 r109 = new k(r107, r108);
            this.label = 1;
            r103.getClass();
            if (ChameleonImageUtils.b(r104, r105, r106, r109, this) != r101) goto L12;
            return r101;
        }
    }

    static {
        Companion = new b();
    }

    public static /* synthetic */ Unit a(ny9.b r100, ActivityResultLauncher r101) {
        return showAIGenerateImagePage$lambda$3(r100, r101);
    }

    public static /* synthetic */ c c() {
        return editPanel_delegate$lambda$0();
    }

    public static /* synthetic */ Unit d(AIGenerateImagePlugin r100, FragmentActivity r101, int r102, Intent r103) {
        return showAIGenerateImagePage$lambda$4(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private static final c editPanel_delegate$lambda$0() {
        return new c();
    }

    private final c getEditPanel() {
        return (c) this.editPanel$delegate.getValue();
    }

    public AIGenerateImagePlugin() {
        this.editPanel$delegate = LazyKt.lazy(new d());
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(AIGenerateImagePlugin r100) {
        return r100.getActivity();
    }

    public static final /* synthetic */ com.larus.office.plugins.slides.media.imggen.a access$getCurAIGenerateImage$p(AIGenerateImagePlugin r100) {
        return r100.curAIGenerateImage;
    }

    public static final /* synthetic */ c access$getEditPanel(AIGenerateImagePlugin r100) {
        return r100.getEditPanel();
    }

    public static final /* synthetic */ g45.d access$getEditPanelManager$p(AIGenerateImagePlugin r100) {
        return r100.editPanelManager;
    }

    public static final /* synthetic */ ChameleonPluginHost access$getPluginHost$p(AIGenerateImagePlugin r100) {
        return r100.pluginHost;
    }

    private final String safeLogId(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L14;
        if (r100 != null) goto L11;
        return "null";
    L11:
        return "empty";
    L14:
        return "len=" + r100.length() + ",hash=" + r100.hashCode();
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        FLogger.f375446a.i(DEBUG_TAG, "[AIGenerateImagePlugin] registerBridgeHandler biz.util.AIGenerateImage");
        r100.put(BIZ_AI_GENERATE_IMAGE, new a(this));
    }

    private final void setupAIGenerateImageCallback(Activity r100, com.larus.office.plugins.slides.media.imggen.a r101) {
        this.curAIGenerateImage = r101;
        Lazy r102 = p.f363383a;
        z0 r103 = (z0) p.f363387e.getValue();
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("[AIGenerateImagePlugin] setupAIGenerateImageCallback hasActionBarItem=");
        if (r103 == null) goto L5;
        boolean r106 = true;
    L6:
        r105.append(r106);
        r105.append(" selectedUrl=");
        if (r101 == null) goto L11;
        SelectedImageModel r107 = r101.f363343a;
        if (r107 == null) goto L11;
        String r108 = r107.getUrl();
    L12:
        r105.append(safeLogId(r108));
        r104.i(DEBUG_TAG, r105.toString());
        showAIGenerateImagePage(r100, r101, r103);
        return;
    L11:
        r108 = null;
        goto L12
    L5:
        r106 = false;
        goto L6
    }

    private static final Unit showAIGenerateImagePage$lambda$3(ny9.b r100, ActivityResultLauncher r101) {
        Intrinsics.checkNotNullParameter(r101, "launcher");
        IUgcAIGCService.f373945a.A(r101, r100);
        return Unit.INSTANCE;
    }

    public void onAttachToUIContainer(ChameleonPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onAttachToUIContainer(r100, r101);
        this.pluginHost = r100;
        String r102 = null;
        if (r100 == null) goto L5;
        g45.d r103 = (g45.d) r100.getHostAbility(g45.d.class);
    L6:
        this.editPanelManager = r103;
        if (r103 == null) goto L9;
        r103.registerEditPanel(getLifecycleOwner(), getEditPanel());
    L9:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("[AIGenerateImagePlugin] onAttachToUIContainer host=");
        if (r100 == null) goto L12;
        r102 = r100.getClass().getSimpleName();
    L12:
        r105.append(r102);
        r105.append(" hasEditPanelManager=");
        if (this.editPanelManager == null) goto L15;
        boolean r106 = true;
    L16:
        r105.append(r106);
        r104.i(DEBUG_TAG, r105.toString());
        return;
    L15:
        r106 = false;
        goto L16
    L5:
        r103 = null;
        goto L6
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onDetachFromUIContainer(r100, r101);
        FLogger.f375446a.i(DEBUG_TAG, "[AIGenerateImagePlugin] onDetachFromUIContainer");
        this.editPanelManager = null;
        this.pluginHost = null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onDetachFromUIContainer((ChameleonPluginHost) r100, r101);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_office_plugins_slides_media_imggen_AIGenerateImagePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, Fragment r101, String r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, 0) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    public static final /* synthetic */ void access$setupAIGenerateImageCallback(AIGenerateImagePlugin r100, Activity r101, com.larus.office.plugins.slides.media.imggen.a r102) {
        r100.setupAIGenerateImageCallback(r101, r102);
    }

    private final Object copyToChameleonDir(ThumbType r100, Function1<? super ThumbType, Unit> r101, Continuation<? super Unit> r102) {
        r101.invoke(r100);
        return Unit.INSTANCE;
    }

    private final void handleActivityResult(Activity r310, int r311, Intent r312) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("Router onActivityResult: resultCode -> ");
        r101.append(r311);
        r101.append(" , data: ");
        String r102 = null;
        if (r312 == null) goto L5;
        Bundle r103 = r312.getExtras();
    L6:
        r101.append(r103);
        r100.i(TAG, r101.toString());
        StringBuilder r104 = new StringBuilder("[AIGenerateImagePlugin] handleActivityResult resultCode=");
        r104.append(r311);
        r104.append(" extras=");
        if (r312 == null) goto L9;
        Bundle r105 = r312.getExtras();
    L10:
        r104.append(r105);
        r100.i(DEBUG_TAG, r104.toString());
        int r106 = 0;
        if (r311 != 40002) goto L74;
        String r110 = UUID.randomUUID().toString();
        long r107 = 0;
        if (r312 == null) goto L16;
        r107 = r312.getLongExtra("image_file_size", 0);
    L16:
        if (r312 == null) goto L19;
        String r108 = r312.getStringExtra("image_local_path");
        if (r108 == null) goto L19;
    L20:
        if (r312 == null) goto L23;
        String r109 = r312.getStringExtra("image_file_name");
        if (r109 == null) goto L23;
    L24:
        if (r312 == null) goto L26;
        int r111 = r312.getIntExtra("image_width", 0);
    L27:
        if (r312 == null) goto L29;
        int r112 = r312.getIntExtra("image_height", 0);
    L30:
        if (r112 > 0) goto L40;
        com.larus.office.plugins.slides.media.imggen.a r113 = this.curAIGenerateImage;
        if (r113 == null) goto L39;
        SelectedImageModel r114 = r113.f363343a;
        if (r114 == null) goto L39;
        Float r115 = r114.getHeight();
        if (r115 == null) goto L39;
        r112 = (int) r115.floatValue();
    L39:
        r112 = 0;
    L40:
        if (r111 <= 0) goto L42;
        r106 = r111;
    L49:
        ThumbType r116 = new ThumbType("image/jpeg", r109, null, Long.valueOf(r107), Integer.valueOf(r112), Integer.valueOf(r106), "docsource://".concat(r108), r110, 4, null);
        Intent r117 = r310.getIntent();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r116, this, r108, null), 3, null);
        com.larus.office.plugins.slides.media.imggen.a r118 = this.curAIGenerateImage;
        if (r118 == null) goto L54;
        Function0<Unit> r119 = r118.f363346d;
        if (r119 == null) goto L54;
        r119.invoke();
    L54:
        if (r117 == null) goto L56;
        String r210 = r117.getStringExtra("presentation_id");
    L57:
        if (r117 == null) goto L59;
        String r211 = r117.getStringExtra("resource_id");
    L61:
        if (r117 == null) goto L63;
        Integer r212 = Integer.valueOf(r117.getIntExtra("resource_type", -1));
    L64:
        if (r117 == null) goto L66;
        String r213 = r117.getStringExtra("artifact_meta_id");
    L67:
        if (r117 == null) goto L69;
        Integer r214 = Integer.valueOf(r117.getIntExtra("artifact_type", -1));
    L70:
        if (r117 == null) goto L72;
        r102 = r117.getStringExtra("aippt_task_id");
    L72:
        tx9.c0.H(null, "aippt_generate_picture_confirm", null, null, null, "aippt_new_detail", null, null, null, null, null, null, null, 0, r210, r211, r212, r213, r214, r102, "aippt_new", null, null, 31473629);
        return;
    L69:
        r214 = null;
        goto L70
    L66:
        r213 = null;
        goto L67
    L63:
        r212 = null;
        goto L64
    L59:
        r211 = null;
        goto L61
    L56:
        r210 = null;
        goto L57
    L42:
        com.larus.office.plugins.slides.media.imggen.a r120 = this.curAIGenerateImage;
        if (r120 == null) goto L49;
        SelectedImageModel r121 = r120.f363343a;
        if (r121 == null) goto L49;
        Float r122 = r121.getWidth();
        if (r122 == null) goto L49;
        r106 = (int) r122.floatValue();
        goto L49
    L29:
        r112 = 0;
        goto L30
    L26:
        r111 = 0;
    L23:
        r109 = "";
    L19:
        r108 = "";
        goto L20
    L74:
        if (r311 != 0) goto L86;
        if (r312 != null) goto L77;
    L79:
        if (r106 == 0) goto L87;
        com.larus.office.plugins.slides.media.imggen.a r123 = this.curAIGenerateImage;
        if (r123 == null) goto L88;
        Function0<Unit> r124 = r123.f363346d;
        if (r124 == null) goto L89;
        r124.invoke();
        return;
    L89:
        return;
    L88:
        return;
    L87:
        return;
    L77:
        if (r312.getBooleanExtra(MinorConfigItems.AI_CREATION, false) != true) goto L79;
        r106 = 1;
        goto L79
    L86:
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    private final void showAIGenerateImagePage(Activity r610, com.larus.office.plugins.slides.media.imggen.a r611, z0 r612) {
        Intent r100 = r610.getIntent();
        if (r612 != null) goto L5;
        return;
    L5:
        FLogger r101 = FLogger.f375446a;
        r101.i(DEBUG_TAG, "[AIGenerateImagePlugin] showAIGenerateImagePage presentationId=" + safeLogId(r100.getStringExtra("presentation_id")) + " resourceId=" + safeLogId(r100.getStringExtra("resource_id")) + " conversationId=" + safeLogId(r100.getStringExtra("conversation_id")));
        Resource r110 = null;
        if ((r610 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r111 = (FragmentActivity) r610;
    L10:
        if (r111 != null) goto L13;
        r101.e(DEBUG_TAG, "[AIGenerateImagePlugin] showAIGenerateImagePage activity is not FragmentActivity");
        r101.e(TAG, "showAIGenerateImagePage: activity is not FragmentActivity");
        return;
    L13:
        Intrinsics.checkNotNull(r610, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity r102 = (AppCompatActivity) r610;
        ResourceExt[] r103 = new ResourceExt[1];
        if (r611 == null) goto L21;
        SelectedImageModel r104 = r611.f363343a;
        if (r104 == null) goto L21;
        String r105 = r104.getUrl();
        if (r105 == null) goto L21;
        String r613 = "";
    L22:
        ResourceExt r112 = new ResourceExt(r110, r105, 1);
        int r106 = 0;
        r103[0] = r112;
        List r113 = CollectionsKt.mutableListOf(r103);
        String r107 = r100.getStringExtra("conversation_id");
        if (r107 != null) goto L25;
        String r114 = r613;
    L26:
        String r108 = r100.getStringExtra("bot_id");
        if (r108 != null) goto L29;
        String r115 = r613;
    L30:
        ChatParam r410 = new ChatParam(r114, r115, "", "", "default", 224);
        String r109 = r100.getStringExtra("presentation_id");
        if (r109 != null) goto L33;
        String r210 = r613;
    L34:
        String r116 = r100.getStringExtra("resource_id");
        if (r116 != null) goto L37;
        String r211 = r613;
    L38:
        Integer r212 = Integer.valueOf(r100.getIntExtra("resource_type", -1));
        String r117 = r100.getStringExtra("artifact_meta_id");
        if (r117 != null) goto L41;
        String r213 = r613;
    L42:
        Integer r214 = Integer.valueOf(r100.getIntExtra("artifact_type", -1));
        String r118 = r100.getStringExtra("aippt_task_id");
        if (r118 != null) goto L45;
        String r310 = r613;
    L46:
        String r119 = r100.getStringExtra(MusicAppletPage.KEY_MESSAGE_ID);
        if (r119 != null) goto L49;
        String r311 = r613;
    L50:
        lr9.a r510 = new lr9.a(r210, r211, r212, r213, r214, r310, r311);
        StringBuilder r120 = new StringBuilder();
        if (r611 == null) goto L57;
        SelectedImageModel r121 = r611.f363343a;
        if (r121 == null) goto L57;
        Float r122 = r121.getWidth();
        if (r122 == null) goto L57;
        int r123 = (int) r122.floatValue();
    L58:
        r120.append(r123);
        r120.append(':');
        if (r611 == null) goto L65;
        SelectedImageModel r124 = r611.f363343a;
        if (r124 == null) goto L65;
        Float r125 = r124.getHeight();
        if (r125 == null) goto L65;
        r106 = (int) r125.floatValue();
    L65:
        r120.append(r106);
        String r411 = r120.toString();
        Bundle r126 = new Bundle();
        r126.putInt("max_select_image_count", 6);
        final FragmentActivity r127 = r111;
        final ny9.b r128 = new ny9.b(true, r102, r612, r410, false, false, null, null, null, null, r113, null, null, null, null, null, null, null, null, false, false, null, null, r126, false, null, null, null, false, null, false, null, null, null, null, null, null, null, r510, r411, "slides", null, null, null, new ChatPageContext(MapsKt.mapOf(TuplesKt.to("x-flow-function-scene", "SLIDESAIImage")), null, null, null, null, null, 62, null), null, null, null, null, false, -8389648, 257599);
        Function1<? super ActivityResultLauncher<Intent>, Unit> r129 = AIGenerateImageBridgeFragment.f363277g;
        Function1<? super ActivityResultLauncher<Intent>, Unit> r130 = new e(r128);
        Function2<? super Integer, ? super Intent, Unit> r131 = new f(this, r127);
        Intrinsics.checkNotNullParameter(r130, "onLaunch");
        Intrinsics.checkNotNullParameter(r131, "onResult");
        AIGenerateImageBridgeFragment.f363277g = r130;
        AIGenerateImageBridgeFragment.f363278h = r131;
        AIGenerateImageBridgeFragment r132 = new AIGenerateImageBridgeFragment();
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L68
        INVOKEVIRTUAL_com_larus_office_plugins_slides_media_imggen_AIGenerateImagePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r127.getSupportFragmentManager().beginTransaction(), r132, "ai_generate_image_bridge_" + UUID.randomUUID()).commitNowAllowingStateLoss();     // Catch: Throwable -> L68
        Object r134 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L68
    L70:
        Throwable r135 = Result.m9452exceptionOrNullimpl(r134);
        if (r135 == null) goto L76;
        FLogger r136 = FLogger.f375446a;
        r136.e(DEBUG_TAG, "[AIGenerateImagePlugin] attach bridge fragment fail " + r135.getMessage(), r135);
        r136.e(TAG, "showAIGenerateImagePage: attach bridge fragment fail: " + r135.getMessage(), r135);
        return;
    L76:
        return;
    L68:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L57:
        r123 = 0;
        goto L58
    L49:
        r311 = r119;
        goto L50
    L45:
        r310 = r118;
        goto L46
    L41:
        r213 = r117;
        goto L42
    L37:
        r211 = r116;
        goto L38
    L33:
        r210 = r109;
        goto L34
    L29:
        r115 = r108;
        goto L30
    L25:
        r114 = r107;
    L21:
        r613 = "";
        r105 = r613;
        goto L22
    L8:
        r111 = null;
        goto L10
    }

    public static final /* synthetic */ Object access$copyToChameleonDir(AIGenerateImagePlugin r100, ThumbType r101, Function1 r102, Continuation r103) {
        return r100.copyToChameleonDir(r101, r102, r103);
    }

    private static final Unit showAIGenerateImagePage$lambda$4(AIGenerateImagePlugin r100, FragmentActivity r101, int r102, Intent r103) {
        r100.handleActivityResult(r101, r102, r103);
        return Unit.INSTANCE;
    }
}
