package m0a;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.ugc.feed.api.model.CreationFeedInitParamsKmp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CreationFeedInitParamsKmp f511533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView.ItemDecoration f511534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView.ItemDecoration f511535c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f511533a, r101.f511533a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f511534b, r101.f511534b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f511535c, r101.f511535c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f511533a.hashCode() * 31;
        RecyclerView.ItemDecoration r101 = this.f511534b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        RecyclerView.ItemDecoration r105 = this.f511535c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationFeedInitParamsAndroid(common=" + this.f511533a + ", customItemDecoration=" + this.f511534b + ", loadingItemDecoration=" + this.f511535c + ')';
    }

    public i(CreationFeedInitParamsKmp r100, RecyclerView.ItemDecoration r101, RecyclerView.ItemDecoration r102) {
        Intrinsics.checkNotNullParameter(r100, "common");
        this.f511533a = r100;
        this.f511534b = r101;
        this.f511535c = r102;
    }
}
