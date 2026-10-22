package com.larus.bmhome.music.protocol;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/music/protocol/ListMusicGenTemplateRequest;", "", "randomSeed", "", "offset", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "needMoreTemplateCover", "", "<init>", "(JIIZ)V", "getRandomSeed", "()J", "getOffset", "()I", "getLimit", "getNeedMoreTemplateCover", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    private final int limit;

    @SerializedName("need_more_template_cover")
    private final boolean needMoreTemplateCover;

    @SerializedName("offset")
    private final int offset;

    @SerializedName("random_seed")
    private final long randomSeed;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.randomSeed == r101.randomSeed) goto L12;
        return false;
    L12:
        if (this.offset == r101.offset) goto L15;
        return false;
    L15:
        if (this.limit == r101.limit) goto L18;
        return false;
    L18:
        if (this.needMoreTemplateCover == r101.needMoreTemplateCover) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.randomSeed;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.offset) * 31) + this.limit) * 31;
        if (this.needMoreTemplateCover == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "ListMusicGenTemplateRequest(randomSeed=" + this.randomSeed + ", offset=" + this.offset + ", limit=" + this.limit + ", needMoreTemplateCover=" + this.needMoreTemplateCover + ')';
    }

    public d() {
        this(0, 0, 0, false);
    }

    public d(long r100, int r101, int r102, boolean r103) {
        this.randomSeed = r100;
        this.offset = r101;
        this.limit = r102;
        this.needMoreTemplateCover = r103;
    }
}
