package com.larus.home.impl.main.side_bar.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/IconTypeEnum;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ICON_IMAGE", "AVATAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IconTypeEnum extends Enum<IconTypeEnum> {
    public static final IconTypeEnum AVATAR = null;
    public static final IconTypeEnum ICON_IMAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconTypeEnum[] f344428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344429b = null;
    private final String type;

    public static EnumEntries<IconTypeEnum> getEntries() {
        return f344429b;
    }

    static {
        IconTypeEnum r100 = new IconTypeEnum("ICON_IMAGE", 0, "icon");
        ICON_IMAGE = r100;
        IconTypeEnum r101 = new IconTypeEnum("AVATAR", 1, "avatar");
        AVATAR = r101;
        IconTypeEnum[] r102 = {r100, r101};
        f344428a = r102;
        f344429b = EnumEntriesKt.enumEntries(r102);
    }

    public static IconTypeEnum[] values() {
        return (IconTypeEnum[]) f344428a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static IconTypeEnum valueOf(String r100) {
        return (IconTypeEnum) r27.a.a(IconTypeEnum.class, r100);
    }

    public IconTypeEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
