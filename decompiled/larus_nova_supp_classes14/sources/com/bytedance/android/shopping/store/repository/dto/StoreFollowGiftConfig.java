package com.bytedance.android.shopping.store.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0000J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "Ljava/io/Serializable;", "bubbleColor", "", "textColor", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBubbleColor", "()Ljava/lang/String;", "setBubbleColor", "(Ljava/lang/String;)V", "getText", "setText", "getTextColor", "setTextColor", "component1", "component2", "component3", "copy", "deepCopy", "equals", "", "other", "", "hashCode", "", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreFollowGiftConfig implements Serializable {

    @SerializedName("bubble_color")
    private String bubbleColor;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private String textColor;

    public StoreFollowGiftConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ StoreFollowGiftConfig copy$default(StoreFollowGiftConfig r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.bubbleColor;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.textColor;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.text;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.bubbleColor;
    }

    public final String component2() {
        return this.textColor;
    }

    public final String component3() {
        return this.text;
    }

    public final StoreFollowGiftConfig copy(String r2, String r3, String r4) {
        return new StoreFollowGiftConfig(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof StoreFollowGiftConfig) == false) goto L12;
        StoreFollowGiftConfig r4 = (StoreFollowGiftConfig) r3;
        if (Intrinsics.areEqual(this.bubbleColor, r4.bubbleColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textColor, r4.textColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.bubbleColor;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.textColor;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.text;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "StoreFollowGiftConfig(bubbleColor=" + this.bubbleColor + ", textColor=" + this.textColor + ", text=" + this.text + ")";
    }

    public final StoreFollowGiftConfig deepCopy() {
        return copy(this.bubbleColor, this.textColor, this.text);
    }

    public final String getBubbleColor() {
        return this.bubbleColor;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final void setBubbleColor(String r1) {
        this.bubbleColor = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setTextColor(String r1) {
        this.textColor = r1;
    }

    public StoreFollowGiftConfig(String r1, String r2, String r3) {
        this.bubbleColor = r1;
        this.textColor = r2;
        this.text = r3;
    }

    public /* synthetic */ StoreFollowGiftConfig(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
