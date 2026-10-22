package ef5;

import com.bytedance.ee.bear.middleground.comment.widget.NoTopFadingEdgeRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class z implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NoTopFadingEdgeRecyclerView f472520a;

    public final String toString() {
        return "OuterVHCreatedEvent(view=" + this.f472520a + ')';
    }

    public z(NoTopFadingEdgeRecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f472520a = r100;
    }
}
