package ef5;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements gf5.c {
    public final RecyclerView a;
    public final TextView b;
    public final View c;

    public final String toString() {
        return "CardAdapterSetReactionEvent(recyclerView=" + this.a + ", textView=" + this.b + ", tran=" + this.c + ')';
    }

    public c(RecyclerView r2, TextView r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        Intrinsics.checkNotNullParameter(r4, "tran");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
