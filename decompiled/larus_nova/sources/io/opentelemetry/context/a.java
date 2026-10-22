package io.opentelemetry.context;

import javax.annotation.Nullable;
import jtc.l;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f492696b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f492697a;

    static {
        f492696b = new a(new Object[0]);
    }

    @Override // io.opentelemetry.context.b
    @Nullable
    public final Object get() {
        f r100 = l.f500399a;
        int r101 = 0;
    L3:
        Object[] r102 = this.f492697a;
        if (r101 >= r102.length) goto L10;
        if (r102[r101] == r100) goto L8;
        r101 = r101 + 2;
        goto L3
    L8:
        return r102[r101 + 1];
    L10:
        return null;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{");
        int r101 = 0;
    L3:
        Object[] r102 = this.f492697a;
        if (r101 >= r102.length) goto L7;
        r100.append(r102[r101]);
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        r100.append(this.f492697a[r101 + 1]);
        r100.append(", ");
        r101 = r101 + 2;
        goto L3
    L7:
        if (r100.length() <= 1) goto L9;
        r100.setLength(r100.length() - 2);
    L9:
        r100.append('}');
        return r100.toString();
    }

    public a(Object[] r100) {
        this.f492697a = r100;
    }
}
