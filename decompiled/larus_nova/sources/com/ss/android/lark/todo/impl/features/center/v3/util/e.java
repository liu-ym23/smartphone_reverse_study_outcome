package com.ss.android.lark.todo.impl.features.center.v3.util;

import com.larksuite.component.universe_design.dialog.UDListDialogController;
import java.util.HashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap<Integer, TaskListDialogUtils.Icon> f441791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskListDialogUtils.b f441792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f441793c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441794a = null;

        static {
            int[] r100 = new int[TaskListDialogUtils.Icon.values().length];
            r100[TaskListDialogUtils.Icon.CreateIcon.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TaskListDialogUtils.Icon.ArchiveIcon.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f441794a = r100;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        TaskListDialogUtils.Icon r101 = this.f441791a.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L9;
        this.f441792b.a();
        return;
    L9:
        if (r102 != 2) goto L15;
        this.f441792b.b(this.f441793c);
        return;
    L15:
        return;
    L5:
        r102 = a.f441794a[r101.ordinal()];
        goto L7
    }

    public e(HashMap r100, com.ss.android.lark.todo.impl.features.center.v3.view.e r101, boolean r102) {
        this.f441791a = r100;
        this.f441792b = r101;
        this.f441793c = r102;
    }
}
