package com.larus.dora.impl.core;

import com.larus.dora.api.annotation.DoraScene;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraSceneManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraSceneManager f332159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StateFlowImpl f332160b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f332161c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutexImpl f332162d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArraySet<u39.a> f332163e = null;

    public DoraSceneManager() {
    }

    static {
        f332159a = new DoraSceneManager();
        f332160b = j1.a(SetsKt.emptySet());
        f332161c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        f332162d = kotlinx.coroutines.sync.b.a();
        f332163e = new CopyOnWriteArraySet();
    }

    public static void c() {
        kj4.a.g().registerDoraLinkCallback(new t0());
        BuildersKt.launch$default(f332161c, null, null, new DoraSceneManager$init$2(null), 3, null);
    }

    public static boolean d(DoraScene... r100) {
        Intrinsics.checkNotNullParameter(r100, InvRouter.SCENES);
        pk4.j.d("DoraSceneManager", "isSceneActive: checking scenes=" + r100 + ", now=" + f332160b.getValue());
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (((Set) f332160b.getValue()).contains(r100[r102]) == false) goto L12;
        r102 = r102 + 1;
        goto L3
    L12:
        return false;
    L8:
        return true;
    }

    public static final Object a(DoraSceneManager r100, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof DoraSceneManager$clearScene$1) == false) goto L7;
        DoraSceneManager$clearScene$1 r101 = (DoraSceneManager$clearScene$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        kotlinx.coroutines.sync.a r112 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L24:
        pk4.j.d("DoraSceneManager", "clearScene");     // Catch: Throwable -> L21
        f332160b.setValue(SetsKt.emptySet());     // Catch: Throwable -> L21
        BuildersKt.launch$default(f332161c, null, null, new DoraSceneManager$notifyChanged$1(null), 3, null);     // Catch: Throwable -> L21
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L21
        r112.unlock(null);
        return Unit.INSTANCE;
    L21:
        th = move-exception;
        r112.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        MutexImpl r106 = f332162d;
        r101.L$0 = r106;
        r101.label = 1;
        if (r106.a(null, r101) == r111) goto L26;
        r112 = r106;
        goto L24
    L26:
        return r111;
    L7:
        r101 = new DoraSceneManager$clearScene$1(r100, r110);
        goto L8
    }

    public final Object b(DoraScene r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof DoraSceneManager$addScene$1) == false) goto L7;
        DoraSceneManager$addScene$1 r100 = (DoraSceneManager$addScene$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r100.L$1;
        DoraScene r104 = (DoraScene) r100.L$0;
        ResultKt.throwOnFailure(r112);
        kotlinx.coroutines.sync.a r114 = r113;
        r110 = r104;
    L23:
        StateFlowImpl r105 = f332160b;     // Catch: Throwable -> L20
        r105.setValue(SetsKt.plus((Set) r105.getValue(), r110));     // Catch: Throwable -> L20
        pk4.j.d("DoraSceneManager", "addScene: " + r110 + ", now=" + r105.getValue());     // Catch: Throwable -> L20
        BuildersKt.launch$default(f332161c, null, null, new DoraSceneManager$notifyChanged$1(null), 3, null);     // Catch: Throwable -> L20
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r114.unlock(null);
        return Unit.INSTANCE;
    L20:
        th = move-exception;
        r114.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r114 = f332162d;
        r100.L$0 = r110;
        r100.L$1 = r114;
        r100.label = 1;
        if (r114.a(null, r100) != r102) goto L23;
        return r102;
    L7:
        r100 = new DoraSceneManager$addScene$1(this, r111);
        goto L8
    }

    public final Object e(DoraScene r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof DoraSceneManager$removeScene$1) == false) goto L7;
        DoraSceneManager$removeScene$1 r100 = (DoraSceneManager$removeScene$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r100.L$1;
        DoraScene r104 = (DoraScene) r100.L$0;
        ResultKt.throwOnFailure(r112);
        kotlinx.coroutines.sync.a r114 = r113;
        r110 = r104;
    L23:
        StateFlowImpl r105 = f332160b;     // Catch: Throwable -> L20
        r105.setValue(SetsKt.minus((Set) r105.getValue(), r110));     // Catch: Throwable -> L20
        pk4.j.d("DoraSceneManager", "removeScene: " + r110 + ", now=" + r105.getValue());     // Catch: Throwable -> L20
        BuildersKt.launch$default(f332161c, null, null, new DoraSceneManager$notifyChanged$1(null), 3, null);     // Catch: Throwable -> L20
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r114.unlock(null);
        return Unit.INSTANCE;
    L20:
        th = move-exception;
        r114.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r114 = f332162d;
        r100.L$0 = r110;
        r100.L$1 = r114;
        r100.label = 1;
        if (r114.a(null, r100) != r102) goto L23;
        return r102;
    L7:
        r100 = new DoraSceneManager$removeScene$1(this, r111);
        goto L8
    }
}
