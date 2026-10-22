package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum DriveBizScene extends Enum<DriveBizScene> implements WireEnum {
    private static final /* synthetic */ DriveBizScene[] $VALUES = null;
    public static final ProtoAdapter<DriveBizScene> ADAPTER = null;
    public static final DriveBizScene DriveBizScene_BASE = null;
    public static final DriveBizScene DriveBizScene_BOARD = null;
    public static final DriveBizScene DriveBizScene_CALENDAR = null;
    public static final DriveBizScene DriveBizScene_CCM = null;
    public static final DriveBizScene DriveBizScene_IM = null;
    public static final DriveBizScene DriveBizScene_MAIL = null;
    public static final DriveBizScene DriveBizScene_MINI_APP = null;
    public static final DriveBizScene DriveBizScene_OKR = null;
    public static final DriveBizScene DriveBizScene_REPORT = null;
    public static final DriveBizScene DriveBizScene_TASK = null;
    public static final DriveBizScene DriveBizScene_UNKNOWN = null;
    public static final DriveBizScene DriveBizScene_VC = null;
    public static final DriveBizScene DriveBizScene_WORKFLOW = null;
    private final int value;

    static {
        DriveBizScene r100 = new DriveBizScene("DriveBizScene_UNKNOWN", 0, 0);
        DriveBizScene_UNKNOWN = r100;
        DriveBizScene r101 = new DriveBizScene("DriveBizScene_IM", 1, 1);
        DriveBizScene_IM = r101;
        DriveBizScene r102 = new DriveBizScene("DriveBizScene_CCM", 2, 2);
        DriveBizScene_CCM = r102;
        DriveBizScene r103 = new DriveBizScene("DriveBizScene_VC", 3, 3);
        DriveBizScene_VC = r103;
        DriveBizScene r104 = new DriveBizScene("DriveBizScene_BASE", 4, 4);
        DriveBizScene_BASE = r104;
        DriveBizScene r105 = new DriveBizScene("DriveBizScene_MINI_APP", 5, 5);
        DriveBizScene_MINI_APP = r105;
        DriveBizScene r110 = new DriveBizScene("DriveBizScene_CALENDAR", 6, 6);
        DriveBizScene_CALENDAR = r110;
        DriveBizScene r111 = new DriveBizScene("DriveBizScene_TASK", 7, 7);
        DriveBizScene_TASK = r111;
        DriveBizScene r112 = new DriveBizScene("DriveBizScene_MAIL", 8, 8);
        DriveBizScene_MAIL = r112;
        DriveBizScene r113 = new DriveBizScene("DriveBizScene_REPORT", 9, 9);
        DriveBizScene_REPORT = r113;
        DriveBizScene r114 = new DriveBizScene("DriveBizScene_OKR", 10, 10);
        DriveBizScene_OKR = r114;
        DriveBizScene r115 = new DriveBizScene("DriveBizScene_BOARD", 11, 11);
        DriveBizScene_BOARD = r115;
        DriveBizScene r106 = new DriveBizScene("DriveBizScene_WORKFLOW", 12, 12);
        DriveBizScene_WORKFLOW = r106;
        $VALUES = new DriveBizScene[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        ADAPTER = ProtoAdapter.newEnumAdapter(DriveBizScene.class);
    }

    public static DriveBizScene[] values() {
        return (DriveBizScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DriveBizScene fromValue(int r100) {
        switch(r100) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return DriveBizScene_WORKFLOW;
    L8:
        return DriveBizScene_BOARD;
    L10:
        return DriveBizScene_OKR;
    L12:
        return DriveBizScene_REPORT;
    L14:
        return DriveBizScene_MAIL;
    L16:
        return DriveBizScene_TASK;
    L18:
        return DriveBizScene_CALENDAR;
    L20:
        return DriveBizScene_MINI_APP;
    L22:
        return DriveBizScene_BASE;
    L24:
        return DriveBizScene_VC;
    L26:
        return DriveBizScene_CCM;
    L28:
        return DriveBizScene_IM;
    L30:
        return DriveBizScene_UNKNOWN;
    }

    public static DriveBizScene valueOf(String r100) {
        return (DriveBizScene) a.a(DriveBizScene.class, r100);
    }

    private DriveBizScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
