package com.bytedance.ee.bear.templates.banner;

import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00015B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0097\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/templates/banner/BannerData;", "Lcom/bytedance/ee/util/io/NonProguard;", ResourceData.KEY_TYPE, "", ResourceData.KEY_URL, "", "title", "text", "topicId", "templateId", "objType", "objToken", "obj_type_list", "", "jump_link_url", "banner_id", "collection_id", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;)V", "getType", "()I", "getUrl", "()Ljava/lang/String;", "getTitle", "getText", "getTopicId", "getTemplateId", "getObjType", "getObjToken", "getObj_type_list", "()Ljava/util/List;", "getJump_link_url", "getBanner_id", "getCollection_id", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
    public static /* synthetic */ BannerData copy$default(BannerData r13, int r14, String r15, String r16, String r17, String r18, String r19, int r20, String r21, List r22, String r23, int r24, String r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        int r2 = r13.type;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = r13.url;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = r13.title;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = r13.text;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r6 = r13.topicId;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = r13.templateId;
    L27:
        if ((r26 & 64) == 0) goto L29;
        int r8 = r13.objType;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = r13.objToken;
    L35:
        if ((r26 & 256) == 0) goto L37;
        List r10 = r13.obj_type_list;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r11 = r13.jump_link_url;
    L43:
        if ((r26 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        int r12 = r13.banner_id;
    L47:
        if ((r26 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        String r1 = r13.collection_id;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
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

    public final BannerData copy(int r15, String r16, String r17, String r18, String r19, String r20, int r21, String r22, List<Integer> r23, String r24, int r25, String r26) {
        Intrinsics.checkNotNullParameter(r23, "obj_type_list");
        return new BannerData(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BannerData) == true) goto L8;
        return false;
    L8:
        BannerData r6 = (BannerData) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.topicId, r6.topicId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.templateId, r6.templateId) == true) goto L27;
        return false;
    L27:
        if (this.objType == r6.objType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.objToken, r6.objToken) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.obj_type_list, r6.obj_type_list) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.jump_link_url, r6.jump_link_url) == true) goto L39;
        return false;
    L39:
        if (this.banner_id == r6.banner_id) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.collection_id, r6.collection_id) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r0 = this.type * 31;
        String r1 = this.url;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.title;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.text;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.topicId;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.templateId;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((r13 + r15) * 31) + this.objType) * 31;
        String r17 = this.objToken;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((r16 + r18) * 31) + this.obj_type_list.hashCode()) * 31;
        String r20 = this.jump_link_url;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (((r19 + r21) * 31) + this.banner_id) * 31;
        String r23 = this.collection_id;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
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

    public BannerData(int r2, String r3, String r4, String r5, String r6, String r7, int r8, String r9, List<Integer> r10, String r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "obj_type_list");
        this.type = r2;
        this.url = r3;
        this.title = r4;
        this.text = r5;
        this.topicId = r6;
        this.templateId = r7;
        this.objType = r8;
        this.objToken = r9;
        this.obj_type_list = r10;
        this.jump_link_url = r11;
        this.banner_id = r12;
        this.collection_id = r13;
    }

    public BannerData(int r16, String r17, String r18, String r19, String r20, String r21, int r22, String r23, List r24, String r25, int r26, String r27, int r28, DefaultConstructorMarker r29) {
        if ((r28 & 1) == 0) goto L5;
        int r3 = 1;
    L7:
        if ((r28 & 64) == 0) goto L9;
        int r9 = e.g.b;
    L11:
        if ((r28 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L13;
        int r13 = -1;
    L14:
        this(r3, r17, r18, r19, r20, r21, r9, r23, r24, r25, r13, r27);
        return;
    L13:
        r13 = r26;
        goto L14
    L9:
        r9 = r22;
        goto L11
    L5:
        r3 = r16;
        goto L7
    }
}
