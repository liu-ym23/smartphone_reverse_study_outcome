package com.larus.bmhome.video;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/video/GroupType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Video", "Graphic", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GroupType extends Enum<GroupType> {
    public static final GroupType Graphic = null;
    public static final GroupType Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GroupType[] f315166a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f315167b = null;
    private final String value;

    public static EnumEntries<GroupType> getEntries() {
        return f315167b;
    }

    static {
        GroupType r100 = new GroupType("Video", 0, "video");
        Video = r100;
        GroupType r101 = new GroupType("Graphic", 1, "graphic");
        Graphic = r101;
        GroupType[] r102 = {r100, r101};
        f315166a = r102;
        f315167b = EnumEntriesKt.enumEntries(r102);
    }

    public static GroupType[] values() {
        return (GroupType[]) f315166a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static GroupType valueOf(String r100) {
        return (GroupType) r27.a.a(GroupType.class, r100);
    }

    public GroupType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
