package wr8;

import android.os.SystemClock;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.bmhome.social.userchat.start.core.StartTaskExecTime;
import com.larus.im.service.s;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;
import wc9.l;
import wc9.o;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends xr8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CompletableDeferred<List<l>> f560868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f560869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableSharedFlow<List<l>> f560870c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a1 f560871d = null;

    public static final class a {
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            CompletableDeferred<List<l>> r101 = b.f560868a;
            if (r101 == null) goto L5;
            r101.complete(CollectionsKt.emptyList());
        L5:
            b.f560868a = null;
            FLogger.f375446a.i("PreLoadConvListTask", "resetDeffer reason=".concat(r100));
        }
    }

    @Override // xr8.a
    public final int d() {
        return 60;
    }

    static {
        MutableSharedFlow<List<l>> r100 = SharedFlowKt.MutableSharedFlow$default(1000, 0, null, 6, null);
        f560870c = r100;
        f560871d = e.a(r100);
    }

    @Override // xr8.a
    public final boolean a() {
        int r100 = com.larus.im.d.f347134a;
        s.f350887a.getClass();
        return s.a.a().getInitialize();
    }

    @Override // xr8.a
    public final void b() {
        FLogger r100 = FLogger.f375446a;
        r100.i("PreLoadConvListTask", "start preload conversations");
        f560868a = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L7;
        r100.i("PreLoadConvListTask", "user not login no need preload conversations");
        CompletableDeferred<List<l>> r101 = f560868a;
        if (r101 == null) goto L9;
        r101.complete(CollectionsKt.emptyList());
        return;
    L9:
        return;
    L7:
        long r102 = SystemClock.elapsedRealtime();
        o r103 = new o(null, 20, null, 9);
        com.larus.im.d.d().getConversationList(r103, new c(this, r102));
    }

    @Override // xr8.a
    public final void e() {
        CompletableDeferred<List<l>> r100 = f560868a;
        if (r100 == null) goto L5;
        r100.complete(CollectionsKt.emptyList());
    L5:
        f560868a = null;
        FLogger.f375446a.i("PreLoadConvListTask", "skip pre load conv list!");
        f(this, false, -1, -1, true, "skip execute", 0, 0, 96);
    }

    public b() {
    }

    @Override // xr8.a
    public final StartTaskExecTime c() {
        return StartTaskExecTime.BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED;
    }

    public static void f(final b r110, final boolean r111, final long r112, final long r113, boolean r114, String r115, int r210, int r211, int r212) {
        if ((r212 & 8) == 0) goto L5;
        final boolean r116 = false;
    L7:
        if ((r212 & 16) == 0) goto L9;
        final String r117 = null;
    L11:
        if ((r212 & 32) == 0) goto L13;
        final int r100 = -1;
    L15:
        if ((r212 & 64) == 0) goto L17;
        final int r101 = -1;
    L18:
        r110.getClass();
        ThreadPlus.submitRunnable(new wr8.a(r110, r111, r100, r101, r112, r113, r116, r117));
        return;
    L17:
        r101 = r211;
        goto L18
    L13:
        r100 = r210;
        goto L15
    L9:
        r117 = r115;
        goto L11
    L5:
        r116 = r114;
        goto L7
    }
}
