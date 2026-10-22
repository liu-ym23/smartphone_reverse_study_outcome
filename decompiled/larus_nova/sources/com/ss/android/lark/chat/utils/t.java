package com.ss.android.lark.chat.utils;

import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes35.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f416735a = null;

    static {
        f416735a = UIHelper.getString(R.string.Lark_File_ToastSingleFileSizeLimit);
        UIHelper.getString(R.string.Lark_File_ToastTotalFileSizeLimit);
    }

    public static long a() {
        SettingManager r100 = SettingManager.getInstance();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(r100.getInt(FileUploadLimitConfig.class)));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        Object r103 = null;
    L11:
        Integer r104 = (Integer) r103;
        if (r104 == null) goto L19;
        if (r104.intValue() <= 0) goto L19;
        Log.i("FileSendUtils", "getMaxSendFileSize limit:" + r104);
        return (((long) r104.intValue()) * 1024) * 1024;
    L19:
        if (Result.m9455isFailureimpl(r102) == false) goto L21;
        Log.w("FileSendUtils", "getMaxSendFileSize failed", Result.m9452exceptionOrNullimpl(r102));
        return 107374182400L;
    L21:
        Log.w("FileSendUtils", "getMaxSendFileSize invalid limit:" + r104);
        return 107374182400L;
    L10:
        r103 = r102;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
