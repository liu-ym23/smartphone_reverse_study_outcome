package f48;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f475572a = 0;

    /* JADX INFO: renamed from: f48.a$a, reason: collision with other inner class name */
    public static final class C5857a<T> implements Comparator {
        public C5857a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            ((c) r101).priority();
            ((c) r100).priority();
            return ComparisonsKt.compareValues(0, 0);
        }
    }

    static {
    }

    public static boolean a(Iterable r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, PromotionProductPrivilegesStruct.SERVICES);
        Intrinsics.checkNotNullParameter(r101, "block");
        List r102 = CollectionsKt.sortedWith(r100, new C5857a());
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (((Boolean) r101.invoke(r103.next())).booleanValue() == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }
}
