package com.larus.avatar.impl.manager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.larus.avatar.impl.databinding.LarusDigitalAvatarManagerLayoutBinding;
import com.larus.avatar.impl.databinding.LarusDigitalAvatarManagerNewEntryLayoutBinding;
import com.larus.avatar.impl.scan.utils.EmptyPermissionFragment;
import com.larus.avatar.impl.upload.DigitalAvatarUploadActivity;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.home.impl.sdk.l1;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g3;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.service.k2;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDAbstractUpload;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import tx9.r0;
import v19.i5;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 h2\u00020\u0001:\u0001hB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002J\"\u0010;\u001a\u0002052\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\b\u0010?\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u000203H\u0002J\u0016\u0010D\u001a\u0002052\f\u0010E\u001a\b\u0012\u0004\u0012\u0002050FH\u0002J\u0010\u0010G\u001a\u0002052\u0006\u00109\u001a\u00020HH\u0002J\b\u0010I\u001a\u000205H\u0016J\u0010\u0010J\u001a\u0002052\u0006\u0010K\u001a\u00020LH\u0016J\u001a\u0010M\u001a\u0002052\u0006\u0010N\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u0010O\u001a\u0002052\b\u0010P\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010Q\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010R\u001a\u00020SH\u0016J\b\u0010T\u001a\u000205H\u0002J:\u0010U\u001a\u0002052\u0006\u0010V\u001a\u00020\u00162\u001a\u0010W\u001a\u0016\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020S\u0018\u00010X2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002050FH\u0002J\u0016\u0010Z\u001a\u0002052\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002050FH\u0002J2\u0010[\u001a\u0002052\u001a\u0010W\u001a\u0016\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020S\u0018\u00010X2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002050FH\u0002J4\u0010\\\u001a\u0002052$\u0010]\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010_\u0012\n\u0012\b\u0012\u0004\u0012\u0002050`\u0012\u0006\u0012\u0004\u0018\u00010a0^H\u0082@¢\u0006\u0002\u0010bJ\b\u0010c\u001a\u000205H\u0002J\u0018\u0010d\u001a\u0002052\u0006\u0010e\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u0016H\u0002J\u0016\u0010f\u001a\u0002052\f\u0010g\u001a\b\u0012\u0004\u0012\u0002050FH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\r\u001a\u0004\b)\u0010+¨\u0006i"}, d2 = {"Lcom/larus/avatar/impl/manager/DigitalAvatarManagerFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/avatar/impl/databinding/LarusDigitalAvatarManagerLayoutBinding;", "newEntryBinding", "Lcom/larus/avatar/impl/databinding/LarusDigitalAvatarManagerNewEntryLayoutBinding;", "viewModel", "Lcom/larus/avatar/impl/manager/DigitalAvatarManagerViewModel;", "getViewModel", "()Lcom/larus/avatar/impl/manager/DigitalAvatarManagerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "pickImagesLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "morePopupLastDismissTime", "", "morePopup", "Lcom/skydoves/balloon/Balloon;", "enterCreateFrom", "", "closeView", "Landroid/view/View;", "getCloseView", "()Landroid/view/View;", "avatarView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getAvatarView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarInfoView", "Landroidx/appcompat/widget/AppCompatTextView;", "getAvatarInfoView", "()Landroidx/appcompat/widget/AppCompatTextView;", "avatarInfoIconView", "Landroid/widget/FrameLayout;", "getAvatarInfoIconView", "()Landroid/widget/FrameLayout;", "avatarManagerBtn", "getAvatarManagerBtn", "isNewUiEnabled", "", "()Z", "isNewUiEnabled$delegate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "renderUi", "", "state", "Lcom/larus/avatar/impl/manager/DigitalAvatarUiState;", "handleEvent", "event", "Lcom/larus/avatar/impl/manager/DigitalAvatarEvent;", "openUploadWithPreGen", "preGenImages", "", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "replicaCreateId", "realGotoVideoRecordPage", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bundle", "checkVideoRecordPermission", "passBlk", "Lkotlin/Function0;", "showToast", "Lcom/larus/avatar/impl/manager/DigitalAvatarEvent$ShowToast;", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "showCameraMultiCaptureTips", "anchorView", WidgetCostModule.TYPE_ON_CREATE, "getTheme", "", "initParams", "showQuotaRemindDeleteDialog", "digitalAvatarId", "replicaTrainQuotaInfo", "Lkotlin/Triple;", "onConfirm", "showDeleteConfirmDialog", "showQuotaRemindReGenDialog", "getMainBotConversationInfo", "callback", "Lkotlin/Function2;", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLauncher", "openDigitalAvatarMenu", "hostView", "checkGalleryPermission", "doNext", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigitalAvatarManagerFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f290779k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDigitalAvatarManagerLayoutBinding f290780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusDigitalAvatarManagerNewEntryLayoutBinding f290781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f290782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f290783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Balloon f290784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f290785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f290786j;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f290787a = null;

        static {
            int[] r100 = new int[DigitalAvatarToastType.values().length];
            r100[DigitalAvatarToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DigitalAvatarToastType.FAILURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DigitalAvatarToastType.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f290787a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.avatar.impl.manager.DigitalAvatarManagerFragment$onViewCreated$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avatar.impl.manager.DigitalAvatarManagerFragment$onViewCreated$7", f = "DigitalAvatarManagerFragment.kt", i = {}, l = {BDAbstractUpload.KeyIsXQuicLibAvailable}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DigitalAvatarManagerFragment this$0;

        /* JADX INFO: renamed from: com.larus.avatar.impl.manager.DigitalAvatarManagerFragment$onViewCreated$7$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.avatar.impl.manager.DigitalAvatarManagerFragment$onViewCreated$7$1", f = "DigitalAvatarManagerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DigitalAvatarManagerFragment this$0;

            /* JADX INFO: renamed from: com.larus.avatar.impl.manager.DigitalAvatarManagerFragment$onViewCreated$7$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "com.larus.avatar.impl.manager.DigitalAvatarManagerFragment$onViewCreated$7$1$1", f = "DigitalAvatarManagerFragment.kt", i = {}, l = {431}, m = "invokeSuspend", n = {}, s = {})
            public static final class C39781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ DigitalAvatarManagerFragment this$0;

                /* JADX INFO: renamed from: com.larus.avatar.impl.manager.DigitalAvatarManagerFragment$onViewCreated$7$1$1$a */
                public static final class a<T> implements FlowCollector {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ DigitalAvatarManagerFragment f290788a;

                    public a(DigitalAvatarManagerFragment r100) {
                        this.f290788a = r100;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object r100, Continuation r110) {
                        e0 r101 = (e0) r100;
                        DigitalAvatarManagerFragment r111 = this.f290788a;
                        int r102 = DigitalAvatarManagerFragment.f290779k;
                        LarusDigitalAvatarManagerLayoutBinding r103 = r111.f290780d;
                        if (r103 == null) goto L5;
                        SimpleDraweeView r104 = r103.f290751f;
                    L6:
                        com.larus.uaigc.api.a r105 = r101.f290811a;
                        if (r105 == null) goto L9;
                        String r106 = r105.d();
                    L10:
                        ImageLoaderKt.u(r104, r106, "digital_avatar_icon");
                        LarusDigitalAvatarManagerLayoutBinding r107 = r111.f290780d;
                        if (r107 == null) goto L13;
                        AppCompatTextView r108 = r107.f290748c;
                    L15:
                        if (r108 != null) goto L17;
                    L28:
                        LarusDigitalAvatarManagerLayoutBinding r109 = r111.f290780d;
                        if (r109 == null) goto L31;
                        SimpleDraweeView r112 = r109.f290751f;
                    L32:
                        e1.d(r112, new o());
                        if (((Boolean) r111.f290786j.getValue()).booleanValue() == false) goto L125;
                        if (r101.f290814d == false) goto L41;
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r113 = r111.f290781e;
                        if (r113 == null) goto L46;
                        AppCompatImageView r114 = r113.f290756d;
                        if (r114 == null) goto L46;
                        e1.x(r114);
                    L46:
                        String r115 = (String) CollectionsKt.getOrNull(r101.f290813c, 0);
                        if (r115 == null) goto L60;
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r116 = r111.f290781e;
                        if (r116 == null) goto L53;
                        SimpleDraweeView r117 = r116.f290759g;
                        if (r117 == null) goto L53;
                        e1.x(r117);
                    L53:
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r118 = r111.f290781e;
                        if (r118 == null) goto L58;
                        SimpleDraweeView r119 = r118.f290759g;
                        if (r119 == null) goto L58;
                        ImageLoaderKt.u(r119, r115, "digital_avatar_icon");
                        Unit r120 = Unit.INSTANCE;
                    L59:
                        if (r120 == null) goto L60;
                    L65:
                        String r121 = (String) CollectionsKt.getOrNull(r101.f290813c, 1);
                        if (r121 == null) goto L79;
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r122 = r111.f290781e;
                        if (r122 == null) goto L72;
                        SimpleDraweeView r123 = r122.f290760h;
                        if (r123 == null) goto L72;
                        e1.x(r123);
                    L72:
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r124 = r111.f290781e;
                        if (r124 == null) goto L77;
                        SimpleDraweeView r125 = r124.f290760h;
                        if (r125 == null) goto L77;
                        ImageLoaderKt.u(r125, r121, "digital_avatar_icon");
                        Unit r126 = Unit.INSTANCE;
                    L78:
                        if (r126 == null) goto L79;
                    L84:
                        String r127 = (String) CollectionsKt.getOrNull(r101.f290813c, 2);
                        if (r127 == null) goto L98;
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r128 = r111.f290781e;
                        if (r128 == null) goto L91;
                        SimpleDraweeView r129 = r128.f290761i;
                        if (r129 == null) goto L91;
                        e1.x(r129);
                    L91:
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r130 = r111.f290781e;
                        if (r130 == null) goto L96;
                        SimpleDraweeView r131 = r130.f290761i;
                        if (r131 == null) goto L96;
                        ImageLoaderKt.u(r131, r127, "digital_avatar_icon");
                        Unit r132 = Unit.INSTANCE;
                    L97:
                        if (r132 == null) goto L98;
                    L104:
                        if (r101.f290815e == false) goto L110;
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r133 = r111.f290781e;
                        if (r133 == null) goto L115;
                        AppCompatTextView r134 = r133.f290757e;
                        if (r134 == null) goto L115;
                        e1.x(r134);
                    L115:
                        LarusDigitalAvatarManagerLayoutBinding r135 = r111.f290780d;
                        if (r135 == null) goto L125;
                        AppCompatTextView r136 = r135.f290750e;
                        if (r136 == null) goto L125;
                        ViewGroup.LayoutParams r137 = r136.getLayoutParams();
                        if (r137 == null) goto L123;
                        ViewGroup.MarginLayoutParams r138 = (ViewGroup.MarginLayoutParams) r137;
                        r138.topMargin = r111.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_20, null, R.dimen.larus_dp_20));
                        r136.setLayoutParams(r138);
                        goto L125
                    L123:
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    L110:
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r139 = r111.f290781e;
                        if (r139 == null) goto L115;
                        AppCompatTextView r140 = r139.f290757e;
                        if (r140 == null) goto L115;
                        e1.o(r140);
                    L96:
                        r132 = null;
                    L98:
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r141 = r111.f290781e;
                        if (r141 == null) goto L104;
                        SimpleDraweeView r142 = r141.f290761i;
                        if (r142 == null) goto L104;
                        e1.o(r142);
                        Unit r143 = Unit.INSTANCE;
                    L77:
                        r126 = null;
                    L79:
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r144 = r111.f290781e;
                        if (r144 == null) goto L84;
                        SimpleDraweeView r145 = r144.f290760h;
                        if (r145 == null) goto L84;
                        e1.o(r145);
                        Unit r146 = Unit.INSTANCE;
                    L58:
                        r120 = null;
                    L60:
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r147 = r111.f290781e;
                        if (r147 == null) goto L65;
                        SimpleDraweeView r148 = r147.f290759g;
                        if (r148 == null) goto L65;
                        e1.o(r148);
                        Unit r149 = Unit.INSTANCE;
                        goto L65
                    L41:
                        LarusDigitalAvatarManagerNewEntryLayoutBinding r150 = r111.f290781e;
                        if (r150 == null) goto L46;
                        AppCompatImageView r151 = r150.f290756d;
                        if (r151 == null) goto L46;
                        e1.o(r151);
                    L125:
                        return Unit.INSTANCE;
                    L31:
                        r112 = null;
                        goto L32
                    L17:
                        if (r101.f290812b.length() <= 0) goto L19;
                        boolean r152 = true;
                    L20:
                        if (r152 == false) goto L26;
                        StringBuilder r153 = new StringBuilder();
                        Context r154 = r111.getContext();
                        if (r154 == null) goto L24;
                        String r155 = r154.getString(R.string.larus_replica_bottomsheet_tag_time);
                    L25:
                        r153.append(r155);
                        r153.append(' ');
                        r153.append(r101.f290812b);
                        String r156 = r153.toString();
                    L27:
                        r108.setText(r156);
                        goto L28
                    L24:
                        r155 = null;
                        goto L25
                    L26:
                        r156 = "";
                        goto L27
                    L19:
                        r152 = false;
                        goto L20
                    L13:
                        r108 = null;
                        goto L15
                    L9:
                        r106 = null;
                        goto L10
                    L5:
                        r104 = null;
                        goto L6
                    }
                }

                public C39781(DigitalAvatarManagerFragment r100, Continuation<? super C39781> r101) {
                    this.this$0 = r100;
                    super(2, r101);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new C39781(this.this$0, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((C39781) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r102 = this.label;
                    if (r102 == 0) goto L8;
                    if (r102 != 1) goto L6;
                    ResultKt.throwOnFailure(r100);
                L12:
                    throw new KotlinNothingValueException();
                L6:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r100);
                    DigitalAvatarManagerFragment r103 = this.this$0;
                    int r104 = DigitalAvatarManagerFragment.f290779k;
                    i1<e0> r105 = r103.U90().getUiState();
                    a r106 = new a(this.this$0);
                    this.label = 1;
                    if (r105.collect(r106, this) != r101) goto L12;
                    return r101;
                }
            }

            /* JADX INFO: renamed from: com.larus.avatar.impl.manager.DigitalAvatarManagerFragment$onViewCreated$7$1$2, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "com.larus.avatar.impl.manager.DigitalAvatarManagerFragment$onViewCreated$7$1$2", f = "DigitalAvatarManagerFragment.kt", i = {}, l = {BDAbstractUpload.KeyIsRetryStatesOption}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ DigitalAvatarManagerFragment this$0;

                /* JADX INFO: renamed from: com.larus.avatar.impl.manager.DigitalAvatarManagerFragment$onViewCreated$7$1$2$a */
                public static final class a<T> implements FlowCollector {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ DigitalAvatarManagerFragment f290789a;

                    public a(DigitalAvatarManagerFragment r100) {
                        this.f290789a = r100;
                    }

                    /* JADX WARN: Type inference failed for: r0v23, types: [com.larus.avatar.impl.manager.j] */
                    /* JADX WARN: Type inference failed for: r0v38, types: [com.larus.avatar.impl.manager.s] */
                    /* JADX WARN: Type inference failed for: r3v32, types: [com.larus.avatar.impl.manager.r] */
                    /* JADX WARN: Type inference failed for: r3v37, types: [com.larus.avatar.impl.manager.q] */
                    /* JADX WARN: Type inference failed for: r4v31, types: [com.larus.avatar.impl.manager.p] */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object r210, Continuation r211) {
                        final com.larus.avatar.impl.manager.a r100 = (com.larus.avatar.impl.manager.a) r210;
                        final DigitalAvatarManagerFragment r101 = this.f290789a;
                        int r102 = DigitalAvatarManagerFragment.f290779k;
                        r101.getClass();
                        boolean r103 = true;
                        if ((r100 instanceof com.larus.avatar.impl.manager.a.f) == false) goto L20;
                        com.larus.avatar.impl.manager.a.f r104 = (com.larus.avatar.impl.manager.a.f) r100;
                        String r105 = r104.f290801a;
                        Triple<Integer, Integer, Integer> r106 = r104.f290802b;
                        ?? r107 = new p(r101, r100);
                        if (r106 == null) goto L7;
                        int r108 = r106.getFirst().intValue();
                    L8:
                        if (r106 == null) goto L10;
                        int r109 = r106.getSecond().intValue();
                    L11:
                        Context r110 = r101.getContext();
                        if (r110 != null) goto L17;
                        AppHost.Companion r111 = AppHost.f326268a;
                        Activity r112 = r111.a().getCurrentActivity();
                        if (r112 == null) goto L16;
                        Context r113 = r112;
                    L18:
                        CommonDialog.a r114 = new CommonDialog.a();
                        AppHost.Companion r115 = AppHost.f326268a;
                        r114.i(r115.getApplication().getString(R.string.larus_replica_popUp_delete));
                        r114.g(r115.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupDesc_generationFail) + r115.getApplication().getResources().getQuantityString(R.plurals.larus_replica_gen_msg_prompt2, r108, new Object[]{Integer.valueOf(r108)}) + r115.getApplication().getResources().getQuantityString(R.plurals.larus_replica_gen_msg_prompt3, r109, new Object[]{Integer.valueOf(r109)}));
                        f0 r116 = new f0(null, Integer.valueOf(ContextCompat.getColor(r113, R.color.larus_conditional_danger_50)), null, 5);
                        Intrinsics.checkNotNullParameter(r116, "commonDialogTextStyleConfig");
                        r114.D = r116;
                        f0 r117 = new f0(null, Integer.valueOf(ContextCompat.getColor(r113, v19.c.b(R.attr.larus_neutral_70, r113, R.color.larus_neutral_70))), null, 5);
                        Intrinsics.checkNotNullParameter(r117, "commonDialogTextStyleConfig");
                        r114.E = r117;
                        r114.h(ContextCompat.getColor(r113, v19.c.b(R.attr.larus_neutral_70, r113, R.color.larus_neutral_70)));
                        CommonDialog.a.f(r114, new y(r107), r115.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupBtn_delete), false, 12);
                        CommonDialog.a.e(r114, new z(), r115.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupBtn_cancel), 4);
                        DigitalAvatarManagerFragment.S90(r114.a(), r101.getChildFragmentManager());
                    L114:
                        return Unit.INSTANCE;
                    L16:
                        r110 = r111.getApplication();
                    L17:
                        r113 = r110;
                        goto L18
                    L10:
                        r109 = 0;
                        goto L11
                    L7:
                        r108 = 0;
                        goto L8
                    L20:
                        if ((r100 instanceof com.larus.avatar.impl.manager.a.e) == false) goto L29;
                        ?? r118 = new q(r101, r100);
                        Context r119 = r101.getContext();
                        if (r119 != null) goto L27;
                        AppHost.Companion r120 = AppHost.f326268a;
                        Activity r121 = r120.a().getCurrentActivity();
                        if (r121 == null) goto L26;
                        r119 = r121;
                        goto L27
                    L26:
                        r119 = r120.getApplication();
                    L27:
                        CommonDialog.a r122 = new CommonDialog.a();
                        AppHost.Companion r123 = AppHost.f326268a;
                        r122.i(r123.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupTitle_deleteReplica));
                        r122.g(r123.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupDesc_generationFail));
                        f0 r124 = new f0(null, Integer.valueOf(ContextCompat.getColor(r119, v19.c.b(R.attr.larus_neutral_100, r119, R.color.larus_neutral_100))), null, 5);
                        Intrinsics.checkNotNullParameter(r124, "commonDialogTextStyleConfig");
                        r122.D = r124;
                        f0 r125 = new f0(null, Integer.valueOf(ContextCompat.getColor(r119, v19.c.b(R.attr.larus_neutral_70, r119, R.color.larus_neutral_70))), null, 5);
                        Intrinsics.checkNotNullParameter(r125, "commonDialogTextStyleConfig");
                        r122.E = r125;
                        r122.h(ContextCompat.getColor(r119, v19.c.b(R.attr.larus_neutral_70, r119, R.color.larus_neutral_70)));
                        CommonDialog.a.f(r122, new w(r118), r123.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupBtn_delete), false, 12);
                        CommonDialog.a.e(r122, new x(), r123.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupBtn_cancel), 4);
                        DigitalAvatarManagerFragment.S90(r122.a(), r101.getChildFragmentManager());
                        goto L114
                    L29:
                        if ((r100 instanceof com.larus.avatar.impl.manager.a.g) == false) goto L42;
                        Triple<Integer, Integer, Integer> r126 = ((com.larus.avatar.impl.manager.a.g) r100).f290803a;
                        ?? r127 = new r(r101);
                        if (r126 == null) goto L33;
                        int r128 = r126.getFirst().intValue();
                    L34:
                        if (r126 == null) goto L36;
                        int r129 = r126.getSecond().intValue();
                    L37:
                        if (r129 != 0) goto L39;
                        t19.s r130 = t19.s.f544207a;
                        Context r131 = r101.getContext();
                        r130.getClass();
                        t19.s.s(r131, R.string.larus_replica_gen_msg_replica_limit);
                        goto L114
                    L39:
                        Context r132 = r101.getContext();
                        if (r132 == null) goto L114;
                        CommonDialog.a r133 = new CommonDialog.a();
                        AppHost.Companion r134 = AppHost.f326268a;
                        r133.i(r134.getApplication().getString(R.string.larus_replica_popUp_createNew));
                        r133.g(r134.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupDesc_generationFail) + r134.getApplication().getResources().getQuantityString(R.plurals.larus_replica_gen_msg_prompt2, r128, new Object[]{Integer.valueOf(r128)}) + r134.getApplication().getResources().getQuantityString(R.plurals.larus_replica_gen_msg_prompt3, r129, new Object[]{Integer.valueOf(r129)}));
                        f0 r135 = new f0(null, Integer.valueOf(ContextCompat.getColor(r132, R.color.larus_conditional_danger_50)), null, 5);
                        Intrinsics.checkNotNullParameter(r135, "commonDialogTextStyleConfig");
                        r133.D = r135;
                        f0 r136 = new f0(null, Integer.valueOf(ContextCompat.getColor(r132, v19.c.b(R.attr.larus_neutral_70, r101.getContext(), R.color.larus_neutral_70))), null, 5);
                        Intrinsics.checkNotNullParameter(r136, "commonDialogTextStyleConfig");
                        r133.E = r136;
                        r133.h(ContextCompat.getColor(r132, v19.c.b(R.attr.larus_neutral_70, r101.getContext(), R.color.larus_neutral_70)));
                        CommonDialog.a.f(r133, new a0(r127), r134.getApplication().getString(R.string.larus_replica_popUp_btn_createNew), false, 12);
                        CommonDialog.a.e(r133, new b0(), r134.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupBtn_cancel), 4);
                        DigitalAvatarManagerFragment.S90(r133.a(), r101.getChildFragmentManager());
                        goto L114
                    L36:
                        r129 = 0;
                        goto L37
                    L33:
                        r128 = 0;
                        goto L34
                    L42:
                        FragmentActivity r137 = null;
                        if (Intrinsics.areEqual(r100, com.larus.avatar.impl.manager.a.d.f290799a) == false) goto L46;
                        final ?? r138 = new s(r101);
                        k2 r139 = k2.f365755a;
                        g3.a.a(r101, null, false, null, false, new l(r138), 30);
                        goto L114
                    L46:
                        if ((r100 instanceof com.larus.avatar.impl.manager.a.b) == false) goto L55;
                        Context r140 = r101.getContext();
                        if (r140 == null) goto L114;
                        ActivityResultLauncher<Intent> r141 = r101.f290783g;
                        if (r141 == null) goto L114;
                        k2 r142 = k2.f365755a;
                        AlbumSettingConfig.a r143 = new AlbumSettingConfig.a();
                        r143.f365518d = ((com.larus.avatar.impl.manager.a.b) r100).f290796a;
                        r143.f365517c = true;
                        r143.f365539y = true;
                        r142.h(r140, r141, r143.a());
                        goto L114
                    L55:
                        if ((r100 instanceof com.larus.avatar.impl.manager.a.c) == false) goto L93;
                        com.larus.avatar.impl.manager.a.c r144 = (com.larus.avatar.impl.manager.a.c) r100;
                        List<ey9.k> r145 = r144.f290797a;
                        String r146 = r144.f290798b;
                        final Context r147 = r101.getContext();
                        if (r147 == null) goto L114;
                        String r148 = GsonProtectorUtils.toJson(new Gson(), r145);
                        final Bundle r149 = new Bundle();
                        r149.putString("pre_gen_images", r148);
                        r149.putBoolean("is_regenerate_replica", true);
                        r149.putString("enter_create_from", r101.f290785i);
                        r149.putString("previous_page", "chat");
                        if (r146 != null) goto L62;
                        r146 = fy9.a.a();
                    L62:
                        r149.putString("replica_create_id", r146);
                        if (IUgcAIGCService.f373945a.v() == false) goto L65;
                        String r150 = BasicTestActionHandler.TEST_ACTION_RESET;
                    L66:
                        r149.putString("scene", r150);
                        r149.putString("enter_method", "personal_homepage_portfolio");
                        IFlowSdkDepend r151 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
                        if (r151 == null) goto L73;
                        r151.H();
                        VideoPortraitConfig r152 = l1.f346198a.a();
                        if (r152 == null) goto L73;
                        if (r152.getEnableVideoAvatar() != true) goto L73;
                    L74:
                        if (r103 == false) goto L89;
                        final ?? r153 = new j(r101, r147, r149);
                        Activity r154 = AppHost.f326268a.a().getCurrentActivity();
                        if ((r154 instanceof FragmentActivity) == false) goto L78;
                        r137 = (FragmentActivity) r154;
                    L78:
                        if (r137 == null) goto L114;
                        int r155 = EmptyPermissionFragment.f291128f;
                        Function1<? super Boolean, Unit> r156 = new m(r153);
                        Intrinsics.checkNotNullParameter(r156, "callback");
                        EmptyPermissionFragment r157 = new EmptyPermissionFragment();
                        r157.f291129d = r156;
                        Result.Companion r158 = Result.Companion;     // Catch: Throwable -> L87
                        FragmentTransaction r159 = r137.getSupportFragmentManager().beginTransaction();     // Catch: Throwable -> L87
                        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r159, r157, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "EmptyPermissionFragment", 0) == true) goto L85;
                        r159 = r159.add(r157, "EmptyPermissionFragment");     // Catch: Throwable -> L87
                    L85:
                        Result.m9449constructorimpl(Integer.valueOf(r159.commitAllowingStateLoss()));     // Catch: Throwable -> L87
                    L87:
                        th = move-exception;
                        Result.Companion r160 = Result.Companion;
                        Result.m9449constructorimpl(ResultKt.createFailure(th));
                        goto L114
                    L89:
                        FragmentActivity r161 = r101.getActivity();
                        if (r161 == null) goto L114;
                        Intent r162 = new Intent();
                        r162.setClass(r147, DigitalAvatarUploadActivity.class);
                        r162.putExtras(r149);
                        r161.startActivityForResult(r162, 100);
                    L73:
                        r103 = false;
                        goto L74
                    L65:
                        r150 = "create";
                        goto L66
                    L93:
                        if ((r100 instanceof com.larus.avatar.impl.manager.a.h) == false) goto L109;
                        com.larus.avatar.impl.manager.a.h r163 = (com.larus.avatar.impl.manager.a.h) r100;
                        Context r164 = r101.getContext();
                        if (r164 != null) goto L97;
                        r164 = AppHost.f326268a.getApplication();
                    L97:
                        int r165 = b.f290787a[r163.getType().ordinal()];
                        if (r165 != 1) goto L100;
                        t19.s r166 = t19.s.f544207a;
                        int r167 = r163.f290804a;
                        r166.getClass();
                        t19.s.o(r164, r167, false);
                        goto L114
                    L100:
                        if (r165 != 2) goto L102;
                        t19.s r168 = t19.s.f544207a;
                        int r169 = r163.f290804a;
                        r168.getClass();
                        t19.s.b(r164, r169, false);
                        goto L114
                    L102:
                        if (r165 != 3) goto L105;
                        t19.s r170 = t19.s.f544207a;
                        int r171 = r163.f290804a;
                        r170.getClass();
                        t19.s.s(r164, r171);
                        goto L114
                    L105:
                        throw new NoWhenBranchMatchedException();
                    L109:
                        if (Intrinsics.areEqual(r100, com.larus.avatar.impl.manager.a.C3979a.f290795a) == false) goto L116;
                        FragmentActivity r172 = r101.getActivity();
                        if (r172 == null) goto L114;
                        r172.finish();
                        goto L114
                    L116:
                        throw new NoWhenBranchMatchedException();
                    }
                }

                public AnonymousClass2(DigitalAvatarManagerFragment r100, Continuation<? super AnonymousClass2> r101) {
                    this.this$0 = r100;
                    super(2, r101);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new AnonymousClass2(this.this$0, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r102 = this.label;
                    if (r102 == 0) goto L8;
                    if (r102 != 1) goto L6;
                    ResultKt.throwOnFailure(r100);
                L12:
                    throw new KotlinNothingValueException();
                L6:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r100);
                    DigitalAvatarManagerFragment r103 = this.this$0;
                    int r104 = DigitalAvatarManagerFragment.f290779k;
                    d1<com.larus.avatar.impl.manager.a> r105 = r103.U90().getEventFlow();
                    a r106 = new a(this.this$0);
                    this.label = 1;
                    if (r105.collect(r106, this) != r101) goto L12;
                    return r101;
                }
            }

            public AnonymousClass1(DigitalAvatarManagerFragment r100, Continuation<? super AnonymousClass1> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                AnonymousClass1 r102 = new AnonymousClass1(this.this$0, r101);
                r102.L$0 = r100;
                return r102;
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
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r100);
                CoroutineScope r101 = (CoroutineScope) this.L$0;
                BuildersKt.launch$default(r101, null, null, new C39781(this.this$0, null), 3, null);
                BuildersKt.launch$default(r101, null, null, new AnonymousClass2(this.this$0, null), 3, null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass7(DigitalAvatarManagerFragment r100, Continuation<? super AnonymousClass7> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass7(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass7) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            LifecycleOwner r103 = this.this$0.getViewLifecycleOwner();
            Lifecycle.State r104 = Lifecycle.State.STARTED;
            AnonymousClass1 r105 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r103, r104, r105, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    public final DigitalAvatarManagerViewModel U90() {
        return (DigitalAvatarManagerViewModel) this.f290782f.getValue();
    }

    public DigitalAvatarManagerFragment() {
        this.f290782f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DigitalAvatarManagerViewModel.class), new DigitalAvatarManagerFragment$special$$inlined$activityViewModels$default$1(this), new DigitalAvatarManagerFragment$special$$inlined$activityViewModels$default$2(this));
        this.f290786j = LazyKt.lazy(new n());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f290780d = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        U90().fetchDigitalAvatarInfo();
        this.f290783g = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(this));
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        String r102 = r101.getString("enter_create_from", "");
    L6:
        this.f290785i = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r100);     // Catch: Throwable -> L7
        FragmentActivity r101 = getActivity();     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.finish();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static void S90(CommonDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, null, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, null);
    }

    public final void V90(View r110, final String r111) {
        r0.f("replica", "replica_manage");
        ViewGroup.MarginLayoutParams r100 = null;
        View r101 = LayoutInflater.from(r110.getContext()).inflate(R.layout.larus_digital_avatar_manager_action_layout, null);
        ((ConstraintLayout) r101.findViewById(R.id.digital_avatar_regenerate_item)).setOnClickListener(new g(this));
        ((ConstraintLayout) r101.findViewById(R.id.digital_avatar_delete_item)).setOnClickListener(new h(this, r111));
        com.larus.bmhome.view.screenmenu.d r102 = com.larus.bmhome.view.screenmenu.d.f317270a;
        Intrinsics.checkNotNull(r101);
        Balloon r112 = com.larus.bmhome.view.screenmenu.d.a(r102, r110, r101, false, null, null, null, null, 120);
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        r100 = (ViewGroup.MarginLayoutParams) r103;
    L5:
        if (r100 == null) goto L8;
        r100.setMarginEnd(-i5.r0());
    L8:
        this.f290784h = r112;
        r112.r(new i(this));
        Context r113 = getContext();
        if (r113 == null) goto L13;
        boolean r104 = true;
        if (com.larus.utils.i.h(r113) != true) goto L13;
    L14:
        if (r104 == false) goto L18;
        Balloon r114 = this.f290784h;
        if (r114 == null) goto L22;
        r114.v(r110, 0, 0);
        return;
    L22:
        return;
    L18:
        Balloon r115 = this.f290784h;
        if (r115 == null) goto L24;
        r115.s(r110, 0, 0);
        return;
    L24:
        return;
    L13:
        r104 = false;
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        if (r102 == null) goto L5;
        r102.setOnShowListener(new t());
    L5:
        LarusDigitalAvatarManagerLayoutBinding r103 = this.f290780d;
        if (r103 == null) goto L8;
        AppCompatImageView r104 = r103.f290752g;
    L9:
        if (r104 == null) goto L12;
        e1.d(r104, new u(this));
    L12:
        if (((Boolean) this.f290786j.getValue()).booleanValue() == false) goto L34;
        LarusDigitalAvatarManagerLayoutBinding r105 = this.f290780d;
        if (r105 == null) goto L16;
        RoundTextView r106 = r105.f290749d;
    L17:
        if (r106 == null) goto L19;
        r106.setVisibility(8);
    L19:
        LarusDigitalAvatarManagerNewEntryLayoutBinding r107 = this.f290781e;
        if (r107 == null) goto L24;
        RoundLinearLayout r108 = r107.f290753a;
        if (r108 == null) goto L24;
        r108.setVisibility(0);
    L24:
        LarusDigitalAvatarManagerNewEntryLayoutBinding r109 = this.f290781e;
        if (r109 == null) goto L29;
        ConstraintLayout r110 = r109.f290755c;
        if (r110 == null) goto L29;
        e1.d(r110, new v(this));
    L29:
        LarusDigitalAvatarManagerNewEntryLayoutBinding r111 = this.f290781e;
        if (r111 == null) goto L51;
        LinearLayout r112 = r111.f290754b;
        if (r112 == null) goto L51;
        e1.d(r112, new d(this));
    L51:
        LarusDigitalAvatarManagerLayoutBinding r113 = this.f290780d;
        if (r113 == null) goto L54;
        FrameLayout r114 = r113.f290747b;
    L55:
        if (r114 == null) goto L57;
        e1.d(r114, new f(this));
    L57:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass7(this, null), 3, null);
        return;
    L54:
        r114 = null;
        goto L55
    L16:
        r106 = null;
        goto L17
    L34:
        LarusDigitalAvatarManagerLayoutBinding r115 = this.f290780d;
        if (r115 == null) goto L37;
        RoundTextView r116 = r115.f290749d;
    L38:
        if (r116 == null) goto L40;
        r116.setVisibility(0);
    L40:
        LarusDigitalAvatarManagerNewEntryLayoutBinding r117 = this.f290781e;
        if (r117 == null) goto L45;
        RoundLinearLayout r118 = r117.f290753a;
        if (r118 == null) goto L45;
        r118.setVisibility(8);
    L45:
        LarusDigitalAvatarManagerLayoutBinding r119 = this.f290780d;
        if (r119 == null) goto L48;
        RoundTextView r120 = r119.f290749d;
    L49:
        if (r120 == null) goto L51;
        e1.d(r120, new e(this));
        goto L51
    L48:
        r120 = null;
        goto L49
    L37:
        r116 = null;
        goto L38
    L8:
        r104 = null;
        goto L9
    }

    public static final Object T90(DigitalAvatarManagerFragment r100, Function2 r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof DigitalAvatarManagerFragment$getMainBotConversationInfo$1) == false) goto L7;
        DigitalAvatarManagerFragment$getMainBotConversationInfo$1 r103 = (DigitalAvatarManagerFragment$getMainBotConversationInfo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (Function2) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        wc9.e r108 = (wc9.e) r105;
    L25:
        r103.L$0 = null;
        r103.label = 2;
        if (r101.invoke(r108, r103) != r106) goto L29;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        ILaunchCacheService r109 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r109 == null) goto L21;
        r108 = r109.b();
        if (r108 != null) goto L25;
    L21:
        Flow r110 = FlowLiveDataConversions.asFlow(AuthModelDelegate.f297134b.y());
        DigitalAvatarManagerFragment$getMainBotConversationInfo$cvs$2 r111 = new DigitalAvatarManagerFragment$getMainBotConversationInfo$cvs$2(null);
        r103.L$0 = r101;
        r103.label = 1;
        r105 = kotlinx.coroutines.flow.e.t(r110, r111, r103);
        if (r105 != r106) goto L24;
        return r106;
    L7:
        r103 = new DigitalAvatarManagerFragment$getMainBotConversationInfo$1(r100, r102);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r211, Bundle r212) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.larus_digital_avatar_manager_layout, r211, false);
        int r101 = R.id.avatar_info_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.avatar_info_container)) == null) goto L47;
        r101 = R.id.avatar_info_icon_view;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.avatar_info_icon_view);
        if (r102 == null) goto L47;
        r101 = R.id.avatar_info_view;
        AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.avatar_info_view);
        if (r103 == null) goto L47;
        r101 = R.id.avatar_manager_btn;
        RoundTextView r104 = (RoundTextView) ViewBindings.findChildViewById(r100, R.id.avatar_manager_btn);
        if (r104 == null) goto L47;
        r101 = R.id.avatar_title_view;
        AppCompatTextView r110 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.avatar_title_view);
        if (r110 == null) goto L47;
        r101 = R.id.avatar_view;
        SimpleDraweeView r111 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.avatar_view);
        if (r111 == null) goto L47;
        r101 = R.id.close_view;
        AppCompatImageView r112 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.close_view);
        if (r112 == null) goto L47;
        r101 = R.id.digital_avatar_new_entry_layout;
        View r105 = ViewBindings.findChildViewById(r100, R.id.digital_avatar_new_entry_layout);
        if (r105 == null) goto L47;
        int r106 = R.id.digital_avatar_manage_entry;
        LinearLayout r113 = (LinearLayout) ViewBindings.findChildViewById(r105, R.id.digital_avatar_manage_entry);
        if (r113 == null) goto L45;
        r106 = R.id.digital_avatar_material_entry;
        ConstraintLayout r114 = (ConstraintLayout) ViewBindings.findChildViewById(r105, R.id.digital_avatar_material_entry);
        if (r114 == null) goto L45;
        r106 = R.id.iv_manage_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r105, R.id.iv_manage_icon)) == null) goto L45;
        r106 = R.id.iv_material_arrow;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r105, R.id.iv_material_arrow)) == null) goto L45;
        r106 = R.id.iv_material_arrow_2;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r105, R.id.iv_material_arrow_2)) == null) goto L45;
        r106 = R.id.iv_material_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r105, R.id.iv_material_icon)) == null) goto L45;
        r106 = R.id.material_red_dot;
        AppCompatImageView r115 = (AppCompatImageView) ViewBindings.findChildViewById(r105, R.id.material_red_dot);
        if (r115 == null) goto L45;
        r106 = R.id.take_video_hint;
        AppCompatTextView r116 = (AppCompatTextView) ViewBindings.findChildViewById(r105, R.id.take_video_hint);
        if (r116 == null) goto L45;
        r106 = R.id.thumbnail_avatar_container;
        FrameLayout r117 = (FrameLayout) ViewBindings.findChildViewById(r105, R.id.thumbnail_avatar_container);
        if (r117 == null) goto L45;
        r106 = R.id.thumbnail_avatar_left;
        SimpleDraweeView r213 = (SimpleDraweeView) ViewBindings.findChildViewById(r105, R.id.thumbnail_avatar_left);
        if (r213 == null) goto L45;
        r106 = R.id.thumbnail_avatar_mid;
        SimpleDraweeView r214 = (SimpleDraweeView) ViewBindings.findChildViewById(r105, R.id.thumbnail_avatar_mid);
        if (r214 == null) goto L45;
        r106 = R.id.thumbnail_avatar_right;
        SimpleDraweeView r215 = (SimpleDraweeView) ViewBindings.findChildViewById(r105, R.id.thumbnail_avatar_right);
        if (r215 == null) goto L45;
        LarusDigitalAvatarManagerNewEntryLayoutBinding r107 = new LarusDigitalAvatarManagerNewEntryLayoutBinding((RoundLinearLayout) r105, r113, r114, r115, r116, r117, r213, r214, r215);
        RoundConstraintLayout r108 = (RoundConstraintLayout) r100;
        this.f290780d = new LarusDigitalAvatarManagerLayoutBinding(r108, r102, r103, r104, r110, r111, r112, r107);
        this.f290781e = r107;
        return r108;
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(r105.getResources().getResourceName(r106)));
    L47:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
