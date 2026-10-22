package com.bytedance.livesdk.preview.viewmodel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/livesdk/preview/viewmodel/PreviewViewHolderType;", "", "DEFAUT", "DetailAdLiveViewHolder", "DetailPreviewLiveViewHolder", "FeedCommonLiveViewHolder", "FeedVoipShareLiveViewHolder", "EcPreviewLiveViewHolder", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreviewViewHolderType extends Enum<PreviewViewHolderType> {
    public static final PreviewViewHolderType DEFAUT = null;
    public static final PreviewViewHolderType DetailAdLiveViewHolder = null;
    public static final PreviewViewHolderType DetailPreviewLiveViewHolder = null;
    public static final PreviewViewHolderType EcPreviewLiveViewHolder = null;
    public static final PreviewViewHolderType FeedCommonLiveViewHolder = null;
    public static final PreviewViewHolderType FeedVoipShareLiveViewHolder = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewViewHolderType[] f256444a = null;

    static {
        PreviewViewHolderType r100 = new PreviewViewHolderType("DEFAUT", 0);
        DEFAUT = r100;
        PreviewViewHolderType r101 = new PreviewViewHolderType("DetailAdLiveViewHolder", 1);
        DetailAdLiveViewHolder = r101;
        PreviewViewHolderType r102 = new PreviewViewHolderType("DetailPreviewLiveViewHolder", 2);
        DetailPreviewLiveViewHolder = r102;
        PreviewViewHolderType r103 = new PreviewViewHolderType("FeedCommonLiveViewHolder", 3);
        FeedCommonLiveViewHolder = r103;
        PreviewViewHolderType r104 = new PreviewViewHolderType("FeedVoipShareLiveViewHolder", 4);
        FeedVoipShareLiveViewHolder = r104;
        PreviewViewHolderType r105 = new PreviewViewHolderType("EcPreviewLiveViewHolder", 5);
        EcPreviewLiveViewHolder = r105;
        f256444a = new PreviewViewHolderType[]{r100, r101, r102, r103, r104, r105};
    }

    public static PreviewViewHolderType valueOf(String r100) {
        return (PreviewViewHolderType) r27.a.a(PreviewViewHolderType.class, r100);
    }

    public static PreviewViewHolderType[] values() {
        return (PreviewViewHolderType[]) f256444a.clone();
    }

    public PreviewViewHolderType(String r100, int r101) {
        super(r100, r101);
    }
}
