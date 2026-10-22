package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/SortType;", "", "", "isDefault", "", "type", "I", "getType", "()I", "Companion", "a", "DEFAULT", "LATEST", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SortType extends Enum<SortType> {
    public static final a Companion = null;
    public static final SortType DEFAULT = null;
    public static final SortType LATEST = null;
    public static final /* synthetic */ SortType[] a = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        SortType r1 = new SortType("DEFAULT", 0, 0);
        DEFAULT = r1;
        SortType r2 = new SortType("LATEST", 1, 1);
        LATEST = r2;
        a = new SortType[]{r1, r2};
        Companion = new a();
    }

    public static SortType valueOf(String r1) {
        return (SortType) r27.a.a(SortType.class, r1);
    }

    public static SortType[] values() {
        return (SortType[]) a.clone();
    }

    public final boolean isDefault() {
        if (this.type != DEFAULT.type) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getType() {
        return this.type;
    }

    public SortType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
