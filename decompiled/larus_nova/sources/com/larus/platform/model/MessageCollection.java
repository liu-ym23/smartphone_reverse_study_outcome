package com.larus.platform.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010#J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010(J¤\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\nHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(¨\u0006<"}, d2 = {"Lcom/larus/platform/model/MessageCollection;", "", "collectionId", "", "title", "collectionBio", "source", "coverUrl", "subCoverUrl", "collectionType", "", "collectionStatus", "schema", "notAllowedCancel", "", "collectionDetails", "", "Lcom/larus/platform/model/CollectionDetail;", "createTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Long;)V", "getCollectionId", "()Ljava/lang/String;", "getTitle", "getCollectionBio", "getSource", "getCoverUrl", "getSubCoverUrl", "getCollectionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCollectionStatus", "getSchema", "getNotAllowedCancel", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCollectionDetails", "()Ljava/util/List;", "getCreateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Long;)Lcom/larus/platform/model/MessageCollection;", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageCollection {

    @SerializedName("collection_bio")
    private final String collectionBio;

    @SerializedName("collection_detail_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<CollectionDetail> collectionDetails;

    @SerializedName("id")
    private final String collectionId;

    @SerializedName("status")
    private final Integer collectionStatus;

    @SerializedName("collection_type")
    private final Integer collectionType;

    @SerializedName("cover_url")
    private final String coverUrl;

    @SerializedName("create_time")
    private final Long createTime;

    @SerializedName("not_allowed_cancel")
    private final Boolean notAllowedCancel;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("source")
    private final String source;

    @SerializedName("sub_cover_url")
    private final String subCoverUrl;

    @SerializedName("title")
    private final String title;

    public MessageCollection() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageCollection copy$default(MessageCollection r110, String r111, String r112, String r113, String r114, String r115, String r116, Integer r210, Integer r211, String r212, Boolean r213, List r214, Long r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.collectionId;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.collectionBio;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.source;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.coverUrl;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.subCoverUrl;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Integer r106 = r110.collectionType;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Integer r107 = r110.collectionStatus;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.schema;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Boolean r118 = r110.notAllowedCancel;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        List r119 = r110.collectionDetails;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Long r108 = r110.createTime;
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

    public final String component1() {
        return this.collectionId;
    }

    public final Boolean component10() {
        return this.notAllowedCancel;
    }

    public final List<CollectionDetail> component11() {
        return this.collectionDetails;
    }

    public final Long component12() {
        return this.createTime;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.collectionBio;
    }

    public final String component4() {
        return this.source;
    }

    public final String component5() {
        return this.coverUrl;
    }

    public final String component6() {
        return this.subCoverUrl;
    }

    public final Integer component7() {
        return this.collectionType;
    }

    public final Integer component8() {
        return this.collectionStatus;
    }

    public final String component9() {
        return this.schema;
    }

    public final MessageCollection copy(String r110, String r111, String r112, String r113, String r114, String r210, Integer r211, Integer r212, String r213, Boolean r214, List<CollectionDetail> r215, Long r216) {
        return new MessageCollection(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageCollection) == true) goto L8;
        return false;
    L8:
        MessageCollection r101 = (MessageCollection) r100;
        if (Intrinsics.areEqual(this.collectionId, r101.collectionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.collectionBio, r101.collectionBio) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.coverUrl, r101.coverUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.subCoverUrl, r101.subCoverUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.collectionType, r101.collectionType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.collectionStatus, r101.collectionStatus) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.notAllowedCancel, r101.notAllowedCancel) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.collectionDetails, r101.collectionDetails) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.collectionId;
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
        String r107 = this.collectionBio;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.source;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.coverUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.subCoverUrl;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.collectionType;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.collectionStatus;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.schema;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.notAllowedCancel;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        List<CollectionDetail> r131 = this.collectionDetails;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.createTime;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
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
        return "MessageCollection(collectionId=" + this.collectionId + ", title=" + this.title + ", collectionBio=" + this.collectionBio + ", source=" + this.source + ", coverUrl=" + this.coverUrl + ", subCoverUrl=" + this.subCoverUrl + ", collectionType=" + this.collectionType + ", collectionStatus=" + this.collectionStatus + ", schema=" + this.schema + ", notAllowedCancel=" + this.notAllowedCancel + ", collectionDetails=" + this.collectionDetails + ", createTime=" + this.createTime + ')';
    }

    public final String getCollectionBio() {
        return this.collectionBio;
    }

    public final List<CollectionDetail> getCollectionDetails() {
        return this.collectionDetails;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final Integer getCollectionStatus() {
        return this.collectionStatus;
    }

    public final Integer getCollectionType() {
        return this.collectionType;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final Boolean getNotAllowedCancel() {
        return this.notAllowedCancel;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getSubCoverUrl() {
        return this.subCoverUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public MessageCollection(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, Integer r107, String r108, Boolean r110, List<CollectionDetail> r111, Long r112) {
        this.collectionId = r100;
        this.title = r101;
        this.collectionBio = r102;
        this.source = r103;
        this.coverUrl = r104;
        this.subCoverUrl = r105;
        this.collectionType = r106;
        this.collectionStatus = r107;
        this.schema = r108;
        this.notAllowedCancel = r110;
        this.collectionDetails = r111;
        this.createTime = r112;
    }

    public /* synthetic */ MessageCollection(String r110, String r111, String r112, String r113, String r114, String r210, Integer r211, Integer r212, String r213, Boolean r214, List r215, Long r216, int r217, DefaultConstructorMarker r218) {
        String r100 = "";
        if ((r217 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r217 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r217 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r217 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r217 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r217 & 64) == 0) goto L29;
        Integer r107 = 0;
    L31:
        if ((r217 & 128) == 0) goto L33;
        Integer r108 = 0;
    L35:
        if ((r217 & 256) != 0) goto L39;
        r100 = r213;
    L39:
        if ((r217 & 512) == 0) goto L41;
        Boolean r115 = Boolean.FALSE;
    L43:
        if ((r217 & 1024) == 0) goto L45;
        List r116 = CollectionsKt.emptyList();
    L47:
        if ((r217 & 2048) == 0) goto L49;
        Long r109 = 0L;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100, r115, r116, r109);
        return;
    L49:
        r109 = r216;
        goto L50
    L45:
        r116 = r215;
        goto L47
    L41:
        r115 = r214;
        goto L43
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
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
