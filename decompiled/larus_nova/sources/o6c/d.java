package o6c;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f522233a = 0;

    static {
    }

    public static String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r101 = new StringBuilder();
        String r102 = r100.getFilesDir().getPath();
        Intrinsics.checkNotNull(r102);
        r101.append(r102.substring(0, StringsKt.lastIndexOf$default(r102, HTTP.URL_DEFAULT, 0, false, 6, null)) + "/databases/");
        r101.append("sdk_storage/");
        String r103 = r101.toString();
        FileUtils.t(r103);
        return r103;
    }
}
