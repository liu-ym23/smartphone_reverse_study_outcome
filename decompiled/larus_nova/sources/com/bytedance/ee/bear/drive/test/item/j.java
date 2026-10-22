package com.bytedance.ee.bear.drive.test.item;

import android.widget.TextView;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j extends za5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveUploadTestItem f224685a;

    public j(DriveUploadTestItem r100) {
        this.f224685a = r100;
    }

    @Override // za5.b, za5.a
    public final void a(List<String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "filePointerList");
        Intrinsics.checkNotNullParameter(r100, "filePointerList");
        TextView r102 = this.f224685a.f224656g;
        TextView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvUploadProgress");
        r102 = null;
    L5:
        r102.setText(R.string.test_upload_file_progress_not_start);
        if (hu5.a.d(r100) == false) goto L13;
        DriveUploadTestItem r104 = this.f224685a;
        r104.f224658i = null;
        TextView r105 = r104.f224655f;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tvUploadFileSelection");
    L11:
        r103.setText(R.string.test_upload_file_selection);
        return;
    L10:
        r103 = r105;
        goto L11
    L13:
        DriveUploadTestItem r106 = this.f224685a;
        r106.f224659j = r101;
        r106.f224658i = (String) ListProtector.get(r100, 0);
        TextView r107 = this.f224685a.f224655f;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("tvUploadFileSelection");
    L17:
        r103.setText(FileUtils.x(r101, (String) ListProtector.get(r100, 0)));
        return;
    L16:
        r103 = r107;
        goto L17
    }
}
