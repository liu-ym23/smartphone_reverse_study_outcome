package q7c;

import com.bytedance.lark.pb.todo.v1.TaskContainerFilter;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskContainerData;

/* JADX INFO: loaded from: classes38.dex */
public interface d extends com.ss.android.lark.todo.impl.features.center.v3.arch.a {
    TaskContainerData getCurSelectContainer();

    t7c.c getFilterSectionViewState();

    void refreshListViewState(boolean r100);

    void reloadGroupInfo();

    void updateTaskListTabCategory(TaskContainerFilter.TabFilter.TaskContainerTabCategory r100);
}
