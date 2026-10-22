package com.larus.im.service.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/service/audio/AvConnectionType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Default", "TokenPoolWithRTCMerge", "Companion", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AvConnectionType extends Enum<AvConnectionType> {
    public static final a Companion = null;
    public static final AvConnectionType Default = null;
    public static final AvConnectionType TokenPoolWithRTCMerge = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvConnectionType[] f350635a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350636b = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<AvConnectionType> getEntries() {
        return f350636b;
    }

    static {
        AvConnectionType r100 = new AvConnectionType("Default", 0, 0);
        Default = r100;
        AvConnectionType r101 = new AvConnectionType("TokenPoolWithRTCMerge", 1, 1);
        TokenPoolWithRTCMerge = r101;
        AvConnectionType[] r102 = {r100, r101};
        f350635a = r102;
        f350636b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static AvConnectionType[] values() {
        return (AvConnectionType[]) f350635a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static AvConnectionType valueOf(String r100) {
        return (AvConnectionType) r27.a.a(AvConnectionType.class, r100);
    }

    public AvConnectionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
