package com.bytedance.locallife.groupon.struct.guesslike;

import com.bytedance.locallife.groupon.guesslike.data.GuessLikeNode;
import com.bytedance.locallife.groupon.guesslike.data.b;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010JJ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0006HÖ\u0001J\b\u0010'\u001a\u0004\u0018\u00010\bJ\t\u0010(\u001a\u00020\u0003HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\"\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006)"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/guesslike/GuessLikeInsertData;", "", "nodeTag", "", "superNodeTag", "index", "", "feedCardData", "Lcom/bytedance/locallife/groupon/guesslike/data/GuessLikeNode;", "tabId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/guesslike/data/GuessLikeNode;Ljava/lang/Integer;)V", "getFeedCardData", "()Lcom/bytedance/locallife/groupon/guesslike/data/GuessLikeNode;", "setFeedCardData", "(Lcom/bytedance/locallife/groupon/guesslike/data/GuessLikeNode;)V", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getNodeTag", "()Ljava/lang/String;", "setNodeTag", "(Ljava/lang/String;)V", "getSuperNodeTag", "setSuperNodeTag", "getTabId", "setTabId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/guesslike/data/GuessLikeNode;Ljava/lang/Integer;)Lcom/bytedance/locallife/groupon/struct/guesslike/GuessLikeInsertData;", "equals", "", "other", "hashCode", "obtainFinalGuessLikeNode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GuessLikeInsertData {

    @SerializedName("node_data")
    private GuessLikeNode feedCardData;

    @SerializedName("index")
    private Integer index;

    @SerializedName("node_tag")
    private String nodeTag;

    @SerializedName("super_node_tag")
    private String superNodeTag;

    @SerializedName("tab_id")
    private Integer tabId;

    public GuessLikeInsertData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GuessLikeInsertData copy$default(GuessLikeInsertData r100, String r101, String r102, Integer r103, GuessLikeNode r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.nodeTag;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.superNodeTag;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.index;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.feedCardData;
    L14:
        GuessLikeNode r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.tabId;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.nodeTag;
    }

    public final String component2() {
        return this.superNodeTag;
    }

    public final Integer component3() {
        return this.index;
    }

    public final GuessLikeNode component4() {
        return this.feedCardData;
    }

    public final Integer component5() {
        return this.tabId;
    }

    public final GuessLikeInsertData copy(String r100, String r101, Integer r110, GuessLikeNode r111, Integer r112) {
        return new GuessLikeInsertData(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GuessLikeInsertData) == true) goto L8;
        return false;
    L8:
        GuessLikeInsertData r101 = (GuessLikeInsertData) r100;
        if (Intrinsics.areEqual(this.nodeTag, r101.nodeTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.superNodeTag, r101.superNodeTag) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.feedCardData, r101.feedCardData) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.nodeTag;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.superNodeTag;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.index;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        GuessLikeNode r110 = this.feedCardData;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.tabId;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "GuessLikeInsertData(nodeTag=" + this.nodeTag + ", superNodeTag=" + this.superNodeTag + ", index=" + this.index + ", feedCardData=" + this.feedCardData + ", tabId=" + this.tabId + ')';
    }

    public final GuessLikeNode obtainFinalGuessLikeNode() {
        GuessLikeNode r100 = this.feedCardData;
        if (r100 == null) goto L6;
        ((b) r100.f258801b.getValue()).getClass();
    L6:
        return this.feedCardData;
    }

    public final GuessLikeNode getFeedCardData() {
        return this.feedCardData;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final String getNodeTag() {
        return this.nodeTag;
    }

    public final String getSuperNodeTag() {
        return this.superNodeTag;
    }

    public final Integer getTabId() {
        return this.tabId;
    }

    public final void setFeedCardData(GuessLikeNode r100) {
        this.feedCardData = r100;
    }

    public final void setIndex(Integer r100) {
        this.index = r100;
    }

    public final void setNodeTag(String r100) {
        this.nodeTag = r100;
    }

    public final void setSuperNodeTag(String r100) {
        this.superNodeTag = r100;
    }

    public final void setTabId(Integer r100) {
        this.tabId = r100;
    }

    public GuessLikeInsertData(String r100, String r101, Integer r102, GuessLikeNode r103, Integer r104) {
        this.nodeTag = r100;
        this.superNodeTag = r101;
        this.index = r102;
        this.feedCardData = r103;
        this.tabId = r104;
    }

    public /* synthetic */ GuessLikeInsertData(String r100, String r101, Integer r102, GuessLikeNode r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Integer r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        GuessLikeNode r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
