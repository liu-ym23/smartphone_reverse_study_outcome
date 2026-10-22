package com.bytedance.android.shopping.dto;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u0006\u0010'\u001a\u00020(J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J{\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00104\u001a\u00020(2\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006:"}, d2 = {"Lcom/bytedance/android/shopping/dto/PromotionActivity;", "Ljava/io/Serializable;", "text", "", "icon", "url", "detailText", "title", "startTime", "", "endTime", "serverTime", "cardImage", "logo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;)V", "getCardImage", "()Ljava/lang/String;", "setCardImage", "(Ljava/lang/String;)V", "getDetailText", "setDetailText", "getEndTime", "()J", "setEndTime", "(J)V", "getIcon", "setIcon", "getLogo", "setLogo", "getServerTime", "setServerTime", "getStartTime", "setStartTime", "getText", "setText", "getTitle", "setTitle", "getUrl", "setUrl", "canBeShown", "", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionActivity implements Serializable {

    @SerializedName("card_image")
    private String cardImage;

    @SerializedName("detail_text")
    private String detailText;

    @SerializedName("end_time")
    private long endTime;

    @SerializedName("icon")
    private String icon;

    @SerializedName("logo")
    private String logo;

    @SerializedName("server_time")
    private long serverTime;

    @SerializedName("start_time")
    private long startTime;

    @SerializedName("text")
    private String text;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    public PromotionActivity() {
        this(null, null, null, null, null, 0, 0, 0, null, null, 1023, null);
    }

    public static /* synthetic */ PromotionActivity copy$default(PromotionActivity r14, String r15, String r16, String r17, String r18, String r19, long r20, long r22, long r24, String r26, String r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        String r2 = r14.text;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = r14.icon;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = r14.url;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = r14.detailText;
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r6 = r14.title;
    L23:
        if ((r28 & 32) == 0) goto L25;
        long r7 = r14.startTime;
    L27:
        if ((r28 & 64) == 0) goto L29;
        long r9 = r14.endTime;
    L31:
        if ((r28 & 128) == 0) goto L33;
        long r11 = r14.serverTime;
    L35:
        if ((r28 & 256) == 0) goto L37;
        String r13 = r14.cardImage;
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r1 = r14.logo;
    L43:
        return r14.copy(r2, r3, r4, r5, r6, r7, r9, r11, r13, r1);
    L41:
        r1 = r27;
        goto L43
    L37:
        r13 = r26;
        goto L39
    L33:
        r11 = r24;
        goto L35
    L29:
        r9 = r22;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final String component1() {
        return this.text;
    }

    public final String component10() {
        return this.logo;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.detailText;
    }

    public final String component5() {
        return this.title;
    }

    public final long component6() {
        return this.startTime;
    }

    public final long component7() {
        return this.endTime;
    }

    public final long component8() {
        return this.serverTime;
    }

    public final String component9() {
        return this.cardImage;
    }

    public final PromotionActivity copy(String r16, String r17, String r18, String r19, String r20, long r21, long r23, long r25, String r27, String r28) {
        return new PromotionActivity(r16, r17, r18, r19, r20, r21, r23, r25, r27, r28);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof PromotionActivity) == false) goto L26;
        PromotionActivity r7 = (PromotionActivity) r6;
        if (Intrinsics.areEqual(this.text, r7.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r7.icon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.url, r7.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.detailText, r7.detailText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.title, r7.title) == true) goto L16;
        return false;
    L16:
        if (this.startTime == r7.startTime) goto L18;
        return false;
    L18:
        if (this.endTime == r7.endTime) goto L20;
        return false;
    L20:
        if (this.serverTime == r7.serverTime) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.cardImage, r7.cardImage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.logo, r7.logo) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.icon;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.url;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.detailText;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.title;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        long r16 = this.startTime;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        long r18 = this.endTime;
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        long r20 = this.serverTime;
        int r21 = (r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31;
        String r22 = this.cardImage;
        if (r22 == null) goto L25;
        int r23 = r22.hashCode();
    L26:
        int r24 = (r21 + r23) * 31;
        String r25 = this.logo;
        if (r25 == null) goto L30;
        r1 = r25.hashCode();
    L30:
        return r24 + r1;
    L25:
        r23 = 0;
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
        return "PromotionActivity(text=" + this.text + ", icon=" + this.icon + ", url=" + this.url + ", detailText=" + this.detailText + ", title=" + this.title + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", cardImage=" + this.cardImage + ", logo=" + this.logo + ")";
    }

    public final boolean canBeShown() {
        return !TextUtils.isEmpty(this.text);
    }

    public final String getCardImage() {
        return this.cardImage;
    }

    public final String getDetailText() {
        return this.detailText;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCardImage(String r1) {
        this.cardImage = r1;
    }

    public final void setDetailText(String r1) {
        this.detailText = r1;
    }

    public final void setEndTime(long r1) {
        this.endTime = r1;
    }

    public final void setIcon(String r1) {
        this.icon = r1;
    }

    public final void setLogo(String r1) {
        this.logo = r1;
    }

    public final void setServerTime(long r1) {
        this.serverTime = r1;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public PromotionActivity(String r1, String r2, String r3, String r4, String r5, long r6, long r8, long r10, String r12, String r13) {
        this.text = r1;
        this.icon = r2;
        this.url = r3;
        this.detailText = r4;
        this.title = r5;
        this.startTime = r6;
        this.endTime = r8;
        this.serverTime = r10;
        this.cardImage = r12;
        this.logo = r13;
    }

    public /* synthetic */ PromotionActivity(String r15, String r16, String r17, String r18, String r19, long r20, long r22, long r24, String r26, String r27, int r28, DefaultConstructorMarker r29) {
        String r2 = "";
        if ((r28 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r6 = "";
    L22:
        long r8 = 0;
        if ((r28 & 32) == 0) goto L25;
        long r10 = 0;
    L27:
        if ((r28 & 64) == 0) goto L29;
        long r12 = 0;
    L31:
        if ((r28 & 128) != 0) goto L35;
        r8 = r24;
    L35:
        if ((r28 & 256) == 0) goto L37;
        String r7 = "";
    L39:
        if ((r28 & 512) != 0) goto L42;
        r2 = r27;
    L42:
        this(r1, r3, r4, r5, r6, r10, r12, r8, r7, r2);
        return;
    L37:
        r7 = r26;
        goto L39
    L29:
        r12 = r22;
        goto L31
    L25:
        r10 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L22
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }
}
