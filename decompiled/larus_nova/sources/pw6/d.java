package pw6;

import com.ss.android.ugc.aweme.poi.bean.PoiBizCode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends gw6.a {
    public d() {
        super(PoiBizCode.DELIVER);
    }

    @Override // gw6.a
    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeTag");
        ow6.b r101 = ow6.c.f527059a;
        ow6.b r102 = ow6.c.f527059a;
        boolean r103 = false;
        if (r102.a() != 1) goto L9;
        List<String> r104 = r102.c();
        if (r104 != null) goto L7;
        return false;
    L7:
        return r104.contains(r100);
    L9:
        if (r102.a() != 2) goto L19;
        List<String> r105 = r102.b();
        if (r105 != null) goto L13;
    L14:
        r103 = true;
    L15:
        if (r103 == false) goto L18;
        return true;
    L18:
        return !r102.b().contains(r100);
    L13:
        if (r105.isEmpty() == false) goto L15;
    L19:
        return false;
    }
}
