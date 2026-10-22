package vza;

import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<k<?>> f557756b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, LinkedList<k<?>>> f557757a;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        f557756b = k.class;
    }

    public c() {
        this.f557757a = new LinkedHashMap();
    }

    public final <BlockViewType extends k<?>> BlockViewType a(j r100, Class<BlockViewType> r101) {
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        int r102 = (r100.hashCode() * 31) + r101.hashCode();
        Map<Integer, LinkedList<k<?>>> r103 = this.f557757a;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        LinkedList r105 = (LinkedList) r104.get(Integer.valueOf(r102));
        if (r105 != null) goto L5;
        return null;
    L5:
        Object r106 = r105.poll();
        if ((r106 instanceof k) == true) goto L8;
        return null;
    L8:
        return (BlockViewType) r106;
    }

    public final <BlockViewType extends k<?>> void b(j r100, Class<BlockViewType> r101, BlockViewType r102) {
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "blockView");
        int r103 = (r100.hashCode() * 31) + r101.hashCode();
        Map<Integer, LinkedList<k<?>>> r104 = this.f557757a;
        Integer r105 = Integer.valueOf(r103);
        LinkedHashMap r106 = (LinkedHashMap) r104;
        Object r107 = r106.get(r105);
        if (r107 != null) goto L5;
        r107 = new LinkedList();
        r106.put(r105, r107);
    L5:
        LinkedList r108 = (LinkedList) r107;
        if (r102.getView().getParent() != null) goto L14;
        if (r108.contains(r102) == true) goto L12;
        r108.push(r102);
        return;
    L12:
        throw new IllegalStateException("IBlockView already in cache, key: " + r103);
    L14:
        throw new IllegalStateException("IBlockView is still attached, key: " + r103);
    }
}
