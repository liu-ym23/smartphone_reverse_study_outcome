package com.bytedance.ee.bear.drive.test.item;

import android.widget.TextView;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j extends za5.b {
    public final /* synthetic */ DriveUploadTestItem a;

    public j(DriveUploadTestItem r1) {
        this.a = r1;
    }

    @Override // za5.b, za5.a
    public final void a(List<String> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "filePointerList");
        Intrinsics.checkNotNullParameter(r6, "filePointerList");
        TextView r0 = this.a.g;
        TextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvUploadProgress");
        r0 = null;
    L5:
        r0.setText(2131914293);
        if (hu5.a.d(r6) == false) goto L13;
        DriveUploadTestItem r8 = this.a;
        r8.i = null;
        TextView r9 = r8.f;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tvUploadFileSelection");
    L11:
        r1.setText(2131914296);
        return;
    L10:
        r1 = r9;
        goto L11
    L13:
        DriveUploadTestItem r2 = this.a;
        r2.j = r7;
        r2.i = (String) ListProtector.get(r6, 0);
        TextView r3 = this.a.f;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("tvUploadFileSelection");
    L17:
        r1.setText(FileUtils.x(r7, (String) ListProtector.get(r6, 0)));
        return;
    L16:
        r1 = r3;
        goto L17
    }
}
