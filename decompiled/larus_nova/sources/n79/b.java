package n79;

import android.content.Context;
import com.larus.drive.biz.impl.activity.DriveMoveListActivity;
import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b implements u79.a {
    public b() {
    }

    @Override // u79.a
    public final void startMoveDriveFileTask(DriveFileItem r100, Context r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "file");
        int r101 = DriveMoveListActivity.f341043h;
        String r102 = r100.f341565b;
        String r103 = r100.f341566c;
        int r104 = r100.f341567d;
        if (r111 == false) goto L5;
        String r105 = "common_refresh_mark_outer";
    L6:
        DriveMoveListActivity.a.a(r110, r102, r103, r104, null, null, r105);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
