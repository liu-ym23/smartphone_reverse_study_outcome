package com.bytedance.ee.bear.templates.preview.data;

import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.diskmanage.NonProguard;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yn5.d;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u008f\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\fHÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/data/CommonPreviewTemplateData;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "templateSource", "", "templateCenterSource", "templateSort", "templateTag", "parentToken", EventConstant.Key.MODULE, "spaceId", "createSelectResultJson", "initIndex", "", "keywords", "list", "Ljava/util/LinkedList;", "Lcom/bytedance/ee/bear/templates/preview/data/Item;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/LinkedList;)V", "getTemplateSource", "()Ljava/lang/String;", "getTemplateCenterSource", "getTemplateSort", "getTemplateTag", "getParentToken", "getModule", "getSpaceId", "getCreateSelectResultJson", "getInitIndex", "()I", "getKeywords", "getList", "()Ljava/util/LinkedList;", "bitableSelectResult", "Lcom/bytedance/ee/bear/templates/bean/TemplateBitableSelectResult;", "getBitableSelectResult", "()Lcom/bytedance/ee/bear/templates/bean/TemplateBitableSelectResult;", "setBitableSelectResult", "(Lcom/bytedance/ee/bear/templates/bean/TemplateBitableSelectResult;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "toString", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonPreviewTemplateData implements NonProguard {
    private d bitableSelectResult;
    private final String createSelectResultJson;
    private final int initIndex;
    private final String keywords;
    private final LinkedList<Item> list;
    private final String module;
    private final String parentToken;
    private final String spaceId;
    private final String templateCenterSource;
    private final String templateSort;
    private final String templateSource;
    private final String templateTag;

    public CommonPreviewTemplateData() {
        this(null, null, null, null, null, null, null, null, 0, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonPreviewTemplateData copy$default(CommonPreviewTemplateData r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, int r211, String r212, LinkedList r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.templateSource;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.templateCenterSource;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.templateSort;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.templateTag;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.parentToken;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.module;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.spaceId;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.createSelectResultJson;
    L35:
        if ((r214 & 256) == 0) goto L37;
        int r118 = r110.initIndex;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.keywords;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        LinkedList r108 = r110.list;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final String component1() {
        return this.templateSource;
    }

    public final String component10() {
        return this.keywords;
    }

    public final LinkedList<Item> component11() {
        return this.list;
    }

    public final String component2() {
        return this.templateCenterSource;
    }

    public final String component3() {
        return this.templateSort;
    }

    public final String component4() {
        return this.templateTag;
    }

    public final String component5() {
        return this.parentToken;
    }

    public final String component6() {
        return this.module;
    }

    public final String component7() {
        return this.spaceId;
    }

    public final String component8() {
        return this.createSelectResultJson;
    }

    public final int component9() {
        return this.initIndex;
    }

    public final CommonPreviewTemplateData copy(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, int r212, String r213, LinkedList<Item> r214) {
        Intrinsics.checkNotNullParameter(r214, "list");
        return new CommonPreviewTemplateData(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonPreviewTemplateData) == true) goto L8;
        return false;
    L8:
        CommonPreviewTemplateData r101 = (CommonPreviewTemplateData) r100;
        if (Intrinsics.areEqual(this.templateSource, r101.templateSource) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateCenterSource, r101.templateCenterSource) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templateSort, r101.templateSort) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateTag, r101.templateTag) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.parentToken, r101.parentToken) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.module, r101.module) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.spaceId, r101.spaceId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.createSelectResultJson, r101.createSelectResultJson) == true) goto L33;
        return false;
    L33:
        if (this.initIndex == r101.initIndex) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.keywords, r101.keywords) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.list, r101.list) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.templateSource;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.templateCenterSource;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.templateSort;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.templateTag;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.parentToken;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.module;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.spaceId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.createSelectResultJson;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (((r121 + r123) * 31) + this.initIndex) * 31;
        String r125 = this.keywords;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return ((r124 + r101) * 31) + this.list.hashCode();
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
        return "CommonPreviewTemplateData(templateSource=" + this.templateSource + ", templateCenterSource=" + this.templateCenterSource + ", templateSort=" + this.templateSort + ", templateTag=" + this.templateTag + ", parentToken=" + this.parentToken + ", module=" + this.module + ", spaceId=" + this.spaceId + ", createSelectResultJson=" + this.createSelectResultJson + ", initIndex=" + this.initIndex + ", keywords=" + this.keywords + ", list=" + this.list + ')';
    }

    public final d getBitableSelectResult() {
        return this.bitableSelectResult;
    }

    public final String getCreateSelectResultJson() {
        return this.createSelectResultJson;
    }

    public final int getInitIndex() {
        return this.initIndex;
    }

    public final String getKeywords() {
        return this.keywords;
    }

    public final LinkedList<Item> getList() {
        return this.list;
    }

    public final String getModule() {
        return this.module;
    }

    public final String getParentToken() {
        return this.parentToken;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final String getTemplateCenterSource() {
        return this.templateCenterSource;
    }

    public final String getTemplateSort() {
        return this.templateSort;
    }

    public final String getTemplateSource() {
        return this.templateSource;
    }

    public final String getTemplateTag() {
        return this.templateTag;
    }

    public final void setBitableSelectResult(d r100) {
        this.bitableSelectResult = r100;
    }

    public CommonPreviewTemplateData(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, int r110, String r111, LinkedList<Item> r112) {
        Intrinsics.checkNotNullParameter(r112, "list");
        this.templateSource = r100;
        this.templateCenterSource = r101;
        this.templateSort = r102;
        this.templateTag = r103;
        this.parentToken = r104;
        this.module = r105;
        this.spaceId = r106;
        this.createSelectResultJson = r107;
        this.initIndex = r110;
        this.keywords = r111;
        this.list = r112;
    }

    public /* synthetic */ CommonPreviewTemplateData(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, int r211, String r212, LinkedList r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        int r117 = 0;
    L39:
        if ((r214 & 512) != 0) goto L43;
        r100 = r212;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        LinkedList r109 = new LinkedList();
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r100, r109);
        return;
    L45:
        r109 = r213;
        goto L46
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
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
