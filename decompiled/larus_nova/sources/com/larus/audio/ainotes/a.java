package com.larus.audio.ainotes;

import android.content.Intent;
import android.os.Build;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.ainotes.notification.AiNoteService;
import com.larus.audio.bean.RECORD_STATUS;
import com.larus.audio.j0;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.t1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.m4;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import g58.d;
import g58.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f288325a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f288326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Timer f288327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f288328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f288329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f288330f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CopyOnWriteArrayList<p68.c> f288331g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static h f288332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f288333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final StateFlowImpl f288334j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b1 f288335k = null;

    /* JADX INFO: renamed from: com.larus.audio.ainotes.a$a, reason: collision with other inner class name */
    public static final class C3953a implements m4 {
        public C3953a() {
        }

        @Override // com.larus.platform.api.m4
        public final void b1() {
        }

        @Override // com.larus.platform.api.m4
        public final void S1() {
            a r100 = a.f288325a;
            if (r100.isRecording() == false) goto L6;
            r100.a("onMinorModeOn");
            return;
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class b implements p68.c {

        /* JADX INFO: renamed from: com.larus.audio.ainotes.a$b$a, reason: collision with other inner class name */
        public static final class C3954a extends TimerTask {
            public static void a() {
                long r100 = (System.currentTimeMillis() - a.f288326b) / ((long) 1000);
                FLogger.f375446a.i("AiNoteManager", "onRecordingDurationUpdate: " + r100);
                Iterator<p68.c> r101 = a.f288331g.iterator();
            L4:
                if (r101.hasNext() == false) goto L6;
                r101.next().c((int) r100);
                goto L4
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public C3954a() {
            }
        }

        public b() {
        }

        @Override // p68.c
        public final void c(int r100) {
        }

        @Override // p68.c
        public final void d(int r100, String r101) {
        }

        @Override // p68.c
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "meetingId");
            FLogger.f375446a.i("AiNoteManager", "onRecordingStart");
            CopyOnWriteArrayList<p68.c> r101 = a.f288331g;
            if (r101 == null) goto L8;
            Iterator<p68.c> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L8;
            p68.c r103 = r102.next();
            r103.a(r100);
            r103.c(0);
        L8:
            a.f288334j.setValue(RECORD_STATUS.RECORDING);
            a.f288326b = System.currentTimeMillis();
            Timer r104 = a.f288327c;
            if (r104 == null) goto L11;
            r104.cancel();
        L11:
            PthreadTimer r105 = new PthreadTimer("ai_recording_timer");
            a.f288327c = r105;
            r105.schedule(new C3954a(), 1000, 1000);
        }

        @Override // p68.c
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "meetingId");
            FLogger.f375446a.i("AiNoteManager", "onMeetingIdGenerated: ".concat(r100));
            CopyOnWriteArrayList<p68.c> r101 = a.f288331g;
            if (r101 == null) goto L8;
            Iterator<p68.c> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            r102.next().b(r100);
            goto L6
        L10:
            return;
        }

        @Override // p68.c
        public final void e(String r100) {
            if (r100 == null) goto L5;
            a.f288330f.remove(r100);
            return;
        }

        @Override // p68.c
        public final void f(byte[] r100) {
            long r101 = System.currentTimeMillis();
            if ((r101 - a.f288333i) <= 1000) goto L23;
            a.f288333i = r101;
            FLogger r102 = FLogger.f375446a;
            StringBuilder r103 = new StringBuilder("onRecordedData, size=");
            if (r100 == null) goto L7;
            Integer r104 = Integer.valueOf(r100.length);
        L8:
            r103.append(r104);
            r103.append(", isDataInvalid=");
            int r105 = j58.a.f497468a;
            boolean r106 = false;
            if (r100 == null) goto L22;
            int r107 = r100.length;
            int r108 = 0;
        L12:
            boolean r109 = true;
            if (r108 >= r107) goto L21;
            if (r100[r108] == 0) goto L18;
            r109 = false;
        L18:
            if (r109 == false) goto L22;
            r108 = r108 + 1;
            goto L12
        L21:
            r106 = true;
        L22:
            r103.append(r106);
            r102.i("AiNoteManager", r103.toString());
            goto L23
        L7:
            r104 = null;
        L23:
            CopyOnWriteArrayList<p68.c> r110 = a.f288331g;
            if (r110 == null) goto L29;
            Iterator<p68.c> r111 = r110.iterator();
        L27:
            if (r111.hasNext() == false) goto L33;
            r111.next().f(r100);
            goto L27
        L33:
            return;
        }
    }

    public a() {
    }

    @Override // com.larus.audio.j0
    public final void h() {
        f288329e = false;
    }

    static {
        f288325a = new a();
        f288330f = new LinkedHashSet();
        f288331g = new CopyOnWriteArrayList();
        StateFlowImpl r100 = j1.a(RECORD_STATUS.INIT);
        f288334j = r100;
        f288335k = e.b(r100);
        AccountService.f365697a.H(new C3953a());
    }

    @Override // com.larus.audio.j0
    public final boolean isRecording() {
        if (f288328d == true) goto L14;
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L9;
        r100.y();
        if (t1.f346241a.y0() != true) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L15;
        return false;
    L15:
        return true;
    L9:
        r101 = false;
        goto L10
    L14:
        return true;
    }

    @Override // com.larus.audio.j0
    public final boolean l() {
        return !f288330f.isEmpty();
    }

    @Override // com.larus.audio.j0
    public final boolean g() {
        return f288328d;
    }

    @Override // com.larus.audio.j0
    public final void a(String r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("AiNoteManager", "Stop recording in " + r100);
        f288328d = false;
        f288329e = false;
        final h r102 = f288332h;
        if (r102 == null) goto L5;
        final Boolean r103 = Boolean.FALSE;
        r101.i("AiAsrManager", "stopAsr");
        r102.f480086u.submit(new d(r102, r103));
    L5:
        AiNoteService r104 = h58.b.f483884a;
        int r105 = Build.VERSION.SDK_INT;
        if (r105 < 24) goto L10;
        AiNoteService r106 = h58.b.f483884a;
        if (r106 == null) goto L13;
        r106.stopForeground(1);
    L13:
        h58.b.f483886c = false;
        if (r105 < 24) goto L18;
        AiNoteService r107 = h58.b.f483884a;
        if (r107 == null) goto L21;
        r107.stopForeground(1);
    L21:
        h58.b.f483886c = false;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L24
        AppHost.Companion r109 = AppHost.f326268a;     // Catch: Throwable -> L24
        r109.getApplication().stopService(new Intent(r109.getApplication(), AiNoteService.class));     // Catch: Throwable -> L24
        h58.b.f483884a = null;     // Catch: Throwable -> L24
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L27:
        if (Result.m9452exceptionOrNullimpl(r110) == null) goto L29;
        FLogger.f375446a.e("AiNoteServiceManager", "unbindForegroundService failed");
    L29:
        int r111 = ((int) (System.currentTimeMillis() - f288326b)) / 1000;
        Timer r112 = f288327c;
        if (r112 == null) goto L32;
        r112.cancel();
    L32:
        f288327c = null;
        Iterator<p68.c> r113 = f288331g.iterator();
    L34:
        if (r113.hasNext() == false) goto L40;
        p68.c r114 = r113.next();
        h r115 = f288332h;
        if (r115 == null) goto L38;
        String r116 = r115.f480074i;
    L39:
        r114.d(r111, r116);
        goto L34
    L38:
        r116 = null;
        goto L39
    L40:
        f288334j.setValue(RECORD_STATUS.FINISH);
        return;
    L24:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L18:
        AiNoteService r118 = h58.b.f483884a;
        if (r118 == null) goto L21;
        r118.stopForeground(true);
        goto L21
    L10:
        AiNoteService r119 = h58.b.f483884a;
        if (r119 == null) goto L13;
        r119.stopForeground(true);
        goto L13
    }

    @Override // com.larus.audio.j0
    public final void j(p68.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<p68.c> r101 = f288331g;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    @Override // com.larus.audio.j0
    public final void k(p68.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f288331g.remove(r100);
    }

    @Override // com.larus.audio.j0
    public final void i(final String r100, final String r101) {
        FLogger.f375446a.i("AiNoteManager", "Start recording");
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().f("AiNoteManager startRecording");
        h58.b.b(r101, r100);
        if (h58.b.f483884a == null) goto L17;
    L12:
        f288328d = true;
        f288329e = false;
        if (r100 == null) goto L15;
        f288330f.add(r100);
    L15:
        final h r102 = new h();
        f288332h = r102;
        b r103 = new b();
        Intrinsics.checkNotNullParameter(r103, "statusListener");
        FLogger.f375446a.i("AiAsrManager", "startAsr， msgId=" + r100 + ", botId=" + r101);
        r102.f480073h = r100;
        r102.f480085t = r103;
        r102.f480084s = false;
        r102.f480083r = false;
        r102.f480086u.submit(new g58.e(r102, r100, r101));
        return;
    L17:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L6
        com.larus.audio.ainotes.notification.a r105 = new com.larus.audio.ainotes.notification.a();     // Catch: Throwable -> L6
        AppHost.Companion r106 = AppHost.f326268a;     // Catch: Throwable -> L6
        r106.getApplication().bindService(new Intent(r106.getApplication(), AiNoteService.class), r105, 1);     // Catch: Throwable -> L6
        Object r107 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L6
    L9:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L11;
        FLogger.f375446a.e("AiNoteServiceManager", "bindForegroundService failed");
    L11:
        Result.m9448boximpl(r107);
    L6:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
