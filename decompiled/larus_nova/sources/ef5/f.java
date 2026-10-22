package ef5;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f472456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f472457b;

    public final String toString() {
        return "CommentScrollStateChangedEvent(recyclerView=" + this.f472456a + ", newState=" + this.f472457b + ')';
    }

    public f(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f472456a = r100;
        this.f472457b = r101;
    }
}
