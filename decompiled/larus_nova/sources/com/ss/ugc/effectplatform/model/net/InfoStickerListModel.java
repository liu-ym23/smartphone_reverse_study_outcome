package com.ss.ugc.effectplatform.model.net;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003JP\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015¨\u0006,"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/InfoStickerListModel;", "", "subtitle", "", EffectConfiguration.KEY_CURSOR, "", "has_more", "", "sticker_list", "", "Lcom/ss/ugc/effectplatform/model/net/InfoStickerEffect;", "extra", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)V", "getCursor", "()Ljava/lang/Integer;", "setCursor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getHas_more", "()Ljava/lang/Boolean;", "setHas_more", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSticker_list", "()Ljava/util/List;", "setSticker_list", "(Ljava/util/List;)V", "getSubtitle", "setSubtitle", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)Lcom/ss/ugc/effectplatform/model/net/InfoStickerListModel;", "equals", "other", "hashCode", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class InfoStickerListModel {
    private Integer cursor;
    private String extra;
    private Boolean has_more;
    private List<InfoStickerEffect> sticker_list;
    private String subtitle;

    public InfoStickerListModel() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InfoStickerListModel copy$default(InfoStickerListModel r100, String r101, Integer r102, Boolean r103, List r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.subtitle;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.cursor;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.has_more;
    L11:
        Boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.sticker_list;
    L14:
        List r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.extra;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.subtitle;
    }

    public final Integer component2() {
        return this.cursor;
    }

    public final Boolean component3() {
        return this.has_more;
    }

    public final List<InfoStickerEffect> component4() {
        return this.sticker_list;
    }

    public final String component5() {
        return this.extra;
    }

    public final InfoStickerListModel copy(String r100, Integer r101, Boolean r110, List<InfoStickerEffect> r111, String r112) {
        return new InfoStickerListModel(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InfoStickerListModel) == false) goto L16;
        InfoStickerListModel r101 = (InfoStickerListModel) r100;
        if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cursor, r101.cursor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.has_more, r101.has_more) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sticker_list, r101.sticker_list) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.subtitle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.cursor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.has_more;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<InfoStickerEffect> r110 = this.sticker_list;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.extra;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "InfoStickerListModel(subtitle=" + this.subtitle + ", cursor=" + this.cursor + ", has_more=" + this.has_more + ", sticker_list=" + this.sticker_list + ", extra=" + this.extra + ")";
    }

    public final Integer getCursor() {
        return this.cursor;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final Boolean getHas_more() {
        return this.has_more;
    }

    public final List<InfoStickerEffect> getSticker_list() {
        return this.sticker_list;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final void setCursor(Integer r100) {
        this.cursor = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setHas_more(Boolean r100) {
        this.has_more = r100;
    }

    public final void setSticker_list(List<InfoStickerEffect> r100) {
        this.sticker_list = r100;
    }

    public final void setSubtitle(String r100) {
        this.subtitle = r100;
    }

    public InfoStickerListModel(String r100, Integer r101, Boolean r102, List<InfoStickerEffect> r103, String r104) {
        this.subtitle = r100;
        this.cursor = r101;
        this.has_more = r102;
        this.sticker_list = r103;
        this.extra = r104;
    }

    public /* synthetic */ InfoStickerListModel(String r100, Integer r101, Boolean r102, List r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Integer r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Boolean r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        List r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
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
