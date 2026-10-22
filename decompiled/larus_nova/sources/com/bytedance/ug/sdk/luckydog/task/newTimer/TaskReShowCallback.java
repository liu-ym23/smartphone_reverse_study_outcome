package com.bytedance.ug.sdk.luckydog.task.newTimer;

import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import ym7.m;

/* JADX INFO: loaded from: classes22.dex */
public final class TaskReShowCallback implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f271958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<FrameLayout> f271959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout.LayoutParams f271960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f271961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f271962e;

    public static final class a {
    }

    static {
    }

    @Override // ym7.m
    public final void a() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskReShowCallback", "checkTaskPendantShowerIfNeeded reShowPendant");
        com.bytedance.ug.sdk.luckydog.task.pendant.f.a(new TaskReShowCallback$reShowPendant$1(this));
    }

    public TaskReShowCallback(String r100, WeakReference<FrameLayout> r101, FrameLayout.LayoutParams r102, int r103, String r104) {
        this.f271958a = r100;
        this.f271959b = r101;
        this.f271960c = r102;
        this.f271961d = r103;
        this.f271962e = r104;
    }
}
