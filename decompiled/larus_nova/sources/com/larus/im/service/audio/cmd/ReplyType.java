package com.larus.im.service.audio.cmd;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/service/audio/cmd/ReplyType;", "", "<init>", "(Ljava/lang/String;I)V", "Text", "Sentence", "Think", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplyType extends Enum<ReplyType> {
    public static final ReplyType Sentence = null;
    public static final ReplyType Text = null;
    public static final ReplyType Think = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplyType[] f350723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350724b = null;

    public static EnumEntries<ReplyType> getEntries() {
        return f350724b;
    }

    static {
        ReplyType r100 = new ReplyType("Text", 0);
        Text = r100;
        ReplyType r101 = new ReplyType("Sentence", 1);
        Sentence = r101;
        ReplyType r102 = new ReplyType("Think", 2);
        Think = r102;
        ReplyType[] r103 = {r100, r101, r102};
        f350723a = r103;
        f350724b = EnumEntriesKt.enumEntries(r103);
    }

    public static ReplyType[] values() {
        return (ReplyType[]) f350723a.clone();
    }

    public static ReplyType valueOf(String r100) {
        return (ReplyType) a.a(ReplyType.class, r100);
    }

    public ReplyType(String r100, int r101) {
        super(r100, r101);
    }
}
