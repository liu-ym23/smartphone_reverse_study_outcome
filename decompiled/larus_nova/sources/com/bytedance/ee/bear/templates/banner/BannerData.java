package com.bytedance.ee.bear.templates.banner;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00015B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0097\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/templates/banner/BannerData;", "Lcom/bytedance/ee/util/io/NonProguard;", "type", "", "url", "", "title", "text", "topicId", GXTemplateKey.GAIAX_TEMPLATE_ID, "objType", "objToken", "obj_type_list", "", "jump_link_url", "banner_id", "collection_id", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;)V", "getType", "()I", "getUrl", "()Ljava/lang/String;", "getTitle", "getText", "getTopicId", "getTemplateId", "getObjType", "getObjToken", "getObj_type_list", "()Ljava/util/List;", "getJump_link_url", "getBanner_id", "getCollection_id", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BannerData implements NonProguard {
    public static final int BANNER_TYPE_SCENE = 5;
    public static final int BANNER_TYPE_SINGLE = 1;
    public static final int BANNER_TYPE_TOPIC = 2;
    public static final int BANNER_TYPE_URL = 3;
    public static final a Companion = null;
    private final int banner_id;
    private final String collection_id;
    private final String jump_link_url;
    private final String objToken;
    private final int objType;
    private final List<Integer> obj_type_list;
    private final String templateId;
    private final String text;
    private final String title;
    private final String topicId;
    private final int type;
    private final String url;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BannerData copy$default(BannerData r110, int r111, String r112, String r113, String r114, String r115, String r116, int r210, String r211, List r212, String r213, int r214, String r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        int r100 = r110.type;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.url;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.title;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.text;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.topicId;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.templateId;
    L27:
        if ((r216 & 64) == 0) goto L29;
        int r106 = r110.objType;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.objToken;
    L35:
        if ((r216 & 256) == 0) goto L37;
        List r117 = r110.obj_type_list;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.jump_link_url;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        int r119 = r110.banner_id;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        String r108 = r110.collection_id;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
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

    public final int component1() {
        return this.type;
    }

    public final String component10() {
        return this.jump_link_url;
    }

    public final int component11() {
        return this.banner_id;
    }

    public final String component12() {
        return this.collection_id;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.text;
    }

    public final String component5() {
        return this.topicId;
    }

    public final String component6() {
        return this.templateId;
    }

    public final int component7() {
        return this.objType;
    }

    public final String component8() {
        return this.objToken;
    }

    public final List<Integer> component9() {
        return this.obj_type_list;
    }

    public final BannerData copy(int r110, String r111, String r112, String r113, String r114, String r210, int r211, String r212, List<Integer> r213, String r214, int r215, String r216) {
        Intrinsics.checkNotNullParameter(r213, "obj_type_list");
        return new BannerData(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BannerData) == true) goto L8;
        return false;
    L8:
        BannerData r101 = (BannerData) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.topicId, r101.topicId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.templateId, r101.templateId) == true) goto L27;
        return false;
    L27:
        if (this.objType == r101.objType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.objToken, r101.objToken) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.obj_type_list, r101.obj_type_list) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.jump_link_url, r101.jump_link_url) == true) goto L39;
        return false;
    L39:
        if (this.banner_id == r101.banner_id) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.collection_id, r101.collection_id) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r100 = this.type * 31;
        String r101 = this.url;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.title;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.text;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.topicId;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.templateId;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (((r113 + r115) * 31) + this.objType) * 31;
        String r117 = this.objToken;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (((r116 + r118) * 31) + this.obj_type_list.hashCode()) * 31;
        String r120 = this.jump_link_url;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (((r119 + r121) * 31) + this.banner_id) * 31;
        String r123 = this.collection_id;
        if (r123 == null) goto L35;
        r102 = r123.hashCode();
    L35:
        return r122 + r102;
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "BannerData(type=" + this.type + ", url=" + this.url + ", title=" + this.title + ", text=" + this.text + ", topicId=" + this.topicId + ", templateId=" + this.templateId + ", objType=" + this.objType + ", objToken=" + this.objToken + ", obj_type_list=" + this.obj_type_list + ", jump_link_url=" + this.jump_link_url + ", banner_id=" + this.banner_id + ", collection_id=" + this.collection_id + ')';
    }

    public final int getBanner_id() {
        return this.banner_id;
    }

    public final String getCollection_id() {
        return this.collection_id;
    }

    public final String getJump_link_url() {
        return this.jump_link_url;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final List<Integer> getObj_type_list() {
        return this.obj_type_list;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public BannerData(int r100, String r101, String r102, String r103, String r104, String r105, int r106, String r107, List<Integer> r110, String r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "obj_type_list");
        this.type = r100;
        this.url = r101;
        this.title = r102;
        this.text = r103;
        this.topicId = r104;
        this.templateId = r105;
        this.objType = r106;
        this.objToken = r107;
        this.obj_type_list = r110;
        this.jump_link_url = r111;
        this.banner_id = r112;
        this.collection_id = r113;
    }

    public BannerData(int r110, String r111, String r112, String r113, String r210, String r211, int r212, String r213, List r214, String r215, int r216, String r217, int r218, DefaultConstructorMarker r219) {
        if ((r218 & 1) == 0) goto L5;
        int r100 = 1;
    L7:
        if ((r218 & 64) == 0) goto L9;
        int r101 = e.f541296g.f541317b;
    L11:
        if ((r218 & 1024) == 0) goto L13;
        int r114 = -1;
    L14:
        this(r100, r111, r112, r113, r210, r211, r101, r213, r214, r215, r114, r217);
        return;
    L13:
        r114 = r216;
        goto L14
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
