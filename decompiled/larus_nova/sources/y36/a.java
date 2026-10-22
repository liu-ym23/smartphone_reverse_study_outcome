package y36;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends i<Boolean> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        Boolean r100 = (Boolean) this.f565862b;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.booleanValue() == false) goto L7;
        return "1";
    L7:
        return "0";
    }

    public a(Boolean r100) {
        super(r100);
    }

    public static Boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        int r101 = r100.hashCode();
        if (r101 == 48) goto L22;
        if (r101 == 49) goto L18;
        if (r101 == 3569038) goto L15;
        if (r101 == 97196323) goto L12;
    L23:
        return null;
    L12:
        if (r100.equals("false") == false) goto L23;
    L25:
        return Boolean.FALSE;
    L15:
        if (r100.equals("true") == false) goto L23;
    L26:
        return Boolean.TRUE;
    L18:
        if (r100.equals("1") == true) goto L26;
    L22:
        if (r100.equals("0") == true) goto L25;
        goto L23
    }

    @Override // y36.i
    public final Boolean c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof Boolean) == false) goto L5;
        Boolean r101 = (Boolean) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return (Boolean) super.c(r100);
    L5:
        r101 = null;
        goto L6
    }

    @Override // y36.i
    public final /* bridge */ /* synthetic */ Boolean d(String r100) {
        return e(r100);
    }

    public a(t36.d r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        super(null);
        b(r100, r101, r102);
    }
}
