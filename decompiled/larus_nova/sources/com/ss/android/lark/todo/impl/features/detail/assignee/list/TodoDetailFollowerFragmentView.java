package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.p;
import com.ss.android.lark.ui.CommonTitleBar;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoDetailFollowerFragmentView extends com.larksuite.framework.section.h<p> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f442688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larksuite.framework.section.e<p> f442689c;

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        p r100 = e();
        k(r100.getFollowerFragmentShowAdd(), new TodoDetailFollowerFragmentView$initViewObserver$1$1(this));
        k(r100.getFollowers(), new TodoDetailFollowerFragmentView$initViewObserver$1$2(this));
        ((CommonTitleBar) this.f442688b.findViewById(R.id.title_bar)).setLeftClickListener(new l(this));
        List<com.ss.android.lark.todo.impl.features.detail.viewmodel.i> r101 = e().getFollowers().getValue();
        if (r101 == null) goto L5;
        int r102 = r101.size();
    L6:
        n(r102);
        this.f442688b.findViewById(R.id.text_button_add).setOnClickListener(new k(this));
        LinearLayoutManager r103 = new LinearLayoutManager(getContext());
        r103.setOrientation(1);
        ((RecyclerView) this.f442688b.findViewById(R.id.assignee_list)).setLayoutManager(r103);
        ((RecyclerView) this.f442688b.findViewById(R.id.assignee_list)).setAdapter(new TodoFollowerAdapter(this.f442689c));
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void n(int r100) {
        if (r100 <= 0) goto L5;
        ((TextView) this.f442688b.findViewById(R.id.text_title)).setText(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_Follower) + " (" + r100 + ')');
        return;
    L5:
        ((TextView) this.f442688b.findViewById(R.id.text_title)).setText(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_Follower));
    }

    public TodoDetailFollowerFragmentView(View r100, com.larksuite.framework.section.e<p> r101) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "ability");
        super(r101);
        this.f442688b = r100;
        this.f442689c = r101;
    }
}
