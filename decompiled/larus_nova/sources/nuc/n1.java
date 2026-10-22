package nuc;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@InternalSerializationApi
public abstract class n1 extends x2<String> {
    public abstract String p(luc.f r100, int r101);

    public n1() {
    }

    @Override // nuc.x2
    public final String n(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r102 = p(r100, r101);
        Intrinsics.checkNotNullParameter(r102, "nestedName");
        String r103 = (String) CollectionsKt.lastOrNull(this.f520801a);
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        Intrinsics.checkNotNullParameter(r103, "parentName");
        Intrinsics.checkNotNullParameter(r102, "childName");
        return r102;
    }
}
