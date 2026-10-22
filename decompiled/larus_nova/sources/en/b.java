package en;

import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchResultItemType f473139a;

    public int hashCode() {
        return this.f473139a.hashCode() * 31;
    }

    public b(SearchResultItemType r100) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        this.f473139a = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Class<?> r101 = getClass();
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(r101, r102)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if (this.f473139a == ((b) r100).f473139a) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.store.search.recyclerview.vo.BaseViewObject");
    L8:
        r102 = null;
        goto L10
    }
}
