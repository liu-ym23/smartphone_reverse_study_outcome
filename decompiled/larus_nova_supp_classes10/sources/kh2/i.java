package kh2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements e<Integer> {
    public final int a;

    @Override // kh2.e
    public final Integer getValue() {
        return Integer.valueOf(this.a);
    }

    public i(com.bytedance.android.ec.adapter.api.state.a r2) {
        if (r2 != null) goto L5;
        int r3 = 0;
    L6:
        this.a = r3;
        return;
    L5:
        r3 = r2.n.getInt("EXTRA_INT_SHOW_CART");
        goto L6
    }
}
