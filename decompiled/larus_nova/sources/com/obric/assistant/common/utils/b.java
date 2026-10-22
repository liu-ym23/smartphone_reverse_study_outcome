package com.obric.assistant.common.utils;

import android.system.Os;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f387875a = null;

    static {
        f387875a = new b();
    }

    public b() {
    }

    public static boolean a(String r110, Function1 r111, Function1 r112) {
        Intrinsics.checkNotNullParameter(r110, "path");
        Intrinsics.checkNotNullParameter(r111, "onUpdated");
        Intrinsics.checkNotNullParameter(r112, LynxVideoManagerLite.EVENT_ON_ERROR);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L24
        String r101 = Os.getenv("ADSP_LIBRARY_PATH");     // Catch: Throwable -> L24
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        List r102 = StringsKt.split$default(r101, new String[]{com.alipay.sdk.m.u.i.f25853b}, false, 0, 6, null);     // Catch: Throwable -> L24
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L24
        Iterator r104 = r102.iterator();     // Catch: Throwable -> L24
    L8:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();     // Catch: Throwable -> L24
        if ((true ^ StringsKt.isBlank((String) r105)) == false) goto L8;
        r103.add(r105);     // Catch: Throwable -> L24
        goto L8
    L13:
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(r103), r110) == true) goto L22;
        List r106 = CollectionsKt.listOf(r110);     // Catch: Throwable -> L24
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L24
        Iterator r108 = r103.iterator();     // Catch: Throwable -> L24
    L17:
        if (r108.hasNext() == false) goto L21;
        Object r109 = r108.next();     // Catch: Throwable -> L24
        if ((!Intrinsics.areEqual((String) r109, r110)) == false) goto L17;
        r107.add(r109);     // Catch: Throwable -> L24
        goto L17
    L21:
        String r113 = CollectionsKt.joinToString$default(CollectionsKt.plus(r106, r107), com.alipay.sdk.m.u.i.f25853b, null, null, 0, null, null, 62, null);     // Catch: Throwable -> L24
        Os.setenv("ADSP_LIBRARY_PATH", r113, true);     // Catch: Throwable -> L24
        r111.invoke(r113);     // Catch: Throwable -> L24
    L22:
        Object r114 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L24
    L26:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L29;
        r112.invoke(r115);
    L29:
        Boolean r116 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r114) == false) goto L33;
        r114 = r116;
    L33:
        return ((Boolean) r114).booleanValue();
    L24:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }
}
