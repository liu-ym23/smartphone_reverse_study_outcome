package com.larus.video.impl.sdk.eventlog;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.a;
import com.larus.platform.api.k4;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class MediaEventLogReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaEventLogReporter f375790a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static k4 f375791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PlayUploadStatus f375792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Job f375793d;

    public MediaEventLogReporter() {
    }

    static {
        f375790a = new MediaEventLogReporter();
        f375792c = PlayUploadStatus.PAUSE;
    }

    public static void b(k4 r100, PlayUploadStatus r101) {
        Intrinsics.checkNotNullParameter(r101, "play");
        if (Intrinsics.areEqual(f375791b, r100) == true) goto L5;
    L7:
        Job r102 = f375793d;
        if (r102 == null) goto L10;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L10:
        f375791b = r100;
        f375792c = r101;
        f375793d = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MediaEventLogReporter$uploadEventLog$1(null), 3, null);
        return;
    L5:
        if (f375792c != r101) goto L7;
    }

    public static final Object a(MediaEventLogReporter r110, k4 r111, PlayUploadStatus r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof MediaEventLogReporter$doUpload$1) == false) goto L7;
        MediaEventLogReporter$doUpload$1 r100 = (MediaEventLogReporter$doUpload$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MediaEventLogReporter$doUpload$1 r114 = r100;
        Object r102 = r114.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r114.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L51:
        FLogger.f375446a.d("MediaELR", "setEnvContext result: " + ((a) r102));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        JSONObject r105 = new JSONObject();
        String r106 = "";
        if (r111 == null) goto L18;
        String r107 = r111.f365192a;
        if (r107 == null) goto L18;
    L19:
        r105.put("scene", r107);
        if (r111 == null) goto L23;
        String r108 = r111.f365193b;
        if (r108 == null) goto L23;
    L24:
        r105.put("title", r108);
        if (r111 == null) goto L28;
        String r109 = r111.f365194c;
        if (r109 == null) goto L28;
    L29:
        r105.put("artist", r109);
        if (r111 == null) goto L33;
        String r115 = r111.f365195d;
        if (r115 == null) goto L33;
    L34:
        r105.put("audio_id", r115);
        if (r111 == null) goto L40;
        String r116 = r111.f365197f;
        if (r116 == null) goto L40;
        r106 = r116;
    L40:
        r105.put(MusicAppletPage.KEY_MESSAGE_ID, r106);
        JSONObject r117 = new JSONObject();
        r117.put("timestamp", AppHost.f326268a.getAppClock().currentTimeMillis());
        if (r111 == null) goto L47;
        String r118 = r111.f365196e;
        if (r118 == null) goto L47;
        Long r119 = StringsKt.toLongOrNull(r118);
        if (r119 == null) goto L47;
        long r120 = r119.longValue();
    L48:
        r117.put("conversation_id", r120);
        r117.put("event_type", 3);
        r117.put("key", r112.getValue());
        r117.put("value", r105.toString());
        r114.label = 1;
        r102 = HttpExtKt.k(ServiceType.BASIC_SERVICE, BizResponse.class, "/alice/message/event_log", r117, null, null, false, null, null, null, r114, 1008);
        if (r102 != r103) goto L51;
        return r103;
    L47:
        r120 = 0;
    L33:
        r115 = "";
    L28:
        r109 = "";
    L23:
        r108 = "";
    L18:
        r107 = "";
    L7:
        r100 = new MediaEventLogReporter$doUpload$1(r110, r113);
        goto L8
    }
}
