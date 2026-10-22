package com.ss.android.ugc.tools.infosticker.repository.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/tools/infosticker/repository/api/InfoStickerState;", "", "INFO_STICKER_STATE_UNKNOWN", "INFO_STICKER_STATE_NOT_DOWNLOAD", "INFO_STICKER_STATE_DOWNLOADING", "INFO_STICKER_STATE_DOWNLOAD_SUCCESS", "INFO_STICKER_STATE_DOWNLOAD_FAILED", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final enum InfoStickerState extends Enum<InfoStickerState> {
    public static final InfoStickerState INFO_STICKER_STATE_DOWNLOADING = null;
    public static final InfoStickerState INFO_STICKER_STATE_DOWNLOAD_FAILED = null;
    public static final InfoStickerState INFO_STICKER_STATE_DOWNLOAD_SUCCESS = null;
    public static final InfoStickerState INFO_STICKER_STATE_NOT_DOWNLOAD = null;
    public static final InfoStickerState INFO_STICKER_STATE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InfoStickerState[] f454821a = null;

    static {
        InfoStickerState r100 = new InfoStickerState("INFO_STICKER_STATE_UNKNOWN", 0);
        INFO_STICKER_STATE_UNKNOWN = r100;
        InfoStickerState r101 = new InfoStickerState("INFO_STICKER_STATE_NOT_DOWNLOAD", 1);
        INFO_STICKER_STATE_NOT_DOWNLOAD = r101;
        InfoStickerState r102 = new InfoStickerState("INFO_STICKER_STATE_DOWNLOADING", 2);
        INFO_STICKER_STATE_DOWNLOADING = r102;
        InfoStickerState r103 = new InfoStickerState("INFO_STICKER_STATE_DOWNLOAD_SUCCESS", 3);
        INFO_STICKER_STATE_DOWNLOAD_SUCCESS = r103;
        InfoStickerState r104 = new InfoStickerState("INFO_STICKER_STATE_DOWNLOAD_FAILED", 4);
        INFO_STICKER_STATE_DOWNLOAD_FAILED = r104;
        f454821a = new InfoStickerState[]{r100, r101, r102, r103, r104};
    }

    public static InfoStickerState valueOf(String r100) {
        return (InfoStickerState) a.a(InfoStickerState.class, r100);
    }

    public static InfoStickerState[] values() {
        return (InfoStickerState[]) f454821a.clone();
    }

    public InfoStickerState(String r100, int r101) {
        super(r100, r101);
    }
}
