package com.larus.avlink.record.page;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/avlink/record/page/TagType;", "", "<init>", "(Ljava/lang/String;I)V", State.RECORDING, "CONVERTING", "OFFLINE", "OFFLINE_RECORDING", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TagType extends Enum<TagType> {
    public static final TagType CONVERTING = null;
    public static final TagType OFFLINE = null;
    public static final TagType OFFLINE_RECORDING = null;
    public static final TagType RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TagType[] f294198a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294199b = null;

    public static EnumEntries<TagType> getEntries() {
        return f294199b;
    }

    static {
        TagType r100 = new TagType(State.RECORDING, 0);
        RECORDING = r100;
        TagType r101 = new TagType("CONVERTING", 1);
        CONVERTING = r101;
        TagType r102 = new TagType("OFFLINE", 2);
        OFFLINE = r102;
        TagType r103 = new TagType("OFFLINE_RECORDING", 3);
        OFFLINE_RECORDING = r103;
        TagType[] r104 = {r100, r101, r102, r103};
        f294198a = r104;
        f294199b = EnumEntriesKt.enumEntries(r104);
    }

    public static TagType[] values() {
        return (TagType[]) f294198a.clone();
    }

    public static TagType valueOf(String r100) {
        return (TagType) r27.a.a(TagType.class, r100);
    }

    public TagType(String r100, int r101) {
        super(r100, r101);
    }
}
