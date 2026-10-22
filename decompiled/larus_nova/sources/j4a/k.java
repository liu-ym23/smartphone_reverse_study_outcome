package j4a;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;

/* JADX INFO: loaded from: classes32.dex */
public final class k {
    public static Uri a(Context r100, File r101) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        if (r100.getApplicationInfo().targetSdkVersion < 24) goto L8;
        return FileProvider.getUriForFile(r100, r100.getPackageName() + ".choosemedia.fileprovider", r101);
    L8:
        return Uri.fromFile(r101);
    }
}
