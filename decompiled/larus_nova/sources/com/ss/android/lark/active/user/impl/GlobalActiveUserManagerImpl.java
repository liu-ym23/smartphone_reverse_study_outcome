package com.ss.android.lark.active.user.impl;

import android.os.Looper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.active.user.api.IGlobalActiveUserManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.a0;
import com.ss.android.lark.passportc.api.k;
import com.ss.android.lark.passportc.api.l;
import com.ss.android.lark.passportc.api.w;
import com.ss.android.lark.passportc.api.x;
import com.ss.android.lark.passportc.api.z;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserRequest;
import com.ss.android.lark.passportc.impl.v2.entity.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import f0c.g;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.CallbackFlowBuilder;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class GlobalActiveUserManagerImpl implements IGlobalActiveUserManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CoroutineScope f408588g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f408589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f408590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nua.c f408591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nua.a f408592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f408593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StateFlowImpl f408594f;

    public static final class a implements Function1<User, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final nua.a f408596b;

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(User r110) {
            User r111 = r110;
            Intrinsics.checkNotNullParameter(r111, "checkUser");
            List<String> r100 = this.f408596b.a();
            if (r100 != null) goto L5;
            Log.i("ActiveUserManagerImpl", "targetId: " + this.f408595a + ", activeUserSelectUidList is null, all pass");
            return Boolean.TRUE;
        L5:
            Log.i("ActiveUserManagerImpl", "targetId: " + this.f408595a + ", activeUserSelectUidList = " + CollectionsKt.joinToString$default(r100, ",", "[", "]", 0, null, null, 56, null));
            Intrinsics.checkNotNullParameter(r111, "<this>");
            boolean r101 = true;
            if (Intrinsics.areEqual(r111.userUnit, "useast15a") == false) goto L10;
            LarkAppContext.Companion.getClass();
            if (LarkAppContext.access$getInstance$cp().buildConfig().isUsPackage() == false) goto L10;
            boolean r102 = true;
        L11:
            if (r102 == false) goto L13;
        L15:
            r101 = false;
        L17:
            return Boolean.valueOf(r101);
        L13:
            if (r100.contains(r111.userId) == false) goto L15;
        L10:
            r102 = false;
            goto L11
        }

        public a(String r100, nua.a r101) {
            Intrinsics.checkNotNullParameter(r101, "activeUserSelect");
            this.f408595a = r100;
            this.f408596b = r101;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GlobalActiveUserManagerImpl f408602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UpdateUserRequest f408603b;

        public c(GlobalActiveUserManagerImpl r100, UpdateUserRequest r101) {
            this.f408602a = r100;
            this.f408603b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v14, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r7v6, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v7, types: [java.util.List] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.ss.android.lark.passportc.impl.v2.entity.c r101 = (com.ss.android.lark.passportc.impl.v2.entity.c) r100;
            IGlobalActiveUserManager.a r102 = (IGlobalActiveUserManager.a) this.f408602a.f408594f.getValue();
            GlobalActiveUserManagerImpl r103 = this.f408602a;
            UpdateUserRequest r104 = this.f408603b;
            Intrinsics.checkNotNull(r101);
            r103.getClass();
            d r105 = r104.f438263a;
            if (r105 == null) goto L8;
            User r106 = r105.f438280a;
            if (r106 == null) goto L8;
            String r107 = r106.userId;
            if (r107 == null) goto L8;
        L14:
            List<d> r108 = r104.f438264b;
            if (r108 == null) goto L31;
            ArrayList r109 = new ArrayList();
            Iterator<T> r110 = r108.iterator();
        L18:
            if (r110.hasNext() == false) goto L27;
            T r111 = r110.next();
            d r112 = (d) r111;
            if (Intrinsics.areEqual(r112.f438280a.userId, r107) == false) goto L22;
        L24:
            boolean r113 = false;
        L25:
            if (r113 == false) goto L18;
            r109.add(r111);
            goto L18
        L22:
            if (r112.f438281b != UserState.ONLINE) goto L24;
            r113 = true;
            goto L25
        L27:
            ?? r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
            Iterator r115 = r109.iterator();
        L29:
            if (r115.hasNext() == false) goto L32;
            r114.add(((d) r115.next()).f438280a.userId);
        L32:
            IGlobalActiveUserManager.a r116 = new IGlobalActiveUserManager.a(r107, r114);
            this.f408602a.f408594f.setValue(r116);
            Log.i("ActiveUserManagerImpl", "activeUserChange v2:\nfrom:" + r102 + "\nto  :" + r116);
            return;
        L31:
            r114 = CollectionsKt.emptyList();
        L8:
            g r117 = r101.f496849a.a();
            if (r117 == null) goto L13;
            User r118 = r117.f475033a;
            if (r118 == null) goto L13;
            r107 = r118.userId;
        L13:
            r107 = null;
            goto L14
        }
    }

    static {
        f408588g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool())));
    }

    @Override // com.ss.android.lark.active.user.api.IGlobalActiveUserManager
    public final b1 c() {
        return e.b(this.f408594f);
    }

    public final IGlobalActiveUserManager.a f() {
        return (IGlobalActiveUserManager.a) this.f408594f.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final UpdateUserRequest g(nua.d r100) {
        List<User> r101 = r100.f520614b;
        ArrayList r102 = null;
        if (r101 == null) goto L23;
        List<User> r103 = r101;
        d r104 = r100.f520613a;
        if (r104 == null) goto L9;
        User r105 = r104.f438280a;
        if (r105 == null) goto L9;
        String r106 = r105.userId;
    L10:
        a r107 = new a(r106, this.f408592d);
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r103.iterator();
    L12:
        if (r109.hasNext() == false) goto L16;
        Object r110 = r109.next();
        if (((Boolean) r107.invoke(r110)).booleanValue() == false) goto L12;
        r108.add(r110);
        goto L12
    L16:
        d r111 = r100.f520613a;
        if (r111 == null) goto L21;
        User r112 = r111.f438280a;
        if (r112 == null) goto L21;
        String r113 = r112.userId;
    L22:
        List<User> r114 = e(r108, r113);
    L24:
        UpdateUserRequest.a r115 = new UpdateUserRequest.a();
        r115.f438266a = r100.f520613a;
        if (r114 == null) goto L30;
        List<User> r116 = r114;
        r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r117 = r116.iterator();
    L28:
        if (r117.hasNext() == false) goto L30;
        r102.add(new d((User) r117.next(), UserState.ONLINE, false));
    L30:
        if (r102 == null) goto L33;
        r115.f438267b = CollectionsKt.toMutableList(r102);
    L33:
        return r115.a();
    L21:
        r113 = null;
    L9:
        r106 = null;
        goto L10
    L23:
        r114 = null;
        goto L24
    }

    public static final String d(GlobalActiveUserManagerImpl r100, j0c.d r101) {
        r100.getClass();
        StringBuilder r102 = new StringBuilder("foreground: ");
        r102.append(r101.f496849a);
        r102.append("\nbackground:");
        StringBuilder r103 = new StringBuilder();
        Iterator<T> r104 = r101.f496851c.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        f0c.b r105 = (f0c.b) r104.next();
        r103.append('\n');
        r103.append(r105.toString());
        goto L4
    L6:
        r102.append(r103);
        return r102.toString();
    }

    public final List<User> e(List<? extends User> r100, String r101) {
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L3:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L9;
        Object r105 = r103.next();
        if ((true ^ Intrinsics.areEqual(((User) r105).userId, r101)) == false) goto L3;
        r102.add(r105);
        goto L3
    L9:
        if (this.f408591c.b() == true) goto L11;
    L13:
        r104 = false;
    L14:
        if (r104 == false) goto L16;
        int r106 = ((Number) this.f408593e.getValue()).intValue();
    L18:
        return r102.subList(0, RangesKt.coerceAtMost(r106, r102.size()));
    L16:
        r106 = 0;
        goto L18
    L11:
        if (this.f408591c.a() == false) goto L13;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.active.user.api.IGlobalActiveUserManager
    @IGlobalActiveUserManager.PassportOnly
    public final Object a(final IGlobalActiveUserManager.b r110, lzb.a r111, Continuation<? super Result<? extends j0c.d>> r112) {
        if ((r112 instanceof GlobalActiveUserManagerImpl$updateActiveUsers$1) == false) goto L7;
        GlobalActiveUserManagerImpl$updateActiveUsers$1 r100 = (GlobalActiveUserManagerImpl$updateActiveUsers$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        Function0 r114 = (Function0) r100.L$1;
        IGlobalActiveUserManager.b r115 = (IGlobalActiveUserManager.b) r100.L$0;
        ResultKt.throwOnFailure(r113);
        Function0 r104 = r114;
        r110 = r115;
    L56:
        Object r116 = ((Result) r113).m9458unboximpl();
        if (Result.m9456isSuccessimpl(r116) == false) goto L61;
        j0c.d r117 = (j0c.d) r116;
        Log.i("ActiveUserManagerImpl", r110.f408553a + " success, get first result");
        IGlobalActiveUserManager.a r118 = (IGlobalActiveUserManager.a) r104.invoke();
        if (r118 == null) goto L61;
        Log.i("ActiveUserManagerImpl", "activeUserChange:\nfrom:" + this.f408594f.getValue() + "\nto:" + r118);
        this.f408594f.setValue(r118);
    L61:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r116);
        if (r119 == null) goto L64;
        Log.e("ActiveUserManagerImpl", r110.f408553a + " failed", r119);
    L64:
        return r116;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if ((r110 instanceof IGlobalActiveUserManager.b.a) == false) goto L17;
        List<User> r120 = r110.f408554b;
        IGlobalActiveUserManager.b.a r121 = (IGlobalActiveUserManager.b.a) r110;
        throw null;
    L17:
        if ((r110 instanceof IGlobalActiveUserManager.b.e) == false) goto L26;
        List<User> r122 = r110.f408554b;
        a r105 = new a(f().f408551a, this.f408592d);
        ArrayList r106 = new ArrayList();
        Iterator<T> r123 = r122.iterator();
    L20:
        if (r123.hasNext() == false) goto L24;
        Object r107 = r123.next();
        if (((Boolean) r105.invoke(r107)).booleanValue() == false) goto L20;
        r106.add(r107);
        goto L20
    L24:
        final List<User> r124 = e(r106, f().f408551a);
        Pair r108 = new Pair(new a0(r124), new GlobalActiveUserManagerImpl$updateActiveUsers$3(this, r124));
    L53:
        z r125 = (z) r108.component1();
        r104 = (Function0) r108.component2();
        Log.i("ActiveUserManagerImpl", "call update:" + r110.f408553a + "\nExecMode:" + r110.f408555c + "\nAction:" + r125);
        CallbackFlowBuilder r126 = e.e(new GlobalActiveUserManagerImpl$asResultFlow$1(this.f408589a.b(r125, r110.f408555c, r111), r110.f408553a, this, null));
        r100.L$0 = r110;
        r100.L$1 = r104;
        r100.label = 1;
        r113 = e.s(r126, r100);
        if (r113 != r102) goto L56;
        return r102;
    L26:
        if ((r110 instanceof IGlobalActiveUserManager.b.c) == false) goto L35;
        List<User> r127 = r110.f408554b;
        IGlobalActiveUserManager.b.c r109 = (IGlobalActiveUserManager.b.c) r110;
        a r128 = new a(null, this.f408592d);
        ArrayList r129 = new ArrayList();
        Iterator<T> r130 = r127.iterator();
    L29:
        if (r130.hasNext() == false) goto L33;
        Object r131 = r130.next();
        if (((Boolean) r128.invoke(r131)).booleanValue() == false) goto L29;
        r129.add(r131);
        goto L29
    L33:
        r108 = new Pair(new w(e(r129, null)), GlobalActiveUserManagerImpl$updateActiveUsers$4.INSTANCE);
        goto L53
    L35:
        if ((r110 instanceof IGlobalActiveUserManager.b.d) == false) goto L66;
        List<User> r132 = r110.f408554b;
        IGlobalActiveUserManager.b.d r133 = (IGlobalActiveUserManager.b.d) r110;
        a r134 = new a(null, this.f408592d);
        ArrayList r135 = new ArrayList();
        Iterator<T> r136 = r132.iterator();
    L38:
        if (r136.hasNext() == false) goto L42;
        Object r137 = r136.next();
        if (((Boolean) r134.invoke(r137)).booleanValue() == false) goto L38;
        r135.add(r137);
        goto L38
    L42:
        final List<User> r138 = e(r135, null);
        boolean r139 = false;
        if (this.f408591c.b() == true) goto L45;
    L47:
        boolean r140 = false;
    L48:
        if (r140 == true) goto L50;
    L52:
        r108 = new Pair(new x(r138, r139), new GlobalActiveUserManagerImpl$updateActiveUsers$5(r110, r138));
        goto L53
    L50:
        if (r110.f408555c.f438115d == Scene.FAST_ONLINE) goto L52;
        r139 = true;
        goto L52
    L45:
        if (this.f408591c.a() == false) goto L47;
        r140 = true;
        goto L48
    L66:
        if ((r110 instanceof IGlobalActiveUserManager.b.C4740b) == false) goto L68;
        List<User> r141 = r110.f408554b;
        IGlobalActiveUserManager.b.C4740b r142 = (IGlobalActiveUserManager.b.C4740b) r110;
        throw null;
    L68:
        throw new NoWhenBranchMatchedException();
    L7:
        r100 = new GlobalActiveUserManagerImpl$updateActiveUsers$1(this, r112);
        goto L8
    }

    @IGlobalActiveUserManager.PassportOnly
    public final Observable<com.ss.android.lark.passportc.impl.v2.entity.c> h(nua.d r100, com.ss.android.lark.passportc.api.d r101, lzb.a r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "executeMode");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Log.i("ActiveUserManagerImpl", "updateActiveUsersAsync2, request=" + Objects.toString(r100) + ", scene=" + r101.f438115d + ", execMode=" + r101);
        boolean r103 = Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        Observable<com.ss.android.lark.passportc.impl.v2.entity.c> r104 = this.f408590b.c(g(r100), r101, r102).doOnNext(new c(this, g(r100)));
        if (r103 == true) goto L5;
        return r104;
    L5:
        return r104.subscribeOn(AndroidSchedulers.mainThread());
    }

    @Inject
    public GlobalActiveUserManagerImpl(l r100, k r101, nua.c r102, nua.a r103) {
        Intrinsics.checkNotNullParameter(r100, "stateManager");
        Intrinsics.checkNotNullParameter(r101, "stateManager2");
        Intrinsics.checkNotNullParameter(r102, "multiUserOnlineFeatureGating");
        Intrinsics.checkNotNullParameter(r103, "activeUserSelect");
        this.f408589a = r100;
        this.f408590b = r101;
        this.f408591c = r102;
        this.f408592d = r103;
        this.f408593e = LazyKt.lazy(GlobalActiveUserManagerImpl$activeBkgUserCount$2.INSTANCE);
        this.f408594f = j1.a(new IGlobalActiveUserManager.a(null, CollectionsKt.emptyList()));
    }

    @Override // com.ss.android.lark.active.user.api.IGlobalActiveUserManager
    @IGlobalActiveUserManager.PassportOnly
    public final Object b(nua.d r100, com.ss.android.lark.passportc.api.d r101, lzb.a r102, Continuation<? super Result<? extends com.ss.android.lark.passportc.impl.v2.entity.c>> r110) {
        if ((r110 instanceof GlobalActiveUserManagerImpl$updateActiveUsers2$1) == false) goto L7;
        GlobalActiveUserManagerImpl$updateActiveUsers2$1 r103 = (GlobalActiveUserManagerImpl$updateActiveUsers2$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        Scene r107 = (Scene) r103.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
    L23:
        return ((Result) r111).m9458unboximpl();
    L14:
        Throwable th10 = th;
        final Scene r112 = r107;
    L28:
        Log.w("ActiveUserManagerImpl", r112 + " v2 emit throwable:" + ExceptionsKt.stackTraceToString(th10));
        Result.Companion r108 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th10));
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        Log.i("ActiveUserManagerImpl", "updateActiveUsers2, request=" + Objects.toString(r100) + ", scene=" + r101.f438115d + ", execMode=" + r101);
        r112 = r101.f438115d;
        final CallbackFlowBuilder r109 = kotlinx.coroutines.rx2.c.a(h(r100, r101, r102));     // Catch: Throwable -> L26
        Flow<Result<? extends com.ss.android.lark.passportc.impl.v2.entity.c>> r113 = new GlobalActiveUserManagerImpl$updateActiveUsers2BWLJW6A$$inlined$map$1(r109, r112, this);     // Catch: Throwable -> L26
        r103.L$0 = r112;     // Catch: Throwable -> L26
        r103.label = 1;     // Catch: Throwable -> L26
        Object r114 = e.s(r113, r103);     // Catch: Throwable -> L26
        if (r114 != r105) goto L22;
        return r105;
    L22:
        r111 = r114;
    L26:
        th = move-exception;
        th10 = th;
    L7:
        r103 = new GlobalActiveUserManagerImpl$updateActiveUsers2$1(this, r110);
        goto L8
    }
}
