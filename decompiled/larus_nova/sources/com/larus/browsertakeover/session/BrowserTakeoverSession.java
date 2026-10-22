package com.larus.browsertakeover.session;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.gamecp.live_impl.GamePromoteDataContext;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.browsertakeover.cdp.BrowserCdpClient;
import com.larus.browsertakeover.signaling.LocalPcSignaling;
import com.larus.browsertakeover.transport.BrowserTransport;
import com.larus.browsertakeover.transport.RtcBrowserTransport;
import com.larus.im.internal.jni.bean.RoomMeta;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.ttm.player.MediaPlayer;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u0000 a2\u00020\u0001:\u0004^_`aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\tJ\u000e\u0010>\u001a\u00020?2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010@\u001a\u00020?J\u0016\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u0015J\"\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\t2\u0006\u0010H\u001a\u00020\u0015H\u0002J\b\u0010I\u001a\u00020?H\u0002J\u0006\u0010J\u001a\u00020?J\u0006\u0010K\u001a\u00020?J\b\u0010L\u001a\u00020?H\u0002J\u0006\u0010M\u001a\u00020?J\u0010\u0010N\u001a\u00020?2\u0006\u0010O\u001a\u00020\tH\u0002J\u0012\u0010P\u001a\u00020?2\b\b\u0002\u0010Q\u001a\u00020\u0017H\u0002J\u0010\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u00020&H\u0002J\u000e\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020\u0015J\u0006\u0010V\u001a\u00020?J\u0006\u0010W\u001a\u00020?J\u0006\u0010X\u001a\u00020?J\b\u0010Y\u001a\u00020?H\u0014J$\u0010Z\u001a\u00020?2\u0006\u0010[\u001a\u00020\t2\b\b\u0002\u0010\\\u001a\u00020\t2\b\b\u0002\u0010]\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001e\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020&@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010+\u001a\u00020*2\u0006\u0010!\u001a\u00020*@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\"\u0010/\u001a\u0004\u0018\u00010.2\b\u0010!\u001a\u0004\u0018\u00010.@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b6\u00104R\u0011\u00107\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b8\u00104R\u0011\u00109\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006b"}, d2 = {"Lcom/larus/browsertakeover/session/BrowserTakeoverSession;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", PullConfiguration.PROCESS_NAME_MAIN, "Landroid/os/Handler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "logId", "", "connectStartedAtMs", "", "frameCount", "id", "entry", "Lcom/larus/browsertakeover/entry/TakeoverEntryStore$Entry;", "monitor", "Lcom/larus/browsertakeover/monitor/BrowserTakeoverMonitor;", "screencastParameters", "Lcom/larus/browsertakeover/experiment/BrowserScreencastParameters;", "generation", "", "pageReady", "", "firstFrame", "invitation", "Lcom/larus/browsertakeover/signaling/LocalPcSignaling$Cancellable;", "observer", "Lcom/larus/browsertakeover/session/BrowserTakeoverSession$Observer;", "startupTimeout", "Ljava/lang/Runnable;", "completionRequested", "host", "value", "Lcom/larus/browsertakeover/cdp/BrowserCdpClient$NavigationState;", "navigationState", "getNavigationState", "()Lcom/larus/browsertakeover/cdp/BrowserCdpClient$NavigationState;", "Lcom/larus/browsertakeover/session/BrowserTakeoverSession$State;", "state", "getState", "()Lcom/larus/browsertakeover/session/BrowserTakeoverSession$State;", "Lcom/larus/browsertakeover/session/BrowserTakeoverSession$ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "getErrorReason", "()Lcom/larus/browsertakeover/session/BrowserTakeoverSession$ErrorReason;", "Lcom/larus/browsertakeover/cdp/BrowserCdpClient;", "client", "getClient", "()Lcom/larus/browsertakeover/cdp/BrowserCdpClient;", "canControl", "getCanControl", "()Z", "canComplete", "getCanComplete", "usesRtsInputPacing", "getUsesRtsInputPacing", "connectionAttempt", "getConnectionAttempt", "()I", "initialize", "entryId", LynxViewpagerItem.BIND_ON_ATTACH, "", "detach", "connect", "width", "height", "createClient", NotificationCompat.CATEGORY_TRANSPORT, "Lcom/larus/browsertakeover/transport/BrowserTransport;", "pageId", "connectionGeneration", "becomeActiveIfReady", "completeAfterPendingInput", BitableAnalytic.SelectSceneClickType.COMPLETE, "startPendingCompletion", "disconnect", "fail", "source", "releaseConnection", "preservePageInfo", "update", TeaEventTrack.ACTION_DRAMA_NEXT, "onFirstFrameSubmitted", MapMonitorConst.ATTEMPT, "onBackgrounded", "onUserClosed", "onPageDismissed", "onCleared", "log", "event", "details", "debug", "State", "ErrorReason", "Observer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BrowserTakeoverSession extends ViewModel {
    private static final a Companion = null;
    public static final String TAG = "BrowserTakeoverSession";
    private BrowserCdpClient client;
    private boolean completionRequested;
    private long connectStartedAtMs;
    private com.larus.browsertakeover.entry.a.C4138a entry;
    private ErrorReason errorReason;
    private boolean firstFrame;
    private long frameCount;
    private int generation;
    private String host;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f319552id;
    private LocalPcSignaling.a invitation;
    private final String logId;
    private final Handler main;
    private kv8.a monitor;
    private BrowserCdpClient.i navigationState;
    private b observer;
    private boolean pageReady;
    private final CoroutineScope scope;
    private jv8.a screencastParameters;
    private Runnable startupTimeout;
    private State state;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/browsertakeover/session/BrowserTakeoverSession$ErrorReason;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTION", "MEDIA_BUSY", "MESSAGE_TOO_LARGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ErrorReason extends Enum<ErrorReason> {
        public static final ErrorReason CONNECTION = null;
        public static final ErrorReason MEDIA_BUSY = null;
        public static final ErrorReason MESSAGE_TOO_LARGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ErrorReason[] f319553a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319554b = null;

        public static EnumEntries<ErrorReason> getEntries() {
            return f319554b;
        }

        static {
            ErrorReason r100 = new ErrorReason("CONNECTION", 0);
            CONNECTION = r100;
            ErrorReason r101 = new ErrorReason("MEDIA_BUSY", 1);
            MEDIA_BUSY = r101;
            ErrorReason r102 = new ErrorReason("MESSAGE_TOO_LARGE", 2);
            MESSAGE_TOO_LARGE = r102;
            ErrorReason[] r103 = {r100, r101, r102};
            f319553a = r103;
            f319554b = EnumEntriesKt.enumEntries(r103);
        }

        public static ErrorReason[] values() {
            return (ErrorReason[]) f319553a.clone();
        }

        public static ErrorReason valueOf(String r100) {
            return (ErrorReason) r27.a.a(ErrorReason.class, r100);
        }

        public ErrorReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/browsertakeover/session/BrowserTakeoverSession$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CONNECTING", "ACTIVE", com.byted.cast.common.bean.State.DISCONNECTED, "ERROR", "COMPLETING", "COMPLETION_FAILED", "COMPLETE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State ACTIVE = null;
        public static final State COMPLETE = null;
        public static final State COMPLETING = null;
        public static final State COMPLETION_FAILED = null;
        public static final State CONNECTING = null;
        public static final State DISCONNECTED = null;
        public static final State ERROR = null;
        public static final State IDLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f319555a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319556b = null;

        public static EnumEntries<State> getEntries() {
            return f319556b;
        }

        static {
            State r100 = new State("IDLE", 0);
            IDLE = r100;
            State r101 = new State("CONNECTING", 1);
            CONNECTING = r101;
            State r102 = new State("ACTIVE", 2);
            ACTIVE = r102;
            State r103 = new State(com.byted.cast.common.bean.State.DISCONNECTED, 3);
            DISCONNECTED = r103;
            State r104 = new State("ERROR", 4);
            ERROR = r104;
            State r105 = new State("COMPLETING", 5);
            COMPLETING = r105;
            State r110 = new State("COMPLETION_FAILED", 6);
            COMPLETION_FAILED = r110;
            State r111 = new State("COMPLETE", 7);
            COMPLETE = r111;
            State[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
            f319555a = r112;
            f319556b = EnumEntriesKt.enumEntries(r112);
        }

        public static State[] values() {
            return (State[]) f319555a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public interface b extends BrowserCdpClient.d {
        void aC(State r100);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f319557a = null;

        static {
            int[] r100 = new int[RtcBrowserTransport.Failure.values().length];
            r100[RtcBrowserTransport.Failure.MEDIA_BUSY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[RtcBrowserTransport.Failure.MESSAGE_TOO_LARGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f319557a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.browsertakeover.session.BrowserTakeoverSession$completeAfterPendingInput$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(Object r100) {
            super(0, r100, BrowserTakeoverSession.class, "startPendingCompletion", "startPendingCompletion()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            BrowserTakeoverSession.access$startPendingCompletion((BrowserTakeoverSession) this.receiver);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.browsertakeover.session.BrowserTakeoverSession$completeAfterPendingInput$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(Object r100) {
            super(0, r100, BrowserTakeoverSession.class, "startPendingCompletion", "startPendingCompletion()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            BrowserTakeoverSession.access$startPendingCompletion((BrowserTakeoverSession) this.receiver);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public static final class d implements BrowserCdpClient.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BrowserTakeoverSession f319558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f319559b;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f319560a = null;

            static {
                int[] r100 = new int[BrowserCdpClient.State.values().length];
                r100[BrowserCdpClient.State.READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[BrowserCdpClient.State.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[BrowserCdpClient.State.DISCONNECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f319560a = r100;
            }
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void OH(String r100) {
            Intrinsics.checkNotNullParameter(r100, "host");
            if (BrowserTakeoverSession.access$getGeneration$p(this.f319558a) != this.f319559b) goto L8;
            BrowserTakeoverSession.access$setHost$p(this.f319558a, r100);
            b r101 = BrowserTakeoverSession.access$getObserver$p(this.f319558a);
            if (r101 == null) goto L9;
            r101.OH(r100);
            return;
        L9:
            return;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void iu(String r100) {
            Intrinsics.checkNotNullParameter(r100, "stage");
            if (BrowserTakeoverSession.access$getGeneration$p(this.f319558a) != this.f319559b) goto L8;
            kv8.a r101 = BrowserTakeoverSession.access$getMonitor$p(this.f319558a);
            if (r101 == null) goto L9;
            r101.g(r100);
            return;
        L9:
            return;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void ko(BrowserCdpClient.l r100) {
            Intrinsics.checkNotNullParameter(r100, ButtonColorBean.StateFocus);
            if (BrowserTakeoverSession.access$getGeneration$p(this.f319558a) == this.f319559b) goto L5;
            return;
        L5:
            if (this.f319558a.getCanControl() == false) goto L11;
            b r101 = BrowserTakeoverSession.access$getObserver$p(this.f319558a);
            if (r101 == null) goto L12;
            r101.ko(r100);
            return;
        L12:
            return;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void m70(BrowserCdpClient.i r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (BrowserTakeoverSession.access$getGeneration$p(this.f319558a) != this.f319559b) goto L8;
            BrowserTakeoverSession.access$setNavigationState$p(this.f319558a, r100);
            b r101 = BrowserTakeoverSession.access$getObserver$p(this.f319558a);
            if (r101 == null) goto L9;
            r101.m70(r100);
            return;
        L9:
            return;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void v30(BrowserCdpClient.State r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (BrowserTakeoverSession.access$getGeneration$p(this.f319558a) == this.f319559b) goto L5;
            return;
        L5:
            BrowserTakeoverSession.log$default(this.f319558a, "cdp_state_changed", "newState=" + r100, false, 4, null);
            int r101 = a.f319560a[r100.ordinal()];
            if (r101 != 1) goto L8;
            BrowserTakeoverSession.access$setPageReady$p(this.f319558a, true);
            BrowserTakeoverSession.access$becomeActiveIfReady(this.f319558a);
            return;
        L8:
            if (r101 != 2) goto L10;
        L12:
            BrowserTakeoverSession.access$fail(this.f319558a, "cdp_" + r100.name());
            return;
        L10:
            if (r101 == 3) goto L12;
        }

        public d(BrowserTakeoverSession r100, int r101) {
            this.f319558a = r100;
            this.f319559b = r101;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void pW(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "stage");
            Intrinsics.checkNotNullParameter(r101, "code");
            if (BrowserTakeoverSession.access$getGeneration$p(this.f319558a) != this.f319559b) goto L8;
            kv8.a r102 = BrowserTakeoverSession.access$getMonitor$p(this.f319558a);
            if (r102 == null) goto L9;
            r102.e(r100, r101);
            return;
        L9:
            return;
        }

        @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
        public final void R50(Bitmap r100, float r101, float r102, float r110) {
            Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
            if (BrowserTakeoverSession.access$getGeneration$p(this.f319558a) == this.f319559b) goto L5;
        L17:
            r100.recycle();
            return;
        L5:
            if (BrowserTakeoverSession.access$getObserver$p(this.f319558a) == null) goto L17;
            BrowserTakeoverSession.access$setFrameCount$p(this.f319558a, BrowserTakeoverSession.access$getFrameCount$p(this.f319558a) + 1);
            if (BrowserTakeoverSession.access$getFirstFrame$p(this.f319558a) == true) goto L10;
        L11:
            BrowserTakeoverSession r103 = this.f319558a;
            StringBuilder r104 = new StringBuilder("count=");
            r104.append(BrowserTakeoverSession.access$getFrameCount$p(this.f319558a));
            r104.append(" first=");
            r104.append(!BrowserTakeoverSession.access$getFirstFrame$p(this.f319558a));
            r104.append(" bitmap=");
            r104.append(r100.getWidth());
            r104.append(Permission.EXECUTE);
            r104.append(r100.getHeight());
            r104.append(" viewport=");
            r104.append(r101);
            r104.append(Permission.EXECUTE);
            r104.append(r102);
            r104.append(" offsetTop=");
            r104.append(r110);
            BrowserTakeoverSession.access$log(r103, "frame_received", r104.toString(), BrowserTakeoverSession.access$getFirstFrame$p(this.f319558a));
        L12:
            BrowserTakeoverSession.access$setFirstFrame$p(this.f319558a, true);
            b r105 = BrowserTakeoverSession.access$getObserver$p(this.f319558a);
            if (r105 == null) goto L15;
            r105.R50(r100, r101, r102, r110);
        L15:
            BrowserTakeoverSession.access$becomeActiveIfReady(this.f319558a);
            return;
        L10:
            if ((BrowserTakeoverSession.access$getFrameCount$p(this.f319558a) % 30) != 0) goto L12;
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.larus.browsertakeover.session.BrowserTakeoverSession$startPendingCompletion$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.browsertakeover.session.BrowserTakeoverSession$startPendingCompletion$1", f = "BrowserTakeoverSession.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD}, m = "invokeSuspend", n = {}, s = {})
    public static final class C109851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.browsertakeover.entry.a.C4138a $current;
        int label;
        final /* synthetic */ BrowserTakeoverSession this$0;

        public C109851(BrowserTakeoverSession r100, com.larus.browsertakeover.entry.a.C4138a r101, Continuation<? super C109851> r102) {
            this.this$0 = r100;
            this.$current = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C109851(this.this$0, this.$current, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C109851) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L9;
            if (r102 != 1) goto L8;
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L15 CancellationException -> L34
        L13:
            boolean r103 = Intrinsics.areEqual(r100, Boxing.boxBoolean(true));     // Catch: Exception -> L15 CancellationException -> L34
        L17:
            BrowserTakeoverSession.log$default(this.this$0, "complete_result", "success=" + r103, false, 4, null);
            kv8.a r104 = BrowserTakeoverSession.access$getMonitor$p(this.this$0);
            if (r104 != null) goto L20;
        L28:
            BrowserTakeoverSession r105 = this.this$0;
            if (r103 == false) goto L31;
            State r106 = State.COMPLETE;
        L32:
            BrowserTakeoverSession.access$update(r105, r106);
            return Unit.INSTANCE;
        L31:
            r106 = State.COMPLETION_FAILED;
            goto L32
        L20:
            if (r104.f506297e == true) goto L28;
            if (r103 == false) goto L24;
            String r107 = "success";
        L25:
            r104.f506299g = r107;
            if (r103 == false) goto L28;
            r104.f506298f = "completed";
            goto L28
        L24:
            r107 = "fail";
            goto L25
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
            BrowserTakeoverSession$startPendingCompletion$1$success$1 r108 = new BrowserTakeoverSession$startPendingCompletion$1$success$1(this.$current, null);     // Catch: Exception -> L15 CancellationException -> L34
            this.label = 1;     // Catch: Exception -> L15 CancellationException -> L34
            r100 = TimeoutKt.c(65000, r108, this);     // Catch: Exception -> L15 CancellationException -> L34
            if (r100 != r101) goto L13;
            return r101;
        L34:
            e = move-exception;
            BrowserTakeoverSession.log$default(this.this$0, "complete_cancelled", null, false, 6, null);
            throw e;
        L15:
            e = move-exception;
            BrowserTakeoverSession.log$default(this.this$0, "complete_exception", "type=".concat(e.getClass().getSimpleName()), false, 4, null);
            r103 = false;
            goto L17
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Mo(BrowserTakeoverSession r100, int r101, LocalPcSignaling.Failure r102) {
        return connect$lambda$6(r100, r101, r102);
    }

    public static /* synthetic */ void No(BrowserTakeoverSession r100) {
        r100.startPendingCompletion();
    }

    public static /* synthetic */ Unit Oo(BrowserTakeoverSession r100, int r101, hv8.a r102, hv8.c r103, RoomMeta r104) {
        return connect$lambda$5(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ void Po(BrowserTakeoverSession r100, int r101) {
        connect$lambda$2(r100, r101);
    }

    public static /* synthetic */ Unit yo(BrowserTakeoverSession r100, int r101, RtcBrowserTransport.Failure r102) {
        return connect$lambda$5$lambda$4(r100, r101, r102);
    }

    private final void becomeActiveIfReady() {
        if (this.state == State.CONNECTING) goto L5;
        return;
    L5:
        if (this.pageReady == true) goto L7;
        return;
    L7:
        if (this.firstFrame == false) goto L21;
        Runnable r100 = this.startupTimeout;
        if (r100 == null) goto L11;
        this.main.removeCallbacks(r100);
    L11:
        this.startupTimeout = null;
        LocalPcSignaling.a r101 = this.invitation;
        if (r101 == null) goto L14;
        r101.cancel();
    L14:
        this.invitation = null;
        kv8.a r102 = this.monitor;
        if (r102 == null) goto L17;
        r102.d("success");
        r102.f();
    L17:
        update(State.ACTIVE);
        return;
    }

    private final void startPendingCompletion() {
        if (this.completionRequested == true) goto L5;
        return;
    L5:
        this.completionRequested = false;
        com.larus.browsertakeover.entry.a.C4138a r100 = this.entry;
        if (r100 != null) goto L15;
        log$default(this, "complete_ignored", "reason=missing_entry", false, 4, null);
        kv8.a r101 = this.monitor;
        if (r101 != null) goto L10;
    L13:
        update(State.COMPLETION_FAILED);
        return;
    L10:
        if (r101.f506297e == true) goto L13;
        r101.f506299g = "fail";
        goto L13
    L15:
        log$default(this, "complete_requested", null, false, 6, null);
        releaseConnection(true);
        BuildersKt.launch$default(this.scope, null, null, new C109851(this, r100, null), 3, null);
    }

    public final void detach() {
        log$default(this, "observer_detached", "state=" + this.state, false, 4, null);
        this.observer = null;
    }

    public final void disconnect() {
        log$default(this, "disconnect_requested", "state=" + this.state, false, 4, null);
        kv8.a r100 = this.monitor;
        if (r100 == null) goto L5;
        r100.d("cancel");
    L5:
        State r101 = this.state;
        State r102 = State.COMPLETING;
        if (r101 != r102) goto L8;
    L13:
        boolean r103 = true;
    L14:
        releaseConnection(r103);
        State r104 = this.state;
        if (r104 != r102) goto L17;
        return;
    L17:
        if (r104 != State.COMPLETE) goto L19;
        return;
    L19:
        if (r104 == State.COMPLETION_FAILED) goto L24;
        update(State.DISCONNECTED);
        return;
    L24:
        return;
    L8:
        if (r101 == State.COMPLETION_FAILED) goto L13;
        if (r101 == State.COMPLETE) goto L13;
        r103 = false;
        goto L14
    }

    public final boolean getCanComplete() {
        State r100 = this.state;
        if (r100 != State.ACTIVE) goto L5;
    L8:
        return true;
    L5:
        if (r100 == State.COMPLETION_FAILED) goto L8;
        return false;
    }

    public final boolean getCanControl() {
        if (this.state != State.ACTIVE) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getConnectionAttempt() {
        kv8.a r100 = this.monitor;
        if (r100 == null) goto L8;
        kv8.a.C6616a r101 = r100.f506296d;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.f506300a;
    L8:
        return 0;
    }

    public final boolean getUsesRtsInputPacing() {
        BrowserCdpClient r100 = this.client;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.n() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void onBackgrounded() {
        kv8.a r100 = this.monitor;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f506298f != null) goto L7;
        r100.f506298f = "background";
    L7:
        r100.d("cancel");
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        log$default(this, "cleared", "state=" + this.state, false, 4, null);
        kv8.a r100 = this.monitor;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        this.observer = null;
        this.completionRequested = false;
        this.main.removeCallbacksAndMessages(null);
        releaseConnection$default(this, false, 1, null);
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.entry = null;
        String r101 = com.larus.browsertakeover.entry.a.f319480a;
        String r102 = this.f319552id;
        Intrinsics.checkNotNullParameter(r102, "id");
        if (Intrinsics.areEqual(com.larus.browsertakeover.entry.a.f319480a, r102) == false) goto L9;
        com.larus.browsertakeover.entry.a.f319480a = null;
        com.larus.browsertakeover.entry.a.f319481b = null;
        return;
    }

    public final void onPageDismissed() {
        kv8.a r100 = this.monitor;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    public final void onUserClosed() {
        kv8.a r100 = this.monitor;
        if (r100 == null) goto L10;
        String r101 = r100.f506298f;
        if (r101 != null) goto L7;
    L8:
        r100.f506298f = GamePromoteDataContext.ACTION_TYPE_USER_CLOSE;
        return;
    L7:
        if (Intrinsics.areEqual(r101, "background") == true) goto L8;
        return;
    }

    public BrowserTakeoverSession() {
        this.main = new Handler(Looper.getMainLooper());
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.logId = Integer.toString(System.identityHashCode(this), CharsKt.checkRadix(16));
        this.f319552id = "";
        this.host = "";
        this.navigationState = new BrowserCdpClient.i(false, false);
        this.state = State.IDLE;
        this.errorReason = ErrorReason.CONNECTION;
    }

    public final void complete() {
        if (getCanComplete() == true) goto L7;
        log$default(this, "complete_ignored", "state=" + this.state, false, 4, null);
        return;
    L7:
        if (this.completionRequested == false) goto L9;
        return;
    L9:
        this.completionRequested = true;
        kv8.a r100 = this.monitor;
        if (r100 != null) goto L12;
    L14:
        update(State.COMPLETING);
        startPendingCompletion();
        return;
    L12:
        if (r100.f506297e == true) goto L14;
        r100.f506299g = null;
        goto L14
    }

    public final void completeAfterPendingInput() {
        if (getCanComplete() == true) goto L7;
        log$default(this, "complete_ignored", "state=" + this.state, false, 4, null);
        return;
    L7:
        if (this.completionRequested == false) goto L9;
        return;
    L9:
        this.completionRequested = true;
        kv8.a r100 = this.monitor;
        if (r100 != null) goto L12;
    L14:
        update(State.COMPLETING);
        BrowserCdpClient r101 = this.client;
        if (r101 != null) goto L17;
        startPendingCompletion();
        return;
    L17:
        r101.R(new AnonymousClass1(this), new AnonymousClass2(this));
        return;
    L12:
        if (r100.f506297e == true) goto L14;
        r100.f506299g = null;
        goto L14
    }

    public final BrowserCdpClient getClient() {
        return this.client;
    }

    public final ErrorReason getErrorReason() {
        return this.errorReason;
    }

    public final BrowserCdpClient.i getNavigationState() {
        return this.navigationState;
    }

    public final State getState() {
        return this.state;
    }

    public static final /* synthetic */ void access$becomeActiveIfReady(BrowserTakeoverSession r100) {
        r100.becomeActiveIfReady();
    }

    public static final /* synthetic */ boolean access$getFirstFrame$p(BrowserTakeoverSession r100) {
        return r100.firstFrame;
    }

    public static final /* synthetic */ long access$getFrameCount$p(BrowserTakeoverSession r100) {
        return r100.frameCount;
    }

    public static final /* synthetic */ int access$getGeneration$p(BrowserTakeoverSession r100) {
        return r100.generation;
    }

    public static final /* synthetic */ kv8.a access$getMonitor$p(BrowserTakeoverSession r100) {
        return r100.monitor;
    }

    public static final /* synthetic */ b access$getObserver$p(BrowserTakeoverSession r100) {
        return r100.observer;
    }

    public static final /* synthetic */ void access$startPendingCompletion(BrowserTakeoverSession r100) {
        r100.startPendingCompletion();
    }

    private final void fail(String r100) {
        log$default(this, "connection_failed", "source=" + r100 + " state=" + this.state + " pageReady=" + this.pageReady + " firstFrame=" + this.firstFrame + " errorReason=" + this.errorReason, false, 4, null);
        kv8.a r101 = this.monitor;
        if (r101 == null) goto L15;
        String r102 = r100.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullParameter(r102, "fallbackCode");
        if (r101.f506297e == true) goto L15;
        kv8.a.C6616a r103 = r101.f506296d;
        if (r103 == null) goto L15;
        if (r103.f506306g != null) goto L13;
        r103.f506306g = new kv8.a.c(r103.f506305f, r102);
    L13:
        r101.f506298f = "disconnected";
        r101.d("fail");
    L15:
        if (this.completionRequested == false) goto L18;
        releaseConnection(true);
        return;
    L18:
        releaseConnection$default(this, false, 1, null);
        update(State.ERROR);
    }

    private final void releaseConnection(boolean r100) {
        StringBuilder r101 = new StringBuilder("hasClient=");
        if (this.client == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r101.append(" hasInvitation=");
        if (this.invitation == null) goto L9;
        boolean r103 = true;
    L10:
        r101.append(r103);
        r101.append(" frames=");
        r101.append(this.frameCount);
        log$default(this, "connection_release", r101.toString(), false, 4, null);
        this.generation++;
        if (r100 == true) goto L18;
        this.host = "";
        this.navigationState = new BrowserCdpClient.i(false, false);
        b r104 = this.observer;
        if (r104 == null) goto L15;
        r104.OH("");
    L15:
        b r105 = this.observer;
        if (r105 == null) goto L18;
        r105.m70(this.navigationState);
    L18:
        Runnable r106 = this.startupTimeout;
        if (r106 == null) goto L21;
        this.main.removeCallbacks(r106);
    L21:
        this.startupTimeout = null;
        LocalPcSignaling.a r107 = this.invitation;
        if (r107 == null) goto L24;
        r107.cancel();
    L24:
        this.invitation = null;
        BrowserCdpClient r108 = this.client;
        this.client = null;
        if (r108 == null) goto L31;
        if (r108.f319403w == true) goto L31;
        r108.g();
        r108.f319403w = true;
        r108.f319384d.removeCallbacksAndMessages(null);
        r108.f319385e.shutdownNow();
        r108.f319381a.release();
    L31:
        if (this.completionRequested == false) goto L34;
        this.main.post(new com.larus.browsertakeover.session.d(this));
        return;
    L34:
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    private final void update(State r100) {
        log$default(this, "state_changed", "oldState=" + this.state + " newState=" + r100 + " pageReady=" + this.pageReady + " firstFrame=" + this.firstFrame, false, 4, null);
        this.state = r100;
        b r101 = this.observer;
        if (r101 == null) goto L6;
        r101.aC(r100);
        return;
    }

    public final void attach(b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.observer = r100;
        log$default(this, "observer_attached", "state=" + this.state, false, 4, null);
        r100.aC(this.state);
        r100.OH(this.host);
        r100.m70(this.navigationState);
    }

    public final boolean initialize(String r100) {
        Intrinsics.checkNotNullParameter(r100, "entryId");
        if (this.entry == null) goto L6;
        log$default(this, "initialize_reused", null, false, 6, null);
        return true;
    L6:
        this.f319552id = r100;
        String r101 = com.larus.browsertakeover.entry.a.f319480a;
        Intrinsics.checkNotNullParameter(r100, "id");
        com.larus.browsertakeover.entry.a.C4138a r102 = null;
        if (Intrinsics.areEqual(com.larus.browsertakeover.entry.a.f319480a, r100) == false) goto L9;
        com.larus.browsertakeover.entry.a.C4138a r103 = com.larus.browsertakeover.entry.a.f319481b;
        com.larus.browsertakeover.entry.a.f319481b = null;
        r102 = r103;
    L9:
        this.entry = r102;
        if (r102 == null) goto L12;
        this.monitor = new kv8.a(r102.f319482a);
        int r104 = ka9.a.f502196a;
        jv8.b r105 = new jv8.b(0);
        AtomicReference<ga9.a.C5998a> r106 = ga9.a.f480591a;
        ga9.e.f480599a.getClass();
        this.screencastParameters = ((jv8.b) ga9.e.a(ga9.a.c("mobile_browser_screencast_size", ga9.e.c(r105)), jv8.b.class, r105)).a(r102.f319482a.f487351g instanceof hv8.c.a);
    L12:
        StringBuilder r107 = new StringBuilder("entryPresent=");
        if (this.entry == null) goto L15;
        boolean r108 = true;
    L16:
        r107.append(r108);
        log$default(this, "initialize", r107.toString(), false, 4, null);
        if (this.entry != null) goto L21;
        return false;
    L21:
        return true;
    L15:
        r108 = false;
        goto L16
    }

    public final void onFirstFrameSubmitted(int r100) {
        kv8.a r101 = this.monitor;
        if (r101 == null) goto L23;
        kv8.a.C6616a r102 = r101.f506296d;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r101.f506297e == false) goto L10;
        return;
    L10:
        if (r100 == r102.f506300a) goto L12;
        return;
    L12:
        if (r102.f506303d == false) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r102.f506302c, "fail") == false) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(r102.f506302c, "cancel") == false) goto L19;
        return;
    L19:
        if (r102.f506304e != null) goto L21;
        r102.f506304e = Long.valueOf(SystemClock.elapsedRealtime());
    L21:
        r101.f();
        return;
    }

    public static final /* synthetic */ void access$fail(BrowserTakeoverSession r100, String r101) {
        r100.fail(r101);
    }

    public static final /* synthetic */ void access$setFirstFrame$p(BrowserTakeoverSession r100, boolean r101) {
        r100.firstFrame = r101;
    }

    public static final /* synthetic */ void access$setFrameCount$p(BrowserTakeoverSession r100, long r101) {
        r100.frameCount = r101;
    }

    public static final /* synthetic */ void access$setHost$p(BrowserTakeoverSession r100, String r101) {
        r100.host = r101;
    }

    public static final /* synthetic */ void access$setNavigationState$p(BrowserTakeoverSession r100, BrowserCdpClient.i r101) {
        r100.navigationState = r101;
    }

    public static final /* synthetic */ void access$setPageReady$p(BrowserTakeoverSession r100, boolean r101) {
        r100.pageReady = r101;
    }

    public static final /* synthetic */ void access$update(BrowserTakeoverSession r100, State r101) {
        r100.update(r101);
    }

    private static final void connect$lambda$2(BrowserTakeoverSession r100, int r101) {
        if (r100.generation == r101) goto L5;
        return;
    L5:
        if (r100.state != State.CONNECTING) goto L9;
        r100.fail("startup_timeout");
        return;
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [com.larus.browsertakeover.session.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.larus.browsertakeover.session.c, java.lang.Object] */
    public final void connect(int r210, int r211) {
        State r100 = this.state;
        State r101 = State.CONNECTING;
        if (r100 != r101) goto L5;
    L57:
        log$default(this, "connect_ignored", "state=" + this.state, false, 4, null);
        return;
    L5:
        if (r100 == State.ACTIVE) goto L57;
        if (r100 == State.COMPLETING) goto L57;
        if (r100 == State.COMPLETE) goto L57;
        if (r100 == State.COMPLETION_FAILED) goto L57;
        com.larus.browsertakeover.entry.a.C4138a r102 = this.entry;
        if (r102 == null) goto L55;
        final hv8.a r103 = r102.f319482a;
        if (r103 == null) goto L55;
        releaseConnection$default(this, false, 1, null);
        final int r110 = this.generation;
        this.connectStartedAtMs = SystemClock.elapsedRealtime();
        kv8.a r111 = this.monitor;
        if (r111 != null) goto L21;
    L28:
        this.frameCount = 0;
        boolean r104 = r103.f487351g instanceof hv8.c.a;
        StringBuilder r105 = new StringBuilder("target=");
        if (r104 == false) goto L31;
        String r106 = "cloud";
    L32:
        r105.append(r106);
        r105.append(" viewport=");
        r105.append(r210);
        r105.append(Permission.EXECUTE);
        r105.append(r211);
        log$default(this, "connect_requested", r105.toString(), false, 4, null);
        this.pageReady = false;
        this.firstFrame = false;
        this.errorReason = ErrorReason.CONNECTION;
        update(r101);
        Runnable r107 = new com.larus.browsertakeover.session.a(this, r110);
        this.main.postDelayed(r107, 60000);
        this.startupTimeout = r107;
        final hv8.c r112 = r103.f487351g;
        if ((r112 instanceof hv8.c.a) == false) goto L36;
        hv8.c.a r113 = (hv8.c.a) r112;
        createClient(new com.larus.browsertakeover.transport.d(r113.f487354a), r113.f487355b, r110);
        return;
    L36:
        if ((r112 instanceof hv8.c.b) == false) goto L54;
        kv8.a r108 = this.monitor;
        if (r108 == null) goto L40;
        r108.g("invite");
    L40:
        log$default(this, "pc_invite_requested", "command=600", false, 4, null);
        int r109 = LocalPcSignaling.f319572a;
        hv8.c.b r114 = (hv8.c.b) r112;
        String r115 = r114.f487356a;
        String r116 = r114.f487357b;
        if (r116 == null) goto L45;
        Integer r117 = StringsKt.toIntOrNull(r116);
        if (r117 == null) goto L45;
        int r118 = r117.intValue();
    L46:
        String r119 = o.f365780a.getDeviceId();
        String r120 = r103.f487345a;
        ?? r121 = new com.larus.browsertakeover.session.b(this, r110, r103, r112);
        ?? r122 = new com.larus.browsertakeover.session.c(this, r110);
        Intrinsics.checkNotNullParameter(r115, "deviceId");
        Intrinsics.checkNotNullParameter(r119, "sourceDeviceId");
        Intrinsics.checkNotNullParameter(r120, "conversationId");
        Intrinsics.checkNotNullParameter(r121, "onRoomMeta");
        Intrinsics.checkNotNullParameter(r122, "onFailure");
        final LocalPcSignaling.b r123 = new LocalPcSignaling.b(r115, r118, r119, r120, null, r121, r122);
        r123.c(new com.larus.browsertakeover.signaling.a(r123));
        if (this.generation == r110) goto L49;
    L51:
        r123.cancel();
        return;
    L49:
        if (this.state != r101) goto L51;
        this.invitation = r123;
        return;
    L45:
        r118 = 0;
        goto L46
    L54:
        throw new NoWhenBranchMatchedException();
    L31:
        r106 = "local_pc";
        goto L32
    L21:
        if (r111.f506297e == true) goto L28;
        r111.d("cancel");
        kv8.a.C6616a r124 = r111.f506296d;
        if (r124 == null) goto L26;
        int r125 = r124.f506300a;
    L27:
        int r126 = r125 + 1;
        r111.f506296d = new kv8.a.C6616a(r126, SystemClock.elapsedRealtime());
        r111.f506298f = null;
        kv8.a.b(r111, "browser_takeover_connect", new JSONObject().put("status", "start"), null, Integer.valueOf(r126), 4);
        goto L28
    L26:
        r125 = 0;
    L55:
        log$default(this, "connect_ignored", "reason=missing_entry", false, 4, null);
    }

    private static final Unit connect$lambda$5$lambda$4(BrowserTakeoverSession r100, int r101, RtcBrowserTransport.Failure r102) {
        Intrinsics.checkNotNullParameter(r102, "reason");
        if (r100.generation != r101) goto L16;
        log$default(r100, "rtc_failure", "reason=" + r102, false, 4, null);
        kv8.a r103 = r100.monitor;
        if (r103 == null) goto L7;
        r103.e(NotificationCompat.CATEGORY_TRANSPORT, r102.name().toLowerCase(Locale.ROOT));
    L7:
        int r104 = c.f319557a[r102.ordinal()];
        if (r104 != 1) goto L10;
        ErrorReason r105 = ErrorReason.MEDIA_BUSY;
    L14:
        r100.errorReason = r105;
        goto L16
    L10:
        if (r104 == 2) goto L12;
        r105 = ErrorReason.CONNECTION;
        goto L14
    L12:
        r105 = ErrorReason.MESSAGE_TOO_LARGE;
    L16:
        return Unit.INSTANCE;
    }

    private static final Unit connect$lambda$6(BrowserTakeoverSession r100, int r101, LocalPcSignaling.Failure r102) {
        Intrinsics.checkNotNullParameter(r102, "reason");
        if (r100.generation != r101) goto L13;
        kv8.a r103 = r100.monitor;
        if (r103 != null) goto L7;
    L11:
        r100.fail("signaling_" + r102.name());
        goto L13
    L7:
        if (r102 != LocalPcSignaling.Failure.TIMEOUT) goto L9;
        String r104 = "invite_timeout";
    L10:
        r103.e("invite", r104);
        goto L11
    L9:
        r104 = r102.name().toLowerCase(Locale.ROOT);
    L13:
        return Unit.INSTANCE;
    }

    private final void createClient(BrowserTransport r110, String r111, int r112) {
        kv8.a r100 = this.monitor;
        if (r100 == null) goto L5;
        r100.g(NotificationCompat.CATEGORY_TRANSPORT);
    L5:
        StringBuilder r101 = new StringBuilder("transport=");
        r101.append(r110.getClass().getSimpleName());
        r101.append(" transportId=");
        r101.append(Integer.toString(System.identityHashCode(r110), CharsKt.checkRadix(16)));
        r101.append(" pageIdPresent=");
        boolean r102 = true;
        if (r111 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        r101.append(!r103);
        log$default(this, "client_create", r101.toString(), false, 4, null);
        jv8.a r104 = this.screencastParameters;
        if (r104 != null) goto L19;
        jv8.b r105 = new jv8.b(0);
        if (r110.c() == BrowserTransport.EndpointMode.BROWSER) goto L18;
        r102 = false;
    L18:
        r104 = r105.a(r102);
    L19:
        BrowserCdpClient r106 = new BrowserCdpClient(r110, new d(this, r112), r104);
        this.client = r106;
        if (r106.f319403w == true) goto L30;
        r106.g();
        r106.G = r111;
        int r113 = r106.f319387g.incrementAndGet();
        r106.J(BrowserCdpClient.State.CONNECTING);
        if (r106.n() == true) goto L25;
    L27:
        r106.f319381a.b(new com.larus.browsertakeover.cdp.a(r113, r106));
        return;
    L25:
        if (r106.y() == true) goto L27;
        r106.j("RTP.pageEndpoint", "initialization_failed");
        return;
    L30:
        return;
    L8:
        if (StringsKt.isBlank(r111) == true) goto L11;
        r103 = false;
        goto L12
    }

    private final void log(String r100, String r101, boolean r102) {
        long r103 = 0;
        if (this.connectStartedAtMs == 0) goto L6;
        r103 = SystemClock.elapsedRealtime() - this.connectStartedAtMs;
    L6:
        String r104 = "session=" + this.logId + " generation=" + this.generation + " event=" + r100 + " elapsedMs=" + r103 + ' ' + r101;
        if (r102 == false) goto L9;
        FLogger.f375446a.d(TAG, r104);
        return;
    L9:
        FLogger.f375446a.i(TAG, r104);
    }

    public static final /* synthetic */ void access$log(BrowserTakeoverSession r100, String r101, String r102, boolean r103) {
        r100.log(r101, r102, r103);
    }

    public static /* synthetic */ void releaseConnection$default(BrowserTakeoverSession r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.releaseConnection(r101);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.browsertakeover.session.e] */
    private static final Unit connect$lambda$5(final BrowserTakeoverSession r100, final int r101, hv8.a r102, hv8.c r110, RoomMeta r111) {
        Intrinsics.checkNotNullParameter(r111, "meta");
        if (r100.generation != r101) goto L5;
        log$default(r100, "http_room_meta_received", "serverExpireTimeMs=" + r111.expireTimeMs + " testDomain=" + r111.useRtcTestDomain, false, 4, null);
        r100.createClient(new RtcBrowserTransport(r111, r102.f487345a, new e(r100, r101)), ((hv8.c.b) r110).f487358c, r101);
    L7:
        return Unit.INSTANCE;
    L5:
        log$default(r100, "http_room_meta_ignored", "callbackGeneration=" + r101, false, 4, null);
        goto L7
    }

    public static /* synthetic */ void log$default(BrowserTakeoverSession r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = false;
    L8:
        r100.log(r101, r102, r103);
    }
}
