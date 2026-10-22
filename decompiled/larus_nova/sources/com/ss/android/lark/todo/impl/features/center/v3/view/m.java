package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterSectionView f442057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map.Entry<TaskFieldType, Boolean> f442058b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FilterSectionView f442059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<TaskFieldType, Boolean> f442060b;

        public a(FilterSectionView r100, Map.Entry<TaskFieldType, Boolean> r101) {
            this.f442059a = r100;
            this.f442060b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f442059a.f441841c.handleAction(m7c.d.C6780d.f512395a, this.f442060b.getKey());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public m(FilterSectionView r100, Map.Entry<TaskFieldType, Boolean> r101) {
        this.f442057a = r100;
        this.f442058b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FilterSectionView.a(this.f442057a);
        r100.post(new a(this.f442057a, this.f442058b));
    }
}
