package com.bytedance.ee.bear.doc.codeblock;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Runnable {
    public final /* synthetic */ CodeLanguageSelectionFragment a;
    public final /* synthetic */ CodeLanguageData b;

    public b(CodeLanguageSelectionFragment r1, CodeLanguageData r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        RecyclerView r0 = this.a.h;
        LinearLayoutManager r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r0 = null;
    L5:
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
        if ((r2 instanceof LinearLayoutManager) == false) goto L8;
        r1 = (LinearLayoutManager) r2;
    L8:
        if (r1 == null) goto L17;
        CodeLanguageData r3 = this.b;
        if (r3 == null) goto L14;
        List<String> r4 = r3.getList();
        if (r4 == null) goto L14;
        int r5 = CollectionsKt.indexOf(r4, this.b.getValue());
    L15:
        r1.scrollToPositionWithOffset(r5, this.a.getResources().getDimensionPixelSize(2131165643) * 2);
        return;
    L14:
        r5 = 0;
        goto L15
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
