package com.bytedance.ee.bear.drive.loader.model;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum InfoCode extends Enum<InfoCode> {
    public static final InfoCode DownloadSuccess = null;
    public static final InfoCode FileInfoSuccess = null;
    public static final InfoCode FileNotChange = null;
    public static final InfoCode GenerateFailed = null;
    public static final InfoCode GenerateFinished = null;
    public static final InfoCode Generating = null;
    public static final InfoCode HitCache = null;
    public static final InfoCode LoadStart = null;
    public static final InfoCode MobileNetworkWarning = null;
    public static final InfoCode OnAttach = null;
    public static final InfoCode OnDetach = null;
    public static final InfoCode PreFetchFileInfo = null;
    public static final InfoCode SHEET_PREVIEW = null;
    public static final InfoCode SLIDES_PREVIEW = null;
    public static final InfoCode SheetInfoSuccess = null;
    public static final InfoCode ShowCommitted = null;
    public static final InfoCode SlidesInfoSuccess = null;
    public static final InfoCode SummitDownloadTask = null;
    public static final InfoCode WPS_PREVIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InfoCode[] f224478a = null;

    static {
        InfoCode r100 = new InfoCode("OnAttach", 0);
        OnAttach = r100;
        InfoCode r101 = new InfoCode("OnDetach", 1);
        OnDetach = r101;
        InfoCode r102 = new InfoCode("LoadStart", 2);
        LoadStart = r102;
        InfoCode r103 = new InfoCode("PreFetchFileInfo", 3);
        PreFetchFileInfo = r103;
        InfoCode r104 = new InfoCode("FileInfoSuccess", 4);
        FileInfoSuccess = r104;
        InfoCode r105 = new InfoCode("SheetInfoSuccess", 5);
        SheetInfoSuccess = r105;
        InfoCode r110 = new InfoCode("SlidesInfoSuccess", 6);
        SlidesInfoSuccess = r110;
        InfoCode r111 = new InfoCode("Generating", 7);
        Generating = r111;
        InfoCode r112 = new InfoCode("GenerateFinished", 8);
        GenerateFinished = r112;
        InfoCode r113 = new InfoCode("GenerateFailed", 9);
        GenerateFailed = r113;
        InfoCode r114 = new InfoCode("ShowCommitted", 10);
        ShowCommitted = r114;
        InfoCode r115 = new InfoCode("SummitDownloadTask", 11);
        SummitDownloadTask = r115;
        InfoCode r106 = new InfoCode("HitCache", 12);
        HitCache = r106;
        InfoCode r107 = new InfoCode("FileNotChange", 13);
        FileNotChange = r107;
        InfoCode r108 = new InfoCode("DownloadSuccess", 14);
        DownloadSuccess = r108;
        InfoCode r109 = new InfoCode("WPS_PREVIEW", 15);
        WPS_PREVIEW = r109;
        InfoCode r116 = new InfoCode("SHEET_PREVIEW", 16);
        SHEET_PREVIEW = r116;
        InfoCode r117 = new InfoCode("SLIDES_PREVIEW", 17);
        SLIDES_PREVIEW = r117;
        InfoCode r118 = new InfoCode("MobileNetworkWarning", 18);
        MobileNetworkWarning = r118;
        f224478a = new InfoCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
    }

    public static InfoCode[] values() {
        return (InfoCode[]) f224478a.clone();
    }

    public static InfoCode valueOf(String r100) {
        return (InfoCode) a.a(InfoCode.class, r100);
    }

    public InfoCode(String r100, int r101) {
        super(r100, r101);
    }
}
