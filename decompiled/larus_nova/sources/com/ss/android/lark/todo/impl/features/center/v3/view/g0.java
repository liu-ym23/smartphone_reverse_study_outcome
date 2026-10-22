package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskItem;

/* JADX INFO: loaded from: classes38.dex */
public final class g0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskItem f442030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskItemViewHolder f442031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f442032d;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442029a;
        long r102 = System.currentTimeMillis();
        this.f442029a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        TaskItem r103 = this.f442030b;
        if (r103.f441499q == true) goto L9;
        return;
    L9:
        if (r103.f441501s == null) goto L11;
        TaskItemViewHolder.Y3(this.f442031c, r103);
        return;
    L11:
        TaskItem.CompleteType r104 = r103.f441500r;
        if (r104 != TaskItem.CompleteType.TaskCompleteDialog) goto L15;
        TaskItemViewHolder.Z3(this.f442031c, r103, false);
        return;
    L15:
        if (r104 != TaskItem.CompleteType.TaskRevokeDialog) goto L17;
        TaskItemViewHolder.a4(this.f442031c, r103, false);
        return;
    L17:
        ImageView r105 = (ImageView) this.f442031c.f441924a.findViewById(R.id.complete_checkbox);
        Context r106 = this.f442031c.f441924a.getContext();
        if (this.f442032d == false) goto L20;
        int r107 = R.drawable.todo_svg_icon_milestone_unchecked;
    L21:
        r105.setImageDrawable(UDIconUtils.getIconDrawable(r106, r107));
        t r108 = this.f442031c.f441925b;
        TaskItem r109 = this.f442030b;
        r108.j(r109.f441483a, r109.f441500r, false);
        return;
    L20:
        r107 = R.drawable.todo_svg_icon_milestone_checked_new;
        goto L21
    }

    public g0(TaskItem r100, TaskItemViewHolder r101, boolean r102) {
        this.f442030b = r100;
        this.f442031c = r101;
        this.f442032d = r102;
    }
}
