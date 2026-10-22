package com.ss.android.lark.todo.impl.features.setting;

import android.view.View;
import androidx.lifecycle.Observer;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.setting.widget.TodoSwitchView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoSettingFragment f443987a;

    public i(TodoSettingFragment r100) {
        this.f443987a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        TodoSettingFragment r102 = this.f443987a;
        View r103 = r102.f443971f;
        if (r103 != null) goto L9;
        View r104 = r102.getView();
        if (r104 == null) goto L7;
        r103 = r104.findViewById(R.id.reminderSwitchView);
    L8:
        r102.f443971f = (TodoSwitchView) r103;
        goto L9
    L7:
        r103 = null;
    L9:
        Intrinsics.checkNotNull(r101);
        ((TodoSwitchView) r103).setCheckedNoEvent(r101.booleanValue());
    }
}
