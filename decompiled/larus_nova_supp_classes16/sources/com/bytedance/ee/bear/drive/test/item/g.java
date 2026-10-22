package com.bytedance.ee.bear.drive.test.item;

import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ DriveUploadTestItem a;

    public g(DriveUploadTestItem r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r6) {
        DriveUploadTestItem r7 = this.a;
        if (r6 == false) goto L5;
        int r0 = 2131914303;
    L6:
        TextView r1 = r7.d;
        EditText r2 = null;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("tvUploadType");
        r1 = null;
    L9:
        r1.setText(r0);
        EditText r3 = r7.e;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
        r3 = null;
    L12:
        r3.setHint(r0);
        if (r6 == false) goto L19;
        EditText r8 = r7.e;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
    L18:
        r2.setText(r7.getActivity().getString(2131914288));
        return;
    L17:
        r2 = r8;
        goto L18
    L19:
        EditText r9 = r7.e;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
    L23:
        r2.setText("");
        return;
    L22:
        r2 = r9;
        goto L23
    L5:
        r0 = 2131914302;
        goto L6
    }
}
