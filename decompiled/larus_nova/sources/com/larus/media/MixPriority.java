package com.larus.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/media/MixPriority;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IDLE", "DEFAULT", "MIX_LOW", "MIX_NORMAL", "MIX_HIGH", "Companion", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MixPriority extends Enum<MixPriority> {
    public static final a Companion = null;
    public static final MixPriority DEFAULT = null;
    public static final MixPriority IDLE = null;
    public static final MixPriority MIX_HIGH = null;
    public static final MixPriority MIX_LOW = null;
    public static final MixPriority MIX_NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MixPriority[] f358964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358965b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MixPriority> getEntries() {
        return f358965b;
    }

    static {
        MixPriority r100 = new MixPriority("IDLE", 0, -1);
        IDLE = r100;
        MixPriority r101 = new MixPriority("DEFAULT", 1, 0);
        DEFAULT = r101;
        MixPriority r102 = new MixPriority("MIX_LOW", 2, 1);
        MIX_LOW = r102;
        MixPriority r103 = new MixPriority("MIX_NORMAL", 3, 2);
        MIX_NORMAL = r103;
        MixPriority r104 = new MixPriority("MIX_HIGH", 4, 3);
        MIX_HIGH = r104;
        MixPriority[] r105 = {r100, r101, r102, r103, r104};
        f358964a = r105;
        f358965b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static MixPriority[] values() {
        return (MixPriority[]) f358964a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MixPriority valueOf(String r100) {
        return (MixPriority) r27.a.a(MixPriority.class, r100);
    }

    public MixPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
