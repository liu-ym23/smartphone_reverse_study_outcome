package com.bytedance.ee.bear.bitable.itemview.record.list;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/CellPureUIType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NotSupport", "RichText", "FormatterText", "Location", "Select", "User", "Group", ExifInterface.TAG_DATETIME, "Checkbox", "Button", "Progress", "Rating", "LinkTable", "LinkTagCompact", "LinkCard", "LinkTagAll", "StageTag", "StageView", "Attachment_Preview", "Attachment_Preview_Big", "Attachment_Gallery", "Attachment_Carousel", "Signature", "canItemContainerClick", "", "needDelegateClick", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CellPureUIType extends Enum<CellPureUIType> {
    public static final CellPureUIType Attachment_Carousel = null;
    public static final CellPureUIType Attachment_Gallery = null;
    public static final CellPureUIType Attachment_Preview = null;
    public static final CellPureUIType Attachment_Preview_Big = null;
    public static final CellPureUIType Button = null;
    public static final CellPureUIType Checkbox = null;
    public static final a Companion = null;
    public static final CellPureUIType DateTime = null;
    public static final CellPureUIType FormatterText = null;
    public static final CellPureUIType Group = null;
    public static final CellPureUIType LinkCard = null;
    public static final CellPureUIType LinkTable = null;
    public static final CellPureUIType LinkTagAll = null;
    public static final CellPureUIType LinkTagCompact = null;
    public static final CellPureUIType Location = null;
    public static final CellPureUIType NotSupport = null;
    public static final CellPureUIType Progress = null;
    public static final CellPureUIType Rating = null;
    public static final CellPureUIType RichText = null;
    public static final CellPureUIType Select = null;
    public static final CellPureUIType Signature = null;
    public static final CellPureUIType StageTag = null;
    public static final CellPureUIType StageView = null;
    public static final CellPureUIType User = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, CellPureUIType> f214084a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ CellPureUIType[] f214085b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214086c = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CellPureUIType> getEntries() {
        return f214086c;
    }

    static {
        CellPureUIType r100 = new CellPureUIType("NotSupport", 0, 0);
        NotSupport = r100;
        CellPureUIType r101 = new CellPureUIType("RichText", 1, 1);
        RichText = r101;
        CellPureUIType r102 = new CellPureUIType("FormatterText", 2, 3);
        FormatterText = r102;
        CellPureUIType r103 = new CellPureUIType("Location", 3, 4);
        Location = r103;
        CellPureUIType r104 = new CellPureUIType("Select", 4, 6);
        Select = r104;
        CellPureUIType r110 = new CellPureUIType("User", 5, 7);
        User = r110;
        CellPureUIType r111 = new CellPureUIType("Group", 6, 8);
        Group = r111;
        CellPureUIType r112 = new CellPureUIType(ExifInterface.TAG_DATETIME, 7, 9);
        DateTime = r112;
        CellPureUIType r113 = new CellPureUIType("Checkbox", 8, 11);
        Checkbox = r113;
        CellPureUIType r114 = new CellPureUIType("Button", 9, 12);
        Button = r114;
        CellPureUIType r115 = new CellPureUIType("Progress", 10, 13);
        Progress = r115;
        CellPureUIType r105 = new CellPureUIType("Rating", 11, 14);
        Rating = r105;
        CellPureUIType r106 = new CellPureUIType("LinkTable", 12, 21);
        LinkTable = r106;
        CellPureUIType r107 = new CellPureUIType("LinkTagCompact", 13, 22);
        LinkTagCompact = r107;
        CellPureUIType r108 = new CellPureUIType("LinkCard", 14, 23);
        LinkCard = r108;
        CellPureUIType r109 = new CellPureUIType("LinkTagAll", 15, 24);
        LinkTagAll = r109;
        CellPureUIType r116 = new CellPureUIType("StageTag", 16, 26);
        StageTag = r116;
        CellPureUIType r117 = new CellPureUIType("StageView", 17, 27);
        StageView = r117;
        CellPureUIType r118 = new CellPureUIType("Attachment_Preview", 18, 30);
        Attachment_Preview = r118;
        CellPureUIType r119 = new CellPureUIType("Attachment_Preview_Big", 19, 31);
        Attachment_Preview_Big = r119;
        CellPureUIType r120 = new CellPureUIType("Attachment_Gallery", 20, 32);
        Attachment_Gallery = r120;
        CellPureUIType r121 = new CellPureUIType("Attachment_Carousel", 21, 33);
        Attachment_Carousel = r121;
        CellPureUIType r122 = new CellPureUIType("Signature", 22, 35);
        Signature = r122;
        int r123 = 0;
        CellPureUIType[] r124 = {r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r105, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122};
        f214085b = r124;
        f214086c = EnumEntriesKt.enumEntries(r124);
        Companion = new a();
        CellPureUIType[] r125 = values();
        LinkedHashMap r126 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r125.length), 16));
        int r127 = r125.length;
    L3:
        if (r123 >= r127) goto L5;
        CellPureUIType r128 = r125[r123];
        r126.put(Integer.valueOf(r128.value), r128);
        r123 = r123 + 1;
        goto L3
    L5:
        f214084a = r126;
    }

    public static CellPureUIType[] values() {
        return (CellPureUIType[]) f214085b.clone();
    }

    public final boolean canItemContainerClick() {
        if (this.value == Button.value) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean needDelegateClick() {
        if (this.value != LinkTagCompact.value) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ Map access$getMAP$cp() {
        return f214084a;
    }

    public final int getValue() {
        return this.value;
    }

    public static CellPureUIType valueOf(String r100) {
        return (CellPureUIType) r27.a.a(CellPureUIType.class, r100);
    }

    public CellPureUIType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
