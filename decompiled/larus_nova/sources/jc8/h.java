package jc8;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, List<IBlockProvider>> f498166a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IBlockProvider f498167b;

    public h() {
    }

    static {
        f498166a = new LinkedHashMap();
        pd6.b r100 = pd6.c.f528682a;
        List r101 = pd6.c.b(Reflection.getOrCreateKotlinClass(IBlockProvider.class));
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        Iterator r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L25;
        IBlockProvider r103 = (IBlockProvider) r102.next();
        if (r103.N0() == BlockProviderType.UNKNOWN) goto L10;
        Iterator<T> r104 = i.f498168a.entrySet().iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        Object r105 = r104.next();
        if (((List) ((Map.Entry) r105).getValue()).contains(r103.N0()) == false) goto L13;
    L18:
        Map.Entry r106 = (Map.Entry) r105;
        if (r106 == null) goto L7;
        int r107 = ((Number) r106.getKey()).intValue();
        List r108 = (List) r106.getValue();
        Map<Integer, List<IBlockProvider>> r109 = f498166a;
        LinkedHashMap r110 = (LinkedHashMap) r109;
        List r111 = (List) r110.get(Integer.valueOf(r107));
        if (r111 != null) goto L24;
        r111 = CollectionsKt.emptyList();
    L24:
        List r112 = CollectionsKt.sortedWith(CollectionsKt.plus(r111, r103), new g(r108));
        r110.put(Integer.valueOf(r107), r112);
        goto L7
    L17:
        r105 = null;
        goto L18
    L10:
        f498167b = r103;
        goto L7
    }

    public static List a(int r100) {
        Object r101 = ((LinkedHashMap) f498166a).get(Integer.valueOf(r100));
        List r102 = (List) r101;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        r101 = null;
    L13:
        List r104 = (List) r101;
        if (r104 != null) goto L19;
        IBlockProvider r105 = f498167b;
        if (r105 != null) goto L21;
        return null;
    L21:
        return CollectionsKt.listOf(r105);
    L19:
        return r104;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L10
    }
}
