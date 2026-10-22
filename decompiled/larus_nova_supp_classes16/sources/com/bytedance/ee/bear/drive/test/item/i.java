package com.bytedance.ee.bear.drive.test.item;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ DriveUploadTestItem a;

    public i(DriveUploadTestItem r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        DriveUploadTestItem r6 = this.a;
        if (r6.l == false) goto L5;
        return;
    L5:
        r6.l = true;
        Button r7 = r6.h;
        CompoundButton r0 = null;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("btnStart");
        r7 = null;
    L8:
        r7.setText(this.a.getActivity().getString(2131914298));
        DriveUploadTestItem r8 = this.a;
        if (TextUtils.isEmpty(r8.i) == false) goto L11;
        Toast.showFailureText(r8.a, 2131914289);
        return;
    L11:
        CompoundButton r1 = r8.c;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("switchView");
        r1 = null;
    L15:
        if (r1.isChecked() == false) goto L22;
        AppCompatEditText r2 = r8.e;
        if (r2 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
        r2 = null;
    L20:
        if (TextUtils.isEmpty(r2.getText()) == false) goto L22;
        Toast.showFailureText(r8.a, 2131914289);
        return;
    L22:
        CompositeDisposable r3 = r8.k;
        CompoundButton r4 = r8.c;
        if (r4 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("switchView");
    L26:
        r3.add(Flowable.just(Boolean.valueOf(r0.isChecked())).subscribeOn(fo5.d.b()).flatMap(new k(r8)).map(new l(r8)).observeOn(fo5.d.d()).subscribe(m.a, new n(r8)));
        return;
    L25:
        r0 = r4;
        goto L26
    }
}
