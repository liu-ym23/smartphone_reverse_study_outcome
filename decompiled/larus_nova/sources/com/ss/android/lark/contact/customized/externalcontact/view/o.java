package com.ss.android.lark.contact.customized.externalcontact.view;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;

/* JADX INFO: loaded from: classes35.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OfficeFloatingBarItemDecoration f419235a;

    public o() {
    }

    public static IndexRecyclerViewAdapter a(RecyclerView r100) {
        RecyclerView.Adapter r101 = r100.getAdapter();
        if ((r101 instanceof ConcatAdapter) == false) goto L13;
        ConcatAdapter r102 = (ConcatAdapter) r101;
        if (r102.getAdapters().size() <= 1) goto L9;
        return (IndexRecyclerViewAdapter) ListProtector.get(r102.getAdapters(), 1);
    L9:
        if (r102.getAdapters().size() != 1) goto L13;
        return (IndexRecyclerViewAdapter) ListProtector.get(r102.getAdapters(), 0);
    L13:
        return (IndexRecyclerViewAdapter) r101;
    }

    public static int b(RecyclerView r100) {
        RecyclerView.Adapter r101 = r100.getAdapter();
        if ((r101 instanceof ConcatAdapter) == false) goto L8;
        ConcatAdapter r102 = (ConcatAdapter) r101;
        if (r102.getAdapters().size() <= 1) goto L8;
        return ((RecyclerView.Adapter) ListProtector.get(r102.getAdapters(), 0)).getItemCount();
    L8:
        return 0;
    }
}
