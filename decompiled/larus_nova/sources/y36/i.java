package y36;

import android.os.Bundle;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class i<T> implements t36.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f565861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f565862b;

    public abstract T d(String r100);

    public i(T r100) {
        this.f565862b = r100;
    }

    public T c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof String) == false) goto L5;
        String r101 = (String) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return d(r101);
    L5:
        r101 = null;
        goto L6
    }

    public final void b(t36.d r100, String r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        com.bytedance.ies.bullet.service.sdk.d r103 = (com.bytedance.ies.bullet.service.sdk.d) r100;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "key");
        String r104 = (String) ((LinkedHashMap) r103.f248139p).get(r101);
        if (r104 == null) goto L9;
        T r105 = d(r104);
        this.f565862b = r105;
        if (r105 == null) goto L8;
        this.f565861a = true;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r104, "value");
        r103.f248137n.put(r101, r104);
    L9:
        Bundle r106 = r103.f248125b;
        if (r106 == null) goto L18;
        Object r107 = r106.get(r101);
        if (r107 == null) goto L18;
        T r108 = c(r107);
        this.f565862b = r108;
        if (r108 == null) goto L17;
        this.f565861a = true;
        return;
    L17:
        String r109 = r107.toString();
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r109, "value");
        r103.f248137n.put(r101, r109);
    L18:
        this.f565862b = r102;
    }
}
