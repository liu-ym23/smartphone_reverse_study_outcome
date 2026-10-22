package com.ss.android.lark.todo.impl.features.center.v3.tablayout;

import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f441748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FeedTabLayout f441749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CurrentGroupIndicator f441750c;

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.center.v3.tablayout.a$a, reason: collision with other inner class name */
    public static final class C5322a {
    }

    static {
    }

    public final void a() {
        FeedTabLayout r100 = this.f441749b;
        CurrentGroupIndicator r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r100 = null;
    L5:
        r100.setVisibility(4);
        CurrentGroupIndicator r102 = this.f441750c;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("groupIndicator");
    L9:
        r101.setVisibility(0);
        return;
    L8:
        r101 = r102;
        goto L9
    }

    public final void b() {
        FeedTabLayout r100 = this.f441749b;
        CurrentGroupIndicator r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r100 = null;
    L5:
        r100.setVisibility(0);
        CurrentGroupIndicator r102 = this.f441750c;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("groupIndicator");
    L9:
        r101.setVisibility(4);
        return;
    L8:
        r101 = r102;
        goto L9
    }

    public a() {
        ArrayList r100 = new ArrayList();
        ContainerType r101 = ContainerType.OWNED_BY_ME_CONTAINER;
        r100.add(new b(r101.toString(), TaskContainer.Category.OWNED_TASKS, r101));
        ContainerType r102 = ContainerType.FOLLOWED_BY_ME_CONTAINER;
        r100.add(new b(r102.toString(), TaskContainer.Category.FOLLOWED_TASKS, r102));
        this.f441748a = r100;
    }
}
