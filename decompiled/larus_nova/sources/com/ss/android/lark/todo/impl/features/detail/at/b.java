package com.ss.android.lark.todo.impl.features.detail.at;

import android.widget.EditText;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.todo.impl.features.detail.at.view.TodoAtView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements TodoAtView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAtController f442779a;

    public b(TodoAtController r100) {
        this.f442779a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.at.view.TodoAtView.b
    public final void a(boolean r100) {
        TodoAtController.b r101 = this.f442779a.f442760c;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.at.view.TodoAtView.b
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
        TodoAtController r102 = this.f442779a;
        EditText r103 = r102.f442764g;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r102.f442767j == null) goto L9;
        int r104 = r103.getSelectionEnd();
        if (r104 <= r102.f442767j.length()) goto L9;
        r103.getEditableText().delete((r104 - r102.f442767j.length()) - 1, r104);
    L9:
        TodoAtController.b r105 = r102.f442760c;
        if (r105 == null) goto L14;
        r105.c(r100, r101);
        return;
    }
}
