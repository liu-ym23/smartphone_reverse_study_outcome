package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/ReportType;", "", "", "type", "I", "getType", "()I", "Companion", "a", "NORMAL", "SHOW", "CLICK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReportType extends Enum<ReportType> {
    public static final ReportType CLICK = null;
    public static final a Companion = null;
    public static final ReportType NORMAL = null;
    public static final ReportType SHOW = null;
    public static final /* synthetic */ ReportType[] a = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        ReportType r1 = new ReportType("NORMAL", 0, 0);
        NORMAL = r1;
        ReportType r2 = new ReportType("SHOW", 1, 1);
        SHOW = r2;
        ReportType r3 = new ReportType("CLICK", 2, 2);
        CLICK = r3;
        a = new ReportType[]{r1, r2, r3};
        Companion = new a();
    }

    public static ReportType valueOf(String r1) {
        return (ReportType) r27.a.a(ReportType.class, r1);
    }

    public static ReportType[] values() {
        return (ReportType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ReportType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
