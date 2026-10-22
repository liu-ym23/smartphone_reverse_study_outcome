package com.obric.assistant.network.api.bean;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/network/api/bean/ObricOmniUploadImageFeedback;", "", "content", "", PromotionProductPrivilegesStruct.TAGS, "", "type", a.KEY_SCORE, "amount", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getTags", "()Ljava/util/List;", "getType", "getScore", "getAmount", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOmniUploadImageFeedback {

    @SerializedName("amount")
    private final int amount;

    @SerializedName("content")
    private final String content;

    @SerializedName(a.KEY_SCORE)
    private final String score;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<String> tags;

    @SerializedName("type")
    private final String type;

    public ObricOmniUploadImageFeedback() {
        this(null, null, null, null, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricOmniUploadImageFeedback copy$default(ObricOmniUploadImageFeedback r100, String r101, List r102, String r103, String r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.tags;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.type;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.score;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.amount;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.content;
    }

    public final List<String> component2() {
        return this.tags;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.score;
    }

    public final int component5() {
        return this.amount;
    }

    public final ObricOmniUploadImageFeedback copy(String r100, List<String> r101, String r110, String r111, int r112) {
        return new ObricOmniUploadImageFeedback(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricOmniUploadImageFeedback) == true) goto L8;
        return false;
    L8:
        ObricOmniUploadImageFeedback r101 = (ObricOmniUploadImageFeedback) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.score, r101.score) == true) goto L21;
        return false;
    L21:
        if (this.amount == r101.amount) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.content;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.tags;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.type;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.score;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.amount;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricOmniUploadImageFeedback(content=" + this.content + ", tags=" + this.tags + ", type=" + this.type + ", score=" + this.score + ", amount=" + this.amount + ')';
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getScore() {
        return this.score;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getType() {
        return this.type;
    }

    public ObricOmniUploadImageFeedback(String r100, List<String> r101, String r102, String r103, int r104) {
        this.content = r100;
        this.tags = r101;
        this.type = r102;
        this.score = r103;
        this.amount = r104;
    }

    public /* synthetic */ ObricOmniUploadImageFeedback(String r100, List r101, String r102, String r103, int r104, int r105, DefaultConstructorMarker r110) {
        String r106 = null;
        if ((r105 & 1) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        List r107 = null;
    L11:
        if ((r105 & 4) == 0) goto L13;
        String r108 = null;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        int r109 = -1;
    L22:
        this(r111, r107, r108, r106, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
