package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum COTStatus extends Enum<COTStatus> implements WireEnum {
    private static final /* synthetic */ COTStatus[] $VALUES = null;
    public static final ProtoAdapter<COTStatus> ADAPTER = null;
    public static final COTStatus COT_STATUS_DONE = null;
    public static final COTStatus COT_STATUS_ERROR = null;
    public static final COTStatus COT_STATUS_NONE = null;
    public static final COTStatus COT_STATUS_RUNNING = null;
    public static final COTStatus COT_STATUS_TIMEOUT = null;
    private final int value;

    static {
        COTStatus r100 = new COTStatus("COT_STATUS_NONE", 0, 0);
        COT_STATUS_NONE = r100;
        COTStatus r101 = new COTStatus("COT_STATUS_RUNNING", 1, 1);
        COT_STATUS_RUNNING = r101;
        COTStatus r102 = new COTStatus("COT_STATUS_DONE", 2, 2);
        COT_STATUS_DONE = r102;
        COTStatus r103 = new COTStatus("COT_STATUS_ERROR", 3, 3);
        COT_STATUS_ERROR = r103;
        COTStatus r104 = new COTStatus("COT_STATUS_TIMEOUT", 4, 4);
        COT_STATUS_TIMEOUT = r104;
        $VALUES = new COTStatus[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(COTStatus.class);
    }

    public static COTStatus[] values() {
        return (COTStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static COTStatus fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return COT_STATUS_TIMEOUT;
    L16:
        return COT_STATUS_ERROR;
    L18:
        return COT_STATUS_DONE;
    L20:
        return COT_STATUS_RUNNING;
    L22:
        return COT_STATUS_NONE;
    }

    public static COTStatus valueOf(String r100) {
        return (COTStatus) a.a(COTStatus.class, r100);
    }

    private COTStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
