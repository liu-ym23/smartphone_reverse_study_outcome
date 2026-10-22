package kotlin.jvm.optionals;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.event.a;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u001a,\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\f\u0012\b\b\u0001\u0012\u0004\b\u0002H\u00020\u00042\u0006\u0010\u0006\u001a\u0002H\u0002H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001aC\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\f\u0012\b\b\u0001\u0012\u0004\b\u0002H\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0087\bø\u0001\u0001ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\n\u001a#\u0010\u000b\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\f\u001a;\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0010\b\u0001\u0010\u000e*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0010\u001a\u0002H\u000eH\u0007¢\u0006\u0002\u0010\u0011\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u001a$\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u0082\u0002\u000b\n\u0002\b9\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"asSequence", "Lkotlin/sequences/Sequence;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/util/Optional;", "getOrDefault", "defaultValue", "(Ljava/util/Optional;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/util/Optional;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrNull", "(Ljava/util/Optional;)Ljava/lang/Object;", "toCollection", "C", "", a.KEY_DESTINATION, "(Ljava/util/Optional;Ljava/util/Collection;)Ljava/util/Collection;", "toList", "", "toSet", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class OptionalsKt {
    public static final <T> Sequence<T> asSequence(Optional<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isPresent() == false) goto L6;
        return SequencesKt.sequenceOf(new Object[]{r100.get()});
    L6:
        return SequencesKt.emptySequence();
    }

    public static final <T> T getOrNull(Optional<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.orElse(null);
    }

    public static final <T> List<T> toList(Optional<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isPresent() == false) goto L6;
        return CollectionsKt.listOf(r100.get());
    L6:
        return CollectionsKt.emptyList();
    }

    public static final <T> Set<T> toSet(Optional<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isPresent() == false) goto L6;
        return SetsKt.setOf(r100.get());
    L6:
        return SetsKt.emptySet();
    }

    public static final <T> T getOrDefault(Optional<? extends T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isPresent() == true) goto L5;
        return r101;
    L5:
        return r100.get();
    }

    public static final <T> T getOrElse(Optional<? extends T> r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        if (r100.isPresent() == false) goto L6;
        return r100.get();
    L6:
        return r101.invoke();
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Optional<T> r100, C r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        if (r100.isPresent() == false) goto L5;
        r101.add(r100.get());
    L5:
        return r101;
    }
}
