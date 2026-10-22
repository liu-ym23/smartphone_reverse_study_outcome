package pdc;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import ldc.e;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a<DATA extends Photo, VH extends RecyclerView.ViewHolder> implements e<DATA> {
    public a() {
    }

    public abstract void a(VH r100, DATA r101);

    public abstract VH b(ViewGroup r100);

    public void c() {
    }
}
