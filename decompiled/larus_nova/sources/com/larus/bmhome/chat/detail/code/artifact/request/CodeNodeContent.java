package com.larus.bmhome.chat.detail.code.artifact.request;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019Jn\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u000b\u0010\u0019¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeNodeContent;", "Ljava/io/Serializable;", "nodeId", "", "path", "language", "description", "content", "reviewStatus", "", "nodeType", "isEntry", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getNodeId", "()Ljava/lang/String;", "getPath", "getLanguage", "getDescription", "getContent", "getReviewStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNodeType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeNodeContent;", "equals", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeNodeContent implements Serializable {

    @SerializedName("content")
    private final String content;

    @SerializedName("description")
    private final String description;

    @SerializedName("is_entry")
    private final Boolean isEntry;

    @SerializedName("language")
    private final String language;

    @SerializedName("node_id")
    private final String nodeId;

    @SerializedName("node_type")
    private final String nodeType;

    @SerializedName("path")
    private final String path;

    @SerializedName("review_status")
    private final Integer reviewStatus;

    public CodeNodeContent() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ CodeNodeContent copy$default(CodeNodeContent r100, String r110, String r111, String r112, String r113, String r114, Integer r115, String r116, Boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.nodeId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.path;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.language;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.description;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.content;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r106 = r100.reviewStatus;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.nodeType;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Boolean r108 = r100.isEntry;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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

    public final String component1() {
        return this.nodeId;
    }

    public final String component2() {
        return this.path;
    }

    public final String component3() {
        return this.language;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.content;
    }

    public final Integer component6() {
        return this.reviewStatus;
    }

    public final String component7() {
        return this.nodeType;
    }

    public final Boolean component8() {
        return this.isEntry;
    }

    public final CodeNodeContent copy(String r110, String r111, String r112, String r113, String r114, Integer r115, String r116, Boolean r117) {
        return new CodeNodeContent(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CodeNodeContent) == true) goto L8;
        return false;
    L8:
        CodeNodeContent r101 = (CodeNodeContent) r100;
        if (Intrinsics.areEqual(this.nodeId, r101.nodeId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.reviewStatus, r101.reviewStatus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.nodeType, r101.nodeType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isEntry, r101.isEntry) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.nodeId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.path;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.language;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.description;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.content;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.reviewStatus;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.nodeType;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.isEntry;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "CodeNodeContent(nodeId=" + this.nodeId + ", path=" + this.path + ", language=" + this.language + ", description=" + this.description + ", content=" + this.content + ", reviewStatus=" + this.reviewStatus + ", nodeType=" + this.nodeType + ", isEntry=" + this.isEntry + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    public final String getNodeType() {
        return this.nodeType;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getReviewStatus() {
        return this.reviewStatus;
    }

    public final Boolean isEntry() {
        return this.isEntry;
    }

    public CodeNodeContent(String r100, String r101, String r102, String r103, String r104, Integer r105, String r106, Boolean r107) {
        this.nodeId = r100;
        this.path = r101;
        this.language = r102;
        this.description = r103;
        this.content = r104;
        this.reviewStatus = r105;
        this.nodeType = r106;
        this.isEntry = r107;
    }

    public /* synthetic */ CodeNodeContent(String r110, String r111, String r112, String r113, String r114, Integer r115, String r116, Boolean r117, int r118, DefaultConstructorMarker r119) {
        Boolean r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
