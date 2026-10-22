package sb9;

import com.larus.home.impl.main.side_bar.data.j0;
import eb9.o;
import eb9.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f541259a = null;

    static {
        f541259a = new a();
    }

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eb9.v
    public final boolean a(o<?> r100, o<?> r110) {
        Intrinsics.checkNotNullParameter(r100, "oldItem");
        Intrinsics.checkNotNullParameter(r110, "newItem");
        DATA r101 = r100.f471909c;
        j0 r102 = null;
        if ((r101 instanceof j0) == false) goto L5;
        j0 r103 = (j0) r101;
    L7:
        if (r103 != null) goto L9;
        return false;
    L9:
        DATA r104 = r110.f471909c;
        if ((r104 instanceof j0) == false) goto L12;
        r102 = (j0) r104;
    L12:
        if (r102 != null) goto L15;
        return false;
    L15:
        if (r100.f471914h != r110.f471914h) goto L20;
        int r105 = b.f541260a;
        if (b.a(j0.b(r103, r100.f471911e), j0.b(r102, r110.f471911e)) == false) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L5:
        r103 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eb9.v
    public final boolean b(o<?> r100, o<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "oldItem");
        Intrinsics.checkNotNullParameter(r101, "newItem");
        DATA r102 = r100.f471909c;
        j0 r103 = null;
        if ((r102 instanceof j0) == false) goto L5;
        j0 r104 = (j0) r102;
    L7:
        if (r104 != null) goto L9;
        return false;
    L9:
        DATA r105 = r101.f471909c;
        if ((r105 instanceof j0) == false) goto L12;
        r103 = (j0) r105;
    L12:
        if (r103 != null) goto L14;
        return false;
    L14:
        int r106 = b.f541260a;
        return b.b(r104, r103);
    L5:
        r104 = null;
        goto L7
    }
}
