package com.ss.android.ugc.aweme.search.dynamic.tools.checker;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.ss.android.ugc.aweme.search.utils.DynamicTool;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/tools/checker/DynamicCardSnapshot;", "Lcom/ss/android/ugc/aweme/search/dynamic/tools/checker/ICardSnapshot;", "Lcom/ss/android/ugc/aweme/search/dynamic/tools/checker/DynamicCardInfo;", "Companion", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class DynamicCardSnapshot implements ICardSnapshot<DynamicCardInfo> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f452751j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f452752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, ICardSnapshot<DynamicCardInfo>> f452753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Companion.STATE f452754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Companion.STATE f452755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f452756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f452757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Exception f452758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Exception f452759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile DynamicCardInfo f452760i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/tools/checker/DynamicCardSnapshot$Companion;", "", "()V", "STATE", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/tools/checker/DynamicCardSnapshot$Companion$STATE;", "", ErrorCode.INIT, "BIND_BEGIN", "BIND_SUCCESS", "BIND_ERROR", "SCREEN", "UN_SCREEN", "RECYCLE", "RUNNING", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
        public static final enum STATE extends Enum<STATE> {
            public static final STATE BIND_BEGIN = null;
            public static final STATE BIND_ERROR = null;
            public static final STATE BIND_SUCCESS = null;
            public static final STATE INIT = null;
            public static final STATE RECYCLE = null;
            public static final STATE RUNNING = null;
            public static final STATE SCREEN = null;
            public static final STATE UN_SCREEN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ STATE[] f452761a = null;

            public static STATE valueOf(String r100) {
                return (STATE) a.a(STATE.class, r100);
            }

            public static STATE[] values() {
                return (STATE[]) f452761a.clone();
            }

            static {
                STATE r100 = new STATE(ErrorCode.INIT, 0);
                INIT = r100;
                STATE r101 = new STATE("BIND_BEGIN", 1);
                BIND_BEGIN = r101;
                STATE r102 = new STATE("BIND_SUCCESS", 2);
                BIND_SUCCESS = r102;
                STATE r103 = new STATE("BIND_ERROR", 3);
                BIND_ERROR = r103;
                STATE r104 = new STATE("SCREEN", 4);
                SCREEN = r104;
                STATE r105 = new STATE("UN_SCREEN", 5);
                UN_SCREEN = r105;
                STATE r110 = new STATE("RECYCLE", 6);
                RECYCLE = r110;
                STATE r111 = new STATE("RUNNING", 7);
                RUNNING = r111;
                f452761a = new STATE[]{r100, r101, r102, r103, r104, r105, r110, r111};
            }

            public STATE(String r100, int r101) {
                super(r100, r101);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f452762a = null;

        static {
            int[] r100 = new int[Companion.STATE.values().length];
            r100[Companion.STATE.INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[Companion.STATE.BIND_BEGIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[Companion.STATE.BIND_SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[Companion.STATE.BIND_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[Companion.STATE.SCREEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[Companion.STATE.UN_SCREEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[Companion.STATE.RUNNING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[Companion.STATE.RECYCLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f452762a = r100;
        }
    }

    static {
        new Companion(0);
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.tools.checker.ICardSnapshot
    public final void onDestroy() {
        this.f452757f = true;
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.tools.checker.ICardSnapshot
    public final void b() {
        l(Companion.STATE.SCREEN);
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.tools.checker.ICardSnapshot
    public final void e() {
        l(Companion.STATE.UN_SCREEN);
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.tools.checker.ICardSnapshot
    public final void f() {
        l(Companion.STATE.BIND_BEGIN);
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.tools.checker.ICardSnapshot
    public final boolean g() {
        if (this.f452754c != Companion.STATE.INIT) goto L5;
    L7:
        return false;
    L5:
        if (this.f452754c == Companion.STATE.RECYCLE) goto L7;
        return true;
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.tools.checker.ICardSnapshot
    public final void i() {
        l(Companion.STATE.BIND_SUCCESS);
        this.f452758g = null;
    }

    public final String toString() {
        return "Snapshot(index=" + this.f452752a + ", currentState=" + this.f452754c + ", lastState=" + this.f452755d + ", runningTriggerName=" + this.f452756e + ", destroyed=" + this.f452757f + ", error=" + this.f452758g + ", historyError=" + this.f452759h + ", cardInfo=" + this.f452760i + ')';
    }

    public static String j(DynamicCardSnapshot r100) {
        Collection<ICardSnapshot<DynamicCardInfo>> r101 = r100.f452753b.values();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        ICardSnapshot r104 = (ICardSnapshot) r103.next();
        if ((r104 instanceof DynamicCardSnapshot) == false) goto L8;
        DynamicCardSnapshot r105 = (DynamicCardSnapshot) r104;
    L9:
        if (r105 == null) goto L4;
        r102.add(r105);
        goto L4
    L8:
        r105 = null;
        goto L9
    L11:
        List r106 = CollectionsKt.sortedWith(r102, new DynamicCardSnapshot$dumpSnapshot$$inlined$sortedByDescending$1());
        int r107 = r106.size();
        StringBuilder r108 = new StringBuilder();
        r108.append("[latest snapshots]\n");
        boolean r109 = false;
        Iterator r110 = r106.subList(0, Math.min(r107, 5)).iterator();
    L13:
        if (r110.hasNext() == false) goto L19;
        DynamicCardSnapshot r111 = (DynamicCardSnapshot) r110.next();
        r108.append(r111.toString());
        r108.append('\n');
        Exception r112 = r111.f452758g;
        if (r112 != null) goto L17;
        r112 = r111.f452759h;
    L17:
        if (r112 == null) goto L13;
        r108.append("error stack: " + ExceptionsKt.stackTraceToString(r112));
        r108.append('\n');
        goto L13
    L19:
        r108.append("--------\n");
        if (r108.length() <= 0) goto L22;
        r109 = true;
    L22:
        if (r109 == false) goto L25;
        r108.delete(r108.length() - 1, r108.length());
    L25:
        return r108.toString();
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.tools.checker.ICardSnapshot
    public final void a(DynamicCardInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.f452760i = r100;
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.tools.checker.ICardSnapshot
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "triggerName");
        this.f452756e = r100;
        l(Companion.STATE.RUNNING);
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.tools.checker.ICardSnapshot
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "triggerName");
        if (Intrinsics.areEqual(this.f452756e, r100) == true) goto L5;
        m("trigger not same", "others trigger not same as last! [" + this.f452756e + " -> " + r100 + "]\n" + j(this));
    L5:
        this.f452756e = null;
        l(this.f452755d);
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.tools.checker.ICardSnapshot
    public final void h(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f452758g = r100;
        this.f452759h = r100;
        l(Companion.STATE.BIND_ERROR);
    }

    public final String k(String r100) {
        return r100 + "\ncurrentIndex=" + this.f452752a + ", currentThread=" + ThreadMethodProxy.currentThread().getName() + '\n' + j(this);
    }

    public final void l(final Companion.STATE r100) {
        Iterator<T> r101 = this.f452753b.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        ICardSnapshot r102 = (ICardSnapshot) r101.next();
        if (Intrinsics.areEqual(r102, this) == true) goto L4;
        if (r102.g() == false) goto L4;
        m("card is already running", k("card is already running!"));
    L11:
        Function0<Unit> r103 = new DynamicCardSnapshot$setState$throwStateError$1(this, r100);
        Function1<String, Unit> r104 = new DynamicCardSnapshot$setState$throwWarning$1(this, r100);
        switch(WhenMappings.f452762a[this.f452754c.ordinal()]) {
            case 1: goto L69;
            case 2: goto L61;
            case 3: goto L51;
            case 4: goto L43;
            case 5: goto L38;
            case 6: goto L30;
            case 7: goto L21;
            case 8: goto L15;
            default: goto L74;
        };
    L15:
        if (r100 != Companion.STATE.RUNNING) goto L18;
        r104.invoke("running after recycle!");
        goto L74
    L18:
        if (r100 == Companion.STATE.BIND_BEGIN) goto L74;
        r103.invoke();
        goto L74
    L21:
        if (r100 == Companion.STATE.SCREEN) goto L74;
        if (r100 == Companion.STATE.UN_SCREEN) goto L74;
        if (r100 == Companion.STATE.BIND_SUCCESS) goto L74;
        if (r100 == Companion.STATE.RECYCLE) goto L74;
        r104.invoke("running -> " + r100);
        goto L74
    L30:
        if (r100 != Companion.STATE.RUNNING) goto L33;
        r104.invoke("un_screen -> running");
        goto L74
    L33:
        if (r100 == Companion.STATE.SCREEN) goto L74;
        if (r100 == Companion.STATE.RECYCLE) goto L74;
        r103.invoke();
        goto L74
    L38:
        if (r100 == Companion.STATE.RUNNING) goto L74;
        if (r100 == Companion.STATE.UN_SCREEN) goto L74;
        r103.invoke();
        goto L74
    L43:
        if (r100 != Companion.STATE.RUNNING) goto L46;
        r104.invoke("error -> running");
        goto L74
    L46:
        if (r100 == Companion.STATE.RECYCLE) goto L74;
        if (r100 == Companion.STATE.BIND_ERROR) goto L74;
        r103.invoke();
        goto L74
    L51:
        if (r100 != Companion.STATE.RECYCLE) goto L54;
        r104.invoke("recycle before attach!");
        goto L74
    L54:
        if (r100 == Companion.STATE.SCREEN) goto L74;
        if (r100 == Companion.STATE.BIND_ERROR) goto L74;
        if (r100 == Companion.STATE.RUNNING) goto L74;
        r103.invoke();
        goto L74
    L61:
        if (r100 != Companion.STATE.RUNNING) goto L64;
        r104.invoke("begin -> running");
        goto L74
    L64:
        if (r100 == Companion.STATE.BIND_SUCCESS) goto L74;
        if (r100 == Companion.STATE.BIND_ERROR) goto L74;
        r103.invoke();
        goto L74
    L69:
        if (r100 == Companion.STATE.BIND_BEGIN) goto L74;
        if (r100 == Companion.STATE.RECYCLE) goto L74;
        r103.invoke();
    L74:
        if (this.f452754c == Companion.STATE.RUNNING) goto L76;
        this.f452755d = this.f452754c;
    L76:
        this.f452754c = r100;
    }

    public DynamicCardSnapshot(int r100, ConcurrentHashMap<String, ICardSnapshot<DynamicCardInfo>> r101) {
        Intrinsics.checkNotNullParameter(r101, "snapshots");
        this.f452752a = r100;
        this.f452753b = r101;
        Companion.STATE r102 = Companion.STATE.INIT;
        this.f452754c = r102;
        this.f452755d = r102;
    }

    public final void m(String r100, String r101) {
        StringBuilder r102 = new StringBuilder("DynamicCardChecker throw [");
        r102.append(r100);
        r102.append("], scene=");
        DynamicCardInfo r103 = this.f452760i;
        if (r103 == null) goto L5;
        String r104 = r103.f452747b;
    L6:
        r102.append(r104);
        r102.append(", ");
        r102.append(r101);
        new Exception(r102.toString());
        ((Boolean) DynamicTool.f453402c.getValue()).booleanValue();
        return;
    L5:
        r104 = null;
        goto L6
    }
}
