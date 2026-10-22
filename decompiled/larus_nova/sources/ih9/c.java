package ih9;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;
import ouc.g0;
import ouc.k;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class c implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f489915a;

    public /* synthetic */ c(d0 r100) {
        this.f489915a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        d0 r102 = this.f489915a;
        String r103 = (String) r100;
        boolean r104 = ((Boolean) r101).booleanValue();
        Intrinsics.checkNotNullParameter(r103, "key");
        Object r105 = r102.get(r103);
        g0 r106 = null;
        if ((r105 instanceof g0) == false) goto L5;
        g0 r107 = (g0) r105;
    L6:
        if (r107 == null) goto L15;
        if (r107.c() == true) goto L10;
        r106 = r107;
    L10:
        if (r106 == null) goto L15;
        Boolean r108 = k.f(r106);
        if (r108 == null) goto L15;
        r104 = r108.booleanValue();
    L15:
        return Boolean.valueOf(r104);
    L5:
        r107 = null;
        goto L6
    }
}
