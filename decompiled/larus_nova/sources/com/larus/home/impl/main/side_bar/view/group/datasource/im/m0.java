package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes29.dex */
public final class m0 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f345363a = null;

    static {
        f345363a = new m0();
    }

    public m0() {
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.im.e
    public final String a(Long r100) {
        Object r101 = null;
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        if (r100 != null) goto L16;
        return null;
    L16:
        if (r100.longValue() != 582478) goto L33;
        int r102 = R.string.larus_groupChats_deviceTag_doubao;
    L31:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L20
        Object r104 = Result.m9449constructorimpl(AppHost.f326268a.getApplication().getString(r102));     // Catch: Throwable -> L20
    L22:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L26;
        FLogger.f375446a.e("SideBarDeviceEndTags", "read device tag failed, appId=" + r100, r105);
    L26:
        if (Result.m9455isFailureimpl(r104) == true) goto L30;
        r101 = r104;
    L30:
        return (String) r101;
    L20:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L33:
        return null;
    L11:
        if (r100.longValue() != 1161) goto L13;
        r102 = R.string.larus_groupChats_deviceTag_feishu;
        goto L31
    L6:
        if (r100.longValue() != 1044603) goto L8;
        r102 = R.string.larus_groupChats_deviceTag_doubaoWork;
        goto L31
    }
}
