package kotlin.reflect;

import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KTypeProjection {
    public static final Companion Companion = null;
    public static final KTypeProjection star = null;
    private final KType type;
    private final KVariance variance;

    /* JADX INFO: loaded from: classes41.dex */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", ScoreTags.SCORE_TYPE_STAR, "getStar$annotations", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getStar$annotations() {
        }

        public final KTypeProjection getSTAR() {
            return KTypeProjection.star;
        }

        @JvmStatic
        public final KTypeProjection contravariant(KType r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            return new KTypeProjection(KVariance.IN, r100);
        }

        @JvmStatic
        public final KTypeProjection covariant(KType r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            return new KTypeProjection(KVariance.OUT, r100);
        }

        @JvmStatic
        public final KTypeProjection invariant(KType r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            return new KTypeProjection(KVariance.INVARIANT, r100);
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[KVariance.values().length];
            r100[KVariance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[KVariance.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    @JvmStatic
    public static final KTypeProjection contravariant(KType r100) {
        return Companion.contravariant(r100);
    }

    public static /* synthetic */ KTypeProjection copy$default(KTypeProjection r100, KVariance r101, KType r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.variance;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        return r100.copy(r101, r102);
    }

    @JvmStatic
    public static final KTypeProjection covariant(KType r100) {
        return Companion.covariant(r100);
    }

    @JvmStatic
    public static final KTypeProjection invariant(KType r100) {
        return Companion.invariant(r100);
    }

    public final KVariance component1() {
        return this.variance;
    }

    public final KType component2() {
        return this.type;
    }

    public final KTypeProjection copy(KVariance r100, KType r101) {
        return new KTypeProjection(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KTypeProjection) == true) goto L8;
        return false;
    L8:
        KTypeProjection r101 = (KTypeProjection) r100;
        if (this.variance == r101.variance) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        KVariance r100 = this.variance;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        KType r104 = this.type;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    static {
        Companion = new Companion(null);
        star = new KTypeProjection(null, null);
    }

    public String toString() {
        KVariance r100 = this.variance;
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        if (r101 != (-1)) goto L8;
        return "*";
    L8:
        if (r101 == 1) goto L22;
        if (r101 == 2) goto L21;
        if (r101 != 3) goto L15;
        return "out " + this.type;
    L15:
        throw new NoWhenBranchMatchedException();
    L21:
        return "in " + this.type;
    L22:
        return String.valueOf(this.type);
    L5:
        r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        goto L6
    }

    public final KType getType() {
        return this.type;
    }

    public final KVariance getVariance() {
        return this.variance;
    }

    public KTypeProjection(KVariance r100, KType r101) {
        this.variance = r100;
        this.type = r101;
        boolean r102 = true;
        if (r100 != null) goto L5;
        boolean r103 = true;
    L6:
        if (r101 != null) goto L8;
        boolean r104 = true;
    L9:
        if (r103 == r104) goto L12;
        r102 = false;
    L12:
        if (r102 == true) goto L18;
        if (r100 != null) goto L15;
        String r105 = "Star projection must have no type specified.";
    L17:
        throw new IllegalArgumentException(r105.toString());
    L15:
        r105 = "The projection variance " + r100 + " requires type to be specified.";
        goto L17
    L18:
        return;
    L8:
        r104 = false;
        goto L9
    L5:
        r103 = false;
        goto L6
    }
}
