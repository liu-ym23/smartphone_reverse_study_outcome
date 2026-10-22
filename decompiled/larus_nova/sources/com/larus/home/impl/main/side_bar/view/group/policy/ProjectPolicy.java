package com.larus.home.impl.main.side_bar.view.group.policy;

import com.larus.home.impl.main.side_bar.view.group.module.ProjectModule;
import com.larus.home.impl.main.side_bar.view.group.module.c0;
import com.larus.home.impl.main.side_bar.view.group.module.p0;
import com.larus.home.impl.main.side_bar.view.group.module.r0;
import com.larus.home.impl.main.side_bar.view.group.module.s0;
import com.larus.home.impl.main.side_bar.view.group.module.y;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class ProjectPolicy implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f345571a;

    public ProjectPolicy(c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "deps");
        this.f345571a = r100;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.policy.b
    public final Object a(Continuation<? super List<y>> r100) {
        if ((r100 instanceof ProjectPolicy$getGroups$1) == false) goto L7;
        ProjectPolicy$getGroups$1 r101 = (ProjectPolicy$getGroups$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        List r107 = (List) r101.L$2;
        List r108 = (List) r101.L$1;
        List r109 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L28:
        r107.add(r103);
        c0 r110 = this.f345571a;
        if (r110.f345472i == true) goto L31;
    L33:
        r108.add(new s0(r110, r106).a());
        return CollectionsKt.build(r109);
    L31:
        if (r110.f345473j == true) goto L33;
        r106 = true;
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        List r111 = CollectionsKt.createListBuilder();
        r111.add(new r0(this.f345571a).a());
        c0 r112 = this.f345571a;
        if (r112.f345472i == true) goto L17;
    L19:
        boolean r113 = false;
    L20:
        if (r113 == false) goto L24;
        y r114 = new p0(r112).a();
        if (r114 == null) goto L24;
        Boxing.boxBoolean(r111.add(r114));
    L24:
        ProjectModule r115 = new ProjectModule(this.f345571a);
        r101.L$0 = r111;
        r101.L$1 = r111;
        r101.L$2 = r111;
        r101.label = 1;
        Object r116 = r115.a(r101);
        if (r116 != r104) goto L27;
        return r104;
    L27:
        r107 = r111;
        r108 = r107;
        r103 = r116;
        r109 = r108;
        goto L28
    L17:
        if (r112.f345473j == false) goto L19;
        r113 = true;
    L7:
        r101 = new ProjectPolicy$getGroups$1(this, r100);
        goto L8
    }
}
