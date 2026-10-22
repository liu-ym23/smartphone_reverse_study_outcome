package ri4;

import android.net.Uri;
import android.os.Build;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.tools.utils.FileAdapterUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final boolean b() {
        KProperty[] r100 = FileAdapterUtils.f454852a;
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean a(String r100, Uri r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        if (b() == false) goto L7;
        return BdMediaFileSystem.isUriExists(AppHost.f326268a.getApplication(), r101);
    L7:
        if (r100 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        return false;
    L15:
        if (new PolarisFileWrapper(r100).exists() == false) goto L26;
        return true;
    L26:
        return false;
    L9:
        if (r100.length() == 0) goto L12;
        r103 = false;
    L18:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Throwable r105 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r105 == null) goto L22;
        FLogger.f375446a.e("MediaImportUtils", "isMediaExists failed " + r105.getMessage());
    L22:
        return false;
    }
}
