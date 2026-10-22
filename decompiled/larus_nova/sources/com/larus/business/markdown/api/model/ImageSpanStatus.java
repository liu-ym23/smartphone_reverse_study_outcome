package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/business/markdown/api/model/ImageSpanStatus;", "", "IDLE", "LOADING", "SUCC", "FAIL", "FAIL_NO_RETRY", "markdown-api_release"}, k = 1, mv = {1, 7, 1})
public final enum ImageSpanStatus extends Enum<ImageSpanStatus> {
    public static final ImageSpanStatus FAIL = null;
    public static final ImageSpanStatus FAIL_NO_RETRY = null;
    public static final ImageSpanStatus IDLE = null;
    public static final ImageSpanStatus LOADING = null;
    public static final ImageSpanStatus SUCC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageSpanStatus[] f320478a = null;

    public static ImageSpanStatus valueOf(String r100) {
        return (ImageSpanStatus) a.a(ImageSpanStatus.class, r100);
    }

    public static ImageSpanStatus[] values() {
        return (ImageSpanStatus[]) f320478a.clone();
    }

    static {
        ImageSpanStatus r100 = new ImageSpanStatus("IDLE", 0);
        IDLE = r100;
        ImageSpanStatus r101 = new ImageSpanStatus("LOADING", 1);
        LOADING = r101;
        ImageSpanStatus r102 = new ImageSpanStatus("SUCC", 2);
        SUCC = r102;
        ImageSpanStatus r103 = new ImageSpanStatus("FAIL", 3);
        FAIL = r103;
        ImageSpanStatus r104 = new ImageSpanStatus("FAIL_NO_RETRY", 4);
        FAIL_NO_RETRY = r104;
        f320478a = new ImageSpanStatus[]{r100, r101, r102, r103, r104};
    }

    public ImageSpanStatus(String r100, int r101) {
        super(r100, r101);
    }
}
