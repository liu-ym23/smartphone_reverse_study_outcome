package ef5;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements gf5.c {
    public final RecyclerView a;
    public final int b;

    public final String toString() {
        return "CommentScrollStateChangedEvent(recyclerView=" + this.a + ", newState=" + this.b + ')';
    }

    public f(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.a = r2;
        this.b = r3;
    }
}
