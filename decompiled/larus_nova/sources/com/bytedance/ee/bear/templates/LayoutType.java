package com.bytedance.ee.bear.templates;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B;\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/templates/LayoutType;", "", "layId", "", "layBlankId", "layHeadId", "layEmptyId", "thumbnailSkeletonLayId", "<init>", "(Ljava/lang/String;IIIIII)V", "getLayId", "()I", "getLayBlankId", "getLayHeadId", "getLayEmptyId", "getThumbnailSkeletonLayId", "TYPE_RECOMMEND2", "TYPE_CENTER2", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LayoutType extends Enum<LayoutType> {
    public static final LayoutType TYPE_CENTER2 = null;
    public static final LayoutType TYPE_RECOMMEND2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutType[] f238752a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f238753b = null;
    private final int layBlankId;
    private final int layEmptyId;
    private final int layHeadId;
    private final int layId;
    private final int thumbnailSkeletonLayId;

    public static EnumEntries<LayoutType> getEntries() {
        return f238753b;
    }

    static {
        LayoutType r100 = new LayoutType("TYPE_RECOMMEND2", 0, R.layout.template_v4_item_recommend2, R.layout.template_v4_item_recommend2_blank, R.layout.template_v4_item_recommend_cover_skeleton2);
        TYPE_RECOMMEND2 = r100;
        LayoutType r101 = new LayoutType("TYPE_CENTER2", 1, R.layout.template_v4_item_center2, R.layout.template_v4_item_center_blank, R.layout.template_v4_item_center_cover_skeleton2);
        TYPE_CENTER2 = r101;
        LayoutType[] r102 = {r100, r101};
        f238752a = r102;
        f238753b = EnumEntriesKt.enumEntries(r102);
    }

    public static LayoutType[] values() {
        return (LayoutType[]) f238752a.clone();
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

    public static LayoutType valueOf(String r100) {
        return (LayoutType) r27.a.a(LayoutType.class, r100);
    }

    public LayoutType(String r100, int r101, int r102, int r103, int r104) {
        super(r100, r101);
        this.layId = r102;
        this.layBlankId = r103;
        this.layHeadId = R.layout.template_v4_item_header;
        this.layEmptyId = R.layout.template_v4_item_empty;
        this.thumbnailSkeletonLayId = r104;
    }
}
