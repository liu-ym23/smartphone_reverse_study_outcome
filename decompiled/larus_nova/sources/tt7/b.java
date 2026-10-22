package tt7;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.lark.kmp.containerization.d;
import com.lark.kmp.module.UserStateModule;
import com.lark.kmp.rustclient.RustClientModule;
import com.lark.kmp.rustclient.internal.q;
import com.lark.kmp.rustclient.internal.t;
import com.lark.kmp.storage.module.StorageModule;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public static void a() {
        int r100 = iy7.a.f496568a;
        Map<d<?>, com.lark.kmp.containerization.c<?>> r101 = com.lark.kmp.containerization.a.f278584a;
        List r102 = CollectionsKt.listOf(new d[]{iy7.b.f496569a, iy7.b.f496570b});
        Intrinsics.checkNotNullParameter(r102, "types");
        ((LinkedHashMap) com.lark.kmp.containerization.a.f278584a).clear();
        Iterator r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        d<?> r104 = (d) r103.next();
        com.lark.kmp.containerization.a.f278584a.put(r104, new com.lark.kmp.containerization.c(r104));
        goto L4
    L6:
        int r105 = iy7.a.f496568a;
        Map<d<?>, com.lark.kmp.containerization.c<?>> r106 = com.lark.kmp.containerization.a.f278584a;
        com.lark.kmp.containerization.b r107 = com.lark.kmp.containerization.a.a(iy7.b.f496569a).b(Unit.INSTANCE, null);
        int r108 = a.f547559a;
        Intrinsics.checkNotNullParameter(r107, "component");
        RustClientModule.a(r107);
        UserStateModule.a(r107);
        StorageModule.a(r107);
        Intrinsics.checkNotNullParameter(r107, KtvSubElement.CONTAINER);
        rpc.b r109 = rpc.d.f538911a;
        Object r110 = r107.a(Reflection.getOrCreateKotlinClass(t.class));
        if (r110 == null) goto L11;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.lark.kmp.rustclient.internal.IRustCallBackReceiver");
        rpc.d.f538911a = (q) r110;
        return;
    L11:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(t.class).getSimpleName() + " found");
    }
}
