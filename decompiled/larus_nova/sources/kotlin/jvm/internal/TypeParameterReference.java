package kotlin.jvm.internal;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", KtvSubElement.CONTAINER, "", "name", "", "variance", "Lkotlin/reflect/KVariance;", "isReified", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "bounds", "", "Lkotlin/reflect/KType;", "()Z", "getName", "()Ljava/lang/String;", "upperBounds", "getUpperBounds$annotations", "()V", "getUpperBounds", "()Ljava/util/List;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "hashCode", "", "setUpperBounds", "", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TypeParameterReference implements KTypeParameter {
    public static final Companion Companion = null;
    private volatile List<? extends KType> bounds;
    private final Object container;
    private final boolean isReified;
    private final String name;
    private final KVariance variance;

    /* JADX INFO: loaded from: classes41.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "()V", "toString", "", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

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

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String toString(KTypeParameter r100) {
            Intrinsics.checkNotNullParameter(r100, "typeParameter");
            StringBuilder r101 = new StringBuilder();
            KVariance r102 = r100.getVariance();
            int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
            if (r103 != 2) goto L5;
            r101.append("in ");
        L9:
            r101.append(r100.getName());
            return r101.toString();
        L5:
            if (r103 != 3) goto L9;
            r101.append("out ");
            goto L9
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void getUpperBounds$annotations() {
    }

    @Override // kotlin.reflect.KTypeParameter
    public List<KType> getUpperBounds() {
        List r100 = this.bounds;
        if (r100 != null) goto L6;
        List<KType> r101 = CollectionsKt.listOf(Reflection.nullableTypeOf(Object.class));
        this.bounds = r101;
        return r101;
    L6:
        return r100;
    }

    public int hashCode() {
        Object r100 = this.container;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + getName().hashCode();
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return Companion.toString(this);
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance getVariance() {
        return this.variance;
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean isReified() {
        return this.isReified;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof TypeParameterReference) == false) goto L9;
        TypeParameterReference r101 = (TypeParameterReference) r100;
        if (Intrinsics.areEqual(this.container, r101.container) == false) goto L9;
        if (Intrinsics.areEqual(getName(), r101.getName()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final void setUpperBounds(List<? extends KType> r100) {
        Intrinsics.checkNotNullParameter(r100, "upperBounds");
        if (this.bounds != null) goto L7;
        this.bounds = r100;
        return;
    L7:
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public TypeParameterReference(Object r100, String r101, KVariance r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "variance");
        this.container = r100;
        this.name = r101;
        this.variance = r102;
        this.isReified = r103;
    }
}
