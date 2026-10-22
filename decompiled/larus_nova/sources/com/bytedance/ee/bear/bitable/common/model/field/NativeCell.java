package com.bytedance.ee.bear.bitable.common.model.field;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/model/field/NativeCell;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ATTACHMENT", "BUTTON", "CHECKBOX", "DATE_TIME", "LINK", "PROGRESS", "RATINGBAR", "RICHTEXT", "SELECT", "MutilSELECT", "SIMPLETEXT", "STAGE", "User", "SingleUser", "FieldSelect", "NOT_SUPPORT", "SIGNATURE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NativeCell extends Enum<NativeCell> {
    public static final NativeCell ATTACHMENT = null;
    public static final NativeCell BUTTON = null;
    public static final NativeCell CHECKBOX = null;
    public static final NativeCell DATE_TIME = null;
    public static final NativeCell FieldSelect = null;
    public static final NativeCell LINK = null;
    public static final NativeCell MutilSELECT = null;
    public static final NativeCell NOT_SUPPORT = null;
    public static final NativeCell PROGRESS = null;
    public static final NativeCell RATINGBAR = null;
    public static final NativeCell RICHTEXT = null;
    public static final NativeCell SELECT = null;
    public static final NativeCell SIGNATURE = null;
    public static final NativeCell SIMPLETEXT = null;
    public static final NativeCell STAGE = null;
    public static final NativeCell SingleUser = null;
    public static final NativeCell User = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NativeCell[] f209858a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209859b = null;
    private final String value;

    public static EnumEntries<NativeCell> getEntries() {
        return f209859b;
    }

    static {
        NativeCell r100 = new NativeCell("ATTACHMENT", 0, "Attachment");
        ATTACHMENT = r100;
        NativeCell r101 = new NativeCell("BUTTON", 1, "Button");
        BUTTON = r101;
        NativeCell r102 = new NativeCell("CHECKBOX", 2, "Checkbox");
        CHECKBOX = r102;
        NativeCell r103 = new NativeCell("DATE_TIME", 3, ExifInterface.TAG_DATETIME);
        DATE_TIME = r103;
        NativeCell r104 = new NativeCell("LINK", 4, "Ling");
        LINK = r104;
        NativeCell r105 = new NativeCell("PROGRESS", 5, "Progress");
        PROGRESS = r105;
        NativeCell r110 = new NativeCell("RATINGBAR", 6, "RatingBar");
        RATINGBAR = r110;
        NativeCell r111 = new NativeCell("RICHTEXT", 7, "RichText");
        RICHTEXT = r111;
        NativeCell r112 = new NativeCell("SELECT", 8, "SingleSelect");
        SELECT = r112;
        NativeCell r113 = new NativeCell("MutilSELECT", 9, "MutilSelect");
        MutilSELECT = r113;
        NativeCell r114 = new NativeCell("SIMPLETEXT", 10, "SimpleText");
        SIMPLETEXT = r114;
        NativeCell r106 = new NativeCell("STAGE", 11, "Stage");
        STAGE = r106;
        NativeCell r107 = new NativeCell("User", 12, "User");
        User = r107;
        NativeCell r115 = new NativeCell("SingleUser", 13, "SingleUser");
        SingleUser = r115;
        NativeCell r108 = new NativeCell("FieldSelect", 14, "FieldSelect");
        FieldSelect = r108;
        NativeCell r109 = new NativeCell("NOT_SUPPORT", 15, "NotSupport");
        NOT_SUPPORT = r109;
        NativeCell r116 = new NativeCell("SIGNATURE", 16, "Signature");
        SIGNATURE = r116;
        NativeCell[] r117 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r115, r108, r109, r116};
        f209858a = r117;
        f209859b = EnumEntriesKt.enumEntries(r117);
    }

    public static NativeCell[] values() {
        return (NativeCell[]) f209858a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static NativeCell valueOf(String r100) {
        return (NativeCell) a.a(NativeCell.class, r100);
    }

    public NativeCell(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
