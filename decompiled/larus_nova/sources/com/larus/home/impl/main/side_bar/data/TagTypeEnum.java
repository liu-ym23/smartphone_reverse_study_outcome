package com.larus.home.impl.main.side_bar.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/TagTypeEnum;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "TAG_NEW", "TAG_RED_DOT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TagTypeEnum extends Enum<TagTypeEnum> {
    public static final TagTypeEnum TAG_NEW = null;
    public static final TagTypeEnum TAG_RED_DOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TagTypeEnum[] f344476a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344477b = null;
    private final int type;

    public static EnumEntries<TagTypeEnum> getEntries() {
        return f344477b;
    }

    static {
        TagTypeEnum r100 = new TagTypeEnum("TAG_NEW", 0, 1);
        TAG_NEW = r100;
        TagTypeEnum r101 = new TagTypeEnum("TAG_RED_DOT", 1, 2);
        TAG_RED_DOT = r101;
        TagTypeEnum[] r102 = {r100, r101};
        f344476a = r102;
        f344477b = EnumEntriesKt.enumEntries(r102);
    }

    public static TagTypeEnum[] values() {
        return (TagTypeEnum[]) f344476a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static TagTypeEnum valueOf(String r100) {
        return (TagTypeEnum) r27.a.a(TagTypeEnum.class, r100);
    }

    public TagTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
