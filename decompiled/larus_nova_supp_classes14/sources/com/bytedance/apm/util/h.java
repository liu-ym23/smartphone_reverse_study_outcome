package com.bytedance.apm.util;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.d;
import ff7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements c {
    public h() {
    }

    public final void onActivityCreated(Activity r1, Bundle r2) {
    }

    public final void onActivityPause(Activity r1) {
    }

    public final void onActivityResume(Activity r1) {
    }

    public final void onActivityStarted(Activity r1) {
    }

    public final void onBackground(Activity r1) {
    }

    public final void onChange(Activity r1, Fragment r2) {
    }

    public final void onFront(Activity r3) {
        if (Build.VERSION.SDK_INT < 23) goto L14;
        float r4 = r3.getWindowManager().getDefaultDisplay().getRefreshRate();
        i.e = i.a(r4);
        if (d.t == false) goto L15;
        int r5 = i.a(r4);
        i.b = r5;
        if (r5 != i.c) goto L11;
        boolean r0 = true;
    L12:
        i.d = r0;
        i.a = 1000.0f / r5;
        return;
    L11:
        r0 = false;
        goto L12
    L15:
        return;
    }
}
