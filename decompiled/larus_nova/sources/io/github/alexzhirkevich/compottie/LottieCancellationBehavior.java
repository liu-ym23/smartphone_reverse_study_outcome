package io.github.alexzhirkevich.compottie;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/github/alexzhirkevich/compottie/LottieCancellationBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "Immediately", "OnIterationFinish", "compottie_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LottieCancellationBehavior extends Enum<LottieCancellationBehavior> {
    public static final LottieCancellationBehavior Immediately = null;
    public static final LottieCancellationBehavior OnIterationFinish = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LottieCancellationBehavior[] f490691a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f490692b = null;

    public static EnumEntries<LottieCancellationBehavior> getEntries() {
        return f490692b;
    }

    static {
        LottieCancellationBehavior r100 = new LottieCancellationBehavior("Immediately", 0);
        Immediately = r100;
        LottieCancellationBehavior r101 = new LottieCancellationBehavior("OnIterationFinish", 1);
        OnIterationFinish = r101;
        LottieCancellationBehavior[] r102 = {r100, r101};
        f490691a = r102;
        f490692b = EnumEntriesKt.enumEntries(r102);
    }

    public static LottieCancellationBehavior[] values() {
        return (LottieCancellationBehavior[]) f490691a.clone();
    }

    public static LottieCancellationBehavior valueOf(String r100) {
        return (LottieCancellationBehavior) r27.a.a(LottieCancellationBehavior.class, r100);
    }

    public LottieCancellationBehavior(String r100, int r101) {
        super(r100, r101);
    }
}
