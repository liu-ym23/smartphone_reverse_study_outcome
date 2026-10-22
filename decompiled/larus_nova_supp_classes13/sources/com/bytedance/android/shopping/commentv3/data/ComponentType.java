package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/ComponentType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "TAB_FILTER", "COMMENT_FILTER_FIRST", "COMMENT_FILTER_SECOND", "COMMENT_NPS", "SORT_HEADER", "COMMENT_HEAD", "COMMENT_MEDIA", "COMMENT_BROWSE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ComponentType extends Enum<ComponentType> {
    public static final ComponentType COMMENT_BROWSE = null;
    public static final ComponentType COMMENT_FILTER_FIRST = null;
    public static final ComponentType COMMENT_FILTER_SECOND = null;
    public static final ComponentType COMMENT_HEAD = null;
    public static final ComponentType COMMENT_MEDIA = null;
    public static final ComponentType COMMENT_NPS = null;
    public static final ComponentType SORT_HEADER = null;
    public static final ComponentType TAB_FILTER = null;
    public static final /* synthetic */ ComponentType[] a = null;
    private final String type;

    public static ComponentType valueOf(String r1) {
        return (ComponentType) r27.a.a(ComponentType.class, r1);
    }

    public static ComponentType[] values() {
        return (ComponentType[]) a.clone();
    }

    static {
        ComponentType r1 = new ComponentType("TAB_FILTER", 0, "tab_filter_component");
        TAB_FILTER = r1;
        ComponentType r2 = new ComponentType("COMMENT_FILTER_FIRST", 1, "comment_filter_first_component");
        COMMENT_FILTER_FIRST = r2;
        ComponentType r3 = new ComponentType("COMMENT_FILTER_SECOND", 2, "comment_filter_second_component");
        COMMENT_FILTER_SECOND = r3;
        ComponentType r4 = new ComponentType("COMMENT_NPS", 3, "comment_nps_component");
        COMMENT_NPS = r4;
        ComponentType r5 = new ComponentType("SORT_HEADER", 4, "sort_header_component");
        SORT_HEADER = r5;
        ComponentType r6 = new ComponentType("COMMENT_HEAD", 5, "comment_header_component");
        COMMENT_HEAD = r6;
        ComponentType r7 = new ComponentType("COMMENT_MEDIA", 6, "comment_media_component");
        COMMENT_MEDIA = r7;
        ComponentType r8 = new ComponentType("COMMENT_BROWSE", 7, "comment_browse_component");
        COMMENT_BROWSE = r8;
        a = new ComponentType[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final String getType() {
        return this.type;
    }

    public ComponentType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
