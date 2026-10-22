package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public final class Jsr305Settings {
    private final Lazy description$delegate;
    private final ReportLevel globalLevel;
    private final boolean isDisabled;
    private final ReportLevel migrationLevel;
    private final Map<FqName, ReportLevel> userDefinedLevelForSpecificAnnotation;

    public static /* synthetic */ String[] accessor$Jsr305Settings$lambda0(Jsr305Settings r100) {
        return description_delegate$lambda$3(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Jsr305Settings) == true) goto L8;
        return false;
    L8:
        Jsr305Settings r101 = (Jsr305Settings) r100;
        if (this.globalLevel == r101.globalLevel) goto L12;
        return false;
    L12:
        if (this.migrationLevel == r101.migrationLevel) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userDefinedLevelForSpecificAnnotation, r101.userDefinedLevelForSpecificAnnotation) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.globalLevel.hashCode() * 31;
        ReportLevel r101 = this.migrationLevel;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.userDefinedLevelForSpecificAnnotation.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.globalLevel + ", migrationLevel=" + this.migrationLevel + ", userDefinedLevelForSpecificAnnotation=" + this.userDefinedLevelForSpecificAnnotation + ')';
    }

    public final ReportLevel getGlobalLevel() {
        return this.globalLevel;
    }

    public final ReportLevel getMigrationLevel() {
        return this.migrationLevel;
    }

    public final Map<FqName, ReportLevel> getUserDefinedLevelForSpecificAnnotation() {
        return this.userDefinedLevelForSpecificAnnotation;
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    private static final String[] description_delegate$lambda$3(Jsr305Settings r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        List r101 = CollectionsKt.createListBuilder();
        r101.add(r100.globalLevel.getDescription());
        ReportLevel r102 = r100.migrationLevel;
        if (r102 == null) goto L5;
        r101.add("under-migration:" + r102.getDescription());
    L5:
        Iterator<Map.Entry<FqName, ReportLevel>> r103 = r100.userDefinedLevelForSpecificAnnotation.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<FqName, ReportLevel> r104 = r103.next();
        r101.add("@" + r104.getKey() + ':' + r104.getValue().getDescription());
        goto L7
    L10:
        return (String[]) CollectionsKt.build(r101).toArray(new String[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Jsr305Settings(ReportLevel r100, ReportLevel r101, Map<FqName, ? extends ReportLevel> r102) {
        Intrinsics.checkNotNullParameter(r100, "globalLevel");
        Intrinsics.checkNotNullParameter(r102, "userDefinedLevelForSpecificAnnotation");
        this.globalLevel = r100;
        this.migrationLevel = r101;
        this.userDefinedLevelForSpecificAnnotation = r102;
        this.description$delegate = LazyKt.lazy(new Jsr305Settings$$Lambda$0(this));
        ReportLevel r103 = ReportLevel.IGNORE;
        if (r100 != r103) goto L8;
        if (r101 != r103) goto L8;
        if (r102.isEmpty() == false) goto L8;
        boolean r104 = true;
    L9:
        this.isDisabled = r104;
        return;
    L8:
        r104 = false;
        goto L9
    }

    public /* synthetic */ Jsr305Settings(ReportLevel r100, ReportLevel r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = MapsKt.emptyMap();
    L8:
        this(r100, r101, r102);
    }
}
