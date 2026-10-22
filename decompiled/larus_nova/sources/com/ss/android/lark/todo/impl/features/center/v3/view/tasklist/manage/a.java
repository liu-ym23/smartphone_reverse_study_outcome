package com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage;

import com.bytedance.lark.pb.todo.v1.TaskContainerFilter;

/* JADX INFO: loaded from: classes38.dex */
public interface a extends com.ss.android.lark.todo.impl.features.center.v3.arch.a {
    TaskContainerFilter.TabFilter.TaskContainerTabCategory getCurSelectTabCategory();

    b getTaskListManageState();

    void goTaskListActivity(String r100);

    void loadTaskListManage(boolean r100);
}
