package iuc;

import bytedance.jvm.time.format.DateTimeFormatter;
import com.ss.ttvideoengine.model.SubInfo;
import fuc.j;
import fuc.o;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.f1;
import kotlinx.datetime.format.v1;
import luc.n;
import nuc.m2;

/* JADX INFO: loaded from: classes42.dex */
public final class g implements juc.d<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f495916a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f495917b = null;

    public g() {
    }

    static {
        f495916a = new g();
        f495917b = n.a("kotlinx.datetime.UtcOffset", luc.e.i.f510857a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f495917b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        j.a r101 = j.Companion;
        String r102 = r100.decodeString();
        int r103 = j.b.f478942a;
        Lazy r104 = v1.f505242a;
        f1 r105 = (f1) r104.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "input");
        Intrinsics.checkNotNullParameter(r105, SubInfo.KEY_FORMAT);
        if (r105 != ((f1) r104.getValue())) goto L6;
        return o.a(r102, (DateTimeFormatter) o.f478943a.getValue());
    L6:
        if (r105 != ((f1) v1.f505243b.getValue())) goto L9;
        return o.a(r102, (DateTimeFormatter) o.f478944b.getValue());
    L9:
        if (r105 != ((f1) v1.f505244c.getValue())) goto L12;
        return o.a(r102, (DateTimeFormatter) o.f478945c.getValue());
    L12:
        return r105.a(r102);
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        j r102 = (j) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.encodeString(r102.toString());
    }
}
