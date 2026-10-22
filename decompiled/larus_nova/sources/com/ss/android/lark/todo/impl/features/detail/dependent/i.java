package com.ss.android.lark.todo.impl.features.detail.dependent;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.lark.pb.todo.v1.TodoItemPermission;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f443089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Todo f443090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskSearchListAdapter f443091c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f443089a;
        long r102 = System.currentTimeMillis();
        this.f443089a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        TodoItemPermission r103 = this.f443090b.self_permission;
        if (r103 == null) goto L8;
        boolean r104 = Intrinsics.areEqual(r103.is_editable, Boolean.TRUE);
    L9:
        if (r104 == false) goto L14;
        TaskSearchListAdapter.b r105 = this.f443091c.f443059a;
        if (r105 == null) goto L15;
        r105.a(this.f443090b.guid);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r104 = false;
        goto L9
    }

    public i(Todo r100, TaskSearchListAdapter r101) {
        this.f443090b = r100;
        this.f443091c = r101;
    }
}
