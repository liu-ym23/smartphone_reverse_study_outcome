package z66;

import android.content.Context;
import android.os.Build;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    static {
    }

    public static List a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 33) goto L8;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L8;
        return CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO});
    L8:
        return CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
    }
}
