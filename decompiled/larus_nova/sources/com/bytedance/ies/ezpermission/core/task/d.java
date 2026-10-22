package com.bytedance.ies.ezpermission.core.task;

import com.bytedance.ies.ezpermission.core.permissions.PermissionTransformer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends BasePermissionTask {
    public d(com.bytedance.ies.ezpermission.core.d r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionContext");
        super(r100);
    }

    @Override // com.bytedance.ies.ezpermission.core.task.BasePermissionTask
    public final Object b(Continuation<? super Unit> r100) {
        List<List<String>> r101 = this.f248588b.b().f248572d;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        List r104 = (List) r103.next();
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        r105.add(PermissionTransformer.a((String) r106.next()));
        goto L7
    L9:
        r102.add(r105);
        goto L4
    L10:
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r108 = r102.iterator();
    L12:
        if (r108.hasNext() == false) goto L20;
        List r109 = (List) r108.next();
        ArrayList r110 = new ArrayList();
        Iterator r111 = r109.iterator();
    L15:
        if (r111.hasNext() == false) goto L19;
        Object r112 = r111.next();
        if (Boxing.boxBoolean(!(((com.bytedance.ies.ezpermission.core.permissions.a) r112) instanceof m46.c)).booleanValue() == false) goto L15;
        r110.add(r112);
        goto L15
    L19:
        r107.add(r110);
        goto L12
    L20:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r107.iterator();
    L22:
        if (r114.hasNext() == false) goto L26;
        Object r115 = r114.next();
        if (Boxing.boxBoolean(!((List) r115).isEmpty()).booleanValue() == false) goto L22;
        r113.add(r115);
        goto L22
    L26:
        List r116 = TypeIntrinsics.asMutableList(r113);
        List r117 = CollectionsKt.flatten(r102);
        ArrayList r118 = new ArrayList();
        Iterator r119 = r117.iterator();
    L28:
        if (r119.hasNext() == false) goto L32;
        Object r120 = r119.next();
        if ((r120 instanceof m46.c) == false) goto L28;
        r118.add(r120);
        goto L28
    L32:
        List r121 = TypeIntrinsics.asMutableList(r118);
        this.f248588b.a(new c(r116, r121, 9));
        n46.a.f517060b.getClass();
        n46.a.c("Permission pre deal finish\n    normal:" + r116 + "\n     special:" + r121);
        Object r122 = a(r100);
        if (r122 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        return r122;
    L36:
        return Unit.INSTANCE;
    }
}
