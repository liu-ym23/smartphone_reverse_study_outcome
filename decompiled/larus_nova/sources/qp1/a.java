package qp1;

import com.bytedance.android.scope.o;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements up1.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mm1.a f534327a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public a(mm1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f534327a = r100;
    }

    @Override // up1.a
    public final boolean isNeedSendShow(String r100, String r101) {
        List<String> r102 = zp1.b.f573182a;
        if (r100 == null) goto L31;
        if (r101 == null) goto L32;
        Iterator<String> r103 = zp1.b.f573182a.iterator();
    L8:
        if (r103.hasNext() == false) goto L33;
        String r104 = r103.next();
        if (Intrinsics.areEqual(r104, r100 + '_' + r101) == false) goto L13;
    L21:
        boolean r105 = true;
    L23:
        if (r105 == false) goto L8;
        return r105;
    L13:
        if (StringsKt.endsWith$default(r104, "*", false, 2, null) == false) goto L18;
        if (StringsKt.startsWith$default(r104, r100, false, 2, null) == true) goto L21;
    L18:
        if (StringsKt.startsWith$default(r104, "*", false, 2, null) == true) goto L20;
    L22:
        r105 = false;
        goto L23
    L20:
        if (StringsKt.endsWith$default(r104, r101, false, 2, null) == false) goto L22;
    L33:
        return false;
    L32:
        return false;
    L31:
        return false;
    }
}
