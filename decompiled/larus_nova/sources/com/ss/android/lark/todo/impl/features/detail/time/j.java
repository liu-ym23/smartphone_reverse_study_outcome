package com.ss.android.lark.todo.impl.features.detail.time;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;
import com.ss.android.lark.todo.databinding.TodoDetailTimeFragmentBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f443562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoTimePickerFragment f443563b;

    public j(TodoTimePickerFragment r100) {
        this.f443563b = r100;
        this.f443562a = -1;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
    public final void onItemSelected(int r100) {
        TodoDetailTimeFragmentBinding r101 = this.f443563b.f443521d;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L6:
        if (r101.f441349n.getVisibility() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L18;
        int r103 = this.f443562a;
        Integer r104 = (Integer) ListProtector.get(this.f443563b.W90().f443548c, r100);
        if (r104 != null) goto L14;
    L16:
        TodoTimePickerFragment r105 = this.f443563b;
        r105.f443541x = ((Number) ListProtector.get(r105.W90().f443548c, r100)).intValue();
        TodoTimePickerFragment r106 = this.f443563b;
        this.f443562a = r106.f443541x;
        r106.aa0();
        return;
    L14:
        if (r103 != r104.intValue()) goto L16;
        return;
    L18:
        return;
    L8:
        r102 = false;
        goto L9
    }
}
