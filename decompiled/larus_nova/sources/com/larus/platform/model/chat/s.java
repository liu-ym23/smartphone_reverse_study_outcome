package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/chat/FirstMetFilterConfig;", "", "maxShowCnt", "", "minShowCnt", "enableDedupe", "", "enableFilterIllegalSuggest", "<init>", "(IIZZ)V", "getMaxShowCnt", "()I", "getMinShowCnt", "getEnableDedupe", "()Z", "getEnableFilterIllegalSuggest", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s {

    @SerializedName("enable_dedupe")
    private final boolean enableDedupe;

    @SerializedName("enable_filter_illegal_suggest")
    private final boolean enableFilterIllegalSuggest;

    @SerializedName("max_show_cnt")
    private final int maxShowCnt;

    @SerializedName("min_show_cnt")
    private final int minShowCnt;

    public s() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.maxShowCnt == r101.maxShowCnt) goto L12;
        return false;
    L12:
        if (this.minShowCnt == r101.minShowCnt) goto L15;
        return false;
    L15:
        if (this.enableDedupe == r101.enableDedupe) goto L18;
        return false;
    L18:
        if (this.enableFilterIllegalSuggest == r101.enableFilterIllegalSuggest) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.maxShowCnt * 31) + this.minShowCnt) * 31;
        int r101 = 1231;
        if (this.enableDedupe == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.enableFilterIllegalSuggest == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FirstMetFilterConfig(maxShowCnt=" + this.maxShowCnt + ", minShowCnt=" + this.minShowCnt + ", enableDedupe=" + this.enableDedupe + ", enableFilterIllegalSuggest=" + this.enableFilterIllegalSuggest + ')';
    }

    public final boolean a() {
        return this.enableDedupe;
    }

    public final boolean b() {
        return this.enableFilterIllegalSuggest;
    }

    public final int c() {
        return this.maxShowCnt;
    }

    public final int d() {
        return this.minShowCnt;
    }

    public s(int r100) {
        this.maxShowCnt = 15;
        this.minShowCnt = 3;
        this.enableDedupe = false;
        this.enableFilterIllegalSuggest = false;
    }
}
