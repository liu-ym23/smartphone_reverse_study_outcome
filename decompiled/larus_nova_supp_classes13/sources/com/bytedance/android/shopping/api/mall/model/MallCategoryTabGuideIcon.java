package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jn\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\tHÖ\u0001J\t\u0010,\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;", "", "iconUrl", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTaIconUrl;", "hasForceInsert", "", "wysiwygItems", "", "wysiwygPosition", "", "wysiwygSceneId", "wysiwygBlockName", "feedType", "feedId", "(Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTaIconUrl;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getFeedId", "()Ljava/lang/String;", "getFeedType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasForceInsert", "()Ljava/lang/Boolean;", "setHasForceInsert", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getIconUrl", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTaIconUrl;", "getWysiwygBlockName", "getWysiwygItems", "getWysiwygPosition", "getWysiwygSceneId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTaIconUrl;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallCategoryTabGuideIcon {

    @SerializedName("feed_id")
    private final String feedId;

    @SerializedName("feed_type")
    private final Integer feedType;

    @SerializedName("has_force_insert")
    private Boolean hasForceInsert;

    @SerializedName("icon_url")
    private final MallCategoryTaIconUrl iconUrl;

    @SerializedName("wysiwyg_block_name")
    private final String wysiwygBlockName;

    @SerializedName("wysiwyg_items")
    private final String wysiwygItems;

    @SerializedName("wysiwyg_position")
    private final Integer wysiwygPosition;

    @SerializedName("wysiwyg_scene_id")
    private final String wysiwygSceneId;

    public MallCategoryTabGuideIcon() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ MallCategoryTabGuideIcon copy$default(MallCategoryTabGuideIcon r9, MallCategoryTaIconUrl r10, Boolean r11, String r12, Integer r13, String r14, String r15, Integer r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        MallCategoryTaIconUrl r2 = r9.iconUrl;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Boolean r3 = r9.hasForceInsert;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.wysiwygItems;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Integer r5 = r9.wysiwygPosition;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.wysiwygSceneId;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.wysiwygBlockName;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Integer r8 = r9.feedType;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.feedId;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final MallCategoryTaIconUrl component1() {
        return this.iconUrl;
    }

    public final Boolean component2() {
        return this.hasForceInsert;
    }

    public final String component3() {
        return this.wysiwygItems;
    }

    public final Integer component4() {
        return this.wysiwygPosition;
    }

    public final String component5() {
        return this.wysiwygSceneId;
    }

    public final String component6() {
        return this.wysiwygBlockName;
    }

    public final Integer component7() {
        return this.feedType;
    }

    public final String component8() {
        return this.feedId;
    }

    public final MallCategoryTabGuideIcon copy(MallCategoryTaIconUrl r11, Boolean r12, String r13, Integer r14, String r15, String r16, Integer r17, String r18) {
        return new MallCategoryTabGuideIcon(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof MallCategoryTabGuideIcon) == false) goto L22;
        MallCategoryTabGuideIcon r4 = (MallCategoryTabGuideIcon) r3;
        if (Intrinsics.areEqual(this.iconUrl, r4.iconUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hasForceInsert, r4.hasForceInsert) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.wysiwygItems, r4.wysiwygItems) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.wysiwygPosition, r4.wysiwygPosition) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.wysiwygSceneId, r4.wysiwygSceneId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.wysiwygBlockName, r4.wysiwygBlockName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.feedType, r4.feedType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.feedId, r4.feedId) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        MallCategoryTaIconUrl r0 = this.iconUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.hasForceInsert;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.wysiwygItems;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.wysiwygPosition;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.wysiwygSceneId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.wysiwygBlockName;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.feedType;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.feedId;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        return r21 + r1;
    L29:
        r20 = 0;
        goto L30
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
        return "MallCategoryTabGuideIcon(iconUrl=" + this.iconUrl + ", hasForceInsert=" + this.hasForceInsert + ", wysiwygItems=" + this.wysiwygItems + ", wysiwygPosition=" + this.wysiwygPosition + ", wysiwygSceneId=" + this.wysiwygSceneId + ", wysiwygBlockName=" + this.wysiwygBlockName + ", feedType=" + this.feedType + ", feedId=" + this.feedId + ")";
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final Integer getFeedType() {
        return this.feedType;
    }

    public final Boolean getHasForceInsert() {
        return this.hasForceInsert;
    }

    public final MallCategoryTaIconUrl getIconUrl() {
        return this.iconUrl;
    }

    public final String getWysiwygBlockName() {
        return this.wysiwygBlockName;
    }

    public final String getWysiwygItems() {
        return this.wysiwygItems;
    }

    public final Integer getWysiwygPosition() {
        return this.wysiwygPosition;
    }

    public final String getWysiwygSceneId() {
        return this.wysiwygSceneId;
    }

    public final void setHasForceInsert(Boolean r1) {
        this.hasForceInsert = r1;
    }

    public MallCategoryTabGuideIcon(MallCategoryTaIconUrl r1, Boolean r2, String r3, Integer r4, String r5, String r6, Integer r7, String r8) {
        this.iconUrl = r1;
        this.hasForceInsert = r2;
        this.wysiwygItems = r3;
        this.wysiwygPosition = r4;
        this.wysiwygSceneId = r5;
        this.wysiwygBlockName = r6;
        this.feedType = r7;
        this.feedId = r8;
    }

    public /* synthetic */ MallCategoryTabGuideIcon(MallCategoryTaIconUrl r10, Boolean r11, String r12, Integer r13, String r14, String r15, Integer r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        MallCategoryTaIconUrl r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Boolean r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
