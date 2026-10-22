package com.bytedance.ee.larkwebview.quality.safe.permission;

import android.content.Intent;

/* JADX INFO: loaded from: classes19.dex */
public interface b {

    public interface a {
        void a(int r100, int r101, Intent r102);
    }

    /* JADX INFO: renamed from: com.bytedance.ee.larkwebview.quality.safe.permission.b$b, reason: collision with other inner class name */
    public interface InterfaceC3481b {
    }

    void requestPermissions(String[] r100, InterfaceC3481b r101);

    void startActivityForResult(Intent r100, int r101, a r102);
}
