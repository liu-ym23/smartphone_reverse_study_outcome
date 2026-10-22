package com.ss.android.lark.officewebview.quality.safe.permission;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f437503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.a f437504b;

    public a() {
        this.f437503a = -1;
    }

    public void startActivityForResult(Fragment r100, Intent r101, int r102, b.a r103) {
        this.f437504b = r103;
        this.f437503a = r102;
        r100.startActivityForResult(r101, r102);
    }
}
