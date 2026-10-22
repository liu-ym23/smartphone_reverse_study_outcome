package com.larus.uaigc.creation.gallery.providers;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.collection.LruCache;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.larus.bmhome.bigimg.aibeautify.CommonAiBeautifyLayout;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.bigimg.u1;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.api.IFlowCreationThemeConfigProvider;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.e0;
import com.larus.platform.service.z2;
import com.larus.uaigc.impl.databinding.LarusLayoutCreationBottomBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import tx9.e2;
import tx9.m0;
import tx9.o0;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001KB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0006\u0010\"\u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\rJ$\u0010%\u001a\u00020\u001f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010&\u001a\u0004\u0018\u00010!J\u001e\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010\u00132\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0002J\u001e\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rJ\u0010\u0010/\u001a\u00020\u001f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0011J\b\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u00020\u001fH\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\u000e\u00103\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\rH\u0002J$\u00106\u001a\u00020\u001f2\b\u00107\u001a\u0004\u0018\u0001082\b\u0010-\u001a\u0004\u0018\u00010\r2\u0006\u00109\u001a\u00020\u0015H\u0002J\u0012\u0010:\u001a\u00020\u001f2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u0010;\u001a\u00020\rH\u0002J\b\u0010<\u001a\u00020\u0015H\u0002J\u0010\u0010=\u001a\u0004\u0018\u00010>H\u0082@¢\u0006\u0002\u00104J\u0016\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010AJ\u0006\u0010B\u001a\u00020\rJ\b\u0010C\u001a\u00020\rH\u0002J\u001f\u0010D\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u00020\rH\u0002¢\u0006\u0002\u0010EJ\u0012\u0010F\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\b\u0010I\u001a\u00020\u001fH\u0002J\u0006\u0010J\u001a\u00020\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/larus/uaigc/creation/gallery/providers/CreationBottomView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutCreationBottomBinding;", "tag", "", "creationCallback", "Lcom/larus/uaigc/creation/gallery/ICreateBottomOperation;", "currentContext", "Lcom/larus/uaigc/creation/gallery/bean/CreationBottomViewContext;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "currentIsVideo", "", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "isDownloading", "isShowAiBeauty", "initAiBeautifyListener", "", "aiImageParams", "Lcom/larus/bmhome/chat/bean/AIEditParams;", "onDownloadAction", "onShareAction", "source", "initData", "aiVideoParams", "bindDownloadData", "coroutineScope", "resourceData", "Lcom/larus/bmhome/bigimg/download/DownloadResource;", "updateCurrentCreationButtonStatus", "status", "creationId", "from", "bindData", "initPublishButton", "publishCreation", "getCreateCreationSource", "addCreation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCreationTypeString", "reportPicAddCreation", "message", "Lcom/larus/im/bean/message/Message;", "success", "reportPicClickAddCreation", "getSubType", "isByPublisher", "getPublisherCreation", "Lcom/larus/platform/api/creation/PublisherCreation;", "setCreationPrivacy", BridgePrivilege.PRIVATE, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItemName", "getCurrentStatus", "refreshButtonStatus", "(Ljava/lang/Integer;Ljava/lang/String;)V", "openPrivacyDialog", "containerView", "Landroid/view/View;", "deleteCreation", "onDestroyView", "ImageShareCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationBottomView extends ConstraintLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f372874i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutCreationBottomBinding f372875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f372876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rz9.d f372877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public sz9.a f372878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f372879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f372880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f372881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f372882h;

    public CreationBottomView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CreationBottomView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getCreateCreationSource() {
        sz9.a r100 = this.f372878d;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L10;
        return 4;
    L10:
        return 1;
    L5:
        if (r100.f544059i != true) goto L7;
        r101 = true;
        goto L7
    }

    private final String getCreationTypeString() {
        sz9.a r100 = this.f372878d;
        if (r100 == null) goto L5;
        Integer r101 = r100.f544058h;
    L6:
        if (r101 != null) goto L9;
    L10:
        if (r101 != null) goto L13;
    L15:
        if (r101 != null) goto L18;
    L20:
        return "replica";
    L18:
        if (r101.intValue() != 4) goto L20;
        return "image_edit";
    L13:
        if (r101.intValue() != 5) goto L15;
    L21:
        return "pic";
    L9:
        if (r101.intValue() == 2) goto L21;
    L5:
        r101 = null;
        goto L6
    }

    private final String getCurrentStatus() {
        CreationGalleryUtil r100 = CreationGalleryUtil.f372883a;
        sz9.a r101 = this.f372878d;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.f544063m);
    L7:
        return CreationGalleryUtil.d(r102);
    L5:
        r102 = null;
        goto L7
    }

    private final l0 getLoadingDialog() {
        return (l0) this.f372881g.getValue();
    }

    private final String getSubType() {
        sz9.a r100 = this.f372878d;
        if (r100 == null) goto L7;
        Integer r101 = r100.f544058h;
        if (r101 == null) goto L7;
        return zp9.y.a(r101.intValue());
    L7:
        return "";
    }

    public final boolean b6() {
        boolean r100 = z2.f365865a.getCreationPublishConfig().b();
        FLogger.f375446a.i(this.f372876b, "isByPublisher enableEnterPublisher:" + r100);
        return r100;
    }

    public final void c6() {
        if (this.f372882h == false) goto L5;
        return;
    L5:
        this.f372882h = true;
        Integer r100 = null;
        if (this.f372880f == false) goto L8;
        BuildersKt.launch$default(this.f372879e, null, null, new CreationBottomView$onDownloadAction$1(this, null), 3, null);
    L8:
        CreationGalleryUtil r101 = CreationGalleryUtil.f372883a;
        Context r102 = getContext();
        sz9.a r103 = this.f372878d;
        if (r103 == null) goto L11;
        n1 r104 = r103.f544051a;
    L12:
        if (r103 == null) goto L14;
        Uri r105 = r103.f544052b;
    L15:
        if (r103 == null) goto L17;
        Integer r106 = r103.f544058h;
    L18:
        if (r103 == null) goto L20;
        com.larus.bmhome.bigimg.l r110 = r103.f544067q;
    L21:
        if (r103 == null) goto L23;
        String r111 = r103.f544068r;
    L24:
        if (r103 == null) goto L26;
        JSONObject r112 = r103.f544071u;
    L27:
        if (r103 == null) goto L29;
        Boolean r113 = Boolean.valueOf(r103.f544065o);
    L30:
        CoroutineScope r107 = this.f372879e;
        sz9.a r108 = this.f372878d;
        if (r108 == null) goto L33;
        Message r114 = r108.f544072v;
    L34:
        if (r108 == null) goto L36;
        String r115 = r108.f544066p;
    L37:
        if (r108 != null) goto L39;
    L41:
        boolean r210 = false;
    L42:
        if (r108 == null) goto L44;
        r100 = r108.f544076z;
    L44:
        CreationGalleryUtil.c(r102, new sz9.c(r104, r105, r106, r110, r111, r112, r113, null, null, r115, r107, r114, null, null, null, r210, r100, 29056), this, new h(this));
        return;
    L39:
        if (r108.f544075y != true) goto L41;
        r210 = true;
        goto L42
    L36:
        r115 = null;
        goto L37
    L33:
        r114 = null;
        goto L34
    L29:
        r113 = null;
        goto L30
    L26:
        r112 = null;
        goto L27
    L23:
        r111 = null;
        goto L24
    L20:
        r110 = null;
        goto L21
    L17:
        r106 = null;
        goto L18
    L14:
        r105 = null;
        goto L15
    L11:
        r104 = null;
        goto L12
    }

    public final String getItemName() {
        sz9.a r100 = this.f372878d;
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.f544063m);
    L7:
        if (r101 != null) goto L10;
    L12:
        if (r101 != null) goto L15;
    L17:
        if (r101 != null) goto L20;
    L22:
        return "";
    L20:
        if (r101.intValue() != 3) goto L22;
        return "already_public";
    L15:
        if (r101.intValue() != 2) goto L17;
        return "go_public";
    L10:
        if (r101.intValue() != 1) goto L12;
        return "go_public";
    L5:
        r101 = null;
        goto L7
    }

    public static final /* synthetic */ String S5(CreationBottomView r100) {
        return r100.getCreationTypeString();
    }

    public static final /* synthetic */ String T5(CreationBottomView r100) {
        return r100.getCurrentStatus();
    }

    public static final /* synthetic */ String U5(CreationBottomView r100) {
        return r100.getSubType();
    }

    public final void Y5(sz9.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f372878d = r100;
        this.f372882h = false;
        nr9.g r101 = r100.f544069s;
        if (r101 == null) goto L7;
        this.f372880f = true;
        CoroutineScope r102 = this.f372879e;
        com.larus.bmhome.bigimg.download.d.c r103 = new com.larus.bmhome.bigimg.download.d.c(r101);
        this.f372875a.f373214d.S5(r102, r103);
    L8:
        n6(r100.f544063m, r100.f544066p, "bindData");
        m0.c(getItemName(), getCurrentStatus(), "picture_detail", "chat_list");
        return;
    L7:
        this.f372880f = false;
        CoroutineScope r104 = this.f372879e;
        com.larus.bmhome.bigimg.download.d.a r105 = new com.larus.bmhome.bigimg.download.d.a(String.valueOf(r100.f544052b));
        this.f372875a.f373214d.S5(r104, r105);
        goto L8
    }

    public final Object Z5(Continuation<? super PublisherCreation> r410) {
        if ((r410 instanceof CreationBottomView$getPublisherCreation$1) == false) goto L7;
        CreationBottomView$getPublisherCreation$1 r100 = (CreationBottomView$getPublisherCreation$1) r410;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        Long r106 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L27:
        UserCreationFromIM r107 = (UserCreationFromIM) r102;
        if (r107 == null) goto L30;
        PublisherCreation r108 = zp9.x.a(r107);
    L31:
        if (r108 != null) goto L37;
        sz9.a r109 = this.f372878d;
        if (r109 == null) goto L35;
        String r110 = r109.f544066p;
    L36:
        r108 = new PublisherCreation(r110, null, null, null, null, null, null, null, null, false, null, null, null, null, 16382, null);
        goto L37
    L35:
        r110 = null;
    L37:
        PublisherCreation r210 = r108;
        Integer r111 = r210.getCreationType();
        FLogger.f375446a.i(this.f372876b, "originCreationType:" + r111 + ' ');
        if (this.f372880f == false) goto L46;
        sz9.a r112 = this.f372878d;
        if (r112 == null) goto L52;
        nr9.g r113 = r112.f544069s;
        if (r113 == null) goto L52;
        nr9.f r114 = r113.f520263g;
        if (r114 == null) goto L52;
        String r115 = r114.f520252b;
    L51:
        String r310 = r115;
    L53:
        sz9.a r116 = this.f372878d;
        if (r116 == null) goto L58;
        Message r117 = r116.f544072v;
        if (r117 == null) goto L58;
        String r211 = r117.getMessageId();
    L59:
        sz9.a r118 = this.f372878d;
        if (r118 == null) goto L64;
        String r119 = r118.f544057g;
        if (r119 == null) goto L64;
        Integer r311 = StringsKt.toIntOrNull(r119);
    L65:
        if (r111 != null) goto L70;
        sz9.a r120 = this.f372878d;
        if (r120 == null) goto L69;
        r111 = r120.f544058h;
        goto L70
    L69:
        Integer r212 = null;
    L71:
        sz9.a r121 = this.f372878d;
        if (r121 == null) goto L74;
        Integer r213 = r121.f544064n;
    L75:
        String r122 = r210.getTaskId();
        if (r122 != null) goto L79;
        r122 = "";
    L79:
        if (r122.length() == 0) goto L82;
        r105 = false;
    L82:
        if (r105 == false) goto L87;
        sz9.a r123 = this.f372878d;
        if (r123 == null) goto L86;
        r122 = r123.f544056f;
        goto L87
    L86:
        r122 = null;
    L87:
        String r312 = r122;
        sz9.a r124 = this.f372878d;
        if (r124 == null) goto L92;
        String r125 = r124.f544073w;
        if (r125 == null) goto L92;
        Long r313 = StringsKt.toLongOrNull(r125);
    L93:
        sz9.a r126 = this.f372878d;
        if (r126 == null) goto L99;
        String r127 = r126.f544074x;
        if (r127 == null) goto L99;
        r106 = StringsKt.toLongOrNull(r127);
    L99:
        return PublisherCreation.copy$default(r210, null, r212, r213, r211, null, r310, null, r311, r312, false, null, r313, r106, null, 9809, null);
    L92:
        r313 = null;
        goto L93
    L74:
        r213 = null;
    L70:
        r212 = r111;
    L64:
        r311 = null;
    L58:
        r211 = null;
    L52:
        r310 = null;
        goto L53
    L46:
        sz9.a r128 = this.f372878d;
        if (r128 == null) goto L52;
        Uri r129 = r128.f544054d;
        if (r129 == null) goto L52;
        r115 = r129.toString();
        goto L51
    L30:
        r108 = null;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        CreationGalleryUtil r130 = CreationGalleryUtil.f372883a;
        sz9.a r131 = this.f372878d;
        if (r131 == null) goto L19;
        Message r132 = r131.f544072v;
        if (r132 == null) goto L19;
        String r133 = r132.getMessageId();
    L20:
        sz9.a r134 = this.f372878d;
        if (r134 == null) goto L23;
        String r135 = r134.f544055e;
    L24:
        r100.label = 1;
        r102 = r130.e(r133, r135, r100);
        if (r102 != r103) goto L27;
        return r103;
    L23:
        r135 = null;
    L19:
        r133 = null;
    L7:
        r100 = new CreationBottomView$getPublisherCreation$1(this, r410);
        goto L8
    }

    public final void i6(String r810) {
        Intrinsics.checkNotNullParameter(r810, "source");
        Integer r100 = null;
        if (this.f372880f == false) goto L80;
        sz9.a r101 = this.f372878d;
        if (r101 == null) goto L9;
        c4 r102 = r101.f544070t;
        if (r102 == null) goto L9;
        wc9.e r103 = r102.f314988e;
    L10:
        if (r101 == null) goto L14;
        c4 r104 = r101.f544070t;
        if (r104 == null) goto L14;
        BotModel r105 = r104.f314987d;
    L15:
        if (r101 == null) goto L19;
        c4 r106 = r101.f544070t;
        if (r106 == null) goto L19;
        String r107 = r106.f314986c;
    L20:
        LruCache<String, wc9.e> r108 = ko8.a.f504531a;
        String r110 = ko8.a.e(ko8.a.f504535e);
        sz9.a r109 = this.f372878d;
        if (r109 == null) goto L25;
        c4 r111 = r109.f544070t;
        if (r111 == null) goto L25;
        String r112 = r111.f314984a;
    L26:
        if (r109 == null) goto L30;
        c4 r113 = r109.f544070t;
        if (r113 == null) goto L30;
        String r114 = r113.f314985b;
    L31:
        if (r109 == null) goto L35;
        c4 r115 = r109.f544070t;
        if (r115 == null) goto L35;
        String r310 = r115.f314993j;
    L36:
        if (r109 == null) goto L40;
        c4 r116 = r109.f544070t;
        if (r116 == null) goto L40;
        String r311 = r116.f314991h;
    L41:
        if (r109 == null) goto L45;
        c4 r117 = r109.f544070t;
        if (r117 == null) goto L45;
        Boolean r312 = r117.f314994k;
    L46:
        if (r109 == null) goto L50;
        c4 r118 = r109.f544070t;
        if (r118 == null) goto L50;
        Integer r313 = r118.f314992i;
    L51:
        if (r109 == null) goto L55;
        c4 r119 = r109.f544070t;
        if (r119 == null) goto L55;
        Message r410 = r119.f314995l;
    L56:
        if (r109 == null) goto L58;
        String r411 = r109.f544066p;
    L59:
        com.larus.bmhome.share.panel.h r120 = new com.larus.bmhome.share.panel.h(r103, r105, r107, "video_detail", r110, r112, r114, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r311, r313, r310, r312, null, null, null, null, null, null, r410, null, null, r411, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 1073741572, -4356, 1023);
        CreationGalleryUtil r121 = CreationGalleryUtil.f372883a;
        sz9.a r122 = this.f372878d;
        if (r122 == null) goto L62;
        nr9.g r210 = r122.f544069s;
    L63:
        if (r122 == null) goto L65;
        String r211 = r122.f544055e;
    L66:
        CoroutineScope r123 = this.f372879e;
        if (r122 == null) goto L69;
        Message r212 = r122.f544072v;
    L70:
        if (r122 == null) goto L72;
        c4 r213 = r122.f544070t;
    L73:
        if (r122 == null) goto L75;
        String r214 = r122.f544066p;
    L76:
        if (r122 == null) goto L78;
        r100 = r122.f544076z;
    L78:
        CreationGalleryUtil.i(new sz9.c(null, null, null, null, null, null, null, r210, r211, r214, r123, r212, r120, r213, null, false, r100, 49279), this, getLoadingDialog());
        return;
    L75:
        r214 = null;
        goto L76
    L72:
        r213 = null;
        goto L73
    L69:
        r212 = null;
        goto L70
    L65:
        r211 = null;
        goto L66
    L62:
        r210 = null;
        goto L63
    L58:
        r411 = null;
    L55:
        r410 = null;
    L50:
        r313 = null;
    L45:
        r312 = null;
    L40:
        r311 = null;
    L35:
        r310 = null;
    L30:
        r114 = null;
    L25:
        r112 = null;
    L19:
        r107 = null;
    L14:
        r105 = null;
    L9:
        r103 = null;
        goto L10
    L80:
        CreationGalleryUtil r124 = CreationGalleryUtil.f372883a;
        Context r125 = getContext();
        sz9.a r126 = this.f372878d;
        if (r126 == null) goto L83;
        n1 r127 = r126.f544051a;
    L84:
        if (r126 == null) goto L86;
        Uri r128 = r126.f544052b;
    L87:
        if (r126 == null) goto L89;
        Integer r129 = r126.f544058h;
    L90:
        if (r126 == null) goto L92;
        com.larus.bmhome.bigimg.l r130 = r126.f544067q;
    L93:
        if (r126 == null) goto L95;
        String r131 = r126.f544068r;
    L96:
        if (r126 == null) goto L98;
        JSONObject r132 = r126.f544071u;
    L99:
        if (r126 == null) goto L101;
        Boolean r133 = Boolean.valueOf(r126.f544065o);
    L102:
        sz9.a r134 = this.f372878d;
        if (r134 == null) goto L105;
        String r135 = r134.f544055e;
    L106:
        CoroutineScope r136 = this.f372879e;
        if (r134 == null) goto L109;
        Message r215 = r134.f544072v;
    L110:
        if (r134 == null) goto L112;
        String r137 = r134.f544066p;
    L113:
        int r138 = 0;
        if (r134 != null) goto L116;
    L118:
        boolean r216 = false;
    L119:
        if (r134 == null) goto L121;
        Integer r217 = r134.f544076z;
    L122:
        sz9.c r139 = new sz9.c(r127, r128, r129, r130, r131, r132, r133, null, r135, r137, r136, r215, null, null, null, r216, r217, 28672);
        Intrinsics.checkNotNullParameter(r125, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r139, "params");
        Intrinsics.checkNotNullParameter(this, "rootView");
        Intrinsics.checkNotNullParameter(r810, "source");
        if (Intrinsics.areEqual(r139.f544097g, Boolean.TRUE) == false) goto L128;
        t19.s r140 = t19.s.f544207a;
        String r141 = r125.getString(R.string.larus_showcase_unsupportedFeatures_toast_cn);
        if (r141 != null) goto L127;
        r141 = "";
    L127:
        r140.getClass();
        t19.s.t(r125, r141);
        return;
    L128:
        ShareServiceDelegate r142 = ShareServiceDelegate.f313831b;
        JSONObject r143 = r139.f544096f;
        if (r143 == null) goto L144;
        r143.put("click_method", r810);
        Integer r144 = r139.f544093c;
        if (r144 != null) goto L134;
    L136:
        int r145 = 0;
    L137:
        r143.put("is_replica_gen", r145);
        Integer r146 = r139.f544093c;
        if (r146 != null) goto L141;
    L143:
        r143.put("is_image_edit", r138);
        r143.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, "picture");
    L145:
        r142.w(r143);
        if (CreationGalleryUtil.j(r139.f544093c) == false) goto L150;
        CoroutineScope r147 = r139.f544101k;
        if (r147 == null) goto L156;
        BuildersKt.launch$default(r147, null, null, new CreationGalleryUtil$showCreationShare$1(this, r139, "share", null), 3, null);
        return;
    L156:
        return;
    L150:
        Uri r148 = r139.f544092b;
        if (r148 == null) goto L158;
        CreationGalleryUtil.h(r148.toString(), true, r139, r125, "doShare", null);
        return;
    L158:
        return;
    L141:
        if (r146.intValue() != 4) goto L143;
        r138 = 1;
        goto L143
    L134:
        if (r144.intValue() != 3) goto L136;
        r145 = 1;
        goto L137
    L144:
        r143 = null;
        goto L145
    L121:
        r217 = null;
        goto L122
    L116:
        if (r134.f544075y != true) goto L118;
        r216 = true;
        goto L119
    L112:
        r137 = null;
        goto L113
    L109:
        r215 = null;
        goto L110
    L105:
        r135 = null;
        goto L106
    L101:
        r133 = null;
        goto L102
    L98:
        r132 = null;
        goto L99
    L95:
        r131 = null;
        goto L96
    L92:
        r130 = null;
        goto L93
    L89:
        r129 = null;
        goto L90
    L86:
        r128 = null;
        goto L87
    L83:
        r127 = null;
        goto L84
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.larus.im.bean.message.Message] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r26v1 */
    /* JADX WARN: Type inference failed for: r26v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r28v1 */
    /* JADX WARN: Type inference failed for: r28v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r28v3 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v16, types: [rz9.d] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r44v0, types: [android.view.ViewGroup, com.larus.uaigc.creation.gallery.providers.CreationBottomView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.im.bean.message.Message] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.larus.platform.service.e0] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27, types: [com.larus.im.bean.message.Message] */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.larus.im.bean.message.Message] */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Object R5(CreationBottomView r410, Continuation r411) {
        r410.getClass();
        if ((r411 instanceof CreationBottomView$addCreation$1) == false) goto L7;
        CreationBottomView$addCreation$1 r100 = (CreationBottomView$addCreation$1) r411;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        Continuation r111 = null;
        String r104 = "recommend_from";
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L16;
        int r105 = r100.I$0;
        zp9.a r106 = (zp9.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r210 = "";
        r104 = "recommend_from";
        String r211 = "template_rec_req_id";
        r111 = r111;
        boolean r112 = true;
    L106:
        sz9.a r107 = r410.f372878d;
        if (r107 == null) goto L109;
        ?? r108 = r107.f544072v;
    L110:
        String r109 = r210;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationBottomView$reportPicAddCreation$1(r108, false, r109, r111), 3, null);
        zp9.a r113 = r106;
        ?? r114 = r111;
    L153:
        if (r113 != null) goto L155;
    L157:
        boolean r115 = false;
    L158:
        if (r115 == false) goto L164;
        if (r113 == null) goto L163;
        UserCreation r116 = r113.f573206b;
        if (r116 == null) goto L163;
        ?? r212 = r116.f364987a;
    L165:
        sz9.a r117 = r410.f372878d;
        if (r117 == null) goto L168;
        ?? r213 = r117.f544056f;
    L169:
        if (r117 == null) goto L173;
        Message r118 = r117.f544072v;
        if (r118 == null) goto L173;
        ?? r214 = r118.getMessageId();
    L174:
        String r215 = r410.getCreationTypeString();
        if (r105 != 2) goto L177;
        String r119 = "0";
    L178:
        String r310 = r119;
        sz9.a r120 = r410.f372878d;
        if (r120 == null) goto L183;
        JSONObject r121 = r120.f544071u;
        if (r121 == null) goto L183;
        ?? r122 = r121.opt(r104);
    L184:
        String r311 = String.valueOf(r122);
        sz9.a r123 = r410.f372878d;
        if (r123 == null) goto L189;
        JSONObject r124 = r123.f544071u;
        if (r124 == null) goto L189;
        ?? r125 = r124.opt("from_template_id");
    L190:
        String r312 = String.valueOf(r125);
        sz9.a r126 = r410.f372878d;
        if (r126 == null) goto L195;
        JSONObject r127 = r126.f544071u;
        if (r127 == null) goto L195;
        ?? r128 = r127.opt("template_rec_extra");
    L196:
        String r313 = String.valueOf(r128);
        sz9.a r129 = r410.f372878d;
        if (r129 == null) goto L201;
        JSONObject r130 = r129.f544071u;
        if (r130 == null) goto L201;
        ?? r131 = r130.opt(r211);
    L202:
        e2.a.b(new o0("picture_detail", "chat", r212, r213, r214, r215, "-1", r310, r311, r312, String.valueOf(r131), r313, null, null, null, null, null, null, 516097), r114, 3);
        return Unit.INSTANCE;
    L201:
        r131 = r114;
    L195:
        r128 = r114;
    L189:
        r125 = r114;
    L183:
        r122 = r114;
        goto L184
    L177:
        r119 = "1";
    L173:
        r214 = r114;
        goto L174
    L168:
        r213 = r114;
    L163:
        r212 = r114;
        goto L165
    L164:
        r212 = r109;
        goto L165
    L155:
        if (r113.f573205a != r112) goto L157;
        r115 = true;
        goto L158
    L109:
        r108 = r111;
        goto L110
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r132 = r100.I$1;
        int r133 = r100.I$0;
        ResultKt.throwOnFailure(r102);
        r210 = "";
        r211 = "template_rec_req_id";
        r112 = true;
        int r134 = r132;
        r105 = r133;
    L95:
        r113 = (zp9.a) r102;
        if (r113 != null) goto L98;
    L100:
        boolean r135 = false;
    L101:
        if (r135 == true) goto L111;
        MainCoroutineDispatcher r136 = Dispatchers.getMain();
        CreationBottomView$addCreation$3 r137 = new CreationBottomView$addCreation$3(r410, r113, r111);
        r100.L$0 = r113;
        r100.I$0 = r105;
        r100.label = 4;
        if (BuildersKt.withContext(r136, r137, r100) == r110) goto L208;
        r106 = r113;
        goto L106
    L208:
        return r110;
    L111:
        r109 = r210;
        sz9.a r138 = r410.f372878d;
        if (r138 == null) goto L114;
        ?? r139 = r138.f544072v;
    L115:
        if (r113 == null) goto L119;
        UserCreation r140 = r113.f573206b;
        if (r140 == null) goto L119;
        ?? r141 = r140.f364987a;
    L120:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationBottomView$reportPicAddCreation$1(r139, r112, r141, r111), 3, null);
        t19.s r142 = t19.s.f544207a;
        Context r143 = r410.getContext();
        Context r144 = r410.getContext();
        if (r144 == null) goto L126;
        Resources r145 = r144.getResources();
        if (r145 == null) goto L126;
        String r146 = r145.getString(R.string.larus_ccMob_PreviewPage_toast_madePublic);
        if (r146 == null) goto L126;
    L127:
        r142.getClass();
        t19.s.p(r143, r146);
        sz9.a r147 = r410.f372878d;
        if (r147 == null) goto L130;
        r147.f544053c = r134;
    L130:
        if (r147 == null) goto L138;
        if (r113 == null) goto L136;
        UserCreation r148 = r113.f573206b;
        if (r148 == null) goto L136;
        String r149 = r148.f364987a;
        if (r149 == null) goto L136;
    L137:
        Intrinsics.checkNotNullParameter(r149, "<set-?>");
        r147.f544066p = r149;
    L136:
        r149 = r109;
    L138:
        ?? r150 = r410.f372877c;
        if (r150 == 0) goto L153;
        sz9.a r151 = r410.f372878d;
        if (r151 == null) goto L143;
        ?? r152 = r151.f544055e;
    L144:
        if (r152 != 0) goto L146;
        r152 = r109;
    L146:
        if (r113 == null) goto L151;
        UserCreation r153 = r113.f573206b;
        if (r153 == null) goto L151;
        String r154 = r153.f364987a;
        if (r154 == null) goto L151;
    L152:
        r150.b(r152, r154, r105);
    L151:
        r154 = r109;
        goto L152
    L143:
        r152 = r111;
    L126:
        r146 = r109;
    L119:
        r141 = r111;
        goto L120
    L114:
        r139 = r111;
        goto L115
    L98:
        if (r113.f573205a != r112) goto L100;
        r135 = true;
        goto L101
    L18:
        int r155 = r100.I$1;
        int r156 = r100.I$0;
        PublisherCreation r157 = (PublisherCreation) r100.L$0;
        ResultKt.throwOnFailure(r102);
        int r158 = r155;
        PublisherCreation r159 = r157;
        int r160 = r156;
    L46:
        sz9.a r161 = r410.f372878d;
        if (r161 == null) goto L49;
        ?? r162 = r161.f544072v;
    L50:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationBottomView$reportPicClickAddCreation$1(r162, r410, r111), 3, null);
        ?? r163 = e0.f365731a;
        sz9.a r164 = r410.f372878d;
        if (r164 == null) goto L56;
        Message r165 = r164.f544072v;
        if (r165 == null) goto L56;
        String r166 = r165.getMessageId();
        if (r166 == null) goto L56;
    L57:
        sz9.a r167 = r410.f372878d;
        if (r167 == null) goto L65;
        Integer r168 = r167.f544058h;
        if (r168 == null) goto L65;
        if (r168.intValue() != 3) goto L65;
        boolean r169 = true;
    L66:
        if (r169 == false) goto L68;
        int r170 = 3;
    L80:
        sz9.a r171 = r410.f372878d;
        if (r171 == null) goto L83;
        Object r172 = r171.f544057g;
    L84:
        if (r171 == null) goto L86;
        Object r173 = r171.f544056f;
    L87:
        int r174 = r410.getCreateCreationSource();
        if (r159 == null) goto L90;
        Object r216 = r159.getMaterialId();
    L91:
        r100.L$0 = r111;
        r100.I$0 = r160;
        r100.I$1 = r158;
        r100.label = 3;
        int r217 = r160;
        r211 = "template_rec_req_id";
        r112 = true;
        r210 = "";
        Object r175 = r163.l(r166, r170, r172, r217, r173, r174, r216, r100);
        if (r175 == r110) goto L207;
        r134 = r158;
        r102 = r175;
        r105 = r217;
        goto L95
    L207:
        return r110;
    L90:
        r216 = r111;
        goto L91
    L86:
        r173 = r111;
        goto L87
    L83:
        r172 = r111;
        goto L84
    L68:
        sz9.a r176 = r410.f372878d;
        if (r176 == null) goto L76;
        Integer r177 = r176.f544058h;
        if (r177 == null) goto L76;
        if (r177.intValue() != 4) goto L76;
        boolean r178 = true;
    L77:
        if (r178 == false) goto L79;
        r170 = 4;
        goto L80
    L79:
        r170 = 2;
    L76:
        r178 = false;
    L65:
        r169 = false;
    L56:
        r166 = "";
        goto L57
    L49:
        r162 = r111;
        goto L50
    L19:
        ResultKt.throwOnFailure(r102);
    L23:
        PublisherCreation r179 = (PublisherCreation) r102;
        if (r410.b6() == false) goto L42;
        new u1();
        sz9.a r180 = r410.f372878d;
        if (r180 == null) goto L30;
        JSONObject r181 = r180.f544071u;
        if (r181 == null) goto L30;
        Object r182 = r181.opt("recommend_from");
    L31:
        String r183 = String.valueOf(r182);
        sz9.a r184 = r410.f372878d;
        if (r184 == null) goto L36;
        JSONObject r185 = r184.f544071u;
        if (r185 == null) goto L36;
        Object r186 = r185.opt("template_rec_req_id");
    L37:
        u1.a(r179, new PublisherTrackParams("picture_detail", r183, String.valueOf(r186)));
        FLogger.f375446a.i(r410.f372876b, "addCreation gotoPublisher");
        sz9.a r187 = r410.f372878d;
        if (r187 == null) goto L40;
        ?? r188 = r187.f544072v;
    L41:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationBottomView$reportPicClickAddCreation$1(r188, r410, r111), 3, null);
        return Unit.INSTANCE;
    L40:
        r188 = r111;
    L36:
        r186 = r111;
    L30:
        r182 = r111;
        goto L31
    L42:
        MainCoroutineDispatcher r189 = Dispatchers.getMain();
        CreationBottomView$addCreation$2 r190 = new CreationBottomView$addCreation$2(r410, 3, r111);
        r100.L$0 = r179;
        r100.I$0 = 1;
        r100.I$1 = 3;
        r100.label = 2;
        if (BuildersKt.withContext(r189, r190, r100) == r110) goto L206;
        r159 = r179;
        r158 = 3;
        r160 = 1;
        goto L46
    L206:
        return r110;
    L20:
        ResultKt.throwOnFailure(r102);
        r100.label = 1;
        r102 = r410.Z5(r100);
        if (r102 != r110) goto L23;
        return r110;
    L7:
        r100 = new CreationBottomView$addCreation$1(r410, r411);
        goto L8
    }

    public final void k6(Integer r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        r102.i(this.f372876b, "refreshButtonStatus " + r100 + " from:" + r101);
        if (r100 == null) goto L24;
        r100.intValue();
        int r103 = 0;
        if (com.larus.bmhome.utils.u.h() == true) goto L7;
    L16:
        boolean r104 = false;
    L17:
        r102.i(this.f372876b, "refreshButtonStatus enable " + r104);
        CreationOperateContainerView r105 = this.f372875a.f373213c;
        if (r104 == false) goto L20;
        r103 = r100.intValue();
    L20:
        r105.r1(r103);
        sz9.a r106 = this.f372878d;
        if (r106 == null) goto L25;
        r106.f544063m = r100.intValue();
        return;
    L25:
        return;
    L7:
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L16;
        sz9.a r107 = this.f372878d;
        r104 = true;
        if (r107 != null) goto L11;
    L13:
        boolean r108 = false;
    L14:
        if (r108 == false) goto L16;
    L11:
        if (r107.f544062l == true) goto L13;
        r108 = true;
        goto L14
    }

    public CreationBottomView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_creation_bottom, this);
        int r103 = R.id.ai_beautify_layout;
        CommonAiBeautifyLayout r104 = (CommonAiBeautifyLayout) ViewBindings.findChildViewById(this, R.id.ai_beautify_layout);
        if (r104 == null) goto L15;
        r103 = R.id.creation_view;
        CreationOperateContainerView r105 = (CreationOperateContainerView) ViewBindings.findChildViewById(this, R.id.creation_view);
        if (r105 == null) goto L15;
        r103 = R.id.download_layout;
        CommonDownLoadLayout r106 = (CommonDownLoadLayout) ViewBindings.findChildViewById(this, R.id.download_layout);
        if (r106 == null) goto L15;
        this.f372875a = new LarusLayoutCreationBottomBinding(this, r104, r105, r106);
        this.f372876b = "CreationBottomView";
        this.f372879e = CoroutineScopeKt.MainScope();
        this.f372881g = LazyKt.lazy(new d(r100));
        e1.d(r106, new e(this));
        r105.setByPublisher(b6());
        final View r107 = r105.findViewById(R.id.privacy_button_container);
        View r108 = r105.findViewById(R.id.publish_container);
        if (r107 == null) goto L11;
        e1.d(r107, new f(this, r107));
    L11:
        if (r108 == null) goto L16;
        e1.d(r108, new g(this));
        return;
    L16:
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public static final Object V5(CreationBottomView r310, boolean r311, Continuation r312) {
        r310.getClass();
        if ((r312 instanceof CreationBottomView$setCreationPrivacy$1) == false) goto L7;
        CreationBottomView$setCreationPrivacy$1 r100 = (CreationBottomView$setCreationPrivacy$1) r312;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = null;
        String r110 = "";
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        ResultKt.throwOnFailure(r102);
    L159:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r106 = r100.I$2;
        int r107 = r100.I$1;
        int r108 = r100.I$0;
        ResultKt.throwOnFailure(r102);
    L109:
        Pair r109 = (Pair) r102;
        if (r109 == null) goto L112;
        Boolean r111 = (Boolean) r109.getFirst();
    L114:
        if (Intrinsics.areEqual(r111, Boxing.boxBoolean(true)) == true) goto L118;
        MainCoroutineDispatcher r112 = Dispatchers.getMain();
        CreationBottomView$setCreationPrivacy$3 r113 = new CreationBottomView$setCreationPrivacy$3(r310, r108, null);
        r100.label = 4;
        if (BuildersKt.withContext(r112, r113, r100) != r103) goto L159;
        return r103;
    L118:
        if (r107 != 2) goto L124;
        Context r114 = r310.getContext();
        if (r114 == null) goto L129;
        Resources r115 = r114.getResources();
        if (r115 == null) goto L129;
        String r116 = r115.getString(R.string.larus_ccMob_PreviewPage_toast_madePrivate);
    L130:
        t19.s r117 = t19.s.f544207a;
        Context r118 = r310.getContext();
        if (r116 != null) goto L133;
        r116 = "";
    L133:
        r117.getClass();
        t19.s.p(r118, r116);
        if (r107 != 2) goto L142;
        e0 r119 = e0.f365731a;
        sz9.a r120 = r310.f372878d;
        if (r120 == null) goto L138;
        String r121 = r120.f544066p;
    L139:
        if (r121 != null) goto L141;
        r121 = "";
    L141:
        r119.X0(r121);
        goto L142
    L138:
        r121 = null;
    L142:
        sz9.a r122 = r310.f372878d;
        if (r122 == null) goto L145;
        r122.f544053c = r106;
    L145:
        rz9.d r123 = r310.f372877c;
        if (r123 == null) goto L159;
        if (r122 == null) goto L149;
        String r124 = r122.f544066p;
    L150:
        if (r124 != null) goto L152;
        r124 = "";
    L152:
        if (r122 == null) goto L154;
        r105 = r122.f544055e;
    L154:
        if (r105 == null) goto L157;
        r110 = r105;
    L157:
        r123.a(r124, r110, r107);
        goto L159
    L149:
        r124 = null;
    L129:
        r116 = null;
        goto L130
    L124:
        Context r125 = r310.getContext();
        if (r125 == null) goto L129;
        Resources r126 = r125.getResources();
        if (r126 == null) goto L129;
        r116 = r126.getString(R.string.larus_ccMob_PreviewPage_toast_madePublic);
        goto L130
    L112:
        r111 = null;
        goto L114
    L18:
        r106 = r100.I$2;
        r107 = r100.I$1;
        int r127 = r100.I$0;
        boolean r128 = r100.Z$0;
        ResultKt.throwOnFailure(r102);
    L57:
        sz9.a r129 = r310.f372878d;
        if (r129 == null) goto L60;
        String r130 = r129.f544066p;
    L61:
        if (r129 == null) goto L63;
        String r210 = r129.f544056f;
    L64:
        if (r129 == null) goto L68;
        Message r131 = r129.f544072v;
        if (r131 == null) goto L68;
        String r211 = r131.getMessageId();
    L69:
        String r212 = r310.getCreationTypeString();
        if (r128 == false) goto L72;
        String r213 = "1";
    L73:
        if (r128 == false) goto L75;
        String r214 = "0";
    L76:
        sz9.a r132 = r310.f372878d;
        if (r132 == null) goto L81;
        JSONObject r133 = r132.f544071u;
        if (r133 == null) goto L81;
        Object r134 = r133.opt("recommend_from");
    L82:
        String r215 = String.valueOf(r134);
        sz9.a r135 = r310.f372878d;
        if (r135 == null) goto L87;
        JSONObject r136 = r135.f544071u;
        if (r136 == null) goto L87;
        Object r137 = r136.opt("from_template_id");
    L88:
        String r216 = String.valueOf(r137);
        sz9.a r138 = r310.f372878d;
        if (r138 == null) goto L93;
        JSONObject r139 = r138.f544071u;
        if (r139 == null) goto L93;
        Object r140 = r139.opt("template_rec_extra");
    L94:
        String r217 = String.valueOf(r140);
        sz9.a r141 = r310.f372878d;
        if (r141 == null) goto L99;
        JSONObject r142 = r141.f544071u;
        if (r142 == null) goto L99;
        Object r143 = r142.opt("template_rec_req_id");
    L100:
        e2.a.b(new o0("picture_detail", "chat", r130, r210, r211, r212, r213, r214, r215, r216, String.valueOf(r143), r217, null, null, null, null, null, null, 516097), null, 3);
        e0 r144 = e0.f365731a;
        sz9.a r145 = r310.f372878d;
        if (r145 == null) goto L104;
        String r146 = r145.f544066p;
        if (r146 == null) goto L104;
    L105:
        r100.I$0 = r127;
        r100.I$1 = r107;
        r100.I$2 = r106;
        r100.label = 3;
        r102 = r144.h(r146, r107, r100);
        if (r102 == r103) goto L163;
        r108 = r127;
        goto L109
    L163:
        return r103;
    L104:
        r146 = "";
    L99:
        r143 = null;
    L93:
        r140 = null;
    L87:
        r137 = null;
    L81:
        r134 = null;
        goto L82
    L75:
        r214 = "1";
        goto L76
    L72:
        r213 = "0";
    L68:
        r211 = null;
        goto L69
    L63:
        r210 = null;
        goto L64
    L60:
        r130 = null;
        goto L61
    L19:
        u1 r147 = (u1) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L27:
        PublisherCreation r148 = (PublisherCreation) r102;
        sz9.a r149 = r310.f372878d;
        if (r149 == null) goto L32;
        JSONObject r150 = r149.f544071u;
        if (r150 == null) goto L32;
        Object r151 = r150.opt("recommend_from");
    L33:
        String r152 = String.valueOf(r151);
        sz9.a r153 = r310.f372878d;
        if (r153 == null) goto L38;
        JSONObject r154 = r153.f544071u;
        if (r154 == null) goto L38;
        Object r155 = r154.opt("template_rec_req_id");
    L39:
        PublisherTrackParams r156 = new PublisherTrackParams("picture_detail", r152, String.valueOf(r155));
        r147.getClass();
        u1.a(r148, r156);
        FLogger.f375446a.i(r310.f372876b, "setCreationPrivacy gotoPublisher");
        sz9.a r157 = r310.f372878d;
        if (r157 == null) goto L42;
        Message r158 = r157.f544072v;
    L43:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationBottomView$reportPicClickAddCreation$1(r158, r310, null), 3, null);
        return Unit.INSTANCE;
    L42:
        r158 = null;
    L38:
        r155 = null;
    L32:
        r151 = null;
        goto L33
    L20:
        ResultKt.throwOnFailure(r102);
        if (r311 == false) goto L23;
    L44:
        if (r311 == false) goto L46;
        int r159 = 3;
    L47:
        if (r311 == false) goto L49;
        r107 = 2;
    L50:
        if (r311 == false) goto L52;
        int r160 = 2;
    L53:
        MainCoroutineDispatcher r161 = Dispatchers.getMain();
        CreationBottomView$setCreationPrivacy$2 r162 = new CreationBottomView$setCreationPrivacy$2(r310, r160, null);
        r100.Z$0 = r311;
        r100.I$0 = r159;
        r100.I$1 = r107;
        r100.I$2 = r160;
        r100.label = 2;
        if (BuildersKt.withContext(r161, r162, r100) == r103) goto L162;
        r128 = r311;
        r106 = r160;
        r127 = r159;
        goto L57
    L162:
        return r103;
    L52:
        r160 = 3;
        goto L53
    L49:
        r107 = 1;
        goto L50
    L46:
        r159 = 2;
        goto L47
    L23:
        if (r310.b6() == false) goto L44;
        r147 = new u1();
        r100.L$0 = r147;
        r100.label = 1;
        r102 = r310.Z5(r100);
        if (r102 != r103) goto L27;
        return r103;
    L7:
        r100 = new CreationBottomView$setCreationPrivacy$1(r310, r312);
        goto L8
    }

    public final void n6(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "creationId");
        Intrinsics.checkNotNullParameter(r102, "from");
        FLogger.f375446a.i(this.f372876b, "updateCurrentCreationButtonStatus status=" + r100 + ", creationId=" + r101 + ", from=" + r102);
        sz9.a r103 = this.f372878d;
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L11;
        e1.o(this.f372875a.f373213c);
        return;
    L11:
        IFlowCreationThemeConfigProvider r105 = (IFlowCreationThemeConfigProvider) ServiceManager.get().getService(IFlowCreationThemeConfigProvider.class);
        Integer r106 = null;
        if (r105 == null) goto L14;
        Boolean r107 = Boolean.valueOf(r105.a(this.f372875a.f373213c, AdaptThemeFeatureKey.CREATION_GO_PUBLISH));
    L16:
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == true) goto L29;
        e1.x(this.f372875a.f373213c);
        sz9.a r108 = this.f372878d;
        if (r108 == null) goto L20;
        r108.f544063m = r100;
    L20:
        if (r108 == null) goto L22;
        r108.f544053c = r100;
    L22:
        if (r108 == null) goto L24;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r108.f544066p = r101;
    L24:
        sz9.a r109 = this.f372878d;
        if (r109 == null) goto L27;
        r106 = Integer.valueOf(r109.f544063m);
    L27:
        k6(r106, r102);
        return;
    L29:
        return;
    L14:
        r107 = null;
        goto L16
    L5:
        if (r103.f544060j == true) goto L7;
        r104 = true;
        goto L8
    }

    public /* synthetic */ CreationBottomView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
