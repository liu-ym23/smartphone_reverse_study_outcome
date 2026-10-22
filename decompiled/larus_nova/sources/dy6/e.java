package dy6;

import android.os.Bundle;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.utils.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f470544a;

    public abstract T c(String r100);

    public e() {
        this.f470544a = null;
    }

    public T b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof String) == false) goto L5;
        String r101 = (String) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return c(r101);
    L5:
        r101 = null;
        goto L6
    }

    public final void a(Bundle r100, String r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r103 = r100.get(r101);
        if (r103 == null) goto L10;
        T r104 = b(r103);
        this.f470544a = r104;
        if (r104 == null) goto L7;
        return;
    L7:
        String r105 = r103.toString();
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r105, "value");
        gq6.a r106 = l.e(Dito.f257280a);
        if (r106 == null) goto L10;
        r106.getLogService();
        en6.e.f473169a.b("DitoContainerParam", "parse value:" + r105 + " for key:" + r101 + " with error");
    L10:
        this.f470544a = r102;
    }
}
