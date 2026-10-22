package com.bytedance.ies.ezresult;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/ezresult/EzResultFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Companion", "ezresult_release"}, k = 1, mv = {1, 4, 1})
public final class EzResultFragment extends Fragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f248593h = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f248594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Pair<Function2<Integer, Intent, Object>, Continuation<Object>>> f248595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Continuation<List<String>>> f248596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f248597g;

    public static final class Companion {

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Continuation f248598a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FragmentManager f248599b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f248600c;

            public a(SafeContinuation r100, FragmentManager r101, Ref.ObjectRef r102) {
                this.f248598a = r100;
                this.f248599b = r101;
                this.f248600c = r102;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                FragmentTransaction r100 = this.f248599b.beginTransaction();     // Catch: Throwable -> L8
                EzResultFragment r101 = (EzResultFragment) this.f248600c.element;     // Catch: Throwable -> L8
                if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "EzResultFragment", 0) == true) goto L6;
                r100 = r100.add(r101, "EzResultFragment");     // Catch: Throwable -> L8
            L6:
                r100.commitNowAllowingStateLoss();     // Catch: Throwable -> L8
                this.f248598a.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L8
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }
        }

        public Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [T, com.bytedance.ies.ezresult.EzResultFragment] */
        /* JADX WARN: Type inference failed for: r4v3, types: [T, com.bytedance.ies.ezresult.EzResultFragment] */
        public final Object a(FragmentManager r100, Continuation<? super EzResultFragment> r110) {
            if ((r110 instanceof EzResultFragment$Companion$getOrInstall$1) == false) goto L7;
            EzResultFragment$Companion$getOrInstall$1 r101 = (EzResultFragment$Companion$getOrInstall$1) r110;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r111 = r101.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r101.label;
            if (r104 == 0) goto L14;
            if (r104 != 1) goto L13;
            Ref.ObjectRef r105 = (Ref.ObjectRef) r101.L$1;
            FragmentManager r106 = (FragmentManager) r101.L$0;
            ResultKt.throwOnFailure(r111);
        L32:
            Ref.ObjectRef r112 = r105;
        L34:
            return (EzResultFragment) r112.element;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r111);
            r112 = new Ref.ObjectRef();
            Fragment r107 = r100.findFragmentByTag("EzResultFragment");
            if ((r107 instanceof EzResultFragment) == true) goto L17;
            r107 = null;
        L17:
            ?? r108 = (EzResultFragment) r107;
            r112.element = r108;
            if (r108 != 0) goto L34;
            r112.element = new EzResultFragment();
            FragmentTransaction r109 = r100.beginTransaction();     // Catch: IllegalStateException -> L26
            EzResultFragment r113 = (EzResultFragment) r112.element;     // Catch: IllegalStateException -> L26
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r109, r113, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "EzResultFragment", 0) == true) goto L24;
            r109 = r109.add(r113, "EzResultFragment");     // Catch: IllegalStateException -> L26
        L24:
            r109.commitNowAllowingStateLoss();     // Catch: IllegalStateException -> L26
        L26:
            r101.L$0 = r100;
            r101.L$1 = r112;
            r101.label = 1;
            SafeContinuation r114 = new SafeContinuation(IntrinsicsKt.intercepted(r101));
            new Handler(Looper.getMainLooper()).post(new a(r114, r100, r112));
            Object r115 = r114.getOrThrow();
            if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
            DebugProbesKt.probeCoroutineSuspended(r101);
        L29:
            if (r115 != r103) goto L31;
            return r103;
        L31:
            r105 = r112;
        L7:
            r101 = new EzResultFragment$Companion$getOrInstall$1(this, r110);
            goto L8
        }
    }

    static {
        f248593h = new Companion();
    }

    @Override // androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    public final int S90() {
        int r100 = this.f248594d.getAndIncrement();
    L4:
        if (this.f248595e.containsKey(Integer.valueOf(r100)) == false) goto L7;
        r100 = this.f248594d.getAndIncrement();
        goto L4
    L7:
        if ((Integer.MAX_VALUE - r100) >= 10) goto L9;
        this.f248594d.set(0);
    L9:
        return r100;
    }

    public EzResultFragment() {
        this.f248594d = new AtomicInteger(0);
        this.f248595e = new ConcurrentHashMap();
        this.f248596f = new ConcurrentHashMap();
        this.f248597g = new a();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f248597g.c(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        this.f248597g.d(r100);
    }

    public final Object T90(List r100, Function0 r101, ContinuationImpl r102) {
        SafeContinuation r103 = new SafeContinuation(IntrinsicsKt.intercepted(r102));
        monitor-enter(this);
        int r104 = S90();     // Catch: Throwable -> L17
        this.f248596f.put(Boxing.boxInt(r104), r103);     // Catch: Throwable -> L17
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        Object[] r106 = r100.toArray(new String[0]);
        if (r106 == null) goto L16;
        requestPermissions((String[]) r106, r104);
        if (r101 == null) goto L11;
        Unit r107 = (Unit) r101.invoke();
    L11:
        Object r108 = r103.getOrThrow();
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L14:
        return r108;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L17:
        th = move-exception;
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Pair<Function2<Integer, Intent, Object>, Continuation<Object>> r103 = this.f248595e.remove(Integer.valueOf(r100));
        if (r103 == null) goto L7;
        Continuation<Object> r104 = r103.getSecond();
        if (r104 == null) goto L9;
        r104.resumeWith(Result.m9449constructorimpl(r103.getFirst().invoke(Integer.valueOf(r101), r102)));
        return;
    L9:
        return;
    L7:
        this.f248597g.b(r100, r101, r102);
        Unit r105 = Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "grantResults");
        super.onRequestPermissionsResult(r100, r101, r102);
        Continuation<List<String>> r103 = this.f248596f.remove(Integer.valueOf(r100));
        if (r103 != null) goto L5;
        return;
    L5:
        if (r101.length != 0) goto L7;
        boolean r104 = true;
    L9:
        if ((!r104) == false) goto L24;
        ArrayList r105 = new ArrayList();
        Iterator r106 = ArraysKt.withIndex(r101).iterator();
    L12:
        if (r106.hasNext() == false) goto L16;
        IndexedValue r107 = (IndexedValue) r106.next();
        if (r102[r107.getIndex()] != 0) goto L12;
        r105.add(r107.getValue());
        goto L12
    L16:
        r103.resumeWith(Result.m9449constructorimpl(r105));
        return;
    L24:
        return;
    L7:
        r104 = false;
        goto L9
    }

    public final Object U90(Intent r100, Function0 r101, String r102, Function2 r110, ContinuationImpl r111) {
        SafeContinuation r103 = new SafeContinuation(IntrinsicsKt.intercepted(r111));
        monitor-enter(this);
        int r104 = S90();     // Catch: Throwable -> L18
        ConcurrentHashMap<Integer, Pair<Function2<Integer, Intent, Object>, Continuation<Object>>> r105 = this.f248595e;     // Catch: Throwable -> L18
        Integer r106 = Boxing.boxInt(r104);     // Catch: Throwable -> L18
        if (r110 == null) goto L17;
        r105.put(r106, new Pair((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r110, 2), r103));     // Catch: Throwable -> L18
        if (r102 == null) goto L9;
        a r112 = this.f248597g;     // Catch: Throwable -> L18
        r112.getClass();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r102, "key");     // Catch: Throwable -> L18
        r112.a(r102);     // Catch: Throwable -> L18
        r112.f248611d.put(r102, Integer.valueOf(r104));     // Catch: Throwable -> L18
        r112.f248612e.put(Integer.valueOf(r104), r102);     // Catch: Throwable -> L18
    L9:
        monitor-exit(this);
        if (r101 == null) goto L12;
        Unit r107 = (Unit) r101.invoke();
    L12:
        startActivityForResult(r100, r104);
        Object r108 = r103.getOrThrow();
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r111);
    L15:
        return r108;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Int, android.content.Intent?) -> kotlin.Any");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }
}
