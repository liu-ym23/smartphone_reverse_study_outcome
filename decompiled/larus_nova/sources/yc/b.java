package yc;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final <T> T a(Class<T> r100) {
        Iterator<a.C8324a> r101 = a.f567111a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        a.C8324a r102 = r101.next();
        if (Intrinsics.areEqual(r102.f567114b, r100) == false) goto L4;
    L10:
        if (r102 == null) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L84;
        Function0 r104 = (Function0) ((LinkedHashMap) a.f567112b).get(r100);
        if (r104 == null) goto L84;
        r104.invoke();
    L84:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L70
        Iterator<a.C8324a> r106 = a.f567111a.iterator();     // Catch: Throwable -> L70
    L19:
        if (r106.hasNext() == false) goto L23;
        a.C8324a r107 = r106.next();     // Catch: Throwable -> L70
        if (Intrinsics.areEqual(r107.f567114b, r100) == false) goto L19;
    L24:
        a.C8324a r108 = r107;     // Catch: Throwable -> L70
        if (r108 == null) goto L68;
        Class<?> r109 = r108.f567114b;     // Catch: Throwable -> L70
        monitor-enter(r109);     // Catch: Throwable -> L70
        CopyOnWriteArrayList<a.C8324a> r110 = a.f567111a;     // Catch: Throwable -> L65
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L65
        Iterator<a.C8324a> r112 = r110.iterator();     // Catch: Throwable -> L65
    L30:
        if (r112.hasNext() == false) goto L35;
        a.C8324a r113 = r112.next();     // Catch: Throwable -> L65
        if (Intrinsics.areEqual(r113.f567114b, r100) == false) goto L30;
        r111.add(r113);     // Catch: Throwable -> L65
        goto L30
    L35:
        if (r111.isEmpty() == false) goto L39;
        monitor-exit(r109);     // Catch: Throwable -> L70
    L74:
        Object r114 = null;
    L76:
        if ((r114 instanceof Object) == true) goto L79;
        return null;
    L79:
        return (T) r114;
    L39:
        if (r111.size() != 1) goto L41;
        a.C8324a r115 = (a.C8324a) r111.get(0);     // Catch: Throwable -> L65
    L53:
        if (r115.f567116d != null) goto L62;
        String r116 = r115.f567115c.getName();     // Catch: Throwable -> L65
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L57
        Constructor<T> r118 = a.a(r116).getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L57
        r118.setAccessible(true);     // Catch: Throwable -> L57
        Object r119 = r118.newInstance(new Object[0]);     // Catch: Throwable -> L57
    L61:
        r115.f567116d = r119;     // Catch: Throwable -> L65
        goto L62
    L57:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L65
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L65
        if (Result.m9455isFailureimpl(r119) == false) goto L61;
        r119 = null;
    L62:
        r114 = r115.f567116d;     // Catch: Throwable -> L65
        monitor-exit(r109);     // Catch: Throwable -> L70
        goto L76
    L41:
        Iterator r121 = r111.iterator();     // Catch: Throwable -> L65
    L43:
        if (r121.hasNext() == false) goto L47;
        Object r122 = r121.next();     // Catch: Throwable -> L65
        if ((!((a.C8324a) r122).f567113a) == false) goto L43;
    L48:
        r115 = (a.C8324a) r122;     // Catch: Throwable -> L65
        if (r115 != null) goto L53;
        r115 = (a.C8324a) r111.get(0);     // Catch: Throwable -> L65
        goto L53
    L47:
        r122 = null;
    L65:
        th = move-exception;
        throw th;     // Catch: Throwable -> L70
    L68:
        r114 = Result.m9449constructorimpl(null);     // Catch: Throwable -> L70
    L73:
        if (Result.m9455isFailureimpl(r114) == false) goto L76;
    L23:
        r107 = null;
    L70:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L73
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = null;
        goto L10
    }
}
