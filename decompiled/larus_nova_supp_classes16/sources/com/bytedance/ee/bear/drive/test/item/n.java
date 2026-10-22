package com.bytedance.ee.bear.drive.test.item;

import android.widget.Button;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ DriveUploadTestItem a;

    public n(DriveUploadTestItem r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Button r0 = this.a.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnStart");
        r0 = null;
    L5:
        r0.setText(this.a.getActivity().getString(2131914297));
        tt5.a.d("DriveUploadTestItem", "startUpload fail: " + r5);
    }
}
