package ssc;

import io.noties.markwon.ext.tasklist.TaskListItem;
import lsc.m;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements m.c<TaskListItem> {
    public b() {
    }

    @Override // lsc.m.c
    public final void a(m r100, uvc.b r101) {
        TaskListItem r102 = (TaskListItem) r101;
        int r103 = r100.length();
        r100.c(r102);
        e.f543522a.c(r100.r(), Boolean.valueOf(r102.f492570h));
        r100.y(r102, r103);
        if (r100.s(r102) == false) goto L6;
        r100.a();
        return;
    }
}
