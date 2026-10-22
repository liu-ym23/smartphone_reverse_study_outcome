package itc;

import java.util.Comparator;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends io.opentelemetry.api.internal.g<f<?>, Object> implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Comparator<f<?>> f495766c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f495767d = null;

    static {
        f495766c = Comparator.comparing(new a());
        f495767d = new d().a();
    }

    public b(Object[] r100) {
        super(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Object[] r100, Comparator<f<?>> r101) {
        if ((r100.length % 2) != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L30;
        if (r100.length == 0) goto L27;
        Object[] r103 = new Object[r100.length];
        System.arraycopy(r100, 0, r103, 0, r100.length);
        io.opentelemetry.api.internal.g.a(r103, 0, r100.length, r100, r101);
        Object r104 = null;
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r105 >= r100.length) goto L25;
        Object r107 = r100[r105];
        Object r108 = r100[r105 + 1];
        if (r107 == null) goto L23;
        if (r104 != null) goto L18;
    L20:
        if (r108 != null) goto L22;
        r104 = null;
        goto L23
    L22:
        int r109 = r106 + 1;
        r100[r106] = r107;
        r106 = r109 + 1;
        r100[r109] = r108;
        r104 = r107;
        goto L23
    L18:
        if (r101.compare(r107, r104) != 0) goto L20;
        r106 = r106 - 2;
    L23:
        r105 = r105 + 2;
        goto L12
    L25:
        if (r100.length == r106) goto L27;
        Object[] r110 = new Object[r106];
        System.arraycopy(r100, 0, r110, 0, r106);
        r100 = r110;
    L27:
        super(r100);
        return;
    L30:
        throw new IllegalArgumentException("You must provide an even number of key/value pair arguments.");
    L5:
        r102 = false;
        goto L6
    }
}
