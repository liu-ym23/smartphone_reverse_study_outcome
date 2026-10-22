package com.larus.bmhome.chat.trace.multimodal;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.utils.c;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.m0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f310241a = 0;

    static {
    }

    public a() {
    }

    public static void b(String r100, ProcessFileResultCode r101, m0 r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        MultimodalCommonParamManager.CommonParam r104 = MultimodalCommonParamManager.a(r100);
        String r105 = null;
        if (r104 == null) goto L22;
        if (r102 == null) goto L8;
        String r106 = r102.f489228f;
        if (r106 == null) goto L8;
        r104.setFileMD5(r106);
    L8:
        if (r102 == null) goto L10;
        r104.setFileSize(Integer.valueOf((int) r102.f489225c));
    L10:
        if (r102 == null) goto L14;
        String r107 = r102.f489224b;
        if (r107 == null) goto L14;
        r104.setFileType(StringsKt.substringAfterLast$default(r107, '.', null, 2, null));
    L14:
        if (r102 == null) goto L22;
        String r108 = r102.f489226d;
        if (r108 == null) goto L22;
        String r109 = r104.getFileType();
        if (r109 == null) goto L21;
        r108 = r109;
    L21:
        r104.setFileType(r108);
    L22:
        JSONObject r110 = new JSONObject();
        if (r101 == null) goto L25;
        String r111 = r101.getErrorType();
    L26:
        r110.put("send_file_process_msg", r111);
        if (r101 == null) goto L29;
        String r112 = r101.getValue();
    L30:
        r110.put("send_file_process_msg_detail", r112);
        if (r101 == null) goto L33;
        r105 = r101.getValue();
    L33:
        r110.put("detail_error_msg", r105);
        ResourceCenter.f313541a.getClass();
        boolean r113 = ResourceCenter.d(r100);
        r110.put("resource_center_enabled", r113);
        if (r113 == false) goto L36;
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        r110.put("resource_id", ResourceCenter.f313545e.get(r100));
        r110.put("resource_scene_id", ResourceCenter.g(r100).getTitle());
    L36:
        if (r103 == null) goto L38;
        r110.put("extra", r103);
    L38:
        JSONObject r114 = com.larus.bmhome.chat.trace.appreciable.a.b(MultimodalCommonParamManager.a(r100), r110);
        FLogger.f375446a.d("MultimodalSendFailTrace", "onSendFailed, event=im_send_multimodal_fail, param=" + r114);
        o.f365780a.reportEvent("im_send_multimodal_fail", r114);
        c.a("im_send_multimodal_fail", r114, true);
        return;
    L29:
        r112 = null;
        goto L30
    L25:
        r111 = null;
        goto L26
    }

    public static /* synthetic */ void c(String r100, ProcessFileResultCode r101, m0 r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        b(r100, r101, r102, null);
    }

    public static void d(String r100, String r101, boolean r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r103, "errorMsg");
        MultimodalCommonParamManager.CommonParam r106 = MultimodalCommonParamManager.a(r100);
        JSONObject r107 = new JSONObject();
        r107.put("error_msg", r103);
        r107.put("is_open_by_cache", r102 ? 1 : 0);
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r101);
        r107.put("tosKey", r104);
        boolean r108 = o0.d(r105);
        r107.put("resource_center_enabled", r108);
        if (r108 == false) goto L5;
        r107.put("resource_id", r105);
    L5:
        JSONObject r109 = com.larus.bmhome.chat.trace.appreciable.a.b(r106, r107);
        FLogger.f375446a.d("MultimodalSendFailTrace", "onSendFailed, event=message_file_open_error, param=" + r109);
        o.f365780a.reportEvent("message_file_open_error", r109);
        c.a("message_file_open_error", r109, true);
        MultimodalCommonParamManager.b(r100);
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, boolean r105, Map r106) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        MultimodalCommonParamManager.CommonParam r107 = MultimodalCommonParamManager.a(r100);
        JSONObject r108 = new JSONObject();
        r108.put("error_msg", r102);
        r108.put("is_open_by_cache", 0);
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r101);
        r108.put("tosKey", r103);
        r108.put("src", r104);
        r108.put("is_multi_img", r105 ? 1 : 0);
        if (r106 == null) goto L5;
        r108.put("extra", new JSONObject(r106).toString());
    L5:
        JSONObject r109 = com.larus.bmhome.chat.trace.appreciable.a.b(r107, r108);
        FLogger.f375446a.d("MultimodalSendFailTrace", "onSendFailed, event=message_image_load_error, param=" + r109);
        o.f365780a.reportEvent("message_image_load_error", r109);
        c.a("message_image_load_error", r109, true);
        MultimodalCommonParamManager.b(r100);
    }
}
