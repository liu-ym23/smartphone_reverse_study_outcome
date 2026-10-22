package com.bytedance.android.shopping.prepurchase.arch.container.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/model/Biz;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PDP", "Comment", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Biz extends Enum<Biz> {
    public static final Biz Comment = null;
    public static final Biz PDP = null;
    public static final /* synthetic */ Biz[] a = null;
    private final String value;

    static {
        Biz r1 = new Biz("PDP", 0, "pdp");
        PDP = r1;
        Biz r2 = new Biz("Comment", 1, "comment");
        Comment = r2;
        a = new Biz[]{r1, r2};
    }

    public static Biz valueOf(String r1) {
        return (Biz) a.a(Biz.class, r1);
    }

    public static Biz[] values() {
        return (Biz[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public Biz(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
