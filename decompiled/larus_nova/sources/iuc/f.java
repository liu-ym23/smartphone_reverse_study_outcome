package iuc;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.ZoneId;
import fuc.h;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.IllegalTimeZoneException;
import luc.n;
import nuc.m2;

/* JADX INFO: loaded from: classes42.dex */
public final class f implements juc.d<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f495914a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f495915b = null;

    public f() {
    }

    static {
        f495914a = new f();
        f495915b = n.a("kotlinx.datetime.TimeZone", luc.e.i.f510857a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f495915b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        h.a r101 = h.Companion;
        String r102 = r100.decodeString();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "zoneId");
        return h.a.a(ZoneId.of(r102));
    L5:
        e = move-exception;
        if ((e instanceof DateTimeException) == true) goto L9;
        throw e;
    L9:
        throw new IllegalTimeZoneException(e);
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        h r102 = (h) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.encodeString(r102.f478940a.getId());
    }
}
