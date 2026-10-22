package com.larus.bmhome.chat.layout.holder.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;

/* JADX INFO: loaded from: classes25.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f303681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f303682b = null;

    static {
        f303681a = LazyKt.lazy(new p0());
        f303682b = LazyKt.lazy(new q0());
    }

    public static List a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return null;
    L11:
        Lazy r102 = f303682b;
        if (((Number) r102.getValue()).intValue() >= 0) goto L14;
        int r103 = Integer.MAX_VALUE;
    L16:
        if (r100.length() <= r103) goto L18;
        return null;
    L18:
        Matcher r104 = ((Pattern) f303681a.getValue()).matcher(r100);
        ArrayList r105 = new ArrayList();
    L20:
        if (r104.find() == false) goto L22;
        int r106 = r104.start();
        int r107 = r104.end();
        String r108 = r104.group();
        r105.add(new Triple(Integer.valueOf(r106), Integer.valueOf(r107), r108));
        goto L20
    L22:
        return r105;
    L14:
        r103 = ((Number) r102.getValue()).intValue();
        goto L16
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }
}
