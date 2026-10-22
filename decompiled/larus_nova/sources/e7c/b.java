package e7c;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.todo.impl.features.detail.assignee.display.AssigneeBaseMeta;
import com.ss.android.lark.todo.impl.features.detail.create.CreateTodoDocxParams;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface b extends a {
    void a(Fragment r100, CreateTodoDocxParams r101, int r102);

    void b(Fragment r100, List<AssigneeBaseMeta> r101, boolean r102, int r103);

    void c(Context r100);

    void e(Context r100, String r101, String r102, String r103, boolean r104);

    void f(Fragment r100, List<String> r101, boolean r102, int r103);

    String getPageName();

    void h(Fragment r100, int r101);

    void startTodoSettingActivity(Activity r100);
}
