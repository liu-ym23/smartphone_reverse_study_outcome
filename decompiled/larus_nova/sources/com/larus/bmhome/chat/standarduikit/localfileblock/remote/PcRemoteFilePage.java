package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import android.app.Application;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.chat.standarduikit.localfileblock.provider.PcLocalFilePreviewProvider;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.service.TaskModeService;
import com.larus.common.apphost.AppHost;
import com.larus.im.internal.jni.bean.DispatchErrorCode;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.p1;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import t19.s;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0002GHB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u0015J\"\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00112\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0017H\u0002J\u0018\u00104\u001a\u0002022\u0006\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000202H\u0002J\b\u00109\u001a\u000202H\u0002J\u0012\u0010:\u001a\u0002022\b\u0010;\u001a\u0004\u0018\u00010%H\u0002J\u000e\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020\u001bJ\u0012\u0010>\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010@\u001a\u000202H\u0002J\b\u0010A\u001a\u000202H\u0014J\u0014\u0010B\u001a\u00020C2\n\u0010D\u001a\u00060Ej\u0002`FH\u0002R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R!\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b&\u0010'R\u0010\u0010)\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010+0.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFilePage;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", "mutableState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFilePage$State;", "kotlin.jvm.PlatformType", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "host", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "conversationId", "", "conversationIdProvider", "Lkotlin/Function0;", "openJob", "Lkotlinx/coroutines/Job;", "pendingRequest", "Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFileRequest;", "operationId", "", "deviceListProvider", "Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "getDeviceListProvider", "()Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "deviceListProvider$delegate", "Lkotlin/Lazy;", "deviceCollection", "Lcom/larus/bmhome/taskskill/model/GroupedDeviceCollection;", "getDeviceCollection", "()Landroidx/lifecycle/MutableLiveData;", "deviceCollection$delegate", "deviceRefreshJob", "isObservingDevices", "", "confirmedDeviceAccountId", "deviceOnlineStatuses", "", "isSourceDeviceOffline", "deviceId", "bind", "", WidgetService.PARAM_FRAGMENT, "onStateChanged", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", "startObservingDevices", "stopObservingDevices", "updateDevices", "devices", "open", "request", "canOpen", "expectedConversation", "cancelOpen", "onCleared", "errorMessage", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "State", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcRemoteFilePage extends ViewModel implements LifecycleEventObserver {
    public static final a Companion = null;
    private static final String TAG = "PcRemoteFilePage";
    private String confirmedDeviceAccountId;
    private String conversationId;
    private Function0<String> conversationIdProvider;
    private final Lazy deviceCollection$delegate;
    private final Lazy deviceListProvider$delegate;
    private Map<String, Boolean> deviceOnlineStatuses;
    private Job deviceRefreshJob;
    private WeakReference<Fragment> host;
    private boolean isObservingDevices;
    private final MutableLiveData<b> mutableState;
    private Job openJob;
    private long operationId;
    private LifecycleOwner owner;
    private g pendingRequest;
    private final CoroutineScope scope;
    private final LiveData<b> state;

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f309437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f309438b;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f309437a, r101.f309437a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f309438b, r101.f309438b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            g r100 = this.f309437a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f309438b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "State(loading=" + this.f309437a + ", deviceNames=" + this.f309438b + ')';
        }

        public /* synthetic */ b(int r100) {
            this(null, MapsKt.emptyMap());
        }

        public b(g r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r101, "deviceNames");
            this.f309437a = r100;
            this.f309438b = r101;
        }

        public static b a(b r100, g r101, Map r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f309437a;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = r100.f309438b;
        L8:
            Intrinsics.checkNotNullParameter(r102, "deviceNames");
            return new b(r101, r102);
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f309439a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Lifecycle.Event.ON_STOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f309439a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFilePage$open$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFilePage$open$1", f = "PcRemoteFilePage.kt", i = {0, 0, 1, 2, 2, 3, 3}, l = {166, 169, 182, 186}, m = "invokeSuspend", n = {"$this$launch", "preparingPreview", "preparingPreview", "file", "preparingPreview", "file", "preparingPreview"}, s = {"L$0", "I$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $autoOpenTimeoutMs;
        final /* synthetic */ String $expectedAccount;
        final /* synthetic */ String $expectedConversation;
        final /* synthetic */ long $identifier;
        final /* synthetic */ g $request;
        final /* synthetic */ long $triggeredAt;
        int I$0;
        long J$0;
        long J$1;
        long J$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PcRemoteFilePage this$0;

        public AnonymousClass1(g r100, String r101, long r102, PcRemoteFilePage r103, String r104, long r105, long r106, Continuation<? super AnonymousClass1> r110) {
            this.$request = r100;
            this.$expectedAccount = r101;
            this.$identifier = r102;
            this.this$0 = r103;
            this.$expectedConversation = r104;
            this.$triggeredAt = r105;
            this.$autoOpenTimeoutMs = r106;
            super(2, r110);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
            AnonymousClass1 r112 = new AnonymousClass1(this.$request, this.$expectedAccount, this.$identifier, this.this$0, this.$expectedConversation, this.$triggeredAt, this.$autoOpenTimeoutMs, r111);
            r112.L$0 = r110;
            return r112;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 != 0) goto L212;
            String r110 = PcRemoteFilePage.TAG;
            ResultKt.throwOnFailure(r210);
            CoroutineScope r102 = (CoroutineScope) this.L$0;
            PcRemoteFileRepository r103 = PcRemoteFileRepository.f309440a;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            g r104 = this.$request;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            this.L$0 = r102;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            this.I$0 = 0;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            this.label = 1;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            Object r105 = PcRemoteFileRepository.f(r104, this);     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L180
            if (r105 != r100) goto L34;
            return r100;
        L34:
            int r106 = 0;
        L227:
            File r107 = (File) r105;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L178
            if (r107 == null) goto L223;
            String r211 = "stage=file_open_failed preview=";
            Object r108 = r100;
        L105:
            String r109 = r110;
            FlowDriveSdkService r111 = FlowDriveSdkService.f365704a;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L175
            this.L$0 = r107;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L175
            this.L$1 = null;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L175
            this.L$2 = null;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L175
            this.I$0 = 1;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L173
            this.label = 3;     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L173
            Object r112 = r111.v(this);     // Catch: Throwable -> L141 CancellationException -> L145 Exception -> L173
            if (r112 != r108) goto L111;
            return r108;
        L111:
            r106 = 1;
        L219:
        L143:
            e = e;
        L182:
            FLogger r113 = FLogger.f375446a;     // Catch: Throwable -> L141
            StringBuilder r114 = new StringBuilder(r211);     // Catch: Throwable -> L141
            if (r106 == 0) goto L185;
            boolean r115 = true;
        L186:
            r114.append(r115);     // Catch: Throwable -> L141
            r114.append(" type=");     // Catch: Throwable -> L141
            r114.append(e.getClass().getSimpleName());     // Catch: Throwable -> L141
            r113.w(r109, r114.toString());     // Catch: Throwable -> L141
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L197;
            if (Intrinsics.areEqual(AccountService.f365697a.getUserId(), this.$expectedAccount) == false) goto L197;
            if (PcRemoteFilePage.access$canOpen(this.this$0, this.$expectedConversation) == false) goto L197;
            if (r106 == 0) goto L194;
            int r116 = R.string.larus_artifactCard_status_previewFail;
        L195:
            s r117 = s.f544207a;     // Catch: Throwable -> L141
            Application r118 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L141
            r117.getClass();     // Catch: Throwable -> L141
            s.b(r118, r116, false);     // Catch: Throwable -> L141
            goto L197
        L194:
            r116 = PcRemoteFilePage.access$errorMessage(this.this$0, e);     // Catch: Throwable -> L141
        L197:
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L203;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r119 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r120 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r120 != null) goto L201;
            r120 = new b(0);
        L201:
            r119.setValue(b.a(r120, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L203:
            return Unit.INSTANCE;
        L185:
            r115 = false;
            goto L186
        L113:
            if (((Boolean) r112).booleanValue() == false) goto L172;
            PcRemoteFileRepository r121 = PcRemoteFileRepository.f309440a;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            g r122 = this.$request;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            this.L$0 = r107;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            this.I$0 = r106;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            this.label = 4;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            Object r123 = PcRemoteFileRepository.f(r122, this);     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (r123 != r108) goto L118;
            return r108;
        L118:
            if (Intrinsics.areEqual((File) r123, r107) == true) goto L120;
        L163:
            Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L170;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r125 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r126 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r126 != null) goto L169;
            r126 = new b(0);
        L169:
            r125.setValue(b.a(r126, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L170:
            return r124;
        L120:
            if (Intrinsics.areEqual(AccountService.f365697a.getUserId(), this.$expectedAccount) == false) goto L163;
            if (this.$identifier == PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L125;
        L155:
            Unit r127 = Unit.INSTANCE;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L162;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r128 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r129 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r129 != null) goto L161;
            r129 = new b(0);
        L161:
            r128.setValue(b.a(r129, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L162:
            return r127;
        L125:
            if (PcRemoteFilePage.access$canOpen(this.this$0, this.$expectedConversation) == false) goto L155;
            Fragment r130 = (Fragment) PcRemoteFilePage.access$getHost$p(this.this$0).get();     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (r130 == null) goto L147;
            FragmentActivity r131 = r130.getActivity();     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (r131 == null) goto L147;
            FlowDriveSdkService r132 = FlowDriveSdkService.f365704a;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            String r133 = r107.getAbsolutePath();     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            String r134 = r107.getName();     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            int r135 = PcLocalFilePreviewProvider.f309429a;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (r132.s(r131, r133, r134, PcLocalFilePreviewProvider.a.a(r131)) == false) goto L140;
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L203;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            r119 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            r120 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r120 != null) goto L201;
            r120 = new b(0);
            goto L201
        L140:
            throw new IllegalStateException("local_preview_open_failed");     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
        L147:
            Unit r136 = Unit.INSTANCE;     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L154;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r137 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r138 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r138 != null) goto L153;
            r138 = new b(0);
        L153:
            r137.setValue(b.a(r138, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L154:
            return r136;
        L172:
            throw new IllegalStateException("local_preview_unavailable");     // Catch: Throwable -> L141 Exception -> L143 CancellationException -> L145
        L173:
            e = e;
        L177:
            r106 = 1;
        L175:
            e = e;
            goto L177
        L223:
            PcRemoteFilePage r139 = this.this$0;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            g r140 = this.$request;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            long r141 = this.$triggeredAt;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            long r142 = this.$identifier;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            long r143 = this.$autoOpenTimeoutMs;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            String r144 = this.$expectedAccount;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            String r145 = this.$expectedConversation;     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            MutableLiveData r146 = PcRemoteFilePage.access$getMutableState$p(r139);     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            b r147 = (b) PcRemoteFilePage.access$getMutableState$p(r139).getValue();     // Catch: Exception -> L99 Throwable -> L141 CancellationException -> L145
            if (r147 != null) goto L46;
            r211 = "stage=file_open_failed preview=";
            b r148 = new b(0);     // Catch: Exception -> L43 Throwable -> L141 CancellationException -> L145
        L229:
            r146.setValue(b.a(r148, r140, null, 2));     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            PcRemoteFileRepository r149 = PcRemoteFileRepository.f309440a;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.L$0 = r139;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.L$1 = r144;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.L$2 = r145;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.I$0 = r106;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.J$0 = r141;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.J$1 = r142;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.J$2 = r143;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            this.label = 2;     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            Object r150 = r149.j(r140, this);     // Catch: Exception -> L97 Throwable -> L141 CancellationException -> L145
            r108 = r100;
            if (r150 != r108) goto L52;
            return r108;
        L52:
            long r151 = r142;
            long r152 = r143;
            String r153 = r144;
        L233:
            r107 = (File) r150;     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            long r154 = SystemClock.elapsedRealtime() - r141;     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            if (r151 == PcRemoteFilePage.access$getOperationId$p(r139)) goto L63;
            Unit r155 = Unit.INSTANCE;     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L62;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r156 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r157 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r157 != null) goto L61;
            r157 = new b(0);
        L61:
            r156.setValue(b.a(r157, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L62:
            return r155;
        L63:
            MutableLiveData r158 = PcRemoteFilePage.access$getMutableState$p(r139);     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            b r159 = (b) PcRemoteFilePage.access$getMutableState$p(r139).getValue();     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            if (r159 != null) goto L66;
            r159 = new b(0);     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
        L66:
            r158.setValue(b.a(r159, null, null, 2));     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            if (r152 <= 0) goto L84;
            if (r154 > r152) goto L84;
            if (Intrinsics.areEqual(AccountService.f365697a.getUserId(), r153) == true) goto L74;
        L75:
            Unit r160 = Unit.INSTANCE;     // Catch: Exception -> L95 Throwable -> L141 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L82;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r161 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r162 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r162 != null) goto L81;
            r162 = new b(0);
        L81:
            r161.setValue(b.a(r162, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L82:
            return r160;
        L74:
            if (PcRemoteFilePage.access$canOpen(r139, r145) == true) goto L105;
        L84:
            r109 = r110;
            FLogger.f375446a.i(r109, "stage=auto_open_skipped elapsed_ms=" + r154 + " timeout_ms=" + r152);     // Catch: Exception -> L93 Throwable -> L141 CancellationException -> L145
            Unit r163 = Unit.INSTANCE;     // Catch: Exception -> L93 Throwable -> L141 CancellationException -> L145
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L92;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r164 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r165 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r165 != null) goto L91;
            r165 = new b(0);
        L91:
            r164.setValue(b.a(r165, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L92:
            return r163;
        L93:
            e = e;
        L101:
            int r166 = r106;
        L102:
            r106 = r166;
        L95:
            e = e;
        L45:
            r109 = r110;
        L97:
            e = e;
        L43:
            e = e;
            r166 = r106;
        L29:
            r109 = r110;
            goto L102
        L46:
            r211 = "stage=file_open_failed preview=";
            r148 = r147;
        L99:
            e = e;
            r211 = "stage=file_open_failed preview=";
        L178:
            e = e;
            r211 = "stage=file_open_failed preview=";
            r109 = r110;
        L180:
            e = e;
            r211 = "stage=file_open_failed preview=";
            r109 = r110;
            r106 = 0;
            goto L182
        L212:
            if (r101 == 1) goto L23;
            if (r101 == 2) goto L20;
            if (r101 == 3) goto L15;
            if (r101 != 4) goto L14;
            r166 = this.I$0;
            File r167 = (File) this.L$0;
            ResultKt.throwOnFailure(r210);     // Catch: Exception -> L11 Throwable -> L141 CancellationException -> L145
            r107 = r167;
            r123 = r210;
        L11:
            e = e;
            r211 = "stage=file_open_failed preview=";
            r109 = PcRemoteFilePage.TAG;
            goto L102
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            int r168 = this.I$0;
            File r169 = (File) this.L$0;
            ResultKt.throwOnFailure(r210);     // Catch: Exception -> L18 Throwable -> L141 CancellationException -> L145
            r211 = "stage=file_open_failed preview=";
            r108 = r100;
            r106 = r168;
            r109 = PcRemoteFilePage.TAG;
            r107 = r169;
            r112 = r210;
        L18:
            e = e;
            r166 = r168;
            r110 = PcRemoteFilePage.TAG;
        L28:
            r211 = "stage=file_open_failed preview=";
            goto L29
        L20:
            long r170 = this.J$2;
            long r171 = this.J$1;
            r110 = PcRemoteFilePage.TAG;
            long r172 = this.J$0;
            int r173 = this.I$0;
            r145 = (String) this.L$2;
            r153 = (String) this.L$1;
            r139 = (PcRemoteFilePage) this.L$0;
            ResultKt.throwOnFailure(r210);     // Catch: Exception -> L26 Throwable -> L141 CancellationException -> L145
            r211 = "stage=file_open_failed preview=";
            r108 = r100;
            r151 = r171;
            r150 = r210;
            r152 = r170;
            r141 = r172;
            r106 = r173;
            goto L233
        L23:
            r110 = PcRemoteFilePage.TAG;
            int r174 = this.I$0;
            CoroutineScope r175 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r210);     // Catch: Exception -> L26 Throwable -> L141 CancellationException -> L145
            r106 = r174;
            r105 = r210;
        L26:
            e = e;
            r166 = r101;
        L145:
            e = move-exception;
            throw e;     // Catch: Throwable -> L141
        L141:
            th = move-exception;
            if (this.$identifier != PcRemoteFilePage.access$getOperationId$p(this.this$0)) goto L211;
            PcRemoteFilePage.access$setPendingRequest$p(this.this$0, null);
            MutableLiveData r176 = PcRemoteFilePage.access$getMutableState$p(this.this$0);
            b r177 = (b) PcRemoteFilePage.access$getMutableState$p(this.this$0).getValue();
            if (r177 != null) goto L210;
            r177 = new b(0);
        L210:
            r176.setValue(b.a(r177, null, null, 2));
            PcRemoteFilePage.access$setOpenJob$p(this.this$0, null);
        L211:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFilePage$startObservingDevices$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFilePage$startObservingDevices$1", f = "PcRemoteFilePage.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    public static final class C109071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        int label;
        final /* synthetic */ PcRemoteFilePage this$0;

        public C109071(PcRemoteFilePage r100, String r101, Continuation<? super C109071> r102) {
            this.this$0 = r100;
            this.$accountId = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C109071(this.this$0, this.$accountId, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C109071) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L13;
            if (r102 != 1) goto L12;
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L7 CancellationException -> L9
        L17:
            bs8.f r103 = (bs8.f) r100;     // Catch: Exception -> L7 CancellationException -> L9
            if (Intrinsics.areEqual(this.$accountId, AccountService.f365697a.getUserId()) == true) goto L22;
            return Unit.INSTANCE;
        L22:
            if (r103.f20306b == false) goto L28;
            PcRemoteFilePage r104 = this.this$0;     // Catch: Exception -> L7 CancellationException -> L9
            String r105 = this.$accountId;     // Catch: Exception -> L7 CancellationException -> L9
            if ((true ^ StringsKt.isBlank(r105)) == true) goto L27;
            r105 = null;
        L27:
            PcRemoteFilePage.access$setConfirmedDeviceAccountId$p(r104, r105);     // Catch: Exception -> L7 CancellationException -> L9
        L28:
            PcRemoteFilePage.access$updateDevices(this.this$0, r103.f20305a);     // Catch: Exception -> L7 CancellationException -> L9
        L32:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r100);
            com.larus.bmhome.taskskill.service.d r106 = PcRemoteFilePage.access$getDeviceListProvider(this.this$0);     // Catch: Exception -> L7 CancellationException -> L9
            this.label = 1;     // Catch: Exception -> L7 CancellationException -> L9
            r100 = r106.a(this);     // Catch: Exception -> L7 CancellationException -> L9
            if (r100 != r101) goto L17;
            return r101;
        L9:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            FLogger.f375446a.w(PcRemoteFilePage.TAG, "stage=device_names_failed type=".concat(e.getClass().getSimpleName()));
            goto L32
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ com.larus.bmhome.taskskill.service.d Mo() {
        return deviceListProvider_delegate$lambda$0();
    }

    public static /* synthetic */ MutableLiveData No(PcRemoteFilePage r100) {
        return deviceCollection_delegate$lambda$1(r100);
    }

    public static /* synthetic */ Unit yo(PcRemoteFilePage r100, bs8.e r101) {
        return bind$lambda$4$lambda$3(r100, r101);
    }

    private final void cancelOpen() {
        this.operationId++;
        Job r100 = this.openJob;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.openJob = null;
        this.pendingRequest = null;
        MutableLiveData<b> r101 = this.mutableState;
        b r102 = r101.getValue();
        if (r102 != null) goto L8;
        r102 = new b(0);
    L8:
        r101.setValue(b.a(r102, null, null, 2));
    }

    private static final com.larus.bmhome.taskskill.service.d deviceListProvider_delegate$lambda$0() {
        return TaskModeService.f314424a.d();
    }

    private final MutableLiveData<bs8.e> getDeviceCollection() {
        return (MutableLiveData) this.deviceCollection$delegate.getValue();
    }

    private final com.larus.bmhome.taskskill.service.d getDeviceListProvider() {
        return (com.larus.bmhome.taskskill.service.d) this.deviceListProvider$delegate.getValue();
    }

    private final void startObservingDevices() {
        if (this.isObservingDevices == false) goto L5;
        return;
    L5:
        this.isObservingDevices = true;
        getDeviceListProvider().f();
        updateDevices(getDeviceListProvider().b());
        String r100 = AccountService.f365697a.getUserId();
        this.deviceRefreshJob = BuildersKt.launch$default(this.scope, null, null, new C109071(this, r100, null), 3, null);
    }

    private final void stopObservingDevices() {
        if (this.isObservingDevices == true) goto L5;
        return;
    L5:
        this.isObservingDevices = false;
        Job r100 = this.deviceRefreshJob;
        if (r100 == null) goto L8;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L8:
        this.deviceRefreshJob = null;
        getDeviceListProvider().e();
    }

    public PcRemoteFilePage() {
        MutableLiveData<b> r100 = new MutableLiveData(new b(0));
        this.mutableState = r100;
        this.state = r100;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.host = new WeakReference(null);
        this.deviceListProvider$delegate = LazyKt.lazy(new com.larus.bmhome.chat.standarduikit.localfileblock.remote.a());
        this.deviceCollection$delegate = LazyKt.lazy(new com.larus.bmhome.chat.standarduikit.localfileblock.remote.b(this));
        this.deviceOnlineStatuses = MapsKt.emptyMap();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        cancelOpen();
        stopObservingDevices();
        LifecycleOwner r100 = this.owner;
        if (r100 == null) goto L5;
        r100.getLifecycle().removeObserver(this);
        getDeviceCollection().removeObservers(r100);
    L5:
        this.owner = null;
        this.host.clear();
        this.conversationIdProvider = null;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    public final LiveData<b> getState() {
        return this.state;
    }

    public static final /* synthetic */ com.larus.bmhome.taskskill.service.d access$getDeviceListProvider(PcRemoteFilePage r100) {
        return r100.getDeviceListProvider();
    }

    public static final /* synthetic */ WeakReference access$getHost$p(PcRemoteFilePage r100) {
        return r100.host;
    }

    public static final /* synthetic */ MutableLiveData access$getMutableState$p(PcRemoteFilePage r100) {
        return r100.mutableState;
    }

    public static final /* synthetic */ long access$getOperationId$p(PcRemoteFilePage r100) {
        return r100.operationId;
    }

    private final boolean canOpen(String r100) {
        Fragment r101 = this.host.get();
        if (r101 != null) goto L5;
        return false;
    L5:
        FragmentActivity r102 = r101.getActivity();
        if (r102 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.conversationId, r100) == false) goto L48;
        Function0<String> r103 = this.conversationIdProvider;
        if (r103 == null) goto L13;
        String r104 = r103.invoke();
    L15:
        if (Intrinsics.areEqual(r104, r100) == true) goto L17;
        return false;
    L17:
        if (r101.isAdded() == true) goto L19;
        return false;
    L19:
        if (r101.isRemoving() == false) goto L21;
        return false;
    L21:
        if (r101.isHidden() == false) goto L23;
        return false;
    L23:
        if (r101.isVisible() == true) goto L25;
        return false;
    L25:
        if (r102.isFinishing() == false) goto L27;
        return false;
    L27:
        if (r102.isDestroyed() == true) goto L55;
        LifecycleOwner r105 = this.owner;
        if (r105 == null) goto L37;
        Lifecycle r106 = r105.getLifecycle();
        if (r106 == null) goto L37;
        Lifecycle.State r107 = r106.getCurrentState();
        if (r107 == null) goto L37;
        if (r107.isAtLeast(Lifecycle.State.RESUMED) != true) goto L37;
        boolean r108 = true;
    L38:
        if (r108 == false) goto L56;
        View r109 = r101.getView();
        if (r109 != null) goto L42;
    L44:
        boolean r110 = false;
    L45:
        if (r110 == false) goto L57;
        return true;
    L57:
        return false;
    L42:
        if (r109.hasWindowFocus() != true) goto L44;
        r110 = true;
        goto L45
    L56:
        return false;
    L37:
        r108 = false;
        goto L38
    L55:
        return false;
    L13:
        r104 = null;
        goto L15
    L48:
        return false;
    }

    private static final MutableLiveData deviceCollection_delegate$lambda$1(PcRemoteFilePage r100) {
        return r100.getDeviceListProvider().d();
    }

    private final int errorMessage(Exception r100) {
        Integer r101 = null;
        if ((r100 instanceof PcRemoteFileException) == false) goto L5;
        PcRemoteFileException r102 = (PcRemoteFileException) r100;
    L6:
        if (r102 == null) goto L8;
        PcRemoteFileError r103 = r102.getKind();
    L10:
        if (r103 != PcRemoteFileError.DOWNLOAD_FAILED) goto L12;
        return R.string.larus_slides_download_toast_fail;
    L12:
        if (r102 == null) goto L14;
        PcRemoteFileError r104 = r102.getKind();
    L16:
        if (r104 == PcRemoteFileError.FILE_NOT_FOUND) goto L65;
        boolean r105 = true;
        if (r102 == null) goto L25;
        Integer r106 = r102.getCode();
        if (r106 == null) goto L25;
        if (r106.intValue() != 11) goto L25;
        boolean r107 = true;
    L26:
        if (r107 == true) goto L65;
        Set r108 = SetsKt.setOf(new Integer[]{2, 6, 10});
        if (r102 == null) goto L32;
        r101 = r102.getCode();
    L32:
        if (CollectionsKt.contains(r108, r101) == false) goto L34;
        return R.string.larus_pc_remote_file_old_version;
    L34:
        if (r102 == null) goto L41;
        Integer r109 = r102.getCode();
        if (r109 == null) goto L41;
        if (r109.intValue() != 7) goto L41;
        boolean r110 = true;
    L42:
        if (r110 == false) goto L44;
        return R.string.larus_pc_remote_file_offline;
    L44:
        if (r102 == null) goto L51;
        Integer r111 = r102.getCode();
        int r112 = DispatchErrorCode.DISPATCH_ERROR_CODE_UNSUPPORTED_FILE_TYPE.value;
        if (r111 == null) goto L51;
        if (r111.intValue() != r112) goto L51;
        boolean r113 = true;
    L52:
        if (r113 == false) goto L54;
        return R.string.larus_pc_remote_file_type_not_supported;
    L54:
        if (r102 == null) goto L61;
        Integer r114 = r102.getCode();
        if (r114 == null) goto L61;
        if (r114.intValue() != 14) goto L61;
    L62:
        if (r105 == false) goto L64;
        return R.string.larus_pc_remote_file_too_large;
    L64:
        return R.string.larus_pc_remote_file_network_error;
    L61:
        r105 = false;
    L51:
        r113 = false;
    L41:
        r110 = false;
    L25:
        r107 = false;
    L65:
        return R.string.larus_pc_remote_file_not_found;
    L14:
        r104 = null;
        goto L16
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    private final void updateDevices(bs8.e r100) {
        if (r100 == null) goto L5;
        List<PcDevice> r101 = r100.a();
    L6:
        if (r101 != null) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L10:
        if (r103.hasNext() == false) goto L23;
        PcDevice r104 = (PcDevice) r103.next();
        String r105 = r104.getDeviceId();
        if (r105 != null) goto L14;
    L20:
        Pair r106 = null;
    L21:
        if (r106 == null) goto L10;
        r102.add(r106);
        goto L10
    L14:
        if ((true ^ StringsKt.isBlank(r105)) == true) goto L17;
        r105 = null;
    L17:
        if (r105 == null) goto L20;
        r106 = TuplesKt.to(r105, r104.r());
        goto L21
    L23:
        this.deviceOnlineStatuses = MapsKt.toMap(r102);
        if (r100 == null) goto L26;
        List<PcDevice> r107 = r100.a();
    L27:
        if (r107 != null) goto L29;
        r107 = CollectionsKt.emptyList();
    L29:
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L30:
        int r110 = 0;
        if (r109.hasNext() == false) goto L56;
        PcDevice r111 = (PcDevice) r109.next();
        String r112 = r111.getDeviceId();
        if (r112 != null) goto L35;
    L53:
        Pair r113 = null;
    L54:
        if (r113 == null) goto L30;
        r108.add(r113);
        goto L30
    L35:
        if ((!StringsKt.isBlank(r112)) == true) goto L38;
        r112 = null;
    L38:
        if (r112 == null) goto L53;
        String r114 = r111.d();
        if (r114 == null) goto L53;
        String r115 = StringsKt.trim(r114).toString();
        if (r115 == null) goto L53;
        if (r115.length() <= 0) goto L47;
        r110 = 1;
    L47:
        if (r110 != 0) goto L50;
        r115 = null;
    L50:
        if (r115 == null) goto L53;
        r113 = TuplesKt.to(r112, r115);
        goto L54
    L56:
        Map r116 = MapsKt.toMap(r108);
        b r117 = this.mutableState.getValue();
        if (r117 != null) goto L60;
        r117 = new b(r110);
    L60:
        if (Intrinsics.areEqual(r117.f309438b, r116) == true) goto L73;
        this.mutableState.setValue(b.a(r117, null, r116, 1));
        return;
    L73:
        return;
    L26:
        r107 = null;
        goto L27
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isSourceDeviceOffline(String r100) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        String r101 = this.confirmedDeviceAccountId;
        if (r101 != null) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r101, AccountService.f365697a.getUserId()) == false) goto L9;
        if (Intrinsics.areEqual(this.deviceOnlineStatuses.get(r100), Boolean.FALSE) == false) goto L9;
        return true;
    }

    public final void open(g r210) {
        Intrinsics.checkNotNullParameter(r210, "request");
        if (FlowDriveSdkService.f365704a.o() == true) goto L6;
        s r100 = s.f544207a;
        Application r101 = AppHost.f326268a.getApplication();
        r100.getClass();
        s.s(r101, R.string.larus_pc_local_file_access_denied);
        return;
    L6:
        g r102 = this.pendingRequest;
        boolean r103 = true;
        if (r102 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L24;
        b r105 = this.mutableState.getValue();
        if (r105 == null) goto L20;
        g r106 = r105.f309437a;
        if (r106 == null) goto L20;
        if (d.a(r106, r210) != true) goto L20;
    L21:
        if (r103 == false) goto L29;
        s r107 = s.f544207a;
        Application r108 = AppHost.f326268a.getApplication();
        r107.getClass();
        s.s(r108, R.string.larus_pc_remote_file_loading);
        return;
    L29:
        return;
    L20:
        r103 = false;
        goto L21
    L24:
        String r109 = this.conversationId;
        String r110 = AccountService.f365697a.getUserId();
        if (canOpen(r109) == true) goto L27;
        return;
    L27:
        long r111 = SystemClock.elapsedRealtime();
        long r112 = 1000 * ((long) RangesKt.coerceAtLeast(p1.f365785a.remoteFileAutoOpenTimeoutSeconds(), 0));
        cancelOpen();
        long r113 = this.operationId;
        this.pendingRequest = r210;
        this.openJob = BuildersKt.launch$default(this.scope, null, null, new AnonymousClass1(r210, r110, r113, this, r109, r111, r112, null), 3, null);
        return;
    L9:
        if (d.a(r102, r210) != true) goto L11;
        r104 = true;
        goto L12
    }

    public static final /* synthetic */ boolean access$canOpen(PcRemoteFilePage r100, String r101) {
        return r100.canOpen(r101);
    }

    public static final /* synthetic */ int access$errorMessage(PcRemoteFilePage r100, Exception r101) {
        return r100.errorMessage(r101);
    }

    public static final /* synthetic */ void access$setConfirmedDeviceAccountId$p(PcRemoteFilePage r100, String r101) {
        r100.confirmedDeviceAccountId = r101;
    }

    public static final /* synthetic */ void access$setOpenJob$p(PcRemoteFilePage r100, Job r101) {
        r100.openJob = r101;
    }

    public static final /* synthetic */ void access$setPendingRequest$p(PcRemoteFilePage r100, g r101) {
        r100.pendingRequest = r101;
    }

    public static final /* synthetic */ void access$updateDevices(PcRemoteFilePage r100, bs8.e r101) {
        r100.updateDevices(r101);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.standarduikit.localfileblock.remote.c] */
    private final void bind(Fragment r100, Function0<String> r101) {
        if (r101 == null) goto L5;
        String r102 = r101.invoke();
    L7:
        if (Intrinsics.areEqual(this.conversationId, r102) == true) goto L9;
        cancelOpen();
    L9:
        this.conversationId = r102;
        this.conversationIdProvider = r101;
        this.host = new WeakReference(r100);
        LifecycleOwner r103 = r100.getViewLifecycleOwnerLiveData().getValue();
        if (this.owner == r103) goto L18;
        cancelOpen();
        stopObservingDevices();
        this.confirmedDeviceAccountId = null;
        LifecycleOwner r104 = this.owner;
        if (r104 == null) goto L14;
        r104.getLifecycle().removeObserver(this);
        getDeviceCollection().removeObservers(r104);
    L14:
        this.owner = r103;
        if (r103 == null) goto L19;
        getDeviceCollection().observe(r103, new d.a(new com.larus.bmhome.chat.standarduikit.localfileblock.remote.c(this)));
        r103.getLifecycle().addObserver(this);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r102 = null;
        goto L7
    }

    private static final Unit bind$lambda$4$lambda$3(PcRemoteFilePage r100, bs8.e r101) {
        r100.updateDevices(r101);
        return Unit.INSTANCE;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = c.f309439a[r101.ordinal()];
        if (r102 != 1) goto L5;
        startObservingDevices();
        return;
    L5:
        if (r102 != 2) goto L7;
        cancelOpen();
        return;
    L7:
        if (r102 != 3) goto L9;
    L11:
        cancelOpen();
        stopObservingDevices();
        return;
    L9:
        if (r102 == 4) goto L11;
    }

    public static final /* synthetic */ void access$bind(PcRemoteFilePage r100, Fragment r101, Function0 r102) {
        r100.bind(r101, r102);
    }
}
