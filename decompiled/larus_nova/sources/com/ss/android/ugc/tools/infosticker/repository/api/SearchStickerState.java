package com.ss.android.ugc.tools.infosticker.repository.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/tools/infosticker/repository/api/SearchStickerState;", "", "SEARCH_STICKER_STICKER_UNKNOWN", "SEARCH_STICKER_STICKER_NOT_DOWNLOAD", "SEARCH_STICKER_STICKER_DOWNLOADING", "SEARCH_STICKER_STICKER_DOWNLOAD_SUCCESS", "SEARCH_STICKER_STICKER_DOWNLOAD_FAILED", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final enum SearchStickerState extends Enum<SearchStickerState> {
    public static final SearchStickerState SEARCH_STICKER_STICKER_DOWNLOADING = null;
    public static final SearchStickerState SEARCH_STICKER_STICKER_DOWNLOAD_FAILED = null;
    public static final SearchStickerState SEARCH_STICKER_STICKER_DOWNLOAD_SUCCESS = null;
    public static final SearchStickerState SEARCH_STICKER_STICKER_NOT_DOWNLOAD = null;
    public static final SearchStickerState SEARCH_STICKER_STICKER_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchStickerState[] f454823a = null;

    static {
        SearchStickerState r100 = new SearchStickerState("SEARCH_STICKER_STICKER_UNKNOWN", 0);
        SEARCH_STICKER_STICKER_UNKNOWN = r100;
        SearchStickerState r101 = new SearchStickerState("SEARCH_STICKER_STICKER_NOT_DOWNLOAD", 1);
        SEARCH_STICKER_STICKER_NOT_DOWNLOAD = r101;
        SearchStickerState r102 = new SearchStickerState("SEARCH_STICKER_STICKER_DOWNLOADING", 2);
        SEARCH_STICKER_STICKER_DOWNLOADING = r102;
        SearchStickerState r103 = new SearchStickerState("SEARCH_STICKER_STICKER_DOWNLOAD_SUCCESS", 3);
        SEARCH_STICKER_STICKER_DOWNLOAD_SUCCESS = r103;
        SearchStickerState r104 = new SearchStickerState("SEARCH_STICKER_STICKER_DOWNLOAD_FAILED", 4);
        SEARCH_STICKER_STICKER_DOWNLOAD_FAILED = r104;
        f454823a = new SearchStickerState[]{r100, r101, r102, r103, r104};
    }

    public static SearchStickerState valueOf(String r100) {
        return (SearchStickerState) a.a(SearchStickerState.class, r100);
    }

    public static SearchStickerState[] values() {
        return (SearchStickerState[]) f454823a.clone();
    }

    public SearchStickerState(String r100, int r101) {
        super(r100, r101);
    }
}
