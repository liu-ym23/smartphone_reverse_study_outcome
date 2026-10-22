package com.larus.im.internal.database.slowtask.index;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public abstract class AbsDBIndexOperator {
    public AbsDBIndexOperator() {
    }

    public abstract Object a(String r100, String r101, List<String> r102, Continuation<? super Boolean> r103);

    public abstract Object b(String r100, String r101, String r102, Continuation<? super Boolean> r103);

    public abstract Object d(String r100, ContinuationImpl r101);

    public abstract Object e(String r100, Continuation<? super List<String>> r101);

    public abstract String f();

    public abstract Object g(String r100, Continuation<? super Boolean> r101);

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0113 -> B:50:0x0118). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0132 -> B:76:0x0135). Please report as a decompilation issue!!! */
    public final Object c(Map<String, ? extends List<String>> r110, Continuation<? super Integer> r111) {
        if ((r111 instanceof AbsDBIndexOperator$dropAllCustomIndexes$1) == false) goto L7;
        AbsDBIndexOperator$dropAllCustomIndexes$1 r100 = (AbsDBIndexOperator$dropAllCustomIndexes$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        AbsDBIndexOperator r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        int r106 = 1;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L17;
        if (r105 != 2) goto L16;
        Iterator r107 = (Iterator) r100.L$3;
        Iterator r108 = (Iterator) r100.L$2;
        Ref.IntRef r109 = (Ref.IntRef) r100.L$1;
        AbsDBIndexOperator r112 = (AbsDBIndexOperator) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L65
        AbsDBIndexOperator r113 = r102;
    L76:
        r109.element++;     // Catch: Throwable -> L57
    L51:
        if (r107.hasNext() == false) goto L59;
        String r114 = (String) r107.next();     // Catch: Throwable -> L57
        r100.L$0 = r112;     // Catch: Throwable -> L57
        r100.L$1 = r109;     // Catch: Throwable -> L57
        r100.L$2 = r108;     // Catch: Throwable -> L57
        r100.L$3 = r107;     // Catch: Throwable -> L57
        r100.label = 2;     // Catch: Throwable -> L57
        if (r112.d(r114, r100) != r104) goto L76;
        return r104;
    L59:
        AbsDBIndexOperator r115 = r113;
        r106 = 1;
    L74:
    L61:
        th = th;
    L67:
        Result.Companion r116 = Result.Companion;
        Object r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L68:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L83;
        com.larus.im.internal.delegate.a.f348188b.e(r115.f(), "dropAllCustomIndexes failed:" + r118);
        return Boxing.boxInt(0);
    L83:
        return r117;
    L24:
        if (r108.hasNext() == false) goto L63;
        Map.Entry r119 = (Map.Entry) r108.next();     // Catch: Throwable -> L61
        String r120 = (String) r119.getKey();     // Catch: Throwable -> L61
        List r121 = (List) r119.getValue();     // Catch: Throwable -> L61
        r100.L$0 = r112;     // Catch: Throwable -> L61
        r100.L$1 = r109;     // Catch: Throwable -> L61
        r100.L$2 = r108;     // Catch: Throwable -> L61
        r100.L$3 = r121;     // Catch: Throwable -> L61
        r100.label = r106;     // Catch: Throwable -> L61
        Object r122 = r112.e(r120, r100);     // Catch: Throwable -> L61
        if (r122 != r104) goto L28;
        return r104;
    L28:
        Iterator r123 = r108;
        List r124 = r121;
        r103 = r122;
        AbsDBIndexOperator r125 = r112;
        Ref.IntRef r126 = r109;
        Iterator r127 = r123;
    L29:
        ArrayList r128 = new ArrayList();     // Catch: Throwable -> L61
        Iterator r129 = ((Iterable) r103).iterator();     // Catch: Throwable -> L61
    L31:
        if (r129.hasNext() == false) goto L49;
        Object r130 = r129.next();     // Catch: Throwable -> L61
        String r131 = (String) r130;     // Catch: Throwable -> L61
        List r132 = r124;     // Catch: Throwable -> L61
        if ((r132 instanceof Collection) == true) goto L35;
    L37:
        Iterator r133 = r132.iterator();     // Catch: Throwable -> L61
    L39:
        if (r133.hasNext() == false) goto L44;
        Iterator r134 = r129;
        if (StringsKt.startsWith$default(r131, (String) r133.next(), false, 2, null) == true) goto L42;
        r129 = r134;
        goto L39
    L42:
        boolean r135 = true;
    L45:
        if (r135 == false) goto L47;
        r128.add(r130);     // Catch: Throwable -> L61
    L47:
        r129 = r134;
    L44:
        r134 = r129;
        r135 = false;
        goto L45
    L35:
        if (r132.isEmpty() == false) goto L37;
    L49:
        r113 = r115;
        r108 = r127;
        r109 = r126;
        r112 = r125;
        r107 = r128.iterator();     // Catch: Throwable -> L61
        goto L51
    L63:
        r117 = Result.m9449constructorimpl(Boxing.boxInt(r109.element));     // Catch: Throwable -> L61
    L57:
        th = th;
        r115 = r113;
        goto L67
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        List r136 = (List) r100.L$3;
        Iterator r137 = (Iterator) r100.L$2;
        Ref.IntRef r138 = (Ref.IntRef) r100.L$1;
        AbsDBIndexOperator r139 = (AbsDBIndexOperator) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L65
        r125 = r139;
        r126 = r138;
        r127 = r137;
        r124 = r136;
        r115 = r102;
        goto L29
    L20:
        ResultKt.throwOnFailure(r103);
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L65
        com.larus.im.internal.delegate.a.f348188b.i(f(), "dropAllCustomIndexes");     // Catch: Throwable -> L65
        r109 = new Ref.IntRef();     // Catch: Throwable -> L65
        r112 = r102;
        r108 = ((LinkedHashMap) r110).entrySet().iterator();     // Catch: Throwable -> L65
        r115 = r112;
    L65:
        th = th;
        r115 = r102;
    L7:
        r102 = this;
        r100 = new AbsDBIndexOperator$dropAllCustomIndexes$1(r102, r111);
        goto L8
    }
}
