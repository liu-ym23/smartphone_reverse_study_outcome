package com.ss.android.lark.todo.impl.features.detail.dependent;

import android.text.Editable;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.q0;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskDependentSearchFragment f443066a;

    public b(TaskDependentSearchFragment r100) {
        this.f443066a = r100;
    }

    @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        TaskDependentSearchFragment r101 = this.f443066a;
        int r102 = TaskDependentSearchFragment.f443049j;
        TaskDependentSearchViewModel r103 = r101.W90();
        if (r100 == null) goto L6;
        String r104 = r100.toString();
        if (r104 == null) goto L6;
    L7:
        r103.searchTasks(r104);
        RecyclerView r105 = this.f443066a.V90();
        if (r105 == null) goto L10;
        r105.setVisibility(8);
    L10:
        LinearLayout r106 = this.f443066a.S90();
        if (r106 == null) goto L13;
        r106.setVisibility(8);
    L13:
        this.f443066a.X90(true);
        return;
    L6:
        r104 = "";
        goto L7
    }
}
