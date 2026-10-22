package androidx.collection;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001aû\u0001\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\b\b\u0001\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b28\b\u0006\u0010\t\u001a2\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\n2%\b\u0006\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u00102d\b\u0006\u0010\u0011\u001a^\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u0001H\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0012H\u0086\bø\u0001\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"MAX_SIZE", "", "lruCache", "Landroidx/collection/LruCache;", "K", "V", "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "key", "value", "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LruCacheKt {
    private static final long MAX_SIZE = 2147483647L;

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\bJ/\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u00012\b\u0010\u000e\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/collection/LruCacheKt$lruCache$4", "Landroidx/collection/LruCache;", "sizeOf", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)I", "create", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "collection"}, k = 1, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ Function1<K, V> $create;
        final /* synthetic */ Function4<Boolean, K, V, V, Unit> $onEntryRemoved;
        final /* synthetic */ Function2<K, V, Integer> $sizeOf;

        public V create(K r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            return (V) this.$create.invoke(r2);
        }

        public int sizeOf(K r2, V r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            return ((Number) this.$sizeOf.invoke(r2, r3)).intValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(int r1, Function2<? super K, ? super V, Integer> r2, Function1<? super K, ? extends V> r3, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> r4) {
            this.$sizeOf = r2;
            this.$create = r3;
            this.$onEntryRemoved = r4;
            super(r1);
        }

        public void entryRemoved(boolean r2, K r3, V r4, V r5) {
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(r2), r3, r4, r5);
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int r1, Function2<? super K, ? super V, Integer> r2, Function1<? super K, ? extends V> r3, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "sizeOf");
        Intrinsics.checkNotNullParameter(r3, "create");
        Intrinsics.checkNotNullParameter(r4, "onEntryRemoved");
        return new AnonymousClass4(r1, r2, r3, r4);
    }

    public static /* synthetic */ LruCache lruCache$default(int r0, Function2 r1, Function1 r2, Function4 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r1 = AnonymousClass1.INSTANCE;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r2 = AnonymousClass2.INSTANCE;
    L9:
        if ((r4 & 8) == 0) goto L11;
        r3 = AnonymousClass3.INSTANCE;
    L11:
        Intrinsics.checkNotNullParameter(r1, "sizeOf");
        Intrinsics.checkNotNullParameter(r2, "create");
        Intrinsics.checkNotNullParameter(r3, "onEntryRemoved");
        return new AnonymousClass4(r0, r1, r2, r3);
    }
}
