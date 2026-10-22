package com.ss.android.lark.videosend.checker;

import android.app.Activity;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.videosend.tools.LimitDisk;
import com.ss.android.lark.videosend.tools.i;
import com.ss.android.lark.videosend.tools.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VideoSendChecker.Result f444852a;

    public abstract String a(VideoSendChecker.Result r100);

    public abstract void c(Activity r100, String r101);

    public a(VideoSendChecker.Result r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f444852a = r100;
    }

    public final void b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        VideoSendChecker.Result r101 = this.f444852a;
        if (r101 != VideoSendChecker.Result.LIMIT_DISK) goto L6;
        LimitDisk r102 = j.f445016a;
        UICallbackExecutor.execute(new i(UIHelper.mustacheFormat(R.string.Lark_IM_InsufficientStorageUnableToSendImageOrVideo_Toast1, "type", UIHelper.getString(R.string.Lark_IM_InsufficientStorageUnableToSendVideo_Variable))));
        return;
    L6:
        if (VideoSendChecker.Result.VALID == r101) goto L10;
        c(r100, a(r101));
        return;
    }
}
