package com.ss.android.lark.todo.impl.features.detail.assignee.add.adapter;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;
import com.ss.android.lark.todo.impl.utils.i;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssigneeRecommendAdapter f442584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecommendItem f442585b;

    public a(AssigneeRecommendAdapter r100, RecommendItem r101) {
        this.f442584a = r100;
        this.f442585b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AssigneeRecommendAdapter r101 = this.f442584a;
        RecommendItem r102 = this.f442585b;
        r101.getClass();
        if (r102.getType() != RecommendItem.ShowType.CHATTER) goto L23;
        boolean r103 = r102.f442574b;
        r101.f442568b.a(r102, r103);
        Iterator<T> r104 = r101.f442569c.iterator();
    L6:
        if (r104.hasNext() == false) goto L23;
        RecommendItem r105 = (RecommendItem) r104.next();
        RecommendItem.a r106 = r105.f442576d;
        if (r106 == null) goto L12;
        Chatter r107 = r106.f442581a;
        if (r107 == null) goto L12;
        String r108 = r107.getId();
    L13:
        RecommendItem.a r109 = r102.f442576d;
        if (r109 == null) goto L18;
        Chatter r110 = r109.f442581a;
        if (r110 == null) goto L18;
        String r111 = r110.getId();
    L20:
        if (Intrinsics.areEqual(r108, r111) == false) goto L6;
        r105.f442574b = !r103;
    L18:
        r111 = null;
    L12:
        r108 = null;
    L23:
        if (r102.getType() == RecommendItem.ShowType.SELECTALL) goto L25;
        return;
    L25:
        if (r102.f442578f == true) goto L27;
        OperationToastHelper r112 = OperationToastHelper.f442443a;
        i r113 = i.f444291a;
        OperationToastHelper.c(LarkContext.getApplication(), R.string.Todo_TooManyGroupMembersUnableToSelectAll_Hover, null, 60);
        return;
    L27:
        r101.f442568b.a(r102, r102.f442574b);
        r102.f442574b = !r102.f442574b;
        Iterator<T> r114 = r101.f442569c.iterator();
    L29:
        if (r114.hasNext() == false) goto L50;
        RecommendItem r115 = (RecommendItem) r114.next();
        RecommendItem.a r116 = r115.f442576d;
        if (r116 != null) goto L33;
    L35:
        boolean r117 = false;
    L36:
        if (r117 == false) goto L29;
        r115.f442574b = r102.f442574b;
        goto L29
    L33:
        if (r116.f442583c != true) goto L35;
        r117 = true;
        goto L36
    }
}
