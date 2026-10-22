package com.larus.canvas.feature.component.logic;

import android.net.Uri;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.canvas.feature.component.base.ImageResId;
import com.larus.canvas.feature.component.base.TextRes;
import com.larus.canvas.feature.component.logic.exit.CanvasExitAnchorManager;
import com.larus.canvas.feature.host.CanvasHostUiPolicy;
import com.larus.canvas.service.bean.AIBeautify;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u0089\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020@H\u0016J\b\u0010D\u001a\u00020@H\u0002J\b\u0010E\u001a\u00020@H\u0002J\u0010\u0010F\u001a\u00020@2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020@H\u0003J\b\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020@2\u0006\u0010M\u001a\u00020NH\u0002J\u0012\u0010O\u001a\u00020@2\b\b\u0002\u0010P\u001a\u00020KH\u0002J\b\u0010Q\u001a\u00020KH\u0002J\b\u0010R\u001a\u00020@H\u0002J\b\u0010S\u001a\u00020@H\u0002J\u0010\u0010T\u001a\u00020@2\u0006\u0010M\u001a\u00020UH\u0002J\u0010\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0002J\u0018\u0010Z\u001a\u00020@2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u000203H\u0002J\u0014\u0010^\u001a\u0004\u0018\u00010W2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010d\u001a\u00020KH\u0002Jå\u0001\u0010e\u001a\u00020@2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010u\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010w\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010x\u001a\u0004\u0018\u00010WH\u0002¢\u0006\u0002\u0010yJ\b\u0010z\u001a\u00020@H\u0002J\b\u0010{\u001a\u00020|H\u0002J\u0012\u0010}\u001a\u00020@2\b\u0010~\u001a\u0004\u0018\u00010cH\u0002J\u0011\u0010\u007f\u001a\u00020@2\u0007\u0010M\u001a\u00030\u0080\u0001H\u0002J\t\u0010\u0081\u0001\u001a\u00020@H\u0002J\u0016\u0010\u0082\u0001\u001a\u00020@2\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010WH\u0002J\t\u0010\u0084\u0001\u001a\u00020@H\u0002J\t\u0010\u0085\u0001\u001a\u00020KH\u0002J\u0011\u0010\u0086\u0001\u001a\n\u0012\u0005\u0012\u00030\u0088\u00010\u0087\u0001H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\t\u001a\u0004\b/\u00100R#\u00102\u001a\n 4*\u0004\u0018\u000103038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\t\u001a\u0004\b5\u00106R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b:\u0010;R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"}, d2 = {"Lcom/larus/canvas/feature/component/logic/GenImageUIActionReceiverComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "canvasTitleAbility", "Lcom/larus/canvas/feature/component/title/ITitleAbility;", "getCanvasTitleAbility", "()Lcom/larus/canvas/feature/component/title/ITitleAbility;", "canvasTitleAbility$delegate", "Lkotlin/Lazy;", "imagePagerAbility", "Lcom/larus/canvas/feature/component/resultdisplay/image/IImagePagerAbility;", "getImagePagerAbility", "()Lcom/larus/canvas/feature/component/resultdisplay/image/IImagePagerAbility;", "imagePagerAbility$delegate", "genImagePlannerAbility", "Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "getGenImagePlannerAbility", "()Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "genImagePlannerAbility$delegate", "canvasInputAbility", "Lcom/larus/canvas/feature/ability/CanvasInputAbility;", "getCanvasInputAbility", "()Lcom/larus/canvas/feature/ability/CanvasInputAbility;", "canvasInputAbility$delegate", "canvasContainerAbility", "Lcom/larus/canvas/feature/ability/CanvasContainerAbility;", "getCanvasContainerAbility", "()Lcom/larus/canvas/feature/ability/CanvasContainerAbility;", "canvasContainerAbility$delegate", "imageDownloadAbility", "Lcom/larus/canvas/feature/component/logic/ImageOperatorAbility;", "getImageDownloadAbility", "()Lcom/larus/canvas/feature/component/logic/ImageOperatorAbility;", "imageDownloadAbility$delegate", "canvasGenImageTraceAbility", "Lcom/larus/canvas/feature/component/logic/trace/CanvasGenImageTraceAbility;", "getCanvasGenImageTraceAbility", "()Lcom/larus/canvas/feature/component/logic/trace/CanvasGenImageTraceAbility;", "canvasGenImageTraceAbility$delegate", "argumentData", "Lcom/larus/canvas/feature/data/CanvasArgumentData;", "getArgumentData", "()Lcom/larus/canvas/feature/data/CanvasArgumentData;", "argumentData$delegate", "hostUiPolicy", "Lcom/larus/canvas/feature/host/CanvasHostUiPolicy;", "getHostUiPolicy", "()Lcom/larus/canvas/feature/host/CanvasHostUiPolicy;", "hostUiPolicy$delegate", "inputTouchInterceptView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getInputTouchInterceptView", "()Landroid/view/View;", "inputTouchInterceptView$delegate", "canvasGalleryContext", "Lcom/larus/canvas/feature/component/logic/provider/CanvasGalleryContext;", "getCanvasGalleryContext", "()Lcom/larus/canvas/feature/component/logic/provider/CanvasGalleryContext;", "canvasGalleryContext$delegate", "pickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", "onAttach", "", "afterViewBind", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "notifyCanvasExit", "initPickPhotoHelper", "onAlbumSelected", "uri", "Landroid/net/Uri;", "bindObservers", "shouldHandleCanvasBackPressed", "", "handleContainerUIAction", "action", "Lcom/larus/canvas/feature/ability/CanvasContainerUIAction;", "handleExitRequest", "fromTitleLeftButton", "shouldConfirmUnsavedGeneratedImages", "showUnsavedGeneratedImagesDialog", "showQuitConfirmPopUpMenu", "handleImagePagerUIAction", "Lcom/larus/canvas/feature/component/resultdisplay/image/ImagePagerUIAction;", "getOriginalImagePath", "", "originalImage", "Lcom/larus/canvas/feature/component/logic/bean/OriginalImageItem;", "showCanvasGalleryDialog", "pageItemData", "Lcom/larus/canvas/feature/component/resultdisplay/image/PageItemData;", "startView", "getImageEditFunctionId", "targetTaskItem", "Lcom/larus/canvas/feature/component/logic/bean/GenImageTaskItem;", "getTopProvider", "Lcom/larus/gallery/api/IGalleryComponentProvider;", "Lcom/larus/canvas/feature/component/logic/bean/CanvasGalleryDataItem;", "enablePreview", "reportEnterPictureDetail", "botId", "aiCreateShowMode", "creationTaskId", "conversationId", "chatType", "currentPage", "enterFrom", "enterMethod", "index", "", "isCreation", "isDeepThinking", "isImageEdit", "imageEditFunctionId", "isReplicaGen", "messageId", "position", "slideStatus", "userType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "dismissPreviewDialog", "createSidebarCallback", "Lcom/larus/canvas/feature/component/logic/provider/ICanvasGallerySidebarCallback;", "skipToVideoCreationPage", "data", "handleTitleUIAction", "Lcom/larus/canvas/feature/component/title/TitleUIAction;", "exitCanvas", "handleSaveClick", "localId", "handleQuitFlow", "isCanvasGenerating", "buildQuitConfirmPopUpMenuItems", "", "Lcom/larus/canvas/feature/component/title/widget/DropdownItemData;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenImageUIActionReceiverComponent extends BaseContentWidget {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f323285y = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f323286m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f323287n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f323288o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f323289p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f323290q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f323291r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f323292s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f323293t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f323294u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f323295v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f323296w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.larus.bmhome.instruction.helper.f f323297x;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f323298a = null;

        static {
            int[] r100 = new int[CanvasHostUiPolicy.ExitBehavior.values().length];
            r100[CanvasHostUiPolicy.ExitBehavior.HOST_BACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CanvasHostUiPolicy.ExitBehavior.HOST_CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CanvasHostUiPolicy.ExitBehavior.NATIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f323298a = r100;
        }
    }

    static {
    }

    public final List<ly8.g> Y2() {
        return CollectionsKt.listOf(new ly8.g[]{new ly8.g("edit_again", new ImageResId(R.drawable.larus_ic_photo_editer), new TextRes.StringResId(R.string.larus_canvas_action_menu_editAnother), ContextCompat.getColor(getContext(), R.color.neutral_100)), new ly8.g("quit", new ImageResId(R.drawable.larus_ic_arrow_to_left), new TextRes.StringResId(R.string.larus_canvas_action_menu_leave), ContextCompat.getColor(getContext(), R.color.danger_50))});
    }

    public final n2 B3() {
        return (n2) this.f323288o.getValue();
    }

    public final com.larus.canvas.feature.component.resultdisplay.image.r D3() {
        return (com.larus.canvas.feature.component.resultdisplay.image.r) this.f323287n.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void P2() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageUIActionReceiverComponent$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageUIActionReceiverComponent$bindObservers$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageUIActionReceiverComponent$bindObservers$3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImageUIActionReceiverComponent$bindObservers$4(this, null), 3, null);
        F2().setOnClickListener(new x1(this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.utils.v.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), new y1(this));
    }

    public final void h3() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r100 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r100 == null) goto L10;
        FragmentManager r101 = r100.getSupportFragmentManager();
        if (r101 == null) goto L11;
        Fragment r102 = r101.findFragmentByTag("CanvasGalleryDialog");
        if (r102 == null) goto L12;
        r101.beginTransaction().remove(r102).commitAllowingStateLoss();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void m3() {
        com.larus.canvas.feature.component.logic.trace.a r100 = (com.larus.canvas.feature.component.logic.trace.a) this.f323292s.getValue();
        if (r100 == null) goto L5;
        r100.OV();
    L5:
        CanvasHostUiPolicy r101 = (CanvasHostUiPolicy) this.f323294u.getValue();
        if (r101.f323740a == true) goto L9;
        CanvasHostUiPolicy.ExitBehavior r102 = CanvasHostUiPolicy.ExitBehavior.NATIVE;
    L12:
        int r103 = b.f323298a[r102.ordinal()];
        boolean r104 = true;
        if (r103 != 1) goto L15;
        ICreationWorkflowService.f373940a.H(new w1(this));
    L33:
        com.larus.canvas.feature.component.logic.trace.a r105 = (com.larus.canvas.feature.component.logic.trace.a) this.f323292s.getValue();
        if (r105 == null) goto L37;
        r105.xx("leave");
        return;
    L37:
        return;
    L15:
        if (r103 == 2) goto L30;
        if (r103 != 3) goto L28;
        my8.q r106 = p3();
        if (r106 != null) goto L21;
    L23:
        r104 = false;
    L24:
        if (r104 == false) goto L26;
        AppHost.f326268a.a().k();
        goto L33
    L26:
        s1a.a.getActivity(this).finish();
        goto L33
    L21:
        if (((Boolean) r106.f516414f.getValue()).booleanValue() != true) goto L23;
    L28:
        throw new NoWhenBranchMatchedException();
    L30:
        if (ICreationWorkflowService.f373940a.L() == true) goto L33;
        s1a.a.getActivity(this).finish();
        goto L33
    L9:
        if (r101.f323741b == false) goto L11;
        r102 = CanvasHostUiPolicy.ExitBehavior.HOST_CLOSE;
        goto L12
    L11:
        r102 = CanvasHostUiPolicy.ExitBehavior.HOST_BACK;
        goto L12
    }

    public final my8.q p3() {
        return (my8.q) this.f323293t.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        IAIChatUgcAIGCService.Companion r100 = IAIChatUgcAIGCService.f365905a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.bmhome.instruction.helper.f r101 = r100.H0(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        r101.b(new v1(this));
        this.f323297x = r101;
    }

    public final com.larus.canvas.feature.component.logic.provider.j z3() {
        return (com.larus.canvas.feature.component.logic.provider.j) this.f323296w.getValue();
    }

    public GenImageUIActionReceiverComponent() {
        this.f323286m = LazyKt.lazy(new t1(this));
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        this.f323287n = LazyKt.lazy(r100, new a2(this));
        this.f323288o = LazyKt.lazy(new b2(this));
        this.f323289p = LazyKt.lazy(new c2(this));
        this.f323290q = LazyKt.lazy(new d2(this));
        this.f323291r = LazyKt.lazy(new e2(this));
        this.f323292s = LazyKt.lazy(new f2(this));
        this.f323293t = LazyKt.lazy(r100, new g2(this));
        this.f323294u = LazyKt.lazy(r100, new h2(this));
        this.f323295v = LazyKt.lazy(new u1(this));
        this.f323296w = LazyKt.lazy(new z1(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        n2 r100 = B3();
        String r101 = null;
        if (r100 == null) goto L9;
        kotlinx.coroutines.flow.b1 r102 = r100.tx();
        if (r102 == null) goto L9;
        Pair r103 = (Pair) r102.getValue();
        if (r103 == null) goto L9;
        ky8.h r104 = (ky8.h) r103.getSecond();
    L11:
        if ((r104 instanceof ky8.f) == false) goto L13;
        ky8.f r105 = (ky8.f) r104;
    L14:
        Lazy r106 = CanvasExitAnchorManager.f323351a;
        if (r105 == null) goto L17;
        String r107 = r105.j();
    L18:
        n2 r108 = B3();
        if (r108 == null) goto L23;
        Pair<String, String> r109 = r108.j50();
        if (r109 == null) goto L23;
        r101 = r109.getSecond();
    L23:
        n2 r110 = B3();
        if (r110 == null) goto L26;
        boolean r111 = r110.M20();
    L27:
        CanvasExitAnchorManager.a(r107, r101, r111);
        return;
    L26:
        r111 = false;
        goto L27
    L17:
        r107 = null;
        goto L18
    L13:
        r105 = null;
    L9:
        r104 = null;
        goto L11
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        h3();
    }

    public static String E3(ky8.k r100) {
        ky8.j r101 = r100.f506723b;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f506720e;
    L6:
        String r104 = "";
        if (com.larus.utils.o0.d(r103) == false) goto L18;
        ky8.j r105 = r100.f506723b;
        if (r105 == null) goto L11;
        r102 = r105.f506720e;
    L11:
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        String r106 = UriProtector.parse(com.larus.canvas.feature.component.logic.helper.a.a(r102)).getPath();
        if (r106 == null) goto L17;
        r104 = r106;
    L17:
        String r107 = Uri.fromFile(new PolarisFileWrapper(r104)).toString();
        Intrinsics.checkNotNull(r107);
        return r107;
    L18:
        ky8.j r108 = r100.f506723b;
        if (r108 == null) goto L26;
        String r109 = r108.f506717b;
        if (r109 != null) goto L24;
        return "";
    L24:
        return r109;
    L26:
        return "";
    L5:
        r103 = null;
        goto L6
    }

    public final String C3(ky8.f r100) {
        if (r100 == null) goto L5;
        AIBeautify r101 = r100.c();
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        AIBeautify r102 = r100.c();
        boolean r103 = false;
        if (r102 == null) goto L11;
        boolean r104 = Intrinsics.areEqual(r102.isExpand, Boolean.TRUE);
    L12:
        if (r104 == false) goto L15;
        return "2";
    L15:
        AIBeautify r105 = r100.c();
        if (r105 == null) goto L18;
        boolean r106 = Intrinsics.areEqual(r105.isErase, Boolean.TRUE);
    L19:
        if (r106 == false) goto L22;
        return "3";
    L22:
        AIBeautify r107 = r100.c();
        if (r107 == null) goto L25;
        r103 = Intrinsics.areEqual(r107.isQualityImprove, Boolean.TRUE);
    L25:
        if (r103 == false) goto L28;
        return "1";
    L28:
        return null;
    L18:
        r106 = false;
        goto L19
    L11:
        r104 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r7v5 */
    public final void G3(boolean r100) {
        my8.q r101 = p3();
        boolean r102 = true;
        int r103 = 0;
        if (r101 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        ?? r105 = 0;
        String r106 = null;
        r106 = null;
        String r107 = null;
        r107 = null;
        r105 = 0;
        r105 = 0;
        r105 = 0;
        r105 = 0;
        if (r104 == true) goto L43;
        if (r100 == false) goto L23;
        com.larus.canvas.feature.component.title.k r108 = (com.larus.canvas.feature.component.title.k) this.f323286m.getValue();
        if (r108 == null) goto L14;
        r108.yS(new com.larus.canvas.feature.component.title.m.a(Y2()));
    L14:
        n2 r109 = B3();
        if (r109 == null) goto L19;
        Long r110 = r109.XF();
        if (r110 == null) goto L19;
        r106 = r110.toString();
    L19:
        n2 r111 = B3();
        if (r111 == null) goto L22;
        r103 = r111.re();
    L22:
        com.larus.canvas.feature.component.logic.helper.d.a(r106, Integer.valueOf(r103));
        return;
    L23:
        com.larus.canvas.feature.component.title.k r112 = (com.larus.canvas.feature.component.title.k) this.f323286m.getValue();
        if (r112 != null) goto L26;
    L28:
        r102 = false;
    L29:
        if (r102 == true) goto L39;
        n2 r113 = B3();
        if (r113 == null) goto L35;
        Long r114 = r113.XF();
        if (r114 == null) goto L35;
        r107 = r114.toString();
    L35:
        n2 r115 = B3();
        if (r115 == null) goto L38;
        r103 = r115.re();
    L38:
        com.larus.canvas.feature.component.logic.helper.d.a(r107, Integer.valueOf(r103));
    L39:
        com.larus.canvas.feature.component.title.k r116 = (com.larus.canvas.feature.component.title.k) this.f323286m.getValue();
        if (r116 == null) goto L129;
        r116.yS(new com.larus.canvas.feature.component.title.m.a(Y2()));
        return;
    L129:
        return;
    L26:
        if (r112.WC() != true) goto L28;
    L43:
        n2 r117 = B3();
        if (r117 == null) goto L48;
        Long r118 = r117.XF();
        if (r118 == null) goto L48;
        String r119 = r118.toString();
    L49:
        n2 r120 = B3();
        if (r120 == null) goto L52;
        int r121 = r120.re();
    L53:
        com.larus.canvas.feature.component.logic.helper.d.a(r119, Integer.valueOf(r121));
        n2 r122 = B3();
        if (r122 == null) goto L75;
        kotlinx.coroutines.flow.i1<ky8.g> r123 = r122.bt();
        if (r123 == null) goto L75;
        ky8.g r124 = r123.getValue();
        if (r124 == null) goto L75;
        Map<String, ky8.h> r125 = r124.f506706a;
        if (r125 == null) goto L75;
        Collection<ky8.h> r126 = r125.values();
        if (r126 == null) goto L75;
        ArrayList r127 = new ArrayList();
        Iterator r128 = r126.iterator();
    L65:
        if (r128.hasNext() == false) goto L69;
        Object r129 = r128.next();
        if ((r129 instanceof ky8.f) == false) goto L65;
        r127.add(r129);
        goto L65
    L69:
        r105 = new ArrayList();
        Iterator r130 = r127.iterator();
    L71:
        if (r130.hasNext() == false) goto L75;
        Object r131 = r130.next();
        if (((ky8.f) r131).l() == false) goto L71;
        r105.add(r131);
    L75:
        if (r105 != 0) goto L78;
        r105 = CollectionsKt.emptyList();
    L78:
        if ((!((Collection) r105).isEmpty()) == false) goto L96;
        Iterable r132 = (Iterable) r105;
        if ((r132 instanceof Collection) == true) goto L82;
    L84:
        Iterator r133 = r132.iterator();
    L86:
        if (r133.hasNext() == false) goto L93;
        if (((ky8.f) r133.next()).f506703g != 2) goto L90;
        boolean r134 = true;
    L91:
        if (r134 == false) goto L86;
        boolean r135 = false;
    L94:
        if (r135 == false) goto L96;
    L97:
        if (r102 == false) goto L108;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r136 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager();
        if (r136.isStateSaved() == false) goto L101;
        return;
    L101:
        if (r136.findFragmentByTag("CanvasUnsavedExitDialog") != null) goto L132;
        CommonDialog.a r137 = new CommonDialog.a();
        int r138 = com.larus.utils.j0.f375426a;
        r137.i(com.larus.utils.j0.e("larus_canvas_unsaved_exit_dialog_title"));
        CommonDialog.a.e(r137, new k2(), getContext().getString(R.string.larus_canvas_action_popUp_btn_cancel), 4);
        CommonDialog.a.f(r137, new l2(this), com.larus.utils.j0.e("larus_canvas_unsaved_exit_dialog_confirm"), false, 12);
        r137.f327197z = false;
        CommonDialog r139 = r137.c();
        LandscapeRestrictionOperation r140 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r139, "CanvasUnsavedExitDialog", r140);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r136, r139, r140) == true) goto L133;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L110
    L107:
        r139.show(r136, "CanvasUnsavedExitDialog");
        return;
    L133:
        return;
    L132:
        return;
    L108:
        m3();
        return;
    L90:
        r134 = false;
    L93:
        r135 = true;
        goto L94
    L82:
        if (((Collection) r132).isEmpty() == false) goto L84;
    L96:
        r102 = false;
        goto L97
    L52:
        r121 = 0;
    L48:
        r119 = null;
        goto L49
    L5:
        if (((Boolean) r101.f516410b.getValue()).booleanValue() != true) goto L7;
        r104 = true;
        goto L8
    }

    public final void H3(String r110) {
        o2 r100 = (o2) this.f323291r.getValue();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        String r103 = null;
        if (r110 == null) goto L17;
        n2 r104 = B3();
        if (r104 == null) goto L15;
        ky8.f r105 = r104.O30(r110);
    L16:
        if (r105 == null) goto L17;
    L29:
        IFlowSdkDepend r106 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r106 == null) goto L38;
        r106.D0();
        com.larus.home.impl.sdk.b1 r107 = com.larus.home.impl.sdk.b1.f346144a;
        r107.c("photoshop_page_download");
        if (r105 == null) goto L34;
        String r108 = r105.g();
    L35:
        if (r108 != null) goto L37;
        r108 = "";
    L37:
        r107.d(r108);
        goto L38
    L34:
        r108 = null;
    L38:
        o2 r109 = (o2) this.f323291r.getValue();
        if (r109 == null) goto L41;
        r109.RI(r110);
    L41:
        n2 r111 = B3();
        if (r111 == null) goto L73;
        kotlinx.coroutines.flow.i1<ky8.g> r112 = r111.bt();
        if (r112 == null) goto L73;
        ky8.g r113 = r112.getValue();
        if (r113 == null) goto L73;
        Map<String, ky8.h> r114 = r113.f506706a;
        if (r114 == null) goto L73;
        Collection<ky8.h> r115 = r114.values();
        if (r115 == null) goto L73;
        Iterator<T> r116 = r115.iterator();
        int r117 = 0;
    L53:
        if (r116.hasNext() == false) goto L71;
        Object r118 = r116.next();
        if (r117 >= 0) goto L57;
        CollectionsKt.throwIndexOverflow();
    L57:
        ky8.h r119 = (ky8.h) r118;
        if ((r119 instanceof ky8.f) == false) goto L60;
        ky8.f r120 = (ky8.f) r119;
    L61:
        if (r120 == null) goto L63;
        String r121 = r120.f506697a;
    L64:
        if (r105 == null) goto L66;
        String r122 = r105.f506697a;
    L68:
        if (Intrinsics.areEqual(r121, r122) == true) goto L72;
        r117 = r117 + 1;
    L72:
        Integer r123 = Integer.valueOf(r117);
    L74:
        com.larus.platform.service.o r124 = com.larus.platform.service.o.f365780a;
        JSONObject r125 = new JSONObject();
        my8.q r126 = p3();
        if (r126 == null) goto L77;
        String r127 = r126.b();
    L78:
        r125.putOpt("bot_id", r127);
        r125.putOpt("ai_create_show_mode", "pure");
        if (r105 == null) goto L81;
        String r128 = r105.j();
    L82:
        r125.putOpt("creation_task_id", r128);
        r125.putOpt("click_from", "click_download");
        r125.putOpt("click_method", "click_canvas_upper_download");
        if (r105 == null) goto L85;
        Long r129 = r105.d();
    L86:
        r125.putOpt("conversation_id", r129);
        r125.putOpt("enter_picture_method", "image_generate_canvas");
        r125.putOpt("has_original_image", 1);
        r125.putOpt("is_deep_thinking", 0);
        if (r105 == null) goto L89;
        AIBeautify r130 = r105.c();
    L90:
        if (r130 == null) goto L92;
        int r131 = 1;
    L93:
        r125.putOpt("is_image_edit", Integer.valueOf(r131));
        r125.putOpt("is_replica_gen", 0);
        if (r105 == null) goto L96;
        String r132 = r105.e();
    L97:
        r125.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r132);
        r125.putOpt("image_edit_function_id", C3(r105));
        if (r123 != null) goto L100;
    L106:
        n2 r133 = B3();
        if (r133 == null) goto L113;
        kotlinx.coroutines.flow.b1 r134 = r133.tx();
        if (r134 == null) goto L113;
        Pair r135 = (Pair) r134.getValue();
        if (r135 == null) goto L113;
        r123 = (Integer) r135.getFirst();
    L114:
        r125.putOpt("position", r123);
        r125.putOpt("user_type", "bot");
        r125.putOpt("is_search_card", 0);
        if (r105 == null) goto L119;
        UserCreationFromIM r136 = r105.f();
        if (r136 == null) goto L119;
        r103 = r136.getCreationId();
    L119:
        r125.putOpt("creation_id", r103);
        Unit r137 = Unit.INSTANCE;
        r124.reportEvent("picture_download", r125);
        return;
    L113:
        r123 = null;
        goto L114
    L100:
        if (r123.intValue() < 0) goto L102;
        r101 = true;
    L102:
        if (r101 == true) goto L105;
        r123 = null;
    L105:
        if (r123 != null) goto L114;
    L96:
        r132 = null;
        goto L97
    L92:
        r131 = 0;
        goto L93
    L89:
        r130 = null;
        goto L90
    L85:
        r129 = null;
        goto L86
    L81:
        r128 = null;
        goto L82
    L77:
        r127 = null;
        goto L78
    L66:
        r122 = null;
        goto L68
    L63:
        r121 = null;
        goto L64
    L60:
        r120 = null;
        goto L61
    L71:
        r117 = -1;
    L73:
        r123 = null;
        goto L74
    L15:
        r105 = null;
    L17:
        n2 r138 = B3();
        if (r138 == null) goto L24;
        kotlinx.coroutines.flow.b1 r139 = r138.tx();
        if (r139 == null) goto L24;
        Pair r140 = (Pair) r139.getValue();
        if (r140 == null) goto L24;
        ky8.h r141 = (ky8.h) r140.getSecond();
    L26:
        if ((r141 instanceof ky8.f) == false) goto L28;
        r105 = (ky8.f) r141;
        goto L29
    L28:
        r105 = null;
    L24:
        r141 = null;
        goto L26
    L5:
        if (r100.yp(r110) != true) goto L7;
        r102 = true;
        goto L8
    }
}
