package zx7;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.list.ListAgency;
import com.ixigua.lib.list.internal.EmptyViewHolder;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends ay7.a<Object, EmptyViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f573890a = null;

    @Override // com.ixigua.lib.list.c
    public final boolean accept(Object r100) {
        return false;
    }

    static {
        f573890a = new a();
    }

    public a() {
    }

    @Override // com.ixigua.lib.list.a
    public final RecyclerView.ViewHolder a(LayoutInflater r100, ViewGroup r101) {
        int r102 = EmptyViewHolder.f278522e;
        ListAgency.f278497d.getClass();
        return new EmptyViewHolder(new Space(r101.getContext()));
    }
}
