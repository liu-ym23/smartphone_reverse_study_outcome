package u85;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ee.bear.drive.biz.importfile.DriveImportFileActivity;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static void a(Context r100, ImportFileEntity r101) {
        Intent r102 = new Intent(r100, DriveImportFileActivity.class);
        r102.putExtra("extra_drive_file_open_entity", r101);
        if ((r100 instanceof Application) == false) goto L5;
        r102.addFlags(268435456);
    L5:
        r100.startActivity(r102);
    }
}
