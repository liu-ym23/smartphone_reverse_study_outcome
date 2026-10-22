package com.bytedance.locallife.pdp.groupondetail.vo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/pdp/groupondetail/vo/CommonContentVOType;", "", "", "type", "I", "getType", "()I", "TYPE_1", "TYPE_2", "TYPE_3", "TYPE_4", "TYPE_5", "TYPE_6", "TYPE_7", "TYPE_8", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum CommonContentVOType extends Enum<CommonContentVOType> {
    public static final CommonContentVOType TYPE_1 = null;
    public static final CommonContentVOType TYPE_2 = null;
    public static final CommonContentVOType TYPE_3 = null;
    public static final CommonContentVOType TYPE_4 = null;
    public static final CommonContentVOType TYPE_5 = null;
    public static final CommonContentVOType TYPE_6 = null;
    public static final CommonContentVOType TYPE_7 = null;
    public static final CommonContentVOType TYPE_8 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommonContentVOType[] f261458a = null;
    private final int type;

    public static CommonContentVOType valueOf(String r100) {
        return (CommonContentVOType) a.a(CommonContentVOType.class, r100);
    }

    public static CommonContentVOType[] values() {
        return (CommonContentVOType[]) f261458a.clone();
    }

    static {
        CommonContentVOType r100 = new CommonContentVOType("TYPE_1", 0, 1);
        TYPE_1 = r100;
        CommonContentVOType r101 = new CommonContentVOType("TYPE_2", 1, 2);
        TYPE_2 = r101;
        CommonContentVOType r102 = new CommonContentVOType("TYPE_3", 2, 3);
        TYPE_3 = r102;
        CommonContentVOType r103 = new CommonContentVOType("TYPE_4", 3, 4);
        TYPE_4 = r103;
        CommonContentVOType r104 = new CommonContentVOType("TYPE_5", 4, 5);
        TYPE_5 = r104;
        CommonContentVOType r110 = new CommonContentVOType("TYPE_6", 5, 6);
        TYPE_6 = r110;
        CommonContentVOType r111 = new CommonContentVOType("TYPE_7", 6, 7);
        TYPE_7 = r111;
        CommonContentVOType r112 = new CommonContentVOType("TYPE_8", 7, 8);
        TYPE_8 = r112;
        f261458a = new CommonContentVOType[]{r100, r101, r102, r103, r104, r110, r111, r112};
    }

    public final int getType() {
        return this.type;
    }

    public CommonContentVOType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
