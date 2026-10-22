package com.ss.android.lark.todo.impl.features.setting;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoSettingFragment f443988a;

    public j(TodoSettingFragment r100) {
        this.f443988a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        TodoSettingFragment r102 = this.f443988a;
        View r103 = r102.f443973h;
        if (r103 != null) goto L9;
        View r104 = r102.getView();
        if (r104 == null) goto L7;
        r103 = r104.findViewById(R.id.tv_reminder_time);
    L8:
        r102.f443973h = (TextView) r103;
        goto L9
    L7:
        r103 = null;
    L9:
        ((TextView) r103).setText(r101);
    }
}
