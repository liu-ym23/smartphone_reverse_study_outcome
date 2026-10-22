package com.larus.bmhome.chat.resp;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J}\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006-"}, d2 = {"Lcom/larus/bmhome/chat/resp/CommonNoticeData;", "", "leftButton", "Lcom/larus/bmhome/chat/resp/Button;", "title", "", "titleSchema", "titleTargetPage", ContainerPosition.BODY, "boldBodyRangeList", "", "Lcom/larus/bmhome/chat/resp/Range;", "schema", "targetPage", "rightButton", "<init>", "(Lcom/larus/bmhome/chat/resp/Button;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/resp/Button;)V", "getLeftButton", "()Lcom/larus/bmhome/chat/resp/Button;", "getTitle", "()Ljava/lang/String;", "getTitleSchema", "getTitleTargetPage", "getBody", "getBoldBodyRangeList", "()Ljava/util/List;", "getSchema", "getTargetPage", "getRightButton", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonNoticeData {

    @SerializedName(ContainerPosition.BODY)
    private final String body;

    @SerializedName("bold_body_range_list")
    private final List<Range> boldBodyRangeList;

    @SerializedName("left_button")
    private final Button leftButton;

    @SerializedName("right_button")
    private final Button rightButton;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("target_page")
    private final String targetPage;

    @SerializedName("title")
    private final String title;

    @SerializedName("title_schema")
    private final String titleSchema;

    @SerializedName("title_target_page")
    private final String titleTargetPage;

    public CommonNoticeData() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonNoticeData copy$default(CommonNoticeData r110, Button r111, String r112, String r113, String r114, String r115, List r116, String r117, String r118, Button r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Button r100 = r110.leftButton;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.titleSchema;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.titleTargetPage;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.body;
    L23:
        if ((r210 & 32) == 0) goto L25;
        List r105 = r110.boldBodyRangeList;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.schema;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.targetPage;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Button r108 = r110.rightButton;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Button component1() {
        return this.leftButton;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.titleSchema;
    }

    public final String component4() {
        return this.titleTargetPage;
    }

    public final String component5() {
        return this.body;
    }

    public final List<Range> component6() {
        return this.boldBodyRangeList;
    }

    public final String component7() {
        return this.schema;
    }

    public final String component8() {
        return this.targetPage;
    }

    public final Button component9() {
        return this.rightButton;
    }

    public final CommonNoticeData copy(Button r110, String r111, String r112, String r113, String r114, List<Range> r115, String r116, String r117, Button r210) {
        return new CommonNoticeData(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonNoticeData) == true) goto L8;
        return false;
    L8:
        CommonNoticeData r101 = (CommonNoticeData) r100;
        if (Intrinsics.areEqual(this.leftButton, r101.leftButton) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.titleSchema, r101.titleSchema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.titleTargetPage, r101.titleTargetPage) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.body, r101.body) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.boldBodyRangeList, r101.boldBodyRangeList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.targetPage, r101.targetPage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.rightButton, r101.rightButton) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        Button r100 = this.leftButton;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.titleSchema;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.titleTargetPage;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.body;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<Range> r116 = this.boldBodyRangeList;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.schema;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.targetPage;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Button r125 = this.rightButton;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
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
        return "CommonNoticeData(leftButton=" + this.leftButton + ", title=" + this.title + ", titleSchema=" + this.titleSchema + ", titleTargetPage=" + this.titleTargetPage + ", body=" + this.body + ", boldBodyRangeList=" + this.boldBodyRangeList + ", schema=" + this.schema + ", targetPage=" + this.targetPage + ", rightButton=" + this.rightButton + ')';
    }

    public final String getBody() {
        return this.body;
    }

    public final List<Range> getBoldBodyRangeList() {
        return this.boldBodyRangeList;
    }

    public final Button getLeftButton() {
        return this.leftButton;
    }

    public final Button getRightButton() {
        return this.rightButton;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getTargetPage() {
        return this.targetPage;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleSchema() {
        return this.titleSchema;
    }

    public final String getTitleTargetPage() {
        return this.titleTargetPage;
    }

    public CommonNoticeData(Button r100, String r101, String r102, String r103, String r104, List<Range> r105, String r106, String r107, Button r108) {
        this.leftButton = r100;
        this.title = r101;
        this.titleSchema = r102;
        this.titleTargetPage = r103;
        this.body = r104;
        this.boldBodyRangeList = r105;
        this.schema = r106;
        this.targetPage = r107;
        this.rightButton = r108;
    }

    public /* synthetic */ CommonNoticeData(Button r110, String r111, String r112, String r113, String r114, List r115, String r116, String r117, Button r118, int r210, DefaultConstructorMarker r211) {
        Button r100 = null;
        if ((r210 & 1) == 0) goto L5;
        Button r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
