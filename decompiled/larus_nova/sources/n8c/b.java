package n8c;

import android.view.View;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.guide.GuideDialog;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GuideDialog f518382a;

    public b(GuideDialog r100) {
        this.f518382a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TodoDependencyHolder.a().mainModuleDependency().g(this.f518382a.getContext());
    }
}
