package com.bytedance.ee.bear.office.h5jsb.handler.audio;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.bytedance.ee.bear.bitable.jsapi.common.AudioRecordHelper;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements gk5.c {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r3, JSONObject r4, p r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r5, "callback");
        AudioRecordHelper.a.h();     // Catch: Throwable -> L5
        r5.onSuccess(new JSONObject());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("AudioStopRecordHandler", "stopRecord failed", th, false);
        BitableJSApiErrorCode r6 = BitableJSApiErrorCode.UNKNOWN;
        r5.onFailure(r6.getCode(), r6.getErrMsg());
    }
}
