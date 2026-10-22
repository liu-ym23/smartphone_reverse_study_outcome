package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\b\u001a?\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\f\u001aG\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\b\u001a?\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"maxOf", ExifInterface.GPS_DIRECTION_TRUE, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "other", "", "(Ljava/lang/Object;[Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsKt extends ComparisonsKt___ComparisonsJvmKt {
    public ComparisonsKt___ComparisonsKt() {
    }

    public static final <T> T maxOf(T r100, T[] r101, Comparator<? super T> r102) {
        Intrinsics.checkNotNullParameter(r101, "other");
        Intrinsics.checkNotNullParameter(r102, "comparator");
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        T r105 = r101[r104];
        if (r102.compare(r100, r105) >= 0) goto L7;
        r100 = r105;
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r100;
    }

    public static final <T> T minOf(T r100, T[] r101, Comparator<? super T> r102) {
        Intrinsics.checkNotNullParameter(r101, "other");
        Intrinsics.checkNotNullParameter(r102, "comparator");
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        T r105 = r101[r104];
        if (r102.compare(r100, r105) <= 0) goto L7;
        r100 = r105;
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r100;
    }

    public static final <T> T maxOf(T r100, T r101, Comparator<? super T> r102) {
        Intrinsics.checkNotNullParameter(r102, "comparator");
        if (r102.compare(r100, r101) < 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    public static <T> T minOf(T r100, T r101, Comparator<? super T> r102) {
        Intrinsics.checkNotNullParameter(r102, "comparator");
        if (r102.compare(r100, r101) > 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    public static final <T> T maxOf(T r100, T r101, T r102, Comparator<? super T> r103) {
        Intrinsics.checkNotNullParameter(r103, "comparator");
        return (T) maxOf(r100, maxOf(r101, r102, r103), r103);
    }

    public static <T> T minOf(T r100, T r101, T r102, Comparator<? super T> r103) {
        Intrinsics.checkNotNullParameter(r103, "comparator");
        return (T) minOf(r100, minOf(r101, r102, r103), r103);
    }
}
