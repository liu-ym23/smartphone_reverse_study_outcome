package com.bytedance.ee.bear.drive.test.item;

import android.widget.TextView;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends za5.b {
    public final /* synthetic */ c a;

    public f(c r1) {
        this.a = r1;
    }

    @Override // za5.b, za5.a
    public final void a(List<String> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "filePointerList");
        Intrinsics.checkNotNullParameter(r6, "filePointerList");
        TextView r2 = null;
        if (hu5.a.d(r6) == false) goto L10;
        c r8 = this.a;
        r8.g = null;
        TextView r9 = r8.d;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tvSaveFileSelection");
    L8:
        r2.setText(2131914296);
        return;
    L7:
        r2 = r9;
        goto L8
    L10:
        c r0 = this.a;
        r0.f = r7;
        r0.g = (String) ListProtector.get(r6, 0);
        TextView r1 = this.a.d;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("tvSaveFileSelection");
    L14:
        r2.setText(FileUtils.x(r7, (String) ListProtector.get(r6, 0)));
        return;
    L13:
        r2 = r1;
        goto L14
    }
}
