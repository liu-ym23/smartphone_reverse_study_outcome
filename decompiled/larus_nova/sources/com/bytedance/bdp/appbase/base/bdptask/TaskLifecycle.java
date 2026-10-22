package com.bytedance.bdp.appbase.base.bdptask;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u00042345B\u0007¢\u0006\u0004\b0\u00101J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\u0016\u001a\u00020\u0015H\u0007J\b\u0010\u0017\u001a\u00020\u0000H\u0007R$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188G@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001f8G@BX\u0086\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R3\u0010)\u001a\u001f\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0015\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010*R]\u0010.\u001aI\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0015\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00066"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "withCtx", "Landroidx/lifecycle/LifecycleOwner;", "owner", "with", "Landroidx/lifecycle/LifecycleRegistry;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$Event;", "event", "start", "addStart", "clearStart", "pause", "addPause", "clearPause", MapMonitorConst.EVENT_DESTROY, "addDestroy", "clearDestroy", "", "refreshState", "copy", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State;", "<set-?>", "e", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State;", "getCurState", "()Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State;", "curState", "", "f", "Z", "getObserverStarted", "()Z", "observerStarted", "Lkotlin/Function1;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent;", "Lkotlin/ParameterName;", "name", "eventChanged", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function3;", "oldState", "newState", "stateChanged", "Lkotlin/jvm/functions/Function3;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Event", "LifecycleEvent", "State", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class TaskLifecycle {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f200468i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f200469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f200470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f200471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f200472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public State f200473e;
    public Function1<? super LifecycleEvent, Unit> eventChanged;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f200474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<LifecycleRegistry> f200475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TaskLifecycle$startObserver$$inlined$also$lambda$1 f200476h;
    public Function3<? super LifecycleEvent, ? super State, ? super State, Unit> stateChanged;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0001\u000bB\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\u0004R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$Event;", "", "other", SRStrategy.KEY_ORIGIN_RESOLUTION, "", "code", "I", "getCode", "()I", "<init>", "(I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
    public static class Event {
        private final int code;

        public static final class a extends Event {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f200477a = null;

            public a() {
                super(0);
            }

            static {
                f200477a = new a();
            }
        }

        public final int getCode() {
            return this.code;
        }

        public Event(int r100) {
            this.code = r100;
        }

        public final Event or(Event r100) {
            int r101 = this.code;
            return new Event(r100.code | r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\t\n\u000b\f\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$Event;", "code", "", "name", "", "(ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "Created", "Destroyed", "Initialized", "Resumed", "Started", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent$Created;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent$Destroyed;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent$Initialized;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent$Resumed;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent$Started;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
    public static abstract class LifecycleEvent extends Event {
        private final String name;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent$Created;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent;", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
        public static final class Created extends LifecycleEvent {
            public static final Created INSTANCE = null;

            static {
                INSTANCE = new Created();
            }

            private Created() {
                int r100 = 2;
                super(r100, "Created", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent$Destroyed;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent;", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
        public static final class Destroyed extends LifecycleEvent {
            public static final Destroyed INSTANCE = null;

            static {
                INSTANCE = new Destroyed();
            }

            private Destroyed() {
                int r100 = 16;
                super(r100, "Destroyed", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent$Initialized;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent;", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
        public static final class Initialized extends LifecycleEvent {
            public static final Initialized INSTANCE = null;

            static {
                INSTANCE = new Initialized();
            }

            private Initialized() {
                int r100 = 1;
                super(r100, "Initialized", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent$Resumed;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent;", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
        public static final class Resumed extends LifecycleEvent {
            public static final Resumed INSTANCE = null;

            static {
                INSTANCE = new Resumed();
            }

            private Resumed() {
                int r100 = 8;
                super(r100, "Resumed", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent$Started;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$LifecycleEvent;", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
        public static final class Started extends LifecycleEvent {
            public static final Started INSTANCE = null;

            static {
                INSTANCE = new Started();
            }

            private Started() {
                int r100 = 4;
                super(r100, "Started", null);
            }
        }

        public final String getName() {
            return this.name;
        }

        private LifecycleEvent(int r100, String r101) {
            super(r100);
            this.name = r101;
        }

        public /* synthetic */ LifecycleEvent(int r100, String r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State;", "", "code", "", "name", "", "(ILjava/lang/String;)V", "getCode", "()I", "getName", "()Ljava/lang/String;", "Destroy", "Pause", "Start", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State$Destroy;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State$Pause;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State$Start;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
    public static abstract class State {
        private final int code;
        private final String name;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State$Destroy;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State;", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
        public static final class Destroy extends State {
            public static final Destroy INSTANCE = null;

            static {
                INSTANCE = new Destroy();
            }

            private Destroy() {
                int r100 = 4;
                super(r100, "Destroy", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State$Pause;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State;", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
        public static final class Pause extends State {
            public static final Pause INSTANCE = null;

            static {
                INSTANCE = new Pause();
            }

            private Pause() {
                int r100 = 2;
                super(r100, "Pause", null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State$Start;", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle$State;", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
        public static final class Start extends State {
            public static final Start INSTANCE = null;

            static {
                INSTANCE = new Start();
            }

            private Start() {
                int r100 = 1;
                super(r100, "Start", null);
            }
        }

        public final int getCode() {
            return this.code;
        }

        public final String getName() {
            return this.name;
        }

        private State(int r100, String r101) {
            this.code = r100;
            this.name = r101;
        }

        public /* synthetic */ State(int r100, String r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }

        public static Activity a(Context r100) {
            if ((r100 instanceof Activity) == true) goto L5;
            Context r101 = null;
        L6:
            Activity r102 = (Activity) r101;
            if (r102 != null) goto L12;
            if ((r100 instanceof ContextWrapper) == true) goto L14;
            return null;
        L14:
            return a(((ContextWrapper) r100).getBaseContext());
        L12:
            return r102;
        L5:
            r101 = r100;
            goto L6
        }
    }

    public final void refreshState() {
        b(false);
    }

    static {
        f200468i = new a();
    }

    public final State a() {
        WeakReference<LifecycleRegistry> r100 = this.f200475g;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L35;
        if (r100 != null) goto L15;
    L20:
        boolean r103 = false;
    L21:
        if (r103 == true) goto L36;
        if (r100 != null) goto L25;
    L31:
        if (r101 == false) goto L34;
        return State.Start.INSTANCE;
    L34:
        return this.f200473e;
    L25:
        if (((this.f200469a & 31) & this.f200470b) == 0) goto L27;
        boolean r104 = true;
    L28:
        if (r104 == true) goto L31;
        r101 = false;
        goto L31
    L27:
        r104 = false;
        goto L28
    L36:
        return State.Pause.INSTANCE;
    L15:
        if (((this.f200469a & 31) & this.f200471c) == 0) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
        r103 = true;
        goto L21
    L17:
        r105 = false;
        goto L18
    L35:
        return State.Destroy.INSTANCE;
    L5:
        if (((this.f200469a & 31) & this.f200472d) == 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == false) goto L10;
        r102 = true;
        goto L11
    L7:
        r106 = false;
        goto L8
    }

    public final void c() {
        WeakReference<LifecycleRegistry> r100 = this.f200475g;
        if (r100 == null) goto L9;
        final LifecycleRegistry r101 = r100.get();
        if (r101 == null) goto L9;
        final TaskLifecycle$startObserver$$inlined$also$lambda$1 r102 = this.f200476h;
        if (r102 == null) goto L9;
        BdpPool.runOnMain(new TaskLifecycle$$special$$inlined$let$lambda$1(r102, r101));
    L9:
        this.f200475g = null;
        this.f200476h = null;
        this.f200474f = false;
    }

    public final TaskLifecycle copy() {
        TaskLifecycle r100 = new TaskLifecycle();
        r100.f200469a = this.f200469a;
        r100.f200470b = this.f200470b;
        r100.f200471c = this.f200471c;
        r100.f200472d = this.f200472d;
        WeakReference<LifecycleRegistry> r101 = this.f200475g;
        if (r101 == null) goto L7;
        LifecycleRegistry r102 = r101.get();
        if (r102 == null) goto L7;
        r100.with(r102);
    L7:
        r100.refreshState();
        return r100;
    }

    public TaskLifecycle() {
        LifecycleEvent.Resumed r100 = LifecycleEvent.Resumed.INSTANCE;
        start(r100);
        pause(LifecycleEvent.Initialized.INSTANCE.or(LifecycleEvent.Created.INSTANCE).or(LifecycleEvent.Started.INSTANCE));
        destroy(LifecycleEvent.Destroyed.INSTANCE);
        this.f200469a = r100.getCode();
        this.f200473e = State.Start.INSTANCE;
    }

    public final State getCurState() {
        return this.f200473e;
    }

    public final boolean getObserverStarted() {
        return this.f200474f;
    }

    public static LifecycleEvent h(Lifecycle.State r100) {
        int r101 = l.f200517a[r100.ordinal()];
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L22;
        if (r101 == 4) goto L21;
        if (r101 != 5) goto L14;
        return LifecycleEvent.Destroyed.INSTANCE;
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return LifecycleEvent.Resumed.INSTANCE;
    L22:
        return LifecycleEvent.Started.INSTANCE;
    L23:
        return LifecycleEvent.Created.INSTANCE;
    L19:
        return LifecycleEvent.Initialized.INSTANCE;
    }

    public final TaskLifecycle addDestroy(Event r100) {
        int r101 = this.f200472d;
        d(r100.getCode() | r101);
        return this;
    }

    public final TaskLifecycle addPause(Event r100) {
        int r101 = this.f200471c;
        f(r100.getCode() | r101);
        return this;
    }

    public final TaskLifecycle addStart(Event r100) {
        int r101 = this.f200470b;
        g(r100.getCode() | r101);
        return this;
    }

    public final void b(boolean r100) {
        LifecycleEvent r101 = LifecycleEvent.Initialized.INSTANCE;
        State.Start r102 = State.Start.INSTANCE;
        WeakReference<LifecycleRegistry> r103 = this.f200475g;
        if (r103 == null) goto L15;
        LifecycleRegistry r104 = r103.get();
        if (r104 == null) goto L15;
        LifecycleEvent r105 = h(r104.getCurrentState());
        e(r105, r100);
        State r106 = a();
        if (r106.getCode() < r102.getCode()) goto L9;
        boolean r107 = true;
    L10:
        if (r107 == true) goto L13;
        r106 = null;
    L13:
        if (r106 == null) goto L15;
        r101 = r105;
        goto L15
    L9:
        r107 = false;
    L15:
        i(r101, r100);
    }

    public final TaskLifecycle clearDestroy(Event r100) {
        int r101 = this.f200472d;
        d((~r100.getCode()) & r101);
        return this;
    }

    public final TaskLifecycle clearPause(Event r100) {
        int r101 = this.f200471c;
        f((~r100.getCode()) & r101);
        return this;
    }

    public final TaskLifecycle clearStart(Event r100) {
        int r101 = this.f200470b;
        g((~r100.getCode()) & r101);
        return this;
    }

    public final void d(int r100) {
        int r101 = r100 & 31;
        this.f200472d = r101;
        int r102 = this.f200470b;
        int r103 = (~r101) & 31;
        this.f200470b = r102 & r103;
        this.f200471c = r103 & this.f200471c;
    }

    public final TaskLifecycle destroy(Event r100) {
        d(r100.getCode());
        return this;
    }

    public final void f(int r100) {
        int r101 = r100 & 31;
        this.f200471c = r101;
        int r102 = this.f200470b;
        int r103 = (~r101) & 31;
        this.f200470b = r102 & r103;
        this.f200472d = r103 & this.f200472d;
    }

    public final void g(int r100) {
        int r101 = r100 & 31;
        this.f200470b = r101;
        int r102 = this.f200471c;
        int r103 = (~r101) & 31;
        this.f200471c = r102 & r103;
        this.f200472d = r103 & this.f200472d;
    }

    public final TaskLifecycle pause(Event r100) {
        f(r100.getCode());
        return this;
    }

    public final TaskLifecycle start(Event r100) {
        g(r100.getCode());
        return this;
    }

    public final TaskLifecycle with(LifecycleOwner r100) {
        Lifecycle r101 = r100.getLifecycle();
        if ((r101 instanceof LifecycleRegistry) == true) goto L5;
        r101 = null;
    L5:
        LifecycleRegistry r102 = (LifecycleRegistry) r101;
        if (r102 != null) goto L8;
        return this;
    L8:
        return with(r102);
    }

    public final TaskLifecycle withCtx(Context r100) {
        f200468i.getClass();
        ComponentCallbacks2 r101 = a.a(r100);
        if (r101 != null) goto L5;
    L13:
        return this;
    L5:
        if ((r101 instanceof LifecycleOwner) == false) goto L13;
        Lifecycle r102 = ((LifecycleOwner) r101).getLifecycle();
        if ((r102 instanceof LifecycleRegistry) == true) goto L9;
        r102 = null;
    L9:
        LifecycleRegistry r103 = (LifecycleRegistry) r102;
        if (r103 == null) goto L13;
        return with(r103);
    }

    public final TaskLifecycle with(LifecycleRegistry r100) {
        this.f200475g = new WeakReference(r100);
        return this;
    }

    public final void e(LifecycleEvent r100, boolean r101) {
        int r102 = (this.f200469a & (-32)) | (r100.getCode() & 31);
        if (r102 != this.f200469a) goto L5;
        if (r101 == true) goto L5;
        return;
    L5:
        this.f200469a = r102;
        if (this.f200474f == false) goto L10;
        Function1<? super LifecycleEvent, Unit> r103 = this.eventChanged;
        if (r103 == null) goto L10;
        Unit r104 = r103.invoke(r100);
    L10:
        i(r100, false);
    }

    public final void i(LifecycleEvent r100, boolean r101) {
        State r102 = a();
        State r103 = this.f200473e;
        if ((!Intrinsics.areEqual(r102, r103)) == true) goto L5;
        if (r101 == true) goto L5;
        return;
    L5:
        this.f200473e = r102;
        if (this.f200474f == false) goto L15;
        Function3<? super LifecycleEvent, ? super State, ? super State, Unit> r104 = this.stateChanged;
        if (r104 == null) goto L11;
        Unit r105 = r104.invoke(r100, r103, r102);
    L11:
        if (Intrinsics.areEqual(r102, State.Destroy.INSTANCE) == false) goto L16;
        c();
        return;
    L16:
        return;
    }
}
