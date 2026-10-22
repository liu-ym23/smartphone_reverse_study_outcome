package com.bytedance.ee.bear.bitable.card.view.cell.link;

import android.os.Build;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class n0 implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkRecordAdapter f207764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkRecordAdapter.ViewHolder f207765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ cp4.a f207766c;

    public n0(LinkRecordAdapter r100, LinkRecordAdapter.ViewHolder r101, cp4.a r102) {
        this.f207764a = r100;
        this.f207765b = r101;
        this.f207766c = r102;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        LinkRecordAdapter r101 = this.f207764a;
        if (r101.f207723f == false) goto L7;
        Intrinsics.checkNotNull(r100);
        View r102 = this.f207765b.f207727b;
        String r103 = this.f207766c.f464635b;
        r101.getClass();
        if (Build.VERSION.SDK_INT < 23) goto L7;
        r101.f207725h = r100.startActionMode(new o0(r100, r102, r101, r103), 1);
    L7:
        return true;
    }
}
