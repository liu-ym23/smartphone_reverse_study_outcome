package q7c;

import com.bytedance.lark.pb.todo.v1.TaskContainerRef;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskContainerData;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.TimeBean;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.SimpleSubTodoData;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes38.dex */
public interface e extends com.ss.android.lark.todo.impl.features.center.v3.arch.a {
    void archiveTaskList();

    TaskContainerData getCurSelectContainer();

    t7c.d getListViewState();

    Todo getTodo(String r100);

    void goCreateTodoActivity(String r100, String r101, String r102, SimpleSubTodoData r103, boolean r104);

    void goOwnerPickerActivity(String r100, TodoAssignee r101);

    void goShareActivity(String r100, String r101);

    void goTimePickerActivity(TimeBean r100, String r101);

    void refreshListViewStateOnTime();

    void reloadList();

    void reviseDefinedSectionData(CopyOnWriteArrayList<TaskSection> r100);

    void scrollPositionTaskGuid(String r100);

    void updateTaskContainerRef(CopyOnWriteArrayList<TaskContainerRef> r100);

    void updateTodo(List<Todo> r100, boolean r101);
}
