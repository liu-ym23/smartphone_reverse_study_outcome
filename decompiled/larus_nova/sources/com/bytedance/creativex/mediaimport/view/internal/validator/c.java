package com.bytedance.creativex.mediaimport.view.internal.validator;

import android.net.Uri;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import ti4.a0;

/* JADX INFO: loaded from: classes15.dex */
public abstract class c<DATA> implements a0<DATA>, d<DATA> {
    @Override // ti4.a0
    public final void a() {
    }

    @Override // ti4.a0
    public final boolean b() {
        return false;
    }

    @Override // ti4.a0
    public final void c() {
    }

    @Override // ti4.a0
    public final Object d(DATA r100, List<? extends DATA> r101, List<? extends DATA> r102, List<? extends DATA> r103, boolean r104, Continuation<? super Boolean> r105) {
        return e(this, r100, r104, r105);
    }

    public static /* synthetic */ Object e(c r100, Object r101, boolean r102, Continuation r103) {
        if ((r103 instanceof ExistsPreValidator$preCheck$1) == false) goto L7;
        ExistsPreValidator$preCheck$1 r104 = (ExistsPreValidator$preCheck$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r102 = r104.Z$0;
        r100 = (c) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L18:
        if (((Boolean) r106).booleanValue() == false) goto L25;
        if (r102 == false) goto L21;
        r100.getClass();
        throw null;
    L21:
        return Boxing.boxBoolean(false);
    L25:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        Uri r109 = r100.getUri(r101);
        String r110 = r100.getPath(r101);
        CoroutineDispatcher r111 = Dispatchers.getIO();
        ExistsPreValidator$preCheck$2 r112 = new ExistsPreValidator$preCheck$2(r110, r109, null);
        r104.L$0 = r100;
        r104.Z$0 = r102;
        r104.label = 1;
        r106 = BuildersKt.withContext(r111, r112, r104);
        if (r106 != r107) goto L18;
        return r107;
    L7:
        r104 = new ExistsPreValidator$preCheck$1(r100, r103);
        goto L8
    }
}
