package com.bytedance.ee.docsdk.impl.utils.keyboard.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00010\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/utils/KeyboardResultReceiver;", "Landroid/os/ResultReceiver;", SocialConstants.PARAM_RECEIVER, "handler", "Landroid/os/Handler;", "(Landroid/os/ResultReceiver;Landroid/os/Handler;)V", TemplateNodeType.REF, "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getRef", "()Ljava/lang/ref/WeakReference;", "onReceiveResult", "", "resultCode", "", OnekeyLoginConstants.CU_KEY_RESULT_DATA, "Landroid/os/Bundle;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeyboardResultReceiver extends ResultReceiver {
    private final WeakReference<ResultReceiver> ref;

    public final WeakReference<ResultReceiver> getRef() {
        return this.ref;
    }

    public KeyboardResultReceiver(ResultReceiver r100, Handler r101) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        super(r101);
        this.ref = new WeakReference(r100);
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int r100, Bundle r101) {
        super.onReceiveResult(r100, r101);
        ResultReceiver r102 = this.ref.get();
        if (r102 == null) goto L6;
        r102.send(r100, r101);
        return;
    }
}
