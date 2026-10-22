package com.ss.android.lark.todo.impl.features.detail.sections;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a1 implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SummaryInlineSection f443330a;

    public a1(SummaryInlineSection r100) {
        this.f443330a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 == 5) goto L8;
        if (r102 != null) goto L6;
        return true;
    L6:
        if (r102.getKeyCode() == 66) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(StringsKt.trim(this.f443330a.f443260d.getText())) == true) goto L14;
        com.larksuite.framework.section.utils.d.a((com.larksuite.framework.section.utils.d) this.f443330a.f443261e.getValue(), com.ss.android.lark.todo.impl.features.detail.viewmodel.a.c2.f443677a);
        return true;
    L14:
        return true;
    }
}
