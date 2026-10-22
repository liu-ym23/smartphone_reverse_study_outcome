package ef5;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f472449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f472450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f472451c;

    public final String toString() {
        return "CardAdapterSetReactionEvent(recyclerView=" + this.f472449a + ", textView=" + this.f472450b + ", tran=" + this.f472451c + ')';
    }

    public c(RecyclerView r100, TextView r101, View r102) {
        Intrinsics.checkNotNullParameter(r101, "textView");
        Intrinsics.checkNotNullParameter(r102, "tran");
        this.f472449a = r100;
        this.f472450b = r101;
        this.f472451c = r102;
    }
}
