package ef5;

import com.bytedance.ee.bear.middleground.comment.widget.NoTopFadingEdgeRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z implements gf5.c {
    public final NoTopFadingEdgeRecyclerView a;

    public final String toString() {
        return "OuterVHCreatedEvent(view=" + this.a + ')';
    }

    public z(NoTopFadingEdgeRecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
    }
}
