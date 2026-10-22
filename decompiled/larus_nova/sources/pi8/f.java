package pi8;

import android.view.View;
import com.larus.bmhome.chat.search.ArticleInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArticleInfo f529373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f529374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f529375c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f529373a, r101.f529373a) == true) goto L12;
        return false;
    L12:
        if (this.f529374b == r101.f529374b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f529375c, r101.f529375c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f529373a.hashCode() * 31) + this.f529374b) * 31) + this.f529375c.hashCode();
    }

    public final String toString() {
        return "ImageTextHolderCallbackData(itemData=" + this.f529373a + ", position=" + this.f529374b + ", itemView=" + this.f529375c + ')';
    }

    public f(ArticleInfo r100, int r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, "itemView");
        this.f529373a = r100;
        this.f529374b = r101;
        this.f529375c = r102;
    }
}
