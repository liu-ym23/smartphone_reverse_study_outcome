package com.bytedance.ee.bear.drive.biz.preview.more.save2space;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.drive.biz.preview.more.download.im.ImFileSave2SpacePushInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.rn.RnPushProtocol;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements bu5.a {
    public final DriveImFileSaveToSpaceVM a;
    public RnPushProtocol b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.save2space.a$a, reason: collision with other inner class name */
    public static final class C0150a {
    }

    public static final class b implements Runnable {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Application r0 = eu5.b.a;     // Catch: Throwable -> L4
            Toast.showSuccessText(r0, r0.getString(2131888478), 0);     // Catch: Throwable -> L4
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

    public a(DriveImFileSaveToSpaceVM r2) {
        Intrinsics.checkNotNullParameter(r2, "saveToSpaceVM");
        this.a = r2;
    }

    public final void didReceivePush(String r5) {
        ImFileSave2SpacePushInfo r6 = (ImFileSave2SpacePushInfo) JSON.parseObject(r5).getJSONObject("data").getJSONObject("body").getJSONObject("data").toJavaObject(ImFileSave2SpacePushInfo.class);     // Catch: Exception -> L9
        tt5.a.h("DriveSdk", "DriveSdkSaveToSpacePlugin#didReceivePush() pushInfo=" + r6);     // Catch: Exception -> L9
        if (StringUtils.equalsIgnoreCase(r6.getOperation(), "SAVE_TO_DRIVE") == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r6.getFileToken()) == true) goto L15;
        m.a(b.a);     // Catch: Exception -> L9
        tt5.a.h("DriveSdk", "DriveSdkSaveToSpacePlugin#didReceivePush() save to drive push, set token!!!");     // Catch: Exception -> L9
        this.a.getLiveFileToken().postValue(r6.getFileToken());     // Catch: Exception -> L9
        return;
    L15:
        return;
    L9:
        e = move-exception;
        tt5.a.e("DriveSdk", "DriveSdkSaveToSpacePlugin#didReceivePush() error=", e, false);
    }
}
