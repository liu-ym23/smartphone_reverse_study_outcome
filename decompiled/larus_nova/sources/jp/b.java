package jp;

import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowSearchResultItemType f499928a;

    public int hashCode() {
        return this.f499928a.hashCode() * 31;
    }

    public b(WindowSearchResultItemType r100) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        this.f499928a = r100;
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
        if (this.f499928a == ((b) r100).f499928a) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowBaseViewObject");
    L8:
        r102 = null;
        goto L10
    }
}
