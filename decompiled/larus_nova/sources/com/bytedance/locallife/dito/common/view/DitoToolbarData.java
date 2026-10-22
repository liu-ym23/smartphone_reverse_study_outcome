package com.bytedance.locallife.dito.common.view;

import com.bytedance.locallife.dito.common.data.DitoImageTextData;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003Je\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/bytedance/locallife/dito/common/view/DitoToolbarData;", "Ljava/io/Serializable;", "backGround", "", "leftContainer", "", "Lcom/bytedance/locallife/dito/common/data/DitoImageTextData;", "rightContainer", "title", "shouldShowLine", "", "notFitStatusBar", "bizParams", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedance/locallife/dito/common/data/DitoImageTextData;ZLjava/lang/String;Lcom/google/gson/JsonObject;)V", "getBackGround", "()Ljava/lang/String;", "getBizParams", "()Lcom/google/gson/JsonObject;", "getLeftContainer", "()Ljava/util/List;", "getNotFitStatusBar", "getRightContainer", "getShouldShowLine", "()Z", "getTitle", "()Lcom/bytedance/locallife/dito/common/data/DitoImageTextData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DitoToolbarData implements Serializable {
    private final String backGround;
    private final JsonObject bizParams;
    private final List<DitoImageTextData> leftContainer;
    private final String notFitStatusBar;
    private final List<DitoImageTextData> rightContainer;
    private final boolean shouldShowLine;
    private final DitoImageTextData title;

    public DitoToolbarData() {
        this(null, null, null, null, false, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DitoToolbarData copy$default(DitoToolbarData r100, String r101, List r102, List r103, DitoImageTextData r104, boolean r110, String r111, JsonObject r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.backGround;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.leftContainer;
    L8:
        List r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.rightContainer;
    L11:
        List r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.title;
    L14:
        DitoImageTextData r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.shouldShowLine;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.notFitStatusBar;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.bizParams;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.backGround;
    }

    public final List<DitoImageTextData> component2() {
        return this.leftContainer;
    }

    public final List<DitoImageTextData> component3() {
        return this.rightContainer;
    }

    public final DitoImageTextData component4() {
        return this.title;
    }

    public final boolean component5() {
        return this.shouldShowLine;
    }

    public final String component6() {
        return this.notFitStatusBar;
    }

    public final JsonObject component7() {
        return this.bizParams;
    }

    public final DitoToolbarData copy(String r110, List<DitoImageTextData> r111, List<DitoImageTextData> r112, DitoImageTextData r113, boolean r114, String r115, JsonObject r116) {
        Intrinsics.checkNotNullParameter(r115, "notFitStatusBar");
        return new DitoToolbarData(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DitoToolbarData) == true) goto L8;
        return false;
    L8:
        DitoToolbarData r101 = (DitoToolbarData) r100;
        if (Intrinsics.areEqual(this.backGround, r101.backGround) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.leftContainer, r101.leftContainer) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rightContainer, r101.rightContainer) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L21;
        return false;
    L21:
        if (this.shouldShowLine == r101.shouldShowLine) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.notFitStatusBar, r101.notFitStatusBar) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.bizParams, r101.bizParams) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.backGround;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<DitoImageTextData> r104 = this.leftContainer;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<DitoImageTextData> r107 = this.rightContainer;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        DitoImageTextData r110 = this.title;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.shouldShowLine == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (((r112 + r113) * 31) + this.notFitStatusBar.hashCode()) * 31;
        JsonObject r115 = this.bizParams;
        if (r115 == null) goto L27;
        r101 = r115.hashCode();
    L27:
        return r114 + r101;
    L21:
        r113 = 1237;
        goto L22
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
        return "DitoToolbarData(backGround=" + this.backGround + ", leftContainer=" + this.leftContainer + ", rightContainer=" + this.rightContainer + ", title=" + this.title + ", shouldShowLine=" + this.shouldShowLine + ", notFitStatusBar=" + this.notFitStatusBar + ", bizParams=" + this.bizParams + ')';
    }

    public final String getBackGround() {
        return this.backGround;
    }

    public final JsonObject getBizParams() {
        return this.bizParams;
    }

    public final List<DitoImageTextData> getLeftContainer() {
        return this.leftContainer;
    }

    public final String getNotFitStatusBar() {
        return this.notFitStatusBar;
    }

    public final List<DitoImageTextData> getRightContainer() {
        return this.rightContainer;
    }

    public final boolean getShouldShowLine() {
        return this.shouldShowLine;
    }

    public final DitoImageTextData getTitle() {
        return this.title;
    }

    public DitoToolbarData(String r100, List<DitoImageTextData> r101, List<DitoImageTextData> r102, DitoImageTextData r103, boolean r104, String r105, JsonObject r106) {
        Intrinsics.checkNotNullParameter(r105, "notFitStatusBar");
        this.backGround = r100;
        this.leftContainer = r101;
        this.rightContainer = r102;
        this.title = r103;
        this.shouldShowLine = r104;
        this.notFitStatusBar = r105;
        this.bizParams = r106;
    }

    public /* synthetic */ DitoToolbarData(String r100, List r101, List r102, DitoImageTextData r110, boolean r111, String r112, JsonObject r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        List r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        List r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        DitoImageTextData r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r114 & 32) == 0) goto L25;
        r112 = "0";
    L25:
        String r107 = r112;
        if ((r114 & 64) == 0) goto L28;
        JsonObject r117 = null;
    L29:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L28:
        r117 = r113;
        goto L29
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
