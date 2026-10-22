package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\\\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0013¨\u0006*"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsV2;", "Ljava/io/Serializable;", "type", "", "tabs", "", "Lcom/ss/android/ugc/aweme/discover/model/GsTab;", "cardStyle", "aiGuideInfo", "Lcom/ss/android/ugc/aweme/discover/model/AIGuideInfo;", "activityAtmosphere", "Lcom/ss/android/ugc/aweme/discover/model/GsActivityAtmosphere;", "heightStyle", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Lcom/ss/android/ugc/aweme/discover/model/AIGuideInfo;Lcom/ss/android/ugc/aweme/discover/model/GsActivityAtmosphere;I)V", "getActivityAtmosphere", "()Lcom/ss/android/ugc/aweme/discover/model/GsActivityAtmosphere;", "getAiGuideInfo", "()Lcom/ss/android/ugc/aweme/discover/model/AIGuideInfo;", "getCardStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeightStyle", "()I", "getTabs", "()Ljava/util/List;", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Lcom/ss/android/ugc/aweme/discover/model/AIGuideInfo;Lcom/ss/android/ugc/aweme/discover/model/GsActivityAtmosphere;I)Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsV2;", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuideSearchWordsV2 implements Serializable {
    public static final Companion Companion = null;
    public static final int GS_MULTI_TABS = 1;
    public static final int GS_NO_TABS = 2;
    public static final int HEIGHT_STYLE_COMPRESSED = 1;
    public static final int HEIGHT_STYLE_NORMAL = 0;

    @SerializedName("activity_atmosphere")
    private final GsActivityAtmosphere activityAtmosphere;

    @SerializedName("extra_guide_info")
    private final AIGuideInfo aiGuideInfo;

    @SerializedName("card_style")
    private final Integer cardStyle;

    @SerializedName("height_style")
    private final int heightStyle;

    @SerializedName("tabs")
    private final List<GsTab> tabs;

    @SerializedName("type")
    private final Integer type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsV2$Companion;", "", "()V", "GS_MULTI_TABS", "", "GS_NO_TABS", "HEIGHT_STYLE_COMPRESSED", "HEIGHT_STYLE_NORMAL", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public GuideSearchWordsV2() {
        this(null, null, null, null, null, 0, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuideSearchWordsV2 copy$default(GuideSearchWordsV2 r100, Integer r101, List r102, Integer r103, AIGuideInfo r104, GsActivityAtmosphere r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.tabs;
    L8:
        List r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.cardStyle;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.aiGuideInfo;
    L14:
        AIGuideInfo r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.activityAtmosphere;
    L17:
        GsActivityAtmosphere r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.heightStyle;
    L20:
        Integer r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Integer component1() {
        return this.type;
    }

    public final List<GsTab> component2() {
        return this.tabs;
    }

    public final Integer component3() {
        return this.cardStyle;
    }

    public final AIGuideInfo component4() {
        return this.aiGuideInfo;
    }

    public final GsActivityAtmosphere component5() {
        return this.activityAtmosphere;
    }

    public final int component6() {
        return this.heightStyle;
    }

    public final GuideSearchWordsV2 copy(Integer r100, List<GsTab> r110, Integer r111, AIGuideInfo r112, GsActivityAtmosphere r113, int r114) {
        return new GuideSearchWordsV2(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GuideSearchWordsV2) == false) goto L18;
        GuideSearchWordsV2 r101 = (GuideSearchWordsV2) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tabs, r101.tabs) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cardStyle, r101.cardStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aiGuideInfo, r101.aiGuideInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.activityAtmosphere, r101.activityAtmosphere) == true) goto L16;
        return false;
    L16:
        if (this.heightStyle == r101.heightStyle) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<GsTab> r104 = this.tabs;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.cardStyle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        AIGuideInfo r110 = this.aiGuideInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        GsActivityAtmosphere r113 = this.activityAtmosphere;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return ((r112 + r101) * 31) + this.heightStyle;
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
        return "GuideSearchWordsV2(type=" + this.type + ", tabs=" + this.tabs + ", cardStyle=" + this.cardStyle + ", aiGuideInfo=" + this.aiGuideInfo + ", activityAtmosphere=" + this.activityAtmosphere + ", heightStyle=" + this.heightStyle + ")";
    }

    public final GsActivityAtmosphere getActivityAtmosphere() {
        return this.activityAtmosphere;
    }

    public final AIGuideInfo getAiGuideInfo() {
        return this.aiGuideInfo;
    }

    public final Integer getCardStyle() {
        return this.cardStyle;
    }

    public final int getHeightStyle() {
        return this.heightStyle;
    }

    public final List<GsTab> getTabs() {
        return this.tabs;
    }

    public final Integer getType() {
        return this.type;
    }

    public GuideSearchWordsV2(Integer r100, List<GsTab> r101, Integer r102, AIGuideInfo r103, GsActivityAtmosphere r104, int r105) {
        this.type = r100;
        this.tabs = r101;
        this.cardStyle = r102;
        this.aiGuideInfo = r103;
        this.activityAtmosphere = r104;
        this.heightStyle = r105;
    }

    public /* synthetic */ GuideSearchWordsV2(Integer r100, List r101, Integer r102, AIGuideInfo r103, GsActivityAtmosphere r104, int r110, int r111, DefaultConstructorMarker r112) {
        GsActivityAtmosphere r105 = null;
        if ((r111 & 1) == 0) goto L5;
        Integer r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        List r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        Integer r107 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        AIGuideInfo r108 = null;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        int r114 = 0;
    L26:
        this(r113, r106, r107, r108, r105, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
