package com.bytedance.relax.ttmlstatic.prewarm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/relax/ttmlstatic/prewarm/TtmlStaticPrewarmPolicy;", "", "(Ljava/lang/String;I)V", "EAGER", "SYSTEM_MEMORY_AWARE", "DISABLED", "relax-kmp-runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum TtmlStaticPrewarmPolicy extends Enum<TtmlStaticPrewarmPolicy> {
    public static final TtmlStaticPrewarmPolicy DISABLED = null;
    public static final TtmlStaticPrewarmPolicy EAGER = null;
    public static final TtmlStaticPrewarmPolicy SYSTEM_MEMORY_AWARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtmlStaticPrewarmPolicy[] f267250a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f267251b = null;

    public static EnumEntries<TtmlStaticPrewarmPolicy> getEntries() {
        return f267251b;
    }

    public static TtmlStaticPrewarmPolicy valueOf(String r100) {
        return (TtmlStaticPrewarmPolicy) r27.a.a(TtmlStaticPrewarmPolicy.class, r100);
    }

    public static TtmlStaticPrewarmPolicy[] values() {
        return (TtmlStaticPrewarmPolicy[]) f267250a.clone();
    }

    static {
        TtmlStaticPrewarmPolicy r100 = new TtmlStaticPrewarmPolicy("EAGER", 0);
        EAGER = r100;
        TtmlStaticPrewarmPolicy r101 = new TtmlStaticPrewarmPolicy("SYSTEM_MEMORY_AWARE", 1);
        SYSTEM_MEMORY_AWARE = r101;
        TtmlStaticPrewarmPolicy r102 = new TtmlStaticPrewarmPolicy("DISABLED", 2);
        DISABLED = r102;
        TtmlStaticPrewarmPolicy[] r103 = {r100, r101, r102};
        f267250a = r103;
        f267251b = EnumEntriesKt.enumEntries(r103);
    }

    public TtmlStaticPrewarmPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
