package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes5.dex */
public interface SupertypeLoopChecker {

    public static final class EMPTY implements SupertypeLoopChecker {
        public static final EMPTY INSTANCE = null;

        static {
            INSTANCE = new EMPTY();
        }

        private EMPTY() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker
        public Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor r100, Collection<? extends KotlinType> r101, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> r102, Function1<? super KotlinType, Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, "currentTypeConstructor");
            Intrinsics.checkNotNullParameter(r101, "superTypes");
            Intrinsics.checkNotNullParameter(r102, "neighbors");
            Intrinsics.checkNotNullParameter(r103, "reportLoop");
            return r101;
        }
    }

    Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor r100, Collection<? extends KotlinType> r101, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> r102, Function1<? super KotlinType, Unit> r103);
}
