package com.ss.android.lark.todo.impl.features.detail.time;

import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;
import com.ss.android.lark.todo.databinding.TodoDetailTimeFragmentBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f443568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoTimePickerFragment f443569b;

    public m(TodoTimePickerFragment r100) {
        this.f443569b = r100;
        this.f443568a = -1;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
    public final void onItemSelected(int r100) {
        TodoDetailTimeFragmentBinding r101 = this.f443569b.f443521d;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L6:
        if (r101.f441350o.getVisibility() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return;
    L11:
        if (this.f443568a != r100) goto L13;
        return;
    L13:
        this.f443569b.V90();
        this.f443568a = r100;
        this.f443569b.aa0();
        return;
    L8:
        r102 = false;
        goto L9
    }
}
