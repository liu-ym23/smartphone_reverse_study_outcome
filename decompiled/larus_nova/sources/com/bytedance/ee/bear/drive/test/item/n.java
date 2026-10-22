package com.bytedance.ee.bear.drive.test.item;

import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveUploadTestItem f224689a;

    public n(DriveUploadTestItem r100) {
        this.f224689a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        UDButton r102 = this.f224689a.f224657h;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnStart");
        r102 = null;
    L5:
        r102.setText(this.f224689a.getActivity().getString(R.string.test_upload_file_start));
        tt5.a.d("DriveUploadTestItem", "startUpload fail: " + r101);
    }
}
