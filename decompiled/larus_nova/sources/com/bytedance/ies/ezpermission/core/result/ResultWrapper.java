package com.bytedance.ies.ezpermission.core.result;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.ezresult.EzResultFragment;
import com.bytedance.ies.ezresult.EzResultSupportFragment;
import com.bytedance.ies.ezresult.a;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class ResultWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EzResultFragment f248582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EzResultSupportFragment f248583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f248584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f248585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Fragment f248586e;

    public ResultWrapper(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f248585d = r100;
    }

    public final /* synthetic */ Object c(Continuation<? super Unit> r100) {
        if ((r100 instanceof ResultWrapper$tryInit$1) == false) goto L7;
        ResultWrapper$tryInit$1 r101 = (ResultWrapper$tryInit$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        ResultWrapper r106 = (ResultWrapper) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L44:
        r106.f248582a = (EzResultFragment) r103;
    L46:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultWrapper r107 = (ResultWrapper) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L39:
        r107.f248583b = (EzResultSupportFragment) r103;
        goto L46
    L17:
        ResultWrapper r108 = (ResultWrapper) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L32:
        r108.f248582a = (EzResultFragment) r103;
        goto L46
    L18:
        ResultKt.throwOnFailure(r103);
        if (this.f248584c == true) goto L21;
        this.f248584c = true;
        Activity r109 = this.f248585d;
        if (r109 != null) goto L25;
        EzResultFragment.Companion r110 = EzResultFragment.f248593h;
        Fragment r111 = this.f248586e;
        Intrinsics.checkNotNull(r111);
        FragmentManager r112 = r111.getChildFragmentManager();
        r101.L$0 = this;
        r101.label = 3;
        r103 = r110.a(r112, r101);
        if (r103 != r104) goto L43;
        return r104;
    L43:
        r106 = this;
        goto L44
    L25:
        if ((r109 instanceof FragmentActivity) == false) goto L35;
        EzResultFragment.Companion r113 = EzResultFragment.f248593h;
        if (r109 == null) goto L34;
        FragmentManager r114 = ((FragmentActivity) r109).getSupportFragmentManager();
        r101.L$0 = this;
        r101.label = 1;
        r103 = r113.a(r114, r101);
        if (r103 != r104) goto L31;
        return r104;
    L31:
        r108 = this;
        goto L32
    L34:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L35:
        EzResultSupportFragment.Companion r115 = EzResultSupportFragment.f248601e;
        Intrinsics.checkNotNull(r109);
        android.app.FragmentManager r116 = r109.getFragmentManager();
        r101.L$0 = this;
        r101.label = 2;
        r103 = r115.a(r116, r101);
        if (r103 != r104) goto L38;
        return r104;
    L38:
        r107 = this;
        goto L39
    L21:
        return Unit.INSTANCE;
    L7:
        r101 = new ResultWrapper$tryInit$1(this, r100);
        goto L8
    }

    public ResultWrapper(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f248586e = r100;
    }

    public final Object a(List<String> r100, Function0<Unit> r101, Continuation<? super List<String>> r110) {
        if ((r110 instanceof ResultWrapper$requestPermissionsInner$1) == false) goto L7;
        ResultWrapper$requestPermissionsInner$1 r102 = (ResultWrapper$requestPermissionsInner$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        ResultKt.throwOnFailure(r111);
    L47:
        return (List) r111;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Function0<Unit> r106 = (Function0) r102.L$2;
        List<String> r107 = (List) r102.L$1;
        ResultWrapper r108 = (ResultWrapper) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L28:
        List r112 = (List) r111;
        if (r112 != null) goto L55;
        List<String> r109 = r107;
        r101 = r106;
        r100 = r109;
    L32:
        EzResultSupportFragment r113 = r108.f248583b;
        Intrinsics.checkNotNull(r113);
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.label = 3;
        r113.getClass();
        SafeContinuation r114 = new SafeContinuation(IntrinsicsKt.intercepted(r102));
        monitor-enter(r113);
        int r115 = r113.a();     // Catch: Throwable -> L50
        r113.f248604c.put(Boxing.boxInt(r115), r114);     // Catch: Throwable -> L50
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L50
        monitor-exit(r113);
        Object[] r117 = r100.toArray(new String[0]);
        if (r117 == null) goto L49;
        r113.requestPermissions((String[]) r117, r115);
        if (r101 == null) goto L41;
        Unit r118 = r101.invoke();
    L41:
        r111 = r114.getOrThrow();
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L44;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L44:
        if (r111 != r104) goto L47;
        return r104;
    L49:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L50:
        th = move-exception;
        throw th;
    L55:
        return r112;
    L17:
        r101 = (Function0) r102.L$2;
        r100 = (List) r102.L$1;
        r108 = (ResultWrapper) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L22:
        EzResultFragment r119 = r108.f248582a;
        if (r119 == null) goto L32;
        r102.L$0 = r108;
        r102.L$1 = r100;
        r102.L$2 = r101;
        r102.label = 2;
        r111 = r119.T90(r100, r101, r102);
        if (r111 != r104) goto L27;
        return r104;
    L27:
        Function0<Unit> r120 = r101;
        r107 = r100;
        r106 = r120;
        goto L28
    L18:
        ResultKt.throwOnFailure(r111);
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.L$2 = r101;
        r102.label = 1;
        if (c(r102) != r104) goto L21;
        return r104;
    L21:
        r108 = this;
    L7:
        r102 = new ResultWrapper$requestPermissionsInner$1(this, r110);
        goto L8
    }

    public final <T> Object b(Intent r110, Function0<Unit> r111, String r112, Function2<? super Integer, ? super Intent, ? extends T> r210, Continuation<? super T> r211) {
        if ((r211 instanceof ResultWrapper$startActivityForResultInner$1) == false) goto L7;
        ResultWrapper$startActivityForResultInner$1 r100 = (ResultWrapper$startActivityForResultInner$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        ResultKt.throwOnFailure(r102);
    L46:
        return r102;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Function2<? super Integer, ? super Intent, ? extends T> r105 = (Function2) r100.L$4;
        String r106 = (String) r100.L$3;
        Function0<Unit> r107 = (Function0) r100.L$2;
        Intent r108 = (Intent) r100.L$1;
        ResultWrapper r109 = (ResultWrapper) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L28:
        if (r102 != null) goto L46;
        Function2<? super Integer, ? super Intent, ? extends T> r113 = r105;
        String r114 = r106;
        Function0<Unit> r115 = r107;
        Intent r116 = r108;
        ResultWrapper r117 = r109;
    L31:
        EzResultSupportFragment r118 = r117.f248583b;
        Intrinsics.checkNotNull(r118);
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.label = 3;
        r118.getClass();
        SafeContinuation r119 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        monitor-enter(r118);
        int r120 = r118.a();     // Catch: Throwable -> L49
        ConcurrentHashMap<Integer, Pair<Function2<Integer, Intent, Object>, Continuation<Object>>> r121 = r118.f248603b;     // Catch: Throwable -> L49
        Integer r122 = Boxing.boxInt(r120);     // Catch: Throwable -> L49
        if (r113 == null) goto L48;
        r121.put(r122, new Pair((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r113, 2), r119));     // Catch: Throwable -> L49
        if (r114 == null) goto L38;
        a r123 = r118.f248605d;     // Catch: Throwable -> L49
        r123.getClass();     // Catch: Throwable -> L49
        Intrinsics.checkNotNullParameter(r114, "key");     // Catch: Throwable -> L49
        r123.a(r114);     // Catch: Throwable -> L49
        r123.f248611d.put(r114, Integer.valueOf(r120));     // Catch: Throwable -> L49
        r123.f248612e.put(Integer.valueOf(r120), r114);     // Catch: Throwable -> L49
    L38:
        monitor-exit(r118);
        if (r115 == null) goto L41;
        Unit r124 = r115.invoke();
    L41:
        r118.startActivityForResult(r116, r120);
        r102 = r119.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L44;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L44:
        if (r102 != r103) goto L46;
        return r103;
    L48:
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Int, android.content.Intent?) -> kotlin.Any");     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    L17:
        Function2<? super Integer, ? super Intent, ? extends T> r125 = (Function2) r100.L$4;
        String r126 = (String) r100.L$3;
        Function0<Unit> r127 = (Function0) r100.L$2;
        Intent r128 = (Intent) r100.L$1;
        ResultWrapper r129 = (ResultWrapper) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r113 = r125;
        r114 = r126;
        r115 = r127;
        r116 = r128;
        r117 = r129;
    L22:
        EzResultFragment r130 = r117.f248582a;
        if (r130 == null) goto L31;
        r100.L$0 = r117;
        r100.L$1 = r116;
        r100.L$2 = r115;
        r100.L$3 = r114;
        r100.L$4 = r113;
        r100.label = 2;
        Object r131 = r130.U90(r116, r115, r114, r113, r100);
        if (r131 != r103) goto L27;
        return r103;
    L27:
        r108 = r116;
        r102 = r131;
        r107 = r115;
        r106 = r114;
        r105 = r113;
        r109 = r117;
        goto L28
    L18:
        ResultKt.throwOnFailure(r102);
        r100.L$0 = this;
        r116 = r110;
        r100.L$1 = r116;
        r100.L$2 = r111;
        r100.L$3 = r112;
        r100.L$4 = r210;
        r100.label = 1;
        if (c(r100) != r103) goto L21;
        return r103;
    L21:
        r117 = this;
        r115 = r111;
        r114 = r112;
        r113 = r210;
    L7:
        r100 = new ResultWrapper$startActivityForResultInner$1(this, r211);
        goto L8
    }
}
