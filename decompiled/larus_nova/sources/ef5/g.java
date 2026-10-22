package ef5;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f472458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f472459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f472460c;

    public final String toString() {
        return "CommentScrolledEvent(recyclerView=" + this.f472458a + ", dx=" + this.f472459b + ", dy=" + this.f472460c + ')';
    }

    public g(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f472458a = r100;
        this.f472459b = r101;
        this.f472460c = r102;
    }
}
