package com.larus.common.location.impl.settings;

import com.bytedance.keva.Keva;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f326367a;

    public static final class a {
    }

    static {
    }

    public final Keva b() {
        return (Keva) this.f326367a.getValue();
    }

    public d() {
        this.f326367a = LazyKt.lazy(new c());
    }

    public final boolean a() {
        long r100 = b().getLong("LCT", 0);
        Calendar r101 = Calendar.getInstance();
        r101.setTimeInMillis(r100);
        int r102 = r101.get(6);
        int r103 = r101.get(1);
        Calendar r104 = Calendar.getInstance();
        int r105 = r104.get(6);
        int r106 = r104.get(1);
        if (r102 != r105) goto L6;
        if (r103 != r106) goto L6;
        boolean r107 = true;
    L7:
        if (r107 == true) goto L9;
        b().erase("CLC");
        b().erase("HLC");
        return true;
    L9:
        return false;
    L6:
        r107 = false;
        goto L7
    }
}
