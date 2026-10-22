package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/ComponentViewType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "LYNX", "SLICE", "NATIVE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ComponentViewType extends Enum<ComponentViewType> {
    public static final ComponentViewType LYNX = null;
    public static final ComponentViewType NATIVE = null;
    public static final ComponentViewType SLICE = null;
    public static final /* synthetic */ ComponentViewType[] a = null;
    private final String type;

    static {
        ComponentViewType r1 = new ComponentViewType("LYNX", 0, "lynx");
        LYNX = r1;
        ComponentViewType r2 = new ComponentViewType("SLICE", 1, "slice");
        SLICE = r2;
        ComponentViewType r3 = new ComponentViewType("NATIVE", 2, "native");
        NATIVE = r3;
        a = new ComponentViewType[]{r1, r2, r3};
    }

    public static ComponentViewType valueOf(String r1) {
        return (ComponentViewType) r27.a.a(ComponentViewType.class, r1);
    }

    public static ComponentViewType[] values() {
        return (ComponentViewType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public ComponentViewType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
