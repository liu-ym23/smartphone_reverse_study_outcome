package com.obric.capability.schedulekit;

import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f396039a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f396040b = null;

    public c() {
    }

    static {
        f396039a = new c();
        f396040b = new ConcurrentHashMap();
    }

    public static int b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return 0;
    L11:
        Integer r102 = f396040b.get(r100);
        if (r102 != null) goto L14;
        uia.a.f550220a.getClass();
        throw new IllegalStateException("app module must call Apphost.setApphost()");
    L14:
        return r102.intValue();
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final Object a(Continuation r100) {
        if ((r100 instanceof IntentSdkVersionResolver$getSdkVersionByIntent$1) == false) goto L7;
        IntentSdkVersionResolver$getSdkVersionByIntent$1 r101 = (IntentSdkVersionResolver$getSdkVersionByIntent$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L33;
        if (r104 != 1) goto L32;
        String r106 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        List r107 = (List) r103;
        List r108 = r107;
        if (r108 != null) goto L14;
    L17:
        if (r105 == false) goto L20;
        via.b r109 = via.b.f555361a;
        Intrinsics.checkNotNullParameter("IntentSdkVersionResolver", "tag");
        int r110 = via.a.f555360a;
        Intrinsics.checkNotNullParameter("ac_".concat("IntentSdkVersionResolver"), "tag");
        return Boxing.boxInt(0);
    L20:
        Iterator r111 = r107.iterator();
        if (r111.hasNext() == false) goto L30;
        Integer r112 = Boxing.boxInt(b(((AppIntentImplInfo) r111.next()).getPackageName()));
    L24:
        if (r111.hasNext() == false) goto L28;
        Integer r113 = Boxing.boxInt(b(((AppIntentImplInfo) r111.next()).getPackageName()));
        if (r112.compareTo(r113) >= 0) goto L24;
        r112 = r113;
        goto L24
    L28:
        return r112;
    L30:
        throw new NoSuchElementException();
    L14:
        if (r108.isEmpty() == true) goto L17;
        r105 = false;
        goto L17
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L33:
        ResultKt.throwOnFailure(r103);
        CoroutineScope r114 = b.f396036a;
        final String r115 = null;
        r101.L$0 = null;
        r101.label = 1;
        final j r116 = new j(IntrinsicsKt.intercepted(r101), 1);
        r116.C();
        new CapabilityScheduleSdk$queryAppIntents$2$1(r115, r116);
        b.a();
        throw null;
    L7:
        r101 = new IntentSdkVersionResolver$getSdkVersionByIntent$1(this, r100);
        goto L8
    }
}
