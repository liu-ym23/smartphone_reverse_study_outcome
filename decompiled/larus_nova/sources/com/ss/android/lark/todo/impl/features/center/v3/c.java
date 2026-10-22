package com.ss.android.lark.todo.impl.features.center.v3;

import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.center.v3.view.TaskListAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f441423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f441424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f441425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f441426d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f441427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f441428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinearSmoothScroller f441429c;

        public b(c r100, String r101, LinearSmoothScroller r102) {
            this.f441427a = r100;
            this.f441428b = r101;
            this.f441429c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f441427a.b(this.f441428b, this.f441429c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.center.v3.c$c, reason: collision with other inner class name */
    public static final class RunnableC5318c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinearLayoutManager f441430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinearSmoothScroller f441431b;

        public RunnableC5318c(LinearLayoutManager r100, LinearSmoothScroller r101) {
            this.f441430a = r100;
            this.f441431b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f441430a.startSmoothScroll(this.f441431b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f441432a;

        public d(c r100) {
            this.f441432a = r100;
        }

        public final void a() {
            c r100 = this.f441432a;
            int r101 = 0;
            if (r100.f441425c.length() != 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L30;
            RecyclerView.Adapter r103 = r100.f441423a.getAdapter();
            if (r103 == null) goto L11;
            Integer r104 = Integer.valueOf(r103.getItemCount());
        L12:
            if (r104 == null) goto L23;
            r104.intValue();
            int r105 = r104.intValue();
        L14:
            if (r101 >= r105) goto L31;
            RecyclerView.ViewHolder r106 = r100.f441423a.findViewHolderForAdapterPosition(r101);
            if ((r106 instanceof TaskListAdapter.ShineViewHolder) == false) goto L22;
            TaskListAdapter.ShineViewHolder r107 = (TaskListAdapter.ShineViewHolder) r106;
            if (Intrinsics.areEqual(r107.V3(), r100.f441425c) == false) goto L22;
            Drawable r108 = com.ss.android.lark.todo.impl.utils.i.f444291a.c(R.drawable.todo_bg_list_item_corner_shine);
            if (r108 == null) goto L22;
            r107.W3(r108, true);
            r107.X3("");
            r100.f441424b = true;
            return;
        L22:
            r101 = r101 + 1;
            goto L14
        L31:
            return;
        L23:
            return;
        L11:
            r104 = null;
            goto L12
        L30:
            return;
        L5:
            r102 = false;
            goto L6
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

    static {
    }

    public final void a() {
        if (this.f441424b == true) goto L5;
        return;
    L5:
        RecyclerView.Adapter r100 = this.f441423a.getAdapter();
        if (r100 == null) goto L8;
        Integer r101 = Integer.valueOf(r100.getItemCount());
    L9:
        if (r101 == null) goto L25;
        r101.intValue();
        int r102 = r101.intValue();
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L19;
        RecyclerView.ViewHolder r104 = this.f441423a.findViewHolderForAdapterPosition(r103);
        if ((r104 instanceof TaskListAdapter.ShineViewHolder) == false) goto L18;
        Drawable r105 = com.ss.android.lark.todo.impl.utils.i.f444291a.c(R.drawable.bg_setting_group_item_rectangle);
        if (r105 == null) goto L18;
        TaskListAdapter.ShineViewHolder r106 = (TaskListAdapter.ShineViewHolder) r104;
        r106.W3(r105, false);
        r106.X3("");
    L18:
        r103 = r103 + 1;
        goto L12
    L19:
        this.f441424b = false;
        this.f441425c = "";
        return;
    L25:
        return;
    L8:
        r101 = null;
        goto L9
    }

    public c(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f441423a = r100;
        this.f441425c = "";
    }

    public final void b(String r100, LinearSmoothScroller r101) {
        Object r102 = this.f441423a.getAdapter();
        if ((r102 instanceof com.ss.android.lark.todo.impl.features.center.v3.view.a) == false) goto L5;
        com.ss.android.lark.todo.impl.features.center.v3.view.a r103 = (com.ss.android.lark.todo.impl.features.center.v3.view.a) r102;
    L7:
        if (r103 != null) goto L9;
    L20:
        int r104 = -1;
    L22:
        if (r104 != (-1)) goto L27;
        int r105 = this.f441426d;
        this.f441426d = r105 + 1;
        if (r105 <= 5) goto L26;
        return;
    L26:
        this.f441423a.postDelayed(new b(this, r100, r101), 250);
        return;
    L27:
        LinearLayoutManager r106 = (LinearLayoutManager) this.f441423a.getLayoutManager();
        if (r106 != null) goto L30;
        return;
    L30:
        int r107 = r106.findFirstVisibleItemPosition();
        int r108 = r106.findLastVisibleItemPosition();
        if (r104 >= (r107 - 1)) goto L34;
        r106.scrollToPosition(r104 + 1);
    L36:
        r101.setTargetPosition(r104);
        this.f441423a.post(new RunnableC5318c(r106, r101));
        this.f441423a.postDelayed(new d(this), 250);
        return;
    L34:
        if (r104 <= (r108 + 1)) goto L36;
        r106.scrollToPosition(r104 - 1);
        goto L36
    L9:
        if (r103.G() == null) goto L20;
        List<?> r109 = r103.G();
        Intrinsics.checkNotNull(r109);
        Iterator<T> r110 = r109.iterator();
        r104 = 0;
    L13:
        if (r110.hasNext() == false) goto L20;
        int r111 = r104 + 1;
        Object r112 = r110.next();
        if ((r112 instanceof com.ss.android.lark.todo.impl.features.center.v3.data.b) == false) goto L19;
        if (Intrinsics.areEqual(((com.ss.android.lark.todo.impl.features.center.v3.data.b) r112).e(), r100) == true) goto L22;
    L19:
        r104 = r111;
        goto L13
    L5:
        r103 = null;
        goto L7
    }
}
