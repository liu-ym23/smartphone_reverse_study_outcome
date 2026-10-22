package com.ss.android.lark.chat.entity.tag;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/entity/tag/TagRelationTypeEnum;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RELATION_TAG_UNSET", "RELATION_TAG_EXTERNAL", "RELATION_TAG_PARTNER", "RELATION_TAG_TENANT_NAME", "toString", "", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TagRelationTypeEnum extends Enum<TagRelationTypeEnum> implements Serializable {
    public static final a Companion = null;
    public static final TagRelationTypeEnum RELATION_TAG_EXTERNAL = null;
    public static final TagRelationTypeEnum RELATION_TAG_PARTNER = null;
    public static final TagRelationTypeEnum RELATION_TAG_TENANT_NAME = null;
    public static final TagRelationTypeEnum RELATION_TAG_UNSET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TagRelationTypeEnum[] f415362a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415363b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static TagRelationTypeEnum a(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L18;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L16;
            return TagRelationTypeEnum.RELATION_TAG_UNSET;
        L16:
            return TagRelationTypeEnum.RELATION_TAG_TENANT_NAME;
        L17:
            return TagRelationTypeEnum.RELATION_TAG_PARTNER;
        L18:
            return TagRelationTypeEnum.RELATION_TAG_EXTERNAL;
        L14:
            return TagRelationTypeEnum.RELATION_TAG_UNSET;
        }
    }

    @JvmStatic
    public static final TagRelationTypeEnum forName(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<TagRelationTypeEnum> getEntries() {
        return f415363b;
    }

    static {
        TagRelationTypeEnum r100 = new TagRelationTypeEnum("RELATION_TAG_UNSET", 0, 0);
        RELATION_TAG_UNSET = r100;
        TagRelationTypeEnum r101 = new TagRelationTypeEnum("RELATION_TAG_EXTERNAL", 1, 1);
        RELATION_TAG_EXTERNAL = r101;
        TagRelationTypeEnum r102 = new TagRelationTypeEnum("RELATION_TAG_PARTNER", 2, 2);
        RELATION_TAG_PARTNER = r102;
        TagRelationTypeEnum r103 = new TagRelationTypeEnum("RELATION_TAG_TENANT_NAME", 3, 3);
        RELATION_TAG_TENANT_NAME = r103;
        TagRelationTypeEnum[] r104 = {r100, r101, r102, r103};
        f415362a = r104;
        f415363b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static TagRelationTypeEnum[] values() {
        return (TagRelationTypeEnum[]) f415362a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder r100 = new StringBuilder("TagSubTypeEnum(");
        Companion.getClass();
        int r101 = getValue();
        if (r101 != 0) goto L5;
    L14:
        String r102 = "TAG_UNSET";
    L15:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        if (r101 != 1) goto L7;
        r102 = "TAG_EXTERNAL";
        goto L15
    L7:
        if (r101 != 2) goto L9;
        r102 = "TAG_PARTNER";
        goto L15
    L9:
        if (r101 != 3) goto L14;
        r102 = "TAG_TENANT_NAME";
        goto L15
    }

    public final int getValue() {
        return this.value;
    }

    public static TagRelationTypeEnum valueOf(String r100) {
        return (TagRelationTypeEnum) r27.a.a(TagRelationTypeEnum.class, r100);
    }

    public TagRelationTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
