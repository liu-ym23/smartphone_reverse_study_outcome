package en;

import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f473140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f473141c;

    @Override // en.b
    public final int hashCode() {
        int r100 = super.hashCode() * 31;
        int r101 = 1231;
        if (this.f473140b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f473141c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    @Override // en.b
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(c.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        c r102 = (c) r100;
        if (this.f473140b == r102.f473140b) goto L17;
        return false;
    L17:
        if (this.f473141c == r102.f473141c) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.store.search.recyclerview.vo.RecommendNoticeVO");
    L8:
        r101 = null;
        goto L10
    }

    public c(boolean r100, boolean r101) {
        super(SearchResultItemType.RECOMMEND_NOTICE);
        this.f473140b = r100;
        this.f473141c = r101;
    }
}
