package dnc;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static final <T> T a(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (T) r100.itemView.findViewById(r101);
    }

    public static final void b(RecyclerView.ViewHolder r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 == false) goto L5;
        e1.o(r100.itemView.findViewById(r101));
        return;
    L5:
        e1.x(r100.itemView.findViewById(r101));
    }

    public static final void c(RecyclerView.ViewHolder r100, int r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ((TextView) r100.itemView.findViewById(r101)).setText(r102);
    }

    public static final void d(RecyclerView.ViewHolder r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 == false) goto L5;
        e1.x(r100.itemView.findViewById(r101));
        return;
    L5:
        e1.o(r100.itemView.findViewById(r101));
    }
}
