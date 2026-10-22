package com.larus.bmhome.chat.layout.holder.image;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageShareClickMethod;
import com.larus.bmhome.chat.layout.holder.progressloading.SketchLoadingController;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.bmhome.databinding.LarusImageScrollItemBinding;
import com.larus.bmhome.share.ShareScene;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.service.ICreationShareService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.v1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001$\u0018\u0000 E2\u00020\u0001:\u0001EB\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012 \u0010\r\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u000e\u0012\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u001e\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\nJ\u0016\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001fJ\u0010\u00106\u001a\u0002002\u0006\u00101\u001a\u00020\u001cH\u0002J\u0012\u00107\u001a\u0002002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u00108\u001a\u0002002\b\u00109\u001a\u0004\u0018\u00010\u0011H\u0082@¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020=H\u0082@¢\u0006\u0002\u0010>J4\u0010?\u001a\u0002002\b\u00109\u001a\u0004\u0018\u00010\u00112\u0006\u0010@\u001a\u00020A2\u0006\u00101\u001a\u00020\u001c2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CH\u0082@¢\u0006\u0002\u0010DR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)¨\u0006F"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/image/ScrollImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/bmhome/databinding/LarusImageScrollItemBinding;", "loadingController", "Lcom/larus/bmhome/chat/layout/holder/progressloading/SketchLoadingController;", "loadImageAction", "Lcom/larus/bmhome/chat/layout/holder/image/ILoadImageAction;", "isReloadGetter", "Lkotlin/Function0;", "", "progressGetter", "Lcom/larus/bmhome/chat/layout/holder/image/IProgressGetter;", "eventParamsGetter", "Lkotlin/Function1;", "Lcom/larus/im/bean/message/Message;", "", "", "", "coroutineScopeGetter", "Lkotlinx/coroutines/CoroutineScope;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "<init>", "(Lcom/larus/bmhome/databinding/LarusImageScrollItemBinding;Lcom/larus/bmhome/chat/layout/holder/progressloading/SketchLoadingController;Lcom/larus/bmhome/chat/layout/holder/image/ILoadImageAction;Lkotlin/jvm/functions/Function0;Lcom/larus/bmhome/chat/layout/holder/image/IProgressGetter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/bmhome/chat/api/MessageAdapter;)V", "imageData", "Lcom/larus/bmhome/chat/layout/holder/image/ImageItemDataWithTemplate;", "message", "imageIndex", "", "Ljava/lang/Integer;", "isSharing", "isLongPicShare", "imageLoadResultListener", "com/larus/bmhome/chat/layout/holder/image/ScrollImageViewHolder$imageLoadResultListener$1", "Lcom/larus/bmhome/chat/layout/holder/image/ScrollImageViewHolder$imageLoadResultListener$1;", "loadingProgressComponent", "Lcom/larus/uaigc/bean/chat/loading/ILoadingProgress;", "getLoadingProgressComponent", "()Lcom/larus/uaigc/bean/chat/loading/ILoadingProgress;", "loadingProgressComponent$delegate", "Lkotlin/Lazy;", "buildCreatePageChatParam", "Lcom/larus/bmhome/chat/ChatParam;", "openNewChatPage", "bindData", "", "data", "position", "refreshSize", "width", "height", "initShareDownloadClickAction", "refreshShareOrDownloadBtn", "doSaveImage", "imageUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPermission", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doShareImage", "imageItemInfo", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItemInfo;", "commonReportParams", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItemInfo;Lcom/larus/bmhome/chat/layout/holder/image/ImageItemDataWithTemplate;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrollImageViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy<Boolean> f303740q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy<Boolean> f303741r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusImageScrollItemBinding f303742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SketchLoadingController f303743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f303744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f303745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h0 f303746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Message, Map<String, Object>> f303747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<CoroutineScope> f303748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BotModel f303749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.larus.bmhome.chat.api.q0 f303750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m0 f303751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Message f303752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f303753l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f303754m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f303755n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final k1 f303756o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f303757p;

    public static final class a {
    }

    static {
        f303740q = LazyKt.lazy(new b1());
        f303741r = LazyKt.lazy(new c1());
    }

    public static final ChatParam T3(ScrollImageViewHolder r100, boolean r101, BotModel r110) {
        r100.getClass();
        if (r101 == false) goto L10;
        wc9.e r102 = AuthModelDelegate.f297134b.y().getValue();
        if (r102 == null) goto L7;
        String r103 = r102.f559198a;
    L8:
        if (r103 != null) goto L17;
        r103 = "";
    L17:
        String r104 = r103;
    L19:
        if (r101 == false) goto L25;
        com.larus.bmhome.chat.api.e0 r105 = AuthModelDelegate.f297134b.e().getValue();
        if (r105 == null) goto L28;
        LaunchInfo r106 = r105.f297186a;
        if (r106 == null) goto L28;
        String r107 = r106.W();
    L27:
        String r108 = r107;
    L30:
        return new ChatParam(r104, r108, null, null, null, 252);
    L28:
        r108 = null;
        goto L30
    L25:
        if (r110 == null) goto L28;
        r107 = r110.getBotId();
        goto L27
    L7:
        r103 = null;
        goto L8
    L10:
        com.larus.bmhome.chat.api.q0 r109 = r100.f303750i;
        if (r109 == null) goto L18;
        com.larus.bmhome.chat.api.n0 r111 = r109.M7();
        if (r111 == null) goto L18;
        com.larus.bmhome.chat.component.cvs.y r112 = (com.larus.bmhome.chat.component.cvs.y) r111.invoke();
        if (r112 == null) goto L18;
        r103 = r112.Y1();
    L18:
        r104 = null;
        goto L19
    }

    public static final Object U3(final ScrollImageViewHolder r110, String r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof ScrollImageViewHolder$doSaveImage$1) == false) goto L7;
        ScrollImageViewHolder$doSaveImage$1 r100 = (ScrollImageViewHolder$doSaveImage$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L12:
        String r104 = r111;
        if (((Boolean) r113).booleanValue() == false) goto L76;
        ICreationMetadataService.Companion r114 = ICreationMetadataService.f373916a;
        Message r115 = r110.f303752k;
        m0 r105 = r110.f303751j;
        if (r105 == null) goto L47;
        String r106 = r105.f303859e;
    L48:
        UserCreationFromIM r116 = r114.I(r115, r106, String.valueOf(r110.f303753l));
        m0 r107 = r110.f303751j;
        if (r107 == null) goto L51;
        String r108 = r107.f303859e;
    L52:
        Map<String, String> r109 = r114.L(r116, r108);
        Message r117 = r110.f303752k;
        m0 r118 = r110.f303751j;
        if (r118 == null) goto L55;
        String r119 = r118.f303859e;
    L56:
        final UserCreationFromIM r120 = r114.I(r117, r119, String.valueOf(r110.f303753l));
        Message r121 = r110.f303752k;
        if (r121 == null) goto L66;
        String r122 = ap8.a.b(r121);
        if (r122 == null) goto L66;
        if ((!StringsKt.isBlank(r122)) == true) goto L64;
        r122 = null;
    L64:
        if (r122 == null) goto L66;
    L67:
        IFlowSdkDepend r123 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r123 == null) goto L74;
        r123.D0();
        com.larus.home.impl.sdk.b1 r124 = com.larus.home.impl.sdk.b1.f346144a;
        r124.c("chat_thumbnail_download");
        if (r104 != null) goto L72;
        String r125 = "";
    L73:
        r124.d(r125);
        goto L74
    L72:
        r125 = r104;
    L74:
        ImageDownloadLoadingMgr r126 = ImageDownloadLoadingMgr.f295963a;
        ImageDownloadLoadingMgr.b(r104, r109, new ScrollImageViewHolder$doSaveImage$3(r120, r110, null), new f1(r110, r120), true, new ScrollImageViewHolder$doSaveImage$5(r104, r122, null));
    L66:
        r122 = "creation_image";
        goto L67
    L55:
        r119 = null;
        goto L56
    L51:
        r108 = null;
        goto L52
    L47:
        r106 = null;
    L76:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r113);
        if (r111 != null) goto L18;
    L21:
        boolean r127 = true;
    L23:
        if (r127 == false) goto L25;
        FLogger.f375446a.e("ScrollImageViewHolder", "doSaveImage error because imageUrl is null or empty");
        return Unit.INSTANCE;
    L25:
        Context r128 = r110.itemView.getContext();
        if ((r128 instanceof FragmentActivity) == false) goto L28;
        FragmentActivity r129 = (FragmentActivity) r128;
    L29:
        if (r129 != null) goto L31;
        FLogger.f375446a.e("ScrollImageViewHolder", "no activity");
        return Unit.INSTANCE;
    L31:
        r100.L$0 = r111;
        r100.label = 1;
        SafeContinuation r130 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        if (Build.VERSION.SDK_INT <= 29) goto L34;
    L36:
        Result.Companion r131 = Result.Companion;
        r130.resumeWith(Result.m9449constructorimpl(Boxing.boxBoolean(true)));
    L37:
        r113 = r130.getOrThrow();
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L40;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L40:
        if (r113 != r102) goto L12;
        return r102;
    L34:
        if (ContextCompat.checkSelfPermission(r129, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L36;
        i2.f365748b.a(r129, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new j1(r130));
        goto L37
    L28:
        r129 = null;
        goto L29
    L18:
        if (r111.length() == 0) goto L21;
        r127 = false;
    L7:
        r100 = new ScrollImageViewHolder$doSaveImage$1(r110, r112);
        goto L8
    }

    public static final Object V3(ScrollImageViewHolder r310, String r311, df8.a r312, m0 r313, JSONObject r314, Continuation r410) {
        r310.getClass();
        if ((r410 instanceof ScrollImageViewHolder$doShareImage$1) == false) goto L7;
        ScrollImageViewHolder$doShareImage$1 r100 = (ScrollImageViewHolder$doShareImage$1) r410;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ScrollImageViewHolder$doShareImage$1 r102 = r100;
        Object r103 = r102.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L97:
        r310.f303754m = false;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (r311 != null) goto L17;
    L20:
        boolean r105 = true;
    L22:
        if (r105 == false) goto L25;
        FLogger.f375446a.e("ScrollImageViewHolder", "doShareImage error because imageUrl is null or empty");
        return Unit.INSTANCE;
    L25:
        if (r310.f303754m == false) goto L27;
        FLogger.f375446a.i("ScrollImageViewHolder", "doShareImage return because isSharing is true");
        return Unit.INSTANCE;
    L27:
        r310.f303754m = true;
        ky9.b r106 = ICreationReportService.f373922a.j().e();
        ImageShareClickMethod r107 = ImageShareClickMethod.OverviewClick;
        String r108 = ap8.a.b(r313.f303855a);
        if (r108 == null) goto L30;
        Integer r109 = Boxing.boxInt(ap8.a.d(r108));
    L31:
        com.larus.bmhome.share.panel.h r210 = r106.c(r107, r312, r109, r314, r313.f303855a);
        z2 r111 = z2.f365865a;
        v1 r112 = r111.getCreationShareSettings().a();
        if (r112 != null) goto L34;
    L36:
        boolean r113 = false;
    L37:
        if (r113 == false) goto L93;
        v1 r114 = r111.getCreationShareSettings().a();
        if (r114 != null) goto L41;
    L43:
        boolean r115 = false;
    L45:
        if (r115 == false) goto L50;
        if (Intrinsics.areEqual(ap8.a.b(r313.f303855a), CreativeScene.AVATAR_IMAGE) == false) goto L53;
    L54:
        boolean r116 = false;
    L55:
        if (r116 == false) goto L93;
        Context r117 = r310.itemView.getContext();
        if ((r117 instanceof FragmentActivity) == false) goto L59;
        FragmentActivity r118 = (FragmentActivity) r117;
    L60:
        if (r118 == null) goto L94;
        FragmentManager r119 = r118.getSupportFragmentManager();
        if (r119 == null) goto L94;
        IFlowSdkDepend r120 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r120 == null) goto L94;
        r120.r0();
        e2 r121 = e2.f346164a;
        ImageEntity r122 = r312.f468311b.getPreviewImage();
        if (r122 == null) goto L68;
        String r123 = r122.getUrl();
    L69:
        String r124 = String.valueOf(r123);
        ImageEntity r125 = r312.f468311b.getImageOrigin();
        if (r125 == null) goto L72;
        String r126 = r125.getUrl();
    L73:
        String r127 = String.valueOf(r126);
        ImageEntity r128 = r312.f468311b.getRawImage();
        if (r128 == null) goto L76;
        String r129 = r128.getUrl();
    L78:
        if (ap8.a.c(r313.f303855a) == true) goto L83;
        ImageEntity r130 = r312.f468311b.getRefImage();
        if (r130 == null) goto L83;
        String r131 = r130.getUrl();
    L84:
        ShareScene r211 = ShareScene.IMAGE_VIEWER_REPORT;
        ImageEntity r132 = r312.f468311b.getImageOrigin();
        if (r132 == null) goto L87;
        long r212 = r132.getHeight();
    L88:
        ImageEntity r133 = r312.f468311b.getImageOrigin();
        if (r133 == null) goto L91;
        long r213 = r133.getWidth();
    L92:
        sq9.i r134 = new sq9.i("share", r313.f303855a.getMessageId(), null, 4);
        ICreationMetadataService.Companion r135 = ICreationMetadataService.f373916a;
        r121.Z0(r119, new sq9.j(null, r124, r127, r129, r131, null, r210, r211, r213, r212, r134, r135.L(r135.I(r310.f303752k, r313.f303859e, String.valueOf(r312.f468310a)), null), 0, null, null, null, null, 127009));
        goto L94
    L91:
        r213 = -1;
        goto L92
    L87:
        r212 = -1;
    L83:
        r131 = null;
        goto L84
    L76:
        r129 = null;
        goto L78
    L72:
        r126 = null;
        goto L73
    L68:
        r123 = null;
    L94:
        r102.label = 1;
        if (DelayKt.delay(500, r102) != r110) goto L97;
        return r110;
    L59:
        r118 = null;
    L53:
        r116 = true;
        goto L55
    L50:
        if (Intrinsics.areEqual(ap8.a.b(r313.f303855a), CreativeScene.AVATAR_IMAGE) == true) goto L54;
        if (Intrinsics.areEqual(ap8.a.b(r313.f303855a), "image") == true) goto L54;
    L41:
        if (r114.f() != true) goto L43;
        r115 = true;
    L93:
        ICreationShareService.a.a(ICreationShareService.f373931a, r310.itemView.getContext(), r311, ShareScene.IMAGE_VIEWER, null, r210, null, ICreationMetadataService.f373916a.I(r310.f303752k, r313.f303859e, String.valueOf(r312.f468310a)), null, null, 904);
        goto L94
    L34:
        if (r112.e() != true) goto L36;
        r113 = true;
        goto L37
    L30:
        r109 = null;
        goto L31
    L17:
        if (r311.length() == 0) goto L20;
        r105 = false;
    L7:
        r100 = new ScrollImageViewHolder$doShareImage$1(r310, r410);
        goto L8
    }

    public ScrollImageViewHolder(LarusImageScrollItemBinding r100, SketchLoadingController r101, g0 r102, q0 r103, h0 r104, Function1 r105, Function0 r106, BotModel r107, com.larus.bmhome.chat.api.q0 r110) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r101, "loadingController");
        Intrinsics.checkNotNullParameter(r102, "loadImageAction");
        Intrinsics.checkNotNullParameter(r103, "isReloadGetter");
        Intrinsics.checkNotNullParameter(r104, "progressGetter");
        Intrinsics.checkNotNullParameter(r105, "eventParamsGetter");
        Intrinsics.checkNotNullParameter(r106, "coroutineScopeGetter");
        super(r100.f310940a);
        this.f303742a = r100;
        this.f303743b = r101;
        this.f303744c = r102;
        this.f303745d = r103;
        this.f303746e = r104;
        this.f303747f = r105;
        this.f303748g = r106;
        this.f303749h = r107;
        this.f303750i = r110;
        this.f303756o = new k1(this);
        this.f303757p = LazyKt.lazy(LazyThreadSafetyMode.NONE, new g1(this));
    }
}
