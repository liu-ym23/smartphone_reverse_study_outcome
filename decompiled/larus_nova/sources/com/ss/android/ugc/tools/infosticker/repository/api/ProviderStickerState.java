package com.ss.android.ugc.tools.infosticker.repository.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/tools/infosticker/repository/api/ProviderStickerState;", "", "PROVIDER_STICKER_STATE_UNKNOWN", "PROVIDER_STICKER_STATE_NOT_DOWNLOAD", "PROVIDER_STICKER_STATE_DOWNLOADING", "PROVIDER_STICKER_STATE_DOWNLOAD_SUCCESS", "PROVIDER_STICKER_STATE_DOWNLOAD_FAILED", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final enum ProviderStickerState extends Enum<ProviderStickerState> {
    public static final ProviderStickerState PROVIDER_STICKER_STATE_DOWNLOADING = null;
    public static final ProviderStickerState PROVIDER_STICKER_STATE_DOWNLOAD_FAILED = null;
    public static final ProviderStickerState PROVIDER_STICKER_STATE_DOWNLOAD_SUCCESS = null;
    public static final ProviderStickerState PROVIDER_STICKER_STATE_NOT_DOWNLOAD = null;
    public static final ProviderStickerState PROVIDER_STICKER_STATE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProviderStickerState[] f454822a = null;

    static {
        ProviderStickerState r100 = new ProviderStickerState("PROVIDER_STICKER_STATE_UNKNOWN", 0);
        PROVIDER_STICKER_STATE_UNKNOWN = r100;
        ProviderStickerState r101 = new ProviderStickerState("PROVIDER_STICKER_STATE_NOT_DOWNLOAD", 1);
        PROVIDER_STICKER_STATE_NOT_DOWNLOAD = r101;
        ProviderStickerState r102 = new ProviderStickerState("PROVIDER_STICKER_STATE_DOWNLOADING", 2);
        PROVIDER_STICKER_STATE_DOWNLOADING = r102;
        ProviderStickerState r103 = new ProviderStickerState("PROVIDER_STICKER_STATE_DOWNLOAD_SUCCESS", 3);
        PROVIDER_STICKER_STATE_DOWNLOAD_SUCCESS = r103;
        ProviderStickerState r104 = new ProviderStickerState("PROVIDER_STICKER_STATE_DOWNLOAD_FAILED", 4);
        PROVIDER_STICKER_STATE_DOWNLOAD_FAILED = r104;
        f454822a = new ProviderStickerState[]{r100, r101, r102, r103, r104};
    }

    public static ProviderStickerState valueOf(String r100) {
        return (ProviderStickerState) a.a(ProviderStickerState.class, r100);
    }

    public static ProviderStickerState[] values() {
        return (ProviderStickerState[]) f454822a.clone();
    }

    public ProviderStickerState(String r100, int r101) {
        super(r100, r101);
    }
}
