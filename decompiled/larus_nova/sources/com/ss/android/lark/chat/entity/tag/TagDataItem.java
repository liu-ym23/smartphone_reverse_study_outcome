package com.ss.android.lark.chat.entity.tag;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J:\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010 R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/entity/tag/TagDataItem;", "Ljava/io/Serializable;", "text", "", "tagType", "Lcom/ss/android/lark/chat/entity/tag/TagTypeEnum;", "relationTagType", "Lcom/ss/android/lark/chat/entity/tag/TagRelationTypeEnum;", "priority", "", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/tag/TagTypeEnum;Lcom/ss/android/lark/chat/entity/tag/TagRelationTypeEnum;Ljava/lang/Integer;)V", "getText", "()Ljava/lang/String;", "getTagType", "()Lcom/ss/android/lark/chat/entity/tag/TagTypeEnum;", "getRelationTagType", "()Lcom/ss/android/lark/chat/entity/tag/TagRelationTypeEnum;", "getPriority", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "equals", "", "other", "", "hashCode", "toString", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/tag/TagTypeEnum;Lcom/ss/android/lark/chat/entity/tag/TagRelationTypeEnum;Ljava/lang/Integer;)Lcom/ss/android/lark/chat/entity/tag/TagDataItem;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagDataItem implements Serializable {
    private final Integer priority;
    private final TagRelationTypeEnum relationTagType;
    private final TagTypeEnum tagType;
    private final String text;

    public static /* synthetic */ TagDataItem copy$default(TagDataItem r100, String r101, TagTypeEnum r102, TagRelationTypeEnum r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.tagType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.relationTagType;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.priority;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.text;
    }

    public final TagTypeEnum component2() {
        return this.tagType;
    }

    public final TagRelationTypeEnum component3() {
        return this.relationTagType;
    }

    public final Integer component4() {
        return this.priority;
    }

    public final TagDataItem copy(String r100, TagTypeEnum r101, TagRelationTypeEnum r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r101, "tagType");
        Intrinsics.checkNotNullParameter(r102, "relationTagType");
        return new TagDataItem(r100, r101, r102, r103);
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.tagType.hashCode()) * 31) + this.relationTagType.hashCode()) * 31;
        Integer r104 = this.priority;
        if (r104 == null) goto L10;
        r101 = r104.intValue();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TagDataItem(tagType=" + this.tagType + ", tagSubType = " + this.relationTagType + ", priority=" + this.priority + ')';
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final TagRelationTypeEnum getRelationTagType() {
        return this.relationTagType;
    }

    public final TagTypeEnum getTagType() {
        return this.tagType;
    }

    public final String getText() {
        return this.text;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(TagDataItem.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.tag.TagDataItem");
        TagDataItem r102 = (TagDataItem) r100;
        if (Intrinsics.areEqual(this.text, r102.text) == true) goto L16;
        return false;
    L16:
        if (this.tagType == r102.tagType) goto L19;
        return false;
    L19:
        if (this.relationTagType == r102.relationTagType) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.priority, r102.priority) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public TagDataItem(String r100, TagTypeEnum r101, TagRelationTypeEnum r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r101, "tagType");
        Intrinsics.checkNotNullParameter(r102, "relationTagType");
        this.text = r100;
        this.tagType = r101;
        this.relationTagType = r102;
        this.priority = r103;
    }

    public /* synthetic */ TagDataItem(String r100, TagTypeEnum r101, TagRelationTypeEnum r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = -1;
    L5:
        this(r100, r101, r102, r103);
    }
}
