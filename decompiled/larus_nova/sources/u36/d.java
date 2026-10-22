package u36;

import com.bytedance.ies.bullet.service.sdk.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y36.o;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f548607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548608b;

    @Override // t36.e
    public final String getName() {
        return this.f548608b;
    }

    public d(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "packages");
        this.f548607a = r100;
        this.f548608b = "Packages";
    }

    @Override // t36.e
    public final boolean b(com.bytedance.ies.bullet.service.sdk.d r110) {
        Intrinsics.checkNotNullParameter(r110, "schemaData");
        ArrayList r100 = new ArrayList();
        String r101 = (String) ((LinkedHashMap) r110.f248139p).get("packages");
        if (r101 == null) goto L15;
        Iterator r102 = StringsKt.split$default(r101, new char[]{','}, false, 0, 6, null).iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        String r103 = (String) r102.next();
        if (r103.length() <= 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L6;
        if (this.f548607a.contains(r103) == true) goto L6;
        r100.add(r103);
        goto L6
    L10:
        r104 = false;
    L15:
        r100.addAll(this.f548607a);
        r110.a("packages", new o(r100), true);
        return true;
    }
}
