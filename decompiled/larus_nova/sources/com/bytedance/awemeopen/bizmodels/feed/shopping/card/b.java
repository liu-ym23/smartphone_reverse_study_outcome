package com.bytedance.awemeopen.bizmodels.feed.shopping.card;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/b;", "", "", "anchorSuffixUI", "I", "getAnchorSuffixUI", "()I", "titleReplace", "getTitleReplace", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class b {

    @SerializedName("anchor_suffix_ui")
    private final int anchorSuffixUI;

    @SerializedName("title_replace")
    private final int titleReplace;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.anchorSuffixUI == r101.anchorSuffixUI) goto L12;
        return false;
    L12:
        if (this.titleReplace == r101.titleReplace) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.anchorSuffixUI * 31) + this.titleReplace;
    }

    public final String toString() {
        return "AnchorSuffixUIConfig(anchorSuffixUI=" + this.anchorSuffixUI + ", titleReplace=" + this.titleReplace + ')';
    }

    public b() {
        this.anchorSuffixUI = 0;
        this.titleReplace = 0;
    }
}
