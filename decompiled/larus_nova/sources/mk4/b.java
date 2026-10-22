package mk4;

import com.bytedance.dora.device.DoraDevice;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514305a = 0;

    static {
    }

    public static a a(nk4.b r100) {
        DoraDevice r101 = kj4.a.g().c();
        if (r101 != null) goto L5;
        List r102 = Collections.emptyList();
    L7:
        if ((r100 instanceof nk4.c) == false) goto L11;
        return new a(r100, r102, d.a(d.b(((nk4.c) r100).f519480a)));
    L11:
        return new a(r100, r102, Collections.emptyList());
    L5:
        r102 = Collections.singletonList(r101);
        goto L7
    }
}
