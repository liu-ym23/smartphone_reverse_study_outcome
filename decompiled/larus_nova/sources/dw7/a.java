package dw7;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static RecyclerView.ViewHolder a(RecyclerView r100, float r101, float r102) {
        View r103 = r100.findChildViewUnder(r101, r102);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r100.getChildViewHolder(r103);
    }
}
