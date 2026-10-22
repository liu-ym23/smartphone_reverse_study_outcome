package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/ExposureEventDetail;", "", "sign", "", "exposureID", "", "exposureScene", "(ILjava/lang/String;Ljava/lang/String;)V", "getExposureID", "()Ljava/lang/String;", "setExposureID", "(Ljava/lang/String;)V", "getExposureScene", "setExposureScene", "getSign", "()I", "setSign", "(I)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExposureEventDetail {
    private String exposureID;
    private String exposureScene;
    private int sign;

    public final String getExposureID() {
        return this.exposureID;
    }

    public final String getExposureScene() {
        return this.exposureScene;
    }

    public final int getSign() {
        return this.sign;
    }

    public final void setExposureID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.exposureID = r100;
    }

    public final void setExposureScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.exposureScene = r100;
    }

    public final void setSign(int r100) {
        this.sign = r100;
    }

    public ExposureEventDetail(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "exposureID");
        Intrinsics.checkNotNullParameter(r102, "exposureScene");
        this.sign = r100;
        this.exposureID = r101;
        this.exposureScene = r102;
    }
}
