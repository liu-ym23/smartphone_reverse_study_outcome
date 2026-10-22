package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TypeSubstitution {
    public static final Companion Companion = null;
    public static final TypeSubstitution EMPTY = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public TypeSubstitution() {
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    public Annotations filterAnnotations(Annotations r100) {
        Intrinsics.checkNotNullParameter(r100, "annotations");
        return r100;
    }

    /* JADX INFO: renamed from: get */
    public abstract TypeProjection mo10737get(KotlinType r100);

    public boolean isEmpty() {
        return false;
    }

    public KotlinType prepareTopLevelType(KotlinType r100, Variance r101) {
        Intrinsics.checkNotNullParameter(r100, "topLevelType");
        Intrinsics.checkNotNullParameter(r101, "position");
        return r100;
    }

    static {
        Companion = new Companion(null);
        EMPTY = new TypeSubstitution$Companion$EMPTY$1();
    }

    public final TypeSubstitution replaceWithNonApproximating() {
        return new AnonymousClass1(this);
    }

    public final TypeSubstitutor buildSubstitutor() {
        return TypeSubstitutor.create(this);
    }
}
