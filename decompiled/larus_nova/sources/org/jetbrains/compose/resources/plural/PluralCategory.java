package org.jetbrains.compose.resources.plural;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lorg/jetbrains/compose/resources/plural/PluralCategory;", "", "<init>", "(Ljava/lang/String;I)V", "ZERO", "ONE", "TWO", "FEW", "MANY", FlowDoraWifiScene.OTHER, "Companion", "library_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PluralCategory extends Enum<PluralCategory> {
    public static final a Companion = null;
    public static final PluralCategory FEW = null;
    public static final PluralCategory MANY = null;
    public static final PluralCategory ONE = null;
    public static final PluralCategory OTHER = null;
    public static final PluralCategory TWO = null;
    public static final PluralCategory ZERO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluralCategory[] f525847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f525848b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<PluralCategory> getEntries() {
        return f525848b;
    }

    static {
        PluralCategory r100 = new PluralCategory("ZERO", 0);
        ZERO = r100;
        PluralCategory r101 = new PluralCategory("ONE", 1);
        ONE = r101;
        PluralCategory r102 = new PluralCategory("TWO", 2);
        TWO = r102;
        PluralCategory r103 = new PluralCategory("FEW", 3);
        FEW = r103;
        PluralCategory r104 = new PluralCategory("MANY", 4);
        MANY = r104;
        PluralCategory r105 = new PluralCategory(FlowDoraWifiScene.OTHER, 5);
        OTHER = r105;
        PluralCategory[] r110 = {r100, r101, r102, r103, r104, r105};
        f525847a = r110;
        f525848b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static PluralCategory[] values() {
        return (PluralCategory[]) f525847a.clone();
    }

    public static PluralCategory valueOf(String r100) {
        return (PluralCategory) r27.a.a(PluralCategory.class, r100);
    }

    public PluralCategory(String r100, int r101) {
        super(r100, r101);
    }
}
