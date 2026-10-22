package ef5;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements gf5.c {
    public final RecyclerView a;
    public final int b;
    public final int c;

    public final String toString() {
        return "CommentScrolledEvent(recyclerView=" + this.a + ", dx=" + this.b + ", dy=" + this.c + ')';
    }

    public g(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
