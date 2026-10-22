package io.github.alexzhirkevich.compottie.internal.platform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/github/alexzhirkevich/compottie/internal/platform/ComposeBackend;", "", "<init>", "(Ljava/lang/String;I)V", "Android", "Skiko", "compottie_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ComposeBackend extends Enum<ComposeBackend> {
    public static final ComposeBackend Android = null;
    public static final ComposeBackend Skiko = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComposeBackend[] f491375a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f491376b = null;

    public static EnumEntries<ComposeBackend> getEntries() {
        return f491376b;
    }

    static {
        ComposeBackend r100 = new ComposeBackend("Android", 0);
        Android = r100;
        ComposeBackend r101 = new ComposeBackend("Skiko", 1);
        Skiko = r101;
        ComposeBackend[] r102 = {r100, r101};
        f491375a = r102;
        f491376b = EnumEntriesKt.enumEntries(r102);
    }

    public static ComposeBackend[] values() {
        return (ComposeBackend[]) f491375a.clone();
    }

    public static ComposeBackend valueOf(String r100) {
        return (ComposeBackend) a.a(ComposeBackend.class, r100);
    }

    public ComposeBackend(String r100, int r101) {
        super(r100, r101);
    }
}
