package com.ss.android.lark.edit.keyboard.utils;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00010\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/edit/keyboard/utils/KeyboardResultReceiver;", "Landroid/os/ResultReceiver;", SocialConstants.PARAM_RECEIVER, "handler", "Landroid/os/Handler;", "<init>", "(Landroid/os/ResultReceiver;Landroid/os/Handler;)V", TemplateNodeType.REF, "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getRef", "()Ljava/lang/ref/WeakReference;", "onReceiveResult", "", "resultCode", "", OnekeyLoginConstants.CU_KEY_RESULT_DATA, "Landroid/os/Bundle;", "edit-keyboard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardResultReceiver extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<ResultReceiver> f420607a;

    public KeyboardResultReceiver(ResultReceiver r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        super(null);
        this.f420607a = new WeakReference(r100);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r100, Bundle r101) {
        super.onReceiveResult(r100, r101);
        ResultReceiver r102 = this.f420607a.get();
        if (r102 == null) goto L6;
        r102.send(r100, r101);
        return;
    }
}
