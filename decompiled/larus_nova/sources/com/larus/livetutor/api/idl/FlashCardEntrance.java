package com.larus.livetutor.api.idl;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006'"}, d2 = {"Lcom/larus/livetutor/api/idl/FlashCardEntrance;", "Ljava/io/Serializable;", "enableFlashCardEntrance", "", "jumpSchema", "", "title", "subtitle", "buttonText", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnableFlashCardEntrance", "()Ljava/lang/Boolean;", "setEnableFlashCardEntrance", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getJumpSchema", "()Ljava/lang/String;", "setJumpSchema", "(Ljava/lang/String;)V", "getTitle", d.f25925o, "getSubtitle", "setSubtitle", "getButtonText", "setButtonText", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/livetutor/api/idl/FlashCardEntrance;", "equals", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlashCardEntrance implements Serializable {

    @SerializedName("button_text")
    private String buttonText;

    @SerializedName("enable_flash_card_entrance")
    private Boolean enableFlashCardEntrance;

    @SerializedName("jump_schema")
    private String jumpSchema;

    @SerializedName("subtitle")
    private String subtitle;

    @SerializedName("title")
    private String title;

    public FlashCardEntrance() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ FlashCardEntrance copy$default(FlashCardEntrance r100, Boolean r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.enableFlashCardEntrance;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.jumpSchema;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.title;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.subtitle;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.buttonText;
    L17:
        Boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Boolean component1() {
        return this.enableFlashCardEntrance;
    }

    public final String component2() {
        return this.jumpSchema;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.subtitle;
    }

    public final String component5() {
        return this.buttonText;
    }

    public final FlashCardEntrance copy(Boolean r100, String r101, String r110, String r111, String r112) {
        return new FlashCardEntrance(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlashCardEntrance) == true) goto L8;
        return false;
    L8:
        FlashCardEntrance r101 = (FlashCardEntrance) r100;
        if (Intrinsics.areEqual(this.enableFlashCardEntrance, r101.enableFlashCardEntrance) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpSchema, r101.jumpSchema) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.buttonText, r101.buttonText) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.enableFlashCardEntrance;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.jumpSchema;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.title;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.subtitle;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.buttonText;
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
        return "FlashCardEntrance(enableFlashCardEntrance=" + this.enableFlashCardEntrance + ", jumpSchema=" + this.jumpSchema + ", title=" + this.title + ", subtitle=" + this.subtitle + ", buttonText=" + this.buttonText + ')';
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final Boolean getEnableFlashCardEntrance() {
        return this.enableFlashCardEntrance;
    }

    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setButtonText(String r100) {
        this.buttonText = r100;
    }

    public final void setEnableFlashCardEntrance(Boolean r100) {
        this.enableFlashCardEntrance = r100;
    }

    public final void setJumpSchema(String r100) {
        this.jumpSchema = r100;
    }

    public final void setSubtitle(String r100) {
        this.subtitle = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public FlashCardEntrance(Boolean r100, String r101, String r102, String r103, String r104) {
        this.enableFlashCardEntrance = r100;
        this.jumpSchema = r101;
        this.title = r102;
        this.subtitle = r103;
        this.buttonText = r104;
    }

    public /* synthetic */ FlashCardEntrance(Boolean r100, String r101, String r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = Boolean.FALSE;
    L5:
        String r106 = null;
        if ((r105 & 2) == 0) goto L8;
        String r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        String r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        String r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
