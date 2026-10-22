package com.bytedance.ies.ezresult;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import f06.b;
import f06.d;
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
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/ezresult/EzResultSupportFragment;", "Landroid/app/Fragment;", "<init>", "()V", "Companion", "ezresult_release"}, k = 1, mv = {1, 4, 1})
public final class EzResultSupportFragment extends Fragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f248601e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f248602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Pair<Function2<Integer, Intent, Object>, Continuation<Object>>> f248603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Continuation<List<String>>> f248604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f248605d;

    public static final class Companion {

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Continuation f248606a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FragmentManager f248607b;

            public a(SafeContinuation r100, FragmentManager r101) {
                this.f248606a = r100;
                this.f248607b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f248607b.executePendingTransactions();     // Catch: Throwable -> L4
                this.f248606a.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public Companion() {
        }

        public final Object a(FragmentManager r100, Continuation<? super EzResultSupportFragment> r101) {
            if ((r101 instanceof EzResultSupportFragment$Companion$getOrInstall$1) == false) goto L7;
            EzResultSupportFragment$Companion$getOrInstall$1 r102 = (EzResultSupportFragment$Companion$getOrInstall$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            EzResultSupportFragment r107 = (EzResultSupportFragment) r102.L$1;
            FragmentManager r108 = (FragmentManager) r102.L$0;
            ResultKt.throwOnFailure(r104);
        L29:
            return r107;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            Fragment r109 = r100.findFragmentByTag("EzResultFragment");
            if ((r109 instanceof EzResultSupportFragment) == true) goto L17;
            r109 = null;
        L17:
            EzResultSupportFragment r110 = (EzResultSupportFragment) r109;
            if (r110 != null) goto L32;
            EzResultSupportFragment r111 = new EzResultSupportFragment();
            r100.beginTransaction().add(r111, "EzResultFragment").commitAllowingStateLoss();
            r100.executePendingTransactions();     // Catch: IllegalStateException -> L22
            return r111;
        L22:
            r102.L$0 = r100;
            r102.L$1 = r111;
            r102.label = 1;
            SafeContinuation r112 = new SafeContinuation(IntrinsicsKt.intercepted(r102));
            new Handler(Looper.getMainLooper()).post(new a(r112, r100));
            Object r113 = r112.getOrThrow();
            if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
            DebugProbesKt.probeCoroutineSuspended(r102);
        L25:
            if (r113 != r105) goto L27;
            return r105;
        L27:
            r107 = r111;
            goto L29
        L32:
            return r110;
        L7:
            r102 = new EzResultSupportFragment$Companion$getOrInstall$1(this, r101);
            goto L8
        }
    }

    static {
        f248601e = new Companion();
    }

    @Override // android.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    public final int a() {
        int r100 = this.f248602a.getAndIncrement();
    L4:
        if (this.f248603b.containsKey(Integer.valueOf(r100)) == false) goto L7;
        r100 = this.f248602a.getAndIncrement();
        goto L4
    L7:
        if ((Integer.MAX_VALUE - r100) >= 10) goto L9;
        this.f248602a.set(0);
    L9:
        return r100;
    }

    public EzResultSupportFragment() {
        this.f248602a = new AtomicInteger(0);
        this.f248603b = new ConcurrentHashMap();
        this.f248604c = new ConcurrentHashMap();
        this.f248605d = new a();
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f248605d.c(r100);
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        this.f248605d.d(r100);
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Pair<Function2<Integer, Intent, Object>, Continuation<Object>> r103 = this.f248603b.remove(Integer.valueOf(r100));
        if (r103 == null) goto L7;
        Continuation<Object> r104 = r103.getSecond();
        if (r104 == null) goto L9;
        r104.resumeWith(Result.m9449constructorimpl(r103.getFirst().invoke(Integer.valueOf(r101), r102)));
        return;
    L9:
        return;
    L7:
        this.f248605d.b(r100, r101, r102);
        Unit r105 = Unit.INSTANCE;
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r210, String[] r211, int[] r212) {
        Intrinsics.checkNotNullParameter(r211, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r212, "grantResults");
        ArrayList r100 = new ArrayList();
        boolean r110 = false;
        Object[] r101 = {Integer.valueOf(r210), r211, r212};
        b r111 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(102612);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r112 = r103;
        int r113 = r112.length;
        int r104 = 0;
    L8:
        if (r104 >= r113) goto L15;
        f06.a r105 = r112[r104];
        int r114 = r104;
        int r115 = r113;
        f06.a[] r213 = r112;
        d r106 = r105.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r101, "void", r111);     // Catch: Exception -> L36
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L36
    L17:
        if (r106.f474982a == true) goto L20;
        super.onRequestPermissionsResult(r210, r211, r212);
    L20:
        Continuation<List<String>> r107 = this.f248604c.remove(Integer.valueOf(r210));
        if (r107 != null) goto L23;
        return;
    L23:
        if (r211.length != 0) goto L25;
        boolean r108 = true;
        r110 = true;
    L27:
        if ((r108 ^ r110) == false) goto L48;
        ArrayList r109 = new ArrayList();
        Iterator r116 = ArraysKt.withIndex(r211).iterator();
    L30:
        if (r116.hasNext() == false) goto L34;
        IndexedValue r117 = (IndexedValue) r116.next();
        if (r212[r117.getIndex()] != 0) goto L30;
        r109.add(r117.getValue());
        goto L30
    L34:
        r107.resumeWith(Result.m9449constructorimpl(r109));
        return;
    L48:
        return;
    L25:
        r108 = true;
    L14:
        r104 = r114 + 1;
        r113 = r115;
        r112 = r213;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
