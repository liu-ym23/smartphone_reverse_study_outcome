package com.ss.bduploader.logupload;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.bduploader.BDUploadUtil;
import com.ss.bduploader.UploadEventManager;
import com.ss.bduploader.net.BDUploadThreadPool;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class AppLogEngineUploader implements VideoEventEngineUploader {
    private static final String APPLOG_CLASS_NAME = "com.ss.android.common.applog.AppLog";
    private static final String APPLOG_NEW_UTILS_CLASS_NAME = "com.ss.android.common.lib.AppLogNewUtils";
    private static final String APPLOG_WRAPPER = "com.pandora.common.applog.AppLogWrapper";
    private static final String TAG = "ttmn";

    public static class Holder {
        private static final AppLogEngineUploader instance = null;

        private Holder() {
        }

        static {
            instance = new AppLogEngineUploader(null);
        }

        public static /* synthetic */ AppLogEngineUploader access$100() {
            return instance;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static AppLogEngineUploader getInstance() {
        return Holder.access$100();
    }

    private AppLogEngineUploader() {
    }

    public /* synthetic */ AppLogEngineUploader(AnonymousClass1 r100) {
        this();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_bduploader_logupload_AppLogEngineUploader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void logPrint(final JSONObject r100) {
        BDUploadThreadPool.addExecuteTask(new AnonymousClass1(r100));
    }

    @Override // com.ss.bduploader.logupload.VideoEventEngineUploader
    public void onEventV3(String r110, JSONObject r111) {
        if (r111 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L18;
        logPrint(r111);
        if (BDUploadUtil.eventEngineUploader == null) goto L9;
        BDUploadUtil.eventEngineUploader.onEventV3(r110, setJsonValue(r111, "upload_log_type", "2"));
        return;
    L9:
        JSONObject r100 = setJsonValue(r111, "upload_log_type", "1");
        INVOKESTATIC_com_ss_bduploader_logupload_AppLogEngineUploader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(APPLOG_NEW_UTILS_CLASS_NAME).getMethod("onEventV3", new Class[]{String.class, JSONObject.class}).invoke(null, new Object[]{r110, r100});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        UploadEventManager.instance.putEvent(setJsonValue(r111, "upload_log_type", "0"));
        e.printStackTrace();
        e.toString();
        return;
    }

    private JSONObject setJsonValue(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
    L6:
        return r100;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }
}
