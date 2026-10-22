package x64;

import com.bytedance.badger.v.w;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static final Pair a(com.bytedance.badger.C.b r100) {
        int r101 = r100.ordinal();
        if (r101 != 0) goto L5;
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.g r102 = com.bytedance.badger.v.d.f199332p;
        KProperty[] r103 = com.bytedance.badger.v.d.f199311a;
        KProperty r104 = r103[15];
        Long r105 = Long.valueOf(((w) r102.a()).a());
        com.bytedance.badger.v.g r106 = com.bytedance.badger.v.d.f199330n;
        KProperty r107 = r103[13];
        return new Pair(r105, Long.valueOf(((w) r106.a()).a()));
    L5:
        if (r101 != 1) goto L8;
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.g r108 = com.bytedance.badger.v.d.f199331o;
        KProperty[] r109 = com.bytedance.badger.v.d.f199311a;
        KProperty r110 = r109[14];
        Long r111 = Long.valueOf(((w) r108.a()).a());
        com.bytedance.badger.v.g r112 = com.bytedance.badger.v.d.f199329m;
        KProperty r113 = r109[12];
        return new Pair(r111, Long.valueOf(((w) r112.a()).a()));
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
