package com.bytedance.ee.bear.list.more.more3;

import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ V1SpaceFolderMoreProvider.b f228801a;

    public x(V1SpaceFolderMoreProvider.b r100) {
        this.f228801a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        tt5.a.e("V1SpaceFolderMoreProvider", "folderComplaintFlow err. ", r101, false);
        if (ax4.d.b(r101, 7) == false) goto L9;
        oj5.b r102 = this.f228801a.c();
        if (r102 == null) goto L7;
        r102.f523573r = true;
    L7:
        V1SpaceFolderMoreProvider.b r103 = this.f228801a;
        r103.e(r103.c());
        return;
    }
}
