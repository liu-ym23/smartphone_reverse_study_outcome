package io.reactivex.internal.functions;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public final class Functions {
    static final Predicate<Object> ALWAYS_FALSE = null;
    static final Predicate<Object> ALWAYS_TRUE = null;
    public static final Action EMPTY_ACTION = null;
    static final Consumer<Object> EMPTY_CONSUMER = null;
    public static final ttc.d EMPTY_LONG_CONSUMER = null;
    public static final Runnable EMPTY_RUNNABLE = null;
    public static final Consumer<Throwable> ERROR_CONSUMER = null;
    static final Function<Object, Object> IDENTITY = null;
    static final Comparator<Object> NATURAL_COMPARATOR = null;
    static final Callable<Object> NULL_SUPPLIER = null;
    public static final Consumer<Throwable> ON_ERROR_MISSING = null;
    public static final Consumer<wwc.c> REQUEST_MAX = null;

    public static final enum HashSetCallable extends Enum<HashSetCallable> implements Callable<Set<Object>> {
        public static final HashSetCallable INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HashSetCallable[] f492836a = null;

        static {
            HashSetCallable r100 = new HashSetCallable();
            INSTANCE = r100;
            f492836a = new HashSetCallable[]{r100};
        }

        public HashSetCallable() {
            super("INSTANCE", 0);
        }

        public static HashSetCallable[] values() {
            return (HashSetCallable[]) f492836a.clone();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Set<Object> call2() throws Exception {
            return new HashSet();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Set<Object> call() throws Exception {
            return call2();
        }

        public static HashSetCallable valueOf(String r100) {
            return (HashSetCallable) r27.a.a(HashSetCallable.class, r100);
        }
    }

    public static final enum NaturalComparator extends Enum<NaturalComparator> implements Comparator<Object> {
        public static final NaturalComparator INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NaturalComparator[] f492837a = null;

        static {
            NaturalComparator r100 = new NaturalComparator();
            INSTANCE = r100;
            f492837a = new NaturalComparator[]{r100};
        }

        public NaturalComparator() {
            super("INSTANCE", 0);
        }

        public static NaturalComparator[] values() {
            return (NaturalComparator[]) f492837a.clone();
        }

        public static NaturalComparator valueOf(String r100) {
            return (NaturalComparator) r27.a.a(NaturalComparator.class, r100);
        }

        @Override // java.util.Comparator
        public int compare(Object r100, Object r101) {
            return ((Comparable) r100).compareTo(r101);
        }
    }

    public static final class a<T> implements Consumer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Action f492838a;

        public a(Action r100) {
            this.f492838a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T r100) throws Exception {
            this.f492838a.run();
        }
    }

    public static final class a0 implements Comparator<Object> {
        public a0() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((Comparable) r100).compareTo(r101);
        }
    }

    public static final class b<T1, T2, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BiFunction<? super T1, ? super T2, ? extends R> f492839a;

        public b(BiFunction<? super T1, ? super T2, ? extends R> r100) {
            this.f492839a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object[] r100) throws Exception {
            Object[] r101 = r100;
            if (r101.length != 2) goto L7;
            return this.f492839a.apply(r101[0], r101[1]);
        L7:
            throw new IllegalArgumentException("Array of size 2 expected but got " + r101.length);
        }
    }

    public static final class b0<T> implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Consumer<? super io.reactivex.o<T>> f492840a;

        @Override // io.reactivex.functions.Action
        public final void run() throws Exception {
            this.f492840a.accept(io.reactivex.o.f495051b);
        }

        public b0(Consumer<? super io.reactivex.o<T>> r100) {
            this.f492840a = r100;
        }
    }

    public static final class c<T1, T2, T3, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function3<T1, T2, T3, R> f492841a;

        public c(Function3<T1, T2, T3, R> r100) {
            this.f492841a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object[] r100) throws Exception {
            Object[] r101 = r100;
            if (r101.length != 3) goto L7;
            return this.f492841a.apply((T1) r101[0], (T2) r101[1], (T3) r101[2]);
        L7:
            throw new IllegalArgumentException("Array of size 3 expected but got " + r101.length);
        }
    }

    public static final class c0<T> implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Consumer<? super io.reactivex.o<T>> f492842a;

        public c0(Consumer<? super io.reactivex.o<T>> r100) {
            this.f492842a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            this.f492842a.accept(io.reactivex.o.a(r100));
        }
    }

    public static final class d<T1, T2, T3, T4, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function4<T1, T2, T3, T4, R> f492843a;

        public d(Function4<T1, T2, T3, T4, R> r100) {
            this.f492843a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object[] r100) throws Exception {
            Object[] r101 = r100;
            if (r101.length != 4) goto L7;
            return this.f492843a.apply((T1) r101[0], (T2) r101[1], (T3) r101[2], (T4) r101[3]);
        L7:
            throw new IllegalArgumentException("Array of size 4 expected but got " + r101.length);
        }
    }

    public static final class d0<T> implements Consumer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Consumer<? super io.reactivex.o<T>> f492844a;

        public d0(Consumer<? super io.reactivex.o<T>> r100) {
            this.f492844a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T r100) throws Exception {
            Consumer<? super io.reactivex.o<T>> r101 = this.f492844a;
            io.reactivex.o<Object> r102 = io.reactivex.o.f495051b;
            ObjectHelper.requireNonNull(r100, "value is null");
            r101.accept(new io.reactivex.o(r100));
        }
    }

    public static final class e<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function5<T1, T2, T3, T4, T5, R> f492845a;

        public e(Function5<T1, T2, T3, T4, T5, R> r100) {
            this.f492845a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object[] r100) throws Exception {
            Object[] r101 = r100;
            if (r101.length != 5) goto L7;
            return this.f492845a.apply((T1) r101[0], (T2) r101[1], (T3) r101[2], (T4) r101[3], (T5) r101[4]);
        L7:
            throw new IllegalArgumentException("Array of size 5 expected but got " + r101.length);
        }
    }

    public static final class e0 implements Callable<Object> {
        public e0() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    public static final class f<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function6<T1, T2, T3, T4, T5, T6, R> f492846a;

        public f(Function6<T1, T2, T3, T4, T5, T6, R> r100) {
            this.f492846a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object[] r110) throws Exception {
            Object[] r111 = r110;
            if (r111.length != 6) goto L7;
            return this.f492846a.apply((T1) r111[0], (T2) r111[1], (T3) r111[2], (T4) r111[3], (T5) r111[4], (T6) r111[5]);
        L7:
            throw new IllegalArgumentException("Array of size 6 expected but got " + r111.length);
        }
    }

    public static final class f0 implements Consumer<Throwable> {
        public f0() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(r100));
        }
    }

    public static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function7<T1, T2, T3, T4, T5, T6, T7, R> f492847a;

        public g(Function7<T1, T2, T3, T4, T5, T6, T7, R> r100) {
            this.f492847a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object[] r110) throws Exception {
            Object[] r111 = r110;
            if (r111.length != 7) goto L7;
            return this.f492847a.apply((T1) r111[0], (T2) r111[1], (T3) r111[2], (T4) r111[3], (T5) r111[4], (T6) r111[5], (T7) r111[6]);
        L7:
            throw new IllegalArgumentException("Array of size 7 expected but got " + r111.length);
        }
    }

    public static final class g0<T> implements Function<T, io.reactivex.schedulers.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TimeUnit f492848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Scheduler f492849b;

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) throws Exception {
            return new io.reactivex.schedulers.a(r100, this.f492849b.now(this.f492848a), this.f492848a);
        }

        public g0(TimeUnit r100, Scheduler r101) {
            this.f492848a = r100;
            this.f492849b = r101;
        }
    }

    public static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f492850a;

        public h(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> r100) {
            this.f492850a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object[] r110) throws Exception {
            Object[] r111 = r110;
            if (r111.length != 8) goto L7;
            return this.f492850a.apply((T1) r111[0], (T2) r111[1], (T3) r111[2], (T4) r111[3], (T5) r111[4], (T6) r111[5], (T7) r111[6], (T8) r111[7]);
        L7:
            throw new IllegalArgumentException("Array of size 8 expected but got " + r111.length);
        }
    }

    public static final class h0<K, T> implements ttc.a<Map<K, T>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function<? super T, ? extends K> f492851a;

        public h0(Function<? super T, ? extends K> r100) {
            this.f492851a = r100;
        }

        @Override // ttc.a
        public final void accept(Object r100, Object r101) throws Exception {
            ((Map) r100).put(this.f492851a.apply(r101), r101);
        }
    }

    public static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f492852a;

        public i(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> r100) {
            this.f492852a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object[] r110) throws Exception {
            Object[] r111 = r110;
            if (r111.length != 9) goto L7;
            return this.f492852a.apply((T1) r111[0], (T2) r111[1], (T3) r111[2], (T4) r111[3], (T5) r111[4], (T6) r111[5], (T7) r111[6], (T8) r111[7], (T9) r111[8]);
        L7:
            throw new IllegalArgumentException("Array of size 9 expected but got " + r111.length);
        }
    }

    public static final class i0<K, V, T> implements ttc.a<Map<K, V>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function<? super T, ? extends V> f492853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function<? super T, ? extends K> f492854b;

        public i0(Function<? super T, ? extends V> r100, Function<? super T, ? extends K> r101) {
            this.f492853a = r100;
            this.f492854b = r101;
        }

        @Override // ttc.a
        public final void accept(Object r100, Object r101) throws Exception {
            ((Map) r100).put(this.f492854b.apply(r101), this.f492853a.apply(r101));
        }
    }

    public static final class j<T> implements Callable<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f492855a;

        @Override // java.util.concurrent.Callable
        public List<T> call() throws Exception {
            return new ArrayList(this.f492855a);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() throws Exception {
            return call();
        }

        public j(int r100) {
            this.f492855a = r100;
        }
    }

    public static final class j0<K, V, T> implements ttc.a<Map<K, Collection<V>>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function<? super K, ? extends Collection<? super V>> f492856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function<? super T, ? extends V> f492857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function<? super T, ? extends K> f492858c;

        @Override // ttc.a
        public final void accept(Object r100, Object r101) throws Exception {
            Map r102 = (Map) r100;
            K r103 = this.f492858c.apply(r101);
            Collection<? super V> r104 = (Collection) r102.get(r103);
            if (r104 != null) goto L5;
            r104 = this.f492856a.apply(r103);
            r102.put(r103, r104);
        L5:
            r104.add(this.f492857b.apply(r101));
        }

        public j0(Function<? super K, ? extends Collection<? super V>> r100, Function<? super T, ? extends V> r101, Function<? super T, ? extends K> r102) {
            this.f492856a = r100;
            this.f492857b = r101;
            this.f492858c = r102;
        }
    }

    public static final class k<T> implements Predicate<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ttc.b f492859a;

        public k(ttc.b r100) {
            this.f492859a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(T r100) throws Exception {
            return !this.f492859a.getAsBoolean();
        }
    }

    public static final class k0 implements Predicate<Object> {
        public k0() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            return true;
        }
    }

    public static class l implements Consumer<wwc.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f492860a;

        public l(int r100) {
            this.f492860a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(wwc.c r100) throws Exception {
            r100.request(this.f492860a);
        }
    }

    public static final class m<T, U> implements Function<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<U> f492861a;

        public m(Class<U> r100) {
            this.f492861a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final U apply(T r100) throws Exception {
            return this.f492861a.cast(r100);
        }
    }

    public static final class n<T, U> implements Predicate<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<U> f492862a;

        public n(Class<U> r100) {
            this.f492862a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(T r100) throws Exception {
            return this.f492862a.isInstance(r100);
        }
    }

    public static final class o implements Action {
        public o() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
        }

        public final String toString() {
            return "EmptyAction";
        }
    }

    public static final class p implements Consumer<Object> {
        public p() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
        }

        public final String toString() {
            return "EmptyConsumer";
        }
    }

    public static final class q implements ttc.d {
        public q() {
        }
    }

    public static final class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }

        public final String toString() {
            return "EmptyRunnable";
        }
    }

    public static final class s<T> implements Predicate<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f492863a;

        public s(T r100) {
            this.f492863a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(T r100) throws Exception {
            return ObjectHelper.equals(r100, this.f492863a);
        }
    }

    public static final class t implements Consumer<Throwable> {
        public t() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            RxJavaPlugins.onError(r100);
        }
    }

    public static final class u implements Predicate<Object> {
        public u() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            return false;
        }
    }

    public static final class v implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future<?> f492864a;

        @Override // io.reactivex.functions.Action
        public final void run() throws Exception {
            this.f492864a.get();
        }

        public v(Future<?> r100) {
            this.f492864a = r100;
        }
    }

    public static final class w implements Function<Object, Object> {
        public w() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            return r100;
        }

        public final String toString() {
            return "IdentityFunction";
        }
    }

    public static final class x<T, U> implements Callable<U>, Function<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final U f492865a;

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f492865a;
        }

        public x(U r100) {
            this.f492865a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final U apply(T r100) throws Exception {
            return this.f492865a;
        }
    }

    public static final class y<T> implements Function<List<T>, List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparator<? super T> f492866a;

        public y(Comparator<? super T> r100) {
            this.f492866a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) throws Exception {
            List r101 = (List) r100;
            Collections.sort(r101, this.f492866a);
            return r101;
        }
    }

    public static final class z implements Consumer<wwc.c> {
        public z() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(wwc.c r100) throws Exception {
            r100.request(Long.MAX_VALUE);
        }
    }

    static {
        IDENTITY = new w();
        EMPTY_RUNNABLE = new r();
        EMPTY_ACTION = new o();
        EMPTY_CONSUMER = new p();
        ERROR_CONSUMER = new t();
        ON_ERROR_MISSING = new f0();
        EMPTY_LONG_CONSUMER = new q();
        ALWAYS_TRUE = new k0();
        ALWAYS_FALSE = new u();
        NULL_SUPPLIER = new e0();
        NATURAL_COMPARATOR = new a0();
        REQUEST_MAX = new z();
    }

    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Predicate<T> alwaysFalse() {
        return (Predicate<T>) ALWAYS_FALSE;
    }

    public static <T> Predicate<T> alwaysTrue() {
        return (Predicate<T>) ALWAYS_TRUE;
    }

    public static <T> Callable<Set<T>> createHashSet() {
        return HashSetCallable.INSTANCE;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return (Consumer<T>) EMPTY_CONSUMER;
    }

    public static <T> Function<T, T> identity() {
        return (Function<T, T>) IDENTITY;
    }

    public static <T> Comparator<T> naturalComparator() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Comparator<T> naturalOrder() {
        return (Comparator<T>) NATURAL_COMPARATOR;
    }

    public static <T> Callable<T> nullSupplier() {
        return (Callable<T>) NULL_SUPPLIER;
    }

    public static <T> Consumer<T> actionConsumer(Action r100) {
        return new a(r100);
    }

    public static <T> Consumer<T> boundedConsumer(int r100) {
        return new l(r100);
    }

    public static <T, U> Function<T, U> castFunction(Class<U> r100) {
        return new m(r100);
    }

    public static <T> Callable<List<T>> createArrayList(int r100) {
        return new j(r100);
    }

    public static <T> Predicate<T> equalsWith(T r100) {
        return new s(r100);
    }

    public static Action futureAction(Future<?> r100) {
        return new v(r100);
    }

    public static <T, U> Predicate<T> isInstanceOf(Class<U> r100) {
        return new n(r100);
    }

    public static <T> Callable<T> justCallable(T r100) {
        return new x(r100);
    }

    public static <T, U> Function<T, U> justFunction(U r100) {
        return new x(r100);
    }

    public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> r100) {
        return new y(r100);
    }

    public static <T> Action notificationOnComplete(Consumer<? super io.reactivex.o<T>> r100) {
        return new b0(r100);
    }

    public static <T> Consumer<Throwable> notificationOnError(Consumer<? super io.reactivex.o<T>> r100) {
        return new c0(r100);
    }

    public static <T> Consumer<T> notificationOnNext(Consumer<? super io.reactivex.o<T>> r100) {
        return new d0(r100);
    }

    public static <T> Predicate<T> predicateReverseFor(ttc.b r100) {
        return new k(r100);
    }

    public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> r100) {
        ObjectHelper.requireNonNull(r100, "f is null");
        return new b(r100);
    }

    public static <T, K> ttc.a<Map<K, T>, T> toMapKeySelector(Function<? super T, ? extends K> r100) {
        return new h0(r100);
    }

    public static <T1, T2, T3, R> Function<Object[], R> toFunction(Function3<T1, T2, T3, R> r100) {
        ObjectHelper.requireNonNull(r100, "f is null");
        return new c(r100);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(Function4<T1, T2, T3, T4, R> r100) {
        ObjectHelper.requireNonNull(r100, "f is null");
        return new d(r100);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(Function5<T1, T2, T3, T4, T5, R> r100) {
        ObjectHelper.requireNonNull(r100, "f is null");
        return new e(r100);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(Function6<T1, T2, T3, T4, T5, T6, R> r100) {
        ObjectHelper.requireNonNull(r100, "f is null");
        return new f(r100);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(Function7<T1, T2, T3, T4, T5, T6, T7, R> r100) {
        ObjectHelper.requireNonNull(r100, "f is null");
        return new g(r100);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> r100) {
        ObjectHelper.requireNonNull(r100, "f is null");
        return new h(r100);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> r100) {
        ObjectHelper.requireNonNull(r100, "f is null");
        return new i(r100);
    }

    public static <T> Function<T, io.reactivex.schedulers.a<T>> timestampWith(TimeUnit r100, Scheduler r101) {
        return new g0(r100, r101);
    }

    public static <T, K, V> ttc.a<Map<K, V>, T> toMapKeyValueSelector(Function<? super T, ? extends K> r100, Function<? super T, ? extends V> r101) {
        return new i0(r101, r100);
    }

    public static <T, K, V> ttc.a<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(Function<? super T, ? extends K> r100, Function<? super T, ? extends V> r101, Function<? super K, ? extends Collection<? super V>> r102) {
        return new j0(r102, r101, r100);
    }
}
