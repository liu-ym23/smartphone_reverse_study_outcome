package kh2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements e<Integer> {
    public final int a;

    @Override // kh2.e
    public final Integer getValue() {
        return Integer.valueOf(this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public a(com.bytedance.android.ec.adapter.api.state.a r2) {
        if (r2 != null) goto L5;
        ?? r3 = 0;
    L6:
        this.a = r3;
        return;
    L5:
        r3 = r2.n.getBoolean("EXTRA_BOOL_ANCHOR_HAS_COMMERCE_PERMISSION");
        goto L6
    }
}
