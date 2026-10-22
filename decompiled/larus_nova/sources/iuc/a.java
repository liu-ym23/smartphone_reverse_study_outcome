package iuc;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.ZoneId;
import fuc.h;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.IllegalTimeZoneException;
import kotlinx.serialization.SerializationException;
import luc.n;
import nuc.m2;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements juc.d<fuc.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f495904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f495905b = null;

    public a() {
    }

    static {
        f495904a = new a();
        f495905b = n.a("kotlinx.datetime.FixedOffsetTimeZone", luc.e.i.f510857a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f495905b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        h.a r101 = h.Companion;
        String r102 = r100.decodeString();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "zoneId");
        h r103 = h.a.a(ZoneId.of(r102));     // Catch: Exception -> L10
        if ((r103 instanceof fuc.c) == false) goto L9;
        return (fuc.c) r103;
    L9:
        throw new SerializationException("Timezone identifier '" + r103 + "' does not correspond to a fixed-offset timezone");
    L10:
        e = move-exception;
        if ((e instanceof DateTimeException) == true) goto L14;
        throw e;
    L14:
        throw new IllegalTimeZoneException(e);
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        fuc.c r102 = (fuc.c) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.encodeString(r102.f478940a.getId());
    }
}
