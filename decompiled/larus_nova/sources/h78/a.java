package h78;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m58.h;
import m58.t;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<b> f483996a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<b> f483997b = null;

    static {
        ArrayList r100 = new ArrayList();
        f483996a = r100;
        ArrayList r101 = new ArrayList();
        f483997b = r101;
        t r102 = h.f512142m;
        if (r102 == null) goto L8;
        o58.a r103 = r102.a();
        if (r103 == null) goto L8;
        List<String> r104 = r103.f522105b;
        if (r104 == null) goto L8;
    L9:
        c r105 = new c(r104);
        Intrinsics.checkNotNullParameter(r105, com.heytap.mcssdk.constant.b.f276366p);
        r101.add(r105);
        t r106 = h.f512142m;
        if (r106 == null) goto L15;
        o58.a r107 = r106.a();
        if (r107 == null) goto L15;
        List<String> r108 = r107.f522104a;
        if (r108 == null) goto L15;
    L16:
        d r109 = new d(r108);
        Intrinsics.checkNotNullParameter(r109, com.heytap.mcssdk.constant.b.f276366p);
        r100.add(r109);
        return;
    L15:
        r108 = CollectionsKt.emptyList();
    L8:
        r104 = CollectionsKt.emptyList();
        goto L9
    }
}
