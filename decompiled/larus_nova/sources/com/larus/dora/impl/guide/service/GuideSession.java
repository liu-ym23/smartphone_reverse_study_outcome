package com.larus.dora.impl.guide.service;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;
import t39.l;

/* JADX INFO: loaded from: classes27.dex */
public final class GuideSession {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f335956m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f335957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i59.b f335958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GuideSessionState f335959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f335960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<Context> f335961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Integer> f335962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineScope f335963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function4<Integer, Integer, Integer, Integer, Unit> f335964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f335965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList<l> f335966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<Job> f335967k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final kotlinx.coroutines.sync.a f335968l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/guide/service/GuideSession$GuideSessionState;", "", "<init>", "(Ljava/lang/String;I)V", "CREATED", "STARTED", "PAUSED", "FINISHED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GuideSessionState extends Enum<GuideSessionState> {
        public static final GuideSessionState CREATED = null;
        public static final GuideSessionState FINISHED = null;
        public static final GuideSessionState PAUSED = null;
        public static final GuideSessionState STARTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GuideSessionState[] f335969a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f335970b = null;

        public static EnumEntries<GuideSessionState> getEntries() {
            return f335970b;
        }

        static {
            GuideSessionState r100 = new GuideSessionState("CREATED", 0);
            CREATED = r100;
            GuideSessionState r101 = new GuideSessionState("STARTED", 1);
            STARTED = r101;
            GuideSessionState r102 = new GuideSessionState("PAUSED", 2);
            PAUSED = r102;
            GuideSessionState r103 = new GuideSessionState("FINISHED", 3);
            FINISHED = r103;
            GuideSessionState[] r104 = {r100, r101, r102, r103};
            f335969a = r104;
            f335970b = EnumEntriesKt.enumEntries(r104);
        }

        public static GuideSessionState[] values() {
            return (GuideSessionState[]) f335969a.clone();
        }

        public static GuideSessionState valueOf(String r100) {
            return (GuideSessionState) r27.a.a(GuideSessionState.class, r100);
        }

        public GuideSessionState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public GuideSession() {
        throw null;
    }

    public final synchronized void d() {
        monitor-enter(this);
        g49.d.d(c(), "launch() start");     // Catch: Throwable -> L10
        Iterator<T> r100 = this.f335967k.iterator();     // Catch: Throwable -> L10
    L5:
        if (r100.hasNext() == false) goto L7;
        Job.DefaultImpls.cancel$default((Job) r100.next(), null, 1, null);     // Catch: Throwable -> L10
        goto L5
    L7:
        this.f335967k.clear();     // Catch: Throwable -> L10
        e(new GuideSession$launch$2(this, null));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void i() {
        monitor-enter(this);
        g49.d.d(c(), "stop() start");     // Catch: Throwable -> L10
        Iterator<T> r100 = this.f335967k.iterator();     // Catch: Throwable -> L10
    L5:
        if (r100.hasNext() == false) goto L7;
        Job.DefaultImpls.cancel$default((Job) r100.next(), null, 1, null);     // Catch: Throwable -> L10
        goto L5
    L7:
        this.f335967k.clear();     // Catch: Throwable -> L10
        e(new GuideSession$stop$2(this, null));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final String c() {
        StringBuilder r100 = new StringBuilder("GuideSession(id=");     // Catch: Exception -> L9
        r100.append(this.f335957a);     // Catch: Exception -> L9
        r100.append(", page=");     // Catch: Exception -> L9
        r100.append(this.f335960d);     // Catch: Exception -> L9
        r100.append(", state=");     // Catch: Exception -> L9
        r100.append(this.f335959c);     // Catch: Exception -> L9
        r100.append(", currentGuideId=");     // Catch: Exception -> L9
        l r101 = this.f335965i;     // Catch: Exception -> L9
        if (r101 == null) goto L6;
        Integer r102 = Integer.valueOf(r101.f());     // Catch: Exception -> L9
    L7:
        r100.append(r102);     // Catch: Exception -> L9
        r100.append(", remainingGuideCount=");     // Catch: Exception -> L9
        r100.append(this.f335966j.size());     // Catch: Exception -> L9
        r100.append(')');     // Catch: Exception -> L9
        return r100.toString();
    L6:
        r102 = null;
    L9:
        e = move-exception;
        g49.d.c("GuideSession", "get tag failed: " + e.getMessage(), e);
        return "GuideSession(id=" + this.f335957a + ", page=" + this.f335960d + ", state=" + this.f335959c + ')';
    }

    public final WeakReference<Context> getContext() {
        return this.f335961e;
    }

    public final void b(DoraGuideMeta r100) {
        Intrinsics.checkNotNullParameter(r100, "guideMeta");
        g49.d.d(c(), "dismissGuide() start, guideMeta=" + r100);
        e(new GuideSession$dismissGuide$2(this, r100, null));
    }

    public final void e(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        final Job r101 = BuildersKt.launch$default(this.f335963g, Dispatchers.getIO(), null, new GuideSession$launchWithMutex$job$1(this, r100, null), 2, null);
        this.f335967k.add(r101);
        r101.invokeOnCompletion(new c(this, r101));
    }

    public final void g(DoraGuideMeta r100) {
        Intrinsics.checkNotNullParameter(r100, "guideMeta");
        g49.d.d(c(), "pushGuide() start, guideMeta=" + r100);
        e(new GuideSession$pushGuide$1(this, r100, null));
    }

    public final void h(GuideSessionState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f335959c = r100;
    }

    public static Object f(Function1 r100, Continuation r101) {
        Object r102 = BuildersKt.withContext(Dispatchers.getMain(), new GuideSession$onMain$2(r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object a(GuideSession r100, l r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof GuideSession$dismissSafe$1) == false) goto L7;
        GuideSession$dismissSafe$1 r103 = (GuideSession$dismissSafe$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L21
    L19:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L27;
        g49.d.c(r100.c(), "dismissGuide() exception: " + r109.getMessage(), r109);
        r100.f335959c = GuideSessionState.FINISHED;
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L21
        GuideSession$dismissSafe$2$1 r111 = new GuideSession$dismissSafe$2$1(r101, null, null, null);     // Catch: Throwable -> L21
        r103.label = 1;     // Catch: Throwable -> L21
        if (f(r111, r103) != r106) goto L19;
        return r106;
    L21:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new GuideSession$dismissSafe$1(r100, r102);
        goto L8
    }

    public GuideSession(int r100, String r101, WeakReference r102, List r103, LifecycleCoroutineScope r110, Function4 r111) {
        GuideSessionState r104 = GuideSessionState.CREATED;
        CopyOnWriteArrayList<l> r105 = new CopyOnWriteArrayList();
        List<Job> r106 = Collections.synchronizedList(new ArrayList());
        MutexImpl r107 = kotlinx.coroutines.sync.b.a();
        Intrinsics.checkNotNullParameter(r104, "state");
        Intrinsics.checkNotNullParameter(r101, "page");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "guideFilterList");
        Intrinsics.checkNotNullParameter(r110, "lifeCycleScope");
        Intrinsics.checkNotNullParameter(r111, "guideListener");
        Intrinsics.checkNotNullParameter(r105, "remainingGuides");
        Intrinsics.checkNotNullParameter(r106, "orchestratorJobs");
        Intrinsics.checkNotNullParameter(r107, "mutex");
        this.f335957a = r100;
        this.f335958b = null;
        this.f335959c = r104;
        this.f335960d = r101;
        this.f335961e = r102;
        this.f335962f = r103;
        this.f335963g = r110;
        this.f335964h = r111;
        this.f335965i = null;
        this.f335966j = r105;
        this.f335967k = r106;
        this.f335968l = r107;
    }
}
