package io.ktor.utils.io;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.x;

/* JADX INFO: loaded from: classes41.dex */
public final class ExceptionUtilsJvmKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f492013a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReentrantReadWriteLock f492014b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> f492015c = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((Constructor) r101).getParameterTypes().length), Integer.valueOf(((Constructor) r100).getParameterTypes().length));
        }
    }

    static {
        f492013a = a(Throwable.class, -1);
        f492014b = new ReentrantReadWriteLock();
        f492015c = new WeakHashMap();
    }

    public static final int a(Class<?> r100, int r101) {
        JvmClassMappingKt.getKotlinClass(r100);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        int r103 = 0;
    L4:
        Field[] r104 = r100.getDeclaredFields();     // Catch: Throwable -> L14
        int r105 = r104.length;     // Catch: Throwable -> L14
        int r106 = 0;
        int r107 = 0;
    L5:
        if (r106 >= r105) goto L10;
        if ((!Modifier.isStatic(r104[r106].getModifiers())) == false) goto L9;
        r107 = r107 + 1;     // Catch: Throwable -> L14
    L9:
        r106 = r106 + 1;     // Catch: Throwable -> L14
        goto L5
    L10:
        r103 = r103 + r107;     // Catch: Throwable -> L14
        r100 = r100.getSuperclass();     // Catch: Throwable -> L14
        if (r100 != null) goto L4;
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(r103));     // Catch: Throwable -> L14
    L16:
        Integer r109 = Integer.valueOf(r101);
        if (Result.m9455isFailureimpl(r108) == false) goto L20;
        r108 = r109;
    L20:
        return ((Number) r108).intValue();
    L14:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public static final <E extends Throwable> E b(E r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        Intrinsics.checkNotNullParameter(r101, "cause");
        Object r102 = null;
        if ((r100 instanceof x) == true) goto L96;
        ReentrantReadWriteLock r103 = f492014b;
        ReentrantReadWriteLock.ReadLock r104 = r103.readLock();
        r104.lock();
        Function1<Throwable, Throwable> r105 = f492015c.get(r100.getClass());     // Catch: Throwable -> L89
        r104.unlock();
        if (r105 != null) goto L19;
        int r106 = 0;
        if (f492013a == a(r100.getClass(), 0)) goto L40;
        ReentrantReadWriteLock.ReadLock r107 = r103.readLock();
        if (r103.getWriteHoldCount() != 0) goto L25;
        int r108 = r103.getReadHoldCount();
    L26:
        int r109 = 0;
    L27:
        if (r109 >= r108) goto L29;
        r107.unlock();
        r109 = r109 + 1;
        goto L27
    L29:
        ReentrantReadWriteLock.WriteLock r110 = r103.writeLock();
        r110.lock();
        f492015c.put((Class<? extends Throwable>) r100.getClass(), ExceptionUtilsJvmKt$tryCopyException$4$1.INSTANCE);     // Catch: Throwable -> L35
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L35
    L31:
        if (r106 >= r108) goto L33;
        r107.lock();
        r106 = r106 + 1;
        goto L31
    L33:
        r110.unlock();
        return null;
    L35:
        th = move-exception;
    L36:
        if (r106 >= r108) goto L38;
        r107.lock();
        r106 = r106 + 1;
        goto L36
    L38:
        r110.unlock();
        throw th;
    L25:
        r108 = 0;
        goto L26
    L40:
        Iterator r112 = ArraysKt.sortedWith(r100.getClass().getConstructors(), new a()).iterator();
        Function1<Throwable, Throwable> r113 = null;
    L42:
        if (r112.hasNext() == false) goto L65;
        final Constructor r114 = (Constructor) r112.next();
        Class<?>[] r115 = r114.getParameterTypes();
        int r116 = r115.length;
        if (r116 != 0) goto L46;
        Function1<Throwable, Throwable> r117 = new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$4(r114);
    L63:
        r113 = r117;
    L64:
        if (r113 == null) goto L42;
    L46:
        if (r116 != 1) goto L48;
        Class<?> r118 = r115[0];
        if (Intrinsics.areEqual(r118, Throwable.class) == false) goto L59;
        r117 = new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$2(r114);
        goto L63
    L59:
        if (Intrinsics.areEqual(r118, String.class) == false) goto L61;
        r117 = new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$3(r114);
    L61:
        r113 = null;
        goto L64
    L48:
        if (r116 != 2) goto L61;
        if (Intrinsics.areEqual(r115[0], String.class) == false) goto L61;
        if (Intrinsics.areEqual(r115[1], Throwable.class) == false) goto L61;
        r117 = new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$1(r114);
    L65:
        ReentrantReadWriteLock r119 = f492014b;
        ReentrantReadWriteLock.ReadLock r120 = r119.readLock();
        if (r119.getWriteHoldCount() != 0) goto L68;
        int r121 = r119.getReadHoldCount();
    L69:
        int r122 = 0;
    L70:
        if (r122 >= r121) goto L72;
        r120.unlock();
        r122 = r122 + 1;
        goto L70
    L72:
        ReentrantReadWriteLock.WriteLock r123 = r119.writeLock();
        r123.lock();
        WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> r124 = f492015c;     // Catch: Throwable -> L84
        Class<?> r125 = r100.getClass();     // Catch: Throwable -> L84
        if (r113 != null) goto L76;
        Function1<Throwable, Throwable> r126 = ExceptionUtilsJvmKt$tryCopyException$5$1.INSTANCE;     // Catch: Throwable -> L84
    L77:
        r124.put((Class<? extends Throwable>) r125, r126);     // Catch: Throwable -> L84
        Unit r127 = Unit.INSTANCE;     // Catch: Throwable -> L84
    L78:
        if (r106 >= r121) goto L80;
        r120.lock();
        r106 = r106 + 1;
        goto L78
    L80:
        r123.unlock();
        if (r113 != null) goto L83;
        return null;
    L83:
        return (E) r113.invoke(r101);
    L76:
        r126 = r113;
    L84:
        th = move-exception;
    L85:
        if (r106 >= r121) goto L87;
        r120.lock();
        r106 = r106 + 1;
        goto L85
    L87:
        r123.unlock();
        throw th;
    L68:
        r121 = 0;
        goto L69
    L19:
        return (E) r105.invoke(r100);
    L89:
        th = move-exception;
        r104.unlock();
        throw th;
    L96:
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L6
        Object r129 = Result.m9449constructorimpl(((x) r100).createCopy());     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r129) == true) goto L13;
        r102 = r129;
    L13:
        return (E) r102;
    L6:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
