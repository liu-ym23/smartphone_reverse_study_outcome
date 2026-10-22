package androidx.compose.foundation.lazy;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@LazyScopeMarker
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0016¢\u0006\u0002\u0010\u000bJ7\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0017¢\u0006\u0002\u0010\fJ\u0096\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0016¢\u0006\u0002\u0010\u0015Jo\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0017¢\u0006\u0002\u0010\u0016JC\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0017¢\u0006\u0002\u0010\u000bJI\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0016¢\u0006\u0002\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", "", "item", "", "key", "contentType", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LazyListScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Object items$lambda$0(int r0) {
            return null;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        public static /* synthetic */ void $default$item(LazyListScope r1, Object r2, Function3 r3) {
            r1.item(r2, null, r3);
        }

        public static /* synthetic */ void access$item$jd(LazyListScope r0, Object r1, Function3 r2) {
            $default$item(r0, r1, r2);
        }

        public static void $default$item(LazyListScope r0, Object r1, Object r2, Function3 r3) {
            throw new IllegalStateException("The method is not implemented".toString());
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        public static /* synthetic */ void $default$items(LazyListScope r1, int r2, Function1 r3, Function4 r4) {
            r1.items(r2, r3, new s(), r4);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload with indexing capabilities.", replaceWith = @ReplaceWith(expression = "stickyHeader(key, contentType, { _ -> content() })", imports = {}))
        public static /* synthetic */ void $default$stickyHeader(LazyListScope r2, Object r3, Object r4, final Function3 r5) {
            r2.stickyHeader(r3, r4, ComposableLambdaKt.composableLambdaInstance(-764088514, true, new C01801(r5)));
        }

        public static /* synthetic */ void access$item$jd(LazyListScope r0, Object r1, Object r2, Function3 r3) {
            $default$item(r0, r1, r2, r3);
        }

        public static /* synthetic */ void access$items$jd(LazyListScope r0, int r1, Function1 r2, Function4 r3) {
            $default$items(r0, r1, r2, r3);
        }

        public static /* synthetic */ void access$stickyHeader$jd(LazyListScope r0, Object r1, Object r2, Function3 r3) {
            $default$stickyHeader(r0, r1, r2, r3);
        }

        public static void $default$stickyHeader(LazyListScope r2, Object r3, Object r4, final Function4 r5) {
            r2.item(r3, r4, ComposableLambdaKt.composableLambdaInstance(1691919627, true, new AnonymousClass2(r5)));
        }

        public static /* synthetic */ void access$stickyHeader$jd(LazyListScope r0, Object r1, Object r2, Function4 r3) {
            $default$stickyHeader(r0, r1, r2, r3);
        }

        public static void $default$items(LazyListScope r0, int r1, Function1 r2, Function1 r3, Function4 r4) {
            throw new IllegalStateException("The method is not implemented".toString());
        }

        public static /* synthetic */ void access$items$jd(LazyListScope r0, int r1, Function1 r2, Function1 r3, Function4 r4) {
            $default$items(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ void item$default(LazyListScope r0, Object r1, Function3 r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 1) == 0) goto L6;
            r1 = null;
        L6:
            r0.item(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }

        public static /* synthetic */ void item$default(LazyListScope r1, Object r2, Object r3, Function3 r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 1) == 0) goto L7;
            r2 = null;
        L7:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            r1.item(r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }

        public static /* synthetic */ void items$default(LazyListScope r0, int r1, Function1 r2, Function4 r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 2) == 0) goto L6;
            r2 = null;
        L6:
            r0.items(r1, r2, r3);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }

        public static /* synthetic */ void stickyHeader$default(LazyListScope r1, Object r2, Object r3, Function3 r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 1) == 0) goto L7;
            r2 = null;
        L7:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            r1.stickyHeader(r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
        }

        public static /* synthetic */ void stickyHeader$default(LazyListScope r1, Object r2, Object r3, Function4 r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 1) == 0) goto L7;
            r2 = null;
        L7:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            r1.stickyHeader(r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void items$default(LazyListScope r0, int r1, Function1 r2, Function1 r3, Function4 r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 2) == 0) goto L7;
            r2 = null;
        L7:
            if ((r5 & 4) == 0) goto L9;
            r3 = AnonymousClass1.INSTANCE;
        L9:
            r0.items(r1, r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        public static /* synthetic */ void item(LazyListScope r0, Object r1, Function3 r2) {
            CC.access$item$jd(r0, r1, r2);
        }

        public static void item(LazyListScope r0, Object r1, Object r2, Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> r3) {
            CC.access$item$jd(r0, r1, r2, r3);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        public static /* synthetic */ void items(LazyListScope r0, int r1, Function1 r2, Function4 r3) {
            CC.access$items$jd(r0, r1, r2, r3);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload with indexing capabilities.", replaceWith = @ReplaceWith(expression = "stickyHeader(key, contentType, { _ -> content() })", imports = {}))
        public static /* synthetic */ void stickyHeader(LazyListScope r0, Object r1, Object r2, Function3 r3) {
            CC.access$stickyHeader$jd(r0, r1, r2, r3);
        }

        public static void stickyHeader(LazyListScope r0, Object r1, Object r2, Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> r3) {
            CC.access$stickyHeader$jd(r0, r1, r2, r3);
        }

        public static /* synthetic */ void item$default(LazyListScope r0, Object r1, Function3 r2, int r3, Object r4) {
            CC.item$default(r0, r1, r2, r3, r4);
        }

        public static void items(LazyListScope r0, int r1, Function1<? super Integer, ? extends Object> r2, Function1<? super Integer, ? extends Object> r3, Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> r4) {
            CC.access$items$jd(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ void item$default(LazyListScope r0, Object r1, Object r2, Function3 r3, int r4, Object r5) {
            CC.item$default(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void items$default(LazyListScope r0, int r1, Function1 r2, Function4 r3, int r4, Object r5) {
            CC.items$default(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void stickyHeader$default(LazyListScope r0, Object r1, Object r2, Function3 r3, int r4, Object r5) {
            CC.stickyHeader$default(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void stickyHeader$default(LazyListScope r0, Object r1, Object r2, Function4 r3, int r4, Object r5) {
            CC.stickyHeader$default(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void items$default(LazyListScope r0, int r1, Function1 r2, Function1 r3, Function4 r4, int r5, Object r6) {
            CC.items$default(r0, r1, r2, r3, r4, r5, r6);
        }
    }

    void item(Object r1, Object r2, Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> r3);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* synthetic */ void item(Object r1, Function3 r2);

    void items(int r1, Function1<? super Integer, ? extends Object> r2, Function1<? super Integer, ? extends Object> r3, Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> r4);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* synthetic */ void items(int r1, Function1 r2, Function4 r3);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload with indexing capabilities.", replaceWith = @ReplaceWith(expression = "stickyHeader(key, contentType, { _ -> content() })", imports = {}))
    /* synthetic */ void stickyHeader(Object r1, Object r2, Function3 r3);

    void stickyHeader(Object r1, Object r2, Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> r3);
}
