package com.bytedance.livesdk.preview.merge;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/livesdk/preview/merge/PreviewViewHolderStatus;", "", ErrorCode.INIT, "ON_BIND", "ON_SELECT", "ON_PAUSE", "UN_SELECT", "UN_BIND", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreviewViewHolderStatus extends Enum<PreviewViewHolderStatus> {
    public static final PreviewViewHolderStatus INIT = null;
    public static final PreviewViewHolderStatus ON_BIND = null;
    public static final PreviewViewHolderStatus ON_PAUSE = null;
    public static final PreviewViewHolderStatus ON_SELECT = null;
    public static final PreviewViewHolderStatus UN_BIND = null;
    public static final PreviewViewHolderStatus UN_SELECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewViewHolderStatus[] f256443a = null;

    static {
        PreviewViewHolderStatus r100 = new PreviewViewHolderStatus(ErrorCode.INIT, 0);
        INIT = r100;
        PreviewViewHolderStatus r101 = new PreviewViewHolderStatus("ON_BIND", 1);
        ON_BIND = r101;
        PreviewViewHolderStatus r102 = new PreviewViewHolderStatus("ON_SELECT", 2);
        ON_SELECT = r102;
        PreviewViewHolderStatus r103 = new PreviewViewHolderStatus("ON_PAUSE", 3);
        ON_PAUSE = r103;
        PreviewViewHolderStatus r104 = new PreviewViewHolderStatus("UN_SELECT", 4);
        UN_SELECT = r104;
        PreviewViewHolderStatus r105 = new PreviewViewHolderStatus("UN_BIND", 5);
        UN_BIND = r105;
        f256443a = new PreviewViewHolderStatus[]{r100, r101, r102, r103, r104, r105};
    }

    public static PreviewViewHolderStatus valueOf(String r100) {
        return (PreviewViewHolderStatus) r27.a.a(PreviewViewHolderStatus.class, r100);
    }

    public static PreviewViewHolderStatus[] values() {
        return (PreviewViewHolderStatus[]) f256443a.clone();
    }

    public PreviewViewHolderStatus(String r100, int r101) {
        super(r100, r101);
    }
}
