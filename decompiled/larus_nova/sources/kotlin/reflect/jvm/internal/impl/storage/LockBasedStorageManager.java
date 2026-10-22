package kotlin.reflect.jvm.internal.impl.storage;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.LynxError;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public class LockBasedStorageManager implements StorageManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final StorageManager NO_LOCKS = null;
    private static final String PACKAGE_NAME = null;
    private final String debugText;
    private final ExceptionHandlingStrategy exceptionHandlingStrategy;
    protected final SimpleLock lock;

    public static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            if (r100 == 3) goto L5;
            String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r100 == 3) goto L9;
            int r102 = 3;
        L10:
            Object[] r103 = new Object[r102];
            if (r100 == 1) goto L17;
            if (r100 == 2) goto L16;
            if (r100 == 3) goto L15;
            r103[0] = "storageManager";
        L19:
            if (r100 == 3) goto L21;
            r103[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
        L22:
            if (r100 == 2) goto L25;
            if (r100 == 3) goto L26;
            r103[2] = "<init>";
        L26:
            String r104 = String.format(r101, r103);
            if (r100 == 3) goto L30;
            throw new IllegalArgumentException(r104);
        L30:
            throw new IllegalStateException(r104);
        L25:
            r103[2] = "computeIfAbsent";
            goto L26
        L21:
            r103[1] = "computeIfAbsent";
            goto L22
        L15:
            r103[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            goto L19
        L16:
            r103[0] = "computation";
            goto L19
        L17:
            r103[0] = "map";
            goto L19
        L9:
            r102 = 2;
            goto L10
        L5:
            r101 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        static {
        }

        private CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager r100, ConcurrentMap<KeyWithComputation<K, V>, Object> r101) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r101 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r100, r101, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction, kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        public V computeIfAbsent(K r100, Function0<? extends V> r101) {
            if (r101 != null) goto L4;
            $$$reportNull$$$0(2);
        L4:
            V r102 = (V) super.computeIfAbsent(r100, r101);
            if (r102 != null) goto L7;
            $$$reportNull$$$0(3);
        L7:
            return r102;
        }

        public /* synthetic */ CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager r100, ConcurrentMap r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> implements CacheWithNullableValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            Object[] r101 = new Object[3];
            if (r100 == 1) goto L7;
            if (r100 == 2) goto L6;
            r101[0] = "storageManager";
        L8:
            r101[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (r100 == 2) goto L11;
            r101[2] = "<init>";
        L13:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
        L11:
            r101[2] = "computeIfAbsent";
            goto L13
        L6:
            r101[0] = "computation";
            goto L8
        L7:
            r101[0] = "map";
            goto L8
        }

        private CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager r100, ConcurrentMap<KeyWithComputation<K, V>, Object> r101) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r101 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r100, r101, new AnonymousClass1());
        }

        public V computeIfAbsent(K r100, Function0<? extends V> r101) {
            if (r101 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return invoke(new KeyWithComputation(r100, r101));
        }

        public /* synthetic */ CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager r100, ConcurrentMap r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = null;

        RuntimeException handleException(Throwable r100);

        static {
            THROW = new AnonymousClass1();
        }
    }

    public static class KeyWithComputation<K, V> {
        private final Function0<? extends V> computation;
        private final K key;

        public int hashCode() {
            return this.key.hashCode();
        }

        public static /* synthetic */ Function0 access$400(KeyWithComputation r100) {
            return r100.computation;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L14:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L14;
            if (this.key.equals(((KeyWithComputation) r100).key) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public KeyWithComputation(K r100, Function0<? extends V> r101) {
            this.key = r100;
            this.computation = r101;
        }
    }

    public static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        private final Function0<? extends T> computable;
        private final LockBasedStorageManager storageManager;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            if (r100 == 2) goto L6;
            if (r100 == 3) goto L6;
            String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r100 == 2) goto L10;
            if (r100 == 3) goto L10;
            int r102 = 3;
        L11:
            Object[] r103 = new Object[r102];
            if (r100 == 1) goto L17;
            if (r100 == 2) goto L16;
            if (r100 == 3) goto L16;
            r103[0] = "storageManager";
        L18:
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L21;
            r103[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        L23:
            if (r100 == 2) goto L26;
            if (r100 == 3) goto L26;
            r103[2] = "<init>";
        L26:
            String r104 = String.format(r101, r103);
            if (r100 == 2) goto L31;
            if (r100 == 3) goto L31;
            throw new IllegalArgumentException(r104);
        L31:
            throw new IllegalStateException(r104);
        L21:
            r103[1] = "renderDebugInformation";
            goto L23
        L22:
            r103[1] = "recursionDetected";
        L16:
            r103[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            goto L18
        L17:
            r103[0] = "computable";
        L10:
            r102 = 2;
        L6:
            r101 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        public void postCompute(T r100) {
        }

        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            Object r100 = this.value;
            if ((r100 instanceof NotValue) == false) goto L5;
            this.storageManager.lock.lock();
            Object r101 = this.value;     // Catch: Throwable -> L35
            if ((r101 instanceof NotValue) == true) goto L12;
            T r102 = (T) WrappedValues.unescapeThrowable(r101);
        L10:
            this.storageManager.lock.unlock();
            return r102;
        L12:
            NotValue r103 = NotValue.COMPUTING;     // Catch: Throwable -> L35
            if (r101 != r103) goto L18;
            this.value = NotValue.RECURSION_WAS_DETECTED;     // Catch: Throwable -> L35
            RecursionDetectedResult<T> r104 = recursionDetected(true);     // Catch: Throwable -> L35
            if (r104.isFallThrough() == true) goto L18;
            r102 = r104.getValue();     // Catch: Throwable -> L35
        L18:
            if (r101 != NotValue.RECURSION_WAS_DETECTED) goto L22;
            RecursionDetectedResult<T> r105 = recursionDetected(false);     // Catch: Throwable -> L35
            if (r105.isFallThrough() == true) goto L22;
            r102 = r105.getValue();     // Catch: Throwable -> L35
        L22:
            this.value = r103;     // Catch: Throwable -> L35
            r102 = this.computable.invoke();     // Catch: Throwable -> L25
            postCompute(r102);     // Catch: Throwable -> L25
            this.value = r102;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            if (ExceptionUtilsKt.isProcessCanceledException(th) == false) goto L29;
            this.value = NotValue.NOT_COMPUTED;     // Catch: Throwable -> L35
            throw th;     // Catch: Throwable -> L35
        L29:
            if (this.value != NotValue.COMPUTING) goto L32;
            this.value = WrappedValues.escapeThrowable(th);     // Catch: Throwable -> L35
        L32:
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(th);     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            this.storageManager.lock.unlock();
            throw th;
        L5:
            return (T) WrappedValues.unescapeThrowable(r100);
        }

        public boolean isComputed() {
            if (this.value != NotValue.NOT_COMPUTED) goto L5;
        L7:
            return false;
        L5:
            if (this.value == NotValue.COMPUTING) goto L7;
            return true;
        }

        public RecursionDetectedResult<T> recursionDetected(boolean r100) {
            RecursionDetectedResult<T> r101 = this.storageManager.recursionDetectedDefault("in a lazy value", null);
            if (r101 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r101;
        }

        public LockBasedLazyValue(LockBasedStorageManager r100, Function0<? extends T> r101) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r101 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = r100;
            this.computable = r101;
        }
    }

    public static abstract class LockBasedLazyValueWithPostCompute<T> extends LockBasedLazyValue<T> {
        private volatile SingleThreadValue<T> valuePostCompute;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            Object[] r101 = new Object[3];
            if (r100 == 1) goto L5;
            r101[0] = "storageManager";
        L6:
            r101[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            r101[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
        L5:
            r101[0] = "computable";
            goto L6
        }

        public abstract void doPostCompute(T r100);

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            SingleThreadValue<T> r100 = this.valuePostCompute;
            if (r100 == null) goto L9;
            if (r100.hasValue() == false) goto L9;
            return r100.getValue();
        L9:
            return (T) super.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        public final void postCompute(T r100) {
            this.valuePostCompute = new SingleThreadValue(r100);
            doPostCompute(r100);     // Catch: Throwable -> L6
            this.valuePostCompute = null;
            return;
        L6:
            th = move-exception;
            this.valuePostCompute = null;
            throw th;
        }

        public LockBasedLazyValueWithPostCompute(LockBasedStorageManager r100, Function0<? extends T> r101) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r101 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r100, r101);
            this.valuePostCompute = null;
        }
    }

    public static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            if (r100 == 2) goto L5;
            String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            if (r100 == 2) goto L8;
            int r102 = 3;
        L9:
            Object[] r103 = new Object[r102];
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L13;
            r103[0] = "storageManager";
        L15:
            if (r100 == 2) goto L17;
            r103[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
        L18:
            if (r100 == 2) goto L20;
            r103[2] = "<init>";
        L20:
            String r104 = String.format(r101, r103);
            if (r100 == 2) goto L24;
            throw new IllegalArgumentException(r104);
        L24:
            throw new IllegalStateException(r104);
        L17:
            r103[1] = AbsMethodDelegate.TAG_INVOKE;
            goto L18
        L13:
            r103[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            goto L15
        L14:
            r103[0] = "computable";
            goto L15
        L8:
            r102 = 2;
            goto L9
        L5:
            r101 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T r100 = (T) super.invoke();
            if (r100 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r100;
        }

        static {
        }

        public LockBasedNotNullLazyValue(LockBasedStorageManager r100, Function0<? extends T> r101) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r101 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r100, r101);
        }
    }

    public static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends LockBasedLazyValueWithPostCompute<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            if (r100 == 2) goto L5;
            String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            if (r100 == 2) goto L8;
            int r102 = 3;
        L9:
            Object[] r103 = new Object[r102];
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L13;
            r103[0] = "storageManager";
        L15:
            if (r100 == 2) goto L17;
            r103[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        L18:
            if (r100 == 2) goto L20;
            r103[2] = "<init>";
        L20:
            String r104 = String.format(r101, r103);
            if (r100 == 2) goto L24;
            throw new IllegalArgumentException(r104);
        L24:
            throw new IllegalStateException(r104);
        L17:
            r103[1] = AbsMethodDelegate.TAG_INVOKE;
            goto L18
        L13:
            r103[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            goto L15
        L14:
            r103[0] = "computable";
            goto L15
        L8:
            r102 = 2;
            goto L9
        L5:
            r101 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T r100 = (T) super.invoke();
            if (r100 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r100;
        }

        static {
        }

        public LockBasedNotNullLazyValueWithPostCompute(LockBasedStorageManager r100, Function0<? extends T> r101) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r101 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r100, r101);
        }
    }

    public static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final ConcurrentMap<K, Object> cache;
        private final Function1<? super K, ? extends V> compute;
        private final LockBasedStorageManager storageManager;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            if (r100 == 3) goto L6;
            if (r100 == 4) goto L6;
            String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L8:
            if (r100 == 3) goto L11;
            if (r100 == 4) goto L11;
            int r102 = 3;
        L12:
            Object[] r103 = new Object[r102];
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L19;
            if (r100 == 3) goto L18;
            if (r100 == 4) goto L18;
            r103[0] = "storageManager";
        L21:
            if (r100 == 3) goto L25;
            if (r100 == 4) goto L24;
            r103[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        L26:
            if (r100 == 3) goto L29;
            if (r100 == 4) goto L29;
            r103[2] = "<init>";
        L29:
            String r104 = String.format(r101, r103);
            if (r100 == 3) goto L34;
            if (r100 == 4) goto L34;
            throw new IllegalArgumentException(r104);
        L34:
            throw new IllegalStateException(r104);
        L24:
            r103[1] = "raceCondition";
            goto L26
        L25:
            r103[1] = "recursionDetected";
        L18:
            r103[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            goto L21
        L19:
            r103[0] = "compute";
            goto L21
        L20:
            r103[0] = "map";
        L11:
            r102 = 2;
        L6:
            r101 = "@NotNull method %s.%s must not return null";
            goto L8
        }

        public LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(K r100) {
            Object r101 = this.cache.get(r100);
            if (r101 != null) goto L5;
        L8:
            this.storageManager.lock.lock();
            Object r102 = this.cache.get(r100);     // Catch: Throwable -> L57
            NotValue r103 = NotValue.COMPUTING;     // Catch: Throwable -> L57
            if (r102 != r103) goto L17;
            r102 = NotValue.RECURSION_WAS_DETECTED;     // Catch: Throwable -> L57
            RecursionDetectedResult<V> r104 = recursionDetected(r100, true);     // Catch: Throwable -> L57
            if (r104.isFallThrough() == true) goto L17;
            V r105 = r104.getValue();     // Catch: Throwable -> L57
        L14:
            this.storageManager.lock.unlock();
            return r105;
        L17:
            if (r102 != NotValue.RECURSION_WAS_DETECTED) goto L21;
            RecursionDetectedResult<V> r106 = recursionDetected(r100, false);     // Catch: Throwable -> L57
            if (r106.isFallThrough() == true) goto L21;
            r105 = r106.getValue();     // Catch: Throwable -> L57
        L21:
            if (r102 == null) goto L24;
            r105 = (V) WrappedValues.unescapeExceptionOrNull(r102);
            goto L14
        L24:
            AssertionError r107 = null;
            this.cache.put(r100, r103);     // Catch: Throwable -> L31
            V r108 = this.compute.invoke(r100);     // Catch: Throwable -> L31
            Object r109 = this.cache.put(r100, WrappedValues.escapeNull(r108));     // Catch: Throwable -> L31
            if (r109 != r103) goto L29;
            this.storageManager.lock.unlock();
            return r108;
        L29:
            r107 = raceCondition(r100, r109);     // Catch: Throwable -> L31
            throw r107;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            if (ExceptionUtilsKt.isProcessCanceledException(th) == true) goto L61;
            if (th == r107) goto L63;
            Object r110 = this.cache.put(r100, WrappedValues.escapeThrowable(th));     // Catch: Throwable -> L57
            if (r110 == NotValue.COMPUTING) goto L50;
            throw raceCondition(r100, r110);     // Catch: Throwable -> L57
        L50:
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(th);     // Catch: Throwable -> L57
        L63:
            this.cache.remove(r100);     // Catch: Throwable -> L54
        L53:
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(th);     // Catch: Throwable -> L57
        L54:
            th = move-exception;
            throw unableToRemoveKey(r100, th);     // Catch: Throwable -> L57
        L61:
            Object r111 = this.cache.remove(r100);     // Catch: Throwable -> L41
        L36:
            if (r111 == NotValue.COMPUTING) goto L40;
            throw inconsistentComputingKey(r100, r111);     // Catch: Throwable -> L57
        L40:
            throw th;     // Catch: Throwable -> L57
        L41:
            th = move-exception;
            throw unableToRemoveKey(r100, th);     // Catch: Throwable -> L57
        L57:
            th = move-exception;
            this.storageManager.lock.unlock();
            throw th;
        L5:
            if (r101 == NotValue.COMPUTING) goto L8;
            return (V) WrappedValues.unescapeExceptionOrNull(r101);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable
        public boolean isComputed(K r100) {
            Object r101 = this.cache.get(r100);
            if (r101 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101 == NotValue.COMPUTING) goto L7;
            return true;
        }

        private AssertionError inconsistentComputingKey(K r100, Object r101) {
            return (AssertionError) LockBasedStorageManager.access$200(new AssertionError("Inconsistent key detected. " + NotValue.COMPUTING + " is expected, was: " + r101 + ", most probably race condition detected on input " + r100 + " under " + this.storageManager));
        }

        private AssertionError raceCondition(K r100, Object r101) {
            AssertionError r102 = (AssertionError) LockBasedStorageManager.access$200(new AssertionError("Race condition detected on input " + r100 + ". Old value is " + r101 + " under " + this.storageManager));
            if (r102 != null) goto L5;
            $$$reportNull$$$0(4);
        L5:
            return r102;
        }

        private AssertionError unableToRemoveKey(K r100, Throwable r101) {
            return (AssertionError) LockBasedStorageManager.access$200(new AssertionError("Unable to remove " + r100 + " under " + this.storageManager, r101));
        }

        public RecursionDetectedResult<V> recursionDetected(K r100, boolean r101) {
            RecursionDetectedResult<V> r102 = this.storageManager.recursionDetectedDefault("", r100);
            if (r102 != null) goto L5;
            $$$reportNull$$$0(3);
        L5:
            return r102;
        }

        public MapBasedMemoizedFunction(LockBasedStorageManager r100, ConcurrentMap<K, Object> r101, Function1<? super K, ? extends V> r102) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r101 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r102 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            this.storageManager = r100;
            this.cache = r101;
            this.compute = r102;
        }
    }

    public static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            if (r100 == 3) goto L5;
            String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r100 == 3) goto L9;
            int r102 = 3;
        L10:
            Object[] r103 = new Object[r102];
            if (r100 == 1) goto L17;
            if (r100 == 2) goto L16;
            if (r100 == 3) goto L15;
            r103[0] = "storageManager";
        L18:
            if (r100 == 3) goto L20;
            r103[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
        L21:
            if (r100 == 3) goto L23;
            r103[2] = "<init>";
        L23:
            String r104 = String.format(r101, r103);
            if (r100 == 3) goto L27;
            throw new IllegalArgumentException(r104);
        L27:
            throw new IllegalStateException(r104);
        L20:
            r103[1] = AbsMethodDelegate.TAG_INVOKE;
            goto L21
        L15:
            r103[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            goto L18
        L16:
            r103[0] = "compute";
            goto L18
        L17:
            r103[0] = "map";
            goto L18
        L9:
            r102 = 2;
            goto L10
        L5:
            r101 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        static {
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction, kotlin.jvm.functions.Function1
        public V invoke(K r100) {
            V r101 = (V) super.invoke(r100);
            if (r101 != null) goto L5;
            $$$reportNull$$$0(3);
        L5:
            return r101;
        }

        public MapBasedMemoizedFunctionToNotNull(LockBasedStorageManager r100, ConcurrentMap<K, Object> r101, Function1<? super K, ? extends V> r102) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r101 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r102 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            super(r100, r101, r102);
        }
    }

    public static final enum NotValue extends Enum<NotValue> {
        private static final /* synthetic */ NotValue[] $VALUES = null;
        public static final NotValue COMPUTING = null;
        public static final NotValue NOT_COMPUTED = null;
        public static final NotValue RECURSION_WAS_DETECTED = null;

        static {
            NotValue r100 = new NotValue("NOT_COMPUTED", 0);
            NOT_COMPUTED = r100;
            NotValue r101 = new NotValue("COMPUTING", 1);
            COMPUTING = r101;
            NotValue r102 = new NotValue("RECURSION_WAS_DETECTED", 2);
            RECURSION_WAS_DETECTED = r102;
            $VALUES = new NotValue[]{r100, r101, r102};
        }

        public static NotValue[] values() {
            return (NotValue[]) $VALUES.clone();
        }

        public static NotValue valueOf(String r100) {
            return (NotValue) a.a(NotValue.class, r100);
        }

        private NotValue(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static class RecursionDetectedResult<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean fallThrough;
        private final T value;

        public static <T> RecursionDetectedResult<T> fallThrough() {
            return new RecursionDetectedResult(null, true);
        }

        public String toString() {
            if (isFallThrough() == false) goto L6;
            return "FALL_THROUGH";
        L6:
            return String.valueOf(this.value);
        }

        static {
        }

        public T getValue() {
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public static <T> RecursionDetectedResult<T> value(T r100) {
            return new RecursionDetectedResult(r100, false);
        }

        private RecursionDetectedResult(T r100, boolean r101) {
            this.value = r100;
            this.fallThrough = r101;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r110) {
        if (r110 == 10) goto L8;
        if (r110 == 13) goto L8;
        if (r110 == 20) goto L8;
        if (r110 == 37) goto L8;
        String r100 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r110 == 10) goto L15;
        if (r110 == 13) goto L15;
        if (r110 == 20) goto L15;
        if (r110 == 37) goto L15;
        int r101 = 3;
    L16:
        Object[] r102 = new Object[r101];
        if (r110 == 1) goto L34;
        if (r110 == 3) goto L34;
        if (r110 == 5) goto L34;
        if (r110 == 6) goto L33;
        switch(r110) {
            case 8: goto L34;
            case 9: goto L32;
            case 10: goto L31;
            case 11: goto L32;
            case 12: goto L30;
            case 13: goto L31;
            case 14: goto L32;
            case 15: goto L29;
            case 16: goto L32;
            case 17: goto L30;
            case 18: goto L29;
            case 19: goto L32;
            case 20: goto L31;
            case 21: goto L32;
            case 22: goto L29;
            case 23: goto L28;
            case 24: goto L28;
            case 25: goto L30;
            case 26: goto L28;
            case 27: goto L30;
            case 28: goto L28;
            case 29: goto L27;
            case 30: goto L28;
            case 31: goto L28;
            case 32: goto L28;
            case 33: goto L27;
            case 34: goto L28;
            case 35: goto L26;
            case 36: goto L25;
            case 37: goto L31;
            default: goto L24;
        };
    L24:
        r102[0] = "debugText";
    L36:
        if (r110 == 10) goto L43;
        if (r110 == 13) goto L43;
        if (r110 == 20) goto L42;
        if (r110 == 37) goto L41;
        r102[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
    L44:
        switch(r110) {
            case 4: goto L58;
            case 5: goto L58;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L57;
            case 9: goto L56;
            case 10: goto L59;
            case 11: goto L56;
            case 12: goto L56;
            case 13: goto L59;
            case 14: goto L56;
            case 15: goto L56;
            case 16: goto L56;
            case 17: goto L56;
            case 18: goto L56;
            case 19: goto L55;
            case 20: goto L59;
            case 21: goto L55;
            case 22: goto L55;
            case 23: goto L54;
            case 24: goto L54;
            case 25: goto L54;
            case 26: goto L53;
            case 27: goto L53;
            case 28: goto L52;
            case 29: goto L52;
            case 30: goto L51;
            case 31: goto L50;
            case 32: goto L49;
            case 33: goto L49;
            case 34: goto L48;
            case 35: goto L47;
            case 36: goto L46;
            case 37: goto L59;
            default: goto L45;
        };
    L45:
        r102[2] = "createWithExceptionHandling";
        goto L59
    L46:
        r102[2] = "sanitizeStackTrace";
        goto L59
    L47:
        r102[2] = "recursionDetectedDefault";
        goto L59
    L48:
        r102[2] = "compute";
        goto L59
    L49:
        r102[2] = "createNullableLazyValueWithPostCompute";
        goto L59
    L50:
        r102[2] = "createRecursionTolerantNullableLazyValue";
        goto L59
    L51:
        r102[2] = "createNullableLazyValue";
        goto L59
    L52:
        r102[2] = "createLazyValueWithPostCompute";
        goto L59
    L53:
        r102[2] = "createRecursionTolerantLazyValue";
        goto L59
    L54:
        r102[2] = "createLazyValue";
        goto L59
    L55:
        r102[2] = "createMemoizedFunctionWithNullableValues";
        goto L59
    L56:
        r102[2] = "createMemoizedFunction";
        goto L59
    L57:
        r102[2] = "replaceExceptionHandling";
        goto L59
    L58:
        r102[2] = "<init>";
    L59:
        String r103 = String.format(r100, r102);
        if (r110 == 10) goto L66;
        if (r110 == 13) goto L66;
        if (r110 == 20) goto L66;
        if (r110 == 37) goto L66;
        throw new IllegalArgumentException(r103);
    L66:
        throw new IllegalStateException(r103);
    L41:
        r102[1] = "sanitizeStackTrace";
        goto L44
    L42:
        r102[1] = "createMemoizedFunctionWithNullableValues";
    L43:
        r102[1] = "createMemoizedFunction";
        goto L44
    L25:
        r102[0] = LynxError.LYNX_THROWABLE;
        goto L36
    L26:
        r102[0] = "source";
        goto L36
    L27:
        r102[0] = "postCompute";
        goto L36
    L28:
        r102[0] = "computable";
        goto L36
    L29:
        r102[0] = "map";
        goto L36
    L30:
        r102[0] = "onRecursiveCall";
        goto L36
    L31:
        r102[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        goto L36
    L32:
        r102[0] = "compute";
        goto L36
    L33:
        r102[0] = "lock";
    L34:
        r102[0] = "exceptionHandlingStrategy";
    L15:
        r101 = 2;
    L8:
        r100 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    static {
        PACKAGE_NAME = StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");
        final ExceptionHandlingStrategy r100 = ExceptionHandlingStrategy.THROW;
        final EmptySimpleLock r101 = EmptySimpleLock.INSTANCE;
        final String r102 = "NO_LOCKS";
        NO_LOCKS = new AnonymousClass1(r102, r100, r101);
    }

    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(this, createConcurrentHashMap(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new CacheWithNullableValuesBasedOnMemoizedFunction(this, createConcurrentHashMap(), null);
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.debugText + ")";
    }

    public LockBasedStorageManager(String r100) {
        this(r100, null, null);
    }

    public static /* synthetic */ ExceptionHandlingStrategy access$100(LockBasedStorageManager r100) {
        return r100.exceptionHandlingStrategy;
    }

    public static /* synthetic */ Throwable access$200(Throwable r100) {
        return sanitizeStackTrace(r100);
    }

    private static <T extends Throwable> T sanitizeStackTrace(T r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(36);
    L4:
        StackTraceElement[] r101 = r100.getStackTrace();
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        if (r101[r103].getClassName().startsWith(PACKAGE_NAME) == false) goto L11;
        r103 = r103 + 1;
    L11:
        List r104 = Arrays.asList(r101).subList(r103, r102);
        r100.setStackTrace((StackTraceElement[]) r104.toArray(new StackTraceElement[r104.size()]));
        return r100;
    L10:
        r103 = -1;
        goto L11
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(Function0<? extends T> r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(34);
    L4:
        this.lock.lock();
        T r101 = r100.invoke();     // Catch: Throwable -> L8
        this.lock.unlock();
        return r101;
    L8:
        th = move-exception;
    L11:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L10:
        throw this.exceptionHandlingStrategy.handleException(th);     // Catch: Throwable -> L11
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValue(Function0<? extends T> r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        return new LockBasedNotNullLazyValue(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        MemoizedFunctionToNotNull<K, V> r101 = createMemoizedFunction(r100, createConcurrentHashMap());
        if (r101 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        return r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        MemoizedFunctionToNullable<K, V> r101 = createMemoizedFunctionWithNullableValues(r100, createConcurrentHashMap());
        if (r101 != null) goto L7;
        $$$reportNull$$$0(20);
    L7:
        return r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NullableLazyValue<T> createNullableLazyValue(Function0<? extends T> r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(30);
    L5:
        return new LockBasedLazyValue(this, r100);
    }

    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> r100, ConcurrentMap<K, Object> r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(15);
    L7:
        return new MapBasedMemoizedFunctionToNotNull(this, r101, r100);
    }

    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> r100, ConcurrentMap<K, Object> r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(21);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(22);
    L7:
        return new MapBasedMemoizedFunction(this, r101, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(final Function0<? extends T> r100, final T r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(27);
    L7:
        return new AnonymousClass4(this, this, r100, r101);
    }

    public <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String r100, K r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(35);
    L4:
        StringBuilder r102 = new StringBuilder("Recursion detected ");
        r102.append(r100);
        if (r101 != null) goto L7;
        String r103 = "";
    L8:
        r102.append(r103);
        r102.append(" under ");
        r102.append(this);
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(r102.toString())));
    L7:
        r103 = "on input: " + r101;
        goto L8
    }

    private LockBasedStorageManager(String r100, ExceptionHandlingStrategy r101, SimpleLock r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(6);
    L8:
        this.lock = r102;
        this.exceptionHandlingStrategy = r101;
        this.debugText = r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(final Function0<? extends T> r100, final Function1<? super Boolean, ? extends T> r101, final Function1<? super T, Unit> r110) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(28);
    L4:
        if (r110 != null) goto L7;
        $$$reportNull$$$0(29);
    L7:
        return new AnonymousClass5(this, this, r100, r101, r110);
    }

    public LockBasedStorageManager(String r100, Runnable r101, Function1<InterruptedException, Unit> r102) {
        this(r100, ExceptionHandlingStrategy.THROW, SimpleLock.Companion.simpleLock(r101, r102));
    }

    public /* synthetic */ LockBasedStorageManager(String r100, ExceptionHandlingStrategy r101, SimpleLock r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }
}
