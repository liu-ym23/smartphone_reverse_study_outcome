package com.ss.android.lark.contact.customized.externalcontact.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;

/* JADX INFO: loaded from: classes35.dex */
public final class t extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IndexRecyclerViewAdapter.b f419247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f419248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IndexRecyclerViewAdapter f419249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u f419250d;

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        super.onScrollStateChanged(r100, r101);
        if (r101 != 0) goto L5;
        this.f419247a = null;
    L5:
        this.f419250d.getClass();
        int r102 = ((LinearLayoutManager) r100.getLayoutManager()).findFirstVisibleItemPosition() - this.f419248b;
        boolean r103 = false;
        if (r102 >= 0) goto L11;
        IndexBar r104 = this.f419250d.f419253c;
        if (r104 == null) goto L25;
        r104.setFocusIndex(0);
        return;
    L25:
        return;
    L11:
        IndexRecyclerViewAdapter.b r105 = this.f419247a;
        if (r105 == null) goto L19;
        int r106 = r105.f418632c;
        if (r102 >= r105.f418633d) goto L17;
        if (r106 > r102) goto L17;
        r103 = true;
    L17:
        if (r103 == false) goto L19;
        return;
    L19:
        IndexRecyclerViewAdapter r107 = this.f419249c;
        r107.getClass();
        IndexRecyclerViewAdapter.b r108 = new IndexRecyclerViewAdapter.a(r107).a(r102);
        this.f419247a = r108;
        if (r108 == null) goto L26;
        int r109 = r108.f418630a;
        u r110 = this.f419250d;
        int r111 = r109 + (r110.f419255e ? 1 : 0);
        IndexBar r112 = r110.f419253c;
        if (r112 == null) goto L27;
        r112.setFocusIndex(r111);
        return;
    L27:
        return;
    }

    public t(u r100, int r101, IndexRecyclerViewAdapter r102) {
        this.f419250d = r100;
        this.f419248b = r101;
        this.f419249c = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        super.onScrolled(r100, r101, r102);
    }
}
