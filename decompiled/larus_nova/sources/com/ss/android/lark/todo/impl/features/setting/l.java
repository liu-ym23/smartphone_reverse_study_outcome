package com.ss.android.lark.todo.impl.features.setting;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoSettingFragment f443990a;

    public l(TodoSettingFragment r100) {
        this.f443990a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        TodoSettingFragment r102 = this.f443990a;
        View r103 = r102.f443974i;
        if (r103 != null) goto L9;
        View r104 = r102.getView();
        if (r104 == null) goto L7;
        r103 = r104.findViewById(R.id.tv_badge_setting);
    L8:
        r102.f443974i = (TextView) r103;
        goto L9
    L7:
        r103 = null;
    L9:
        Intrinsics.checkNotNull(r101);
        ((TextView) r103).setText(r101.intValue());
    }
}
