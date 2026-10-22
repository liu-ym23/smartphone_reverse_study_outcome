package com.larus.dora.impl.frameassembler;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/frameassembler/DoraDuplicateFramePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "OVERWRITE", "IGNORE_NEW", "FAIL_SESSION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraDuplicateFramePolicy extends Enum<DoraDuplicateFramePolicy> {
    public static final DoraDuplicateFramePolicy FAIL_SESSION = null;
    public static final DoraDuplicateFramePolicy IGNORE_NEW = null;
    public static final DoraDuplicateFramePolicy OVERWRITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraDuplicateFramePolicy[] f335778a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335779b = null;

    public static EnumEntries<DoraDuplicateFramePolicy> getEntries() {
        return f335779b;
    }

    static {
        DoraDuplicateFramePolicy r100 = new DoraDuplicateFramePolicy("OVERWRITE", 0);
        OVERWRITE = r100;
        DoraDuplicateFramePolicy r101 = new DoraDuplicateFramePolicy("IGNORE_NEW", 1);
        IGNORE_NEW = r101;
        DoraDuplicateFramePolicy r102 = new DoraDuplicateFramePolicy("FAIL_SESSION", 2);
        FAIL_SESSION = r102;
        DoraDuplicateFramePolicy[] r103 = {r100, r101, r102};
        f335778a = r103;
        f335779b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraDuplicateFramePolicy[] values() {
        return (DoraDuplicateFramePolicy[]) f335778a.clone();
    }

    public static DoraDuplicateFramePolicy valueOf(String r100) {
        return (DoraDuplicateFramePolicy) r27.a.a(DoraDuplicateFramePolicy.class, r100);
    }

    public DoraDuplicateFramePolicy(String r100, int r101) {
        super(r100, r101);
    }
}
