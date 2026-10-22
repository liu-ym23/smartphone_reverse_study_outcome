package com.ss.android.lark.todo.impl.features.detail;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.widget.KeyboardScrollView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements KeyboardScrollView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoKeyboardFragment f443108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f443109b;

    @Override // com.ss.android.lark.todo.impl.features.detail.widget.KeyboardScrollView.a
    public final void a(KeyboardScrollView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        TodoKeyboardFragment r101 = this.f443108a;
        View r102 = r101.f442554k;
        if (r102 != null) goto L9;
        View r103 = r101.getView();
        if (r103 == null) goto L7;
        r102 = r103.findViewById(R.id.shader);
    L8:
        r101.f442554k = r102;
        goto L9
    L7:
        r102 = null;
    L9:
        boolean r104 = false;
        if ((r100.getChildAt(0).getMeasuredWidth() - this.f443109b.element) <= (r100.getScrollX() + r100.getWidth())) goto L12;
        r104 = true;
    L12:
        com.larksuite.framework.section.utils.a.d(r102, r104);
    }

    public g(TodoKeyboardFragment r100, Ref.IntRef r101) {
        this.f443108a = r100;
        this.f443109b = r101;
    }
}
