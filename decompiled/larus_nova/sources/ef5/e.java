package ef5;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f472453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f472454b;

    public final String toString() {
        return "CommentPageScrollStateChangedEvent(recyclerView=" + this.f472453a + ", newState=" + this.f472454b + ')';
    }

    public e(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f472453a = r100;
        this.f472454b = r101;
    }
}
