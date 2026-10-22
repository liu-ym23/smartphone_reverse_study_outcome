package p6b;

import android.app.Application;
import android.text.TextUtils;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintState;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.service.impl.z0;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import com.ss.android.lark.videosend.tools.VideoCompressTools;
import com.ss.android.lark.videosend.tools.VideoTools;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import m6b.p;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f527958a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f527959a = null;

        static {
            f527959a = new d();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f527960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Message f527961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f527962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f527963d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public IGetDataCallback<String> f527964e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f527965f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f527966g;

        public final String toString() {
            return "message=" + this.f527961b + ",mediaCount=" + this.f527962c + ",isNeedUpdateProgress=" + this.f527963d + ",isResend=" + this.f527965f + ",needSendMessageAfterUpload=" + this.f527966g;
        }

        public b() {
            this.f527966g = true;
        }
    }

    public d() {
        this.f527958a = Collections.synchronizedMap(new HashMap());
    }

    public static void c(b r100) {
        String r101 = ImSdkProxy.e().getCurrentUserId();
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L21:
        Log.e("MediaSendDispatcher", "compress is success, but user id is switched, so stop send msg");
        return;
    L5:
        if (r101.equals(r100.f527960a) == false) goto L21;
        pac.a.b();
        Message r102 = r100.f527961b;
        z0.j(r102.getcId());
        Log.i("MediaSendDispatcher", "compress is success, start to send msg: " + r102.getcId());
        if ((r100.f527964e instanceof p) == false) goto L14;
        if (r100.f527963d == false) goto L12;
        MediaContent r103 = new MediaContent((MediaContent) r102.getContent());
        r103.setFileState(FileState.UPLOADING);
        r102.setMessageContent(r103);
    L12:
        ((p) r100.f527964e).onBeginSendMessage(r102);
    L14:
        if (r100.f527966g == true) goto L16;
        return;
    L16:
        Application r104 = LarkContext.getApplication();
        if (r100.f527965f == false) goto L19;
        ImSdkService.f().p2(ImSdkMessageUtils.b(r104, r102), r100.f527964e);
        return;
    L19:
        ImSdkService.f().l9(ImSdkMessageUtils.b(r104, r102), r100.f527964e);
    }

    public final void a(String r100) {
        Long r101 = this.f527958a.get(r100);
        if (r101 == null) goto L12;
        JSONObject r102 = new JSONObject();
        r102.put(VoicePrintState.EXT_KEY_CANCEL_REASON, "user");     // Catch: JSONException -> L7
    L8:
        Statistics.sendEvent("video_send_cancel_event_dev", r102);
        int r103 = com.ss.android.lark.videosend.compress.d.f444936d;
        com.ss.android.lark.videosend.compress.d.b.f444940a.b(r101.longValue());
        return;
    L7:
        Log.i("MediaSendDispatcher", "cancel json exception");
        goto L8
    }

    public final void b(b r100) {
        Log.i("MediaSendDispatcher", "sendMessage: " + r100);
        if (r100.f527962c != 0) goto L6;
        c(r100);
        return;
    L6:
        Message r101 = r100.f527961b;
        String r102 = r101.getcId();
        if ((r101.getContent() instanceof MediaContent) == false) goto L11;
        String r103 = ((MediaContent) r101.getContent()).getCompressPath();
        if (r103 == null) goto L11;
        z0.h(r102, r103);
    L11:
        ImSdkService.f().f1(r102, SendStatus.SENDING);
        String r104 = r6b.a.b(r101);
        String r105 = r6b.a.a(r101);
        if (TextUtils.equals(r104, r105) == true) goto L14;
    L16:
        String r106 = r101.getcId();
        c r107 = new c(this, r100, r100, r106);
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r107, "callback");
        String r108 = r6b.a.b(r101);
        String r109 = r6b.a.a(r101);
        boolean r110 = false;
        if (r108.length() <= 0) goto L19;
        boolean r111 = true;
    L20:
        if (r111 == true) goto L22;
    L28:
        com.ss.android.lark.videosend.compress.a r112 = null;
    L29:
        if (r112 != null) goto L31;
        Log.e("MediaSendDispatcher", "no compress param, cId: " + r106);
        return;
    L31:
        r112.f444930e = Boolean.TRUE;
        this.f527958a.put(r106, Long.valueOf(r112.f444926a));
        int r113 = com.ss.android.lark.videosend.compress.d.f444936d;
        com.ss.android.lark.videosend.compress.d.b.f444940a.c(r112);
        return;
    L22:
        if (r109.length() <= 0) goto L24;
        r110 = true;
    L24:
        if (r110 == false) goto L28;
        r112 = new com.ss.android.lark.videosend.compress.a(UUID.randomUUID().hashCode(), r108, r107);
        r112.f444929d = r109;
        r112.f444931f = r101.getChatId();
        r112.f444932g = r101.getcId();
        if (r101.getType() != Message.Type.MEDIA) goto L29;
        r112.f444935j = ((MediaContent) r101.getContent()).getMediaUploadId();
        ((MediaContent) r101.getContent()).getFirstScreenImageUploadId();
        goto L29
    L19:
        r111 = false;
        goto L20
    L14:
        if (TextUtils.isEmpty(r104) == true) goto L16;
        z0.c(r101.getcId());
        VideoCompressResult r114 = new VideoCompressResult(VideoCompressResult.ResultType.RAW);
        r114.f444893b = VideoCompressTools.c(VideoTools.getVideoInfo(r104), new VideoTools.d(), r104, r105);
        z0.b(r101.getcId(), r114);
        c(r100);
    }
}
