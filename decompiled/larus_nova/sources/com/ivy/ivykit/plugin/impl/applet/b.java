package com.ivy.ivykit.plugin.impl.applet;

import android.os.FileObserver;
import com.bytedance.ies.bullet.service.base.d1;
import com.obric.sva.sdk.data.ISmModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class b extends FileObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d1 f278366a;

    public b(d1 r100, String r101) {
        this.f278366a = r100;
        super(r101, ISmModel.VERSION_0600);
    }

    @Override // android.os.FileObserver
    public final void onEvent(int r100, String r101) {
        if (r100 != 512) goto L5;
    L7:
        a r102 = c.f278367a;
        d1 r103 = this.f278366a;
        Intrinsics.checkNotNullParameter(r103, "info");
        String r104 = r103.f247870m;
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        if (r104.length() != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L22;
        a r106 = c.f278367a;
        if (r106 == null) goto L19;
        d1 r107 = r106.remove(r104);
    L19:
        c.f278368b.remove(r104);
        return;
    L22:
        return;
    L13:
        r105 = false;
        goto L14
    L5:
        if (r100 == 1024) goto L7;
    }
}
