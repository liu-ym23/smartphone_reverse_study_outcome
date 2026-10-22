package com.bytedance.ee.larkwebview.quality.safe.permission;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f242933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.a f242934b;

    public a() {
        this.f242933a = -1;
    }

    public void startActivityForResult(Fragment r100, Intent r101, int r102, b.a r103) {
        this.f242934b = r103;
        this.f242933a = r102;
        r100.startActivityForResult(r101, r102);
    }
}
