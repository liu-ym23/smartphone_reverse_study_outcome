package com.ss.android.lark.todo.impl.features.detail.time;

import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;
import com.ss.android.lark.todo.databinding.TodoDetailTimeFragmentBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f443564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoTimePickerFragment f443565b;

    public k(TodoTimePickerFragment r100) {
        this.f443565b = r100;
        this.f443564a = -1;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
    public final void onItemSelected(int r100) {
        TodoDetailTimeFragmentBinding r101 = this.f443565b.f443521d;
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
        if (this.f443564a != r100) goto L13;
        return;
    L13:
        this.f443565b.V90();
        this.f443564a = r100;
        this.f443565b.aa0();
        return;
    L8:
        r102 = false;
        goto L9
    }
}
