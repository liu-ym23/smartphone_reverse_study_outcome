package com.ss.android.ugc.aweme.discover.mixfeed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/mixfeed/DividerColorConfig;", "Ljava/io/Serializable;", "()V", "darkColor", "", "getDarkColor", "()Ljava/lang/String;", "lightColor", "getLightColor", "equals", "", "other", "", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DividerColorConfig implements Serializable {

    @SerializedName("dark_color")
    private final String darkColor;

    @SerializedName("light_color")
    private final String lightColor;

    public DividerColorConfig() {
    }

    public final String getDarkColor() {
        return this.darkColor;
    }

    public final String getLightColor() {
        return this.lightColor;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DividerColorConfig) == false) goto L5;
        DividerColorConfig r101 = (DividerColorConfig) r100;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r101.lightColor, this.lightColor) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r101.darkColor, this.darkColor) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        r101 = null;
        goto L7
    }
}
