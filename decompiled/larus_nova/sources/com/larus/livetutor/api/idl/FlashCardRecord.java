package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003JV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\bHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001a¨\u0006,"}, d2 = {"Lcom/larus/livetutor/api/idl/FlashCardRecord;", "Ljava/io/Serializable;", "id", "", "flashCardTaskId", "createdTime", "updatedTime", "topicContent", "", "jumpSchema", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getFlashCardTaskId", "setFlashCardTaskId", "getCreatedTime", "setCreatedTime", "getUpdatedTime", "setUpdatedTime", "getTopicContent", "()Ljava/lang/String;", "setTopicContent", "(Ljava/lang/String;)V", "getJumpSchema", "setJumpSchema", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/livetutor/api/idl/FlashCardRecord;", "equals", "", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlashCardRecord implements Serializable {

    @SerializedName("created_time")
    private Long createdTime;

    @SerializedName("flash_card_task_id")
    private Long flashCardTaskId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private Long f355868id;

    @SerializedName("jump_schema")
    private String jumpSchema;

    @SerializedName("topic_content")
    private String topicContent;

    @SerializedName("updated_time")
    private Long updatedTime;

    public FlashCardRecord() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FlashCardRecord copy$default(FlashCardRecord r100, Long r101, Long r102, Long r103, Long r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f355868id;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.flashCardTaskId;
    L8:
        Long r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.createdTime;
    L11:
        Long r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.updatedTime;
    L14:
        Long r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.topicContent;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.jumpSchema;
    L20:
        Long r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Long component1() {
        return this.f355868id;
    }

    public final Long component2() {
        return this.flashCardTaskId;
    }

    public final Long component3() {
        return this.createdTime;
    }

    public final Long component4() {
        return this.updatedTime;
    }

    public final String component5() {
        return this.topicContent;
    }

    public final String component6() {
        return this.jumpSchema;
    }

    public final FlashCardRecord copy(Long r100, Long r110, Long r111, Long r112, String r113, String r114) {
        return new FlashCardRecord(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlashCardRecord) == true) goto L8;
        return false;
    L8:
        FlashCardRecord r101 = (FlashCardRecord) r100;
        if (Intrinsics.areEqual(this.f355868id, r101.f355868id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.flashCardTaskId, r101.flashCardTaskId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.createdTime, r101.createdTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.updatedTime, r101.updatedTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.topicContent, r101.topicContent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.jumpSchema, r101.jumpSchema) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r100 = this.f355868id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.flashCardTaskId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.createdTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.updatedTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.topicContent;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.jumpSchema;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "FlashCardRecord(id=" + this.f355868id + ", flashCardTaskId=" + this.flashCardTaskId + ", createdTime=" + this.createdTime + ", updatedTime=" + this.updatedTime + ", topicContent=" + this.topicContent + ", jumpSchema=" + this.jumpSchema + ')';
    }

    public final Long getCreatedTime() {
        return this.createdTime;
    }

    public final Long getFlashCardTaskId() {
        return this.flashCardTaskId;
    }

    public final Long getId() {
        return this.f355868id;
    }

    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    public final String getTopicContent() {
        return this.topicContent;
    }

    public final Long getUpdatedTime() {
        return this.updatedTime;
    }

    public final void setCreatedTime(Long r100) {
        this.createdTime = r100;
    }

    public final void setFlashCardTaskId(Long r100) {
        this.flashCardTaskId = r100;
    }

    public final void setId(Long r100) {
        this.f355868id = r100;
    }

    public final void setJumpSchema(String r100) {
        this.jumpSchema = r100;
    }

    public final void setTopicContent(String r100) {
        this.topicContent = r100;
    }

    public final void setUpdatedTime(Long r100) {
        this.updatedTime = r100;
    }

    public FlashCardRecord(Long r100, Long r101, Long r102, Long r103, String r104, String r105) {
        this.f355868id = r100;
        this.flashCardTaskId = r101;
        this.createdTime = r102;
        this.updatedTime = r103;
        this.topicContent = r104;
        this.jumpSchema = r105;
    }

    public /* synthetic */ FlashCardRecord(Long r100, Long r101, Long r102, Long r103, String r104, String r110, int r111, DefaultConstructorMarker r112) {
        Long r105 = 0L;
        if ((r111 & 1) == 0) goto L5;
        Long r113 = r105;
    L7:
        if ((r111 & 2) != 0) goto L11;
        r105 = r101;
    L11:
        if ((r111 & 4) == 0) goto L13;
        Long r106 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        Long r107 = null;
    L19:
        if ((r111 & 16) == 0) goto L21;
        String r108 = null;
    L23:
        if ((r111 & 32) == 0) goto L25;
        String r114 = null;
    L26:
        this(r113, r105, r106, r107, r108, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L21:
        r108 = r104;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L5:
        r113 = r100;
        goto L7
    }
}
