package com.ss.android.ugc.aweme.search.vision.model.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/data/ResultPanelStatus;", "", "", "value", "I", "getValue", "()I", "FULLSCREEN", "HALFSCREEN", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ResultPanelStatus extends Enum<ResultPanelStatus> {
    public static final ResultPanelStatus FULLSCREEN = null;
    public static final ResultPanelStatus HALFSCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultPanelStatus[] f453631a = null;
    private final int value;

    static {
        ResultPanelStatus r100 = new ResultPanelStatus("FULLSCREEN", 0, 10);
        FULLSCREEN = r100;
        ResultPanelStatus r101 = new ResultPanelStatus("HALFSCREEN", 1, 7);
        HALFSCREEN = r101;
        f453631a = new ResultPanelStatus[]{r100, r101};
    }

    public static ResultPanelStatus valueOf(String r100) {
        return (ResultPanelStatus) a.a(ResultPanelStatus.class, r100);
    }

    public static ResultPanelStatus[] values() {
        return (ResultPanelStatus[]) f453631a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ResultPanelStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
