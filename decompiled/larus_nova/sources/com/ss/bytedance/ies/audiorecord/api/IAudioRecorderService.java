package com.ss.bytedance.ies.audiorecord.api;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.dyext.annotation.DouyinImpl;
import kotlin.Metadata;
import ljc.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/ss/bytedance/ies/audiorecord/api/IAudioRecorderService;", "", "", "boolean", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lljc/a;", "getAudioRecorder", "audiorecord-api-0.0.0.2-alpha.93@aar_release"}, k = 1, mv = {1, 4, 0})
@DouyinImpl(plugin = "com.ss.android.ugc.aweme.iesvideoclip")
public interface IAudioRecorderService {
    a getAudioRecorder(boolean r100, Context r101);
}
