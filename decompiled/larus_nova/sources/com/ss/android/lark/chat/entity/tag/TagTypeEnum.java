package com.ss.android.lark.chat.entity.tag;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chat/entity/tag/TagTypeEnum;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TAG_TYPE", "RELATION_TAG", "TENANT_ENTITY_TAG", "toString", "", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TagTypeEnum extends Enum<TagTypeEnum> implements Serializable {
    public static final a Companion = null;
    public static final TagTypeEnum RELATION_TAG = null;
    public static final TagTypeEnum TENANT_ENTITY_TAG = null;
    public static final TagTypeEnum UNKNOWN_TAG_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TagTypeEnum[] f415364a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415365b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static TagTypeEnum a(int r100) {
            if (r100 == 0) goto L11;
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L13;
            return TagTypeEnum.UNKNOWN_TAG_TYPE;
        L13:
            return TagTypeEnum.TENANT_ENTITY_TAG;
        L14:
            return TagTypeEnum.RELATION_TAG;
        L11:
            return TagTypeEnum.UNKNOWN_TAG_TYPE;
        }
    }

    @JvmStatic
    public static final TagTypeEnum forName(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<TagTypeEnum> getEntries() {
        return f415365b;
    }

    static {
        TagTypeEnum r100 = new TagTypeEnum("UNKNOWN_TAG_TYPE", 0, 0);
        UNKNOWN_TAG_TYPE = r100;
        TagTypeEnum r101 = new TagTypeEnum("RELATION_TAG", 1, 1);
        RELATION_TAG = r101;
        TagTypeEnum r102 = new TagTypeEnum("TENANT_ENTITY_TAG", 2, 2);
        TENANT_ENTITY_TAG = r102;
        TagTypeEnum[] r103 = {r100, r101, r102};
        f415364a = r103;
        f415365b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static TagTypeEnum[] values() {
        return (TagTypeEnum[]) f415364a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder r100 = new StringBuilder("TagTypeEnum(");
        Companion.getClass();
        int r101 = getValue();
        if (r101 != 0) goto L5;
    L11:
        String r102 = "Unknown";
    L12:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        if (r101 != 1) goto L7;
        r102 = "Relation_tag";
        goto L12
    L7:
        if (r101 != 2) goto L11;
        r102 = "Tenant_entity_tag";
        goto L12
    }

    public final int getValue() {
        return this.value;
    }

    public static TagTypeEnum valueOf(String r100) {
        return (TagTypeEnum) r27.a.a(TagTypeEnum.class, r100);
    }

    public TagTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
