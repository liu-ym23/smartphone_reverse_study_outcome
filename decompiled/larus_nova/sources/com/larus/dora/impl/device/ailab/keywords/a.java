package com.larus.dora.impl.device.ailab.keywords;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f333555a = 0;

    static {
    }

    public static final String a(DoraWakeupKeywords r100, String r101) {
        List<DoraWakeupKeyword> r102 = r100.getWakeupKeywords();
        DoraWakeupKeyword r103 = null;
        Object r104 = null;
        if (r102 == null) goto L16;
        Iterator<T> r105 = r102.iterator();
    L6:
        if (r105.hasNext() == false) goto L14;
        Object r106 = r105.next();
        DoraWakeupKeyword r107 = (DoraWakeupKeyword) r106;
        if (r107 == null) goto L10;
        String r108 = r107.getKeyword();
    L12:
        if (Intrinsics.areEqual(r108, r101) == false) goto L6;
        r104 = r106;
        goto L14
    L10:
        r108 = null;
    L14:
        r103 = (DoraWakeupKeyword) r104;
    L16:
        if (r103 == null) goto L35;
        Integer r109 = r103.getStatus();
        if (r109 != null) goto L22;
    L24:
        if (r109 != null) goto L27;
        return "none";
    L27:
        if (r109.intValue() != 0) goto L34;
        return "off";
    L34:
        return "none";
    L22:
        if (r109.intValue() != 1) goto L24;
        return "on";
    L35:
        return "none";
    }
}
