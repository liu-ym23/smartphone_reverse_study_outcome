package com.ss.android.lark.contact.base.contact_list.mvp;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;

/* JADX INFO: loaded from: classes35.dex */
public final class k extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IndexRecyclerViewAdapter.b f418608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExternalContactView2.b f418609b;

    public k(ExternalContactView2.b r100) {
        this.f418609b = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        super.onScrollStateChanged(r100, r101);
        if (r101 != 0) goto L5;
        this.f418608a = null;
    L5:
        this.f418609b.getClass();
        int r102 = ((LinearLayoutManager) r100.getLayoutManager()).findFirstVisibleItemPosition();
        IndexRecyclerViewAdapter.b r103 = this.f418608a;
        if (r103 == null) goto L14;
        int r104 = r103.f418632c;
        if (r102 >= r103.f418633d) goto L11;
        if (r104 > r102) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        return;
    L11:
        r105 = false;
    L14:
        this.f418609b.getClass();
        IndexRecyclerViewAdapter r106 = (IndexRecyclerViewAdapter) r100.getAdapter();
        r106.getClass();
        IndexRecyclerViewAdapter.b r107 = new IndexRecyclerViewAdapter.a(r106).a(r102);
        this.f418608a = r107;
        if (r107 == null) goto L20;
        int r108 = r107.f418630a;
        IndexBar r109 = this.f418609b.f418586c;
        if (r109 == null) goto L21;
        r109.setFocusIndex(r108);
        return;
    L21:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        super.onScrolled(r100, r101, r102);
    }
}
