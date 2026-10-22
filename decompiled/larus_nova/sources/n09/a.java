package n09;

import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zv9.f;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements t74.a.InterfaceC7693a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f516612a;

    @Override // t74.a.InterfaceC7693a
    public final DTraitRiskType a() {
        if (this.f516612a.e() != 0) goto L6;
        return DTraitRiskType.HIGH;
    L6:
        return DTraitRiskType.LOW;
    }

    @Override // t74.a.InterfaceC7693a
    public final int getTimeout() {
        return this.f516612a.f();
    }

    public a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f516612a = r100;
    }

    @Override // t74.a.InterfaceC7693a
    public final boolean b(String r100) {
        List<String> r101 = this.f516612a.a();
        if (r101 == null) goto L28;
        List r102 = CollectionsKt.filterNotNull(r101);
        if (r102 == null) goto L29;
        List r103 = r102;
        if ((r103 instanceof Collection) == true) goto L9;
    L11:
        Iterator r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L31;
        String r105 = (String) r104.next();
        if (r100 != null) goto L17;
    L19:
        boolean r106 = false;
    L20:
        if (r106 == false) goto L13;
        return true;
    L17:
        if (StringsKt.contains$default(r100, r105, false, 2, null) != true) goto L19;
        r106 = true;
        goto L20
    L31:
        return false;
    L9:
        if (r103.isEmpty() == false) goto L11;
        return false;
    L29:
        return false;
    L28:
        return false;
    }
}
