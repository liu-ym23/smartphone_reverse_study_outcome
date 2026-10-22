package d37;

import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements e37.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f466745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e37.e f466746b = null;

    public f() {
    }

    static {
        f466745a = new f();
        int r100 = w27.e.f558039a;
        e37.f r101 = w27.f.f558040a;
        if (r101 == null) goto L5;
        com.larus.navigation.impl.platform.l r102 = r101.a();
    L6:
        f466746b = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // e37.e
    public final Object a(String r100, String r101, Map r102, Map r110, Continuation r111) {
        e37.e r103 = f466746b;
        if (r103 != null) goto L5;
        return null;
    L5:
        return r103.a(r100, r101, r102, r110, r111);
    }

    @Override // e37.e
    public final Object b(String r100, String r101, Map r110, String r111, Map r112, ContinuationImpl r113) {
        e37.e r102 = f466746b;
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.b(r100, r101, r110, r111, r112, r113);
    }
}
