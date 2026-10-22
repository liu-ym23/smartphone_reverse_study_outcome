package com.ss.android.lark.widget.photopicker.utils;

import android.content.Context;
import android.os.Environment;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f447653a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f447654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f447655b;

        public a(Context r100, String r101) {
            this.f447654a = r100;
            this.f447655b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.makeToast(this.f447654a, this.f447655b).show();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static boolean a(Context r100, PhotoItem r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
        return true;
    L5:
        long r102 = Environment.getDataDirectory().getFreeSpace();
        long r103 = r101.getOriginSize();
        if (r103 != 0) goto L9;
        r103 = ConfigManager.b();
    L9:
        if (r102 >= r103) goto L12;
        Log.i("DiskSpaceChecker", "innerLeft:" + r102 + ", imageSize:" + r103);
        ThreadUtils.runOnUIThread(new a(r100, UIHelper.mustacheFormat(R.string.Lark_IM_InsufficientStorageUnableToSaveImageOrVideo_Toast, "type", UIHelper.getString(R.string.Lark_IM_InsufficientStorageUnableToSendImage_Variable))));
        return false;
    L12:
        return true;
    }
}
