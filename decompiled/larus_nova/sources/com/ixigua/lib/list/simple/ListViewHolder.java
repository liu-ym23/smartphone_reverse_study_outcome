package com.ixigua.lib.list.simple;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.list.ListAdapter;
import com.ixigua.lib.list.a;
import com.ixigua.lib.list.d;
import java.util.List;
import kotlin.Metadata;
import wx7.b;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/ixigua/lib/list/simple/ListViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lwx7/b;", "", "liblist_release"}, k = 1, mv = {1, 4, 0})
public class ListViewHolder<T> extends RecyclerView.ViewHolder implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f278523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f278524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a<?, ?> f278525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f278526d;

    @Override // wx7.b
    public final boolean R1(ListViewHolder<?> r100, wx7.a r101) {
        return false;
    }

    public void W3() {
    }

    public void X3() {
    }

    public ListViewHolder(View r100) {
        super(r100);
    }

    public void T3(T r100) {
        this.f278523a = r100;
    }

    public final void V3(wx7.a r100) {
        ListAdapter r101 = this.f278524b;
        if (r101 == null) goto L7;
        b r102 = r101.f278491c;
        if (r102 == null) goto L7;
        boolean r103 = r102.R1(this, r100);
    L8:
        if (r103 == true) goto L16;
        a<?, ?> r104 = this.f278525c;
        if ((r104 instanceof b) == true) goto L12;
        r104 = null;
    L12:
        b r105 = (b) r104;
        if (r105 == null) goto L17;
        r105.R1(this, r100);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public void U3(T r100, List<? extends Object> r101) {
        T3(r100);
    }
}
