package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/p;", "", "", "poiPromptMark", "I", "getPoiPromptMark", "()I", "setPoiPromptMark", "(I)V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class p {

    @SerializedName("item_patch_poi_prompt_mark")
    private int poiPromptMark;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L9;
        return false;
    L9:
        if (this.poiPromptMark == ((p) r100).poiPromptMark) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.poiPromptMark;
    }

    public final String toString() {
        return "PoiPatchStruct(poiPromptMark=" + this.poiPromptMark + ')';
    }
}
