package e33;

import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class m {
    public static final l a(Class<? extends o> r100, Set<? extends Class<?>> r101, n r102, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "serviceCls");
        Intrinsics.checkNotNullParameter(r101, "exportedTypes");
        ArrayList r103 = new ArrayList();
        r103.add(JvmClassMappingKt.getKotlinClass(r100));
        Set<? extends Class<?>> r104 = r101;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        r105.add(JvmClassMappingKt.getKotlinClass((Class) r106.next()));
        goto L4
    L6:
        CollectionsKt.addAll(r103, r105);
        Unit r107 = Unit.INSTANCE;
        return new l(r100, r103, r102, r110, r111);
    }
}
