package com.ss.android.lark.todo.impl.features.center.v3.view;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.todo.impl.features.center.v3.data.SectionHeaderItem;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskItem;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.SimpleSubTodoData;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class u0 implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListAdapter f442124a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskListAdapter f442125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f442126b;

        public a(TaskListAdapter r100, int r101) {
            this.f442125a = r100;
            this.f442126b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f442125a.notifyItemChanged(this.f442126b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void p() {
        TaskListAdapter r100 = this.f442124a;
        r100.f441947b.p(r100.f441951f);
    }

    public u0(TaskListAdapter r100) {
        this.f442124a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        this.f442124a.f441947b.a(r100);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        this.f442124a.f441947b.c(r100);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        this.f442124a.f441947b.h(r100);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        this.f442124a.f441947b.i(r100);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        this.f442124a.f441947b.k(r100);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        this.f442124a.f441947b.l(r100);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void o(TaskItemViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Iterator<T> r101 = this.f442124a.f441951f.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((SectionHeaderItem) r101.next()).f441454t = false;
        goto L4
    L6:
        this.f442124a.f441947b.o(r100, r100.f441932i);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f442124a.f441947b.b(r100, r101);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "digest");
        this.f442124a.f441947b.d(r100, r101);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f442124a.f441947b.e(r100, r101);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void f(String r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        this.f442124a.f441947b.f(r100, r101);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void g(String r100, SimpleSubTodoData r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionGuid");
        this.f442124a.f441947b.g(r100, r101);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void m(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        this.f442124a.f441947b.m(r100, r101);
        Integer r102 = this.f442124a.f441952g.get(r100);
        if (r102 == null) goto L19;
        r102.intValue();
        if (r102.intValue() < this.f442124a.f441951f.size()) goto L7;
        return;
    L7:
        SectionHeaderItem r103 = (SectionHeaderItem) ListProtector.get(this.f442124a.f441951f, r102.intValue());
        r103.f441442h = r101;
        TaskListAdapter r104 = this.f442124a;
        r104.f441950e = TaskListAdapter.A2(r104.f441951f, r104.f441952g, r104.f441953h);
        Iterator<com.ss.android.lark.todo.impl.features.center.v3.data.a> r105 = this.f442124a.f441950e.iterator();
        int r106 = 0;
    L9:
        if (r105.hasNext() == false) goto L14;
        if (Intrinsics.areEqual(r105.next(), r103) == true) goto L15;
        r106 = r106 + 1;
    L15:
        TaskListAdapter r107 = this.f442124a;
        r107.f441949d.submitList(r107.f441950e, new a(r107, r106));
        return;
    L14:
        r106 = -1;
        goto L15
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void n(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f442124a.f441947b.n(r100, r101);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.t
    public final void j(String r100, TaskItem.CompleteType r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "completeType");
        this.f442124a.f441947b.j(r100, r101, r102);
    }
}
