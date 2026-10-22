package com.ss.android.lark.todo.impl.features.detail.at.view;

import androidx.lifecycle.Observer;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.ss.android.lark.todo.impl.features.detail.at.view.adapter.AtSelectAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAtView f442821a;

    public h(TodoAtView r100) {
        this.f442821a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        GetAnotherNameFormatResponse.FormatRule r101 = (GetAnotherNameFormatResponse.FormatRule) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        TodoAtView r102 = this.f442821a;
        if (r101 != GetAnotherNameFormatResponse.FormatRule.UNKNOWN) goto L5;
        r101 = GetAnotherNameFormatResponse.FormatRule.NAME_FIRST;
    L5:
        r102.f442795j = r101;
        AtSelectAdapter r103 = r102.f442794i;
        if (r103 == null) goto L9;
        r103.notifyDataSetChanged();
        return;
    }
}
