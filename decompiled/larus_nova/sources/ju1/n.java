package ju1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f500412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f500413b;

    public final boolean a() {
        Object r100 = c();
        if ((r100 instanceof Boolean) == true) goto L5;
        r100 = null;
    L5:
        Boolean r101 = (Boolean) r100;
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    }

    public Object c() {
        return this.f500412a;
    }

    public final int b(int r100) {
        Object r101 = c();
        if ((r101 instanceof Number) == true) goto L5;
        r101 = null;
    L5:
        Number r102 = (Number) r101;
        if (r102 != null) goto L8;
        return r100;
    L8:
        return r102.intValue();
    }

    public final String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "default");
        Object r101 = c();
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        String r102 = (String) r101;
        if (r102 != null) goto L9;
        return r100;
    L9:
        return r102;
    }

    public n(Object r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f500412a = r100;
        this.f500413b = r101;
    }
}
