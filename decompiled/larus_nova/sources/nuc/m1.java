package nuc;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@InternalSerializationApi
public abstract class m1 extends w2<String> {
    public final String q() {
        if (this.f520795a.isEmpty() == false) goto L6;
        return "$";
    L6:
        return CollectionsKt.joinToString$default(this.f520795a, ".", "$.", null, 0, null, null, 60, null);
    }

    public m1() {
    }

    @Override // nuc.w2
    public final /* bridge */ /* synthetic */ String m(luc.f r100, int r101) {
        return p(r100, r101);
    }

    public String o(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return r100.b(r101);
    }

    public final String p(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r102 = o(r100, r101);
        Intrinsics.checkNotNullParameter(r102, "nestedName");
        String r103 = (String) CollectionsKt.lastOrNull(this.f520795a);
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        Intrinsics.checkNotNullParameter(r103, "parentName");
        Intrinsics.checkNotNullParameter(r102, "childName");
        return r102;
    }
}
