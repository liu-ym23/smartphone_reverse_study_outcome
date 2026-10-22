package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.bytedance.lark.pb.todo.v1.TaskContainerSection;
import com.bytedance.lark.pb.todo.v1.TaskContainerSectionItem;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f441708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ContainerType f441709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f441710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f441711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ArrayList<WeakReference<b>> f441712e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ArrayList<com.ss.android.lark.todo.impl.features.center.v3.tablayout.b> f441713f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayList<TaskContainerSection> f441714g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArrayList<TaskContainerSectionItem> f441715h = null;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a();

        void b(TaskContainer r100);

        void c();

        void d();

        void e(ContainerType r100);
    }

    static {
        f441709b = ContainerType.OWNED_BY_ME_CONTAINER;
        f441712e = new ArrayList();
        f441713f = new ArrayList();
        f441714g = new ArrayList();
        f441715h = new ArrayList();
        TodoDependencyHolder.a().accountChangeDependency().a(new a());
    }

    public static void a(ContainerType r100) {
        Intrinsics.checkNotNullParameter(r100, "containerType");
        if (f441709b != r100) goto L5;
        return;
    L5:
        f441710c = false;
        f441711d = false;
        f441708a = null;
        f441709b = r100;
        Iterator<WeakReference<b>> r101 = f441712e.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        b r102 = r101.next().get();
        if (r102 == null) goto L7;
        r102.e(r100);
        goto L7
    }

    public static void b(TaskContainer r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "taskContainer");
        if (r101 == false) goto L5;
    L7:
        f441709b = ContainerType.UNKNOWN;
        f441710c = false;
        f441711d = false;
        f441708a = r100.guid;
        Iterator<WeakReference<b>> r102 = f441712e.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        b r103 = r102.next().get();
        if (r103 == null) goto L9;
        r103.b(r100);
        goto L9
    L13:
        return;
    L5:
        if (Intrinsics.areEqual(f441708a, r100.guid) == false) goto L7;
    }

    public static void c(List r100, List r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Intrinsics.checkNotNullParameter(r101, "sections");
        Intrinsics.checkNotNullParameter(r102, "containerSectionItems");
        ArrayList<com.ss.android.lark.todo.impl.features.center.v3.tablayout.b> r103 = f441713f;
        r103.clear();
        r103.addAll(r100);
        ArrayList<TaskContainerSection> r104 = f441714g;
        r104.clear();
        r104.addAll(r101);
        ArrayList<TaskContainerSectionItem> r105 = f441715h;
        r105.clear();
        r105.addAll(r102);
        Iterator<WeakReference<b>> r106 = f441712e.iterator();
    L4:
        if (r106.hasNext() == false) goto L8;
        b r107 = r106.next().get();
        if (r107 == null) goto L4;
        r107.d();
        goto L4
    }
}
