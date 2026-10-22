package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Annotations EMPTY = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            EMPTY = new Annotations$Companion$EMPTY$1();
        }

        public final Annotations getEMPTY() {
            return EMPTY;
        }

        public final Annotations create(List<? extends AnnotationDescriptor> r100) {
            Intrinsics.checkNotNullParameter(r100, "annotations");
            if (r100.isEmpty() == false) goto L6;
            return EMPTY;
        L6:
            return new AnnotationsImpl(r100);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class DefaultImpls {
        public static AnnotationDescriptor findAnnotation(Annotations r100, FqName r101) {
            Intrinsics.checkNotNullParameter(r101, "fqName");
            Iterator<AnnotationDescriptor> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            AnnotationDescriptor r103 = r102.next();
            if (Intrinsics.areEqual(r103.getFqName(), r101) == false) goto L4;
        L10:
            return r103;
        L8:
            r103 = null;
            goto L10
        }

        public static boolean hasAnnotation(Annotations r100, FqName r101) {
            Intrinsics.checkNotNullParameter(r101, "fqName");
            if (r100.mo10727findAnnotation(r101) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    /* JADX INFO: renamed from: findAnnotation */
    AnnotationDescriptor mo10727findAnnotation(FqName r100);

    boolean hasAnnotation(FqName r100);

    boolean isEmpty();
}
