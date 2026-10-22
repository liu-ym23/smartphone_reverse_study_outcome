package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.TaskCompleteStatusFieldFilterValue;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterSectionView f442043a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FilterSectionView f442044a;

        public a(FilterSectionView r100) {
            this.f442044a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f442044a.f441841c.handleAction(m7c.d.a.f512392a, TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.ALL);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public j(FilterSectionView r100) {
        this.f442043a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FilterSectionView.a(this.f442043a);
        r100.post(new a(this.f442043a));
    }
}
