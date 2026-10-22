package q7c;

import com.bytedance.lark.pb.todo.v1.TaskContainerSection;
import com.bytedance.lark.pb.todo.v1.TaskContainerSectionItem;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskContainerData;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskSectionData;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public interface a extends com.ss.android.lark.todo.impl.features.center.v3.arch.a {
    void archiveTaskList();

    void deleteTaskList(boolean r100);

    HashMap<String, Todo> getCenterTodoMap();

    Boolean getContainerMetaDataSuccess();

    ArrayList<TaskContainerSectionItem> getContainerSectionItems();

    ArrayList<TaskContainerSection> getContainerSections();

    t7c.a getContainerTabViewState();

    ArrayList<TaskContainerData> getContainers();

    TaskContainerData getCurSelectContainer();

    Map<TaskFieldType, ArrayList<TaskSectionData>> getSectionsMap();

    void goTaskListCreateActivity();

    void goTaskListEventsActivity(String r100);

    Boolean isContainerSuccess();

    Boolean isTodoSuccess();

    void loadTaskListMembers();

    void refreshContainerTabViewState();

    void refreshFilterSectionViewState();

    void refreshListViewState();

    void refreshLoadingStatus();

    void renameTaskList();

    void selectAllTaskEvents();

    void selectTaskListArchiveView(boolean r100);

    void selectTaskListManage();

    void setContainerSuccess(Boolean r100);

    void setCurSelectContainer(TaskContainerData r100);

    void setFilterSectionShow(boolean r100);

    void setTodoSuccess(Boolean r100);

    void showTaskListMenu();
}
