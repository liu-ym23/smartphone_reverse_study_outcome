package pi8;

import android.view.View;
import com.larus.im.bean.message.SearchImageInfo;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchImageInfo f529368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f529369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f529370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<List<SearchImageInfo>> f529371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<List<Pair<Integer, View>>> f529372e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f529368a, r101.f529368a) == true) goto L12;
        return false;
    L12:
        if (this.f529369b == r101.f529369b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f529370c, r101.f529370c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f529371d, r101.f529371d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f529372e, r101.f529372e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f529368a.hashCode() * 31) + this.f529369b) * 31) + this.f529370c.hashCode()) * 31) + this.f529371d.hashCode()) * 31) + this.f529372e.hashCode();
    }

    public final String toString() {
        return "ImageHolderCallbackData(itemData=" + this.f529368a + ", position=" + this.f529369b + ", itemView=" + this.f529370c + ", imageInfoListGetter=" + this.f529371d + ", imageItemViewGetter=" + this.f529372e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(SearchImageInfo r100, int r101, View r102, Function0<? extends List<SearchImageInfo>> r103, Function0<? extends List<? extends Pair<Integer, ? extends View>>> r104) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, "itemView");
        Intrinsics.checkNotNullParameter(r103, "imageInfoListGetter");
        Intrinsics.checkNotNullParameter(r104, "imageItemViewGetter");
        this.f529368a = r100;
        this.f529369b = r101;
        this.f529370c = r102;
        this.f529371d = r103;
        this.f529372e = r104;
    }
}
