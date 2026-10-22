package iuc;

import bytedance.jvm.time.LocalTime;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.format.s0;
import kotlinx.datetime.format.y0;
import luc.n;
import nuc.m2;

/* JADX INFO: loaded from: classes42.dex */
public final class e implements juc.d<fuc.g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f495912a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f495913b = null;

    public e() {
    }

    static {
        f495912a = new e();
        f495913b = n.a("kotlinx.datetime.LocalTime", luc.e.i.f510857a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f495913b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        fuc.g.a r101 = fuc.g.Companion;
        String r102 = r100.decodeString();
        int r103 = fuc.g.b.f478938a;
        Lazy r104 = y0.f505249a;
        s0 r105 = (s0) r104.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "input");
        Intrinsics.checkNotNullParameter(r105, SubInfo.KEY_FORMAT);
        if (r105 != ((s0) r104.getValue())) goto L10;
        return new fuc.g(LocalTime.parse(r102));
    L6:
        e = move-exception;
        throw new DateTimeFormatException(e);
    L10:
        return r105.a(r102);
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        fuc.g r102 = (fuc.g) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.encodeString(r102.toString());
    }
}
