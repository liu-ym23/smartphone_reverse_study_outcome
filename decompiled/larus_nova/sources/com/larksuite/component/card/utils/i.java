package com.larksuite.component.card.utils;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes24.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f283984a = 0;

    static {
    }

    public static long a(Date r100) {
        Calendar r101 = Calendar.getInstance();
        if (r100 == null) goto L5;
        r101.setTime(r100);
    L5:
        Calendar r102 = Calendar.getInstance();
        r102.set(11, r101.get(11));
        r102.set(12, r101.get(12));
        r102.set(13, 0);
        r102.set(14, 0);
        return r102.getTimeInMillis();
    }
}
