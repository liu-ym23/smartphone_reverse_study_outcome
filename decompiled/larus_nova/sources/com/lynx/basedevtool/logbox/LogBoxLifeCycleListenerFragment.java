package com.lynx.basedevtool.logbox;

import a5a.b;
import a5a.l;
import a5a.m;
import a5a.n;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;

/* JADX INFO: loaded from: classes32.dex */
public class LogBoxLifeCycleListenerFragment extends Fragment {
    @Override // android.app.Fragment
    public final void onDestroy() {
        Activity r100 = getActivity();
        n r101 = n.a.f1906a;
        if (r100 != null) goto L5;
        r101.getClass();
        l r102 = null;
    L6:
        if (r102 == null) goto L16;
        b r103 = r102.f1887d;
        if (r103 == null) goto L10;
        l.a(r103);
        r102.f1887d = null;
    L10:
        m r104 = r102.f1886c;
        if (r104 == null) goto L16;
        Dialog r105 = r104.f1896e;
        if (r105 == null) goto L15;
        m.a(r105);
        r104.f1896e = null;
    L15:
        r102.f1886c = null;
    L16:
        super.onDestroy();
        return;
    L5:
        r102 = r101.f1905a.get(r100);
        goto L6
    }

    public LogBoxLifeCycleListenerFragment() {
    }
}
