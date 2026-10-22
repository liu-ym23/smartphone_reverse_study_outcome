package com.ss.android.lark.passportc.impl.v2;

import android.os.SystemClock;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserRequest;
import com.ss.android.lark.passportc.impl.v2.state.AllUserState;
import com.ss.android.lark.utils.statistics.PerfLog;
import f0c.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0c.c f438244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, b> f438245b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f438246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f438247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f438248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f438249d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f438250e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f438251f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f438246a == r101.f438246a) goto L12;
            return false;
        L12:
            if (this.f438247b == r101.f438247b) goto L15;
            return false;
        L15:
            if (this.f438248c == r101.f438248c) goto L18;
            return false;
        L18:
            if (this.f438249d == r101.f438249d) goto L21;
            return false;
        L21:
            if (this.f438250e == r101.f438250e) goto L24;
            return false;
        L24:
            if (this.f438251f == r101.f438251f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f438246a * 31;
            long r101 = this.f438247b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f438248c;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            long r105 = this.f438249d;
            int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            long r107 = this.f438250e;
            int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
            long r109 = this.f438251f;
            return r108 + ((int) (r109 ^ (r109 >>> 32)));
        }

        public final String toString() {
            return "UpdateRequestVisitContext(requestId=" + this.f438246a + ", requestStartTime=" + this.f438247b + ", onlineStartTime=" + this.f438248c + ", offlineStartTime=" + this.f438249d + ", updateOnlineStartTime=" + this.f438250e + ", updateOfflineStartTime=" + this.f438251f + ')';
        }

        public b(int r100) {
            this.f438246a = r100;
            this.f438247b = Long.MAX_VALUE;
            this.f438248c = Long.MAX_VALUE;
            this.f438249d = Long.MAX_VALUE;
            this.f438250e = Long.MAX_VALUE;
            this.f438251f = Long.MAX_VALUE;
        }
    }

    static {
    }

    @Inject
    public e(l0c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "userFlowMonitor");
        this.f438244a = r100;
        this.f438245b = new ConcurrentHashMap();
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void q(com.ss.android.lark.passportc.impl.v2.entity.a r100) {
        Intrinsics.checkNotNullParameter(r100, "stateDiffResult");
        Log.i("UserUpdateVisitor", "[updateUser], diffResult: " + r100);
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void c(UpdateUserRequest r100, com.ss.android.lark.passportc.api.d r101) {
        Intrinsics.checkNotNullParameter(r100, "updateRequest");
        Intrinsics.checkNotNullParameter(r101, "executeMode");
        b r102 = this.f438245b.get(Integer.valueOf(r100.f438265c));
        if (r102 == null) goto L5;
        long r103 = SystemClock.elapsedRealtime() - r102.f438247b;
    L6:
        Log.i("UserUpdateVisitor", "[updateUser], disposed, reqId:" + r100.f438265c + ", cost:" + r103 + "ms");
        Log.i("UserUpdateVisitor", "[updateUser], ----------------");
        this.f438245b.remove(Integer.valueOf(r100.f438265c));
        this.f438244a.d();
        return;
    L5:
        r103 = -1;
        goto L6
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void e(AllUserState r100, AllUserState r101) {
        Intrinsics.checkNotNullParameter(r100, "oldState");
        Intrinsics.checkNotNullParameter(r101, "newState");
        if (Intrinsics.areEqual(r101, r100) == false) goto L5;
        return;
    L5:
        Log.i("UserUpdateVisitor", "[stateUpdate], newState: count=" + r101.f438283a.size() + " \n" + r101);
    }

    @Override // h0c.f
    public final void f(UpdateUserContext r100, i0c.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "transition");
        Log.i("UserUpdateVisitor", "[stateTransit], state transition start, reqId:" + r100.f438252a + ", context:" + r100.hashCode() + ", uid:" + r100.f438254c.userId + ", transition:{" + r101.getFrom() + " -> " + r101.getTo() + '}');
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void i(UpdateUserRequest r100, com.ss.android.lark.passportc.api.d r101) {
        Intrinsics.checkNotNullParameter(r100, "updateRequest");
        Intrinsics.checkNotNullParameter(r101, "executeMode");
        Log.i("UserUpdateVisitor", "[updateUser], ----------------");
        Log.i("UserUpdateVisitor", "[updateUser], start, request:" + r100 + ", executeMode:{scene:" + r101.f438115d + ", strategy:" + r101.f438113b + '}');
        ConcurrentHashMap<Integer, b> r102 = this.f438245b;
        Integer r103 = Integer.valueOf(r100.f438265c);
        b r104 = r102.get(r103);
        if (r104 != null) goto L8;
        r104 = new b(r100.f438265c);
        b r105 = r102.putIfAbsent(r103, r104);
        if (r105 == null) goto L8;
        r104 = r105;
    L8:
        r104.f438247b = SystemClock.elapsedRealtime();
        this.f438244a.f();
        this.f438244a.b("rust_infra_update_user_");
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void r(UpdateUserRequest r100, com.ss.android.lark.passportc.api.d r101) {
        Intrinsics.checkNotNullParameter(r100, "updateRequest");
        Intrinsics.checkNotNullParameter(r101, "executeMode");
        b r102 = this.f438245b.get(Integer.valueOf(r100.f438265c));
        if (r102 == null) goto L5;
        long r103 = SystemClock.elapsedRealtime() - r102.f438247b;
    L6:
        Log.i("UserUpdateVisitor", "[updateUser], complete, reqId:" + r100.f438265c + ", cost:" + r103 + "ms");
        Log.i("UserUpdateVisitor", "[updateUser], ----------------");
        this.f438245b.remove(Integer.valueOf(r100.f438265c));
        this.f438244a.d();
        return;
    L5:
        r103 = -1;
        goto L6
    }

    @Override // h0c.f
    public final void d(UpdateUserContext r100, UserState r101, UserState r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fromState");
        Intrinsics.checkNotNullParameter(r102, "toState");
        Log.i("UserUpdateVisitor", "[stateTransit], fireState start, reqId:" + r100.f438252a + ", context:" + r100.hashCode() + ", uid:" + r100.f438254c.userId + ", " + r101 + " -> " + r102);
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void h(UpdateUserRequest r100, com.ss.android.lark.passportc.api.d r101, com.ss.android.lark.passportc.impl.v2.entity.c r102) {
        Intrinsics.checkNotNullParameter(r100, "updateRequest");
        Intrinsics.checkNotNullParameter(r101, "executeMode");
        Intrinsics.checkNotNullParameter(r102, "updateResult");
        b r103 = this.f438245b.get(Integer.valueOf(r100.f438265c));
        if (r103 == null) goto L5;
        long r104 = SystemClock.elapsedRealtime() - r103.f438247b;
    L6:
        StringBuilder r105 = new StringBuilder("[updateUser], next, reqId:");
        r105.append(r100.f438265c);
        r105.append(", result:{");
        f0c.b r106 = r102.f496849a;
        StringBuilder r107 = new StringBuilder("{uid=");
        g r108 = r106.a();
        if (r108 == null) goto L11;
        User r109 = r108.f475033a;
        if (r109 == null) goto L11;
        String r110 = r109.userId;
    L12:
        r107.append(r110);
        r107.append(", state:");
        r107.append(r106.f475024b.f475035a);
        r107.append("}}");
        r105.append(r107.toString());
        r105.append(", cost:");
        r105.append(r104);
        r105.append("ms}");
        Log.i("UserUpdateVisitor", r105.toString());
        this.f438244a.i("rust_infra_update_user_");
        return;
    L11:
        r110 = null;
        goto L12
    L5:
        r104 = -1;
        goto L6
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void j(UpdateUserRequest r100, com.ss.android.lark.passportc.api.d r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "updateRequest");
        Intrinsics.checkNotNullParameter(r101, "executeMode");
        Intrinsics.checkNotNullParameter(r102, "error");
        b r103 = this.f438245b.get(Integer.valueOf(r100.f438265c));
        if (r103 == null) goto L5;
        long r104 = SystemClock.elapsedRealtime() - r103.f438247b;
    L6:
        Log.e("UserUpdateVisitor", "[updateUser], error, reqId:" + r100.f438265c + ", cost:" + r104 + "ms", r102);
        Log.i("UserUpdateVisitor", "[updateUser], ----------------");
        this.f438245b.remove(Integer.valueOf(r100.f438265c));
        this.f438244a.d();
        return;
    L5:
        r104 = -1;
        goto L6
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void m(UpdateUserContext r100, UserState r101, UserState r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        b r103 = this.f438245b.get(Integer.valueOf(r100.f438252a));
        if (r103 == null) goto L5;
        r103.f438249d = SystemClock.elapsedRealtime();
    L5:
        this.f438244a.b("rust_infra_transfer_offline");
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void p(UpdateUserContext r100, UserState r101, UserState r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        b r103 = this.f438245b.get(Integer.valueOf(r100.f438252a));
        if (r103 == null) goto L5;
        r103.f438248c = SystemClock.elapsedRealtime();
    L5:
        this.f438244a.b("rust_infra_transfer_online");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h0c.f
    public final void s(UpdateUserContext r100, i0c.d r110, h0c.b r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "transition");
        Intrinsics.checkNotNullParameter(r111, "result");
        r111.getClass();
        if ((r111 instanceof h0c.b.c) == false) goto L12;
        j0c.a r112 = (j0c.a) r111.f483504a;
        if (r112 == null) goto L9;
        boolean r101 = true;
        if (r112.f496839a != true) goto L9;
    L10:
        if (r101 == false) goto L12;
        Log.i("UserUpdateVisitor", "[stateTransit], state transition end, reqId:" + r100.f438252a + ", context:" + r100.hashCode() + ", uid:" + r100.f438254c.userId + ", result:{isSuccess=true, errorMessage=" + ((j0c.a) r111.f483504a).f496840b + '}');
        return;
    L9:
        r101 = false;
    L12:
        j0c.a r102 = (j0c.a) r111.f483504a;
        if (r102 == null) goto L16;
        String r103 = r102.f496840b;
        if (r103 == null) goto L16;
    L17:
        StringBuilder r113 = new StringBuilder(r103);
        j0c.a r114 = (j0c.a) r111.f483504a;
        if (r114 == null) goto L25;
        List<j0c.c> r115 = r114.f496842d;
        if (r115 == null) goto L25;
        Iterator<T> r116 = r115.iterator();
    L23:
        if (r116.hasNext() == false) goto L25;
        j0c.c r104 = (j0c.c) r116.next();
        r113.append(r104.f496845a + ", " + r104.f496848d + "; ");
    L25:
        Log.e("UserUpdateVisitor", "[stateTransit], state transition end, reqId:" + r100.f438252a + ", context:" + r100.hashCode() + ", uid:" + r100.f438254c.userId + ", result:{isSuccess=false, errorMessage=" + r113 + '}');
        return;
    L16:
        r103 = "";
        goto L17
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void a(UpdateUserContext r100, UserState r101, UserState r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        if (r103 == true) goto L5;
        return;
    L5:
        b r104 = this.f438245b.get(Integer.valueOf(r100.f438252a));
        if (r104 == null) goto L8;
        long r105 = SystemClock.elapsedRealtime() - r104.f438251f;
    L9:
        this.f438244a.g(r105);
        Log.i("UserUpdateVisitor", "foreground offline transfer, notifyConvention cost:" + r105 + "ms");
        return;
    L8:
        r105 = -1;
        goto L9
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void b(UpdateUserContext r100, UserState r101, UserState r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        if (r103 == true) goto L5;
        return;
    L5:
        b r104 = this.f438245b.get(Integer.valueOf(r100.f438252a));
        if (r104 == null) goto L9;
        r104.f438251f = SystemClock.elapsedRealtime();
        return;
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void g(UpdateUserContext r100, UserState r101, UserState r102, h0c.b<j0c.a> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        Intrinsics.checkNotNullParameter(r103, "result");
        this.f438244a.i("rust_infra_transfer_online");
        b r104 = this.f438245b.get(Integer.valueOf(r100.f438252a));
        if (r104 == null) goto L5;
        long r105 = SystemClock.elapsedRealtime() - r104.f438248c;
    L6:
        Log.i("UserUpdateVisitor", "foreground online transfer, component task cost:" + r105 + "ms");
        return;
    L5:
        r105 = -1;
        goto L6
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void k(UpdateUserContext r100, UserState r101, UserState r102, h0c.b.c r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        Intrinsics.checkNotNullParameter(r103, "result");
        b r104 = this.f438245b.get(Integer.valueOf(r100.f438252a));
        if (r104 == null) goto L5;
        long r105 = SystemClock.elapsedRealtime() - r104.f438249d;
    L6:
        Log.i("UserUpdateVisitor", "foreground offline transfer, component task cost:" + r105 + "ms");
        this.f438244a.i("rust_infra_transfer_offline");
        return;
    L5:
        r105 = -1;
        goto L6
    }

    @Override // h0c.f
    public final void l(UpdateUserContext r100, UserState r101, UserState r102, h0c.b r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fromState");
        Intrinsics.checkNotNullParameter(r102, "toState");
        Intrinsics.checkNotNullParameter(r103, "results");
        Log.i("UserUpdateVisitor", "[stateTransit], fireState end, reqId:" + r100.f438252a + ", context:" + r100.hashCode() + ", uid:" + r100.f438254c.userId + ", result:{success:" + (r103 instanceof h0c.b.c) + '}');
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void n(UpdateUserContext r100, UserState r101, UserState r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        if (r103 == true) goto L5;
        return;
    L5:
        b r104 = this.f438245b.get(Integer.valueOf(r100.f438252a));
        if (r104 == null) goto L8;
        long r105 = SystemClock.elapsedRealtime() - r104.f438250e;
    L9:
        this.f438244a.g(r105);
        Log.i("UserUpdateVisitor", "foreground online transfer, notifyConvention cost:" + r105 + "ms");
        return;
    L8:
        r105 = -1;
        goto L9
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void o(UpdateUserContext r100, UserState r101, UserState r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        if (r103 == true) goto L5;
        return;
    L5:
        b r104 = this.f438245b.get(Integer.valueOf(r100.f438252a));
        if (r104 == null) goto L9;
        r104.f438250e = SystemClock.elapsedRealtime();
        return;
    }
}
