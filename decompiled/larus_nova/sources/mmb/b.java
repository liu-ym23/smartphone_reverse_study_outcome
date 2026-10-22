package mmb;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.lark.dependency.k0;
import com.ss.android.lark.todo_api.ITodoApi;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements k0 {
    public b() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.k0
    public final void c(Fragment r100, int r101) {
        ((ITodoApi) LarkContext.spiByDwarf(ITodoApi.class)).startTodoAddAssigneeActivity(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.k0
    public final void a(Fragment r100, String r101, int r102) {
        ((ITodoApi) LarkContext.spiByDwarf(ITodoApi.class)).startTodoCreateActivity(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.k0
    public final void b(Fragment r100, String r101, int r102) {
        ((ITodoApi) LarkContext.spiByDwarf(ITodoApi.class)).startTodoDisplayAssigneeActivity(r100, r101, r102);
    }
}
