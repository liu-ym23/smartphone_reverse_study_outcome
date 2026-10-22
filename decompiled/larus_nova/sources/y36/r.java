package y36;

import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class r extends i<Integer> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f565864c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        Integer r100 = (Integer) this.f565862b;
        if (r100 == null) goto L18;
        int r101 = r100.intValue();
        int r102 = q.f565863a;
        boolean r103 = Intrinsics.areEqual(this.f565864c, Boolean.TRUE);
        Map<String, Map<Class<?>, Object>> r104 = x26.a.f562251a;
        w26.g r105 = (w26.g) x26.a.a(w26.g.class);
        if (r105 == null) goto L11;
        w26.e r106 = (w26.e) r105.n0(w26.e.class);
        if (r106 == null) goto L11;
        Boolean r107 = r106.g2();
        if (r107 == null) goto L11;
        boolean r108 = r107.booleanValue();
    L12:
        if (r108 == false) goto L14;
        StringCompanionObject r109 = StringCompanionObject.INSTANCE;
        String r110 = String.format("%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r101)}, 1));
    L15:
        if (r103 == false) goto L20;
        return r110;
    L20:
        return StringsKt.takeLast(r110, 6) + StringsKt.dropLast(r110, 6);
    L14:
        r110 = Integer.toHexString(r101);
    L11:
        r108 = true;
        goto L12
    L18:
        return null;
    }

    public r(Integer r100) {
        super(r100);
        this.f565864c = Boolean.FALSE;
    }

    @Override // y36.i
    public final Integer d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        int r101 = q.f565863a;
        return q.a(r100, Intrinsics.areEqual(this.f565864c, Boolean.TRUE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(t36.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        this(null);
        this.f565864c = (Boolean) new a(r100, "use_argb", Boolean.FALSE).f565862b;
        b(r100, r101, null);
    }
}
