package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014Jb\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u00020\u0007HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u00063"}, d2 = {"Lcom/larus/livetutor/api/idl/AudioExtraV2;", "Ljava/io/Serializable;", "partId", "", "partInTutorIdx", "", "ttsSubtitle", "", "ttsIdx", "startIdx", "len", "sentenceIdx", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getPartId", "()Ljava/lang/Long;", "setPartId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPartInTutorIdx", "()Ljava/lang/Integer;", "setPartInTutorIdx", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTtsSubtitle", "()Ljava/lang/String;", "setTtsSubtitle", "(Ljava/lang/String;)V", "getTtsIdx", "setTtsIdx", "getStartIdx", "setStartIdx", "getLen", "setLen", "getSentenceIdx", "setSentenceIdx", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/livetutor/api/idl/AudioExtraV2;", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioExtraV2 implements Serializable {

    @SerializedName("len")
    private Integer len;

    @SerializedName("part_id")
    private Long partId;

    @SerializedName("part_in_tutor_idx")
    private Integer partInTutorIdx;

    @SerializedName("sentence_idx")
    private Integer sentenceIdx;

    @SerializedName("start_idx")
    private Integer startIdx;

    @SerializedName("tts_idx")
    private Long ttsIdx;

    @SerializedName("tts_subtitle")
    private String ttsSubtitle;

    public AudioExtraV2() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ AudioExtraV2 copy$default(AudioExtraV2 r100, Long r101, Integer r102, String r103, Long r104, Integer r110, Integer r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.partId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.partInTutorIdx;
    L8:
        Integer r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.ttsSubtitle;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.ttsIdx;
    L14:
        Long r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.startIdx;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.len;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.sentenceIdx;
    L23:
        Long r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Long component1() {
        return this.partId;
    }

    public final Integer component2() {
        return this.partInTutorIdx;
    }

    public final String component3() {
        return this.ttsSubtitle;
    }

    public final Long component4() {
        return this.ttsIdx;
    }

    public final Integer component5() {
        return this.startIdx;
    }

    public final Integer component6() {
        return this.len;
    }

    public final Integer component7() {
        return this.sentenceIdx;
    }

    public final AudioExtraV2 copy(Long r110, Integer r111, String r112, Long r113, Integer r114, Integer r115, Integer r116) {
        return new AudioExtraV2(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioExtraV2) == true) goto L8;
        return false;
    L8:
        AudioExtraV2 r101 = (AudioExtraV2) r100;
        if (Intrinsics.areEqual(this.partId, r101.partId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.partInTutorIdx, r101.partInTutorIdx) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ttsSubtitle, r101.ttsSubtitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ttsIdx, r101.ttsIdx) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.startIdx, r101.startIdx) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.len, r101.len) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sentenceIdx, r101.sentenceIdx) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Long r100 = this.partId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.partInTutorIdx;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.ttsSubtitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.ttsIdx;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.startIdx;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.len;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.sentenceIdx;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "AudioExtraV2(partId=" + this.partId + ", partInTutorIdx=" + this.partInTutorIdx + ", ttsSubtitle=" + this.ttsSubtitle + ", ttsIdx=" + this.ttsIdx + ", startIdx=" + this.startIdx + ", len=" + this.len + ", sentenceIdx=" + this.sentenceIdx + ')';
    }

    public final Integer getLen() {
        return this.len;
    }

    public final Long getPartId() {
        return this.partId;
    }

    public final Integer getPartInTutorIdx() {
        return this.partInTutorIdx;
    }

    public final Integer getSentenceIdx() {
        return this.sentenceIdx;
    }

    public final Integer getStartIdx() {
        return this.startIdx;
    }

    public final Long getTtsIdx() {
        return this.ttsIdx;
    }

    public final String getTtsSubtitle() {
        return this.ttsSubtitle;
    }

    public final void setLen(Integer r100) {
        this.len = r100;
    }

    public final void setPartId(Long r100) {
        this.partId = r100;
    }

    public final void setPartInTutorIdx(Integer r100) {
        this.partInTutorIdx = r100;
    }

    public final void setSentenceIdx(Integer r100) {
        this.sentenceIdx = r100;
    }

    public final void setStartIdx(Integer r100) {
        this.startIdx = r100;
    }

    public final void setTtsIdx(Long r100) {
        this.ttsIdx = r100;
    }

    public final void setTtsSubtitle(String r100) {
        this.ttsSubtitle = r100;
    }

    public AudioExtraV2(Long r100, Integer r101, String r102, Long r103, Integer r104, Integer r105, Integer r106) {
        this.partId = r100;
        this.partInTutorIdx = r101;
        this.ttsSubtitle = r102;
        this.ttsIdx = r103;
        this.startIdx = r104;
        this.len = r105;
        this.sentenceIdx = r106;
    }

    public /* synthetic */ AudioExtraV2(Long r100, Integer r101, String r102, Long r110, Integer r111, Integer r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Long r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Integer r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Long r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
