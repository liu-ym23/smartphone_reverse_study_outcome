package com.bytedance.ee.bear.document.orientation;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public final DocumentPluginHost a;

    public static final class a {
    }

    static {
    }

    public final int a() {
        tt5.a.h("ForsetiOrientationController", "getRequestedOrientation() called");
        Fragment r0 = this.a.getHostFragment();
        if (r0 == null) goto L14;
        if (ForsetiHelper.s(r0) == false) goto L14;
        sua.a r1 = (sua.a) ApiUtils.getApi(sua.a.class);
        if (r1.isRunningInForseti(this.a.getActivity()) == true) goto L12;
        return this.a.getActivity().getRequestedOrientation();
    L12:
        return r1.getScreenOrientationHandle(r0).a();
    L14:
        return this.a.getActivity().getRequestedOrientation();
    }

    public h(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.a = r2;
    }

    public final void b(int r4) {
        Fragment r0 = this.a.getHostFragment();
        StringBuilder r1 = new StringBuilder("setRequestedOrientation() called with: orientation = ");
        r1.append(r4);
        r1.append(" isResumed:");
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r0.isResumed());
    L6:
        r1.append(r2);
        tt5.a.h("ForsetiOrientationController", r1.toString());
        if (r0 != null) goto L9;
    L17:
        this.a.getActivity().setRequestedOrientation(r4);
        return;
    L9:
        if (ForsetiHelper.s(r0) == false) goto L17;
        sua.a r3 = (sua.a) ApiUtils.getApi(sua.a.class);
        if (r3.isRunningInForseti(this.a.getActivity()) == true) goto L15;
        this.a.getActivity().setRequestedOrientation(r4);
        return;
    L15:
        r3.getScreenOrientationHandle(r0).b(r4);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
