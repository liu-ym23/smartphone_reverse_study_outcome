package q7c;

import com.ss.android.lark.todo.impl.features.center.v3.data.TaskContainerData;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.SimpleSubTodoData;

/* JADX INFO: loaded from: classes38.dex */
public interface c extends com.ss.android.lark.todo.impl.features.center.v3.arch.a {
    t7c.b getCreateViewState();

    TaskContainerData getCurSelectContainer();

    void goCreateTaskListActivity();

    void goCreateTodoActivity(String r100, String r101, String r102, SimpleSubTodoData r103, boolean r104);

    boolean isSelectTaskListMange();
}
