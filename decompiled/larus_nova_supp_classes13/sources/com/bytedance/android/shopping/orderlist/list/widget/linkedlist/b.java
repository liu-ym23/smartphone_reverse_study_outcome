package com.bytedance.android.shopping.orderlist.list.widget.linkedlist;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements com.bytedance.android.shopping.orderlist.list.widget.gul.a {
    public final /* synthetic */ OrderListLinkedScrollView a;

    @Override // com.bytedance.android.shopping.orderlist.list.widget.gul.a
    public final boolean a() {
        OrderListLinkedScrollView r0 = this.a;
        return !r0.i(r0.getGulContainer());
    }

    @Override // com.bytedance.android.shopping.orderlist.list.widget.gul.a
    public final void b() {
        OrderListLinkedScrollView r0 = this.a;
        if (r0.i(r0.getGulContainer()) == true) goto L7;
        r0.setScrollY(r0.a.getYataRecyclerView().getHeight());
        r0.getGulContainer().t0();
        return;
    }

    public b(OrderListLinkedScrollView r1) {
        this.a = r1;
    }
}
