package com.bytedance.ee.bear.drive.test.item;

import android.text.TextUtils;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.ee.bear.middleground.drive.export.UploadRequestInfo;
import com.bytedance.ee.util.io.FileUtils;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l<T, R> implements Function {
    public final /* synthetic */ DriveUploadTestItem a;

    public l(DriveUploadTestItem r1) {
        this.a = r1;
    }

    public final Object apply(Object r17) {
        AuthCodeRequester.AuthCodeResult r1 = (AuthCodeRequester.AuthCodeResult) r17;
        Intrinsics.checkNotNullParameter(r1, TipCallBackData.RESULT);
        DrivePriority.UploadPriority.DEFAULT.getPriority();
        UploadRequestInfo.UploadType r11 = UploadRequestInfo.UploadType.DRIVE;
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("size_checker", "true");
        DriveUploadTestItem r2 = this.a;
        if (r2.j == false) goto L5;
        String r6 = r2.i;
        String r5 = "";
    L6:
        CompoundButton r3 = r2.c;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("switchView");
        r3 = null;
    L10:
        if (r3.isChecked() == false) goto L12;
        String r9 = r1.getUploadCode();
        String r8 = "bitable_file";
        String r7 = "";
    L22:
        DriveUploadTestItem r4 = this.a;
        boolean r10 = r4.j;
        String r12 = r4.i;
        Intrinsics.checkNotNull(r12);
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0().s(new UploadRequestInfo(r5, r6, FileUtils.x(r10, r12), r7, r8, r9, DrivePriority.UploadPriority.USER_INTERACTION.getPriority(), r11, null, r13, null, new DriveUploadTestItem.TestUploadCallback(this.a)));
        return Unit.INSTANCE;
    L12:
        AppCompatEditText r14 = this.a.e;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
        r14 = null;
    L16:
        if (TextUtils.isEmpty(String.valueOf(r14.getText())) == false) goto L18;
        r8 = FileInfoPuller.CALLER_EXPLORER;
        r7 = "";
        r9 = r7;
        goto L22
    L18:
        AppCompatEditText r16 = this.a.e;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
        r16 = null;
    L21:
        r7 = String.valueOf(r16.getText());
        r8 = "docx_file";
        r9 = "";
        goto L22
    L5:
        r5 = r2.i;
        r6 = "";
        goto L6
    }
}
