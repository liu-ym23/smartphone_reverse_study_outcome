package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003JU\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u000eHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006."}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/GsTab;", "Ljava/io/Serializable;", "id", "", "title", "Lcom/ss/android/ugc/aweme/discover/model/GsTitle;", "jumpLink", "Lcom/ss/android/ugc/aweme/discover/model/GsJumpLink;", "boxConfig", "Lcom/ss/android/ugc/aweme/discover/model/BoxConfig;", "wordList", "", "Lcom/ss/android/ugc/aweme/discover/model/ECGuideSearchWord;", "tabStyle", "", "(Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/GsTitle;Lcom/ss/android/ugc/aweme/discover/model/GsJumpLink;Lcom/ss/android/ugc/aweme/discover/model/BoxConfig;Ljava/util/List;I)V", "getBoxConfig", "()Lcom/ss/android/ugc/aweme/discover/model/BoxConfig;", "setBoxConfig", "(Lcom/ss/android/ugc/aweme/discover/model/BoxConfig;)V", "getId", "()Ljava/lang/String;", "getJumpLink", "()Lcom/ss/android/ugc/aweme/discover/model/GsJumpLink;", "getTabStyle", "()I", "setTabStyle", "(I)V", "getTitle", "()Lcom/ss/android/ugc/aweme/discover/model/GsTitle;", "getWordList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GsTab implements Serializable {
    public static final Companion Companion = null;
    public static final int STYLE_HORIZONTAL = 1;
    public static final int STYLE_HORIZONTAL_PLAIN = 2;
    public static final int STYLE_VERTICAL = 0;

    @SerializedName("box_config")
    private BoxConfig boxConfig;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f450487id;

    @SerializedName("jump_link")
    private final GsJumpLink jumpLink;

    @SerializedName("tab_style")
    private int tabStyle;

    @SerializedName("title")
    private final GsTitle title;

    @SerializedName(BitableAnalytic.LocationClickType.WORDS)
    private final List<ECGuideSearchWord> wordList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/GsTab$Companion;", "", "()V", "STYLE_HORIZONTAL", "", "STYLE_HORIZONTAL_PLAIN", "STYLE_VERTICAL", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public GsTab() {
        this(null, null, null, null, null, 0, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GsTab copy$default(GsTab r100, String r101, GsTitle r102, GsJumpLink r103, BoxConfig r104, List r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f450487id;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.title;
    L8:
        GsTitle r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.jumpLink;
    L11:
        GsJumpLink r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.boxConfig;
    L14:
        BoxConfig r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.wordList;
    L17:
        List r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.tabStyle;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.f450487id;
    }

    public final GsTitle component2() {
        return this.title;
    }

    public final GsJumpLink component3() {
        return this.jumpLink;
    }

    public final BoxConfig component4() {
        return this.boxConfig;
    }

    public final List<ECGuideSearchWord> component5() {
        return this.wordList;
    }

    public final int component6() {
        return this.tabStyle;
    }

    public final GsTab copy(String r100, GsTitle r110, GsJumpLink r111, BoxConfig r112, List<ECGuideSearchWord> r113, int r114) {
        return new GsTab(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GsTab) == false) goto L18;
        GsTab r101 = (GsTab) r100;
        if (Intrinsics.areEqual(this.f450487id, r101.f450487id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpLink, r101.jumpLink) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.boxConfig, r101.boxConfig) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.wordList, r101.wordList) == true) goto L16;
        return false;
    L16:
        if (this.tabStyle == r101.tabStyle) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.f450487id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        GsTitle r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        GsJumpLink r107 = this.jumpLink;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        BoxConfig r110 = this.boxConfig;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<ECGuideSearchWord> r113 = this.wordList;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return ((r112 + r101) * 31) + this.tabStyle;
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
        return "GsTab(id=" + this.f450487id + ", title=" + this.title + ", jumpLink=" + this.jumpLink + ", boxConfig=" + this.boxConfig + ", wordList=" + this.wordList + ", tabStyle=" + this.tabStyle + ")";
    }

    public final BoxConfig getBoxConfig() {
        return this.boxConfig;
    }

    public final String getId() {
        return this.f450487id;
    }

    public final GsJumpLink getJumpLink() {
        return this.jumpLink;
    }

    public final int getTabStyle() {
        return this.tabStyle;
    }

    public final GsTitle getTitle() {
        return this.title;
    }

    public final List<ECGuideSearchWord> getWordList() {
        return this.wordList;
    }

    public final void setBoxConfig(BoxConfig r100) {
        this.boxConfig = r100;
    }

    public final void setTabStyle(int r100) {
        this.tabStyle = r100;
    }

    public GsTab(String r100, GsTitle r101, GsJumpLink r102, BoxConfig r103, List<ECGuideSearchWord> r104, int r105) {
        this.f450487id = r100;
        this.title = r101;
        this.jumpLink = r102;
        this.boxConfig = r103;
        this.wordList = r104;
        this.tabStyle = r105;
    }

    public /* synthetic */ GsTab(String r100, GsTitle r101, GsJumpLink r102, BoxConfig r103, List r104, int r110, int r111, DefaultConstructorMarker r112) {
        List r105 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        GsTitle r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        GsJumpLink r107 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        BoxConfig r108 = null;
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
