package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterSectionView f442046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskFieldType f442047b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FilterSectionView f442048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskFieldType f442049b;

        public a(FilterSectionView r100, TaskFieldType r101) {
            this.f442048a = r100;
            this.f442049b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f442048a.f441841c.handleAction(m7c.d.b.f512393a, this.f442049b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public k(FilterSectionView r100, TaskFieldType r101) {
        this.f442046a = r100;
        this.f442047b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FilterSectionView.a(this.f442046a);
        r100.post(new a(this.f442046a, this.f442047b));
    }
}
