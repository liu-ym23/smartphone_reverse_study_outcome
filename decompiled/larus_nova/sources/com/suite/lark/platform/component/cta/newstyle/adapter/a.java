package com.suite.lark.platform.component.cta.newstyle.adapter;

import android.view.ViewGroup;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VersionInfoAdapter.VersionViewHolder f460556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VersionInfoAdapter f460557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f460558c;

    public a(VersionInfoAdapter.VersionViewHolder r100, VersionInfoAdapter r101, int r102) {
        this.f460556a = r100;
        this.f460557b = r101;
        this.f460558c = r102;
    }

    public final void a() {
        float r100 = (this.f460556a.f460553e.getMeasuredHeight() - this.f460556a.f460551c.getMeasuredHeight()) / 2.0f;
        float r101 = UIUtils.dp2px(this.f460557b.getContext(), 18.0f) - r100;
        float r102 = UIUtils.dp2px(this.f460557b.getContext(), 24.0f) - (2 * r100);
        int r103 = UIUtils.dp2px(this.f460557b.getContext(), 18.0f);
        ViewGroup.LayoutParams r104 = this.f460556a.f460555g.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        int r106 = this.f460558c;
        if (r106 != 0) goto L6;
        r105.setMargins(r103, (int) r101, r103, (int) r102);
    L9:
        this.f460556a.f460555g.setLayoutParams(r105);
        return;
    L6:
        if (r106 != (this.f460557b.getItemCount() - 1)) goto L8;
        r105.setMargins(r103, 0, r103, (int) r101);
        goto L9
    L8:
        r105.setMargins(r103, 0, r103, (int) r102);
        goto L9
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
