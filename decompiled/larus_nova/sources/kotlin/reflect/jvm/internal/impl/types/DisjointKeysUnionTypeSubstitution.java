package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes5.dex */
public final class DisjointKeysUnionTypeSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;
    private final TypeSubstitution first;
    private final TypeSubstitution second;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final TypeSubstitution create(TypeSubstitution r100, TypeSubstitution r101) {
            Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_FIRST);
            Intrinsics.checkNotNullParameter(r101, "second");
            if (r100.isEmpty() == false) goto L6;
            return r101;
        L6:
            if (r101.isEmpty() == false) goto L9;
            return r100;
        L9:
            return new DisjointKeysUnionTypeSubstitution(r100, r101, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ DisjointKeysUnionTypeSubstitution(TypeSubstitution r100, TypeSubstitution r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    @JvmStatic
    public static final TypeSubstitution create(TypeSubstitution r100, TypeSubstitution r101) {
        return Companion.create(r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateCapturedTypes() {
        if (this.first.approximateCapturedTypes() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.second.approximateCapturedTypes() == true) goto L8;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        if (this.first.approximateContravariantCapturedTypes() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.second.approximateContravariantCapturedTypes() == true) goto L8;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public Annotations filterAnnotations(Annotations r100) {
        Intrinsics.checkNotNullParameter(r100, "annotations");
        return this.second.filterAnnotations(this.first.filterAnnotations(r100));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo10737get(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        TypeProjection r101 = this.first.mo10737get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return this.second.mo10737get(r100);
    }

    private DisjointKeysUnionTypeSubstitution(TypeSubstitution r100, TypeSubstitution r101) {
        this.first = r100;
        this.second = r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public KotlinType prepareTopLevelType(KotlinType r100, Variance r101) {
        Intrinsics.checkNotNullParameter(r100, "topLevelType");
        Intrinsics.checkNotNullParameter(r101, "position");
        return this.second.prepareTopLevelType(this.first.prepareTopLevelType(r100, r101), r101);
    }
}
