package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import androidx.lifecycle.Observer;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberRole;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class q<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListPermissionFragment f442399a;

    public q(TaskListPermissionFragment r100) {
        this.f442399a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        TodoItemMemberRole r111 = (TodoItemMemberRole) r110;
        TaskListPermissionFragment r100 = this.f442399a;
        Intrinsics.checkNotNull(r111);
        int r101 = TaskListPermissionFragment.f442310k;
        Context r102 = r100.getContext();
        if (r102 == null) goto L11;
        String r103 = UUID.randomUUID().toString();
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        com.ss.android.lark.todo.impl.utils.i r105 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r104.append(com.ss.android.lark.todo.impl.utils.i.d(R.string.Todo_List_NoPermissionRequestFormer_Text, "permission", r103));
        if (TaskListPermissionFragment.b.f442318a[r111.ordinal()] != 1) goto L8;
        String r112 = r105.g(R.string.Todo_List_NoPermissionRequestEditLatter_Text).concat(" $");
    L9:
        int r106 = StringsKt.indexOf$default(r104, r103, 0, false, 6, null);
        r104.replace(r106, r104.length(), r112);
        r104.setSpan(new r(r102, r100), r106, r104.length(), 33);
        r104.setSpan(new c8c.a(UDIconUtils.getIconDrawable(r102, R.drawable.ud_icon_expand_down_filled, r105.a(R.color.primary_fill_default), new UDDimension.b(8))), r104.length() - 1, r104.length(), 33);
        r100.U90().setText(r104);
        r100.U90().setMovementMethod(LinkMovementMethod.getInstance());
        r100.U90().setHighlightColor(r105.a(R.color.transparent));
        return;
    L8:
        r112 = r105.g(R.string.Todo_List_NoPermissionRequestViewLatter_Text).concat(" $");
        goto L9
    }
}
