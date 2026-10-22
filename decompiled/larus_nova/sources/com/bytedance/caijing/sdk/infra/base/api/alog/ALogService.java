package com.bytedance.caijing.sdk.infra.base.api.alog;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/alog/ALogService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "asyncFlush", "", "d", "tag", "", "content", "e", "getLogDirPath", RXScreenCaptureService.KEY_INDEX, "isReady", "", "w", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ALogService extends ICJService {
    void asyncFlush();

    void d(String r100, String r101);

    void e(String r100, String r101);

    String getLogDirPath();

    void i(String r100, String r101);

    boolean isReady();

    void w(String r100, String r101);
}
