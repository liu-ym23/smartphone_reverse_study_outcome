package jdc;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f498781a = 0;

    public static final class a {
        @JvmStatic
        public static void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "click");
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            Statistics.sendEvent("public_picbrowser_click", new JSONObject().put("click", r100).put(PickerReporterConstants.KEY.TARGET, r101));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("ImagePreviewHitPoint", "sendPicBrowserClick " + e.getMessage());
        }

        @JvmStatic
        public static void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "click");
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            Statistics.sendEvent("public_picbrowser_more_click", new JSONObject().put("click", r100).put(PickerReporterConstants.KEY.TARGET, r101));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("ImagePreviewHitPoint", "sendPicBrowserMoreClick " + e.getMessage());
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "click");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Statistics.sendEvent("public_pic_preview_click", new JSONObject().put("click", r100).put(PickerReporterConstants.KEY.TARGET, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("ImagePreviewHitPoint", "sendPicPreviewClick " + e.getMessage());
    }
}
