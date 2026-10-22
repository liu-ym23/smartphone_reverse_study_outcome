package i7c;

import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapController;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.adapterhelper.loadmodule.PageLoadingStatus;
import com.ss.android.lark.todo.impl.adapterhelper.viewholder.TaskBaseViewHolder;
import j7c.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C6237a f488525a;

    /* JADX INFO: renamed from: i7c.a$a, reason: collision with other inner class name */
    public static final class C6237a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f488526a;

        public C6237a(a r100) {
            this.f488526a = r100;
        }
    }

    public abstract int a(int r100);

    public abstract void d(TaskBaseViewHolder r100);

    public abstract TaskBaseViewHolder f(ViewGroup r100, int r101);

    public a() {
        this.f488525a = new C6237a(this);
    }

    public final int b(int r100) {
        if (r100 != 0) goto L5;
        return R.layout.task_default_empty_view;
    L5:
        return a(r100);
    }

    public void c(TaskBaseViewHolder r100, MultiItemEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        r100.T3(r101);
    }

    public void e(TaskBaseViewHolder r100, PageLoadingStatus r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Intrinsics.checkNotNullParameter(r101, "pageLoadingStatus");
        this.f488525a.getClass();
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "loadMoreStatus");
        int r102 = e.a.f497664a[r101.ordinal()];
        if (r102 != 1) goto L5;
        Intrinsics.checkNotNullParameter(r100, "holder");
        e.a(r100.getView(R.id.load_more_loading_view), true);
        Intrinsics.checkNotNullParameter(r100, "holder");
        e.a(r100.getView(R.id.load_more_load_fail_view), false);
        return;
    L5:
        if (r102 != 2) goto L7;
        Intrinsics.checkNotNullParameter(r100, "holder");
        e.a(r100.getView(R.id.load_more_loading_view), false);
        Intrinsics.checkNotNullParameter(r100, "holder");
        e.a(r100.getView(R.id.load_more_load_fail_view), true);
        return;
    L7:
        if (r102 != 3) goto L15;
        Intrinsics.checkNotNullParameter(r100, "holder");
        e.a(r100.getView(R.id.load_more_loading_view), false);
        Intrinsics.checkNotNullParameter(r100, "holder");
        e.a(r100.getView(R.id.load_more_load_fail_view), false);
        return;
    }
}
