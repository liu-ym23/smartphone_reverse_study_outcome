package com.bytedance.ies.xbridge.media.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/ies/xbridge/media/model/XDownloadFileMethodParamModel$SaveWay", "", "Lcom/bytedance/ies/xbridge/media/model/XDownloadFileMethodParamModel$SaveWay;", "video", "image", "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final enum XDownloadFileMethodParamModel$SaveWay extends Enum<XDownloadFileMethodParamModel$SaveWay> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XDownloadFileMethodParamModel$SaveWay[] f249506a = null;
    public static final XDownloadFileMethodParamModel$SaveWay image = null;
    public static final XDownloadFileMethodParamModel$SaveWay video = null;

    public static XDownloadFileMethodParamModel$SaveWay valueOf(String r100) {
        return (XDownloadFileMethodParamModel$SaveWay) a.a(XDownloadFileMethodParamModel$SaveWay.class, r100);
    }

    public static XDownloadFileMethodParamModel$SaveWay[] values() {
        return (XDownloadFileMethodParamModel$SaveWay[]) f249506a.clone();
    }

    static {
        XDownloadFileMethodParamModel$SaveWay r100 = new XDownloadFileMethodParamModel$SaveWay("video", 0);
        video = r100;
        XDownloadFileMethodParamModel$SaveWay r101 = new XDownloadFileMethodParamModel$SaveWay("image", 1);
        image = r101;
        f249506a = new XDownloadFileMethodParamModel$SaveWay[]{r100, r101};
    }

    public XDownloadFileMethodParamModel$SaveWay(String r100, int r101) {
        super(r100, r101);
    }
}
