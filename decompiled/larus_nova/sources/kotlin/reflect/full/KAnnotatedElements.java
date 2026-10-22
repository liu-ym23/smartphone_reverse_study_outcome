package kotlin.reflect.full;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0007¨\u0006\u000b"}, d2 = {"findAnnotation", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/KAnnotatedElement;", "(Lkotlin/reflect/KAnnotatedElement;)Ljava/lang/annotation/Annotation;", "hasAnnotation", "", "findAnnotations", "", "klass", "Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KAnnotatedElements {
    public static final /* synthetic */ <T extends Annotation> T findAnnotation(KAnnotatedElement r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<T> r101 = r100.getAnnotations().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((((Annotation) r102) instanceof Annotation) == false) goto L4;
    L9:
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (T) r102;
    L8:
        r102 = null;
        goto L9
    }

    public static final /* synthetic */ <T extends Annotation> List<T> findAnnotations(KAnnotatedElement r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return findAnnotations(r100, Reflection.getOrCreateKotlinClass(Annotation.class));
    }

    public static final /* synthetic */ <T extends Annotation> boolean hasAnnotation(KAnnotatedElement r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<T> r101 = r100.getAnnotations().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((((Annotation) r102) instanceof Annotation) == false) goto L4;
    L9:
        Intrinsics.reifiedOperationMarker(1, "T?");
        if (((Annotation) r102) != null) goto L17;
        return false;
    L17:
        return true;
    L8:
        r102 = null;
        goto L9
    }

    public static final <T extends Annotation> List<T> findAnnotations(KAnnotatedElement r100, KClass<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "klass");
        List<T> r102 = CollectionsKt.filterIsInstance(r100.getAnnotations(), JvmClassMappingKt.getJavaClass(r101));
        if ((!r102.isEmpty()) == false) goto L5;
        return r102;
    L5:
        Class<? extends Annotation> r103 = Java8RepeatableContainerLoader.INSTANCE.loadRepeatableContainer(JvmClassMappingKt.getJavaClass(r101));
        if (r103 == null) goto L19;
        Iterator<T> r104 = r100.getAnnotations().iterator();
    L9:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) r105)), r103) == false) goto L9;
    L14:
        Annotation r106 = (Annotation) r105;
        if (r106 == null) goto L19;
        Object r107 = r106.getClass().getMethod("value", new Class[0]).invoke(r106, new Object[0]);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.full.KAnnotatedElements.findAnnotations>");
        return ArraysKt.asList((Annotation[]) r107);
    L13:
        r105 = null;
    L19:
        return CollectionsKt.emptyList();
    }
}
