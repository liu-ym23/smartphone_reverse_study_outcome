package com.ss.android.lark.appcontext.applifecycle2.api;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import java.util.List;
import jva.d;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class AppLifecycle2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.ss.android.lark.appcontext.applifecycle2.impl.c f408863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<jva.b> f408864b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/appcontext/applifecycle2/api/AppLifecycle2$ProcessStateSyncMode;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "ONLY_TRIGGER", "ONLY_DETECTOR", "BOTH", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ProcessStateSyncMode extends Enum<ProcessStateSyncMode> {
        public static final ProcessStateSyncMode BOTH = null;
        public static final ProcessStateSyncMode ONLY_DETECTOR = null;
        public static final ProcessStateSyncMode ONLY_TRIGGER = null;
        public static final ProcessStateSyncMode SINGLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ProcessStateSyncMode[] f408865a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f408866b = null;

        public static EnumEntries<ProcessStateSyncMode> getEntries() {
            return f408866b;
        }

        static {
            ProcessStateSyncMode r100 = new ProcessStateSyncMode("SINGLE", 0);
            SINGLE = r100;
            ProcessStateSyncMode r101 = new ProcessStateSyncMode("ONLY_TRIGGER", 1);
            ONLY_TRIGGER = r101;
            ProcessStateSyncMode r102 = new ProcessStateSyncMode("ONLY_DETECTOR", 2);
            ONLY_DETECTOR = r102;
            ProcessStateSyncMode r103 = new ProcessStateSyncMode("BOTH", 3);
            BOTH = r103;
            ProcessStateSyncMode[] r104 = {r100, r101, r102, r103};
            f408865a = r104;
            f408866b = EnumEntriesKt.enumEntries(r104);
        }

        public static ProcessStateSyncMode[] values() {
            return (ProcessStateSyncMode[]) f408865a.clone();
        }

        public static ProcessStateSyncMode valueOf(String r100) {
            return (ProcessStateSyncMode) r27.a.a(ProcessStateSyncMode.class, r100);
        }

        public ProcessStateSyncMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements jva.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f408867a;

        @Override // jva.b
        public final void a() {
        }

        public final int hashCode() {
            return this.f408867a.hashCode();
        }

        public a(y r100) {
            Intrinsics.checkNotNullParameter(r100, "oldObserver");
            this.f408867a = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f408867a, ((a) r100).f408867a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // jva.c
        public final void b(AppState r100, AppState r101) {
            Intrinsics.checkNotNullParameter(r100, "oldState");
            Intrinsics.checkNotNullParameter(r101, "newState");
            this.f408867a.f(AppLifecycle2.e(r100), AppLifecycle2.e(r101));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Application f408868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<kva.a> f408869b;

        public final Application getContext() {
            return this.f408868a;
        }

        public b(Application r100, ProcessStateSyncMode r101, boolean r102, List r103) {
            this.f408868a = r100;
            this.f408869b = r103;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f408870a = null;

        static {
            int[] r100 = new int[ProcessStateSyncMode.values().length];
            r100[ProcessStateSyncMode.BOTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ProcessStateSyncMode.ONLY_TRIGGER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ProcessStateSyncMode.ONLY_DETECTOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f408870a = r100;
        }
    }

    static {
        f408864b = new LinkedList();
    }

    @JvmStatic
    public static final jva.a a() {
        com.ss.android.lark.appcontext.applifecycle2.impl.c r100 = f408863a;
        if (r100 == null) goto L8;
        jva.a r101 = r100.f408887b.a();
        if (r101 == null) goto L8;
        return r101;
    L8:
        throw new IllegalStateException("AppLifecycle not inited yet!");
    }

    @JvmStatic
    public static final d b() {
        com.ss.android.lark.appcontext.applifecycle2.impl.c r100 = f408863a;
        if (r100 == null) goto L8;
        d r101 = r100.f408887b;
        if (r101 == null) goto L8;
        return r101;
    L8:
        throw new IllegalStateException("AppLifecycle not inited yet!");
    }

    public static String c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = z.c(r100);
        Intrinsics.checkNotNull(r101);
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 != null) goto L12;
        return PullConfiguration.PROCESS_NAME_MAIN;
    L12:
        return r101;
    L5:
        r102 = false;
        goto L6
    }

    @JvmStatic
    public static final void d(jva.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        com.ss.android.lark.appcontext.applifecycle2.impl.c r101 = f408863a;
        if (r101 == null) goto L5;
        r101.a(r100);
        return;
    L5:
        LinkedList<jva.b> r102 = f408864b;
        monitor-enter(r102);
        r102.add(r100);     // Catch: Throwable -> L10
        monitor-exit(r102);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static y.a e(AppState r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f408871a == false) goto L9;
        d r101 = b();
        if (r101.isForeground() == false) goto L7;
        String r102 = r101.b();
    L8:
        y.a r103 = y.a.a(r102, r100.f408873c, r101.b(), r100.f408874d);
        Intrinsics.checkNotNull(r103);
        return r103;
    L7:
        r102 = r100.f408872b;
        goto L8
    L9:
        y.a r104 = y.a.a(null, null, b().b(), r100.f408874d);
        Intrinsics.checkNotNull(r104);
        return r104;
    }
}
