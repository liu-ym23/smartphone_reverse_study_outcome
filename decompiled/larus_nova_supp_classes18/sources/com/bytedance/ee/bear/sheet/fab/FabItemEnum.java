package com.bytedance.ee.bear.sheet.fab;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum FabItemEnum extends Enum<FabItemEnum> {
    public static final /* synthetic */ FabItemEnum[] a = null;
    public static final FabItemEnum bitableGrid = null;
    public static final FabItemEnum bitableKanban = null;
    public static final FabItemEnum cardMode = null;
    public static final FabItemEnum createRecord = null;
    public static final FabItemEnum input = null;
    public static final FabItemEnum kanbanZoomIn = null;
    public static final FabItemEnum kanbanZoomOut = null;
    public static final FabItemEnum operation = null;
    public static final FabItemEnum search = null;
    public static final FabItemEnum shareDashboard = null;
    public static final FabItemEnum shareForm = null;
    public int colorRes;
    public int imageRes;
    public int imageTintColorRes;
    public int type;

    public FabItemEnum() {
        throw null;
    }

    static {
        FabItemEnum r7 = new FabItemEnum("input", 0, 0, 2131254958, 2131100557, 2131101921);
        input = r7;
        FabItemEnum r0 = new FabItemEnum("cardMode", 1, 0, 2131255668, 2131100557, 2131105548);
        cardMode = r0;
        FabItemEnum r2 = new FabItemEnum(WikiFolderPushPlugin.OPT, 2, 2, 2131256033, 2131101922, 2131106521);
        operation = r2;
        FabItemEnum r3 = new FabItemEnum(ThumbGlideUrl.SOURCE_SEARCH, 3, 0, 2131254760, 2131100557, 2131105548);
        search = r3;
        FabItemEnum r4 = new FabItemEnum("bitableGrid", 4, 0, 2131253853, 2131100557, 2131105548);
        bitableGrid = r4;
        FabItemEnum r6 = new FabItemEnum("bitableKanban", 5, 0, 2131253854, 2131100557, 2131105548);
        bitableKanban = r6;
        FabItemEnum r18 = new FabItemEnum("kanbanZoomIn", 6, 0, 2131256308, 2131100557, 2131105548);
        kanbanZoomIn = r18;
        FabItemEnum r19 = new FabItemEnum("kanbanZoomOut", 7, 0, 2131256310, 2131100557, 2131105548);
        kanbanZoomOut = r19;
        FabItemEnum r1 = new FabItemEnum("createRecord", 8, 0, 2131253548, 2131103404, 2131106521);
        createRecord = r1;
        FabItemEnum r5 = new FabItemEnum("shareForm", 9);
        shareForm = r5;
        FabItemEnum r8 = new FabItemEnum("shareDashboard", 10);
        shareDashboard = r8;
        a = new FabItemEnum[]{r7, r0, r2, r3, r4, r6, r18, r19, r1, r5, r8};
    }

    public static FabItemEnum[] values() {
        return (FabItemEnum[]) a.clone();
    }

    public static FabItemEnum valueOf(String r1) {
        return (FabItemEnum) r27.a.a(FabItemEnum.class, r1);
    }

    public FabItemEnum(String r8, int r9) {
        this(r8, r9, 1, 0, 0, 0);
    }

    public FabItemEnum(String r1, int r2, int r3, int r4, int r5, int r6) {
        super(r1, r2);
        this.type = r3;
        this.imageRes = r4;
        this.colorRes = r5;
        this.imageTintColorRes = r6;
    }
}
