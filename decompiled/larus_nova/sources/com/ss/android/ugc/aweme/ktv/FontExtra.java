package com.ss.android.ugc.aweme.ktv;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/ktv/FontExtra;", "", "()V", "isItalic", "", "()Z", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class FontExtra {

    @SerializedName("UseItalic")
    private final boolean isItalic;

    public FontExtra() {
    }

    public final boolean isItalic() {
        return this.isItalic;
    }
}
