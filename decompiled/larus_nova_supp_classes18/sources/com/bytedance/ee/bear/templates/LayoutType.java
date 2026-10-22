package com.bytedance.ee.bear.templates;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B;\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/templates/LayoutType;", "", "layId", "", "layBlankId", "layHeadId", "layEmptyId", "thumbnailSkeletonLayId", "<init>", "(Ljava/lang/String;IIIIII)V", "getLayId", "()I", "getLayBlankId", "getLayHeadId", "getLayEmptyId", "getThumbnailSkeletonLayId", "TYPE_RECOMMEND2", "TYPE_CENTER2", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LayoutType extends Enum<LayoutType> {
    public static final LayoutType TYPE_CENTER2 = null;
    public static final LayoutType TYPE_RECOMMEND2 = null;
    public static final /* synthetic */ LayoutType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int layBlankId;
    private final int layEmptyId;
    private final int layHeadId;
    private final int layId;
    private final int thumbnailSkeletonLayId;

    public static EnumEntries<LayoutType> getEntries() {
        return b;
    }

    static {
        LayoutType r6 = new LayoutType("TYPE_RECOMMEND2", 0, 2131564975, 2131564976, 2131564977);
        TYPE_RECOMMEND2 = r6;
        LayoutType r0 = new LayoutType("TYPE_CENTER2", 1, 2131564970, 2131564971, 2131564972);
        TYPE_CENTER2 = r0;
        LayoutType[] r1 = {r6, r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public static LayoutType[] values() {
        return (LayoutType[]) a.clone();
    }

    public final int getLayBlankId() {
        return this.layBlankId;
    }

    public final int getLayEmptyId() {
        return this.layEmptyId;
    }

    public final int getLayHeadId() {
        return this.layHeadId;
    }

    public final int getLayId() {
        return this.layId;
    }

    public final int getThumbnailSkeletonLayId() {
        return this.thumbnailSkeletonLayId;
    }

    public static LayoutType valueOf(String r1) {
        return (LayoutType) r27.a.a(LayoutType.class, r1);
    }

    public LayoutType(String r1, int r2, int r3, int r4, int r5) {
        super(r1, r2);
        this.layId = r3;
        this.layBlankId = r4;
        this.layHeadId = 2131564974;
        this.layEmptyId = 2131564973;
        this.thumbnailSkeletonLayId = r5;
    }
}
