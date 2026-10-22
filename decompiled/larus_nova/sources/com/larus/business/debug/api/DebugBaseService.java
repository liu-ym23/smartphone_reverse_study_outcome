package com.larus.business.debug.api;

import android.content.Context;
import com.larus.disk.api.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J2\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000bH&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0003H&¨\u0006\u001b"}, d2 = {"Lcom/larus/business/debug/api/DebugBaseService;", "", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "initDefaultEnv", "openDebugActivity", "", "showMessageInfo", "title", "", "content", "messageId", "message", "Lcom/larus/im/bean/message/Message;", "audioDebugService", "Lcom/larus/audio/audiov3/IAudioDebugService;", "audioDiagnosticCacheHandler", "Lcom/larus/disk/api/CacheHandler;", "showVuiDebugPanel", DBDefinition.TASK_ID, "onLibraFlightSwitched", "saveSettingKeyOnLaunch", "settingsAll", "Lorg/json/JSONObject;", "fetchNewSettingIfNecessary", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DebugBaseService {
    void a(Context r100, String r101);

    void b();

    void c(Context r100);

    void d();

    c e();

    void f(Context r100, String r101, String r102, String r103);

    void init(Context r100);
}
