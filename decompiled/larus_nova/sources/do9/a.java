package do9;

import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingPageOpenSource;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f469504a = 0;

    /* JADX INFO: renamed from: do9.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5694a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f469505a = null;

        static {
            int[] r100 = new int[MmRecordingPageOpenSource.values().length];
            r100[MmRecordingPageOpenSource.RECORDING_START_AUTO_OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[MmRecordingPageOpenSource.CLICK_RECORDING_CARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[MmRecordingPageOpenSource.DOUBAO_APPS_FLOAT_WINDOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[MmRecordingPageOpenSource.DOUBAO_APPS_IN_TASK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[MmRecordingPageOpenSource.OUTER_PUSH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f469505a = r100;
        }
    }

    static {
    }

    public static void a(String r100, MmRecordingPageOpenSource r101, DoubaoStatisticInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "openSource");
        int r103 = C5694a.f469505a[r101.ordinal()];
        boolean r104 = true;
        if (r103 != 1) goto L5;
        String r105 = "recording_start_auto_open";
    L18:
        FLogger.f375446a.i("AudioRecordingTrace", "reportEnterRecordingPage: recordingId=" + r100 + ", openSource=" + r101);
        String r106 = null;
        if (r102 == null) goto L21;
        String r107 = r102.getRawParams();
    L23:
        if (r107 != null) goto L25;
    L28:
        boolean r108 = true;
    L29:
        if (r108 == false) goto L31;
        JSONObject r109 = new JSONObject();
    L32:
        String r110 = r109.optString("is_general_agent");
        Intrinsics.checkNotNull(r110);
        if (r110.length() > 0) goto L36;
        r104 = false;
    L36:
        if (r104 == false) goto L38;
        r106 = r110;
    L38:
        if (r106 != null) goto L40;
        r106 = "0";
    L40:
        IApplog.f287053a.reportEvent(CheckPointType.ENTER_PAGE, r109.put("current_page", "feishu_recording_detail_page").put("feishu_record_id", r100).put("enter_method", r105).put("is_general_agent", r106).put("chat_id", r109.optString("chat_id")));
        return;
    L31:
        r109 = new JSONObject(r107);
        goto L32
    L25:
        if (r107.length() == 0) goto L28;
        r108 = false;
        goto L29
    L21:
        r107 = null;
        goto L23
    L5:
        if (r103 != 2) goto L7;
        r105 = "click_recording_card";
        goto L18
    L7:
        if (r103 != 3) goto L9;
        r105 = "doubao_apps_task_float_window";
        goto L18
    L9:
        if (r103 != 4) goto L11;
        r105 = "doubao_apps_in_task";
        goto L18
    L11:
        if (r103 == 5) goto L13;
        r105 = "";
        goto L18
    L13:
        r105 = "outer_push";
        goto L18
    }
}
