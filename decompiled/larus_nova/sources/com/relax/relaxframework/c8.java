package com.relax.relaxframework;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c8 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c8 f405039e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Function0<Unit>> f405040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<Function1<Long, Unit>> f405041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.rts.foundation.s f405042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f405043d;

    public static final class a {
    }

    static {
    }

    public final void a() {
    L2:
        IntCompanionObject r100 = IntCompanionObject.INSTANCE;
        int r101 = com.bytedance.rts.foundation.j.d(this.f405040a);
        com.bytedance.rts.foundation.k.c(r100, r101);
        Object r102 = null;
        if (r101 <= 0) goto L8;
        ArrayList<Function0<Unit>> r103 = this.f405040a;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if ((!r103.isEmpty()) == false) goto L7;
        r102 = ListProtector.remove(r103, 0);
    L7:
        Intrinsics.checkNotNull(r102);
        ((Function0) r102).invoke();
        goto L2
    L8:
        this.f405042c = null;
    }

    public c8() {
        this.f405040a = com.bytedance.rts.foundation.j.k(new Function0[0]);
        this.f405041b = com.bytedance.rts.foundation.j.k(new Function1[0]);
    }
}
