package com.bytedance.ee.bear.office.h5jsb.handler.audio;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.bytedance.ee.bear.bitable.jsapi.common.AudioRecordHelper;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements gk5.c {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r100, JSONObject r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "callback");
        AudioRecordHelper.f214330a.h();     // Catch: Throwable -> L5
        r102.onSuccess(new JSONObject());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("AudioStopRecordHandler", "stopRecord failed", th, false);
        BitableJSApiErrorCode r103 = BitableJSApiErrorCode.UNKNOWN;
        r102.onFailure(r103.getCode(), r103.getErrMsg());
    }
}
