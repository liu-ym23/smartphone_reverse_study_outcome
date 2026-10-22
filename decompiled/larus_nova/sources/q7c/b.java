package q7c;

import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskContainerData;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes38.dex */
public interface b extends com.ss.android.lark.todo.impl.features.center.v3.arch.a {
    t7c.a getContainerTabViewState();

    TaskContainerData getCurSelectContainer();

    String getPositionedTaskGuid();

    LinkedHashMap<String, com.ss.android.lark.todo.impl.features.center.v3.data.f> getTaskListTodoMap();

    void goRenameTaskListActivity(TaskContainer r100, String r101, String r102);

    void goTaskListEventsActivity(String r100);

    void refreshContainerTabViewState();

    void refreshCreateViewState();

    void refreshFilterSectionViewState();

    void refreshListViewState();

    void refreshLoadingStatus();

    void reloadContainerMetaData();

    void setContainerMetaDataSuccess(Boolean r100);

    void setCurSelectContainer(TaskContainerData r100);

    void setFilterSectionShow(boolean r100);

    void setGroupInfoSuccess(Boolean r100);

    void setTaskListTodoMap(LinkedHashMap<String, com.ss.android.lark.todo.impl.features.center.v3.data.f> r100);

    void toastChangedToEditPermission();

    void toastChangedToReadPermission();

    void toastError(int r100);

    void toastSuccess(int r100);
}
