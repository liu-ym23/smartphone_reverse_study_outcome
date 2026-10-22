package org.jetbrains.compose.resources;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes42.dex */
@InternalResourceApi
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lorg/jetbrains/compose/resources/DensityQualifier;", "Lorg/jetbrains/compose/resources/Qualifier;", "", "dpi", "", "<init>", "(Ljava/lang/String;II)V", "getDpi", "()I", "LDPI", "MDPI", "HDPI", "XHDPI", "XXHDPI", "XXXHDPI", "Companion", "library_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DensityQualifier extends Enum<DensityQualifier> {
    public static final a Companion = null;
    public static final DensityQualifier HDPI = null;
    public static final DensityQualifier LDPI = null;
    public static final DensityQualifier MDPI = null;
    public static final DensityQualifier XHDPI = null;
    public static final DensityQualifier XXHDPI = null;
    public static final DensityQualifier XXXHDPI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DensityQualifier[] f525829a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f525830b = null;
    private final int dpi;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DensityQualifier> getEntries() {
        return f525830b;
    }

    static {
        DensityQualifier r100 = new DensityQualifier("LDPI", 0, 120);
        LDPI = r100;
        DensityQualifier r101 = new DensityQualifier("MDPI", 1, 160);
        MDPI = r101;
        DensityQualifier r102 = new DensityQualifier("HDPI", 2, 240);
        HDPI = r102;
        DensityQualifier r103 = new DensityQualifier("XHDPI", 3, 320);
        XHDPI = r103;
        DensityQualifier r104 = new DensityQualifier("XXHDPI", 4, 480);
        XXHDPI = r104;
        DensityQualifier r105 = new DensityQualifier("XXXHDPI", 5, 640);
        XXXHDPI = r105;
        DensityQualifier[] r110 = {r100, r101, r102, r103, r104, r105};
        f525829a = r110;
        f525830b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static DensityQualifier[] values() {
        return (DensityQualifier[]) f525829a.clone();
    }

    public final int getDpi() {
        return this.dpi;
    }

    public static DensityQualifier valueOf(String r100) {
        return (DensityQualifier) r27.a.a(DensityQualifier.class, r100);
    }

    public DensityQualifier(String r100, int r101, int r102) {
        super(r100, r101);
        this.dpi = r102;
    }
}
