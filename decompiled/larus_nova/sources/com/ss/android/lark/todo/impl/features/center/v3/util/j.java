package com.ss.android.lark.todo.impl.features.center.v3.util;

import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.ss.android.lark.todo.impl.features.center.v3.sidebar.TodoSidebarFragment$containerAdapter$2;
import java.util.HashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap<Integer, TaskListDialogUtils.Icon> f441806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskListDialogUtils.a f441807b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441808a = null;

        static {
            int[] r100 = new int[TaskListDialogUtils.Icon.values().length];
            r100[TaskListDialogUtils.Icon.CreateIcon.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TaskListDialogUtils.Icon.CreateSectionIcon.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f441808a = r100;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        TaskListDialogUtils.Icon r101 = this.f441806a.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L9;
        this.f441807b.a();
        return;
    L9:
        if (r102 != 2) goto L15;
        this.f441807b.b();
        return;
    L15:
        return;
    L5:
        r102 = a.f441808a[r101.ordinal()];
        goto L7
    }

    public j(HashMap r100, TodoSidebarFragment$containerAdapter$2.a.b r101) {
        this.f441806a = r100;
        this.f441807b = r101;
    }
}
