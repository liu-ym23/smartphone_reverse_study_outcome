package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001aY\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\t\u001aZ\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001a>\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001aZ\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001a-\u0010\r\u001a\u00020\u000e\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u000f\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0010\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aY\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0016\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022 \u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0014\u001a&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a-\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a-\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\u001aO\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u001aR\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001an\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001aR\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001an\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001ap\u0010!\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u000328\b\u0004\u0010\"\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0#H\u0087\bø\u0001\u0000\u001aO\u0010&\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"compareBy", "Ljava/util/Comparator;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "thenDescending", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt__ComparisonsKt {

    /* JADX INFO: renamed from: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass2<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> $selector;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super T, ? extends Comparable<?>> r100) {
            this.$selector = r100;
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Function1<T, Comparable<?>> r102 = this.$selector;
            return ComparisonsKt__ComparisonsKt.compareValues(r102.invoke(r100), r102.invoke(r101));
        }
    }

    /* JADX INFO: renamed from: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass1<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> $selector;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super T, ? extends Comparable<?>> r100) {
            this.$selector = r100;
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Function1<T, Comparable<?>> r102 = this.$selector;
            return ComparisonsKt__ComparisonsKt.compareValues(r102.invoke(r101), r102.invoke(r100));
        }
    }

    public ComparisonsKt__ComparisonsKt() {
    }

    public static /* synthetic */ int a(Comparator r100, Comparator r101, Object r102, Object r103) {
        return thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(r100, r101, r102, r103);
    }

    public static /* synthetic */ int b(Comparator r100, Object r101, Object r102) {
        return nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(r100, r101, r102);
    }

    public static /* synthetic */ int c(Comparator r100, Object r101, Object r102) {
        return nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(r100, r101, r102);
    }

    public static /* synthetic */ int d(Comparator r100, Comparator r101, Object r102, Object r103) {
        return then$lambda$1$ComparisonsKt__ComparisonsKt(r100, r101, r102, r103);
    }

    public static /* synthetic */ int e(Function1[] r100, Object r101, Object r102) {
        return compareBy$lambda$0$ComparisonsKt__ComparisonsKt(r100, r101, r102);
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        NaturalOrderComparator r100 = NaturalOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return r100;
    }

    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        ReverseOrderComparator r100 = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return r100;
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return nullsFirst(naturalOrder());
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return nullsLast(naturalOrder());
    }

    public static <T> Comparator<T> compareBy(final Function1<? super T, ? extends Comparable<?>>... r100) {
        Intrinsics.checkNotNullParameter(r100, "selectors");
        if (r100.length <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return new b(r100);
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r101 = false;
        goto L6
    }

    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "selector");
        return new AnonymousClass1(r100);
    }

    public static final <T> Comparator<T> nullsFirst(final Comparator<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "comparator");
        return new d(r100);
    }

    public static final <T> Comparator<T> nullsLast(final Comparator<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "comparator");
        return new e(r100);
    }

    public static final <T> Comparator<T> reversed(Comparator<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof ReversedComparator) == true) goto L14;
        Comparator<T> r101 = NaturalOrderComparator.INSTANCE;
        if (Intrinsics.areEqual(r100, r101) == false) goto L9;
        ReverseOrderComparator r102 = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
        return r102;
    L9:
        if (Intrinsics.areEqual(r100, ReverseOrderComparator.INSTANCE) == false) goto L11;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
    L13:
        return r101;
    L11:
        r101 = new ReversedComparator(r100);
        goto L13
    L14:
        return ((ReversedComparator) r100).getComparator();
    }

    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "selector");
        return new AnonymousClass2(r100);
    }

    private static final <T, K> Comparator<T> compareBy(final Comparator<? super K> r100, final Function1<? super T, ? extends K> r101) {
        Intrinsics.checkNotNullParameter(r100, "comparator");
        Intrinsics.checkNotNullParameter(r101, "selector");
        return new AnonymousClass3(r100, r101);
    }

    private static final <T, K> Comparator<T> compareByDescending(final Comparator<? super K> r100, final Function1<? super T, ? extends K> r101) {
        Intrinsics.checkNotNullParameter(r100, "comparator");
        Intrinsics.checkNotNullParameter(r101, "selector");
        return new C123292(r100, r101);
    }

    public static <T extends Comparable<?>> int compareValues(T r100, T r101) {
        if (r100 != r101) goto L5;
        return 0;
    L5:
        if (r100 != null) goto L8;
        return -1;
    L8:
        if (r101 != null) goto L12;
        return 1;
    L12:
        return r100.compareTo(r101);
    }

    public static <T> Comparator<T> then(final Comparator<T> r100, final Comparator<? super T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "comparator");
        return new a(r100, r101);
    }

    private static final <T> Comparator<T> thenBy(final Comparator<T> r100, final Function1<? super T, ? extends Comparable<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "selector");
        return new C123301(r100, r101);
    }

    private static final <T> Comparator<T> thenByDescending(final Comparator<T> r100, final Function1<? super T, ? extends Comparable<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "selector");
        return new C123321(r100, r101);
    }

    private static final <T> Comparator<T> thenComparator(final Comparator<T> r100, final Function2<? super T, ? super T, Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "comparison");
        return new C123341(r100, r101);
    }

    public static final <T> Comparator<T> thenDescending(final Comparator<T> r100, final Comparator<? super T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "comparator");
        return new c(r100, r101);
    }

    private static final int compareBy$lambda$0$ComparisonsKt__ComparisonsKt(Function1[] r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$selectors");
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(r101, r102, r100);
    }

    public static final <T> int compareValuesBy(T r100, T r101, Function1<? super T, ? extends Comparable<?>>... r102) {
        Intrinsics.checkNotNullParameter(r102, "selectors");
        if (r102.length <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(r100, r101, r102);
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r103 = false;
        goto L6
    }

    private static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T r100, T r101, Function1<? super T, ? extends Comparable<?>>[] r102) {
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        Function1<? super T, ? extends Comparable<?>> r105 = r102[r104];
        int r106 = compareValues(r105.invoke(r100), r105.invoke(r101));
        if (r106 != 0) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return r106;
    L8:
        return 0;
    }

    private static final int nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(Comparator r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$comparator");
        if (r101 != r102) goto L5;
        return 0;
    L5:
        if (r101 != null) goto L7;
        return -1;
    L7:
        if (r102 != null) goto L10;
        return 1;
    L10:
        return r100.compare(r101, r102);
    }

    private static final int nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(Comparator r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$comparator");
        if (r101 != r102) goto L5;
        return 0;
    L5:
        if (r101 != null) goto L7;
        return 1;
    L7:
        if (r102 != null) goto L10;
        return -1;
    L10:
        return r100.compare(r101, r102);
    }

    private static final <T, K> Comparator<T> thenBy(final Comparator<T> r100, final Comparator<? super K> r101, final Function1<? super T, ? extends K> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "comparator");
        Intrinsics.checkNotNullParameter(r102, "selector");
        return new C123312(r100, r101, r102);
    }

    private static final <T, K> Comparator<T> thenByDescending(final Comparator<T> r100, final Comparator<? super K> r101, final Function1<? super T, ? extends K> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "comparator");
        Intrinsics.checkNotNullParameter(r102, "selector");
        return new C123332(r100, r101, r102);
    }

    private static final <T> int compareValuesBy(T r100, T r101, Function1<? super T, ? extends Comparable<?>> r102) {
        Intrinsics.checkNotNullParameter(r102, "selector");
        return compareValues(r102.invoke(r100), r102.invoke(r101));
    }

    private static final <T, K> int compareValuesBy(T r100, T r101, Comparator<? super K> r102, Function1<? super T, ? extends K> r103) {
        Intrinsics.checkNotNullParameter(r102, "comparator");
        Intrinsics.checkNotNullParameter(r103, "selector");
        return r102.compare(r103.invoke(r100), r103.invoke(r101));
    }

    private static final int then$lambda$1$ComparisonsKt__ComparisonsKt(Comparator r100, Comparator r101, Object r102, Object r103) {
        Intrinsics.checkNotNullParameter(r100, "$this_then");
        Intrinsics.checkNotNullParameter(r101, "$comparator");
        int r104 = r100.compare(r102, r103);
        if (r104 == 0) goto L6;
        return r104;
    L6:
        return r101.compare(r102, r103);
    }

    private static final int thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(Comparator r100, Comparator r101, Object r102, Object r103) {
        Intrinsics.checkNotNullParameter(r100, "$this_thenDescending");
        Intrinsics.checkNotNullParameter(r101, "$comparator");
        int r104 = r100.compare(r102, r103);
        if (r104 == 0) goto L6;
        return r104;
    L6:
        return r101.compare(r103, r102);
    }
}
