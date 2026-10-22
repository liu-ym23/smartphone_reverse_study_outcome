package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0013\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000bHÆ\u0003JR\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0007HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00061"}, d2 = {"Lcom/larus/livetutor/api/idl/SubtitleMsg;", "Ljava/io/Serializable;", "round", "", "textAction", "Lcom/larus/livetutor/api/idl/TextAction;", "text", "", "liveTutorSubtitle", "Lcom/larus/livetutor/api/idl/LiveTutorSubtitle;", "totalSubtitle", "", "<init>", "(Ljava/lang/Long;Lcom/larus/livetutor/api/idl/TextAction;Ljava/lang/String;Lcom/larus/livetutor/api/idl/LiveTutorSubtitle;Ljava/util/List;)V", "getRound", "()Ljava/lang/Long;", "setRound", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTextAction", "()Lcom/larus/livetutor/api/idl/TextAction;", "setTextAction", "(Lcom/larus/livetutor/api/idl/TextAction;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getLiveTutorSubtitle", "()Lcom/larus/livetutor/api/idl/LiveTutorSubtitle;", "setLiveTutorSubtitle", "(Lcom/larus/livetutor/api/idl/LiveTutorSubtitle;)V", "getTotalSubtitle", "()Ljava/util/List;", "setTotalSubtitle", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Lcom/larus/livetutor/api/idl/TextAction;Ljava/lang/String;Lcom/larus/livetutor/api/idl/LiveTutorSubtitle;Ljava/util/List;)Lcom/larus/livetutor/api/idl/SubtitleMsg;", "equals", "", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubtitleMsg implements Serializable {

    @SerializedName("live_tutor_subtitle")
    private LiveTutorSubtitle liveTutorSubtitle;

    @SerializedName("round")
    private Long round;

    @SerializedName("text")
    private String text;

    @SerializedName("text_action")
    private TextAction textAction;

    @SerializedName("total_subtitle")
    private List<LiveTutorSubtitle> totalSubtitle;

    public SubtitleMsg() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubtitleMsg copy$default(SubtitleMsg r100, Long r101, TextAction r102, String r103, LiveTutorSubtitle r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.round;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.textAction;
    L8:
        TextAction r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.text;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.liveTutorSubtitle;
    L14:
        LiveTutorSubtitle r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.totalSubtitle;
    L17:
        Long r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Long component1() {
        return this.round;
    }

    public final TextAction component2() {
        return this.textAction;
    }

    public final String component3() {
        return this.text;
    }

    public final LiveTutorSubtitle component4() {
        return this.liveTutorSubtitle;
    }

    public final List<LiveTutorSubtitle> component5() {
        return this.totalSubtitle;
    }

    public final SubtitleMsg copy(Long r100, TextAction r101, String r110, LiveTutorSubtitle r111, List<LiveTutorSubtitle> r112) {
        return new SubtitleMsg(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SubtitleMsg) == true) goto L8;
        return false;
    L8:
        SubtitleMsg r101 = (SubtitleMsg) r100;
        if (Intrinsics.areEqual(this.round, r101.round) == true) goto L12;
        return false;
    L12:
        if (this.textAction == r101.textAction) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.liveTutorSubtitle, r101.liveTutorSubtitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.totalSubtitle, r101.totalSubtitle) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Long r100 = this.round;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        TextAction r104 = this.textAction;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.text;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        LiveTutorSubtitle r110 = this.liveTutorSubtitle;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<LiveTutorSubtitle> r113 = this.totalSubtitle;
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
        return "SubtitleMsg(round=" + this.round + ", textAction=" + this.textAction + ", text=" + this.text + ", liveTutorSubtitle=" + this.liveTutorSubtitle + ", totalSubtitle=" + this.totalSubtitle + ')';
    }

    public final LiveTutorSubtitle getLiveTutorSubtitle() {
        return this.liveTutorSubtitle;
    }

    public final Long getRound() {
        return this.round;
    }

    public final String getText() {
        return this.text;
    }

    public final TextAction getTextAction() {
        return this.textAction;
    }

    public final List<LiveTutorSubtitle> getTotalSubtitle() {
        return this.totalSubtitle;
    }

    public final void setLiveTutorSubtitle(LiveTutorSubtitle r100) {
        this.liveTutorSubtitle = r100;
    }

    public final void setRound(Long r100) {
        this.round = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextAction(TextAction r100) {
        this.textAction = r100;
    }

    public final void setTotalSubtitle(List<LiveTutorSubtitle> r100) {
        this.totalSubtitle = r100;
    }

    public SubtitleMsg(Long r100, TextAction r101, String r102, LiveTutorSubtitle r103, List<LiveTutorSubtitle> r104) {
        this.round = r100;
        this.textAction = r101;
        this.text = r102;
        this.liveTutorSubtitle = r103;
        this.totalSubtitle = r104;
    }

    public /* synthetic */ SubtitleMsg(Long r100, TextAction r101, String r102, LiveTutorSubtitle r103, List r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Long r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        TextAction r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        LiveTutorSubtitle r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        List r113 = null;
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
