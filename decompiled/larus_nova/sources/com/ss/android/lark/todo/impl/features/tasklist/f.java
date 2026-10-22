package com.ss.android.lark.todo.impl.features.tasklist;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListNameFragment f444106a;

    public f(TaskListNameFragment r100) {
        this.f444106a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        TaskContainer r101 = (TaskContainer) r100;
        KeyboardUtils.hideKeyboard(this.f444106a.getContext());
        this.f444106a.f444012i.dismiss();
        if (r101 == null) goto L5;
        TaskListNameFragment r102 = this.f444106a;
        Bundle r103 = new Bundle();
        r103.putByteArray("result.task.list.container", TaskContainer.ADAPTER.encode(r101));
        zab.a.b(r102, -1, r103);
        return;
    L5:
        zab.a.a(this.f444106a);
    }
}
