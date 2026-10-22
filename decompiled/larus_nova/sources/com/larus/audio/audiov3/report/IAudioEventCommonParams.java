package com.larus.audio.audiov3.report;

import android.app.Application;
import com.larus.audio.audiov3.util.IAudioDeviceHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, d2 = {"Lcom/larus/audio/audiov3/report/IAudioEventCommonParams;", "", "enable", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Application;", "disable", "currentInfo", "Lcom/larus/audio/audiov3/util/IAudioDeviceHelper$DeviceInfo;", "Companion", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAudioEventCommonParams {
    IAudioDeviceHelper.a a();

    void b(Application r100);

    void disable();
}
