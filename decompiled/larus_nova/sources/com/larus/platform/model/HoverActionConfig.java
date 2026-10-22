package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/platform/model/HoverActionConfig;", "", "optimizeActionList", "", "showSuggestOnAction", "showQuoteOnAction", "showSuggestOnInput", "supportMainBot", "supportOfficialBot", "supportUserBot", "<init>", "(ZZZZZZZ)V", "getOptimizeActionList", "()Z", "getShowSuggestOnAction", "getShowQuoteOnAction", "getShowSuggestOnInput", "getSupportMainBot", "getSupportOfficialBot", "getSupportUserBot", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HoverActionConfig {
    public static final a Companion = null;
    private static final HoverActionConfig GROUP_CONTROL = null;
    private static final HoverActionConfig GROUP_V1 = null;
    private static final HoverActionConfig GROUP_V2 = null;
    private static final HoverActionConfig GROUP_V3 = null;
    private static final HoverActionConfig GROUP_V4 = null;

    @SerializedName("style_optimize")
    private final boolean optimizeActionList;

    @SerializedName("enable_quote")
    private final boolean showQuoteOnAction;

    @SerializedName("enable_suggest")
    private final boolean showSuggestOnAction;

    @SerializedName("enable_input_with_suggest")
    private final boolean showSuggestOnInput;

    @SerializedName("support_coco_bot")
    private final boolean supportMainBot;

    @SerializedName("support_guanfang_bot")
    private final boolean supportOfficialBot;

    @SerializedName("support_user_bot")
    private final boolean supportUserBot;

    public static final class a {
        public a() {
        }
    }

    public HoverActionConfig() {
        this(false, false, false, false, false, false, false, 127, null);
    }

    public static /* synthetic */ HoverActionConfig copy$default(HoverActionConfig r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r110, boolean r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.optimizeActionList;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.showSuggestOnAction;
    L8:
        boolean r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.showQuoteOnAction;
    L11:
        boolean r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.showSuggestOnInput;
    L14:
        boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.supportMainBot;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.supportOfficialBot;
    L20:
        boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.supportUserBot;
    L23:
        boolean r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final boolean component1() {
        return this.optimizeActionList;
    }

    public final boolean component2() {
        return this.showSuggestOnAction;
    }

    public final boolean component3() {
        return this.showQuoteOnAction;
    }

    public final boolean component4() {
        return this.showSuggestOnInput;
    }

    public final boolean component5() {
        return this.supportMainBot;
    }

    public final boolean component6() {
        return this.supportOfficialBot;
    }

    public final boolean component7() {
        return this.supportUserBot;
    }

    public final HoverActionConfig copy(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116) {
        return new HoverActionConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HoverActionConfig) == true) goto L8;
        return false;
    L8:
        HoverActionConfig r101 = (HoverActionConfig) r100;
        if (this.optimizeActionList == r101.optimizeActionList) goto L12;
        return false;
    L12:
        if (this.showSuggestOnAction == r101.showSuggestOnAction) goto L15;
        return false;
    L15:
        if (this.showQuoteOnAction == r101.showQuoteOnAction) goto L18;
        return false;
    L18:
        if (this.showSuggestOnInput == r101.showSuggestOnInput) goto L21;
        return false;
    L21:
        if (this.supportMainBot == r101.supportMainBot) goto L24;
        return false;
    L24:
        if (this.supportOfficialBot == r101.supportOfficialBot) goto L27;
        return false;
    L27:
        if (this.supportUserBot == r101.supportUserBot) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.optimizeActionList == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.showSuggestOnAction == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.showQuoteOnAction == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.showSuggestOnInput == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.supportMainBot == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.supportOfficialBot == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.supportUserBot == true) goto L31;
        r100 = 1237;
    L31:
        return r112 + r100;
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "HoverActionConfig(optimizeActionList=" + this.optimizeActionList + ", showSuggestOnAction=" + this.showSuggestOnAction + ", showQuoteOnAction=" + this.showQuoteOnAction + ", showSuggestOnInput=" + this.showSuggestOnInput + ", supportMainBot=" + this.supportMainBot + ", supportOfficialBot=" + this.supportOfficialBot + ", supportUserBot=" + this.supportUserBot + ')';
    }

    static {
        Companion = new a();
        GROUP_CONTROL = new HoverActionConfig(false, false, false, false, false, false, false);
        GROUP_V1 = new HoverActionConfig(true, false, false, false, false, false, false);
        GROUP_V2 = new HoverActionConfig(true, false, true, false, false, false, false);
        GROUP_V3 = new HoverActionConfig(true, true, true, false, false, false, false);
        GROUP_V4 = new HoverActionConfig(true, true, true, true, false, false, false);
    }

    public static final /* synthetic */ HoverActionConfig access$getGROUP_CONTROL$cp() {
        return GROUP_CONTROL;
    }

    public static final /* synthetic */ HoverActionConfig access$getGROUP_V1$cp() {
        return GROUP_V1;
    }

    public static final /* synthetic */ HoverActionConfig access$getGROUP_V2$cp() {
        return GROUP_V2;
    }

    public static final /* synthetic */ HoverActionConfig access$getGROUP_V3$cp() {
        return GROUP_V3;
    }

    public static final /* synthetic */ HoverActionConfig access$getGROUP_V4$cp() {
        return GROUP_V4;
    }

    public final boolean getOptimizeActionList() {
        return this.optimizeActionList;
    }

    public final boolean getShowQuoteOnAction() {
        return this.showQuoteOnAction;
    }

    public final boolean getShowSuggestOnAction() {
        return this.showSuggestOnAction;
    }

    public final boolean getShowSuggestOnInput() {
        return this.showSuggestOnInput;
    }

    public final boolean getSupportMainBot() {
        return this.supportMainBot;
    }

    public final boolean getSupportOfficialBot() {
        return this.supportOfficialBot;
    }

    public final boolean getSupportUserBot() {
        return this.supportUserBot;
    }

    public HoverActionConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106) {
        this.optimizeActionList = r100;
        this.showSuggestOnAction = r101;
        this.showQuoteOnAction = r102;
        this.showSuggestOnInput = r103;
        this.supportMainBot = r104;
        this.supportOfficialBot = r105;
        this.supportUserBot = r106;
    }

    public /* synthetic */ HoverActionConfig(boolean r100, boolean r101, boolean r102, boolean r110, boolean r111, boolean r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        boolean r116 = false;
    L7:
        if ((r114 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r114 & 4) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r114 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r114 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r114 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r114 & 64) == 0) goto L29;
        boolean r117 = false;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
