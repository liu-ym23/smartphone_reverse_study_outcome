package com.ss.android.ugc.aweme.search.vision.result.v1;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/v1/PhotoSearchAiContainerStatusType;", "", "Open", "Close", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PhotoSearchAiContainerStatusType extends Enum<PhotoSearchAiContainerStatusType> {
    public static final PhotoSearchAiContainerStatusType Close = null;
    public static final PhotoSearchAiContainerStatusType Open = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PhotoSearchAiContainerStatusType[] f453843a = null;

    static {
        PhotoSearchAiContainerStatusType r100 = new PhotoSearchAiContainerStatusType("Open", 0);
        Open = r100;
        PhotoSearchAiContainerStatusType r101 = new PhotoSearchAiContainerStatusType("Close", 1);
        Close = r101;
        f453843a = new PhotoSearchAiContainerStatusType[]{r100, r101};
    }

    public static PhotoSearchAiContainerStatusType valueOf(String r100) {
        return (PhotoSearchAiContainerStatusType) a.a(PhotoSearchAiContainerStatusType.class, r100);
    }

    public static PhotoSearchAiContainerStatusType[] values() {
        return (PhotoSearchAiContainerStatusType[]) f453843a.clone();
    }

    public PhotoSearchAiContainerStatusType(String r100, int r101) {
        super(r100, r101);
    }
}
