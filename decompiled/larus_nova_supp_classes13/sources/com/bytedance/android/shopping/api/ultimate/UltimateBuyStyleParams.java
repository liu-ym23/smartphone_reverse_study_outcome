package com.bytedance.android.shopping.api.ultimate;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyStyleParams;", "Ljava/io/Serializable;", "heightPercent", "", "maskAlpha", "", "(ILjava/lang/Float;)V", "getHeightPercent", "()I", "getMaskAlpha", "()Ljava/lang/Float;", "Ljava/lang/Float;", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class UltimateBuyStyleParams implements Serializable {

    @SerializedName("height_percent")
    private final int heightPercent;

    @SerializedName("mask_background_color")
    private final Float maskAlpha;

    public UltimateBuyStyleParams() {
        Float r0 = null;
        int r2 = 0;
        this(r2, r0, 3, r0);
    }

    public final int getHeightPercent() {
        return this.heightPercent;
    }

    public final Float getMaskAlpha() {
        return this.maskAlpha;
    }

    public UltimateBuyStyleParams(int r1, Float r2) {
        this.heightPercent = r1;
        this.maskAlpha = r2;
    }

    public /* synthetic */ UltimateBuyStyleParams(int r1, Float r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 73;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = Float.valueOf(0.5f);
    L8:
        this(r1, r2);
    }
}
