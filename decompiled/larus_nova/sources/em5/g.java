package em5;

import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends a<SearchSpaceInfo> {
    @Override // em5.a, cpc.a
    public final boolean a() {
        if (this.f473087f.size() >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    public g(String r100) {
        Intrinsics.checkNotNullParameter("doc/in/folder", "id");
        Intrinsics.checkNotNullParameter(r100, "defaultStr");
        super("doc/in/folder", r100);
    }
}
