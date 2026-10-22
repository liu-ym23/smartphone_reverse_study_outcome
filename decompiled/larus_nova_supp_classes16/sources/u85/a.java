package u85;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ee.bear.drive.biz.importfile.DriveImportFileActivity;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static void a(Context r2, ImportFileEntity r3) {
        Intent r0 = new Intent(r2, DriveImportFileActivity.class);
        r0.putExtra("extra_drive_file_open_entity", r3);
        if ((r2 instanceof Application) == false) goto L5;
        r0.addFlags(268435456);
    L5:
        r2.startActivity(r0);
    }
}
