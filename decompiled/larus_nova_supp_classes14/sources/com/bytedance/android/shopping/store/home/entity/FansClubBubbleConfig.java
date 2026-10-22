package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014Jb\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0000J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/FansClubBubbleConfig;", "Ljava/io/Serializable;", "bubbleColor", "", "promptTextColor", "promptText", "jumpTextColor", "jumpText", "seperatorColor", "showLimit", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBubbleColor", "()Ljava/lang/String;", "getJumpText", "getJumpTextColor", "getPromptText", "getPromptTextColor", "getSeperatorColor", "getShowLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/store/home/entity/FansClubBubbleConfig;", "deepCopy", "equals", "", "other", "", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansClubBubbleConfig implements Serializable {

    @SerializedName("bubble_color")
    private final String bubbleColor;

    @SerializedName("jump_text")
    private final String jumpText;

    @SerializedName("jump_text_color")
    private final String jumpTextColor;

    @SerializedName("prompt_text")
    private final String promptText;

    @SerializedName("prompt_text_color")
    private final String promptTextColor;

    @SerializedName("seperator_color")
    private final String seperatorColor;

    @SerializedName("show_limit")
    private final Integer showLimit;

    public FansClubBubbleConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ FansClubBubbleConfig copy$default(FansClubBubbleConfig r5, String r6, String r7, String r8, String r9, String r10, String r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.bubbleColor;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.promptTextColor;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.promptText;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.jumpTextColor;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.jumpText;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.seperatorColor;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.showLimit;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.bubbleColor;
    }

    public final String component2() {
        return this.promptTextColor;
    }

    public final String component3() {
        return this.promptText;
    }

    public final String component4() {
        return this.jumpTextColor;
    }

    public final String component5() {
        return this.jumpText;
    }

    public final String component6() {
        return this.seperatorColor;
    }

    public final Integer component7() {
        return this.showLimit;
    }

    public final FansClubBubbleConfig copy(String r10, String r11, String r12, String r13, String r14, String r15, Integer r16) {
        return new FansClubBubbleConfig(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FansClubBubbleConfig) == false) goto L20;
        FansClubBubbleConfig r4 = (FansClubBubbleConfig) r3;
        if (Intrinsics.areEqual(this.bubbleColor, r4.bubbleColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promptTextColor, r4.promptTextColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.promptText, r4.promptText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpTextColor, r4.jumpTextColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.jumpText, r4.jumpText) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.seperatorColor, r4.seperatorColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showLimit, r4.showLimit) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r0 = this.bubbleColor;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.promptTextColor;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.promptText;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.jumpTextColor;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.jumpText;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.seperatorColor;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.showLimit;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "FansClubBubbleConfig(bubbleColor=" + this.bubbleColor + ", promptTextColor=" + this.promptTextColor + ", promptText=" + this.promptText + ", jumpTextColor=" + this.jumpTextColor + ", jumpText=" + this.jumpText + ", seperatorColor=" + this.seperatorColor + ", showLimit=" + this.showLimit + ")";
    }

    public final FansClubBubbleConfig deepCopy() {
        return copy(this.bubbleColor, this.promptTextColor, this.promptText, this.jumpTextColor, this.jumpText, this.seperatorColor, this.showLimit);
    }

    public final String getBubbleColor() {
        return this.bubbleColor;
    }

    public final String getJumpText() {
        return this.jumpText;
    }

    public final String getJumpTextColor() {
        return this.jumpTextColor;
    }

    public final String getPromptText() {
        return this.promptText;
    }

    public final String getPromptTextColor() {
        return this.promptTextColor;
    }

    public final String getSeperatorColor() {
        return this.seperatorColor;
    }

    public final Integer getShowLimit() {
        return this.showLimit;
    }

    public FansClubBubbleConfig(String r1, String r2, String r3, String r4, String r5, String r6, Integer r7) {
        this.bubbleColor = r1;
        this.promptTextColor = r2;
        this.promptText = r3;
        this.jumpTextColor = r4;
        this.jumpText = r5;
        this.seperatorColor = r6;
        this.showLimit = r7;
    }

    public /* synthetic */ FansClubBubbleConfig(String r7, String r8, String r9, String r10, String r11, String r12, Integer r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        Integer r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
