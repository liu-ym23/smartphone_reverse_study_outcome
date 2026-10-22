package sb0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f541205a;

    public a() {
        this.f541205a = null;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) {
        b r103 = this.f541205a;
        if (r103 != null) goto L6;
        return null;
    L6:
        if (r102 == null) goto L13;
        if (r101 == null) goto L9;
        Object r104 = r101.invoke(r103, new Object[]{this});
    L10:
        if (r104 == null) goto L13;
        return r104;
    L9:
        r104 = null;
    L13:
        if (r101 != null) goto L15;
        return null;
    L15:
        return r101.invoke(this.f541205a, new Object[0]);
    }
}
