package com.ss.android.ugc.aweme.search.common.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u00015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/SearchStyleConfig;", "", "Lcom/ss/android/ugc/aweme/search/common/config/FrameStyle;", "frameStyle", "Lcom/ss/android/ugc/aweme/search/common/config/FrameStyle;", "d", "()Lcom/ss/android/ugc/aweme/search/common/config/FrameStyle;", "Lcom/ss/android/ugc/aweme/search/common/config/ArrowIconStyle;", "arrowIconStyle", "Lcom/ss/android/ugc/aweme/search/common/config/ArrowIconStyle;", "c", "()Lcom/ss/android/ugc/aweme/search/common/config/ArrowIconStyle;", "Lcom/ss/android/ugc/aweme/search/common/config/SearchIconStyle;", "searchIconStyle", "Lcom/ss/android/ugc/aweme/search/common/config/SearchIconStyle;", "getSearchIconStyle", "()Lcom/ss/android/ugc/aweme/search/common/config/SearchIconStyle;", "Lcom/ss/android/ugc/aweme/search/common/config/ActionStyle;", "actionStyle", "Lcom/ss/android/ugc/aweme/search/common/config/ActionStyle;", "b", "()Lcom/ss/android/ugc/aweme/search/common/config/ActionStyle;", "Lcom/ss/android/ugc/aweme/search/common/config/ClearStyle;", "clearStyle", "Lcom/ss/android/ugc/aweme/search/common/config/ClearStyle;", "getClearStyle", "()Lcom/ss/android/ugc/aweme/search/common/config/ClearStyle;", "Lcom/ss/android/ugc/aweme/search/common/config/ScanStyle;", "scanStyle", "Lcom/ss/android/ugc/aweme/search/common/config/ScanStyle;", "f", "()Lcom/ss/android/ugc/aweme/search/common/config/ScanStyle;", "Lcom/ss/android/ugc/aweme/search/common/config/ActionExtra;", "actionExtra", "Lcom/ss/android/ugc/aweme/search/common/config/ActionExtra;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/ss/android/ugc/aweme/search/common/config/ActionExtra;", "setActionExtra", "(Lcom/ss/android/ugc/aweme/search/common/config/ActionExtra;)V", "Lcom/ss/android/ugc/aweme/search/common/config/HintTextStyle;", "hintText", "Lcom/ss/android/ugc/aweme/search/common/config/HintTextStyle;", "e", "()Lcom/ss/android/ugc/aweme/search/common/config/HintTextStyle;", "setHintText", "(Lcom/ss/android/ugc/aweme/search/common/config/HintTextStyle;)V", "", "showOrder", "Z", ce.f26391f, "()Z", "setShowOrder", "(Z)V", "Companion", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchStyleConfig {

    @SerializedName("action_extra")
    private ActionExtra actionExtra;

    @SerializedName("action_style")
    private final ActionStyle actionStyle;

    @SerializedName("arrow_icon_style")
    private final ArrowIconStyle arrowIconStyle;

    @SerializedName("clear_style")
    private final ClearStyle clearStyle;

    @SerializedName("frame_style")
    private final FrameStyle frameStyle;

    @SerializedName("hint_text")
    private HintTextStyle hintText;

    @SerializedName("scan_style")
    private final ScanStyle scanStyle;

    @SerializedName("search_icon_style")
    private final SearchIconStyle searchIconStyle;

    @SerializedName("show_order")
    private boolean showOrder;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/SearchStyleConfig$Companion;", "", "()V", "COMMON_STYLE", "", "MIDDLE_STYLE", "RESULT_STYLE", "SUG_STYLE", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public SearchStyleConfig() {
        this(null, null, null, null, false, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SearchStyleConfig) == false) goto L24;
        SearchStyleConfig r101 = (SearchStyleConfig) r100;
        if (Intrinsics.areEqual(this.frameStyle, r101.frameStyle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.arrowIconStyle, r101.arrowIconStyle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.searchIconStyle, r101.searchIconStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionStyle, r101.actionStyle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.clearStyle, r101.clearStyle) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.scanStyle, r101.scanStyle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionExtra, r101.actionExtra) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.hintText, r101.hintText) == true) goto L22;
        return false;
    L22:
        if (this.showOrder == r101.showOrder) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        FrameStyle r100 = this.frameStyle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ArrowIconStyle r104 = this.arrowIconStyle;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        SearchIconStyle r107 = this.searchIconStyle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ActionStyle r110 = this.actionStyle;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ClearStyle r113 = this.clearStyle;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ScanStyle r116 = this.scanStyle;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        ActionExtra r119 = this.actionExtra;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        HintTextStyle r122 = this.hintText;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        int r123 = (r121 + r101) * 31;
        boolean r124 = this.showOrder;
        ?? r125 = r124;
        if (r124 == false) goto L37;
        r125 = 1;
    L37:
        return r123 + r125;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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

    public final String toString() {
        return "SearchStyleConfig(frameStyle=" + this.frameStyle + ", arrowIconStyle=" + this.arrowIconStyle + ", searchIconStyle=" + this.searchIconStyle + ", actionStyle=" + this.actionStyle + ", clearStyle=" + this.clearStyle + ", scanStyle=" + this.scanStyle + ", actionExtra=" + this.actionExtra + ", hintText=" + this.hintText + ", showOrder=" + this.showOrder + ")";
    }

    public final ActionExtra a() {
        return this.actionExtra;
    }

    public final ActionStyle b() {
        return this.actionStyle;
    }

    public final ArrowIconStyle c() {
        return this.arrowIconStyle;
    }

    public final FrameStyle d() {
        return this.frameStyle;
    }

    public final HintTextStyle e() {
        return this.hintText;
    }

    public final ScanStyle f() {
        return this.scanStyle;
    }

    public final boolean g() {
        return this.showOrder;
    }

    public SearchStyleConfig(FrameStyle r100, ActionStyle r101, ScanStyle r102, HintTextStyle r103, boolean r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 32) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 128) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 256) == 0) goto L17;
        r104 = false;
    L17:
        this.frameStyle = r100;
        this.arrowIconStyle = null;
        this.searchIconStyle = null;
        this.actionStyle = r101;
        this.clearStyle = null;
        this.scanStyle = r102;
        this.actionExtra = null;
        this.hintText = r103;
        this.showOrder = r104;
    }
}
