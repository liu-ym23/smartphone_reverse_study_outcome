package com.larus.livetutor.impl.typing.enumeration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/livetutor/impl/typing/enumeration/TypingMode;", "", "<init>", "(Ljava/lang/String;I)V", "CharByCharTypingMode", "FlushTypingMode", "MaskErasureTypingMode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TypingMode extends Enum<TypingMode> {
    public static final TypingMode CharByCharTypingMode = null;
    public static final TypingMode FlushTypingMode = null;
    public static final TypingMode MaskErasureTypingMode = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypingMode[] f356601a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f356602b = null;

    public static EnumEntries<TypingMode> getEntries() {
        return f356602b;
    }

    static {
        TypingMode r100 = new TypingMode("CharByCharTypingMode", 0);
        CharByCharTypingMode = r100;
        TypingMode r101 = new TypingMode("FlushTypingMode", 1);
        FlushTypingMode = r101;
        TypingMode r102 = new TypingMode("MaskErasureTypingMode", 2);
        MaskErasureTypingMode = r102;
        TypingMode[] r103 = {r100, r101, r102};
        f356601a = r103;
        f356602b = EnumEntriesKt.enumEntries(r103);
    }

    public static TypingMode[] values() {
        return (TypingMode[]) f356601a.clone();
    }

    public static TypingMode valueOf(String r100) {
        return (TypingMode) a.a(TypingMode.class, r100);
    }

    public TypingMode(String r100, int r101) {
        super(r100, r101);
    }
}
