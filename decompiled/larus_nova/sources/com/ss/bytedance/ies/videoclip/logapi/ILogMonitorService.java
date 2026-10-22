package com.ss.bytedance.ies.videoclip.logapi;

import com.ss.android.ugc.aweme.framework.services.dyext.annotation.DouyinImpl;
import kotlin.Metadata;
import tjc.a;
import tjc.b;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\t"}, d2 = {"Lcom/ss/bytedance/ies/videoclip/logapi/ILogMonitorService;", "", "Ltjc/a;", "log", "", "injectLogImpl", "Ltjc/b;", "monitor", "injectMonitorImpl", "logapi-0.0.0.2-alpha.93@aar_release"}, k = 1, mv = {1, 4, 0})
@DouyinImpl(plugin = "com.ss.android.ugc.aweme.iesvideoclip")
public interface ILogMonitorService {
    void injectLogImpl(a r100);

    void injectMonitorImpl(b r100);
}
