package com.larus.bmhome.chat.list.cell.record;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.j0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxCheckboxSlotCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.holder.helper.w0;
import com.larus.bmhome.chat.layout.item.RecordStatus;
import com.larus.bmhome.chat.layout.item.u3;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i2;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import ic8.p0;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\\B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J4\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020*0)0(2\u0006\u0010&\u001a\u00020%2\u0014\u0010+\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020*0)0,H\u0016J \u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020%H\u0016J\u0018\u00102\u001a\u00020.2\u0006\u0010\"\u001a\u00020#2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020.2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\t2\u0006\u00103\u001a\u000204H\u0002J\u0014\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u000107H\u0002J\u0018\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020:2\u0006\u00103\u001a\u000204H\u0002JA\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002072\n\b\u0002\u0010B\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010C\u001a\u0004\u0018\u0001072\n\b\u0002\u00106\u001a\u0004\u0018\u000107H\u0002¢\u0006\u0002\u0010DJ\b\u0010E\u001a\u00020.H\u0017J\b\u0010F\u001a\u00020.H\u0016J\b\u0010G\u001a\u00020.H\u0016J\u0016\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020J2\u0006\u00103\u001a\u000204J<\u0010K\u001a\u00020.2\u0006\u0010\"\u001a\u00020#2\b\u0010L\u001a\u0004\u0018\u0001072\b\b\u0002\u0010M\u001a\u00020J2\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002072\u0006\u0010P\u001a\u000207H\u0002JQ\u0010Q\u001a\u00020.2\u0006\u0010R\u001a\u0002072\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002072*\u0010S\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020V0U0T\"\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020V0UH\u0002¢\u0006\u0002\u0010WJ\u0018\u0010X\u001a\u00020.2\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u000207H\u0002J\u0012\u0010Y\u001a\u0002072\b\u0010Z\u001a\u0004\u0018\u00010@H\u0002J\u0012\u0010[\u001a\u0002072\b\u0010Z\u001a\u0004\u0018\u00010@H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e¨\u0006]"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/record/RecordCardCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/list/cell/record/RecordCardCellState;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "recordCardBox", "Lcom/larus/bmhome/chat/layout/item/RecordCardBox;", "audioListener", "Lcom/larus/audio/bean/IAiNoteRecordingStatusListener;", "appListener", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", DyPayConstant.KEY_START_TIME, "", "aiNoteManager", "Lcom/larus/audio/IAiNote;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "chatListComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListComponentAbility$delegate", "onCreateBoxView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "", "boxType", "getMessageSlotCells", "", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/list/arch/IFlowListCellState;", "default", "", "onBindView", "", "view", "state", "position", "sendRecordText", "message", "Lcom/larus/im/bean/message/Message;", "stopRecord", "source", "", "getListener", "convertDataBean", "Lcom/larus/bmhome/chat/bean/RecordCardData;", "content", "handleSpecialSituation", "recordCardData", "callRemoteStatusChange", "status", "Lcom/larus/bmhome/chat/layout/item/RecordStatus;", "messageId", "duration", "meetingId", "(Lcom/larus/bmhome/chat/layout/item/RecordStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", WidgetCostModule.TYPE_ON_START, "onViewAttachedToWindow", "onViewDetachedFromWindow", "onReportVisibleChange", "visible", "", "openDetailPage", "id", "autoPlay", RemoteMessageConst.MSGID, "cvsId", "area", "reportRecordCardEvent", "event", "others", "", "Lkotlin/Pair;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lkotlin/Pair;)V", "reportRecordCardDuration", "getReportCardStatus", "recordStatus", "getButtonClickType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordCardCell extends BaseMessageListCell<k> implements LifecycleObserver {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map<String, Long> f305742m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f305743n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map<String, Integer> f305744o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set<String> f305745p = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u3 f305746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnonymousClass2 f305747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f305748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f305749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j0 f305750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f305751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f305752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f305753l;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            AudioServiceDelegate r101 = AudioServiceDelegate.f288288a;
            if (r101.P().isRecording() == false) goto L6;
            FLogger.f375446a.i("RecordCardBox", "user logout, stop recording");
            r101.P().a("user logout");
            return;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class b {
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
            RecordCardCell.f305742m.put(r100, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f305754a = null;

        static {
            int[] r100 = new int[RecordStatus.values().length];
            r100[RecordStatus.UNAUTHORIZED_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L49:
            r100[RecordStatus.EarlyEndError.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L59:
            r100[RecordStatus.RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r100[RecordStatus.Connecting.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[RecordStatus.RECORD_ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L45:
            r100[RecordStatus.RECORD_FINISHED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L55:
            r100[RecordStatus.RecordInterruptedFinish.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[RecordStatus.OFFLINE_ASR_ING.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L51:
            r100[RecordStatus.SUMMARY_GENERATING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L53:
            r100[RecordStatus.SUMMARY_READY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L35:
            r100[RecordStatus.OfflineASRError.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
        L47:
            r100[RecordStatus.SecurityRiskControlError.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L57:
            r100[RecordStatus.SUMMARY_GENERATE_ERROR.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L33:
            r100[RecordStatus.AVAILABLE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L17:
            f305754a = r100;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class d implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordCardCell f305755a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            RecordCardCell r100 = this.f305755a;
            k r101 = (k) r100.f297618d;
            if (r101 == null) goto L15;
            Message r102 = r101.f563233a;
            if (r102 == null) goto L16;
            String r103 = r102.getMessageId();
            String r104 = "";
            if (r103 != null) goto L9;
            r103 = "";
        L9:
            String r105 = r102.getConversationId();
            if (r105 == null) goto L13;
            r104 = r105;
        L13:
            Map<String, Long> r106 = RecordCardCell.f305742m;
            r100.w(r103, r104);
            return;
        L16:
            return;
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            RecordCardCell r100 = this.f305755a;
            k r101 = (k) r100.f297618d;
            if (r101 == null) goto L18;
            Message r102 = r101.f563233a;
            if (r102 == null) goto L19;
            Map<String, Long> r103 = RecordCardCell.f305742m;
            String r104 = r102.getMessageId();
            String r105 = "";
            if (r104 != null) goto L9;
            r104 = "";
        L9:
            b.a(r104);
            String r106 = r102.getMessageId();
            if (r106 != null) goto L12;
            r106 = "";
        L12:
            String r107 = r102.getConversationId();
            if (r107 == null) goto L16;
            r105 = r107;
        L16:
            r100.x("voice_note_card_show", r106, r105, new Pair[0]);
            return;
        L19:
            return;
        }

        public d(RecordCardCell r100) {
            this.f305755a = r100;
        }
    }

    static {
        AccountService.f365697a.E(new a());
        f305742m = new LinkedHashMap();
        f305743n = "";
        f305744o = new LinkedHashMap();
        f305745p = new LinkedHashSet();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        u3 r100 = this.f305746e;
        if (r100 == null) goto L5;
        RecordStatus r101 = r100.getRecordStatus();
    L7:
        if (r101 != RecordStatus.UNAUTHORIZED_ERROR) goto L12;
        u3 r102 = this.f305746e;
        if (r102 == null) goto L13;
        r102.o();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.bmhome.chat.list.cell.record.RecordCardCell$onViewAttachedToWindow$2, java.lang.Object, p68.c] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final void onViewAttachedToWindow() {
        u3 r100 = this.f305746e;
        RecordStatus r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getContext();
    L7:
        if ((r102 instanceof LifecycleOwner) == false) goto L9;
        LifecycleOwner r103 = (LifecycleOwner) r102;
    L10:
        if (r103 == null) goto L14;
        Lifecycle r104 = r103.getLifecycle();
        if (r104 == null) goto L14;
        r104.addObserver(this);
    L14:
        u3 r105 = this.f305746e;
        if (r105 == null) goto L18;
        r101 = r105.getRecordStatus();
    L18:
        if (r101 == RecordStatus.RECORDING) goto L20;
    L41:
        ?? r106 = new AnonymousClass2(this);
        this.f305747f = r106;
        j0 r107 = this.f305750i;
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.larus.audio.bean.IAiNoteRecordingStatusListener");
        r107.j(r106);
        this.f305748g = new d(this);
        f09.a r108 = AppHost.f326268a.a();
        d r109 = this.f305748g;
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.larus.common.apphost.lifecycle.ActivityStackManager.OnAppBackGroundListener");
        r108.j(r109);
        return;
    L20:
        if (this.f305750i.l() == true) goto L41;
        k r110 = (k) this.f297618d;
        if (r110 == null) goto L41;
        Message r111 = r110.f563233a;
        if (r111 == null) goto L41;
        if (o0.d(r111.getMessageId()) == false) goto L41;
        if (f305745p.contains(r111.getMessageId()) == true) goto L41;
        FLogger.f375446a.i("RecordCardBox", "restart after killed, update remote status");
        RecordStatus r112 = RecordStatus.RecordInterruptedFinish;
        String r113 = r111.getMessageId();
        String r114 = "";
        if (r113 != null) goto L32;
        String r115 = "";
    L33:
        r(this, r112, r115, null, "onViewAttachedToWindow", 12);
        String r116 = r111.getMessageId();
        if (r116 != null) goto L36;
        r116 = "";
    L36:
        String r117 = r111.getConversationId();
        if (r117 == null) goto L40;
        r114 = r117;
    L40:
        x("voice_note_recording_interrupted", r116, r114, new Pair[]{TuplesKt.to("error_type", "not_audio_but_msg")});
        goto L41
    L32:
        r115 = r113;
        goto L33
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final void onViewDetachedFromWindow() {
        FLogger.f375446a.i("RecordCardBox", "cell detached from window");
        ((LinkedHashMap) f305744o).clear();
        u3 r100 = this.f305746e;
        if (r100 == null) goto L5;
        Object r101 = r100.getContext();
    L7:
        if ((r101 instanceof LifecycleOwner) == false) goto L9;
        LifecycleOwner r102 = (LifecycleOwner) r101;
    L10:
        if (r102 == null) goto L15;
        Lifecycle r103 = r102.getLifecycle();
        if (r103 == null) goto L15;
        r103.removeObserver(this);
    L15:
        if (this.f305747f == null) goto L18;
        j0 r104 = AudioServiceDelegate.f288288a.P();
        AnonymousClass2 r105 = this.f305747f;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.larus.audio.bean.IAiNoteRecordingStatusListener");
        r104.k(r105);
        this.f305747f = null;
    L18:
        if (this.f305748g == null) goto L20;
        f09.a r106 = AppHost.f326268a.a();
        d r107 = this.f305748g;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.larus.common.apphost.lifecycle.ActivityStackManager.OnAppBackGroundListener");
        r106.c(r107);
        this.f305748g = null;
    L20:
        k r108 = (k) this.f297618d;
        if (r108 == null) goto L33;
        Message r109 = r108.f563233a;
        if (r109 == null) goto L34;
        String r110 = r109.getMessageId();
        String r111 = "";
        if (r110 != null) goto L27;
        r110 = "";
    L27:
        String r112 = r109.getConversationId();
        if (r112 == null) goto L31;
        r111 = r112;
    L31:
        w(r110, r111);
        return;
    L34:
        return;
    L33:
        return;
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    public RecordCardCell() {
        this.f305749h = System.currentTimeMillis();
        this.f305750i = AudioServiceDelegate.f288288a.P();
        this.f305751j = LazyKt.lazy(new com.larus.bmhome.chat.list.cell.record.a(this));
        this.f305752k = LazyKt.lazy(new com.larus.bmhome.chat.list.cell.record.b(this));
        this.f305753l = LazyKt.lazy(new com.larus.bmhome.chat.list.cell.record.c(this));
    }

    public static String s(RecordStatus r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L5:
        switch(r101) {
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L6;
            case 8: goto L9;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L7;
            default: goto L6;
        };
    L6:
        return "other";
    L7:
        return "summary_update_failed";
    L8:
        return "summary_complete";
    L9:
        return "recording_complete";
    L10:
        return "recording_error";
    L11:
        return PTYSocketStateCallback.CONNECTING;
    L12:
        return "recording";
    L4:
        r101 = c.f305754a[r100.ordinal()];
        goto L5
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final List<BaseMessageSlotCell<? extends ei9.f>> g(int r100, List<BaseMessageSlotCell<? extends ei9.f>> r101) {
        Intrinsics.checkNotNullParameter(r101, "default");
        return CollectionsKt.mutableListOf(new MessageInboxCheckboxSlotCell[]{new MessageInboxCheckboxSlotCell()});
    }

    public final void t(boolean r100, Message r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        FLogger.f375446a.i("RecordCardBox", "report visible change to " + r100 + ", msgId: " + r101.getMessageId());
        String r102 = "";
        if (r100 == false) goto L15;
        String r103 = r101.getMessageId();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        String r104 = r101.getConversationId();
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        x("voice_note_card_show", r103, r104, new Pair[0]);
        String r105 = r101.getMessageId();
        if (r105 == null) goto L14;
        r102 = r105;
    L14:
        b.a(r102);
        return;
    L15:
        String r106 = r101.getMessageId();
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        String r107 = r101.getConversationId();
        if (r107 == null) goto L22;
        r102 = r107;
    L22:
        w(r106, r102);
    }

    public final void w(String r100, String r101) {
        long r102 = System.currentTimeMillis();
        Long r103 = (Long) ((LinkedHashMap) f305742m).get(r100);
        if (r103 == null) goto L11;
        long r104 = r102 - r103.longValue();
        FLogger.f375446a.i("RecordCardBox", "report record stay duration: msgId: " + r100 + ", duration: " + r104);
        Pair<String, ? extends Object>[] r105 = new Pair[2];
        u3 r106 = this.f305746e;
        if (r106 == null) goto L12;
        RecordStatus r107 = r106.getRecordStatus();
        if (r107 == null) goto L13;
        r105[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, s(r107));
        r105[1] = TuplesKt.to("duration", Integer.valueOf((int) r104));
        x("voice_note_card_stay", r100, r101, r105);
        return;
    L13:
        return;
    L12:
        return;
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final View m(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        u3 r103 = new u3(r100);
        de8.c r104 = (de8.c) this.f305751j.getValue();
        if (r104 == null) goto L5;
        Integer r105 = r104.m();
    L6:
        r103.setImmerseBgColor(r105);
        r103.setBoxType(r102);
        this.f305746e = r103;
        return r103;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onBindView(View r110, ei9.f r111, int r112) {
        k r100 = (k) r111;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r100, "state");
        final Message r101 = r100.f563233a;
        String r102 = r101.getContent();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        q0.a r113 = null;
        if (r103 == false) goto L154;
    L16:
        final p0 r104 = null;
    L17:
        if (r104 == null) goto L157;
        FLogger r105 = FLogger.f375446a;
        r105.i("RecordCardBox", "GRecord updateRecordStatus bindData card status: " + r104.d() + ", msgId: " + r101.getMessageId());
        String r106 = r101.getMessageId();
        String r114 = "";
        if (r106 != null) goto L22;
        r106 = "";
    L22:
        Integer r107 = r104.d();
        Intrinsics.checkNotNullParameter(r106, "messageId");
        Map<String, Integer> r115 = f305744o;
        Integer r108 = (Integer) ((LinkedHashMap) r115).get(r106);
        if (r108 == null) goto L51;
        int r109 = r108.intValue();
        int r116 = RecordStatus.Connecting.getType();
        if (r107 != null) goto L28;
    L34:
        RecordStatus r117 = RecordStatus.RECORD_FINISHED;
        if (r109 != r117.getType()) goto L43;
        int r118 = RecordStatus.RECORDING.getType();
        if (r107 == null) goto L43;
        if (r107.intValue() != r118) goto L43;
        r105.i("RecordCardBox", "update from finish to recording, ignore");
    L50:
        boolean r119 = true;
    L52:
        if (r119 == false) goto L54;
        r105.i("RecordCardBox", "GRecord updateRecordStatus illegal status update, ignored");
        return;
    L54:
        u3 r120 = this.f305746e;
        if (r120 == null) goto L57;
        r120.m(r104);
    L57:
        Integer r121 = r104.d();
        int r122 = RecordStatus.Connecting.getType();
        if (r121 != null) goto L61;
    L62:
        Integer r123 = r104.d();
        int r124 = RecordStatus.AVAILABLE.getType();
        if (r123 != null) goto L66;
    L96:
        if (o0.d(f305743n) == true) goto L98;
    L113:
        Integer r125 = r104.d();
        int r126 = RecordStatus.RECORDING.getType();
        if (r125 != null) goto L117;
    L129:
        u3 r127 = this.f305746e;
        if (r127 == null) goto L132;
        r127.setAudioPlayButtonClick(new com.larus.bmhome.chat.list.cell.record.d(r104, r101, this));
    L132:
        u3 r128 = this.f305746e;
        if (r128 == null) goto L135;
        r128.setButtonClick(new e(this, r101, r104));
    L135:
        u3 r129 = this.f305746e;
        if (r129 == null) goto L138;
        r129.setRootClick(new f(this, r104, r101));
    L138:
        k r130 = (k) this.f297618d;
        if (r130 == null) goto L148;
        Message r131 = r130.f563233a;
        if (r131 == null) goto L148;
        u3 r132 = this.f305746e;
        if (r132 == null) goto L148;
        q0 r133 = lf8.a.b(this);
        q0 r134 = lf8.a.b(this);
        if (r134 == null) goto L147;
        r113 = r134.getProvider();
    L147:
        r132.setRootLongClick(new w0(new com.larus.bmhome.chat.layout.holder.helper.c(r131, r133, r113, new com.larus.bmhome.chat.layout.holder.helper.d())));
    L148:
        String r135 = r101.getMessageId();
        if (r135 == null) goto L152;
        r114 = r135;
    L152:
        r115.put(r114, r104.d());
        return;
    L117:
        if (r125.intValue() != r126) goto L129;
        if (this.f305750i.isRecording() == false) goto L129;
        if (o0.d(f305743n) == false) goto L129;
        if (Intrinsics.areEqual(r101.getMessageId(), f305743n) == true) goto L129;
        r105.i("RecordCardBox", "update not recording card status, msg: " + r101.getMessageId() + ", recording msg: " + r101.getMessageId());
        RecordStatus r136 = RecordStatus.RecordInterruptedFinish;
        String r137 = r101.getMessageId();
        if (r137 != null) goto L127;
        String r138 = "";
    L128:
        r(this, r136, r138, null, "handleSpecialSituation in cell update not recording card status", 12);
        goto L129
    L127:
        r138 = r137;
        goto L128
    L98:
        if (this.f305750i.isRecording() == false) goto L113;
        if (Intrinsics.areEqual(r101.getMessageId(), f305743n) == false) goto L113;
        Integer r139 = r104.d();
        int r140 = RecordStatus.RECORDING.getType();
        if (r139 != null) goto L105;
    L106:
        r105.i("RecordCardBox", "stop recording for mismatch card status: " + r104.d() + ", curr msg: " + r101.getMessageId());
        this.f305750i.a("stop by other device");
        String r141 = r101.getMessageId();
        if (r141 != null) goto L109;
        r141 = "";
    L109:
        String r142 = r101.getConversationId();
        if (r142 != null) goto L112;
        r142 = "";
    L112:
        x("voice_note_card_error", r141, r142, new Pair[]{TuplesKt.to("error_type", "not_msg_but_audio")});
        goto L113
    L105:
        if (r139.intValue() == r140) goto L113;
    L66:
        if (r123.intValue() != r124) goto L96;
    L68:
        if (Intrinsics.areEqual(f305743n, r101.getMessageId()) == false) goto L73;
        if (this.f305750i.isRecording() == false) goto L73;
        r105.i("RecordCardBox", "same card call recording, ignored, msgId: " + r101.getMessageId());
    L73:
        if (this.f305750i.isRecording() == false) goto L88;
        u3 r143 = this.f305746e;
        if (r143 == null) goto L77;
        s r144 = s.f544207a;
        Context r145 = r143.getContext();
        String r146 = AppHost.f326268a.getApplication().getString(R.string.larus_memo_record_recording_conflict_toast);
        r144.getClass();
        s.t(r145, r146);
    L77:
        RecordStatus r147 = RecordStatus.RECORD_ERROR;
        String r148 = r101.getMessageId();
        if (r148 != null) goto L80;
        String r149 = "";
    L81:
        r(this, r147, r149, null, "handleSpecialSituation in cell aiNoteManager.isRecording()", 12);
        String r150 = r101.getMessageId();
        if (r150 != null) goto L84;
        r150 = "";
    L84:
        String r151 = r101.getConversationId();
        if (r151 != null) goto L87;
        r151 = "";
    L87:
        x("voice_note_card_error", r150, r151, new Pair[]{TuplesKt.to("error_type", "another_recording_card")});
        goto L129
    L80:
        r149 = r148;
        goto L81
    L88:
        i2 r152 = i2.f365748b;
        q0 r153 = lf8.a.b(this);
        if (r153 == null) goto L93;
        Function0<Fragment> r154 = r153.getHostFragment();
        if (r154 == null) goto L93;
        Fragment r155 = r154.invoke();
    L94:
        i2.q(r155, CollectionsKt.arrayListOf(new String[]{"android.permission.RECORD_AUDIO"}), new g(this, r101));
    L93:
        r155 = null;
        goto L94
    L61:
        if (r121.intValue() == r122) goto L68;
    L43:
        if (r109 != RecordStatus.RECORD_ERROR.getType()) goto L51;
        int r156 = r117.getType();
        if (r107 == null) goto L51;
        if (r107.intValue() != r156) goto L51;
        r105.i("RecordCardBox", "update from RECORD_ERROR to " + r107 + ", ignore");
        goto L50
    L28:
        if (r107.intValue() != r116) goto L34;
        if (r109 == RecordStatus.EarlyEndError.getType()) goto L34;
        if (r109 == RecordStatus.UNAUTHORIZED_ERROR.getType()) goto L34;
        r105.i("RecordCardBox", "update from " + r109 + " to connecting, ignore");
    L51:
        r119 = false;
        goto L52
    L157:
        return;
    L154:
        r104 = (p0) GsonProtectorUtils.fromJson(new Gson(), r102, p0.class);     // Catch: JsonSyntaxException -> L14
    L14:
        e = move-exception;
        FLogger.f375446a.e("RecordCardBox", "convertDataBean:" + r102, e);
        goto L16
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final void x(String r100, String r101, String r102, Pair<String, ? extends Object>... r103) {
        JSONObject r104 = new JSONObject();
        q0 r105 = lf8.a.b(this);
        String r106 = "";
        if (r105 == null) goto L8;
        ChatParam r107 = r105.getChatParam();
        if (r107 == null) goto L8;
        String r108 = r107.f296892d;
        if (r108 == null) goto L8;
    L9:
        r104.put("current_page", r108);
        q0 r109 = lf8.a.b(this);
        if (r109 == null) goto L15;
        ChatParam r110 = r109.getChatParam();
        if (r110 == null) goto L15;
        String r111 = r110.f296891c;
        if (r111 == null) goto L15;
    L16:
        r104.put("previous_page", r111);
        r104.put(MusicAppletPage.KEY_MESSAGE_ID, r101);
        r104.put("conversation_id", r102);
        y r112 = (y) this.f305752k.getValue();
        if (r112 == null) goto L22;
        String r113 = r112.getBotId();
        if (r113 == null) goto L22;
        r106 = r113;
    L22:
        r104.put("bot_id", r106);
        r104.put("card_source", "message");
        r104.put("scene", "message");
        int r114 = r103.length;
        int r115 = 0;
    L23:
        if (r115 >= r114) goto L25;
        Pair<String, ? extends Object> r116 = r103[r115];
        FLogger.f375446a.i("RecordCardBox", "zchRecord , " + r116.getFirst() + " : " + r116.getSecond());
        r104.put(r116.getFirst(), r116.getSecond());
        r115 = r115 + 1;
        goto L23
    L25:
        o.f365780a.reportEvent(r100, r104);
        return;
    L15:
        r111 = "";
    L8:
        r108 = "";
        goto L9
    }

    public final void o(RecordStatus r100, String r101, Integer r102, String r103, String r104) {
        p0 r105 = new p0(r103, Integer.valueOf(r100.getType()), r102, 3199);
        FLogger.f375446a.i("RecordCardBox", "GRecord updateRecordStatus in " + r104 + ", update remote status to " + r100 + ", duration to " + r102 + ", msgId: " + r101 + ", meetingId: " + r103);
        u7 r106 = (u7) this.f305753l.getValue();
        if (r106 == null) goto L6;
        r106.pe(r101, r105);
        return;
    }

    public static /* synthetic */ void r(RecordCardCell r100, RecordStatus r101, String r102, String r103, String r110, int r111) {
        if ((r111 & 8) == 0) goto L5;
        String r104 = null;
    L7:
        if ((r111 & 16) == 0) goto L9;
        String r105 = null;
    L10:
        r100.o(r101, r102, null, r104, r105);
        return;
    L9:
        r105 = r110;
        goto L10
    L5:
        r104 = r103;
        goto L7
    }

    public final void u(Context r100, String r101, boolean r102, String r110, String r111, String r112) {
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("opening applet page ");
        r104.append(r101);
        r104.append(", autoplay is ");
        r104.append(r102);
        r104.append(", status is ");
        u3 r105 = this.f305746e;
        Integer r106 = null;
        if (r105 == null) goto L7;
        RecordStatus r107 = r105.getRecordStatus();
        if (r107 == null) goto L7;
        Integer r108 = Integer.valueOf(r107.getType());
    L8:
        r104.append(r108);
        r103.i("RecordCardBox", r104.toString());
        w(r110, r111);
        b.a(r110);
        Gson r109 = new Gson();
        com.bytedance.router.i r113 = SmartRouter.buildRoute(r100, "//applet");
        r113.f267554c.putExtra(IFlowAppIntentIDL.PARAM_APPLET_ID, "com.flow.shorthand");
        r113.f267554c.putExtra("pageId", "detail");
        Pair[] r114 = new Pair[9];
        r114[0] = TuplesKt.to("id", r101);
        Boolean r115 = Boolean.FALSE;
        r114[1] = TuplesKt.to(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, r115);
        r114[2] = TuplesKt.to("autoPlay", Boolean.valueOf(r102));
        u3 r116 = this.f305746e;
        if (r116 == null) goto L13;
        RecordStatus r117 = r116.getRecordStatus();
        if (r117 == null) goto L13;
        r106 = Integer.valueOf(r117.getType());
    L13:
        r114[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r106);
        r114[4] = TuplesKt.to("scene", "record_card");
        r114[5] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r110);
        r114[6] = TuplesKt.to("conversation_id", r111);
        y r118 = (y) this.f305752k.getValue();
        if (r118 == null) goto L17;
        String r119 = r118.getBotId();
        if (r119 == null) goto L17;
    L18:
        r114[7] = TuplesKt.to("botId", r119);
        r114[8] = TuplesKt.to("area", r112);
        r113.f267554c.putExtra("pageData", GsonProtectorUtils.toJson(r109, MapsKt.hashMapOf(r114)));
        r113.f267554c.putExtra("pageType", "full");
        r113.f267554c.putExtra("pageSettings", GsonProtectorUtils.toJson(r109, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("showSpeaker", r115), TuplesKt.to("hideNavBar", Boolean.TRUE)})));
        r113.d();
        return;
    L17:
        r119 = "";
    L7:
        r108 = null;
        goto L8
    }
}
