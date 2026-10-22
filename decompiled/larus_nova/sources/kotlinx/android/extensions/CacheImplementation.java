package kotlinx.android.extensions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation;", "", "<init>", "(Ljava/lang/String;I)V", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "Companion", "kotlin-android-extensions-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CacheImplementation extends Enum<CacheImplementation> {
    public static final a Companion = null;
    public static final CacheImplementation HASH_MAP = null;
    public static final CacheImplementation NO_CACHE = null;
    public static final CacheImplementation SPARSE_ARRAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CacheImplementation f504594a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ CacheImplementation[] f504595b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f504596c = null;

    public static EnumEntries<CacheImplementation> getEntries() {
        return f504596c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.android.extensions.CacheImplementation$a] */
    static {
        CacheImplementation r100 = new CacheImplementation("SPARSE_ARRAY", 0);
        SPARSE_ARRAY = r100;
        CacheImplementation r101 = new CacheImplementation("HASH_MAP", 1);
        HASH_MAP = r101;
        CacheImplementation r102 = new CacheImplementation("NO_CACHE", 2);
        NO_CACHE = r102;
        CacheImplementation[] r103 = {r100, r101, r102};
        f504595b = r103;
        f504596c = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
        f504594a = r101;
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) f504595b.clone();
    }

    public static final /* synthetic */ CacheImplementation access$getDEFAULT$cp() {
        return f504594a;
    }

    public static CacheImplementation valueOf(String r100) {
        return (CacheImplementation) r27.a.a(CacheImplementation.class, r100);
    }

    public CacheImplementation(String r100, int r101) {
        super(r100, r101);
    }
}
