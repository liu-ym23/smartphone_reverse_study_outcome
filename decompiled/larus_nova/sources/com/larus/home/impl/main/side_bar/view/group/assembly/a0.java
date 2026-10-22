package com.larus.home.impl.main.side_bar.view.group.assembly;

import com.larus.im.bean.conversation.ArchiveStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a0 implements IIMCallback<ArchiveStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SideBarTimeGroupArchiveHandler f345163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f345164b;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger.f375446a.e("SideBarTimeGroupArchive", "archive time group failed code=" + r100.getCode());
        SideBarTimeGroupArchiveHandler r101 = this.f345163a;
        ArchiveStatus r102 = ArchiveStatus.FAILED;
        String r103 = this.f345164b;
        r101.getClass();
        t0.e(new z(r101, r102, r103));
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(ArchiveStatus r100) {
        ArchiveStatus r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        FLogger.f375446a.i("SideBarTimeGroupArchive", "archive time group finished status=" + r101);
        SideBarTimeGroupArchiveHandler r102 = this.f345163a;
        String r103 = this.f345164b;
        r102.getClass();
        t0.e(new z(r102, r101, r103));
    }

    public a0(SideBarTimeGroupArchiveHandler r100, String r101) {
        this.f345163a = r100;
        this.f345164b = r101;
    }
}
