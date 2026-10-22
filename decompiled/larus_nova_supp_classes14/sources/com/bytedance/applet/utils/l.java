package com.bytedance.applet.utils;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements IIMCallback<List<? extends Message>> {
    public l() {
    }

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("MessageUtils", "Failed to add messages: " + r4.getExt());
    }

    public final void onSuccess(Object r3) {
        Intrinsics.checkNotNullParameter((List) r3, "result");
        FLogger.a.d("MessageUtils", "Messages added successfully");
    }
}
