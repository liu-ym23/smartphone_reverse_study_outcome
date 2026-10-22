package com.larus.bmhome.chat.component.fastsend;

import android.app.Dialog;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Insets;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.keyframes.model.KFAnimation;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.home.impl.sdk.c1;
import com.larus.home.impl.sdk.h2;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g3;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.k2;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v19.e6;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u009a\u00012\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002\u009a\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010c\u001a\u00020aH\u0002J\b\u0010d\u001a\u00020\u0007H\u0002J\b\u0010g\u001a\u00020aH\u0016J\b\u0010h\u001a\u00020aH\u0016J\n\u0010i\u001a\u0004\u0018\u00010jH\u0002J\u0016\u0010k\u001a\u00020a2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020a0fH\u0002J\u0010\u0010m\u001a\u00020a2\u0006\u0010n\u001a\u00020EH\u0002J\b\u0010q\u001a\u00020aH\u0016J\u0010\u0010u\u001a\u00020a2\u0006\u0010v\u001a\u00020\u0007H\u0016J\u0010\u0010w\u001a\u00020a2\u0006\u0010x\u001a\u00020\u0007H\u0002J\u0010\u0010y\u001a\u00020a2\u0006\u0010n\u001a\u00020EH\u0016J\u0010\u0010z\u001a\u00020a2\u0006\u0010{\u001a\u00020\u0007H\u0002J\f\u0010|\u001a\u00020\u0007*\u00020}H\u0002J\u0010\u0010~\u001a\u00020a2\u0006\u0010n\u001a\u00020EH\u0016J\u001a\u0010\u007f\u001a\u00020a2\u0007\u0010\u0080\u0001\u001a\u00020\\2\u0007\u0010\u0081\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0083\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0084\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020a2\u0006\u0010v\u001a\u00020\u0007H\u0002J\t\u0010\u0087\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0088\u0001\u001a\u00020\\H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020a2\u0007\u0010\u0080\u0001\u001a\u00020\\H\u0016J\t\u0010\u008a\u0001\u001a\u00020\\H\u0016J\t\u0010\u008b\u0001\u001a\u00020\\H\u0002J\u001a\u0010\u008c\u0001\u001a\u00020a2\u0007\u0010\u008d\u0001\u001a\u00020E2\u0006\u0010v\u001a\u00020\u0007H\u0002J\t\u0010\u008e\u0001\u001a\u00020aH\u0016J\n\u0010\u0091\u0001\u001a\u00030\u0090\u0001H\u0002J\u000b\u0010\u0092\u0001\u001a\u0004\u0018\u00010\tH\u0016J\t\u0010\u0093\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0094\u0001\u001a\u00020\u0007H\u0016J\u0014\u0010\u0095\u0001\u001a\u00020a2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010jH\u0016J\t\u0010\u0097\u0001\u001a\u00020aH\u0016J\u0013\u0010\u0098\u0001\u001a\u00020a2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016J\u0015\u0010\u0099\u0001\u001a\u00020\u00072\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000f\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000f\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000f\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u000f\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u000f\u001a\u0004\b9\u0010:R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010>\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u000f\u001a\u0004\b?\u0010@R\u0012\u0010B\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010CR\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010F\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010CR\u000e\u0010G\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u000f\u001a\u0004\bJ\u0010KR\u001b\u0010M\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bN\u0010@R\u001d\u0010Q\u001a\u0004\u0018\u00010R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u000f\u001a\u0004\bS\u0010TR\u000e\u0010V\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010X\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u000f\u001a\u0004\bY\u0010@R\u0012\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0004\n\u0002\u0010]R\u001a\u0010^\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020a0_X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010b\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020a0_X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010e\u001a\b\u0012\u0004\u0012\u00020a0fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010o\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010@\"\u0004\bq\u0010rR\u0012\u0010s\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0004\n\u0002\u0010]R\u000e\u0010t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009b\u0001"}, d2 = {"Lcom/larus/bmhome/chat/component/fastsend/FastSendImageComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "<init>", "()V", "isAlbumShown", "", "albumFragment", "Lcom/larus/platform/api/IBottomPhotoPickerPage;", "multimodalAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalAbility$delegate", "Lkotlin/Lazy;", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "referenceMsgAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getReferenceMsgAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "referenceMsgAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "attachmentAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentAbility$delegate", "suggestedActionAbility", "Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "getSuggestedActionAbility", "()Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "suggestedActionAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "settingsConfig", "Lcom/larus/platform/model/album/FastSendImageConfig;", "enableFastSendAccessibilityOpt", "getEnableFastSendAccessibilityOpt", "()Z", "enableFastSendAccessibilityOpt$delegate", "albumHasImage", "Ljava/lang/Boolean;", "bottomAlbumDisplayType", "", "accessibilityEnabledCache", "enableChatTab", "fastSendImageComponentDelegate", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageComponentDelegateAbility;", "getFastSendImageComponentDelegate", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageComponentDelegateAbility;", "fastSendImageComponentDelegate$delegate", "enableFastSend", "getEnableFastSend", "enableFastSend$delegate", "Lcom/larus/bmhome/chat/component/util/CombinedLazy;", "fastSendImageConfig", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendConfigAbility;", "getFastSendImageConfig", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendConfigAbility;", "fastSendImageConfig$delegate", "albumHasDestroy", "sharedQuickAlbumInput", "peekHeightFallbackFix", "getPeekHeightFallbackFix", "peekHeightFallbackFix$delegate", "bottomAlbumInitHeight", "", "Ljava/lang/Integer;", "albumResultCallback", "Lkotlin/Function1;", "Lcom/larus/platform/AlbumMultiSelectItem;", "", "albumMultiResultCallback", "switchBackToModifyInputFromFastAlbum", "isFastAlbumInBottom", "dismissCallback", "Lkotlin/Function0;", "onAttach", "onResume", "getLatestPhotoUri", "Landroid/net/Uri;", "updateAlbumHasImage", "onNext", "updateBottomAlbumAfterPermission", "from", "forceDayMode", "getForceDayMode", "setForceDayMode", "(Z)V", "pendingPeekHeight", "pendingAnimEnd", "showBottomAlbum", "needAnim", "setAlbumWindowFocusable", "focusable", "dismissBottomAlbum", "checkIfNeedManualCloseBottomMenu", "isFromIme", "isSystemSmallWindow", "Landroidx/fragment/app/Fragment;", "hideBottomAlbum", "updatePeekHeight", "height", "isAnimEnd", "isChatTabShow", "isAlbumExitInBottom", "isEnableFastSend", "isAccessibilityEnabledForFastSend", "showBottomAlbumInternal", "getFastSendEnable", "getBottomAlbumSpaceHeightForBottomMenu", "setBottomAlbumInitHeight", "getBottomAlbumInitHeightForBottomMenu", "getBottomAlbumInitHeight", "showAlbumFragment", "displayType", "onFragmentViewDestroyed", "traceInfo", "Lcom/larus/platform/model/album/AlbumTraceInfo;", "getTraceInfo", "getBottomAlbumFragment", "isAlbumExit", "isInjectInputAlbumShowing", "onAttachmentDeleted", "uri", "clearAllSelectedResources", "setAlbumTraceInfo", "enableFastAlbumMultiSelect", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FastSendImageComponent extends ComponentFeature implements e0 {
    public static final /* synthetic */ KProperty<Object>[] M = null;
    public final Lazy A;
    public boolean B;
    public boolean C;
    public final Lazy D;
    public Integer E;
    public final z F;
    public final a0 G;
    public final b0 H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Integer f300690J;
    public boolean K;
    public kq9.e L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f300691h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.larus.platform.api.a0 f300692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f300693j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f300694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f300695l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f300696m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f300697n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f300698o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f300699p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f300700q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f300701r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final kq9.p f300702s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f300703t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Boolean f300704u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f300705v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Boolean f300706w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f300707x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f300708y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ce8.b f300709z;

    public static final class a {
    }

    public static final class b implements Function0<f0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f300710a;

        public b(AttachReceiver r100) {
            this.f300710a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.fastsend.f0, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final f0 invoke() {
            AttachReceiver r100 = this.f300710a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(f0.class));
        }
    }

    public static final class c implements Function0<d0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f300711a;

        public c(AttachReceiver r100) {
            this.f300711a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.fastsend.d0, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final d0 invoke() {
            AttachReceiver r100 = this.f300711a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(d0.class));
        }
    }

    static {
        M = new KProperty[]{Reflection.property1(new PropertyReference1Impl(FastSendImageComponent.class, "enableFastSend", "getEnableFastSend()Z", 0))};
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        this.f300704u = null;
        this.f300706w = null;
        if (Intrinsics.areEqual(this.f300705v, "no_permission") == false) goto L17;
        com.larus.platform.api.a0 r100 = this.f300692i;
        if (r100 == null) goto L11;
        Fragment r101 = r100.od();
        if (r101 == null) goto L11;
        boolean r102 = true;
        if (r101.isAdded() != true) goto L11;
    L12:
        if (r102 == false) goto L18;
        k2 r103 = k2.f365755a;
        if (g3.a.d() == false) goto L19;
        h3("onResume");
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r102 = false;
        goto L12
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final void qD() {
        this.I = true;
    }

    public final int L2() {
        Integer r100 = this.E;
        if (r100 == null) goto L9;
        if (r100.intValue() <= 0) goto L9;
        FLogger.f375446a.i("FastSendImageComponent", "getBottomAlbumInitHeight is " + r100);
        return r100.intValue() + i5.y0(v19.c.b(R.attr.larus_dp_23, null, R.dimen.larus_dp_23));
    L9:
        if (xX() == true) goto L13;
        return 0;
    L13:
        return i5.y0(v19.c.b(R.attr.larus_dp_220, null, R.dimen.larus_dp_220));
    }

    public final ICoreInputAbility P2() {
        return (ICoreInputAbility) this.f300694k.getValue();
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final boolean S0() {
        if (this.f300691h == true) goto L5;
        return false;
    L5:
        com.larus.platform.api.a0 r100 = this.f300692i;
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r100.S0() != true) goto L12;
        return true;
    L12:
        return false;
    }

    public final kq9.e U2() {
        kq9.e r100 = this.L;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.platform.model.album.AlbumTraceInfo");
        return r100;
    L6:
        ChatControlTrace r101 = ChatControlTrace.f309996b;
        r101.getClass();
        com.larus.bmhome.chat.trace.a r102 = r101.gc(ChatControlTrace.f310027y);
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("getTraceInfo chatKey=");
        r104.append(ChatControlTrace.f310027y);
        r104.append(", botId=");
        String r105 = null;
        if (r102 == null) goto L9;
        String r106 = r102.f310079a;
    L10:
        r104.append(r106);
        r104.append(", conversationId=");
        if (r102 == null) goto L13;
        String r107 = r102.f310085g;
    L14:
        r104.append(r107);
        r104.append(", botConversationType=");
        if (r102 == null) goto L17;
        Integer r108 = r102.f310082d;
    L18:
        r104.append(r108);
        r103.d("FastSendImageComponent", r104.toString());
        if (r102 == null) goto L21;
        String r109 = r102.f310079a;
    L22:
        if (r102 == null) goto L24;
        String r110 = r102.f310085g;
    L25:
        if (r102 == null) goto L29;
        Integer r111 = r102.f310082d;
        if (r111 == null) goto L29;
        int r112 = r111.intValue();
    L30:
        String r113 = r101.h(ChatControlTrace.f310027y);
        if (r102 == null) goto L33;
        String r114 = r102.f310088j;
    L34:
        com.larus.bmhome.chat.component.bottom.reference.a r115 = (com.larus.bmhome.chat.component.bottom.reference.a) this.f300697n.getValue();
        if (r115 == null) goto L37;
        String r116 = r115.wf();
    L38:
        com.larus.bmhome.chat.component.bottom.reference.a r117 = (com.larus.bmhome.chat.component.bottom.reference.a) this.f300697n.getValue();
        if (r117 == null) goto L44;
        ReferenceInfo r118 = r117.T6();
        if (r118 == null) goto L44;
        r105 = r118.referencedMessageId;
    L44:
        return new kq9.e(r109, r110, r112, r113, r114, "chat_album_preview_click", r116, r105, null, null, null, null, 3840);
    L37:
        r116 = null;
        goto L38
    L33:
        r114 = null;
    L29:
        r112 = 0;
        goto L30
    L24:
        r110 = null;
        goto L25
    L21:
        r109 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final boolean bx() {
        if (this.f300691h == false) goto L5;
    L8:
        com.larus.platform.api.a0 r100 = this.f300692i;
        if (r100 == null) goto L13;
        return r100.H10();
    L13:
        return !this.B;
    L5:
        if (this.B == false) goto L8;
        return false;
    }

    public final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.f300696m.getValue();
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final void wd() {
        com.larus.platform.api.a0 r100 = this.f300692i;
        if (r100 == null) goto L6;
        r100.n60();
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final boolean xX() {
        ce8.b r100 = this.f300709z;
        KProperty<Object> r101 = M[0];
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Object r102 = r100.f23468a.invoke();
        if (r100.f23469b.invoke((T) r100.f23470c.getValue(), (D) r102).booleanValue() == true) goto L5;
        return false;
    L5:
        if (((Boolean) this.f300703t.getValue()).booleanValue() == true) goto L10;
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r103 == null) goto L9;
        r103.S();
        boolean r104 = c1.f346148a.a();
    L18:
        if (r104 == true) goto L22;
        return true;
    L22:
        return false;
    L9:
        r104 = false;
        goto L18
    L10:
        Boolean r105 = this.f300706w;
        if (r105 == null) goto L13;
        r104 = r105.booleanValue();
        goto L18
    L13:
        IFlowSdkDepend r106 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r106 == null) goto L16;
        r106.S();
        r104 = c1.f346148a.a();
    L17:
        this.f300706w = Boolean.valueOf(r104);
        goto L18
    L16:
        r104 = false;
        goto L17
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, e0.class);
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [com.larus.bmhome.chat.component.fastsend.z] */
    /* JADX WARN: Type inference failed for: r0v29, types: [com.larus.bmhome.chat.component.fastsend.a0] */
    /* JADX WARN: Type inference failed for: r0v30, types: [com.larus.bmhome.chat.component.fastsend.b0] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.bmhome.chat.component.fastsend.v] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.bmhome.chat.component.fastsend.w] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.bmhome.chat.component.fastsend.x] */
    public FastSendImageComponent() {
        this.f300693j = LazyKt.lazy(new u(this));
        this.f300694k = LazyKt.lazy(new com.larus.bmhome.chat.component.fastsend.b(this));
        this.f300695l = LazyKt.lazy(new com.larus.bmhome.chat.component.fastsend.c(this));
        this.f300696m = LazyKt.lazy(new d(this));
        this.f300697n = LazyKt.lazy(new e(this));
        this.f300698o = LazyKt.lazy(new f(this));
        this.f300699p = LazyKt.lazy(new g(this));
        this.f300700q = LazyKt.lazy(new h(this));
        this.f300701r = LazyKt.lazy(new i(this));
        z2 r100 = z2.f365865a;
        this.f300702s = r100.n1();
        this.f300703t = LazyKt.lazy(new j());
        this.f300707x = r100.enableChatWithTab();
        this.f300708y = LazyKt.lazy(new b(this));
        this.f300709z = new ce8.b(new v(this), new w(this), new x());
        this.A = LazyKt.lazy(new c(this));
        this.B = true;
        this.D = LazyKt.lazy(new y());
        this.F = new z(this);
        this.G = new a0(this);
        this.H = new b0(this);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        W20("onFragmentViewDestroyed");
    }

    public final f1 N2() {
        return (f1) s1a.d.a(this).getAbility(f1.class);
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final int ce() {
        boolean r100 = false;
        if (xX() == true) goto L5;
        return 0;
    L5:
        if (this.f300707x == false) goto L10;
        if ((s1a.a.getActivity(this) instanceof d4) == true) goto L10;
        r100 = true;
    L10:
        if (r100 == false) goto L13;
        return i5.y0(v19.c.b(R.attr.larus_dp_36, null, R.dimen.larus_dp_36));
    L13:
        return i5.y0(v19.c.b(R.attr.larus_dp_197, null, R.dimen.larus_dp_197));
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final int rw() {
        return L2();
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final boolean IZ() {
        return this.f300691h;
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final com.larus.platform.api.a0 WW() {
        return this.f300692i;
    }

    public static final Uri F2(FastSendImageComponent r210) {
        r210.getClass();
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L7;
        r100.T();
        if (h2.f346184a.isBasicMode() != true) goto L7;
        boolean r101 = true;
    L8:
        Uri r102 = null;
        if (r101 == true) goto L29;
        Uri r103 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] r104 = {DBDefinition.ID};
        ContentResolver r110 = r210.getContext().getContentResolver();
        f06.c r211 = new f06.c();
        Object[] r105 = {r103, r104, null, null, "date_added DESC"};
        f06.b r106 = new f06.b();
        f06.d r107 = r211.b(240004, "android/content/ContentResolver", "query", r110, r105, "android.database.Cursor", r106);
        if (r107.f474982a == false) goto L14;
        r211.a(240004, "android/content/ContentResolver", "query", r110, r105, null, r106, false);
        Cursor r108 = (Cursor) r107.f474983b;
    L15:
        if (r108 == null) goto L29;
        Cursor r109 = r108;
        Cursor r111 = r109;     // Catch: Throwable -> L23
        if (r111.moveToFirst() == false) goto L21;
        Uri r112 = Uri.withAppendedPath(r103, String.valueOf(r111.getLong(r111.getColumnIndexOrThrow(DBDefinition.ID))));     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r109, null);
        r102 = r112;
    L30:
        goto L29
    L21:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r109, null);
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r109, th);
        throw th;
    L14:
        Cursor r114 = r110.query(r103, r104, null, null, "date_added DESC");
        r211.a(240004, "android/content/ContentResolver", "query", r110, r105, r114, r106, true);
        r108 = r114;
    L29:
        return r102;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final void At(kq9.e r100) {
        Intrinsics.checkNotNullParameter(r100, "traceInfo");
        this.L = r100;
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final void G90(final boolean r100) {
        if (xX() == true) goto L5;
        return;
    L5:
        this.f300690J = null;
        this.K = false;
        if (this.f300704u != null) goto L8;
        FLogger.f375446a.i("FastSendImageComponent", "[showBottomAlbum] updateAlbumHasImage first");
        Function0 r101 = new n(this, r100);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new FastSendImageComponent$updateAlbumHasImage$1(this, r101, null), 2, null);
        return;
    L8:
        Y2(r100);
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final void W20(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        FLogger r101 = FLogger.f375446a;
        r101.i("FastSendImageComponent", "dismissBottomAlbum ".concat(r100));
        boolean r102 = false;
        this.f300691h = false;
        this.f300705v = null;
        com.larus.platform.api.a0 r103 = this.f300692i;
        if (r103 == null) goto L5;
        r103.Uw();
    L5:
        this.f300692i = null;
        if (Intrinsics.areEqual(r100, "showIme") == true) goto L9;
        return;
    L9:
        if (z2.f365865a.enableFastAlbumSmallWindowAdapt() == true) goto L11;
        r101.i("FastSendImageComponent", "checkIfNeedManualCloseBottomMenu, not enableFastAlbumSmallWindowAdapt");
        return;
    L11:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r104 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r104 == null) goto L30;
        int r105 = Build.VERSION.SDK_INT;
        if (r105 >= 24) goto L17;
    L19:
        if (r105 >= 24) goto L21;
    L34:
        WindowManager r106 = (WindowManager) r104.getSystemService(WindowManager.class);     // Catch: Throwable -> L29
        WindowMetrics r107 = r106.getCurrentWindowMetrics();     // Catch: Throwable -> L29
        WindowMetrics r108 = r106.getMaximumWindowMetrics();     // Catch: Throwable -> L29
        Rect r109 = r107.getBounds();     // Catch: Throwable -> L29
        Rect r110 = r108.getBounds();     // Catch: Throwable -> L29
        Insets r111 = r107.getWindowInsets().getInsetsIgnoringVisibility((WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars()) | WindowInsets.Type.displayCutout());     // Catch: Throwable -> L29
        int r112 = (r109.width() - r111.left) - r111.right;     // Catch: Throwable -> L29
        int r113 = (r109.height() - r111.top) - r111.bottom;     // Catch: Throwable -> L29
        float r114 = r112 / r110.width();     // Catch: Throwable -> L29
        float r115 = r113 / r110.height();
        if (r114 >= 0.9f) goto L27;
    L28:
        r102 = true;
        goto L30
    L27:
        if (r115 >= 0.9f) goto L30;
    L21:
        if (r104.isInPictureInPictureMode() == false) goto L34;
        r101.i("FastSendImageComponent", "isSystemSmallWindow, PIP mode");
        goto L28
    L17:
        if (r104.isInMultiWindowMode() == false) goto L19;
        r101.i("FastSendImageComponent", "isSystemSmallWindow, multi window mode");
    L30:
        if (r102 == false) goto L38;
        FLogger.f375446a.i("FastSendImageComponent", "checkIfNeedManualCloseBottomMenu, small window mode");
        t0.f375468a.postDelayed(new l(this), 1000);
        return;
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final void Wi(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        com.larus.platform.api.a0 r101 = this.f300692i;
        if (r101 == null) goto L6;
        r101.Ua();
        return;
    }

    public final void X2(boolean r100) {
        com.larus.platform.api.a0 r101 = this.f300692i;
        Window r102 = null;
        if (r101 == null) goto L5;
        Fragment r103 = r101.od();
    L7:
        if ((r103 instanceof DialogFragment) == false) goto L9;
        DialogFragment r104 = (DialogFragment) r103;
    L10:
        if (r104 == null) goto L14;
        Dialog r105 = r104.getDialog();
        if (r105 == null) goto L14;
        r102 = r105.getWindow();
    L14:
        FLogger.f375446a.i("FastSendImageComponent", "setAlbumWindowFocusable, focusable=" + r100 + ", window=" + r102);
        if (r100 == false) goto L18;
        if (r102 == null) goto L21;
        r102.clearFlags(8);
        return;
    L21:
        return;
    L18:
        if (r102 == null) goto L23;
        r102.addFlags(8);
        return;
    L23:
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public final void Y2(boolean r310) {
        k2 r100 = k2.f365755a;
        boolean r101 = g3.a.d();
        FLogger.f375446a.i("FastSendImageComponent", "[showBottomAlbum] hasReadPermission:" + r101 + ", albumHasImage:" + this.f300704u + ", needAnim:" + r310);
        WeakReference r102 = null;
        if (r101 == true) goto L7;
        String r103 = "no_permission";
    L5:
        final String r110 = r103;
        ChatControlTrace r104 = ChatControlTrace.f309996b;
        com.larus.bmhome.chat.component.cvs.y r105 = u0();
        if (r105 == null) goto L44;
        String r106 = r105.Y1();
    L45:
        r104.sb(r106, "chat_album_preview_click");
        this.f300691h = true;
        this.f300705v = r110;
        com.larus.platform.api.a0 r107 = this.f300692i;
        if (r107 == null) goto L48;
        r107.Uw();
    L48:
        this.C = false;
        z r108 = this.F;
        a0 r109 = this.G;
        com.larus.bmhome.chat.component.bottom.multimodal.g r111 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f300693j.getValue();
        if (r111 == null) goto L74;
        AlbumSettingConfig r112 = r111.eP();
        if (r112 == null) goto L74;
        if (r112.getEnableInjectInput() == true) goto L55;
    L59:
        boolean r113 = false;
    L60:
        this.C = r113;
        kq9.e r114 = U2();
        if (Intrinsics.areEqual(r114.f505627j, Boolean.TRUE) == true) goto L68;
        boolean r115 = com.larus.bmhome.utils.i.e(r114.f505619b, Integer.valueOf(r114.f505620c));
        if (com.larus.platform.exp.g.a() == false) goto L68;
        if (r115 == false) goto L67;
        boolean r116 = ((kq9.n) com.larus.platform.exp.g.f365383a.getValue()).a();
    L69:
        r112.setEnableMultiSelectConfirmed(r116);
        Bundle r117 = ((de8.c) this.f300701r.getValue()).f468085a;
        if (r117 == null) goto L72;
        String r118 = r117.getString("suggested_action_provider");
    L73:
        r112.setSuggestedActionProvider(r118);
        Unit r119 = Unit.INSTANCE;
        AlbumSettingConfig r120 = r112;
    L76:
        if (this.C == false) goto L78;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r102 = new WeakReference(com.larus.ui.arch.component.internal.attach.a.b(this, this));
    L78:
        WeakReference r121 = r102;
        boolean r122 = this.I;
        b0 r123 = this.H;
        int r124 = L2();
        kq9.e r125 = U2();
        MediaPickerUIMode r126 = MediaPickerUIMode.COLLAPSED_BOTTOM_SHEET;
        boolean r210 = ((de8.c) this.f300701r.getValue()).C();
        z2.f365865a.w3();
        f0 r127 = (f0) this.f300708y.getValue();
        if (r127 != null) goto L81;
    L83:
        boolean r211 = false;
    L84:
        com.larus.platform.api.a0 r128 = r100.f(new hq9.b0(r121, r108, r109, r120, r110, new o(r110, this), r124, r125, r123, new p(this), r310, r126, new c0(this), r210, r122, false, r211));
        this.f300692i = r128;
        if (r128 == null) goto L87;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r128.Ci(com.larus.ui.arch.component.internal.attach.a.b(this, this));
    L87:
        this.B = false;
        com.larus.platform.api.a0 r129 = this.f300692i;
        if (r129 == null) goto L91;
        r129.Lb(new q(this));
        return;
    L91:
        return;
    L81:
        if (r127.eT() != true) goto L83;
        r211 = true;
        goto L84
    L72:
        r118 = null;
        goto L73
    L67:
        r116 = ((kq9.n) com.larus.platform.exp.g.f365383a.getValue()).b();
    L68:
        r116 = false;
        goto L69
    L55:
        if (r112.getMobilePreviewHostEnabled() == false) goto L59;
        if (uy8.b.c() == false) goto L59;
        r113 = true;
    L74:
        r120 = null;
        goto L76
    L44:
        r106 = null;
        goto L45
    L7:
        if (Intrinsics.areEqual(this.f300704u, Boolean.FALSE) == false) goto L9;
        r103 = "no_image";
        goto L5
    L9:
        Map<String, String> r130 = IAIChatRenderTraceService.f365896a.i();
        if (r130 == null) goto L19;
        String r131 = r130.get("key_current_page");
        if (r131 == null) goto L19;
        if (o0.d(r131) == true) goto L17;
        r131 = null;
    L17:
        if (r131 == null) goto L19;
    L20:
        String r132 = r131;
        com.larus.bmhome.chat.component.cvs.y r133 = u0();
        if (r133 == null) goto L23;
        String r134 = r133.getBotId();
    L24:
        com.larus.bmhome.chat.component.cvs.y r135 = u0();
        if (r135 == null) goto L29;
        wc9.e r136 = r135.h();
        if (r136 == null) goto L29;
        String r137 = ic8.n.f(r136);
    L30:
        com.larus.bmhome.chat.component.bottom.reference.a r138 = (com.larus.bmhome.chat.component.bottom.reference.a) this.f300697n.getValue();
        if (r138 == null) goto L33;
        String r139 = r138.wf();
    L34:
        com.larus.bmhome.chat.component.bottom.reference.a r140 = (com.larus.bmhome.chat.component.bottom.reference.a) this.f300697n.getValue();
        if (r140 == null) goto L39;
        ReferenceInfo r141 = r140.T6();
        if (r141 == null) goto L39;
        String r142 = r141.referencedMessageId;
    L40:
        e6.f552469a.getClass();
        tx9.c0.H(r134, "chat_album_preview", null, null, r137, r132, null, null, null, null, null, r139, r142, 0, null, null, null, null, null, null, null, null, e6.a(), 29353932);
        r103 = "album_display";
    L39:
        r142 = null;
        goto L40
    L33:
        r139 = null;
    L29:
        r137 = null;
        goto L30
    L23:
        r134 = null;
    L19:
        r131 = "album";
        goto L20
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final void h0(Uri r100) {
        if (bx() == false) goto L5;
    L8:
        com.larus.platform.api.a0 r101 = this.f300692i;
        if (r101 == null) goto L14;
        r101.tZ(r100);
        return;
    L14:
        return;
    L5:
        if (this.C == true) goto L7;
        return;
    L7:
        if (this.f300691h == true) goto L8;
    }

    public final void h3(final String r100) {
        k2 r101 = k2.f365755a;
        if (g3.a.d() == true) goto L6;
        FLogger.f375446a.i("FastSendImageComponent", "[updateBottomAlbumAfterPermission] no permission, from:".concat(r100));
        return;
    L6:
        Function0 r102 = new com.larus.bmhome.chat.component.fastsend.a(this, r100);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new FastSendImageComponent$updateAlbumHasImage$1(this, r102, null), 2, null);
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final void kh(int r100) {
        Integer r101 = Integer.valueOf(r100);
        if (r101.intValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        this.E = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.fastsend.e0
    public final void k6(int r100, boolean r101) {
        int r102 = i5.y0(v19.c.b(R.attr.larus_dp_23, null, R.dimen.larus_dp_23)) + r100;
        if (this.f300707x == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        r102 = r102 + i5.y0(v19.c.b(R.attr.larus_dp_68, null, R.dimen.larus_dp_68));
    L10:
        com.larus.platform.api.a0 r104 = this.f300692i;
        if (r104 != null) goto L16;
        FLogger.f375446a.i("FastSendImageComponent", "updatePeekHeight, albumFragment is null height:" + r100 + ", isAnimEnd:" + r101 + " peekHeightFallbackFix=" + ((Boolean) this.D.getValue()).booleanValue());
        if (((Boolean) this.D.getValue()).booleanValue() == false) goto L18;
        this.f300690J = Integer.valueOf(r102);
        this.K = r101;
        return;
    L18:
        return;
    L16:
        this.f300690J = null;
        this.K = false;
        r104.k6(r102, r101);
        return;
    L5:
        if ((s1a.a.getActivity(this) instanceof d4) == true) goto L7;
        r103 = true;
        goto L8
    }
}
