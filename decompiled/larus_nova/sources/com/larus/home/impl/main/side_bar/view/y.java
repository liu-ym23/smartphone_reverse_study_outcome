package com.larus.home.impl.main.side_bar.view;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.home.impl.main.side_bar.view.adapter.BaseSideBarAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class y implements com.larus.bmhome.chat.helper.f0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SideBarContentFragment f345830a;

    public /* synthetic */ y(SideBarContentFragment r100) {
        this.f345830a = r100;
    }

    @Override // com.larus.bmhome.chat.helper.f0.a
    public final void a(Set r100) {
        SideBarContentFragment r101 = this.f345830a;
        int r102 = SideBarContentFragment.f344768k1;
        Intrinsics.checkNotNullParameter(r100, "it");
        ConcatAdapter r103 = r101.f344774g;
        if (r103 == null) goto L16;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r104 = r103.getAdapters();
        if (r104 == null) goto L23;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Object r107 = r106.next();
        if ((r107 instanceof BaseSideBarAdapter) == false) goto L8;
        r105.add(r107);
        goto L8
    L12:
        Iterator r108 = r105.iterator();
    L14:
        if (r108.hasNext() == false) goto L24;
        ((BaseSideBarAdapter) r108.next()).H2();
        goto L14
    L24:
        return;
    L23:
        return;
    }
}
