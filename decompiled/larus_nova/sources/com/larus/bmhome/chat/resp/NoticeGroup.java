package com.larus.bmhome.chat.resp;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/resp/NoticeGroup;", "", "group", "", "<init>", "(Ljava/lang/String;II)V", "getGroup", "()I", "COMMON", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NoticeGroup extends Enum<NoticeGroup> {
    public static final NoticeGroup COMMON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NoticeGroup[] f308556a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308557b = null;
    private final int group;

    public static EnumEntries<NoticeGroup> getEntries() {
        return f308557b;
    }

    static {
        NoticeGroup r100 = new NoticeGroup();
        COMMON = r100;
        NoticeGroup[] r101 = {r100};
        f308556a = r101;
        f308557b = EnumEntriesKt.enumEntries(r101);
    }

    public NoticeGroup() {
        super("COMMON", 0);
        this.group = 1;
    }

    public static NoticeGroup[] values() {
        return (NoticeGroup[]) f308556a.clone();
    }

    public final int getGroup() {
        return this.group;
    }

    public static NoticeGroup valueOf(String r100) {
        return (NoticeGroup) a.a(NoticeGroup.class, r100);
    }
}
