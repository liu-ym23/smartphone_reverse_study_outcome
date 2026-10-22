package com.larus.home.impl.main.side_bar.data;

import com.android.ttcjpaysdk.base.ui.Utils.CJPayDiscountTextUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/DividerTypeEnum;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", CJPayDiscountTextUtils.CJ_PAY_STRIKE_THROUGH_TEXT_STYLE, "BLANK_SPACE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DividerTypeEnum extends Enum<DividerTypeEnum> {
    public static final DividerTypeEnum BLANK_SPACE = null;
    public static final DividerTypeEnum LINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DividerTypeEnum[] f344426a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344427b = null;
    private final int type;

    public static EnumEntries<DividerTypeEnum> getEntries() {
        return f344427b;
    }

    static {
        DividerTypeEnum r100 = new DividerTypeEnum(CJPayDiscountTextUtils.CJ_PAY_STRIKE_THROUGH_TEXT_STYLE, 0, 0);
        LINE = r100;
        DividerTypeEnum r101 = new DividerTypeEnum("BLANK_SPACE", 1, 1);
        BLANK_SPACE = r101;
        DividerTypeEnum[] r102 = {r100, r101};
        f344426a = r102;
        f344427b = EnumEntriesKt.enumEntries(r102);
    }

    public static DividerTypeEnum[] values() {
        return (DividerTypeEnum[]) f344426a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static DividerTypeEnum valueOf(String r100) {
        return (DividerTypeEnum) r27.a.a(DividerTypeEnum.class, r100);
    }

    public DividerTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
