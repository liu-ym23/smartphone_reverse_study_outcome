package com.bytedance.ee.bear.drive.loader.model;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final /* synthetic */ InfoCode[] a = null;

    static {
        InfoCode r0 = new InfoCode("OnAttach", 0);
        OnAttach = r0;
        InfoCode r1 = new InfoCode("OnDetach", 1);
        OnDetach = r1;
        InfoCode r3 = new InfoCode("LoadStart", 2);
        LoadStart = r3;
        InfoCode r5 = new InfoCode("PreFetchFileInfo", 3);
        PreFetchFileInfo = r5;
        InfoCode r7 = new InfoCode("FileInfoSuccess", 4);
        FileInfoSuccess = r7;
        InfoCode r9 = new InfoCode("SheetInfoSuccess", 5);
        SheetInfoSuccess = r9;
        InfoCode r11 = new InfoCode("SlidesInfoSuccess", 6);
        SlidesInfoSuccess = r11;
        InfoCode r13 = new InfoCode("Generating", 7);
        Generating = r13;
        InfoCode r16 = new InfoCode("GenerateFinished", 8);
        GenerateFinished = r16;
        InfoCode r14 = new InfoCode("GenerateFailed", 9);
        GenerateFailed = r14;
        InfoCode r12 = new InfoCode("ShowCommitted", 10);
        ShowCommitted = r12;
        InfoCode r10 = new InfoCode("SummitDownloadTask", 11);
        SummitDownloadTask = r10;
        InfoCode r8 = new InfoCode("HitCache", 12);
        HitCache = r8;
        InfoCode r6 = new InfoCode("FileNotChange", 13);
        FileNotChange = r6;
        InfoCode r4 = new InfoCode("DownloadSuccess", 14);
        DownloadSuccess = r4;
        InfoCode r2 = new InfoCode("WPS_PREVIEW", 15);
        WPS_PREVIEW = r2;
        InfoCode r17 = new InfoCode("SHEET_PREVIEW", 16);
        SHEET_PREVIEW = r17;
        InfoCode r18 = new InfoCode("SLIDES_PREVIEW", 17);
        SLIDES_PREVIEW = r18;
        InfoCode r19 = new InfoCode("MobileNetworkWarning", 18);
        MobileNetworkWarning = r19;
        a = new InfoCode[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14, r12, r10, r8, r6, r4, r2, r17, r18, r19};
    }

    public static InfoCode[] values() {
        return (InfoCode[]) a.clone();
    }

    public static InfoCode valueOf(String r1) {
        return (InfoCode) a.a(InfoCode.class, r1);
    }

    public InfoCode(String r1, int r2) {
        super(r1, r2);
    }
}
