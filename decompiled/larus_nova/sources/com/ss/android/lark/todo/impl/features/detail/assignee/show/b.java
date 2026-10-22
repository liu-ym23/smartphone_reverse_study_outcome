package com.ss.android.lark.todo.impl.features.detail.assignee.show;

import androidx.lifecycle.Observer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.todo.impl.features.detail.assignee.list.AssigneeRecycleFragment;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AssigneeBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeShowFragment f442756a;

    public b(TodoAssigneeShowFragment r100) {
        this.f442756a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        if (r101 == null) goto L32;
        AssigneeRecycleFragment r102 = (AssigneeRecycleFragment) ListProtector.get(TodoAssigneeShowFragment.S90(this.f442756a), 0);
        List r103 = r101;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        T r106 = r105.next();
        if ((true ^ ((AssigneeBean) r106).isComplete()) == false) goto L7;
        r104.add(r106);
        goto L7
    L11:
        r102.S90(r104, true);
        AssigneeRecycleFragment r107 = (AssigneeRecycleFragment) ListProtector.get(TodoAssigneeShowFragment.S90(this.f442756a), 1);
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r103.iterator();
    L13:
        if (r109.hasNext() == false) goto L17;
        T r110 = r109.next();
        if (((AssigneeBean) r110).isComplete() == false) goto L13;
        r108.add(r110);
        goto L13
    L17:
        r107.S90(r108, false);
        if (this.f442756a.T90().getTabCount() != TodoAssigneeShowFragment.S90(this.f442756a).size()) goto L31;
        this.f442756a.T90().getTabAt(0).b(((AssigneeRecycleFragment) ListProtector.get(TodoAssigneeShowFragment.S90(this.f442756a), 0)).f442667h);
        this.f442756a.T90().getTabAt(1).b(((AssigneeRecycleFragment) ListProtector.get(TodoAssigneeShowFragment.S90(this.f442756a), 1)).f442667h);
        return;
    L31:
        return;
    }
}
