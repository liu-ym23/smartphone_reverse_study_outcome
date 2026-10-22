package v3c;

import com.ss.android.lark.search.dto.info.TagContent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f552979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TagContent> f552980b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f552979a, r101.f552979a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f552980b, r101.f552980b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f552979a.hashCode() * 31) + this.f552980b.hashCode();
    }

    public final String toString() {
        return "TagInfo(contentWithoutTag=" + this.f552979a + ", tagContentList=" + this.f552980b + ')';
    }

    public l(String r100, List<TagContent> r101) {
        Intrinsics.checkNotNullParameter(r100, "contentWithoutTag");
        Intrinsics.checkNotNullParameter(r101, "tagContentList");
        this.f552979a = r100;
        this.f552980b = r101;
    }
}
