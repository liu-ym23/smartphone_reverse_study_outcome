package com.bytedance.ies.argus.aspect.eventCenter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/ArgusBizIdUpdateFrom;", "", "", "priority", "I", "getPriority", "()I", "UNSET", "BIZ_INTENT_EXTRA", "BIZ_LOAD_TEMPLATE_URL", "BIZ_VIEW_ATTACH", "BIZ_CREATE_VIEW", "INNER_TTM", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusBizIdUpdateFrom extends Enum<ArgusBizIdUpdateFrom> {
    public static final ArgusBizIdUpdateFrom BIZ_CREATE_VIEW = null;
    public static final ArgusBizIdUpdateFrom BIZ_INTENT_EXTRA = null;
    public static final ArgusBizIdUpdateFrom BIZ_LOAD_TEMPLATE_URL = null;
    public static final ArgusBizIdUpdateFrom BIZ_VIEW_ATTACH = null;
    public static final ArgusBizIdUpdateFrom INNER_TTM = null;
    public static final ArgusBizIdUpdateFrom UNSET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusBizIdUpdateFrom[] f245814a = null;
    private final int priority;

    public static ArgusBizIdUpdateFrom valueOf(String r100) {
        return (ArgusBizIdUpdateFrom) r27.a.a(ArgusBizIdUpdateFrom.class, r100);
    }

    public static ArgusBizIdUpdateFrom[] values() {
        return (ArgusBizIdUpdateFrom[]) f245814a.clone();
    }

    static {
        ArgusBizIdUpdateFrom r100 = new ArgusBizIdUpdateFrom("UNSET", 0, 0);
        UNSET = r100;
        ArgusBizIdUpdateFrom r101 = new ArgusBizIdUpdateFrom("BIZ_INTENT_EXTRA", 1, 1);
        BIZ_INTENT_EXTRA = r101;
        ArgusBizIdUpdateFrom r102 = new ArgusBizIdUpdateFrom("BIZ_LOAD_TEMPLATE_URL", 2, 2);
        BIZ_LOAD_TEMPLATE_URL = r102;
        ArgusBizIdUpdateFrom r103 = new ArgusBizIdUpdateFrom("BIZ_VIEW_ATTACH", 3, 3);
        BIZ_VIEW_ATTACH = r103;
        ArgusBizIdUpdateFrom r104 = new ArgusBizIdUpdateFrom("BIZ_CREATE_VIEW", 4, 4);
        BIZ_CREATE_VIEW = r104;
        ArgusBizIdUpdateFrom r105 = new ArgusBizIdUpdateFrom("INNER_TTM", 5, 100);
        INNER_TTM = r105;
        f245814a = new ArgusBizIdUpdateFrom[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getPriority() {
        return this.priority;
    }

    public ArgusBizIdUpdateFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.priority = r102;
    }
}
