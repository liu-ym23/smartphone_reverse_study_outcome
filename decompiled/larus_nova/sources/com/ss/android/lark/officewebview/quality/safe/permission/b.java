package com.ss.android.lark.officewebview.quality.safe.permission;

import android.content.Intent;

/* JADX INFO: loaded from: classes37.dex */
public interface b {

    public interface a {
        void a(int r100, int r101, Intent r102);
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officewebview.quality.safe.permission.b$b, reason: collision with other inner class name */
    public interface InterfaceC5222b {
        void a(String[] r100, int[] r101);
    }

    void requestPermissions(String[] r100, InterfaceC5222b r101);

    void startActivityForResult(Intent r100, int r101, a r102);
}
