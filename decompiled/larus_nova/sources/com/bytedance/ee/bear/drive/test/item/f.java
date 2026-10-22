package com.bytedance.ee.bear.drive.test.item;

import android.widget.TextView;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f extends za5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f224681a;

    public f(c r100) {
        this.f224681a = r100;
    }

    @Override // za5.b, za5.a
    public final void a(List<String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "filePointerList");
        Intrinsics.checkNotNullParameter(r100, "filePointerList");
        TextView r102 = null;
        if (hu5.a.d(r100) == false) goto L10;
        c r103 = this.f224681a;
        r103.f224676g = null;
        TextView r104 = r103.f224673d;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tvSaveFileSelection");
    L8:
        r102.setText(R.string.test_upload_file_selection);
        return;
    L7:
        r102 = r104;
        goto L8
    L10:
        c r105 = this.f224681a;
        r105.f224675f = r101;
        r105.f224676g = (String) ListProtector.get(r100, 0);
        TextView r106 = this.f224681a.f224673d;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("tvSaveFileSelection");
    L14:
        r102.setText(FileUtils.x(r101, (String) ListProtector.get(r100, 0)));
        return;
    L13:
        r102 = r106;
        goto L14
    }
}
