package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.GroupEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class p implements Function1<GroupEntity, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f207615a;

    public p(Context r100) {
        this.f207615a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(GroupEntity r100) {
        GroupEntity r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "groupEntity");
        if (TextUtils.isEmpty(r101.getLinkToken()) == false) goto L5;
        tt5.a.k("GroupFilterValueEditViewHolder", "group linkToken is empty id=" + r101.getId() + " name=" + r101.getLocalName(null));
    L5:
        com.bytedance.ee.bear.lark.dependency.n r102 = (com.bytedance.ee.bear.lark.dependency.n) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.n.class, null, null, 6);
        Context r103 = this.f207615a;
        r101.getLinkToken();
        r102.p(r103);
        return Unit.INSTANCE;
    }
}
