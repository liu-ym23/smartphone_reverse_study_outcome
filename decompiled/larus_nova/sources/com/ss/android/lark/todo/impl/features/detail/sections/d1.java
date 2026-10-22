package com.ss.android.lark.todo.impl.features.detail.sections;

import android.text.Editable;
import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class d1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SummaryInlineSection f443351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f443352b;

    public d1(SummaryInlineSection r100, EditText r101) {
        this.f443351a = r100;
        this.f443352b = r101;
    }

    public final void a() {
        com.larksuite.framework.section.c r100 = this.f443351a.b();
        com.ss.android.lark.todo.impl.features.detail.viewmodel.a.j3 r101 = com.ss.android.lark.todo.impl.features.detail.viewmodel.a.j3.f443720a;
        Editable r102 = this.f443352b.getText();
        if (r102 == null) goto L9;
        String r103 = r102.toString();
        if (r103 == null) goto L9;
        String r104 = StringsKt.trim(r103).toString();
        if (r104 == null) goto L9;
        int r105 = r104.length();
    L10:
        r100.f(r101, r105);
        this.f443351a.b().d(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.k3.f443726a, com.ss.android.lark.todo.impl.features.common.richtext2.b.a(this.f443352b));
        SummaryInlineSection r106 = this.f443351a;
        boolean r107 = r106.f443262f;
        r106.f443262f = false;
        return;
    L9:
        r105 = 0;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
